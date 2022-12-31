package us.pinguo.edit2020.view.loading;

import android.widget.TextView;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import kotlinx.coroutines.v1;
import us.pinguo.edit2020.R;
import us.pinguo.foundation.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BgReplacementLoadingView.kt */
/* loaded from: classes4.dex */
public final class BgReplacementLoadingView$doFinishAnimation$2 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ BgReplacementLoadingView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BgReplacementLoadingView$doFinishAnimation$2(BgReplacementLoadingView bgReplacementLoadingView) {
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
        ((WebPAnimDraweeView) this.this$0._$_findCachedViewById(R.id.ivLoadingEnd)).t();
        v1 v1Var = this.this$0.f10777d;
        if (v1Var != null) {
            v1.a.a(v1Var, null, 1, null);
        }
        ((TextView) this.this$0._$_findCachedViewById(R.id.tvProgress)).setText(e.b().getText(R.string.str_matting_success));
    }
}
