package com.pinguo.camera360.lib.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import us.pinguo.foundation.utils.n0;
import us.pinguo.ui.uilview.AlphaImageView;
/* loaded from: classes3.dex */
public class RedPointAlphaImageView extends AlphaImageView {
    private boolean a;
    private int b;
    private Paint c;

    public RedPointAlphaImageView(Context context) {
        super(context);
        this.a = false;
        init();
    }

    private void init() {
        this.b = n0.c(3);
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(-635856);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setAntiAlias(true);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a) {
            if (getDrawable() != null) {
                int width = getWidth();
                int height = getHeight();
                int intrinsicWidth = getDrawable().getIntrinsicWidth();
                canvas.drawCircle(intrinsicWidth + ((width - intrinsicWidth) / 2), (height - getDrawable().getIntrinsicHeight()) / 2, this.b, this.c);
                return;
            }
            int width2 = getWidth();
            int i2 = this.b;
            canvas.drawCircle(width2 - i2, i2, i2, this.c);
        }
    }

    public void setHasRedPoint(boolean z) {
        boolean z2 = this.a != z;
        this.a = z;
        if (z2) {
            invalidate();
        }
    }

    public RedPointAlphaImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        init();
    }

    public RedPointAlphaImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = false;
        init();
    }
}
