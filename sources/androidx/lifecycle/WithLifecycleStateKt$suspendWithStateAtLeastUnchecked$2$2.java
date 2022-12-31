package androidx.lifecycle;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import kotlinx.coroutines.CoroutineDispatcher;
/* compiled from: WithLifecycleState.kt */
/* loaded from: classes.dex */
final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2 extends Lambda implements l<Throwable, u> {
    final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher;
    final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 $observer;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(CoroutineDispatcher coroutineDispatcher, Lifecycle lifecycle, WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1) {
        super(1);
        this.$lifecycleDispatcher = coroutineDispatcher;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$observer = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Throwable th) {
        invoke2(th);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        CoroutineDispatcher coroutineDispatcher = this.$lifecycleDispatcher;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (coroutineDispatcher.isDispatchNeeded(emptyCoroutineContext)) {
            CoroutineDispatcher coroutineDispatcher2 = this.$lifecycleDispatcher;
            final Lifecycle lifecycle = this.$this_suspendWithStateAtLeastUnchecked;
            final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = this.$observer;
            coroutineDispatcher2.dispatch(emptyCoroutineContext, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.1
                @Override // java.lang.Runnable
                public final void run() {
                    Lifecycle.this.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                }
            });
            return;
        }
        this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this.$observer);
    }
}
