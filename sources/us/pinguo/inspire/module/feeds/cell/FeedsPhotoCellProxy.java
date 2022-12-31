package us.pinguo.inspire.module.feeds.cell;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.foundation.statistics.l;
import us.pinguo.foundation.utils.f0;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.MissionDetail.TaskDetailActivity;
import us.pinguo.inspire.module.comment.CommentLoader;
import us.pinguo.inspire.module.comment.InspireComment;
import us.pinguo.inspire.module.comment.InspireUser;
import us.pinguo.inspire.module.comment.TranslateLayout;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.discovery.entity.InspireFeedContent;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
import us.pinguo.inspire.module.discovery.entity.InspireFeedSender;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.module.feeds.view.FeedsPhotoCommentView;
import us.pinguo.inspire.module.profile.activity.GuestProfileActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.profile.activity.ProfileActivity;
import us.pinguo.inspire.util.p;
import us.pinguo.inspire.util.transition.TouchScaleInfo;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.inspire.widget.PhotoGridView;
import us.pinguo.inspire.widget.j.b;
import us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment;
import us.pinguo.inspire.widget.videocell.InspireVideoView;
import us.pinguo.share.util.InspireShareUtils;
import us.pinguo.user.s0;
import us.pinguo.user.util.f;
import us.pinguo.user.util.j;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsPhotoCellProxy implements View.OnClickListener, PhotoGridView.a, f.b {
    public static final int REQUEST_DETAIL = 63213;
    private static int sCommentContentColor;
    private static int sCommentNameColor;
    private static int sHighLightColor;
    private ObjectAnimator mAlphaAnimator;
    private Runnable mAlphaRunnable;
    private us.pinguo.inspire.cell.recycler.e mCell;
    protected InspireFeed mData;
    protected InspireFeedContent mFcnt;
    protected Subscription mLikeSubscription;
    protected RecyclerView mRecyclerView;
    private long mStartShowTime;
    private FeedStat mStat;
    protected us.pinguo.widget.common.cell.recycler.c mViewHolder;
    private boolean mShowTime = true;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes9.dex */
    public static class InspireCommentEvent {
        public boolean add;
        public InspireComment comment;
        public String workId;

        public InspireCommentEvent(InspireComment inspireComment, boolean z, String str) {
            this.comment = inspireComment;
            this.add = z;
            this.workId = str;
        }
    }

    public FeedsPhotoCellProxy(InspireFeed inspireFeed) {
        this.mData = inspireFeed;
        registerUpdateAttentionStatus();
        registerUpdateLikeStatus();
        registerUpdateCommentStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(InspireFeedContent inspireFeedContent, InspireWork inspireWork) {
        if (inspireWork == null || this.mData == null) {
            return;
        }
        updateCollectNum(inspireFeedContent, inspireWork);
        listenLike(inspireFeedContent);
    }

    private void adjustPadding(us.pinguo.widget.common.cell.recycler.c cVar) {
        View view = cVar.getView(R.id.feeds_photo_video_container);
        if (cVar.getView(R.id.feeds_photo_game_enter_layout).getVisibility() == 8 && cVar.getView(R.id.feeds_photo_content).getVisibility() == 8) {
            view.setPadding(0, 0, 0, 0);
        } else {
            view.setPadding(0, view.getResources().getDimensionPixelSize(R.dimen.feeds_upper_part_padding), 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(InspireFeedContent inspireFeedContent, Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        listenLike(inspireFeedContent);
    }

    private void changeCollectUi(InspireFeedContent inspireFeedContent) {
        int i2;
        if (this.mViewHolder == null) {
            return;
        }
        this.mViewHolder.setImageResource(R.id.feeds_photo_collect_img, getLikeRes(inspireFeedContent));
        int i3 = inspireFeedContent.like;
        if (i3 == 0 && (i2 = inspireFeedContent.likeCount) > 0) {
            inspireFeedContent.likeCount = i2 - 1;
        } else if (i3 == 1) {
            inspireFeedContent.likeCount++;
        }
        setLikeTxt(inspireFeedContent);
    }

    private void checkShowJoinChallenge(us.pinguo.widget.common.cell.recycler.c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f() {
        share();
        FeedStat feedStat = this.mStat;
        if (feedStat != null) {
            l.c("Feed_ShareClick", feedStat);
        }
    }

    private void enterToTaskDetailPage(View view) {
        String taskId = this.mData.getTaskId();
        Intent intent = new Intent(view.getContext(), TaskDetailActivity.class);
        intent.putExtra("task_id", taskId);
        intent.putExtra("key_from_page", "首页");
        ContextCompat.startActivity(view.getContext(), intent, null);
        us.pinguo.foundation.statistics.h.a.R("follow", this.mData.getTaskId(), "click", String.valueOf(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(us.pinguo.inspire.event.c cVar) {
        if (this.mData.getFcnt() == null || !this.mData.getFcnt().workId.equals(cVar.a)) {
            return;
        }
        InspireFeed inspireFeed = this.mData;
        InspireFeedSender inspireFeedSender = inspireFeed.sender;
        if (inspireFeedSender != null) {
            inspireFeedSender.relation = cVar.b;
        }
        updateData(inspireFeed);
    }

    private us.pinguo.widget.common.cell.recycler.a getAdapter(View view) {
        RecyclerView recyclerView;
        if (view == null) {
            return null;
        }
        View view2 = (View) view.getParent();
        while (view2 != null && !(view2 instanceof RecyclerView)) {
            view2 = (View) view2.getParent();
        }
        if (!(view2 instanceof RecyclerView) || (recyclerView = (RecyclerView) view2) == null) {
            return null;
        }
        return (us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter();
    }

    private int getLikeRes(InspireFeedContent inspireFeedContent) {
        return (inspireFeedContent == null || inspireFeedContent.like == 0) ? R.drawable.feeds_photo_unlike : R.drawable.feeds_photo_liked;
    }

    private void handleTranslate(us.pinguo.widget.common.cell.recycler.c cVar) {
        TranslateLayout translateLayout = (TranslateLayout) cVar.getView(R.id.translate_layout);
        boolean z = true;
        if ((getFcnt() == null || TextUtils.isEmpty(getFcnt().desc) || getFcnt().translate != 1) ? false : false) {
            translateLayout.reset();
            translateLayout.setVisibility(0);
            translateLayout.initData(this.mData.getFcnt().workId, CommentLoader.TRANSLATE_TYPE_WORK, this.mData.getFcnt().descLang);
            return;
        }
        translateLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(Throwable th) {
        us.pinguo.foundation.e.e(th);
        d.f.a.b.d.c(th);
    }

    private boolean isAllPhotoPrepared() {
        Bitmap[] bitmaps;
        us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
        if (cVar == null || (bitmaps = ((PhotoGridView) cVar.getView(R.id.feeds_photo_group)).getBitmaps()) == null || bitmaps.length == 0) {
            return false;
        }
        for (Bitmap bitmap : bitmaps) {
            if (bitmap == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(us.pinguo.inspire.event.b bVar) {
        if (this.mData.getFcnt() == null || !this.mData.getFcnt().workId.equals(bVar.a)) {
            return;
        }
        InspireFeedContent fcnt = this.mData.getFcnt();
        fcnt.comCount--;
        List<InspireComment> list = this.mData.getFcnt().comments;
        for (int i2 = 0; list != null && i2 < list.size(); i2++) {
            if (f0.b(list.get(i2).commentId, bVar.b)) {
                list.remove(i2);
                us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
                if (cVar != null) {
                    setComment(cVar, this.mData.getFcnt());
                    setCommentNum(this.mViewHolder, this.mData.getFcnt());
                    return;
                }
                return;
            }
        }
    }

    private void listenLike(final InspireFeedContent inspireFeedContent) {
        Subscription subscription = this.mLikeSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscribe = us.pinguo.foundation.r.d.a().c(InspireWork.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.feeds.cell.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsPhotoCellProxy.this.b(inspireFeedContent, (InspireWork) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.feeds.cell.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsPhotoCellProxy.this.d(inspireFeedContent, (Throwable) obj);
            }
        });
        this.mLikeSubscription = subscribe;
        us.pinguo.foundation.utils.h.a(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(us.pinguo.inspire.event.f fVar) {
        if (this.mData.getFcnt() == null || !this.mData.getFcnt().workId.equals(fVar.a)) {
            return;
        }
        this.mData.getFcnt().likeCount = fVar.b;
        this.mData.getFcnt().like = fVar.c;
        setLikeTxt(this.mData.getFcnt());
    }

    private void registerUpdateAttentionStatus() {
        us.pinguo.foundation.utils.h.a(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire.event.c.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.feeds.cell.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsPhotoCellProxy.this.h((us.pinguo.inspire.event.c) obj);
            }
        }, d.a));
    }

    private void registerUpdateCommentStatus() {
        us.pinguo.foundation.utils.h.a(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire.event.b.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.feeds.cell.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsPhotoCellProxy.this.k((us.pinguo.inspire.event.b) obj);
            }
        }, c.a));
    }

    private void registerUpdateLikeStatus() {
        us.pinguo.foundation.utils.h.a(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire.event.f.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.feeds.cell.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsPhotoCellProxy.this.n((us.pinguo.inspire.event.f) obj);
            }
        }, h.a));
    }

    private void setCommentNum(us.pinguo.widget.common.cell.recycler.c cVar, InspireFeedContent inspireFeedContent) {
        if (cVar == null) {
            return;
        }
        if (inspireFeedContent != null && inspireFeedContent.comCount > 0) {
            cVar.setText(R.id.feeds_photo_comment_txt, InspireWork.formatNum(getFcnt().comCount));
        } else {
            cVar.setText(R.id.feeds_photo_comment_txt, R.string.inspire_comment);
        }
    }

    private void setContent(TextView textView) {
        InspireFeedContent fcnt = getFcnt();
        View view = this.mViewHolder.getView(R.id.feeds_btn_layout);
        if (fcnt != null && !TextUtils.isEmpty(fcnt.desc)) {
            if (textView.getVisibility() != 0) {
                view.setPadding(0, 0, 0, 0);
                textView.setVisibility(0);
            }
            textView.setClickable(true);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText("");
            us.pinguo.inspire.widget.j.b.f(textView, fcnt.desc, new b.c() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy.1
                @Override // us.pinguo.inspire.widget.j.b.c
                public void onClick(View view2, us.pinguo.inspire.widget.j.b bVar, b.C0407b c0407b) {
                    Intent intent = new Intent();
                    if (f0.b(s0.getInstance().getUserId(), c0407b.a)) {
                        intent.setClass(view2.getContext(), ProfileActivity.class);
                    } else {
                        intent.setClass(view2.getContext(), GuestProfileActivity.class);
                        intent.putExtra(GuestProfileFragment.USER_ID, c0407b.a);
                    }
                    view2.getContext().startActivity(intent);
                }
            });
            return;
        }
        textView.setVisibility(8);
    }

    private void setFlowerNum(us.pinguo.widget.common.cell.recycler.c cVar) {
        int i2 = getFcnt().flowerSum;
        if (i2 > 0) {
            cVar.setText(R.id.feeds_photo_flower_txt, String.valueOf(i2));
        } else {
            cVar.setText(R.id.feeds_photo_flower_txt, R.string.flower);
        }
    }

    private void setTimeAndLoc(us.pinguo.widget.common.cell.recycler.c cVar) {
        String f2 = p.f(cVar.itemView.getContext(), this.mData.timeline * 1000, System.currentTimeMillis());
        String location = getFcnt() == null ? null : getFcnt().getLocation();
        if (this.mShowTime) {
            if (!TextUtils.isEmpty(location)) {
                f2 = f2 + " / " + location;
            }
            location = f2;
        }
        TextView textView = (TextView) cVar.getView(R.id.feeds_photo_loc);
        textView.setText(location);
        if (TextUtils.isEmpty(location)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void share() {
        us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
        if (cVar == null || cVar.itemView == null) {
            return;
        }
        if (!this.mData.isVideo() && !isAllPhotoPrepared()) {
            j0.c(R.string.feeds_share_wait);
        } else {
            InspireShareUtils.showShareDialog((FragmentActivity) this.mViewHolder.itemView.getContext(), new us.pinguo.inspire.util.z.a.a(this.mData, (FeedsPhotoCommentView) this.mViewHolder.getView(R.id.feeds_photo_group)), null, null, false, "");
        }
    }

    private void tryShowBgInAnimation() {
        us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
        if (cVar == null) {
            return;
        }
        final View view = cVar.getView(R.id.feeds_photo_video_container);
        PhotoGridView photoGridView = (PhotoGridView) this.mViewHolder.getView(R.id.feeds_photo_group);
        try {
            photoGridView.setDrawingCacheEnabled(true);
            final Bitmap createBitmap = Bitmap.createBitmap(photoGridView.getDrawingCache());
            photoGridView.setDrawingCacheEnabled(false);
            ViewCompat.setBackground(view, new Drawable() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy.2
                @Override // android.graphics.drawable.Drawable
                public void draw(Canvas canvas) {
                    Rect rect = new Rect(getBounds());
                    rect.top += view.getPaddingTop();
                    canvas.drawBitmap(createBitmap, new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight()), rect, new Paint());
                }

                @Override // android.graphics.drawable.Drawable
                public int getOpacity() {
                    return -1;
                }

                @Override // android.graphics.drawable.Drawable
                public void setAlpha(int i2) {
                }

                @Override // android.graphics.drawable.Drawable
                public void setColorFilter(@Nullable ColorFilter colorFilter) {
                }
            });
        } catch (OutOfMemoryError e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    private void updateCollectNum(InspireFeedContent inspireFeedContent, InspireWork inspireWork) {
        int i2 = inspireWork.like;
        if (i2 == inspireFeedContent.like) {
            return;
        }
        inspireFeedContent.like = i2;
        if (this.mViewHolder == null) {
            return;
        }
        changeCollectUi(inspireFeedContent);
    }

    public void collect(View view, InspireFeedContent inspireFeedContent) {
        if (!s0.getInstance().e()) {
            View findViewById = view.getRootView().findViewById(16908290);
            if (findViewById != null) {
                us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
                s0.getInstance().a((Activity) findViewById.getContext(), 1, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
            }
        } else if (inspireFeedContent == null) {
        } else {
            inspireFeedContent.like = inspireFeedContent.like != 0 ? 0 : 1;
            InspireWork inspireWork = new InspireWork();
            inspireWork.workId = inspireFeedContent.workId;
            if (inspireFeedContent.like == 0) {
                inspireWork.disLike().subscribe((Subscriber<? super Boolean>) new us.pinguo.inspire.lib.rx.a());
            } else {
                inspireWork.like().subscribe((Subscriber<? super Boolean>) new us.pinguo.inspire.lib.rx.a());
                showLikeAnim();
            }
            changeCollectUi(inspireFeedContent);
        }
    }

    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feeds_photo_layout, viewGroup, false);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new us.pinguo.widget.common.cell.recycler.c(inflate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FeedsPhotoCommentView.CommentText[] getCommentText(InspireFeedContent inspireFeedContent) {
        List<InspireComment> list = inspireFeedContent.comments;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            InspireComment inspireComment = list.get(i2);
            InspireUser inspireUser = inspireComment.sender;
            String str = inspireUser == null ? " " : inspireUser.nickname;
            InspireComment.CommentBody commentBody = inspireComment.content;
            String str2 = commentBody == null ? "" : commentBody.text;
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(new FeedsPhotoCommentView.CommentText(new FeedsPhotoCommentView.CommentSeg[]{new FeedsPhotoCommentView.CommentSeg(str, sCommentNameColor), new FeedsPhotoCommentView.CommentSeg(" ", sCommentContentColor), new FeedsPhotoCommentView.CommentSeg(us.pinguo.inspire.widget.j.b.j(str2), sCommentContentColor)}));
            }
        }
        FeedsPhotoCommentView.CommentText[] commentTextArr = new FeedsPhotoCommentView.CommentText[arrayList.size()];
        arrayList.toArray(commentTextArr);
        return commentTextArr;
    }

    protected InspireFeedContent getFcnt() {
        InspireFeed inspireFeed = this.mData;
        if (inspireFeed == null) {
            return null;
        }
        if (this.mFcnt == null) {
            this.mFcnt = inspireFeed.getFcnt();
        }
        return this.mFcnt;
    }

    public View getShareElement() {
        us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
        if (cVar == null) {
            return null;
        }
        return cVar.getView(R.id.feeds_photo_group);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void intentToDetail(View view, int i2) {
        us.pinguo.widget.common.cell.recycler.a adapter;
        InspireFeedContent fcnt = getFcnt();
        if (fcnt == null || TextUtils.isEmpty(fcnt.workId) || (adapter = getAdapter(view)) == null) {
            return;
        }
        InspireWork convertFeedToWork = this.mData.convertFeedToWork();
        View shareElement = getShareElement();
        if (shareElement instanceof PhotoGridView) {
            FeedsList.tempBitmaps = ((PhotoGridView) shareElement).getBitmaps();
            setSelectedTagFromTransition(i2);
            tryShowBgInAnimation();
        }
        FeedsList.enterDetailPage(view.getContext(), convertFeedToWork.workId, "", convertFeedToWork, "from_feed", adapter, this.mCell, i2, us.pinguo.inspire.util.transition.h.a.f(view.getContext() instanceof Activity ? (Activity) view.getContext() : ActivityRecorder.getInstance().d(), shareElement));
        listenLike(fcnt);
        FeedStat feedStat = this.mStat;
        if (feedStat != null) {
            l.c("Feed_DetailClick", feedStat);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        String str;
        this.mViewHolder = cVar;
        if (sHighLightColor == 0) {
            sHighLightColor = cVar.itemView.getResources().getColor(us.pinguo.ui.R.color.color_highlight);
            sCommentNameColor = -5452545;
            sCommentContentColor = cVar.itemView.getResources().getColor(us.pinguo.ui.R.color.text_white);
        }
        if (this.mData == null) {
            return;
        }
        if (getClass().equals(FeedsPhotoCellProxy.class)) {
            ViewCompat.setTransitionName(cVar.getView(R.id.feeds_photo_group), us.pinguo.inspire.util.transition.h.a.j(this.mData));
            cVar.getView(R.id.feeds_photo_video).setVisibility(8);
            cVar.getView(R.id.feeds_photo_group).setVisibility(0);
        } else {
            ViewCompat.setTransitionName(((InspireVideoView) cVar.getView(R.id.feeds_photo_video)).b(), us.pinguo.inspire.util.transition.h.a.j(this.mData));
            cVar.getView(R.id.feeds_photo_video).setVisibility(0);
            cVar.getView(R.id.feeds_photo_group).setVisibility(8);
        }
        ViewCompat.setBackground(this.mViewHolder.getView(R.id.feeds_photo_video_container), null);
        InspireFeedSender inspireFeedSender = this.mData.sender;
        String str2 = "";
        String str3 = (inspireFeedSender == null || (str3 = inspireFeedSender.avatar) == null) ? "" : "";
        PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.feeds_photo_avatar);
        portraitImageView.setBeforeOnClickListener(this);
        portraitImageView.setImageUri(str3, us.pinguo.ui.R.drawable.default_avatar);
        portraitImageView.setMark(this.mData.sender.mark);
        InspireFeedSender inspireFeedSender2 = this.mData.sender;
        portraitImageView.setUserType(inspireFeedSender2 == null ? 0 : inspireFeedSender2.type);
        InspireFeedSender inspireFeedSender3 = this.mData.sender;
        portraitImageView.setUserId(inspireFeedSender3 == null ? "" : inspireFeedSender3.userId);
        InspireFeedSender inspireFeedSender4 = this.mData.sender;
        if (inspireFeedSender4 != null && (str = inspireFeedSender4.nickname) != null) {
            str2 = str;
        }
        cVar.setText(R.id.feeds_photo_name, str2);
        AttentionButton attentionButton = (AttentionButton) cVar.getView(R.id.feeds_relation);
        if (this.mData.sender != null) {
            attentionButton.setVisibility(0);
            InspireFeedSender inspireFeedSender5 = this.mData.sender;
            attentionButton.k(inspireFeedSender5, false, inspireFeedSender5.userId, this.mCell);
        }
        setTimeAndLoc(cVar);
        setContent((TextView) cVar.getView(R.id.feeds_photo_content));
        setPhotos(cVar);
        cVar.itemView.setOnClickListener(this);
        cVar.getView(R.id.feeds_photo_collect_img).setOnClickListener(this);
        cVar.getView(R.id.feeds_photo_collect_txt).setOnClickListener(this);
        cVar.getView(R.id.feeds_photo_share).setOnClickListener(this);
        cVar.getView(R.id.feeds_photo_content).setOnClickListener(this);
        cVar.getView(R.id.feeds_photo_comment_img).setOnClickListener(this);
        cVar.getView(R.id.feeds_photo_comment_txt).setOnClickListener(this);
        cVar.getView(R.id.feeds_photo_flower_img).setOnClickListener(this);
        cVar.getView(R.id.feeds_photo_flower_txt).setOnClickListener(this);
        setLikeTxt(getFcnt());
        setComment(cVar, getFcnt());
        setCommentNum(this.mViewHolder, getFcnt());
        setChallenge(cVar);
        adjustPadding(cVar);
        handleTranslate(cVar);
        checkShowJoinChallenge(cVar);
        setFlowerNum(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mData.isMock) {
            return;
        }
        int id = view.getId();
        if (id == R.id.feeds_photo_collect_img || id == R.id.feeds_photo_collect_txt) {
            collect(view, getFcnt());
            l.c("pc_feed_like_click", this.mStat);
        } else if (id == R.id.feeds_photo_share) {
            Activity activity = (Activity) this.mRecyclerView.getContext();
            if (activity != null) {
                j.a.b(activity, new Runnable() { // from class: us.pinguo.inspire.module.feeds.cell.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedsPhotoCellProxy.this.f();
                    }
                }, null, null);
            }
        } else if (id == R.id.feeds_photo_avatar) {
            FeedStat feedStat = this.mStat;
            if (feedStat != null) {
                l.c("Feed_OwnerInfoClick", feedStat);
            }
        } else if (id == R.id.feed_photo_game_entrance) {
            if (this.mData.isChallengeTask()) {
                enterToTaskDetailPage(view);
            }
        } else if (view.getId() == R.id.feeds_photo_join_challenge) {
            enterToTaskDetailPage(view);
        } else {
            if (view.getId() == R.id.feeds_photo_comment_img) {
                l.c("pc_feed_comment_click", this.mStat);
            }
            intentToDetail(view, 0);
        }
    }

    @Override // us.pinguo.user.util.f.b
    public void onDoubleClick(View view) {
        InspireFeedContent fcnt = getFcnt();
        if (fcnt == null || this.mData.isMock) {
            return;
        }
        if (fcnt.like == 0) {
            collect(view, getFcnt());
        } else {
            showLikeAnim();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onHide() {
        long currentTimeMillis = System.currentTimeMillis() - this.mStartShowTime;
        if (this.mData.isChallengeTask()) {
            us.pinguo.foundation.statistics.h.a.R("follow", this.mData.getTaskId(), "show", String.valueOf(currentTimeMillis));
        }
    }

    @Override // us.pinguo.inspire.widget.PhotoGridView.a
    public void onItemClick(PhotoGridView photoGridView, int i2) {
        if (this.mData.isMock) {
            return;
        }
        intentToDetail(photoGridView, i2);
        FeedStat feedStat = this.mStat;
        if (feedStat != null) {
            l.c("Feed_ContentInteraction", feedStat);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onShow() {
        this.mStartShowTime = System.currentTimeMillis();
    }

    @Override // us.pinguo.user.util.f.b
    public void onSingleClick(View view) {
    }

    public void onViewRecycled() {
        FeedsPhotoCommentView feedsPhotoCommentView;
        us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
        if (cVar != null && (feedsPhotoCommentView = (FeedsPhotoCommentView) cVar.getView(R.id.feeds_photo_group)) != null) {
            feedsPhotoCommentView.stopAnim();
        }
        this.mViewHolder = null;
        this.mRecyclerView = null;
        Subscription subscription = this.mLikeSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        if (PictureViewPagerDialogFragment.sBitmaps != null) {
            PictureViewPagerDialogFragment.sBitmaps = null;
        }
    }

    protected void releasePhotos(us.pinguo.widget.common.cell.recycler.c cVar) {
        ((PhotoGridView) cVar.getView(R.id.feeds_photo_group)).setPhotos(null);
    }

    public void releaseResource(us.pinguo.widget.common.cell.recycler.c cVar) {
        if (cVar == null) {
            return;
        }
        us.pinguo.common.log.a.k("释放图片资源", new Object[0]);
        releasePhotos(cVar);
    }

    public void reloadResource(us.pinguo.widget.common.cell.recycler.c cVar) {
        if (cVar == null) {
            return;
        }
        us.pinguo.common.log.a.k("重新加载图片资源", new Object[0]);
        setPhotos(cVar);
    }

    public void setCell(us.pinguo.inspire.cell.recycler.e eVar) {
        this.mCell = eVar;
    }

    public void setChallenge(us.pinguo.widget.common.cell.recycler.c cVar) {
        View view = cVar.getView(R.id.feeds_photo_game_enter_layout);
        TextView textView = (TextView) cVar.getView(R.id.feeds_photo_game_desc);
        TextView textView2 = (TextView) cVar.getView(R.id.feeds_photo_game_name);
        cVar.getView(R.id.feed_photo_game_entrance).setOnClickListener(this);
        if (this.mData.isChallengeTask()) {
            view.setVisibility(0);
            textView.setText(R.string.inspire_participate_short);
            String str = this.mData.getFcnt().task.taskName;
            if (str == null) {
                str = "";
            }
            textView2.setText(str);
            return;
        }
        view.setVisibility(8);
    }

    protected void setComment(us.pinguo.widget.common.cell.recycler.c cVar, InspireFeedContent inspireFeedContent) {
        FeedsPhotoCommentView feedsPhotoCommentView = (FeedsPhotoCommentView) cVar.getView(R.id.feeds_photo_group);
        List<InspireComment> list = inspireFeedContent.comments;
        if (list != null && list.size() != 0) {
            feedsPhotoCommentView.setBottomExtraPadding(0);
            feedsPhotoCommentView.setComments(getCommentText(inspireFeedContent));
        } else {
            feedsPhotoCommentView.setComments(null);
        }
        feedsPhotoCommentView.showAnim();
    }

    public void setLikeTxt(InspireFeedContent inspireFeedContent) {
        int i2;
        if (this.mViewHolder == null) {
            return;
        }
        this.mViewHolder.setImageResource(R.id.feeds_photo_collect_img, getLikeRes(getFcnt()));
        if (inspireFeedContent != null && (i2 = inspireFeedContent.likeCount) > 0) {
            this.mViewHolder.setText(R.id.feeds_photo_collect_txt, InspireWork.formatNum(i2));
        } else {
            this.mViewHolder.setText(R.id.feeds_photo_collect_txt, R.string.feeds_photo_like_no_num);
        }
    }

    protected void setPhotos(us.pinguo.widget.common.cell.recycler.c cVar) {
        List<InspireFeedPhoto> list;
        PhotoGridView photoGridView = (PhotoGridView) cVar.getView(R.id.feeds_photo_group);
        InspireFeedContent fcnt = getFcnt();
        int i2 = 1;
        photoGridView.setEnableLongPicTag(true);
        if (fcnt != null && (list = fcnt.photos) != null && list.size() != 0) {
            if (photoGridView.getVisibility() != 0) {
                photoGridView.setVisibility(0);
            }
            List<InspireFeedPhoto> list2 = fcnt.photos;
            int size = list2 == null ? 0 : list2.size();
            if (!"photo".equals(this.mData.type) || size <= 1) {
                i2 = size;
            }
            PhotoGridView.b[] bVarArr = new PhotoGridView.b[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                InspireFeedPhoto inspireFeedPhoto = fcnt.photos.get(i3);
                if (inspireFeedPhoto != null) {
                    if (i3 == 0) {
                        bVarArr[i3] = new PhotoGridView.b(inspireFeedPhoto.width, inspireFeedPhoto.height, fcnt.photos.get(i3).url);
                    } else {
                        bVarArr[i3] = new PhotoGridView.b(inspireFeedPhoto.width, inspireFeedPhoto.height, fcnt.photos.get(i3).url);
                    }
                }
            }
            if (i2 > 0) {
                if (photoGridView.getVisibility() != 0) {
                    photoGridView.setVisibility(0);
                }
                photoGridView.setPhotos(bVarArr);
                photoGridView.forceLayout();
            } else {
                photoGridView.setVisibility(4);
            }
            photoGridView.setTagText(photoGridView.getResources().getString(R.string.feeds_long_pic), 0);
            photoGridView.setOnClickListener(this);
            photoGridView.setOnItemClick(this);
            photoGridView.setOnDoubleClickListener(this);
            return;
        }
        photoGridView.setVisibility(4);
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void setSelectedTagFromTransition(int i2) {
        us.pinguo.widget.common.cell.recycler.c cVar;
        if (i2 < 0 || (cVar = this.mViewHolder) == null) {
            return;
        }
        PhotoGridView photoGridView = (PhotoGridView) cVar.getView(R.id.feeds_photo_group);
        photoGridView.setTag(R.id.tag_element_info, TouchScaleInfo.a(photoGridView, getFcnt(), i2));
    }

    public void setShowTime(boolean z) {
        this.mShowTime = z;
    }

    public void setStat(FeedStat feedStat) {
        this.mStat = feedStat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLikeAnim() {
        us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
        if (cVar == null) {
            return;
        }
        final ImageView imageView = (ImageView) cVar.getView(R.id.feeds_photo_like_anim);
        final AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        if (this.mAlphaAnimator == null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(imageView, "alpha", 255, 0);
            this.mAlphaAnimator = ofInt;
            ofInt.setDuration(300L);
            this.mAlphaAnimator.addListener(new Animator.AnimatorListener() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animationDrawable.isRunning()) {
                        return;
                    }
                    imageView.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
        }
        if (this.mAlphaRunnable == null) {
            this.mAlphaRunnable = new Runnable() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy.4
                @Override // java.lang.Runnable
                public void run() {
                    FeedsPhotoCellProxy.this.mAlphaAnimator.start();
                }
            };
        }
        this.mHandler.removeCallbacks(this.mAlphaRunnable);
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
        if (this.mAlphaAnimator.isStarted()) {
            this.mAlphaAnimator.end();
        }
        imageView.setAlpha(255);
        imageView.setVisibility(0);
        animationDrawable.start();
        imageView.postDelayed(this.mAlphaRunnable, 900L);
    }

    public void updateComment(InspireCommentEvent inspireCommentEvent) {
        InspireFeedContent fcnt = getFcnt();
        if (TextUtils.isEmpty(inspireCommentEvent.workId) || !inspireCommentEvent.workId.equals(fcnt.workId) || inspireCommentEvent == null || inspireCommentEvent.comment == null) {
            return;
        }
        if (fcnt.comments == null) {
            fcnt.comments = new ArrayList();
        }
        if (inspireCommentEvent.add) {
            fcnt.comCount++;
            fcnt.comments.add(inspireCommentEvent.comment);
            Collections.sort(fcnt.comments);
        } else {
            fcnt.comCount--;
            fcnt.comments.remove(inspireCommentEvent.comment);
        }
        us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
        if (cVar == null) {
            return;
        }
        setComment(cVar, fcnt);
        setCommentNum(this.mViewHolder, getFcnt());
    }

    public void updateData(InspireFeed inspireFeed) {
        this.mData = inspireFeed;
        this.mFcnt = null;
    }
}
