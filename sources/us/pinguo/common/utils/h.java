package us.pinguo.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* compiled from: SystemUtils.java */
/* loaded from: classes4.dex */
public class h {
    public static String a(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null ? String.valueOf(packageInfo.versionName) : "";
    }
}
