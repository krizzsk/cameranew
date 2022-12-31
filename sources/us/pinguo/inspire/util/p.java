package us.pinguo.inspire.util;

import android.content.Context;
import androidx.room.RoomDatabase;
import java.util.Calendar;
import vStudio.Android.Camera360.R;
/* compiled from: InspireTimeFormatter.java */
/* loaded from: classes9.dex */
public class p {
    public static int a(long j2, long j3) {
        return (int) (((float) (j2 - j3)) / 8.64E7f);
    }

    public static long b(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, RoomDatabase.MAX_BIND_PARAMETER_CNT);
        return calendar.getTimeInMillis();
    }

    public static long c(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static int d(long j2, long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j3);
        int i2 = calendar.get(1) - calendar2.get(1);
        int i3 = (i2 + 1) * 12;
        for (int i4 = (i2 - 1) * 12; i4 <= i3; i4++) {
            calendar2.clear();
            calendar2.setTimeInMillis(j3);
            calendar2.add(2, i4);
            if (calendar.before(calendar2)) {
                return j2 >= j3 ? i4 - 1 : i4;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static String e(Context context, long j2, long j3) {
        long j4 = j3 - j2;
        if (j4 < 60000) {
            return context.getString(R.string.relative_time_justnow);
        }
        if (j4 < 3600000) {
            return String.format(context.getString(R.string.relative_time_minute), Long.valueOf((j4 / 1000) / 60));
        }
        if (g(j2, j3)) {
            return String.format(context.getString(R.string.relative_time_hour), Long.valueOf(((j4 / 1000) / 60) / 60));
        }
        if (h(j2, j3)) {
            return context.getString(R.string.relative_time_yesterday);
        }
        int a = a(j3, j2);
        int d2 = d(j3, j2);
        return d2 <= 0 ? String.format(context.getString(R.string.relative_time_day), Integer.valueOf(a)) : d2 < 12 ? String.format(context.getString(R.string.relative_time_month), Integer.valueOf(d2)) : String.format(context.getString(R.string.relative_time_year), Integer.valueOf(d2 / 12));
    }

    public static String f(Context context, long j2, long j3) {
        return e(context, j2, j3);
    }

    public static boolean g(long j2, long j3) {
        return j2 <= b(j3) && j2 >= c(j3);
    }

    public static boolean h(long j2, long j3) {
        return g(j2, c(j3) - 1);
    }
}
