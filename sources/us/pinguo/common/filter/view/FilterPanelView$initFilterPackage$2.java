package us.pinguo.common.filter.view;

import com.pinguo.camera360.effect.model.entity.Effect;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.commonui.R;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.entity.PackageItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterPanelView.kt */
/* loaded from: classes4.dex */
public final class FilterPanelView$initFilterPackage$2 extends Lambda implements q<PackageItem, Integer, FilterItem, u> {
    final /* synthetic */ FilterPanelView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelView$initFilterPackage$2(FilterPanelView filterPanelView) {
        super(3);
        this.this$0 = filterPanelView;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ u invoke(PackageItem packageItem, Integer num, FilterItem filterItem) {
        invoke(packageItem, num.intValue(), filterItem);
        return u.a;
    }

    public final void invoke(PackageItem filterPackage, int i2, FilterItem filterItem) {
        s.h(filterPackage, "filterPackage");
        if (s.c(filterPackage.getPackageId(), Effect.EFFECT_FILTER_AUTO_KEY)) {
            this.this$0.setSeekBarVisible(false);
            this.this$0.O(false, filterPackage, filterItem);
            this.this$0.setFilterItemViewVisible(false);
            FilterPanelView.a q = this.this$0.q();
            if (q == null) {
                return;
            }
            q.q();
        } else if (s.c(filterPackage.getPackageId(), Effect.EFFECT_FILTER_NONE_KEY)) {
            this.this$0.setSeekBarVisible(false);
            this.this$0.O(false, filterPackage, filterItem);
            this.this$0.setFilterItemViewVisible(false);
            FilterPanelView.a q2 = this.this$0.q();
            if (q2 == null) {
                return;
            }
            q2.T();
        } else if (filterPackage.isDownloaded()) {
            if (filterItem == null) {
                ((FilterPanelTabView) this.this$0.a(R.id.filterTabView)).h(filterPackage.getCategoryId());
            }
            FilterPanelView.a q3 = this.this$0.q();
            if (q3 != null) {
                q3.a(filterPackage, filterItem);
            }
            FilterPanelView filterPanelView = this.this$0;
            filterPanelView.O(filterPanelView.x(), filterPackage, filterItem);
            this.this$0.setFilterItemViewVisible(true);
        } else {
            FilterPanelView.a q4 = this.this$0.q();
            if (q4 == null) {
                return;
            }
            q4.l(filterPackage);
        }
    }
}
