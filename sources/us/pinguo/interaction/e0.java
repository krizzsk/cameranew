package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: DestinationWeb.java */
/* loaded from: classes4.dex */
public class e0 extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        String uri2 = uri.toString();
        if (intent.getBooleanExtra("force_inner_browser", false)) {
            Intent intent2 = new Intent();
            intent2.setClassName(context, "com.pinguo.camera360.lib.ui.WebViewActivity");
            intent2.putExtra("web_view_url", uri2);
            intent2.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            context.startActivity(intent2);
            return;
        }
        String queryParameter = Uri.parse(uri2).getQueryParameter("clickUrlInner");
        if (!TextUtils.isEmpty(queryParameter) && Integer.valueOf(queryParameter).intValue() == 1) {
            Intent intent3 = new Intent();
            intent3.setClassName(context, "com.pinguo.camera360.lib.ui.WebViewActivity");
            intent3.putExtra("web_view_url", uri2);
            intent3.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            context.startActivity(intent3);
            return;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (Exception unused) {
            Intent intent4 = new Intent();
            intent4.setClassName(context, "com.pinguo.camera360.lib.ui.WebViewActivity");
            intent4.putExtra("web_view_url", uri2);
            intent4.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            context.startActivity(intent4);
        }
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().startsWith("http");
    }
}
