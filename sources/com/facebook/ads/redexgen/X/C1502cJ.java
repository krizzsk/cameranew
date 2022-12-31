package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.cJ  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1502cJ implements InterfaceC05171u {
    public static byte[] A04;
    public static String[] A05 = {"iEaWyjzULIZCFnp1nESlU5XZjwcvRjHd", "KbGYZiX8Pduw0KfpYwrRe1NWFWC1OMxy", "fhu9engps4P6WEn4zln6smGq5lQXex4h", "tbT6PfDqIL055", "rKa5gX4b0", "TAsNWcfBygYGmj6nueBPL3we7Mc4FYi0", "mn5595Nd0", "gAb4cPpeQcskkpTdmUE6rt9G8rZq3FNo"};
    public EnumC05161t A00 = EnumC05161t.A03;
    public EnumC05161t A01 = EnumC05161t.A03;
    public final AbstractC1500cG A02;
    public final XT A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A05;
            if (strArr[7].charAt(1) != strArr[5].charAt(1)) {
                throw new RuntimeException();
            }
            A05[0] = "d2XCtNqKB2PlkmIVLWNasBjUSsZJOiBr";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 29);
            i5++;
        }
    }

    public static void A01() {
        A04 = new byte[]{-73, 11, 6, -73, 118, 104, -95, -73, -67, 104, -85, -87, -74, 104, -85, -80, -87, -74, -81, -83, 104, -111, -74, -68, -83, -81, -70, -87, -68, -79, -73, -74, 104, -115, -70, -70, -73, -70, 104, -75, -73, -84, -83, 104, -86, -63, 104, -69, -83, -68, -68, -79, -74, -81, 104, -119, -84, -101, -83, -68, -68, -79, -74, -81, -69, 118, -69, -83, -68, -111, -74, -68, -83, -81, -70, -87, -68, -79, -73, -74, -115, -70, -70, -73, -70, -107, -73, -84, -83, 112, 113, 112, 108, 107, -97, -114, -109, -113, -104, -115, -113, 120, -113, -98, -95, -103, -100, -107, -103, -59, -62, -64, 115, -41, -14, -17, -18, -25, -96, -23, -18, -12, -27, -14, -18, -31, -20, -96, -12, -14, -31, -18, -13, -23, -12, -23, -17, -18, -82, -15, 0, -7, -67, -64, -78, -75, 121, 122, -63, -74, -67, -59, 118, 119, 15, 3, -4, 15, -69, 4, 14, -69, -4, 7, Draft_75.CR, 0, -4, -1, 20, -69, -25, -22, -36, -33, -28, -23, -30, -57, -69, -25, -22, -36, -33, -32, -33, -69, 10, Draft_75.CR, -69, -18, -29, -22, -14, -28, -23, -30, -45, -57, -64, -45, Byte.MAX_VALUE, -56, -46, Byte.MAX_VALUE, -64, -53, -47, -60, -64, -61, -40, Byte.MAX_VALUE, -78, -89, -82, -74, -88, -83, -90, -14, -26, -33, -14, -98, -25, -15, -98, -20, -19, -14, -98, -54, -51, -65, -62, -61, -62};
    }

    static {
        A01();
    }

    public C1502cJ(XT xt, AbstractC1500cG abstractC1500cG) {
        this.A03 = xt;
        this.A02 = abstractC1500cG;
    }

    private void A02(EnumC05161t enumC05161t, EnumC05161t enumC05161t2) {
        String A00 = A00(113, 26, 99);
        String str = A00(108, 5, 54) + enumC05161t + A00(0, 4, 122) + enumC05161t2;
        this.A03.A06().A8q(A00(139, 3, 115), C06808m.A0W, new C06818n(A00, str));
        this.A03.A0D().AFZ(A00 + ' ' + str);
    }

    private void A03(String str, String str2, boolean z) {
        AdSettings.IntegrationErrorMode A00 = C05131q.A00(this.A03);
        String format = String.format(Locale.US, AdErrorType.INCORRECT_API_CALL_ERROR.getDefaultErrorMessage(), str, str2);
        String A002 = A00(139, 3, 115);
        String A003 = A00(91, 17, 13);
        if (!z) {
            Log.e(A003, format);
            this.A03.A06().A8q(A002, C06808m.A0U, new C06818n(format));
            this.A03.A0D().AFY(format);
            return;
        }
        int i2 = C05151s.A00[A00.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                this.A02.A05();
                this.A02.A06(10, AdErrorType.INCORRECT_STATE_ERROR, format);
                this.A03.A0D().AFY(format);
                Log.e(A003, format);
                this.A03.A06().A8q(A002, C06808m.A0U, new C06818n(format));
            }
            Log.e(A003, format);
            return;
        }
        throw new C05181v(format + A00(4, 87, 43));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05171u
    public final boolean A5H() {
        boolean z = (this.A00 == EnumC05161t.A03 || this.A00 == EnumC05161t.A05) && this.A01 != EnumC05161t.A08;
        if (z) {
            this.A00 = EnumC05161t.A07;
        } else {
            A03(A00(142, 6, 52), A00(154, 42, 126), false);
        }
        return !z;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05171u
    public final boolean A5I() {
        boolean z = this.A00 == EnumC05161t.A06 && (this.A01 != EnumC05161t.A08 || JD.A0f(this.A03));
        if (z) {
            this.A00 = EnumC05161t.A03;
            this.A01 = EnumC05161t.A08;
        } else {
            EnumC05161t enumC05161t = this.A00;
            EnumC05161t enumC05161t2 = EnumC05161t.A06;
            String A00 = A00(148, 6, 49);
            if (enumC05161t != enumC05161t2) {
                A03(A00, A00(219, 18, 97), true);
            } else {
                A03(A00, A00(196, 23, 66), false);
            }
        }
        return !z;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05171u
    public final EnumC05161t A5a() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05171u
    public final void AEJ(EnumC05161t enumC05161t) {
        this.A00 = enumC05161t;
        this.A01 = enumC05161t;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05171u
    public final void AEM(AdError adError) {
        this.A00 = EnumC05161t.A05;
        this.A01 = EnumC05161t.A05;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05171u
    public final void AEQ() {
        if (this.A00 != EnumC05161t.A07) {
            A02(this.A00, EnumC05161t.A06);
        }
        this.A00 = EnumC05161t.A06;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05171u
    public final void AEW() {
        if (this.A01 != EnumC05161t.A08) {
            A02(this.A00, EnumC05161t.A09);
        }
        this.A01 = EnumC05161t.A09;
    }
}
