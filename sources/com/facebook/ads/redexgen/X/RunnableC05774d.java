package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.4d  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC05774d implements Runnable {
    public static byte[] A07;
    public static String[] A08 = {"c4xSVVt4fNiIZ9aJ0ftrOCVpKy2EJW", "bj77oS7wYHzhrY124YppwtIfPTuDoAHL", "mRmZUQV2DMpprRsDQaH8Mtbq5JuQtR14", "UXM5", "qfxFRQLCBxpF20va4RNO9ygLlTXV5cTV", "Bw29gSSAA0erG37CQVEqOkFPeCj6ZZr8", "KVIri1u0fbW7r5jnncTGzAnirlJcKx", "TA0EOfT3Z02jNldii3VIEnkki3"};
    public OverScroller A01;
    public int A02;
    public int A03;
    public final /* synthetic */ C0828Eq A06;
    public Interpolator A00 = C0828Eq.A1A;
    public boolean A04 = false;
    public boolean A05 = false;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 32);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{-46, -42, -96, -45, -29, -14, -17, -20, -20};
    }

    static {
        A03();
    }

    public RunnableC05774d(C0828Eq c0828Eq) {
        this.A06 = c0828Eq;
        this.A01 = new OverScroller(c0828Eq.getContext(), C0828Eq.A1A);
    }

    private float A00(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    private int A01(int absDx, int absDy, int i2, int i3) {
        int i4;
        int containerSize = Math.abs(absDx);
        int halfContainerSize = Math.abs(absDy);
        boolean z = containerSize > halfContainerSize;
        int sqrt = (int) Math.sqrt((i2 * i2) + (i3 * i3));
        int sqrt2 = (int) Math.sqrt((absDx * absDx) + (absDy * absDy));
        C0828Eq c0828Eq = this.A06;
        int width = z ? c0828Eq.getWidth() : c0828Eq.getHeight();
        int delta = width / 2;
        float A00 = delta + (delta * A00(Math.min(1.0f, (sqrt2 * 1.0f) / width)));
        if (sqrt > 0) {
            i4 = Math.round(Math.abs(A00 / sqrt) * 1000.0f) * 4;
        } else {
            if (!z) {
                containerSize = halfContainerSize;
            }
            i4 = (int) (((containerSize / width) + 1.0f) * 300.0f);
        }
        return Math.min(i4, 2000);
    }

    private final void A04() {
        this.A05 = false;
        this.A04 = true;
    }

    private final void A05() {
        this.A04 = false;
        if (this.A05) {
            A07();
        }
    }

    private final void A06(int i2, int i3, int i4, int i5) {
        A0B(i2, i3, A01(i2, i3, i4, i5));
    }

    public final void A07() {
        if (this.A04) {
            this.A05 = true;
            return;
        }
        this.A06.removeCallbacks(this);
        if (A08[4].charAt(10) == 'o') {
            throw new RuntimeException();
        }
        A08[2] = "DBTzn4opHB64KJUt1kyQdTPFEm6jko5S";
        AnonymousClass31.A0D(this.A06, this);
    }

    public final void A08() {
        this.A06.removeCallbacks(this);
        this.A01.abortAnimation();
    }

    public final void A09(int i2, int i3) {
        this.A06.setScrollState(2);
        this.A03 = 0;
        this.A02 = 0;
        this.A01.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        A07();
    }

    public final void A0A(int i2, int i3) {
        A06(i2, i3, 0, 0);
    }

    public final void A0B(int i2, int i3, int i4) {
        A0C(i2, i3, i4, C0828Eq.A1A);
    }

    public final void A0C(int i2, int i3, int i4, Interpolator interpolator) {
        if (this.A00 != interpolator) {
            this.A00 = interpolator;
            this.A01 = new OverScroller(this.A06.getContext(), interpolator);
        }
        this.A06.setScrollState(2);
        this.A03 = 0;
        this.A02 = 0;
        this.A01.startScroll(0, 0, i2, i3, i4);
        if (Build.VERSION.SDK_INT < 23) {
            OverScroller overScroller = this.A01;
            if (A08[7].length() != 26) {
                throw new RuntimeException();
            }
            A08[2] = "UeYo97OquvC2FnZv3LivDSVIricXCoYT";
            overScroller.computeScrollOffset();
        }
        A07();
    }

    public final void A0D(int i2, int i3, Interpolator interpolator) {
        int A01 = A01(i2, i3, 0, 0);
        if (interpolator == null) {
            interpolator = C0828Eq.A1A;
        }
        A0C(i2, i3, A01, interpolator);
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x028d, code lost:
        if (r15 != 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02a7, code lost:
        if (r9.A07() < r11) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02a9, code lost:
        r9.A0A(r11 - 1);
        r9.A04(r5 - r1, r4 - r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02b7, code lost:
        r9.A04(r5 - r1, r4 - r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x02cf, code lost:
        if (r9 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02e4, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e2, code lost:
        if (r9 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e8, code lost:
        if (r9.A0E() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ee, code lost:
        if (r9.A0F() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f0, code lost:
        r11 = r21.A06.A0s.A03();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f8, code lost:
        if (r11 != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00fa, code lost:
        r9.A09();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x010a, code lost:
        if (com.facebook.ads.redexgen.X.RunnableC05774d.A08[4].charAt(10) == 'o') goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x010c, code lost:
        com.facebook.ads.redexgen.X.RunnableC05774d.A08[3] = "TGS8taa2nLIFayhr7f7v";
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x017c, code lost:
        if (r15 != 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x017e, code lost:
        r21.A06.A1Y(r14, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0183, code lost:
        if (r14 != 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0185, code lost:
        if (r1 == r7) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0187, code lost:
        r1 = r0.getFinalX();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x018b, code lost:
        if (r1 != 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x018d, code lost:
        if (r13 != 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x018f, code lost:
        if (r0 == r6) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0195, code lost:
        if (r0.getFinalY() != 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0197, code lost:
        r0.abortAnimation();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x020e, code lost:
        if (r0 == false) goto L111;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01fc  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RunnableC05774d.run():void");
    }
}
