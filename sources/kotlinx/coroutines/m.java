package kotlinx.coroutines;

import java.util.concurrent.Future;
/* compiled from: Future.kt */
/* loaded from: classes3.dex */
final class m extends n {
    private final Future<?> a;

    public m(Future<?> future) {
        this.a = future;
    }

    @Override // kotlinx.coroutines.o
    public void a(Throwable th) {
        if (th != null) {
            this.a.cancel(false);
        }
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        a(th);
        return kotlin.u.a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.a + ']';
    }
}
