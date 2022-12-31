package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.installreferrer.commons.InstallReferrerCommons;
import d.c.a.b.a.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InstallReferrerClientImpl extends InstallReferrerClient {
    private static final int PLAY_STORE_MIN_APP_VER = 80837300;
    private static final String SERVICE_ACTION_NAME = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE";
    private static final String SERVICE_NAME = "com.google.android.finsky.externalreferrer.GetInstallReferrerService";
    private static final String SERVICE_PACKAGE_NAME = "com.android.vending";
    private static final String TAG = "InstallReferrerClient";
    private int clientState = 0;
    private final Context mApplicationContext;
    private a service;
    private ServiceConnection serviceConnection;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ClientState {
        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED = 0;
    }

    /* loaded from: classes.dex */
    private final class InstallReferrerServiceConnection implements ServiceConnection {
        private final InstallReferrerStateListener mListener;

        private InstallReferrerServiceConnection(InstallReferrerStateListener installReferrerStateListener) {
            if (installReferrerStateListener != null) {
                this.mListener = installReferrerStateListener;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InstallReferrerCommons.logVerbose(InstallReferrerClientImpl.TAG, "Install Referrer service connected.");
            InstallReferrerClientImpl.this.service = a.AbstractBinderC0292a.x0(iBinder);
            InstallReferrerClientImpl.this.clientState = 2;
            this.mListener.onInstallReferrerSetupFinished(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            InstallReferrerCommons.logWarn(InstallReferrerClientImpl.TAG, "Install Referrer service disconnected.");
            InstallReferrerClientImpl.this.service = null;
            InstallReferrerClientImpl.this.clientState = 0;
            this.mListener.onInstallReferrerServiceDisconnected();
        }
    }

    public InstallReferrerClientImpl(Context context) {
        this.mApplicationContext = context.getApplicationContext();
    }

    private boolean isPlayStoreCompatible() {
        return this.mApplicationContext.getPackageManager().getPackageInfo(SERVICE_PACKAGE_NAME, 128).versionCode >= PLAY_STORE_MIN_APP_VER;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void endConnection() {
        this.clientState = 3;
        if (this.serviceConnection != null) {
            InstallReferrerCommons.logVerbose(TAG, "Unbinding from service.");
            this.mApplicationContext.unbindService(this.serviceConnection);
            this.serviceConnection = null;
        }
        this.service = null;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public ReferrerDetails getInstallReferrer() throws RemoteException {
        if (isReady()) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.mApplicationContext.getPackageName());
            try {
                return new ReferrerDetails(this.service.b(bundle));
            } catch (RemoteException e2) {
                InstallReferrerCommons.logWarn(TAG, "RemoteException getting install referrer information");
                this.clientState = 0;
                throw e2;
            }
        }
        throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public boolean isReady() {
        return (this.clientState != 2 || this.service == null || this.serviceConnection == null) ? false : true;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void startConnection(InstallReferrerStateListener installReferrerStateListener) {
        ServiceInfo serviceInfo;
        if (isReady()) {
            InstallReferrerCommons.logVerbose(TAG, "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i2 = this.clientState;
        if (i2 == 1) {
            InstallReferrerCommons.logWarn(TAG, "Client is already in the process of connecting to the service.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
        } else if (i2 == 3) {
            InstallReferrerCommons.logWarn(TAG, "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
        } else {
            InstallReferrerCommons.logVerbose(TAG, "Starting install referrer service setup.");
            Intent intent = new Intent(SERVICE_ACTION_NAME);
            intent.setComponent(new ComponentName(SERVICE_PACKAGE_NAME, SERVICE_NAME));
            List<ResolveInfo> queryIntentServices = this.mApplicationContext.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (SERVICE_PACKAGE_NAME.equals(str) && str2 != null && isPlayStoreCompatible()) {
                    Intent intent2 = new Intent(intent);
                    InstallReferrerServiceConnection installReferrerServiceConnection = new InstallReferrerServiceConnection(installReferrerStateListener);
                    this.serviceConnection = installReferrerServiceConnection;
                    try {
                        if (this.mApplicationContext.bindService(intent2, installReferrerServiceConnection, 1)) {
                            InstallReferrerCommons.logVerbose(TAG, "Service was bonded successfully.");
                            return;
                        }
                        InstallReferrerCommons.logWarn(TAG, "Connection to service is blocked.");
                        this.clientState = 0;
                        installReferrerStateListener.onInstallReferrerSetupFinished(1);
                        return;
                    } catch (SecurityException unused) {
                        InstallReferrerCommons.logWarn(TAG, "No permission to connect to service.");
                        this.clientState = 0;
                        installReferrerStateListener.onInstallReferrerSetupFinished(4);
                        return;
                    }
                }
                InstallReferrerCommons.logWarn(TAG, "Play Store missing or incompatible. Version 8.3.73 or later required.");
                this.clientState = 0;
                installReferrerStateListener.onInstallReferrerSetupFinished(2);
                return;
            }
            this.clientState = 0;
            InstallReferrerCommons.logVerbose(TAG, "Install Referrer service unavailable on device.");
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
        }
    }
}
