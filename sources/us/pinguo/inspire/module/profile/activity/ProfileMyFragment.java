package us.pinguo.inspire.module.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action1;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.inspire.base.SlipHeaderAbsListFragment;
import us.pinguo.inspire.event.ShowProfileRecommendEvent;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.attention.AttentionActivity;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.attention.IntentAttention;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
import us.pinguo.inspire.module.feeds.FeedsDecoration;
import us.pinguo.inspire.module.feeds.cell.FeedsInterestCell;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell;
import us.pinguo.inspire.module.feeds.cell.FeedsVideoCell;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.module.message.category.type.InspireRelation;
import us.pinguo.inspire.module.profile.GridSpaceDecoration;
import us.pinguo.inspire.module.profile.IProfileView;
import us.pinguo.inspire.module.profile.ProfileAdapter;
import us.pinguo.inspire.module.profile.ProfileOnScrollListener;
import us.pinguo.inspire.module.profile.ProfilePresenter;
import us.pinguo.inspire.module.profile.cell.ProfileFeedsCell;
import us.pinguo.inspire.module.profile.cell.ProfileFeedsVideoCell;
import us.pinguo.inspire.module.profile.cell.ProfileGridItemCell;
import us.pinguo.inspire.module.profile.cell.ProfileHeaderCell;
import us.pinguo.inspire.module.profile.fragment.GuestPortraitDialogFragment;
import us.pinguo.inspire.module.profile.fragment.UserPortraitDialogFragment;
import us.pinguo.inspire.module.profile.view.ProfileHeaderTabView;
import us.pinguo.inspire.module.publish.event.UpdatePublishStateEvent;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.inspire.widget.photopager.FullScreenPhoto;
import us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment;
import us.pinguo.user.EditInfoActivity;
import us.pinguo.user.User;
import us.pinguo.user.event.QueryUserVipInfoDoneEvent;
import us.pinguo.user.model.ProfileAuthorInfo;
import us.pinguo.user.recycler.FlingFilterRecyclerView;
import us.pinguo.user.recycler.FocusChildRecyclerView;
import us.pinguo.user.s0;
import us.pinguo.util.q;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public abstract class ProfileMyFragment extends SlipHeaderAbsListFragment implements ProfileAdapter.OnHeaderSwitchListener, IProfileView, us.pinguo.librouter.module.inspire.c, ProfileHeaderTabView.OnTabViewSelectListener, AttentionButton.g {
    public static final int LOGIN_REQ = 1;
    private static final int PERSONAL_CODE = 2;
    private static final int REQ_EDIT_INFO = 3;
    public AttentionButton mGuestAttentionBtn;
    private RecyclerView.ItemDecoration mItemDecoration;
    private GridLayoutManager mLayoutManager;
    private ProfileAdapter mProfileAdapter;
    ProfileOnScrollListener mProfileOnScrollListener;
    protected ProfilePresenter mProfilePresenter;
    public Toolbar mToolbar;
    protected ProfileHeaderTabView.State mState = ProfileHeaderTabView.State.STORY;
    private us.pinguo.user.a1.m mLoadingCell = new us.pinguo.user.a1.m(null);
    private boolean addAttentionSuccess = false;
    private Runnable showRefreshingRunnable = new Runnable() { // from class: us.pinguo.inspire.module.profile.activity.ProfileMyFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (((BaseAbsListFragment) ProfileMyFragment.this).mRefreshLayout != null) {
                ((BaseAbsListFragment) ProfileMyFragment.this).mRefreshLayout.setRefreshing(true);
            }
        }
    };
    private boolean showFirst = true;

    private void addShadow(View view) {
        View view2 = new View(view.getContext());
        view2.setAlpha(0.0f);
        view2.setId(R.id.feeds_title_shadow);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, us.pinguo.foundation.t.b.a.a(view.getContext(), 4.0f));
        layoutParams.addRule(3, view.getId());
        view2.setBackgroundResource(us.pinguo.ui.R.drawable.feeds_divider_shadow_top);
        ((RelativeLayout) view.getParent()).addView(view2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(View view) {
        getActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0(View view) {
        onClickEdit(this.mProfilePresenter.getHeaderAuthorInfo());
    }

    private RecyclerView.ItemDecoration getDividerDecoration(boolean z) {
        if (getCurrentShowStyle(z) == 0) {
            return new GridSpaceDecoration();
        }
        return new us.pinguo.inspire.cell.recycler.c(getActivity(), 12, 2, false);
    }

    private List<us.pinguo.widget.common.cell.recycler.b> getWorkCells(List<InspireWork> list, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (i2 == 0) {
            while (i3 < list.size()) {
                arrayList.add(new ProfileGridItemCell(list.get(i3)));
                i3++;
            }
        } else {
            while (i3 < list.size()) {
                InspireWork inspireWork = list.get(i3);
                if (inspireWork.isVideo()) {
                    arrayList.add(new ProfileFeedsVideoCell(inspireWork));
                } else {
                    arrayList.add(new ProfileFeedsCell(inspireWork));
                }
                i3++;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(View view) {
        FragmentActivity activity = getActivity();
        if (activity instanceof ProfileActivity) {
            ((ProfileActivity) activity).publish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(us.pinguo.foundation.r.b bVar) {
        if (User.d().n()) {
            this.mProfilePresenter.attachView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void m0(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void o0(ShowProfileRecommendEvent showProfileRecommendEvent) {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar == null || !(cVar.getItem(0) instanceof ProfileHeaderCell)) {
            return;
        }
        ((ProfileHeaderCell) this.mAdapter.getItem(0)).onEvent(showProfileRecommendEvent);
    }

    private void onClickEdit(ProfileAuthorInfo profileAuthorInfo) {
        Intent intent = new Intent(getActivity(), EditInfoActivity.class);
        intent.putExtra("author_info", profileAuthorInfo);
        startActivityForResult(intent, 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p0(Throwable th) {
        us.pinguo.common.log.a.f(th);
        Inspire.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        showLoadingData();
        this.mProfilePresenter.fetchProfileList(getAuthorId(), 0L);
    }

    private void registerShowRecommend() {
        addSubscription(us.pinguo.foundation.r.d.a().c(ShowProfileRecommendEvent.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.activity.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfileMyFragment.this.o0((ShowProfileRecommendEvent) obj);
            }
        }, j.a));
    }

    private void registerUpdatePublishStateEvent() {
        addSubscription(us.pinguo.foundation.r.d.a().c(UpdatePublishStateEvent.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.activity.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfileMyFragment.this.t0((UpdatePublishStateEvent) obj);
            }
        }, c.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0(UpdatePublishStateEvent updatePublishStateEvent) {
        PublishData publishData;
        if (updatePublishStateEvent == null || (publishData = updatePublishStateEvent.publishData) == null || publishData.state != 4) {
            return;
        }
        new Handler().post(new Runnable() { // from class: us.pinguo.inspire.module.profile.activity.h
            @Override // java.lang.Runnable
            public final void run() {
                ProfileMyFragment.this.r0();
            }
        });
    }

    private void setProfileCloseAnim() {
        initSlipHeaderScroll(this.mToolbar);
        updateToolbar();
    }

    private void showLoadingData() {
        setLoadMoreEnabled(false);
        this.mAdapter.beginChange();
        if (this.mAdapter.getItemCount() > 1) {
            us.pinguo.user.recycler.c cVar = this.mAdapter;
            cVar.remove(1, cVar.getItemCount() - 1);
        }
        this.mLoadingCell.c(1);
        this.mLoadingCell.b(-1118482);
        this.mAdapter.add(this.mLoadingCell);
        this.mAdapter.endChange(true);
    }

    private void updateToolbar() {
        ProfileAuthorInfo headerAuthorInfo = this.mProfilePresenter.getHeaderAuthorInfo();
        this.mToolbar.setTitle(headerAuthorInfo.nickname);
        this.mToolbar.setTitleTextColor(0);
        this.mToolbar.setTitleTextAppearance(getActivity(), us.pinguo.user.R.style.ToolBar_TextSize);
        this.mToolbar.getMenu().clear();
        this.mToolbar.inflateMenu(R.menu.profile_cancel_attention_meun);
        us.pinguo.common.log.a.m("FUCK TOOLBAR", "update Toolbar..new.............", new Object[0]);
        boolean equals = s0.getInstance().getUserId().equals(getAuthorId());
        this.mToolbar.getMenu().clear();
        if (equals) {
            this.mToolbar.findViewById(R.id.profile_item_edit).setVisibility(0);
            if (getActivity() instanceof ProfileActivity) {
                this.mToolbar.findViewById(R.id.btn_publish).setVisibility(0);
            } else {
                this.mToolbar.findViewById(R.id.btn_publish).setVisibility(4);
            }
            this.mGuestAttentionBtn.setVisibility(8);
            return;
        }
        this.mToolbar.findViewById(R.id.profile_item_edit).setVisibility(8);
        this.mToolbar.findViewById(R.id.btn_publish).setVisibility(8);
        this.mGuestAttentionBtn.setVisibility(0);
        this.mGuestAttentionBtn.i(headerAuthorInfo, true, getAuthorId(), getResources().getColor(us.pinguo.ui.R.color.white), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void w0(List list) {
        if (list.size() == 0) {
            RecyclerView.ItemDecoration itemDecoration = this.mItemDecoration;
            if (itemDecoration != null && (itemDecoration instanceof FeedsDecoration)) {
                this.mRecyclerView.removeItemDecoration(itemDecoration);
            }
            if (getAuthorId().equals(s0.getInstance().getUserId())) {
                us.pinguo.inspire.base.c.g(this.mAdapter, true);
            } else {
                us.pinguo.inspire.base.c.g(this.mAdapter, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void y0() {
        this.mRecyclerView.removeCallbacks(this.showRefreshingRunnable);
        onRefreshComplete();
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void addAttention(InspireAttention inspireAttention) {
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void appendData(List<InspireWork> list) {
        if (list != null && list.size() != 0) {
            this.mProfileAdapter.addAll(getWorkCells(list, getCurrentShowStyle(this.mState == ProfileHeaderTabView.State.STORY)));
            return;
        }
        us.pinguo.common.log.a.m("FK", "profile no more content", new Object[0]);
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar != null) {
            cVar.showNoMoreContent();
        }
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void cancelAttention(InspireAttention inspireAttention) {
    }

    public RecyclerView checkScrollTo(InspireWork inspireWork, int i2) {
        int curIndex = FeedsList.getCurIndex(((us.pinguo.widget.common.cell.recycler.a) this.mRecyclerView.getAdapter()).getCells(), inspireWork);
        if (curIndex >= 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
            boolean z = curIndex >= linearLayoutManager.findFirstCompletelyVisibleItemPosition() && curIndex <= linearLayoutManager.findLastCompletelyVisibleItemPosition();
            us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(curIndex);
            if (item instanceof FeedsPhotoCell) {
                this.mRecyclerView.setTag(R.id.tag_element_info, item);
            }
            if (!z) {
                this.mRecyclerView.getLayoutManager().scrollToPosition(curIndex);
            }
        }
        return this.mRecyclerView;
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void clearNewStatus() {
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void deleteWork(String str) {
        List cells = this.mProfileAdapter.getCells();
        int i2 = 0;
        while (true) {
            if (i2 >= cells.size()) {
                i2 = -1;
                break;
            }
            us.pinguo.widget.common.cell.recycler.b bVar = (us.pinguo.widget.common.cell.recycler.b) cells.get(i2);
            if (bVar instanceof ProfileFeedsCell) {
                if (((ProfileFeedsCell) bVar).getWorkId().equals(str)) {
                    break;
                }
                i2++;
            } else if (bVar instanceof ProfileFeedsVideoCell) {
                if (((ProfileFeedsVideoCell) bVar).getWorkId().equals(str)) {
                    break;
                }
                i2++;
            } else {
                if (bVar instanceof ProfileGridItemCell) {
                    String workId = ((ProfileGridItemCell) bVar).getWorkId();
                    if (!TextUtils.isEmpty(workId) && workId.equals(str)) {
                        break;
                    }
                } else {
                    continue;
                }
                i2++;
            }
        }
        if (i2 != -1) {
            us.pinguo.common.log.a.m("zhouwei", "profile delete success ", new Object[0]);
            this.mProfileAdapter.remove(i2);
        }
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public String getAuthorId() {
        return getUserId();
    }

    public List<us.pinguo.widget.common.cell.recycler.b> getCells(List<InspireWork> list, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(list);
        FeedsInterestCell feedsInterestCell = this.mAdapter.getItem(0) instanceof ProfileHeaderCell ? ((ProfileHeaderCell) this.mAdapter.getItem(0)).getFeedsInterestCell() : null;
        ProfileHeaderCell profileHeaderCell = new ProfileHeaderCell(this.mProfilePresenter.getHeaderAuthorInfo(), getActivity());
        profileHeaderCell.setFeedsInterestCell(feedsInterestCell);
        profileHeaderCell.setOnTabViewSelectListener(this);
        profileHeaderCell.setOnHeaderSwitchListener(this);
        profileHeaderCell.setState(this.mState);
        arrayList.add(profileHeaderCell);
        arrayList.addAll(getWorkCells(arrayList2, i2));
        return arrayList;
    }

    public View getChangedShareElement(InspireWork inspireWork) {
        us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(FeedsList.getCurIndex(((us.pinguo.widget.common.cell.recycler.a) this.mRecyclerView.getAdapter()).getCells(), inspireWork));
        if (item instanceof FeedsPhotoCell) {
            return ((FeedsPhotoCell) item).getChangedShareElement();
        }
        if (item instanceof FeedsVideoCell) {
            return ((FeedsVideoCell) item).getChangedShareElement();
        }
        if (item instanceof ProfileGridItemCell) {
            return ((ProfileGridItemCell) item).getShareElement();
        }
        return null;
    }

    protected abstract int getCurrentShowStyle(boolean z);

    @Override // us.pinguo.inspire.cell.recycler.PortalChildFragment, us.pinguo.librouter.module.inspire.c
    public Fragment getFragment() {
        return this;
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public Context getFragmentContext() {
        return getContext();
    }

    public boolean getNewStatus() {
        return false;
    }

    @Override // us.pinguo.inspire.base.SlipHeaderAbsListFragment
    public us.pinguo.inspire.base.d getScrollListener(Toolbar toolbar, us.pinguo.inspire.cell.recycler.d dVar) {
        if (this.mProfileOnScrollListener == null) {
            this.mProfileOnScrollListener = new ProfileOnScrollListener(toolbar, dVar, getActivity() instanceof ProfileActivity);
            this.mProfileOnScrollListener.setMyProfile(getAuthorId().equals(s0.getInstance().getUserId()));
        }
        return this.mProfileOnScrollListener;
    }

    public abstract String getUserId();

    public abstract boolean handleLogin();

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void hideEmpty() {
        this.mProfileAdapter.hideEmpty();
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void hideError() {
        this.mProfileAdapter.hideError();
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void hideLoadMore() {
        this.mProfileAdapter.hideFooter();
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void hideLoading() {
        onRefreshComplete();
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initHeaderTitleBar(View view) {
        View findViewById = view.findViewById(R.id.base_fragment_title_container_res_0x7d060019);
        findViewById.setVisibility(0);
        addShadow(findViewById);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.base_fragment_header_tool_bar_res_0x7d060017);
        this.mToolbar = toolbar;
        toolbar.setNavigationIcon(getContext().getResources().getDrawable(us.pinguo.ui.R.drawable.navigation_back_white));
        this.mToolbar.getNavigationIcon().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.profile.activity.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileMyFragment.this.f0(view2);
            }
        });
        AttentionButton attentionButton = (AttentionButton) this.mToolbar.findViewById(R.id.header_toolbar_custom_view);
        this.mGuestAttentionBtn = attentionButton;
        attentionButton.setAttentionStyle(new AttentionButton.h() { // from class: us.pinguo.inspire.module.profile.activity.ProfileMyFragment.2
            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void animingStyle(AttentionButton attentionButton2) {
            }

            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void followedStyle(AttentionButton attentionButton2) {
                attentionButton2.setBackgroundResource(R.drawable.bg_followed_profile);
                attentionButton2.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }

            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void friendStyle(AttentionButton attentionButton2) {
                attentionButton2.setBackgroundResource(R.drawable.bg_friends_profile);
                attentionButton2.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }

            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void unFollowedStyle(AttentionButton attentionButton2) {
                attentionButton2.setBackgroundResource(R.drawable.bg_unfollow_profile);
                attentionButton2.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }
        });
        this.mGuestAttentionBtn.setAttentionListener(this);
        this.mToolbar.findViewById(R.id.profile_item_edit).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.profile.activity.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileMyFragment.this.h0(view2);
            }
        });
        this.mToolbar.findViewById(R.id.btn_publish).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.profile.activity.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileMyFragment.this.j0(view2);
            }
        });
        registerUpdatePublishStateEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        initView(recyclerView, aVar);
        recyclerView.setClipChildren(false);
        if (recyclerView instanceof FocusChildRecyclerView) {
            ((FocusChildRecyclerView) recyclerView).setGetFocusChild(new FocusChildRecyclerView.a() { // from class: us.pinguo.inspire.module.profile.activity.ProfileMyFragment.1
                @Override // us.pinguo.user.recycler.FocusChildRecyclerView.a
                public View getFocusChild(FocusChildRecyclerView focusChildRecyclerView) {
                    if ((((BaseAbsListFragment) ProfileMyFragment.this).mAdapter.getItem(0) instanceof ProfileHeaderCell) && ((LinearLayoutManager) focusChildRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) {
                        us.pinguo.common.log.a.k("hack getFocusedChild , return first", new Object[0]);
                        return focusChildRecyclerView.getChildAt(0);
                    }
                    return focusChildRecyclerView.superGetFocusedChild();
                }
            });
        }
    }

    public void initView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        this.mLayoutManager = gridLayoutManager;
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView.ItemDecoration dividerDecoration = getDividerDecoration(true);
        this.mItemDecoration = dividerDecoration;
        if (dividerDecoration != null) {
            recyclerView.addItemDecoration(dividerDecoration);
        }
        recyclerView.setAdapter(aVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ProfileHeaderCell(new ProfileAuthorInfo(), getActivity()));
        aVar.setCells(arrayList);
        this.mProfilePresenter = new ProfilePresenter();
        if (handleLogin() && !s0.getInstance().e()) {
            registerLoginEvent();
            us.pinguo.foundation.statistics.h.a.g("", "personal_center", "show");
            s0.getInstance().a(getActivity(), 0, "personal_center");
            return;
        }
        this.mProfilePresenter.attachView(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 1 && i2 == 2) {
            getActivity().setResult(i3);
            getActivity().finish();
        }
    }

    @Override // us.pinguo.inspire.widget.AttentionButton.g
    public void onAddAttentionFail(Throwable th) {
    }

    @Override // us.pinguo.inspire.widget.AttentionButton.g
    public void onAddAttentionSuccess(InspireAttention inspireAttention) {
        this.mProfilePresenter.fetchRecommendList(getAuthorId());
        this.addAttentionSuccess = true;
        List<InspireWork> myFavoriteList = this.mProfilePresenter.getMyFavoriteList();
        List<InspireWork> myWorkList = this.mProfilePresenter.getMyWorkList();
        for (int i2 = 0; myFavoriteList != null && i2 < myFavoriteList.size(); i2++) {
            myFavoriteList.get(i2).setRelation(inspireAttention.getRelation());
        }
        for (int i3 = 0; myWorkList != null && i3 < myWorkList.size(); i3++) {
            myWorkList.get(i3).setRelation(inspireAttention.getRelation());
        }
    }

    public abstract /* synthetic */ void onAdvDataChange();

    @Override // us.pinguo.librouter.module.inspire.c
    public boolean onBackPressed() {
        return false;
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onDataRefresh() {
        us.pinguo.inspire.widget.videocell.f fVar = this.mVideoPresenter;
        if (fVar != null) {
            fVar.stopCurrentVideo();
        }
        ProfilePresenter profilePresenter = this.mProfilePresenter;
        if (profilePresenter != null) {
            ProfileHeaderTabView.State state = this.mState;
            if (state == ProfileHeaderTabView.State.STORY) {
                profilePresenter.fetchProfileList(getUserId(), 0L);
            } else if (state == ProfileHeaderTabView.State.LIKE) {
                profilePresenter.fetchMyFavoriteList(getUserId(), 0L, 30);
            } else if (state == ProfileHeaderTabView.State.FLOWER) {
                profilePresenter.fetchMyFlowerList(getUserId(), 0L, 30);
            }
            if (this.addAttentionSuccess) {
                this.mProfilePresenter.fetchRecommendList(getAuthorId());
            }
        }
    }

    @Override // us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ProfilePresenter profilePresenter = this.mProfilePresenter;
        if (profilePresenter != null) {
            profilePresenter.detachView();
        }
        ProfileHeaderCell.restore();
    }

    public void onEvent(QueryUserVipInfoDoneEvent queryUserVipInfoDoneEvent) {
        us.pinguo.common.log.a.k("QueryUserVipInfoDoneEvent event = " + queryUserVipInfoDoneEvent.d(), new Object[0]);
        if (this.mAdapter.getItem(0) instanceof ProfileHeaderCell) {
            ((ProfileHeaderCell) this.mAdapter.getItem(0)).updateVipIcon(queryUserVipInfoDoneEvent.d().booleanValue());
        }
    }

    @Override // us.pinguo.inspire.module.profile.ProfileAdapter.OnHeaderSwitchListener
    public void onLaunchPersonalCenter(View view, ProfileAuthorInfo profileAuthorInfo) {
        PortraitImageView portraitImageView;
        ProfileHeaderCell.ProfileHeaderHolder profileHeaderHolder = (ProfileHeaderCell.ProfileHeaderHolder) ((ProfileHeaderCell) this.mAdapter.getItem(0)).mViewHolder;
        if (profileHeaderHolder == null || (portraitImageView = profileHeaderHolder.avatar) == null) {
            return;
        }
        Bitmap bitmap = portraitImageView.getBitmap();
        Rect rect = new Rect();
        int[] iArr = new int[2];
        final PortraitImageView portraitImageView2 = profileHeaderHolder.avatar;
        portraitImageView2.getLocationInWindow(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + profileHeaderHolder.avatar.getWidth(), iArr[1] + profileHeaderHolder.avatar.getHeight());
        FullScreenPhoto fullScreenPhoto = new FullScreenPhoto();
        fullScreenPhoto.rect = rect;
        fullScreenPhoto.photo = new InspireFeedPhoto();
        if (profileAuthorInfo.avatar.endsWith("-200")) {
            InspireFeedPhoto inspireFeedPhoto = fullScreenPhoto.photo;
            String str = profileAuthorInfo.avatar;
            inspireFeedPhoto.url = str.substring(0, str.length() - 4);
        } else {
            fullScreenPhoto.photo.url = profileAuthorInfo.avatar;
        }
        fullScreenPhoto.photo.width = us.pinguo.foundation.t.b.a.j(view.getContext());
        fullScreenPhoto.photo.height = us.pinguo.foundation.t.b.a.j(view.getContext());
        String userId = s0.getInstance().getUserId();
        if (!TextUtils.isEmpty(userId) && userId.equals(profileAuthorInfo.userId)) {
            fullScreenPhoto.topOffset = us.pinguo.foundation.t.b.a.a(portraitImageView2.getContext(), 80.0f);
            UserPortraitDialogFragment.showFullScreenPics(getFragmentManager(), bitmap, profileAuthorInfo, fullScreenPhoto, new PictureViewPagerDialogFragment.c() { // from class: us.pinguo.inspire.module.profile.activity.ProfileMyFragment.3
                @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment.c
                public Rect getPicRect(int i2) {
                    Rect rect2 = new Rect();
                    int[] iArr2 = new int[2];
                    portraitImageView2.getLocationInWindow(iArr2);
                    rect2.set(iArr2[0], iArr2[1], iArr2[0] + portraitImageView2.getWidth(), iArr2[1] + portraitImageView2.getHeight());
                    return rect2;
                }
            });
            return;
        }
        if (profileAuthorInfo.getRelation() == InspireRelation.FANS.ordinal() || profileAuthorInfo.getRelation() == InspireRelation.NONE.ordinal() || profileAuthorInfo.getRelation() == -1) {
            fullScreenPhoto.topOffset = us.pinguo.foundation.t.b.a.a(portraitImageView2.getContext(), 80.0f);
        }
        GuestPortraitDialogFragment.showFullScreenPics(getFragmentManager(), bitmap, profileAuthorInfo, fullScreenPhoto, new PictureViewPagerDialogFragment.c() { // from class: us.pinguo.inspire.module.profile.activity.ProfileMyFragment.4
            @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment.c
            public Rect getPicRect(int i2) {
                Rect rect2 = new Rect();
                int[] iArr2 = new int[2];
                portraitImageView2.getLocationInWindow(iArr2);
                rect2.set(iArr2[0], iArr2[1], iArr2[0] + portraitImageView2.getWidth(), iArr2[1] + portraitImageView2.getHeight());
                return rect2;
            }
        });
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onLoadMore() {
        ProfileHeaderTabView.State state = this.mState;
        if (state == ProfileHeaderTabView.State.STORY) {
            List<InspireWork> myWorkList = this.mProfilePresenter.getMyWorkList();
            if (myWorkList != null && myWorkList.size() != 0) {
                this.mProfilePresenter.loadMoreWorks(getAuthorId(), myWorkList.get(myWorkList.size() - 1).uploadTime);
            } else {
                hideLoadMore();
                return;
            }
        } else if (state == ProfileHeaderTabView.State.LIKE) {
            this.mProfilePresenter.loadMoreFavarite(30, getAuthorId());
        } else if (state == ProfileHeaderTabView.State.FLOWER) {
            this.mProfilePresenter.loadMoreFlowerWork(30, getAuthorId());
        }
        if (q.f(getActivity()) || !this.showFirst) {
            return;
        }
        this.showFirst = false;
        Toast.makeText(getContext(), getString(us.pinguo.ui.R.string.network_not_available), 0).show();
    }

    public abstract /* synthetic */ void onLogin();

    public abstract /* synthetic */ void onLogout();

    @Override // us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PGEventBus.getInstance().c(this);
    }

    @Override // us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        GridLayoutManager gridLayoutManager;
        super.onResume();
        PGEventBus.getInstance().b(this);
        if (this.mToolbar == null || (gridLayoutManager = this.mLayoutManager) == null || gridLayoutManager.findFirstCompletelyVisibleItemPosition() != 0) {
            return;
        }
        this.mToolbar.getNavigationIcon().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onSelected() {
    }

    @Override // us.pinguo.inspire.module.profile.ProfileAdapter.OnHeaderSwitchListener
    public void onStyleSwitch(int i2) {
        List<InspireWork> myFavoriteList;
        boolean z;
        List<us.pinguo.widget.common.cell.recycler.b> cells;
        ProfileHeaderTabView.State state = this.mState;
        if (state == ProfileHeaderTabView.State.STORY) {
            myFavoriteList = this.mProfilePresenter.getMyWorkList();
            if (myFavoriteList == null || myFavoriteList.size() == 0) {
                return;
            }
            z = true;
        } else {
            if (state == ProfileHeaderTabView.State.FLOWER) {
                myFavoriteList = this.mProfilePresenter.getMyFlowerList();
                if (myFavoriteList == null || myFavoriteList.size() == 0) {
                    return;
                }
            } else {
                myFavoriteList = this.mProfilePresenter.getMyFavoriteList();
                if (myFavoriteList == null || myFavoriteList.size() == 0) {
                    return;
                }
            }
            z = false;
        }
        if (i2 == 0) {
            cells = getCells(myFavoriteList, 0, z);
        } else {
            cells = getCells(myFavoriteList, 1, z);
        }
        RecyclerView.ItemDecoration itemDecoration = this.mItemDecoration;
        if (itemDecoration != null) {
            this.mRecyclerView.removeItemDecoration(itemDecoration);
        }
        RecyclerView.ItemDecoration dividerDecoration = getDividerDecoration(z);
        this.mItemDecoration = dividerDecoration;
        if (dividerDecoration != null && !us.pinguo.foundation.utils.k.a(myFavoriteList)) {
            this.mRecyclerView.addItemDecoration(this.mItemDecoration);
        }
        this.mProfileAdapter.set(cells);
    }

    @Override // us.pinguo.inspire.module.profile.view.ProfileHeaderTabView.OnTabViewSelectListener
    public void onTabSelect(View view, ProfileHeaderTabView.State state) {
        ProfileHeaderCell profileHeaderCell = (ProfileHeaderCell) this.mAdapter.getItem(0);
        ProfileHeaderTabView.State state2 = ProfileHeaderTabView.State.STORY;
        if (state == state2) {
            this.mState = state;
            showLoadingData();
            this.mState = state2;
            if (profileHeaderCell != null) {
                profileHeaderCell.setState(state2);
            }
            this.mProfilePresenter.fetchProfileList(getAuthorId(), 0L);
        } else if (state == ProfileHeaderTabView.State.LIKE) {
            this.mState = state;
            showLoadingData();
            if (profileHeaderCell != null) {
                profileHeaderCell.setState(this.mState);
            }
            RecyclerView.ItemDecoration itemDecoration = this.mItemDecoration;
            if (itemDecoration != null) {
                this.mRecyclerView.removeItemDecoration(itemDecoration);
            }
            RecyclerView.ItemDecoration dividerDecoration = getDividerDecoration(false);
            this.mItemDecoration = dividerDecoration;
            this.mRecyclerView.addItemDecoration(dividerDecoration);
            this.mProfilePresenter.fetchMyFavoriteList(getAuthorId(), 0L, 30);
        } else if (state == ProfileHeaderTabView.State.ATTENTION) {
            IntentAttention.intentToAttentionOrFans(getActivity(), getUserId(), AttentionActivity.FROM_ATTENTION, 0);
        } else if (state == ProfileHeaderTabView.State.FANS) {
            IntentAttention.intentToAttentionOrFans(getActivity(), getUserId(), AttentionActivity.FROM_FANS, 1);
        } else if (state == ProfileHeaderTabView.State.FLOWER) {
            this.mState = state;
            showLoadingData();
            if (profileHeaderCell != null) {
                profileHeaderCell.setState(this.mState);
            }
            RecyclerView.ItemDecoration itemDecoration2 = this.mItemDecoration;
            if (itemDecoration2 != null) {
                this.mRecyclerView.removeItemDecoration(itemDecoration2);
            }
            RecyclerView.ItemDecoration dividerDecoration2 = getDividerDecoration(false);
            this.mItemDecoration = dividerDecoration2;
            this.mRecyclerView.addItemDecoration(dividerDecoration2);
            this.mProfilePresenter.fetchMyFlowerList(getAuthorId(), 0L, 30);
        }
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onUnSelected() {
    }

    @Override // us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setSlient(true);
        registerShowRecommend();
        this.mProfilePresenter.fetchUserVipInfo(getAuthorId());
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void refreshProfile() {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar == null || cVar.getItemCount() <= 0 || !(this.mAdapter.getItem(0) instanceof ProfileHeaderCell)) {
            return;
        }
        ProfileHeaderCell profileHeaderCell = (ProfileHeaderCell) this.mAdapter.getItem(0);
        ProfileAuthorInfo data = profileHeaderCell.getData();
        User.Info h2 = User.d().h();
        if (data == null || h2 == null) {
            return;
        }
        data.avatar = h2.avatar;
        data.backgroundPic = h2.backgroundPic;
        data.nickname = h2.nickname;
        data.desc = h2.description;
        if (!TextUtils.isEmpty(h2.gender)) {
            data.gender = Integer.parseInt(h2.gender);
        }
        InspireGeo inspireGeo = new InspireGeo();
        data.geo = inspireGeo;
        inspireGeo.city = h2.city;
        inspireGeo.country = h2.country;
        inspireGeo.province = h2.province;
        profileHeaderCell.updateData(data);
    }

    public void registerLoginEvent() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.foundation.r.b.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.activity.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfileMyFragment.this.l0((us.pinguo.foundation.r.b) obj);
            }
        }, k.a));
    }

    @Override // us.pinguo.inspire.cell.recycler.PortalChildFragment, us.pinguo.librouter.module.inspire.c
    public void releaseResource() {
    }

    @Override // us.pinguo.inspire.cell.recycler.PortalChildFragment, us.pinguo.librouter.module.inspire.c
    public void reloadResource() {
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void scrollToFirstPosition() {
        FlingFilterRecyclerView flingFilterRecyclerView = this.mRecyclerView;
        if (flingFilterRecyclerView != null) {
            flingFilterRecyclerView.smoothScrollToPosition(0);
        }
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void setData(final List<InspireWork> list) {
        if (list == null) {
            return;
        }
        ProfileHeaderCell profileHeaderCell = (ProfileHeaderCell) this.mAdapter.getItem(0);
        if (profileHeaderCell != null) {
            profileHeaderCell.updateIcon();
        }
        this.mRecyclerView.scrollToPosition(0);
        this.mProfileAdapter.beginChange();
        this.mProfileAdapter.set(getCells(list, getCurrentShowStyle(true), true));
        this.mProfileAdapter.endChange(true);
        setProfileCloseAnim();
        this.mRecyclerView.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.profile.activity.g
            @Override // java.lang.Runnable
            public final void run() {
                ProfileMyFragment.this.w0(list);
            }
        }, 100L);
        setLoadMoreEnabled(true);
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void setFavorite(List<InspireWork> list) {
        if (list == null) {
            return;
        }
        ProfileHeaderCell profileHeaderCell = (ProfileHeaderCell) this.mAdapter.getItem(0);
        if (profileHeaderCell != null) {
            profileHeaderCell.updateIcon();
        }
        this.mProfileAdapter.beginChange();
        this.mProfileAdapter.set(getCells(list, getCurrentShowStyle(false), false));
        if (list.size() == 0) {
            RecyclerView.ItemDecoration itemDecoration = this.mItemDecoration;
            if (itemDecoration != null && (itemDecoration instanceof FeedsDecoration)) {
                this.mRecyclerView.removeItemDecoration(itemDecoration);
            }
            us.pinguo.inspire.base.c.e(this.mAdapter, getAuthorId().equals(s0.getInstance().getUserId()));
        }
        this.mProfileAdapter.endChange(true);
        this.mRecyclerView.scrollToPosition(0);
        setProfileCloseAnim();
        setLoadMoreEnabled(true);
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void setFlowerWorks(List<InspireWork> list) {
        if (list == null) {
            return;
        }
        ProfileHeaderCell profileHeaderCell = (ProfileHeaderCell) this.mAdapter.getItem(0);
        if (profileHeaderCell != null) {
            profileHeaderCell.updateIcon();
        }
        this.mProfileAdapter.beginChange();
        this.mProfileAdapter.set(getCells(list, getCurrentShowStyle(false), false));
        if (list.size() == 0) {
            RecyclerView.ItemDecoration itemDecoration = this.mItemDecoration;
            if (itemDecoration != null && (itemDecoration instanceof FeedsDecoration)) {
                this.mRecyclerView.removeItemDecoration(itemDecoration);
            }
            us.pinguo.inspire.base.c.d(this.mAdapter, getAuthorId().equals(s0.getInstance().getUserId()));
        }
        this.mProfileAdapter.endChange(true);
        this.mRecyclerView.scrollToPosition(0);
        setProfileCloseAnim();
        setLoadMoreEnabled(true);
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void setOnRefreshComplete() {
        this.mRecyclerView.post(new Runnable() { // from class: us.pinguo.inspire.module.profile.activity.l
            @Override // java.lang.Runnable
            public final void run() {
                ProfileMyFragment.this.y0();
            }
        });
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void showEmpty() {
        this.mProfileAdapter.showEmpty();
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void showError() {
        this.mProfileAdapter.showError();
    }

    @Override // us.pinguo.inspire.module.profile.IProfileView
    public void showLoading() {
        this.mRecyclerView.postDelayed(this.showRefreshingRunnable, 10L);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void triggerFirstRefresh(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.videocell.InspireVideoFragment, us.pinguo.inspire.base.BaseAbsListFragment
    public us.pinguo.inspire.widget.videocell.e initAdapter() {
        ProfileAdapter profileAdapter = new ProfileAdapter();
        this.mProfileAdapter = profileAdapter;
        return profileAdapter;
    }
}
