package us.pinguo.inspire.module.attention;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes9.dex */
public class AttentionView extends FrameLayout {
    private int mColor;
    private Paint mPaint;
    private RectF mRect;
    private String mText;
    private int mViewHeight;
    private int mViewWidth;

    public AttentionView(Context context) {
        super(context);
        this.mRect = new RectF();
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(this.mRect, 3.0f, 3.0f, this.mPaint);
        canvas.drawText(this.mText, this.mViewWidth / 2, this.mViewHeight / 2, this.mPaint);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.mViewWidth = View.MeasureSpec.getSize(i2);
        this.mViewHeight = View.MeasureSpec.getSize(i3);
        this.mRect.set(new RectF(0.0f, 0.0f, this.mViewWidth, this.mViewHeight));
    }

    public void setTextAndColor(String str, int i2) {
        this.mText = str;
        this.mColor = i2;
        this.mPaint.setColor(i2);
        invalidate();
    }

    public AttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRect = new RectF();
        init();
    }

    public AttentionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mRect = new RectF();
        init();
    }

    @TargetApi(21)
    public AttentionView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mRect = new RectF();
        init();
    }
}
