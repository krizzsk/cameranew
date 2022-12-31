package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
/* compiled from: DestinationSticker.java */
/* loaded from: classes4.dex */
public class c0 extends us.pinguo.foundation.interaction.b {
    private Intent i(Context context, String str, String str2, String str3) {
        int i2;
        if ("video".equals(str3)) {
            i2 = 2;
        } else {
            i2 = "combine".equals(str3) ? 3 : 1;
        }
        Intent d2 = us.pinguo.foundation.b.d(context, str2, "", "true", i2, 0, 1);
        if (!TextUtils.isEmpty(str)) {
            d2.putExtra("bundle_key_category", str);
        }
        return d2;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        return i(context, uri.getQueryParameter("categoryID"), uri.getQueryParameter("stickerId"), uri.toString().startsWith("app://camera360/stickervideo") ? "video" : uri.getQueryParameter("type"));
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        super.b(uri, context, intent);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().startsWith("app://camera360/stickervideo") || uri.toString().startsWith("app://camera360/sticker");
    }
}
