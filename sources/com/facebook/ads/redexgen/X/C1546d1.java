package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.d1  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1546d1 implements InterfaceC04840n {
    public static byte[] A0A;
    public static String[] A0B = {"1VlIdrj3fRAASVh0IRQbA", "AKXoeI10d8PJONEXEmQHjWIEkAB2E", "HfXt1ktTFXNYFvURT1ePpe", "VNbNAjzqH3UXN3t9RrTP5z6I5Qa6gPQJ", "DeawL9PzUIlDumNdtXISYTaSpfy6P3Cj", "KNbO6MhxkLbBAZAqlm1H7U8Ouut8mEhI", "i536pd2CEb7n0lc", "TelURl5RBqiFivFSJRRvco6RCKborqoX"};
    public static final String A0C;
    public InterfaceC04920v A00;
    public C1535cq A01;
    public C0803Dr A02;
    @Nullable
    public JT A03;
    @Nullable
    @DoNotStrip
    public InterfaceC1048Nn A04;
    @Nullable
    public C1166Sd A05;
    public String A06;
    public boolean A07 = false;
    public boolean A08 = false;
    public boolean A09 = false;

    public static String A05(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 19);
            if (A0B[2].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[3] = "viF0h1063r6cbXDqGfnWrC6qPBVBGzAv";
            strArr[7] = "3ywSXssJKLxMazlfVUMLvW6ymO505mlb";
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0A = new byte[]{-11, -26, -7, -11, -80, -23, -11, -18, -19, -23, -24, -38, -95, -84};
    }

    static {
        A07();
        A0C = C1546d1.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        if (this.A00 != null && this.A07 && (this.A08 || !this.A09)) {
            this.A00.AA1(this, this.A05);
        }
        this.A02.A0D().A3V(this.A00 != null);
        if (A0B[2].length() == 29) {
            throw new RuntimeException();
        }
        A0B[2] = "DQYu3GBVfiN4Ml";
    }

    private void A09(AnonymousClass95 anonymousClass95, C05121p c05121p) {
        C1537cs A00 = C1537cs.A00(c05121p.A03());
        this.A06 = A00.A61();
        if (C04810j.A03(this.A02, A00, this.A03)) {
            this.A02.A0D().A3z();
            this.A00.AAx(this, K3.A00(AdErrorType.NO_FILL));
            return;
        }
        this.A04 = new FE(this, A00);
        this.A05 = new C1166Sd(this.A02, new WeakReference(this.A04), anonymousClass95.A04(), A61());
        this.A05.A0G(anonymousClass95.A07(), anonymousClass95.A08());
        C1547d2 c1547d2 = new C1547d2(this);
        C0803Dr c0803Dr = this.A02;
        JT jt = this.A03;
        C1166Sd c1166Sd = this.A05;
        this.A01 = new C1535cq(c0803Dr, jt, c1166Sd, c1166Sd.getViewabilityChecker(), c1547d2);
        this.A01.A08(A00);
        this.A05.loadDataWithBaseURL(C1051Nq.A01(AdInternalSettings.getUrlPrefix()), A00.A04(), A05(0, 9, 110), A05(9, 5, 97), null);
        this.A07 = true;
        A06();
    }

    public final void A0C(C0803Dr c0803Dr, JT jt, K8 k8, InterfaceC04920v interfaceC04920v, C05121p c05121p) {
        c0803Dr.A0D().A3U();
        this.A02 = c0803Dr;
        this.A03 = jt;
        this.A00 = interfaceC04920v;
        this.A09 = JD.A15(this.A02.getApplicationContext());
        A09(c05121p.A01(), c05121p);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04840n
    public final String A61() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04840n
    public final AdPlacementType A75() {
        return AdPlacementType.BANNER;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04840n
    public final void onDestroy() {
        this.A02.A0D().A3S(this.A05 != null);
        C1166Sd c1166Sd = this.A05;
        if (c1166Sd != null) {
            c1166Sd.destroy();
            this.A05 = null;
            this.A04 = null;
        }
    }
}
