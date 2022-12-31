package us.pinguo.inspire.base;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import us.pinguo.foundation.base.SubscriptionFragment;
import us.pinguo.user.R;
import us.pinguo.user.recycler.FlingFilterRecyclerView;
import us.pinguo.user.ui.view.CompatibleToolbar;
import us.pinguo.user.util.f;
/* loaded from: classes9.dex */
public abstract class BaseAbsListFragment extends SubscriptionFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final int PRELOAD_SIZE = 5;
    protected us.pinguo.user.recycler.c mAdapter;
    protected View mContainerView;
    private FrameLayout mExpandView;
    private FrameLayout mFooterView;
    private FrameLayout mHeaderTitleView;
    protected boolean mIsDataRefreshing;
    private boolean mLoadingMore;
    private RecyclerView.OnScrollListener mOnScrollListener;
    protected FlingFilterRecyclerView mRecyclerView;
    protected SwipeRefreshLayout mRefreshLayout;
    protected FrameLayout mTitleContainer;
    private Toolbar mToolbar;
    protected boolean mEnableLoadMore = true;
    private f.b mDefaultOnDoubleClickTitleListener = new a();
    private RecyclerView.OnScrollListener onScrollListener = new d(this);
    private ArrayList<e> mOnDataRefreshListeners = new ArrayList<>();
    private boolean mIsNoMoreContent = false;

    /* loaded from: classes9.dex */
    class a implements f.b {
        a() {
        }

        @Override // us.pinguo.user.util.f.b
        public void onDoubleClick(View view) {
            BaseAbsListFragment.this.mRecyclerView.smoothScrollToPosition(0);
        }

        @Override // us.pinguo.user.util.f.b
        public void onSingleClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
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
    /* loaded from: classes9.dex */
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
            if (BaseAbsListFragment.this.mRefreshLayout.isRefreshing()) {
                return;
            }
            BaseAbsListFragment baseAbsListFragment = BaseAbsListFragment.this;
            if (baseAbsListFragment.mIsDataRefreshing) {
                return;
            }
            baseAbsListFragment.triggerRefresh();
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public interface e {
        void onDataRefreshed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(f fVar, View view) {
        fVar.d(view, this.mDefaultOnDoubleClickTitleListener);
    }

    private void addListener() {
        b bVar = new b();
        this.mOnScrollListener = bVar;
        this.mRecyclerView.addOnScrollListener(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0(View view) {
        getActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
        if (((androidx.recyclerview.widget.LinearLayoutManager) r0).findLastVisibleItemPosition() >= ((r6.mAdapter.getItemCount() - 1) - 5)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        if (r0.findLastVisibleItemPosition() >= ((r6.mAdapter.getItemCount() - 1) - (r0.getSpanCount() * 5))) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkLoadMore() {
        /*
            r6 = this;
            boolean r0 = r6.mEnableLoadMore
            if (r0 == 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            if (r0 == 0) goto Lb2
            int r0 = r0.getItemCount()
            if (r0 == 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            boolean r0 = r0.isFootShowing()
            if (r0 != 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            boolean r0 = r0.isError()
            if (r0 != 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            boolean r0 = r0.isLoadingShowing()
            if (r0 != 0) goto Lb2
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            boolean r0 = r0.isNoMoreShowing()
            if (r0 != 0) goto Lb2
            boolean r0 = r6.canLoadMore()
            if (r0 == 0) goto Lb2
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = r6.mRefreshLayout
            boolean r0 = r0.isRefreshing()
            if (r0 != 0) goto Lb2
            boolean r0 = r6.mLoadingMore
            if (r0 == 0) goto L49
            goto Lb2
        L49:
            us.pinguo.user.recycler.FlingFilterRecyclerView r0 = r6.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            boolean r1 = r0 instanceof androidx.recyclerview.widget.LinearLayoutManager
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L67
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            int r0 = r0.findLastVisibleItemPosition()
            us.pinguo.user.recycler.c r1 = r6.mAdapter
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
            us.pinguo.user.recycler.c r4 = r6.mAdapter
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
            us.pinguo.user.recycler.c r4 = r6.mAdapter
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
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            r0.showFooter()
            r6.onLoadMore()
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.base.BaseAbsListFragment.checkLoadMore():void");
    }

    private boolean checkRefresh() {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        return (cVar == null || cVar.isFootShowing() || this.mAdapter.isLoadingShowing()) ? false : true;
    }

    protected void addFooterView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        this.mFooterView.addView(view, layoutParams);
        this.mFooterView.setVisibility(0);
    }

    public void adddOnDataRefreshListener(e eVar) {
        this.mOnDataRefreshListeners.add(eVar);
    }

    protected boolean canLoadMore() {
        return true;
    }

    public View getContainerView() {
        return this.mContainerView;
    }

    protected ImageView getDefaultRightIv() {
        return (ImageView) this.mToolbar.findViewById(R.id.iv_right_toolbar);
    }

    protected TextView getDefaultRightTv() {
        return (TextView) this.mToolbar.findViewById(R.id.tv_right_toolbar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Toolbar getDefaultToolbar() {
        return this.mToolbar;
    }

    public FrameLayout getExpandView() {
        return this.mExpandView;
    }

    public SwipeRefreshLayout getRefreshLayout(View view) {
        return (SwipeRefreshLayout) view.findViewById(vStudio.Android.Camera360.R.id.base_list_swipe_res_0x7d06001d);
    }

    protected View inflateRootView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(vStudio.Android.Camera360.R.layout.layout_base_list_fragment, viewGroup, false);
    }

    protected us.pinguo.user.recycler.c initAdapter() {
        return new us.pinguo.user.recycler.c();
    }

    protected void initDefaultTitle(View view) {
        Toolbar b2 = ((CompatibleToolbar) view.findViewById(R.id.toolbar_common)).b();
        this.mToolbar = b2;
        b2.setBackgroundColor(-1);
        this.mToolbar.setTitleTextColor(getResources().getColor(us.pinguo.foundation.R.color.light_main_title_text));
        this.mToolbar.setTitleTextAppearance(getActivity(), R.style.ToolBar_TextSize);
        final f fVar = new f();
        this.mToolbar.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.base.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseAbsListFragment.this.b0(fVar, view2);
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

    protected boolean isLoading() {
        return this.mAdapter.isFootShowing() || this.mLoadingMore;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflateRootView = inflateRootView(layoutInflater, viewGroup, bundle);
        this.mRefreshLayout = getRefreshLayout(inflateRootView);
        this.mRecyclerView = (FlingFilterRecyclerView) inflateRootView.findViewById(vStudio.Android.Camera360.R.id.base_list_recycle_view_res_0x7d06001c);
        this.mTitleContainer = (FrameLayout) inflateRootView.findViewById(vStudio.Android.Camera360.R.id.base_title_container_res_0x7d06001e);
        this.mFooterView = (FrameLayout) inflateRootView.findViewById(vStudio.Android.Camera360.R.id.base_list_footer_res_0x7d06001a);
        this.mExpandView = (FrameLayout) inflateRootView.findViewById(vStudio.Android.Camera360.R.id.fl_expand_base_list_res_0x7d0600d3);
        initDefaultTitle(this.mTitleContainer);
        initHeaderTitleBar(inflateRootView);
        addListener();
        this.mRefreshLayout.setColorSchemeColors(-12828083);
        return inflateRootView;
    }

    protected abstract void onDataRefresh();

    @Override // us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        FlingFilterRecyclerView flingFilterRecyclerView;
        super.onDestroyView();
        RecyclerView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null && (flingFilterRecyclerView = this.mRecyclerView) != null) {
            flingFilterRecyclerView.removeOnScrollListener(onScrollListener);
        }
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar != null) {
            cVar.onDestroyView();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseFragment
    public void onFragmentHide() {
        super.onFragmentHide();
        us.pinguo.user.util.e.a.d(this.mRecyclerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseFragment
    public void onFragmentShow() {
        super.onFragmentShow();
        us.pinguo.user.util.e.a.e(this.mRecyclerView);
    }

    protected abstract void onLoadMore();

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public final void onRefresh() {
        us.pinguo.common.log.a.k("onRefresh,isRefreshing:" + this.mRefreshLayout.isRefreshing(), new Object[0]);
        if (checkRefresh()) {
            this.mIsDataRefreshing = true;
            onDataRefresh();
            return;
        }
        onRefreshComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRefreshComplete() {
        us.pinguo.common.log.a.k("onRefreshComplete", new Object[0]);
        SwipeRefreshLayout swipeRefreshLayout = this.mRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        this.mIsDataRefreshing = false;
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mContainerView = view.findViewById(vStudio.Android.Camera360.R.id.base_list_layout_res_0x7d06001b);
        initSwpieRefreshLayout(this.mRefreshLayout);
        us.pinguo.user.recycler.c initAdapter = initAdapter();
        this.mAdapter = initAdapter;
        initAdapter.setSwipeRefreshLayout(this.mRefreshLayout);
        initRecycleView(this.mRecyclerView, this.mAdapter);
        triggerFirstRefresh(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void replaceTitle(View view) {
        this.mToolbar = null;
        if (view == null) {
            this.mTitleContainer.setVisibility(8);
            return;
        }
        this.mTitleContainer.setVisibility(0);
        this.mTitleContainer.removeAllViews();
        this.mTitleContainer.addView(view);
    }

    public void setBackBtnVisiable(View view) {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
            this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.base.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseAbsListFragment.this.d0(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLoadMoreEnabled(boolean z) {
        this.mEnableLoadMore = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLoadingMore(boolean z) {
        this.mLoadingMore = z;
    }

    public void setNoMoreContent(boolean z) {
        this.mIsNoMoreContent = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPullToRefreshEnabled(boolean z) {
        this.mRefreshLayout.setEnabled(z);
    }

    public void setTitle(String str) {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setTitle(str);
        }
    }

    protected void triggerFirstRefresh(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new c(view));
    }

    public void triggerRefresh() {
        this.mRefreshLayout.setRefreshing(true);
        onRefresh();
    }

    public void setTitle(int i2) {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setTitle(i2);
        }
    }
}
