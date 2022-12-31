package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.pinguo.camera360.homepage.beautylab.BeautyLabActivity;
/* compiled from: DestinationBeautyLab.java */
/* loaded from: classes4.dex */
public class j extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        Intent intent = new Intent(context, BeautyLabActivity.class);
        intent.setFlags(603979776);
        return intent;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().startsWith("app://camera360/beautylab");
    }
}
