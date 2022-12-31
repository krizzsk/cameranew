package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: DestinationAppGoto.java */
/* loaded from: classes4.dex */
public class f extends us.pinguo.foundation.interaction.b {
    public static String a = "";

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        String queryParameter = uri.getQueryParameter("schema");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(queryParameter)));
            us.pinguo.foundation.statistics.h.a.w0("deep_link_app", a, "link_success");
        } catch (Throwable unused) {
            String queryParameter2 = uri.getQueryParameter("url");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            Intent intent2 = new Intent();
            intent2.setClassName(context, "com.pinguo.camera360.lib.ui.WebViewActivity");
            intent2.putExtra("web_view_url", queryParameter2);
            intent2.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            context.startActivity(intent2);
            us.pinguo.foundation.statistics.h.a.w0("deep_link_h5", a, "link_success");
        }
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().startsWith("app://camera360/goto");
    }
}
