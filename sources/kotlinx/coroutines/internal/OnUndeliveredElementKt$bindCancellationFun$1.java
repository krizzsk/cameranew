package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
/* compiled from: OnUndeliveredElement.kt */
/* loaded from: classes3.dex */
final class OnUndeliveredElementKt$bindCancellationFun$1 extends Lambda implements kotlin.jvm.b.l<Throwable, kotlin.u> {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ E $element;
    final /* synthetic */ kotlin.jvm.b.l<E, kotlin.u> $this_bindCancellationFun;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OnUndeliveredElementKt$bindCancellationFun$1(kotlin.jvm.b.l<? super E, kotlin.u> lVar, E e2, CoroutineContext coroutineContext) {
        super(1);
        this.$this_bindCancellationFun = lVar;
        this.$element = e2;
        this.$context = coroutineContext;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        invoke2(th);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        OnUndeliveredElementKt.b(this.$this_bindCancellationFun, this.$element, this.$context);
    }
}
