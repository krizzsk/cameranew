package us.pinguo.foundation.statistics;

import android.os.SystemClock;
import androidx.core.util.Pair;
import java.util.HashMap;
import java.util.Map;
/* compiled from: PgStatisticsBase.java */
/* loaded from: classes4.dex */
public class g {
    private static Pair<String, Long> a;
    private static Map<String, a> b = new HashMap();

    /* compiled from: PgStatisticsBase.java */
    /* loaded from: classes4.dex */
    static class a implements Runnable {
        final long a;
        final String b;

        a(String str, long j2) {
            this.a = j2;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.b.remove(this.b);
            h.a.g0(this.b, String.valueOf(this.a));
        }
    }

    public static void b(String str) {
        if (us.pinguo.foundation.d.f10987f) {
            us.pinguo.common.log.a.m("Umeng", str, new Object[0]);
        }
    }

    public static void c(String str) {
        Pair<String, Long> pair = a;
        a = null;
        if (pair != null && str.equals(pair.first)) {
            a aVar = new a(str, SystemClock.elapsedRealtime() - pair.second.longValue());
            us.pinguo.foundation.utils.f.d(aVar, 2000L);
            b.put(str, aVar);
        }
    }

    public static void d(String str) {
        long j2;
        a aVar = b.get(str);
        if (aVar != null) {
            j2 = aVar.a;
            b.remove(aVar);
            us.pinguo.foundation.utils.f.a(aVar);
        } else {
            j2 = 0;
        }
        a = new Pair<>(str, Long.valueOf(SystemClock.elapsedRealtime() - j2));
    }

    public static void e(String str) {
        if (str == null) {
            return;
        }
        f.e(str, false);
    }

    public static void f(String str) {
        if (str == null) {
            return;
        }
        f.f(str);
        PageStack.getInstance().c(str);
    }
}
