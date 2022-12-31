package kotlinx.coroutines;
/* compiled from: CancellableContinuation.kt */
/* loaded from: classes3.dex */
final class l2 extends g {
    private final kotlinx.coroutines.internal.p a;

    public l2(kotlinx.coroutines.internal.p pVar) {
        this.a = pVar;
    }

    @Override // kotlinx.coroutines.o
    public void a(Throwable th) {
        this.a.L();
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        a(th);
        return kotlin.u.a;
    }

    public String toString() {
        return "RemoveOnCancel[" + this.a + ']';
    }
}
