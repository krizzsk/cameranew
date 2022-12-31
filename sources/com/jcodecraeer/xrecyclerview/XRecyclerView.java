package com.jcodecraeer.xrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.material.appbar.AppBarLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.jcodecraeer.xrecyclerview.AppBarStateChangeListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class XRecyclerView extends RecyclerView {
    private static List<Integer> u = new ArrayList();
    private boolean a;
    private boolean b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f5804d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<View> f5805e;

    /* renamed from: f  reason: collision with root package name */
    private f f5806f;

    /* renamed from: g  reason: collision with root package name */
    private float f5807g;

    /* renamed from: h  reason: collision with root package name */
    private float f5808h;

    /* renamed from: i  reason: collision with root package name */
    private com.jcodecraeer.xrecyclerview.a f5809i;

    /* renamed from: j  reason: collision with root package name */
    private d f5810j;

    /* renamed from: k  reason: collision with root package name */
    private ArrowRefreshHeader f5811k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5812l;
    private boolean m;
    private View n;
    private View o;
    private final RecyclerView.AdapterDataObserver p;
    private AppBarStateChangeListener.State q;
    private int r;
    private int s;
    private e t;

    /* loaded from: classes2.dex */
    class a extends GridLayoutManager.SpanSizeLookup {
        final /* synthetic */ GridLayoutManager a;

        a(GridLayoutManager gridLayoutManager) {
            this.a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            if (XRecyclerView.this.f5806f.h(i2) || XRecyclerView.this.f5806f.g(i2) || XRecyclerView.this.f5806f.i(i2)) {
                return this.a.getSpanCount();
            }
            return 1;
        }
    }

    /* loaded from: classes2.dex */
    class b extends AppBarStateChangeListener {
        b() {
        }

        @Override // com.jcodecraeer.xrecyclerview.AppBarStateChangeListener
        public void b(AppBarLayout appBarLayout, AppBarStateChangeListener.State state) {
            XRecyclerView.this.q = state;
        }
    }

    /* loaded from: classes2.dex */
    private class c extends RecyclerView.AdapterDataObserver {
        private c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (XRecyclerView.this.f5806f != null) {
                XRecyclerView.this.f5806f.notifyDataSetChanged();
            }
            if (XRecyclerView.this.f5806f == null || XRecyclerView.this.n == null) {
                return;
            }
            int e2 = XRecyclerView.this.f5806f.e() + 1;
            if (XRecyclerView.this.m) {
                e2++;
            }
            if (XRecyclerView.this.f5806f.getItemCount() == e2) {
                View view = XRecyclerView.this.n;
                view.setVisibility(0);
                VdsAgent.onSetViewVisibility(view, 0);
                XRecyclerView xRecyclerView = XRecyclerView.this;
                xRecyclerView.setVisibility(8);
                VdsAgent.onSetViewVisibility(xRecyclerView, 8);
                return;
            }
            View view2 = XRecyclerView.this.n;
            view2.setVisibility(8);
            VdsAgent.onSetViewVisibility(view2, 8);
            XRecyclerView xRecyclerView2 = XRecyclerView.this;
            xRecyclerView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(xRecyclerView2, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3) {
            XRecyclerView.this.f5806f.notifyItemRangeChanged(i2, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            XRecyclerView.this.f5806f.notifyItemRangeInserted(i2, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            XRecyclerView.this.f5806f.notifyItemMoved(i2, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            XRecyclerView.this.f5806f.notifyItemRangeRemoved(i2, i3);
        }

        /* synthetic */ c(XRecyclerView xRecyclerView, a aVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3, Object obj) {
            XRecyclerView.this.f5806f.notifyItemRangeChanged(i2, i3, obj);
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onLoadMore();

        void onRefresh();
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(int i2);

        int b();
    }

    public XRecyclerView(Context context) {
        this(context, null);
    }

    private void init() {
        if (this.f5812l) {
            ArrowRefreshHeader arrowRefreshHeader = new ArrowRefreshHeader(getContext());
            this.f5811k = arrowRefreshHeader;
            arrowRefreshHeader.setProgressStyle(this.c);
        }
        LoadingMoreFooter loadingMoreFooter = new LoadingMoreFooter(getContext());
        loadingMoreFooter.setProgressStyle(this.f5804d);
        this.o = loadingMoreFooter;
        loadingMoreFooter.setVisibility(8);
        VdsAgent.onSetViewVisibility(loadingMoreFooter, 8);
    }

    private int m(int[] iArr) {
        int i2 = iArr[0];
        for (int i3 : iArr) {
            if (i3 > i2) {
                i2 = i3;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View n(int i2) {
        ArrayList<View> arrayList;
        if (p(i2) && (arrayList = this.f5805e) != null) {
            return arrayList.get(i2 - 10002);
        }
        return null;
    }

    private int o() {
        f fVar = this.f5806f;
        if (fVar == null) {
            return 0;
        }
        return fVar.e() + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(int i2) {
        ArrayList<View> arrayList = this.f5805e;
        return arrayList != null && u != null && arrayList.size() > 0 && u.contains(Integer.valueOf(i2));
    }

    private boolean q() {
        ArrowRefreshHeader arrowRefreshHeader = this.f5811k;
        return (arrowRefreshHeader == null || arrowRefreshHeader.getParent() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(int i2) {
        return i2 == 10000 || i2 == 10001 || u.contains(Integer.valueOf(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public RecyclerView.Adapter getAdapter() {
        f fVar = this.f5806f;
        if (fVar != null) {
            return fVar.f();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        AppBarLayout appBarLayout;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (parent != null && !(parent instanceof CoordinatorLayout)) {
            parent = parent.getParent();
        }
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    appBarLayout = null;
                    break;
                }
                View childAt = coordinatorLayout.getChildAt(childCount);
                if (childAt instanceof AppBarLayout) {
                    appBarLayout = (AppBarLayout) childAt;
                    break;
                }
                childCount--;
            }
            if (appBarLayout != null) {
                appBarLayout.b(new b());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i2) {
        int findLastVisibleItemPosition;
        super.onScrollStateChanged(i2);
        if (i2 != 0 || this.f5810j == null || this.a || !this.m) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            findLastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
            findLastVisibleItemPosition = m(iArr);
        } else {
            findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        int itemCount = layoutManager.getItemCount() + o();
        ArrowRefreshHeader arrowRefreshHeader = this.f5811k;
        int c2 = arrowRefreshHeader != null ? arrowRefreshHeader.c() : 3;
        if (layoutManager.getChildCount() <= 0 || findLastVisibleItemPosition < itemCount - this.r || itemCount < layoutManager.getChildCount() || this.b || c2 >= 2) {
            return;
        }
        this.a = true;
        View view = this.o;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setState(0);
        } else {
            com.jcodecraeer.xrecyclerview.a aVar = this.f5809i;
            if (aVar != null) {
                aVar.a(view);
            }
        }
        this.f5810j.onLoadMore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i2, int i3) {
        super.onScrolled(i2, i3);
        e eVar = this.t;
        if (eVar == null) {
            return;
        }
        int b2 = eVar.b();
        int i4 = this.s + i3;
        this.s = i4;
        if (i4 <= 0) {
            this.t.a(0);
        } else if (i4 <= b2 && i4 > 0) {
            this.t.a((int) ((i4 / b2) * 255.0f));
        } else {
            this.t.a(255);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ArrowRefreshHeader arrowRefreshHeader;
        ArrowRefreshHeader arrowRefreshHeader2;
        d dVar;
        if (this.f5807g == -1.0f) {
            this.f5807g = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5807g = motionEvent.getRawY();
        } else if (action != 2) {
            this.f5807g = -1.0f;
            if (q() && this.f5812l && this.q == AppBarStateChangeListener.State.EXPANDED && (arrowRefreshHeader2 = this.f5811k) != null && arrowRefreshHeader2.g() && (dVar = this.f5810j) != null) {
                dVar.onRefresh();
            }
        } else {
            float rawY = motionEvent.getRawY() - this.f5807g;
            this.f5807g = motionEvent.getRawY();
            if (q() && this.f5812l && this.q == AppBarStateChangeListener.State.EXPANDED && (arrowRefreshHeader = this.f5811k) != null) {
                arrowRefreshHeader.f(rawY / this.f5808h);
                if (this.f5811k.d() > 0 && this.f5811k.c() < 2) {
                    return false;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i2) {
        super.scrollToPosition(i2);
        if (i2 == 0) {
            this.s = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        f fVar = new f(adapter);
        this.f5806f = fVar;
        super.setAdapter(fVar);
        adapter.registerAdapterDataObserver(this.p);
        this.p.onChanged();
    }

    public void setArrowImageView(int i2) {
        ArrowRefreshHeader arrowRefreshHeader = this.f5811k;
        if (arrowRefreshHeader != null) {
            arrowRefreshHeader.setArrowImageView(i2);
        }
    }

    public void setDragRate(float f2) {
        if (f2 <= 0.5d) {
            return;
        }
        this.f5808h = f2;
    }

    @Deprecated
    public void setEmptyView(View view) {
        this.n = view;
        this.p.onChanged();
    }

    public void setFootView(@NonNull View view, @NonNull com.jcodecraeer.xrecyclerview.a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        this.o = view;
        this.f5809i = aVar;
    }

    public void setFootViewText(String str, String str2) {
        View view = this.o;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setLoadingHint(str);
            ((LoadingMoreFooter) this.o).setNoMoreHint(str2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (this.f5806f == null || !(layoutManager instanceof GridLayoutManager)) {
            return;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        gridLayoutManager.setSpanSizeLookup(new a(gridLayoutManager));
    }

    public void setLimitNumberToCallLoadMore(int i2) {
        this.r = i2;
    }

    public void setLoadingListener(d dVar) {
        this.f5810j = dVar;
    }

    public void setLoadingMoreEnabled(boolean z) {
        this.m = z;
        if (z) {
            return;
        }
        View view = this.o;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setState(1);
        }
    }

    public void setLoadingMoreProgressStyle(int i2) {
        this.f5804d = i2;
        View view = this.o;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setProgressStyle(i2);
        }
    }

    public void setNoMore(boolean z) {
        this.a = false;
        this.b = z;
        View view = this.o;
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setState(z ? 2 : 1);
            return;
        }
        com.jcodecraeer.xrecyclerview.a aVar = this.f5809i;
        if (aVar != null) {
            aVar.b(view, z);
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.f5812l = z;
    }

    public void setRefreshHeader(ArrowRefreshHeader arrowRefreshHeader) {
        this.f5811k = arrowRefreshHeader;
    }

    public void setRefreshProgressStyle(int i2) {
        this.c = i2;
        ArrowRefreshHeader arrowRefreshHeader = this.f5811k;
        if (arrowRefreshHeader != null) {
            arrowRefreshHeader.setProgressStyle(i2);
        }
    }

    public void setRefreshTimeSpKeyName(String str) {
        ArrowRefreshHeader arrowRefreshHeader = this.f5811k;
        if (arrowRefreshHeader != null) {
            arrowRefreshHeader.setXrRefreshTimeKey(str);
        }
    }

    public void setScrollAlphaChangeListener(e eVar) {
        this.t = eVar;
    }

    public XRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = false;
        this.b = false;
        this.c = -1;
        this.f5804d = -1;
        this.f5805e = new ArrayList<>();
        this.f5807g = -1.0f;
        this.f5808h = 3.0f;
        this.f5812l = true;
        this.m = true;
        this.p = new c(this, null);
        this.q = AppBarStateChangeListener.State.EXPANDED;
        this.r = 1;
        this.s = 0;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private RecyclerView.Adapter a;

        /* loaded from: classes2.dex */
        class a extends GridLayoutManager.SpanSizeLookup {
            final /* synthetic */ GridLayoutManager a;

            a(GridLayoutManager gridLayoutManager) {
                this.a = gridLayoutManager;
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i2) {
                if (f.this.h(i2) || f.this.g(i2) || f.this.i(i2)) {
                    return this.a.getSpanCount();
                }
                return 1;
            }
        }

        /* loaded from: classes2.dex */
        private class b extends RecyclerView.ViewHolder {
            public b(f fVar, View view) {
                super(view);
            }
        }

        public f(RecyclerView.Adapter adapter) {
            this.a = adapter;
        }

        public int e() {
            if (XRecyclerView.this.f5805e == null) {
                return 0;
            }
            return XRecyclerView.this.f5805e.size();
        }

        public RecyclerView.Adapter f() {
            return this.a;
        }

        public boolean g(int i2) {
            return XRecyclerView.this.m && i2 == getItemCount() - 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int e2;
            int i2 = XRecyclerView.this.m ? 2 : 1;
            if (this.a != null) {
                e2 = e() + this.a.getItemCount();
            } else {
                e2 = e();
            }
            return e2 + i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i2) {
            int e2;
            if (this.a == null || i2 < e() + 1 || (e2 = i2 - (e() + 1)) >= this.a.getItemCount()) {
                return -1L;
            }
            return this.a.getItemId(e2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            int e2 = i2 - (e() + 1);
            if (i(i2)) {
                return 10000;
            }
            if (h(i2)) {
                return ((Integer) XRecyclerView.u.get(i2 - 1)).intValue();
            } else if (g(i2)) {
                return 10001;
            } else {
                RecyclerView.Adapter adapter = this.a;
                if (adapter == null || e2 >= adapter.getItemCount()) {
                    return 0;
                }
                int itemViewType = this.a.getItemViewType(e2);
                if (XRecyclerView.this.r(itemViewType)) {
                    throw new IllegalStateException("XRecyclerView require itemViewType in adapter should be less than 10000 ");
                }
                return itemViewType;
            }
        }

        public boolean h(int i2) {
            return XRecyclerView.this.f5805e != null && i2 >= 1 && i2 < XRecyclerView.this.f5805e.size() + 1;
        }

        public boolean i(int i2) {
            return i2 == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                gridLayoutManager.setSpanSizeLookup(new a(gridLayoutManager));
            }
            this.a.onAttachedToRecyclerView(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            if (h(i2) || i(i2)) {
                return;
            }
            int e2 = i2 - (e() + 1);
            RecyclerView.Adapter adapter = this.a;
            if (adapter == null || e2 >= adapter.getItemCount()) {
                return;
            }
            this.a.onBindViewHolder(viewHolder, e2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 10000) {
                return new b(this, XRecyclerView.this.f5811k);
            }
            if (XRecyclerView.this.p(i2)) {
                return new b(this, XRecyclerView.this.n(i2));
            }
            if (i2 == 10001) {
                return new b(this, XRecyclerView.this.o);
            }
            return this.a.onCreateViewHolder(viewGroup, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            this.a.onDetachedFromRecyclerView(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
            return this.a.onFailedToRecycleView(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewAttachedToWindow(viewHolder);
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) && (h(viewHolder.getLayoutPosition()) || i(viewHolder.getLayoutPosition()) || g(viewHolder.getLayoutPosition()))) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
            this.a.onViewAttachedToWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            this.a.onViewDetachedFromWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            this.a.onViewRecycled(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            this.a.registerAdapterDataObserver(adapterDataObserver);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            this.a.unregisterAdapterDataObserver(adapterDataObserver);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List<Object> list) {
            if (h(i2) || i(i2)) {
                return;
            }
            int e2 = i2 - (e() + 1);
            RecyclerView.Adapter adapter = this.a;
            if (adapter == null || e2 >= adapter.getItemCount()) {
                return;
            }
            if (list.isEmpty()) {
                this.a.onBindViewHolder(viewHolder, e2);
            } else {
                this.a.onBindViewHolder(viewHolder, e2, list);
            }
        }
    }
}
