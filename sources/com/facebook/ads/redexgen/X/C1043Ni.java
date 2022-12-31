package com.facebook.ads.redexgen.X;

import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.ArrayList;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ni  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1043Ni extends RelativeLayout {
    public static MU A05;
    public static byte[] A06;
    public static String[] A07 = {"CT308ms2RTF49ixw7iITcI5DvAIGWMXZ", "UVauKq3DlAHpB1vMyeeSD4Us6AaVXCYd", "G3Ivv2DNtSsvdOlvNnw6jHI40eb4uyYL", "qur6nZLrhU9XJET37yOODnXWYcrj37IJ", "OCLfHPrXkMpm02uq88EYR3Uw1JpI2kE3", "KopKmjllEHptdGx3", "mL4xXMXopKoNgp", "1VwEGJcTQNgN7iTbFc9O"};
    public static final int A08;
    public static final int A09;
    public AbstractC1454bO A00;
    public XT A01;
    public C04930w A02;
    @Nullable
    public C1173Sk A03;
    @Nullable
    public O9 A04;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A07[6].length() == 9) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[2] = "hwjeWCnyrgrPOyFOaJyYR4Ki88uO9bQs";
            strArr[0] = "4m7NTkn57B9pIqsgccGzW0RoTzQfESBy";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 119);
            i5++;
        }
    }

    public static void A02() {
        A06 = new byte[]{-25, 5, 22, 19, 25, 23, 9, 16, -60, -14, 5, 24, Draft_75.CR, 26, 9, -60, 26, Draft_75.CR, 9, 27, -60, 5, 8, 9, 20, 24, 9, 22, -60, Draft_75.CR, 23, 18, -53, 24, -60, 7, 22, 9, 5, 24, 9, 8, -60, 20, 22, 19, 20, 9, 22, 16, 29, -5, -7, 2, -7, 6, -3, -9};
    }

    static {
        A02();
        A08 = (int) (LY.A00 * 8.0f);
        A09 = (int) (LY.A00 * 15.0f);
        A05 = new C1172Sj();
    }

    public C1043Ni(XT xt) {
        super(xt);
        this.A01 = xt;
        this.A02 = new C04930w(xt);
        M5.A0K(this.A02);
        this.A00 = new C0831Et();
        this.A00.A0G(this.A02);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.A02, layoutParams);
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x001a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<com.facebook.ads.redexgen.X.PE> A01(com.facebook.ads.redexgen.X.AnonymousClass16 r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        L8:
            java.util.List r5 = r7.A0X()
            int r0 = r5.size()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r0)
            r3 = 0
        L16:
            int r0 = r5.size()
            if (r3 >= r0) goto L31
            java.lang.Object r2 = r5.get(r3)
            com.facebook.ads.redexgen.X.19 r2 = (com.facebook.ads.redexgen.X.AnonymousClass19) r2
            int r1 = r5.size()
            com.facebook.ads.redexgen.X.PE r0 = new com.facebook.ads.redexgen.X.PE
            r0.<init>(r3, r1, r2)
            r4.add(r0)
            int r3 = r3 + 1
            goto L16
        L31:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1043Ni.A01(com.facebook.ads.redexgen.X.16):java.util.ArrayList");
    }

    public final void A04() {
        this.A02.setAdapter(null);
    }

    public final void A05(C1198Tj c1198Tj, int i2) {
        ArrayList<PE> A01 = A01(c1198Tj.A0y());
        this.A02.setCardsInfo(A01);
        this.A03 = new C1173Sk(this.A01, A01, c1198Tj.A0y(), this.A01.A00().A08(), c1198Tj, A05, c1198Tj.A0y().A0Q(), this.A02.getCarouselCardBehaviorHelper(), null);
        this.A02.setAdapter(this.A03);
        int childSpacing = i2 - (A08 * 10);
        this.A03.A0F(childSpacing, 16, 0);
        this.A03.A06();
        setupDotsLayout(c1198Tj, A01);
    }

    public final void A06(QZ qz) {
        C1173Sk c1173Sk = this.A03;
        if (c1173Sk != null) {
            c1173Sk.A0G(qz);
        } else {
            this.A01.A06().A8q(A00(51, 7, 29), C06808m.A1i, new C06818n(A00(0, 51, 45)));
        }
        this.A02.A22(qz);
    }

    public static MU getDummyListener() {
        return A05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpLayoutForCardAtIndex(int i2) {
        O9 o9 = this.A04;
        if (o9 != null) {
            o9.A00(i2);
        }
    }

    private void setupDotsLayout(C1198Tj c1198Tj, ArrayList<PE> arrayList) {
        this.A02.getCarouselCardBehaviorHelper().A0Z(new C1171Si(this));
        this.A04 = new O9(this.A01, c1198Tj.A0y().A0J().A01(), arrayList.size());
        M5.A0K(this.A04);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.A02.getId());
        layoutParams.setMargins(0, A09, 0, 0);
        addView(this.A04, layoutParams);
    }
}
