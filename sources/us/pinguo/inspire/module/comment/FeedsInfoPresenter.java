package us.pinguo.inspire.module.comment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.rockerhieu.emoji.model.Emoticon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspirePhoto;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.InspireWorkBulkLoader;
import us.pinguo.inspire.module.MissionDetail.ILoadMore;
import us.pinguo.inspire.module.MissionDetail.TaskDetailActivity;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.comment.CommentLoader;
import us.pinguo.inspire.module.comment.InspireComment;
import us.pinguo.inspire.module.comment.cell.BaseInfoCell;
import us.pinguo.inspire.module.comment.cell.CommentItemCell;
import us.pinguo.inspire.module.comment.cell.ContentInfoCell;
import us.pinguo.inspire.module.comment.cell.IdInfoCell;
import us.pinguo.inspire.module.comment.cell.ImageInfoCell;
import us.pinguo.inspire.module.comment.cell.VideoAdInfoCell;
import us.pinguo.inspire.module.comment.cell.VideoInfoCell;
import us.pinguo.inspire.module.comment.widget.InfoCommentLayout;
import us.pinguo.inspire.module.comment.widget.OnInfoCommentListener;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.module.profile.ProfileLoader;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.module.publish.InspirePublishTask;
import us.pinguo.inspire.module.publish.utils.UUIDUtils;
import us.pinguo.inspire.module.publish.vo.CommentInfo;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.inspire.widget.chat.ChatBottomLayout;
import us.pinguo.user.model.ProfileAuthorInfo;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsInfoPresenter extends us.pinguo.foundation.p.a implements ChatBottomLayout.f, OnInfoCommentListener {
    public static final int AD_INSERT_POS = 5;
    public static final int DEFAULT_NUM = 50;
    private String commentContent;
    private InspireWorkBulkLoader.AdVideo mAdVideo;
    private List<InspireAttention> mAtMembers;
    private String mCommentEp;
    private String mCommentId;
    private CommentLoader mCommentLoader;
    private String mCommentSp;
    private Subscription mCommentSubscribe;
    private List<InspireComment> mComments;
    private IFeedsInfoView mFeedsDetailView;
    private String mFrom;
    private int mInitIndex;
    private int mInitInnerIndex;
    private String mInitWorkId;
    private int mLoadMoreIndex;
    private boolean mLoadingMore = false;
    private boolean mNoMore = false;
    private List<InspireWork> mWorkList;

    static {
        clearVideoAdTag();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void A(Throwable th) {
        us.pinguo.common.log.a.m("hwLog", "监听登录失败", new Object[0]);
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.e.e(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void B(Void r2) {
        us.pinguo.common.log.a.m("zhouwei", "report success。。。", new Object[0]);
        us.pinguo.foundation.utils.j0.c(R.string.work_reported_success);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void C(Throwable th) {
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.e.e(th);
        us.pinguo.user.util.i.b(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void E(Throwable th) {
        us.pinguo.common.log.a.f(th);
        us.pinguo.user.util.i.b(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void G(InspireWork inspireWork, BaseInfoCell baseInfoCell, InspireWork inspireWork2) {
        if (inspireWork.like == 1) {
            inspireWork2.like = 1;
        }
        int i2 = inspireWork.likeSum;
        if (i2 > inspireWork2.likeSum) {
            inspireWork2.likeSum = i2;
        }
        if (baseInfoCell instanceof ContentInfoCell) {
            ((ContentInfoCell) baseInfoCell).updadeWorkFromNet(inspireWork2);
        }
        updateWork(inspireWork, inspireWork2);
        this.mFeedsDetailView.onWorkUpdated(inspireWork2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void H(Throwable th) {
        us.pinguo.foundation.e.e(th);
        if (us.pinguo.foundation.d.f10985d) {
            us.pinguo.user.util.i.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(BaseResponse baseResponse) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(Throwable th) {
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.e.e(th);
        us.pinguo.foundation.utils.j0.c(us.pinguo.c360.i18n.R.string.network_error);
    }

    private void checkInsertAdVideo(List<BaseInfoCell> list) {
        if (this.mAdVideo == null || us.pinguo.foundation.utils.k.a(list)) {
            return;
        }
        String str = list.get(0).getData().taskId;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!(us.pinguo.user.s0.getInstance().e() && us.pinguo.librouter.c.d.b().getPayInterface().a()) && Inspire.a().getSharedPreferences("challenge_ad", 0).getBoolean(str, true) && this.mInitIndex + 5 < list.size()) {
            list.add(this.mInitIndex + 5, new VideoAdInfoCell(this.mAdVideo, str));
        }
    }

    private static void clearVideoAdTag() {
        Inspire.a().getSharedPreferences("challenge_ad", 0).edit().clear().apply();
    }

    private List<BaseInfoCell> createCellList(List<InspireWork> list) {
        ArrayList arrayList = new ArrayList();
        if (us.pinguo.foundation.utils.k.a(list)) {
            return arrayList;
        }
        for (InspireWork inspireWork : list) {
            if (inspireWork.isVideo()) {
                arrayList.add(new VideoInfoCell(inspireWork));
            } else {
                if (inspireWork.isMulityPhotos()) {
                    if (inspireWork.members != null) {
                        for (int i2 = 0; i2 < inspireWork.members.size(); i2++) {
                            arrayList.add(new ImageInfoCell(inspireWork, i2));
                        }
                    }
                } else {
                    arrayList.add(new ImageInfoCell(inspireWork, 0));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(InspireComment inspireComment, Boolean bool) {
        String str = inspireComment.commentId;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mComments.size()) {
                break;
            } else if (str.equals(this.mComments.get(i2).commentId)) {
                InspireComment remove = this.mComments.remove(i2);
                this.mFeedsDetailView.getCommentLayout().deleteComment(remove);
                this.mFeedsDetailView.onCommentNumChange(false);
                us.pinguo.foundation.r.d.a().b(new us.pinguo.inspire.event.b(remove.workId, remove.commentId));
                break;
            } else {
                i2++;
            }
        }
        us.pinguo.foundation.utils.j0.c(R.string.delete_success_res_0x7f110149);
        us.pinguo.foundation.r.d.a().b(new FeedsPhotoCellProxy.InspireCommentEvent(inspireComment, false, inspireComment.workId));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(RecResp recResp) {
        this.mWorkList = new ArrayList(recResp.getItems());
        List<BaseInfoCell> initCellList = initCellList();
        this.mFeedsDetailView.setAdmin(recResp.isAdmin());
        this.mFeedsDetailView.setCells(initCellList);
    }

    private InspireComment generateOneComment(Emoticon emoticon, List<String> list, String str, List<InspireAttention> list2, InspireComment inspireComment, String str2) {
        InspireComment inspireComment2 = new InspireComment();
        inspireComment2.workId = str2;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        inspireComment2.atMembers = arrayList;
        inspireComment2.createTime = System.currentTimeMillis() / 1000;
        if (inspireComment != null) {
            inspireComment2.isReply = true;
            inspireComment2.receiver = inspireComment.sender;
        }
        inspireComment2.replyId = inspireComment == null ? "" : inspireComment.commentId;
        InspireUser inspireUser = new InspireUser();
        if (us.pinguo.user.s0.getInstance().e()) {
            inspireUser.nickname = us.pinguo.user.s0.getInstance().d();
        } else {
            inspireUser.nickname = "Anonymous user";
        }
        inspireUser.avatar = us.pinguo.user.s0.getInstance().g();
        inspireUser.userId = us.pinguo.user.s0.getInstance().getUserId();
        inspireUser.mark = us.pinguo.user.s0.getInstance().b();
        ProfileAuthorInfo profile = ProfileLoader.getInstance().getProfile();
        inspireUser.type = profile == null ? 0 : profile.type;
        inspireComment2.sender = inspireUser;
        if (inspireComment != null) {
            inspireComment2.receiver = inspireComment.sender;
        }
        InspireComment.CommentBody commentBody = new InspireComment.CommentBody();
        commentBody.text = str;
        commentBody.imgs = new ArrayList();
        if (list != null) {
            for (String str3 : list) {
                InspirePhoto inspirePhoto = new InspirePhoto();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str3, options);
                inspirePhoto.picUrl = InspirePublishFragment.FILE_HEADER + str3;
                inspirePhoto.width = options.outWidth;
                inspirePhoto.height = options.outHeight;
                commentBody.imgs.add(inspirePhoto);
            }
        }
        commentBody.emoticon = emoticon;
        inspireComment2.content = commentBody;
        return inspireComment2;
    }

    private List<CommentItemCell> getCommentCells(List<InspireComment> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                CommentItemCell commentItemCell = new CommentItemCell(list.get(i2));
                if (i2 == 0) {
                    commentItemCell.setFirst(true);
                }
                commentItemCell.setOnItemClickListener(this.mFeedsDetailView);
                arrayList.add(commentItemCell);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(Throwable th) {
        this.mFeedsDetailView.onLoadRecError();
        us.pinguo.common.log.a.f(th);
    }

    private List<BaseInfoCell> initCellList() {
        ArrayList arrayList = new ArrayList();
        if (us.pinguo.foundation.utils.k.a(this.mWorkList)) {
            InspireWork inspireWork = new InspireWork();
            String str = this.mInitWorkId;
            if (str == null) {
                str = "";
            }
            arrayList.add(new IdInfoCell(inspireWork, str));
            return arrayList;
        }
        int i2 = this.mInitIndex;
        InspireWork inspireWork2 = (i2 < 0 || i2 >= this.mWorkList.size()) ? this.mWorkList.get(0) : this.mWorkList.get(this.mInitIndex);
        Iterator<InspireWork> it = this.mWorkList.iterator();
        int i3 = 0;
        while (true) {
            Bitmap bitmap = null;
            if (it.hasNext()) {
                InspireWork next = it.next();
                if (next.isVideo()) {
                    arrayList.add(new VideoInfoCell(next));
                    if (next == inspireWork2) {
                        this.mInitIndex = i3;
                    }
                } else if (next.isMulityPhotos()) {
                    if (next.members != null) {
                        int i4 = 0;
                        while (i4 < next.members.size()) {
                            ImageInfoCell imageInfoCell = new ImageInfoCell(next, i4);
                            arrayList.add(imageInfoCell);
                            if (next == inspireWork2) {
                                Bitmap[] bitmapArr = FeedsList.tempBitmaps;
                                imageInfoCell.setTempBitmap((bitmapArr == null || bitmapArr.length <= i4) ? null : bitmapArr[i4]);
                                if (this.mInitInnerIndex == i4) {
                                    this.mInitIndex = i3;
                                }
                            }
                            i3++;
                            i4++;
                        }
                    }
                } else {
                    ImageInfoCell imageInfoCell2 = new ImageInfoCell(next, 0);
                    arrayList.add(imageInfoCell2);
                    if (next == inspireWork2) {
                        this.mInitIndex = i3;
                        Bitmap[] bitmapArr2 = FeedsList.tempBitmaps;
                        if (bitmapArr2 != null && bitmapArr2.length > 0) {
                            bitmap = bitmapArr2[0];
                        }
                        imageInfoCell2.setTempBitmap(bitmap);
                    }
                }
                i3++;
            } else {
                ((BaseInfoCell) arrayList.get(this.mInitIndex)).setShowTransition(true);
                FeedsList.tempBitmaps = null;
                checkInsertAdVideo(arrayList);
                return arrayList;
            }
        }
    }

    private void initData(Bundle bundle) {
        this.mComments = new ArrayList();
        String string = bundle.getString("feed_detail_from");
        this.mFrom = string;
        if (string == null) {
            string = "";
        }
        this.mFrom = string;
        this.mCommentId = bundle.getString("key_comment_id");
        if (bundle.containsKey("task_ad_video")) {
            this.mAdVideo = (InspireWorkBulkLoader.AdVideo) bundle.getParcelable("task_ad_video");
        }
        if (this.mFrom.equals("from_feed")) {
            this.mInitIndex = FeedsList.getSelectIndex();
            this.mInitInnerIndex = FeedsList.getSelectInnerIndex();
            this.mWorkList = FeedsList.getWorkList();
            this.mInitWorkId = null;
        } else if (this.mFrom.equals("from_message")) {
            String string2 = bundle.getString("work_id");
            this.mInitWorkId = string2;
            getWork(string2);
        } else if (this.mFrom.equals("from_rec")) {
            this.mFeedsDetailView.fillForEmptyPage();
            getRecWorks();
        } else {
            this.mWorkList = FeedsList.getWorkList();
            this.mInitIndex = FeedsList.getSelectIndex();
            List<InspireWork> list = this.mWorkList;
            if (list == null || list.size() == 0) {
                String string3 = bundle.getString("work_id");
                this.mInitWorkId = string3;
                if (TextUtils.isEmpty(string3)) {
                    this.mFeedsDetailView.finish();
                } else {
                    getWork(this.mInitWorkId);
                }
            }
        }
        if (bundle.containsKey("task_info")) {
            this.mFeedsDetailView.setTaskInfo((InspireWork.TaskInfo) bundle.getParcelable("task_info"));
        }
        if (TextUtils.isEmpty(this.mInitWorkId) && us.pinguo.foundation.utils.k.a(this.mWorkList)) {
            return;
        }
        this.mFeedsDetailView.setCells(initCellList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(InspireWork inspireWork) {
        ArrayList arrayList = new ArrayList(1);
        this.mWorkList = arrayList;
        arrayList.add(inspireWork);
        this.mFeedsDetailView.setCells(initCellList());
        this.mFeedsDetailView.hideLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(IInfoCommentLayout iInfoCommentLayout, CommentLoader.CommentResp commentResp) {
        this.mCommentEp = commentResp.ep;
        this.mCommentSp = commentResp.sp;
        List<InspireComment> list = commentResp.list;
        us.pinguo.common.log.a.k("comments size:" + list.size(), new Object[0]);
        iInfoCommentLayout.addCommentList(getCommentCells(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onGetWorkError */
    public void l(Throwable th) {
        this.mFeedsDetailView.hideLoading();
        us.pinguo.foundation.e.e(th);
        us.pinguo.user.util.i.b(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadMoreSuccess(List<InspireWork> list) {
        this.mWorkList.addAll(list);
        ArrayList arrayList = new ArrayList();
        for (InspireWork inspireWork : list) {
            if (inspireWork.isVideo()) {
                arrayList.add(new VideoInfoCell(inspireWork));
            } else {
                if (inspireWork.isMulityPhotos()) {
                    if (inspireWork.members != null) {
                        for (int i2 = 0; i2 < inspireWork.members.size(); i2++) {
                            arrayList.add(new ImageInfoCell(inspireWork, i2));
                        }
                    }
                } else {
                    arrayList.add(new ImageInfoCell(inspireWork, 0));
                }
            }
        }
        this.mFeedsDetailView.appendCells(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void q(us.pinguo.user.recycler.c cVar, Throwable th) {
        us.pinguo.foundation.e.e(th);
        cVar.hideFooter();
        us.pinguo.user.util.i.b(th);
        us.pinguo.common.log.a.k("onError..", new Object[0]);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(RecResp recResp) {
        this.mFeedsDetailView.appendCells(createCellList(recResp.getItems()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void u(Throwable th) {
        us.pinguo.common.log.a.f(th);
        this.mFeedsDetailView.appendCells(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w(InspireWork inspireWork, InfoCommentLayout infoCommentLayout, CommentLoader.CommentAndLike commentAndLike) {
        if (inspireWork != this.mFeedsDetailView.getCurrentWork()) {
            return;
        }
        inspireWork.commentAndLike = commentAndLike;
        if (commentAndLike != null) {
            setCommentAndLike(infoCommentLayout, commentAndLike);
        } else {
            infoCommentLayout.getCommentAdapter().showError();
        }
        infoCommentLayout.hideCommentLoading();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void x(InfoCommentLayout infoCommentLayout, Throwable th) {
        infoCommentLayout.hideCommentLoading();
        infoCommentLayout.getCommentAdapter().showError();
        us.pinguo.foundation.e.e(th);
        us.pinguo.user.util.i.b(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z(InspireWork inspireWork, Emoticon emoticon, String[] strArr, InspireComment inspireComment, us.pinguo.foundation.r.b bVar) {
        us.pinguo.common.log.a.m("hwLog", "监听登录成功", new Object[0]);
        if (inspireWork == this.mFeedsDetailView.getCurrentWork()) {
            addComment(emoticon, strArr == null ? null : new ArrayList(Arrays.asList(strArr)), this.commentContent, this.mAtMembers, inspireComment, inspireWork.workId);
            this.mAtMembers = null;
            this.commentContent = null;
        }
    }

    public void addComment(Emoticon emoticon, List<String> list, String str, List<InspireAttention> list2, InspireComment inspireComment, String str2) {
        InspireComment generateOneComment = generateOneComment(emoticon, list, str, list2, inspireComment, str2);
        this.mComments.add(0, generateOneComment);
        this.mFeedsDetailView.getCommentLayout().addComment(generateOneComment, this.mFeedsDetailView);
        generateOneComment.clientId = UUIDUtils.generateUUID();
        addComment(emoticon, str, list, generateOneComment, str2);
    }

    public void attachView(us.pinguo.foundation.p.b bVar) {
        this.mFeedsDetailView = (IFeedsInfoView) bVar;
        this.mCommentLoader = new CommentLoader();
        initData(this.mFeedsDetailView.getArguments());
    }

    public void cacheCommentAndLike(InspireWork inspireWork, CommentLoader.CommentAndLike commentAndLike) {
        if (this.mWorkList == null || inspireWork == null || inspireWork.workId == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mWorkList.size(); i2++) {
            InspireWork inspireWork2 = this.mWorkList.get(i2);
            if (inspireWork2 != null && inspireWork.workId.equals(inspireWork2.workId)) {
                inspireWork2.commentAndLike = commentAndLike;
                return;
            }
        }
    }

    public void cancelRec(InspireWork inspireWork) {
        RecLoader.INSTANCE.cancelRec(inspireWork).subscribe(h0.a, d0.a);
    }

    public void checkLoadMoreWorks(int i2) {
        if (this.mLoadingMore || this.mNoMore) {
            return;
        }
        ILoadMore iLoadMore = ActivityRecorder.getInstance().c() instanceof ILoadMore ? (ILoadMore) ActivityRecorder.getInstance().c() : null;
        if (iLoadMore == null) {
            return;
        }
        int i3 = this.mLoadMoreIndex;
        if (i3 == 0 || i2 >= i3) {
            this.mLoadingMore = true;
            iLoadMore.loadMore(new TaskDetailActivity.OnLoadMoreListener() { // from class: us.pinguo.inspire.module.comment.FeedsInfoPresenter.1
                @Override // us.pinguo.inspire.module.MissionDetail.TaskDetailActivity.OnLoadMoreListener
                public void onLoadMore(List<InspireWork> list, boolean z) {
                    if (z) {
                        if (us.pinguo.foundation.utils.k.a(list)) {
                            FeedsInfoPresenter.this.mNoMore = true;
                        } else {
                            FeedsInfoPresenter feedsInfoPresenter = FeedsInfoPresenter.this;
                            feedsInfoPresenter.mLoadMoreIndex = feedsInfoPresenter.mFeedsDetailView.getCellCountWithoutAd() - 1;
                            FeedsInfoPresenter.this.onLoadMoreSuccess(list);
                        }
                    }
                    FeedsInfoPresenter.this.mLoadingMore = false;
                }
            });
        }
    }

    public void delete(String str, final String str2, String str3) {
        addSubscription(this.mCommentLoader.delete(str, str2, str3).subscribe(new Action1<Void>() { // from class: us.pinguo.inspire.module.comment.FeedsInfoPresenter.2
            @Override // rx.functions.Action1
            public void call(Void r3) {
                FeedsInfoPresenter.this.mFeedsDetailView.workDeleteSuccess(str2, true);
                us.pinguo.foundation.r.d.a().b(new us.pinguo.inspire_proxy.a.a(str2));
            }
        }, i0.a));
    }

    public void deleteComment(final InspireComment inspireComment) {
        PublishData publishData;
        if (inspireComment == null) {
            return;
        }
        if (!TextUtils.isEmpty(inspireComment.clientId) && (publishData = inspireComment.publishData) != null && publishData.state == 2) {
            this.mFeedsDetailView.getCommentLayout().deleteComment(inspireComment);
        } else if (TextUtils.isEmpty(inspireComment.commentId)) {
        } else {
            addSubscription(this.mCommentLoader.deleteComment(inspireComment.commentId).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.y
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    FeedsInfoPresenter.this.e(inspireComment, (Boolean) obj);
                }
            }, j0.a));
        }
    }

    @Override // us.pinguo.foundation.p.a
    public void detachView() {
        super.detachView();
    }

    public String getFrom() {
        return this.mFrom;
    }

    public int getInitIndex() {
        return this.mInitIndex;
    }

    public int getItemCount() {
        if (TextUtils.isEmpty(this.mInitWorkId)) {
            List<InspireWork> list = this.mWorkList;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return 1;
    }

    public int getRealCount() {
        List<InspireWork> list = this.mWorkList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getRecWorks() {
        addSubscription(RecLoader.INSTANCE.refreshRecList((this.mFeedsDetailView.getArguments() == null || !this.mFeedsDetailView.getArguments().containsKey("workIds")) ? null : this.mFeedsDetailView.getArguments().getString("workIds")).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.k0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoPresenter.this.h((RecResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.comment.t0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoPresenter.this.j((Throwable) obj);
            }
        }));
    }

    public void getWork(String str) {
        if (TextUtils.isEmpty(str)) {
            k(new RuntimeException("workId is null!"));
            return;
        }
        this.mFeedsDetailView.showLoading();
        addSubscription(this.mCommentLoader.getWorkDetail(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.z
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoPresenter.this.n((InspireWork) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.comment.f0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoPresenter.this.l((Throwable) obj);
            }
        }));
    }

    public List<InspireWork> getWorkList() {
        return this.mWorkList;
    }

    public void loadMoreComment(String str, String str2, String str3, int i2) {
        final IInfoCommentLayout commentLayout = this.mFeedsDetailView.getCommentLayout();
        if (commentLayout == null || commentLayout.getCommentAdapter() == null) {
            return;
        }
        final us.pinguo.user.recycler.c commentAdapter = commentLayout.getCommentAdapter();
        if (TextUtils.isEmpty(str3)) {
            commentAdapter.hideFooter();
            commentAdapter.showNoMoreContent();
            return;
        }
        addSubscription(this.mCommentLoader.fetchCommentList(str, str2, str3, i2).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.s0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoPresenter.this.p(commentLayout, (CommentLoader.CommentResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.comment.l0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoPresenter.q(us.pinguo.user.recycler.c.this, (Throwable) obj);
            }
        }));
    }

    public void loadMoreRec() {
        RecLoader recLoader = RecLoader.INSTANCE;
        recLoader.loadRecList(recLoader.getLastPageNo() + 1).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.r0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoPresenter.this.s((RecResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.comment.a0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoPresenter.this.u((Throwable) obj);
            }
        });
    }

    public void onAdShowed() {
        String str = this.mWorkList.get(0).taskId;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Inspire.a().getSharedPreferences("challenge_ad", 0).edit().putBoolean(str, false).apply();
    }

    public void onCommentShow(final InfoCommentLayout infoCommentLayout) {
        CommentLoader.CommentResp commentResp;
        final InspireWork currentWork = this.mFeedsDetailView.getCurrentWork();
        CommentLoader.CommentAndLike commentAndLike = currentWork.commentAndLike;
        if ((commentAndLike == null || (commentResp = commentAndLike.comment) == null || us.pinguo.foundation.utils.k.a(commentResp.list)) ? false : true) {
            setCommentAndLike(infoCommentLayout, currentWork.commentAndLike);
            infoCommentLayout.hideCommentLoading();
        }
        Subscription subscribe = this.mCommentLoader.getCommentAndLike(currentWork.workId, "", "", 50, 50).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.b0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoPresenter.this.w(currentWork, infoCommentLayout, (CommentLoader.CommentAndLike) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.comment.c0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoPresenter.x(InfoCommentLayout.this, (Throwable) obj);
            }
        });
        this.mCommentSubscribe = subscribe;
        addSubscription(subscribe);
    }

    @Override // us.pinguo.inspire.module.comment.widget.OnInfoCommentListener
    public void onLoadMoreComment() {
        if (this.mFeedsDetailView.getCurrentWork() == null) {
            return;
        }
        loadMoreComment(this.mFeedsDetailView.getCurrentWork().getWorkId(), this.mCommentSp, this.mCommentEp, 1);
    }

    public void onPageSelected(int i2) {
        Subscription subscription = this.mCommentSubscribe;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void onPause() {
    }

    @Override // us.pinguo.inspire.widget.chat.ChatBottomLayout.f
    public void onSendClick(String str, List<InspireAttention> list, final InspireComment inspireComment, final String[] strArr, final Emoticon emoticon) {
        this.commentContent = str;
        this.mAtMembers = list;
        if (emoticon != null) {
            String str2 = emoticon.emoticonId;
        }
        final InspireWork currentWork = this.mFeedsDetailView.getCurrentWork();
        if (currentWork == null) {
            return;
        }
        if (!us.pinguo.user.s0.getInstance().e() && CommentLoader.isLoginRequired()) {
            us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
            us.pinguo.user.s0.getInstance().a(this.mFeedsDetailView.getActivity(), 0, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
            us.pinguo.common.log.a.m("hwLog", "未登录，注册监听", new Object[0]);
            addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.foundation.r.b.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.p0
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    FeedsInfoPresenter.this.z(currentWork, emoticon, strArr, inspireComment, (us.pinguo.foundation.r.b) obj);
                }
            }, q0.a));
        } else if (CommentLoader.isLoginRequired() || us.pinguo.user.s0.getInstance().e() || !this.mFeedsDetailView.checkShowLoginWhenAnonymous("comment_anonymous_click")) {
            addComment(emoticon, strArr == null ? null : new ArrayList(Arrays.asList(strArr)), this.commentContent, this.mAtMembers, inspireComment, currentWork.workId);
            this.mAtMembers = null;
            this.commentContent = null;
        }
    }

    public synchronized void removeWork(String str, int i2) {
        List<InspireWork> list = this.mWorkList;
        if (list != null && str != null) {
            if (i2 >= 0 && i2 < list.size() && str.equals(this.mWorkList.get(i2).workId)) {
                this.mWorkList.remove(i2);
                return;
            }
            for (int i3 = 0; i3 < this.mWorkList.size(); i3++) {
                if (str.equals(this.mWorkList.get(i2).workId)) {
                    this.mWorkList.remove(i3);
                    return;
                }
            }
        }
    }

    public void report(String str, String str2) {
        addSubscription(this.mCommentLoader.report(str, str2).subscribe(u0.a, o0.a));
    }

    public void reportComment(InspireComment inspireComment) {
        if (inspireComment == null || TextUtils.isEmpty(inspireComment.commentId)) {
            return;
        }
        addSubscription(this.mCommentLoader.reportComment(inspireComment.commentId).observeOn(AndroidSchedulers.mainThread()).subscribe(m0.a, g0.a));
    }

    public void setCommentAndLike(InfoCommentLayout infoCommentLayout, CommentLoader.CommentAndLike commentAndLike) {
        this.mComments.clear();
        CommentLoader.CommentResp commentResp = commentAndLike.comment;
        if (commentResp != null) {
            this.mCommentSp = commentResp.sp;
            this.mCommentEp = commentResp.ep;
            this.mComments.addAll(commentResp.list);
        }
        infoCommentLayout.setComments(getCommentCells(this.mComments));
    }

    public synchronized void updateWork(InspireWork inspireWork, InspireWork inspireWork2) {
        if (this.mWorkList != null && inspireWork2 != null && inspireWork2.workId != null) {
            for (int i2 = 0; i2 < this.mWorkList.size(); i2++) {
                InspireWork inspireWork3 = this.mWorkList.get(i2);
                if (inspireWork3 != null && inspireWork2.workId.equals(inspireWork3.workId)) {
                    this.mWorkList.set(i2, inspireWork2);
                    return;
                }
            }
        }
    }

    public void updateWorkFromNet(final BaseInfoCell baseInfoCell, final InspireWork inspireWork) {
        if (baseInfoCell instanceof IdInfoCell) {
            return;
        }
        if (inspireWork != null && !TextUtils.isEmpty(inspireWork.workId)) {
            String str = this.mInitWorkId;
            if (str != null && str.equals(inspireWork.workId)) {
                this.mInitWorkId = null;
                return;
            } else {
                addSubscription(this.mCommentLoader.getWorkDetail(inspireWork.workId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.n0
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        FeedsInfoPresenter.this.G(inspireWork, baseInfoCell, (InspireWork) obj);
                    }
                }, e0.a));
                return;
            }
        }
        us.pinguo.foundation.e.e(new RuntimeException("workId is null!"));
    }

    private void addComment(Emoticon emoticon, String str, List<String> list, InspireComment inspireComment, String str2) {
        PublishData publishData = new PublishData();
        publishData.clientId = inspireComment.clientId;
        CommentInfo commentInfo = new CommentInfo();
        publishData.commentInfo = commentInfo;
        commentInfo.content = str;
        commentInfo.replyId = inspireComment.replyId;
        commentInfo.emoticonId = emoticon == null ? null : emoticon.emoticonId;
        commentInfo.workId = str2;
        publishData.isPhoto = true;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            publishData.filePathes = arrayList;
            arrayList.addAll(list);
        }
        inspireComment.publishData = publishData;
        publishData.attentions = inspireComment.atMembers;
        new InspirePublishTask().publishComment(publishData);
    }
}
