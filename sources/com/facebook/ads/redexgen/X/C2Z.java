package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
/* renamed from: com.facebook.ads.redexgen.X.2Z  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C2Z<K, V> {
    public static int A03;
    public static int A04;
    public static Object[] A05;
    public static Object[] A06;
    public static byte[] A07;
    public static String[] A08 = {"BrVHgBkmBksyBnnjIq0pHnqXAu9AUg3j", "iIth6RrlZFIJsCIcgsKekGbs32ChyRjv", "Uwdt1z4SmD1Mf7UvGeSYdNXOfhFYTYnY", "QITUqyWPG2VnlGrB2a6hYhF3R3KaavLD", "arDW8RiIBmWFNCZvgTvY8WvuJ76u3VTs", "pOGA2rk9V0ZEl", "438Cia9wbNYnLnXWpHR8BTCUnyjltaF2", "slnYcYZFDBEgJMtczrpzy3D6NQdPiCOq"};
    public int[] A01 = C2P.A00;
    public Object[] A02 = C2P.A02;
    public int A00 = 0;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 105);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        if (A08[5].length() == 11) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[0] = "Xtbm9MFCOkvOfDux5Me3XhO5K6Bs7EUd";
        strArr[1] = "PZcI0QBOeZ0LYFf6gJzuFWLZdUoY6utj";
        A07 = new byte[]{-69, 7, -5, -4, 6, -77, -32, -12, 3, -68, -62, -74, 3, 5};
    }

    static {
        A04();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    private final int A00() {
        int index = this.A00;
        if (index == 0) {
            return -1;
        }
        int A02 = A02(this.A01, index, 0);
        if (A02 < 0) {
            return A02;
        }
        if (this.A02[A02 << 1] == null) {
            return A02;
        }
        int i2 = A02 + 1;
        while (i2 < index) {
            int end = this.A01[i2];
            if (end != 0) {
                break;
            }
            Object[] objArr = this.A02;
            String[] strArr = A08;
            String str = strArr[2];
            String str2 = strArr[4];
            int charAt = str.charAt(15);
            int end2 = str2.charAt(15);
            if (charAt != end2) {
                throw new RuntimeException();
            }
            A08[5] = "5BliZlAS3QBBz9o";
            int end3 = i2 << 1;
            if (objArr[end3] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = A02 - 1; i3 >= 0; i3--) {
            int end4 = this.A01[i3];
            if (end4 != 0) {
                break;
            }
            int end5 = i3 << 1;
            if (this.A02[end5] == null) {
                return i3;
            }
        }
        int end6 = i2 ^ (-1);
        return end6;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    private final int A01(Object obj, int end) {
        int i2 = this.A00;
        if (i2 == 0) {
            if (A08[7].charAt(6) != 'Z') {
                throw new RuntimeException();
            }
            A08[7] = "y399iLZYsEEz0hzdxnUhzykHYZJwaaUE";
            return -1;
        }
        int A02 = A02(this.A01, i2, end);
        if (A02 < 0) {
            return A02;
        }
        if (obj.equals(this.A02[A02 << 1])) {
            return A02;
        }
        int i3 = A02 + 1;
        while (i3 < i2 && this.A01[i3] == end) {
            if (obj.equals(this.A02[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = A02 - 1; i4 >= 0 && this.A01[i4] == end; i4--) {
            if (obj.equals(this.A02[i4 << 1])) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    public static int A02(int[] iArr, int i2, int i3) {
        try {
            return C2P.A02(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    private void A05(int i2) {
        if (i2 == 8) {
            synchronized (C1486bx.class) {
                if (A06 != null) {
                    Object[] objArr = A06;
                    this.A02 = objArr;
                    A06 = (Object[]) objArr[0];
                    this.A01 = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    A04--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (C1486bx.class) {
                if (A05 != null) {
                    Object[] objArr2 = A05;
                    this.A02 = objArr2;
                    A05 = (Object[]) objArr2[0];
                    this.A01 = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    A03--;
                    return;
                }
            }
        }
        this.A01 = new int[i2];
        this.A02 = new Object[i2 << 1];
    }

    public static void A06(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length != 8) {
            if (iArr.length == 4) {
                synchronized (C1486bx.class) {
                    if (A03 < 10) {
                        objArr[0] = A05;
                        objArr[1] = iArr;
                        for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        A05 = objArr;
                        A03++;
                    }
                }
            }
        } else if (A08[5].length() == 11) {
            throw new RuntimeException();
        } else {
            A08[7] = "zLkFwVZRQmO2pmmfCTMSdjo5f8ctaykz";
            synchronized (C1486bx.class) {
                if (A04 < 10) {
                    objArr[0] = A06;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    A06 = objArr;
                    A04++;
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final int A07(Object obj) {
        int i2 = this.A00 * 2;
        Object[] objArr = this.A02;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    int i4 = i3 >> 1;
                    return i4;
                }
            }
            return -1;
        }
        for (int i5 = 1; i5 < i2; i5 += 2) {
            if (obj.equals(objArr[i5])) {
                int i6 = i5 >> 1;
                return i6;
            }
        }
        return -1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final int A08(Object obj) {
        return obj == null ? A00() : A01(obj, obj.hashCode());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final K A09(int i2) {
        return (K) this.A02[i2 << 1];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V A0A(int i2) {
        int i3;
        Object[] objArr = this.A02;
        V v = (V) objArr[(i2 << 1) + 1];
        int i4 = this.A00;
        if (i4 <= 1) {
            A06(this.A01, objArr, i4);
            this.A01 = C2P.A00;
            this.A02 = C2P.A02;
            i3 = 0;
        } else {
            i3 = i4 - 1;
            int[] iArr = this.A01;
            int osize = iArr.length;
            int i5 = 8;
            if (osize > 8) {
                int i6 = this.A00;
                int osize2 = iArr.length;
                if (i6 < osize2 / 3) {
                    if (i4 > 8) {
                        int osize3 = i4 >> 1;
                        i5 = i4 + osize3;
                    }
                    int[] iArr2 = this.A01;
                    Object[] objArr2 = this.A02;
                    A05(i5);
                    if (i4 == this.A00) {
                        if (i2 > 0) {
                            int[] ohashes = this.A01;
                            System.arraycopy(iArr2, 0, ohashes, 0, i2);
                            System.arraycopy(objArr2, 0, this.A02, 0, i2 << 1);
                        }
                        if (i2 < i3) {
                            System.arraycopy(iArr2, i2 + 1, this.A01, i2, i3 - i2);
                            System.arraycopy(objArr2, (i2 + 1) << 1, this.A02, i2 << 1, (i3 - i2) << 1);
                        }
                    } else {
                        throw new ConcurrentModificationException();
                    }
                }
            }
            if (i2 < i3) {
                int[] iArr3 = this.A01;
                System.arraycopy(iArr3, i2 + 1, iArr3, i2, i3 - i2);
                Object[] objArr3 = this.A02;
                System.arraycopy(objArr3, (i2 + 1) << 1, objArr3, i2 << 1, (i3 - i2) << 1);
            }
            Object[] objArr4 = this.A02;
            objArr4[i3 << 1] = null;
            objArr4[(i3 << 1) + 1] = null;
        }
        int i7 = this.A00;
        String[] strArr = A08;
        String str = strArr[0];
        String str2 = strArr[1];
        int charAt = str.charAt(11);
        int osize4 = str2.charAt(11);
        if (charAt != osize4) {
            String[] strArr2 = A08;
            strArr2[0] = "xFHRCOjHDqSI1UlNRZSx5FadcPcGQITj";
            strArr2[1] = "4ZMke5GLOi53P3lo3UgzHK3l5Qzb3367";
            if (i4 == i7) {
                this.A00 = i3;
                return v;
            }
            throw new ConcurrentModificationException();
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V A0B(int i2) {
        return (V) this.A02[(i2 << 1) + 1];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V A0C(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.A02;
        V v2 = (V) objArr[i3];
        objArr[i3] = v;
        return v2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final void A0D(int i2) {
        int i3 = this.A00;
        if (this.A01.length < i2) {
            int[] iArr = this.A01;
            Object[] objArr = this.A02;
            A05(i2);
            if (this.A00 > 0) {
                System.arraycopy(iArr, 0, this.A01, 0, i3);
                System.arraycopy(objArr, 0, this.A02, 0, i3 << 1);
            }
            A06(iArr, objArr, i3);
        }
        if (this.A00 == i3) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final void clear() {
        if (this.A00 > 0) {
            int[] iArr = this.A01;
            Object[] objArr = this.A02;
            int i2 = this.A00;
            this.A01 = C2P.A00;
            Object[] oarray = C2P.A02;
            this.A02 = oarray;
            this.A00 = 0;
            A06(iArr, objArr, i2);
        }
        if (this.A00 <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final boolean containsKey(Object obj) {
        return A08(obj) >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final boolean containsValue(Object obj) {
        return A07(obj) >= 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0078, code lost:
        return false;
     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<?, ?> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r5 = 1
            if (r6 != r7) goto L4
            return r5
        L4:
            boolean r0 = r7 instanceof com.facebook.ads.redexgen.X.C2Z
            r4 = 0
            if (r0 == 0) goto L41
            com.facebook.ads.redexgen.X.2Z r7 = (com.facebook.ads.redexgen.X.C2Z) r7
            int r1 = r6.size()
            int r0 = r7.size()
            if (r1 == r0) goto L16
            return r4
        L16:
            r3 = r4
        L17:
            int r0 = r6.A00     // Catch: java.lang.ClassCastException -> L3f java.lang.NullPointerException -> L40
            if (r3 >= r0) goto L3e
            java.lang.Object r2 = r6.A09(r3)     // Catch: java.lang.ClassCastException -> L3f java.lang.NullPointerException -> L40
            java.lang.Object r1 = r6.A0B(r3)     // Catch: java.lang.ClassCastException -> L3f java.lang.NullPointerException -> L40
            java.lang.Object r0 = r7.get(r2)     // Catch: java.lang.ClassCastException -> L3f java.lang.NullPointerException -> L40
            if (r1 != 0) goto L32
            if (r0 != 0) goto L3c
            boolean r0 = r7.containsKey(r2)     // Catch: java.lang.ClassCastException -> L3f java.lang.NullPointerException -> L40
            if (r0 != 0) goto L39
            goto L3c
        L32:
            boolean r0 = r1.equals(r0)     // Catch: java.lang.ClassCastException -> L3f java.lang.NullPointerException -> L40
            if (r0 != 0) goto L39
            goto L3d
        L39:
            int r3 = r3 + 1
            goto L17
        L3c:
            return r4
        L3d:
            return r4
        L3e:
            return r5
        L3f:
            return r4
        L40:
            return r4
        L41:
            boolean r0 = r7 instanceof java.util.Map
            if (r0 == 0) goto L7d
            java.util.Map r7 = (java.util.Map) r7
            int r1 = r6.size()
            int r0 = r7.size()
            if (r1 == r0) goto L52
            return r4
        L52:
            r3 = r4
        L53:
            int r0 = r6.A00     // Catch: java.lang.ClassCastException -> L7b java.lang.NullPointerException -> L7c
            if (r3 >= r0) goto L7a
            java.lang.Object r2 = r6.A09(r3)     // Catch: java.lang.ClassCastException -> L7b java.lang.NullPointerException -> L7c
            java.lang.Object r1 = r6.A0B(r3)     // Catch: java.lang.ClassCastException -> L7b java.lang.NullPointerException -> L7c
            java.lang.Object r0 = r7.get(r2)     // Catch: java.lang.ClassCastException -> L7b java.lang.NullPointerException -> L7c
            if (r1 != 0) goto L6e
            if (r0 != 0) goto L78
            boolean r0 = r7.containsKey(r2)     // Catch: java.lang.ClassCastException -> L7b java.lang.NullPointerException -> L7c
            if (r0 != 0) goto L75
            goto L78
        L6e:
            boolean r0 = r1.equals(r0)     // Catch: java.lang.ClassCastException -> L7b java.lang.NullPointerException -> L7c
            if (r0 != 0) goto L75
            goto L79
        L75:
            int r3 = r3 + 1
            goto L53
        L78:
            return r4
        L79:
            return r4
        L7a:
            return r5
        L7b:
            return r4
        L7c:
            return r4
        L7d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2Z.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V get(Object obj) {
        int A082 = A08(obj);
        if (A082 >= 0) {
            return (V) this.A02[(A082 << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final int hashCode() {
        int[] iArr = this.A01;
        Object[] objArr = this.A02;
        int i2 = 0;
        int v = 0;
        int s = 1;
        int i3 = this.A00;
        while (v < i3) {
            Object obj = objArr[s];
            i2 += iArr[v] ^ (obj == null ? 0 : obj.hashCode());
            v++;
            s += 2;
        }
        return i2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final boolean isEmpty() {
        return this.A00 <= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V put(K k2, V v) {
        int hashCode;
        int A01;
        int n = this.A00;
        if (k2 == null) {
            hashCode = 0;
            A01 = A00();
        } else {
            hashCode = k2.hashCode();
            A01 = A01(k2, hashCode);
        }
        if (A01 >= 0) {
            int i2 = (A01 << 1) + 1;
            Object[] objArr = this.A02;
            V value = (V) objArr[i2];
            objArr[i2] = v;
            return value;
        }
        int i3 = A01 ^ (-1);
        if (n >= this.A01.length) {
            int i4 = 4;
            if (n >= 8) {
                i4 = (n >> 1) + n;
            } else if (n >= 4) {
                i4 = 8;
            }
            int[] iArr = this.A01;
            Object[] objArr2 = this.A02;
            A05(i4);
            if (n == this.A00) {
                int[] iArr2 = this.A01;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.A02, 0, objArr2.length);
                }
                A06(iArr, objArr2, n);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < n) {
            int[] iArr3 = this.A01;
            System.arraycopy(iArr3, i3, iArr3, i3 + 1, n - i3);
            Object[] objArr3 = this.A02;
            System.arraycopy(objArr3, i3 << 1, objArr3, (i3 + 1) << 1, (this.A00 - i3) << 1);
        }
        int i5 = this.A00;
        if (n == i5) {
            int[] iArr4 = this.A01;
            if (i3 < iArr4.length) {
                iArr4[i3] = hashCode;
                Object[] objArr4 = this.A02;
                objArr4[i3 << 1] = k2;
                objArr4[(i3 << 1) + 1] = v;
                this.A00 = i5 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V remove(Object obj) {
        int A082 = A08(obj);
        if (A082 >= 0) {
            return A0A(A082);
        }
        String[] strArr = A08;
        if (strArr[2].charAt(15) != strArr[4].charAt(15)) {
            throw new RuntimeException();
        }
        A08[5] = "POG7nMkVNzdGaGlGxNMu0E80q";
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final int size() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2Z != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    /* JADX WARN: Incorrect condition in loop: B:8:0x0021 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r9 = this;
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L10
            r2 = 12
            r1 = 2
            r0 = 31
            java.lang.String r0 = A03(r2, r1, r0)
            return r0
        L10:
            int r0 = r9.A00
            int r0 = r0 * 28
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r0 = 123(0x7b, float:1.72E-43)
            r4.append(r0)
            r5 = 0
        L1f:
            int r0 = r9.A00
            if (r5 >= r0) goto L7b
            if (r5 <= 0) goto L31
            r2 = 10
            r1 = 2
            r0 = 45
            java.lang.String r0 = A03(r2, r1, r0)
            r4.append(r0)
        L31:
            java.lang.Object r7 = r9.A09(r5)
            r8 = 0
            r6 = 10
            r3 = 42
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C2Z.A08
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 11
            if (r1 == r0) goto L75
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2Z.A08
            java.lang.String r1 = "5MoFeGsxqoTSR8Y6IShdOiE5VevAoRo0"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "kGPruxXsJMcA49LPD5OztVvQJS4oto1Y"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = A03(r8, r6, r3)
            if (r7 == r9) goto L71
            r4.append(r7)
        L5c:
            r0 = 61
            r4.append(r0)
            java.lang.Object r0 = r9.A0B(r5)
            if (r0 == r9) goto L6d
            r4.append(r0)
        L6a:
            int r5 = r5 + 1
            goto L1f
        L6d:
            r4.append(r1)
            goto L6a
        L71:
            r4.append(r1)
            goto L5c
        L75:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L7b:
            r0 = 125(0x7d, float:1.75E-43)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2Z.toString():java.lang.String");
    }
}
