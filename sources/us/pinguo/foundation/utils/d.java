package us.pinguo.foundation.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.Locale;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: AppUtils.java */
/* loaded from: classes4.dex */
public class d {
    public static boolean a(Context context, String str) {
        if (str == null || "".equals(str) || context.getPackageManager().getLaunchIntentForPackage(str) == null) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static Intent b(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.android.vending");
        launchIntentForPackage.setData(Uri.parse("http://play.google.com/store/apps/details?id=" + str));
        launchIntentForPackage.setFlags(PGImageSDK.SDK_STATUS_CREATE);
        launchIntentForPackage.setAction("android.intent.action.VIEW");
        return launchIntentForPackage;
    }

    public static Intent c(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + str));
        intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
        intent.setPackage("com.huawei.appmarket");
        return intent;
    }

    public static Intent d(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + str));
        intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
        return intent;
    }

    public static boolean e() {
        return Locale.CHINA.getLanguage().equalsIgnoreCase(v.a().getLanguage());
    }

    public static boolean f(Context context) {
        return a(context, "com.android.vending");
    }
}
