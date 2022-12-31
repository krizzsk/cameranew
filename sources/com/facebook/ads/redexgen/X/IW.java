package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* loaded from: assets/audience_network.dex */
public final class IW {
    public static String[] A04 = {"c84vrcH31LBgkMTCK1bohHlXVMnz9AJR", "d1OdysF2oEJNIHjT9033ROKyCX5j9bI3", "fxcqndjlyXUHbVpCK9jm", "aT6eQk8J7bmxuuGVWtHexoeTGFRtLCio", "ywK9OdvkymoDgjlaSqX1MXgGISTKD1G", "kvGKIZl1lyVjOHyD1SwfLq7Qy0hyNYJA", "P5ZowT1yJlaZidguBbmn", "kEUPdIGxbWMHKqV30QNAKk8CqZCFjcZl"};
    public int A00;
    public int A01;
    public int A02;
    public byte[] A03;

    public IW(byte[] bArr, int i2, int i3) {
        A08(bArr, i2, i3);
    }

    private int A00() {
        int i2 = 0;
        while (!A0A()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (A04[5].charAt(7) != 'Z') {
            String[] strArr = A04;
            strArr[1] = "EO6sj55N530JbeetbwPxyBKxcCLP9BzL";
            strArr[0] = "oyZlo8wPjIkpHiFdOrp6pSDhzRhw9ZCk";
            return i3 + (i2 > 0 ? A05(i2) : 0);
        }
        throw new RuntimeException();
    }

    private void A01() {
        int i2;
        int i3 = this.A02;
        I6.A04(i3 >= 0 && (i3 < (i2 = this.A01) || (i3 == i2 && this.A00 == 0)));
    }

    private boolean A02(int i2) {
        if (2 <= i2 && i2 < this.A01) {
            byte[] bArr = this.A03;
            if (bArr[i2] == 3 && bArr[i2 - 2] == 0 && bArr[i2 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final int A03() {
        int A00 = A00();
        return (A00 % 2 == 0 ? -1 : 1) * ((A00 + 1) / 2);
    }

    public final int A04() {
        return A00();
    }

    public final int A05(int i2) {
        int i3;
        int i4 = 0;
        this.A00 += i2;
        while (true) {
            i3 = this.A00;
            if (i3 <= 8) {
                break;
            }
            this.A00 = i3 - 8;
            byte[] bArr = this.A03;
            int i5 = this.A02;
            i4 |= (bArr[i5] & Draft_75.END_OF_FRAME) << this.A00;
            if (!A02(i5 + 1)) {
                r4 = 1;
            }
            this.A02 = i5 + r4;
        }
        byte[] bArr2 = this.A03;
        int i6 = this.A02;
        int i7 = (i4 | ((bArr2[i6] & Draft_75.END_OF_FRAME) >> (8 - i3))) & ((-1) >>> (32 - i2));
        if (i3 == 8) {
            this.A00 = 0;
            this.A02 = i6 + (A02(i6 + 1) ? 2 : 1);
        }
        A01();
        String[] strArr = A04;
        if (strArr[6].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[1] = "VwcsjLhlZd9I2ct9XMdPqerwWVhD9SnY";
        strArr2[0] = "SEOCmBzyD2oxYau0L8QhU7fYZrlA9WRm";
        return i7;
    }

    public final void A06() {
        int i2 = this.A00 + 1;
        this.A00 = i2;
        if (i2 == 8) {
            this.A00 = 0;
            int i3 = this.A02;
            this.A02 = i3 + (A02(i3 + 1) ? 2 : 1);
        }
        A01();
    }

    public final void A07(int numBytes) {
        int i2 = this.A02;
        int i3 = numBytes / 8;
        this.A02 += i3;
        this.A00 += numBytes - (i3 * 8);
        int i4 = this.A00;
        if (i4 > 7) {
            this.A02++;
            this.A00 = i4 - 8;
        }
        while (true) {
            i2++;
            int i5 = this.A02;
            String[] strArr = A04;
            if (strArr[6].length() != strArr[2].length()) {
                break;
            }
            String[] strArr2 = A04;
            strArr2[7] = "16ru2e8lXVuKccLj62CTuGGODJDTLMLs";
            strArr2[3] = "ss2rTXlJnNbrcKU9GLjWVNttz382myoQ";
            if (i2 <= i5) {
                boolean A02 = A02(i2);
                String[] strArr3 = A04;
                if (strArr3[6].length() != strArr3[2].length()) {
                    break;
                }
                String[] strArr4 = A04;
                strArr4[6] = "8iP0ukDWZhsNH03XWb9d";
                strArr4[2] = "2ETrOFK8hCpKH2QuP6pQ";
                if (A02) {
                    this.A02++;
                    i2 += 2;
                }
            } else {
                A01();
                return;
            }
        }
        throw new RuntimeException();
    }

    public final void A08(byte[] bArr, int i2, int i3) {
        this.A03 = bArr;
        this.A02 = i2;
        this.A01 = i3;
        this.A00 = 0;
        A01();
    }

    public final boolean A09() {
        int initialBitOffset = this.A02;
        int leadingZeros = this.A00;
        int i2 = 0;
        while (this.A02 < this.A01 && !A0A()) {
            i2++;
        }
        boolean z = this.A02 == this.A01;
        this.A02 = initialBitOffset;
        this.A00 = leadingZeros;
        if (A04[5].charAt(7) != 'Z') {
            String[] strArr = A04;
            strArr[7] = "4CnifSrgKpd7e7K0x8WVIkfErouhzSPT";
            strArr[3] = "4ZydgevgZqNlOfL3PtmcBBhuPOTZ7C4b";
            return !z && A0B((i2 * 2) + 1);
        }
        throw new RuntimeException();
    }

    public final boolean A0A() {
        boolean z = (this.A03[this.A02] & (128 >> this.A00)) != 0;
        A06();
        return z;
    }

    public final boolean A0B(int numBytes) {
        int newByteOffset = this.A02;
        int i2 = numBytes / 8;
        int i3 = this.A02 + i2;
        int i4 = (this.A00 + numBytes) - (i2 * 8);
        if (i4 > 7) {
            i3++;
            i4 -= 8;
        }
        int i5 = newByteOffset + 1;
        while (i5 <= i3 && i3 < this.A01) {
            if (A02(i5)) {
                i3++;
                i5 += 2;
            }
            i5++;
        }
        int newBitOffset = this.A01;
        if (i3 >= newBitOffset) {
            return i3 == newBitOffset && i4 == 0;
        }
        return true;
    }
}
