package us.pinguo.common.filter.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.filter.FilterPackageAdapter;
import us.pinguo.common.widget.ScrollCenterLayoutManager;
import us.pinguo.commonui.R;
import us.pinguo.foundation.utils.n0;
import us.pinguo.repository2020.FilterConstants;
import us.pinguo.repository2020.entity.CategoryItem;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.entity.PackageItem;
import us.pinguo.repository2020.manager.FilterRedPointManager;
/* compiled from: FilterPackageListView.kt */
/* loaded from: classes4.dex */
public final class FilterPackageListView extends FrameLayout {
    public Map<Integer, View> a;
    private FilterPackageAdapter b;
    private FilterPackageAdapter c;

    /* renamed from: d  reason: collision with root package name */
    private ScrollCenterLayoutManager f9888d;

    /* renamed from: e  reason: collision with root package name */
    private ScrollCenterLayoutManager f9889e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9890f;

    /* renamed from: g  reason: collision with root package name */
    private int f9891g;

    /* renamed from: h  reason: collision with root package name */
    private String f9892h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9893i;

    /* renamed from: j  reason: collision with root package name */
    private l<? super PackageItem, u> f9894j;

    /* renamed from: k  reason: collision with root package name */
    private q<? super PackageItem, ? super Integer, ? super FilterItem, u> f9895k;

    /* renamed from: l  reason: collision with root package name */
    private p<? super PackageItem, ? super Integer, u> f9896l;
    private p<? super PackageItem, ? super Boolean, u> m;
    private boolean n;
    private boolean o;
    private l<? super Boolean, u> p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;

