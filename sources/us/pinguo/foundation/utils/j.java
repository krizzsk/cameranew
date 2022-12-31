package us.pinguo.foundation.utils;
/* compiled from: ClickUtil.java */
/* loaded from: classes4.dex */
public class j {
    private static long a;
    private static long b;

    public static boolean a(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - a) < j2) {
            us.pinguo.common.log.a.c("fast double click", new Object[0]);
            return true;
        }
        a = currentTimeMillis;
        return false;
    }

    public static boolean b(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - b) < j2) {
            return true;
        }
        b = currentTimeMillis;
        return false;
    }
}
