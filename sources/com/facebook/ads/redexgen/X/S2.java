package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.dynamiclayout.DynamicFullScreenAdView$AdFormatType;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class S2 implements MV, InterfaceC1082Ox {
    public static byte[] A06;
    public static String[] A07 = {"oiGCyLLJ3En0Vucm2lwQCmCmn0v6sJ5G", "mjDZ5bMhh2egn3gotl5Fak9vSR0Edani", "1hG9WDI3REfqDlfCDst9s2RoZGy9hyfa", "soGyy3NAn5Cor38t8b", "p7cBZk", "O0VCEzMFnvnMCBxUoY", "3U8Wd6", "kV1x0xBuSb6EFvzAtfCiFjMbzzjOwzOj"};
    @Nullable
    public AnonymousClass52 A00;
    public C06999f A01;
    public String A02;
    public final XT A03;
    public final MU A04;
    public final InterfaceC1031Mw A05;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 111);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{-25, -14, -3, -25, -1, -7, 43, 56, 41, 43, 45, 62, 51, 64, 51, 62, 67, 29, 27, 40, 29, 31, 38, 0, 12, 10, -53, 3, -2, 0, 2, -1, 12, 12, 8, -53, -2, 18, 1, 6, 2, 11, 0, 2, 11, 2, 17, 20, 12, 15, 8, -53, 15, 17, 3, -53, -34, 18, 1, 6, 2, 11, 0, 2, -21, 2, 17, 20, 12, 15, 8, -17, 2, 20, -2, 15, 1, 2, 1, -13, 6, 1, 2, 12, -34, 0, 17, 6, 19, 6, 17, 22, 45, 57, 55, -8, 48, 43, 45, 47, 44, 57, 57, 53, -8, 53, 43, 62, 43, 56, 43, 90, 46, 98, 81, 86, 82, 91, 80, 82, 59, 82, 97, 100, 92, 95, 88, 46, 80, 97, 86, 99, 86, 97, 102, Draft_75.CR, 86, 96, Draft_75.CR, 91, 98, 89, 89, 57, 56, 45, 47, -31, -35, -46, -44, -42, -34, -42, -33, -27, -70, -75, 53, 49, 38, 40, 42, 50, 42, 51, 57, 36, 46, 41};
    }

    static {
        A02();
    }

    public S2(XT xt, JT jt, MU mu, AnonymousClass16 anonymousClass16, InterfaceC1031Mw interfaceC1031Mw, @DynamicFullScreenAdView$AdFormatType int i2) {
        this.A03 = xt;
        this.A04 = mu;
        this.A05 = interfaceC1031Mw;
        this.A02 = anonymousClass16.A0Y().optString(A00(158, 12, 86));
        if (!anonymousClass16.A0n()) {
            this.A01 = new C06999f(xt, jt, mu, anonymousClass16, interfaceC1031Mw, i2);
            this.A01.setRtfActionsJavascriptListener(this);
            return;
        }
        this.A01 = null;
    }

    private void A01() {
        C06999f c06999f = this.A01;
        if (c06999f != null) {
            c06999f.close();
            return;
        }
        AnonymousClass52 anonymousClass52 = this.A00;
        if (anonymousClass52 != null) {
            anonymousClass52.finish(4);
            return;
        }
        this.A03.A06().A8q(A00(6, 11, 91), C06808m.A06, new C06818n(A00(111, 32, 126)));
        Activity A0C = this.A03.A0C();
        if (A0C == null) {
            return;
        }
        A0C.finish();
    }

    private boolean A03() {
        AnonymousClass52 anonymousClass52 = this.A00;
        String A00 = A00(6, 11, 91);
        if (anonymousClass52 != null && anonymousClass52.A0H() != null) {
            try {
                Intent intent = new Intent();
                intent.putExtra(A00(147, 11, 2), this.A02);
                intent.setClassName(A00(92, 19, 91), A00(23, 69, 46));
                this.A00.A0H().startActivityForResult(intent, 1001);
                this.A03.A0D().AE1();
                return true;
            } catch (ActivityNotFoundException e2) {
                this.A03.A0D().ADv();
                this.A03.A06().A8q(A00, C06808m.A0B, new C06818n(e2));
                return false;
            }
        }
        this.A03.A06().A8q(A00, C06808m.A06, new C06818n(A00(111, 32, 126)));
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1082Ox
    public final void A7t(String str) {
        MO mo = new MO(this.A03);
        String A00 = A00(143, 4, 91);
        boolean equals = A00.equals(str);
        String A002 = A00(0, 6, 23);
        if (!equals) {
            boolean equals2 = A002.equals(str);
            String[] strArr = A07;
            if (strArr[5].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[5] = "HXT1N9aUFCiTX8IjAD";
            strArr2[3] = "Hjw6INOHlWjDRzMVan";
            if (!equals2) {
                if (A00(17, 6, 75).equals(str)) {
                    mo.A03(str);
                    this.A03.A0D().ADw();
                    A01();
                    return;
                }
                A01();
                return;
            }
        }
        mo.A03(str);
        boolean equals3 = A00.equals(str);
        if (A07[1].charAt(31) != 'i') {
            throw new RuntimeException();
        }
        A07[0] = "ID97lvjCTklEU0mENKFZ0jCzQAEYbfvd";
        if (equals3) {
            XT xt = this.A03;
            String[] strArr3 = A07;
            if (strArr3[7].charAt(27) != strArr3[2].charAt(27)) {
                A07[1] = "BoqZ4wfC0SiK5tBsDvOnRbTPQI0SuSvi";
                xt.A0D().ADy();
            } else {
                xt.A0D().ADy();
            }
        } else if (A002.equals(str)) {
            this.A03.A0D().ADx();
        }
        if (!A03()) {
            A01();
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void A8e(Intent intent, @Nullable Bundle bundle, AnonymousClass52 anonymousClass52) {
        this.A00 = anonymousClass52;
        C06999f c06999f = this.A01;
        if (c06999f != null) {
            c06999f.A8e(intent, bundle, anonymousClass52);
        } else if (bundle == null && !A03()) {
            A01();
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABU(boolean z) {
        C06999f c06999f = this.A01;
        if (c06999f != null) {
            c06999f.ABU(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABt(boolean z) {
        C06999f c06999f = this.A01;
        if (c06999f != null) {
            c06999f.ABt(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void AE6(Bundle bundle) {
        if (this.A01 != null) {
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        String A7L;
        if (i2 == 1001) {
            KH kh = new KH(intent);
            if (kh.A03() == null) {
                new MO(this.A03).A04(String.valueOf(i3));
            } else {
                new MO(this.A03).A04(String.valueOf(kh.A03()));
                if (kh.A02() != null) {
                    MU mu = this.A04;
                    if (kh.A02().booleanValue()) {
                        A7L = this.A05.A7M();
                    } else {
                        A7L = this.A05.A7L();
                    }
                    mu.A3q(A7L);
                }
                if (kh.A04()) {
                    this.A04.A3q(this.A05.A5X());
                }
            }
            A01();
            return true;
        }
        C06999f c06999f = this.A01;
        if (c06999f != null) {
            return c06999f.onActivityResult(i2, i3, intent);
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void onDestroy() {
        C06999f c06999f = this.A01;
        if (c06999f != null) {
            c06999f.onDestroy();
        }
        this.A01 = null;
        this.A00 = null;
    }
}
