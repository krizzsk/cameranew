package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* renamed from: com.facebook.ads.redexgen.X.Wf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1269Wf implements B8 {
    public static String[] A06 = {"grqzXl31Ib3CwgbOGLAhXGiUSybb3G6k", "HqCRL2sDmMVhvd9OffyzWNuXpbgyFlqg", "IpTiYMxyYV6xHW6l8ixVEePHdVdY3VZ5", "ZRTEafxouxRK9cmvY3V1KAxZT1cXIFF2", "yUYM5z5ItqNmKdZaBdfrwPcFTl5oQFEz", "Jf72zunVfpVe04eAXULupQi0ZX1Zqvmv", "BX9HD2aywQJTDQtUbY1GrFeREy6of4gh", "vYXD58apfp8PH7rmktr19THixNAKPTAD"};
    public static final int A07 = Float.floatToIntBits(Float.NaN);
    public boolean A05;
    public int A01 = -1;
    public int A00 = -1;
    public int A02 = 0;
    public ByteBuffer A03 = B8.A00;
    public ByteBuffer A04 = B8.A00;

    public static void A00(int i2, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i2 * 4.656612875245797E-10d));
        if (floatToIntBits == A07) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A45(int i2, int i3, int i4) throws B7 {
        if (C0923Il.A0b(i4)) {
            int i5 = this.A01;
            String[] strArr = A06;
            if (strArr[1].charAt(10) != strArr[5].charAt(10)) {
                throw new RuntimeException();
            }
            A06[0] = "leVPKBI8NIDC3IwFclJng7rkdIPGoQ7e";
            if (i5 == i2 && this.A00 == i3 && this.A02 == i4) {
                return false;
            }
            this.A01 = i2;
            this.A00 = i3;
            this.A02 = i4;
            return true;
        }
        throw new B7(i2, i3, i4);
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final ByteBuffer A6x() {
        ByteBuffer byteBuffer = this.A04;
        this.A04 = B8.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A6y() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A6z() {
        return 4;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A70() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A8F() {
        return C0923Il.A0b(this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A8J() {
        return this.A05 && this.A04 == B8.A00;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void ADA() {
        this.A05 = true;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void ADB(ByteBuffer byteBuffer) {
        int resampledSize = this.A02 == 1073741824 ? 1 : 0;
        int i2 = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i3 = limit - i2;
        if (resampledSize == 0) {
            int size = i3 / 3;
            i3 = size * 4;
        }
        int capacity = this.A03.capacity();
        String[] strArr = A06;
        String str = strArr[1];
        String str2 = strArr[5];
        int limit2 = str.charAt(10);
        int size2 = str2.charAt(10);
        if (limit2 != size2) {
            throw new RuntimeException();
        }
        A06[2] = "93WHocDEPVvmBm0SxxEdEuUxxAP6dl6i";
        if (capacity < i3) {
            this.A03 = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
        } else {
            this.A03.clear();
        }
        if (resampledSize != 0) {
            while (i2 < limit) {
                int size3 = byteBuffer.get(i2);
                int limit3 = size3 & 255;
                int size4 = i2 + 1;
                int limit4 = limit3 | ((byteBuffer.get(size4) & 255) << 8);
                int size5 = i2 + 2;
                int limit5 = limit4 | ((byteBuffer.get(size5) & 255) << 16);
                int size6 = i2 + 3;
                A00(limit5 | ((byteBuffer.get(size6) & 255) << 24), this.A03);
                i2 += 4;
            }
        } else {
            while (i2 < limit) {
                int size7 = byteBuffer.get(i2);
                int limit6 = (size7 & 255) << 8;
                int size8 = i2 + 1;
                int limit7 = limit6 | ((byteBuffer.get(size8) & 255) << 16);
                int size9 = i2 + 2;
                A00(limit7 | ((byteBuffer.get(size9) & 255) << 24), this.A03);
                i2 += 3;
            }
        }
        int size10 = byteBuffer.limit();
        byteBuffer.position(size10);
        this.A03.flip();
        this.A04 = this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void flush() {
        this.A04 = B8.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void reset() {
        flush();
        this.A01 = -1;
        this.A00 = -1;
        this.A02 = 0;
        this.A03 = B8.A00;
    }
}
