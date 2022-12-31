package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: DestinationAppCondition.java */
/* loaded from: classes4.dex */
public class e extends us.pinguo.foundation.interaction.b {
    private void i(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            Intent intent = new Intent();
            intent.setClassName(context, "com.pinguo.camera360.lib.ui.WebViewActivity");
            intent.putExtra("web_view_url", str);
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            context.startActivity(intent);
            return;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable unused) {
            Intent intent2 = new Intent();
            intent2.setClassName(context, "com.pinguo.camera360.lib.ui.WebViewActivity");
            intent2.putExtra("web_view_url", str);
            intent2.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            context.startActivity(intent2);
        }
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        boolean z = true;
        boolean z2 = !"0".equals(uri.getQueryParameter("inner"));
        String queryParameter = uri.getQueryParameter("appName");
        String queryParameter2 = uri.getQueryParameter("protocol");
        String queryParameter3 = uri.getQueryParameter("fallback");
        if (TextUtils.isEmpty(queryParameter2)) {
            z = false;
        } else if (!TextUtils.isEmpty(queryParameter)) {
            z = us.pinguo.foundation.utils.d.a(context, queryParameter);
        }
        if (z) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(queryParameter2)));
                return;
            } catch (Throwable unused) {
                i(context, queryParameter3, z2);
                return;
            }
        }
        i(context, queryParameter3, z2);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().startsWith("app://camera360/condition");
    }
}
