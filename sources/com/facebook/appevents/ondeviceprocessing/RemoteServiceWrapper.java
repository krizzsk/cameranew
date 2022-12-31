package com.facebook.appevents.ondeviceprocessing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.appevents.AppEvent;
import com.facebook.f;
import com.facebook.internal.i;
import com.facebook.internal.x;
import com.facebook.t.a.a;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class RemoteServiceWrapper {
    private static final String a = "RemoteServiceWrapper";
    private static Boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum EventType {
        MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
        CUSTOM_APP_EVENTS("CUSTOM_APP_EVENTS");
        
        private String eventType;

        EventType(String str) {
            this.eventType = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.eventType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum ServiceResult {
        OPERATION_SUCCESS,
        SERVICE_NOT_AVAILABLE,
        SERVICE_ERROR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements ServiceConnection {
        private final CountDownLatch a = new CountDownLatch(1);
        @Nullable
        private IBinder b;

        a() {
        }

        @Nullable
        public IBinder a() throws InterruptedException {
            this.a.await(5L, TimeUnit.SECONDS);
            return this.b;
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            this.a.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.b = iBinder;
            this.a.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    @Nullable
    private static Intent a(Context context) {
        if (com.facebook.internal.instrument.e.a.c(RemoteServiceWrapper.class)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                Intent intent = new Intent("ReceiverService");
                intent.setPackage("com.facebook.katana");
                if (packageManager.resolveService(intent, 0) != null && i.b(context, "com.facebook.katana")) {
                    return intent;
                }
                Intent intent2 = new Intent("ReceiverService");
                intent2.setPackage("com.facebook.wakizashi");
                if (packageManager.resolveService(intent2, 0) != null) {
                    if (i.b(context, "com.facebook.wakizashi")) {
                        return intent2;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, RemoteServiceWrapper.class);
            return null;
        }
    }

    public static boolean b() {
        if (com.facebook.internal.instrument.e.a.c(RemoteServiceWrapper.class)) {
            return false;
        }
        try {
            if (b == null) {
                b = Boolean.valueOf(a(f.f()) != null);
            }
            return b.booleanValue();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, RemoteServiceWrapper.class);
            return false;
        }
    }

    public static ServiceResult c(String str, List<AppEvent> list) {
        if (com.facebook.internal.instrument.e.a.c(RemoteServiceWrapper.class)) {
            return null;
        }
        try {
            return d(EventType.CUSTOM_APP_EVENTS, str, list);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, RemoteServiceWrapper.class);
            return null;
        }
    }

    private static ServiceResult d(EventType eventType, String str, List<AppEvent> list) {
        if (com.facebook.internal.instrument.e.a.c(RemoteServiceWrapper.class)) {
            return null;
        }
        try {
            ServiceResult serviceResult = ServiceResult.SERVICE_NOT_AVAILABLE;
            com.facebook.appevents.internal.b.b();
            Context f2 = f.f();
            Intent a2 = a(f2);
            if (a2 != null) {
                a aVar = new a();
                if (f2.bindService(a2, aVar, 1)) {
                    try {
                        IBinder a3 = aVar.a();
                        if (a3 != null) {
                            com.facebook.t.a.a x0 = a.AbstractBinderC0124a.x0(a3);
                            Bundle a4 = b.a(eventType, str, list);
                            if (a4 != null) {
                                x0.l(a4);
                                String str2 = a;
                                x.Y(str2, "Successfully sent events to the remote service: " + a4);
                            }
                            serviceResult = ServiceResult.OPERATION_SUCCESS;
                        }
                        f2.unbindService(aVar);
                        x.Y(a, "Unbound from the remote service");
                        return serviceResult;
                    } catch (RemoteException | InterruptedException e2) {
                        ServiceResult serviceResult2 = ServiceResult.SERVICE_ERROR;
                        String str3 = a;
                        x.X(str3, e2);
                        f2.unbindService(aVar);
                        x.Y(str3, "Unbound from the remote service");
                        return serviceResult2;
                    }
                }
                return ServiceResult.SERVICE_ERROR;
            }
            return serviceResult;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, RemoteServiceWrapper.class);
            return null;
        }
    }

    public static ServiceResult e(String str) {
        if (com.facebook.internal.instrument.e.a.c(RemoteServiceWrapper.class)) {
            return null;
        }
        try {
            return d(EventType.MOBILE_APP_INSTALL, str, new LinkedList());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, RemoteServiceWrapper.class);
            return null;
        }
    }
}
