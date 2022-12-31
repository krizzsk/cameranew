package us.pinguo.repository2020.abtest;

import java.util.ArrayList;
/* compiled from: PriceAbTestManager.kt */
/* loaded from: classes6.dex */
public final class PriceAbTestManager {
    public static final PriceAbTestManager a = new PriceAbTestManager();
    private static final kotlin.f b;
    private static final kotlin.f c;

    /* renamed from: d  reason: collision with root package name */
    private static final kotlin.f f11815d;

    /* renamed from: e  reason: collision with root package name */
    private static final kotlin.f f11816e;

    /* renamed from: f  reason: collision with root package name */
    private static final kotlin.f f11817f;

    /* renamed from: g  reason: collision with root package name */
    private static final kotlin.f f11818g;

    /* renamed from: h  reason: collision with root package name */
    private static final kotlin.f f11819h;

    static {
        kotlin.f b2;
        kotlin.f b3;
        kotlin.f b4;
        kotlin.f b5;
        kotlin.f b6;
        kotlin.f b7;
        kotlin.f b8;
        b2 = kotlin.h.b(PriceAbTestManager$plan_6_99$2.INSTANCE);
        b = b2;
        b3 = kotlin.h.b(PriceAbTestManager$plan_9_99$2.INSTANCE);
        c = b3;
        b4 = kotlin.h.b(PriceAbTestManager$plan_14_99$2.INSTANCE);
        f11815d = b4;
        b5 = kotlin.h.b(PriceAbTestManager$plan_19_99$2.INSTANCE);
        f11816e = b5;
        b6 = kotlin.h.b(PriceAbTestManager$plan_29_99$2.INSTANCE);
        f11817f = b6;
        b7 = kotlin.h.b(PriceAbTestManager$plan_23_99$2.INSTANCE);
        f11818g = b7;
        b8 = kotlin.h.b(PriceAbTestManager$testProductIdList$2.INSTANCE);
        f11819h = b8;
    }

    private PriceAbTestManager() {
    }

    private final g a() {
        return (g) f11815d.getValue();
    }

    private final g b() {
        return (g) f11816e.getValue();
    }

    private final g c() {
        return (g) f11818g.getValue();
    }

    private final g d() {
        return (g) f11817f.getValue();
    }

    private final g e() {
        return (g) b.getValue();
    }

    private final g f() {
        return (g) c.getValue();
    }

    public final g g() {
        String o = ABTestManager.a.o("android_vip_sub_pcr_test");
        if (o == null) {
            return null;
        }
        switch (o.hashCode()) {
            case -289970728:
                if (o.equals("VIP_yearly_14.99")) {
                    return a();
                }
                break;
            case -289821773:
                if (o.equals("VIP_yearly_19.99")) {
                    return b();
                }
                break;
            case -288898252:
                if (o.equals("VIP_yearly_29.99")) {
                    return d();
                }
                break;
            case 1376262955:
                if (o.equals("VIP_yearly_6.99")) {
                    return e();
                }
                break;
            case 1376352328:
                if (o.equals("VIP_yearly_9.99")) {
                    return f();
                }
                break;
        }
        return c();
    }

    public final ArrayList<String> h() {
        return (ArrayList) f11819h.getValue();
    }
}
