package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* renamed from: com.facebook.ads.redexgen.X.Wb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1265Wb implements B8 {
    public static String[] A0D = {"iVI49d2ZLsEdnN", "8nt9Mx90pYcLgm8jwIqfRxnuNB", "N5EnT7xPV04alRStuSSEb4qxGw0ypgBS", "CZFk7KMkAj1VPwfzqXgnV4RMFN6v0v1b", "0r4SPeKqFHrxpG", "Bbc1ECWkbstPDX5EGN6JJHjdPo9FJmAx", "C6RSY0Y2UTdbfyI9HBBCvYbiYc", "niyGYsc3TbIZXUeN92sM43TjCNQsZLKY"};
    public long A06;
    public long A07;
    @Nullable
    public C0748Bd A08;
    public boolean A0C;
    public float A01 = 1.0f;
    public float A00 = 1.0f;
    public int A02 = -1;
    public int A05 = -1;
    public int A03 = -1;
    public ByteBuffer A09 = B8.A00;
    public ShortBuffer A0B = this.A09.asShortBuffer();
    public ByteBuffer A0A = B8.A00;
    public int A04 = -1;

    public final float A00(float f2) {
        float A00 = C0923Il.A00(f2, 0.1f, 8.0f);
        if (this.A00 != A00) {
            this.A00 = A00;
            this.A08 = null;
        }
        flush();
        return A00;
    }

    public final float A01(float f2) {
        float A00 = C0923Il.A00(f2, 0.1f, 8.0f);
        if (this.A01 != A00) {
            this.A01 = A00;
            this.A08 = null;
        }
        flush();
        return A00;
    }

    public final long A02(long j2) {
        long j3 = this.A07;
        if (j3 >= 1024) {
            int i2 = this.A03;
            int i3 = this.A05;
            if (i2 == i3) {
                return C0923Il.A0F(j2, this.A06, j3);
            }
            return C0923Il.A0F(j2, this.A06 * i2, j3 * i3);
        }
        return (long) (this.A01 * j2);
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A45(int i2, int i3, int i4) throws B7 {
        if (i4 == 2) {
            int i5 = this.A04;
            if (i5 == -1) {
                i5 = i2;
            }
            if (this.A05 == i2 && this.A02 == i3 && this.A03 == i5) {
                return false;
            }
            this.A05 = i2;
            this.A02 = i3;
            this.A03 = i5;
            this.A08 = null;
            return true;
        }
        throw new B7(i2, i3, i4);
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final ByteBuffer A6x() {
        ByteBuffer byteBuffer = this.A0A;
        this.A0A = B8.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A6y() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A6z() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A70() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A8F() {
        if (this.A05 != -1) {
            if (Math.abs(this.A01 - 1.0f) < 0.01f) {
                float abs = Math.abs(this.A00 - 1.0f);
                String[] strArr = A0D;
                if (strArr[6].length() != strArr[1].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[4] = "vE55EECrsMoThx";
                strArr2[0] = "BaJHYxULwHsid1";
                if (abs >= 0.01f || this.A03 != this.A05) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A8J() {
        C0748Bd c0748Bd;
        return this.A0C && ((c0748Bd = this.A08) == null || c0748Bd.A0H() == 0);
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void ADA() {
        I6.A04(this.A08 != null);
        this.A08.A0J();
        this.A0C = true;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void ADB(ByteBuffer byteBuffer) {
        I6.A04(this.A08 != null);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.A06 += remaining;
            this.A08.A0L(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int A0H = this.A08.A0H() * this.A02 * 2;
        if (A0H > 0) {
            if (this.A09.capacity() < A0H) {
                this.A09 = ByteBuffer.allocateDirect(A0H).order(ByteOrder.nativeOrder());
                this.A0B = this.A09.asShortBuffer();
            } else {
                this.A09.clear();
                this.A0B.clear();
            }
            this.A08.A0K(this.A0B);
            this.A07 += A0H;
            this.A09.limit(A0H);
            this.A0A = this.A09;
        }
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void flush() {
        if (A8F()) {
            C0748Bd c0748Bd = this.A08;
            if (c0748Bd == null) {
                this.A08 = new C0748Bd(this.A05, this.A02, this.A01, this.A00, this.A03);
            } else {
                c0748Bd.A0I();
            }
        }
        this.A0A = B8.A00;
        this.A06 = 0L;
        this.A07 = 0L;
        this.A0C = false;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void reset() {
        this.A01 = 1.0f;
        this.A00 = 1.0f;
        this.A02 = -1;
        this.A05 = -1;
        this.A03 = -1;
        this.A09 = B8.A00;
        this.A0B = this.A09.asShortBuffer();
        this.A0A = B8.A00;
        this.A04 = -1;
        this.A08 = null;
        this.A06 = 0L;
        this.A07 = 0L;
        this.A0C = false;
    }
}
