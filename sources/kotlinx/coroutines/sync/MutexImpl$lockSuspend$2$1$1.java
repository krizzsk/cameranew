package kotlinx.coroutines.sync;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* compiled from: Mutex.kt */
/* loaded from: classes3.dex */
final class MutexImpl$lockSuspend$2$1$1 extends Lambda implements l<Throwable, u> {
    final /* synthetic */ Object $owner;
    final /* synthetic */ MutexImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutexImpl$lockSuspend$2$1$1(MutexImpl mutexImpl, Object obj) {
        super(1);
        this.this$0 = mutexImpl;
        this.$owner = obj;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Throwable th) {
        invoke2(th);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.this$0.b(this.$owner);
    }
}
