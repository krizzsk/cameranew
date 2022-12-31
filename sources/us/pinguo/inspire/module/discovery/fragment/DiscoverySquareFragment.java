package us.pinguo.inspire.module.discovery.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.collection.GrowingIO;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.utils.f0;
import us.pinguo.foundation.utils.k;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.inspire.cell.recycler.PortalChildEasyListFragment;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireTaskBulkLoader;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.inspire.module.challenge.ChallengeBannerCell;
import us.pinguo.inspire.module.challenge.ChallengeTabHelper;
import us.pinguo.inspire.module.challenge.ChallengeTabUnread;
import us.pinguo.inspire.module.discovery.cell.ChallengeListPhotoCell;
import us.pinguo.inspire.module.discovery.cell.DiscoveryTaskCell;
import us.pinguo.inspire.module.feeds.cell.FeedsBannerCell;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.util.transition.h;
import us.pinguo.librouter.c.d;
import us.pinguo.user.a1.l;
import us.pinguo.user.a1.o;
import us.pinguo.user.recycler.FocusChildRecyclerView;
import us.pinguo.user.recycler.c;
import us.pinguo.user.s0;
import us.pinguo.user.util.f;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoverySquareFragment extends PortalChildEasyListFragment<InspireTaskBulkLoader.TaskListResp> {
    private ChallengeBannerCell mBannerCell;
    private boolean mRefreshedSuccess;
    private boolean mSelected;
    private ChallengeTabHelper mTabHelper;
    private RecyclerView.RecycledViewPool mViewPool;
    private BaseAbsListFragment.e onDataRefreshedListener;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mCheckVisRunnable = new Runnable() { // from class: us.pinguo.inspire.module.discovery.fragment.b
        @Override // java.lang.Runnable
        public final void run() {
            DiscoverySquareFragment.this.v0();
        }
    };
    private f.b mOnDoubleClickTitleListener = new f.b() { // from class: us.pinguo.inspire.module.discovery.fragment.DiscoverySquareFragment.1
        @Override // us.pinguo.user.util.f.b
        public void onDoubleClick(View view) {
            ((BaseAbsListFragment) DiscoverySquareFragment.this).mRecyclerView.smoothScrollToPosition(0);
        }

        @Override // us.pinguo.user.util.f.b
        public void onSingleClick(View view) {
        }
    };
    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: us.pinguo.inspire.module.discovery.fragment.DiscoverySquareFragment.4
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                DiscoverySquareFragment.this.mHandler.postDelayed(DiscoverySquareFragment.this.mCheckVisRunnable, 200L);
            } else {
                DiscoverySquareFragment.this.mHandler.removeCallbacks(DiscoverySquareFragment.this.mCheckVisRunnable);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (DiscoverySquareFragment.this.mRefreshedSuccess && i3 != 0) {
                DiscoverySquareFragment.this.mTabHelper.onScrolled();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkVisibleChangeForWebp */
    public void v0() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(findFirstVisibleItemPosition);
            if (item instanceof DiscoveryTaskCell) {
                ((DiscoveryTaskCell) item).checkVisibleChange();
            }
        }
    }

    private DiscoveryTaskCell findTaskCell(InspireWork inspireWork) {
        for (int i2 = 0; i2 < this.mAdapter.getItemCount(); i2++) {
            if (this.mAdapter.getItem(i2) instanceof DiscoveryTaskCell) {
                DiscoveryTaskCell discoveryTaskCell = (DiscoveryTaskCell) this.mAdapter.getItem(i2);
                if (f0.b(discoveryTaskCell.getData().taskId, inspireWork.taskId)) {
                    return discoveryTaskCell;
                }
            }
        }
        return null;
    }

    private ArrayList<us.pinguo.widget.common.cell.recycler.b> loadmoreCells(InspireTaskBulkLoader.TaskListResp taskListResp) {
        ArrayList<us.pinguo.widget.common.cell.recycler.b> arrayList = new ArrayList<>();
        if (!k.a(taskListResp.items)) {
            for (InspireTask inspireTask : taskListResp.items) {
                arrayList.add(new DiscoveryTaskCell(inspireTask).setViewPool(this.mViewPool));
            }
        }
        this.mRefreshedSuccess = true;
        return arrayList;
    }

    private ArrayList<us.pinguo.widget.common.cell.recycler.b> refreshCells(InspireTaskBulkLoader.TaskListResp taskListResp) {
        ChallengeBannerCell challengeBabberCell;
        ArrayList<us.pinguo.widget.common.cell.recycler.b> arrayList = new ArrayList<>();
        if (!this.mAdapter.isEmpty() && (this.mAdapter.getItem(0) instanceof ChallengeBannerCell)) {
            challengeBabberCell = (ChallengeBannerCell) this.mAdapter.getItem(0);
            challengeBabberCell.updateData(d.b().getInterface().a().getBannerData("72ba7c334d1aec71e75f82397c2c82f0"));
        } else {
            challengeBabberCell = FeedsBannerCell.getChallengeBabberCell("72ba7c334d1aec71e75f82397c2c82f0");
        }
        if (challengeBabberCell != null) {
            challengeBabberCell.setBannerData(taskListResp.banner);
            arrayList.add(challengeBabberCell);
        }
        this.mBannerCell = challengeBabberCell;
        if (!k.a(taskListResp.items)) {
            for (InspireTask inspireTask : taskListResp.items) {
                arrayList.add(new DiscoveryTaskCell(inspireTask).setViewPool(this.mViewPool));
            }
        }
        this.mRefreshedSuccess = true;
        this.mHandler.postDelayed(this.mCheckVisRunnable, 200L);
        return arrayList;
    }

    private void updadeBannerDesc() {
    }

    public RecyclerView checkScrollTo(InspireWork inspireWork) {
        DiscoveryTaskCell findTaskCell;
        c cVar = this.mAdapter;
        if (cVar == null || cVar.getItemCount() == 0 || (findTaskCell = findTaskCell(inspireWork)) == null || findTaskCell.getRecyclerView() == null) {
            return null;
        }
        RecyclerView recyclerView = findTaskCell.getRecyclerView();
        us.pinguo.widget.common.cell.recycler.a aVar = (us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter();
        for (int i2 = 0; i2 < aVar.getItemCount(); i2++) {
            if (((ChallengeListPhotoCell) aVar.getItem(i2)).getData().equals(inspireWork)) {
                recyclerView.scrollToPosition(i2);
                us.pinguo.common.log.a.k("scrollToPosition:" + i2, new Object[0]);
            }
        }
        return recyclerView;
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void clearNewStatus() {
    }

    public boolean getNewStatus() {
        return false;
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "challenge_task_list_page";
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected HashMap<String, String> getParam() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(GuestProfileFragment.USER_ID, s0.getInstance().getUserId());
        hashMap.put("sp", "1");
        return hashMap;
    }

    public ChallengeListPhotoCell getShareElementByWork(InspireWork inspireWork) {
        DiscoveryTaskCell findTaskCell = findTaskCell(inspireWork);
        int i2 = 0;
        while (true) {
            if (i2 >= this.mAdapter.getItemCount()) {
                break;
            }
            if (this.mAdapter.getItem(i2) instanceof DiscoveryTaskCell) {
                DiscoveryTaskCell discoveryTaskCell = (DiscoveryTaskCell) this.mAdapter.getItem(i2);
                if (f0.b(discoveryTaskCell.getData().taskId, inspireWork.taskId)) {
                    findTaskCell = discoveryTaskCell;
                    break;
                }
            }
            i2++;
        }
        return findTaskCell.getShareElementByWork(inspireWork);
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected Type getType() {
        return new com.google.gson.t.a<BaseResponse<InspireTaskBulkLoader.TaskListResp>>() { // from class: us.pinguo.inspire.module.discovery.fragment.DiscoverySquareFragment.2
        }.getType();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected String getUrl() {
        return Inspire.f11205f + InspireTaskBulkLoader.URL2;
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected View inflateRootView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.discovery_square_fragment, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public void initConfig() {
        super.initConfig();
        setIgnoreErrorToast(true);
        setDeleteDuplicateEanbled(false);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void initDefaultTitle(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        c cVar = (c) aVar;
        cVar.setFooterCell(new l(null).setBackgroundColor(-1));
        cVar.setNoMoreCell(new o(null).setBackgroundColor(-1));
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mRecyclerView.addOnScrollListener(this.onScrollListener);
        this.mRecyclerView.setBackgroundColor(getActivity().getResources().getColor(us.pinguo.user.R.color.portal_page_bg));
        this.mContainerView.setBackgroundDrawable(null);
        this.mRecyclerView.setTag(this);
        if (recyclerView instanceof FocusChildRecyclerView) {
            ((FocusChildRecyclerView) recyclerView).setGetFocusChild(new FocusChildRecyclerView.a() { // from class: us.pinguo.inspire.module.discovery.fragment.DiscoverySquareFragment.3
                @Override // us.pinguo.user.recycler.FocusChildRecyclerView.a
                public View getFocusChild(FocusChildRecyclerView focusChildRecyclerView) {
                    if ((((BaseAbsListFragment) DiscoverySquareFragment.this).mAdapter.getItem(0) instanceof ChallengeBannerCell) && ((LinearLayoutManager) focusChildRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) {
                        us.pinguo.common.log.a.k("hack getFocusedChild , return first", new Object[0]);
                        return focusChildRecyclerView.getChildAt(0);
                    }
                    return focusChildRecyclerView.superGetFocusedChild();
                }
            });
        }
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initTitle() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (h.a.e()) {
            return;
        }
        FeedsList.onActivityResult(i2, i3, intent, this.mRecyclerView);
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onAdvDataChange() {
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public boolean onBackPressed() {
        return false;
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mEnableDefaultFragmentVisibleStrategy = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment
    public void onDataRefresh() {
        super.onDataRefresh();
        BaseAbsListFragment.e eVar = this.onDataRefreshedListener;
        if (eVar != null) {
            eVar.onDataRefreshed();
        }
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onLogin() {
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onLogout() {
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mSelected) {
            onPageEnd();
            onFragmentHide();
        }
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mSelected) {
            onPageStart();
            onFragmentShow();
        }
        updadeBannerDesc();
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onSelected() {
        this.mSelected = true;
        if (!this.mIsPausing) {
            onPageStart();
            onFragmentShow();
        }
        us.pinguo.foundation.statistics.h.a.B0("recommend_challenge_task_list_change", "click");
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onUnSelected() {
        this.mSelected = false;
        onPageEnd();
        onFragmentHide();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        this.mViewPool = recycledViewPool;
        recycledViewPool.setMaxRecycledViews(0, 16);
        super.onViewCreated(view, bundle);
        GrowingIO.setTabName(view, "Discovery");
        this.mTabHelper = new ChallengeTabHelper(view);
    }

    public void setOnRefreshLisener(BaseAbsListFragment.e eVar) {
        this.onDataRefreshedListener = eVar;
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected boolean useDefaultPageStatistic() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public HashMap<String, String> addParamForPage(InspireTaskBulkLoader.TaskListResp taskListResp) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sort", String.valueOf(taskListResp.sort));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> appendCells(InspireTaskBulkLoader.TaskListResp taskListResp) {
        return loadmoreCells(taskListResp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public boolean checkNomore(InspireTaskBulkLoader.TaskListResp taskListResp) {
        return TaskDetailBasePresenter.SCENE_LIST.equals(taskListResp.sort);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> createCells(InspireTaskBulkLoader.TaskListResp taskListResp) {
        ChallengeTabUnread.INSTANCE.checkNew(taskListResp);
        return refreshCells(taskListResp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public boolean isLoadMoreEnable(InspireTaskBulkLoader.TaskListResp taskListResp) {
        return !TaskDetailBasePresenter.SCENE_LIST.equals(taskListResp.sort);
    }
}
