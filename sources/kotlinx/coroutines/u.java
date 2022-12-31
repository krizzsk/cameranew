package kotlinx.coroutines;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class u extends w1 {

    /* renamed from: e  reason: collision with root package name */
    public final q<?> f8843e;

    public u(q<?> qVar) {
        this.f8843e = qVar;
    }

    @Override // kotlinx.coroutines.e0
    public void Q(Throwable th) {
        q<?> qVar = this.f8843e;
        qVar.H(qVar.t(R()));
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        Q(th);
        return kotlin.u.a;
    }
}
