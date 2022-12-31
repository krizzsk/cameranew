package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* compiled from: Collect.kt */
/* loaded from: classes3.dex */
public final class FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 implements d<T> {
    final /* synthetic */ kotlin.jvm.b.q a;
    final /* synthetic */ d b;

    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(kotlin.jvm.b.q qVar, d dVar) {
        this.a = qVar;
        this.b = dVar;
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(T t, Continuation<? super kotlin.u> continuation) {
        Object coroutine_suspended;
        Object invoke = this.a.invoke(this.b, t, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return invoke == coroutine_suspended ? invoke : kotlin.u.a;
    }
}
