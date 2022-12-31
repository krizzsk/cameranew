package us.pinguo.inspire.module.challenge;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import us.pinguo.foundation.utils.w;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.UploadWorkResult;
import us.pinguo.inspire.module.contact.ContactSearchActivity;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.discovery.entity.InspireFeedContent;
import us.pinguo.inspire.module.feeds.IFeedsView;
import us.pinguo.inspire.module.feeds.cell.FeedsFollowMoreCell;
import us.pinguo.inspire.module.feeds.cell.FeedsFollowTitleCell;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell;
import us.pinguo.inspire.module.feeds.cell.FeedsUploadStateCell;
import us.pinguo.inspire.module.feeds.cell.FeedsVideoCell;
import us.pinguo.inspire.module.feeds.model.FeedsFollowManager;
import us.pinguo.inspire.module.feeds.model.FeedsFollowPresenter;
import us.pinguo.inspire.module.feeds.model.FeedsHotManager;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.module.feeds.model.FeedsTopManager;
import us.pinguo.inspire.module.publish.event.UpdatePublishStateEvent;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.inspire.proxy.InspireStatistics;
import us.pinguo.user.R;
import us.pinguo.user.s0;
import us.pinguo.user.u0;
import us.pinguo.user.ui.view.CompatibleToolbar;
/* loaded from: classes9.dex */
public class FollowFragment extends ChallengeTabChildFragment implements IFeedsView {
    private static final int REQUEST_SEARCH = 11;
    private boolean mDataInited;
    private FeedsFollowPresenter mFollowPresenter;

    private FeedsUploadStateCell getCellByPublishData(PublishData publishData) {
        List<us.pinguo.widget.common.cell.recycler.b> cells = this.mAdapter.getCells();
        if (cells != null) {
            for (us.pinguo.widget.common.cell.recycler.b bVar : cells) {
                if (bVar instanceof FeedsUploadStateCell) {
                    FeedsUploadStateCell feedsUploadStateCell = (FeedsUploadStateCell) bVar;
                    if (publishData.clientId.equals(feedsUploadStateCell.getData().clientId)) {
                        return feedsUploadStateCell;
                    }
                }
            }
            return null;
        }
        return null;
    }

    private int indexToAddStateCell() {
        int insertIndex = FeedsTopManager.getInsertIndex(this.mAdapter.getCells(), FeedsUploadStateCell.class);
        if (insertIndex < 0) {
            insertIndex = 0;
        }
        while (insertIndex < this.mAdapter.getItemCount() && (this.mAdapter.getItem(insertIndex) instanceof FeedsUploadStateCell)) {
            insertIndex++;
        }
        return insertIndex;
    }

