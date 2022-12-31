package com.pinguo.camera360.member;

import android.view.ViewGroup;
import kotlin.jvm.internal.Lambda;
import us.pinguo.common.widget.adv.AdRewardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriptionRewardAdvController.kt */
/* loaded from: classes3.dex */
public final class SubscriptionRewardAdvController$showEarnedDialog$1$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ AdRewardView $it;
    final /* synthetic */ SubscriptionRewardAdvController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionRewardAdvController$showEarnedDialog$1$1(SubscriptionRewardAdvController subscriptionRewardAdvController, AdRewardView adRewardView) {
        super(0);
        this.this$0 = subscriptionRewardAdvController;
        this.$it = adRewardView;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ViewGroup viewGroup;
        viewGroup = this.this$0.a;
        viewGroup.removeView(this.$it);
        this.this$0.b.finish();
    }
}
