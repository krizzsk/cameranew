package us.pinguo.repository2020.abtest;

import kotlin.jvm.internal.s;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* compiled from: RewardAdBrazilStrategy.kt */
/* loaded from: classes6.dex */
public final class h {
    public static final h a = new h();

    private h() {
    }

    public final String a() {
        return ABTestManager.a.p("reward_video_test_2", IADStatisticBase.VARCHAR_DEFALUT_VALUE);
    }

    public final boolean b() {
        return s.c(a(), "without_home_page");
    }
}
