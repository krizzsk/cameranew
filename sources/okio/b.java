package okio;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
/* compiled from: Buffer.java */
/* loaded from: classes3.dex */
public final class b implements d, c, Cloneable, ByteChannel {
    @Nullable
    h a;
    long b;

    private boolean z(h hVar, int i2, ByteString byteString, int i3, int i4) {
        int i5 = hVar.c;
        byte[] bArr = hVar.a;
        while (i3 < i4) {
            if (i2 == i5) {
                hVar = hVar.f8943f;
                byte[] bArr2 = hVar.a;
                bArr = bArr2;
                i2 = hVar.b;
                i5 = hVar.c;
            }
            if (bArr[i2] != byteString.getByte(i3)) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    public byte A() {
        long j2 = this.b;
        if (j2 != 0) {
            h hVar = this.a;
            int i2 = hVar.b;
            int i3 = hVar.c;
            int i4 = i2 + 1;
            byte b = hVar.a[i2];
            this.b = j2 - 1;
            if (i4 == i3) {
                this.a = hVar.b();
                i.a(hVar);
            } else {
                hVar.b = i4;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.d
    public b F() {
        return this;
    }

    @Override // okio.d
    public long H(ByteString byteString) {
        return y(byteString, 0L);
    }

    public byte[] N() {
        try {
            return O(this.b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public byte[] O(long j2) throws EOFException {
        l.b(this.b, 0L, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[(int) j2];
            R(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    @Override // okio.d
    public int P(f fVar) {
        int W = W(fVar, false);
        if (W == -1) {
            return -1;
        }
        try {
            X(fVar.a[W].size());
            return W;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public ByteString Q() {
        return new ByteString(N());
    }

    public void R(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = read(bArr, i2, bArr.length - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
    }

    public int S() {
        long j2 = this.b;
        if (j2 >= 4) {
            h hVar = this.a;
            int i2 = hVar.b;
            int i3 = hVar.c;
            if (i3 - i2 < 4) {
                return ((A() & Draft_75.END_OF_FRAME) << 24) | ((A() & Draft_75.END_OF_FRAME) << 16) | ((A() & Draft_75.END_OF_FRAME) << 8) | (A() & Draft_75.END_OF_FRAME);
            }
            byte[] bArr = hVar.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & Draft_75.END_OF_FRAME) << 24) | ((bArr[i4] & Draft_75.END_OF_FRAME) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & Draft_75.END_OF_FRAME) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | (bArr[i7] & Draft_75.END_OF_FRAME);
            this.b = j2 - 4;
            if (i9 == i3) {
                this.a = hVar.b();
                i.a(hVar);
            } else {
                hVar.b = i9;
            }
            return i10;
        }
        throw new IllegalStateException("size < 4: " + this.b);
    }

    public String T(long j2, Charset charset) throws EOFException {
        l.b(this.b, 0L, j2);
        if (charset != null) {
            if (j2 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
            } else if (j2 == 0) {
                return "";
            } else {
                h hVar = this.a;
                if (hVar.b + j2 > hVar.c) {
                    return new String(O(j2), charset);
                }
                String str = new String(hVar.a, hVar.b, (int) j2, charset);
                int i2 = (int) (hVar.b + j2);
                hVar.b = i2;
                this.b -= j2;
                if (i2 == hVar.c) {
                    this.a = hVar.b();
                    i.a(hVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String U() {
        try {
            return T(this.b, l.a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String V(long j2) throws EOFException {
        return T(j2, l.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
        if (r19 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int W(okio.f r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 161
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.b.W(okio.f, boolean):int");
    }

    public void X(long j2) throws EOFException {
        h hVar;
        while (j2 > 0) {
            if (this.a != null) {
                int min = (int) Math.min(j2, hVar.c - hVar.b);
                long j3 = min;
                this.b -= j3;
                j2 -= j3;
                h hVar2 = this.a;
                int i2 = hVar2.b + min;
                hVar2.b = i2;
                if (i2 == hVar2.c) {
                    this.a = hVar2.b();
                    i.a(hVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString Y() {
        long j2 = this.b;
        if (j2 <= 2147483647L) {
            return Z((int) j2);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    public final ByteString Z(int i2) {
        if (i2 == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a0(int i2) {
        if (i2 >= 1 && i2 <= 8192) {
            h hVar = this.a;
            if (hVar == null) {
                h b = i.b();
                this.a = b;
                b.f8944g = b;
                b.f8943f = b;
                return b;
            }
            h hVar2 = hVar.f8944g;
            if (hVar2.c + i2 > 8192 || !hVar2.f8942e) {
                h b2 = i.b();
                hVar2.c(b2);
                return b2;
            }
            return hVar2;
        }
        throw new IllegalArgumentException();
    }

    public b b0(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j2 = i3;
            l.b(bArr.length, i2, j2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                h a0 = a0(1);
                int min = Math.min(i4 - i2, 8192 - a0.c);
                System.arraycopy(bArr, i2, a0.a, a0.c, min);
                i2 += min;
                a0.c += min;
            }
            this.b += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void c0(b bVar, long j2) {
        if (bVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (bVar != this) {
            l.b(bVar.b, 0L, j2);
            while (j2 > 0) {
                h hVar = bVar.a;
                if (j2 < hVar.c - hVar.b) {
                    h hVar2 = this.a;
                    h hVar3 = hVar2 != null ? hVar2.f8944g : null;
                    if (hVar3 != null && hVar3.f8942e) {
                        if ((hVar3.c + j2) - (hVar3.f8941d ? 0 : hVar3.b) <= 8192) {
                            hVar.f(hVar3, (int) j2);
                            bVar.b -= j2;
                            this.b += j2;
                            return;
                        }
                    }
                    bVar.a = hVar.e((int) j2);
                }
                h hVar4 = bVar.a;
                long j3 = hVar4.c - hVar4.b;
                bVar.a = hVar4.b();
                h hVar5 = this.a;
                if (hVar5 == null) {
                    this.a = hVar4;
                    hVar4.f8944g = hVar4;
                    hVar4.f8943f = hVar4;
                } else {
                    hVar5.f8944g.c(hVar4);
                    hVar4.a();
                }
                bVar.b -= j3;
                this.b += j3;
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // okio.j, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public final void d() {
        try {
            X(this.b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public b d0(int i2) {
        h a0 = a0(1);
        byte[] bArr = a0.a;
        int i3 = a0.c;
        a0.c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.b++;
        return this;
    }

    public b e0(int i2) {
        h a0 = a0(4);
        byte[] bArr = a0.a;
        int i3 = a0.c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        a0.c = i6 + 1;
        this.b += 4;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            long j2 = this.b;
            if (j2 != bVar.b) {
                return false;
            }
            long j3 = 0;
            if (j2 == 0) {
                return true;
            }
            h hVar = this.a;
            h hVar2 = bVar.a;
            int i2 = hVar.b;
            int i3 = hVar2.b;
            while (j3 < this.b) {
                long min = Math.min(hVar.c - i2, hVar2.c - i3);
                int i4 = 0;
                while (i4 < min) {
                    int i5 = i2 + 1;
                    int i6 = i3 + 1;
                    if (hVar.a[i2] != hVar2.a[i3]) {
                        return false;
                    }
                    i4++;
                    i2 = i5;
                    i3 = i6;
                }
                if (i2 == hVar.c) {
                    hVar = hVar.f8943f;
                    i2 = hVar.b;
                }
                if (i3 == hVar2.c) {
                    hVar2 = hVar2.f8943f;
                    i3 = hVar2.b;
                }
                j3 += min;
            }
            return true;
        }
        return false;
    }

    public b f0(String str) {
        g0(str, 0, str.length());
        return this;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // okio.d
    public long g(ByteString byteString) throws IOException {
        return x(byteString, 0L);
    }

    public b g0(String str, int i2, int i3) {
        if (str != null) {
            if (i2 < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i2);
            } else if (i3 >= i2) {
                if (i3 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                }
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt < 128) {
                        h a0 = a0(1);
                        byte[] bArr = a0.a;
                        int i4 = a0.c - i2;
                        int min = Math.min(i3, 8192 - i4);
                        int i5 = i2 + 1;
                        bArr[i2 + i4] = (byte) charAt;
                        while (i5 < min) {
                            char charAt2 = str.charAt(i5);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i5 + i4] = (byte) charAt2;
                            i5++;
                        }
                        int i6 = a0.c;
                        int i7 = (i4 + i5) - i6;
                        a0.c = i6 + i7;
                        this.b += i7;
                        i2 = i5;
                    } else {
                        if (charAt < 2048) {
                            d0((charAt >> 6) | 192);
                            d0((charAt & '?') | 128);
                        } else if (charAt >= 55296 && charAt <= 57343) {
                            int i8 = i2 + 1;
                            char charAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                            if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                d0((i9 >> 18) | 240);
                                d0(((i9 >> 12) & 63) | 128);
                                d0(((i9 >> 6) & 63) | 128);
                                d0((i9 & 63) | 128);
                                i2 += 2;
                            } else {
                                d0(63);
                                i2 = i8;
                            }
                        } else {
                            d0((charAt >> '\f') | 224);
                            d0(((charAt >> 6) & 63) | 128);
                            d0((charAt & '?') | 128);
                        }
                        i2++;
                    }
                }
                return this;
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public int hashCode() {
        h hVar = this.a;
        if (hVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = hVar.c;
            for (int i4 = hVar.b; i4 < i3; i4++) {
                i2 = (i2 * 31) + hVar.a[i4];
            }
            hVar = hVar.f8943f;
        } while (hVar != this.a);
        return i2;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // okio.c
    public /* bridge */ /* synthetic */ c k(String str) throws IOException {
        f0(str);
        return this;
    }

    @Override // okio.c
    public /* bridge */ /* synthetic */ c l(String str, int i2, int i3) throws IOException {
        g0(str, i2, i3);
        return this;
    }

    @Override // okio.c
    public /* bridge */ /* synthetic */ c q(int i2) throws IOException {
        d0(i2);
        return this;
    }

    @Override // okio.j
    public long r(b bVar, long j2) {
        if (bVar != null) {
            if (j2 >= 0) {
                long j3 = this.b;
                if (j3 == 0) {
                    return -1L;
                }
                if (j2 > j3) {
                    j2 = j3;
                }
                bVar.c0(this, j2);
                return j2;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public int read(byte[] bArr, int i2, int i3) {
        l.b(bArr.length, i2, i3);
        h hVar = this.a;
        if (hVar == null) {
            return -1;
        }
        int min = Math.min(i3, hVar.c - hVar.b);
        System.arraycopy(hVar.a, hVar.b, bArr, i2, min);
        int i4 = hVar.b + min;
        hVar.b = i4;
        this.b -= min;
        if (i4 == hVar.c) {
            this.a = hVar.b();
            i.a(hVar);
        }
        return min;
    }

    @Override // okio.d
    public boolean request(long j2) {
        return this.b >= j2;
    }

    public final long size() {
        return this.b;
    }

    /* renamed from: t */
    public b clone() {
        b bVar = new b();
        if (this.b == 0) {
            return bVar;
        }
        h d2 = this.a.d();
        bVar.a = d2;
        d2.f8944g = d2;
        d2.f8943f = d2;
        h hVar = this.a;
        while (true) {
            hVar = hVar.f8943f;
            if (hVar != this.a) {
                bVar.a.f8944g.c(hVar.d());
            } else {
                bVar.b = this.b;
                return bVar;
            }
        }
    }

    public String toString() {
        return Y().toString();
    }

    public boolean v() {
        return this.b == 0;
    }

    public final byte w(long j2) {
        int i2;
        l.b(this.b, j2, 1L);
        long j3 = this.b;
        if (j3 - j2 > j2) {
            h hVar = this.a;
            while (true) {
                int i3 = hVar.c;
                int i4 = hVar.b;
                long j4 = i3 - i4;
                if (j2 < j4) {
                    return hVar.a[i4 + ((int) j2)];
                }
                j2 -= j4;
                hVar = hVar.f8943f;
            }
        } else {
            long j5 = j2 - j3;
            h hVar2 = this.a;
            do {
                hVar2 = hVar2.f8944g;
                int i5 = hVar2.c;
                i2 = hVar2.b;
                j5 += i5 - i2;
            } while (j5 < 0);
            return hVar2.a[i2 + ((int) j5)];
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                h a0 = a0(1);
                int min = Math.min(i2, 8192 - a0.c);
                byteBuffer.get(a0.a, a0.c, min);
                i2 -= min;
                a0.c += min;
            }
            this.b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long x(ByteString byteString, long j2) throws IOException {
        byte[] bArr;
        if (byteString.size() != 0) {
            long j3 = 0;
            if (j2 >= 0) {
                h hVar = this.a;
                long j4 = -1;
                if (hVar == null) {
                    return -1L;
                }
                long j5 = this.b;
                if (j5 - j2 < j2) {
                    while (j5 > j2) {
                        hVar = hVar.f8944g;
                        j5 -= hVar.c - hVar.b;
                    }
                } else {
                    while (true) {
                        long j6 = (hVar.c - hVar.b) + j3;
                        if (j6 >= j2) {
                            break;
                        }
                        hVar = hVar.f8943f;
                        j3 = j6;
                    }
                    j5 = j3;
                }
                byte b = byteString.getByte(0);
                int size = byteString.size();
                long j7 = 1 + (this.b - size);
                long j8 = j2;
                h hVar2 = hVar;
                long j9 = j5;
                while (j9 < j7) {
                    byte[] bArr2 = hVar2.a;
                    int min = (int) Math.min(hVar2.c, (hVar2.b + j7) - j9);
                    int i2 = (int) ((hVar2.b + j8) - j9);
                    while (i2 < min) {
                        if (bArr2[i2] == b) {
                            bArr = bArr2;
                            if (z(hVar2, i2 + 1, byteString, 1, size)) {
                                return (i2 - hVar2.b) + j9;
                            }
                        } else {
                            bArr = bArr2;
                        }
                        i2++;
                        bArr2 = bArr;
                    }
                    j9 += hVar2.c - hVar2.b;
                    hVar2 = hVar2.f8943f;
                    j8 = j9;
                    j4 = -1;
                }
                return j4;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public long y(ByteString byteString, long j2) {
        int i2;
        int i3;
        long j3 = 0;
        if (j2 >= 0) {
            h hVar = this.a;
            if (hVar == null) {
                return -1L;
            }
            long j4 = this.b;
            if (j4 - j2 < j2) {
                while (j4 > j2) {
                    hVar = hVar.f8944g;
                    j4 -= hVar.c - hVar.b;
                }
            } else {
                while (true) {
                    long j5 = (hVar.c - hVar.b) + j3;
                    if (j5 >= j2) {
                        break;
                    }
                    hVar = hVar.f8943f;
                    j3 = j5;
                }
                j4 = j3;
            }
            if (byteString.size() == 2) {
                byte b = byteString.getByte(0);
                byte b2 = byteString.getByte(1);
                while (j4 < this.b) {
                    byte[] bArr = hVar.a;
                    i2 = (int) ((hVar.b + j2) - j4);
                    int i4 = hVar.c;
                    while (i2 < i4) {
                        byte b3 = bArr[i2];
                        if (b3 == b || b3 == b2) {
                            i3 = hVar.b;
                            return (i2 - i3) + j4;
                        }
                        i2++;
                    }
                    j4 += hVar.c - hVar.b;
                    hVar = hVar.f8943f;
                    j2 = j4;
                }
                return -1L;
            }
            byte[] internalArray = byteString.internalArray();
            while (j4 < this.b) {
                byte[] bArr2 = hVar.a;
                i2 = (int) ((hVar.b + j2) - j4);
                int i5 = hVar.c;
                while (i2 < i5) {
                    byte b4 = bArr2[i2];
                    for (byte b5 : internalArray) {
                        if (b4 == b5) {
                            i3 = hVar.b;
                            return (i2 - i3) + j4;
                        }
                    }
                    i2++;
                }
                j4 += hVar.c - hVar.b;
                hVar = hVar.f8943f;
                j2 = j4;
            }
            return -1L;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        h hVar = this.a;
        if (hVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), hVar.c - hVar.b);
        byteBuffer.put(hVar.a, hVar.b, min);
        int i2 = hVar.b + min;
        hVar.b = i2;
        this.b -= min;
        if (i2 == hVar.c) {
            this.a = hVar.b();
            i.a(hVar);
        }
        return min;
    }
}
