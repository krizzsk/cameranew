package us.pinguo.edit2020.view.loading;

import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.edit2020.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BgReplacementLoadingView.kt */
/* loaded from: classes4.dex */
public final class BgReplacementLoadingView$setupView$3 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ BgReplacementLoadingView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BgReplacementLoadingView$setupView$3(BgReplacementLoadingView bgReplacementLoadingView) {
        super(0);
        this.this$0 = bgReplacementLoadingView;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z;
        z = this.this$0.f10781h;
        if (z) {
            return;
        }
        ((WebPAnimDraweeView) this.this$0._$_findCachedViewById(R.id.ivLoadingMiddle)).t();
    }
}
