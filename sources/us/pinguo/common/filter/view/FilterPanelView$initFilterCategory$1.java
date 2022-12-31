package us.pinguo.common.filter.view;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.repository2020.entity.CategoryItem;
/* compiled from: FilterPanelView.kt */
/* loaded from: classes4.dex */
final class FilterPanelView$initFilterCategory$1 extends Lambda implements p<CategoryItem, Boolean, u> {
    final /* synthetic */ FilterPanelView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelView$initFilterCategory$1(FilterPanelView filterPanelView) {
        super(2);
        this.this$0 = filterPanelView;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(CategoryItem categoryItem, Boolean bool) {
        invoke(categoryItem, bool.booleanValue());
        return u.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0074, code lost:
        if (java.lang.Math.abs(r7.d(r4 != null ? r4.getCategoryId() : null) - ((us.pinguo.common.filter.view.FilterPanelTabView) r5.this$0.a(r0)).d(r6.getCategoryId())) <= 1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(us.pinguo.repository2020.entity.CategoryItem r6, boolean r7) {
        /*
            r5 = this;
            java.lang.String r0 = "category"
            kotlin.jvm.internal.s.h(r6, r0)
            us.pinguo.common.filter.view.FilterPanelView r0 = r5.this$0
            us.pinguo.common.filter.view.FilterPanelView$a r0 = r0.q()
            if (r0 != 0) goto Le
            goto L11
        Le:
            r0.C(r6)
        L11:
            java.lang.String r0 = r6.getCategoryId()
            java.lang.String r1 = "category_collect"
            boolean r0 = kotlin.jvm.internal.s.c(r0, r1)
            if (r0 != 0) goto L83
            if (r7 != 0) goto L83
            us.pinguo.common.filter.view.FilterPanelView r7 = r5.this$0
            int r0 = us.pinguo.commonui.R.id.filterTabView
            android.view.View r7 = r7.a(r0)
            us.pinguo.common.filter.view.FilterPanelTabView r7 = (us.pinguo.common.filter.view.FilterPanelTabView) r7
            us.pinguo.repository2020.entity.CategoryItem r7 = r7.b()
            r2 = 0
            if (r7 != 0) goto L32
            r7 = r2
            goto L36
        L32:
            java.lang.String r7 = r7.getCategoryId()
        L36:
            boolean r7 = kotlin.jvm.internal.s.c(r7, r1)
            r1 = 1
            r3 = 0
            if (r7 == 0) goto L40
        L3e:
            r1 = 0
            goto L76
        L40:
            us.pinguo.common.filter.view.FilterPanelView r7 = r5.this$0
            android.view.View r7 = r7.a(r0)
            us.pinguo.common.filter.view.FilterPanelTabView r7 = (us.pinguo.common.filter.view.FilterPanelTabView) r7
            us.pinguo.common.filter.view.FilterPanelView r4 = r5.this$0
            android.view.View r4 = r4.a(r0)
            us.pinguo.common.filter.view.FilterPanelTabView r4 = (us.pinguo.common.filter.view.FilterPanelTabView) r4
            us.pinguo.repository2020.entity.CategoryItem r4 = r4.b()
            if (r4 != 0) goto L57
            goto L5b
        L57:
            java.lang.String r2 = r4.getCategoryId()
        L5b:
            int r7 = r7.d(r2)
            us.pinguo.common.filter.view.FilterPanelView r2 = r5.this$0
            android.view.View r0 = r2.a(r0)
            us.pinguo.common.filter.view.FilterPanelTabView r0 = (us.pinguo.common.filter.view.FilterPanelTabView) r0
            java.lang.String r2 = r6.getCategoryId()
            int r0 = r0.d(r2)
            int r7 = r7 - r0
            int r7 = java.lang.Math.abs(r7)
            if (r7 > r1) goto L3e
        L76:
            us.pinguo.common.filter.view.FilterPanelView r7 = r5.this$0
            int r0 = us.pinguo.commonui.R.id.packageListView
            android.view.View r7 = r7.a(r0)
            us.pinguo.common.filter.view.FilterPackageListView r7 = (us.pinguo.common.filter.view.FilterPackageListView) r7
            r7.E(r6, r1)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.view.FilterPanelView$initFilterCategory$1.invoke(us.pinguo.repository2020.entity.CategoryItem, boolean):void");
    }
}
