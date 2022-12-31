package us.pinguo.user;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import us.pinguo.foundation.base.SubscriptionFragment;
import us.pinguo.user.recycler.FlingFilterRecyclerView;
import us.pinguo.user.ui.view.CompatibleToolbar;
import us.pinguo.user.util.f;
/* loaded from: classes6.dex */
public abstract class BaseAbsListFragment extends SubscriptionFragment implements SwipeRefreshLayout.OnRefreshListener {
    protected SwipeRefreshLayout a;
    protected FlingFilterRecyclerView b;
    protected FrameLayout c;

    /* renamed from: d  reason: collision with root package name */
    protected us.pinguo.user.recycler.c f12338d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f12339e;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView.OnScrollListener f12341g;

    /* renamed from: h  reason: collision with root package name */
    private FrameLayout f12342h;

    /* renamed from: i  reason: collision with root package name */
    private FrameLayout f12343i;

    /* renamed from: j  reason: collision with root package name */
    private Toolbar f12344j;

    /* renamed from: k  reason: collision with root package name */
    protected View f12345k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12346l;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f12340f = true;
    private f.b m = new a();

    /* loaded from: classes6.dex */
    class a implements f.b {
        a() {
        }

        @Override // us.pinguo.user.util.f.b
        public void onDoubleClick(View view) {
            BaseAbsListFragment.this.b.smoothScrollToPosition(0);
        }

        @Override // us.pinguo.user.util.f.b
        public void onSingleClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            us.pinguo.user.util.e.a.a(recyclerView);
            if (i3 == 0 && i2 == 0) {
                return;
            }
            BaseAbsListFragment.this.checkLoadMore();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ View a;

        c(View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(16)
        public void onGlobalLayout() {
            if (us.pinguo.common.utils.b.b) {
                this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            if (BaseAbsListFragment.this.a.isRefreshing()) {
                return;
            }
            BaseAbsListFragment baseAbsListFragment = BaseAbsListFragment.this;
            if (baseAbsListFragment.f12339e) {
                return;
            }
            baseAbsListFragment.triggerRefresh();
        }
    }

    /* loaded from: classes6.dex */
    class d extends RecyclerView.OnScrollListener {
        d(BaseAbsListFragment baseAbsListFragment) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
        }
    }

    public BaseAbsListFragment() {
        new d(this);
        new ArrayList();
    }

    private void addListener() {
        b bVar = new b();
        this.f12341g = bVar;
        this.b.addOnScrollListener(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public /* synthetic */ void c0(us.pinguo.user.util.f fVar, View view) {
        VdsAgent.lambdaOnClick(view);
        fVar.d(view, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
        if (((androidx.recyclerview.widget.LinearLayoutManager) r0).findLastVisibleItemPosition() >= ((r6.f12338d.getItemCount() - 1) - 5)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        if (r0.findLastVisibleItemPosition() >= ((r6.f12338d.getItemCount() - 1) - (r0.getSpanCount() * 5))) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkLoadMore() {
        /*
            r6 = this;
            boolean r0 = r6.f12340f
            if (r0 == 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.f12338d
            if (r0 == 0) goto Lb2
            int r0 = r0.getItemCount()
            if (r0 == 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.f12338d
            boolean r0 = r0.isFootShowing()
            if (r0 != 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.f12338d
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.f12338d
            boolean r0 = r0.isError()
            if (r0 != 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.f12338d
            boolean r0 = r0.isLoadingShowing()
            if (r0 != 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.f12338d
            boolean r0 = r0.isNoMoreShowing()
            if (r0 != 0) goto Lb2
            boolean r0 = r6.canLoadMore()
            if (r0 == 0) goto Lb2
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = r6.a
            boolean r0 = r0.isRefreshing()
            if (r0 != 0) goto Lb2
            boolean r0 = r6.f12346l
            if (r0 == 0) goto L49
            goto Lb2
        L49:
            us.pinguo.user.recycler.FlingFilterRecyclerView r0 = r6.b
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            boolean r1 = r0 instanceof androidx.recyclerview.widget.LinearLayoutManager
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L67
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            int r0 = r0.findLastVisibleItemPosition()
            us.pinguo.user.recycler.c r1 = r6.f12338d
            int r1 = r1.getItemCount()
            int r1 = r1 - r3
            int r1 = r1 + (-5)
            if (r0 < r1) goto La8
            goto La3
        L67:
            boolean r1 = r0 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r1 == 0) goto L82
            androidx.recyclerview.widget.GridLayoutManager r0 = (androidx.recyclerview.widget.GridLayoutManager) r0
            int r1 = r0.findLastVisibleItemPosition()
            us.pinguo.user.recycler.c r4 = r6.f12338d
            int r4 = r4.getItemCount()
            int r4 = r4 - r3
            int r0 = r0.getSpanCount()
            int r0 = r0 * 5
            int r4 = r4 - r0
            if (r1 < r4) goto La8
            goto La3
        L82:
            boolean r1 = r0 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r1 == 0) goto La8
            androidx.recyclerview.widget.StaggeredGridLayoutManager r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r0
            r1 = 0
            int[] r1 = r0.findLastVisibleItemPositions(r1)
            us.pinguo.user.recycler.c r4 = r6.f12338d
            int r4 = r4.getItemCount()
            int r4 = r4 - r3
            int r0 = r0.getSpanCount()
            int r0 = r0 * 5
            int r4 = r4 - r0
            r0 = 0
        L9c:
            int r5 = r1.length
            if (r0 >= r5) goto La8
            r5 = r1[r0]
            if (r5 < r4) goto La5
        La3:
            r2 = 1
            goto La8
        La5:
            int r0 = r0 + 1
            goto L9c
        La8:
            if (r2 == 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.f12338d
            r0.showFooter()
            r6.onLoadMore()
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.user.BaseAbsListFragment.checkLoadMore():void");
    }

    private boolean checkRefresh() {
        us.pinguo.user.recycler.c cVar = this.f12338d;
        return (cVar == null || cVar.isFootShowing() || this.f12338d.isLoadingShowing()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public /* synthetic */ void e0(View view) {
        VdsAgent.lambdaOnClick(view);
        getActivity().onBackPressed();
    }

    protected boolean canLoadMore() {
        return true;
    }

    public SwipeRefreshLayout getRefreshLayout(View view) {
        return (SwipeRefreshLayout) view.findViewById(R.id.base_list_swipe);
    }

    protected View inflateRootView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.layout_area_list_fragment, viewGroup, false);
    }

    protected us.pinguo.user.recycler.c initAdapter() {
        return new us.pinguo.user.recycler.c();
    }

    protected void initDefaultTitle(View view) {
        Toolbar b2 = ((CompatibleToolbar) view.findViewById(R.id.toolbar_common)).b();
        this.f12344j = b2;
        b2.setBackgroundColor(-1);
        this.f12344j.setTitleTextColor(getResources().getColor(us.pinguo.foundation.R.color.light_main_title_text));
        this.f12344j.setTitleTextAppearance(getActivity(), R.style.ToolBar_TextSize);
        final us.pinguo.user.util.f fVar = new us.pinguo.user.util.f();
        this.f12344j.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.user.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseAbsListFragment.this.c0(fVar, view2);
            }
        });
        setBackBtnVisiable(view);
    }

    public void initHeaderTitleBar(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(aVar);
    }

    protected void initSwpieRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.swipe_color);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflateRootView = inflateRootView(layoutInflater, viewGroup, bundle);
        this.a = getRefreshLayout(inflateRootView);
        this.b = (FlingFilterRecyclerView) inflateRootView.findViewById(R.id.base_list_recycle_view);
        this.c = (FrameLayout) inflateRootView.findViewById(R.id.base_title_container);
        this.f12342h = (FrameLayout) inflateRootView.findViewById(R.id.base_list_footer);
        this.f12343i = (FrameLayout) inflateRootView.findViewById(R.id.fl_expand_base_list);
        initDefaultTitle(this.c);
        initHeaderTitleBar(inflateRootView);
        addListener();
        this.a.setColorSchemeColors(-12828083);
        return inflateRootView;
    }

