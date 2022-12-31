package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Vq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1254Vq extends DL {
    public static byte[] A05;
    public static String[] A06 = {"Wz5kpI", "Qu4rCXWHGrZxyCLJ91nJYm9HwbbNBaAB", "jcFxTUNQ9mBSPSNjMUJY07wGvzfGS2C0", "wRecpgZSCUfboq2e81nqZjs5B", "2wu5mHiieWPMNFHGOEN0thCm6IWO9Xya", "P54DBngSoaRE6HRNMaW6H3WNUnBy8S0x", "u1kez8Hi5IXqm6uzKKQ3Ad3inAYpSzVQ", "yOq9tmgmQLY5WHe8QvjpkSndY9PHYfSY"};
    public int A00;
    public DN A01;
    public DP A02;
    public DR A03;
    public boolean A04;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 51);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{61, 41, 56, 53, 51, 115, 42, 51, 46, 62, 53, 47};
    }

    static {
        A04();
    }

    public static int A00(byte b, int i2, int i3) {
        return (b >> i3) & (255 >>> (8 - i2));
    }

    public static int A01(byte b, DN dn) {
        if (!dn.A04[A00(b, dn.A00, 1)].A03) {
            return dn.A02.A03;
        }
        return dn.A02.A04;
    }

    private final DN A02(IV iv) throws IOException {
        if (this.A03 == null) {
            this.A03 = DS.A04(iv);
            return null;
        }
        DP dp = this.A02;
        if (A06[7].charAt(1) != 'O') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[3] = "EnVW7ymY5FyvrkHYKpVAYit2P";
        strArr[0] = "59lsEN";
        if (dp == null) {
            this.A02 = DS.A03(iv);
            return null;
        }
        byte[] bArr = new byte[iv.A07()];
        System.arraycopy(iv.A00, 0, bArr, 0, iv.A07());
        DQ[] A0C = DS.A0C(iv, this.A03.A05);
        return new DN(this.A03, this.A02, bArr, A0C, DS.A00(A0C.length - 1));
    }

    public static void A05(IV iv, long j2) {
        iv.A0X(iv.A07() + 4);
        iv.A00[iv.A07() - 4] = (byte) (j2 & 255);
        iv.A00[iv.A07() - 3] = (byte) ((j2 >>> 8) & 255);
        iv.A00[iv.A07() - 2] = (byte) ((j2 >>> 16) & 255);
        iv.A00[iv.A07() - 1] = (byte) (255 & (j2 >>> 24));
    }

    public static boolean A06(IV iv) {
        try {
            return DS.A0A(1, iv, true);
        } catch (AS unused) {
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DL
    public final long A07(IV iv) {
        if ((iv.A00[0] & 1) == 1) {
            return -1L;
        }
        int A01 = A01(iv.A00[0], this.A01);
        int i2 = this.A04 ? (this.A00 + A01) / 4 : 0;
        A05(iv, i2);
        this.A04 = true;
        this.A00 = A01;
        return i2;
    }

    @Override // com.facebook.ads.redexgen.X.DL
    public final void A08(long j2) {
        super.A08(j2);
        this.A04 = j2 != 0;
        DR dr = this.A03;
        this.A00 = dr != null ? dr.A03 : 0;
    }

    @Override // com.facebook.ads.redexgen.X.DL
    public final void A09(boolean z) {
        super.A09(z);
        if (z) {
            this.A01 = null;
            this.A03 = null;
            this.A02 = null;
        }
        this.A00 = 0;
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.X.DL
    public final boolean A0A(IV iv, long j2, DK dk) throws IOException, InterruptedException {
        if (this.A01 != null) {
            String[] strArr = A06;
            if (strArr[5].charAt(2) != strArr[1].charAt(2)) {
                throw new RuntimeException();
            }
            A06[2] = "mO0nJ77ourwQSXFSw31DnFJId1Q3DZ07";
            return false;
        }
        this.A01 = A02(iv);
        if (this.A01 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.A01.A02.A09);
        arrayList.add(this.A01.A03);
        dk.A00 = Format.A07(null, A03(0, 12, 111), null, this.A01.A02.A02, -1, this.A01.A02.A05, (int) this.A01.A02.A06, arrayList, null, 0, null);
        return true;
    }
}
