package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class ShadowTextView extends TextView {
    private Paint a;
    private RectF b;
    private int c;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    private void a() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.a.setColor(Color.parseColor("#99333333"));
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(0.0f);
        this.b = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.b;
        float f2 = rectF.bottom;
        canvas.drawRoundRect(rectF, f2 / 2.0f, f2 / 2.0f, this.a);
        canvas.translate((this.b.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            int measureText = (int) getPaint().measureText("00");
            this.c = measureText;
            if (measuredWidth < measureText) {
                measuredWidth = measureText;
            }
            int i4 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i4, measuredHeight);
            this.b.set(0.0f, 0.0f, i4, measuredHeight);
            return;
        }
        this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public ShadowTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = 0;
        a();
    }
}
