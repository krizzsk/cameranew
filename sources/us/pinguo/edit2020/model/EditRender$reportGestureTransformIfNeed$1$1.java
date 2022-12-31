package us.pinguo.edit2020.model;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* compiled from: EditRender.kt */
@DebugMetadata(c = "us.pinguo.edit2020.model.EditRender$reportGestureTransformIfNeed$1$1", f = "EditRender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class EditRender$reportGestureTransformIfNeed$1$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ boolean $isDuoge;
    final /* synthetic */ p<Boolean, Boolean, u> $it;
    final /* synthetic */ boolean $needed;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EditRender$reportGestureTransformIfNeed$1$1(p<? super Boolean, ? super Boolean, u> pVar, boolean z, boolean z2, Continuation<? super EditRender$reportGestureTransformIfNeed$1$1> continuation) {
        super(2, continuation);
        this.$it = pVar;
        this.$needed = z;
        this.$isDuoge = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditRender$reportGestureTransformIfNeed$1$1(this.$it, this.$needed, this.$isDuoge, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditRender$reportGestureTransformIfNeed$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            j.b(obj);
            this.$it.invoke(Boxing.boxBoolean(this.$needed), Boxing.boxBoolean(this.$isDuoge));
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
