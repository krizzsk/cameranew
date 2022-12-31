package com.pinguo.camera360.member;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriptionRewardAdvController.kt */
/* loaded from: classes3.dex */
public final class SubscriptionRewardAdvController$showInterruptDialog$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ SubscriptionRewardAdvController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionRewardAdvController$showInterruptDialog$1(SubscriptionRewardAdvController subscriptionRewardAdvController) {
        super(0);
        this.this$0 = subscriptionRewardAdvController;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.t();
        us.pinguo.foundation.statistics.h.b.D0(this.this$0.c, "rewarded_ads", "replay");
    }
}
