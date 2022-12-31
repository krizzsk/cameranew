package com.facebook.ads.redexgen.X;

import androidx.core.view.MotionEventCompat;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* loaded from: assets/audience_network.dex */
public final class IU {
    public static String[] A04 = {"RHSjJGYddlOPzslamo8j", "no2wrOKISs4wdINa", "E7xZIMZbElFQthX5cbe1zXMBiqq9Oct2", "NQ4djAykaRRiHV2nkQWoiztobM3LGBfO", "EDikhWaymQH2jtWvDyx1vViO84FhvN", "TllFBKS94wZfNNX6FcczOhdwmX6snrOZ", "CS63JXje", "QpZzHKHty24GTaxrVVV4B8DIrBZ4Gw8P"};
    public byte[] A00;
    public int A01;
    public int A02;
    public int A03;

    public IU() {
    }

    public IU(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public IU(byte[] bArr, int i2) {
        this.A00 = bArr;
        this.A02 = i2;
    }

    private void A00() {
        int i2;
        int i3 = this.A03;
        I6.A04(i3 >= 0 && (i3 < (i2 = this.A02) || (i3 == i2 && this.A01 == 0)));
    }

    public final int A01() {
        return ((this.A02 - this.A03) * 8) - this.A01;
    }

    public final int A02() {
        I6.A04(this.A01 == 0);
        return this.A03;
    }

    public final int A03() {
        return (this.A03 * 8) + this.A01;
    }

    public final int A04(int returnValue) {
        int i2;
        if (returnValue == 0) {
            return 0;
        }
        int i3 = 0;
        this.A01 += returnValue;
        while (true) {
            i2 = this.A01;
            if (i2 <= 8) {
                break;
            }
            this.A01 = i2 - 8;
            byte[] bArr = this.A00;
            int i4 = this.A03;
            this.A03 = i4 + 1;
            i3 |= (bArr[i4] & Draft_75.END_OF_FRAME) << this.A01;
        }
        byte[] bArr2 = this.A00;
        int i5 = this.A03;
        int i6 = (i3 | ((bArr2[i5] & Draft_75.END_OF_FRAME) >> (8 - i2))) & ((-1) >>> (32 - returnValue));
        if (i2 == 8) {
            this.A01 = 0;
            this.A03 = i5 + 1;
        }
        A00();
        return i6;
    }

    public final void A05() {
        if (this.A01 == 0) {
            return;
        }
        this.A01 = 0;
        this.A03++;
        A00();
    }

    public final void A06() {
        int i2 = this.A01 + 1;
        this.A01 = i2;
        if (i2 == 8) {
            this.A01 = 0;
            this.A03++;
        }
        A00();
    }

    public final void A07(int i2) {
        this.A03 = i2 / 8;
        this.A01 = i2 - (this.A03 * 8);
        A00();
    }

    public final void A08(int i2) {
        int i3 = i2 / 8;
        this.A03 += i3;
        this.A01 += i2 - (i3 * 8);
        int i4 = this.A01;
        if (i4 > 7) {
            this.A03++;
            this.A01 = i4 - 8;
        }
        A00();
    }

    public final void A09(int i2) {
        I6.A04(this.A01 == 0);
        this.A03 += i2;
        A00();
    }

    public final void A0A(int i2, int firstByteReadSize) {
        if (firstByteReadSize < 32) {
            i2 &= (1 << firstByteReadSize) - 1;
        }
        int min = Math.min(8 - this.A01, firstByteReadSize);
        int firstByteRightPaddingSize = this.A01;
        int i3 = (8 - firstByteRightPaddingSize) - min;
        int i4 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> firstByteRightPaddingSize) | ((1 << i3) - 1);
        byte[] bArr = this.A00;
        int i5 = this.A03;
        bArr[i5] = (byte) (bArr[i5] & i4);
        int firstByteInputBits = bArr[i5];
        bArr[i5] = (byte) (firstByteInputBits | ((i2 >>> (firstByteReadSize - min)) << i3));
        int i6 = firstByteReadSize - min;
        int i7 = i5 + 1;
        while (i6 > 8) {
            this.A00[i7] = (byte) (i2 >>> (i6 - 8));
            i6 -= 8;
            i7++;
        }
        int currentByteIndex = 8 - i6;
        byte[] bArr2 = this.A00;
        bArr2[i7] = (byte) (bArr2[i7] & ((1 << currentByteIndex) - 1));
        int lastByteInput = i2 & ((1 << i6) - 1);
        byte b = (byte) (bArr2[i7] | (lastByteInput << currentByteIndex));
        if (A04[3].charAt(20) != 'i') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[4] = "HDn8cIfTWSkx257fNKtZvpUDi4vYZW";
        strArr[6] = "YQkUGCO4";
        bArr2[i7] = b;
        A08(firstByteReadSize);
        A00();
    }

    public final void A0B(byte[] bArr) {
        A0C(bArr, bArr.length);
    }

    public final void A0C(byte[] bArr, int i2) {
        this.A00 = bArr;
        this.A03 = 0;
        this.A01 = 0;
        this.A02 = i2;
    }

    public final void A0D(byte[] bArr, int i2, int i3) {
        int i4 = (i3 >> 3) + i2;
        while (i2 < i4) {
            byte[] bArr2 = this.A00;
            int i5 = this.A03;
            this.A03 = i5 + 1;
            byte b = bArr2[i5];
            int i6 = this.A01;
            bArr[i2] = (byte) (b << i6);
            bArr[i2] = (byte) (((255 & bArr2[this.A03]) >> (8 - i6)) | bArr[i2]);
            i2++;
        }
        int i7 = i3 & 7;
        if (i7 != 0) {
            bArr[i4] = (byte) (bArr[i4] & (255 >> i7));
            int i8 = this.A01;
            if (i8 + i7 > 8) {
                int i9 = bArr[i4];
                byte[] bArr3 = this.A00;
                int i10 = this.A03;
                this.A03 = i10 + 1;
                bArr[i4] = (byte) (i9 | ((bArr3[i10] & Draft_75.END_OF_FRAME) << i8));
                this.A01 = i8 - 8;
            }
            this.A01 += i7;
            byte[] bArr4 = this.A00;
            int i11 = this.A03;
            int i12 = this.A01;
            bArr[i4] = (byte) (bArr[i4] | ((byte) (((255 & bArr4[i11]) >> (8 - i12)) << (8 - i7))));
            if (i12 == 8) {
                this.A01 = 0;
                this.A03 = i11 + 1;
            }
            A00();
        }
    }

    public final void A0E(byte[] bArr, int i2, int i3) {
        I6.A04(this.A01 == 0);
        System.arraycopy(this.A00, this.A03, bArr, i2, i3);
        this.A03 += i3;
        A00();
    }

    public final boolean A0F() {
        boolean z = (this.A00[this.A03] & (128 >> this.A01)) != 0;
        A06();
        return z;
    }
}