    protected abstract void onDataRefresh();

    @Override // us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        FlingFilterRecyclerView flingFilterRecyclerView;
        super.onDestroyView();
        RecyclerView.OnScrollListener onScrollListener = this.f12341g;
        if (onScrollListener != null && (flingFilterRecyclerView = this.b) != null) {
            flingFilterRecyclerView.removeOnScrollListener(onScrollListener);
        }
        us.pinguo.user.recycler.c cVar = this.f12338d;
        if (cVar != null) {
            cVar.onDestroyView();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseFragment
    public void onFragmentHide() {
        super.onFragmentHide();
        us.pinguo.user.util.e.a.d(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseFragment
    public void onFragmentShow() {
        super.onFragmentShow();
        us.pinguo.user.util.e.a.e(this.b);
    }

    protected abstract void onLoadMore();

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public final void onRefresh() {
        us.pinguo.common.log.a.k("onRefresh,isRefreshing:" + this.a.isRefreshing(), new Object[0]);
        if (checkRefresh()) {
            this.f12339e = true;
            onDataRefresh();
            return;
        }
        onRefreshComplete();
    }

    protected void onRefreshComplete() {
        us.pinguo.common.log.a.k("onRefreshComplete", new Object[0]);
        SwipeRefreshLayout swipeRefreshLayout = this.a;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        this.f12339e = false;
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f12345k = view.findViewById(R.id.base_list_layout);
        initSwpieRefreshLayout(this.a);
        us.pinguo.user.recycler.c initAdapter = initAdapter();
        this.f12338d = initAdapter;
        initAdapter.setSwipeRefreshLayout(this.a);
        initRecycleView(this.b, this.f12338d);
        triggerFirstRefresh(view);
    }

    public void setBackBtnVisiable(View view) {
        Toolbar toolbar = this.f12344j;
        if (toolbar != null) {
            toolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
            this.f12344j.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.user.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseAbsListFragment.this.e0(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLoadMoreEnabled(boolean z) {
        this.f12340f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPullToRefreshEnabled(boolean z) {
        this.a.setEnabled(z);
    }

    public void setTitle(String str) {
        Toolbar toolbar = this.f12344j;
        if (toolbar != null) {
            toolbar.setTitle(str);
        }
    }

    protected void triggerFirstRefresh(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new c(view));
    }

    public void triggerRefresh() {
        this.a.setRefreshing(true);
        onRefresh();
    }
}
