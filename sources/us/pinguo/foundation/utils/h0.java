package us.pinguo.foundation.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.Locale;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: SystemUtils.java */
/* loaded from: classes4.dex */
public class h0 {
    public static void a() {
        for (ActivityManager.AppTask appTask : ((ActivityManager) us.pinguo.util.v.a().getSystemService("activity")).getAppTasks()) {
            appTask.finishAndRemoveTask();
        }
    }

    public static String b() {
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        return language + PGTransHeader.CONNECTOR + country;
    }

    public static String c() {
        return Build.MODEL;
    }

    public static String d(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null ? String.valueOf(packageInfo.versionName) : "";
    }

    public static int e(int i2, int i3) {
        boolean z = true;
        if (i3 != -1) {
            int abs = Math.abs(i2 - i3);
            if (Math.min(abs, 360 - abs) < 65) {
                z = false;
            }
        }
        return z ? (((i2 + 45) / 90) * 90) % BaseBlurEffect.ROTATION_360 : i3;
    }
}
