package us.pinguo.inspire.module.challenge;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import rx.functions.Action1;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy;
import us.pinguo.inspire.module.feeds.cell.FeedsVideoCell;
import us.pinguo.inspire.proxy.InspireStatistics;
import us.pinguo.inspire.widget.videocell.InspireVideoFragment;
import us.pinguo.user.recycler.FeedsNewDecoration;
import us.pinguo.user.recycler.FlingFilterRecyclerView;
/* loaded from: classes9.dex */
public abstract class ChallengeTabChildFragment extends InspireVideoFragment {
    private static final long REFRESH_TIME = 600000;
    protected ChallengeOnScrollListener mFeedsOnScrollListener;
    protected boolean mPaused;
    private long mPreRefreshTime;
    protected boolean mSelected;

    private void checkSelected() {
        if (this.mSelected && !this.mPaused) {
            onShow();
        } else {
            onHide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(FeedsPhotoCellProxy.InspireCommentEvent inspireCommentEvent) {
        FlingFilterRecyclerView flingFilterRecyclerView;
        if (inspireCommentEvent == null || TextUtils.isEmpty(inspireCommentEvent.workId) || this.mAdapter == null || (flingFilterRecyclerView = this.mRecyclerView) == null || flingFilterRecyclerView.getChildCount() == 0) {
            return;
        }
        String str = inspireCommentEvent.workId;
        FlingFilterRecyclerView flingFilterRecyclerView2 = this.mRecyclerView;
        int childAdapterPosition = flingFilterRecyclerView2.getChildAdapterPosition(flingFilterRecyclerView2.getChildAt(0));
        if (childAdapterPosition < 0) {
            childAdapterPosition = 0;
        }
        while (childAdapterPosition < this.mAdapter.getItemCount()) {
            us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(childAdapterPosition);
            boolean z = item instanceof FeedsPhotoCell;
            if (z || (item instanceof FeedsVideoCell)) {
                InspireFeed inspireFeed = (InspireFeed) item.getData();
                String str2 = inspireFeed.getFcnt() == null ? null : inspireFeed.getFcnt().workId;
                if (str2 != null && str2.equals(str)) {
                    if (z) {
                        ((FeedsPhotoCell) item).updateComment(inspireCommentEvent);
                    } else if (item instanceof FeedsVideoCell) {
                        ((FeedsVideoCell) item).updateComment(inspireCommentEvent);
                    }
                    us.pinguo.common.log.a.k("updateComment", new Object[0]);
                    return;
                }
            }
            childAdapterPosition++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public /* synthetic */ void i0(us.pinguo.inspire_proxy.a.a aVar) {
        if (this.mAdapter == null || aVar == null || aVar.a == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mAdapter.getItemCount(); i2++) {
            if (this.mAdapter.getItem(i2).getData() instanceof InspireFeed) {
                InspireFeed inspireFeed = (InspireFeed) this.mAdapter.getItem(i2).getData();
                if (inspireFeed.getFcnt() != null && aVar.a.equals(inspireFeed.getFcnt().workId)) {
                    this.mAdapter.remove(i2);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    private void notifyFeedsCellsVisible(boolean z) {
        if (this.mAdapter == null) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(findFirstVisibleItemPosition);
            if (item instanceof us.pinguo.inspire.cell.recycler.a) {
                item.setShown(z);
            }
        }
    }

    private void registerCommentUpdateEvent() {
        addSubscription(us.pinguo.foundation.r.d.a().c(FeedsPhotoCellProxy.InspireCommentEvent.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.challenge.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ChallengeTabChildFragment.this.f0((FeedsPhotoCellProxy.InspireCommentEvent) obj);
            }
        }, d.a));
    }

    private void registerFeedDeleteEvent() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire_proxy.a.a.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.challenge.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ChallengeTabChildFragment.this.i0((us.pinguo.inspire_proxy.a.a) obj);
            }
        }, e.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkAutoRefresh() {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.mPreRefreshTime;
        if (j2 != 0 && currentTimeMillis - j2 > REFRESH_TIME) {
            this.mPreRefreshTime = currentTimeMillis;
            triggerRefresh();
            us.pinguo.common.log.a.k("auto refresh", new Object[0]);
            AdvConfigManager.getInstance().scheduleUpdate();
        }
        if (this.mPreRefreshTime == 0) {
            this.mPreRefreshTime = System.currentTimeMillis();
        }
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public abstract /* synthetic */ void clearNewStatus();

    public abstract /* synthetic */ boolean getNewStatus();

    protected abstract String getPageKey();

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public SwipeRefreshLayout getRefreshLayout(View view) {
        return (SwipeRefreshLayout) view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        recyclerView.addItemDecoration(new FeedsNewDecoration(getActivity()));
        recyclerView.setTag(this);
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public abstract /* synthetic */ void onAdvDataChange();

    @Override // us.pinguo.librouter.module.inspire.c
    public abstract /* synthetic */ boolean onBackPressed();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void onDataRefresh() {
        this.mPreRefreshTime = System.currentTimeMillis();
    }

    public void onHide() {
        InspireStatistics.onPageEnd("portal_hot_page");
        if (this.mAdapter == null) {
            return;
        }
        notifyFeedsCellsVisible(false);
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public abstract /* synthetic */ void onLogin();

    @Override // us.pinguo.librouter.module.inspire.c
    public abstract /* synthetic */ void onLogout();

    @Override // us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mPaused = true;
        if (this.mSelected) {
            checkSelected();
        }
    }

    @Override // us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mPaused = false;
        if (this.mSelected) {
            checkSelected();
        }
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onSelected() {
        this.mSelected = true;
        checkSelected();
    }

    public void onShow() {
        FlingFilterRecyclerView flingFilterRecyclerView;
        InspireStatistics.onPageStart(getPageKey());
        us.pinguo.foundation.statistics.l.onEvent(getActivity(), getPageKey());
        if (this.mAdapter == null) {
            return;
        }
        if (this.mFeedsOnScrollListener != null && (flingFilterRecyclerView = this.mRecyclerView) != null && (flingFilterRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            this.mFeedsOnScrollListener.checkShowRefreshBtn((LinearLayoutManager) this.mRecyclerView.getLayoutManager());
        }
        checkAutoRefresh();
        notifyFeedsCellsVisible(true);
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onUnSelected() {
        this.mSelected = false;
        checkSelected();
    }

    @Override // us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setSlient(true);
        registerCommentUpdateEvent();
        registerFeedDeleteEvent();
        ChallengeOnScrollListener challengeOnScrollListener = new ChallengeOnScrollListener(view);
        this.mFeedsOnScrollListener = challengeOnScrollListener;
        this.mRecyclerView.addOnScrollListener(challengeOnScrollListener);
    }
}
