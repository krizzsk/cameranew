package us.pinguo.inspire.module.MissionDetail;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.functions.Action1;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.statistics.PageStack;
import us.pinguo.foundation.utils.f0;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.InspireWorkBulkLoader;
import us.pinguo.inspire.model.SceneParam;
import us.pinguo.inspire.module.MissionDetail.MissionTimeView;
import us.pinguo.inspire.module.MissionDetail.SceneDialog;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
import us.pinguo.inspire.module.comment.CommentLoader;
import us.pinguo.inspire.module.discovery.cell.DiscoveryWaterFallWorkCell;
import us.pinguo.inspire.module.guide.ChallengeShareDialog;
import us.pinguo.inspire.module.home.ChallengeGuideDialog;
import us.pinguo.inspire.module.profile.activity.GuestProfileActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.profile.activity.ProfileActivity;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.module.publish.event.UpdatePublishStateEvent;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.inspire.proxy.InspireStatistics;
import us.pinguo.inspire.widget.fresco.PhotoDraweeView;
import us.pinguo.inspire.widget.j.b;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.util.BaseShareDialog;
import us.pinguo.share.util.ExpandShareSite;
import us.pinguo.share.util.InspireShareUtils;
import us.pinguo.share.util.OnShareSiteClickListener;
import us.pinguo.ui.uilview.CircleImageView;
import us.pinguo.user.R;
import us.pinguo.user.s0;
import us.pinguo.user.u0;
import us.pinguo.user.ui.view.CompatibleToolbar;
/* loaded from: classes9.dex */
public class TaskDetailActivity extends InspireBaseActivity implements IMissionDetailView, View.OnClickListener, MissionTimeView.OnTimeFinishListenner, SwipeRefreshLayout.OnRefreshListener, us.pinguo.foundation.proxy.a, PGShareListener, us.pinguo.inspire.util.transition.c, ILoadMore {
    private static final float BANNER_RATE = 2.34375f;
    private static final String KEY_CHALLENGE_GUIDE = "challenge_guide";
    public static final int REQURST_TASK_DETATIL_LOGIN = 33214;
    private ViewGroup mBottomLayout;
    private CompatibleToolbar mCompatibleToolbar;
    TextView mCountTxt;
    private boolean mGDPREnable;
    private ChallengeGuideDialog mGuideDialog;
    private TaskDetailHeaderCell mHeaderCell;
    private HeaderShadowHelper mHeaderShadowHelper;
    private View mHeaderView;
    private boolean mIsPausing;
    private RecyclerView.ItemDecoration mItemDecoration;
    private us.pinguo.user.recycler.c mLmAdapter;
    private RecyclerView.OnScrollListener mOnScrollListener;
    View mParticipateView;
    private UpdatePublishStateEvent mPublishDataEvent;
    private ChallengeShareDialog mPublishDialog;
    private InspireWork mPublishedWork;
    RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private long mResumeTime;
    private SceneDialog mSceneDialog;
    TaskDetailPresenter mTaskDetailPresenter;
    Toolbar mToolbar;
    private PublishData mUploadData;
    private ProgressBar mUploadProgress;
    private InspireWork reenterWork;
    private boolean mShowShareDiaog = false;
    private boolean mIsDestroy = true;
    private boolean mFromPush = false;
    private boolean mEnableloadMore = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mCheckVisRunnable = new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.1
        @Override // java.lang.Runnable
        public void run() {
            TaskDetailActivity.this.checkVisibleChange();
        }
    };
    private Map<String, Long> mTransferredMap = new HashMap();
    private Runnable setRefreshingRunnable = new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (TaskDetailActivity.this.mRefreshLayout != null) {
                TaskDetailActivity.this.mRefreshLayout.setRefreshing(true);
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface OnLoadMoreListener {
        void onLoadMore(List<InspireWork> list, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void A0(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void C0() {
        this.mUploadProgress.setVisibility(8);
        us.pinguo.foundation.utils.w.k(this, R.string.upload_risky_image, us.pinguo.ui.R.string.ok, -999, false, h.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void E0() {
        this.mUploadProgress.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void G0(final UpdatePublishStateEvent updatePublishStateEvent) {
        if (this.mTaskDetailPresenter == null || updatePublishStateEvent.publishData == null || updatePublishStateEvent.getFilterType() != 0 || !f0.b(updatePublishStateEvent.publishData.taskId, this.mTaskDetailPresenter.getTaskId())) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.2
            @Override // java.lang.Runnable
            public void run() {
                TaskDetailActivity.this.processEvent(updatePublishStateEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ void J0(View view, us.pinguo.inspire.widget.j.b bVar, b.C0407b c0407b) {
        if (!TextUtils.isEmpty(c0407b.b)) {
            us.pinguo.foundation.interaction.c c = AppGoto.getInstance().c(c0407b.b);
            c.c("force_inner_browser", true);
            c.b(us.pinguo.foundation.e.b());
        } else if (c0407b.a != null) {
            Intent intent = new Intent();
            if (f0.b(s0.getInstance().getUserId(), c0407b.a)) {
                intent.setClass(this, ProfileActivity.class);
            } else {
                intent.setClass(this, GuestProfileActivity.class);
                intent.putExtra(GuestProfileFragment.USER_ID, c0407b.a);
            }
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void M0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void N0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0() {
        share();
        us.pinguo.foundation.statistics.h.a.Y(FirebaseAnalytics.Event.SHARE, this.mTaskDetailPresenter.getTaskId(), "click", String.valueOf(1));
    }

    private void addListener() {
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0) {
                    TaskDetailActivity.this.mHandler.postDelayed(TaskDetailActivity.this.mCheckVisRunnable, 200L);
                } else {
                    TaskDetailActivity.this.mHandler.removeCallbacks(TaskDetailActivity.this.mCheckVisRunnable);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                us.pinguo.user.util.e.a.a(recyclerView);
                if (i3 != 0) {
                    TaskDetailActivity.this.checkLoadMore();
                    TaskDetailActivity.this.mHeaderShadowHelper.onScrolled();
                }
            }
        };
        this.mOnScrollListener = onScrollListener;
        this.mRecyclerView.addOnScrollListener(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (((androidx.recyclerview.widget.LinearLayoutManager) r0).findLastVisibleItemPosition() == (r7.mLmAdapter.getItemCount() - 1)) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
        if (((androidx.recyclerview.widget.GridLayoutManager) r0).findLastVisibleItemPosition() == (r7.mLmAdapter.getItemCount() - 1)) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkLoadMore() {
        /*
            r7 = this;
            boolean r0 = r7.mEnableloadMore
            if (r0 == 0) goto L88
            us.pinguo.user.recycler.c r0 = r7.mLmAdapter
            if (r0 == 0) goto L88
            boolean r0 = r0.isFootShowing()
            if (r0 != 0) goto L88
            us.pinguo.user.recycler.c r0 = r7.mLmAdapter
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L88
            us.pinguo.user.recycler.c r0 = r7.mLmAdapter
            boolean r0 = r0.isError()
            if (r0 != 0) goto L88
            us.pinguo.user.recycler.c r0 = r7.mLmAdapter
            boolean r0 = r0.isLoadingShowing()
            if (r0 != 0) goto L88
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = r7.mRefreshLayout
            boolean r0 = r0.isRefreshing()
            if (r0 == 0) goto L2f
            goto L88
        L2f:
            androidx.recyclerview.widget.RecyclerView r0 = r7.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            boolean r1 = r0 instanceof androidx.recyclerview.widget.LinearLayoutManager
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L4c
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            int r0 = r0.findLastVisibleItemPosition()
            us.pinguo.user.recycler.c r1 = r7.mLmAdapter
            int r1 = r1.getItemCount()
            int r1 = r1 - r4
            if (r0 != r1) goto L7e
            goto L79
        L4c:
            boolean r1 = r0 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r1 == 0) goto L60
            androidx.recyclerview.widget.GridLayoutManager r0 = (androidx.recyclerview.widget.GridLayoutManager) r0
            int r0 = r0.findLastVisibleItemPosition()
            us.pinguo.user.recycler.c r1 = r7.mLmAdapter
            int r1 = r1.getItemCount()
            int r1 = r1 - r4
            if (r0 != r1) goto L7e
            goto L79
        L60:
            boolean r1 = r0 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r1 == 0) goto L7e
            androidx.recyclerview.widget.StaggeredGridLayoutManager r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r0
            int[] r0 = r0.findLastVisibleItemPositions(r2)
            us.pinguo.user.recycler.c r1 = r7.mLmAdapter
            int r1 = r1.getItemCount()
            int r1 = r1 - r4
            r5 = 0
        L72:
            int r6 = r0.length
            if (r5 >= r6) goto L7e
            r6 = r0[r5]
            if (r6 != r1) goto L7b
        L79:
            r3 = 1
            goto L7e
        L7b:
            int r5 = r5 + 1
            goto L72
        L7e:
            if (r3 == 0) goto L88
            us.pinguo.user.recycler.c r0 = r7.mLmAdapter
            r0.showFooter()
            r7.onLoadMore(r2)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.checkLoadMore():void");
    }

    private void checkScrollTo(InspireWork inspireWork) {
        int findIndex = findIndex(inspireWork);
        if (findIndex >= 0) {
            this.mRecyclerView.scrollToPosition(findIndex);
        }
    }

    private void checkShowGuide() {
        new Handler().postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.10
            @Override // java.lang.Runnable
            public void run() {
                if ((TaskDetailActivity.this.mGuideDialog == null || !TaskDetailActivity.this.mGuideDialog.isShowing()) && !TaskDetailActivity.this.mIsDestroy) {
                    String f2 = us.pinguo.util.s.f(TaskDetailActivity.this);
                    SharedPreferences sharedPreferences = TaskDetailActivity.this.getSharedPreferences("inspire_setting", 0);
                    if (f0.b(f2, sharedPreferences.getString(TaskDetailActivity.KEY_CHALLENGE_GUIDE, ""))) {
                        return;
                    }
                    InspireTask task = TaskDetailActivity.this.mTaskDetailPresenter.getTask();
                    if (task != null) {
                        Inspire.c().edit().putBoolean(task.taskId, false).commit();
                    }
                    sharedPreferences.edit().putString(TaskDetailActivity.KEY_CHALLENGE_GUIDE, f2).apply();
                    TaskDetailActivity.this.mGuideDialog = new ChallengeGuideDialog(TaskDetailActivity.this);
                    TaskDetailActivity.this.mGuideDialog.show();
                }
            }
        }, 600L);
    }

    private int findIndex(InspireWork inspireWork) {
        if (inspireWork == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.mLmAdapter.getItemCount(); i2++) {
            if (this.mLmAdapter.getItem(i2).getData().equals(inspireWork)) {
                return i2;
            }
        }
        return -1;
    }

    public static String getSceneId(String str) {
        Uri parse = Uri.parse(str);
        return (parse != null && "sceneTemplate".equals(parse.getLastPathSegment())) ? parse.getQueryParameter("sceneId") : "";
    }

    public static String[] getStickerId(String str) {
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        String lastPathSegment = parse.getLastPathSegment();
        if ("video".equals(lastPathSegment) || "photo".equals(lastPathSegment)) {
            return new String[]{parse.getQueryParameter("stickerId"), parse.getQueryParameter("stickerCategoryId")};
        }
        return null;
    }

    private void initHeaders() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(vStudio.Android.Camera360.R.layout.task_detail_header_layout, (ViewGroup) this.mRecyclerView, false);
        this.mHeaderView = viewGroup;
        TaskDetailHeaderCell taskDetailHeaderCell = new TaskDetailHeaderCell(viewGroup);
        this.mHeaderCell = taskDetailHeaderCell;
        this.mLmAdapter.add(0, taskDetailHeaderCell);
        this.mCountTxt = (TextView) this.mHeaderView.findViewById(vStudio.Android.Camera360.R.id.mission_detail_count);
        PhotoDraweeView photoDraweeView = (PhotoDraweeView) findViewById(vStudio.Android.Camera360.R.id.task_detail_title_bg);
        ViewGroup.LayoutParams layoutParams = photoDraweeView.getLayoutParams();
        layoutParams.height = (int) (us.pinguo.foundation.t.b.a.j(this) / BANNER_RATE);
        photoDraweeView.setLayoutParams(layoutParams);
        this.mHeaderShadowHelper = new HeaderShadowHelper(findViewById(vStudio.Android.Camera360.R.id.task_detail_header_shadow), "task_detail_header", this.mHeaderView);
    }

    private void initRecycler(InspireTask inspireTask) {
        if (inspireTask != null && !inspireTask.isVideo()) {
            if (this.mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                return;
            }
            this.mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
            RecyclerView.ItemDecoration itemDecoration = this.mItemDecoration;
            if (itemDecoration != null) {
                this.mRecyclerView.removeItemDecoration(itemDecoration);
            }
            us.pinguo.inspire.widget.h hVar = new us.pinguo.inspire.widget.h(2, TaskCellSize.INSTANCE.getPhotoDividerWidth(), false, 1);
            this.mItemDecoration = hVar;
            this.mRecyclerView.addItemDecoration(hVar);
        } else if (this.mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
        } else {
            this.mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
            RecyclerView.ItemDecoration itemDecoration2 = this.mItemDecoration;
            if (itemDecoration2 != null) {
                this.mRecyclerView.removeItemDecoration(itemDecoration2);
            }
            us.pinguo.inspire.widget.h hVar2 = new us.pinguo.inspire.widget.h(3, TaskCellSize.INSTANCE.getVideoDividerWidth(), false, 1);
            this.mItemDecoration = hVar2;
            this.mRecyclerView.addItemDecoration(hVar2);
        }
    }

    private void initToolBar() {
        CompatibleToolbar compatibleToolbar = (CompatibleToolbar) findViewById(vStudio.Android.Camera360.R.id.task_detail_toolbar);
        this.mCompatibleToolbar = compatibleToolbar;
        Toolbar b = compatibleToolbar.b();
        this.mToolbar = b;
        b.setBackgroundColor(0);
        this.mToolbar.setNavigationIcon(vStudio.Android.Camera360.R.drawable.challenge_back);
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.MissionDetail.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailActivity.this.r0(view);
            }
        });
        this.mToolbar.inflateMenu(vStudio.Android.Camera360.R.menu.share_tool_bar_menu);
        this.mToolbar.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.MissionDetail.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailActivity.this.t0(view);
            }
        });
        this.mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: us.pinguo.inspire.module.MissionDetail.n
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return TaskDetailActivity.this.v0(menuItem);
            }
        });
        us.pinguo.inspire.util.x.a(this.mToolbar, this.mRecyclerView);
    }

    private void initViews() {
        this.mUploadProgress = (ProgressBar) findViewById(vStudio.Android.Camera360.R.id.challenge_upload_progress);
        this.mRecyclerView = (RecyclerView) findViewById(vStudio.Android.Camera360.R.id.rv_task_detail);
        initRecycler(null);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRefreshLayout = (SwipeRefreshLayout) findViewById(vStudio.Android.Camera360.R.id.srl_task_detail);
        this.mParticipateView = findViewById(vStudio.Android.Camera360.R.id.mission_detail_particapate);
        this.mBottomLayout = (ViewGroup) findViewById(vStudio.Android.Camera360.R.id.mission_detail_bottom_layout);
        this.mRefreshLayout.setOnRefreshListener(this);
        this.mParticipateView.setOnClickListener(this);
        us.pinguo.user.recycler.c cVar = new us.pinguo.user.recycler.c();
        this.mLmAdapter = cVar;
        this.mRecyclerView.setAdapter(cVar);
        addListener();
        initToolBar();
        this.mGDPREnable = PgAdvManager.getInstance().c(getApplicationContext(), IADStatisticBase.UNIT_ID_GLOBAL);
        us.pinguo.common.log.a.s("GDPREnable:" + this.mGDPREnable, new Object[0]);
        setParticipantEnable(this.mGDPREnable);
    }

    public static void launchOfFirst(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.pinguo.camera360.homepage.HomePageActivity");
        intent.setFlags(603979776);
        us.pinguo.common.log.a.k("launch CameraActivity", new Object[0]);
        context.startActivity(intent);
    }

    private void onLoadMore(OnLoadMoreListener onLoadMoreListener) {
        this.mTaskDetailPresenter.loadMoreWorks(onLoadMoreListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void participantBySceneTemplate(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mTaskDetailPresenter.participateSceneTempate(this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processEvent(final UpdatePublishStateEvent updatePublishStateEvent) {
        PublishData publishData;
        PublishData publishData2 = this.mUploadData;
        if (publishData2 != null && publishData2 != (publishData = updatePublishStateEvent.publishData)) {
            if (publishData.clientTimeInMillis <= publishData2.clientTimeInMillis) {
                return;
            }
            this.mUploadData = publishData;
        } else {
            this.mUploadData = updatePublishStateEvent.publishData;
        }
        PublishData publishData3 = updatePublishStateEvent.publishData;
        int i2 = publishData3.state;
        if (i2 != 4) {
            if (i2 == 3 || i2 == 1) {
                this.mUploadProgress.setVisibility(0);
                this.mUploadProgress.setProgress(i2 != 3 ? 0 : 5);
                return;
            } else if (i2 == 0) {
                this.mUploadProgress.setVisibility(0);
                long longValue = (this.mTransferredMap.containsKey(updatePublishStateEvent.publishData.clientId) ? this.mTransferredMap.get(updatePublishStateEvent.publishData.clientId).longValue() : 0L) + 2;
                if (longValue > 95) {
                    longValue = 95;
                }
                this.mTransferredMap.put(updatePublishStateEvent.publishData.clientId, Long.valueOf(longValue));
                setProgressAnim(this.mUploadProgress, ((int) ((((float) longValue) / 100.0f) * 95.0f)) + 5);
                return;
            } else if (i2 == 2) {
                us.pinguo.foundation.statistics.h.a.k0("submit_faild", publishData3.videoType == 0 ? "shot_video" : "library_video", updatePublishStateEvent.getInspireWork() == null ? updatePublishStateEvent.publishData.taskId : updatePublishStateEvent.getInspireWork().workId, "feedback");
                this.mUploadProgress.setVisibility(8);
                j0.c(vStudio.Android.Camera360.R.string.upload_failed);
                return;
            } else {
                this.mUploadProgress.setVisibility(8);
                return;
            }
        }
        final InspireWork inspireWork = updatePublishStateEvent.getInspireWork();
        if (inspireWork.workType == 1) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(inspireWork.workUrl)) {
                arrayList.add(inspireWork.workUrl);
            }
            us.pinguo.user.util.n.a.o(u0.m, arrayList, new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.f
                @Override // java.lang.Runnable
                public final void run() {
                    TaskDetailActivity.this.z0(updatePublishStateEvent, inspireWork);
                }
            }, new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.p
                @Override // java.lang.Runnable
                public final void run() {
                    TaskDetailActivity.this.C0();
                }
            }, new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.l
                @Override // java.lang.Runnable
                public final void run() {
                    TaskDetailActivity.this.E0();
                }
            });
            return;
        }
        String str = updatePublishStateEvent.publishData.taskId;
        String str2 = inspireWork.authorId;
        if (f0.b(str, this.mTaskDetailPresenter.getTask() == null ? "" : this.mTaskDetailPresenter.getTask().taskId)) {
            if ((s0.getInstance().e() || !CommentLoader.isLoginRequired()) && f0.b(str2, s0.getInstance().getUserId())) {
                setProgressNoAnim(this.mUploadProgress, 100);
                this.mUploadProgress.setVisibility(8);
                this.mPublishDataEvent = updatePublishStateEvent;
                this.mPublishedWork = inspireWork;
                if (this.mIsPausing) {
                    this.mShowShareDiaog = true;
                } else {
                    showPublishSuccessDialog(updatePublishStateEvent);
                }
                this.mUploadData = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(View view) {
        onBackPressed();
    }

    private void registerPublishSuccessListener() {
        addSubscription(us.pinguo.foundation.r.d.a().c(UpdatePublishStateEvent.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.MissionDetail.r
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                TaskDetailActivity.this.G0((UpdatePublishStateEvent) obj);
            }
        }, o.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0(View view) {
        this.mRecyclerView.smoothScrollToPosition(0);
    }

    public static void setProgressAnim(ProgressBar progressBar, int i2) {
        Object tag = progressBar.getTag(vStudio.Android.Camera360.R.id.progress_anim);
        if (tag instanceof ObjectAnimator) {
            ((ObjectAnimator) tag).cancel();
        }
        int progress = progressBar.getProgress();
        if (i2 <= progress) {
            progressBar.setProgress(i2);
            return;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(progressBar, "progress", progressBar.getProgress(), i2);
        progressBar.setTag(vStudio.Android.Camera360.R.id.progress_anim, ofInt);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(((i2 - progress) / progressBar.getMax()) * 1000);
        ofInt.start();
    }

    public static void setProgressNoAnim(ProgressBar progressBar, int i2) {
        Object tag = progressBar.getTag(vStudio.Android.Camera360.R.id.progress_anim);
        if (tag instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) tag;
            if (objectAnimator.isStarted()) {
                objectAnimator.cancel();
            }
        }
        progressBar.setTag(vStudio.Android.Camera360.R.id.progress_anim, null);
        progressBar.setProgress(i2);
    }

    private void shareWithCheck() {
        us.pinguo.user.util.j.a.b(this, new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.k
            @Override // java.lang.Runnable
            public final void run() {
                TaskDetailActivity.this.P0();
            }
        }, i.a, g.a);
    }

    private void showPublishSuccessDialog(UpdatePublishStateEvent updatePublishStateEvent) {
        if (this.mIsDestroy || this.mIsPausing) {
            return;
        }
        us.pinguo.foundation.statistics.h.a.k0("submit_success", updatePublishStateEvent.publishData.videoType == 0 ? "shot_video" : "library_video", updatePublishStateEvent.getInspireWork() == null ? updatePublishStateEvent.publishData.taskId : updatePublishStateEvent.getInspireWork().workId, "feedback");
        ChallengeShareDialog challengeShareDialog = new ChallengeShareDialog(this, this.mTaskDetailPresenter.getTask(), this.mPublishedWork, updatePublishStateEvent.publishData);
        this.mPublishDialog = challengeShareDialog;
        challengeShareDialog.show();
    }

    private void showSceneInfoDialog(String str, SceneParam sceneParam) {
        final String sceneId = getSceneId(str);
        us.pinguo.common.log.a.m("zhouwei", "secneId ：" + sceneId, new Object[0]);
        String string = getString(us.pinguo.librouter.c.d.b().getInterface().c(sceneId) ? us.pinguo.ui.R.string.use_scene_template : us.pinguo.ui.R.string.download_scene_template);
        if (this.mSceneDialog == null) {
            this.mSceneDialog = new SceneDialog(this);
            this.mSceneDialog.setOnSceneBtnClickListener(new SceneDialog.OnSceneBtnClickListener() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.11
                @Override // us.pinguo.inspire.module.MissionDetail.SceneDialog.OnSceneBtnClickListener
                public void onSceneBtnClick(SceneDialog sceneDialog) {
                    if (!us.pinguo.librouter.c.d.b().getInterface().c(sceneId)) {
                        us.pinguo.librouter.c.d.b().getInterface().h(sceneId, TaskDetailActivity.this);
                        return;
                    }
                    sceneDialog.dismiss();
                    TaskDetailActivity.this.participantBySceneTemplate(sceneId);
                }
            });
        }
        this.mSceneDialog.setTitle(sceneParam.title);
        this.mSceneDialog.setSceneUrl(sceneParam.image);
        this.mSceneDialog.setBtnText(string);
        this.mSceneDialog.setProgressVisibility(false);
        this.mSceneDialog.setBtnVisibility(true);
        this.mSceneDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ boolean v0(MenuItem menuItem) {
        if (menuItem.getItemId() == vStudio.Android.Camera360.R.id.share_toolbar) {
            shareWithCheck();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0() {
        ChallengeShareDialog challengeShareDialog;
        if (!this.mIsPausing || (challengeShareDialog = this.mPublishDialog) == null) {
            return;
        }
        challengeShareDialog.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void z0(UpdatePublishStateEvent updatePublishStateEvent, InspireWork inspireWork) {
        String str = updatePublishStateEvent.publishData.taskId;
        String str2 = inspireWork.authorId;
        if (f0.b(str, this.mTaskDetailPresenter.getTask() == null ? "" : this.mTaskDetailPresenter.getTask().taskId)) {
            if ((s0.getInstance().e() || !CommentLoader.isLoginRequired()) && f0.b(str2, s0.getInstance().getUserId())) {
                setProgressNoAnim(this.mUploadProgress, 100);
                this.mUploadProgress.setVisibility(8);
                this.mPublishDataEvent = updatePublishStateEvent;
                this.mPublishedWork = inspireWork;
                if (this.mIsPausing) {
                    this.mShowShareDiaog = true;
                } else {
                    showPublishSuccessDialog(updatePublishStateEvent);
                }
                this.mUploadData = null;
            }
        }
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public int appendWorks(List<ChallengeDetailPhotoCell> list) {
        List<ChallengeDetailPhotoCell> worksList;
        if (list == null || (worksList = getWorksList()) == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        for (ChallengeDetailPhotoCell challengeDetailPhotoCell : list) {
            if (!worksList.contains(challengeDetailPhotoCell)) {
                arrayList.add(challengeDetailPhotoCell);
            }
        }
        this.mLmAdapter.addAll(arrayList);
        return arrayList.size();
    }

    public void checkVisibleChange() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager)) {
            return;
        }
        us.pinguo.widget.common.cell.recycler.a aVar = (us.pinguo.widget.common.cell.recycler.a) this.mRecyclerView.getAdapter();
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.mRecyclerView.getLayoutManager();
        int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        for (int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            us.pinguo.widget.common.cell.recycler.b item = aVar.getItem(findFirstVisibleItemPosition);
            if (item instanceof ChallengeDetailVideoCell) {
                ((ChallengeDetailVideoCell) item).checkVisibleChange();
            }
        }
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void completeRefresh() {
        this.mLmAdapter.hideFooter();
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void enableLoadMore(boolean z) {
        this.mEnableloadMore = z;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i2) {
        View findViewById = super.findViewById(i2);
        return findViewById == null ? this.mHeaderView.findViewById(i2) : findViewById;
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public Intent getActivityIntent() {
        return getIntent();
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public us.pinguo.user.recycler.c getAdapter() {
        return this.mLmAdapter;
    }

    @Override // us.pinguo.inspire.util.transition.c
    public View getChangedShareElement() {
        int findIndex = findIndex(this.reenterWork);
        this.reenterWork = null;
        us.pinguo.widget.common.cell.recycler.b item = this.mLmAdapter.getItem(findIndex);
        if (item instanceof ChallengeDetailPhotoCell) {
            return ((ChallengeDetailPhotoCell) item).getShareElement();
        }
        return null;
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public Context getContext() {
        return this;
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public ArrayList<InspireWork> getMyWorkList() {
        List<us.pinguo.widget.common.cell.recycler.b> cells;
        ArrayList<InspireWork> arrayList = new ArrayList<>();
        us.pinguo.user.recycler.c cVar = this.mLmAdapter;
        if (cVar != null && (cells = cVar.getCells()) != null) {
            for (us.pinguo.widget.common.cell.recycler.b bVar : cells) {
                Object data = bVar.getData();
                if (data != null && (data instanceof InspireWork)) {
                    arrayList.add((InspireWork) data);
                }
            }
        }
        return arrayList;
    }

    public InspireWorkBulkLoader.AdVideo getTaskAdVideo() {
        TaskDetailPresenter taskDetailPresenter = this.mTaskDetailPresenter;
        if (taskDetailPresenter == null) {
            return null;
        }
        return taskDetailPresenter.getAdVideo();
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public List<ChallengeDetailPhotoCell> getWorksList() {
        ArrayList arrayList = new ArrayList();
        List<us.pinguo.widget.common.cell.recycler.b> cells = this.mLmAdapter.getCells();
        if (cells != null) {
            for (us.pinguo.widget.common.cell.recycler.b bVar : cells) {
                if (bVar instanceof DiscoveryWaterFallWorkCell) {
                    arrayList.add((ChallengeDetailPhotoCell) bVar);
                }
            }
        }
        return arrayList;
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void hideBottomLayout() {
        ViewGroup viewGroup = this.mBottomLayout;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public boolean isLastCell(int i2) {
        return this.mLmAdapter.getItemCount() - 1 == i2;
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public boolean isLoadingMore() {
        us.pinguo.user.recycler.c cVar = this.mLmAdapter;
        return cVar != null && cVar.isFootShowing();
    }

    @Override // us.pinguo.inspire.module.MissionDetail.ILoadMore
    public void loadMore(OnLoadMoreListener onLoadMoreListener) {
        onLoadMore(onLoadMoreListener);
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i2, Intent intent) {
        super.onActivityReenter(i2, intent);
        intent.setExtrasClassLoader(getClassLoader());
        String stringExtra = intent.getStringExtra("changedTaskId");
        String stringExtra2 = intent.getStringExtra("changedWorkId");
        us.pinguo.inspire.util.transition.h hVar = us.pinguo.inspire.util.transition.h.a;
        if (!hVar.e() || stringExtra2 == null) {
            return;
        }
        InspireWork inspireWork = new InspireWork();
        this.reenterWork = inspireWork;
        inspireWork.taskId = stringExtra;
        inspireWork.workId = stringExtra2;
        checkScrollTo(inspireWork);
        hVar.l(this);
        hVar.s(this, this.mRecyclerView);
    }

    @Override // us.pinguo.foundation.base.InspireRedirectActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 33214 && i3 == -1) {
            this.mTaskDetailPresenter.onParticipateClick(this);
        }
        if ((i2 == 205 || i2 == 1005) && i3 == -1) {
            shareWithCheck();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        InspirePublishFragment.sTaskId = null;
        if (this.mFromPush && !us.pinguo.inspire.z.a.a) {
            launchOfFirst(this);
        }
        super.onBackPressed();
        us.pinguo.foundation.statistics.h.a.Y("back", this.mTaskDetailPresenter.getTaskId(), "click", String.valueOf(1));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == vStudio.Android.Camera360.R.id.mission_detail_particapate) {
            if (!us.pinguo.librouter.c.d.b().getInterface().k()) {
                j0.c(vStudio.Android.Camera360.R.string.current_device_not_support_task);
                return;
            }
            VideoEdit2Activity.sTaskId = this.mTaskDetailPresenter.getTaskId();
            this.mTaskDetailPresenter.onParticipateClick(this);
            us.pinguo.foundation.statistics.h.a.Y("join", this.mTaskDetailPresenter.getTaskId(), "click", String.valueOf(1));
            getIntent().removeExtra(us.pinguo.foundation.constant.a.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mEnableBaseNotch = false;
        us.pinguo.inspire.util.transition.h hVar = us.pinguo.inspire.util.transition.h.a;
        hVar.d(this);
        super.onCreate(bundle);
        setContentView(vStudio.Android.Camera360.R.layout.inspire_mission_detail_actvity);
        this.mIsDestroy = false;
        if (getIntent() != null && getIntent().hasExtra("key_task_detail_from_push")) {
            this.mFromPush = getIntent().getBooleanExtra("key_task_detail_from_push", false);
        } else {
            this.mFromPush = false;
        }
        initViews();
        initHeaders();
        TaskDetailPresenter taskDetailPresenter = new TaskDetailPresenter();
        this.mTaskDetailPresenter = taskDetailPresenter;
        taskDetailPresenter.attachView(this);
        this.mTaskDetailPresenter.refresh(true);
        registerPublishSuccessListener();
        hVar.n(this, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.SubscriptionActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mIsDestroy = true;
        TaskWorkShare.workList = null;
        super.onDestroy();
        PageStack.getInstance().b("pc_taskInfo_show");
    }

    public void onDownloadFinished(final boolean z) {
        runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    TaskDetailActivity.this.mSceneDialog.setBtnText(TaskDetailActivity.this.getResources().getString(us.pinguo.ui.R.string.use_scene_template));
                    TaskDetailActivity.this.mSceneDialog.setBtnVisibility(true);
                    TaskDetailActivity.this.mSceneDialog.setProgressVisibility(false);
                }
            }
        });
    }

    public void onDownloadStarted() {
        runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.12
            @Override // java.lang.Runnable
            public void run() {
                TaskDetailActivity.this.mSceneDialog.setProgressVisibility(true);
                TaskDetailActivity.this.mSceneDialog.setBtnVisibility(false);
            }
        });
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void onNoMore() {
        enableLoadMore(false);
        us.pinguo.user.recycler.c cVar = this.mLmAdapter;
        if (cVar != null) {
            cVar.showNoMoreContent();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        us.pinguo.foundation.statistics.f.e("challenge_task_detail_page", true);
        InspireStatistics.onPageEnd("pc_taskInfo_show");
        this.mIsPausing = true;
        us.pinguo.user.util.e.a.d(this.mRecyclerView);
        ChallengeShareDialog challengeShareDialog = this.mPublishDialog;
        if (challengeShareDialog == null || !challengeShareDialog.isShowing()) {
            return;
        }
        this.mPublishDialog.onPause();
        new Handler().postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.c
            @Override // java.lang.Runnable
            public final void run() {
                TaskDetailActivity.this.x0();
            }
        }, 1000L);
    }

    public void onProgressUpdate(final Integer... numArr) {
        runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.14
            @Override // java.lang.Runnable
            public void run() {
                TaskDetailActivity.this.mSceneDialog.setProgress(numArr[0].intValue());
                TaskDetailActivity.this.mSceneDialog.setMax(numArr[1].intValue());
            }
        });
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.mTaskDetailPresenter.refresh(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        UpdatePublishStateEvent updatePublishStateEvent;
        super.onResume();
        this.mResumeTime = System.currentTimeMillis();
        us.pinguo.foundation.statistics.f.f("challenge_task_detail_page");
        InspireStatistics.onPageStart("pc_taskInfo_show");
        us.pinguo.foundation.statistics.l.onEvent(this, "pc_taskInfo_show", "challenge_id=" + this.mTaskDetailPresenter.getTaskId() + ",src=" + PageStack.getInstance().e());
        us.pinguo.foundation.statistics.l.onEvent(this, "community_challenge_detail_page_show");
        this.mIsPausing = false;
        if (us.pinguo.foundation.proxy.b.a) {
            onShareComplete(ShareSite.WECHAT_FRIENDS, false);
            us.pinguo.foundation.proxy.b.a = false;
        }
        us.pinguo.user.util.e.a.e(this.mRecyclerView);
        checkVisibleChange();
        ChallengeShareDialog challengeShareDialog = this.mPublishDialog;
        if (challengeShareDialog != null && challengeShareDialog.isShowing()) {
            this.mPublishDialog.onResume();
        }
        if (!this.mShowShareDiaog || (updatePublishStateEvent = this.mPublishDataEvent) == null) {
            return;
        }
        this.mShowShareDiaog = false;
        showPublishSuccessDialog(updatePublishStateEvent);
        this.mPublishDataEvent = null;
    }

    @Override // us.pinguo.share.core.PGShareListener
    public void onShareCancel(ShareSite shareSite) {
    }

    @Override // us.pinguo.share.core.PGShareListener
    public void onShareComplete(ShareSite shareSite, boolean z) {
        ChallengeShareDialog challengeShareDialog = this.mPublishDialog;
        if (challengeShareDialog == null || !challengeShareDialog.isShowing()) {
            return;
        }
        this.mPublishDialog.dismiss();
    }

    @Override // us.pinguo.share.core.PGShareListener
    public void onShareError(ShareSite shareSite, Throwable th) {
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void onTaskRefreshed(InspireTask inspireTask) {
        initRecycler(inspireTask);
        View findViewById = findViewById(vStudio.Android.Camera360.R.id.mission_detail_particapate);
        if (inspireTask.taskType == 5) {
            ViewCompat.setBackground(findViewById, getResources().getDrawable(vStudio.Android.Camera360.R.drawable.task_icon_join_photo_movie));
        } else {
            findViewById.setBackgroundResource(inspireTask.isVideo() ? vStudio.Android.Camera360.R.drawable.icon_details_join_video : vStudio.Android.Camera360.R.drawable.icon_details_camera);
        }
    }

    @Override // us.pinguo.inspire.module.MissionDetail.MissionTimeView.OnTimeFinishListenner
    public void onTimeFinish() {
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void selectItem(int i2) {
        if (i2 < 0 || i2 >= this.mLmAdapter.getItemCount() - 1) {
            return;
        }
        this.mRecyclerView.scrollToPosition(i2 + 1);
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setBrowsed(int i2) {
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setCount(int i2) {
        this.mCountTxt.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i2)));
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setDescription(String str) {
        us.pinguo.inspire.widget.j.b.f((TextView) findViewById(vStudio.Android.Camera360.R.id.task_detail_title_desc), str, new b.c() { // from class: us.pinguo.inspire.module.MissionDetail.q
            @Override // us.pinguo.inspire.widget.j.b.c
            public final void onClick(View view, us.pinguo.inspire.widget.j.b bVar, b.C0407b c0407b) {
                TaskDetailActivity.this.J0(view, bVar, c0407b);
            }
        });
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setHeaderImageUri(String str, final String str2) {
        PhotoDraweeView photoDraweeView = (PhotoDraweeView) findViewById(vStudio.Android.Camera360.R.id.task_detail_title_bg);
        photoDraweeView.setImageURI(str);
        photoDraweeView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                us.pinguo.foundation.interaction.c c = AppGoto.getInstance().c(str2);
                c.c("force_inner_browser", true);
                c.b(TaskDetailActivity.this);
            }
        });
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setParticipantEnable(boolean z) {
        this.mParticipateView.setVisibility((this.mGDPREnable && z) ? 8 : 0);
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setRanking(int i2) {
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setRefreshing(boolean z) {
        if (this.mRefreshLayout != null) {
            if (z) {
                this.mHandler.postDelayed(this.setRefreshingRunnable, 200L);
                return;
            }
            this.mHandler.removeCallbacks(this.setRefreshingRunnable);
            this.mRefreshLayout.setRefreshing(false);
        }
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setSupported(int i2) {
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setTaskAvatar(String str) {
        ((CircleImageView) findViewById(vStudio.Android.Camera360.R.id.task_detail_title_avatar)).setImageUri(str, vStudio.Android.Camera360.R.drawable.challenge_default_avatar);
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setTaskFinished(boolean z) {
        if (z) {
            hideBottomLayout();
        } else {
            showBottomLayout();
        }
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setTaskRemainTime(boolean z, int i2) {
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setTitle(String str) {
        this.mCompatibleToolbar.setCenterTitle(str);
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void setWorks(List<ChallengeDetailPhotoCell> list, boolean z) {
        if (!z) {
            setRefreshing(false);
        }
        if (list.size() > 0 && list.get(0).getData().isDemo && this.mTaskDetailPresenter.getTask().isPlay && this.mTaskDetailPresenter.getTask().isVideo()) {
            InspireWork data = list.get(0).getData();
            SharedPreferences c = Inspire.c();
            if (c.getBoolean("show_demo_" + data.taskId, true)) {
                SharedPreferences.Editor edit = Inspire.c().edit();
                edit.putBoolean("show_demo_" + data.taskId, false).apply();
                showDemoVideo(list.get(0).getData());
            }
        }
        this.mLmAdapter.beginChange();
        us.pinguo.user.recycler.c cVar = this.mLmAdapter;
        cVar.remove(1, cVar.getItemCount() - 1);
        if (!us.pinguo.foundation.utils.k.a(list)) {
            this.mLmAdapter.addAll(list);
        } else if (!z) {
            this.mLmAdapter.showEmpty(1, vStudio.Android.Camera360.R.drawable.empty_task_work, vStudio.Android.Camera360.R.string.no_task_work);
        }
        this.mLmAdapter.endChange(true);
        this.mHandler.postDelayed(this.mCheckVisRunnable, 200L);
    }

    public void share() {
        InspireStatistics.taskInfoShareClick(s0.getInstance().getUserId(), this.mTaskDetailPresenter.getTask() == null ? "" : this.mTaskDetailPresenter.getTask().taskId);
        final InspireTask task = this.mTaskDetailPresenter.getTask();
        if (task == null) {
            return;
        }
        InspireShareUtils.showShareDialog(this, new us.pinguo.inspire.util.z.a.c(task), new PGShareListener() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.6
            @Override // us.pinguo.share.core.PGShareListener
            public void onShareCancel(ShareSite shareSite) {
                us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, BaseShareDialog.a0(shareSite), "challenge_work_list", task.taskId, "share_cancel");
            }

            @Override // us.pinguo.share.core.PGShareListener
            public void onShareComplete(ShareSite shareSite, boolean z) {
                if (z) {
                    return;
                }
                us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, BaseShareDialog.a0(shareSite), "challenge_work_list", task.taskId, "share_success");
            }

            @Override // us.pinguo.share.core.PGShareListener
            public void onShareError(ShareSite shareSite, Throwable th) {
            }
        }, new OnShareSiteClickListener() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.7
            @Override // us.pinguo.share.util.OnShareSiteClickListener
            public void onShareOtherClick(OnShareSiteClickListener.ShareDialogContent shareDialogContent) {
            }

            @Override // us.pinguo.share.util.OnShareSiteClickListener
            public void onShareSiteClick(@Nullable DialogFragment dialogFragment, ExpandShareSite expandShareSite) {
                us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, BaseShareDialog.a0(expandShareSite.a()), "challenge_work_list", task.taskId, "click");
            }
        }, false, "").setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.inspire.module.MissionDetail.j
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, "", "challenge_work_list", InspireTask.this.taskId, "close_panel");
            }
        });
    }

    public void showBottomLayout() {
        ViewGroup viewGroup = this.mBottomLayout;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public void showDemoVideo(InspireWork inspireWork) {
        us.pinguo.inspire_proxy.media.e.h(this, Uri.parse(inspireWork.getWorkUrl()), inspireWork.getWidth(), inspireWork.getHeight(), 0);
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void showEmpty() {
        this.mLmAdapter.showEmpty(1, vStudio.Android.Camera360.R.drawable.empty_task_work, vStudio.Android.Camera360.R.string.no_task_work);
        setRefreshing(false);
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void showRanking(boolean z) {
    }

    @Override // us.pinguo.inspire.module.MissionDetail.IMissionDetailView
    public void showSceneDialog(String str, SceneParam sceneParam) {
        showSceneInfoDialog(str, sceneParam);
    }

    public void share(final InspireWork inspireWork) {
        if (inspireWork == null) {
            return;
        }
        InspireShareUtils.showShareDialog(this, new us.pinguo.inspire.util.z.a.d(inspireWork), new PGShareListener() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.8
            @Override // us.pinguo.share.core.PGShareListener
            public void onShareCancel(ShareSite shareSite) {
                us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, BaseShareDialog.a0(shareSite), "submit_challenge_success_popup", inspireWork.workId, "share_cancel");
            }

            @Override // us.pinguo.share.core.PGShareListener
            public void onShareComplete(ShareSite shareSite, boolean z) {
                us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, BaseShareDialog.a0(shareSite), "submit_challenge_success_popup", inspireWork.workId, "share_success");
                InspireWorkBulkLoader.increaseShareCompletion(inspireWork.workId);
            }

            @Override // us.pinguo.share.core.PGShareListener
            public void onShareError(ShareSite shareSite, Throwable th) {
            }
        }, new OnShareSiteClickListener() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.9
            @Override // us.pinguo.share.util.OnShareSiteClickListener
            public void onShareOtherClick(OnShareSiteClickListener.ShareDialogContent shareDialogContent) {
            }

            @Override // us.pinguo.share.util.OnShareSiteClickListener
            public void onShareSiteClick(@Nullable DialogFragment dialogFragment, ExpandShareSite expandShareSite) {
                us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, BaseShareDialog.a0(expandShareSite.a()), "submit_challenge_success_popup", inspireWork.workId, "click");
            }
        }, false, "").setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.inspire.module.MissionDetail.m
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, "", "submit_challenge_success_popup", InspireWork.this.workId, "close_panel");
            }
        });
    }
}
