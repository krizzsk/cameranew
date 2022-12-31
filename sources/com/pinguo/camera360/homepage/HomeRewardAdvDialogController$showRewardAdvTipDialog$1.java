package com.pinguo.camera360.homepage;

import androidx.activity.OnBackPressedDispatcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.pinguo.camera360.homepage.HomeRewardAdvDialogController;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.DelayKt;
import us.pinguo.common.widget.adv.AdRewardView;
import vStudio.Android.Camera360.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeRewardAdvDialogController.kt */
@DebugMetadata(c = "com.pinguo.camera360.homepage.HomeRewardAdvDialogController$showRewardAdvTipDialog$1", f = "HomeRewardAdvDialogController.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class HomeRewardAdvDialogController$showRewardAdvTipDialog$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ String $source;
    final /* synthetic */ boolean $withDelay;
    int label;
    final /* synthetic */ HomeRewardAdvDialogController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeRewardAdvDialogController$showRewardAdvTipDialog$1(boolean z, HomeRewardAdvDialogController homeRewardAdvDialogController, String str, Continuation<? super HomeRewardAdvDialogController$showRewardAdvTipDialog$1> continuation) {
        super(2, continuation);
        this.$withDelay = z;
        this.this$0 = homeRewardAdvDialogController;
        this.$source = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new HomeRewardAdvDialogController$showRewardAdvTipDialog$1(this.$withDelay, this.this$0, this.$source, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((HomeRewardAdvDialogController$showRewardAdvTipDialog$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ConstraintLayout constraintLayout;
        HomeRewardAdvDialogController.c cVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            if (this.$withDelay) {
                this.label = 1;
                if (DelayKt.b(300L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        this.this$0.u();
        constraintLayout = this.this$0.a;
        constraintLayout.addView(this.this$0.f6766g, -1, -1);
        boolean b = us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "first_reward", true, null, 4, null);
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = R.string.str_first_free_vip;
        Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = R.drawable.icon_ad_free_vip;
        if (!b) {
            ref$IntRef.element = R.string.str_free_vip_again;
            ref$IntRef2.element = R.drawable.icon_ad_free_vip_again;
        }
        AdRewardView adRewardView = this.this$0.f6766g;
        if (adRewardView != null) {
            HomeRewardAdvDialogController homeRewardAdvDialogController = this.this$0;
            String str = this.$source;
            AdRewardView.x(adRewardView, false, ref$IntRef2.element, ref$IntRef.element, new HomeRewardAdvDialogController$showRewardAdvTipDialog$1$1$1(adRewardView, homeRewardAdvDialogController, str), new HomeRewardAdvDialogController$showRewardAdvTipDialog$1$1$2(homeRewardAdvDialogController, str), null, 33, null);
            adRewardView.setOnCloseClickListener(new HomeRewardAdvDialogController$showRewardAdvTipDialog$1$1$3(homeRewardAdvDialogController));
        }
        OnBackPressedDispatcher onBackPressedDispatcher = this.this$0.b.getOnBackPressedDispatcher();
        FragmentActivity fragmentActivity = this.this$0.b;
        cVar = this.this$0.f6769j;
        onBackPressedDispatcher.addCallback(fragmentActivity, cVar);
        return kotlin.u.a;
    }
}
