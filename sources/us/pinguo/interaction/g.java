package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import us.pinguo.admobvista.StaticsAdv.InspireStaticeConfig;
import us.pinguo.librouter.application.BaseApplication;
/* compiled from: DestinationAppList.java */
/* loaded from: classes4.dex */
public class g extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        String queryParameter = uri.getQueryParameter("unit_id");
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = intent.getStringExtra("applist_unit_id");
        }
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = String.valueOf(InspireStaticeConfig.HOME_FUNCTION_APPWALL_ID);
        }
        String queryParameter2 = uri.getQueryParameter("type");
        if (TextUtils.isEmpty(queryParameter2)) {
            queryParameter2 = intent.getStringExtra("applist_type");
        }
        int i2 = 0;
        try {
            i2 = Integer.valueOf(queryParameter2).intValue();
        } catch (NumberFormatException e2) {
            d.f.a.b.d.c(e2);
        }
        us.pinguo.admobvista.b.a(context, i2, queryParameter);
        us.pinguo.foundation.statistics.l.onEvent(BaseApplication.d(), "Community_Portal_AppWall_Page");
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().startsWith("app://camera360/applist");
    }
}
