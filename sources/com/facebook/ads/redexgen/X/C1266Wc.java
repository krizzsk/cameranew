package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* renamed from: com.facebook.ads.redexgen.X.Wc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1266Wc implements B8 {
    public static String[] A0E = {"tvm2mqRs7a3ehYHdc1yBQoSNsWCnK", "tOWfSaULM8EnbecBF3SZtCA", "iNgvpQne2", "1AcoT6GEPIUQ3JZIKBz6KhI4GHeuy79P", "lryhUlLd6yxpw4rz006xnThMb", "3cZRB", "VTjWgXugqiR9aqruhTtZOoVTfcJyB76i", "EEKliZG5v6PVzs3xPcyqxwhc3FAivYta"};
    public int A00;
    public int A02;
    public int A03;
    public int A05;
    public long A06;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public ByteBuffer A07 = B8.A00;
    public ByteBuffer A08 = B8.A00;
    public int A01 = -1;
    public int A04 = -1;
    public byte[] A0C = new byte[0];
    public byte[] A0D = new byte[0];

    private int A00(long j2) {
        return (int) ((this.A04 * j2) / 1000000);
    }

    private int A01(ByteBuffer byteBuffer) {
        for (int limit = byteBuffer.limit() - 1; limit >= byteBuffer.position(); limit -= 2) {
            if (Math.abs((int) byteBuffer.get(limit)) > 4) {
                int i2 = this.A00;
                return ((limit / i2) * i2) + i2;
            }
        }
        int position = byteBuffer.position();
        String[] strArr = A0E;
        if (strArr[5].length() != strArr[1].length()) {
            String[] strArr2 = A0E;
            strArr2[5] = "KbmXU";
            strArr2[1] = "sStp2WQndpDzY5UDNElAkrU";
            return position;
        }
        throw new RuntimeException();
    }

    private int A02(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position() + 1; position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.get(position)) > 4) {
                int i2 = this.A00;
                return i2 * (position / i2);
            }
        }
        return byteBuffer.limit();
    }

    private void A03(int i2) {
        if (this.A07.capacity() < i2) {
            this.A07 = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.A07.clear();
        }
        if (i2 > 0) {
            this.A0A = true;
        }
    }

    private void A04(ByteBuffer byteBuffer) {
        A03(byteBuffer.remaining());
        this.A07.put(byteBuffer);
        this.A07.flip();
        this.A08 = this.A07;
    }

    private void A05(ByteBuffer byteBuffer) {
        int maybeSilenceInputSize = byteBuffer.limit();
        int A02 = A02(byteBuffer);
        int position = A02 - byteBuffer.position();
        byte[] bArr = this.A0C;
        int length = bArr.length;
        int maybeSilenceBufferRemaining = this.A02;
        int i2 = length - maybeSilenceBufferRemaining;
        if (A02 < maybeSilenceInputSize && position < i2) {
            A09(bArr, maybeSilenceBufferRemaining);
            this.A02 = 0;
            this.A05 = 0;
            return;
        }
        int min = Math.min(position, i2);
        byteBuffer.limit(byteBuffer.position() + min);
        String[] strArr = A0E;
        if (strArr[0].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[6] = "wWIHZuTOncQcUu5TT4FAsoGOHgVjS7Hw";
        strArr2[3] = "FL1HwHnzDnNmmMdWBTP73LL49pAAT75M";
        byteBuffer.get(this.A0C, this.A02, min);
        this.A02 += min;
        int i3 = this.A02;
        byte[] bArr2 = this.A0C;
        if (i3 == bArr2.length) {
            if (this.A0A) {
                A09(bArr2, this.A03);
                this.A06 += (this.A02 - (this.A03 * 2)) / this.A00;
            } else {
                this.A06 += (i3 - this.A03) / this.A00;
            }
            A08(byteBuffer, this.A0C, this.A02);
            this.A02 = 0;
            this.A05 = 2;
        }
        byteBuffer.limit(maybeSilenceInputSize);
    }

    private void A06(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.A0C.length));
        int A01 = A01(byteBuffer);
        if (A01 == byteBuffer.position()) {
            this.A05 = 1;
        } else {
            byteBuffer.limit(A01);
            A04(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void A07(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int A02 = A02(byteBuffer);
        byteBuffer.limit(A02);
        this.A06 += byteBuffer.remaining() / this.A00;
        A08(byteBuffer, this.A0D, this.A03);
        if (A02 < limit) {
            A09(this.A0D, this.A03);
            this.A05 = 0;
            byteBuffer.limit(limit);
        }
    }

    private void A08(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        int min = Math.min(byteBuffer.remaining(), this.A03);
        int i3 = this.A03 - min;
        System.arraycopy(bArr, i2 - i3, this.A0D, 0, i3);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.A0D, i3, min);
    }

    private void A09(byte[] bArr, int i2) {
        A03(i2);
        this.A07.put(bArr, 0, i2);
        this.A07.flip();
        this.A08 = this.A07;
    }

    public final long A0A() {
        return this.A06;
    }

    public final void A0B(boolean z) {
        this.A09 = z;
        flush();
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A45(int i2, int i3, int i4) throws B7 {
        if (i4 == 2) {
            if (this.A04 == i2) {
                int i5 = this.A01;
                if (A0E[4].length() != 25) {
                    throw new RuntimeException();
                }
                String[] strArr = A0E;
                strArr[0] = "H8XMnFWveFctl2wFWM9cW2gP9UHr1";
                strArr[2] = "PgSQZHBtM";
                if (i5 == i3) {
                    return false;
                }
            }
            this.A04 = i2;
            this.A01 = i3;
            this.A00 = i3 * 2;
            return true;
        }
        throw new B7(i2, i3, i4);
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final ByteBuffer A6x() {
        ByteBuffer byteBuffer = this.A08;
        this.A08 = B8.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A6y() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A6z() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A70() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A8F() {
        return this.A04 != -1 && this.A09;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A8J() {
        return this.A0B && this.A08 == B8.A00;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void ADA() {
        this.A0B = true;
        int i2 = this.A02;
        if (i2 > 0) {
            A09(this.A0C, i2);
        }
        if (!this.A0A) {
            this.A06 += this.A03 / this.A00;
        }
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void ADB(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !this.A08.hasRemaining()) {
            int i2 = this.A05;
            if (i2 != 0) {
                String[] strArr = A0E;
                if (strArr[5].length() == strArr[1].length()) {
                    throw new RuntimeException();
                }
                A0E[4] = "AiWUvfGcxq4zga3HVbzIicdLH";
                if (i2 == 1) {
                    A05(byteBuffer);
                } else if (i2 == 2) {
                    A07(byteBuffer);
                } else {
                    throw new IllegalStateException();
                }
            } else {
                A06(byteBuffer);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void flush() {
        if (A8F()) {
            int A00 = A00(150000L) * this.A00;
            if (this.A0C.length != A00) {
                this.A0C = new byte[A00];
            }
            this.A03 = A00(20000L) * this.A00;
            int length = this.A0D.length;
            int i2 = this.A03;
            if (length != i2) {
                this.A0D = new byte[i2];
            }
        }
        this.A05 = 0;
        this.A08 = B8.A00;
        this.A0B = false;
        this.A06 = 0L;
        String[] strArr = A0E;
        if (strArr[5].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[5] = "CYbGl";
        strArr2[1] = "FkXGzwkTO5dsiSfEVL3DvOQ";
        this.A02 = 0;
        this.A0A = false;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void reset() {
        this.A09 = false;
        flush();
        this.A07 = B8.A00;
        this.A01 = -1;
        this.A04 = -1;
        this.A03 = 0;
        this.A0C = new byte[0];
        this.A0D = new byte[0];
    }
}
