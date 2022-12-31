package kotlinx.coroutines;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class d1 extends b2 {

    /* renamed from: e  reason: collision with root package name */
    private final b1 f8731e;

    public d1(b1 b1Var) {
        this.f8731e = b1Var;
    }

    @Override // kotlinx.coroutines.e0
    public void Q(Throwable th) {
        this.f8731e.dispose();
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        Q(th);
        return kotlin.u.a;
    }
}
