package cn.sharesdk.framework.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import com.mob.MobSDK;
/* compiled from: AppUtils.java */
/* loaded from: classes.dex */
public class a {
    public static boolean a(String str) {
        PackageInfo packageInfo;
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            packageInfo = MobSDK.getContext().getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
