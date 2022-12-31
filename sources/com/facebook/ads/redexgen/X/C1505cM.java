package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.cM  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1505cM implements KW {
    public static byte[] A0E;
    public static String[] A0F = {"Um", "5O6Pi5UhekEiJBNtL2", "ByBiFstlzS", "VNZICTTmM6bBZ", "I3ykA2cHAONkN", "xnUs6VMzToWHuFoC", "Qkjm3fg24P6DD7pmZ7L4neN1zLjqdukp", "LFB8Dcv49A6aPeUL"};
    public InterfaceC05141r A00;
    public AnonymousClass94 A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final Handler A05;
    @Nullable
    public final AdSize A06;
    public final C04890s A07;
    public final XT A08;
    public final JT A09;
    public final K9 A0A;
    public final KX A0B;
    public final Runnable A0C;
    public final String A0D;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0F[2].length() != 10) {
                throw new RuntimeException();
            }
            A0F[1] = "uoxYJqIRleds8fPMMv";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 87);
            i5++;
        }
    }

    public static void A05() {
        byte[] bArr = {64, 65, -14, 66, 62, 51, 53, 55, 63, 55, 64, 70, -14, 59, 64, -14, 68, 55, 69, 66, 65, 64, 69, 55};
        if (A0F[0].length() != 2) {
            throw new RuntimeException();
        }
        A0F[1] = "dKV76OJFyRmVPWeRzZ";
        A0E = bArr;
    }

    static {
        A05();
        M7.A02();
    }

    public C1505cM(XT xt, String str, K9 k9, @Nullable AdSize adSize, int i2) {
        this.A08 = xt;
        this.A0D = str;
        this.A0A = k9;
        this.A06 = adSize;
        this.A04 = i2;
        this.A0B = new KX(this.A08);
        this.A0B.A0O(this);
        this.A07 = new C04890s();
        this.A03 = true;
        this.A05 = new Handler();
        this.A0C = new F5(this);
        this.A09 = xt.A08();
        DynamicLoaderFactory.makeLoader(this.A08).getInitApi().onAdLoadInvoked(this.A08);
    }

    private List<C1543cy> A04() {
        AnonymousClass94 anonymousClass94 = this.A01;
        ArrayList arrayList = new ArrayList(anonymousClass94.A02());
        for (AnonymousClass92 A04 = anonymousClass94.A04(); A04 != null; A04 = anonymousClass94.A04()) {
            InterfaceC04840n A00 = this.A07.A00(AdPlacementType.NATIVE);
            if (A00 != null && A00.A75() == AdPlacementType.NATIVE) {
                C05121p loadConfig = new C05121p(A04.A04(), anonymousClass94.A05(), this.A0D, anonymousClass94.A05().A0C());
                C1543cy c1543cy = (C1543cy) A00;
                c1543cy.A0Z(this.A08, new C1506cN(this, arrayList, c1543cy), this.A09, loadConfig, C1198Tj.A0I());
            }
        }
        return arrayList;
    }

    public final void A06() {
        this.A03 = false;
        this.A05.removeCallbacks(this.A0C);
    }

    public final void A07() {
        try {
            KE ke = new KE(this.A08, null, null, null);
            XT xt = this.A08;
            String str = this.A0D;
            AdSize adSize = this.A06;
            this.A0B.A0N(new KU(xt, str, adSize != null ? new C0993Lj(adSize.getHeight(), this.A06.getWidth()) : null, this.A0A, null, this.A04, AdSettings.isTestMode(this.A08), AdSettings.isMixedAudience(), ke, C0999Lp.A01(JD.A0H(this.A08)), this.A02, null));
        } catch (K4 e2) {
            AAW(K3.A02(e2));
        }
    }

    public final void A08(InterfaceC05141r interfaceC05141r) {
        this.A00 = interfaceC05141r;
    }

    public final void A09(String str) {
        this.A02 = str;
    }

    public final boolean A0A() {
        AnonymousClass94 anonymousClass94 = this.A01;
        return anonymousClass94 == null || anonymousClass94.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.KW
    public final void AAW(K3 k3) {
        if (this.A03) {
            this.A05.postDelayed(this.A0C, TapjoyConstants.SESSION_ID_INACTIVITY_TIME);
        }
        InterfaceC05141r interfaceC05141r = this.A00;
        if (A0F[2].length() != 10) {
            throw new RuntimeException();
        }
        A0F[2] = "yGn7NPCZVX";
        if (interfaceC05141r != null) {
            interfaceC05141r.AAW(k3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.KW
    public final void ACC(TW tw) {
        AnonymousClass94 A00 = tw.A00();
        if (A00 != null) {
            if (this.A03) {
                long A0A = A00.A05().A0A();
                if (A0A == 0) {
                    A0A = TapjoyConstants.SESSION_ID_INACTIVITY_TIME;
                }
                this.A05.postDelayed(this.A0C, A0A);
            }
            this.A01 = A00;
            List<C1543cy> A04 = A04();
            if (this.A00 != null) {
                if (A04.isEmpty()) {
                    this.A00.AAW(K3.A01(AdErrorType.NO_FILL, A03(0, 0, 68)));
                    return;
                } else {
                    this.A00.ABO(A04);
                    return;
                }
            }
            return;
        }
        throw new IllegalStateException(A03(0, 24, 123));
    }
}
