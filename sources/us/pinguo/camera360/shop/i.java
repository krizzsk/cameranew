package us.pinguo.camera360.shop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
/* compiled from: StoreLauncher2.java */
/* loaded from: classes3.dex */
public class i {
    public static Intent a(Context context, String str, int i2) {
        Intent intent = new Intent();
        intent.setClassName(context, "us.pinguo.camera360.shop.StoreActivity2");
        if (i2 == 2) {
            intent.putExtra("key_type", 2);
        } else if (i2 == 1) {
            intent.putExtra("key_type", 1);
        } else if (i2 == 8) {
            intent.putExtra("key_type", 8);
        } else {
            intent.putExtra("key_type", 4);
        }
        intent.putExtra("key_details_id", str);
        return intent;
    }

    public static Intent b(Context context, int i2, String str, String str2, Uri uri, boolean z, int i3) {
        Intent a = a(context, str, 2);
        if (!TextUtils.isEmpty(str2)) {
            a.putExtra("key_filter_id", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            a.putExtra("bundle_key_package", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            a.putExtra("bundle_key_filter", str2);
        }
        a.putExtra("key_is_intent", true);
        a.putExtra("key_cam", i3);
        a.putExtra("camera_type", i2);
        if (uri != null) {
            a.putExtra("output", uri);
        }
        a.putExtra("key_no_watermark", z);
        return a;
    }

    public static Intent c(Context context, String str, String str2, int i2, int i3) {
        Intent a = a(context, str, 2);
        if (!TextUtils.isEmpty(str2)) {
            a.putExtra("key_filter_id", str2);
        }
        a.putExtra("camera_type", i2);
        a.putExtra("key_cam", i3);
        return a;
    }
}
