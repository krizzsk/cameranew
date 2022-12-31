package kotlinx.coroutines.sync;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* compiled from: Semaphore.kt */
/* loaded from: classes3.dex */
final class SemaphoreImpl$onCancellationRelease$1 extends Lambda implements l<Throwable, u> {
    final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SemaphoreImpl$onCancellationRelease$1(e eVar) {
        super(1);
        this.this$0 = eVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Throwable th) {
        invoke2(th);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.this$0.release();
    }
}
