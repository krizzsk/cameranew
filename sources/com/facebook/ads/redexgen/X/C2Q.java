package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.2Q  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2Q<E> implements Cloneable {
    public static byte[] A04;
    public static final Object A05;
    public int A00;
    public boolean A01;
    public long[] A02;
    public Object[] A03;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 54);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A04 = new byte[]{19, 79, 83, 82, 72, 27, 118, 90, 75, 18, 91, 87, 51, 53};
    }

    static {
        A05();
        A05 = new Object();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public C2Q() {
        this(10);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public C2Q(int i2) {
        this.A01 = false;
        if (i2 == 0) {
            this.A02 = C2P.A01;
            this.A03 = C2P.A02;
        } else {
            int A00 = C2P.A00(i2);
            this.A02 = new long[A00];
            this.A03 = new Object[A00];
        }
        this.A00 = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    private final long A00(int i2) {
        if (this.A01) {
            A04();
        }
        return this.A02[i2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /* renamed from: A01 */
    public final C2Q<E> clone() {
        C2Q<E> c2q = null;
        try {
            c2q = (C2Q) super.clone();
            c2q.A02 = (long[]) this.A02.clone();
            c2q.A03 = (Object[]) this.A03.clone();
            return c2q;
        } catch (CloneNotSupportedException unused) {
            return c2q;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    private final E A02(long j2, E e2) {
        int A03 = C2P.A03(this.A02, this.A00, j2);
        if (A03 >= 0) {
            Object[] objArr = this.A03;
            if (objArr[A03] != A05) {
                return (E) objArr[A03];
            }
        }
        return e2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    private void A04() {
        int o = this.A00;
        int i2 = 0;
        long[] jArr = this.A02;
        Object[] objArr = this.A03;
        for (int i3 = 0; i3 < o; i3++) {
            Object obj = objArr[i3];
            if (obj != A05) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.A01 = false;
        this.A00 = i2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final int A06() {
        if (this.A01) {
            A04();
        }
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final E A07(int i2) {
        if (this.A01) {
            A04();
        }
        return (E) this.A03[i2];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final E A08(long j2) {
        return A02(j2, null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final void A09() {
        int i2 = this.A00;
        Object[] objArr = this.A03;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.A00 = 0;
        this.A01 = false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final void A0A(int i2) {
        Object[] objArr = this.A03;
        Object obj = objArr[i2];
        Object obj2 = A05;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.A01 = true;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final void A0B(long j2, E e2) {
        int A03 = C2P.A03(this.A02, this.A00, j2);
        if (A03 >= 0) {
            this.A03[A03] = e2;
            return;
        }
        int i2 = A03 ^ (-1);
        if (i2 < this.A00) {
            Object[] objArr = this.A03;
            if (objArr[i2] == A05) {
                this.A02[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.A01 && this.A00 >= this.A02.length) {
            A04();
            i2 = C2P.A03(this.A02, this.A00, j2) ^ (-1);
        }
        int i3 = this.A00;
        if (i3 >= this.A02.length) {
            int A00 = C2P.A00(i3 + 1);
            long[] jArr = new long[A00];
            Object[] objArr2 = new Object[A00];
            long[] jArr2 = this.A02;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.A03;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.A02 = jArr;
            this.A03 = objArr2;
        }
        int i4 = this.A00;
        if (i4 - i2 != 0) {
            long[] jArr3 = this.A02;
            System.arraycopy(jArr3, i2, jArr3, i2 + 1, i4 - i2);
            Object[] objArr4 = this.A03;
            System.arraycopy(objArr4, i2, objArr4, i2 + 1, this.A00 - i2);
        }
        this.A02[i2] = j2;
        this.A03[i2] = e2;
        this.A00++;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Q != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /* JADX WARN: Incorrect condition in loop: B:8:0x0021 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r5 = this;
            int r0 = r5.A06()
            if (r0 > 0) goto L10
            r2 = 12
            r1 = 2
            r0 = 126(0x7e, float:1.77E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            return r0
        L10:
            int r0 = r5.A00
            int r0 = r0 * 28
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            r0 = 123(0x7b, float:1.72E-43)
            r3.append(r0)
            r4 = 0
        L1f:
            int r0 = r5.A00
            if (r4 >= r0) goto L56
            if (r4 <= 0) goto L31
            r2 = 10
            r1 = 2
            r0 = 65
            java.lang.String r0 = A03(r2, r1, r0)
            r3.append(r0)
        L31:
            long r0 = r5.A00(r4)
            r3.append(r0)
            r0 = 61
            r3.append(r0)
            java.lang.Object r0 = r5.A07(r4)
            if (r0 == r5) goto L49
            r3.append(r0)
        L46:
            int r4 = r4 + 1
            goto L1f
        L49:
            r2 = 0
            r1 = 10
            r0 = 13
            java.lang.String r0 = A03(r2, r1, r0)
            r3.append(r0)
            goto L46
        L56:
            r0 = 125(0x7d, float:1.75E-43)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2Q.toString():java.lang.String");
    }
}
