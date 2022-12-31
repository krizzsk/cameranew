package us.pinguo.common.filter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.commonui.R;
import us.pinguo.repository2020.entity.CategoryItem;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.entity.PackageItem;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: FilterPanelView.kt */
/* loaded from: classes4.dex */
public final class FilterPanelView extends LinearLayout {
    public Map<Integer, View> a;
    private boolean b;
    private a c;

    /* renamed from: d */
    private boolean f9907d;

    /* renamed from: e */
    private long f9908e;

    /* compiled from: FilterPanelView.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void A(int i2);

        void C(CategoryItem categoryItem);

        void H(FilterItem filterItem);

        void I(String str);

        String M();

        void T();

        void U(boolean z, FilterItem filterItem);

        void a(PackageItem packageItem, FilterItem filterItem);

        void c(PackageItem packageItem, boolean z);

        void l(PackageItem packageItem);

        boolean n();

        void q();

        void r(int i2);
    }

    /* compiled from: FilterPanelView.kt */
    /* loaded from: classes4.dex */
    public static final class b implements us.pinguo.ui.widget.h {
        b() {
            FilterPanelView.this = r1;
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            a q = FilterPanelView.this.q();
            if (q == null) {
                return;
            }
            q.r(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            a q = FilterPanelView.this.q();
            if (q == null) {
                return;
            }
            q.A(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = true;
        this.f9908e = 130L;
        View.inflate(getContext(), R.layout.filter_panel_view_layout, this);
        t();
        v();
        u();
        w();
    }

    public static /* synthetic */ void G(FilterPanelView filterPanelView, PackageItem packageItem, boolean z, FilterItem filterItem, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            filterItem = null;
        }
        filterPanelView.F(packageItem, z, filterItem);
    }

    public static /* synthetic */ void J(FilterPanelView filterPanelView, FilterItem filterItem, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        filterPanelView.I(filterItem, num);
    }

    public static /* synthetic */ void L(FilterPanelView filterPanelView, PackageItem packageItem, FilterItem filterItem, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            filterItem = null;
        }
        filterPanelView.K(packageItem, filterItem);
    }

    public final void O(boolean z, PackageItem packageItem, FilterItem filterItem) {
        l.d(n0.a(z0.b()), null, null, new FilterPanelView$seekBarEnable$1(packageItem, filterItem, this, z, null), 3, null);
    }

    public static final void Q(FilterPanelView this$0) {
        s.h(this$0, "this$0");
        if (this$0.f9907d) {
            return;
        }
        StickySeekBar filterSeekBar = (StickySeekBar) this$0.a(R.id.filterSeekBar);
        s.g(filterSeekBar, "filterSeekBar");
        filterSeekBar.setVisibility(0);
        VdsAgent.onSetViewVisibility(filterSeekBar, 0);
    }

    public static final void R(FilterPanelView this$0) {
        s.h(this$0, "this$0");
        int i2 = R.id.filterSeekBar;
        StickySeekBar filterSeekBar = (StickySeekBar) this$0.a(i2);
        s.g(filterSeekBar, "filterSeekBar");
        filterSeekBar.setVisibility(8);
        VdsAgent.onSetViewVisibility(filterSeekBar, 8);
        ((StickySeekBar) this$0.a(i2)).setAlpha(1.0f);
    }

    public static final void T(FilterPanelView this$0) {
        s.h(this$0, "this$0");
        if (this$0.f9907d) {
            return;
        }
        Group groupSeekBar = (Group) this$0.a(R.id.groupSeekBar);
        s.g(groupSeekBar, "groupSeekBar");
        groupSeekBar.setVisibility(0);
        VdsAgent.onSetViewVisibility(groupSeekBar, 0);
    }

    public static final void U(FilterPanelView this$0) {
        s.h(this$0, "this$0");
        int i2 = R.id.groupSeekBar;
        Group groupSeekBar = (Group) this$0.a(i2);
        s.g(groupSeekBar, "groupSeekBar");
        groupSeekBar.setVisibility(8);
        VdsAgent.onSetViewVisibility(groupSeekBar, 8);
        ((Group) this$0.a(i2)).setAlpha(1.0f);
    }

