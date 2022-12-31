package com.tapjoy.internal;
/* loaded from: classes3.dex */
public final class el {
    final is a;

    public el(is isVar) {
        this.a = isVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, eg egVar) {
        return (i2 << 3) | egVar.f7398e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(long j2) {
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (((-16384) & j2) == 0) {
            return 2;
        }
        if (((-2097152) & j2) == 0) {
            return 3;
        }
        if (((-268435456) & j2) == 0) {
            return 4;
        }
        if (((-34359738368L) & j2) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j2) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j2) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j2) == 0) {
            return 8;
        }
        return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public final void c(int i2) {
        while ((i2 & (-128)) != 0) {
            this.a.e((i2 & 127) | 128);
            i2 >>>= 7;
        }
        this.a.e(i2);
    }

    public final void d(int i2) {
        this.a.d(i2);
    }

    public final void a(iu iuVar) {
        this.a.b(iuVar);
    }

    public final void d(long j2) {
        this.a.f(j2);
    }

    public final void c(long j2) {
        while (((-128) & j2) != 0) {
            this.a.e((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        this.a.e((int) j2);
    }
}
