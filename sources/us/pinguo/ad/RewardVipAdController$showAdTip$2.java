package us.pinguo.ad;

import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.foundation.statistics.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RewardVipAdController.kt */
/* loaded from: classes3.dex */
public final class RewardVipAdController$showAdTip$2 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ String $adType;
    final /* synthetic */ String $page;
    final /* synthetic */ RewardVipAdController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardVipAdController$showAdTip$2(RewardVipAdController rewardVipAdController, String str, String str2) {
        super(0);
        this.this$0 = rewardVipAdController;
        this.$page = str;
        this.$adType = str2;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.a.k();
        h.b.A0(this.$page, this.$adType, "exit");
    }
}
