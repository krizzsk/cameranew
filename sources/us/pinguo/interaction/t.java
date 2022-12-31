package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
/* compiled from: DestinationHome.java */
/* loaded from: classes4.dex */
public class t extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.pinguo.camera360.homepage.HomePageActivity");
        intent.setFlags(603979776);
        return intent;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return "app://camera360/home".equals(uri.toString());
    }
}
