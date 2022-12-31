package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import us.pinguo.user.User;
import us.pinguo.user.v0;
/* compiled from: DestinationCloudAlbumAction.java */
/* loaded from: classes4.dex */
public class p extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        if (User.d().n()) {
            Intent intent2 = new Intent();
            intent2.setClassName(context, "com.pinguo.album.activities.PGAlbumActivity");
            context.startActivity(intent2);
            return;
        }
        v0.f(context);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return "app://camera360/cloud".equals(uri);
    }
}
