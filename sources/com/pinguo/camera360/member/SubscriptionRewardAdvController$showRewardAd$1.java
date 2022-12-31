package com.pinguo.camera360.member;

import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.FragmentActivity;
import com.pinguo.camera360.member.SubscriptionRewardAdvController;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.common.widget.adv.AdRewardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriptionRewardAdvController.kt */
@DebugMetadata(c = "com.pinguo.camera360.member.SubscriptionRewardAdvController$showRewardAd$1", f = "SubscriptionRewardAdvController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class SubscriptionRewardAdvController$showRewardAd$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ SubscriptionRewardAdvController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionRewardAdvController$showRewardAd$1(SubscriptionRewardAdvController subscriptionRewardAdvController, Continuation<? super SubscriptionRewardAdvController$showRewardAd$1> continuation) {
        super(2, continuation);
        this.this$0 = subscriptionRewardAdvController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new SubscriptionRewardAdvController$showRewardAd$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((SubscriptionRewardAdvController$showRewardAd$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ViewGroup viewGroup;
        SubscriptionRewardAdvController.b bVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            this.this$0.o();
            viewGroup = this.this$0.a;
            viewGroup.addView(this.this$0.f6914g, -1, -1);
            AdRewardView adRewardView = this.this$0.f6914g;
            if (adRewardView != null) {
                SubscriptionRewardAdvController subscriptionRewardAdvController = this.this$0;
                adRewardView.k();
                subscriptionRewardAdvController.t();
                adRewardView.setOnCloseClickListener(new SubscriptionRewardAdvController$showRewardAd$1$1$1(subscriptionRewardAdvController));
            }
            OnBackPressedDispatcher onBackPressedDispatcher = this.this$0.b.getOnBackPressedDispatcher();
            FragmentActivity fragmentActivity = this.this$0.b;
            bVar = this.this$0.f6916i;
            onBackPressedDispatcher.addCallback(fragmentActivity, bVar);
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
