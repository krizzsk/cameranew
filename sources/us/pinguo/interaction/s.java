package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.pinguo.camera360.camera.options.l0;
/* compiled from: DestinationFeedback.java */
/* loaded from: classes4.dex */
public class s extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        return new Intent();
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        l0.b(context);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().startsWith("app://camera360/feedback") || "app://pinguo.android.team.feedback".equals(uri.toString());
    }
}
