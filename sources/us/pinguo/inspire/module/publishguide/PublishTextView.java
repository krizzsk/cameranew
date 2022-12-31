package us.pinguo.inspire.module.publishguide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes9.dex */
public class PublishTextView extends TextView {
    private Paint mPaint;
    private int mRadius;
    private Rect mRect;
    private float mShowRate;
    private RectF mTempRectF;

    public PublishTextView(Context context) {
        super(context);
        this.mShowRate = 1.0f;
        this.mRect = new Rect();
        this.mPaint = new Paint();
        this.mTempRectF = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRadius == 0) {
            this.mRadius = us.pinguo.foundation.t.b.a.a(getContext(), 2.0f);
        }
        this.mPaint.setColor(-12806145);
        this.mRect.set(getLeft(), getTop(), (int) (getLeft() + (getWidth() * this.mShowRate)), getBottom());
        canvas.save();
        canvas.clipRect(this.mRect);
        this.mTempRectF.set(getLeft(), getTop(), getRight(), getBottom());
        RectF rectF = this.mTempRectF;
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, i2, i2, this.mPaint);
        super.onDraw(canvas);
        canvas.restore();
    }

    public void setShowRate(float f2) {
        this.mShowRate = f2;
    }

    public PublishTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mShowRate = 1.0f;
        this.mRect = new Rect();
        this.mPaint = new Paint();
        this.mTempRectF = new RectF();
    }

    public PublishTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mShowRate = 1.0f;
        this.mRect = new Rect();
        this.mPaint = new Paint();
        this.mTempRectF = new RectF();
    }
}