    public static final void a0(FilterPanelView this$0) {
        s.h(this$0, "this$0");
        RecyclerView recyclerView = (RecyclerView) ((FilterPanelItemView) this$0.a(R.id.filterItemView)).a(R.id.filterItemRecyclerView);
        s.g(recyclerView, "filterItemView.filterItemRecyclerView");
        recyclerView.setVisibility(8);
        VdsAgent.onSetViewVisibility(recyclerView, 8);
    }

    public static /* synthetic */ void c0(FilterPanelView filterPanelView, int i2, List list, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = -1;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        filterPanelView.b0(i2, list, i3, z);
    }

    private final void t() {
        int i2 = R.id.filterTabView;
        ((FilterPanelTabView) a(i2)).setOnCategoryClick(new FilterPanelView$initFilterCategory$1(this));
        ((FilterPanelTabView) a(i2)).setInterceptClickEvent(new FilterPanelView$initFilterCategory$2(this));
    }

    private final void u() {
        int i2 = R.id.filterItemView;
        ((FilterPanelItemView) a(i2)).setOnFilterClick(new FilterPanelView$initFilterItem$1(this));
        ((FilterPanelItemView) a(i2)).setGotoStore(new FilterPanelView$initFilterItem$2(this));
        ((FilterPanelItemView) a(i2)).setOnFilterCollectStatusChangeListener(new FilterPanelView$initFilterItem$3(this));
    }

    private final void v() {
        int i2 = R.id.packageListView;
        ((FilterPackageListView) a(i2)).setFocusPackageChanged(new FilterPanelView$initFilterPackage$1(this));
        ((FilterPackageListView) a(i2)).setOnPackageClick(new FilterPanelView$initFilterPackage$2(this));
        ((FilterPackageListView) a(i2)).setOnFilterPackageCollectStatusChange(new FilterPanelView$initFilterPackage$3(this));
    }

    private final void w() {
        ((StickySeekBar) a(R.id.filterSeekBar)).setTrackListener(new b());
    }

