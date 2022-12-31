package com.adjust.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class GooglePlayServicesClient {

    /* loaded from: classes.dex */
    private static final class GooglePlayServicesConnection implements ServiceConnection {
        long timeoutMilliSec;
        boolean retrieved = false;
        private final LinkedBlockingQueue<IBinder> queue = new LinkedBlockingQueue<>(1);

        public GooglePlayServicesConnection(long j2) {
            this.timeoutMilliSec = j2;
        }

        public IBinder getBinder() throws InterruptedException {
            if (!this.retrieved) {
                this.retrieved = true;
                return this.queue.poll(this.timeoutMilliSec, TimeUnit.MILLISECONDS);
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.queue.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes.dex */
    public static final class GooglePlayServicesInfo {
        private final String gpsAdid;
        private final Boolean trackingEnabled;

        GooglePlayServicesInfo(String str, Boolean bool) {
            this.gpsAdid = str;
            this.trackingEnabled = bool;
        }

        public String getGpsAdid() {
            return this.gpsAdid;
        }

        public Boolean isTrackingEnabled() {
            return this.trackingEnabled;
        }
    }

    /* loaded from: classes.dex */
    private static final class GooglePlayServicesInterface implements IInterface {
        private IBinder binder;

        public GooglePlayServicesInterface(IBinder iBinder) {
            this.binder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.binder;
        }

        public String getGpsAdid() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public Boolean getTrackingEnabled(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                Boolean valueOf = Boolean.valueOf(obtain2.readInt() != 0);
                if (valueOf != null) {
                    return Boolean.valueOf(!valueOf.booleanValue());
                }
                return null;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static GooglePlayServicesInfo getGooglePlayServicesInfo(Context context, long j2) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                GooglePlayServicesConnection googlePlayServicesConnection = new GooglePlayServicesConnection(j2);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (context.bindService(intent, googlePlayServicesConnection, 1)) {
                        try {
                            GooglePlayServicesInterface googlePlayServicesInterface = new GooglePlayServicesInterface(googlePlayServicesConnection.getBinder());
                            return new GooglePlayServicesInfo(googlePlayServicesInterface.getGpsAdid(), googlePlayServicesInterface.getTrackingEnabled(true));
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    throw new IOException("Google Play connection failed");
                } finally {
                    context.unbindService(googlePlayServicesConnection);
                }
            } catch (Exception e3) {
                throw e3;
            }
        }
        throw new IllegalStateException("Google Play Services info can't be accessed from the main thread");
    }
}
