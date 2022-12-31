package us.pinguo.foundation.statistics;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.work.WorkRequest;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* compiled from: PageStat.java */
/* loaded from: classes4.dex */
public final class f {
    private static Map<String, Long> a = new HashMap();
    private static Map<String, Long> b = new HashMap();
    private static Handler c = null;

    /* renamed from: d  reason: collision with root package name */
    private static volatile long f11042d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static volatile long f11043e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static SharedPreferences f11044f = null;

    /* renamed from: g  reason: collision with root package name */
    private static SharedPreferences.Editor f11045g = null;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f11046h = false;

    /* compiled from: PageStat.java */
    /* loaded from: classes4.dex */
    private static class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                f.g();
            }
        }
    }

    public static void b(String str, boolean z) {
        if (c == null) {
            c = new b();
        }
        c.sendEmptyMessageDelayed(1, 1000L);
        Long l2 = b.get(str);
        if (l2 != null) {
            f11043e = SystemClock.elapsedRealtime();
            long longValue = f11043e - l2.longValue();
            b.remove(str);
            if (z) {
                h.a.g0(str, String.valueOf(longValue));
            } else {
                j.a.f.e.onEvent("id_page_stay_cost", str, String.valueOf(longValue));
            }
            f11042d += longValue;
            if (us.pinguo.foundation.d.f10987f) {
                g.b(str + "_" + longValue);
            }
        }
    }

    public static boolean c(String str) {
        if ("KeepLiveActivity".equals(str)) {
            j.a.f.e.onEvent("id_1_0_2");
            return false;
        } else if (b.containsKey(str)) {
            return false;
        } else {
            if (c == null) {
                c = new b();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            b.put(str, Long.valueOf(elapsedRealtime));
            c.removeMessages(1);
            if (f11043e == 0 && f11042d == 0) {
                if (f11044f == null) {
                    f11044f = us.pinguo.foundation.e.b().getSharedPreferences("multi_pref", 4);
                }
                f11043e = f11044f.getLong("last_exit_time", 0L);
                if (f11043e == 0) {
                    f11043e = elapsedRealtime;
                }
                f11042d = f11044f.getLong("app_time", 0L);
            }
            if (Math.abs(elapsedRealtime - f11043e) > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                if (f11042d > 0 && f11042d < AdvTimeUtils.MILLIS_OF_A_DAY) {
                    j.a.f.e.onEvent("id_app_cost", String.valueOf(f11042d));
                    if (us.pinguo.foundation.d.f10987f) {
                        g.b("id_app_cost:" + String.valueOf(f11042d));
                    }
                } else {
                    f11042d = 0L;
                    f11043e = 0L;
                    g();
                }
                f11042d = 0L;
                if (f11046h) {
                    j.a.f.e.onEvent("id_1_0_1");
                    g.b("id_1_0_1");
                } else {
                    j.a.f.e.onEvent("id_1_0");
                    g.b("id_1_0");
                }
                f11046h = true;
                return true;
            } else if (f11043e == elapsedRealtime) {
                if (f11046h) {
                    j.a.f.e.onEvent("id_1_0_1");
                    g.b("id_1_0_1");
                } else {
                    j.a.f.e.onEvent("id_1_0");
                    g.b("id_1_0");
                }
                f11046h = true;
                return true;
            } else {
                f11046h = true;
                return false;
            }
        }
    }

    public static void d(String str) {
        e(str, true);
    }

    public static void e(String str, boolean z) {
        Long l2 = a.get(str);
        if (l2 != null) {
            long currentTimeMillis = System.currentTimeMillis() - l2.longValue();
            a.remove(str);
            if (z) {
                h.a.g0(str, String.valueOf(currentTimeMillis));
            } else {
                h.a.g0(str, String.valueOf(currentTimeMillis));
                j.a.f.e.onEvent("id_page_stay_cost", str, String.valueOf(currentTimeMillis));
            }
            if (us.pinguo.foundation.d.f10987f) {
                g.b("session_" + str + "_" + currentTimeMillis);
            }
        }
    }

    public static void f(String str) {
        if (a.containsKey(str)) {
            return;
        }
        a.put(str, Long.valueOf(System.currentTimeMillis()));
        if (us.pinguo.foundation.d.f10987f) {
            g.b("session_" + str + "_0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        if (f11044f == null) {
            f11044f = us.pinguo.foundation.e.b().getSharedPreferences("multi_pref", 4);
        }
        if (f11045g == null) {
            f11045g = f11044f.edit();
        }
        f11045g.putLong("last_exit_time", f11043e);
        f11045g.putLong("app_time", f11042d);
        f11045g.apply();
    }
}
