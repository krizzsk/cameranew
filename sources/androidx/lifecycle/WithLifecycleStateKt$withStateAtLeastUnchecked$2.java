package androidx.lifecycle;

import kotlin.jvm.internal.Lambda;
/* compiled from: WithLifecycleState.kt */
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$withStateAtLeastUnchecked$2 extends Lambda implements kotlin.jvm.b.a<R> {
    final /* synthetic */ kotlin.jvm.b.a<R> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WithLifecycleStateKt$withStateAtLeastUnchecked$2(kotlin.jvm.b.a<? extends R> aVar) {
        super(0);
        this.$block = aVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [R, java.lang.Object] */
    @Override // kotlin.jvm.b.a
    public final R invoke() {
        return this.$block.invoke();
    }
}
