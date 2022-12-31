package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Zs  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1360Zs implements InterfaceC06356k {
    public static byte[] A01;
    public static String[] A02 = {"dNr6PPQsY9l", "RH2U4Hh24YJB1CaC1uFo9RGIyJZKKzLP", "dQYGehnAuPol14EFpizMkTDsN0LYSx6h", "7Q5ZVjGu0JJTpQG9POYIlRIj1jnsmDo", "fVmoe7EJsPLcTdm", "gOyCjpHNXOG3DgRDYrCD", "Bt7utfgyfoKMrlpwfOIMwYj8ykKc", "iv3XcVN43HhJpxh2FG4KyUlJf74g4nGs"};
    public final /* synthetic */ C1350Zi A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 66);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {32, 31, 50, 50, 35, 48, 55, 29, 42, 45, 53};
        String[] strArr = A02;
        if (strArr[5].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        A02[7] = "zsr7uVrJNcFH7kX5XxLPdtK6eEcZRxEm";
        A01 = bArr;
    }

    static {
        A01();
    }

    public C1360Zs(C1350Zi c1350Zi) {
        this.A00 = c1350Zi;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        return this.A00.A0B(A00(0, 11, 124), false);
    }
}
