package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class O9 extends LinearLayout {
    public static String[] A05 = {"JiUd07qZ", "phaLMHqUBlp6P5RZzzm", "VtPMRXbuUkVLmtGCwM", "RgvNiIo52t", "FYi9K2JmgPw1hqWSXD3EPgcEPQmLRiB", "yPPKnDMDveXTdnfoUUkFxo3t2NtgVDwK", "Cr", "5lHXxybE2bQiDNmNKuHItJ8Sueck67l"};
    public int A00;
    public List<GradientDrawable> A01;
    public final int A02;
    public final int A03;
    public final int A04;

    public O9(XT xt, C1I c1i, int dotSize) {
        super(xt);
        this.A00 = -1;
        setOrientation(0);
        setGravity(17);
        float f2 = LY.A00;
        int i2 = (int) (8.0f * f2);
        int i3 = (int) (6.0f * f2);
        int margin = (int) (1.0f * f2);
        this.A02 = margin;
        int margin2 = c1i.A04(false);
        this.A04 = margin2;
        int margin3 = C2N.A01(this.A04, 128);
        this.A03 = margin3;
        this.A01 = new ArrayList();
        for (int i4 = 0; i4 < dotSize; i4++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setSize(i2, i2);
            int margin4 = this.A02;
            gradientDrawable.setStroke(margin4, 0);
            ImageView imageView = new ImageView(xt);
            LinearLayout.LayoutParams dotImageParams = new LinearLayout.LayoutParams(-2, -2);
            dotImageParams.setMargins(0, 0, i3, 0);
            dotImageParams.gravity = 17;
            imageView.setLayoutParams(dotImageParams);
            imageView.setImageDrawable(gradientDrawable);
            this.A01.add(gradientDrawable);
            addView(imageView);
        }
        A00(0);
    }

    public final void A00(int i2) {
        int i3;
        int i4;
        if (this.A00 == i2) {
            return;
        }
        this.A00 = i2;
        if (A05[2].length() == 22) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[4] = "BJqXxH8n0fuaHx3JVwGHjWVcPjmBGjI";
        strArr[7] = "ZUGfW6Md7SIL60yz7Eq8Bq3LU56iFcm";
        for (int i5 = 0; i5 < this.A01.size(); i5++) {
            if (i5 == i2) {
                i3 = this.A04;
                i4 = this.A04;
            } else {
                i3 = this.A03;
                i4 = 0;
            }
            int borderColor = this.A02;
            this.A01.get(i5).setStroke(borderColor, i4);
            this.A01.get(i5).setColor(i3);
            this.A01.get(i5).invalidateSelf();
        }
    }
}
