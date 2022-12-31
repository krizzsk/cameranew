package us.pinguo.common.filter.view;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.repository2020.entity.FilterItem;
/* compiled from: FilterPanelView.kt */
/* loaded from: classes4.dex */
final class FilterPanelView$initFilterItem$3 extends Lambda implements p<Boolean, FilterItem, u> {
    final /* synthetic */ FilterPanelView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelView$initFilterItem$3(FilterPanelView filterPanelView) {
        super(2);
        this.this$0 = filterPanelView;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Boolean bool, FilterItem filterItem) {
        invoke(bool.booleanValue(), filterItem);
        return u.a;
    }

    public final void invoke(boolean z, FilterItem item) {
        s.h(item, "item");
        FilterPanelView.a q = this.this$0.q();
        if (q == null) {
            return;
        }
        q.U(z, item);
    }
}
