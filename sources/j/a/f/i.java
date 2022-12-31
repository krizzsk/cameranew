package j.a.f;

import android.app.Application;
import kotlin.jvm.internal.s;
/* compiled from: StatManager.kt */
/* loaded from: classes6.dex */
public final class i {
    public static final i a = new i();
    private static final h b = new h();

    private i() {
    }

    public final h a() {
        return b;
    }

    public final void b(Application application) {
        s.h(application, "application");
        us.pinguo.bigdata.c.a.e(application);
        g.c(application);
        e.g(b);
    }

    public final void c(boolean z) {
        g.e(z);
    }

    public final void d(boolean z) {
        g.f(z);
        e.a.b(z);
    }
}
