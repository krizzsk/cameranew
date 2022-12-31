package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
/* compiled from: DestinationCamera.java */
/* loaded from: classes4.dex */
public class k extends us.pinguo.foundation.interaction.b {
    private Intent i(Context context, String str) {
        Intent a = us.pinguo.foundation.b.a(context);
        if (!TextUtils.isEmpty(str)) {
            a.putExtra("bundle_key_mode", str);
        }
        return a;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        return i(context, uri.getQueryParameter("cameraId"));
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().contains("app://camera360/camera/open") || uri.toString().contains("app://camera360/cameraopen");
    }
}
