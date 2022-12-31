package com.facebook.ads.redexgen.X;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Keep;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class O3 extends View {
    public static byte[] A05;
    public float A00;
    public final float A01;
    public final Paint A02;
    public final Paint A03;
    public final RectF A04;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 80);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{0, 2, 31, 23, 2, 21, 3, 3};
    }

    public O3(XT xt) {
        super(xt);
        this.A01 = Resources.getSystem().getDisplayMetrics().density * 3.0f;
        this.A00 = 0.0f;
        this.A04 = new RectF();
        this.A02 = new Paint(1);
        this.A02.setStyle(Paint.Style.STROKE);
        this.A02.setStrokeWidth(this.A01);
        this.A03 = new Paint(1);
        this.A03.setStyle(Paint.Style.STROKE);
        this.A03.setStrokeWidth(this.A01);
    }

    public final void A02(int i2, int i3) {
        this.A02.setColor(i2);
        this.A03.setColor(i3);
    }

    @Keep
    public float getProgress() {
        return this.A00;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.A04, 0.0f, 360.0f, false, this.A02);
        canvas.drawArc(this.A04, -90.0f, ((100.0f - this.A00) * 360.0f) / 100.0f, false, this.A03);
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumHeight(), i3), getDefaultSize(getSuggestedMinimumWidth(), i2));
        setMeasuredDimension(min, min);
        this.A04.set((this.A01 / 2.0f) + 0.0f + getPaddingLeft(), (this.A01 / 2.0f) + 0.0f + getPaddingTop(), (min - (this.A01 / 2.0f)) - getPaddingRight(), (min - (this.A01 / 2.0f)) - getPaddingBottom());
    }

    @Keep
    public void setProgress(float f2) {
        this.A00 = Math.min(f2, 100.0f);
        postInvalidate();
    }

    public void setProgressWithAnimation(float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, A00(0, 8, 32), f2);
        ofFloat.setDuration(400L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }
}
