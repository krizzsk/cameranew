package com.facebook.ads.redexgen.X;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ye  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1320Ye implements InterfaceC06356k {
    public static byte[] A01;
    public final /* synthetic */ YQ A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 84);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{123, -71, -72, -86, -111, -100};
    }

    public C1320Ye(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        strArr = this.A00.A06;
        if (strArr != null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                strArr2 = this.A00.A06;
                int i3 = strArr2.length;
                if (i2 < i3) {
                    strArr3 = this.A00.A06;
                    sb.append(strArr3[i2]);
                    strArr4 = this.A00.A06;
                    int i4 = strArr4.length;
                    if (i2 != i4 - 1) {
                        sb.append(A00(0, 1, 29));
                    }
                    i2++;
                } else {
                    AbstractC06506z signalValueTypeDef = this.A00.A08(AnonymousClass78.A08(sb.toString().getBytes(A00(1, 5, 16)), AnonymousClass77.A06));
                    return signalValueTypeDef;
                }
            }
        } else {
            return this.A00.A07(EnumC06466v.A07);
        }
    }
}
