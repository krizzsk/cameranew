package us.pinguo.inspire.module.comment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.challenge.ChallengeTabUnread;
import us.pinguo.inspire.module.comment.cell.BaseInfoCell;
import us.pinguo.inspire.module.comment.cell.ContentInfoCell;
import us.pinguo.inspire.module.comment.widget.InfoTopLayout;
import us.pinguo.inspire.module.discovery.entity.dicovery.AuthorInfo;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.ui.widget.video.VideoPlayer;
import vStudio.Android.Camera360.R;
/* compiled from: FeedsRecFragment.kt */
/* loaded from: classes9.dex */
public final class FeedsRecFragment extends FeedsInfoFragment implements us.pinguo.librouter.module.inspire.c {
    private boolean isLoadingMore;
    private View progressView;
    private SwipeRefreshLayout refreshLayout;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final int PRE_LOAD_MORE = 10;
    private boolean isPageSelect = true;
    private boolean autoPlay = true;

    private final void checkLoadMore(int i2) {
        if (this.isLoadingMore) {
            return;
        }
        FeedsInfoPagerAdapter mPagerAdapter = getMPagerAdapter();
        int count = mPagerAdapter == null ? 0 : mPagerAdapter.getCount();
        if (count <= 0 || i2 + this.PRE_LOAD_MORE < count) {
            return;
        }
        this.isLoadingMore = true;
        FeedsInfoPresenter mPresenter = getMPresenter();
        if (mPresenter == null) {
            return;
        }
        mPresenter.loadMoreRec();
    }

