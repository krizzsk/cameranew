package us.pinguo.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: TimeUtils.java */
/* loaded from: classes4.dex */
public final class i {
    public static DateFormat a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat;
    }

    public static String b(long j2, String str) {
        DateFormat a = a(str);
        a.setTimeZone(TimeZone.getDefault());
        return a.format(new Date(j2));
    }
}
