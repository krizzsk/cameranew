package us.pinguo.inspire.module.MissionDetail;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes9.dex */
public class TriangleView extends View {
    private Paint mPaint;

    public TriangleView(Context context) {
        super(context);
        this.mPaint = new Paint(1);
        init();
    }

    private void init() {
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(getWidth(), 0.0f);
        path.lineTo(0.0f, getHeight());
        path.lineTo(0.0f, 0.0f);
        canvas.drawPath(path, this.mPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setColor(int i2) {
        this.mPaint.setColor(i2);
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint(1);
        init();
    }

    public TriangleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaint = new Paint(1);
        init();
    }
}
