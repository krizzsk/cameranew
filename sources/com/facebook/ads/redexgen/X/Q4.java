package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.widget.Button;
import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class Q4 extends Button {
    public static byte[] A07;
    public String A00;
    public String A01;
    public boolean A02;
    public final Paint A03;
    public final Path A04;
    public final Path A05;
    public final Path A06;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 4);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A07 = new byte[]{89, 104, 124, 122, 108, 118, 74, 71, 95};
    }

    public Q4(XT xt) {
        this(xt, false);
    }

    public Q4(XT xt, boolean z) {
        super(xt);
        this.A02 = false;
        this.A01 = A00(5, 4, 34);
        this.A00 = A00(0, 5, 13);
        this.A04 = new Path();
        this.A05 = new Path();
        this.A06 = new Path();
        this.A03 = new Q3(this, z);
        A01();
        setClickable(true);
        M5.A0M(this, 0);
    }

    private void A01() {
        setContentDescription(this.A02 ? this.A01 : this.A00);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (canvas.isHardwareAccelerated() && Build.VERSION.SDK_INT < 17) {
            setLayerType(1, null);
        }
        float max = Math.max(canvas.getWidth(), canvas.getHeight()) / 100.0f;
        if (this.A02) {
            this.A06.rewind();
            this.A06.moveTo(max * 26.5f, max * 15.5f);
            this.A06.lineTo(max * 26.5f, 84.5f * max);
            this.A06.lineTo(90.0f * max, 50.0f * max);
            this.A06.lineTo(26.5f * max, 15.5f * max);
            this.A06.close();
            canvas.drawPath(this.A06, this.A03);
        } else {
            this.A04.rewind();
            this.A04.moveTo(max * 29.0f, max * 21.0f);
            this.A04.lineTo(max * 29.0f, max * 79.0f);
            this.A04.lineTo(max * 45.0f, max * 79.0f);
            this.A04.lineTo(45.0f * max, max * 21.0f);
            this.A04.lineTo(29.0f * max, max * 21.0f);
            this.A04.close();
            this.A05.rewind();
            this.A05.moveTo(max * 55.0f, max * 21.0f);
            this.A05.lineTo(max * 55.0f, max * 79.0f);
            this.A05.lineTo(max * 71.0f, 79.0f * max);
            this.A05.lineTo(71.0f * max, max * 21.0f);
            this.A05.lineTo(55.0f * max, 21.0f * max);
            this.A05.close();
            canvas.drawPath(this.A04, this.A03);
            canvas.drawPath(this.A05, this.A03);
        }
        super.onDraw(canvas);
    }

    public void setChecked(boolean z) {
        this.A02 = z;
        A01();
        refreshDrawableState();
        invalidate();
    }

    public void setPauseAccessibilityLabel(@Nullable String str) {
        if (str != null) {
            this.A00 = str;
            A01();
        }
    }

    public void setPlayAccessibilityLabel(@Nullable String str) {
        if (str != null) {
            this.A01 = str;
            A01();
        }
    }
}
