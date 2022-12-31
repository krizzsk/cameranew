package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Arrays;
import java.util.EnumSet;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.1b  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04981b {
    public static byte[] A05;
    public static String[] A06 = {"jJreqFAWfQsm2UlBXjWleQZy51A8w9r3", "B5vxrqY9e1pfFDILbPSJEQZe5Zep9JAF", "7hwRhDIA2xM98ucsNVPICP0872", "8yYdfjKxcW1uK5E8nS4F9bT", "cwoTvwLLOWGZrFwonmn2qn9xu", "wuc4L", "VoE60CbUCih", "1JGxuEjawtyxaKItdz1AQ1lnM"};
    @Nullable
    public C7J A00;
    public EnumC1056Nv A01 = EnumC1056Nv.A06;
    @Nullable
    @DoNotStrip
    public C1072On A02;
    public final C1528cj A03;
    public final InterfaceC04971a A04;

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 96);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A05 = new byte[]{-97, -39, -27, -34, -35, -81, -44, -38, -53, -40, -44, -57, -46, -122, -85, -40, -40, -43, -40, -122, -104, -106, -106, -100, -122, -35, -49, -38, -50, -43, -37, -38, -122, -57, -122, -36, -57, -46, -49, -54, -122, -89, -54, -81, -44, -52, -43, -108, 31, 34, 29, 34, 31, 50, 31, 29, 32, 51, 44, 34, 42, 35, -45, -30, -37, -53, -48, -42, -57, -44, -43, -42, -53, -42, -53, -61, -50};
    }

    static {
        A07();
    }

    public C04981b(XT xt, C05121p c05121p, InterfaceC04971a interfaceC04971a, @Nullable String str) {
        this.A03 = A02(xt, c05121p, str, c05121p.A03());
        this.A04 = interfaceC04971a;
    }

    @Nullable
    private AdError A00(XT xt) {
        if (this.A03.A0X().isEmpty()) {
            xt.A06().A8q(A06(62, 3, 18), C06808m.A0R, new C06818n(A06(5, 43, 6)));
            return AdError.internalError(AdError.INTERNAL_ERROR_2006);
        }
        return null;
    }

    public static C1528cj A02(XT xt, C05121p c05121p, @Nullable String str, JSONObject jSONObject) {
        C1528cj adDataBundle = C1528cj.A02(jSONObject, xt);
        adDataBundle.A0c(str);
        AnonymousClass95 A01 = c05121p.A01();
        if (A01 != null) {
            adDataBundle.A0Z(A01.A06());
        }
        return adDataBundle;
    }

    private C7J A04(XT xt) {
        C7J c7j = this.A00;
        return c7j != null ? c7j : new C7J(xt);
    }

    private void A08(XT xt) {
        C1U A062 = this.A03.A0K().A0D().A06();
        A0A(A062 != null ? A062.A0A() : EnumC1056Nv.A06);
        C1519ca c1519ca = new C1519ca(this);
        C7J c7j = new C7J(xt);
        boolean z = JD.A1N(xt) && C5V.A0A(this.A03.A0Y());
        String[] strArr = A06;
        if (strArr[7].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[6] = "rsw451NGt86";
        strArr2[2] = "Yd4DtCWl7E1Fg10XBidxjBNo2K";
        if (z) {
            C5V c5v = new C5V(c7j, this.A03.A0Y(), this.A03.A0U(), this.A03.A0V(), z, new C1518cZ(this));
            C0937Jb funnelLoggingHandler = new C0937Jb(this.A03.A0Q(), xt.A08());
            c7j.A0b(funnelLoggingHandler);
            c5v.A0B();
            return;
        }
        C1528cj c1528cj = this.A03;
        String[] strArr3 = A06;
        if (strArr3[1].charAt(24) != strArr3[0].charAt(24)) {
            C05081l.A02(xt, c1528cj, true, c1519ca);
            return;
        }
        String[] strArr4 = A06;
        strArr4[6] = "NvwaqOE8NtZ";
        strArr4[2] = "Mi75BUZiVIPk9FHJPOQQgiG4jh";
        C05081l.A02(xt, c1528cj, true, c1519ca);
    }

    /* JADX WARN: Incorrect condition in loop: B:15:0x00c9 */
    /* JADX WARN: Incorrect condition in loop: B:21:0x0112 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A09(com.facebook.ads.redexgen.X.XT r21, java.util.EnumSet<com.facebook.ads.CacheFlag> r22) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C04981b.A09(com.facebook.ads.redexgen.X.XT, java.util.EnumSet):void");
    }

    private void A0A(EnumC1056Nv enumC1056Nv) {
        this.A01 = enumC1056Nv;
    }

    public final AnonymousClass16 A0B() {
        return this.A03;
    }

    public final EnumC0965Kd A0C() {
        if (this.A03.A0l()) {
            return EnumC0965Kd.A03;
        }
        int size = this.A03.A0X().size();
        String[] strArr = A06;
        if (strArr[6].length() != strArr[2].length()) {
            A06[3] = "f4kXngrP8CD5dz";
            if (size > 1) {
                return EnumC0965Kd.A06;
            }
            if (this.A03.A0K().A0D().A06() != null) {
                EnumC0965Kd enumC0965Kd = EnumC0965Kd.A08;
                String[] strArr2 = A06;
                if (strArr2[7].length() == strArr2[4].length()) {
                    A06[3] = "ny";
                    return enumC0965Kd;
                }
            } else if (A0I()) {
                EnumC0965Kd enumC0965Kd2 = EnumC0965Kd.A09;
                String[] strArr3 = A06;
                if (strArr3[6].length() != strArr3[2].length()) {
                    A06[3] = "JH";
                    return enumC0965Kd2;
                }
                throw new RuntimeException();
            } else {
                EnumC0965Kd enumC0965Kd3 = EnumC0965Kd.A07;
                if (A06[3].length() == 32) {
                    A06[3] = "ySAy4b6nQ";
                    return enumC0965Kd3;
                }
                String[] strArr4 = A06;
                strArr4[1] = "93R6MUXHMTxUt8WfLt1oZ3ea5zubl3sl";
                strArr4[0] = "9xXPI1nVQC4CSUB4soKlPH985bh9DAt9";
                return enumC0965Kd3;
            }
        }
        throw new RuntimeException();
    }

    public final EnumC1056Nv A0D() {
        return this.A01;
    }

    public final String A0E() {
        return this.A03.A0Q();
    }

    public final void A0F() {
        this.A04.AF5();
    }

    public final void A0G(Intent intent, RewardData rewardData, String str) {
        this.A03.A0a(rewardData);
        this.A03.A0e(str);
        intent.putExtra(A06(48, 14, 94), this.A03);
    }

    public final void A0H(XT xt, EnumSet<CacheFlag> enumSet) {
        AdError A00 = A00(xt);
        if (A00 != null) {
            this.A04.A9i(A00);
            return;
        }
        this.A04.ADP();
        if (A0C() == EnumC0965Kd.A08) {
            A08(xt);
        } else {
            A09(xt, enumSet);
        }
    }

    public final boolean A0I() {
        return !TextUtils.isEmpty(this.A03.A0K().A0D().A08());
    }

    public final boolean A0J() {
        return this.A03.A0j();
    }
}
