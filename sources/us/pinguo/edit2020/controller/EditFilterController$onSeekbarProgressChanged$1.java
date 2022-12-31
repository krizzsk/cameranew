package us.pinguo.edit2020.controller;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.viewmodel.module.EditFilterModule;
import us.pinguo.repository2020.entity.FilterEntry;
/* compiled from: EditFilterController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.EditFilterController$onSeekbarProgressChanged$1", f = "EditFilterController.kt", i = {}, l = {TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class EditFilterController$onSeekbarProgressChanged$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ FilterEntry $entry;
    final /* synthetic */ int $progress;
    int label;
    final /* synthetic */ EditFilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFilterController$onSeekbarProgressChanged$1(EditFilterController editFilterController, FilterEntry filterEntry, int i2, Continuation<? super EditFilterController$onSeekbarProgressChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = editFilterController;
        this.$entry = filterEntry;
        this.$progress = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditFilterController$onSeekbarProgressChanged$1(this.this$0, this.$entry, this.$progress, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditFilterController$onSeekbarProgressChanged$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        EditFilterModule editFilterModule;
        EditFilterModule editFilterModule2;
        EditFilterModule editFilterModule3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            editFilterModule = this.this$0.v;
            if (!editFilterModule.P()) {
                editFilterModule2 = this.this$0.v;
                FilterEntry filterEntry = this.$entry;
                this.label = 1;
                obj = editFilterModule2.Z(filterEntry, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            super/*us.pinguo.common.filter.controller.FilterController*/.A(this.$progress);
            return kotlin.u.a;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            editFilterModule3 = this.this$0.v;
            editFilterModule3.v().postValue(Boxing.boxInt(this.$progress));
            return kotlin.u.a;
        }
        super/*us.pinguo.common.filter.controller.FilterController*/.A(this.$progress);
        return kotlin.u.a;
    }
}
