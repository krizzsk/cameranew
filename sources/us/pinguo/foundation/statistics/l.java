package us.pinguo.foundation.statistics;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: StatisticsUtils.java */
/* loaded from: classes4.dex */
public class l {
    public static final List<Class<?>> a = new ArrayList();

    public static void a(Context context, Throwable th) {
        us.pinguo.common.log.a.f(th);
    }

    public static void b(String str, F$key f$key) {
        j.a.f.e.onEvent(str);
        g.b(str);
    }

    public static void c(String str, FeedStat feedStat) {
        String str2;
        HashMap hashMap = new HashMap();
        String str3 = "statIsNull";
        if (feedStat == null) {
            str2 = "statIsNull";
        } else {
            str2 = feedStat.item;
            if (str2 == null) {
                str2 = "itemIsNull";
            }
        }
        if (feedStat != null && (str3 = feedStat.item1) == null) {
            str3 = "item1IsNull";
        }
        hashMap.put("item:", str2);
        hashMap.put("item1:", str3);
        j.a.f.e.onEvent(str, str2, str3);
        g.b(str + PGTransHeader.CONNECTOR + str2 + PGTransHeader.CONNECTOR + str3);
    }

    public static void d(Context context, String str) {
        onEvent(context, str, "src=" + PageStack.getInstance().e());
    }

    public static void e(String str) {
        g.e(str);
    }

    public static void f(String str) {
        g.f(str);
    }

    public static void g(Context context, Throwable th) {
        if (a.contains(th.getClass())) {
            return;
        }
        a(context, th);
    }

    public static void h(Context context, String str) {
        onEvent(context, str);
    }

    public static void i(Context context, String str, String str2) {
        onEvent(context, str, str2);
    }

    public static void onEvent(Context context, String str, String str2) {
        j.a.f.e.onEvent(str, str2);
        us.pinguo.common.log.a.g("zhouwei", "统计事件: eventId:" + str + " value：" + str2, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(PGTransHeader.CONNECTOR);
        sb.append(str2);
        g.b(sb.toString());
    }

    public static void onEvent(Context context, String str) {
        j.a.f.e.onEvent(str);
        g.b(str);
    }

    public static void onEvent(Context context, String str, HashMap<String, String> hashMap) {
        j.a.f.e.onEvent(str, hashMap);
        g.b(str + PGTransHeader.CONNECTOR + hashMap.toString());
    }

    public static void onEvent(String str, F$key f$key) {
        j.a.f.e.onEvent("id_" + str);
        g.b(str);
    }

    public static void onEvent(String str, String str2, F$key f$key) {
        j.a.f.e.onEvent("id_" + str, str2);
        g.b(str);
    }
}
