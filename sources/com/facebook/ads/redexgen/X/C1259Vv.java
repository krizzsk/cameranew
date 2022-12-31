package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Vv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1259Vv extends DL {
    public static byte[] A02;
    public static String[] A03 = {"RjYCDLb2NANzCnedRKoQM0GQ", "QX5lqyT5r1TYXy6sq6A", "sDmzmZu2Epi", "QleORMZQxcHxPLUcnR0aaEPVJ", "tBrVRsKa63H7cOEQm0uGMqa5cwtrVWSW", "PEwzIbtLaNn1pzRcppb", "zVqUyH", "ZIYCsXe3luBjtUiXTHmKPLmA"};
    public C1260Vw A00;
    public II A01;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 56);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{6, 18, 3, 14, 8, 72, 1, 11, 6, 4};
    }

    static {
        A03();
    }

    private int A00(IV iv) {
        int i2 = (iv.A00[2] & Draft_75.END_OF_FRAME) >> 4;
        switch (i2) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i2 - 2);
            case 6:
            case 7:
                iv.A0Z(4);
                iv.A0O();
                int A0E = i2 == 6 ? iv.A0E() : iv.A0I();
                iv.A0Y(0);
                return A0E + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i2 - 8);
            default:
                return -1;
        }
    }

    public static boolean A04(IV iv) {
        return iv.A04() >= 5 && iv.A0E() == 127 && iv.A0M() == 1179402563;
    }

    public static boolean A05(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.facebook.ads.redexgen.X.DL
    public final long A07(IV iv) {
        if (!A05(iv.A00)) {
            return -1L;
        }
        int A00 = A00(iv);
        String[] strArr = A03;
        if (strArr[2].length() != strArr[0].length()) {
            String[] strArr2 = A03;
            strArr2[2] = "M0DKrSciZtY";
            strArr2[0] = "bwyyvFLni8GVBC8P6VU38e20";
            return A00;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.DL
    public final void A09(boolean z) {
        super.A09(z);
        if (z) {
            this.A01 = null;
            this.A00 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DL
    public final boolean A0A(IV iv, long j2, DK dk) throws IOException, InterruptedException {
        byte[] bArr = iv.A00;
        if (this.A01 == null) {
            this.A01 = new II(bArr, 17);
            byte[] data = Arrays.copyOfRange(bArr, 9, iv.A07());
            data[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(data);
            dk.A00 = Format.A07(null, A02(0, 10, 95), null, -1, this.A01.A00(), this.A01.A01, this.A01.A06, singletonList, null, 0, null);
            return true;
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            this.A00 = new C1260Vw(this);
            this.A00.A01(iv);
            return true;
        } else if (!A05(bArr)) {
            return true;
        } else {
            C1260Vw c1260Vw = this.A00;
            if (c1260Vw != null) {
                c1260Vw.A00(j2);
                dk.A01 = this.A00;
            }
            return false;
        }
    }
}
