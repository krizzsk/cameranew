package us.pinguo.foundation.interaction.f;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
/* compiled from: DestinationCameraAction.java */
/* loaded from: classes4.dex */
public class a extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        Intent intent = new Intent();
        if ("app://camera360/camera/action".equals(uri.toString())) {
            intent.setAction("us.pinguo.camera360.EFFECT_IMAGE_CAPTURE");
        }
        return intent;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return "app://camera360/camera/action".equals(uri.toString());
    }
}
