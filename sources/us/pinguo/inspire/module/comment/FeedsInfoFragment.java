package us.pinguo.inspire.module.comment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.rockerhieu.emoji.KeyboardFrameLayout;
import com.rockerhieu.emoji.KeyboardLayout;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import us.pinguo.c360.i18n.R;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.foundation.base.SubscriptionFragment;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspirePhoto;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.MissionDetail.TaskDetailActivity;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.inspire.module.comment.cell.BaseInfoCell;
import us.pinguo.inspire.module.comment.cell.CommentItemCell;
import us.pinguo.inspire.module.comment.cell.ContentInfoCell;
import us.pinguo.inspire.module.comment.cell.IVideoInfo;
import us.pinguo.inspire.module.comment.cell.ImageInfoCell;
import us.pinguo.inspire.module.comment.cell.VideoAdInfoCell;
import us.pinguo.inspire.module.comment.cell.VideoInfoCell;
import us.pinguo.inspire.module.comment.widget.CommentRecyclerView;
import us.pinguo.inspire.module.comment.widget.FlingDownViewPager;
import us.pinguo.inspire.module.comment.widget.InfoBottomLayout;
import us.pinguo.inspire.module.comment.widget.InfoChatBottom;
import us.pinguo.inspire.module.comment.widget.InfoCommentLayout;
import us.pinguo.inspire.module.comment.widget.InfoTopLayout;
import us.pinguo.inspire.module.comment.widget.InfoVideoView;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.module.profile.FlowerLoader;
import us.pinguo.inspire.module.publish.event.UpdatePublishStateEvent;
import us.pinguo.inspire.module.publish.vo.CommentInfo;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.inspire.widget.chat.ChatBottomLayout;
import us.pinguo.share.util.BaseShareDialog;
import us.pinguo.share.util.ExpandShareSite;
import us.pinguo.share.util.InspireShareUtils;
import us.pinguo.share.util.OnShareSiteClickListener;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
import us.pinguo.user.util.f;
/* compiled from: FeedsInfoFragment.kt */
/* loaded from: classes9.dex */
public class FeedsInfoFragment extends SubscriptionFragment implements ViewPager.OnPageChangeListener, IFeedsInfoView, IInfoView, CommentRecyclerView.OnZoomOutListener, f.b, us.pinguo.inspire.util.transition.c {
    public static final Companion Companion = new Companion(null);
    private static String element_id = "challenge_work_detail_page";
    private boolean isAdmin;
    private long mCurrentShowTime;
    private Runnable mDeleteAdRunnable;
    private ObjectAnimator mLikeAnimator;
    private Runnable mLikeRunnable;
    private FeedsInfoPagerAdapter mPagerAdapter;
    private ImageInfoCell mPreMultiImageCell;
    private FeedsInfoPresenter mPresenter;
    private View mProgressView;
    private InspireComment mScrollToComment;
    private InfoVideoPresenter mVideoPresenter;
    private FlingDownViewPager mViewPager;
    private InspireWork.TaskInfo taskInfo;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final int REQUEST_LOGIN = 324;
    private int mEnterIndex = -1;
    private int mCurrentIndex = -1;
    private boolean mUpdateWorkFromNet = true;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* compiled from: FeedsInfoFragment.kt */
    /* loaded from: classes9.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final String getElement_id() {
            return FeedsInfoFragment.element_id;
        }

        public final void setElement_id(String str) {
            kotlin.jvm.internal.s.h(str, "<set-?>");
            FeedsInfoFragment.element_id = str;
        }
    }

    private final boolean checkIfCanDeleteComment(InspireComment inspireComment) {
        PublishData publishData;
        if (TextUtils.isEmpty(inspireComment.commentId)) {
            return (TextUtils.isEmpty(inspireComment.clientId) || (publishData = inspireComment.publishData) == null || publishData.state != 2) ? false : true;
        }
        InspireWork currentWork = getCurrentWork();
        if (kotlin.jvm.internal.s.c(currentWork == null ? null : currentWork.authorId, us.pinguo.user.s0.getInstance().getUserId())) {
            return true;
        }
        if (kotlin.jvm.internal.s.c(inspireComment.sender.userId, us.pinguo.user.s0.getInstance().getUserId())) {
            return us.pinguo.user.s0.getInstance().e() || CommentLoader.isLoginRequired();
        }
        return false;
    }

    private final void createCommentItemDialog(final InspireComment inspireComment, boolean z) {
        CharSequence[] charSequenceArr;
        String str;
        final SpannableString spannableString = new SpannableString(us.pinguo.foundation.e.b().getString(R.string.delete));
        spannableString.setSpan(new ForegroundColorSpan((int) SupportMenu.CATEGORY_MASK), 0, spannableString.length(), 17);
        final String string = us.pinguo.foundation.e.b().getString(vStudio.Android.Camera360.R.string.report);
        kotlin.jvm.internal.s.g(string, "getAppContext().getStrin…re_proxy.R.string.report)");
        String string2 = us.pinguo.foundation.e.b().getString(us.pinguo.foundation.R.string.cancel);
        kotlin.jvm.internal.s.g(string2, "getAppContext().getStrin…undation.R.string.cancel)");
        boolean z2 = (((inspireComment == null ? null : inspireComment.sender) == null || (str = inspireComment.sender.userId) == null || !kotlin.jvm.internal.s.c(str, us.pinguo.user.s0.getInstance().getUserId())) && (inspireComment == null || TextUtils.isEmpty(inspireComment.clientId))) ? false : true;
        if (z) {
            charSequenceArr = z2 ? new CharSequence[]{spannableString, string2} : new CharSequence[]{spannableString, string, string2};
        } else if (z2) {
            return;
        } else {
            charSequenceArr = new CharSequence[]{string, string2};
        }
        final CharSequence[] charSequenceArr2 = charSequenceArr;
        us.pinguo.foundation.utils.w.s(getActivity(), charSequenceArr, new DialogInterface.OnClickListener() { // from class: us.pinguo.inspire.module.comment.FeedsInfoFragment$createCommentItemDialog$1
            private final void onClickItemDeleteMenu() {
                FeedsInfoPresenter mPresenter = this.getMPresenter();
                if (mPresenter == null) {
                    return;
                }
                mPresenter.deleteComment(inspireComment);
            }

            private final void onClickItemReportMenu() {
                FeedsInfoPresenter mPresenter = this.getMPresenter();
                if (mPresenter == null) {
                    return;
                }
                mPresenter.reportComment(inspireComment);
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int i2) {
                kotlin.jvm.internal.s.h(dialog, "dialog");
                CharSequence[] charSequenceArr3 = charSequenceArr2;
                if (i2 >= charSequenceArr3.length) {
                    return;
                }
                CharSequence charSequence = charSequenceArr3[i2];
                if (kotlin.jvm.internal.s.c(spannableString, charSequence)) {
                    onClickItemDeleteMenu();
                } else if (kotlin.jvm.internal.s.c(string, charSequence)) {
                    onClickItemReportMenu();
                }
                dialog.dismiss();
            }
        }, null);
    }

    private final void hackCurItem(int i2) {
        FlingDownViewPager flingDownViewPager = this.mViewPager;
        if (flingDownViewPager != null) {
            us.pinguo.foundation.utils.a0.d(flingDownViewPager, VerticalViewPager.class, "mCurItem", Integer.valueOf(i2));
        } else {
            kotlin.jvm.internal.s.z("mViewPager");
            throw null;
        }
    }

    private final void initChatBottom() {
        int i2 = us.pinguo.inspire.R.id.info_bottom_chat_layout;
        ((InfoChatBottom) _$_findCachedViewById(i2)).setGetWorkIdPresenter(new ChatBottomLayout.e() { // from class: us.pinguo.inspire.module.comment.k
            @Override // us.pinguo.inspire.widget.chat.ChatBottomLayout.e
            public final String a() {
                String m129initChatBottom$lambda3;
                m129initChatBottom$lambda3 = FeedsInfoFragment.m129initChatBottom$lambda3(FeedsInfoFragment.this);
                return m129initChatBottom$lambda3;
            }
        });
        int i3 = us.pinguo.inspire.R.id.info_keyboard_layout;
        ((KeyboardFrameLayout) _$_findCachedViewById(i3)).setOnkbdStateListener((InfoChatBottom) _$_findCachedViewById(i2));
        ((KeyboardFrameLayout) _$_findCachedViewById(i3)).setOnDispatchTouchListener(new KeyboardLayout.a() { // from class: us.pinguo.inspire.module.comment.s
            @Override // com.rockerhieu.emoji.KeyboardLayout.a
            public final void onDispatchTouchEvent(MotionEvent motionEvent) {
                FeedsInfoFragment.m130initChatBottom$lambda4(FeedsInfoFragment.this, motionEvent);
            }
        });
        ((InfoChatBottom) _$_findCachedViewById(i2)).setOnSendClickListener(this.mPresenter);
        ((InfoBottomLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_bottom_layout)).setMIInfoView(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initChatBottom$lambda-3  reason: not valid java name */
    public static final String m129initChatBottom$lambda3(FeedsInfoFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        InspireWork currentWork = this$0.getCurrentWork();
        if (currentWork == null) {
            return null;
        }
        return currentWork.workId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initChatBottom$lambda-4  reason: not valid java name */
    public static final void m130initChatBottom$lambda4(FeedsInfoFragment this$0, MotionEvent motionEvent) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ((InfoChatBottom) this$0._$_findCachedViewById(us.pinguo.inspire.R.id.info_bottom_chat_layout)).onDispatchTouchEvent(motionEvent);
        InfoCommentLayout infoCommentLayout = (InfoCommentLayout) this$0._$_findCachedViewById(us.pinguo.inspire.R.id.info_comment_layout);
        boolean z = false;
        if (infoCommentLayout != null && infoCommentLayout.getVisibility() == 0) {
            z = true;
        }
        if (z && motionEvent.getAction() == 0) {
            int[] iArr = new int[2];
            this$0._$_findCachedViewById(us.pinguo.inspire.R.id.info_comment_title_layout).getLocationInWindow(iArr);
            if (motionEvent.getRawY() <= iArr[1]) {
                ((InfoBottomLayout) this$0._$_findCachedViewById(us.pinguo.inspire.R.id.info_bottom_layout)).hideChatBottom$Inspire_marketGoogleRelease();
            }
        }
    }