    private void initData() {
        if (s0.getInstance().e()) {
            SwipeRefreshLayout swipeRefreshLayout = this.mRefreshLayout;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.post(new Runnable() { // from class: us.pinguo.inspire.module.challenge.FollowFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((BaseAbsListFragment) FollowFragment.this).mRefreshLayout != null) {
                            ((BaseAbsListFragment) FollowFragment.this).mRefreshLayout.setRefreshing(true);
                        }
                    }
                });
            }
            FeedsFollowPresenter feedsFollowPresenter = new FeedsFollowPresenter();
            this.mFollowPresenter = feedsFollowPresenter;
            feedsFollowPresenter.attachView(this);
            this.mFollowPresenter.initData(getActivity());
            this.mDataInited = true;
            return;
        }
        showEmptyPage();
    }

    private void initTitle(View view) {
        CompatibleToolbar compatibleToolbar = (CompatibleToolbar) view.findViewById(R.id.toolbar_common);
        compatibleToolbar.setTitle(vStudio.Android.Camera360.R.string.inspire_follow);
        Toolbar b = compatibleToolbar.b();
        b.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        b.inflateMenu(vStudio.Android.Camera360.R.menu.find_friend_search_menu);
        b.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: us.pinguo.inspire.module.challenge.p
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return FollowFragment.this.l0(menuItem);
            }
        });
        b.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.challenge.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FollowFragment.this.n0(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ boolean l0(MenuItem menuItem) {
        startActivityForResult(new Intent(getActivity(), ContactSearchActivity.class), 11);
        us.pinguo.foundation.statistics.l.onEvent(getActivity(), "Community_Discovery_Search_Click");
        return true;
    }

    private void loadMoreData() {
        FeedsFollowPresenter feedsFollowPresenter = this.mFollowPresenter;
        if (feedsFollowPresenter != null) {
            feedsFollowPresenter.loadMore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0(View view) {
        getActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void p0() {
        if (this.mDataInited) {
            return;
        }
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(FeedsUploadStateCell feedsUploadStateCell, UpdatePublishStateEvent updatePublishStateEvent) {
        this.mAdapter.beginChange();
        this.mAdapter.remove(feedsUploadStateCell);
        if (updatePublishStateEvent.getInspireWork() != null) {
            InspireFeed convertWorkToFeed = InspireFeed.convertWorkToFeed(updatePublishStateEvent.getInspireWork());
            int insertIndex = FeedsTopManager.getInsertIndex(this.mAdapter.getCells(), FeedsPhotoCell.class);
            if (convertWorkToFeed != null) {
                if (convertWorkToFeed.type.equals("video")) {
                    this.mAdapter.add(insertIndex, new FeedsVideoCell(convertWorkToFeed));
                } else if (convertWorkToFeed.type.equals("photo") || convertWorkToFeed.type.equals(InspireFeed.TYPE_MULTI)) {
                    this.mAdapter.add(insertIndex, FeedsHotManager.initPhotoCell(convertWorkToFeed));
                }
                ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(insertIndex, us.pinguo.foundation.t.b.a.a(this.mRecyclerView.getContext(), 0.0f));
            }
        } else {
            us.pinguo.common.log.a.k("inspire work is null ", new Object[0]);
        }
        if (this.mAdapter.isEmpty()) {
            this.mAdapter.hideEmpty();
        }
        this.mAdapter.endChange(true);
    }

    private void refreshData() {
        FeedsFollowPresenter feedsFollowPresenter = this.mFollowPresenter;
        if (feedsFollowPresenter != null) {
            feedsFollowPresenter.refresh(getActivity());
        }
    }

    private void removeUploadStateCells() {
        List<us.pinguo.widget.common.cell.recycler.b> cells = this.mAdapter.getCells();
        ArrayList arrayList = new ArrayList();
        if (cells != null) {
            for (us.pinguo.widget.common.cell.recycler.b bVar : cells) {
                if (bVar.getType() == 14) {
                    arrayList.add(bVar);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.mAdapter.remove(this.mAdapter.indexOf((us.pinguo.widget.common.cell.recycler.b) arrayList.get(0)), this.mAdapter.indexOf((us.pinguo.widget.common.cell.recycler.b) arrayList.get(arrayList.size() - 1)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void s0(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            dialogInterface.dismiss();
        }
    }

    private void showEmptyPage() {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar == null) {
            return;
        }
        cVar.beginChange();
        showEmptyPageImpl();
        this.mAdapter.endChange(true);
    }

    private void showEmptyPageImpl() {
        if (!s0.getInstance().e()) {
            this.mAdapter.showLogin(getChildFragmentManager());
        } else if (!us.pinguo.util.q.f(getActivity())) {
            this.mAdapter.showError();
        } else {
            this.mAdapter.showEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void u0(FeedsUploadStateCell feedsUploadStateCell) {
        this.mAdapter.beginChange();
        this.mAdapter.remove(feedsUploadStateCell);
        if (this.mAdapter.isEmpty()) {
            this.mAdapter.hideEmpty();
        }
        this.mAdapter.endChange(true);
        w.k(getActivity(), R.string.upload_risky_image, us.pinguo.ui.R.string.ok, -999, false, m.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePublishStateEvent(final UpdatePublishStateEvent updatePublishStateEvent) {
        final FeedsUploadStateCell cellByPublishData = getCellByPublishData(updatePublishStateEvent.publishData);
        if (cellByPublishData != null) {
            PublishData publishData = updatePublishStateEvent.publishData;
            int i2 = publishData.state;
            if (i2 != 4) {
                if (i2 == 2) {
                    cellByPublishData.updateData(publishData);
                    return;
                } else if (i2 == 0) {
                    cellByPublishData.addTransferred(updatePublishStateEvent.transferred);
                    cellByPublishData.updateData(updatePublishStateEvent.publishData);
                    return;
                } else {
                    return;
                }
            } else if (publishData.isPhoto) {
                Map<String, UploadWorkResult> map = publishData.uploadResults;
                ArrayList arrayList = new ArrayList();
                for (UploadWorkResult uploadWorkResult : map.values()) {
                    if (!TextUtils.isEmpty(uploadWorkResult.data.memUrl)) {
                        arrayList.add(uploadWorkResult.data.memUrl);
                    }
                }
                us.pinguo.user.util.n.a.o(u0.m, arrayList, new Runnable() { // from class: us.pinguo.inspire.module.challenge.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        FollowFragment.this.r0(cellByPublishData, updatePublishStateEvent);
                    }
                }, new Runnable() { // from class: us.pinguo.inspire.module.challenge.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        FollowFragment.this.u0(cellByPublishData);
                    }
                }, new Runnable() { // from class: us.pinguo.inspire.module.challenge.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        FollowFragment.this.w0(cellByPublishData);
                    }
                });
                return;
            } else {
                this.mAdapter.beginChange();
                this.mAdapter.remove(cellByPublishData);
                if (updatePublishStateEvent.getInspireWork() != null) {
                    InspireFeed convertWorkToFeed = InspireFeed.convertWorkToFeed(updatePublishStateEvent.getInspireWork());
                    int insertIndex = FeedsTopManager.getInsertIndex(this.mAdapter.getCells(), FeedsPhotoCell.class);
                    if (convertWorkToFeed != null) {
                        if (convertWorkToFeed.type.equals("video")) {
                            this.mAdapter.add(insertIndex, new FeedsVideoCell(convertWorkToFeed));
                        } else if (convertWorkToFeed.type.equals("photo") || convertWorkToFeed.type.equals(InspireFeed.TYPE_MULTI)) {
                            this.mAdapter.add(insertIndex, FeedsHotManager.initPhotoCell(convertWorkToFeed));
                        }
                        ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(insertIndex, us.pinguo.foundation.t.b.a.a(this.mRecyclerView.getContext(), 0.0f));
                    }
                } else {
                    us.pinguo.common.log.a.k("inspire work is null ", new Object[0]);
                }
                if (this.mAdapter.isEmpty()) {
                    this.mAdapter.hideEmpty();
                }
                this.mAdapter.endChange(true);
                return;
            }
        }
        PublishData publishData2 = updatePublishStateEvent.publishData;
        if (publishData2.state == 4) {
            if (publishData2.isPhoto) {
                Map<String, UploadWorkResult> map2 = publishData2.uploadResults;
                ArrayList arrayList2 = new ArrayList();
                for (UploadWorkResult uploadWorkResult2 : map2.values()) {
                    if (!TextUtils.isEmpty(uploadWorkResult2.data.memUrl)) {
                        arrayList2.add(uploadWorkResult2.data.memUrl);
                    }
                }
                us.pinguo.user.util.n.a.o(u0.m, arrayList2, null, new Runnable() { // from class: us.pinguo.inspire.module.challenge.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        FollowFragment.this.z0();
                    }
                }, null);
                return;
            }
            return;
        }
        int indexToAddStateCell = indexToAddStateCell();
        FeedsUploadStateCell feedsUploadStateCell = new FeedsUploadStateCell(updatePublishStateEvent.publishData);
        us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(indexToAddStateCell - 1);
        if (item != null && (item instanceof FeedsUploadStateCell)) {
            feedsUploadStateCell.setDividerVisibility(true);
        } else {
            feedsUploadStateCell.setDividerVisibility(false);
        }
        this.mAdapter.add(indexToAddStateCell, feedsUploadStateCell);
        if (this.mAdapter.isEmpty()) {
            this.mAdapter.hideEmpty();
        }
        ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(indexToAddStateCell, us.pinguo.foundation.t.b.a.a(this.mRecyclerView.getContext(), indexToAddStateCell));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void w0(FeedsUploadStateCell feedsUploadStateCell) {
        this.mAdapter.beginChange();
        this.mAdapter.remove(feedsUploadStateCell);
        if (this.mAdapter.isEmpty()) {
            this.mAdapter.hideEmpty();
        }
        this.mAdapter.endChange(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void x0(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void z0() {
        w.k(getActivity(), R.string.upload_risky_image, us.pinguo.ui.R.string.ok, -999, false, l.a);
    }

    @Override // us.pinguo.inspire.module.feeds.IFeedsView
    public void addData(List<us.pinguo.widget.common.cell.recycler.b> list, boolean z) {
        this.mAdapter.appendCellsAndHideFooter(list);
        if (z) {
            disableLoadMore();
        }
        onRefreshComplete();
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected boolean canLoadMore() {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        return cVar == null || !(cVar.getItem(0) instanceof FeedsFollowTitleCell);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment
    public void checkAutoRefresh() {
        if (s0.getInstance().e()) {
            super.checkAutoRefresh();
        }
    }

    public RecyclerView checkScrollTo(InspireWork inspireWork, int i2) {
        int curIndex = FeedsList.getCurIndex(((us.pinguo.widget.common.cell.recycler.a) this.mRecyclerView.getAdapter()).getCells(), inspireWork);
        if (curIndex >= 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
            boolean z = curIndex >= linearLayoutManager.findFirstCompletelyVisibleItemPosition() && curIndex <= linearLayoutManager.findLastCompletelyVisibleItemPosition();
            us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(curIndex);
            if (item instanceof FeedsPhotoCell) {
                this.mRecyclerView.setTag(vStudio.Android.Camera360.R.id.tag_element_info, item);
            }
            if (!z) {
                this.mRecyclerView.getLayoutManager().scrollToPosition(curIndex);
            }
        }
        return this.mRecyclerView;
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment, us.pinguo.librouter.module.inspire.c
    public void clearNewStatus() {
    }

    @Override // us.pinguo.inspire.module.feeds.IFeedsView
    public void deleteWork(String str) {
        us.pinguo.user.recycler.c cVar;
        InspireFeedContent fcnt;
        if (TextUtils.isEmpty(str) || (cVar = this.mAdapter) == null || cVar.getItemCount() == 0) {
            return;
        }
        int itemCount = this.mAdapter.getItemCount();
        for (int i2 = 0; i2 < itemCount; i2++) {
            us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(i2);
            if (item != null && (item.getData() instanceof InspireFeed) && (fcnt = ((InspireFeed) item.getData()).getFcnt()) != null && str.equals(fcnt.workId)) {
                this.mAdapter.remove(i2);
                return;
            }
        }
    }

    @Override // us.pinguo.inspire.module.feeds.IFeedsView
    public void disableLoadMore() {
        setLoadMoreEnabled(false);
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar == null || (cVar.getItem(cVar.getItemCount() - 1) instanceof FeedsFollowMoreCell)) {
            return;
        }
        this.mAdapter.showNoMoreContent();
    }

    @Override // us.pinguo.inspire.module.feeds.IFeedsView
    public void enableLoadMore() {
        setLoadMoreEnabled(true);
    }

    @Override // us.pinguo.inspire.module.feeds.IFeedsView
    public us.pinguo.widget.common.cell.recycler.a getAdapter() {
        return this.mAdapter;
    }

    public View getChangedShareElement(InspireWork inspireWork) {
        us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(FeedsList.getCurIndex(((us.pinguo.widget.common.cell.recycler.a) this.mRecyclerView.getAdapter()).getCells(), inspireWork));
        if (item instanceof FeedsPhotoCell) {
            return ((FeedsPhotoCell) item).getChangedShareElement();
        }
        if (item instanceof FeedsVideoCell) {
            return ((FeedsVideoCell) item).getChangedShareElement();
        }
        return null;
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment
    public boolean getNewStatus() {
        return false;
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment
    protected String getPageKey() {
        return "portal_follow_page";
    }

    @Override // us.pinguo.inspire.module.feeds.IFeedsView
    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment, us.pinguo.inspire.base.BaseAbsListFragment
    public SwipeRefreshLayout getRefreshLayout(View view) {
        return (SwipeRefreshLayout) view.findViewById(vStudio.Android.Camera360.R.id.base_list_layout_res_0x7d06001b);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected View inflateRootView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(vStudio.Android.Camera360.R.layout.feeds_follow_fragment, viewGroup, false);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void initDefaultTitle(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment, us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 11) {
            triggerRefresh();
        }
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment, us.pinguo.librouter.module.inspire.c
    public void onAdvDataChange() {
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment, us.pinguo.librouter.module.inspire.c
    public boolean onBackPressed() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment, us.pinguo.inspire.base.BaseAbsListFragment
    public void onDataRefresh() {
        super.onDataRefresh();
        if (!this.mDataInited) {
            initData();
            onRefreshComplete();
            return;
        }
        refreshData();
        setLoadMoreEnabled(true);
    }

    @Override // us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FeedsFollowPresenter feedsFollowPresenter = this.mFollowPresenter;
        if (feedsFollowPresenter != null) {
            feedsFollowPresenter.detachView();
        }
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment
    public void onHide() {
        super.onHide();
        InspireStatistics.onPageEnd("portal_follow_page");
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onLoadMore() {
        loadMoreData();
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment, us.pinguo.librouter.module.inspire.c
    public void onLogin() {
        FeedsFollowManager.clearTime();
        this.mAdapter.clear();
        triggerRefresh();
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment, us.pinguo.librouter.module.inspire.c
    public void onLogout() {
        FeedsFollowManager.clearTime();
        FeedsFollowManager.clearRecCloseTime();
        if (this.mFollowPresenter == null || this.mAdapter == null) {
            return;
        }
        showEmptyPage();
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment, us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mPaused = true;
        super.onPause();
        us.pinguo.foundation.statistics.f.b("follow_user_work_list_page", true);
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment, us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        us.pinguo.foundation.statistics.f.c("follow_user_work_list_page");
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment
    public void onShow() {
        super.onShow();
        if (!this.mDataInited) {
            new Handler().post(new Runnable() { // from class: us.pinguo.inspire.module.challenge.o
                @Override // java.lang.Runnable
                public final void run() {
                    FollowFragment.this.p0();
                }
            });
        } else {
            us.pinguo.user.recycler.c cVar = this.mAdapter;
            if (cVar != null && ((cVar.isError() || this.mAdapter.isEmpty()) && !this.mRefreshLayout.isRefreshing())) {
                triggerRefresh();
            }
        }
        InspireStatistics.onPageStart("portal_follow_page");
    }

    @Override // us.pinguo.inspire.cell.recycler.PortalChildFragment, us.pinguo.librouter.module.inspire.c
    public void onTabClickWhenSelected() {
        super.onTabClickWhenSelected();
    }

    @Override // us.pinguo.inspire.module.feeds.IFeedsView
    public void onUpdatePublishStateEvent(final UpdatePublishStateEvent updatePublishStateEvent) {
        if (this.mAdapter == null) {
            new Handler().postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.challenge.FollowFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    if (((BaseAbsListFragment) FollowFragment.this).mAdapter != null) {
                        FollowFragment.this.updatePublishStateEvent(updatePublishStateEvent);
                    }
                }
            }, 200L);
        } else {
            updatePublishStateEvent(updatePublishStateEvent);
        }
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabChildFragment, us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mDataInited = false;
        initData();
        initTitle(view);
        FeedsFollowManager.setPublishDataToFail();
    }

    @Override // us.pinguo.inspire.module.feeds.IFeedsView
    public void refreshFeedsAfterTopCells(List<us.pinguo.widget.common.cell.recycler.b> list) {
        us.pinguo.user.recycler.c cVar;
        if (list == null || (cVar = this.mAdapter) == null) {
            return;
        }
        cVar.beginChange();
        if (this.mAdapter.isError()) {
            this.mAdapter.hideError();
        }
        if (this.mAdapter.isEmpty()) {
            this.mAdapter.hideEmpty();
        }
        int topCellCount = FeedsTopManager.getTopCellCount(this.mAdapter.getCells());
        if (topCellCount >= 0) {
            us.pinguo.user.recycler.c cVar2 = this.mAdapter;
            cVar2.remove(topCellCount, cVar2.getItemCount());
        }
        this.mAdapter.addAll(list);
        if (this.mAdapter.getItemCount() == 0) {
            showEmptyPageImpl();
        }
        this.mAdapter.endChange(true);
        this.mVideoPresenter.onDataRefreshed();
        this.mRecyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: us.pinguo.inspire.module.challenge.FollowFragment.2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ((BaseAbsListFragment) FollowFragment.this).mRecyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                us.pinguo.user.util.e.a.a(((BaseAbsListFragment) FollowFragment.this).mRecyclerView);
                return false;
            }
        });
    }

    @Override // us.pinguo.inspire.module.feeds.IFeedsView
    public void setData(List<us.pinguo.widget.common.cell.recycler.b> list) {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar != null) {
            cVar.set(list);
        }
        us.pinguo.user.util.e.a.a(this.mRecyclerView);
    }

    @Override // us.pinguo.inspire.module.feeds.IFeedsView
    public void showErrorWhenEmpty() {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar != null) {
            if (cVar.getItemCount() == 0 || this.mAdapter.isEmpty()) {
                us.pinguo.user.recycler.c cVar2 = this.mAdapter;
                cVar2.showError(FeedsTopManager.getTopCellCount(cVar2.getCells()));
            }
        }
    }

    @Override // us.pinguo.inspire.module.feeds.IFeedsView
    public void stopRefreshAnim() {
        onRefreshComplete();
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void triggerFirstRefresh(View view) {
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected boolean useDefaultPageStatistic() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.inspire.base.BaseAbsListFragment
    public us.pinguo.inspire.widget.videocell.e initAdapter() {
        return new us.pinguo.inspire.widget.videocell.e();
    }
}
