package com.facebook.ads.internal.view;

import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.ads.redexgen.X.C0937Jb;
import com.facebook.ads.redexgen.X.C1023Mo;
import com.facebook.ads.redexgen.X.C1I;
import com.facebook.ads.redexgen.X.C1S;
import com.facebook.ads.redexgen.X.C1Z;
import com.facebook.ads.redexgen.X.LY;
import com.facebook.ads.redexgen.X.M5;
import com.facebook.ads.redexgen.X.MR;
import com.facebook.ads.redexgen.X.MS;
import com.facebook.ads.redexgen.X.MT;
import com.facebook.ads.redexgen.X.MU;
import com.facebook.ads.redexgen.X.MY;
import com.facebook.ads.redexgen.X.PD;
import com.facebook.ads.redexgen.X.XT;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class FullScreenAdToolbar extends MT {
    public static byte[] A07;
    public static String[] A08 = {"elaUgpg", "xyZ5KhWZZkOCw26QnbyRE89VYXYHkT38", "j2Hg99bd5kkvFLrtwtqoGvtE7T", "FtK0h2Y990QReQxCoMrwn7Y", "09p430KvfvIa5D7TMMbG57be7BWhVuc0", "4K9Dg6G4rdQDm1ubILJxRl9GbBVTjarc", "MQsbPX4", "ODYsITK"};
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    @Nullable
    public MS A00;
    public final RelativeLayout A01;
    public final C0937Jb A02;
    public final MR A03;
    public final MU A04;
    public final C1023Mo A05;
    public final PD A06;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 113);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{-26, 15, 18, 22, 8, -61, -28, 7, 56, 75, 86, 85, 88, 90, 6, 39, 74};
    }

    static {
        A03();
        A09 = (int) (LY.A00 * 10.0f);
        A0D = (int) (LY.A00 * 16.0f);
        int i2 = A0D;
        int i3 = A09;
        A0B = i2 - i3;
        A0C = (i2 * 2) - i3;
        A0A = (int) (LY.A00 * 4.0f);
    }

    public FullScreenAdToolbar(XT xt, MU mu, C0937Jb c0937Jb, @ToolbarActionView$ToolbarActionMode int i2, int i3) {
        super(xt);
        this.A04 = mu;
        this.A02 = c0937Jb;
        setGravity(16);
        this.A05 = new C1023Mo(xt, i2);
        this.A05.setContentDescription(A02(0, 8, 50));
        this.A05.setActionClickListener(new MY(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i4 = A0B;
        layoutParams.setMargins(i4, i4, A0C, i4);
        addView(this.A05, layoutParams);
        this.A01 = new RelativeLayout(xt);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.A06 = new PD(xt);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        this.A06.setLayoutParams(layoutParams3);
        this.A01.addView(this.A06);
        addView(this.A01, layoutParams2);
        this.A03 = new MR(xt, i3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        int i5 = A0D;
        layoutParams4.setMargins(0, i5 / 2, i5 / 2, i5 / 2);
        addView(this.A03, layoutParams4);
    }

    @Override // com.facebook.ads.redexgen.X.MT
    public final void A04(C1I c1i, boolean z) {
        int A04 = c1i.A04(z);
        this.A06.A01(c1i.A0A(z), A04);
        this.A03.setIconColors(A04);
        this.A03.setContentDescription(A02(8, 9, 117));
        this.A05.setColors(A04);
        if (z) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1778384896, 0});
            gradientDrawable.setCornerRadius(0.0f);
            M5.A0S(this, gradientDrawable);
            M5.A0Q(this.A03, 0, ViewCompat.MEASURED_STATE_MASK, A0A);
            return;
        }
        M5.A0M(this, 0);
    }

    @Override // com.facebook.ads.redexgen.X.MT
    public final boolean A05() {
        return this.A05.A02();
    }

    @Override // com.facebook.ads.redexgen.X.MT
    public int getToolbarHeight() {
        return MT.A00;
    }

    @Override // com.facebook.ads.redexgen.X.MT
    public void setAdReportingVisible(boolean z) {
        this.A03.setVisibility(z ? 0 : 8);
    }

    @Override // com.facebook.ads.redexgen.X.MT
    public void setPageDetails(C1S c1s, String str, int i2, C1Z c1z) {
        this.A05.setInitialUnskippableSeconds(i2);
        this.A06.setPageDetails(c1s);
        this.A03.setAdDetails(c1s, str, this.A02, this.A04);
    }

    @Override // com.facebook.ads.redexgen.X.MT
    public void setPageDetailsVisible(boolean z) {
        this.A01.removeAllViews();
        if (z) {
            RelativeLayout relativeLayout = this.A01;
            PD pd = this.A06;
            if (A08[4].charAt(4) != '3') {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[2] = "uYrc95dj4mq6YR3RipRhNZPjST";
            strArr[3] = "ufyXPPKrvmASdIniU0CJIS9";
            relativeLayout.addView(pd);
        }
        C1023Mo c1023Mo = this.A05;
        String[] strArr2 = A08;
        if (strArr2[2].length() == strArr2[3].length()) {
            c1023Mo.setToolbarMessageEnabled(!z);
            return;
        }
        A08[1] = "RoBBOPMqmB8G6B1FErbRchWOJuWn3pgq";
        c1023Mo.setToolbarMessageEnabled(!z);
    }

    @Override // com.facebook.ads.redexgen.X.MT
    public void setProgress(float f2) {
        this.A05.setProgress(f2);
    }

    @Override // com.facebook.ads.redexgen.X.MT
    public void setProgressSpinnerInvisible(boolean z) {
        this.A05.setProgressSpinnerInvisible(z);
    }

    @Override // com.facebook.ads.redexgen.X.MT
    public void setToolbarActionMessage(String str) {
        this.A05.setToolbarMessage(str);
    }

    @Override // com.facebook.ads.redexgen.X.MT
    public void setToolbarActionMode(@ToolbarActionView$ToolbarActionMode int i2) {
        this.A05.setToolbarActionMode(i2);
    }

    @Override // com.facebook.ads.redexgen.X.MT
    public void setToolbarListener(MS ms) {
        this.A00 = ms;
    }
}
