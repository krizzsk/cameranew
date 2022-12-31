package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.widget.ImageView;
import java.util.Arrays;
@SuppressLint({"ViewConstructor"})
/* loaded from: assets/audience_network.dex */
public final class PK extends ImageView {
    public static byte[] A03;
    public static final int A04;
    public final Paint A00;
    public final PI A01;
    public final PJ A02;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 78);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{11, 47, 33, 40, 29, -40, 36, 29, 30, 44, 14, 50, 36, 43, 32, -37, 45, 36, 34, 35, 47};
    }

    static {
        A03();
        A04 = (int) (LY.A00 * 4.0f);
    }

    public PK(XT xt, PI pi, PJ pj) {
        super(xt);
        this.A01 = pi;
        this.A02 = pj;
        this.A00 = new Paint();
        this.A00.setColor(-1728053248);
        setColorFilter(-1);
        int i2 = A04;
        setPadding(i2, i2, i2, i2);
        boolean z = this.A01 == PI.A03;
        setContentDescription(z ? A02(0, 10, 106) : A02(10, 11, 109));
        Bitmap A01 = ME.A01(MD.TO_RIGHT_ARROW);
        if (z) {
            Matrix matrix = new Matrix();
            matrix.postRotate(180.0f);
            A01 = Bitmap.createBitmap(A01, 0, 0, A01.getWidth(), A01.getHeight(), matrix, true);
        }
        setImageBitmap(A01);
        setOnClickListener(new PH(this));
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        canvas.drawCircle(width, height, Math.min(width, height), this.A00);
        super.onDraw(canvas);
    }
}
