package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
@CheckReturnValue
/* loaded from: classes2.dex */
public class d {
    @Nullable
    private static d b;
    private final Context a;

    private d(Context context) {
        this.a = context.getApplicationContext();
    }

    public static d a(Context context) {
        com.google.android.gms.common.internal.q.j(context);
        synchronized (d.class) {
            if (b == null) {
                g.c(context);
                b = new d(context);
            }
        }
        return b;
    }

    @Nullable
    private static h d(PackageInfo packageInfo, h... hVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        k kVar = new k(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < hVarArr.length; i2++) {
            if (hVarArr[i2].equals(kVar)) {
                return hVarArr[i2];
            }
        }
        return null;
    }

    private final o e(String str, int i2) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo g2 = com.google.android.gms.common.wrappers.b.a(this.a).g(str, 64, i2);
            boolean f2 = c.f(this.a);
            if (g2 == null) {
                return o.b("null pkg");
            }
            Signature[] signatureArr = g2.signatures;
            if (signatureArr != null && signatureArr.length == 1) {
                k kVar = new k(g2.signatures[0].toByteArray());
                String str2 = g2.packageName;
                o a = g.a(str2, kVar, f2, false);
                return (!a.a || (applicationInfo = g2.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !g.a(str2, kVar, false, true).a) ? a : o.b("debuggable release cert app rejected");
            }
            return o.b("single cert required");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return o.b(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    public static boolean f(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? d(packageInfo, m.a) : d(packageInfo, m.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (f(packageInfo, false)) {
            return true;
        }
        if (f(packageInfo, true)) {
            if (c.f(this.a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i2) {
        o b2;
        String[] i3 = com.google.android.gms.common.wrappers.b.a(this.a).i(i2);
        if (i3 != null && i3.length != 0) {
            b2 = null;
            int length = i3.length;
            int i4 = 0;
            while (true) {
                if (i4 < length) {
                    b2 = e(i3[i4], i2);
                    if (b2.a) {
                        break;
                    }
                    i4++;
                } else {
                    com.google.android.gms.common.internal.q.j(b2);
                    b2 = b2;
                    break;
                }
            }
        } else {
            b2 = o.b("no pkgs");
        }
        b2.g();
        return b2.a;
    }
}
