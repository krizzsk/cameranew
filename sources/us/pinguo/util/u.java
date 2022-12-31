package us.pinguo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: TimeUtils.kt */
/* loaded from: classes6.dex */
public final class u {
    public static final u a = new u();
    private static final String[] b = {"Asia/Seoul"};

    private u() {
    }

    public static final long a() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 24);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    public static final DateFormat b(String format) {
        kotlin.jvm.internal.s.h(format, "format");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat;
    }

    public static final String d(long j2, String format) {
        kotlin.jvm.internal.s.h(format, "format");
        DateFormat b2 = b(format);
        b2.setTimeZone(TimeZone.getDefault());
        String format2 = b2.format(new Date(j2));
        kotlin.jvm.internal.s.g(format2, "sdf.format(Date(time))");
        return format2;
    }

    public final String[] c() {
        return b;
    }
}
