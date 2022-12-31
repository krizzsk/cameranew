package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Vs  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1256Vs extends DL {
    public static byte[] A01;
    public static String[] A02 = {"nsRNjMJCINzttEcy6gRH", "iLBhdjTg3OKb8ywbNnp8pgqKlG", "RImCZo78JGnCd", "MQCM5Bft3v5AKfjxIzCtQe6XKQuHj9cI", "eIxys3n1xHnYXLY6XFR5ULs5u2Lm7Uxd", "C5r06ne3nHFGIipq1ktKTjeYxK5IlnNR", "VUYnCtCcQXjB1sQxVfFNmblLRJpOLxas", "bjyChy1rj1vSDo4qa0ykMaouAr"};
    public static final int A03;
    public static final byte[] A04;
    public boolean A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 7);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{119, -104, -99, -101, -59, -39, -56, -51, -45, -109, -45, -44, -39, -41};
    }

    static {
        A02();
        A03 = C0923Il.A08(A01(0, 4, 33));
        A04 = new byte[]{79, 112, 117, 115, 72, 101, 97, 100};
    }

    private long A00(byte[] bArr) {
        int i2;
        int i3;
        int i4 = bArr[0] & Draft_75.END_OF_FRAME;
        int i5 = i4 & 3;
        if (i5 == 0) {
            i2 = 1;
        } else if (i5 != 1 && i5 != 2) {
            i2 = bArr[1] & 63;
        } else {
            i2 = 2;
        }
        int i6 = i4 >> 3;
        int i7 = i6 & 3;
        if (i6 >= 16) {
            i3 = 2500 << i7;
        } else if (i6 >= 12) {
            int length = i7 & 1;
            i3 = 10000 << length;
        } else {
            String[] strArr = A02;
            String str = strArr[0];
            String str2 = strArr[2];
            int length2 = str.length();
            int length3 = str2.length();
            if (length2 == length3) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[0] = "5xugLvQ3PcyvpmKVP2TF";
            strArr2[2] = "0gGe0pFYIsJYF";
            if (i7 == 3) {
                i3 = 60000;
            } else {
                i3 = 10000 << i7;
            }
        }
        return i2 * i3;
    }

    private void A03(List<byte[]> list, int i2) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i2 * 1000000000) / 48000).array());
    }

    public static boolean A04(IV iv) {
        int A042 = iv.A04();
        byte[] bArr = A04;
        if (A042 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        iv.A0c(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, A04);
    }

    @Override // com.facebook.ads.redexgen.X.DL
    public final long A07(IV iv) {
        return A04(A00(iv.A00));
    }

    @Override // com.facebook.ads.redexgen.X.DL
    public final void A09(boolean z) {
        super.A09(z);
        if (z) {
            this.A00 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DL
    public final boolean A0A(IV iv, long j2, DK dk) throws IOException, InterruptedException {
        if (!this.A00) {
            byte[] copyOf = Arrays.copyOf(iv.A00, iv.A07());
            int i2 = copyOf[9] & Draft_75.END_OF_FRAME;
            int channelCount = (copyOf[11] & Draft_75.END_OF_FRAME) << 8;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            A03(arrayList, channelCount | (copyOf[10] & Draft_75.END_OF_FRAME));
            A03(arrayList, 3840);
            dk.A00 = Format.A07(null, A01(4, 10, 93), null, -1, -1, i2, 48000, arrayList, null, 0, null);
            this.A00 = true;
            return true;
        }
        boolean z = iv.A08() == A03;
        iv.A0Y(0);
        return z;
    }
}
