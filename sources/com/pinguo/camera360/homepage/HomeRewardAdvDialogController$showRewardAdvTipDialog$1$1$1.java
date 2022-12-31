package com.pinguo.camera360.homepage;

import kotlin.jvm.internal.Lambda;
import us.pinguo.common.widget.adv.AdRewardView;
/* compiled from: HomeRewardAdvDialogController.kt */
/* loaded from: classes3.dex */
final class HomeRewardAdvDialogController$showRewardAdvTipDialog$1$1$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ AdRewardView $it;
    final /* synthetic */ String $source;
    final /* synthetic */ HomeRewardAdvDialogController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeRewardAdvDialogController$showRewardAdvTipDialog$1$1$1(AdRewardView adRewardView, HomeRewardAdvDialogController homeRewardAdvDialogController, String str) {
        super(0);
        this.$it = adRewardView;
        this.this$0 = homeRewardAdvDialogController;
        this.$source = str;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$it.k();
        this.this$0.A();
        us.pinguo.foundation.statistics.h.b.A0(this.$source, "rewarded_ads", "play");
    }
}
