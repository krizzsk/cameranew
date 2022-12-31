package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
/* compiled from: DestinationDownApk.java */
/* loaded from: classes4.dex */
public class r extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        String queryParameter = uri.getQueryParameter("link");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        q.i(context, queryParameter);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return "downApk".equals(uri.getScheme());
    }
}
