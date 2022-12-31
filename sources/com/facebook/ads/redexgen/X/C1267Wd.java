package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* renamed from: com.facebook.ads.redexgen.X.Wd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1267Wd implements B8 {
    public static String[] A06 = {"5utGUnn02b5VIzuc1FLHs1Qqi0fGEzz2", "DaG3Y2wQcTFt6n6rQ7Gr6iJZtSjkgUIR", "I5wcdOmu3UXBpwLMhd1MA2dM71iQzRTS", "a3TfZcOy08z7kq2pPCWxFv40lmZdIopZ", "nCxl35vO69EqZhEDDoDcGzJRz4rMZlE7", "Y5761Ga76B4ReZAKlzLfDyZ1gXjGXB3L", "t1lur4hbWemc11jTFC6OlnNGsbjhQ3VM", "6CnjKSKlGDDfBCJgDd7Ssr26upnReJdk"};
    public boolean A05;
    public int A02 = -1;
    public int A00 = -1;
    public int A01 = 0;
    public ByteBuffer A03 = B8.A00;
    public ByteBuffer A04 = B8.A00;

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A45(int i2, int i3, int i4) throws B7 {
        if (i4 == 3 || i4 == 2 || i4 == Integer.MIN_VALUE || i4 == 1073741824) {
            if (this.A02 == i2 && this.A00 == i3 && this.A01 == i4) {
                return false;
            }
            this.A02 = i2;
            this.A00 = i3;
            this.A01 = i4;
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
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final int A70() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final boolean A8F() {
        int i2 = this.A01;
        return (i2 == 0 || i2 == 2) ? false : true;
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
        int i2;
        int size = byteBuffer.position();
        int resampledSize = byteBuffer.limit();
        int i3 = resampledSize - size;
        int i4 = this.A01;
        if (i4 == Integer.MIN_VALUE) {
            i2 = (i3 / 3) * 2;
        } else if (i4 == 3) {
            i2 = i3 * 2;
        } else if (i4 == 1073741824) {
            i2 = i3 / 2;
        } else {
            throw new IllegalStateException();
        }
        int capacity = this.A03.capacity();
        String[] strArr = A06;
        if (strArr[6].charAt(17) == strArr[3].charAt(17)) {
            String[] strArr2 = A06;
            strArr2[2] = "W94yXwDUFyNDAMV4dQ9gRwTb9HKmhar0";
            strArr2[1] = "UxSCLQ06z7wJwwSNZRUXPEmpHaH1zCeE";
            if (capacity < i2) {
                this.A03 = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
            } else {
                this.A03.clear();
            }
            int i5 = this.A01;
            if (i5 == Integer.MIN_VALUE) {
                while (size < resampledSize) {
                    this.A03.put(byteBuffer.get(size + 1));
                    this.A03.put(byteBuffer.get(size + 2));
                    size += 3;
                }
            } else if (i5 == 3) {
                while (size < resampledSize) {
                    this.A03.put((byte) 0);
                    this.A03.put((byte) ((byteBuffer.get(size) & Draft_75.END_OF_FRAME) - 128));
                    size++;
                }
            } else if (i5 == 1073741824) {
                while (size < resampledSize) {
                    ByteBuffer byteBuffer2 = this.A03;
                    String[] strArr3 = A06;
                    if (strArr3[2].charAt(9) != strArr3[1].charAt(9)) {
                        String[] strArr4 = A06;
                        strArr4[2] = "sfuVTkj8IwDRAmHRKMELNpZyhpVkIKBS";
                        strArr4[1] = "Fl4ka6a0nXkGByMLlkeuhoftQnViDXP0";
                        byteBuffer2.put(byteBuffer.get(size + 2));
                        this.A03.put(byteBuffer.get(size + 3));
                        size += 4;
                    }
                }
            } else {
                throw new IllegalStateException();
            }
            byteBuffer.position(byteBuffer.limit());
            this.A03.flip();
            this.A04 = this.A03;
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void flush() {
        this.A04 = B8.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.B8
    public final void reset() {
        flush();
        this.A02 = -1;
        this.A00 = -1;
        this.A01 = 0;
        this.A03 = B8.A00;
    }
}
