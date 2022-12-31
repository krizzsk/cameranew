package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import us.pinguo.foundation.utils.j0;
import vStudio.Android.Camera360.R;
/* compiled from: DestinationPetal.java */
/* loaded from: classes4.dex */
public class w extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        int i2;
        String str;
        String lastPathSegment = uri.getLastPathSegment();
        if ("openTopic".equals(lastPathSegment)) {
            i2 = 1;
            str = uri.getQueryParameter("topicId");
        } else if ("openPkg".equals(lastPathSegment)) {
            i2 = 2;
            str = uri.getQueryParameter("pkgId");
        } else if ("openScene".equals(lastPathSegment)) {
            i2 = 8;
            str = uri.getQueryParameter("sceneId");
        } else {
            i2 = 4;
            str = "";
        }
        if ("loc".equals(uri.getQueryParameter("type")) && !us.pinguo.camera360.loc.c.f()) {
            j0.d(context.getString(R.string.loc_invalid));
            return us.pinguo.foundation.b.b(context, "", "");
        }
        return us.pinguo.camera360.shop.i.a(context, str, i2);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().contains("app://camera360/petal");
    }
}
