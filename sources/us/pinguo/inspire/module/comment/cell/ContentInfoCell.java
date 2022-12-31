package us.pinguo.inspire.module.comment.cell;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.dinuscxj.ellipsize.EllipsizeTextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.collection.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.open.SocialConstants;
import java.util.Objects;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.utils.f0;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.JoinStatus;
import us.pinguo.inspire.module.comment.CommentLoader;
import us.pinguo.inspire.module.comment.FeedsInfoFragment;
import us.pinguo.inspire.module.comment.IInfoView;
import us.pinguo.inspire.module.comment.cell.ContentInfoCell;
import us.pinguo.inspire.module.comment.widget.InfoBottomLayout;
import us.pinguo.inspire.module.discovery.entity.dicovery.AuthorInfo;
import us.pinguo.inspire.module.profile.FlowerLoader;
import us.pinguo.inspire.module.profile.activity.GuestProfileActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.profile.activity.ProfileActivity;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.inspire.widget.InfoAttentionButton;
import us.pinguo.inspire.widget.j.b;
import us.pinguo.librouter.module.camera.f;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.user.s0;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* compiled from: ContentInfoCell.kt */
/* loaded from: classes9.dex */
public abstract class ContentInfoCell extends BaseInfoCell implements View.OnClickListener, f.a {
    public static final Companion Companion = new Companion(null);
    private boolean buyFlowerClicked;
    private ValueAnimator hideBuyFlowerAnimator;
    private IInfoView infoView;
    private boolean showBuyFlowerRefresh;

    /* compiled from: ContentInfoCell.kt */
    /* loaded from: classes9.dex */
    public static final class BuyFlowerRefreshEvent {
        private final String cellId;
        private final boolean finish;

        public BuyFlowerRefreshEvent(boolean z, String cellId) {
            kotlin.jvm.internal.s.h(cellId, "cellId");
            this.finish = z;
            this.cellId = cellId;
        }

        public final String getCellId() {
            return this.cellId;
        }

        public final boolean getFinish() {
            return this.finish;
        }
    }

