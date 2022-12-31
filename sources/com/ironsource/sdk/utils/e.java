package com.ironsource.sdk.utils;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* compiled from: MD5Hashing.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f5780d = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private b a = new b();
    private b b = new b();
    private int[] c = new int[16];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MD5Hashing.java */
    /* loaded from: classes2.dex */
    public class b {
        private boolean a;
        private int[] b;
        private long c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f5781d;

        /* JADX INFO: Access modifiers changed from: private */
        public void i(b bVar) {
            byte[] bArr = bVar.f5781d;
            byte[] bArr2 = this.f5781d;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            int[] iArr = bVar.b;
            int[] iArr2 = this.b;
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            this.a = bVar.a;
            this.c = bVar.c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            int[] iArr = this.b;
            iArr[0] = 1732584193;
            iArr[1] = -271733879;
            iArr[2] = -1732584194;
            iArr[3] = 271733878;
            this.c = 0L;
        }

        private b(e eVar) {
            this.a = true;
            this.b = new int[4];
            this.f5781d = new byte[64];
            j();
        }
    }

    e() {
        k();
    }

    private static int a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 + ((i4 & i3) | (i5 & (~i3))) + i6 + i8;
        return ((i9 >>> (32 - i7)) | (i9 << i7)) + i3;
    }

    private static int b(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 + ((i4 & (~i5)) | (i3 & i5)) + i6 + i8;
        return ((i9 >>> (32 - i7)) | (i9 << i7)) + i3;
    }

    private static int c(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 + ((i4 ^ i3) ^ i5) + i6 + i8;
        return ((i9 >>> (32 - i7)) | (i9 << i7)) + i3;
    }

    private static int d(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 + (i4 ^ ((~i5) | i3)) + i6 + i8;
        return ((i9 >>> (32 - i7)) | (i9 << i7)) + i3;
    }

    private int[] e(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5 += 4) {
            this.c[i4] = (bArr[i5 + i3] & Draft_75.END_OF_FRAME) | ((bArr[(i5 + 1) + i3] & Draft_75.END_OF_FRAME) << 8) | ((bArr[(i5 + 2) + i3] & Draft_75.END_OF_FRAME) << 16) | ((bArr[(i5 + 3) + i3] & Draft_75.END_OF_FRAME) << 24);
            i4++;
        }
        return this.c;
    }

    private static byte[] f(long j2) {
        return new byte[]{(byte) (j2 & 255), (byte) ((j2 >>> 8) & 255), (byte) ((j2 >>> 16) & 255), (byte) ((j2 >>> 24) & 255), (byte) ((j2 >>> 32) & 255), (byte) ((j2 >>> 40) & 255), (byte) ((j2 >>> 48) & 255), (byte) ((j2 >>> 56) & 255)};
    }

    private static byte[] g(int[] iArr, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4 += 4) {
            bArr[i4] = (byte) (iArr[i3] & 255);
            bArr[i4 + 1] = (byte) ((iArr[i3] >>> 8) & 255);
            bArr[i4 + 2] = (byte) ((iArr[i3] >>> 16) & 255);
            bArr[i4 + 3] = (byte) ((iArr[i3] >>> 24) & 255);
            i3++;
        }
        return bArr;
    }

    public static String j(String str) {
        e eVar = new e();
        eVar.o(str);
        return eVar.i();
    }

    private static String l(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            int i2 = b2 & Draft_75.END_OF_FRAME;
            if (i2 < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i2));
        }
        return stringBuffer.toString();
    }

    private static void m(b bVar, int[] iArr) {
        int i2 = bVar.b[0];
        int i3 = bVar.b[1];
        int i4 = bVar.b[2];
        int i5 = bVar.b[3];
        int a2 = a(i2, i3, i4, i5, iArr[0], 7, -680876936);
        int a3 = a(i5, a2, i3, i4, iArr[1], 12, -389564586);
        int a4 = a(i4, a3, a2, i3, iArr[2], 17, 606105819);
        int a5 = a(i3, a4, a3, a2, iArr[3], 22, -1044525330);
        int a6 = a(a2, a5, a4, a3, iArr[4], 7, -176418897);
        int a7 = a(a3, a6, a5, a4, iArr[5], 12, 1200080426);
        int a8 = a(a4, a7, a6, a5, iArr[6], 17, -1473231341);
        int a9 = a(a5, a8, a7, a6, iArr[7], 22, -45705983);
        int a10 = a(a6, a9, a8, a7, iArr[8], 7, 1770035416);
        int a11 = a(a7, a10, a9, a8, iArr[9], 12, -1958414417);
        int a12 = a(a8, a11, a10, a9, iArr[10], 17, -42063);
        int a13 = a(a9, a12, a11, a10, iArr[11], 22, -1990404162);
        int a14 = a(a10, a13, a12, a11, iArr[12], 7, 1804603682);
        int a15 = a(a11, a14, a13, a12, iArr[13], 12, -40341101);
        int a16 = a(a12, a15, a14, a13, iArr[14], 17, -1502002290);
        int a17 = a(a13, a16, a15, a14, iArr[15], 22, 1236535329);
        int b2 = b(a14, a17, a16, a15, iArr[1], 5, -165796510);
        int b3 = b(a15, b2, a17, a16, iArr[6], 9, -1069501632);
        int b4 = b(a16, b3, b2, a17, iArr[11], 14, 643717713);
        int b5 = b(a17, b4, b3, b2, iArr[0], 20, -373897302);
        int b6 = b(b2, b5, b4, b3, iArr[5], 5, -701558691);
        int b7 = b(b3, b6, b5, b4, iArr[10], 9, 38016083);
        int b8 = b(b4, b7, b6, b5, iArr[15], 14, -660478335);
        int b9 = b(b5, b8, b7, b6, iArr[4], 20, -405537848);
        int b10 = b(b6, b9, b8, b7, iArr[9], 5, 568446438);
        int b11 = b(b7, b10, b9, b8, iArr[14], 9, -1019803690);
        int b12 = b(b8, b11, b10, b9, iArr[3], 14, -187363961);
        int b13 = b(b9, b12, b11, b10, iArr[8], 20, 1163531501);
        int b14 = b(b10, b13, b12, b11, iArr[13], 5, -1444681467);
        int b15 = b(b11, b14, b13, b12, iArr[2], 9, -51403784);
        int b16 = b(b12, b15, b14, b13, iArr[7], 14, 1735328473);
        int b17 = b(b13, b16, b15, b14, iArr[12], 20, -1926607734);
        int c = c(b14, b17, b16, b15, iArr[5], 4, -378558);
        int c2 = c(b15, c, b17, b16, iArr[8], 11, -2022574463);
        int c3 = c(b16, c2, c, b17, iArr[11], 16, 1839030562);
        int c4 = c(b17, c3, c2, c, iArr[14], 23, -35309556);
        int c5 = c(c, c4, c3, c2, iArr[1], 4, -1530992060);
        int c6 = c(c2, c5, c4, c3, iArr[4], 11, 1272893353);
        int c7 = c(c3, c6, c5, c4, iArr[7], 16, -155497632);
        int c8 = c(c4, c7, c6, c5, iArr[10], 23, -1094730640);
        int c9 = c(c5, c8, c7, c6, iArr[13], 4, 681279174);
        int c10 = c(c6, c9, c8, c7, iArr[0], 11, -358537222);
        int c11 = c(c7, c10, c9, c8, iArr[3], 16, -722521979);
        int c12 = c(c8, c11, c10, c9, iArr[6], 23, 76029189);
        int c13 = c(c9, c12, c11, c10, iArr[9], 4, -640364487);
        int c14 = c(c10, c13, c12, c11, iArr[12], 11, -421815835);
        int c15 = c(c11, c14, c13, c12, iArr[15], 16, 530742520);
        int c16 = c(c12, c15, c14, c13, iArr[2], 23, -995338651);
        int d2 = d(c13, c16, c15, c14, iArr[0], 6, -198630844);
        int d3 = d(c14, d2, c16, c15, iArr[7], 10, 1126891415);
        int d4 = d(c15, d3, d2, c16, iArr[14], 15, -1416354905);
        int d5 = d(c16, d4, d3, d2, iArr[5], 21, -57434055);
        int d6 = d(d2, d5, d4, d3, iArr[12], 6, 1700485571);
        int d7 = d(d3, d6, d5, d4, iArr[3], 10, -1894986606);
        int d8 = d(d4, d7, d6, d5, iArr[10], 15, -1051523);
        int d9 = d(d5, d8, d7, d6, iArr[1], 21, -2054922799);
        int d10 = d(d6, d9, d8, d7, iArr[8], 6, 1873313359);
        int d11 = d(d7, d10, d9, d8, iArr[15], 10, -30611744);
        int d12 = d(d8, d11, d10, d9, iArr[6], 15, -1560198380);
        int d13 = d(d9, d12, d11, d10, iArr[13], 21, 1309151649);
        int d14 = d(d10, d13, d12, d11, iArr[4], 6, -145523070);
        int d15 = d(d11, d14, d13, d12, iArr[11], 10, -1120210379);
        int d16 = d(d12, d15, d14, d13, iArr[2], 15, 718787259);
        int d17 = d(d13, d16, d15, d14, iArr[9], 21, -343485551);
        int[] iArr2 = bVar.b;
        iArr2[0] = iArr2[0] + d14;
        int[] iArr3 = bVar.b;
        iArr3[1] = iArr3[1] + d17;
        int[] iArr4 = bVar.b;
        iArr4[2] = iArr4[2] + d16;
        int[] iArr5 = bVar.b;
        iArr5[3] = iArr5[3] + d15;
    }

    private void n(b bVar, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        this.b.a = false;
        if (i3 + i2 > bArr.length) {
            i3 = bArr.length - i2;
        }
        int i5 = ((int) (bVar.c >>> 3)) & 63;
        bVar.c += i3 << 3;
        int i6 = 64 - i5;
        if (i3 >= i6) {
            System.arraycopy(bArr, i2, bVar.f5781d, i5, i6);
            m(bVar, e(bVar.f5781d, 64, 0));
            while (i6 + 63 < i3) {
                m(bVar, e(bArr, 64, i6));
                i6 += 64;
            }
            i4 = i6;
            i5 = 0;
        }
        if (i4 < i3) {
            for (int i7 = i4; i7 < i3; i7++) {
                bVar.f5781d[(i5 + i7) - i4] = bArr[i7 + i2];
            }
        }
    }

    public byte[] h() {
        if (!this.b.a) {
            this.b.i(this.a);
            long j2 = this.b.c;
            int i2 = (int) ((j2 >>> 3) & 63);
            n(this.b, f5780d, 0, i2 < 56 ? 56 - i2 : 120 - i2);
            n(this.b, f(j2), 0, 8);
            this.b.a = true;
        }
        return g(this.b.b, 16);
    }

    public String i() {
        return l(h());
    }

    public void k() {
        this.a.j();
        this.b.a = false;
    }

    public void o(String str) {
        p(str.getBytes());
    }

    public void p(byte[] bArr) {
        q(bArr, 0, bArr.length);
    }

    public void q(byte[] bArr, int i2, int i3) {
        n(this.a, bArr, i2, i3);
    }

    public String toString() {
        return i();
    }
}
