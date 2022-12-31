package us.pinguo.inspire.module.feeds.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import d.f.a.b.d;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.module.feeds.view.FeedsPhotoCommentView;
/* loaded from: classes9.dex */
public class FeedsCommentView extends View {
    private static final int MAX_COUNT = 5;
    private ValueAnimator mAnimator;
    private int mBottomExtraPadding;
    private CommentDrawable[] mDrawables;
    private int mMargin;
    private int mPadding;
    private FeedsPhotoCommentView.CommentText[] mTexts;

    public FeedsCommentView(Context context) {
        super(context);
        this.mDrawables = new CommentDrawable[5];
        init();
    }

    private void init() {
        this.mMargin = a.a(getContext(), 16.0f);
        this.mPadding = a.a(getContext(), 4.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        FeedsPhotoCommentView.CommentText[] commentTextArr = this.mTexts;
        int length = commentTextArr == null ? 0 : commentTextArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            CommentDrawable[] commentDrawableArr = this.mDrawables;
            if (i2 >= commentDrawableArr.length) {
                return;
            }
            if (commentDrawableArr[i2] != null) {
                commentDrawableArr[i2].draw(canvas);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        FeedsPhotoCommentView.CommentText[] commentTextArr = this.mTexts;
        if (commentTextArr == null || commentTextArr.length == 0) {
            return;
        }
        int measuredHeight = getMeasuredHeight();
        int i4 = this.mMargin;
        int i5 = (measuredHeight - i4) - this.mBottomExtraPadding;
        int measuredWidth = getMeasuredWidth() - this.mMargin;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            CommentDrawable[] commentDrawableArr = this.mDrawables;
            if (i6 >= commentDrawableArr.length || i6 >= this.mTexts.length) {
                return;
            }
            CommentDrawable commentDrawable = commentDrawableArr[i6];
            if (i7 == 0) {
                i7 = commentDrawable.getHeight();
            }
            int i8 = i5 - i7;
            commentDrawable.setBounds(i4, i8, measuredWidth, i5);
            i5 = i8 - this.mPadding;
            i6++;
        }
    }

    public void setBottomExtraPadding(int i2) {
        this.mBottomExtraPadding = i2;
    }

    public void setComments(FeedsPhotoCommentView.CommentText[] commentTextArr) {
        this.mTexts = commentTextArr;
        for (int i2 = 0; commentTextArr != null && i2 < commentTextArr.length && i2 < 5; i2++) {
            CommentDrawable[] commentDrawableArr = this.mDrawables;
            commentDrawableArr[i2] = commentDrawableArr[i2] == null ? new CommentDrawable(getResources()) : commentDrawableArr[i2];
            this.mDrawables[i2].setCallback(this);
            this.mDrawables[i2].setText(commentTextArr[i2].segs);
        }
        requestLayout();
    }

    public void showAnim() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.mAnimator.cancel();
            return;
        }
        FeedsPhotoCommentView.CommentText[] commentTextArr = this.mTexts;
        if (commentTextArr == null || commentTextArr.length == 0) {
            return;
        }
        final float b = a.b(getResources(), 30.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.mTexts.length);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(commentTextArr.length * 400);
        this.mAnimator.setStartDelay(400L);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.module.feeds.view.FeedsCommentView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                int measuredHeight = (FeedsCommentView.this.getMeasuredHeight() - FeedsCommentView.this.mMargin) - FeedsCommentView.this.mBottomExtraPadding;
                for (int i2 = 0; i2 < FeedsCommentView.this.mDrawables.length; i2++) {
                    CommentDrawable commentDrawable = FeedsCommentView.this.mDrawables[i2];
                    if (commentDrawable != null) {
                        int length = (FeedsCommentView.this.mTexts.length - i2) - 1;
                        int length2 = FeedsCommentView.this.mTexts.length;
                        int bottom = measuredHeight - ((int) commentDrawable.getBottom());
                        int i3 = (int) (bottom + b);
                        float f2 = length;
                        if (floatValue >= f2) {
                            i3 = (int) (i3 + ((0 - i3) * ((floatValue - f2) / (length2 - length))));
                        }
                        commentDrawable.setTransY(i3);
                        float f3 = i3 > bottom ? 1.0f - ((i3 - bottom) / b) : 1.0f;
                        commentDrawable.setAlpha((int) (255.0f * f3));
                        d.d("i:" + i2 + "   alpha:" + f3, new Object[0]);
                    }
                }
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: us.pinguo.inspire.module.feeds.view.FeedsCommentView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                for (int i2 = 0; i2 < FeedsCommentView.this.mDrawables.length; i2++) {
                    if (FeedsCommentView.this.mDrawables[i2] != null) {
                        FeedsCommentView.this.mDrawables[i2].setAlpha(255);
                    }
                }
                FeedsCommentView.this.mAnimator = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                for (int i2 = 0; i2 < FeedsCommentView.this.mDrawables.length; i2++) {
                    if (FeedsCommentView.this.mDrawables[i2] != null) {
                        FeedsCommentView.this.mDrawables[i2].setAlpha(0);
                    }
                }
            }
        });
        this.mAnimator.start();
    }

    public void stopAnim() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            return;
        }
        this.mAnimator.end();
        this.mAnimator = null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        CommentDrawable[] commentDrawableArr;
        boolean verifyDrawable = super.verifyDrawable(drawable);
        if (!verifyDrawable && (commentDrawableArr = this.mDrawables) != null && commentDrawableArr.length > 0) {
            int i2 = 0;
            while (true) {
                CommentDrawable[] commentDrawableArr2 = this.mDrawables;
                if (i2 >= commentDrawableArr2.length) {
                    break;
                } else if (drawable == commentDrawableArr2[i2]) {
                    return true;
                } else {
                    i2++;
                }
            }
        }
        return verifyDrawable;
    }

    public FeedsCommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawables = new CommentDrawable[5];
        init();
    }

    public FeedsCommentView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDrawables = new CommentDrawable[5];
        init();
    }
}
