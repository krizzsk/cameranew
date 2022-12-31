package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.18  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass18 extends View$OnTouchListenerC05021f implements PB {
    public static byte[] A07;
    public static String[] A08 = {"T7MK6mm4Fzbg8PTMnM4kcHpb21LLpIaw", "PTQtUxKdjysMmbj8hCZsGKEwd1IRWqqZ", "Zw8mt4VncD", "79VYCrnrWW", "2MnAMBnkkiKtyd2cP7mHhabJycDYuMiE", "jaMauIT7sdi", "OgIH7ZaBRtH9hoDgrnw", "xZmsCngT77DU5lblEiekqTVKPqNdsast"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public MZ A04;
    public boolean A05;
    public final C0720Aa A06;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 28);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{-6, -7, -37, -20, -14, -16, -50, -13, -20, -7, -14, -16, -17};
    }

    static {
        A03();
    }

    public AnonymousClass18(XT xt) {
        super(xt);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C0720Aa(xt, new P8(), new P7());
        A02();
    }

    public AnonymousClass18(XT xt, AttributeSet attributeSet) {
        super(xt, attributeSet);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C0720Aa(xt, new P8(), new P7());
        A02();
    }

    public AnonymousClass18(XT xt, AttributeSet attributeSet, int i2) {
        super(xt, attributeSet, i2);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C0720Aa(xt, new P8(), new P7());
        A02();
    }

    private int A00(int availableWidth) {
        int numFullItems = this.A00 * 2;
        int itemSize = (getMeasuredWidth() - getPaddingLeft()) - numFullItems;
        int A0D = getAdapter().A0D();
        int i2 = 0;
        int numItems = Integer.MAX_VALUE;
        while (numItems > availableWidth) {
            i2++;
            if (i2 >= A0D) {
                return availableWidth;
            }
            int numItems2 = i2 * numFullItems;
            numItems = (int) ((itemSize - numItems2) / (i2 + 0.333f));
        }
        return numItems;
    }

    private void A02() {
        this.A06.A2E(0);
        setLayoutManager(this.A06);
        setSaveEnabled(false);
        setSnapDelegate(this);
        M5.A0K(this);
    }

    private void A04(int i2, int i3) {
        if (i2 == this.A03 && i3 == this.A02) {
            return;
        }
        this.A03 = i2;
        if (A08[1].charAt(11) == 'q') {
            throw new RuntimeException();
        }
        A08[6] = "hNBaptvkpj";
        this.A02 = i3;
        if (this.A04 != null) {
            throw new NullPointerException(A01(0, 13, 111));
        }
    }

    @Override // com.facebook.ads.redexgen.X.View$OnTouchListenerC05021f
    public final void A22(int i2, boolean z) {
        super.A22(i2, z);
        A04(i2, 0);
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final int A7A(int i2) {
        int abs = Math.abs(i2);
        if (abs <= ((View$OnTouchListenerC05021f) this).A06) {
            return 0;
        }
        int i3 = this.A01;
        if (i3 == 0) {
            return 1;
        }
        return 1 + (abs / i3);
    }

    public int getChildSpacing() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.C0828Eq, android.view.View
    public final void onMeasure(int i2, int itemSize) {
        int round;
        int A00;
        super.onMeasure(i2, itemSize);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.A05) {
            round = (((int) LY.A00) * JD.A0C(getContext())) + paddingTop;
        } else {
            round = Math.round(getMeasuredWidth() / 1.91f);
        }
        int mode = View.MeasureSpec.getMode(itemSize);
        if (mode == Integer.MIN_VALUE) {
            round = Math.min(View.MeasureSpec.getSize(itemSize), round);
        } else if (mode == 1073741824) {
            round = View.MeasureSpec.getSize(itemSize);
        }
        int i3 = round - paddingTop;
        if (this.A05) {
            A00 = Math.min(MW.A09, i3);
        } else {
            A00 = A00(i3);
        }
        setMeasuredDimension(getMeasuredWidth(), A00 + paddingTop);
        if (!this.A05) {
            setChildWidth((this.A00 * 2) + A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0828Eq
    public void setAdapter(@Nullable C4A c4a) {
        this.A06.A2L(c4a == null ? -1 : c4a.hashCode());
        super.setAdapter(c4a);
    }

    public void setChildSpacing(int i2) {
        this.A00 = i2;
    }

    public void setChildWidth(int i2) {
        this.A01 = i2;
        int measuredWidth = getMeasuredWidth();
        this.A06.A2M((((measuredWidth - getPaddingLeft()) - getPaddingRight()) - this.A01) / 2);
        this.A06.A2K(this.A01 / measuredWidth);
    }

    public void setCurrentPosition(int i2) {
        A22(i2, false);
    }

    public void setOnPageChangedListener(MZ mz) {
        this.A04 = mz;
    }

    public void setShowTextInCarousel(boolean z) {
        this.A05 = z;
    }
}
