package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Sy  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1187Sy implements LR {
    public static byte[] A01;
    public static String[] A02 = {"XQ6pDaA1rZEM", "XoeGOYiSv0w2M1U1qXC2kK0WxpTFbq6C", "goNPtYs5sZFfNSJyOgs171oDuCl7t69H", "IBRmsKraW8ihcuaNuynFKjmRlH", "udOMyB", "k9bLdXox5SSCuqwZoRmzAy5kJm", "rLCACxpviKCtWgunDsmekf59Ef0kXw8R", "IiDilnQTvcIperbA6lCpmy3utrrmGEhT"};
    public final /* synthetic */ C1185Sw A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 68);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-32, -8, -22, -24, -8, -30};
    }

    static {
        A01();
    }

    public C1187Sy(C1185Sw c1185Sw) {
        this.A00 = c1185Sw;
    }

    public /* synthetic */ C1187Sy(C1185Sw c1185Sw, T3 t3) {
        this(c1185Sw);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    @Override // com.facebook.ads.redexgen.X.LR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AAB() {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.Sw r0 = r5.A00
            com.facebook.ads.redexgen.X.MT r3 = r0.A0V
            r2 = 0
            r1 = 0
            r0 = 7
            java.lang.String r0 = A00(r2, r1, r0)
            r3.setToolbarActionMessage(r0)
            com.facebook.ads.redexgen.X.Sw r0 = r5.A00
            com.facebook.ads.redexgen.X.C1185Sw.A0S(r0)
            com.facebook.ads.redexgen.X.Sw r0 = r5.A00
            boolean r0 = com.facebook.ads.redexgen.X.C1185Sw.A0b(r0)
            r3 = 0
            if (r0 == 0) goto L44
            com.facebook.ads.redexgen.X.Sw r0 = r5.A00
            boolean r0 = com.facebook.ads.redexgen.X.C1185Sw.A0g(r0)
            if (r0 == 0) goto L44
            com.facebook.ads.redexgen.X.Sw r0 = r5.A00
            com.facebook.ads.redexgen.X.MT r1 = r0.A0V
            r0 = 1
            r1.setToolbarActionMode(r0)
        L2c:
            com.facebook.ads.redexgen.X.Sw r0 = r5.A00
            boolean r4 = com.facebook.ads.redexgen.X.C1185Sw.A0f(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1187Sy.A02
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 6
            if (r1 == r0) goto L4c
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L44:
            com.facebook.ads.redexgen.X.Sw r0 = r5.A00
            com.facebook.ads.redexgen.X.MT r0 = r0.A0V
            r0.setToolbarActionMode(r3)
            goto L2c
        L4c:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1187Sy.A02
            java.lang.String r1 = "RNuzR8"
            r0 = 4
            r2[r0] = r1
            if (r4 != 0) goto L6d
            com.facebook.ads.redexgen.X.Sw r1 = r5.A00
            r0 = 500(0x1f4, float:7.0E-43)
            com.facebook.ads.redexgen.X.M5.A0U(r1, r0)
            com.facebook.ads.redexgen.X.Sw r0 = r5.A00
            com.facebook.ads.redexgen.X.SZ r0 = com.facebook.ads.redexgen.X.C1185Sw.A0A(r0)
            if (r0 == 0) goto L6d
            com.facebook.ads.redexgen.X.Sw r0 = r5.A00
            com.facebook.ads.redexgen.X.SZ r0 = com.facebook.ads.redexgen.X.C1185Sw.A0A(r0)
            com.facebook.ads.redexgen.X.M5.A0N(r0, r3)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1187Sy.AAB():void");
    }

    @Override // com.facebook.ads.redexgen.X.LR
    public final void ABj(float f2) {
        boolean z;
        C1U c1u;
        boolean z2;
        AnonymousClass16 anonymousClass16;
        float A03;
        AnonymousClass16 anonymousClass162;
        AnonymousClass16 anonymousClass163;
        boolean z3;
        AnonymousClass16 anonymousClass164;
        boolean z4;
        AnonymousClass16 anonymousClass165;
        this.A00.A0Q((int) f2);
        z = this.A00.A0U;
        if (!z) {
            c1u = this.A00.A0E;
            float percentage = 100.0f * (1.0f - (f2 / c1u.A07()));
            this.A00.A0V.setProgress(percentage);
            return;
        }
        z2 = this.A00.A09;
        if (z2) {
            anonymousClass164 = this.A00.A0D;
            A03 = 1.0f - (f2 / anonymousClass164.A0K().A0D().A02());
            z4 = this.A00.A0C;
            if (z4 || A03 < 1.0f) {
                this.A00.A0C = false;
                anonymousClass165 = this.A00.A0D;
                String A00 = anonymousClass165.A0O().A00();
                String[] strArr = A02;
                if (strArr[1].charAt(20) != strArr[6].charAt(20)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[0] = "16sMGD3KF8iI";
                strArr2[5] = "yItCOMUcMHVXea4ql8lykvs7qx";
                this.A00.A0V.setToolbarActionMessage(A00.replace(A00(0, 6, 65), String.valueOf((int) f2)));
            } else {
                this.A00.A0C = true;
                this.A00.A0V.setToolbarActionMessage(A00(0, 0, 7));
            }
        } else {
            anonymousClass16 = this.A00.A0D;
            A03 = 1.0f - (f2 / anonymousClass16.A0K().A0D().A03());
        }
        this.A00.A0V.setProgress(100.0f * A03);
        anonymousClass162 = this.A00.A0D;
        anonymousClass163 = this.A00.A0D;
        boolean z5 = ((float) anonymousClass162.A0K().A0D().A02()) - f2 >= ((float) anonymousClass163.A0K().A0D().A03());
        z3 = this.A00.A0C;
        if (!z3 && z5) {
            this.A00.A0V.setToolbarActionMode(1);
        }
    }
}
