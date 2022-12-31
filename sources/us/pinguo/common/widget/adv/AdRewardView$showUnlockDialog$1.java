package us.pinguo.common.widget.adv;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
import us.pinguo.commonui.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdRewardView.kt */
@DebugMetadata(c = "us.pinguo.common.widget.adv.AdRewardView$showUnlockDialog$1", f = "AdRewardView.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class AdRewardView$showUnlockDialog$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;
    final /* synthetic */ AdRewardView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdRewardView$showUnlockDialog$1(AdRewardView adRewardView, Continuation<? super AdRewardView$showUnlockDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = adRewardView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new AdRewardView$showUnlockDialog$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((AdRewardView$showUnlockDialog$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            this.label = 1;
            if (DelayKt.b(250L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        AdRewardView adRewardView = this.this$0;
        ConstraintLayout unlockDialog = (ConstraintLayout) adRewardView._$_findCachedViewById(R.id.unlockDialog);
        s.g(unlockDialog, "unlockDialog");
        adRewardView.j(unlockDialog);
        return u.a;
    }
}
