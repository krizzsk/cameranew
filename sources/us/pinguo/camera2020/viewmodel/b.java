package us.pinguo.camera2020.viewmodel;

import android.app.Application;
import kotlin.jvm.internal.s;
import us.pinguo.repository2020.m;
import us.pinguo.repository2020.u;
/* compiled from: ViewFinderSettingsViewModel.kt */
/* loaded from: classes3.dex */
public final class b extends a {
    private final u<Boolean> a;
    private final u<Boolean> b;
    private final u<Boolean> c;

    /* renamed from: d  reason: collision with root package name */
    private final u<Boolean> f9456d;

    /* renamed from: e  reason: collision with root package name */
    private final u<Boolean> f9457e;

    /* renamed from: f  reason: collision with root package name */
    private final u<Integer> f9458f;

    /* renamed from: g  reason: collision with root package name */
    private final u<Integer> f9459g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Application app) {
        super(app);
        s.h(app, "app");
        m mVar = m.a;
        this.a = mVar.l();
        this.b = mVar.j();
        this.c = mVar.D();
        this.f9456d = mVar.p();
        this.f9457e = mVar.A();
        this.f9458f = mVar.v();
        this.f9459g = mVar.n();
    }

    public final u<Boolean> a() {
        return this.b;
    }

    public final u<Integer> b() {
        return this.f9459g;
    }

    public final u<Boolean> c() {
        return this.f9456d;
    }

    public final u<Integer> d() {
        return this.f9458f;
    }

    public final u<Boolean> e() {
        return this.a;
    }

    public final u<Boolean> f() {
        return this.f9457e;
    }

    public final u<Boolean> g() {
        return this.c;
    }
}
