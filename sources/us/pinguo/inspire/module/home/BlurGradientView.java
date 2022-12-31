package us.pinguo.inspire.module.home;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.Inspire;
import us.pinguo.ui.R;
/* loaded from: classes9.dex */
public class BlurGradientView extends View {
    public static final int BLUR_RADIUS_DEFAULT = 50;
    private static Bitmap mDefaultBitmap;
    private ValueAnimator mAnimator;
    private float mBlurRadius;
    private IBlurSource mBlurSource;
    private Bitmap mCurBitmap;
    private Blurable mCurGradientedCell;
    private Blurable mCurLoadingCell;
    private Rect mDstRect;
    private Handler mHandler;
    private boolean mIsPausing;
    private Paint mPaint;
    private float mRate;
    private Rect mSrcRect;
    private Bitmap mToBitmap;

    /* loaded from: classes9.dex */
    public interface Blurable {
        void getBitmapToBlur(OnBitmapLoadedListener onBitmapLoadedListener, float f2, float f3, Handler handler);
    }

    /* loaded from: classes9.dex */
    public interface IBlurSource {
        Blurable getBlurable();
    }

    /* loaded from: classes9.dex */
    public interface OnBitmapLoadedListener {
        void onLoaded(int i2, Bitmap bitmap);
    }

    public BlurGradientView(Context context) {
        super(context);
        this.mSrcRect = new Rect();
        this.mDstRect = new Rect();
        this.mHandler = new Handler();
        init();
    }

    private Blurable getCurActiveCell() {
        IBlurSource iBlurSource = this.mBlurSource;
        if (iBlurSource == null) {
            return null;
        }
        return iBlurSource.getBlurable();
    }

    private void init() {
        this.mBlurRadius = a.a(getContext(), 50.0f);
        this.mPaint = new Paint(4);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(600L);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.module.home.BlurGradientView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BlurGradientView.this.mRate = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BlurGradientView.this.invalidate();
            }
        });
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: us.pinguo.inspire.module.home.BlurGradientView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BlurGradientView blurGradientView = BlurGradientView.this;
                blurGradientView.mCurBitmap = blurGradientView.mToBitmap;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        if (mDefaultBitmap == null) {
            try {
                mDefaultBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blur_default);
            } catch (OutOfMemoryError e2) {
                Inspire.f(e2);
                mDefaultBitmap = Bitmap.createBitmap(new int[]{getResources().getColor(R.color.inspire_loading_color)}, 1, 1, Bitmap.Config.ARGB_8888);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.mCurBitmap;
        Bitmap bitmap2 = this.mToBitmap;
        if (bitmap == null) {
            bitmap = mDefaultBitmap;
        }
        if (bitmap2 == null) {
            bitmap2 = mDefaultBitmap;
        }
        this.mSrcRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.mPaint.setAlpha((int) ((1.0f - this.mRate) * 255.0f));
        canvas.drawBitmap(bitmap, this.mSrcRect, this.mDstRect, this.mPaint);
        this.mPaint.setAlpha((int) (this.mRate * 255.0f));
        this.mSrcRect.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
        canvas.drawBitmap(bitmap2, this.mSrcRect, this.mDstRect, this.mPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.mDstRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void release() {
        if (this.mIsPausing) {
            return;
        }
        this.mIsPausing = true;
        this.mCurGradientedCell = null;
        this.mCurBitmap = null;
        this.mToBitmap = null;
        invalidate();
    }

    public void resume() {
        if (this.mIsPausing) {
            this.mIsPausing = false;
            showGradientBg();
            this.mRate = 1.0f;
            invalidate();
        }
    }

    public void setBlurSource(IBlurSource iBlurSource) {
        this.mBlurSource = iBlurSource;
    }

    public void showGradientBg() {
        if (this.mIsPausing) {
            return;
        }
        if (this.mAnimator.isRunning() || this.mAnimator.isStarted()) {
            if (this.mCurGradientedCell == getCurActiveCell()) {
                return;
            }
            this.mAnimator.cancel();
        }
        final Blurable curActiveCell = getCurActiveCell();
        if (this.mCurGradientedCell == curActiveCell || curActiveCell == null) {
            return;
        }
        this.mCurLoadingCell = curActiveCell;
        curActiveCell.getBitmapToBlur(new OnBitmapLoadedListener() { // from class: us.pinguo.inspire.module.home.BlurGradientView.3
            @Override // us.pinguo.inspire.module.home.BlurGradientView.OnBitmapLoadedListener
            public void onLoaded(int i2, Bitmap bitmap) {
                if (BlurGradientView.this.mCurLoadingCell == null || i2 != BlurGradientView.this.mCurLoadingCell.hashCode()) {
                    return;
                }
                BlurGradientView.this.mCurLoadingCell = null;
                BlurGradientView.this.mCurGradientedCell = curActiveCell;
                BlurGradientView.this.mToBitmap = bitmap;
                BlurGradientView.this.mAnimator.start();
            }
        }, this.mBlurRadius, 0.5f, this.mHandler);
    }

    public BlurGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSrcRect = new Rect();
        this.mDstRect = new Rect();
        this.mHandler = new Handler();
        init();
    }

    public BlurGradientView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mSrcRect = new Rect();
        this.mDstRect = new Rect();
        this.mHandler = new Handler();
        init();
    }
}
