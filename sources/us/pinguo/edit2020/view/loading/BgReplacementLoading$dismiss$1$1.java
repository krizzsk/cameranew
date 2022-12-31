package us.pinguo.edit2020.view.loading;

import android.view.ViewPropertyAnimator;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.edit2020.view.loading.BgReplacementLoading;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BgReplacementLoadingControl.kt */
/* loaded from: classes4.dex */
public final class BgReplacementLoading$dismiss$1$1 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ BgReplacementLoadingView $this_apply;
    final /* synthetic */ BgReplacementLoading this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BgReplacementLoading$dismiss$1$1(BgReplacementLoadingView bgReplacementLoadingView, BgReplacementLoading bgReplacementLoading) {
        super(0);
        this.$this_apply = bgReplacementLoadingView;
        this.this$0 = bgReplacementLoading;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BgReplacementLoading.a aVar;
        ViewPropertyAnimator duration = this.$this_apply.animate().alpha(0.0f).setDuration(50L);
        aVar = this.this$0.f10776e;
        duration.setListener(aVar).start();
    }
}
