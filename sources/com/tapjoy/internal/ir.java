package com.tapjoy.internal;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.EOFException;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
public final class ir implements is, it, Cloneable {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    iy a;
    long b;

    @Override // com.tapjoy.internal.is
    public final is a() {
        return this;
    }

    @Override // com.tapjoy.internal.it
    public final void a(long j2) {
        if (this.b < j2) {
            throw new EOFException();
        }
    }

    @Override // com.tapjoy.internal.it
    public final byte c() {
        long j2 = this.b;
        if (j2 != 0) {
            iy iyVar = this.a;
            int i2 = iyVar.b;
            int i3 = iyVar.c;
            int i4 = i2 + 1;
            byte b = iyVar.a[i2];
            this.b = j2 - 1;
            if (i4 == i3) {
                this.a = iyVar.a();
                iz.a(iyVar);
            } else {
                iyVar.b = i4;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // com.tapjoy.internal.jb, java.io.Closeable, java.lang.AutoCloseable, com.tapjoy.internal.jc
    public final void close() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ir) {
            ir irVar = (ir) obj;
            long j2 = this.b;
            if (j2 != irVar.b) {
                return false;
            }
            long j3 = 0;
            if (j2 == 0) {
                return true;
            }
            iy iyVar = this.a;
            iy iyVar2 = irVar.a;
            int i2 = iyVar.b;
            int i3 = iyVar2.b;
            while (j3 < this.b) {
                long min = Math.min(iyVar.c - i2, iyVar2.c - i3);
                int i4 = 0;
                while (i4 < min) {
                    int i5 = i2 + 1;
                    int i6 = i3 + 1;
                    if (iyVar.a[i2] != iyVar2.a[i3]) {
                        return false;
                    }
                    i4++;
                    i2 = i5;
                    i3 = i6;
                }
                if (i2 == iyVar.c) {
                    iyVar = iyVar.f7735f;
                    i2 = iyVar.b;
                }
                if (i3 == iyVar2.c) {
                    iyVar2 = iyVar2.f7735f;
                    i3 = iyVar2.b;
                }
                j3 += min;
            }
            return true;
        }
        return false;
    }

    @Override // com.tapjoy.internal.jb, java.io.Flushable
    public final void flush() {
    }

    public final byte[] g() {
        try {
            return g(this.b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: h */
    public final ir clone() {
        ir irVar = new ir();
        if (this.b == 0) {
            return irVar;
        }
        iy iyVar = new iy(this.a);
        irVar.a = iyVar;
        iyVar.f7736g = iyVar;
        iyVar.f7735f = iyVar;
        iy iyVar2 = this.a;
        while (true) {
            iyVar2 = iyVar2.f7735f;
            if (iyVar2 != this.a) {
                irVar.a.f7736g.a(new iy(iyVar2));
            } else {
                irVar.b = this.b;
                return irVar;
            }
        }
    }

    public final int hashCode() {
        iy iyVar = this.a;
        if (iyVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = iyVar.c;
            for (int i4 = iyVar.b; i4 < i3; i4++) {
                i2 = (i2 * 31) + iyVar.a[i4];
            }
            iyVar = iyVar.f7735f;
        } while (iyVar != this.a);
        return i2;
    }

    public final String toString() {
        iu jaVar;
        long j2 = this.b;
        if (j2 <= 2147483647L) {
            int i2 = (int) j2;
            if (i2 == 0) {
                jaVar = iu.b;
            } else {
                jaVar = new ja(this, i2);
            }
            return jaVar.toString();
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    private void a(byte[] bArr) {
        int min;
        int i2 = 0;
        while (i2 < bArr.length) {
            int length = bArr.length - i2;
            je.a(bArr.length, i2, length);
            iy iyVar = this.a;
            if (iyVar == null) {
                min = -1;
            } else {
                min = Math.min(length, iyVar.c - iyVar.b);
                System.arraycopy(iyVar.a, iyVar.b, bArr, i2, min);
                int i3 = iyVar.b + min;
                iyVar.b = i3;
                this.b -= min;
                if (i3 == iyVar.c) {
                    this.a = iyVar.a();
                    iz.a(iyVar);
                }
            }
            if (min == -1) {
                throw new EOFException();
            }
            i2 += min;
        }
    }

    public final int d() {
        long j2 = this.b;
        if (j2 >= 4) {
            iy iyVar = this.a;
            int i2 = iyVar.b;
            int i3 = iyVar.c;
            if (i3 - i2 < 4) {
                return ((c() & Draft_75.END_OF_FRAME) << 24) | ((c() & Draft_75.END_OF_FRAME) << 16) | ((c() & Draft_75.END_OF_FRAME) << 8) | (c() & Draft_75.END_OF_FRAME);
            }
            byte[] bArr = iyVar.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & Draft_75.END_OF_FRAME) << 24) | ((bArr[i4] & Draft_75.END_OF_FRAME) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & Draft_75.END_OF_FRAME) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | (bArr[i7] & Draft_75.END_OF_FRAME);
            this.b = j2 - 4;
            if (i9 == i3) {
                this.a = iyVar.a();
                iz.a(iyVar);
            } else {
                iyVar.b = i9;
            }
            return i10;
        }
        throw new IllegalStateException("size < 4: " + this.b);
    }

    @Override // com.tapjoy.internal.it
    public final int e() {
        return je.a(d());
    }

    @Override // com.tapjoy.internal.it
    public final long f() {
        long j2;
        long j3 = this.b;
        if (j3 >= 8) {
            iy iyVar = this.a;
            int i2 = iyVar.b;
            int i3 = iyVar.c;
            if (i3 - i2 < 8) {
                j2 = ((d() & 4294967295L) << 32) | (4294967295L & d());
            } else {
                byte[] bArr = iyVar.a;
                int i4 = i2 + 1;
                int i5 = i4 + 1;
                long j4 = (bArr[i4] & 255) << 48;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                int i11 = i10 + 1;
                long j5 = j4 | ((bArr[i2] & 255) << 56) | ((bArr[i5] & 255) << 40) | ((bArr[i6] & 255) << 32) | ((bArr[i7] & 255) << 24) | ((bArr[i8] & 255) << 16) | ((bArr[i9] & 255) << 8) | (bArr[i10] & 255);
                this.b = j3 - 8;
                if (i11 == i3) {
                    this.a = iyVar.a();
                    iz.a(iyVar);
                } else {
                    iyVar.b = i11;
                }
                j2 = j5;
            }
            return je.a(j2);
        }
        throw new IllegalStateException("size < 8: " + this.b);
    }

    private byte[] g(long j2) {
        je.a(this.b, 0L, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[(int) j2];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    @Override // com.tapjoy.internal.it
    public final boolean b() {
        return this.b == 0;
    }

    @Override // com.tapjoy.internal.is
    /* renamed from: e */
    public final ir f(long j2) {
        long a = je.a(j2);
        iy c2 = c(8);
        byte[] bArr = c2.a;
        int i2 = c2.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((a >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((a >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((a >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((a >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((a >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((a >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((a >>> 8) & 255);
        bArr[i9] = (byte) (a & 255);
        c2.c = i9 + 1;
        this.b += 8;
        return this;
    }

    @Override // com.tapjoy.internal.it
    public final iu b(long j2) {
        return new iu(g(j2));
    }

    @Override // com.tapjoy.internal.is
    /* renamed from: b */
    public final ir d(int i2) {
        int a = je.a(i2);
        iy c2 = c(4);
        byte[] bArr = c2.a;
        int i3 = c2.c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((a >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((a >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((a >>> 8) & 255);
        bArr[i6] = (byte) (a & 255);
        c2.c = i6 + 1;
        this.b += 4;
        return this;
    }

    @Override // com.tapjoy.internal.it
    public final String c(long j2) {
        Charset charset = je.a;
        je.a(this.b, 0L, j2);
        if (charset != null) {
            if (j2 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
            } else if (j2 == 0) {
                return "";
            } else {
                iy iyVar = this.a;
                if (iyVar.b + j2 > iyVar.c) {
                    return new String(g(j2), charset);
                }
                String str = new String(iyVar.a, iyVar.b, (int) j2, charset);
                int i2 = (int) (iyVar.b + j2);
                iyVar.b = i2;
                this.b -= j2;
                if (i2 == iyVar.c) {
                    this.a = iyVar.a();
                    iz.a(iyVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.tapjoy.internal.is
    /* renamed from: a */
    public final ir b(iu iuVar) {
        if (iuVar != null) {
            iuVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.tapjoy.internal.jc
    public final long b(ir irVar, long j2) {
        if (irVar != null) {
            if (j2 >= 0) {
                long j3 = this.b;
                if (j3 == 0) {
                    return -1L;
                }
                if (j2 > j3) {
                    j2 = j3;
                }
                irVar.a(this, j2);
                return j2;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.tapjoy.internal.is
    /* renamed from: a */
    public final ir b(String str) {
        char charAt;
        int length = str.length();
        if (str != null) {
            if (length >= 0) {
                if (length > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + length + " > " + str.length());
                }
                int i2 = 0;
                while (i2 < length) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 128) {
                        iy c2 = c(1);
                        byte[] bArr = c2.a;
                        int i3 = c2.c - i2;
                        int min = Math.min(length, 8192 - i3);
                        int i4 = i2 + 1;
                        bArr[i2 + i3] = (byte) charAt2;
                        while (true) {
                            i2 = i4;
                            if (i2 >= min || (charAt = str.charAt(i2)) >= 128) {
                                break;
                            }
                            i4 = i2 + 1;
                            bArr[i2 + i3] = (byte) charAt;
                        }
                        int i5 = c2.c;
                        int i6 = (i3 + i2) - i5;
                        c2.c = i5 + i6;
                        this.b += i6;
                    } else {
                        if (charAt2 < 2048) {
                            e((charAt2 >> 6) | 192);
                            e((charAt2 & '?') | 128);
                        } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                            int i7 = i2 + 1;
                            char charAt3 = i7 < length ? str.charAt(i7) : (char) 0;
                            if (charAt2 <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                                e((i8 >> 18) | 240);
                                e(((i8 >> 12) & 63) | 128);
                                e(((i8 >> 6) & 63) | 128);
                                e((i8 & 63) | 128);
                                i2 += 2;
                            } else {
                                e(63);
                                i2 = i7;
                            }
                        } else {
                            e((charAt2 >> '\f') | 224);
                            e(((charAt2 >> 6) & 63) | 128);
                            e((charAt2 & '?') | 128);
                        }
                        i2++;
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("endIndex < beginIndex: " + length + " < 0");
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // com.tapjoy.internal.it
    public final void d(long j2) {
        iy iyVar;
        while (j2 > 0) {
            if (this.a != null) {
                int min = (int) Math.min(j2, iyVar.c - iyVar.b);
                long j3 = min;
                this.b -= j3;
                j2 -= j3;
                iy iyVar2 = this.a;
                int i2 = iyVar2.b + min;
                iyVar2.b = i2;
                if (i2 == iyVar2.c) {
                    this.a = iyVar2.a();
                    iz.a(iyVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final iy c(int i2) {
        if (i2 > 0 && i2 <= 8192) {
            iy iyVar = this.a;
            if (iyVar == null) {
                iy a = iz.a();
                this.a = a;
                a.f7736g = a;
                a.f7735f = a;
                return a;
            }
            iy iyVar2 = iyVar.f7736g;
            return (iyVar2.c + i2 > 8192 || !iyVar2.f7734e) ? iyVar2.a(iz.a()) : iyVar2;
        }
        throw new IllegalArgumentException();
    }

    public final ir a(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j2 = i3;
            je.a(bArr.length, 0L, j2);
            int i4 = i3 + 0;
            while (i2 < i4) {
                iy c2 = c(1);
                int min = Math.min(i4 - i2, 8192 - c2.c);
                System.arraycopy(bArr, i2, c2.a, c2.c, min);
                i2 += min;
                c2.c += min;
            }
            this.b += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.tapjoy.internal.is
    /* renamed from: a */
    public final ir e(int i2) {
        iy c2 = c(1);
        byte[] bArr = c2.a;
        int i3 = c2.c;
        c2.c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.b++;
        return this;
    }

    @Override // com.tapjoy.internal.jb
    public final void a(ir irVar, long j2) {
        iy a;
        if (irVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (irVar != this) {
            je.a(irVar.b, 0L, j2);
            while (j2 > 0) {
                iy iyVar = irVar.a;
                int i2 = iyVar.c;
                int i3 = iyVar.b;
                if (j2 < i2 - i3) {
                    iy iyVar2 = this.a;
                    iy iyVar3 = iyVar2 != null ? iyVar2.f7736g : null;
                    if (iyVar3 != null && iyVar3.f7734e) {
                        if ((iyVar3.c + j2) - (iyVar3.f7733d ? 0 : iyVar3.b) <= 8192) {
                            iyVar.a(iyVar3, (int) j2);
                            irVar.b -= j2;
                            this.b += j2;
                            return;
                        }
                    }
                    int i4 = (int) j2;
                    if (i4 > 0 && i4 <= i2 - i3) {
                        if (i4 >= 1024) {
                            a = new iy(iyVar);
                        } else {
                            a = iz.a();
                            System.arraycopy(iyVar.a, iyVar.b, a.a, 0, i4);
                        }
                        a.c = a.b + i4;
                        iyVar.b += i4;
                        iyVar.f7736g.a(a);
                        irVar.a = a;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                iy iyVar4 = irVar.a;
                long j3 = iyVar4.c - iyVar4.b;
                irVar.a = iyVar4.a();
                iy iyVar5 = this.a;
                if (iyVar5 == null) {
                    this.a = iyVar4;
                    iyVar4.f7736g = iyVar4;
                    iyVar4.f7735f = iyVar4;
                } else {
                    iy a2 = iyVar5.f7736g.a(iyVar4);
                    iy iyVar6 = a2.f7736g;
                    if (iyVar6 != a2) {
                        if (iyVar6.f7734e) {
                            int i5 = a2.c - a2.b;
                            if (i5 <= (8192 - iyVar6.c) + (iyVar6.f7733d ? 0 : iyVar6.b)) {
                                a2.a(iyVar6, i5);
                                a2.a();
                                iz.a(a2);
                            }
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                }
                irVar.b -= j3;
                this.b += j3;
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
}
