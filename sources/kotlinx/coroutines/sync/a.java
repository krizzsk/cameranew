package kotlinx.coroutines.sync;

import kotlin.u;
import kotlinx.coroutines.n;
/* compiled from: Semaphore.kt */
/* loaded from: classes3.dex */
final class a extends n {
    private final f a;
    private final int b;

    public a(f fVar, int i2) {
        this.a = fVar;
        this.b = i2;
    }

    @Override // kotlinx.coroutines.o
    public void a(Throwable th) {
        this.a.q(this.b);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Throwable th) {
        a(th);
        return u.a;
    }

    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.a + ", " + this.b + ']';
    }
}
