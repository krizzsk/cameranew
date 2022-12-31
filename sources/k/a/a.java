package k.a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.camera.options.l0;
import com.pinguo.camera360.k.b.a;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.foundation.d;
import us.pinguo.foundation.e;
import us.pinguo.util.q;
import us.pinguo.util.s;
import vStudio.Android.Camera360.Conditions;
/* compiled from: AppGradeModel.java */
/* loaded from: classes6.dex */
public class a {
    public static final int b;
    private Activity a;

    static {
        b = d.f10985d ? 3 : 7;
    }

    public a(Activity activity) {
        this.a = activity;
    }

    public static void b(Context context) {
        if (c(context)) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.android.vending");
            launchIntentForPackage.setData(Uri.parse("https://play.google.com/store/apps/details?id=vStudio.Android.Camera360"));
            launchIntentForPackage.setAction("android.intent.action.VIEW");
            context.startActivity(launchIntentForPackage);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=vStudio.Android.Camera360"));
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=vStudio.Android.Camera360"));
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static boolean c(Context context) {
        return (Conditions.d() || Conditions.e()) && s.h("com.android.vending", context);
    }

    public static void d() {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:support@pingguo.us"));
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        if (intent.resolveActivity(e.b().getPackageManager()) != null) {
            e.b().startActivity(intent);
        }
    }

    public void a() {
        a.f.b(7);
        if (!Conditions.d() && !Conditions.e() && !Conditions.c()) {
            l0.b(this.a);
        } else {
            d();
        }
    }

    public boolean e() {
        int i2;
        try {
            i2 = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            i2 = -1;
        }
        if (CameraBusinessSettingModel.v().n("independent_settings", -1) != i2 && CameraBusinessSettingModel.v().n("key_camera_lunch_count", 0) > b && q.f(this.a)) {
            CameraBusinessSettingModel.v().F("independent_settings", i2);
            return true;
        }
        return false;
    }
}
