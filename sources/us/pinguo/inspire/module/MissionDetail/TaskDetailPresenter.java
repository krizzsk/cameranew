package us.pinguo.inspire.module.MissionDetail;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import rx.Subscription;
import rx.functions.Action1;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireTaskBulkLoader;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.InspireWorkBulkLoader;
import us.pinguo.inspire.module.MissionDetail.TaskDetailActivity;
import us.pinguo.inspire.module.discovery.cell.DiscoveryWaterFallWorkCell;
import us.pinguo.inspire.proxy.InspireStatistics;
import us.pinguo.widget.common.cell.recycler.c;
/* loaded from: classes9.dex */
public class TaskDetailPresenter extends TaskDetailBasePresenter {
    public static final int FEEDS_DFAULT_PAGE_NUM = 1;
    public static final int FEEDS_THIRD_STATUS = 3;
    private static final String KEY_CHALLENGE_GUIDE = "challenge_guide";
    private static final String KEY_VOTE_GUIDE = "vote_guide";
    public static final int REQUEST_VOTE = 23;
    public static final int REQUEST_WORK_FEED = 22;
    public static final int TIME_SECOND = 86400;
    static final int TYPE_HEADER = 0;
    static final int TYPE_ITEM = 1;
    private Activity mActivity;
    private List<InspireWorkBulkLoader.AdVideo> mAdVideos;
    private boolean mGetMyWorksComplete;
    private boolean mGetVoteWorksComplete;
    private Subscription mLoadMoreSubscription;
    private IMissionDetailView mMissionDetailView;
    public InspireTask mTask;
    private InspireWorkBulkLoader mWorkLoader;
    private InspireTaskBulkLoader mTaskLoader = new InspireTaskBulkLoader();
    private boolean mShowCache = true;
    private BroadcastReceiver mCollectionReceiver = new BroadcastReceiver() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailPresenter.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            us.pinguo.common.log.a.m("zhouwei", "onReceive.......", new Object[0]);
            if (intent == null || TextUtils.isEmpty(intent.getAction()) || !"us.pinguo.inspire.collection".equals(intent.getAction()) || intent.getIntExtra("type", 1) != 0) {
                return;
            }
            us.pinguo.common.log.a.m("zhouwei", "刷新cell.......", new Object[0]);
            TaskDetailPresenter.this.refreshCell((InspireWork) intent.getParcelableExtra("inspire_work"));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(InspireWorkBulkLoader.InspireWorkResponse inspireWorkResponse) {
        IMissionDetailView iMissionDetailView = this.mMissionDetailView;
        if (iMissionDetailView == null) {
            return;
        }
        this.mAdVideos = inspireWorkResponse.adVideo;
        iMissionDetailView.setRefreshing(false);
        this.mGetVoteWorksComplete = true;
        checkHideRefresh();
        if (inspireWorkResponse == null) {
            return;
        }
        if (inspireWorkResponse.status == 3) {
            this.mTask.finished = true;
            this.mMissionDetailView.showRanking(true);
            this.mMissionDetailView.setTaskFinished(true);
        } else {
            this.mMissionDetailView.showRanking(false);
            this.mMissionDetailView.setTaskFinished(false);
        }
        if (inspireWorkResponse.items != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(inspireWorkResponse.items);
            this.mMissionDetailView.setWorks(getWorksGroupCells(arrayList), false);
            if (inspireWorkResponse.items.size() == 0) {
                this.mMissionDetailView.enableLoadMore(false);
            } else {
                this.mMissionDetailView.enableLoadMore(true);
            }
        }
    }

