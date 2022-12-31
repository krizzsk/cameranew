package us.pinguo.advconfigdata.appwall;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.Utils.AdvSystemUtils;
/* loaded from: classes3.dex */
public class AppWallRotateView extends View {
    private static final int ANIM_COUNT = 10;
    private static final long ANIM_PER_DURATION = 600;
    private static final long PER_ANIM_DELAY_TIME = 1000;
    private String ADString;
    private int BORDERCOLOR;
    private int mADHeight;
    private Paint mADStringPaint;
    private int mADTextSize;
    private int mADWidth;
    private long mAnimatorRepeatedTimes;
    private AppWallIconManager mAppWallIconManager;
    private float mBorder2Radius;
    private float mBorder2StrokeWidth;
    private Paint mBorderPaint2;
    private Camera mCamera;
    private long mCurrentAnimTime;
    private RoundedBitmapDrawable mCurrentDrawable;
    private RectF mDrawableRect;
    private int mDrawableWid;
    private boolean mIsAnimRunning;
    private Matrix mMatrix;
    private Runnable mRestartAnimationRunnable;
    private ValueAnimator mRotateAnimator;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (AppWallRotateView.this.mIsAnimRunning) {
                AppWallRotateView.this.updateMatrixByRotate(intValue);
                AppWallRotateView.this.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            AppWallRotateView.access$208(AppWallRotateView.this);
            AdvLog.Log("onAnimationRepeat,mAnimatorRepeatedTimes" + AppWallRotateView.this.mAnimatorRepeatedTimes);
            if (AppWallRotateView.this.mAnimatorRepeatedTimes >= 10) {
                AppWallRotateView.this.mIsAnimRunning = false;
                AppWallRotateView.this.mAnimatorRepeatedTimes = 0L;
                AppWallRotateView appWallRotateView = AppWallRotateView.this;
                appWallRotateView.removeCallbacks(appWallRotateView.mRestartAnimationRunnable);
                AppWallRotateView.this.mRotateAnimator.cancel();
            } else if (AppWallRotateView.this.mAnimatorRepeatedTimes % 2 != 0) {
                AppWallRotateView.this.mRotateAnimator.setIntValues(-90, 0);
                AppWallRotateView appWallRotateView2 = AppWallRotateView.this;
                appWallRotateView2.mCurrentDrawable = appWallRotateView2.mAppWallIconManager.getRandomRoundDrawable(AppWallRotateView.this.getResources());
                AppWallRotateView.this.mCurrentDrawable.setCornerRadius(AppWallRotateView.this.mDrawableRect.width() / 2.0f);
            } else {
                AppWallRotateView.this.mRotateAnimator.setIntValues(0, 90);
                AppWallRotateView appWallRotateView3 = AppWallRotateView.this;
                appWallRotateView3.mCurrentAnimTime = appWallRotateView3.mRotateAnimator.getCurrentPlayTime();
                AppWallRotateView.this.mRotateAnimator.cancel();
                AppWallRotateView appWallRotateView4 = AppWallRotateView.this;
                appWallRotateView4.postDelayed(appWallRotateView4.mRestartAnimationRunnable, AppWallRotateView.PER_ANIM_DELAY_TIME);
            }
        }
    }

    /* loaded from: classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdvLog.Log("mRestartAnimationRunnable");
            AppWallRotateView.this.mRotateAnimator.setCurrentPlayTime(AppWallRotateView.this.mCurrentAnimTime);
            AppWallRotateView.this.mRotateAnimator.start();
        }
    }

    public AppWallRotateView(Context context) {
        super(context);
        this.mBorderPaint2 = new Paint();
        this.mDrawableRect = new RectF();
        this.mCurrentDrawable = null;
        this.mMatrix = null;
        this.mRotateAnimator = null;
        this.mCamera = new Camera();
        this.mAnimatorRepeatedTimes = 0L;
        this.mCurrentAnimTime = 0L;
        this.mAppWallIconManager = null;
        this.mIsAnimRunning = false;
        this.mADWidth = 0;
        this.mADHeight = 0;
        this.mADTextSize = 0;
        this.BORDERCOLOR = -12959667;
        this.mRestartAnimationRunnable = new c();
        this.mDrawableWid = 0;
        this.ADString = "AD";
        this.mADStringPaint = new Paint();
        init();
    }

    static /* synthetic */ long access$208(AppWallRotateView appWallRotateView) {
        long j2 = appWallRotateView.mAnimatorRepeatedTimes;
        appWallRotateView.mAnimatorRepeatedTimes = 1 + j2;
        return j2;
    }

    private void createAnimator() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 90);
        this.mRotateAnimator = ofInt;
        ofInt.setDuration(ANIM_PER_DURATION);
        this.mRotateAnimator.setInterpolator(new LinearInterpolator());
        this.mRotateAnimator.setRepeatCount(-1);
        this.mRotateAnimator.setStartDelay(ANIM_PER_DURATION);
        this.mRotateAnimator.addUpdateListener(new a());
        this.mRotateAnimator.addListener(new b());
    }

    private void drawADIcon(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        Rect rect = new Rect();
        Paint paint = this.mADStringPaint;
        String str = this.ADString;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(this.ADString, width - rect.width(), -this.mADStringPaint.getFontMetricsInt().top, this.mADStringPaint);
    }

    private void drawBorders(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mBorder2Radius, this.mBorderPaint2);
    }

    private void drawDrawable(Canvas canvas) {
        canvas.save();
        RoundedBitmapDrawable roundedBitmapDrawable = this.mCurrentDrawable;
        RectF rectF = this.mDrawableRect;
        roundedBitmapDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        canvas.concat(this.mMatrix);
        this.mCurrentDrawable.draw(canvas);
        canvas.restore();
    }

    private void getcorrectTextSize(int i2) {
        this.mADStringPaint.setTextSize(i2);
        Rect rect = new Rect();
        Paint paint = this.mADStringPaint;
        String str = this.ADString;
        paint.getTextBounds(str, 0, str.length(), rect);
        if (rect.width() < getWidth() / 10) {
            i2++;
            getcorrectTextSize(i2);
        }
        if (rect.width() > getWidth() / 5) {
            getcorrectTextSize(i2 - 1);
        }
    }

    private void init() {
        createAnimator();
        this.mADHeight = AdvSystemUtils.DpToPx(getContext(), 15.0f);
        this.mADWidth = AdvSystemUtils.DpToPx(getContext(), 20.0f);
        this.mADTextSize = AdvSystemUtils.DpToPx(getContext(), 10.0f);
        this.mBorder2StrokeWidth = AdvSystemUtils.DpToPx(getContext(), 1.5f);
        this.mBorderPaint2.setColor(this.BORDERCOLOR);
        this.mBorderPaint2.setAntiAlias(true);
        this.mBorderPaint2.setStyle(Paint.Style.STROKE);
        this.mBorderPaint2.setStrokeWidth(this.mBorder2StrokeWidth);
        this.mMatrix = new Matrix();
        this.mADStringPaint.setColor(this.BORDERCOLOR);
        this.mADStringPaint.setTextAlign(Paint.Align.LEFT);
    }

    private void restore() {
        this.mAnimatorRepeatedTimes = 0L;
        this.mMatrix.reset();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMatrixByRotate(int i2) {
        float width = getWidth() / 2;
        float height = getHeight() / 2;
        this.mMatrix.reset();
        this.mCamera.save();
        this.mCamera.rotateY(i2);
        this.mCamera.getMatrix(this.mMatrix);
        this.mCamera.restore();
        this.mMatrix.preTranslate(-width, -height);
        this.mMatrix.postTranslate(width, height);
    }

    public String getCurImageURl() {
        return this.mAppWallIconManager.getCurImageURl();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDrawable(canvas);
        drawBorders(canvas);
        drawADIcon(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(min, min);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.mADStringPaint.setStrokeWidth(2.0f);
        getcorrectTextSize(30);
        Rect rect = new Rect();
        Paint paint = this.mADStringPaint;
        String str = this.ADString;
        paint.getTextBounds(str, 0, str.length(), rect);
        int height = i2 - rect.height();
        this.mDrawableWid = height;
        float f2 = this.mBorder2StrokeWidth;
        this.mBorder2Radius = (height - (f2 * 2.0f)) / 2.0f;
        float f3 = (((height - (f2 * 2.0f)) * 1.0f) / 2.0f) * 2.0f;
        RectF rectF = this.mDrawableRect;
        float f4 = (i2 - f3) / 2.0f;
        rectF.left = f4;
        rectF.top = f4;
        rectF.right = f4 + f3;
        rectF.bottom = f4 + f3;
        this.mCurrentDrawable.setCornerRadius(rectF.width() / 2.0f);
    }

    public void setBorderColor(int i2) {
        this.mBorderPaint2.setColor(i2);
        this.mADStringPaint.setColor(i2);
        this.BORDERCOLOR = i2;
        invalidate();
    }

    public void setGuId(String str) {
        AppWallIconManager appWallIconManager = new AppWallIconManager(getContext(), str);
        this.mAppWallIconManager = appWallIconManager;
        this.mCurrentDrawable = appWallIconManager.getRandomRoundDrawable(getResources());
    }

    public void startAnim() {
        AdvLog.Log("startAnim");
        if (this.mIsAnimRunning || this.mAppWallIconManager.getSize() <= 1) {
            return;
        }
        this.mIsAnimRunning = true;
        this.mRotateAnimator.cancel();
        this.mRotateAnimator.setIntValues(0, 90);
        removeCallbacks(this.mRestartAnimationRunnable);
        restore();
        this.mRotateAnimator.start();
    }

    public void stopAnim() {
        AdvLog.Log("stopAnim");
        this.mIsAnimRunning = false;
        this.mRotateAnimator.cancel();
        restore();
        removeCallbacks(this.mRestartAnimationRunnable);
    }

    public AppWallRotateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderPaint2 = new Paint();
        this.mDrawableRect = new RectF();
        this.mCurrentDrawable = null;
        this.mMatrix = null;
        this.mRotateAnimator = null;
        this.mCamera = new Camera();
        this.mAnimatorRepeatedTimes = 0L;
        this.mCurrentAnimTime = 0L;
        this.mAppWallIconManager = null;
        this.mIsAnimRunning = false;
        this.mADWidth = 0;
        this.mADHeight = 0;
        this.mADTextSize = 0;
        this.BORDERCOLOR = -12959667;
        this.mRestartAnimationRunnable = new c();
        this.mDrawableWid = 0;
        this.ADString = "AD";
        this.mADStringPaint = new Paint();
        init();
    }

    public AppWallRotateView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mBorderPaint2 = new Paint();
        this.mDrawableRect = new RectF();
        this.mCurrentDrawable = null;
        this.mMatrix = null;
        this.mRotateAnimator = null;
        this.mCamera = new Camera();
        this.mAnimatorRepeatedTimes = 0L;
        this.mCurrentAnimTime = 0L;
        this.mAppWallIconManager = null;
        this.mIsAnimRunning = false;
        this.mADWidth = 0;
        this.mADHeight = 0;
        this.mADTextSize = 0;
        this.BORDERCOLOR = -12959667;
        this.mRestartAnimationRunnable = new c();
        this.mDrawableWid = 0;
        this.ADString = "AD";
        this.mADStringPaint = new Paint();
        init();
    }

    @TargetApi(21)
    public AppWallRotateView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mBorderPaint2 = new Paint();
        this.mDrawableRect = new RectF();
        this.mCurrentDrawable = null;
        this.mMatrix = null;
        this.mRotateAnimator = null;
        this.mCamera = new Camera();
        this.mAnimatorRepeatedTimes = 0L;
        this.mCurrentAnimTime = 0L;
        this.mAppWallIconManager = null;
        this.mIsAnimRunning = false;
        this.mADWidth = 0;
        this.mADHeight = 0;
        this.mADTextSize = 0;
        this.BORDERCOLOR = -12959667;
        this.mRestartAnimationRunnable = new c();
        this.mDrawableWid = 0;
        this.ADString = "AD";
        this.mADStringPaint = new Paint();
        init();
    }
}
