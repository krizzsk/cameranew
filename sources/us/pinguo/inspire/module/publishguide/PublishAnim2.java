package us.pinguo.inspire.module.publishguide;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tapjoy.TapjoyAuctionFlags;
import us.pinguo.librouter.module.inspire.BasePublishGuideFragment;
/* loaded from: classes9.dex */
public class PublishAnim2 {
    private static final int DURATION = 400;
    private Activity mActivity;
    private ValueAnimator mAnim;
    private ViewGroup mContainer;
    private int mContainerId;
    private ViewGroup mContainerParent;
    private int mContainerParentId;
    private FragmentManager mFragmentManager;
    private int mBgColorNoAlpha = 0;
    private int mBgColorAlphaMax = 123;
    private TimeInterpolator mInterpolator = new AccelerateDecelerateInterpolator();

    public PublishAnim2(Activity activity, FragmentManager fragmentManager) {
        this.mActivity = activity;
        int identifier = activity.getResources().getIdentifier("portal_publish_container_parent", TapjoyAuctionFlags.AUCTION_ID, activity.getPackageName());
        this.mContainerParentId = identifier;
        if (identifier == 0) {
            this.mContainerParent = new RelativeLayout(activity);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(identifier);
        this.mContainerParent = viewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(0);
        }
        int identifier2 = activity.getResources().getIdentifier("portal_publish_container", TapjoyAuctionFlags.AUCTION_ID, activity.getPackageName());
        this.mContainerId = identifier2;
        if (identifier2 == 0) {
            RelativeLayout relativeLayout = new RelativeLayout(activity);
            this.mContainer = relativeLayout;
            this.mContainerParent.addView(relativeLayout);
            return;
        }
        ViewGroup viewGroup2 = this.mContainerParent;
        if (viewGroup2 != null) {
            this.mContainer = (ViewGroup) viewGroup2.findViewById(identifier2);
        }
        this.mFragmentManager = fragmentManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showImpl() {
        boolean z;
        ValueAnimator valueAnimator = this.mAnim;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            z = false;
        } else {
            z = true;
            this.mAnim.cancel();
        }
        int d2 = us.pinguo.foundation.t.b.a.d(this.mActivity);
        if (!z) {
            this.mContainer.setTranslationY(d2);
            this.mContainerParent.setVisibility(0);
        }
        final View findViewWithTag = this.mContainer.findViewWithTag("publish_guide_close");
        final float translationY = this.mContainer.getTranslationY();
        final int alpha = Color.alpha(((ColorDrawable) this.mContainerParent.getBackground()).getColor());
        final int i2 = this.mBgColorAlphaMax;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnim = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.module.publishguide.PublishAnim2.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                float interpolation = PublishAnim2.this.mInterpolator.getInterpolation(floatValue);
                float f2 = translationY;
                float f3 = f2 + ((r3 - f2) * interpolation);
                int i3 = alpha;
                int argb = Color.argb((int) (i3 + ((i2 - i3) * floatValue)), Color.red(PublishAnim2.this.mBgColorNoAlpha), Color.green(PublishAnim2.this.mBgColorNoAlpha), Color.blue(PublishAnim2.this.mBgColorNoAlpha));
                PublishAnim2.this.mContainer.setTranslationY(f3);
                PublishAnim2.this.mContainerParent.setBackgroundColor(argb);
                findViewWithTag.setRotation(((0.0f - alpha) * floatValue) - 90.0f);
            }
        });
        this.mAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mAnim.setDuration((int) (Math.abs((translationY - 0.0f) / d2) * 400.0f));
        this.mAnim.start();
    }

    public void hide() {
        ValueAnimator valueAnimator = this.mAnim;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.mAnim.cancel();
        }
        int d2 = us.pinguo.foundation.t.b.a.d(this.mActivity);
        final View findViewWithTag = this.mContainer.findViewWithTag("publish_guide_close");
        final float translationY = this.mContainer.getTranslationY();
        final float f2 = d2;
        final int alpha = Color.alpha(((ColorDrawable) this.mContainerParent.getBackground()).getColor());
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnim = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.module.publishguide.PublishAnim2.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                float f3 = translationY;
                float f4 = f3 + ((f2 - f3) * floatValue);
                int i2 = alpha;
                PublishAnim2.this.mContainerParent.setBackgroundColor(Color.argb((int) (i2 + ((r5 - i2) * floatValue)), Color.red(PublishAnim2.this.mBgColorNoAlpha), Color.green(PublishAnim2.this.mBgColorNoAlpha), Color.blue(PublishAnim2.this.mBgColorNoAlpha)));
                PublishAnim2.this.mContainer.setTranslationY(f4);
                findViewWithTag.setRotation(((0.0f - alpha) * floatValue) - 90.0f);
            }
        });
        this.mAnim.setDuration((int) (Math.abs((translationY - f2) / f2) * 400.0f));
        this.mAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mAnim.addListener(new Animator.AnimatorListener() { // from class: us.pinguo.inspire.module.publishguide.PublishAnim2.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PublishAnim2.this.mContainerParent.setVisibility(8);
                Fragment findFragmentByTag = PublishAnim2.this.mFragmentManager.findFragmentByTag("publishguide");
                if (findFragmentByTag != null) {
                    PublishAnim2.this.mFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.mAnim.start();
    }

    public void hideNoAnim() {
        if (this.mContainer == null || this.mContainerParent == null || this.mFragmentManager == null) {
            return;
        }
        int d2 = us.pinguo.foundation.t.b.a.d(this.mActivity);
        this.mContainerParent.setBackgroundColor(0);
        this.mContainerParent.setVisibility(8);
        this.mContainer.setTranslationY(d2);
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag("publishguide");
        if (findFragmentByTag != null) {
            this.mFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
    }

    public void show() {
        BasePublishGuideFragment basePublishGuideFragment = (BasePublishGuideFragment) this.mFragmentManager.findFragmentByTag("publishguide");
        if (basePublishGuideFragment == null) {
            PublishGuide2Fragment publishGuide2Fragment = new PublishGuide2Fragment();
            publishGuide2Fragment.setPublishAnim(this);
            publishGuide2Fragment.setOnFirstFrameAvailableListener(new BasePublishGuideFragment.a() { // from class: us.pinguo.inspire.module.publishguide.PublishAnim2.2
                @Override // us.pinguo.librouter.module.inspire.BasePublishGuideFragment.a
                public void onFirstFrameAvailable() {
                    PublishAnim2.this.showImpl();
                }
            });
            us.pinguo.common.log.a.k("new PublishGuideFragment add", new Object[0]);
            if (this.mContainerId != 0) {
                this.mFragmentManager.beginTransaction().add(this.mContainerId, publishGuide2Fragment, "publishguide").commitAllowingStateLoss();
            }
        } else if (basePublishGuideFragment.isAdded()) {
            if (basePublishGuideFragment.isInLayout()) {
                return;
            }
            this.mFragmentManager.beginTransaction().show(basePublishGuideFragment);
            if (this.mContainerParent.getVisibility() == 8) {
                showImpl();
            }
        } else {
            us.pinguo.common.log.a.k("find PublishGuideFragment", new Object[0]);
            if (this.mContainerId != 0) {
                this.mFragmentManager.beginTransaction().add(this.mContainerId, basePublishGuideFragment, "publishguide").commitAllowingStateLoss();
            }
        }
    }
}
