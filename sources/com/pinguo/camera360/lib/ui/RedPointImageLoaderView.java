package com.pinguo.camera360.lib.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
import us.pinguo.foundation.utils.n0;
/* loaded from: classes3.dex */
public class RedPointImageLoaderView extends ImageLoaderView {

    /* renamed from: d  reason: collision with root package name */
    private int f6834d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f6835e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6836f;

    public RedPointImageLoaderView(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.f6834d = n0.c(3);
        Paint paint = new Paint();
        this.f6835e = paint;
        paint.setColor(-635856);
        this.f6835e.setStyle(Paint.Style.FILL);
        this.f6835e.setAntiAlias(true);
        this.f6836f = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6836f) {
            int width = getWidth();
            int i2 = this.f6834d;
            canvas.drawCircle(width - i2, i2, i2, this.f6835e);
        }
    }

    public void setIsDrawRedPoint(boolean z) {
        this.f6836f = z;
        invalidate();
    }

    public void setRedPointRadius(int i2) {
        this.f6834d = n0.c(i2);
    }

    public RedPointImageLoaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public RedPointImageLoaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
