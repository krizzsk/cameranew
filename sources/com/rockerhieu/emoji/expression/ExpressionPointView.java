package com.rockerhieu.emoji.expression;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.core.view.ViewCompat;
/* compiled from: ExpressionPagerView.java */
/* loaded from: classes9.dex */
class ExpressionPointView extends View {
    private Paint a;
    private int b;
    private int c;

    public ExpressionPointView(Context context) {
        super(context);
        this.b = ViewCompat.MEASURED_STATE_MASK;
        this.c = -7829368;
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 2.0f;
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        if (isSelected()) {
            this.a.setColor(this.b);
        } else {
            this.a.setColor(this.c);
        }
        canvas.drawCircle(width, height, min, this.a);
    }
}
