package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.util.Log;
import java.util.Arrays;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class FE extends AbstractC1169Sg {
    public static byte[] A02;
    public final /* synthetic */ C1546d1 A00;
    public final /* synthetic */ C1537cs A01;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 123);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{21, 34, 34, 63, 34, 112, 53, 40, 53, 51, 37, 36, 57, 62, 55, 112, 49, 51, 36, 57, 63, 62, 17, 21, 22, 19};
    }

    public FE(C1546d1 c1546d1, C1537cs c1537cs) {
        this.A00 = c1546d1;
        this.A01 = c1537cs;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1048Nn
    public final void A9r() {
        boolean z;
        this.A00.A08 = true;
        z = this.A00.A09;
        if (!z) {
            return;
        }
        this.A00.A06();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1169Sg, com.facebook.ads.redexgen.X.InterfaceC1048Nn
    public final void AA7(String str, Map<String, String> map) {
        C0803Dr c0803Dr;
        C0803Dr c0803Dr2;
        JT jt;
        String str2;
        C0803Dr c0803Dr3;
        InterfaceC04920v interfaceC04920v;
        InterfaceC04920v interfaceC04920v2;
        c0803Dr = this.A00.A02;
        c0803Dr.A0D().A3W();
        Uri parse = Uri.parse(str);
        if (A00(22, 4, 12).equals(parse.getScheme()) && C04780g.A04(parse.getAuthority())) {
            interfaceC04920v = this.A00.A00;
            if (interfaceC04920v != null) {
                interfaceC04920v2 = this.A00.A00;
                interfaceC04920v2.AA0(this.A00);
            }
        }
        c0803Dr2 = this.A00.A02;
        jt = this.A00.A03;
        AbstractC04770f A00 = C04780g.A00(c0803Dr2, jt, this.A01.A61(), parse, map);
        if (A00 == null) {
            return;
        }
        try {
            c0803Dr3 = this.A00.A02;
            c0803Dr3.A0D().A3T();
            A00.A0B();
        } catch (Exception e2) {
            str2 = C1546d1.A0C;
            Log.e(str2, A00(0, 22, 43), e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1169Sg, com.facebook.ads.redexgen.X.InterfaceC1048Nn
    public final void AAk() {
        C0803Dr c0803Dr;
        C1535cq c1535cq;
        C1535cq c1535cq2;
        C1535cq c1535cq3;
        c0803Dr = this.A00.A02;
        InterfaceC1560dF A0D = c0803Dr.A0D();
        c1535cq = this.A00.A01;
        A0D.A3X(c1535cq != null);
        c1535cq2 = this.A00.A01;
        if (c1535cq2 == null) {
            return;
        }
        c1535cq3 = this.A00.A01;
        c1535cq3.A02();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1169Sg, com.facebook.ads.redexgen.X.InterfaceC1048Nn
    public final void ABS() {
        C0803Dr c0803Dr;
        C1535cq c1535cq;
        c0803Dr = this.A00.A02;
        c0803Dr.A0D().A3Z();
        c1535cq = this.A00.A01;
        c1535cq.A07();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1048Nn
    public final void ACd() {
    }
}
