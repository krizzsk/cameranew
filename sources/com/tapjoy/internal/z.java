package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class z {
    @Nullable
    public static String a(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int b(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    @SuppressLint({"NewApi"})
    public static long c(PackageManager packageManager, String str) {
        if (Build.VERSION.SDK_INT >= 9) {
            try {
                long j2 = packageManager.getPackageInfo(str, 0).firstInstallTime;
                if (j2 > 0) {
                    return j2;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return 0L;
    }

    public static String d(PackageManager packageManager, String str) {
        try {
            return jq.b(packageManager.getApplicationInfo(str, 0).sourceDir);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public static Signature[] e(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int a(Context context) {
        return b(context.getPackageManager(), context.getPackageName());
    }
}
