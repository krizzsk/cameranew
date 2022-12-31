package us.pinguo.common.filter.view;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.entity.CategoryItem;
/* compiled from: FilterPanelTabView.kt */
/* loaded from: classes4.dex */
final class FilterPanelTabView$updateList$1 extends Lambda implements p<Integer, CategoryItem, u> {
    final /* synthetic */ FilterPanelTabView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelTabView$updateList$1(FilterPanelTabView filterPanelTabView) {
        super(2);
        this.this$0 = filterPanelTabView;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Integer num, CategoryItem categoryItem) {
        invoke(num.intValue(), categoryItem);
        return u.a;
    }

    public final void invoke(int i2, CategoryItem categoryItem) {
        s.h(categoryItem, "categoryItem");
        this.this$0.e(categoryItem, Integer.valueOf(i2));
    }
}
