package us.pinguo.common.filter.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.z0;
import us.pinguo.common.filter.FilterItemAdapter;
import us.pinguo.common.widget.ScrollCenterLayoutManager;
import us.pinguo.commonui.R;
import us.pinguo.foundation.utils.n0;
import us.pinguo.repository2020.entity.FilterItem;
/* compiled from: FilterPanelItemView.kt */
/* loaded from: classes4.dex */
public final class FilterPanelItemView extends LinearLayout {
    public Map<Integer, View> a;
    private FilterItemAdapter b;
    private ScrollCenterLayoutManager c;

    /* renamed from: d  reason: collision with root package name */
    private p<? super FilterItem, ? super Integer, u> f9897d;

    /* renamed from: e  reason: collision with root package name */
    private p<? super FilterItem, ? super Integer, u> f9898e;

    /* renamed from: f  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f9899f;

    /* renamed from: g  reason: collision with root package name */
    private p<? super Boolean, ? super FilterItem, u> f9900g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9901h;

    /* renamed from: i  reason: collision with root package name */
    private final a f9902i;

    /* compiled from: FilterPanelItemView.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            s.h(outRect, "outRect");
            s.h(view, "view");
            s.h(parent, "parent");
            s.h(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            Integer valueOf = adapter == null ? null : Integer.valueOf(adapter.getItemCount());
            if (valueOf == null) {
                return;
            }
            int intValue = valueOf.intValue();
            Context b = us.pinguo.foundation.e.b();
            s.g(b, "getAppContext()");
            int width = (parent.getWidth() / 2) - us.pinguo.util.g.a(b, 16.0f);
            Context b2 = us.pinguo.foundation.e.b();
            s.g(b2, "getAppContext()");
            int a = us.pinguo.util.g.a(b2, 12.0f);
            if (childAdapterPosition == 0) {
                outRect.left = width;
                outRect.right = a;
            } else if (childAdapterPosition == intValue - 1) {
                outRect.right = width;
            } else {
                outRect.right = a;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelItemView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.filter_panel_item_view_layout, this);
        if (this.f9901h) {
            setBackgroundColor(-1);
            ((AppCompatImageView) a(R.id.iconFilterStore)).setImageResource(R.drawable.icon_filter_panel_store_white);
        } else {
            setBackground(null);
            ((AppCompatImageView) a(R.id.iconFilterStore)).setImageResource(R.drawable.icon_filter_panel_store_white_light);
        }
        ((AppCompatImageView) a(R.id.iconFilterStore)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.filter.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterPanelItemView.b(FilterPanelItemView.this, view);
            }
        });
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 10);
        int i2 = R.id.filterItemRecyclerView;
        ((RecyclerView) a(i2)).setRecycledViewPool(recycledViewPool);
        RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) a(i2)).getItemAnimator();
        Objects.requireNonNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.DefaultItemAnimator");
        ((DefaultItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        this.f9902i = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FilterPanelItemView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        kotlin.jvm.b.a<u> aVar = this$0.f9899f;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FilterPanelItemView this$0, ScrollCenterLayoutManager layoutManager, Ref$ObjectRef itemPosition) {
        s.h(this$0, "this$0");
        s.h(layoutManager, "$layoutManager");
        s.h(itemPosition, "$itemPosition");
        int i2 = (n0.i() / 2) - ((RecyclerView) this$0.a(R.id.filterItemRecyclerView)).getLeft();
        layoutManager.scrollToPositionWithOffset(((Number) itemPosition.element).intValue(), i2 - (this$0.getContext().getResources().getDimensionPixelSize(R.dimen.filter_item_width) / 2));
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

    public final void c() {
        FilterItemAdapter filterItemAdapter = this.b;
        if (filterItemAdapter == null) {
            return;
        }
        filterItemAdapter.p(-1);
    }

    public final FilterItem d() {
        FilterItemAdapter filterItemAdapter = this.b;
        if (filterItemAdapter == null || filterItemAdapter.i() == -1) {
            return null;
        }
        return filterItemAdapter.e().get(filterItemAdapter.i());
    }

    public final int e() {
        FilterItemAdapter filterItemAdapter = this.b;
        if (filterItemAdapter == null) {
            return 0;
        }
        return filterItemAdapter.i();
    }

    public final FilterItemAdapter f() {
        return this.b;
    }

    public final boolean g() {
        ArrayList<FilterItem> e2;
        FilterItemAdapter filterItemAdapter = this.b;
        return (filterItemAdapter == null || (e2 = filterItemAdapter.e()) == null || e2.size() != 1) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [T, java.lang.Integer] */
    public final void j(FilterItem filterItem, Integer num) {
        s.h(filterItem, "filterItem");
        FilterItemAdapter filterItemAdapter = this.b;
        if (filterItemAdapter == null) {
            return;
        }
        int i2 = R.id.filterItemRecyclerView;
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) a(i2)).getLayoutManager();
        final ScrollCenterLayoutManager scrollCenterLayoutManager = layoutManager instanceof ScrollCenterLayoutManager ? (ScrollCenterLayoutManager) layoutManager : null;
        if (scrollCenterLayoutManager == null) {
            return;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = num;
        if (num == 0) {
            ref$ObjectRef.element = Integer.valueOf(filterItemAdapter.h(filterItem));
        }
        Integer num2 = (Integer) ref$ObjectRef.element;
        int i3 = filterItemAdapter.i();
        if (num2 != null && num2.intValue() == i3) {
            p<? super FilterItem, ? super Integer, u> pVar = this.f9898e;
            if (pVar == null) {
                return;
            }
            pVar.invoke(filterItem, ref$ObjectRef.element);
            return;
        }
        p<? super FilterItem, ? super Integer, u> pVar2 = this.f9897d;
        if (pVar2 != null) {
            pVar2.invoke(filterItem, ref$ObjectRef.element);
        }
        int i4 = filterItemAdapter.i();
        filterItemAdapter.p(((Number) ref$ObjectRef.element).intValue());
        if (i4 > -1) {
            filterItemAdapter.notifyItemChanged(i4);
        }
        filterItemAdapter.notifyItemChanged(((Number) ref$ObjectRef.element).intValue());
        if (num != 0) {
            l.d(kotlinx.coroutines.n0.a(z0.c()), null, null, new FilterPanelItemView$onFilterItemClick$2(scrollCenterLayoutManager, this, ref$ObjectRef, null), 3, null);
            return;
        }
        RecyclerView filterItemRecyclerView = (RecyclerView) a(i2);
        s.g(filterItemRecyclerView, "filterItemRecyclerView");
        us.pinguo.foundation.ui.c.b(filterItemRecyclerView, new Runnable() { // from class: us.pinguo.common.filter.view.d
            @Override // java.lang.Runnable
            public final void run() {
                FilterPanelItemView.k(FilterPanelItemView.this, scrollCenterLayoutManager, ref$ObjectRef);
            }
        });
    }

    public final void l(int i2, List<FilterItem> filterList, int i3, boolean z) {
        ScrollCenterLayoutManager scrollCenterLayoutManager;
        ScrollCenterLayoutManager scrollCenterLayoutManager2;
        s.h(filterList, "filterList");
        FilterItemAdapter filterItemAdapter = this.b;
        if (filterItemAdapter == null) {
            FilterItemAdapter filterItemAdapter2 = new FilterItemAdapter();
            filterItemAdapter2.q(filterList);
            filterItemAdapter2.m(i2);
            filterItemAdapter2.n(this.f9900g);
            filterItemAdapter2.p(i3);
            filterItemAdapter2.l(this.f9901h);
            this.b = filterItemAdapter2;
            ScrollCenterLayoutManager scrollCenterLayoutManager3 = new ScrollCenterLayoutManager(getContext(), 0, false);
            int i4 = R.id.filterItemRecyclerView;
            ((RecyclerView) a(i4)).setAdapter(filterItemAdapter2);
            ((RecyclerView) a(i4)).setLayoutManager(scrollCenterLayoutManager3);
            ((RecyclerView) a(i4)).addItemDecoration(this.f9902i);
            ((RecyclerView) a(i4)).setEdgeEffectFactory(new us.pinguo.common.a());
            this.c = scrollCenterLayoutManager3;
            filterItemAdapter2.o(new FilterPanelItemView$updateList$1(this));
            if (!z || (scrollCenterLayoutManager2 = this.c) == null) {
                return;
            }
            scrollCenterLayoutManager2.scrollToPosition(i3);
            return;
        }
        filterItemAdapter.q(filterList);
        filterItemAdapter.m(i2);
        filterItemAdapter.p(i3);
        filterItemAdapter.notifyDataSetChanged();
        if (!z || (scrollCenterLayoutManager = this.c) == null) {
            return;
        }
        scrollCenterLayoutManager.scrollToPosition(i3);
    }

    public final void setDark(boolean z) {
        if (z != this.f9901h) {
            this.f9901h = z;
            FilterItemAdapter filterItemAdapter = this.b;
            if (filterItemAdapter != null) {
                filterItemAdapter.l(z);
            }
            if (z) {
                setBackgroundColor(-1);
                ((AppCompatImageView) a(R.id.iconFilterStore)).setImageResource(R.drawable.icon_filter_panel_store_white);
                return;
            }
            setBackground(null);
            ((AppCompatImageView) a(R.id.iconFilterStore)).setImageResource(R.drawable.icon_filter_panel_store_white_light);
        }
    }

    public final void setGotoStore(kotlin.jvm.b.a<u> aVar) {
        this.f9899f = aVar;
    }

    public final void setOnFilterClick(p<? super FilterItem, ? super Integer, u> pVar) {
        this.f9897d = pVar;
    }

    public final void setOnFilterCollectStatusChangeListener(p<? super Boolean, ? super FilterItem, u> pVar) {
        this.f9900g = pVar;
    }

    public final void setOnFilterReClick(p<? super FilterItem, ? super Integer, u> pVar) {
        this.f9898e = pVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.filter_panel_item_view_layout, this);
        if (this.f9901h) {
            setBackgroundColor(-1);
            ((AppCompatImageView) a(R.id.iconFilterStore)).setImageResource(R.drawable.icon_filter_panel_store_white);
        } else {
            setBackground(null);
            ((AppCompatImageView) a(R.id.iconFilterStore)).setImageResource(R.drawable.icon_filter_panel_store_white_light);
        }
        ((AppCompatImageView) a(R.id.iconFilterStore)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.filter.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterPanelItemView.b(FilterPanelItemView.this, view);
            }
        });
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 10);
        int i2 = R.id.filterItemRecyclerView;
        ((RecyclerView) a(i2)).setRecycledViewPool(recycledViewPool);
        RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) a(i2)).getItemAnimator();
        Objects.requireNonNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.DefaultItemAnimator");
        ((DefaultItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        this.f9902i = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelItemView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.filter_panel_item_view_layout, this);
        if (this.f9901h) {
            setBackgroundColor(-1);
            ((AppCompatImageView) a(R.id.iconFilterStore)).setImageResource(R.drawable.icon_filter_panel_store_white);
        } else {
            setBackground(null);
            ((AppCompatImageView) a(R.id.iconFilterStore)).setImageResource(R.drawable.icon_filter_panel_store_white_light);
        }
        ((AppCompatImageView) a(R.id.iconFilterStore)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.filter.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterPanelItemView.b(FilterPanelItemView.this, view);
            }
        });
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 10);
        int i3 = R.id.filterItemRecyclerView;
        ((RecyclerView) a(i3)).setRecycledViewPool(recycledViewPool);
        RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) a(i3)).getItemAnimator();
        Objects.requireNonNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.DefaultItemAnimator");
        ((DefaultItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        this.f9902i = new a();
    }
}
