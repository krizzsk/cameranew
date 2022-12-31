package j.a.b.a;

import kotlin.jvm.internal.s;
/* compiled from: HawkeyeLogListener.kt */
/* loaded from: classes3.dex */
public final class a implements us.pinguo.hawkeye.e.a {
    private final boolean a;

    public a() {
        b bVar = b.a;
        this.a = bVar.a();
        bVar.b();
    }

    @Override // us.pinguo.hawkeye.e.a
    public void a(String pageKey, int i2) {
        s.h(pageKey, "pageKey");
        if (this.a) {
            us.pinguo.hawkeye.f.a.a("onFpsCalculated, pageKey = " + pageKey + ", lastFps = " + i2);
        }
    }
}
