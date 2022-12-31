package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* renamed from: com.facebook.ads.redexgen.X.Rh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1144Rh extends C4R {
    public static byte[] A0H;
    public static String[] A0I = {"vVts3290hN8iYOphvTtUHsw8p", "g", "QXZRYfiopoOIgyOb", "uRY3EBcOhcPzIFCW", "1yhQGC5wOot73mjsntHrCCOy6H7", "ngPHprqJPXgJBcmGEhNrmzVf2B4dA5Oh", "DCeBbFrEMIUsiq6", "addqTveDrmk"};
    @Nullable
    public OV A02;
    public QZ A04;
    @Nullable
    public List<PE> A05;
    public boolean A09;
    public final int A0A;
    public final Context A0B;
    public final C1469be A0C;
    public final C4Z A0D;
    public final Set<Integer> A0G = new HashSet();
    public boolean A08 = true;
    public boolean A06 = true;
    public boolean A07 = true;
    public int A01 = -1;
    public float A00 = 0.0f;
    public final OZ A0F = new C1147Rk(this);
    public OX A03 = new C1146Rj(this);
    public final OY A0E = new C1145Ri(this);

    public static String A05(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0H, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 126);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A0H = new byte[]{-26, -6, -7, -12, 4, -11, -15, -26, -2, 4, -22, -13, -26, -25, -15, -22, -23, 4, -11, -26, -9, -26, -14, 7, 17, 29, 4, 7, 16, 17, 18, 29, 20, 7, 2, 3, Draft_75.CR, 29, 14, -1, 16, -1, 11, -5, -12, -15, -6, -14, -22, 4, -15, -22, -5, -22, -15, 4, -11, -26, -9, -26, -14};
    }

    static {
        A08();
    }

    public C1144Rh(C2F c2f, int i2, @Nullable List<PE> list, @Nullable QZ qz, @Nullable Bundle bundle) {
        this.A0C = c2f.getLayoutManager();
        this.A0A = i2;
        this.A05 = list;
        this.A04 = qz;
        this.A0D = new C1468bd(c2f.getContext());
        this.A0B = c2f.getContext();
        c2f.A1j(this);
        A0D(bundle);
    }

    @Nullable
    private SJ A03(int i2, int i3) {
        return A04(i2, i3, true);
    }

    @Nullable
    private SJ A04(int i2, int i3, boolean isCompletelyVisible) {
        SJ sj = null;
        while (i2 <= i3) {
            SJ sj2 = (SJ) this.A0C.A1q(i2);
            if (sj2 == null || sj2.A0h()) {
                return null;
            }
            boolean A0b = A0b(sj2);
            if (A0I[2].length() != 16) {
                throw new RuntimeException();
            }
            A0I[0] = "";
            if (sj == null && sj2.A0i() && A0b && !this.A0G.contains(Integer.valueOf(i2)) && (!isCompletelyVisible || A0I(sj2))) {
                sj = sj2;
            }
            if (sj2.A0i() && !A0b) {
                A0C(i2, false);
            }
            i2++;
        }
        return sj;
    }

    private void A06() {
        if (!this.A07) {
            return;
        }
        int A28 = this.A0C.A28();
        int lastVisibleItem = this.A0C.A29();
        SJ firstAutoplayableVideo = A03(A28, lastVisibleItem);
        if (firstAutoplayableVideo != null) {
            firstAutoplayableVideo.A0f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        int A27 = this.A0C.A27();
        if (A27 != -1 && A27 < this.A05.size() - 1) {
            A0V(A27 + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(int i2) {
        SJ A04 = A04(i2 + 1, this.A0C.A29(), false);
        if (A04 != null) {
            A04.A0f();
            A0V(((Integer) A04.getTag(-1593835536)).intValue());
        }
    }

    private void A0A(int i2, int i3) {
        while (i2 <= i3) {
            A0T(i2);
            i2++;
        }
    }

    private final void A0B(int i2, int i3) {
        A0S(i2);
        A0S(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(int i2, boolean z) {
        if (z) {
            this.A0G.add(Integer.valueOf(i2));
        } else {
            this.A0G.remove(Integer.valueOf(i2));
        }
    }

    private void A0D(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.A00 = bundle.getFloat(A05(43, 18, 39), 0.0f);
        this.A07 = bundle.getBoolean(A05(0, 23, 39), true);
        this.A08 = bundle.getBoolean(A05(23, 20, 64), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0H() {
        return JD.A1s(this.A0B) || this.A0A == 1;
    }

    public static boolean A0I(OJ oj) {
        int width = (int) (((oj.getWidth() + LY.A01.widthPixels) * 1.3f) / 2.0f);
        int width2 = (int) (((LY.A01.widthPixels - oj.getWidth()) * 0.7f) / 2.0f);
        int furthestX = (int) (oj.getX() + oj.getWidth());
        if (furthestX <= width) {
            int furthestX2 = (oj.getX() > width2 ? 1 : (oj.getX() == width2 ? 0 : -1));
            if (furthestX2 >= 0) {
                return true;
            }
        }
        return false;
    }

    private boolean A0J(SJ sj) {
        if (this.A08 && sj.A0i()) {
            this.A08 = false;
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C4R
    public void A0L(C0828Eq c0828Eq, int i2) {
        super.A0L(c0828Eq, i2);
        if (i2 == 0) {
            this.A09 = true;
            A06();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4R
    public void A0M(C0828Eq c0828Eq, int i2, int i3) {
        super.A0M(c0828Eq, i2, i3);
        this.A09 = false;
        if (this.A06) {
            this.A09 = true;
            A06();
            this.A06 = false;
        }
        int A28 = this.A0C.A28();
        int A29 = this.A0C.A29();
        A0B(A28, A29);
        A0A(A28, A29);
        A0W(A28, A29, i2);
    }

    public final OX A0N() {
        return this.A03;
    }

    public final OY A0O() {
        return this.A0E;
    }

    public final OZ A0P() {
        return this.A0F;
    }

    public final void A0Q() {
        this.A01 = -1;
        int A29 = this.A0C.A29();
        for (int A28 = this.A0C.A28(); A28 <= A29 && A28 >= 0; A28++) {
            SJ sj = (SJ) this.A0C.A1q(A28);
            if (sj != null && sj.A0h()) {
                this.A01 = A28;
                sj.A0e();
                return;
            }
        }
    }

    public final void A0R() {
        SJ sj = (SJ) this.A0C.A1q(this.A01);
        if (sj != null && this.A01 >= 0) {
            sj.A0f();
        }
    }

    public final void A0S(int i2) {
        SJ sj = (SJ) this.A0C.A1q(i2);
        if (sj == null || A0b(sj)) {
            return;
        }
        String[] strArr = A0I;
        if (strArr[6].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        A0I[0] = "Vxamqv9qm4zlsVVB8";
        A0a(sj, false);
    }

    public final void A0T(int i2) {
        List<PE> list;
        SJ sj = (SJ) this.A0C.A1q(i2);
        if (sj == null) {
            return;
        }
        if (A0b(sj)) {
            A0a(sj, true);
        }
        if (!A0J(sj) || (list = this.A05) == null) {
            return;
        }
        this.A0F.setVolume(list.get(((Integer) sj.getTag(-1593835536)).intValue()).A03().A0D().A09() ? 0.0f : 1.0f);
    }

    public final void A0U(int i2) {
        A0A(i2, i2);
    }

    public final void A0V(int i2) {
        this.A0D.A0A(i2);
        this.A0C.A1L(this.A0D);
    }

    public final void A0W(int recomputeFrom, int i2, int i3) {
        if (!A0H() || this.A02 == null) {
            return;
        }
        int A27 = this.A0C.A27();
        if (A27 == -1) {
            A27 = i3 < 0 ? recomputeFrom : i2;
        }
        this.A02.AF8(A27);
    }

    public final void A0X(Bundle bundle) {
        bundle.putFloat(A05(43, 18, 39), this.A00);
        bundle.putBoolean(A05(0, 23, 39), this.A07);
        bundle.putBoolean(A05(23, 20, 64), this.A08);
    }

    public void A0Y(View view, boolean z) {
        view.setAlpha(z ? 1.0f : 0.5f);
    }

    public final void A0Z(OV ov) {
        this.A02 = ov;
    }

    public void A0a(SJ sj, boolean z) {
        if (A0H()) {
            A0Y(sj, z);
        }
        if (z) {
            return;
        }
        boolean A0h = sj.A0h();
        String[] strArr = A0I;
        if (strArr[6].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        A0I[2] = "slnyAJQBNPORwedJ";
        if (A0h) {
            sj.A0e();
        }
    }

    public boolean A0b(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.15f;
    }
}
