package us.pinguo.edit2020.viewmodel;

import androidx.activity.result.ActivityResult;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditViewModel.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.EditViewModel$sendActivityResult$1", f = "EditViewModel.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class EditViewModel$sendActivityResult$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ ActivityResult $result;
    int label;
    final /* synthetic */ EditViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditViewModel$sendActivityResult$1(EditViewModel editViewModel, ActivityResult activityResult, Continuation<? super EditViewModel$sendActivityResult$1> continuation) {
        super(2, continuation);
        this.this$0 = editViewModel;
        this.$result = activityResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditViewModel$sendActivityResult$1(this.this$0, this.$result, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditViewModel$sendActivityResult$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        e z;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            z = this.this$0.z();
            ActivityResult activityResult = this.$result;
            this.label = 1;
            if (z.D(activityResult, this) == coroutine_suspended) {
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
