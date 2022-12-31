package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import java.util.Arrays;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class O1 {
    public static byte[] A09;
    @Nullable
    public O0 A00;
    public boolean A01;
    public boolean A02;
    public final XT A03;
    public final JT A04;
    public final C1009Lz A05;
    public final MU A06;
    public final QZ A07;
    public final String A08;

    static {
        A02();
    }

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 104);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A09 = new byte[]{31, 8, 29, 30, 41, 40, 40, 51, 50, 31, 48, 53, 63, 55, 16, 53, 47, 40, 57, 50, 57, 46, 114, 69, 69, 88, 69, 23, 82, 79, 82, 84, 66, 67, 94, 89, 80, 23, 86, 84, 67, 94, 88, 89, 73, 126, 126, 99, 126, 44, 123, 100, 101, 96, 105, 44, 99, 124, 105, 98, 101, 98, 107, 44};
    }

    public O1(XT xt, String str, QZ qz, C1009Lz c1009Lz, JT jt) {
        this.A01 = true;
        this.A03 = xt;
        this.A08 = str;
        this.A07 = qz;
        this.A05 = c1009Lz;
        this.A04 = jt;
        this.A06 = new C1163Sa(this);
    }

    public O1(XT xt, String str, QZ qz, C1009Lz c1009Lz, JT jt, MU mu) {
        this.A01 = true;
        this.A03 = xt;
        this.A08 = str;
        this.A07 = qz;
        this.A05 = c1009Lz;
        this.A04 = jt;
        this.A06 = mu;
    }

    public static void A03(XT xt, @Nullable QZ qz, C1009Lz c1009Lz, JT jt, C1J c1j, String str) {
        AbstractC04770f A01 = C04780g.A01(xt, jt, str, Uri.parse(c1j.A05()), new C1055Nu().A03(qz).A02(c1009Lz).A05(), false, false);
        if (A01 != null) {
            A01.A09();
        }
    }

    private void A05(String str, String str2, Map<String, String> map) {
        this.A04.A9E(str, map);
        LX.A00(new DialogInterface$OnClickListenerC1059Ny(this, map, str, str2), new DialogInterface$OnClickListenerC1060Nz(this, str, map), ActivityUtils.A00());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(String str, String str2, Map<String, String> map) {
        String A01 = A01(0, 22, 52);
        try {
            AbstractC04770f A012 = C04780g.A01(this.A03, this.A04, str, Uri.parse(str2), new C1055Nu(map).A03(this.A07).A02(this.A05).A05(), this.A01, this.A02);
            if (A012 != null) {
                A012.A0B();
            }
            if (this.A00 != null) {
                this.A00.AAF();
            }
            this.A06.A3q(this.A08);
        } catch (ActivityNotFoundException e2) {
            Log.e(A01, A01(44, 20, 100) + str2, e2);
        } catch (Exception e3) {
            Log.e(A01, A01(22, 22, 95), e3);
        }
    }

    public final void A07(O0 o0) {
        this.A00 = o0;
    }

    public final void A08(String str, String str2, Map<String, String> map) {
        new C0937Jb(str, this.A04).A02(EnumC0936Ja.A0J, null);
        if (this.A05.A09(this.A03)) {
            this.A04.A8m(str, map);
        } else if (JD.A12(this.A03)) {
            A05(str, str2, map);
        } else {
            A06(str, str2, map);
        }
    }

    public final void A09(boolean z) {
        this.A02 = z;
    }

    public final void A0A(boolean z) {
        this.A01 = z;
    }
}
