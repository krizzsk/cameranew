package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.p0;
import com.google.android.gms.common.internal.q0;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
@CheckReturnValue
/* loaded from: classes2.dex */
public final class g {
    private static volatile q0 a;
    private static final Object b = new Object();
    private static Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a(String str, h hVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return d(str, hVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ String b(boolean z, String str, h hVar) throws Exception {
        boolean z2 = true;
        return o.e(str, hVar, z, (z || !d(str, hVar, true, false).a) ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (g.class) {
            if (c != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                c = context.getApplicationContext();
            }
        }
    }

    private static o d(final String str, final h hVar, final boolean z, boolean z2) {
        try {
            if (a == null) {
                com.google.android.gms.common.internal.q.j(c);
                synchronized (b) {
                    if (a == null) {
                        a = p0.x0(DynamiteModule.e(c, DynamiteModule.f3709k, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            com.google.android.gms.common.internal.q.j(c);
            try {
                if (a.v0(new zzj(str, hVar, z, z2), com.google.android.gms.dynamic.d.z0(c.getPackageManager()))) {
                    return o.a();
                }
                return o.d(new Callable(z, str, hVar) { // from class: com.google.android.gms.common.i
                    private final boolean a;
                    private final String b;
                    private final h c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = z;
                        this.b = str;
                        this.c = hVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return g.b(this.a, this.b, this.c);
                    }
                });
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return o.c("module call", e2);
            }
        } catch (DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            String valueOf = String.valueOf(e3.getMessage());
            return o.c(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e3);
        }
    }
}