    /* compiled from: FilterPackageListView.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            s.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            ScrollCenterLayoutManager scrollCenterLayoutManager = FilterPackageListView.this.f9889e;
            int findFirstVisibleItemPosition = scrollCenterLayoutManager == null ? 0 : scrollCenterLayoutManager.findFirstVisibleItemPosition();
            ScrollCenterLayoutManager scrollCenterLayoutManager2 = FilterPackageListView.this.f9889e;
            int findLastVisibleItemPosition = scrollCenterLayoutManager2 != null ? scrollCenterLayoutManager2.findLastVisibleItemPosition() : 0;
            FilterPackageAdapter filterPackageAdapter = FilterPackageListView.this.c;
            if (filterPackageAdapter == null) {
                return;
            }
            int j2 = filterPackageAdapter.j();
            FilterPackageListView filterPackageListView = FilterPackageListView.this;
            if (j2 >= findFirstVisibleItemPosition && j2 <= findLastVisibleItemPosition) {
                l<Boolean, u> y = filterPackageListView.y();
                if (y == null) {
                    return;
                }
                y.invoke(Boolean.TRUE);
                return;
            }
            l<Boolean, u> y2 = filterPackageListView.y();
            if (y2 == null) {
                return;
            }
            y2.invoke(Boolean.FALSE);
        }
    }

    /* compiled from: FilterPackageListView.kt */
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            s.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1) {
                FilterPackageListView.this.f9893i = true;
            }
            if (i2 == 0) {
                FilterPackageListView.this.f9893i = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            l<Boolean, u> y;
            l<Boolean, u> y2;
            ArrayList<PackageItem> h2;
            PackageItem packageItem;
            l<PackageItem, u> x;
            s.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            ScrollCenterLayoutManager scrollCenterLayoutManager = FilterPackageListView.this.f9888d;
            boolean z = false;
            int findFirstVisibleItemPosition = scrollCenterLayoutManager == null ? 0 : scrollCenterLayoutManager.findFirstVisibleItemPosition();
            ScrollCenterLayoutManager scrollCenterLayoutManager2 = FilterPackageListView.this.f9888d;
            int findLastVisibleItemPosition = scrollCenterLayoutManager2 == null ? 0 : scrollCenterLayoutManager2.findLastVisibleItemPosition();
            if (FilterPackageListView.this.f9893i) {
                int i4 = (findLastVisibleItemPosition + findFirstVisibleItemPosition) / 2;
                FilterPackageAdapter filterPackageAdapter = FilterPackageListView.this.b;
                if (filterPackageAdapter != null && (h2 = filterPackageAdapter.h()) != null && (packageItem = h2.get(i4)) != null && (x = FilterPackageListView.this.x()) != null) {
                    x.invoke(packageItem);
                }
            }
            FilterPackageAdapter filterPackageAdapter2 = FilterPackageListView.this.b;
            if (filterPackageAdapter2 == null) {
                return;
            }
            int j2 = filterPackageAdapter2.j();
            FilterPackageListView filterPackageListView = FilterPackageListView.this;
            if (j2 == -1) {
                return;
            }
            if (filterPackageListView.f9890f) {
                j2++;
            }
            if (j2 >= findFirstVisibleItemPosition && j2 <= findLastVisibleItemPosition) {
                if (!filterPackageListView.A() && (y2 = filterPackageListView.y()) != null) {
                    y2.invoke(Boolean.TRUE);
                }
                z = true;
            } else if (filterPackageListView.A() && (y = filterPackageListView.y()) != null) {
                y.invoke(Boolean.FALSE);
            }
            filterPackageListView.setUserVisible(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPackageListView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.f9890f = true;
        this.f9891g = -1;
        this.f9892h = "type_normal";
        this.q = true;
        View.inflate(getContext(), R.layout.filter_package_view_layout, this);
    }

    public static /* synthetic */ void H(FilterPackageListView filterPackageListView, PackageItem packageItem, boolean z, FilterItem filterItem, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            filterItem = null;
        }
        filterPackageListView.G(packageItem, z, filterItem);
    }

    public static /* synthetic */ void J(FilterPackageListView filterPackageListView, PackageItem packageItem, Integer num, FilterItem filterItem, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            filterItem = null;
        }
        filterPackageListView.I(packageItem, num, filterItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(FilterPackageListView this$0, Ref$ObjectRef packagePosition) {
        s.h(this$0, "this$0");
        s.h(packagePosition, "$packagePosition");
        this$0.O(((Number) packagePosition.element).intValue());
    }

    private final void M(View view) {
        N(view);
        if (this.u) {
            V(view);
        }
        if (this.t) {
            W(view);
        }
    }

    private final void N(View view) {
        if (this.s) {
            int i2 = R.id.iconNone;
            Drawable background = ((AppCompatImageView) view.findViewById(i2)).getBackground();
            if (background != null) {
                background.setTint(Color.parseColor("#EEEEEE"));
            }
            ((AppCompatImageView) view.findViewById(i2)).setImageResource(R.drawable.icon_none_filter_gray);
            int i3 = R.id.iconAuto;
            Drawable background2 = ((AppCompatImageView) view.findViewById(i3)).getBackground();
            if (background2 != null) {
                background2.setTint(Color.parseColor("#EEEEEE"));
            }
            ((AppCompatImageView) view.findViewById(i3)).setImageResource(R.drawable.icon_auto_filter_gray);
            return;
        }
        int i4 = R.id.iconNone;
        Drawable background3 = ((AppCompatImageView) view.findViewById(i4)).getBackground();
        if (background3 != null) {
            background3.setTint(Color.parseColor("#2d2d2d"));
        }
        ((AppCompatImageView) view.findViewById(i4)).setImageResource(R.drawable.icon_none_filter_gray);
        int i5 = R.id.iconAuto;
        Drawable background4 = ((AppCompatImageView) view.findViewById(i5)).getBackground();
        if (background4 != null) {
            background4.setTint(Color.parseColor("#2d2d2d"));
        }
        ((AppCompatImageView) view.findViewById(i5)).setImageResource(R.drawable.icon_auto_filter_gray);
    }

    private final void O(int i2) {
        ScrollCenterLayoutManager scrollCenterLayoutManager;
        int i3 = (n0.i() / 2) - (getContext().getResources().getDimensionPixelSize(R.dimen.filter_package_panel_item_width) / 2);
        if (i2 < 0 || (scrollCenterLayoutManager = this.f9888d) == null) {
            return;
        }
        scrollCenterLayoutManager.scrollToPositionWithOffset(i2, i3);
    }

    private final void V(View view) {
        if (this.s) {
            int i2 = R.id.iconAuto;
            Drawable background = ((AppCompatImageView) view.findViewById(i2)).getBackground();
            if (background != null) {
                background.setTint(Color.parseColor("#2d2d2d"));
            }
            ((AppCompatImageView) view.findViewById(i2)).setImageResource(R.drawable.icon_auto_filter_white);
            int i3 = R.id.iconNone;
            Drawable background2 = ((AppCompatImageView) view.findViewById(i3)).getBackground();
            if (background2 != null) {
                background2.setTint(Color.parseColor("#eeeeee"));
            }
            ((AppCompatImageView) view.findViewById(i3)).setImageResource(R.drawable.icon_none_filter_gray);
            return;
        }
        int i4 = R.id.iconAuto;
        Drawable background3 = ((AppCompatImageView) view.findViewById(i4)).getBackground();
        if (background3 != null) {
            background3.setTint(Color.parseColor("#eeeeee"));
        }
        ((AppCompatImageView) view.findViewById(i4)).setImageResource(R.drawable.icon_auto_filter_black);
        int i5 = R.id.iconNone;
        Drawable background4 = ((AppCompatImageView) view.findViewById(i5)).getBackground();
        if (background4 != null) {
            background4.setTint(Color.parseColor("#2d2d2d"));
        }
        ((AppCompatImageView) view.findViewById(i5)).setImageResource(R.drawable.icon_none_filter_gray);
    }

    private final void W(View view) {
        if (this.s) {
            int i2 = R.id.iconNone;
            Drawable background = ((AppCompatImageView) view.findViewById(i2)).getBackground();
            if (background != null) {
                background.setTint(Color.parseColor("#2d2d2d"));
            }
            ((AppCompatImageView) view.findViewById(i2)).setImageResource(R.drawable.icon_none_filter_white);
            int i3 = R.id.iconAuto;
            Drawable background2 = ((AppCompatImageView) view.findViewById(i3)).getBackground();
            if (background2 != null) {
                background2.setTint(Color.parseColor("#eeeeee"));
            }
            ((AppCompatImageView) view.findViewById(i3)).setImageResource(R.drawable.icon_auto_filter_gray);
            return;
        }
        int i4 = R.id.iconNone;
        Drawable background3 = ((AppCompatImageView) view.findViewById(i4)).getBackground();
        if (background3 != null) {
            background3.setTint(Color.parseColor("#eeeeee"));
        }
        ((AppCompatImageView) view.findViewById(i4)).setImageResource(R.drawable.icon_none_filter_black);
        int i5 = R.id.iconAuto;
        Drawable background4 = ((AppCompatImageView) view.findViewById(i5)).getBackground();
        if (background4 != null) {
            background4.setTint(Color.parseColor("#2d2d2d"));
        }
        ((AppCompatImageView) view.findViewById(i5)).setImageResource(R.drawable.icon_auto_filter_gray);
    }

    private final void X() {
        ((RecyclerView) a(R.id.filterCollectRecyclerView)).addOnScrollListener(new a());
    }

    private final void Y() {
        ((RecyclerView) a(R.id.filterPackageRecyclerView)).addOnScrollListener(new b());
    }

    private final void i(FilterPackageAdapter filterPackageAdapter) {
        View headerView = LayoutInflater.from(us.pinguo.foundation.e.b()).inflate(R.layout.filter_none_and_auto_header_layout, (ViewGroup) null, false);
        filterPackageAdapter.s(headerView);
        s.g(headerView, "headerView");
        M(headerView);
        ((AppCompatImageView) headerView.findViewById(R.id.iconNone)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.filter.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterPackageListView.j(FilterPackageListView.this, view);
            }
        });
        ((AppCompatImageView) headerView.findViewById(R.id.iconAuto)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.filter.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterPackageListView.k(FilterPackageListView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(FilterPackageListView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        this$0.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FilterPackageListView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        this$0.F();
    }

    private final void n() {
        View e2;
        View e3;
        if (this.f9890f) {
            this.t = false;
            this.u = false;
            FilterPackageAdapter filterPackageAdapter = this.b;
            if (filterPackageAdapter != null && (e3 = filterPackageAdapter.e()) != null) {
                N(e3);
            }
            FilterPackageAdapter filterPackageAdapter2 = this.c;
            if (filterPackageAdapter2 == null || (e2 = filterPackageAdapter2.e()) == null) {
                return;
            }
            N(e2);
        }
    }

    public final boolean A() {
        return this.q;
    }

    public final void E(CategoryItem categoryItem, boolean z) {
        s.h(categoryItem, "categoryItem");
        FilterPackageAdapter filterPackageAdapter = this.b;
        if (filterPackageAdapter == null) {
            return;
        }
        int i2 = 0;
        Iterator<PackageItem> it = filterPackageAdapter.h().iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (s.c(it.next().getCategoryId(), categoryItem.getCategoryId())) {
                break;
            } else {
                i2++;
            }
        }
        if (this.f9890f) {
            i2++;
        }
        if (i2 >= 0) {
            if (z) {
                ScrollCenterLayoutManager scrollCenterLayoutManager = this.f9888d;
                if (scrollCenterLayoutManager == null) {
                    return;
                }
                Context context = getContext();
                s.g(context, "context");
                scrollCenterLayoutManager.a(context, i2, 60.0f);
                return;
            }
            O(i2);
        }
    }

    public final void F() {
        int j2;
        View e2;
        View e3;
        this.t = false;
        this.u = true;
        q<? super PackageItem, ? super Integer, ? super FilterItem, u> qVar = this.f9895k;
        if (qVar != null) {
            qVar.invoke(FilterConstants.a.j(), -1, null);
        }
        FilterPackageAdapter filterPackageAdapter = this.b;
        if (filterPackageAdapter != null && (e3 = filterPackageAdapter.e()) != null) {
            V(e3);
        }
        FilterPackageAdapter filterPackageAdapter2 = this.c;
        if (filterPackageAdapter2 != null && (e2 = filterPackageAdapter2.e()) != null) {
            V(e2);
        }
        FilterPackageAdapter filterPackageAdapter3 = s.c(this.f9892h, "type_collect") ? this.c : this.b;
        if (filterPackageAdapter3 == null || (j2 = filterPackageAdapter3.j()) == -1) {
            return;
        }
        filterPackageAdapter3.v(-1);
        filterPackageAdapter3.notifyItemChanged(j2 + 1);
    }

    public final void G(PackageItem filterPackage, boolean z, FilterItem filterItem) {
        s.h(filterPackage, "filterPackage");
        FilterPackageAdapter filterPackageAdapter = this.c;
        if (filterPackageAdapter == null) {
            return;
        }
        int i2 = 0;
        Iterator<PackageItem> it = filterPackageAdapter.h().iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (s.c(it.next().getPackageId(), filterPackage.getPackageId())) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == filterPackageAdapter.j()) {
            p<? super PackageItem, ? super Integer, u> pVar = this.f9896l;
            if (pVar != null) {
                pVar.invoke(filterPackage, Integer.valueOf(i2));
            }
        } else {
            n();
            q<? super PackageItem, ? super Integer, ? super FilterItem, u> qVar = this.f9895k;
            if (qVar != null) {
                qVar.invoke(filterPackage, Integer.valueOf(i2), filterItem);
            }
            filterPackageAdapter.v(i2);
            filterPackageAdapter.notifyDataSetChanged();
            if (z) {
                if (this.f9890f) {
                    i2++;
                }
                ScrollCenterLayoutManager scrollCenterLayoutManager = this.f9889e;
                if (scrollCenterLayoutManager != null) {
                    Context context = getContext();
                    s.g(context, "context");
                    scrollCenterLayoutManager.a(context, i2, 100.0f);
                }
            }
        }
        FilterPackageAdapter filterPackageAdapter2 = this.b;
        if (filterPackageAdapter2 == null) {
            return;
        }
        filterPackageAdapter2.v(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v13, types: [T, java.lang.Integer] */
    public final void I(PackageItem filterPackageItem, Integer num, FilterItem filterItem) {
        ScrollCenterLayoutManager scrollCenterLayoutManager;
        s.h(filterPackageItem, "filterPackageItem");
        FilterPackageAdapter filterPackageAdapter = this.b;
        if (filterPackageAdapter == null || (scrollCenterLayoutManager = this.f9888d) == null) {
            return;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = num;
        if (num == 0) {
            ref$ObjectRef.element = Integer.valueOf(filterPackageAdapter.i(filterPackageItem));
        }
        Integer num2 = (Integer) ref$ObjectRef.element;
        int j2 = filterPackageAdapter.j();
        if (num2 != null && num2.intValue() == j2) {
            p<? super PackageItem, ? super Integer, u> pVar = this.f9896l;
            if (pVar != null) {
                pVar.invoke(filterPackageItem, ref$ObjectRef.element);
            }
        } else {
            n();
            q<? super PackageItem, ? super Integer, ? super FilterItem, u> qVar = this.f9895k;
            if (qVar != null) {
                qVar.invoke(filterPackageItem, ref$ObjectRef.element, filterItem);
            }
            if (filterPackageItem.isDownloaded()) {
                filterPackageAdapter.v(((Number) ref$ObjectRef.element).intValue());
                filterPackageAdapter.notifyDataSetChanged();
            }
            if (this.f9890f) {
                ref$ObjectRef.element = Integer.valueOf(((Number) ref$ObjectRef.element).intValue() + 1);
            }
            if (num == 0) {
                RecyclerView filterPackageRecyclerView = (RecyclerView) a(R.id.filterPackageRecyclerView);
                s.g(filterPackageRecyclerView, "filterPackageRecyclerView");
                us.pinguo.foundation.ui.c.b(filterPackageRecyclerView, new Runnable() { // from class: us.pinguo.common.filter.view.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilterPackageListView.K(FilterPackageListView.this, ref$ObjectRef);
                    }
                });
            } else if (((Number) ref$ObjectRef.element).intValue() >= 0) {
                Context context = getContext();
                s.g(context, "context");
                scrollCenterLayoutManager.a(context, ((Number) ref$ObjectRef.element).intValue(), 100.0f);
            }
        }
        FilterRedPointManager.a.l(filterPackageItem.getPackageId());
    }

    public final void L() {
        int j2;
        View e2;
        View e3;
        this.t = true;
        this.u = false;
        q<? super PackageItem, ? super Integer, ? super FilterItem, u> qVar = this.f9895k;
        if (qVar != null) {
            qVar.invoke(FilterConstants.a.k(), -1, null);
        }
        FilterPackageAdapter filterPackageAdapter = this.b;
        if (filterPackageAdapter != null && (e3 = filterPackageAdapter.e()) != null) {
            W(e3);
        }
        FilterPackageAdapter filterPackageAdapter2 = this.c;
        if (filterPackageAdapter2 != null && (e2 = filterPackageAdapter2.e()) != null) {
            W(e2);
        }
        FilterPackageAdapter filterPackageAdapter3 = s.c(this.f9892h, "type_collect") ? this.c : this.b;
        if (filterPackageAdapter3 == null || (j2 = filterPackageAdapter3.j()) == -1) {
            return;
        }
        filterPackageAdapter3.v(-1);
        filterPackageAdapter3.notifyItemChanged(j2 + 1);
    }

    public final void P() {
        ScrollCenterLayoutManager scrollCenterLayoutManager;
        if (this.b == null || (scrollCenterLayoutManager = this.f9888d) == null) {
            return;
        }
        scrollCenterLayoutManager.scrollToPosition(0);
    }

    public final void Q() {
        ScrollCenterLayoutManager scrollCenterLayoutManager;
        FilterPackageAdapter filterPackageAdapter = this.b;
        if (filterPackageAdapter == null || (scrollCenterLayoutManager = this.f9888d) == null) {
            return;
        }
        scrollCenterLayoutManager.scrollToPosition(filterPackageAdapter.getItemCount() - 1);
    }

    public final void R(int i2) {
        FilterPackageAdapter filterPackageAdapter = this.c;
        if (filterPackageAdapter == null || i2 == 0) {
            return;
        }
        if (i2 != 1) {
            int i3 = this.f9891g;
            if (i3 == -1) {
                return;
            }
            if (i3 == i2) {
                filterPackageAdapter.k(0);
                return;
            } else {
                filterPackageAdapter.k(i3);
                return;
            }
        }
        filterPackageAdapter.k(0);
    }

    public final void S(List<PackageItem> filterList) {
        l<? super Boolean, u> lVar;
        s.h(filterList, "filterList");
        l("type_collect");
        FilterPackageAdapter filterPackageAdapter = this.c;
        boolean z = true;
        if (filterPackageAdapter == null) {
            FilterPackageAdapter filterPackageAdapter2 = new FilterPackageAdapter();
            filterPackageAdapter2.o(1);
            filterPackageAdapter2.r(this.r);
            filterPackageAdapter2.t(this.m);
            filterPackageAdapter2.w(filterList);
            if (this.f9890f) {
                i(filterPackageAdapter2);
            }
            this.c = filterPackageAdapter2;
            ScrollCenterLayoutManager scrollCenterLayoutManager = new ScrollCenterLayoutManager(getContext(), 0, false);
            int i2 = R.id.filterCollectRecyclerView;
            ((RecyclerView) a(i2)).setAdapter(filterPackageAdapter2);
            ((RecyclerView) a(i2)).setLayoutManager(scrollCenterLayoutManager);
            RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) a(i2)).getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            if (this.r) {
                ((RecyclerView) a(i2)).addItemDecoration(new k());
            }
            this.f9889e = scrollCenterLayoutManager;
            filterPackageAdapter2.u(new FilterPackageListView$updateCollectList$1(this));
            X();
            return;
        }
        filterPackageAdapter.w(filterList);
        filterPackageAdapter.notifyDataSetChanged();
        if (filterPackageAdapter.j() == -1) {
            l<? super Boolean, u> lVar2 = this.p;
            if (lVar2 == null) {
                return;
            }
            lVar2.invoke(Boolean.FALSE);
            return;
        }
        ScrollCenterLayoutManager scrollCenterLayoutManager2 = this.f9889e;
        int findFirstVisibleItemPosition = scrollCenterLayoutManager2 == null ? 0 : scrollCenterLayoutManager2.findFirstVisibleItemPosition();
        ScrollCenterLayoutManager scrollCenterLayoutManager3 = this.f9889e;
        int findLastVisibleItemPosition = scrollCenterLayoutManager3 == null ? 0 : scrollCenterLayoutManager3.findLastVisibleItemPosition();
        int j2 = filterPackageAdapter.j();
        if (!((findFirstVisibleItemPosition > j2 || j2 > findLastVisibleItemPosition) ? false : false) || (lVar = this.p) == null) {
            return;
        }
        lVar.invoke(Boolean.TRUE);
    }

    public final void T(PackageItem packageItem) {
        s.h(packageItem, "packageItem");
        FilterPackageAdapter filterPackageAdapter = this.b;
        if (filterPackageAdapter == null) {
            return;
        }
        ArrayList<PackageItem> h2 = filterPackageAdapter.h();
        ArrayList<PackageItem> arrayList = new ArrayList();
        for (Object obj : h2) {
            if (s.c(((PackageItem) obj).getPackageId(), packageItem.getPackageId())) {
                arrayList.add(obj);
            }
        }
        for (PackageItem packageItem2 : arrayList) {
            packageItem2.setDownloadProgress(packageItem.getDownloadProgress());
            if (packageItem.getDownloadProgress() == 100) {
                packageItem2.setDownloaded(true);
            }
            int indexOf = filterPackageAdapter.h().indexOf(packageItem2);
            if (this.f9890f) {
                indexOf++;
            }
            filterPackageAdapter.notifyItemChanged(indexOf);
        }
    }

    public final void U(List<PackageItem> filterList) {
        l<? super Boolean, u> lVar;
        s.h(filterList, "filterList");
        l("type_normal");
        FilterPackageAdapter filterPackageAdapter = this.b;
        boolean z = false;
        if (filterPackageAdapter == null) {
            FilterPackageAdapter filterPackageAdapter2 = new FilterPackageAdapter();
            filterPackageAdapter2.o(0);
            filterPackageAdapter2.r(this.r);
            filterPackageAdapter2.t(this.m);
            filterPackageAdapter2.w(filterList);
            if (this.f9890f) {
                i(filterPackageAdapter2);
            }
            this.b = filterPackageAdapter2;
            ScrollCenterLayoutManager scrollCenterLayoutManager = new ScrollCenterLayoutManager(getContext(), 0, false);
            int i2 = R.id.filterPackageRecyclerView;
            ((RecyclerView) a(i2)).setAdapter(filterPackageAdapter2);
            ((RecyclerView) a(i2)).setLayoutManager(scrollCenterLayoutManager);
            RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) a(i2)).getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            if (this.r) {
                ((RecyclerView) a(i2)).addItemDecoration(new k());
            }
            this.f9888d = scrollCenterLayoutManager;
            filterPackageAdapter2.u(new FilterPackageListView$updateList$1(this));
            Y();
            return;
        }
        filterPackageAdapter.w(filterList);
        filterPackageAdapter.notifyDataSetChanged();
        if (filterPackageAdapter.j() == -1) {
            l<? super Boolean, u> lVar2 = this.p;
            if (lVar2 == null) {
                return;
            }
            lVar2.invoke(Boolean.FALSE);
            return;
        }
        ScrollCenterLayoutManager scrollCenterLayoutManager2 = this.f9888d;
        int findFirstVisibleItemPosition = scrollCenterLayoutManager2 == null ? 0 : scrollCenterLayoutManager2.findFirstVisibleItemPosition();
        ScrollCenterLayoutManager scrollCenterLayoutManager3 = this.f9888d;
        int findLastVisibleItemPosition = scrollCenterLayoutManager3 == null ? 0 : scrollCenterLayoutManager3.findLastVisibleItemPosition();
        int j2 = filterPackageAdapter.j();
        if (findFirstVisibleItemPosition <= j2 && j2 <= findLastVisibleItemPosition) {
            z = true;
        }
        if (!z || (lVar = this.p) == null) {
            return;
        }
        lVar.invoke(Boolean.TRUE);
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

    public final void l(String type) {
        s.h(type, "type");
        this.f9892h = type;
        boolean c = s.c(type, "type_normal");
        RecyclerView filterPackageRecyclerView = (RecyclerView) a(R.id.filterPackageRecyclerView);
        s.g(filterPackageRecyclerView, "filterPackageRecyclerView");
        int i2 = c ? 0 : 8;
        filterPackageRecyclerView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(filterPackageRecyclerView, i2);
        RecyclerView filterCollectRecyclerView = (RecyclerView) a(R.id.filterCollectRecyclerView);
        s.g(filterCollectRecyclerView, "filterCollectRecyclerView");
        int i3 = c ^ true ? 0 : 8;
        filterCollectRecyclerView.setVisibility(i3);
        VdsAgent.onSetViewVisibility(filterCollectRecyclerView, i3);
    }

    public final void m() {
        FilterPackageAdapter filterPackageAdapter = this.c;
        if (filterPackageAdapter == null) {
            return;
        }
        this.f9891g = filterPackageAdapter.j();
        filterPackageAdapter.v(-1);
    }

    public final void o() {
        int i2 = !this.r ? 1 : 0;
        FilterPackageAdapter filterPackageAdapter = this.b;
        if (filterPackageAdapter != null) {
            filterPackageAdapter.v(-1);
            n();
            filterPackageAdapter.notifyItemRangeChanged(i2, filterPackageAdapter.getItemCount());
        }
        FilterPackageAdapter filterPackageAdapter2 = this.c;
        if (filterPackageAdapter2 == null) {
            return;
        }
        filterPackageAdapter2.v(-1);
        n();
        filterPackageAdapter2.notifyItemRangeChanged(i2, filterPackageAdapter2.getItemCount());
    }

    public final void p(boolean z) {
        this.f9890f = z;
    }

    public final void q(boolean z) {
        FilterPackageAdapter filterPackageAdapter = this.c;
        if (filterPackageAdapter != null) {
            filterPackageAdapter.q(z);
        }
        FilterPackageAdapter filterPackageAdapter2 = this.c;
        if (filterPackageAdapter2 != null) {
            filterPackageAdapter2.notifyDataSetChanged();
        }
        FilterPackageAdapter filterPackageAdapter3 = this.b;
        if (filterPackageAdapter3 != null) {
            filterPackageAdapter3.q(z);
        }
        FilterPackageAdapter filterPackageAdapter4 = this.b;
        if (filterPackageAdapter4 == null) {
            return;
        }
        filterPackageAdapter4.notifyDataSetChanged();
    }

    public final PackageItem r() {
        FilterPackageAdapter filterPackageAdapter = this.c;
        if (filterPackageAdapter == null || filterPackageAdapter.j() == -1) {
            return null;
        }
        return filterPackageAdapter.h().get(filterPackageAdapter.j());
    }

    public final View s() {
        View view;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) a(R.id.filterPackageRecyclerView)).findViewHolderForAdapterPosition(t());
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return null;
        }
        return view.findViewById(R.id.album);
    }

    public final void setDark(boolean z) {
        View e2;
        View e3;
        if (z != this.s) {
            this.s = z;
            FilterPackageAdapter filterPackageAdapter = this.b;
            if (filterPackageAdapter != null) {
                filterPackageAdapter.n(z);
            }
            FilterPackageAdapter filterPackageAdapter2 = this.c;
            if (filterPackageAdapter2 != null) {
                filterPackageAdapter2.n(z);
            }
            FilterPackageAdapter filterPackageAdapter3 = this.c;
            if (filterPackageAdapter3 != null && (e3 = filterPackageAdapter3.e()) != null) {
                M(e3);
            }
            FilterPackageAdapter filterPackageAdapter4 = this.b;
            if (filterPackageAdapter4 != null && (e2 = filterPackageAdapter4.e()) != null) {
                M(e2);
            }
            if (z) {
                setBackgroundColor(-1);
            } else {
                setBackgroundColor(Color.parseColor("#7F000000"));
            }
        }
    }

    public final void setFilterItemHiddenByPackageVisible(boolean z) {
        this.o = z;
    }

    public final void setFocusPackageChanged(l<? super PackageItem, u> lVar) {
        this.f9894j = lVar;
    }

    public final void setFromEdit(boolean z) {
        this.r = z;
    }

    public final void setOnFilterPackageCollectStatusChange(p<? super PackageItem, ? super Boolean, u> pVar) {
        this.m = pVar;
    }

    public final void setOnPackageClick(q<? super PackageItem, ? super Integer, ? super FilterItem, u> qVar) {
        this.f9895k = qVar;
    }

    public final void setOnPackageReClick(p<? super PackageItem, ? super Integer, u> pVar) {
        this.f9896l = pVar;
    }

    public final void setOnPackageVisibleChanged(l<? super Boolean, u> lVar) {
        this.p = lVar;
    }

    public final void setSeekbarHiddenByPackageVisible(boolean z) {
        this.n = z;
    }

    public final void setSelectAuto(boolean z) {
        this.u = z;
    }

    public final void setSelectNone(boolean z) {
        this.t = z;
    }

    public final void setUserVisible(boolean z) {
        this.q = z;
    }

    public final int t() {
        FilterPackageAdapter filterPackageAdapter = this.b;
        if (filterPackageAdapter == null) {
            return -1;
        }
        boolean z = this.r;
        int j2 = filterPackageAdapter.j();
        return z ? j2 : j2 + 1;
    }

    public final PackageItem u() {
        FilterPackageAdapter filterPackageAdapter = this.b;
        if (filterPackageAdapter == null || filterPackageAdapter.j() == -1) {
            return null;
        }
        return filterPackageAdapter.h().get(filterPackageAdapter.j());
    }

    public final boolean v() {
        return this.o;
    }

    public final PackageItem w() {
        ArrayList<PackageItem> h2;
        FilterPackageAdapter filterPackageAdapter = this.b;
        if (filterPackageAdapter == null || (h2 = filterPackageAdapter.h()) == null) {
            return null;
        }
        return (PackageItem) kotlin.collections.s.D(h2, 0);
    }

    public final l<PackageItem, u> x() {
        return this.f9894j;
    }

    public final l<Boolean, u> y() {
        return this.p;
    }

    public final boolean z() {
        return this.n;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPackageListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.f9890f = true;
        this.f9891g = -1;
        this.f9892h = "type_normal";
        this.q = true;
        View.inflate(getContext(), R.layout.filter_package_view_layout, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPackageListView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.f9890f = true;
        this.f9891g = -1;
        this.f9892h = "type_normal";
        this.q = true;
        View.inflate(getContext(), R.layout.filter_package_view_layout, this);
    }
}
