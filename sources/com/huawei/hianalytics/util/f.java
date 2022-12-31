package com.huawei.hianalytics.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* loaded from: classes2.dex */
public abstract class f {
    public static long a(String str, long j2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j2))).getTime();
        } catch (ParseException unused) {
            com.huawei.hianalytics.b.b.c("DatesUtils", "onEvent(): ParseException");
            return 0L;
        }
    }

    public static void a(Context context) {
        if (context == null) {
            com.huawei.hianalytics.b.b.c("DatesUtils", "onCleanData null context");
            return;
        }
        SharedPreferences a = k.a(context, "stat_v2");
        if (a != null) {
            SharedPreferences.Editor edit = a.edit();
            edit.remove("events");
            edit.commit();
        }
        l.b(context, "cached_v2");
    }
}
