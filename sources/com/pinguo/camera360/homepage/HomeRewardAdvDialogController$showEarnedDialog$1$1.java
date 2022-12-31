package com.pinguo.camera360.homepage;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Lambda;
import us.pinguo.common.widget.adv.AdRewardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeRewardAdvDialogController.kt */
/* loaded from: classes3.dex */
public final class HomeRewardAdvDialogController$showEarnedDialog$1$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ AdRewardView $it;
    final /* synthetic */ HomeRewardAdvDialogController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeRewardAdvDialogController$showEarnedDialog$1$1(HomeRewardAdvDialogController homeRewardAdvDialogController, AdRewardView adRewardView) {
        super(0);
        this.this$0 = homeRewardAdvDialogController;
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
        ConstraintLayout constraintLayout;
        constraintLayout = this.this$0.a;
        constraintLayout.removeView(this.$it);
    }
}