    private void checkHideRefresh() {
        IMissionDetailView iMissionDetailView;
        if (this.mGetMyWorksComplete && this.mGetVoteWorksComplete && (iMissionDetailView = this.mMissionDetailView) != null) {
            iMissionDetailView.setRefreshing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(Throwable th) {
        us.pinguo.foundation.e.e(th);
        this.mGetVoteWorksComplete = true;
        IMissionDetailView iMissionDetailView = this.mMissionDetailView;
        if (iMissionDetailView == null) {
            return;
        }
        iMissionDetailView.enableLoadMore(false);
        this.mMissionDetailView.setRefreshing(false);
        if (this.mMissionDetailView.getAdapter().getItemCount() <= 1) {
            this.mMissionDetailView.hideBottomLayout();
        }
        checkHideRefresh();
        if (us.pinguo.user.util.m.a(th)) {
            us.pinguo.user.util.m.b(this.mActivity);
        } else {
            us.pinguo.user.util.i.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(TaskDetailActivity.OnLoadMoreListener onLoadMoreListener, InspireWorkBulkLoader.InspireWorkResponse inspireWorkResponse) {
        List<InspireWork> list = inspireWorkResponse.items;
        if (onLoadMoreListener != null) {
            onLoadMoreListener.onLoadMore(list, true);
        }
        IMissionDetailView iMissionDetailView = this.mMissionDetailView;
        if (iMissionDetailView != null && iMissionDetailView.getAdapter() != null && list != null) {
            if (list.size() == 0) {
                this.mMissionDetailView.completeRefresh();
                this.mMissionDetailView.onNoMore();
                return;
            }
            us.pinguo.user.recycler.c adapter = this.mMissionDetailView.getAdapter();
            int itemCount = adapter.getItemCount();
            int appendWorks = this.mMissionDetailView.appendWorks(getWorksGroupCells(list));
            if (!this.mMissionDetailView.isLoadingMore()) {
                if (appendWorks > 0) {
                    adapter.notifyItemRangeInserted(itemCount, appendWorks);
                    return;
                }
                return;
            }
            this.mMissionDetailView.completeRefresh();
            adapter.notifyItemChanged(itemCount - 1);
            if (appendWorks > 0) {
                adapter.notifyItemRangeInserted(itemCount, appendWorks - 1);
                return;
            }
            return;
        }
        this.mMissionDetailView.completeRefresh();
    }

    private int getWorkIndex(List<DiscoveryWaterFallWorkCell> list, InspireWork inspireWork) {
        if (list != null && inspireWork != null) {
            int i2 = -1;
            for (DiscoveryWaterFallWorkCell discoveryWaterFallWorkCell : list) {
                i2++;
                InspireWork data = discoveryWaterFallWorkCell.getData();
                if (data != null && data.getWorkId() != null && data.getWorkId().equals(inspireWork.workId)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    private List<ChallengeDetailPhotoCell> getWorksGroupCells(List<InspireWork> list) {
        c.a challengeDetailPhotoCell;
        boolean isVideo = this.mTask.isVideo();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (InspireWork inspireWork : list) {
                if (isVideo) {
                    challengeDetailPhotoCell = new ChallengeDetailVideoCell(this.mTask, inspireWork);
                } else {
                    challengeDetailPhotoCell = new ChallengeDetailPhotoCell(this.mTask, inspireWork);
                }
                arrayList.add(challengeDetailPhotoCell);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        if (us.pinguo.user.util.m.a(th)) {
            us.pinguo.user.util.m.b(this.mActivity);
        }
        IMissionDetailView iMissionDetailView = this.mMissionDetailView;
        if (iMissionDetailView != null) {
            iMissionDetailView.completeRefresh();
        }
    }

    private void initViewAfterGetTask() {
        initViewData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(InspireTask inspireTask) {
        IMissionDetailView iMissionDetailView;
        this.mTask = inspireTask;
        if ((inspireTask == null || inspireTask.finished) && (iMissionDetailView = this.mMissionDetailView) != null) {
            iMissionDetailView.hideBottomLayout();
        }
        checkIsCanUseVideoOrSticker();
        initViewAfterGetTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(Throwable th) {
        this.mMissionDetailView.setRefreshing(false);
        this.mMissionDetailView.hideBottomLayout();
        us.pinguo.foundation.e.e(th);
        us.pinguo.user.util.i.b(th);
        this.mMissionDetailView.showEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshCell(InspireWork inspireWork) {
        List<ChallengeDetailPhotoCell> worksList = this.mMissionDetailView.getWorksList();
        if (worksList != null) {
            for (int i2 = 0; i2 < worksList.size(); i2++) {
                ChallengeDetailPhotoCell challengeDetailPhotoCell = worksList.get(i2);
                InspireWork data = challengeDetailPhotoCell.getData();
                if (inspireWork != null && inspireWork.getWorkId() != null && inspireWork.getWorkId().equals(data.workId)) {
                    challengeDetailPhotoCell.updateData(inspireWork);
                    return;
                }
            }
        }
    }

    @Override // us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter
    public void attachView(us.pinguo.foundation.p.b bVar) {
        IMissionDetailView iMissionDetailView = (IMissionDetailView) bVar;
        this.mMissionDetailView = iMissionDetailView;
        this.mActivity = (Activity) iMissionDetailView.getContext();
        Intent activityIntent = this.mMissionDetailView.getActivityIntent();
        this.mTask = (InspireTask) activityIntent.getParcelableExtra("task");
        if (activityIntent.hasExtra("web_view_from")) {
            InspireStatistics.pushSimpleClick(1, activityIntent.getStringExtra("web_view_push_id"));
        }
        this.mActivity.registerReceiver(this.mCollectionReceiver, new IntentFilter("us.pinguo.inspire.collection"));
        this.mMissionDetailView.enableLoadMore(false);
    }

    public void checkIsCanUseVideoOrSticker() {
        Uri parse;
        InspireTask inspireTask = this.mTask;
        if (inspireTask == null) {
            return;
        }
        if (!inspireTask.isVideo()) {
            InspireTask inspireTask2 = this.mTask;
            if (inspireTask2.taskType != 5) {
                if (TextUtils.isEmpty(inspireTask2.sceneGotoUrl) || (parse = Uri.parse(this.mTask.sceneGotoUrl)) == null) {
                    return;
                }
                parse.getLastPathSegment();
                return;
            }
        }
        if (us.pinguo.librouter.c.d.b().getInterface().k()) {
            return;
        }
        this.mMissionDetailView.setParticipantEnable(false);
    }

    public InspireWorkBulkLoader createWorkModel(String str) {
        return new InspireWorkBulkLoader(str);
    }

    @Override // us.pinguo.foundation.p.a
    public void detachView() {
        super.detachView();
        this.mMissionDetailView = null;
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.unregisterReceiver(this.mCollectionReceiver);
        }
    }

    @Override // us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter
    protected void downloadSceneTemplate() {
        IMissionDetailView iMissionDetailView = this.mMissionDetailView;
        InspireTask inspireTask = this.mTask;
        iMissionDetailView.showSceneDialog(inspireTask.sceneGotoUrl, inspireTask.sceneParam);
    }

    public InspireWorkBulkLoader.AdVideo getAdVideo() {
        List<InspireWorkBulkLoader.AdVideo> list = this.mAdVideos;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.mAdVideos.get(0);
    }

    public InspireTask getTask() {
        return this.mTask;
    }

    public String getTaskId() {
        if (getTask() != null && !TextUtils.isEmpty(getTask().taskId)) {
            return getTask().taskId;
        }
        return this.mActivity.getIntent().getStringExtra("task_id");
    }

    public void initViewData() {
        this.mMissionDetailView.onTaskRefreshed(this.mTask);
        this.mMissionDetailView.setTitle(this.mTask.taskName);
        this.mMissionDetailView.setCount(this.mTask.watchSum);
        IMissionDetailView iMissionDetailView = this.mMissionDetailView;
        InspireTask inspireTask = this.mTask;
        iMissionDetailView.setTaskRemainTime(inspireTask.finished, inspireTask.remainingDays);
        IMissionDetailView iMissionDetailView2 = this.mMissionDetailView;
        InspireTask inspireTask2 = this.mTask;
        iMissionDetailView2.setHeaderImageUri(inspireTask2.taskCover, inspireTask2.taskGotoUrl);
        this.mMissionDetailView.setDescription(this.mTask.isNewTask() ? this.mTask.desc : this.mTask.shortDesc);
        this.mMissionDetailView.showRanking(this.mTask.finished);
        this.mMissionDetailView.setTaskFinished(this.mTask.finished);
        this.mMissionDetailView.setTaskAvatar(this.mTask.icon);
        this.mWorkLoader = createWorkModel(this.mTask.taskId);
        initVoteWorks();
    }

    public void initVoteWorks() {
        this.mGetVoteWorksComplete = false;
        addSubscription(this.mWorkLoader.loadTop(1, 50).subscribe(new Action1() { // from class: us.pinguo.inspire.module.MissionDetail.y
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                TaskDetailPresenter.this.d((InspireWorkBulkLoader.InspireWorkResponse) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.MissionDetail.v
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                TaskDetailPresenter.this.f((Throwable) obj);
            }
        }));
    }

    public boolean isFirstShowTask() {
        InspireTask inspireTask = this.mTask;
        if (inspireTask == null || TextUtils.isEmpty(inspireTask.taskId)) {
            return false;
        }
        SharedPreferences c = Inspire.c();
        String str = "first show:" + this.mTask.taskId;
        boolean z = c.getBoolean(str, true);
        if (z) {
            c.edit().putBoolean(str, false).commit();
        }
        return z;
    }

    public boolean isLastCell(int i2) {
        IMissionDetailView iMissionDetailView = this.mMissionDetailView;
        if (iMissionDetailView == null) {
            return false;
        }
        return iMissionDetailView.isLastCell(i2);
    }

    public void loadMoreWorks(final TaskDetailActivity.OnLoadMoreListener onLoadMoreListener) {
        if (this.mTask == null) {
            this.mMissionDetailView.completeRefresh();
            if (onLoadMoreListener != null) {
                onLoadMoreListener.onLoadMore(null, false);
            }
        } else if (this.mWorkLoader == null) {
            this.mMissionDetailView.completeRefresh();
            if (onLoadMoreListener != null) {
                onLoadMoreListener.onLoadMore(null, false);
            }
        } else {
            ArrayList<InspireWork> myWorkList = this.mMissionDetailView.getMyWorkList();
            if (myWorkList == null) {
                if (onLoadMoreListener != null) {
                    onLoadMoreListener.onLoadMore(null, false);
                }
            } else if (!this.mWorkLoader.hasMore()) {
                this.mMissionDetailView.completeRefresh();
                if (onLoadMoreListener != null) {
                    onLoadMoreListener.onLoadMore(null, true);
                }
            } else {
                int pageNum = this.mWorkLoader.getPageNum(myWorkList.size());
                us.pinguo.common.log.a.m("zhouwei", "TaskDetail pageNum ：" + pageNum, new Object[0]);
                Subscription subscribe = this.mWorkLoader.loadMore(pageNum, 50).subscribe(new Action1() { // from class: us.pinguo.inspire.module.MissionDetail.w
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        TaskDetailPresenter.this.h(onLoadMoreListener, (InspireWorkBulkLoader.InspireWorkResponse) obj);
                    }
                }, new Action1() { // from class: us.pinguo.inspire.module.MissionDetail.z
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        TaskDetailPresenter.this.j((Throwable) obj);
                    }
                });
                this.mLoadMoreSubscription = subscribe;
                addSubscription(subscribe);
            }
        }
    }

    public void onParticipateClick(Activity activity) {
        onParticipate(activity, this.mTask);
    }

    public void participateSceneTempate(Activity activity, String str) {
        participateBySceneTemplate(activity, this.mTask, str);
    }

    public void refresh(boolean z) {
        this.mShowCache = z;
        if (this.mTask == null) {
            String stringExtra = this.mMissionDetailView.getActivityIntent().getStringExtra("task_id");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            Subscription subscription = this.mLoadMoreSubscription;
            if (subscription != null && !subscription.isUnsubscribed()) {
                this.mLoadMoreSubscription.unsubscribe();
            }
            this.mMissionDetailView.setRefreshing(true);
            addSubscription(this.mTaskLoader.loadTask(stringExtra).subscribe(new Action1() { // from class: us.pinguo.inspire.module.MissionDetail.x
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    TaskDetailPresenter.this.l((InspireTask) obj);
                }
            }, new Action1() { // from class: us.pinguo.inspire.module.MissionDetail.u
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    TaskDetailPresenter.this.n((Throwable) obj);
                }
            }));
            return;
        }
        initViewAfterGetTask();
    }

    public void share() {
    }
}
