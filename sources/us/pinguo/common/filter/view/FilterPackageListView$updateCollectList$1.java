package us.pinguo.common.filter.view;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.entity.PackageItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterPackageListView.kt */
/* loaded from: classes4.dex */
public final class FilterPackageListView$updateCollectList$1 extends Lambda implements p<Integer, PackageItem, u> {
    final /* synthetic */ FilterPackageListView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPackageListView$updateCollectList$1(FilterPackageListView filterPackageListView) {
        super(2);
        this.this$0 = filterPackageListView;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Integer num, PackageItem packageItem) {
        invoke(num.intValue(), packageItem);
        return u.a;
    }

    public final void invoke(int i2, PackageItem filterItem) {
        s.h(filterItem, "filterItem");
        FilterPackageListView.H(this.this$0, filterItem, true, null, 4, null);
    }
}
