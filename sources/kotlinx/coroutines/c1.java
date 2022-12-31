package kotlinx.coroutines;
/* compiled from: CancellableContinuation.kt */
/* loaded from: classes3.dex */
final class c1 extends n {
    private final b1 a;

    public c1(b1 b1Var) {
        this.a = b1Var;
    }

    @Override // kotlinx.coroutines.o
    public void a(Throwable th) {
        this.a.dispose();
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        a(th);
        return kotlin.u.a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.a + ']';
    }
}
