package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* loaded from: classes3.dex */
public final class hi {
    final o a;
    public final o b;
    private final SharedPreferences c;

    public hi(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("fiverocks", 0);
        this.c = sharedPreferences;
        this.a = new o(sharedPreferences, "noMoreToday.date");
        this.b = new o(sharedPreferences, "noMoreToday.actionIds");
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_HYPHEN, Locale.getDefault()).format(new Date());
    }

    public final void b() {
        String a = this.a.a();
        if (a == null || a().equals(a)) {
            return;
        }
        this.a.a(null);
        this.b.a(null);
    }
}
