package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Semaphore.kt */
/* loaded from: classes3.dex */
public final class f extends z<f> {

    /* renamed from: e  reason: collision with root package name */
    /* synthetic */ AtomicReferenceArray f8840e;

    public f(long j2, f fVar, int i2) {
        super(j2, fVar, i2);
        int i3;
        i3 = SemaphoreKt.f8835f;
        this.f8840e = new AtomicReferenceArray(i3);
    }

    @Override // kotlinx.coroutines.internal.z
    public int n() {
        int i2;
        i2 = SemaphoreKt.f8835f;
        return i2;
    }

    public final void q(int i2) {
        c0 c0Var;
        c0Var = SemaphoreKt.f8834e;
        this.f8840e.set(i2, c0Var);
        o();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + m() + ", hashCode=" + hashCode() + ']';
    }
}
