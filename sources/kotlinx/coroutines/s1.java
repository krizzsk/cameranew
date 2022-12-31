package kotlinx.coroutines;
/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes3.dex */
final class s1 extends n {
    private final kotlin.jvm.b.l<Throwable, kotlin.u> a;

    /* JADX WARN: Multi-variable type inference failed */
    public s1(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        this.a = lVar;
    }

    @Override // kotlinx.coroutines.o
    public void a(Throwable th) {
        this.a.invoke(th);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        a(th);
        return kotlin.u.a;
    }

    public String toString() {
        return "InvokeOnCancel[" + p0.a(this.a) + '@' + p0.b(this) + ']';
    }
}
