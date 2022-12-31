package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.o;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class PackageManagerWrapper {
    private final Context a;

    public PackageManagerWrapper(Context context) {
        this.a = context;
    }

    public int a(String str) {
        return this.a.checkCallingOrSelfPermission(str);
    }

    public int b(String str, String str2) {
        return this.a.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo c(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationInfo(str, i2);
    }

    public CharSequence d(String str) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo e(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getPackageInfo(str, i2);
    }

    public boolean f() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.a);
        }
        if (!o.k() || (nameForUid = this.a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.a.getPackageManager().isInstantApp(nameForUid);
    }

    public final PackageInfo g(String str, int i2, int i3) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getPackageInfo(str, 64);
    }

    @TargetApi(19)
    public final boolean h(int i2, String str) {
        if (o.f()) {
            try {
                ((AppOpsManager) this.a.getSystemService("appops")).checkPackage(i2, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i2);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String[] i(int i2) {
        return this.a.getPackageManager().getPackagesForUid(i2);
    }
}
