package us.pinguo.repository2020.abtest;

import kotlin.jvm.internal.s;
import kotlin.text.t;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.foundation.utils.v;
/* compiled from: RewardAdTypeABTest.kt */
/* loaded from: classes6.dex */
public final class i {
    public static final i a = new i();
    private static final String[] b = {"in", "br", "kh", "mm", "pk", "vn", "la"};

    private i() {
    }

    private final boolean c() {
        String str;
        boolean n;
        String country = v.a().getCountry();
        String[] strArr = b;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str = null;
                break;
            }
            str = strArr[i2];
            i2++;
            n = t.n(str, country, true);
            if (n) {
                break;
            }
        }
        return str != null;
    }

    public final String a() {
        return c() ? "reward" : ABTestManager.a.p("reward_video_test_1", IADStatisticBase.VARCHAR_DEFALUT_VALUE);
    }

    public final boolean b() {
        return s.c(a(), "inter_reward") || s.c(a(), "reward") || c();
    }

    public final boolean d() {
        return s.c(a(), "reward") || c();
    }

    public final boolean e() {
        if (c()) {
            return false;
        }
        return s.c(a(), "inter_reward");
    }
}
