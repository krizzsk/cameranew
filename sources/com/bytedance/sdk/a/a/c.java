package com.bytedance.sdk.a.a;

import androidx.core.location.LocationRequestCompat;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
/* compiled from: Buffer.java */
/* loaded from: classes.dex */
public final class c implements d, e, Cloneable, ByteChannel {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    o a;
    long b;

    @Override // com.bytedance.sdk.a.a.e
    public void a(long j2) throws EOFException {
        if (this.b < j2) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a_(c cVar, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar != this) {
            u.a(cVar.b, 0L, j2);
            while (j2 > 0) {
                o oVar = cVar.a;
                if (j2 < oVar.c - oVar.b) {
                    o oVar2 = this.a;
                    o oVar3 = oVar2 != null ? oVar2.f849g : null;
                    if (oVar3 != null && oVar3.f847e) {
                        if ((oVar3.c + j2) - (oVar3.f846d ? 0 : oVar3.b) <= 8192) {
                            oVar.a(oVar3, (int) j2);
                            cVar.b -= j2;
                            this.b += j2;
                            return;
                        }
                    }
                    cVar.a = oVar.a((int) j2);
                }
                o oVar4 = cVar.a;
                long j3 = oVar4.c - oVar4.b;
                cVar.a = oVar4.b();
                o oVar5 = this.a;
                if (oVar5 == null) {
                    this.a = oVar4;
                    oVar4.f849g = oVar4;
                    oVar4.f848f = oVar4;
                } else {
                    oVar5.f849g.a(oVar4).c();
                }
                cVar.b -= j3;
                this.b += j3;
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c c() {
        return this;
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: d */
    public c u() {
        return this;
    }

    public String d(long j2) throws EOFException {
        return a(j2, u.a);
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean e() {
        return this.b == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            long j2 = this.b;
            if (j2 != cVar.b) {
                return false;
            }
            long j3 = 0;
            if (j2 == 0) {
                return true;
            }
            o oVar = this.a;
            o oVar2 = cVar.a;
            int i2 = oVar.b;
            int i3 = oVar2.b;
            while (j3 < this.b) {
                long min = Math.min(oVar.c - i2, oVar2.c - i3);
                int i4 = 0;
                while (i4 < min) {
                    int i5 = i2 + 1;
                    int i6 = i3 + 1;
                    if (oVar.a[i2] != oVar2.a[i3]) {
                        return false;
                    }
                    i4++;
                    i2 = i5;
                    i3 = i6;
                }
                if (i2 == oVar.c) {
                    oVar = oVar.f848f;
                    i2 = oVar.b;
                }
                if (i3 == oVar2.c) {
                    oVar2 = oVar2.f848f;
                    i3 = oVar2.b;
                }
                j3 += min;
            }
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.a.a.e
    public InputStream f() {
        return new InputStream() { // from class: com.bytedance.sdk.a.a.c.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                c cVar = c.this;
                if (cVar.b > 0) {
                    return cVar.h() & Draft_75.END_OF_FRAME;
                }
                return -1;
            }

            public String toString() {
                return c.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) {
                return c.this.a(bArr, i2, i3);
            }
        };
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        o oVar = this.a;
        if (oVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = oVar.c;
            for (int i4 = oVar.b; i4 < i3; i4++) {
                i2 = (i2 * 31) + oVar.a[i4];
            }
            oVar = oVar.f848f;
        } while (oVar != this.a);
        return i2;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.bytedance.sdk.a.a.e
    public int j() {
        long j2 = this.b;
        if (j2 >= 4) {
            o oVar = this.a;
            int i2 = oVar.b;
            int i3 = oVar.c;
            if (i3 - i2 < 4) {
                return ((h() & Draft_75.END_OF_FRAME) << 24) | ((h() & Draft_75.END_OF_FRAME) << 16) | ((h() & Draft_75.END_OF_FRAME) << 8) | (h() & Draft_75.END_OF_FRAME);
            }
            byte[] bArr = oVar.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & Draft_75.END_OF_FRAME) << 24) | ((bArr[i4] & Draft_75.END_OF_FRAME) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & Draft_75.END_OF_FRAME) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | (bArr[i7] & Draft_75.END_OF_FRAME);
            this.b = j2 - 4;
            if (i9 == i3) {
                this.a = oVar.b();
                p.a(oVar);
            } else {
                oVar.b = i9;
            }
            return i10;
        }
        throw new IllegalStateException("size < 4: " + this.b);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a5 A[EDGE_INSN: B:42:0x00a5->B:38:0x00a5 ?: BREAK  , SYNTHETIC] */
    @Override // com.bytedance.sdk.a.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long m() {
        /*
            r15 = this;
            long r0 = r15.b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            com.bytedance.sdk.a.a.o r6 = r15.a
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.c
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            com.bytedance.sdk.a.a.c r0 = new com.bytedance.sdk.a.a.c
            r0.<init>()
            com.bytedance.sdk.a.a.c r0 = r0.k(r4)
            com.bytedance.sdk.a.a.c r0 = r0.i(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.o()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r0 == 0) goto L76
            r1 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            com.bytedance.sdk.a.a.o r7 = r6.b()
            r15.a = r7
            com.bytedance.sdk.a.a.p.a(r6)
            goto L9f
        L9d:
            r6.b = r8
        L9f:
            if (r1 != 0) goto La5
            com.bytedance.sdk.a.a.o r6 = r15.a
            if (r6 != 0) goto Lb
        La5:
            long r1 = r15.b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.b = r1
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.a.c.m():long");
    }

    public f n() {
        return new f(q());
    }

    public String o() {
        try {
            return a(this.b, u.a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public String p() throws EOFException {
        return e(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public byte[] q() {
        try {
            return g(this.b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void r() {
        try {
            h(this.b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.c - oVar.b);
        byteBuffer.put(oVar.a, oVar.b, min);
        int i2 = oVar.b + min;
        oVar.b = i2;
        this.b -= min;
        if (i2 == oVar.c) {
            this.a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    /* renamed from: s */
    public c clone() {
        c cVar = new c();
        if (this.b == 0) {
            return cVar;
        }
        o a = this.a.a();
        cVar.a = a;
        a.f849g = a;
        a.f848f = a;
        o oVar = this.a;
        while (true) {
            oVar = oVar.f848f;
            if (oVar != this.a) {
                cVar.a.f849g.a(oVar.a());
            } else {
                cVar.b = this.b;
                return cVar;
            }
        }
    }

    public final f t() {
        long j2 = this.b;
        if (j2 <= 2147483647L) {
            return f((int) j2);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    public String toString() {
        return t().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                o e2 = e(1);
                int min = Math.min(i2, 8192 - e2.c);
                byteBuffer.get(e2.a, e2.c, min);
                i2 -= min;
                e2.c += min;
            }
            this.b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final c a(c cVar, long j2, long j3) {
        if (cVar != null) {
            u.a(this.b, j2, j3);
            if (j3 == 0) {
                return this;
            }
            cVar.b += j3;
            o oVar = this.a;
            while (true) {
                int i2 = oVar.c;
                int i3 = oVar.b;
                if (j2 < i2 - i3) {
                    break;
                }
                j2 -= i2 - i3;
                oVar = oVar.f848f;
            }
            while (j3 > 0) {
                o a = oVar.a();
                int i4 = (int) (a.b + j2);
                a.b = i4;
                a.c = Math.min(i4 + ((int) j3), a.c);
                o oVar2 = cVar.a;
                if (oVar2 == null) {
                    a.f849g = a;
                    a.f848f = a;
                    cVar.a = a;
                } else {
                    oVar2.f849g.a(a);
                }
                j3 -= a.c - a.b;
                oVar = oVar.f848f;
                j2 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final long b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: d */
    public c g(int i2) {
        o e2 = e(4);
        byte[] bArr = e2.a;
        int i3 = e2.c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        e2.c = i6 + 1;
        this.b += 4;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.e
    public String e(long j2) throws EOFException {
        if (j2 >= 0) {
            long j3 = LocationRequestCompat.PASSIVE_INTERVAL;
            if (j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                j3 = j2 + 1;
            }
            long a = a((byte) 10, 0L, j3);
            if (a != -1) {
                return f(a);
            }
            if (j3 < b() && b(j3 - 1) == 13 && b(j3) == 10) {
                return f(j3);
            }
            c cVar = new c();
            a(cVar, 0L, Math.min(32L, b()));
            throw new EOFException("\\n not found: limit=" + Math.min(b(), j2) + " content=" + cVar.n().e() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f(long j2) throws EOFException {
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (b(j3) == 13) {
                String d2 = d(j3);
                h(2L);
                return d2;
            }
        }
        String d3 = d(j2);
        h(1L);
        return d3;
    }

    public final long g() {
        long j2 = this.b;
        if (j2 == 0) {
            return 0L;
        }
        o oVar = this.a.f849g;
        int i2 = oVar.c;
        return (i2 >= 8192 || !oVar.f847e) ? j2 : j2 - (i2 - oVar.b);
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte h() {
        long j2 = this.b;
        if (j2 != 0) {
            o oVar = this.a;
            int i2 = oVar.b;
            int i3 = oVar.c;
            int i4 = i2 + 1;
            byte b = oVar.a[i2];
            this.b = j2 - 1;
            if (i4 == i3) {
                this.a = oVar.b();
                p.a(oVar);
            } else {
                oVar.b = i4;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // com.bytedance.sdk.a.a.e
    public short i() {
        long j2 = this.b;
        if (j2 >= 2) {
            o oVar = this.a;
            int i2 = oVar.b;
            int i3 = oVar.c;
            if (i3 - i2 < 2) {
                return (short) (((h() & Draft_75.END_OF_FRAME) << 8) | (h() & Draft_75.END_OF_FRAME));
            }
            byte[] bArr = oVar.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & Draft_75.END_OF_FRAME) << 8) | (bArr[i4] & Draft_75.END_OF_FRAME);
            this.b = j2 - 2;
            if (i5 == i3) {
                this.a = oVar.b();
                p.a(oVar);
            } else {
                oVar.b = i5;
            }
            return (short) i6;
        }
        throw new IllegalStateException("size < 2: " + this.b);
    }

    @Override // com.bytedance.sdk.a.a.e
    public short k() {
        return u.a(i());
    }

    @Override // com.bytedance.sdk.a.a.e
    public int l() {
        return u.a(j());
    }

    public final byte b(long j2) {
        int i2;
        u.a(this.b, j2, 1L);
        long j3 = this.b;
        if (j3 - j2 > j2) {
            o oVar = this.a;
            while (true) {
                int i3 = oVar.c;
                int i4 = oVar.b;
                long j4 = i3 - i4;
                if (j2 < j4) {
                    return oVar.a[i4 + ((int) j2)];
                }
                j2 -= j4;
                oVar = oVar.f848f;
            }
        } else {
            long j5 = j2 - j3;
            o oVar2 = this.a;
            do {
                oVar2 = oVar2.f849g;
                int i5 = oVar2.c;
                i2 = oVar2.b;
                j5 += i5 - i2;
            } while (j5 < 0);
            return oVar2.a[i2 + ((int) j5)];
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public f c(long j2) throws EOFException {
        return new f(g(j2));
    }

    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: c */
    public c h(int i2) {
        o e2 = e(2);
        byte[] bArr = e2.a;
        int i3 = e2.c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        e2.c = i4 + 1;
        this.b += 2;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte[] g(long j2) throws EOFException {
        u.a(this.b, 0L, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[(int) j2];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    public final f f(int i2) {
        if (i2 == 0) {
            return f.b;
        }
        return new q(this, i2);
    }

    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: b */
    public c c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o e(int i2) {
        if (i2 >= 1 && i2 <= 8192) {
            o oVar = this.a;
            if (oVar == null) {
                o a = p.a();
                this.a = a;
                a.f849g = a;
                a.f848f = a;
                return a;
            }
            o oVar2 = oVar.f849g;
            return (oVar2.c + i2 > 8192 || !oVar2.f847e) ? oVar2.a(p.a()) : oVar2;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.sdk.a.a.e
    public void h(long j2) throws EOFException {
        o oVar;
        while (j2 > 0) {
            if (this.a != null) {
                int min = (int) Math.min(j2, oVar.c - oVar.b);
                long j3 = min;
                this.b -= j3;
                j2 -= j3;
                o oVar2 = this.a;
                int i2 = oVar2.b + min;
                oVar2.b = i2;
                if (i2 == oVar2.c) {
                    this.a = oVar2.b();
                    p.a(oVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: b */
    public c c(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j2 = i3;
            u.a(bArr.length, i2, j2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                o e2 = e(1);
                int min = Math.min(i4 - i2, 8192 - e2.c);
                System.arraycopy(bArr, i2, e2.a, e2.c, min);
                i2 += min;
                e2.c += min;
            }
            this.b += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public String a(long j2, Charset charset) throws EOFException {
        u.a(this.b, 0L, j2);
        if (charset != null) {
            if (j2 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
            } else if (j2 == 0) {
                return "";
            } else {
                o oVar = this.a;
                if (oVar.b + j2 > oVar.c) {
                    return new String(g(j2), charset);
                }
                String str = new String(oVar.a, oVar.b, (int) j2, charset);
                int i2 = (int) (oVar.b + j2);
                oVar.b = i2;
                this.b -= j2;
                if (i2 == oVar.c) {
                    this.a = oVar.b();
                    p.a(oVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: i */
    public c l(long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 == 0) {
            return i(48);
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i3 = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i3 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i3 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        o e2 = e(i3);
        byte[] bArr = e2.a;
        int i4 = e2.c + i3;
        while (j2 != 0) {
            i4--;
            bArr[i4] = c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i4 - 1] = 45;
        }
        e2.c += i3;
        this.b += i3;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: j */
    public c k(long j2) {
        if (j2 == 0) {
            return i(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
        o e2 = e(numberOfTrailingZeros);
        byte[] bArr = e2.a;
        int i2 = e2.c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = c[(int) (15 & j2)];
            j2 >>>= 4;
        }
        e2.c += numberOfTrailingZeros;
        this.b += numberOfTrailingZeros;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: b */
    public c i(int i2) {
        o e2 = e(1);
        byte[] bArr = e2.a;
        int i3 = e2.c;
        e2.c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.b++;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a = a(bArr, i2, bArr.length - i2);
            if (a == -1) {
                throw new EOFException();
            }
            i2 += a;
        }
    }

    public int a(byte[] bArr, int i2, int i3) {
        u.a(bArr.length, i2, i3);
        o oVar = this.a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i3, oVar.c - oVar.b);
        System.arraycopy(oVar.a, oVar.b, bArr, i2, min);
        int i4 = oVar.b + min;
        oVar.b = i4;
        this.b -= min;
        if (i4 == oVar.c) {
            this.a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    public c a(f fVar) {
        if (fVar != null) {
            fVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.bytedance.sdk.a.a.d
    /* renamed from: a */
    public c b(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i2, int i3) {
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
                        o e2 = e(1);
                        byte[] bArr = e2.a;
                        int i4 = e2.c - i2;
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
                        int i6 = e2.c;
                        int i7 = (i4 + i5) - i6;
                        e2.c = i6 + i7;
                        this.b += i7;
                        i2 = i5;
                    } else {
                        if (charAt < 2048) {
                            i((charAt >> 6) | 192);
                            i((charAt & '?') | 128);
                        } else if (charAt >= 55296 && charAt <= 57343) {
                            int i8 = i2 + 1;
                            char charAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                            if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                i((i9 >> 18) | 240);
                                i(((i9 >> 12) & 63) | 128);
                                i(((i9 >> 6) & 63) | 128);
                                i((i9 & 63) | 128);
                                i2 += 2;
                            } else {
                                i(63);
                                i2 = i8;
                            }
                        } else {
                            i((charAt >> '\f') | 224);
                            i(((charAt >> 6) & 63) | 128);
                            i((charAt & '?') | 128);
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

    public c a(int i2) {
        if (i2 < 128) {
            i(i2);
        } else if (i2 < 2048) {
            i((i2 >> 6) | 192);
            i((i2 & 63) | 128);
        } else if (i2 < 65536) {
            if (i2 >= 55296 && i2 <= 57343) {
                i(63);
            } else {
                i((i2 >> 12) | 224);
                i(((i2 >> 6) & 63) | 128);
                i((i2 & 63) | 128);
            }
        } else if (i2 <= 1114111) {
            i((i2 >> 18) | 240);
            i(((i2 >> 12) & 63) | 128);
            i(((i2 >> 6) & 63) | 128);
            i((i2 & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
        }
        return this;
    }

    public c a(String str, int i2, int i3, Charset charset) {
        if (str != null) {
            if (i2 < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i2);
            } else if (i3 >= i2) {
                if (i3 <= str.length()) {
                    if (charset != null) {
                        if (charset.equals(u.a)) {
                            return a(str, i2, i3);
                        }
                        byte[] bytes = str.substring(i2, i3).getBytes(charset);
                        return c(bytes, 0, bytes.length);
                    }
                    throw new IllegalArgumentException("charset == null");
                }
                throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = 0;
        while (true) {
            long a = sVar.a(this, 8192L);
            if (a == -1) {
                return j2;
            }
            j2 += a;
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j2) {
        if (cVar != null) {
            if (j2 >= 0) {
                long j3 = this.b;
                if (j3 == 0) {
                    return -1L;
                }
                if (j2 > j3) {
                    j2 = j3;
                }
                cVar.a_(this, j2);
                return j2;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.bytedance.sdk.a.a.e
    public long a(byte b) {
        return a(b, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long a(byte b, long j2, long j3) {
        o oVar;
        long j4 = 0;
        if (j2 >= 0 && j3 >= j2) {
            long j5 = this.b;
            long j6 = j3 > j5 ? j5 : j3;
            if (j2 == j6 || (oVar = this.a) == null) {
                return -1L;
            }
            if (j5 - j2 < j2) {
                while (j5 > j2) {
                    oVar = oVar.f849g;
                    j5 -= oVar.c - oVar.b;
                }
            } else {
                while (true) {
                    long j7 = (oVar.c - oVar.b) + j4;
                    if (j7 >= j2) {
                        break;
                    }
                    oVar = oVar.f848f;
                    j4 = j7;
                }
                j5 = j4;
            }
            long j8 = j2;
            while (j5 < j6) {
                byte[] bArr = oVar.a;
                int min = (int) Math.min(oVar.c, (oVar.b + j6) - j5);
                for (int i2 = (int) ((oVar.b + j8) - j5); i2 < min; i2++) {
                    if (bArr[i2] == b) {
                        return (i2 - oVar.b) + j5;
                    }
                }
                j5 += oVar.c - oVar.b;
                oVar = oVar.f848f;
                j8 = j5;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.b), Long.valueOf(j2), Long.valueOf(j3)));
    }

    @Override // com.bytedance.sdk.a.a.r
    public t a() {
        return t.c;
    }
}
