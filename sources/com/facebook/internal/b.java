package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: AttributionIdentifiers.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    private static final String f3046f = "com.facebook.internal.b";

    /* renamed from: g  reason: collision with root package name */
    private static b f3047g;
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3048d;

    /* renamed from: e  reason: collision with root package name */
    private long f3049e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AttributionIdentifiers.java */
    /* renamed from: com.facebook.internal.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0106b implements IInterface {
        private IBinder a;

        C0106b(IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.a;
        }

        public String x0() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean y0() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AttributionIdentifiers.java */
    /* loaded from: classes.dex */
    public static final class c implements ServiceConnection {
        private AtomicBoolean a;
        private final BlockingQueue<IBinder> b;

        private c() {
            this.a = new AtomicBoolean(false);
            this.b = new LinkedBlockingDeque();
        }

        public IBinder a() throws InterruptedException {
            if (!this.a.compareAndSet(true, true)) {
                return this.b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.b.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static b a(b bVar) {
        bVar.f3049e = System.currentTimeMillis();
        f3047g = bVar;
        return bVar;
    }

    private static b c(Context context) {
        b d2 = d(context);
        if (d2 == null) {
            b e2 = e(context);
            return e2 == null ? new b() : e2;
        }
        return d2;
    }

    private static b d(Context context) {
        Method C;
        Object K;
        try {
            if (!j(context) || (C = x.C("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class)) == null || (K = x.K(null, C, context)) == null) {
                return null;
            }
            Method B = x.B(K.getClass(), "getId", new Class[0]);
            Method B2 = x.B(K.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if (B != null && B2 != null) {
                b bVar = new b();
                bVar.b = (String) x.K(K, B, new Object[0]);
                bVar.f3048d = ((Boolean) x.K(K, B2, new Object[0])).booleanValue();
                return bVar;
            }
            return null;
        } catch (Exception e2) {
            x.X(TapjoyConstants.TJC_ANDROID_ID, e2);
            return null;
        }
    }

    private static b e(Context context) {
        c cVar = new c();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, cVar, 1)) {
            try {
                C0106b c0106b = new C0106b(cVar.a());
                b bVar = new b();
                bVar.b = c0106b.x0();
                bVar.f3048d = c0106b.y0();
                return bVar;
            } catch (Exception e2) {
                x.X(TapjoyConstants.TJC_ANDROID_ID, e2);
            } finally {
                context.unbindService(cVar);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[Catch: all -> 0x00d8, Exception -> 0x00da, TryCatch #4 {Exception -> 0x00da, all -> 0x00d8, blocks: (B:3:0x000b, B:5:0x0015, B:7:0x0019, B:10:0x002a, B:12:0x0045, B:14:0x004d, B:21:0x0067, B:23:0x006d, B:25:0x0071, B:27:0x0075, B:17:0x0057, B:19:0x005f, B:50:0x00d0, B:51:0x00d7), top: B:68:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071 A[Catch: all -> 0x00d8, Exception -> 0x00da, TryCatch #4 {Exception -> 0x00da, all -> 0x00d8, blocks: (B:3:0x000b, B:5:0x0015, B:7:0x0019, B:10:0x002a, B:12:0x0045, B:14:0x004d, B:21:0x0067, B:23:0x006d, B:25:0x0071, B:27:0x0075, B:17:0x0057, B:19:0x005f, B:50:0x00d0, B:51:0x00d7), top: B:68:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075 A[Catch: all -> 0x00d8, Exception -> 0x00da, TRY_LEAVE, TryCatch #4 {Exception -> 0x00da, all -> 0x00d8, blocks: (B:3:0x000b, B:5:0x0015, B:7:0x0019, B:10:0x002a, B:12:0x0045, B:14:0x004d, B:21:0x0067, B:23:0x006d, B:25:0x0071, B:27:0x0075, B:17:0x0057, B:19:0x005f, B:50:0x00d0, B:51:0x00d7), top: B:68:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0100  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.internal.b h(android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.b.h(android.content.Context):com.facebook.internal.b");
    }

    @Nullable
    private static String i(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }

    private static boolean j(Context context) {
        Method C = x.C("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (C == null) {
            return false;
        }
        Object K = x.K(null, C, context);
        return (K instanceof Integer) && ((Integer) K).intValue() == 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean l(Context context) {
        b h2 = h(context);
        return h2 != null && h2.k();
    }

    public String b() {
        if (com.facebook.f.z() && com.facebook.f.e()) {
            return this.b;
        }
        return null;
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.a;
    }

    public boolean k() {
        return this.f3048d;
    }
}
