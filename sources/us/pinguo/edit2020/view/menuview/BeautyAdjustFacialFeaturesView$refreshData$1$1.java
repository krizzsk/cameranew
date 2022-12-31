package us.pinguo.edit2020.view.menuview;

import android.content.Context;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.bean.r;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* compiled from: BeautyAdjustFacialFeaturesView.kt */
/* loaded from: classes4.dex */
final class BeautyAdjustFacialFeaturesView$refreshData$1$1 extends Lambda implements p<Integer, r, u> {
    final /* synthetic */ BeautyAdjustFacialFeaturesView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyAdjustFacialFeaturesView$refreshData$1$1(BeautyAdjustFacialFeaturesView beautyAdjustFacialFeaturesView) {
        super(2);
        this.this$0 = beautyAdjustFacialFeaturesView;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Integer num, r rVar) {
        invoke(num.intValue(), rVar);
        return u.a;
    }

    public final void invoke(int i2, r data) {
        s.h(data, "data");
        CenterLayoutManager g2 = this.this$0.g();
        Context context = this.this$0.getContext();
        s.g(context, "context");
        g2.b(context, i2, 100.0f);
        p<Integer, r, u> h2 = this.this$0.h();
        if (h2 == null) {
            return;
        }
        h2.invoke(Integer.valueOf(i2), data);
    }
}
