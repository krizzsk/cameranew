package us.pinguo.advsdk.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.network.d;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: InteractionFactory.java */
/* loaded from: classes3.dex */
public class a {
    private boolean b(Context context, String str) {
        try {
            return !context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    private void c(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
        context.startActivity(intent);
    }

    public void a(Context context, AdsItem adsItem) {
        String str = adsItem.landingUrl;
        String str2 = adsItem.clickUrl;
        if (!TextUtils.isEmpty(str) && b(context, str)) {
            new d(context, adsItem, PgAdvConstants$CountMode.NORMAL).execute();
            c(context, str);
            return;
        }
        boolean a = us.pinguo.advsdk.utils.d.a(context, "com.android.vending");
        boolean startsWith = str2.startsWith("https://play.google.com");
        try {
            if (a && startsWith) {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.android.vending");
                launchIntentForPackage.setAction("android.intent.action.VIEW");
                launchIntentForPackage.setData(Uri.parse(str2));
                launchIntentForPackage.setFlags(PGImageSDK.SDK_STATUS_CREATE);
                context.startActivity(launchIntentForPackage);
            } else {
                c(context, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                c(context, str2);
            } catch (Exception unused) {
                e2.printStackTrace();
            }
        }
    }
}
