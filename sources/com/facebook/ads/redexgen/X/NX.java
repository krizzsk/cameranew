package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@TargetApi(19)
/* loaded from: assets/audience_network.dex */
public final class NX extends ProgressBar {
    public static final int A02 = Color.argb(26, 0, 0, 0);
    public static final int A03 = Color.rgb(88, (int) IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 255);
    public Paint A00;
    public Rect A01;

    public NX(XT xt, AttributeSet attributeSet, int i2) {
        super(xt, attributeSet, i2);
        A01();
    }

    private Drawable A00() {
        ColorDrawable progressDrawable = new ColorDrawable(0);
        return new LayerDrawable(new Drawable[]{progressDrawable, new ClipDrawable(new ColorDrawable(A03), 3, 1)});
    }

    private void A01() {
        setIndeterminate(false);
        setMax(100);
        setProgressDrawable(A00());
        this.A01 = new Rect();
        this.A00 = new Paint();
        this.A00.setStyle(Paint.Style.FILL);
        this.A00.setColor(A02);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        canvas.drawRect(this.A01, this.A00);
        super.onDraw(canvas);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.A01.set(0, 0, getMeasuredWidth(), 2);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i2) {
        super.setProgress(i2 == 100 ? 0 : Math.max(i2, 5));
    }
}
