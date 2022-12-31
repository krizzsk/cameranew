package androidx.lifecycle;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* compiled from: Lifecycle.kt */
@DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class LifecycleCoroutineScope$launchWhenStarted$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ p<m0, Continuation<? super u>, Object> $block;
    int label;
    final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LifecycleCoroutineScope$launchWhenStarted$1(LifecycleCoroutineScope lifecycleCoroutineScope, p<? super m0, ? super Continuation<? super u>, ? extends Object> pVar, Continuation<? super LifecycleCoroutineScope$launchWhenStarted$1> continuation) {
        super(2, continuation);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new LifecycleCoroutineScope$launchWhenStarted$1(this.this$0, this.$block, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((LifecycleCoroutineScope$launchWhenStarted$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            Lifecycle lifecycle$lifecycle_runtime_ktx_release = this.this$0.getLifecycle$lifecycle_runtime_ktx_release();
            p<m0, Continuation<? super u>, Object> pVar = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.whenStarted(lifecycle$lifecycle_runtime_ktx_release, pVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        return u.a;
    }
}
