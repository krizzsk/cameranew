package us.pinguo.edit2020.view;

import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
/* compiled from: ImageCompareAdjustView.kt */
/* loaded from: classes4.dex */
final class ImageCompareAdjustView$onFinishInflate$1 extends Lambda implements kotlin.jvm.b.l<Float, kotlin.u> {
    final /* synthetic */ ImageCompareAdjustView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCompareAdjustView$onFinishInflate$1(ImageCompareAdjustView imageCompareAdjustView) {
        super(1);
        this.this$0 = imageCompareAdjustView;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Float f2) {
        invoke(f2.floatValue());
        return kotlin.u.a;
    }

    public final void invoke(float f2) {
        kotlin.jvm.b.l<Float, kotlin.u> g2 = this.this$0.g();
        if (g2 != null) {
            g2.invoke(Float.valueOf(f2));
        }
        float width = this.this$0.getWidth() * f2;
        ImageCompareAdjustView imageCompareAdjustView = this.this$0;
        int i2 = R.id.tvBefore;
        if (width <= ((TextView) imageCompareAdjustView._$_findCachedViewById(i2)).getX() + ((TextView) this.this$0._$_findCachedViewById(i2)).getWidth()) {
            TextView tvBefore = (TextView) this.this$0._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(tvBefore, "tvBefore");
            if (!(tvBefore.getVisibility() == 4)) {
                TextView tvBefore2 = (TextView) this.this$0._$_findCachedViewById(i2);
                kotlin.jvm.internal.s.g(tvBefore2, "tvBefore");
                tvBefore2.setVisibility(4);
                VdsAgent.onSetViewVisibility(tvBefore2, 4);
            }
        } else {
            TextView tvBefore3 = (TextView) this.this$0._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(tvBefore3, "tvBefore");
            if (tvBefore3.getVisibility() == 4) {
                TextView tvBefore4 = (TextView) this.this$0._$_findCachedViewById(i2);
                kotlin.jvm.internal.s.g(tvBefore4, "tvBefore");
                tvBefore4.setVisibility(0);
                VdsAgent.onSetViewVisibility(tvBefore4, 0);
            }
        }
        ImageCompareAdjustView imageCompareAdjustView2 = this.this$0;
        int i3 = R.id.tvAfter;
        if (width >= ((TextView) imageCompareAdjustView2._$_findCachedViewById(i3)).getX()) {
            TextView tvAfter = (TextView) this.this$0._$_findCachedViewById(i3);
            kotlin.jvm.internal.s.g(tvAfter, "tvAfter");
            if (tvAfter.getVisibility() == 4) {
                return;
            }
            TextView tvAfter2 = (TextView) this.this$0._$_findCachedViewById(i3);
            kotlin.jvm.internal.s.g(tvAfter2, "tvAfter");
            tvAfter2.setVisibility(4);
            VdsAgent.onSetViewVisibility(tvAfter2, 4);
            return;
        }
        TextView tvAfter3 = (TextView) this.this$0._$_findCachedViewById(i3);
        kotlin.jvm.internal.s.g(tvAfter3, "tvAfter");
        if (tvAfter3.getVisibility() == 4) {
            TextView tvAfter4 = (TextView) this.this$0._$_findCachedViewById(i3);
            kotlin.jvm.internal.s.g(tvAfter4, "tvAfter");
            tvAfter4.setVisibility(0);
            VdsAgent.onSetViewVisibility(tvAfter4, 0);
        }
    }
}
