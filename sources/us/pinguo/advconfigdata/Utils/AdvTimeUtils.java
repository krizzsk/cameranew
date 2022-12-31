package us.pinguo.advconfigdata.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes3.dex */
public final class AdvTimeUtils {
    public static final String DATE_FORMAT_DAY = "yyyyMMdd";
    public static final String DATE_FORMAT_HYPHEN = "yyyy-MM-dd";
    public static final String DATE_FORMAT_MIL = "yyyyMMdd-HH:mm:ss.SSS";
    public static final String DATE_FORMAT_MIN = "yyyyMMdd-HH:mm";
    public static final String DATE_FORMAT_SEC = "yyyyMMdd-HH:mm:ss";
    public static final String DATE_FORMAT_SEC_HYPHEN = "yyyy-MM-dd HH:mm:ss";
    public static final long MILLIS_OF_A_DAY = 86400000;

    private AdvTimeUtils() {
    }

    public static int clamp(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public static long clamp(long j2, long j3, long j4) {
        return j2 > j4 ? j4 : j2 < j3 ? j3 : j2;
    }

    public static long currentTimeMillisInLocal() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis + TimeZone.getDefault().getOffset(currentTimeMillis);
    }

    public static long getCurrentTimeZoneUnixTime(long j2) {
        return j2 + TimeZone.getDefault().getRawOffset();
    }

    public static Date getData(String str, String str2, TimeZone timeZone) {
        if (str != null && !"".equals(str.trim())) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.ENGLISH);
            simpleDateFormat.setTimeZone(timeZone);
            try {
                return simpleDateFormat.parse(str);
            } catch (ParseException unused) {
            }
        }
        return null;
    }

    public static DateFormat getDateFormat(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat;
    }

    public static long getDaysFrom1970() {
        return System.currentTimeMillis() / MILLIS_OF_A_DAY;
    }

    public static String getStringDate(long j2, String str) {
        DateFormat dateFormat = getDateFormat(str);
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(new Date(j2));
    }

    public static long getTimeStamp(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.ENGLISH).parse(str).getTime() / 1000;
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static String getStringDate(long j2, DateFormat dateFormat) {
        return dateFormat.format(new Date(j2));
    }

    public static Date getData(String str, String str2) {
        if (str != null && !"".equals(str.trim())) {
            try {
                return new SimpleDateFormat(str2, Locale.ENGLISH).parse(str);
            } catch (ParseException unused) {
            }
        }
        return null;
    }
}
