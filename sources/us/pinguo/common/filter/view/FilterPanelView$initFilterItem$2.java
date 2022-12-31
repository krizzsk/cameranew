package us.pinguo.common.filter.view;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.commonui.R;
/* compiled from: FilterPanelView.kt */
/* loaded from: classes4.dex */
final class FilterPanelView$initFilterItem$2 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ FilterPanelView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelView$initFilterItem$2(FilterPanelView filterPanelView) {
        super(0);
        this.this$0 = filterPanelView;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String c = ((FilterPanelTabView) this.this$0.a(R.id.filterTabView)).c();
        if (s.c(c, "category_collect")) {
            c = null;
        }
        FilterPanelView.a q = this.this$0.q();
        if (q == null) {
            return;
        }
        q.I(c);
    }
}
