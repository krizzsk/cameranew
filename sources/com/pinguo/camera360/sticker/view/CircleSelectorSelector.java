package com.pinguo.camera360.sticker.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class CircleSelectorSelector extends CircleSelectorImageView {
    private final int TOTAL_DURATION;
    private ValueAnimator mAnimation;
    private float mProgressAngle;
    private RectF oval;
    private Paint paint;

    public CircleSelectorSelector(Context context) {
        super(context);
        this.TOTAL_DURATION = 1000;
        this.mProgressAngle = 0.0f;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(1342177280);
        this.paint.setAntiAlias(true);
        this.oval = new RectF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.sticker.view.CircleSelectorImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        int height;
        super.onDraw(canvas);
        int min = Math.min(getWidth(), getHeight());
        float f2 = (width - min) / 2.0f;
        float f3 = (height - min) / 2.0f;
        float f4 = min;
        this.oval.set(f2, f3, f2 + f4, f4 + f3);
        canvas.drawArc(this.oval, -90.0f, -this.mProgressAngle, true, this.paint);
    }

    public void setProgress(int i2) {
        float f2 = 360.0f - ((i2 / 100.0f) * 360.0f);
        ValueAnimator valueAnimator = this.mAnimation;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimation.cancel();
        }
        this.mAnimation = ValueAnimator.ofFloat(this.mProgressAngle, f2);
        this.mAnimation.setDuration((int) ((Math.abs(this.mProgressAngle - f2) / 360.0f) * 1000.0f));
        this.mAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pinguo.camera360.sticker.view.CircleSelectorSelector.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CircleSelectorSelector.this.mProgressAngle = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CircleSelectorSelector.this.invalidate();
            }
        });
        this.mAnimation.start();
    }

    public void setProgressWithoutAnimation(int i2) {
        ValueAnimator valueAnimator = this.mAnimation;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimation.cancel();
        }
        this.mProgressAngle = 360.0f - ((i2 / 100.0f) * 360.0f);
        invalidate();
    }

    public CircleSelectorSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TOTAL_DURATION = 1000;
        this.mProgressAngle = 0.0f;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(1342177280);
        this.paint.setAntiAlias(true);
        this.oval = new RectF();
    }

    public CircleSelectorSelector(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.TOTAL_DURATION = 1000;
        this.mProgressAngle = 0.0f;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(1342177280);
        this.paint.setAntiAlias(true);
        this.oval = new RectF();
    }
}
