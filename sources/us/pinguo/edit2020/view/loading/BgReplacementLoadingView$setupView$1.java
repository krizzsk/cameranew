package us.pinguo.edit2020.view.loading;

import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.R;
/* compiled from: BgReplacementLoadingView.kt */
/* loaded from: classes4.dex */
final class BgReplacementLoadingView$setupView$1 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ BgReplacementLoadingView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BgReplacementLoadingView$setupView$1(BgReplacementLoadingView bgReplacementLoadingView) {
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
        WebPAnimDraweeView ivLoadingMiddle = (WebPAnimDraweeView) this.this$0._$_findCachedViewById(R.id.ivLoadingMiddle);
        s.g(ivLoadingMiddle, "ivLoadingMiddle");
        ivLoadingMiddle.setVisibility(0);
        VdsAgent.onSetViewVisibility(ivLoadingMiddle, 0);
    }
}
