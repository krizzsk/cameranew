package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* compiled from: DestinationAppwall.java */
/* loaded from: classes4.dex */
public class h extends us.pinguo.foundation.interaction.b {
    public static final String a = us.pinguo.foundation.constant.a.a;

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        int i2;
        String stringExtra = intent.getStringExtra("applist_type");
        String stringExtra2 = intent.getStringExtra("applist_unit_id");
        try {
            i2 = Integer.valueOf(stringExtra).intValue();
        } catch (Exception e2) {
            d.f.a.b.d.c(e2);
            i2 = 0;
        }
        us.pinguo.admobvista.b.a(context, i2, stringExtra2);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().startsWith(a);
    }
}
