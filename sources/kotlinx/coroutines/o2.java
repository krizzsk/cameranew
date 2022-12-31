package kotlinx.coroutines;
/* compiled from: Executors.kt */
/* loaded from: classes3.dex */
final class o2 implements Runnable {
    private final CoroutineDispatcher a;
    private final p<kotlin.u> b;

    /* JADX WARN: Multi-variable type inference failed */
    public o2(CoroutineDispatcher coroutineDispatcher, p<? super kotlin.u> pVar) {
        this.a = coroutineDispatcher;
        this.b = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.B(this.a, kotlin.u.a);
    }
}
