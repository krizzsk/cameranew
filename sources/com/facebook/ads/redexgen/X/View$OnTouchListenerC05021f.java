package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.1f  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnTouchListenerC05021f extends C0828Eq implements View.OnTouchListener {
    public static byte[] A07;
    public static String[] A08 = {"y4Urxqcv9RCHCbRsxOihNkmZ9cqKDFdZ", "LGqXjwU2H5uaBf0UptGCT7ZDInUwl5IV", "fkBbKznr2zH2OwfKJXQ1DdYWN1N", "HFNULQ3MobNCNeOVkX9dtbi8574Dr14V", "KPqvTm6ScHx6bbBibk9kuRT9nwj9YcDc", "WIY3Unb14PjE3ayNyWd6XWPIVw0Az9uS", "ZZL8YXP6wYj9", "tbuIO4j0iRDkkCNXzrivmX4Au5offJfR"};
    public int A00;
    public C1469be A01;
    public PB A02;
    public boolean A03;
    public boolean A04;
    public int A05;
    public final int A06;

    public static String A09(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 62);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{-53, -26, -39, -24, -54, -35, -37, -15, -37, -28, -35, -22, -50, -31, -35, -17, -104, -25, -26, -28, -15, -104, -21, -19, -24, -24, -25, -22, -20, -21, -104, -60, -31, -26, -35, -39, -22, -60, -39, -15, -25, -19, -20, -59, -39, -26, -39, -33, -35, -22};
    }

    static {
        A0A();
    }

    public View$OnTouchListenerC05021f(XT xt) {
        super(xt);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    public View$OnTouchListenerC05021f(XT xt, AttributeSet attributeSet) {
        super(xt, attributeSet);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    public View$OnTouchListenerC05021f(XT xt, AttributeSet attributeSet, int i2) {
        super(xt, attributeSet, i2);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    private int A05() {
        return ((int) getContext().getResources().getDisplayMetrics().density) * 10;
    }

    private int A06(int i2) {
        int i3 = this.A00 - i2;
        int A7A = this.A02.A7A(i3);
        int i4 = this.A06;
        if (i3 > i4) {
            return A08(this.A05, A7A);
        }
        if (i3 < (-i4)) {
            return A07(this.A05, A7A);
        }
        return this.A05;
    }

    private int A07(int i2, int i3) {
        return Math.max(i2 - i3, 0);
    }

    private int A08(int i2, int i3) {
        return Math.min(i2 + i3, getItemCount() - 1);
    }

    public void A22(int i2, boolean z) {
        if (getAdapter() == null) {
            return;
        }
        this.A05 = i2;
        if (z) {
            A1W(i2);
        } else {
            A1V(i2);
        }
    }

    public int getCurrentPosition() {
        return this.A05;
    }

    private int getItemCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().A0D();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6 || actionMasked == 3 || actionMasked == 4) {
            if (this.A04) {
                A22(A06(rawX), true);
            }
            this.A03 = true;
            this.A04 = false;
            return true;
        }
        if (actionMasked == 0 || actionMasked == 5 || (this.A03 && actionMasked == 2)) {
            this.A00 = rawX;
            String[] strArr = A08;
            if (strArr[5].charAt(14) == strArr[4].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[5] = "MxKeEan5PHYt2nmJnSz3xsZ38eI3mGgL";
            strArr2[4] = "utg9fSYK4sdWKYxBX5KGIJ2pCeKuK2tx";
            if (this.A03) {
                this.A03 = false;
            }
            this.A04 = true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C0828Eq
    public void setLayoutManager(C4M c4m) {
        if (c4m instanceof C1469be) {
            super.setLayoutManager(c4m);
            this.A01 = (C1469be) c4m;
            return;
        }
        throw new IllegalArgumentException(A09(0, 50, 58));
    }

    public void setSnapDelegate(PB pb) {
        this.A02 = pb;
    }
}
