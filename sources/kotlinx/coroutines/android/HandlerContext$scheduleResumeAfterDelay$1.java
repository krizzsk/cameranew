package kotlinx.coroutines.android;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes3.dex */
final class HandlerContext$scheduleResumeAfterDelay$1 extends Lambda implements l<Throwable, u> {
    final /* synthetic */ Runnable $block;
    final /* synthetic */ HandlerContext this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerContext$scheduleResumeAfterDelay$1(HandlerContext handlerContext, Runnable runnable) {
        super(1);
        this.this$0 = handlerContext;
        this.$block = runnable;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Throwable th) {
        invoke2(th);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.this$0.a.removeCallbacks(this.$block);
    }
}
