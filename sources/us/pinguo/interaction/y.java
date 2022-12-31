package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: DestinationPuzzle.java */
/* loaded from: classes4.dex */
public class y extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        Intent a = super.a(uri, bundle, context);
        a.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_MODE_VALUE, 3);
        return a;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().contains("app://camera360/collage");
    }
}
