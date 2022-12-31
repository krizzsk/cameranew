package com.facebook.ads.redexgen.X;

import android.content.pm.ServiceInfo;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Yh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1323Yh implements InterfaceC06356k {
    public static byte[] A01;
    public static String[] A02 = {"Wdahz1Wjl3dMmMcpJsybmGRAeciA4tMI", "owhKI", "oRwt0jb9EEblUBuGQWVNL6ozc0Rzi0vw", "l56im1aaEdwcDHM5hLD8b", "Eu2PxKSDFU9lAkWHn67wF6yqVh6mLTIL", "0Vvrgp6tuvzAmenwYfecbhGxQfkK1YW3", "HQi", "vUie1Te"};
    public final /* synthetic */ YQ A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 30);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{18, 121, 120, 106, 1, 20};
    }

    static {
        A01();
    }

    public C1323Yh(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ServiceInfo[] serviceInfoArr;
        ServiceInfo[] serviceInfoArr2;
        ServiceInfo[] serviceInfoArr3;
        ServiceInfo[] serviceInfoArr4;
        serviceInfoArr = this.A00.A05;
        if (serviceInfoArr != null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                serviceInfoArr2 = this.A00.A05;
                int i3 = serviceInfoArr2.length;
                if (i2 < i3) {
                    serviceInfoArr3 = this.A00.A05;
                    sb.append(serviceInfoArr3[i2].name);
                    serviceInfoArr4 = this.A00.A05;
                    int i4 = serviceInfoArr4.length;
                    if (i2 != i4 - 1) {
                        sb.append(A00(0, 1, 6));
                    }
                    i2++;
                } else {
                    AbstractC06506z signalValueTypeDef = this.A00.A08(AnonymousClass78.A08(sb.toString().getBytes(A00(1, 5, 50)), AnonymousClass77.A06));
                    return signalValueTypeDef;
                }
            }
        } else {
            AbstractC06506z A07 = this.A00.A07(EnumC06466v.A07);
            String[] strArr = A02;
            if (strArr[5].charAt(15) != strArr[0].charAt(15)) {
                String[] strArr2 = A02;
                strArr2[2] = "PIV5HCfMNdAm4GWeouxefmFP0XOPfsYa";
                strArr2[4] = "Fq26Ssz9KPDLteFZDGni0zECOafhdUl8";
                return A07;
            }
            throw new RuntimeException();
        }
    }
}