    /* JADX WARN: Code restructure failed: missing block: B:192:0x018b, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0191, code lost:
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0191 A[EDGE_INSN: B:210:0x0191->B:196:0x0191 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x0123 -> B:162:0x0128). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(us.pinguo.repository2020.entity.FilterEntry r18, kotlin.coroutines.Continuation<? super java.lang.Boolean> r19) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.view.FilterPanelView.z(us.pinguo.repository2020.entity.FilterEntry, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void F(PackageItem filterPackage, boolean z, FilterItem filterItem) {
        s.h(filterPackage, "filterPackage");
        ((FilterPackageListView) a(R.id.packageListView)).G(filterPackage, z, filterItem);
    }

    public final void H(CategoryItem categoryItem) {
        if (categoryItem == null) {
            return;
        }
        FilterPanelTabView filterTabView = (FilterPanelTabView) a(R.id.filterTabView);
        s.g(filterTabView, "filterTabView");
        FilterPanelTabView.f(filterTabView, categoryItem, null, 2, null);
    }

    public final void I(FilterItem filterItem, Integer num) {
        if (filterItem == null) {
            return;
        }
        ((FilterPanelItemView) a(R.id.filterItemView)).j(filterItem, num);
    }

    public final void K(PackageItem packageItem, FilterItem filterItem) {
        if (packageItem == null) {
            return;
        }
        ((FilterPackageListView) a(R.id.packageListView)).I(packageItem, null, filterItem);
    }

    public final void M() {
        ((FilterPackageListView) a(R.id.packageListView)).P();
    }

    public final void N() {
        ((FilterPackageListView) a(R.id.packageListView)).Q();
    }

    public final void P(boolean z) {
        if (z) {
            ((FilterPackageListView) a(R.id.packageListView)).setSeekbarHiddenByPackageVisible(false);
            int i2 = R.id.filterSeekBar;
            StickySeekBar filterSeekBar = (StickySeekBar) a(i2);
            s.g(filterSeekBar, "filterSeekBar");
            if ((filterSeekBar.getVisibility() == 0) || this.f9907d) {
                return;
            }
            ((StickySeekBar) a(i2)).animate().cancel();
            ((StickySeekBar) a(i2)).setAlpha(0.0f);
            ((StickySeekBar) a(i2)).animate().alpha(1.0f).setDuration(this.f9908e).withEndAction(new Runnable() { // from class: us.pinguo.common.filter.view.h
                @Override // java.lang.Runnable
                public final void run() {
                    FilterPanelView.Q(FilterPanelView.this);
                }
            }).start();
            return;
        }
        int i3 = R.id.filterSeekBar;
        StickySeekBar filterSeekBar2 = (StickySeekBar) a(i3);
        s.g(filterSeekBar2, "filterSeekBar");
        if (filterSeekBar2.getVisibility() == 0) {
            ((StickySeekBar) a(i3)).animate().cancel();
            ((StickySeekBar) a(i3)).animate().alpha(0.0f).setDuration(this.f9908e).withEndAction(new Runnable() { // from class: us.pinguo.common.filter.view.g
                @Override // java.lang.Runnable
                public final void run() {
                    FilterPanelView.R(FilterPanelView.this);
                }
            }).start();
        }
        View selectorFilter = a(R.id.selectorFilter);
        s.g(selectorFilter, "selectorFilter");
        selectorFilter.setVisibility(8);
        VdsAgent.onSetViewVisibility(selectorFilter, 8);
        View selectorTemplate = a(R.id.selectorTemplate);
        s.g(selectorTemplate, "selectorTemplate");
        selectorTemplate.setVisibility(8);
        VdsAgent.onSetViewVisibility(selectorTemplate, 8);
    }

    public final void S(boolean z) {
        if (z) {
            ((FilterPackageListView) a(R.id.packageListView)).setSeekbarHiddenByPackageVisible(false);
            int i2 = R.id.groupSeekBar;
            Group groupSeekBar = (Group) a(i2);
            s.g(groupSeekBar, "groupSeekBar");
            if ((groupSeekBar.getVisibility() == 0) || this.f9907d) {
                return;
            }
            ((Group) a(i2)).animate().cancel();
            ((Group) a(i2)).setAlpha(0.0f);
            ((Group) a(i2)).animate().alpha(1.0f).setDuration(this.f9908e).withEndAction(new Runnable() { // from class: us.pinguo.common.filter.view.j
                @Override // java.lang.Runnable
                public final void run() {
                    FilterPanelView.T(FilterPanelView.this);
                }
            }).start();
            return;
        }
        int i3 = R.id.groupSeekBar;
        Group groupSeekBar2 = (Group) a(i3);
        s.g(groupSeekBar2, "groupSeekBar");
        if (groupSeekBar2.getVisibility() == 0) {
            ((Group) a(i3)).animate().cancel();
            ((Group) a(i3)).animate().alpha(0.0f).setDuration(this.f9908e).withEndAction(new Runnable() { // from class: us.pinguo.common.filter.view.f
                @Override // java.lang.Runnable
                public final void run() {
                    FilterPanelView.U(FilterPanelView.this);
                }
            }).start();
        }
    }

    public final void V() {
        ((FilterPackageListView) a(R.id.packageListView)).F();
    }

    public final void W(int i2) {
        ((FilterPackageListView) a(R.id.packageListView)).R(i2);
    }

    public final void X() {
        a(R.id.selectorFilter).performClick();
    }

    public final void Y() {
        ((FilterPackageListView) a(R.id.packageListView)).L();
    }

    public final void Z() {
        a(R.id.selectorTemplate).performClick();
    }

    public View a(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void b0(int i2, List<FilterItem> filterList, int i3, boolean z) {
        s.h(filterList, "filterList");
        ((FilterPanelItemView) a(R.id.filterItemView)).l(i2, filterList, i3, z);
        setFilterItemViewVisible(true);
    }

    public final void d(String categoryId) {
        s.h(categoryId, "categoryId");
        ((FilterPanelTabView) a(R.id.filterTabView)).h(categoryId);
        ((FilterPackageListView) a(R.id.packageListView)).l("type_normal");
    }

    public final void d0(List<PackageItem> packageList) {
        s.h(packageList, "packageList");
        ((FilterPackageListView) a(R.id.packageListView)).S(packageList);
    }

    public final void e() {
        ((FilterPackageListView) a(R.id.packageListView)).m();
    }

    public final void e0(PackageItem packageItem, int i2) {
        s.h(packageItem, "packageItem");
        packageItem.setDownloadProgress(i2);
        ((FilterPackageListView) a(R.id.packageListView)).T(packageItem);
    }

    public final void f() {
        StickySeekBar filterSeekBar = (StickySeekBar) a(R.id.filterSeekBar);
        s.g(filterSeekBar, "filterSeekBar");
        filterSeekBar.setVisibility(8);
        VdsAgent.onSetViewVisibility(filterSeekBar, 8);
        setFilterItemViewVisible(false);
        ((FilterPackageListView) a(R.id.packageListView)).o();
    }

    public final void f0(List<PackageItem> packageList) {
        s.h(packageList, "packageList");
        ((FilterPackageListView) a(R.id.packageListView)).U(packageList);
    }

    public final void g(boolean z) {
        ((FilterPackageListView) a(R.id.packageListView)).p(z);
    }

    public final void g0(int i2) {
        ((StickySeekBar) a(R.id.filterSeekBar)).setDefaultProgress(i2);
    }

    public final void h(boolean z) {
        ((FilterPackageListView) a(R.id.packageListView)).q(z);
    }

    public final void h0(int i2) {
        ((StickySeekBar) a(R.id.filterSeekBar)).setProgress(i2);
    }

    public final CategoryItem i() {
        return ((FilterPanelTabView) a(R.id.filterTabView)).b();
    }

    public final void i0(String categoryId) {
        s.h(categoryId, "categoryId");
        ((FilterPanelTabView) a(R.id.filterTabView)).h(categoryId);
    }

    public final View j() {
        return ((FilterPackageListView) a(R.id.packageListView)).s();
    }

    public final void j0(List<CategoryItem> tabList) {
        s.h(tabList, "tabList");
        ((FilterPanelTabView) a(R.id.filterTabView)).g(tabList);
    }

    public final PackageItem k() {
        return ((FilterPackageListView) a(R.id.packageListView)).r();
    }

    public final FilterItem l() {
        return ((FilterPanelItemView) a(R.id.filterItemView)).d();
    }

    public final int m() {
        return ((FilterPanelItemView) a(R.id.filterItemView)).e();
    }

    public final int n() {
        return ((FilterPackageListView) a(R.id.packageListView)).t();
    }

    public final PackageItem o() {
        return ((FilterPackageListView) a(R.id.packageListView)).u();
    }

    public final boolean p() {
        return this.f9907d;
    }

    public final a q() {
        return this.c;
    }

    public final PackageItem r() {
        return ((FilterPackageListView) a(R.id.packageListView)).w();
    }

    public final void s(CategoryItem categoryItem, PackageItem packageItem, FilterItem filterItem) {
        H(categoryItem);
        if (!s.c(categoryItem == null ? null : categoryItem.getCategoryId(), "category_collect")) {
            K(packageItem, filterItem);
        } else if (packageItem == null) {
            return;
        } else {
            F(packageItem, false, filterItem);
        }
        J(this, filterItem, null, 2, null);
    }

    public final void setDisableSeekbar(boolean z) {
        if (this.f9907d != z) {
            this.f9907d = z;
            if (z) {
                StickySeekBar filterSeekBar = (StickySeekBar) a(R.id.filterSeekBar);
                s.g(filterSeekBar, "filterSeekBar");
                filterSeekBar.setVisibility(8);
                VdsAgent.onSetViewVisibility(filterSeekBar, 8);
            }
        }
    }

    public final void setFadeAnimDuration(long j2) {
        this.f9908e = j2;
    }

    public final void setFilterItemViewVisible(boolean z) {
        if (z) {
            ((FilterPackageListView) a(R.id.packageListView)).setFilterItemHiddenByPackageVisible(false);
        }
        if (z && ((FilterPanelItemView) a(R.id.filterItemView)).g()) {
            setFilterItemViewVisible(false);
            return;
        }
        int i2 = R.id.filterItemView;
        int i3 = R.id.filterItemRecyclerView;
        ViewPropertyAnimator animate = ((RecyclerView) ((FilterPanelItemView) a(i2)).a(i3)).animate();
        animate.cancel();
        if (z) {
            if (((RecyclerView) ((FilterPanelItemView) a(i2)).a(i3)).getAlpha() == 0.0f) {
                RecyclerView recyclerView = (RecyclerView) ((FilterPanelItemView) a(i2)).a(i3);
                s.g(recyclerView, "filterItemView.filterItemRecyclerView");
                recyclerView.setVisibility(0);
                VdsAgent.onSetViewVisibility(recyclerView, 0);
                animate.alpha(1.0f);
                animate.setDuration(this.f9908e);
                animate.start();
            } else {
                ((RecyclerView) ((FilterPanelItemView) a(i2)).a(i3)).setAlpha(1.0f);
                RecyclerView recyclerView2 = (RecyclerView) ((FilterPanelItemView) a(i2)).a(i3);
                s.g(recyclerView2, "filterItemView.filterItemRecyclerView");
                recyclerView2.setVisibility(0);
                VdsAgent.onSetViewVisibility(recyclerView2, 0);
            }
        } else {
            if (((RecyclerView) ((FilterPanelItemView) a(i2)).a(i3)).getAlpha() == 1.0f) {
                animate.alpha(0.0f);
                animate.setDuration(this.f9908e);
                animate.withEndAction(new Runnable() { // from class: us.pinguo.common.filter.view.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilterPanelView.a0(FilterPanelView.this);
                    }
                });
                animate.start();
            } else {
                ((RecyclerView) ((FilterPanelItemView) a(i2)).a(i3)).setAlpha(0.0f);
                RecyclerView recyclerView3 = (RecyclerView) ((FilterPanelItemView) a(i2)).a(i3);
                s.g(recyclerView3, "filterItemView.filterItemRecyclerView");
                recyclerView3.setVisibility(8);
                VdsAgent.onSetViewVisibility(recyclerView3, 8);
            }
        }
        FilterPanelItemView filterItemView = (FilterPanelItemView) a(i2);
        s.g(filterItemView, "filterItemView");
        Log.i(TJAdUnitConstants.String.VIDEO_INFO, s.q("==============filterItemView visible=", Boolean.valueOf(filterItemView.getVisibility() == 0)));
    }

    public final void setFilterPanelBg(@ColorInt int i2) {
        ((FilterPanelTabView) a(R.id.filterTabView)).setBackgroundColor(i2);
        ((FilterPackageListView) a(R.id.packageListView)).setBackgroundColor(i2);
    }

    public final void setFilterPanelEvent(a aVar) {
        this.c = aVar;
    }

    public final void setFromEdit(boolean z) {
        ((FilterPackageListView) a(R.id.packageListView)).setFromEdit(z);
    }

    public final void setSeekBarVisible(boolean z) {
        this.b = z;
    }

    public final boolean x() {
        return this.b;
    }

    public final boolean y() {
        StickySeekBar filterSeekBar = (StickySeekBar) a(R.id.filterSeekBar);
        s.g(filterSeekBar, "filterSeekBar");
        return filterSeekBar.getVisibility() == 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.b = true;
        this.f9908e = 130L;
        View.inflate(getContext(), R.layout.filter_panel_view_layout, this);
        t();
        v();
        u();
        w();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.b = true;
        this.f9908e = 130L;
        View.inflate(getContext(), R.layout.filter_panel_view_layout, this);
        t();
        v();
        u();
        w();
    }
}
