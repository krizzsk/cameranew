package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
/* loaded from: assets/audience_network.dex */
public final class PC extends RelativeLayout {
    public final Paint A00;
    public final RectF A01;

    public PC(XT xt, String str) {
        super(xt);
        float f2 = xt.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(xt);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(16.0f);
        textView.setText(str);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        int i2 = (int) (6.0f * f2);
        textView.setPadding(i2, i2, i2, i2);
        addView(textView);
        this.A00 = new Paint();
        this.A00.setStyle(Paint.Style.FILL);
        this.A00.setColor(-1);
        this.A01 = new RectF();
        M5.A0M(this, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f2 = getContext().getResources().getDisplayMetrics().density;
        this.A01.set(0.0f, 0.0f, getWidth(), getHeight());
        canvas.drawRoundRect(this.A01, f2 * 10.0f, 10.0f * f2, this.A00);
        super.onDraw(canvas);
    }
}
