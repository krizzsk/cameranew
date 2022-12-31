package us.pinguo.repository2020.abtest;

import kotlin.jvm.internal.s;
import us.pinguo.repository2020.utils.o;
/* compiled from: ManualSkinAbTestManager.kt */
/* loaded from: classes6.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    private final boolean c() {
        return o.b(o.a, "manual_guide_has_show", false, null, 4, null);
    }

    public final int a() {
        return o.f(o.a, "skin_last_tab", 0, null, 4, null);
    }

    public final String b() {
        return ABTestManager.a.p("android_manual_skin_manual_tab", "skin_control");
    }

    public final void d() {
        o.n(o.a, "manual_guide_has_show", true, null, 4, null);
    }

    public final void e(int i2) {
        if (s.c(b(), "skin_keep_tab")) {
            o.r(o.a, "skin_last_tab", i2, null, 4, null);
        }
    }

    public final boolean f() {
        return (s.c(b(), "skin_strong_attention") || s.c(b(), "skin_keep_tab")) && !c();
    }
}
