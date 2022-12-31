package kotlinx.coroutines;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class w extends w1 implements v {

    /* renamed from: e  reason: collision with root package name */
    public final x f8846e;

    public w(x xVar) {
        this.f8846e = xVar;
    }

    @Override // kotlinx.coroutines.e0
    public void Q(Throwable th) {
        this.f8846e.j(R());
    }

    @Override // kotlinx.coroutines.v
    public boolean c(Throwable th) {
        return R().V(th);
    }

    @Override // kotlinx.coroutines.v
    public v1 getParent() {
        return R();
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        Q(th);
        return kotlin.u.a;
    }
}
