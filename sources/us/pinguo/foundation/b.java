package us.pinguo.foundation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
/* compiled from: Camera2020Launcher.java */
/* loaded from: classes4.dex */
public class b {
    public static boolean a;

    public static Intent a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "us.pinguo.camera2020.activity.Camera2020Activity");
        intent.setFlags(603979776);
        return intent;
    }

    public static Intent b(Context context, String str, String str2) {
        Intent a2 = a(context);
        if (!TextUtils.isEmpty(str)) {
            a2.putExtra("bundle_key_package", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            a2.putExtra("bundle_key_filter", str2);
        }
        a2.putExtra("bundle_key_hide_preview", true);
        return a2;
    }

    public static Intent c(Context context, String str, String str2, String str3, int i2, int i3) {
        Intent b = b(context, str, str2);
        if (!TextUtils.isEmpty(str3)) {
            b.putExtra("bundle_key_is_sticker", str3);
        }
        b.putExtra("camera_type", i2);
        b.putExtra("key_cam", i3);
        return b;
    }

    public static Intent d(Context context, String str, String str2, String str3, int i2, int i3, int i4) {
        Intent c = c(context, str, str2, str3, i2, i3);
        c.putExtra("bundle_key_sticker_goto_type", i4);
        return c;
    }

    public static Intent e(Context context, String str, String str2) {
        Intent b = b(context, str, str2);
        b.putExtra("bundle_key_is_save_publish", true);
        return b;
    }

    private static Intent f(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "us.pinguo.camera2020.activity.IntentCamera2020Activity");
        intent.setFlags(603979776);
        return intent;
    }

    public static Intent g(Context context, int i2, String str, String str2, Uri uri, boolean z, String str3, int i3) {
        Intent f2 = f(context);
        if (!TextUtils.isEmpty(str)) {
            f2.putExtra("bundle_key_package", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            f2.putExtra("bundle_key_is_sticker", str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            f2.putExtra("bundle_key_filter", str2);
        }
        f2.putExtra("camera_type", i2);
        f2.putExtra("bundle_key_hide_preview", true);
        f2.putExtra("key_cam", i3);
        if (uri != null) {
            f2.putExtra("output", uri);
        }
        f2.putExtra("key_no_watermark", z);
        return f2;
    }

    public static Intent h(Context context, int i2, String str, String str2, Uri uri, boolean z, String str3, int i3, int i4) {
        Intent g2 = g(context, i2, str, str2, uri, z, str3, i3);
        g2.putExtra("bundle_key_sticker_goto_type", i4);
        return g2;
    }

    public static Intent i(Context context, Bundle bundle) {
        Intent f2 = f(context);
        f2.putExtras(bundle);
        return f2;
    }

    public static void j(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "us.pinguo.camera2020.activity.Camera2020Activity");
        intent.setFlags(603979776);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
