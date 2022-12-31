package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
/* compiled from: DestinationWebView.java */
/* loaded from: classes4.dex */
public class f0 extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        Intent intent = new Intent("camera360.webview");
        intent.putExtra("web_view_url", uri.toString());
        return intent;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return "http".equals(uri.getScheme()) || "https".equals(uri.getScheme());
    }
}
