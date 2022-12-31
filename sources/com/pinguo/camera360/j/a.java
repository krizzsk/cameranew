package com.pinguo.camera360.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* compiled from: GalleryLauncher.java */
/* loaded from: classes3.dex */
public class a {
    public static void a(Context context, Uri uri) {
        Intent intent = new Intent();
        intent.putExtra("bundle_key_goto", uri);
        intent.putExtra("photo_page_come_from", 0);
        intent.setClassName(context, "com.pinguo.camera360.gallery.GalleryActivity");
        context.startActivity(intent);
    }

    public static void b(Context context) {
        Intent intent = new Intent();
        intent.putExtra("photo_page_come_from", 1);
        intent.setClassName(context, "com.pinguo.camera360.gallery.GalleryActivity");
        context.startActivity(intent);
    }

    public static void c(Activity activity, int i2) {
        Intent intent = new Intent();
        intent.setClassName(activity, "com.pinguo.camera360.gallery.GalleryActivity");
        intent.setAction("com.pinguo.camera360.gallery.view_photo");
        intent.putExtra("photo_page_come_from", 0);
        intent.putExtra("index-hint", i2);
        activity.startActivity(intent);
        activity.finish();
    }
}
