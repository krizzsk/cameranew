package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Wj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1273Wj implements B8 {
    public static String[] A08 = {"hI95CJvP", "e7uFmzv8JlxhzV9w6wWiWm3C", "0BfqaNpqjs7ROgqNLFdYFDMF2kIE2JVl", "01nBjZj9wdoXPRYWJREYdbIjHTCf93fz", "xbIGt4PZ2jMEHXqvTGNBXf5J", "qzrNEKfdD0Je3OCcD1S0Cr1qEsV7v9mi", "0sM3QN", "C1cp7SniMnLQ2eyeNR7DTGSoW6Un2OTz"};
    public boolean A04;
    public boolean A05;
    @Nullable
    public int[] A06;
    @Nullable
    public int[] A07;
    public ByteBuffer A02 = B8.A00;
    public ByteBuffer A03 = B8.A00;
    public int A00 = -1;
    public int A01 = -1;

    public final void A00(@Nullable int[] iArr) {
        this.A07 = iArr;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A45(int i2, int i3, int i4) throws B7 {
        boolean z = !Arrays.equals(this.A07, this.A06);
        this.A06 = this.A07;
        if (this.A06 == null) {
            this.A04 = false;
            return z;
        } else if (i4 == 2) {
            if (!z && this.A01 == i2) {
                int i5 = this.A00;
                String[] strArr = A08;
                if (strArr[6].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[6] = "gVI3SL";
                strArr2[0] = "1HQF1tqI";
                if (i5 == i3) {
                    return false;
                }
            }
            this.A01 = i2;
            this.A00 = i3;
            this.A04 = i3 != this.A06.length;
            int i6 = 0;
            while (true) {
                int[] iArr = this.A06;
                if (i6 >= iArr.length) {
                    return true;
                }
                int i7 = iArr[i6];
                if (i7 < i3) {
                    this.A04 |= i7 != i6;
                    i6++;
                } else {
                    throw new B7(i2, i3, i4);
                }
            }
        } else {
            throw new B7(i2, i3, i4);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final ByteBuffer A6x() {
        ByteBuffer byteBuffer = this.A03;
        this.A03 = B8.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A6y() {
        int[] iArr = this.A06;
        return iArr == null ? this.A00 : iArr.length;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A6z() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A70() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A8F() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A8J() {
        return this.A05 && this.A03 == B8.A00;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void ADA() {
        this.A05 = true;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void ADB(ByteBuffer byteBuffer) {
        int[] iArr;
        I6.A04(this.A06 != null);
        int outputSize = byteBuffer.position();
        int limit = byteBuffer.limit();
        int limit2 = this.A00;
        int i2 = (limit - outputSize) / (limit2 * 2);
        int frameCount = this.A06.length;
        int i3 = frameCount * i2 * 2;
        int frameCount2 = this.A02.capacity();
        if (frameCount2 < i3) {
            this.A02 = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
        } else {
            this.A02.clear();
        }
        while (outputSize < limit) {
            for (int frameCount3 : this.A06) {
                int channelIndex = frameCount3 * 2;
                this.A02.putShort(byteBuffer.getShort(channelIndex + outputSize));
            }
            outputSize += this.A00 * 2;
        }
        byteBuffer.position(limit);
        this.A02.flip();
        this.A03 = this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void flush() {
        this.A03 = B8.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void reset() {
        flush();
        this.A02 = B8.A00;
        this.A00 = -1;
        this.A01 = -1;
        this.A06 = null;
        this.A07 = null;
        this.A04 = false;
    }
}
