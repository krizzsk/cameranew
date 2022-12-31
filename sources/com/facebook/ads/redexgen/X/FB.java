package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: assets/audience_network.dex */
public final class FB extends AbstractC1533co {
    public static byte[] A0E;
    public static String[] A0F = {"YJVWhBFSVFKs7NrWmWULGh", "0GvTyPfIpVaCupDTXIuhVv", "vKmpQ0k2zgunQxdAFsx7Wlk6dmYtSCUc", "dqRYVPDeGy45RCRFCWIUPRHRtp9NBigI", "NSweCua6lZ8ChPFZ3cKnaOBscLcsrWLc", "HenZyTRrHhMHTWT00jKprDJGPW9d4C4V", "lvvcgtkpn6JHhS0LrJ19j3FN0lJsZZOv", "GmBDkEWrzwPugE8SLtTHysECIxUFQGpg"};
    public long A00;
    public AnonymousClass12 A01;
    public AnonymousClass13 A02;
    public AnonymousClass16 A03;
    public XT A04;
    public C0937Jb A05;
    public EnumC0965Kd A06;
    @Nullable
    @DoNotStrip
    public C1072On A07;
    public String A08;
    @Nullable
    public String A09;
    public String A0A;
    public final String A0C = UUID.randomUUID().toString();
    public final AtomicBoolean A0D = new AtomicBoolean();
    public boolean A0B = false;

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A0E = new byte[]{56, 52, 54, 54, 48, 57, 48, 39, 58, 56, 48, 33, 48, 39, 10, 39, 58, 33, 52, 33, 60, 58, 59, 110, 97, 100, 104, 99, 121, 89, 98, 102, 104, 99, 7, 15, 14, 3, 11, 30, 3, 5, 4, 46, 11, 30, 11, 89, 69, 72, 74, 76, 68, 76, 71, 93, 96, 77, 12, 14, 25, 24, 25, 26, 21, 18, 25, 24, 51, 14, 21, 25, 18, 8, 29, 8, 21, 19, 18, 55, 25, 5, 85, 66, 86, 82, 66, 84, 83, 115, 78, 74, 66, 4, 19, 1, 23, 4, 18, 37, 19, 4, 0, 19, 4, 35, 36, 58, 104, Byte.MAX_VALUE, 109, 123, 104, 126, Byte.MAX_VALUE, 126, 76, 115, 126, Byte.MAX_VALUE, 117, 91, 126, 94, 123, 110, 123, 88, 111, 116, 126, 118, Byte.MAX_VALUE, 25, 14, 28, 10, 25, 15, 14, 15, 52, 29, 2, 15, 14, 4, 87, 81, 67, 106, 75, 86, 76, 81, 64, 124, 103, 96, 120, 124, 108, 64, 109, 83, 76, 64, 82, 113, 92, 85, 64};
    }

    static {
        A08();
    }

    private void A06() {
        C2M A00 = C2M.A00(this.A04);
        AnonymousClass13 anonymousClass13 = this.A02;
        A00.A06(anonymousClass13, anonymousClass13.A00());
    }

    private void A07() {
        if (this.A02 != null) {
            try {
                C2M.A00(this.A04).A05(this.A02);
            } catch (Exception unused) {
            }
        }
    }

    private void A09(Intent intent) {
        int i2 = super.A00;
        String A04 = A04(58, 24, 2);
        if (i2 != -1) {
            ContentResolver contentResolver = this.A04.getContentResolver();
            if (A0F[3].charAt(29) != 'i') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[7] = "ryaiaZaF8EzuUPZd67FeoIG9jUALGHZG";
            strArr[6] = "XITZtpYy2wf6QHmOozCOnY6Xlkm3ca51";
            if (Settings.System.getInt(contentResolver, A04(1, 22, 43), 0) != 1) {
                int i3 = super.A00;
                if (A0F[2].charAt(2) != 'm') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0F;
                strArr2[1] = "mo2n49jFbf8CHvb7nubztA";
                strArr2[0] = "3h0LYrxRFByrgEG7Z48zJG";
                intent.putExtra(A04, i3);
                return;
            }
        }
        if (!JD.A0e(this.A04)) {
            intent.putExtra(A04, 6);
        }
    }

    private void A0A(boolean z) {
        if (this.A06 == EnumC0965Kd.A0B) {
            A0C(z);
            return;
        }
        EnumC0965Kd enumC0965Kd = this.A06;
        String[] strArr = A0F;
        if (strArr[1].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0F;
        strArr2[4] = "1yOiFacRiwJanRzqDJ6A5hJ77lYfziAe";
        strArr2[5] = "McEelBumOV7dKb1zb6BdvUT5HG6VvrgI";
        if (enumC0965Kd == EnumC0965Kd.A0A) {
            A0B(z);
        } else {
            A0C(z);
        }
    }

    private void A0B(boolean z) {
        C7J c7j = new C7J(this.A04);
        boolean z2 = JD.A1N(this.A04) && C5V.A0A(this.A03.A0Y());
        if (z2) {
            C5V c5v = new C5V(c7j, this.A03.A0Y(), this.A03.A0U(), this.A03.A0V(), z2, new C1539cu(this));
            C0937Jb funnelLoggingHandler = new C0937Jb(this.A03.A0Q(), this.A04.A08());
            c7j.A0b(funnelLoggingHandler);
            c5v.A0B();
            return;
        }
        C05081l.A02(this.A04, this.A03, z, new C1538ct(this));
    }

    private void A0C(boolean isUnifiedAssetsLoaderEnabled) {
        C7J c7j = new C7J(this.A04);
        c7j.A0b(this.A05);
        boolean z = JD.A1N(this.A04) && C5V.A0A(this.A03.A0Y());
        boolean A0l = this.A03.A0l();
        if (z) {
            new C5V(c7j, this.A03.A0Y(), this.A03.A0U(), this.A03.A0V(), z, new C1541cw(this, A0l)).A0B();
            return;
        }
        C1524cf c1524cf = (C1524cf) this.A03;
        if (!c1524cf.A0m()) {
            if (TextUtils.isEmpty(c1524cf.A0K().A0D().A08())) {
                this.A01.AC0(this, AdError.INTERNAL_ERROR);
                return;
            }
            C05091m.A02(this.A04, c7j, c1524cf);
        }
        c7j.A0U(new FC(this, isUnifiedAssetsLoaderEnabled, A0l, c1524cf, this), new C7C(c1524cf.A0V(), A04(133, 14, 21)));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1533co
    public final int A0D() {
        AnonymousClass16 anonymousClass16 = this.A03;
        if (anonymousClass16 == null) {
            String[] strArr = A0F;
            if (strArr[4].charAt(5) != strArr[5].charAt(5)) {
                A0F[3] = "zy8kAWNFspHhc9OUOOhBHMIK4AaCMilm";
                return -1;
            }
            throw new RuntimeException();
        }
        return anonymousClass16.A0H();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1533co
    public final AnonymousClass16 A0E() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1533co
    public final boolean A0F() {
        if (!this.A0D.get()) {
            return false;
        }
        String A03 = PV.A03(super.A01, this.A0C, this.A08);
        this.A03.A0a(super.A01);
        this.A03.A0e(A03);
        AdActivityIntent A04 = L9.A04(this.A04);
        A04.putExtra(A04(164, 8, 91), this.A06);
        A04.putExtra(A04(108, 25, 100), this.A03);
        A04.putExtra(A04(156, 8, 119), this.A0C);
        if (A03 != null) {
            A04.putExtra(A04(93, 15, 8), A03);
        }
        A04.putExtra(A04(47, 11, 87), this.A0A);
        A04.putExtra(A04(147, 9, 91), this.A0B);
        A04.putExtra(A04(82, 11, 89), this.A00);
        String str = this.A09;
        if (str != null) {
            A04.putExtra(A04(34, 13, 20), str);
        }
        A09(A04);
        A04.setFlags(A04.getFlags() | PGImageSDK.SDK_STATUS_CREATE);
        A04.putExtra(A04(23, 11, 115), this.A03.A0Q());
        ActivityUtils.A03(this.A04);
        L9.A09(this.A04, A04);
        return true;
    }

    public final void A0G(XT xt, AnonymousClass12 anonymousClass12, C05121p c05121p, boolean z, @Nullable String str, @Nullable String str2) {
        this.A0D.set(false);
        this.A04 = xt;
        this.A01 = anonymousClass12;
        this.A0B = C05101n.A02(str);
        this.A0A = c05121p.A02();
        this.A00 = c05121p.A00();
        this.A09 = str2;
        String str3 = this.A0A;
        this.A08 = str3 != null ? str3.split(A04(0, 1, 25))[0] : A04(0, 0, 20);
        this.A03 = C1524cf.A02(c05121p.A03(), this.A04);
        this.A03.A0g(c05121p.A01().A0F());
        this.A03.A0c(str);
        this.A03.A0Z(c05121p.A01().A06());
        this.A05 = new C0937Jb(this.A03.A0Q(), xt.A08());
        if (this.A03.A0l()) {
            this.A06 = this.A03.A0m() ? EnumC0965Kd.A0C : EnumC0965Kd.A04;
            if (this.A03.A0j()) {
                this.A04.A0D().AEX(EnumC04740c.A04);
            } else {
                this.A04.A0D().AEX(EnumC04740c.A06);
            }
        } else {
            int A0G = this.A03.A0G();
            if (A0G == 0) {
                this.A06 = EnumC0965Kd.A0B;
                this.A04.A0D().AEX(EnumC04740c.A09);
            } else if (A0G == 1) {
                this.A06 = EnumC0965Kd.A0A;
                this.A04.A0D().AEX(EnumC04740c.A08);
            }
        }
        this.A02 = new AnonymousClass13(this.A0C, this, anonymousClass12);
        A06();
        if (this.A03.A0m()) {
            this.A03.A0h(new MO(this.A04).A06());
        }
        AnonymousClass16 anonymousClass16 = this.A03;
        String[] strArr = A0F;
        if (strArr[4].charAt(5) == strArr[5].charAt(5)) {
            throw new RuntimeException();
        }
        A0F[2] = "Eum2kzY1KsvV3iHB7OkWnIxnMBSPWXGg";
        if (anonymousClass16.A0n()) {
            this.A0D.set(true);
            this.A01.ABx(this);
            return;
        }
        A0A(z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04840n
    public final String A61() {
        return this.A03.A0Q();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04840n
    public final void onDestroy() {
        A07();
    }
}
