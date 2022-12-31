package vStudio.Android.Camera360.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.Nullable;
/* compiled from: HomeLauncher.java */
/* loaded from: classes7.dex */
public final class g {
    public static Bitmap a;

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.pinguo.camera360.homepage.HomePageActivity");
        intent.setFlags(603979776);
        intent.putExtra("show-home-only", true);
        intent.putExtra("is_launch", true);
        us.pinguo.common.log.a.k("launch CameraActivity", new Object[0]);
        context.startActivity(intent);
    }

    public static void b(Context context, int i2, int i3, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.pinguo.camera360.homepage.HomePageActivity");
        intent.setFlags(603979776);
        intent.putExtra("union_adv_index", i3);
        if (bundle != null) {
            context.startActivity(intent, bundle);
        } else {
            context.startActivity(intent);
        }
        us.pinguo.common.log.a.k("launch HomePageActivity", new Object[0]);
    }

    public static void c(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.pinguo.camera360.homepage.HomePageActivity");
        intent.setFlags(603979776);
        intent.putExtra("show-home-only", true);
        intent.putExtra("is_launch", false);
        us.pinguo.common.log.a.k("launch CameraActivity", new Object[0]);
        context.startActivity(intent);
    }
}
