package us.pinguo.edit2020.view;

import java.util.List;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvanceStickerAdjustView.kt */
/* loaded from: classes4.dex */
public final class AdvanceStickerAdjustView$refreshData$1$1 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.p0, kotlin.u> {
    final /* synthetic */ List<us.pinguo.edit2020.model.f.a> $blendList;
    final /* synthetic */ AdvanceStickerAdjustView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvanceStickerAdjustView$refreshData$1$1(AdvanceStickerAdjustView advanceStickerAdjustView, List<us.pinguo.edit2020.model.f.a> list) {
        super(2);
        this.this$0 = advanceStickerAdjustView;
        this.$blendList = list;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.p0 p0Var) {
        invoke(num.intValue(), p0Var);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.p0 noName_1) {
        kotlin.jvm.internal.s.h(noName_1, "$noName_1");
        this.this$0.v(i2);
        if (i2 == 3) {
            ((ScrollableTextListView) this.this$0._$_findCachedViewById(R.id.overlayList)).d(this.$blendList);
        }
        kotlin.jvm.b.l<Integer, kotlin.u> m = this.this$0.m();
        if (m == null) {
            return;
        }
        m.invoke(Integer.valueOf(i2));
    }
}
