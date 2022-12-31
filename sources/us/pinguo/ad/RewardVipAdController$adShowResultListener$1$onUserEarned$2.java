package us.pinguo.ad;

import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.common.widget.adv.AdRewardView;
import us.pinguo.foundation.statistics.h;
/* compiled from: RewardVipAdController.kt */
/* loaded from: classes3.dex */
final class RewardVipAdController$adShowResultListener$1$onUserEarned$2 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ String $adType;
    final /* synthetic */ String $pageType2;
    final /* synthetic */ RewardVipAdController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardVipAdController$adShowResultListener$1$onUserEarned$2(RewardVipAdController rewardVipAdController, String str, String str2) {
        super(0);
        this.this$0 = rewardVipAdController;
        this.$pageType2 = str;
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
        AdRewardView adRewardView = this.this$0.a;
        adRewardView.setVisibility(8);
        VdsAgent.onSetViewVisibility(adRewardView, 8);
        h.b.D0(this.$pageType2, this.$adType, "exit");
    }
}
