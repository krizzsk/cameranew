package us.pinguo.common.filter.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.widget.ScrollCenterLayoutManager;
import us.pinguo.commonui.R;
import us.pinguo.repository2020.entity.CategoryItem;
import us.pinguo.repository2020.manager.FilterRedPointManager;
/* compiled from: FilterPanelTabView.kt */
/* loaded from: classes4.dex */
public final class FilterPanelTabView extends LinearLayout {
    public Map<Integer, View> a;
    private CategoryItem b;
    private us.pinguo.common.filter.b c;

    /* renamed from: d  reason: collision with root package name */
    private ScrollCenterLayoutManager f9903d;

    /* renamed from: e  reason: collision with root package name */
    private p<? super CategoryItem, ? super Boolean, u> f9904e;

    /* renamed from: f  reason: collision with root package name */
    private l<? super CategoryItem, Boolean> f9905f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9906g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelTabView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.filter_panel_tab_layout, this);
    }

    public static /* synthetic */ void f(FilterPanelTabView filterPanelTabView, CategoryItem categoryItem, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        filterPanelTabView.e(categoryItem, num);
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

    public final CategoryItem b() {
        return this.b;
    }

    public final String c() {
        CategoryItem categoryItem;
        String categoryId;
        us.pinguo.common.filter.b bVar = this.c;
        return (bVar == null || (categoryItem = (CategoryItem) kotlin.collections.s.D(bVar.e(), bVar.g())) == null || (categoryId = categoryItem.getCategoryId()) == null) ? "category_collect" : categoryId;
    }

    public final int d(String str) {
        us.pinguo.common.filter.b bVar;
        int i2 = 0;
        if (str == null || (bVar = this.c) == null) {
            return 0;
        }
        for (CategoryItem categoryItem : bVar.e()) {
            if (s.c(categoryItem.getCategoryId(), str)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final void e(CategoryItem categoryItem, Integer num) {
        s.h(categoryItem, "categoryItem");
        us.pinguo.common.filter.b bVar = this.c;
        if (bVar == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) a(R.id.tabRecyclerView)).getLayoutManager();
        ScrollCenterLayoutManager scrollCenterLayoutManager = layoutManager instanceof ScrollCenterLayoutManager ? (ScrollCenterLayoutManager) layoutManager : null;
        if (scrollCenterLayoutManager == null) {
            return;
        }
        Integer valueOf = num == null ? Integer.valueOf(bVar.f(categoryItem)) : num;
        l<? super CategoryItem, Boolean> lVar = this.f9905f;
        boolean z = false;
        if (lVar != null && lVar.invoke(categoryItem).booleanValue()) {
            z = true;
        }
        if (z) {
            return;
        }
        bVar.n(valueOf.intValue());
        bVar.notifyDataSetChanged();
        if (num == null) {
            Context context = getContext();
            s.g(context, "context");
            scrollCenterLayoutManager.a(context, valueOf.intValue(), 1.0f);
            p<? super CategoryItem, ? super Boolean, u> pVar = this.f9904e;
            if (pVar != null) {
                pVar.invoke(categoryItem, Boolean.FALSE);
            }
        } else {
            Context context2 = getContext();
            s.g(context2, "context");
            scrollCenterLayoutManager.a(context2, valueOf.intValue(), 100.0f);
            p<? super CategoryItem, ? super Boolean, u> pVar2 = this.f9904e;
            if (pVar2 != null) {
                pVar2.invoke(categoryItem, Boolean.FALSE);
            }
        }
        this.b = categoryItem;
        FilterRedPointManager.a.k(categoryItem.getCategoryId());
    }

    public final void g(List<CategoryItem> tabList) {
        s.h(tabList, "tabList");
        us.pinguo.common.filter.b bVar = this.c;
        if (bVar == null) {
            us.pinguo.common.filter.b bVar2 = new us.pinguo.common.filter.b();
            this.c = bVar2;
            bVar2.o(tabList);
            ScrollCenterLayoutManager scrollCenterLayoutManager = new ScrollCenterLayoutManager(getContext(), 0, false);
            int i2 = R.id.tabRecyclerView;
            ((RecyclerView) a(i2)).setAdapter(bVar2);
            ((RecyclerView) a(i2)).setLayoutManager(scrollCenterLayoutManager);
            this.f9903d = scrollCenterLayoutManager;
            bVar2.m(new FilterPanelTabView$updateList$1(this));
            return;
        }
        bVar.o(tabList);
        bVar.notifyDataSetChanged();
    }

    public final void h(String categoryId) {
        s.h(categoryId, "categoryId");
        us.pinguo.common.filter.b bVar = this.c;
        if (bVar == null) {
            return;
        }
        CategoryItem categoryItem = bVar.e().get(bVar.g());
        s.g(categoryItem, "it.categoryTabsList[it.selectedPosition]");
        CategoryItem categoryItem2 = categoryItem;
        setCurrentCategoryItem(categoryItem2);
        if (s.c(categoryItem2.getCategoryId(), categoryId)) {
            return;
        }
        int i2 = 0;
        Iterator<CategoryItem> it = bVar.e().iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (s.c(it.next().getCategoryId(), categoryId)) {
                break;
            } else {
                i2++;
            }
        }
        bVar.n(i2);
        bVar.notifyDataSetChanged();
        ScrollCenterLayoutManager scrollCenterLayoutManager = this.f9903d;
        if (scrollCenterLayoutManager != null) {
            Context context = getContext();
            s.g(context, "context");
            scrollCenterLayoutManager.a(context, i2, 200.0f);
        }
        FilterRedPointManager.a.k(categoryId);
    }

    public final void setCurrentCategoryItem(CategoryItem categoryItem) {
        this.b = categoryItem;
    }

    public final void setDark(boolean z) {
        if (z != this.f9906g) {
            this.f9906g = z;
            us.pinguo.common.filter.b bVar = this.c;
            if (bVar != null) {
                bVar.l(z);
            }
            if (z) {
                setBackgroundColor(-1);
            } else {
                setBackgroundColor(Color.parseColor("#7F000000"));
            }
        }
    }

    public final void setInterceptClickEvent(l<? super CategoryItem, Boolean> lVar) {
        this.f9905f = lVar;
    }

    public final void setOnCategoryClick(p<? super CategoryItem, ? super Boolean, u> pVar) {
        this.f9904e = pVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.filter_panel_tab_layout, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelTabView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.filter_panel_tab_layout, this);
    }
}
