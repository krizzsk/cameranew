package us.pinguo.foundation.interaction.f;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
/* compiled from: DestinationSelfieAction.java */
/* loaded from: classes4.dex */
public class c extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        Intent intent = new Intent();
        intent.setAction("com.camera360.selfie_IMAGE_CAPTURE");
        return intent;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return "app://camera360/selfie/action".equals(uri.toString());
    }
}
