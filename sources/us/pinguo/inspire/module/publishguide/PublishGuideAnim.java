package us.pinguo.inspire.module.publishguide;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.text.SpannableString;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import us.pinguo.ui.widget.j;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class PublishGuideAnim implements ValueAnimator.AnimatorUpdateListener {
    private static final int DURATION = 250;
    private static final int TRANS_MAX_DP = 60;
    private ValueAnimator mAnimator;
    private View mEntranceView;
    private j mHideListener;
    private boolean mIsCancel;
    private View mPublishParent;
    private TextView mPublishTxt;
    private float mRate;
    private j mShowListener;
    private boolean mShwoingAnim;
    private int mTransMax;

    public PublishGuideAnim(View view) {
        this.mEntranceView = view.findViewById(R.id.publish_guide_entrance);
        this.mPublishParent = view.findViewById(R.id.publish_guide_publish_ripple);
        this.mPublishTxt = (TextView) view.findViewById(R.id.publish_guide_publish);
        this.mTransMax = us.pinguo.foundation.t.b.a.b(view.getResources(), 60.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(250L);
        this.mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mAnimator.addUpdateListener(this);
        this.mShowListener = new j() { // from class: us.pinguo.inspire.module.publishguide.PublishGuideAnim.1
            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                PublishGuideAnim.this.mIsCancel = true;
            }

            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (PublishGuideAnim.this.mIsCancel) {
                    return;
                }
                PublishGuideAnim.this.mRate = 1.0f;
                PublishGuideAnim.this.mEntranceView.setVisibility(8);
            }

            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PublishGuideAnim.this.mIsCancel = false;
                PublishGuideAnim.this.mPublishParent.setVisibility(0);
                PublishGuideAnim.this.mPublishParent.setAlpha(0.0f);
                PublishGuideAnim.this.mPublishParent.setTranslationY(-PublishGuideAnim.this.mTransMax);
            }
        };
        this.mHideListener = new j() { // from class: us.pinguo.inspire.module.publishguide.PublishGuideAnim.2
            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                PublishGuideAnim.this.mIsCancel = true;
            }

            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (PublishGuideAnim.this.mIsCancel) {
                    return;
                }
                PublishGuideAnim.this.mRate = 0.0f;
                PublishGuideAnim.this.mPublishParent.setVisibility(8);
            }

            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PublishGuideAnim.this.mEntranceView.setVisibility(0);
                PublishGuideAnim.this.mIsCancel = false;
            }
        };
    }

    private void hidePublish() {
        if (this.mRate == 0.0f) {
            return;
        }
        if (this.mAnimator.isStarted() && this.mShwoingAnim) {
            this.mAnimator.cancel();
        }
        this.mShwoingAnim = false;
        this.mAnimator.removeListener(this.mShowListener);
        this.mAnimator.addListener(this.mHideListener);
        this.mAnimator.setFloatValues(this.mRate, 0.0f);
        this.mAnimator.start();
    }

    private void setPublishNum(int i2) {
        String string = this.mPublishTxt.getResources().getString(R.string.publish_guide_publish);
        SpannableString spannableString = new SpannableString(string + "  " + i2);
        spannableString.setSpan(new CountSpan(this.mPublishTxt.getContext(), i2), spannableString.length() + (-1), spannableString.length(), 33);
        this.mPublishTxt.setText(spannableString);
    }

    private void showPublish() {
        if (this.mAnimator.isStarted() && !this.mShwoingAnim) {
            this.mAnimator.cancel();
        }
        if (this.mRate == 1.0f) {
            return;
        }
        this.mShwoingAnim = true;
        this.mAnimator.removeListener(this.mHideListener);
        this.mAnimator.addListener(this.mShowListener);
        this.mAnimator.setFloatValues(this.mRate, 1.0f);
        this.mAnimator.start();
    }

    public void changePublishNum(int i2) {
        if (i2 == 0) {
            hidePublish();
            return;
        }
        setPublishNum(i2);
        showPublish();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.mRate = floatValue;
        this.mPublishParent.setAlpha(floatValue);
        this.mEntranceView.setAlpha(1.0f - this.mRate);
        this.mPublishParent.setTranslationY((-(1.0f - this.mRate)) * this.mTransMax);
        this.mEntranceView.setTranslationY(this.mRate * this.mTransMax);
    }
}
