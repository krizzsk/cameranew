package us.pinguo.common.filter.view;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.entity.FilterItem;
/* compiled from: FilterPanelItemView.kt */
/* loaded from: classes4.dex */
final class FilterPanelItemView$updateList$1 extends Lambda implements p<Integer, FilterItem, u> {
    final /* synthetic */ FilterPanelItemView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelItemView$updateList$1(FilterPanelItemView filterPanelItemView) {
        super(2);
        this.this$0 = filterPanelItemView;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Integer num, FilterItem filterItem) {
        invoke(num.intValue(), filterItem);
        return u.a;
    }

    public final void invoke(int i2, FilterItem filterItem) {
        s.h(filterItem, "filterItem");
        this.this$0.j(filterItem, Integer.valueOf(i2));
    }
}