    private final void checkVideoPause() {
        new Handler().postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.comment.w0
            @Override // java.lang.Runnable
            public final void run() {
                FeedsRecFragment.m148checkVideoPause$lambda1(FeedsRecFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkVideoPause$lambda-1  reason: not valid java name */
    public static final void m148checkVideoPause$lambda1(FeedsRecFragment this$0) {
        InfoVideoPresenter mVideoPresenter;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.isPageSelect || (mVideoPresenter = this$0.getMVideoPresenter()) == null) {
            return;
        }
        mVideoPresenter.checkPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initRefresh$lambda-0  reason: not valid java name */
    public static final void m149initRefresh$lambda0(FeedsRecFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        FeedsInfoPresenter mPresenter = this$0.getMPresenter();
        if (mPresenter == null) {
            return;
        }
        mPresenter.getRecWorks();
    }

    private final void initRelationRxBusMsg() {
        addSubscription(us.pinguo.foundation.r.d.a().c(AttentionButton.k.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.y0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsRecFragment.m150initRelationRxBusMsg$lambda4(FeedsRecFragment.this, (AttentionButton.k) obj);
            }
        }, v0.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initRelationRxBusMsg$lambda-4  reason: not valid java name */
    public static final void m150initRelationRxBusMsg$lambda4(FeedsRecFragment this$0, AttentionButton.k kVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        FeedsInfoPagerAdapter mPagerAdapter = this$0.getMPagerAdapter();
        int i2 = 0;
        if ((mPagerAdapter == null ? 0 : mPagerAdapter.getCount()) <= 0) {
            return;
        }
        FeedsInfoPagerAdapter mPagerAdapter2 = this$0.getMPagerAdapter();
        kotlin.jvm.internal.s.e(mPagerAdapter2);
        int count = mPagerAdapter2.getCount();
        if (count < 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            FeedsInfoPagerAdapter mPagerAdapter3 = this$0.getMPagerAdapter();
            kotlin.jvm.internal.s.e(mPagerAdapter3);
            BaseInfoCell item = mPagerAdapter3.getItem(i2);
            if (item instanceof ContentInfoCell) {
                ContentInfoCell contentInfoCell = (ContentInfoCell) item;
                AuthorInfo authorInfo = contentInfoCell.getData().authorInfo;
                if (kotlin.jvm.internal.s.c(authorInfo == null ? null : authorInfo.userId, kVar != null ? kVar.c : null)) {
                    contentInfoCell.getData().authorInfo.relation = kVar.a;
                    contentInfoCell.updateAttentionButton(kVar, contentInfoCell.getData());
                }
            }
            if (i2 == count) {
                return;
            }
            i2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentWork$lambda-2  reason: not valid java name */
    public static final void m152setCurrentWork$lambda2(BaseResponse baseResponse) {
        us.pinguo.common.log.a.k("incrWatchSum", new Object[0]);
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment
    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment, us.pinguo.inspire.module.comment.IFeedsInfoView
    public void appendCells(List<BaseInfoCell> list) {
        super.appendCells(list);
        us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("loadMoreRec Success:", list == null ? null : Integer.valueOf(list.size())), new Object[0]);
        this.isLoadingMore = false;
    }

    public final void checkShowCameraToast() {
        if (ChallengeTabUnread.INSTANCE.getUnread() <= 0 || !(getCurrentCell() instanceof ContentInfoCell)) {
            return;
        }
        BaseInfoCell currentCell = getCurrentCell();
        Objects.requireNonNull(currentCell, "null cannot be cast to non-null type us.pinguo.inspire.module.comment.cell.ContentInfoCell");
        ContentInfoCell contentInfoCell = (ContentInfoCell) currentCell;
        if (contentInfoCell.getData().isTaskFinished()) {
            return;
        }
        InfoGuide.showCameraToast(contentInfoCell);
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void clearNewStatus() {
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment, us.pinguo.inspire.module.comment.IFeedsInfoView
    public void fillForEmptyPage() {
    }

    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public Fragment getFragment() {
        return this;
    }

    public boolean getNewStatus() {
        return false;
    }

    public final View getProgressView() {
        return this.progressView;
    }

    public final SwipeRefreshLayout getRefreshLayout() {
        return this.refreshLayout;
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment
    public void initData() {
        super.initData();
        InfoVideoPresenter mVideoPresenter = getMVideoPresenter();
        if (mVideoPresenter == null) {
            return;
        }
        mVideoPresenter.setAutoPlayEnabled(this.autoPlay);
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment
    protected void initRefresh() {
        View view = getView();
        SwipeRefreshLayout swipeRefreshLayout = view == null ? null : (SwipeRefreshLayout) view.findViewById(R.id.info_refresh);
        this.refreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setProgressViewEndTarget(false, us.pinguo.foundation.t.b.a.a(getContext(), 100.0f));
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.refreshLayout;
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setColorSchemeColors(-12828083);
        }
        SwipeRefreshLayout swipeRefreshLayout3 = this.refreshLayout;
        if (swipeRefreshLayout3 == null) {
            return;
        }
        swipeRefreshLayout3.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: us.pinguo.inspire.module.comment.a1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FeedsRecFragment.m149initRefresh$lambda0(FeedsRecFragment.this);
            }
        });
    }

    public final boolean isLoadingMore() {
        return this.isLoadingMore;
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onAdvDataChange() {
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        FeedsInfoFragment.Companion.setElement_id("challenge_recommend_detail_page");
        this.mEnableDefaultFragmentVisibleStrategy = false;
        return onCreateView;
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment, us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment, us.pinguo.inspire.module.comment.IFeedsInfoView
    public void onLoadRecError() {
        SwipeRefreshLayout swipeRefreshLayout = this.refreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        View view = this.progressView;
        if (view != null) {
            view.setVisibility(8);
        }
        us.pinguo.foundation.utils.j0.c(us.pinguo.c360.i18n.R.string.network_error);
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onLogin() {
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onLogout() {
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        super.onPageSelected(i2);
        ((SwipeRefreshLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_refresh)).setEnabled(i2 == 0);
        checkLoadMore(i2);
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.isPageSelect) {
            onFragmentHide();
        }
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isPageSelect) {
            onFragmentShow();
        }
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onSelected() {
        this.isPageSelect = true;
        InfoVideoPresenter mVideoPresenter = getMVideoPresenter();
        if (mVideoPresenter != null) {
            mVideoPresenter.setAutoPlayEnabled(true);
        }
        InfoVideoPresenter mVideoPresenter2 = getMVideoPresenter();
        if (mVideoPresenter2 != null) {
            mVideoPresenter2.onResume();
        }
        InfoVideoPresenter mVideoPresenter3 = getMVideoPresenter();
        VideoPlayer mVideoPlayer = mVideoPresenter3 == null ? null : mVideoPresenter3.getMVideoPlayer();
        if (mVideoPlayer != null) {
            mVideoPlayer.d0(false);
        }
        us.pinguo.foundation.statistics.h.a.B0("challenge_task_list_recommend_change", "click");
        if (this.mIsPausing) {
            return;
        }
        onFragmentShow();
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onTabClickWhenSelected() {
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onUnSelected() {
        this.isPageSelect = false;
        InfoVideoPresenter mVideoPresenter = getMVideoPresenter();
        if (mVideoPresenter != null) {
            mVideoPresenter.onPause();
        }
        onFragmentHide();
        checkVideoPause();
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        initRelationRxBusMsg();
        ((InfoTopLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_top_layout)).hideClose();
        this.isLoadingMore = false;
        setMUpdateWorkFromNet(false);
        this.progressView = ((ViewStub) _$_findCachedViewById(us.pinguo.inspire.R.id.info_progress_stub)).inflate();
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void releaseResource() {
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void reloadResource() {
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment
    public void resumeVideo() {
        if (this.isPageSelect) {
            super.resumeVideo();
        }
    }

    public final void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment, us.pinguo.inspire.module.comment.IFeedsInfoView
    public void setCells(List<BaseInfoCell> cells) {
        kotlin.jvm.internal.s.h(cells, "cells");
        super.setCells(cells);
        ((SwipeRefreshLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_refresh)).setRefreshing(false);
        View view = getView();
        View findViewById = view == null ? null : view.findViewById(R.id.info_progress);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (cells.size() > 1) {
            checkShowCameraToast();
        }
    }

    @Override // us.pinguo.inspire.module.comment.FeedsInfoFragment
    public void setCurrentWork(int i2) {
        super.setCurrentWork(i2);
        InspireWork currentWork = getCurrentWork();
        if (currentWork != null) {
            RecLoader.INSTANCE.incrWatchSum(currentWork).subscribe(z0.a, x0.a);
        }
    }

    public final void setLoadingMore(boolean z) {
        this.isLoadingMore = z;
    }

    public final void setNoAutoPlay() {
        this.autoPlay = false;
    }

    public final void setProgressView(View view) {
        this.progressView = view;
    }

    public final void setRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.refreshLayout = swipeRefreshLayout;
    }

    public final void triggerRefresh() {
        SwipeRefreshLayout swipeRefreshLayout = this.refreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(true);
        }
        FeedsInfoPresenter mPresenter = getMPresenter();
        if (mPresenter == null) {
            return;
        }
        mPresenter.getRecWorks();
    }
}
