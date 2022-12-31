package us.pinguo.common.filter.view;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.commonui.R;
import us.pinguo.foundation.utils.k0;
import us.pinguo.repository2020.entity.CategoryItem;
/* compiled from: FilterPanelView.kt */
/* loaded from: classes4.dex */
final class FilterPanelView$initFilterCategory$2 extends Lambda implements l<CategoryItem, Boolean> {
    final /* synthetic */ FilterPanelView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelView$initFilterCategory$2(FilterPanelView filterPanelView) {
        super(1);
        this.this$0 = filterPanelView;
    }

    @Override // kotlin.jvm.b.l
    public final Boolean invoke(CategoryItem categoryItem) {
        s.h(categoryItem, "categoryItem");
        boolean z = false;
        if (s.c(categoryItem.getCategoryId(), "category_collect")) {
            FilterPanelView.a q = this.this$0.q();
            if (q != null && q.n()) {
                k0.a.a(R.string.str_not_collected_yet);
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }
}
