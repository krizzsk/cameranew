package us.pinguo.paylibcenter.o;

import com.google.gson.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: Util.java */
/* loaded from: classes5.dex */
public class a {
    private static long a;

    public static String a(Object obj) {
        if (obj != null) {
            try {
                return new e().s(obj);
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    public static <T> T b(String str, Class<T> cls) {
        try {
            return (T) new e().j(str, cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(String str) {
        try {
            Matcher matcher = Pattern.compile("\\bout_trade_no=\"(.*?)\"").matcher(str);
            return matcher.find() ? matcher.group(1) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static synchronized boolean d(long... jArr) {
        synchronized (a.class) {
            long j2 = 600;
            if (jArr != null) {
                if (jArr.length > 0) {
                    j2 = jArr[0];
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a < j2) {
                return true;
            }
            a = currentTimeMillis;
            return false;
        }
    }
}