    private final void initTop() {
        ((InfoTopLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_top_layout)).setOnInfoTopClickListener(new FeedsInfoFragment$initTop$1(this));
    }

    private final void initViewPager(View view) {
        View findViewById = view.findViewById(vStudio.Android.Camera360.R.id.feeds_detail_viewpager);
        kotlin.jvm.internal.s.g(findViewById, "root.findViewById<FlingD…d.feeds_detail_viewpager)");
        FlingDownViewPager flingDownViewPager = (FlingDownViewPager) findViewById;
        this.mViewPager = flingDownViewPager;
        if (flingDownViewPager != null) {
            flingDownViewPager.setPageMarginDrawable(new ColorDrawable(getResources().getColor(us.pinguo.user.R.color.portal_page_bg)));
            FlingDownViewPager flingDownViewPager2 = this.mViewPager;
            if (flingDownViewPager2 != null) {
                flingDownViewPager2.setOnPageChangeListener(this);
                FlingDownViewPager flingDownViewPager3 = this.mViewPager;
                if (flingDownViewPager3 != null) {
                    flingDownViewPager3.setOffscreenPageLimit(1);
                    return;
                } else {
                    kotlin.jvm.internal.s.z("mViewPager");
                    throw null;
                }
            }
            kotlin.jvm.internal.s.z("mViewPager");
            throw null;
        }
        kotlin.jvm.internal.s.z("mViewPager");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onFlowerClick$lambda-18  reason: not valid java name */
    public static final void m131onFlowerClick$lambda18(FeedsInfoFragment this$0, Integer s) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.g(s, "s");
        this$0.updateFlower(s.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onFlowerClick$lambda-19  reason: not valid java name */
    public static final void m132onFlowerClick$lambda19(Throwable th) {
        us.pinguo.foundation.utils.j0.d(th.getMessage());
        us.pinguo.common.log.a.f(th);
    }

    private final void onReceiveUpdateStateMsg(UpdatePublishStateEvent updatePublishStateEvent) {
        us.pinguo.user.recycler.c commentAdapter;
        CommentInfo commentInfo;
        String str = null;
        if ((updatePublishStateEvent == null ? null : updatePublishStateEvent.publishData) == null || TextUtils.isEmpty(updatePublishStateEvent.publishData.clientId)) {
            return;
        }
        InfoCommentLayout infoCommentLayout = (InfoCommentLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_comment_layout);
        List cells = (infoCommentLayout == null || (commentAdapter = infoCommentLayout.getCommentAdapter()) == null) ? null : commentAdapter.getCells();
        if (cells == null) {
            return;
        }
        Iterator it = cells.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next instanceof CommentItemCell) {
                CommentItemCell commentItemCell = (CommentItemCell) next;
                if (kotlin.jvm.internal.s.c(updatePublishStateEvent.publishData.clientId, commentItemCell.getData().clientId)) {
                    updateComment(commentItemCell, updatePublishStateEvent);
                    break;
                }
            }
        }
        if (updatePublishStateEvent.publishData.state == 4) {
            InspireWork currentWork = getCurrentWork();
            String str2 = currentWork == null ? null : currentWork.workId;
            PublishData publishData = updatePublishStateEvent.publishData;
            if (publishData != null && (commentInfo = publishData.commentInfo) != null) {
                str = commentInfo.workId;
            }
            if (kotlin.jvm.internal.s.c(str2, str)) {
                onCommentNumChange(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onShareClick$lambda-16  reason: not valid java name */
    public static final void m133onShareClick$lambda16(FeedsInfoFragment this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
        InspireWork currentWork = this$0.getCurrentWork();
        cVar.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, "", "challenge_work_detail_page", currentWork == null ? null : currentWork.workId, "close_panel");
    }

    private final void preloadVideo(int i2, int i3) {
        InfoVideoPresenter infoVideoPresenter;
        int i4 = i2 + 1 == i3 ? i3 + 1 : i3 - 1;
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
        BaseInfoCell item = feedsInfoPagerAdapter == null ? null : feedsInfoPagerAdapter.getItem(i4);
        if (!(item instanceof IVideoInfo) || (infoVideoPresenter = this.mVideoPresenter) == null) {
            return;
        }
        infoVideoPresenter.preloadVideo((IVideoInfo) item);
    }

    private final void refreshFlowers() {
        if (!us.pinguo.user.s0.getInstance().e()) {
            BaseInfoCell currentCell = getCurrentCell();
            if (currentCell instanceof ContentInfoCell) {
                ((ContentInfoCell) currentCell).updateFlower(FlowerLoader.INSTANCE.getFLOWER_NUM_UNLOGIN());
                return;
            }
            return;
        }
        FlowerLoader.INSTANCE.refreshFlowerCount().subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.j
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoFragment.m134refreshFlowers$lambda0(FeedsInfoFragment.this, (Integer) obj);
            }
        }, p.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshFlowers$lambda-0  reason: not valid java name */
    public static final void m134refreshFlowers$lambda0(FeedsInfoFragment this$0, Integer s) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        BaseInfoCell currentCell = this$0.getCurrentCell();
        if (currentCell instanceof ContentInfoCell) {
            kotlin.jvm.internal.s.g(s, "s");
            ((ContentInfoCell) currentCell).updateFlower(s.intValue());
        }
    }

    private final void registerLoginEvent() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.foundation.r.b.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.l
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoFragment.m136registerLoginEvent$lambda20(FeedsInfoFragment.this, (us.pinguo.foundation.r.b) obj);
            }
        }, x.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerLoginEvent$lambda-20  reason: not valid java name */
    public static final void m136registerLoginEvent$lambda20(FeedsInfoFragment this$0, us.pinguo.foundation.r.b bVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.refreshFlowers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerLoginEvent$lambda-21  reason: not valid java name */
    public static final void m137registerLoginEvent$lambda21(Throwable th) {
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.e.e(th);
    }

    private final void registerUpdateAddCommentStateMsg() {
        addSubscription(us.pinguo.foundation.r.d.a().c(UpdatePublishStateEvent.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoFragment.m138registerUpdateAddCommentStateMsg$lambda10(FeedsInfoFragment.this, (UpdatePublishStateEvent) obj);
            }
        }, u.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerUpdateAddCommentStateMsg$lambda-10  reason: not valid java name */
    public static final void m138registerUpdateAddCommentStateMsg$lambda10(FeedsInfoFragment this$0, UpdatePublishStateEvent updatePublishStateEvent) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (updatePublishStateEvent.getFilterType() == 1) {
            this$0.onReceiveUpdateStateMsg(updatePublishStateEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentWork$lambda-9  reason: not valid java name */
    public static final void m140setCurrentWork$lambda9(FeedsInfoFragment this$0, int i2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this$0.mPagerAdapter;
        if (feedsInfoPagerAdapter != null) {
            feedsInfoPagerAdapter.removeItem(i2);
        }
        if (this$0.mCurrentIndex == i2 + 1) {
            this$0.hackCurItem(i2);
        }
        FeedsInfoPagerAdapter feedsInfoPagerAdapter2 = this$0.mPagerAdapter;
        if (feedsInfoPagerAdapter2 != null) {
            feedsInfoPagerAdapter2.notifyDataSetChanged();
        }
        this$0.mDeleteAdRunnable = null;
        FlingDownViewPager flingDownViewPager = this$0.mViewPager;
        if (flingDownViewPager != null) {
            this$0.mCurrentIndex = flingDownViewPager.getCurrentItem();
        } else {
            kotlin.jvm.internal.s.z("mViewPager");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shareWithCheck() {
        FragmentActivity activity;
        final BaseInfoCell currentCell = getCurrentCell();
        boolean z = currentCell instanceof ContentInfoCell;
        if (z && z && (activity = getActivity()) != null) {
            us.pinguo.user.util.j.c(us.pinguo.user.util.j.a, activity, new Runnable() { // from class: us.pinguo.inspire.module.comment.i
                @Override // java.lang.Runnable
                public final void run() {
                    FeedsInfoFragment.m141shareWithCheck$lambda2(BaseInfoCell.this);
                }
            }, null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shareWithCheck$lambda-2  reason: not valid java name */
    public static final void m141shareWithCheck$lambda2(BaseInfoCell baseInfoCell) {
        ((ContentInfoCell) baseInfoCell).onShareClick();
    }

    private final void showLikeAnim() {
        int i2 = us.pinguo.inspire.R.id.info_like_anim;
        if (((ImageView) _$_findCachedViewById(i2)) == null) {
            ((ViewStub) _$_findCachedViewById(us.pinguo.inspire.R.id.info_like_anim_stub)).inflate();
        }
        Drawable drawable = ((ImageView) _$_findCachedViewById(i2)).getDrawable();
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        final AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
        if (this.mLikeAnimator == null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt((ImageView) _$_findCachedViewById(i2), "alpha", 255, 0);
            this.mLikeAnimator = ofInt;
            kotlin.jvm.internal.s.e(ofInt);
            ofInt.setDuration(300L);
            ObjectAnimator objectAnimator = this.mLikeAnimator;
            kotlin.jvm.internal.s.e(objectAnimator);
            objectAnimator.addListener(new us.pinguo.ui.widget.j() { // from class: us.pinguo.inspire.module.comment.FeedsInfoFragment$showLikeAnim$1
                @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ImageView imageView;
                    kotlin.jvm.internal.s.h(animation, "animation");
                    if (animationDrawable.isRunning() || (imageView = (ImageView) this._$_findCachedViewById(us.pinguo.inspire.R.id.info_like_anim)) == null) {
                        return;
                    }
                    imageView.setVisibility(8);
                }
            });
        }
        if (this.mLikeRunnable == null) {
            this.mLikeRunnable = new Runnable() { // from class: us.pinguo.inspire.module.comment.g
                @Override // java.lang.Runnable
                public final void run() {
                    FeedsInfoFragment.m142showLikeAnim$lambda14(FeedsInfoFragment.this);
                }
            };
        }
        Runnable runnable = this.mLikeRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
        ObjectAnimator objectAnimator2 = this.mLikeAnimator;
        kotlin.jvm.internal.s.e(objectAnimator2);
        if (objectAnimator2.isStarted()) {
            ObjectAnimator objectAnimator3 = this.mLikeAnimator;
            kotlin.jvm.internal.s.e(objectAnimator3);
            objectAnimator3.end();
        }
        ((ImageView) _$_findCachedViewById(i2)).setAlpha(255);
        ((ImageView) _$_findCachedViewById(i2)).setVisibility(0);
        animationDrawable.start();
        ((ImageView) _$_findCachedViewById(i2)).postDelayed(this.mLikeRunnable, 900L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showLikeAnim$lambda-14  reason: not valid java name */
    public static final void m142showLikeAnim$lambda14(FeedsInfoFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ObjectAnimator objectAnimator = this$0.mLikeAnimator;
        if (objectAnimator == null) {
            return;
        }
        objectAnimator.start();
    }

    private final void updateComment(CommentItemCell commentItemCell, UpdatePublishStateEvent updatePublishStateEvent) {
        us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("updateComment", Integer.valueOf(updatePublishStateEvent.publishData.state)), new Object[0]);
        int i2 = updatePublishStateEvent.publishData.state;
        if (i2 == 2) {
            if (!TextUtils.isEmpty(updatePublishStateEvent.errorMsg)) {
                us.pinguo.foundation.utils.j0.d(updatePublishStateEvent.errorMsg);
            }
        } else if (i2 == 4) {
            List<InspirePhoto> list = updatePublishStateEvent.getInspireComment().content.imgs;
            if (!(list == null || list.isEmpty())) {
                ArrayList arrayList = new ArrayList();
                for (InspirePhoto inspirePhoto : list) {
                    String str = inspirePhoto.picUrl;
                    if (!(str == null || str.length() == 0)) {
                        arrayList.add(inspirePhoto.picUrl);
                    }
                }
                us.pinguo.user.util.n nVar = us.pinguo.user.util.n.a;
                String UPLOAD_MEDIA_CHECK = us.pinguo.user.u0.m;
                kotlin.jvm.internal.s.g(UPLOAD_MEDIA_CHECK, "UPLOAD_MEDIA_CHECK");
                nVar.o(UPLOAD_MEDIA_CHECK, arrayList, null, new Runnable() { // from class: us.pinguo.inspire.module.comment.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedsInfoFragment.m143updateComment$lambda13(FeedsInfoFragment.this);
                    }
                }, null);
            }
            commentItemCell.getData().clientId = null;
            if (updatePublishStateEvent.getInspireComment() != null) {
                commentItemCell.getData().createTime = updatePublishStateEvent.getInspireComment().createTime;
                commentItemCell.getData().commentId = updatePublishStateEvent.getInspireComment().commentId;
                if (getCurrentWork() != null) {
                    us.pinguo.foundation.r.d a = us.pinguo.foundation.r.d.a();
                    InspireComment data = commentItemCell.getData();
                    InspireWork currentWork = getCurrentWork();
                    a.b(new FeedsPhotoCellProxy.InspireCommentEvent(data, true, currentWork != null ? currentWork.workId : null));
                }
            }
        }
        commentItemCell.updateState(updatePublishStateEvent.publishData.state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateComment$lambda-13  reason: not valid java name */
    public static final void m143updateComment$lambda13(FeedsInfoFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.utils.w.k(this$0.getActivity(), us.pinguo.user.R.string.upload_risky_image, us.pinguo.ui.R.string.ok, -999, false, r.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateComment$lambda-13$lambda-12  reason: not valid java name */
    public static final void m144updateComment$lambda13$lambda12(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            dialogInterface.dismiss();
        }
    }

    private final void updateFlower(int i2) {
        int i3 = this.mCurrentIndex;
        int i4 = i3 - 2;
        int i5 = i3 + 2;
        if (i4 > i5) {
            return;
        }
        while (true) {
            int i6 = i4 + 1;
            FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
            BaseInfoCell item = feedsInfoPagerAdapter == null ? null : feedsInfoPagerAdapter.getItem(i4);
            if (item instanceof ContentInfoCell) {
                ((ContentInfoCell) item).updateFlower(i2);
            }
            if (i4 == i5) {
                return;
            }
            i4 = i6;
        }
    }

    private final void updateWorkInfo(BaseInfoCell baseInfoCell) {
        if (baseInfoCell == null) {
            return;
        }
        baseInfoCell.setOnDoubleClickListener(this);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void appendCells(List<BaseInfoCell> list) {
        List U;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList<BaseInfoCell> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((BaseInfoCell) obj) instanceof ContentInfoCell) {
                arrayList.add(obj);
            }
        }
        for (BaseInfoCell baseInfoCell : arrayList) {
            ((ContentInfoCell) baseInfoCell).setInfoView(this);
        }
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
        if (feedsInfoPagerAdapter != null) {
            U = kotlin.collections.c0.U(list);
            feedsInfoPagerAdapter.addItems(U);
        }
        FeedsInfoPagerAdapter feedsInfoPagerAdapter2 = this.mPagerAdapter;
        if (feedsInfoPagerAdapter2 == null) {
            return;
        }
        feedsInfoPagerAdapter2.notifyDataSetChanged();
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public boolean checkShowLoginWhenAnonymous(String key) {
        kotlin.jvm.internal.s.h(key, "key");
        SharedPreferences c = Inspire.c();
        int i2 = c.getInt(key, 0);
        if (i2 == 3) {
            us.pinguo.user.s0.getInstance().a(ActivityRecorder.getInstance().d(), this.REQUEST_LOGIN, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
            c.edit().putInt(key, i2 + 1).apply();
            return true;
        }
        c.edit().putInt(key, i2 + 1).apply();
        return false;
    }

    public final void collect() {
        if (!us.pinguo.user.s0.getInstance().e() && CommentLoader.isLoginRequired()) {
            us.pinguo.user.s0.getInstance().a(ActivityRecorder.getInstance().d(), 1, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
            return;
        }
        InspireWork currentWork = getCurrentWork();
        if (currentWork == null) {
            return;
        }
        int i2 = currentWork.like == 0 ? 1 : 0;
        currentWork.like = i2;
        if (i2 == 0) {
            currentWork.disLike().subscribe((Subscriber<? super Boolean>) new us.pinguo.inspire.lib.rx.a());
            currentWork.likeSum--;
        } else {
            currentWork.like().subscribe((Subscriber<? super Boolean>) new us.pinguo.inspire.lib.rx.a());
            currentWork.likeSum++;
        }
        us.pinguo.foundation.r.d.a().b(new us.pinguo.inspire.event.f(currentWork.workId, currentWork.likeSum, currentWork.like));
        if (getCurrentCell() instanceof ContentInfoCell) {
            BaseInfoCell currentCell = getCurrentCell();
            Objects.requireNonNull(currentCell, "null cannot be cast to non-null type us.pinguo.inspire.module.comment.cell.ContentInfoCell");
            ((ContentInfoCell) currentCell).updateLike(currentWork);
        }
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void fillForEmptyPage() {
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void finish() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    @Override // androidx.fragment.app.Fragment, us.pinguo.inspire.module.comment.IFeedsInfoView
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return getActivity();
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public int getCellCountWithoutAd() {
        kotlin.z.d h2;
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
        kotlin.jvm.internal.s.e(feedsInfoPagerAdapter);
        h2 = kotlin.z.j.h(0, feedsInfoPagerAdapter.getCount());
        ArrayList arrayList = new ArrayList();
        for (Integer num : h2) {
            int intValue = num.intValue();
            FeedsInfoPagerAdapter mPagerAdapter = getMPagerAdapter();
            if (!((mPagerAdapter == null ? null : mPagerAdapter.getItem(intValue)) instanceof VideoAdInfoCell)) {
                arrayList.add(num);
            }
        }
        return arrayList.size();
    }

    @Override // us.pinguo.inspire.util.transition.c
    public View getChangedShareElement() {
        FeedsInfoPagerAdapter feedsInfoPagerAdapter;
        BaseInfoCell item;
        int i2 = this.mCurrentIndex;
        if (i2 == this.mEnterIndex || (feedsInfoPagerAdapter = this.mPagerAdapter) == null || (item = feedsInfoPagerAdapter.getItem(i2)) == null) {
            return null;
        }
        return item.getShareElement();
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public IInfoCommentLayout getCommentLayout() {
        return (InfoCommentLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_comment_layout);
    }

    public final BaseInfoCell getCurrentCell() {
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
        if (feedsInfoPagerAdapter == null) {
            return null;
        }
        return feedsInfoPagerAdapter.getItem(this.mCurrentIndex);
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public InspireWork getCurrentWork() {
        BaseInfoCell item;
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
        if (feedsInfoPagerAdapter == null || (item = feedsInfoPagerAdapter.getItem(this.mCurrentIndex)) == null) {
            return null;
        }
        return item.getData();
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public InspireBaseActivity getInspireActivity() {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type us.pinguo.foundation.base.InspireBaseActivity");
        return (InspireBaseActivity) activity;
    }

    protected final long getMCurrentShowTime() {
        return this.mCurrentShowTime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FeedsInfoPagerAdapter getMPagerAdapter() {
        return this.mPagerAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FeedsInfoPresenter getMPresenter() {
        return this.mPresenter;
    }

    protected final boolean getMUpdateWorkFromNet() {
        return this.mUpdateWorkFromNet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final InfoVideoPresenter getMVideoPresenter() {
        return this.mVideoPresenter;
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "challenge_work_detail_page";
    }

    public final int getREQUEST_LOGIN() {
        return this.REQUEST_LOGIN;
    }

    public final void handleSharePreprocessResult() {
        shareWithCheck();
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void hideLoading() {
        View view = this.mProgressView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void initData() {
        InfoVideoPresenter infoVideoPresenter = new InfoVideoPresenter();
        this.mVideoPresenter = infoVideoPresenter;
        kotlin.jvm.internal.s.e(infoVideoPresenter);
        infoVideoPresenter.attachView(this);
        FeedsInfoPresenter feedsInfoPresenter = new FeedsInfoPresenter();
        this.mPresenter = feedsInfoPresenter;
        if (feedsInfoPresenter == null) {
            return;
        }
        feedsInfoPresenter.attachView(this);
    }

    protected void initRefresh() {
        ((SwipeRefreshLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_refresh)).setEnabled(false);
    }

    @Override // us.pinguo.inspire.module.comment.IInfoView
    public boolean isCommentLayoutShowing() {
        int i2 = us.pinguo.inspire.R.id.info_comment_layout;
        return ((InfoCommentLayout) _$_findCachedViewById(i2)) != null && ((InfoCommentLayout) _$_findCachedViewById(i2)).getVisibility() == 0;
    }

    public final boolean onBackPressed() {
        int i2 = us.pinguo.inspire.R.id.info_bottom_layout;
        if (((InfoBottomLayout) _$_findCachedViewById(i2)) == null || !((InfoBottomLayout) _$_findCachedViewById(i2)).onBackPressed()) {
            BaseInfoCell currentCell = getCurrentCell();
            if ((currentCell instanceof ContentInfoCell) && ((ContentInfoCell) currentCell).onBackPressed()) {
                return true;
            }
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            String str = element_id;
            InspireWork currentWork = getCurrentWork();
            cVar.M(str, "close_page", "", currentWork == null ? null : currentWork.workId, "click");
            return false;
        }
        return true;
    }

    @Override // us.pinguo.inspire.module.comment.IInfoView
    public void onCameraClick(InspireWork work) {
        Resources resources;
        kotlin.jvm.internal.s.h(work, "work");
        InspireWork.TaskInfo taskInfo = this.taskInfo;
        if (taskInfo != null && taskInfo.isFinished()) {
            FragmentActivity activity = getActivity();
            String str = null;
            if (activity != null && (resources = activity.getResources()) != null) {
                str = resources.getString(vStudio.Android.Camera360.R.string.task_finished);
            }
            us.pinguo.foundation.utils.j0.d(str);
            return;
        }
        InspireWork.TaskInfo taskInfo2 = work.taskInfo;
        if (taskInfo2 != null && taskInfo2.taskType == 5) {
            TaskDetailBasePresenter.onParticipatePhotoMovie(getActivity(), work.taskInfo.toTask(), work.workId);
        } else {
            TaskDetailBasePresenter.onParticipateForInfo(getActivity(), work.taskInfo, work.isVideo());
        }
    }

    @Override // us.pinguo.inspire.module.comment.IInfoView
    public void onChallengeClick() {
        InspireWork.TaskInfo taskInfo;
        String str;
        InspireWork.TaskInfo taskInfo2;
        InspireWork currentWork = getCurrentWork();
        if (!TextUtils.isEmpty((currentWork == null || (taskInfo = currentWork.taskInfo) == null) ? null : taskInfo.h5GotoUrl)) {
            us.pinguo.foundation.interaction.c c = AppGoto.getInstance().c((currentWork == null || (taskInfo2 = currentWork.taskInfo) == null) ? null : taskInfo2.h5GotoUrl);
            c.c("force_inner_browser", true);
            c.b(getActivity());
        } else {
            if (!(currentWork != null && currentWork.isTaskWork()) || (str = currentWork.taskId) == null) {
                if ((currentWork == null ? null : currentWork.taskInfo) != null) {
                    str = (currentWork == null ? null : currentWork.taskInfo).taskId;
                } else {
                    str = null;
                }
            }
            if (str != null) {
                Intent intent = new Intent(getContext(), TaskDetailActivity.class);
                intent.putExtra("task_id", str);
                intent.putExtra("key_from_page", "详情");
                startActivity(intent);
            }
        }
        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
        String str2 = element_id;
        InspireWork currentWork2 = getCurrentWork();
        cVar.M(str2, "task", "", currentWork2 != null ? currentWork2.workId : null, "click");
    }

    @Override // us.pinguo.inspire.module.comment.IInfoView
    public void onChatBottomHide() {
        InfoCommentLayout infoCommentLayout = (InfoCommentLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_comment_layout);
        if (infoCommentLayout == null) {
            return;
        }
        infoCommentLayout.hideCommentLayout$Inspire_marketGoogleRelease();
    }

    @Override // us.pinguo.inspire.module.comment.IInfoView
    public void onCommentClick() {
        ((InfoBottomLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_bottom_layout)).showChatBottom();
        if (((CommentRecyclerView) _$_findCachedViewById(us.pinguo.inspire.R.id.info_recycler)) == null) {
            ((ViewStub) _$_findCachedViewById(us.pinguo.inspire.R.id.info_comment_layout_stub)).inflate();
            int i2 = us.pinguo.inspire.R.id.info_comment_layout;
            ((InfoChatBottom) _$_findCachedViewById(us.pinguo.inspire.R.id.info_bottom_chat_layout)).addOnLayoutChangeListener((InfoCommentLayout) _$_findCachedViewById(i2));
            InfoCommentLayout infoCommentLayout = (InfoCommentLayout) _$_findCachedViewById(i2);
            kotlin.jvm.internal.s.e(infoCommentLayout);
            infoCommentLayout.setOnZoomOutListener(this);
            ((InfoCommentLayout) _$_findCachedViewById(i2)).setOnInfoCommentListener(this.mPresenter);
        }
        int i3 = us.pinguo.inspire.R.id.info_comment_layout;
        InfoCommentLayout infoCommentLayout2 = (InfoCommentLayout) _$_findCachedViewById(i3);
        InspireWork currentWork = getCurrentWork();
        infoCommentLayout2.showComment$Inspire_marketGoogleRelease(currentWork == null ? 0 : currentWork.commentSum);
        FeedsInfoPresenter feedsInfoPresenter = this.mPresenter;
        if (feedsInfoPresenter != null) {
            feedsInfoPresenter.onCommentShow((InfoCommentLayout) _$_findCachedViewById(i3));
        }
        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
        String str = element_id;
        InspireWork currentWork2 = getCurrentWork();
        cVar.M(str, "comment", "", currentWork2 == null ? null : currentWork2.workId, "click");
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void onCommentNumChange(boolean z) {
        InspireWork currentWork = getCurrentWork();
        if (z) {
            if (currentWork != null) {
                currentWork.commentSum++;
            }
        } else if (currentWork != null) {
            currentWork.commentSum--;
        }
        BaseInfoCell currentCell = getCurrentCell();
        if (currentCell instanceof ContentInfoCell) {
            ((ContentInfoCell) currentCell).updateCommentNum(currentWork);
        }
        InfoCommentLayout infoCommentLayout = (InfoCommentLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_comment_layout);
        if (infoCommentLayout == null) {
            return;
        }
        infoCommentLayout.updateCommentNum(currentWork == null ? null : Integer.valueOf(currentWork.commentSum));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        element_id = "challenge_work_detail_page";
        return inflater.inflate(vStudio.Android.Camera360.R.layout.feeds_info_fragment, viewGroup, false);
    }

    @Override // us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        us.pinguo.librouter.c.d.b().getPayInterface().e();
        InfoGuide.cancelGuide();
        InfoVideoPresenter infoVideoPresenter = this.mVideoPresenter;
        if (infoVideoPresenter != null) {
            infoVideoPresenter.detachView();
        }
        this.mVideoPresenter = null;
        FeedsInfoPresenter feedsInfoPresenter = this.mPresenter;
        if (feedsInfoPresenter != null) {
            feedsInfoPresenter.detachView();
        }
        this.mPresenter = null;
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.user.util.f.b
    public void onDoubleClick(View view) {
        InspireWork currentWork = getCurrentWork();
        if (currentWork != null && currentWork.like == 0) {
            collect();
            showLikeAnim();
        } else {
            showLikeAnim();
        }
        InspireWork currentWork2 = getCurrentWork();
        if (currentWork2 != null && currentWork2.like == 1) {
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            String str = element_id;
            InspireWork currentWork3 = getCurrentWork();
            cVar.M(str, "like", "", currentWork3 != null ? currentWork3.workId : null, "double_click");
        } else {
            us.pinguo.foundation.statistics.c cVar2 = us.pinguo.foundation.statistics.h.a;
            String str2 = element_id;
            InspireWork currentWork4 = getCurrentWork();
            cVar2.M(str2, "non_like", "", currentWork4 != null ? currentWork4.workId : null, "double_click");
        }
        if (!us.pinguo.user.s0.getInstance().e()) {
        }
    }

    public final void onFinish(Intent intent) {
        BaseVideoTextureView videoView;
        InspireWork data;
        InspireWork data2;
        kotlin.jvm.internal.s.h(intent, "intent");
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
        String str = null;
        BaseInfoCell item = feedsInfoPagerAdapter == null ? null : feedsInfoPagerAdapter.getItem(this.mCurrentIndex);
        if (this.mEnterIndex != this.mCurrentIndex) {
            intent.putExtra("changedTaskId", (item == null || (data = item.getData()) == null) ? null : data.taskId);
            if (item != null && (data2 = item.getData()) != null) {
                str = data2.workId;
            }
            intent.putExtra("changedWorkId", str);
            if (item instanceof ImageInfoCell) {
                intent.putExtra("changedWorkInnerIndex", ((ImageInfoCell) item).getMIndex());
            }
        }
        if (item instanceof VideoInfoCell) {
            InfoVideoView videoView2 = ((VideoInfoCell) item).getVideoView();
            if (kotlin.jvm.internal.s.c((videoView2 == null || (videoView = videoView2.getVideoView()) == null) ? 0 : Float.valueOf(videoView.getRotation()), 0) || videoView2 == null) {
                return;
            }
            videoView2.showCover();
        }
    }

    @Override // us.pinguo.inspire.module.comment.IInfoView
    public void onFlowerClick() {
        if (getCurrentWork() == null) {
            return;
        }
        FlowerLoader flowerLoader = FlowerLoader.INSTANCE;
        if (flowerLoader.getFlowerNum() == 0) {
            return;
        }
        InspireWork currentWork = getCurrentWork();
        kotlin.jvm.internal.s.e(currentWork);
        String str = currentWork.workId;
        kotlin.jvm.internal.s.g(str, "currentWork!!.workId");
        flowerLoader.sendFlower(str).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.q
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FeedsInfoFragment.m131onFlowerClick$lambda18(FeedsInfoFragment.this, (Integer) obj);
            }
        }, m.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseFragment
    public void onFragmentHide() {
        super.onFragmentHide();
        statShowTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseFragment
    public void onFragmentShow() {
        super.onFragmentShow();
        this.mCurrentShowTime = System.currentTimeMillis();
    }

    @Override // us.pinguo.inspire.module.comment.cell.CommentItemCell.OnItemClickListener
    public void onItemClick(InspireComment inspireComment) {
        if (inspireComment == null || kotlin.jvm.internal.s.c(inspireComment.sender.userId, us.pinguo.user.s0.getInstance().getUserId())) {
            return;
        }
        ((InfoChatBottom) _$_findCachedViewById(us.pinguo.inspire.R.id.info_bottom_chat_layout)).setReplyMode(inspireComment);
        scrollToComment(inspireComment);
    }

    @Override // us.pinguo.inspire.module.comment.cell.CommentItemCell.OnItemClickListener
    public void onItemLongClick(InspireComment inspireComment) {
    }

    @Override // us.pinguo.inspire.module.comment.cell.CommentItemCell.OnItemClickListener
    public void onItemMenuClick(InspireComment selectComment) {
        kotlin.jvm.internal.s.h(selectComment, "selectComment");
        createCommentItemDialog(selectComment, checkIfCanDeleteComment(selectComment));
    }

    @Override // us.pinguo.inspire.module.comment.IInfoView
    public void onLikeClick() {
        int i2;
        int i3;
        int i4;
        if (!us.pinguo.user.s0.getInstance().e() && CommentLoader.isLoginRequired()) {
            us.pinguo.user.s0.getInstance().a(getActivity(), this.REQUEST_LOGIN, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
        } else if (!us.pinguo.user.s0.getInstance().e() && !CommentLoader.isLoginRequired() && checkShowLoginWhenAnonymous("like_anonymous_click")) {
        } else {
            collect();
            InspireWork currentWork = getCurrentWork();
            boolean z = false;
            if (currentWork != null && currentWork.like == 1) {
                us.pinguo.foundation.statistics.h.a.M(element_id, "like", "", currentWork == null ? null : currentWork.workId, "click");
            } else {
                us.pinguo.foundation.statistics.h.a.M(element_id, "non_like", "", currentWork == null ? null : currentWork.workId, "click");
            }
            if (currentWork != null && currentWork.isMulityPhotos()) {
                z = true;
            }
            if (!z || (i2 = this.mCurrentIndex) - 9 > (i3 = i2 + 9)) {
                return;
            }
            while (true) {
                int i5 = i4 + 1;
                if (i4 >= 0) {
                    FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
                    BaseInfoCell item = feedsInfoPagerAdapter == null ? null : feedsInfoPagerAdapter.getItem(i4);
                    if (item instanceof ImageInfoCell) {
                        ImageInfoCell imageInfoCell = (ImageInfoCell) item;
                        if (us.pinguo.foundation.utils.f0.b(imageInfoCell.getData().workId, currentWork.workId)) {
                            imageInfoCell.getData().like = currentWork.like;
                            imageInfoCell.getData().likeSum = currentWork.likeSum;
                            imageInfoCell.updateLike(currentWork);
                        }
                    }
                }
                if (i4 == i3) {
                    return;
                }
                i4 = i5;
            }
        }
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void onLoadRecError() {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Runnable runnable;
        if (i2 != 0 || this.mDeleteAdRunnable == null) {
            return;
        }
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
        if (((feedsInfoPagerAdapter == null ? null : feedsInfoPagerAdapter.getItem(this.mCurrentIndex)) instanceof VideoAdInfoCell) || (runnable = this.mDeleteAdRunnable) == null) {
            return;
        }
        runnable.run();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        BaseInfoCell item;
        int i3 = this.mCurrentIndex;
        InspireWork inspireWork = null;
        if (i3 >= 0) {
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            String str = element_id;
            String str2 = i2 > i3 ? "next_work" : "previous_work";
            InspireWork currentWork = getCurrentWork();
            cVar.M(str, str2, "", currentWork == null ? null : currentWork.workId, "slide");
        }
        FeedsList.setCurrentWork(getCurrentWork());
        ((InfoChatBottom) _$_findCachedViewById(us.pinguo.inspire.R.id.info_bottom_chat_layout)).refreshBottomLayout();
        FeedsInfoPresenter feedsInfoPresenter = this.mPresenter;
        if (feedsInfoPresenter != null) {
            feedsInfoPresenter.onPageSelected(i2);
        }
        setCurrentWork(i2);
        us.pinguo.foundation.r.d a = us.pinguo.foundation.r.d.a();
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
        if (feedsInfoPagerAdapter != null && (item = feedsInfoPagerAdapter.getItem(i2)) != null) {
            inspireWork = item.getData();
        }
        a.b(new InfoPageChangeEvent(inspireWork));
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        InfoVideoPresenter infoVideoPresenter = this.mVideoPresenter;
        if (infoVideoPresenter != null) {
            infoVideoPresenter.onPause();
        }
        FeedsInfoPresenter feedsInfoPresenter = this.mPresenter;
        if (feedsInfoPresenter == null) {
            return;
        }
        feedsInfoPresenter.onPause();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        resumeVideo();
        if (us.pinguo.user.s0.getInstance().e()) {
            refreshFlowers();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.s.h(outState, "outState");
        super.onSaveInstanceState(outState);
        FeedsInfoPresenter feedsInfoPresenter = this.mPresenter;
        if ((feedsInfoPresenter == null ? null : feedsInfoPresenter.getWorkList()) != null) {
            FeedsInfoPresenter feedsInfoPresenter2 = this.mPresenter;
            List<InspireWork> workList = feedsInfoPresenter2 != null ? feedsInfoPresenter2.getWorkList() : null;
            Objects.requireNonNull(workList, "null cannot be cast to non-null type java.util.ArrayList<us.pinguo.inspire.model.InspireWork>");
            FeedsList.onSaveInstanceState(outState, (ArrayList) workList);
        }
    }

    @Override // us.pinguo.inspire.module.comment.IInfoView
    public void onShareClick() {
        us.pinguo.inspire.y.a.c mViewHolder;
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
        BaseInfoCell item = feedsInfoPagerAdapter == null ? null : feedsInfoPagerAdapter.getItem(this.mCurrentIndex);
        if ((item == null ? null : item.getMViewHolder()) == null) {
            us.pinguo.foundation.utils.j0.c(vStudio.Android.Camera360.R.string.feeds_share_wait);
        } else if (getCurrentWork() == null) {
        } else {
            InspireShareUtils.showShareDialog(getActivity(), new us.pinguo.inspire.util.z.a.d(item.getData(), (item == null || (mViewHolder = item.getMViewHolder()) == null) ? null : mViewHolder.a(vStudio.Android.Camera360.R.id.piv_image_info)), new FeedsInfoFragment$onShareClick$1(this), new OnShareSiteClickListener() { // from class: us.pinguo.inspire.module.comment.FeedsInfoFragment$onShareClick$2
                @Override // us.pinguo.share.util.OnShareSiteClickListener
                public void onShareOtherClick(OnShareSiteClickListener.ShareDialogContent shareDialogContent) {
                    kotlin.jvm.internal.s.h(shareDialogContent, "shareDialogContent");
                }

                @Override // us.pinguo.share.util.OnShareSiteClickListener
                public void onShareSiteClick(DialogFragment dialogFragment, ExpandShareSite shareSite) {
                    kotlin.jvm.internal.s.h(shareSite, "shareSite");
                    us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                    String a0 = BaseShareDialog.a0(shareSite.a());
                    InspireWork currentWork = FeedsInfoFragment.this.getCurrentWork();
                    cVar.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, a0, "challenge_work_detail_page", currentWork == null ? null : currentWork.workId, "click");
                }
            }, false, "").setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.inspire.module.comment.o
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FeedsInfoFragment.m133onShareClick$lambda16(FeedsInfoFragment.this, dialogInterface);
                }
            });
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            String str = element_id;
            InspireWork currentWork = getCurrentWork();
            cVar.M(str, FirebaseAnalytics.Event.SHARE, "", currentWork != null ? currentWork.workId : null, "click");
        }
    }

    @Override // us.pinguo.user.util.f.b
    public void onSingleClick(View view) {
        InfoVideoPresenter infoVideoPresenter;
        if (!(view instanceof InfoVideoView) || (infoVideoPresenter = this.mVideoPresenter) == null) {
            return;
        }
        infoVideoPresenter.onVideoClick((InfoVideoView) view);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        us.pinguo.inspire.util.transition.h hVar = us.pinguo.inspire.util.transition.h.a;
        FragmentActivity requireActivity = requireActivity();
        kotlin.jvm.internal.s.g(requireActivity, "requireActivity()");
        hVar.m(requireActivity, this);
        FeedsList.onRestoreInstanceState(bundle);
        initViewPager(view);
        initRefresh();
        initData();
        initTop();
        initChatBottom();
        registerUpdateAddCommentStateMsg();
        registerLoginEvent();
        us.pinguo.librouter.c.d.b().getPayInterface().d(getActivity());
        FragmentActivity requireActivity2 = requireActivity();
        kotlin.jvm.internal.s.g(requireActivity2, "requireActivity()");
        FlingDownViewPager flingDownViewPager = this.mViewPager;
        if (flingDownViewPager == null) {
            kotlin.jvm.internal.s.z("mViewPager");
            throw null;
        }
        FeedsInfoPresenter feedsInfoPresenter = this.mPresenter;
        hVar.r(requireActivity2, flingDownViewPager, feedsInfoPresenter != null ? feedsInfoPresenter.getFrom() : null);
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void onWorkUpdated(InspireWork work) {
        kotlin.jvm.internal.s.h(work, "work");
        if (kotlin.jvm.internal.s.c(work, getCurrentWork())) {
            BaseInfoCell currentCell = getCurrentCell();
            if (currentCell instanceof ContentInfoCell) {
                ((ContentInfoCell) currentCell).updadeWorkFromNet(work);
            }
        }
    }

    @Override // us.pinguo.inspire.module.comment.widget.CommentRecyclerView.OnZoomOutListener
    public void onZoomOut() {
    }

    public void resumeVideo() {
        InfoVideoPresenter infoVideoPresenter = this.mVideoPresenter;
        if (infoVideoPresenter == null) {
            return;
        }
        infoVideoPresenter.onResume();
    }

    public final void scrollToComment(InspireComment comment) {
        kotlin.jvm.internal.s.h(comment, "comment");
        InfoCommentLayout infoCommentLayout = (InfoCommentLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_comment_layout);
        if ((infoCommentLayout == null ? null : infoCommentLayout.getCommentAdapter()) == null) {
            return;
        }
        this.mScrollToComment = comment;
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void setAdmin(boolean z) {
        this.isAdmin = z;
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void setCells(List<BaseInfoCell> cells) {
        FeedsInfoPresenter feedsInfoPresenter;
        kotlin.jvm.internal.s.h(cells, "cells");
        ArrayList<BaseInfoCell> arrayList = new ArrayList();
        for (Object obj : cells) {
            if (((BaseInfoCell) obj) instanceof ContentInfoCell) {
                arrayList.add(obj);
            }
        }
        for (BaseInfoCell baseInfoCell : arrayList) {
            ((ContentInfoCell) baseInfoCell).setInfoView(this);
        }
        int i2 = 0;
        boolean z = this.mPagerAdapter == null;
        this.mCurrentIndex = -1;
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = new FeedsInfoPagerAdapter(cells);
        this.mPagerAdapter = feedsInfoPagerAdapter;
        FlingDownViewPager flingDownViewPager = this.mViewPager;
        if (flingDownViewPager != null) {
            flingDownViewPager.setAdapter(feedsInfoPagerAdapter);
            if (z && (feedsInfoPresenter = this.mPresenter) != null) {
                i2 = feedsInfoPresenter.getInitIndex();
            }
            FlingDownViewPager flingDownViewPager2 = this.mViewPager;
            if (flingDownViewPager2 != null) {
                flingDownViewPager2.setCurrentItem(i2);
                if (this.mEnterIndex < 0) {
                    this.mEnterIndex = i2;
                }
                setCurrentWork(i2);
                refreshFlowers();
                if (z) {
                    InfoGuide.checkShowGuideFirst(getView(), this);
                    return;
                }
                return;
            }
            kotlin.jvm.internal.s.z("mViewPager");
            throw null;
        }
        kotlin.jvm.internal.s.z("mViewPager");
        throw null;
    }

    public void setCurrentWork(final int i2) {
        InspireWork.TaskInfo taskInfo;
        String str;
        FeedsInfoPresenter feedsInfoPresenter;
        if (i2 == this.mCurrentIndex) {
            return;
        }
        if (getView() != null) {
            InfoGuide.checkShowGuide(getView(), this);
        }
        statShowTime();
        this.mCurrentShowTime = System.currentTimeMillis();
        refreshFlowers();
        FeedsInfoPresenter feedsInfoPresenter2 = this.mPresenter;
        if (feedsInfoPresenter2 != null) {
            feedsInfoPresenter2.checkLoadMoreWorks(i2);
        }
        preloadVideo(this.mCurrentIndex, i2);
        this.mCurrentIndex = i2;
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
        BaseInfoCell item = feedsInfoPagerAdapter == null ? null : feedsInfoPagerAdapter.getItem(i2);
        if (item instanceof ImageInfoCell) {
            ImageInfoCell imageInfoCell = (ImageInfoCell) item;
            if (imageInfoCell.getData().isMulityPhotos()) {
                ImageInfoCell imageInfoCell2 = this.mPreMultiImageCell;
                if (imageInfoCell2 != null) {
                    imageInfoCell2.setTransitionName(null);
                }
                imageInfoCell.setTransitionName(us.pinguo.inspire.util.transition.h.a.i(imageInfoCell.getData()));
                this.mPreMultiImageCell = imageInfoCell;
            }
        } else if (item instanceof VideoAdInfoCell) {
            ((InfoBottomLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_bottom_layout)).setVisibility(8);
            ((InfoTopLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_top_layout)).setVisibility(8);
            InfoVideoPresenter infoVideoPresenter = this.mVideoPresenter;
            if (infoVideoPresenter != null) {
                infoVideoPresenter.onPageSelect(item);
            }
            this.mDeleteAdRunnable = new Runnable() { // from class: us.pinguo.inspire.module.comment.n
                @Override // java.lang.Runnable
                public final void run() {
                    FeedsInfoFragment.m140setCurrentWork$lambda9(FeedsInfoFragment.this, i2);
                }
            };
            FeedsInfoPresenter feedsInfoPresenter3 = this.mPresenter;
            if (feedsInfoPresenter3 == null) {
                return;
            }
            feedsInfoPresenter3.onAdShowed();
            return;
        }
        ((InfoBottomLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_bottom_layout)).setVisibility(0);
        ((InfoTopLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_top_layout)).setVisibility(0);
        if ((item == null ? null : item.getMViewHolder()) != null) {
            InfoVideoPresenter infoVideoPresenter2 = this.mVideoPresenter;
            if (infoVideoPresenter2 != null) {
                infoVideoPresenter2.onPageSelect(item);
            }
        } else {
            FeedsInfoFragment$setCurrentWork$runnable$1 feedsInfoFragment$setCurrentWork$runnable$1 = new FeedsInfoFragment$setCurrentWork$runnable$1(this, i2, item);
            Context context = getContext();
            if (context != null) {
                us.pinguo.foundation.l.c.b(context, new FeedsInfoFragment$setCurrentWork$2(feedsInfoFragment$setCurrentWork$runnable$1), 50L);
            }
        }
        InspireWork currentWork = getCurrentWork();
        FeedsList.setCurrentWork(currentWork);
        long currentTimeMillis = System.currentTimeMillis();
        updateWorkInfo(item);
        us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("uploadWork:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)), new Object[0]);
        if (this.mUpdateWorkFromNet && (feedsInfoPresenter = this.mPresenter) != null) {
            feedsInfoPresenter.updateWorkFromNet(item, currentWork);
        }
        InfoCommentLayout infoCommentLayout = (InfoCommentLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.info_comment_layout);
        if (infoCommentLayout != null) {
            infoCommentLayout.clearComments$Inspire_marketGoogleRelease();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("workId:");
        sb.append((Object) (currentWork != null ? currentWork.workId : null));
        sb.append("   \n taskId:");
        String str2 = "NULL";
        if (currentWork != null && (taskInfo = currentWork.taskInfo) != null && (str = taskInfo.taskId) != null) {
            str2 = str;
        }
        sb.append(str2);
        us.pinguo.common.log.a.k(sb.toString(), new Object[0]);
    }

    protected final void setMCurrentShowTime(long j2) {
        this.mCurrentShowTime = j2;
    }

    protected final void setMPagerAdapter(FeedsInfoPagerAdapter feedsInfoPagerAdapter) {
        this.mPagerAdapter = feedsInfoPagerAdapter;
    }

    protected final void setMPresenter(FeedsInfoPresenter feedsInfoPresenter) {
        this.mPresenter = feedsInfoPresenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMUpdateWorkFromNet(boolean z) {
        this.mUpdateWorkFromNet = z;
    }

    protected final void setMVideoPresenter(InfoVideoPresenter infoVideoPresenter) {
        this.mVideoPresenter = infoVideoPresenter;
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void setTaskInfo(InspireWork.TaskInfo taskInfo) {
        kotlin.jvm.internal.s.h(taskInfo, "taskInfo");
        this.taskInfo = taskInfo;
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void showLoading() {
        View inflate = ((ViewStub) _$_findCachedViewById(us.pinguo.inspire.R.id.info_progress_stub)).inflate();
        this.mProgressView = inflate;
        if (inflate == null) {
            return;
        }
        inflate.setVisibility(0);
    }

    protected final void statShowTime() {
        Boolean valueOf;
        InspireWork currentWork;
        InspireWork.TaskInfo taskInfo;
        InspireWork.TaskInfo taskInfo2;
        if (this.mCurrentIndex < 0 || this.mCurrentShowTime <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mCurrentShowTime;
        if (currentTimeMillis <= 0 || currentTimeMillis > 60000) {
            return;
        }
        FeedsInfoPagerAdapter feedsInfoPagerAdapter = this.mPagerAdapter;
        BaseInfoCell item = feedsInfoPagerAdapter == null ? null : feedsInfoPagerAdapter.getItem(this.mCurrentIndex);
        if (item == null) {
            valueOf = null;
        } else {
            View requireView = requireView();
            kotlin.jvm.internal.s.g(requireView, "requireView()");
            valueOf = Boolean.valueOf(item.isFullScreen(requireView));
        }
        kotlin.jvm.internal.s.c(valueOf, Boolean.TRUE);
        if (item instanceof VideoAdInfoCell) {
            InspireWork.TaskInfo taskInfo3 = this.taskInfo;
            String str = taskInfo3 == null ? null : taskInfo3.taskId;
            if (str == null) {
                InspireWork currentWork2 = getCurrentWork();
                if (currentWork2 != null && (taskInfo2 = currentWork2.taskInfo) != null) {
                    r3 = taskInfo2.taskId;
                }
                str = r3;
            }
            us.pinguo.foundation.statistics.h.a.Q(element_id, str, "show", String.valueOf(currentTimeMillis));
            return;
        }
        InspireWork.TaskInfo taskInfo4 = this.taskInfo;
        String str2 = taskInfo4 == null ? null : taskInfo4.taskId;
        String str3 = (str2 == null && ((currentWork = getCurrentWork()) == null || (taskInfo = currentWork.taskInfo) == null || (str2 = taskInfo.taskId) == null)) ? "NA" : str2;
        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
        String str4 = element_id;
        InspireWork currentWork3 = getCurrentWork();
        cVar.W(str4, str3, currentWork3 != null ? currentWork3.workId : null, "show", String.valueOf(currentTimeMillis));
    }

    @Override // us.pinguo.inspire.module.comment.IFeedsInfoView
    public void workDeleteSuccess(String str, boolean z) {
        Context context = getContext();
        us.pinguo.foundation.utils.j0.d(context == null ? null : context.getString(vStudio.Android.Camera360.R.string.delete_success_res_0x7f110149));
        finish();
    }
}
