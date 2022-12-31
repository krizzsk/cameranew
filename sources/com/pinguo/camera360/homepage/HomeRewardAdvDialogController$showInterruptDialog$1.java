package com.pinguo.camera360.homepage;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeRewardAdvDialogController.kt */
/* loaded from: classes3.dex */
public final class HomeRewardAdvDialogController$showInterruptDialog$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ HomeRewardAdvDialogController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeRewardAdvDialogController$showInterruptDialog$1(HomeRewardAdvDialogController homeRewardAdvDialogController) {
        super(0);
        this.this$0 = homeRewardAdvDialogController;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.A();
        us.pinguo.foundation.statistics.h.b.D0(this.this$0.c, "rewarded_ads", "replay");
    }
}
