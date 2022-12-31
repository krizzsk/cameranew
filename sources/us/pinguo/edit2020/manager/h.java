package us.pinguo.edit2020.manager;

import java.util.ArrayList;
import java.util.Locale;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.v;
import us.pinguo.repository2020.utils.o;
/* compiled from: TutorialDownloadOption.kt */
/* loaded from: classes4.dex */
public final class h {
    private final ArrayList<String> a;
    private final Locale b;

    public h() {
        ArrayList<String> f2;
        f2 = u.f("vi", "th", "zh", "ja", "ko", "in");
        this.a = f2;
        this.b = v.a();
    }

    private final boolean c() {
        return this.a.contains(this.b.getLanguage());
    }

    public final String a() {
        String j2 = o.j(o.a, "tutorial_option4", "", null, 4, null);
        return j2 == null || j2.length() == 0 ? c() ? "asia_" : "other_" : j2;
    }

    public final boolean b() {
        return s.c(a(), "asia_");
    }
}
