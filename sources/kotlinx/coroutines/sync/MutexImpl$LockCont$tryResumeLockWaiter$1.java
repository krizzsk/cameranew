package kotlinx.coroutines.sync;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import kotlinx.coroutines.sync.MutexImpl;
/* compiled from: Mutex.kt */
/* loaded from: classes3.dex */
final class MutexImpl$LockCont$tryResumeLockWaiter$1 extends Lambda implements l<Throwable, u> {
    final /* synthetic */ MutexImpl this$0;
    final /* synthetic */ MutexImpl.LockCont this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutexImpl$LockCont$tryResumeLockWaiter$1(MutexImpl mutexImpl, MutexImpl.LockCont lockCont) {
        super(1);
        this.this$0 = mutexImpl;
        this.this$1 = lockCont;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Throwable th) {
        invoke2(th);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.this$0.b(this.this$1.f8828d);
    }
}
