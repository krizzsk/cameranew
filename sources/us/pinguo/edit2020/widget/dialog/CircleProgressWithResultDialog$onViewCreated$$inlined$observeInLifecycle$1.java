package us.pinguo.edit2020.widget.dialog;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
/* compiled from: StaticStickerExtension.kt */
@DebugMetadata(c = "us.pinguo.edit2020.utils.StaticStickerExtensionKt$observeInLifecycle$1", f = "StaticStickerExtension.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class CircleProgressWithResultDialog$onViewCreated$$inlined$observeInLifecycle$1 extends SuspendLambda implements p<Integer, Continuation<? super u>, Object> {
    int label;

    public CircleProgressWithResultDialog$onViewCreated$$inlined$observeInLifecycle$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CircleProgressWithResultDialog$onViewCreated$$inlined$observeInLifecycle$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(Integer num, Continuation<? super u> continuation) {
        return ((CircleProgressWithResultDialog$onViewCreated$$inlined$observeInLifecycle$1) create(num, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            j.b(obj);
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