    /* compiled from: ContentInfoCell.kt */
    /* loaded from: classes9.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final void updateRanking(TextView rankingTxt, int i2, InspireWork inspireWork) {
            kotlin.jvm.internal.s.h(rankingTxt, "rankingTxt");
            if (inspireWork != null ? inspireWork.isAd : false) {
                rankingTxt.setVisibility(8);
                return;
            }
            boolean z = true;
            if (1 <= i2 && i2 < 4) {
                rankingTxt.setVisibility(0);
                rankingTxt.setText(kotlin.jvm.internal.s.q("No.", Integer.valueOf(i2)));
                rankingTxt.setBackgroundResource(R.drawable.info_ranking_1);
                return;
            }
            if ((4 > i2 || i2 >= 101) ? false : false) {
                rankingTxt.setVisibility(0);
                rankingTxt.setText(kotlin.jvm.internal.s.q("No.", Integer.valueOf(i2)));
                rankingTxt.setBackgroundResource(R.drawable.info_ranking_other);
                return;
            }
            rankingTxt.setVisibility(0);
            rankingTxt.setText(rankingTxt.getResources().getString(R.string.info_ranking_no));
            rankingTxt.setBackgroundResource(R.drawable.info_ranking_other);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentInfoCell(InspireWork data) {
        super(data);
        kotlin.jvm.internal.s.h(data, "data");
        initBuyFlowerRefreshEventListener();
    }

    private final void clickAnim(View view) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.6f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.6f, 1.0f));
        kotlin.jvm.internal.s.g(ofPropertyValuesHolder, "ofPropertyValuesHolder(v…aleXHolder, scaleYHolder)");
        ofPropertyValuesHolder.setDuration(InfoBottomLayout.Companion.getDURATION());
        ofPropertyValuesHolder.start();
    }

    private final void clickLikeAnim(final LottieAnimationView lottieAnimationView) {
        InspireWork mData = getMData();
        boolean z = false;
        if (mData != null && mData.like == 1) {
            z = true;
        }
        if (z) {
            lottieAnimationView.setAnimation("lottie/unlike/unlike.json");
            lottieAnimationView.setImageAssetsFolder("lottie/unlike");
        } else {
            lottieAnimationView.setAnimation("lottie/like/like.json");
            lottieAnimationView.setImageAssetsFolder("lottie/like");
        }
        lottieAnimationView.setProgress(0.0f);
        lottieAnimationView.d(new us.pinguo.ui.widget.j() { // from class: us.pinguo.inspire.module.comment.cell.ContentInfoCell$clickLikeAnim$listener$1
            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                InspireWork mData2;
                mData2 = ContentInfoCell.this.getMData();
                boolean z2 = false;
                if (mData2 != null && mData2.like == 1) {
                    z2 = true;
                }
                if (z2) {
                    lottieAnimationView.setAnimation("lottie/unlike/unlike.json");
                    lottieAnimationView.setImageAssetsFolder("lottie/unlike");
                } else {
                    lottieAnimationView.setAnimation("lottie/like/like.json");
                    lottieAnimationView.setImageAssetsFolder("lottie/like");
                }
                lottieAnimationView.setProgress(0.0f);
                lottieAnimationView.r(this);
            }
        });
        lottieAnimationView.p();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, android.view.View] */
    private final void hideBuyFlower() {
        if (getMViewHolder() == null) {
            return;
        }
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder);
        final View a = mViewHolder.a(R.id.info_bottom_flower_img);
        us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder2);
        final View a2 = mViewHolder2.a(R.id.info_bottom_flower_num);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        us.pinguo.inspire.y.a.c mViewHolder3 = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder3);
        ?? a3 = mViewHolder3.a(R.id.info_buy_flower_layout);
        if (a3 == 0) {
            return;
        }
        ref$ObjectRef.element = a3;
        ((View) a3).setOnClickListener(this);
        ValueAnimator valueAnimator = this.hideBuyFlowerAnimator;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hideBuyFlowerAnimator = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(400L);
        }
        final int dimensionPixelSize = ((View) ref$ObjectRef.element).getResources().getDimensionPixelSize(R.dimen.info_buy_layout_width);
        final int dimensionPixelSize2 = ((View) ref$ObjectRef.element).getResources().getDimensionPixelSize(R.dimen.info_buy_layout_height);
        a.setAlpha(0.0f);
        a2.setAlpha(0.0f);
        a.setVisibility(0);
        a2.setVisibility(0);
        ValueAnimator valueAnimator2 = this.hideBuyFlowerAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.module.comment.cell.s
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ContentInfoCell.m164hideBuyFlower$lambda2(Ref$ObjectRef.this, a, a2, dimensionPixelSize, dimensionPixelSize2, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this.hideBuyFlowerAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new us.pinguo.ui.widget.j() { // from class: us.pinguo.inspire.module.comment.cell.ContentInfoCell$hideBuyFlower$2
                @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ref$ObjectRef.element.setVisibility(8);
                }
            });
        }
        ValueAnimator valueAnimator4 = this.hideBuyFlowerAnimator;
        if (valueAnimator4 == null) {
            return;
        }
        valueAnimator4.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hideBuyFlower$lambda-2  reason: not valid java name */
    public static final void m164hideBuyFlower$lambda2(Ref$ObjectRef buyLayout, View view, View view2, int i2, int i3, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(buyLayout, "$buyLayout");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ((View) buyLayout.element).setAlpha(1 - floatValue);
        view.setAlpha(floatValue);
        view2.setAlpha(floatValue);
        ViewGroup.LayoutParams layoutParams = ((View) buyLayout.element).getLayoutParams();
        layoutParams.width = (int) (i2 + ((i3 - i2) * floatValue));
        ((View) buyLayout.element).setLayoutParams(layoutParams);
    }

    private final void hideRefreshFlower(boolean z) {
        this.showBuyFlowerRefresh = false;
        if (getMViewHolder() == null) {
            return;
        }
        if (z) {
            hideBuyFlower();
        }
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder);
        View a = mViewHolder.a(R.id.info_buy_flower_layout);
        if (a == null) {
            return;
        }
        View findViewById = a.findViewById(R.id.info_buy_flower_progress);
        View findViewById2 = a.findViewById(R.id.info_buy_flower_cover);
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
    }

    private final void initBuyFlowerRefreshEventListener() {
        us.pinguo.foundation.utils.h.a(us.pinguo.foundation.r.d.a().c(BuyFlowerRefreshEvent.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.cell.q
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ContentInfoCell.m165initBuyFlowerRefreshEventListener$lambda8(ContentInfoCell.this, (ContentInfoCell.BuyFlowerRefreshEvent) obj);
            }
        }, u.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initBuyFlowerRefreshEventListener$lambda-8  reason: not valid java name */
    public static final void m165initBuyFlowerRefreshEventListener$lambda8(ContentInfoCell this$0, BuyFlowerRefreshEvent buyFlowerRefreshEvent) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (kotlin.jvm.internal.s.c(buyFlowerRefreshEvent.getCellId(), this$0.toString())) {
            return;
        }
        if (buyFlowerRefreshEvent.getFinish()) {
            this$0.buyFlowerClicked = false;
            this$0.hideRefreshFlower(true);
            return;
        }
        this$0.buyFlowerClicked = true;
        this$0.showRefreshFlower(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: paySuccess$lambda-5  reason: not valid java name */
    public static final Integer m167paySuccess$lambda5(Integer it) {
        us.pinguo.common.log.a.s(kotlin.jvm.internal.s.q("延迟之后鲜花数:", it), new Object[0]);
        kotlin.jvm.internal.s.g(it, "it");
        if (it.intValue() > 0) {
            return it;
        }
        throw new RuntimeException("返回鲜花数为0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: paySuccess$lambda-6  reason: not valid java name */
    public static final void m168paySuccess$lambda6(ContentInfoCell this$0, Integer s) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.buyFlowerClicked = false;
        kotlin.jvm.internal.s.g(s, "s");
        this$0.updateFlower(s.intValue());
        this$0.hideRefreshFlower(true);
        us.pinguo.foundation.r.d.a().b(new BuyFlowerRefreshEvent(true, this$0.toString()));
        us.pinguo.common.log.a.s("获取更新之后的鲜花数成功", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: paySuccess$lambda-7  reason: not valid java name */
    public static final void m169paySuccess$lambda7(ContentInfoCell this$0, Throwable th) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.buyFlowerClicked = false;
        this$0.hideRefreshFlower(true);
        us.pinguo.common.log.a.s("获取更新之后的鲜花数失败", new Object[0]);
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.r.d.a().b(new BuyFlowerRefreshEvent(true, this$0.toString()));
    }

    /* JADX WARN: Type inference failed for: r2v18, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, android.view.View] */
    private final void showBuyFlower(boolean z) {
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder);
        final View a = mViewHolder.a(R.id.info_bottom_flower_img);
        us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder2);
        final View a2 = mViewHolder2.a(R.id.info_bottom_flower_num);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        us.pinguo.inspire.y.a.c mViewHolder3 = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder3);
        ?? a3 = mViewHolder3.a(R.id.info_buy_flower_layout);
        ref$ObjectRef.element = a3;
        if (a3 == 0) {
            us.pinguo.inspire.y.a.c mViewHolder4 = getMViewHolder();
            kotlin.jvm.internal.s.e(mViewHolder4);
            ViewStub viewStub = (ViewStub) mViewHolder4.a(R.id.info_buy_flower_stub);
            kotlin.jvm.internal.s.e(viewStub);
            ref$ObjectRef.element = viewStub.inflate();
        }
        ((TextView) ((View) ref$ObjectRef.element).findViewById(R.id.info_buy_flower_price)).setText(FlowerLoader.INSTANCE.getGiftResp().getPrice());
        ((View) ref$ObjectRef.element).setOnClickListener(this);
        if (!z) {
            ((View) ref$ObjectRef.element).setAlpha(1.0f);
            ((View) ref$ObjectRef.element).setVisibility(0);
            int dimensionPixelSize = ((View) ref$ObjectRef.element).getResources().getDimensionPixelSize(R.dimen.info_buy_layout_width);
            ViewGroup.LayoutParams layoutParams = ((View) ref$ObjectRef.element).getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            ((View) ref$ObjectRef.element).setLayoutParams(layoutParams);
            a2.setVisibility(8);
            a.setVisibility(8);
            return;
        }
        ((View) ref$ObjectRef.element).setAlpha(0.0f);
        ((View) ref$ObjectRef.element).setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ViewGroup.LayoutParams layoutParams2 = ((View) ref$ObjectRef.element).getLayoutParams();
        final int dimensionPixelSize2 = ((View) ref$ObjectRef.element).getResources().getDimensionPixelSize(R.dimen.info_buy_layout_height);
        if (layoutParams2 != null) {
            layoutParams2.width = dimensionPixelSize2;
        }
        View view = (View) ref$ObjectRef.element;
        if (view != null) {
            view.setLayoutParams(layoutParams2);
        }
        final int dimensionPixelSize3 = ((View) ref$ObjectRef.element).getResources().getDimensionPixelSize(R.dimen.info_buy_layout_width);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.module.comment.cell.t
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ContentInfoCell.m170showBuyFlower$lambda1(Ref$ObjectRef.this, a, a2, dimensionPixelSize2, dimensionPixelSize3, valueAnimator);
            }
        });
        ofFloat.addListener(new us.pinguo.ui.widget.j() { // from class: us.pinguo.inspire.module.comment.cell.ContentInfoCell$showBuyFlower$2
            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a2.setVisibility(8);
                a.setVisibility(8);
                a.setAlpha(1.0f);
                a2.setAlpha(1.0f);
            }
        });
        ofFloat.start();
    }

    static /* synthetic */ void showBuyFlower$default(ContentInfoCell contentInfoCell, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBuyFlower");
        }
        if ((i2 & 1) != 0) {
            z = true;
        }
        contentInfoCell.showBuyFlower(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showBuyFlower$lambda-1  reason: not valid java name */
    public static final void m170showBuyFlower$lambda1(Ref$ObjectRef buyLayout, View view, View view2, int i2, int i3, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(buyLayout, "$buyLayout");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ((View) buyLayout.element).setAlpha(floatValue);
        float f2 = 1 - floatValue;
        view.setAlpha(f2);
        view2.setAlpha(f2);
        ViewGroup.LayoutParams layoutParams = ((View) buyLayout.element).getLayoutParams();
        layoutParams.width = (int) (i2 + ((i3 - i2) * floatValue));
        ((View) buyLayout.element).setLayoutParams(layoutParams);
    }

    private final void showFlower() {
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        if (mViewHolder != null) {
            mViewHolder.e(R.id.info_bottom_flower_img, 0);
        }
        us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
        if (mViewHolder2 != null) {
            mViewHolder2.e(R.id.info_bottom_flower_num, 0);
        }
        us.pinguo.inspire.y.a.c mViewHolder3 = getMViewHolder();
        View a = mViewHolder3 == null ? null : mViewHolder3.a(R.id.info_buy_flower_layout);
        if (a != null) {
            a.setVisibility(8);
        }
        us.pinguo.inspire.y.a.c mViewHolder4 = getMViewHolder();
        View a2 = mViewHolder4 == null ? null : mViewHolder4.a(R.id.info_send_flower_img);
        if (a2 != null) {
            a2.setVisibility(8);
        }
        InspireWork.TaskInfo taskInfo = getMData().taskInfo;
        if (TextUtils.isEmpty(taskInfo == null ? null : taskInfo.flowerIcon)) {
            return;
        }
        us.pinguo.inspire.y.a.c mViewHolder5 = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder5);
        View a3 = mViewHolder5.a(R.id.info_bottom_flower_img);
        kotlin.jvm.internal.s.g(a3, "mViewHolder!!.getView(R.id.info_bottom_flower_img)");
        ImageView imageView = (ImageView) a3;
        ImageLoader imageLoader = ImageLoader.getInstance();
        InspireWork.TaskInfo taskInfo2 = getMData().taskInfo;
        imageLoader.e(taskInfo2 != null ? taskInfo2.flowerIcon : null, imageView);
    }

    private final void showRefreshFlower(boolean z, boolean z2) {
        this.showBuyFlowerRefresh = true;
        if (getMViewHolder() == null) {
            return;
        }
        if (z) {
            showBuyFlower(z2);
        }
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder);
        View a = mViewHolder.a(R.id.info_buy_flower_layout);
        if (a == null) {
            us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
            kotlin.jvm.internal.s.e(mViewHolder2);
            ViewStub viewStub = (ViewStub) mViewHolder2.a(R.id.info_buy_flower_stub);
            kotlin.jvm.internal.s.e(viewStub);
            a = viewStub.inflate();
        }
        View findViewById = a.findViewById(R.id.info_buy_flower_progress);
        View findViewById2 = a.findViewById(R.id.info_buy_flower_cover);
        findViewById.setVisibility(0);
        findViewById2.setVisibility(0);
    }

    static /* synthetic */ void showRefreshFlower$default(ContentInfoCell contentInfoCell, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showRefreshFlower");
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        contentInfoCell.showRefreshFlower(z, z2);
    }

    private final void showSendFlowerAnim() {
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        LottieAnimationView lottieAnimationView = mViewHolder == null ? null : (LottieAnimationView) mViewHolder.a(R.id.info_send_flower_img);
        if (lottieAnimationView == null) {
            us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
            ViewStub viewStub = mViewHolder2 == null ? null : (ViewStub) mViewHolder2.a(R.id.info_send_flower_stub);
            lottieAnimationView = (LottieAnimationView) (viewStub != null ? viewStub.inflate() : null);
        }
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
        }
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateAttentionButton$lambda-3  reason: not valid java name */
    public static final void m171updateAttentionButton$lambda3(InspireWork work, View view) {
        kotlin.jvm.internal.s.h(work, "$work");
        us.pinguo.foundation.statistics.h.a.M(FeedsInfoFragment.Companion.getElement_id(), "follow", "", work.workId, "click");
    }

    private final void updateAuthorInfo(InspireWork inspireWork) {
        updateAvatar(inspireWork);
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        if (mViewHolder != null) {
            String str = inspireWork.authorName;
            if (str == null) {
                AuthorInfo authorInfo = inspireWork.authorInfo;
                str = authorInfo == null ? null : authorInfo.nickname;
            }
            mViewHolder.d(R.id.info_name, str);
        }
        updateAttentionButton(null, inspireWork);
        updateChallengeName();
        updateWorkTag(inspireWork);
    }

    private final void updateAvatar(final InspireWork inspireWork) {
        AuthorInfo authorInfo;
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        PortraitImageView portraitImageView = mViewHolder == null ? null : (PortraitImageView) mViewHolder.a(R.id.info_avatar);
        String str = inspireWork.authorAvatar;
        if (str == null) {
            AuthorInfo authorInfo2 = inspireWork.authorInfo;
            str = authorInfo2 == null ? null : authorInfo2.avatar;
        }
        if (portraitImageView != null) {
            portraitImageView.setImageUri(str, us.pinguo.ui.R.drawable.default_avatar);
        }
        if (portraitImageView != null) {
            String str2 = inspireWork.authorId;
            if (str2 == null) {
                str2 = (inspireWork == null || (authorInfo = inspireWork.authorInfo) == null) ? null : authorInfo.userId;
            }
            portraitImageView.setUserId(str2);
        }
        if (portraitImageView != null) {
            portraitImageView.setTag(str);
        }
        if (portraitImageView != null) {
            portraitImageView.setBeforeOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContentInfoCell.m172updateAvatar$lambda4(InspireWork.this, view);
                }
            });
        }
        us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
        PhotoImageView photoImageView = mViewHolder2 == null ? null : (PhotoImageView) mViewHolder2.a(R.id.info_avatar_flag);
        AuthorInfo authorInfo3 = inspireWork.authorInfo;
        if (!TextUtils.isEmpty(authorInfo3 == null ? null : authorInfo3.nationalFlag)) {
            if (inspireWork.isAd) {
                if (photoImageView == null) {
                    return;
                }
                AuthorInfo authorInfo4 = inspireWork.authorInfo;
                photoImageView.setImageUri(authorInfo4 != null ? authorInfo4.nationalFlag : null, R.drawable.ic_default_advertise);
            } else if (photoImageView == null) {
            } else {
                AuthorInfo authorInfo5 = inspireWork.authorInfo;
                photoImageView.setImageUri(authorInfo5 != null ? authorInfo5.nationalFlag : null);
            }
        } else if (!TextUtils.isEmpty(inspireWork.nationalFlag)) {
            if (inspireWork.isAd) {
                if (photoImageView == null) {
                    return;
                }
                photoImageView.setImageUri(inspireWork.nationalFlag, R.drawable.ic_default_advertise);
            } else if (photoImageView == null) {
            } else {
                photoImageView.setImageUri(inspireWork.nationalFlag);
            }
        } else if (inspireWork.isAd) {
            if (photoImageView == null) {
                return;
            }
            photoImageView.setImageByResouceId(R.drawable.ic_default_advertise);
        } else if (photoImageView == null) {
        } else {
            photoImageView.setImageByResouceId(R.drawable.info_empty_map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateAvatar$lambda-4  reason: not valid java name */
    public static final void m172updateAvatar$lambda4(InspireWork work, View view) {
        kotlin.jvm.internal.s.h(work, "$work");
        us.pinguo.foundation.statistics.h.a.M(FeedsInfoFragment.Companion.getElement_id(), "head", "", work.workId, "click");
    }

    private final void updateCameraBtn() {
        AppCompatImageView appCompatImageView;
        if (us.pinguo.librouter.c.d.b().getInterface().k() && !getMData().isAd) {
            if (getMData().taskInfo == null) {
                us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
                if (mViewHolder != null) {
                    mViewHolder.e(R.id.info_bottom_camera_img, 4);
                }
                us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
                if (mViewHolder2 == null) {
                    return;
                }
                mViewHolder2.e(R.id.info_bottom_camera_num, 4);
                return;
            }
            if (getMData().taskInfo.taskType == 5) {
                us.pinguo.inspire.y.a.c mViewHolder3 = getMViewHolder();
                if (mViewHolder3 != null) {
                    mViewHolder3.e(R.id.info_bottom_camera_img, 0);
                }
                us.pinguo.inspire.y.a.c mViewHolder4 = getMViewHolder();
                if (mViewHolder4 != null) {
                    mViewHolder4.e(R.id.info_bottom_camera_num, 0);
                }
                us.pinguo.inspire.y.a.c mViewHolder5 = getMViewHolder();
                appCompatImageView = mViewHolder5 != null ? (AppCompatImageView) mViewHolder5.a(R.id.info_bottom_camera_img) : null;
                if (appCompatImageView != null) {
                    appCompatImageView.setImageResource(R.drawable.info_photo_movie);
                }
                us.pinguo.inspire.y.a.c mViewHolder6 = getMViewHolder();
                if (mViewHolder6 == null) {
                    return;
                }
                mViewHolder6.c(R.id.info_bottom_camera_num, R.string.photo_movie_upload);
                return;
            }
            us.pinguo.inspire.y.a.c mViewHolder7 = getMViewHolder();
            if (mViewHolder7 != null) {
                mViewHolder7.e(R.id.info_bottom_camera_img, 0);
            }
            us.pinguo.inspire.y.a.c mViewHolder8 = getMViewHolder();
            if (mViewHolder8 != null) {
                mViewHolder8.e(R.id.info_bottom_camera_num, 0);
            }
            us.pinguo.inspire.y.a.c mViewHolder9 = getMViewHolder();
            appCompatImageView = mViewHolder9 != null ? (AppCompatImageView) mViewHolder9.a(R.id.info_bottom_camera_img) : null;
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(R.drawable.icon_vedio_play);
            }
            us.pinguo.inspire.y.a.c mViewHolder10 = getMViewHolder();
            if (mViewHolder10 == null) {
                return;
            }
            mViewHolder10.c(R.id.info_bottom_camera_num, R.string.info_camera);
            return;
        }
        us.pinguo.inspire.y.a.c mViewHolder11 = getMViewHolder();
        if (mViewHolder11 != null) {
            mViewHolder11.e(R.id.info_bottom_camera_img, 4);
        }
        us.pinguo.inspire.y.a.c mViewHolder12 = getMViewHolder();
        if (mViewHolder12 == null) {
            return;
        }
        mViewHolder12.e(R.id.info_bottom_camera_num, 4);
    }

    private final void updateChallengeName() {
        String sb;
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        TextView textView = mViewHolder == null ? null : (TextView) mViewHolder.a(R.id.info_see_details);
        us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
        TextView textView2 = mViewHolder2 == null ? null : (TextView) mViewHolder2.a(R.id.info_challenge_name);
        if (getMData().isAd) {
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (getMData().taskInfo.influencer != null && !TextUtils.isEmpty(getMData().taskInfo.influencer.getInfluencerText())) {
                if (textView != null) {
                    textView.setVisibility(0);
                }
                if (textView != null) {
                    textView.setText(getMData().taskInfo.influencer.getInfluencerText());
                }
            } else if (textView != null) {
                textView.setVisibility(8);
            }
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            String element_id = FeedsInfoFragment.Companion.getElement_id();
            InspireWork mData = getMData();
            cVar.M(element_id, "", "is_ad", mData == null ? null : mData.workId, "show");
        } else {
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (textView2 != null) {
                InspireWork.TaskInfo taskInfo = getMData().taskInfo;
                if (TextUtils.isEmpty(taskInfo == null ? null : taskInfo.taskName)) {
                    sb = "";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Constants.ID_PREFIX);
                    InspireWork.TaskInfo taskInfo2 = getMData().taskInfo;
                    sb2.append((Object) (taskInfo2 == null ? null : taskInfo2.taskName));
                    sb2.append(Constants.ID_PREFIX);
                    sb = sb2.toString();
                }
                textView2.setText(sb);
            }
            if (textView2 != null) {
                textView2.setSelected(true);
            }
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
        us.pinguo.inspire.y.a.c mViewHolder3 = getMViewHolder();
        TextView textView3 = mViewHolder3 != null ? (TextView) mViewHolder3.a(R.id.info_name) : null;
        if (textView3 != null) {
            ViewGroup.LayoutParams layoutParams = textView3.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (getMData().isAd) {
                layoutParams2.bottomToBottom = R.id.info_avatar;
            } else {
                layoutParams2.bottomToBottom = -1;
            }
            textView3.setLayoutParams(layoutParams2);
        }
    }

    private final void updateContent() {
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        EllipsizeTextView ellipsizeTextView = mViewHolder == null ? null : (EllipsizeTextView) mViewHolder.a(R.id.info_bottom_content);
        InspireWork mData = getMData();
        if (TextUtils.isEmpty(mData == null ? null : mData.desc)) {
            if (ellipsizeTextView == null) {
                return;
            }
            ellipsizeTextView.setVisibility(8);
            return;
        }
        if (ellipsizeTextView != null) {
            ellipsizeTextView.setClickable(true);
        }
        if (ellipsizeTextView != null) {
            ellipsizeTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        InspireWork mData2 = getMData();
        us.pinguo.inspire.widget.j.b.f(ellipsizeTextView, mData2 != null ? mData2.desc : null, o.a);
        if (ellipsizeTextView == null) {
            return;
        }
        ellipsizeTextView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateContent$lambda-0  reason: not valid java name */
    public static final void m173updateContent$lambda0(View view, us.pinguo.inspire.widget.j.b bVar, b.C0407b c0407b) {
        Intent intent = new Intent();
        if (f0.b(s0.getInstance().getUserId(), c0407b.a)) {
            intent.setClass(view.getContext(), ProfileActivity.class);
        } else {
            intent.setClass(view.getContext(), GuestProfileActivity.class);
            intent.putExtra(GuestProfileFragment.USER_ID, c0407b.a);
        }
        view.getContext().startActivity(intent);
    }

    private final void updateWorkTag(InspireWork inspireWork) {
        View view;
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        TextView textView = mViewHolder == null ? null : (TextView) mViewHolder.a(R.id.info_tag);
        us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
        Resources resources = (mViewHolder2 == null || (view = mViewHolder2.b) == null) ? null : view.getResources();
        if (inspireWork != null && inspireWork.isDemo) {
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView == null) {
                return;
            }
            textView.setText(resources != null ? resources.getString(R.string.challenge_official) : null);
            return;
        }
        if (inspireWork != null && inspireWork.isKingWork()) {
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView == null) {
                return;
            }
            textView.setText(resources != null ? resources.getString(R.string.challenge_king) : null);
            return;
        }
        if (!(inspireWork != null && inspireWork.isSWork())) {
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (textView == null) {
            return;
        }
        textView.setText(resources != null ? resources.getString(R.string.challenge_tag_s) : null);
    }

    public final void fakeFlowerAnim() {
        if (getMViewHolder() == null) {
            return;
        }
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder);
        ImageView flowerImg = (ImageView) mViewHolder.a(R.id.info_bottom_flower_img);
        kotlin.jvm.internal.s.g(flowerImg, "flowerImg");
        clickAnim(flowerImg);
        showSendFlowerAnim();
    }

    public final ValueAnimator getHideBuyFlowerAnimator() {
        return this.hideBuyFlowerAnimator;
    }

    public final IInfoView getInfoView() {
        return this.infoView;
    }

    public final boolean onBackPressed() {
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        View a = mViewHolder == null ? null : mViewHolder.a(R.id.info_buy_flower_layout);
        if (a != null && a.getVisibility() == 0) {
            hideBuyFlower();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.module.comment.cell.BaseInfoCell, us.pinguo.inspire.y.a.b
    public void onBindViewHolder(us.pinguo.inspire.y.a.c viewHolder) {
        int intValue;
        kotlin.jvm.internal.s.h(viewHolder, "viewHolder");
        super.onBindViewHolder(viewHolder);
        updateLike(getMData());
        updateCommentNum(getMData());
        updateContent();
        updateShopping();
        Companion companion = Companion;
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder);
        View a = mViewHolder.a(R.id.info_ranking_txt);
        kotlin.jvm.internal.s.g(a, "mViewHolder!!.getView(R.id.info_ranking_txt)");
        TextView textView = (TextView) a;
        AuthorInfo authorInfo = getMData().authorInfo;
        Integer valueOf = authorInfo == null ? null : Integer.valueOf(authorInfo.ranking);
        if (valueOf == null) {
            intValue = getMData().authorRanking;
        } else {
            intValue = valueOf.intValue();
        }
        companion.updateRanking(textView, intValue, getMData());
        updateAuthorInfo(getMData());
        updateCameraBtn();
        updateFlower(s0.getInstance().e() ? FlowerLoader.INSTANCE.getFlowerNum() : FlowerLoader.INSTANCE.getFLOWER_NUM_UNLOGIN());
        showFlower();
        if (this.showBuyFlowerRefresh) {
            showRefreshFlower$default(this, true, false, 2, null);
        } else {
            hideRefreshFlower(true);
        }
        viewHolder.b(R.id.info_avatar, this);
        viewHolder.b(R.id.info_bottom_camera_img, this);
        viewHolder.b(R.id.info_bottom_like_img, this);
        viewHolder.b(R.id.info_bottom_like_num, this);
        viewHolder.b(R.id.info_bottom_comment_img, this);
        viewHolder.b(R.id.info_bottom_comment_num, this);
        viewHolder.b(R.id.info_bottom_flower_num, this);
        viewHolder.b(R.id.info_bottom_flower_img, this);
        viewHolder.b(R.id.info_challenge_name, this);
        viewHolder.b(R.id.info_name, this);
        viewHolder.b(R.id.info_bottom_content, this);
        viewHolder.b(R.id.info_ranking_txt, this);
        viewHolder.b(R.id.info_shopping_cart_icon, this);
        viewHolder.b(R.id.info_shopping_cart_text, this);
        viewHolder.b(R.id.info_see_details, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        JoinStatus joinStatus;
        kotlin.jvm.internal.s.h(v, "v");
        if (us.pinguo.foundation.utils.j.a(600L)) {
            return;
        }
        boolean z = false;
        String str = null;
        switch (v.getId()) {
            case R.id.info_avatar /* 2097545455 */:
                if (getMData().isAd) {
                    us.pinguo.foundation.interaction.c c = AppGoto.getInstance().c(getMData().taskInfo.influencer.getInfluencerLink());
                    c.c("force_inner_browser", true);
                    c.b(v.getContext());
                    us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                    String element_id = FeedsInfoFragment.Companion.getElement_id();
                    InspireWork mData = getMData();
                    cVar.M(element_id, "head", "is_ad", mData != null ? mData.workId : null, "click");
                    return;
                }
                us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
                PortraitImageView portraitImageView = mViewHolder != null ? (PortraitImageView) mViewHolder.a(R.id.info_avatar) : 0;
                if (portraitImageView == null) {
                    return;
                }
                portraitImageView.onClick(portraitImageView);
                return;
            case R.id.info_bottom_camera_img /* 2097545457 */:
                clickAnim(v);
                if (getMData().isTaskFinished()) {
                    j0.d(v.getContext().getResources().getString(R.string.task_finished));
                } else {
                    InspireWork.TaskInfo taskInfo = getMData().taskInfo;
                    if (((taskInfo == null || (joinStatus = taskInfo.isJoin) == null) ? 1 : joinStatus.status) == 0) {
                        String str2 = getMData().taskInfo.isJoin.message;
                        if (str2 == null) {
                            str2 = "";
                        }
                        j0.d(str2);
                    } else {
                        IInfoView iInfoView = this.infoView;
                        if (iInfoView != null) {
                            iInfoView.onCameraClick(getMData());
                        }
                    }
                }
                us.pinguo.foundation.statistics.c cVar2 = us.pinguo.foundation.statistics.h.a;
                String element_id2 = FeedsInfoFragment.Companion.getElement_id();
                InspireWork.TaskInfo taskInfo2 = getMData().taskInfo;
                if (taskInfo2 != null && taskInfo2.taskType == 5) {
                    z = true;
                }
                String str3 = z ? "upload" : "shoot";
                InspireWork mData2 = getMData();
                cVar2.M(element_id2, str3, "", mData2 != null ? mData2.workId : null, "click");
                return;
            case R.id.info_bottom_comment_img /* 2097545460 */:
            case R.id.info_bottom_comment_num /* 2097545461 */:
                us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
                kotlin.jvm.internal.s.e(mViewHolder2);
                View a = mViewHolder2.a(R.id.info_bottom_comment_img);
                kotlin.jvm.internal.s.g(a, "mViewHolder!!.getView(R.….info_bottom_comment_img)");
                clickAnim(a);
                IInfoView iInfoView2 = this.infoView;
                if (iInfoView2 == null) {
                    return;
                }
                iInfoView2.onCommentClick();
                return;
            case R.id.info_bottom_content /* 2097545462 */:
                if (getMData().isAd) {
                    us.pinguo.foundation.interaction.c c2 = AppGoto.getInstance().c(getMData().taskInfo.influencer.getInfluencerLink());
                    c2.c("force_inner_browser", true);
                    c2.b(v.getContext());
                    us.pinguo.foundation.statistics.c cVar3 = us.pinguo.foundation.statistics.h.a;
                    String element_id3 = FeedsInfoFragment.Companion.getElement_id();
                    InspireWork mData3 = getMData();
                    cVar3.M(element_id3, SocialConstants.PARAM_COMMENT, "", mData3 != null ? mData3.workId : null, "click");
                    return;
                }
                return;
            case R.id.info_bottom_flower_img /* 2097545463 */:
            case R.id.info_bottom_flower_num /* 2097545464 */:
                us.pinguo.inspire.y.a.c mViewHolder3 = getMViewHolder();
                kotlin.jvm.internal.s.e(mViewHolder3);
                View a2 = mViewHolder3.a(R.id.info_bottom_flower_img);
                kotlin.jvm.internal.s.g(a2, "mViewHolder!!.getView(R.id.info_bottom_flower_img)");
                clickAnim(a2);
                us.pinguo.foundation.statistics.c cVar4 = us.pinguo.foundation.statistics.h.a;
                FeedsInfoFragment.Companion companion = FeedsInfoFragment.Companion;
                String element_id4 = companion.getElement_id();
                InspireWork mData4 = getMData();
                cVar4.M(element_id4, "flower", "", mData4 == null ? null : mData4.workId, "click");
                if (!s0.getInstance().e()) {
                    s0.getInstance().a(ActivityRecorder.getInstance().d(), 222, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
                    return;
                } else if (!us.pinguo.util.q.f(v.getContext())) {
                    j0.c(us.pinguo.c360.i18n.R.string.network_error);
                    return;
                } else if (FlowerLoader.INSTANCE.getFlowerNum() <= 0) {
                    showBuyFlower$default(this, false, 1, null);
                    String element_id5 = companion.getElement_id();
                    InspireWork mData5 = getMData();
                    cVar4.M(element_id5, "popup_pay", "", mData5 != null ? mData5.workId : null, "click");
                    return;
                } else {
                    IInfoView iInfoView3 = this.infoView;
                    if (iInfoView3 != null) {
                        iInfoView3.onFlowerClick();
                    }
                    showSendFlowerAnim();
                    return;
                }
            case R.id.info_bottom_like_img /* 2097545466 */:
            case R.id.info_bottom_like_num /* 2097545467 */:
                if (s0.getInstance().e() || !CommentLoader.isLoginRequired()) {
                    us.pinguo.inspire.y.a.c mViewHolder4 = getMViewHolder();
                    kotlin.jvm.internal.s.e(mViewHolder4);
                    View a3 = mViewHolder4.a(R.id.info_bottom_like_img);
                    kotlin.jvm.internal.s.g(a3, "mViewHolder!!.getView(R.id.info_bottom_like_img)");
                    clickLikeAnim((LottieAnimationView) a3);
                }
                IInfoView iInfoView4 = this.infoView;
                if (iInfoView4 == null) {
                    return;
                }
                iInfoView4.onLikeClick();
                return;
            case R.id.info_buy_flower_layout /* 2097545469 */:
                if (this.buyFlowerClicked) {
                    return;
                }
                this.buyFlowerClicked = true;
                us.pinguo.librouter.c.d.b().getPayInterface().f(ActivityRecorder.getInstance().d(), this);
                us.pinguo.foundation.statistics.h.a.B0("flowers_pay", "click");
                return;
            case R.id.info_challenge_name /* 2097545475 */:
                IInfoView iInfoView5 = this.infoView;
                if (iInfoView5 == null) {
                    return;
                }
                iInfoView5.onChallengeClick();
                return;
            case R.id.info_name /* 2097545492 */:
                if (getMData().isAd) {
                    us.pinguo.foundation.interaction.c c3 = AppGoto.getInstance().c(getMData().taskInfo.influencer.getInfluencerLink());
                    c3.c("force_inner_browser", true);
                    c3.b(v.getContext());
                    us.pinguo.foundation.statistics.h.a.B0("challenge_task_list_t_shopping_entrence", "click");
                    return;
                }
                AuthorInfo authorInfo = getMData().authorInfo;
                if ((authorInfo == null ? null : authorInfo.userId) == null) {
                    str = getMData().authorId;
                } else {
                    AuthorInfo authorInfo2 = getMData().authorInfo;
                    if (authorInfo2 != null) {
                        str = authorInfo2.userId;
                    }
                }
                PortraitImageView.f(ActivityRecorder.getInstance().d(), str);
                return;
            case R.id.info_ranking_txt /* 2097545495 */:
                AppGoto appGoto = AppGoto.getInstance();
                us.pinguo.foundation.interaction.c c4 = appGoto.c(Inspire.f11205f + "/challengeRank/index.html?time=" + System.currentTimeMillis());
                c4.c("force_inner_browser", true);
                c4.b(v.getContext());
                us.pinguo.foundation.statistics.h.a.B0("challenge_task_list_t_rank_entrence", "click");
                return;
            case R.id.info_see_details /* 2097545499 */:
                us.pinguo.foundation.interaction.c c5 = AppGoto.getInstance().c(getMData().taskInfo.influencer.getInfluencerLink());
                c5.c("force_inner_browser", true);
                c5.b(v.getContext());
                us.pinguo.foundation.statistics.c cVar5 = us.pinguo.foundation.statistics.h.a;
                String element_id6 = FeedsInfoFragment.Companion.getElement_id();
                InspireWork mData6 = getMData();
                cVar5.M(element_id6, "view_btn", "is_ad", mData6 != null ? mData6.workId : null, "click");
                return;
            case R.id.info_shopping_cart_icon /* 2097545502 */:
                us.pinguo.foundation.interaction.c c6 = AppGoto.getInstance().c(getMData().taskInfo.influencer.getInfluencerLink());
                c6.c("force_inner_browser", true);
                c6.b(v.getContext());
                us.pinguo.foundation.statistics.c cVar6 = us.pinguo.foundation.statistics.h.a;
                String element_id7 = FeedsInfoFragment.Companion.getElement_id();
                InspireWork mData7 = getMData();
                cVar6.M(element_id7, "purchase_icon", "", mData7 != null ? mData7.workId : null, "click");
                return;
            case R.id.info_shopping_cart_text /* 2097545503 */:
                us.pinguo.foundation.interaction.c c7 = AppGoto.getInstance().c(getMData().taskInfo.influencer.getInfluencerLink());
                c7.c("force_inner_browser", true);
                c7.b(v.getContext());
                us.pinguo.foundation.statistics.c cVar7 = us.pinguo.foundation.statistics.h.a;
                String element_id8 = FeedsInfoFragment.Companion.getElement_id();
                InspireWork mData8 = getMData();
                cVar7.M(element_id8, "purchase_description", "", mData8 != null ? mData8.workId : null, "click");
                return;
            default:
                return;
        }
    }

    public final void onShareClick() {
        IInfoView iInfoView = this.infoView;
        if (iInfoView == null) {
            return;
        }
        iInfoView.onShareClick();
    }

    @Override // us.pinguo.librouter.module.camera.f.a
    public void payCancel() {
        this.buyFlowerClicked = false;
        hideBuyFlower();
        us.pinguo.foundation.statistics.h.a.q("cancelled", "");
    }

    @Override // us.pinguo.librouter.module.camera.f.a
    public void payFail(String message) {
        kotlin.jvm.internal.s.h(message, "message");
        this.buyFlowerClicked = false;
        hideBuyFlower();
        j0.d(us.pinguo.librouter.c.d.b().getPayInterface().c());
        us.pinguo.foundation.statistics.h.a.q("failure", message);
    }

    @Override // us.pinguo.librouter.module.camera.f.a
    public void paySuccess() {
        us.pinguo.foundation.r.d.a().b(new BuyFlowerRefreshEvent(false, toString()));
        showRefreshFlower(true, false);
        addSubscription(FlowerLoader.INSTANCE.refreshFlowerCount().map(l.a).retryWhen(new us.pinguo.foundation.utils.download.e(15, 500)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.cell.n
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ContentInfoCell.m168paySuccess$lambda6(ContentInfoCell.this, (Integer) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.comment.cell.r
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ContentInfoCell.m169paySuccess$lambda7(ContentInfoCell.this, (Throwable) obj);
            }
        }));
        us.pinguo.foundation.statistics.h.a.q(FirebaseAnalytics.Param.SUCCESS, "");
    }

    public final void setHideBuyFlowerAnimator(ValueAnimator valueAnimator) {
        this.hideBuyFlowerAnimator = valueAnimator;
    }

    public final void setInfoView(IInfoView iInfoView) {
        this.infoView = iInfoView;
    }

    public final void updadeWorkFromNet(InspireWork work) {
        int intValue;
        kotlin.jvm.internal.s.h(work, "work");
        setMData(work);
        if (getMViewHolder() != null) {
            Companion companion = Companion;
            us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
            kotlin.jvm.internal.s.e(mViewHolder);
            View a = mViewHolder.a(R.id.info_ranking_txt);
            kotlin.jvm.internal.s.g(a, "mViewHolder!!.getView<Te…w>(R.id.info_ranking_txt)");
            TextView textView = (TextView) a;
            AuthorInfo authorInfo = getMData().authorInfo;
            Integer valueOf = authorInfo == null ? null : Integer.valueOf(authorInfo.ranking);
            if (valueOf == null) {
                intValue = getMData().authorRanking;
            } else {
                intValue = valueOf.intValue();
            }
            companion.updateRanking(textView, intValue, getMData());
            updateCameraBtn();
            updateCommentNum(getMData());
        }
    }

    public final void updateAttentionButton(AttentionButton.k kVar, final InspireWork work) {
        kotlin.jvm.internal.s.h(work, "work");
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        InfoAttentionButton infoAttentionButton = mViewHolder == null ? null : (InfoAttentionButton) mViewHolder.a(R.id.info_follow);
        if (getMData().isAd) {
            if (infoAttentionButton == null) {
                return;
            }
            infoAttentionButton.setVisibility(8);
            return;
        }
        if (kotlin.jvm.internal.s.c(kVar == null ? null : kVar.b, Integer.toHexString(System.identityHashCode(infoAttentionButton)))) {
            return;
        }
        if (infoAttentionButton != null) {
            AuthorInfo authorInfo = work.authorInfo;
            String str = authorInfo != null ? authorInfo.userId : null;
            if (str == null) {
                str = work.authorId;
            }
            infoAttentionButton.v(work, str, this);
        }
        if (infoAttentionButton != null) {
            infoAttentionButton.setBeforeOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContentInfoCell.m171updateAttentionButton$lambda3(InspireWork.this, view);
                }
            });
        }
        if (infoAttentionButton == null) {
            return;
        }
        infoAttentionButton.setVisibility(0);
    }

    public final void updateCommentNum(InspireWork inspireWork) {
        View view;
        Resources resources;
        int i2 = inspireWork == null ? 0 : inspireWork.commentSum;
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        if (mViewHolder == null) {
            return;
        }
        String str = null;
        if (i2 == 0) {
            us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
            if (mViewHolder2 != null && (view = mViewHolder2.b) != null && (resources = view.getResources()) != null) {
                str = resources.getString(R.string.msg_comment);
            }
        } else {
            str = InspireWork.formatNum(i2);
        }
        mViewHolder.d(R.id.info_bottom_comment_num, str);
    }

    public final void updateFlower(int i2) {
        if (getMViewHolder() == null) {
            return;
        }
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder);
        View a = mViewHolder.a(R.id.info_buy_flower_layout);
        if (a == null || a.getVisibility() == 8 || a.getAlpha() < 1.0f) {
            us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
            if (mViewHolder2 != null) {
                mViewHolder2.e(R.id.info_bottom_flower_img, 0);
            }
            us.pinguo.inspire.y.a.c mViewHolder3 = getMViewHolder();
            if (mViewHolder3 != null) {
                mViewHolder3.e(R.id.info_bottom_flower_num, 0);
            }
        }
        us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("updateFlower:", Integer.valueOf(i2)), new Object[0]);
        us.pinguo.inspire.y.a.c mViewHolder4 = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder4);
        AppCompatTextView appCompatTextView = (AppCompatTextView) mViewHolder4.a(R.id.info_bottom_flower_num);
        if (appCompatTextView != null) {
            appCompatTextView.setText(i2 > 99 ? "99+" : String.valueOf(i2));
        }
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(appCompatTextView, 6, 10, 1, 2);
    }

    public final void updateLike(InspireWork inspireWork) {
        String formatNum;
        View view;
        Resources resources;
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        TextView textView = mViewHolder == null ? null : (TextView) mViewHolder.a(R.id.info_bottom_like_num);
        if (!kotlin.jvm.internal.s.c(inspireWork == null ? null : Integer.valueOf(inspireWork.likeSum), textView == null ? null : textView.getTag())) {
            if (textView != null) {
                if (inspireWork != null && inspireWork.likeSum == 0) {
                    us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
                    formatNum = (mViewHolder2 == null || (view = mViewHolder2.b) == null || (resources = view.getResources()) == null) ? null : resources.getString(R.string.feeds_photo_like_no_num);
                } else {
                    Integer valueOf = inspireWork == null ? null : Integer.valueOf(inspireWork.likeSum);
                    kotlin.jvm.internal.s.e(valueOf);
                    formatNum = InspireWork.formatNum(valueOf.intValue());
                }
                textView.setText(formatNum);
            }
            if (textView != null) {
                textView.setTag(inspireWork == null ? null : Integer.valueOf(inspireWork.likeSum));
            }
        }
        us.pinguo.inspire.y.a.c mViewHolder3 = getMViewHolder();
        LottieAnimationView lottieAnimationView = mViewHolder3 != null ? (LottieAnimationView) mViewHolder3.a(R.id.info_bottom_like_img) : null;
        if ((lottieAnimationView == null || lottieAnimationView.m()) ? false : true) {
            if (inspireWork != null && inspireWork.like == 1) {
                if (lottieAnimationView != null) {
                    lottieAnimationView.setAnimation("lottie/unlike/unlike.json");
                }
                if (lottieAnimationView != null) {
                    lottieAnimationView.setImageAssetsFolder("lottie/unlike");
                }
            } else {
                if (lottieAnimationView != null) {
                    lottieAnimationView.setAnimation("lottie/like/like.json");
                }
                if (lottieAnimationView != null) {
                    lottieAnimationView.setImageAssetsFolder("lottie/like");
                }
            }
            if (lottieAnimationView == null) {
                return;
            }
            lottieAnimationView.setProgress(0.0f);
        }
    }

    public final void updateShopping() {
        if (getMViewHolder() == null) {
            return;
        }
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder);
        View a = mViewHolder.a(R.id.info_shopping_cart_icon);
        kotlin.jvm.internal.s.g(a, "mViewHolder!!.getView(R.….info_shopping_cart_icon)");
        PhotoImageView photoImageView = (PhotoImageView) a;
        us.pinguo.inspire.y.a.c mViewHolder2 = getMViewHolder();
        kotlin.jvm.internal.s.e(mViewHolder2);
        View a2 = mViewHolder2.a(R.id.info_shopping_cart_text);
        kotlin.jvm.internal.s.g(a2, "mViewHolder!!.getView(R.….info_shopping_cart_text)");
        TextView textView = (TextView) a2;
        InspireWork.TaskInfo taskInfo = getMData().taskInfo;
        if ((taskInfo != null && taskInfo.taskMode == 2) && !getMData().isAd && getMData().taskInfo.isInfluencer == 1) {
            photoImageView.setVisibility(0);
            if (!TextUtils.isEmpty(getMData().taskInfo.influencer.getInfluencerText())) {
                textView.setText(getMData().taskInfo.influencer.getInfluencerText());
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            photoImageView.setImageUri(getMData().taskInfo.influencer.getInfluencerIcon(), R.drawable.challenge_shopping);
            us.pinguo.foundation.statistics.h.a.B0("recommend_purchase_entrance", "show");
            return;
        }
        textView.setVisibility(8);
        photoImageView.setVisibility(8);
    }
}
