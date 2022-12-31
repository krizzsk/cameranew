package us.pinguo.repository2020.abtest;

import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
/* compiled from: USPriceABManager.kt */
/* loaded from: classes6.dex */
public final class j {
    public static final j a = new j();
    private static boolean b;
    private static final List<String> c;

    static {
        List<String> j2;
        j2 = u.j("monthly_vip_0499_3dayfree", "monthly_vip_0699_3dayfree");
        c = j2;
    }

    private j() {
    }

    public final List<String> a() {
        return c;
    }

    public final String b() {
        ABTestManager aBTestManager = ABTestManager.a;
        String o = aBTestManager.o("android_vip_sub_pcr");
        Pair<String, String> s = aBTestManager.s("android_vip_sub_pcr");
        if (s != null && !b) {
            b = true;
            us.pinguo.foundation.statistics.h.b.a("android_vip_sub_pcr", s.getFirst(), s.getSecond());
        }
        return s.c(o, "0499_monthly_3day_trial") ? "monthly_vip_0499_3dayfree" : s.c(o, "0699_monthly_3day_trial") ? "monthly_vip_0699_3dayfree" : "yearly_vip_2399_3dayfree";
    }

    public final boolean c() {
        Object obj;
        String b2 = b();
        Iterator<T> it = c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (s.c((String) obj, b2)) {
                break;
            }
        }
        return obj != null;
    }
}
