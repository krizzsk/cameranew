package us.pinguo.common.filter.view;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.commonui.R;
import us.pinguo.repository2020.entity.PackageItem;
/* compiled from: FilterPanelView.kt */
/* loaded from: classes4.dex */
final class FilterPanelView$initFilterPackage$1 extends Lambda implements l<PackageItem, u> {
    final /* synthetic */ FilterPanelView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelView$initFilterPackage$1(FilterPanelView filterPanelView) {
        super(1);
        this.this$0 = filterPanelView;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(PackageItem packageItem) {
        invoke2(packageItem);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(PackageItem it) {
        s.h(it, "it");
        ((FilterPanelTabView) this.this$0.a(R.id.filterTabView)).h(it.getCategoryId());
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        FilterPanelView.a q = this.this$0.q();
        iVar.g0(q == null ? null : q.M(), it.getCategoryId(), "slide_select");
    }
}
