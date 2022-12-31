package us.pinguo.interaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import vStudio.Android.Camera360.R;
/* compiled from: DestinationCameraVideoAction.java */
/* loaded from: classes4.dex */
public class n extends us.pinguo.foundation.interaction.b {
    public static void i(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "us.pinguo.camera2020.activity.Camera2020Activity");
        intent.setFlags(603979776);
        intent.putExtra("camera_type", 2);
        intent.putExtra("bundle_key_mode", "c205e3582b514d6fb5c21a953e1e901e");
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        i(context);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return "app://camera360/effectvideo".equals(uri.toString());
    }
}
