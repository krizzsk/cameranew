package com.facebook.appevents.ml;
/* compiled from: Operator.java */
/* loaded from: classes.dex */
final class b {
    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(a aVar, a aVar2) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            int c = aVar.c(0);
            int c2 = aVar.c(1);
            int c3 = aVar.c(2);
            float[] b = aVar.b();
            float[] b2 = aVar2.b();
            for (int i2 = 0; i2 < c; i2++) {
                for (int i3 = 0; i3 < c2; i3++) {
                    for (int i4 = 0; i4 < c3; i4++) {
                        int i5 = (i2 * c2 * c3) + (i3 * c3) + i4;
                        b[i5] = b[i5] + b2[i4];
                    }
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(a[] aVarArr) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            int c = aVarArr[0].c(0);
            int i2 = 0;
            for (a aVar : aVarArr) {
                i2 += aVar.c(1);
            }
            a aVar2 = new a(new int[]{c, i2});
            float[] b = aVar2.b();
            for (int i3 = 0; i3 < c; i3++) {
                int i4 = i3 * i2;
                for (int i5 = 0; i5 < aVarArr.length; i5++) {
                    float[] b2 = aVarArr[i5].b();
                    int c2 = aVarArr[i5].c(1);
                    System.arraycopy(b2, i3 * c2, b, i4, c2);
                    i4 += c2;
                }
            }
            return aVar2;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(a aVar, a aVar2) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        int i2 = 0;
        try {
            int c = aVar.c(0);
            int c2 = aVar.c(1);
            int c3 = aVar.c(2);
            int c4 = aVar2.c(0);
            int i3 = (c2 - c4) + 1;
            int c5 = aVar2.c(2);
            a aVar3 = new a(new int[]{c, i3, c5});
            float[] b = aVar.b();
            float[] b2 = aVar3.b();
            float[] b3 = aVar2.b();
            int i4 = 0;
            while (i4 < c) {
                int i5 = 0;
                while (i5 < c5) {
                    int i6 = 0;
                    while (i6 < i3) {
                        float f2 = 0.0f;
                        while (i2 < c4) {
                            for (int i7 = 0; i7 < c3; i7++) {
                                f2 += b[(c2 * c3 * i4) + ((i2 + i6) * c3) + i7] * b3[(((i2 * c3) + i7) * c5) + i5];
                            }
                            i2++;
                        }
                        b2[(i3 * c5 * i4) + (i6 * c5) + i5] = f2;
                        i6++;
                        i2 = 0;
                    }
                    i5++;
                    i2 = 0;
                }
                i4++;
                i2 = 0;
            }
            return aVar3;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a d(a aVar, a aVar2, a aVar3) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            int c = aVar.c(0);
            int c2 = aVar3.c(0);
            a h2 = h(aVar, aVar2);
            float[] b = aVar3.b();
            float[] b2 = h2.b();
            for (int i2 = 0; i2 < c; i2++) {
                for (int i3 = 0; i3 < c2; i3++) {
                    int i4 = (i2 * c2) + i3;
                    b2[i4] = b2[i4] + b[i3];
                }
            }
            return h2;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a e(String[] strArr, int i2, a aVar) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            int length = strArr.length;
            int c = aVar.c(1);
            a aVar2 = new a(new int[]{length, i2, c});
            float[] b = aVar2.b();
            float[] b2 = aVar.b();
            for (int i3 = 0; i3 < length; i3++) {
                int[] c2 = c.c(strArr[i3], i2);
                for (int i4 = 0; i4 < i2; i4++) {
                    System.arraycopy(b2, c2[i4] * c, b, (c * i2 * i3) + (c * i4), c);
                }
            }
            return aVar2;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(a aVar, int i2) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            if (i2 >= aVar.d()) {
                return;
            }
            int i3 = 1;
            for (int i4 = i2; i4 < aVar.d(); i4++) {
                i3 *= aVar.c(i4);
            }
            int[] iArr = new int[i2 + 1];
            for (int i5 = 0; i5 < i2; i5++) {
                iArr[i5] = aVar.c(i5);
            }
            iArr[i2] = i3;
            aVar.e(iArr);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(a aVar, int i2) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            int c = aVar.c(0);
            int c2 = aVar.c(1);
            int c3 = aVar.c(2);
            int i3 = (c2 - i2) + 1;
            a aVar2 = new a(new int[]{c, i3, c3});
            float[] b = aVar.b();
            float[] b2 = aVar2.b();
            for (int i4 = 0; i4 < c; i4++) {
                for (int i5 = 0; i5 < c3; i5++) {
                    for (int i6 = 0; i6 < i3; i6++) {
                        int i7 = i6 * c3;
                        int i8 = (i4 * i3 * c3) + i7 + i5;
                        int i9 = (i4 * c2 * c3) + i7 + i5;
                        b2[i8] = Float.MIN_VALUE;
                        for (int i10 = 0; i10 < i2; i10++) {
                            b2[i8] = Math.max(b2[i8], b[i9 + (i10 * c3)]);
                        }
                    }
                }
            }
            return aVar2;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    static a h(a aVar, a aVar2) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            int c = aVar.c(0);
            int c2 = aVar2.c(0);
            int c3 = aVar2.c(1);
            a aVar3 = new a(new int[]{c, c3});
            float[] b = aVar.b();
            float[] b2 = aVar2.b();
            float[] b3 = aVar3.b();
            for (int i2 = 0; i2 < c; i2++) {
                for (int i3 = 0; i3 < c3; i3++) {
                    int i4 = (i2 * c3) + i3;
                    b3[i4] = 0.0f;
                    for (int i5 = 0; i5 < c2; i5++) {
                        b3[i4] = b3[i4] + (b[(i2 * c2) + i5] * b2[(i5 * c3) + i3]);
                    }
                }
            }
            return aVar3;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(a aVar) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            float[] b = aVar.b();
            for (int i2 = 0; i2 < b.length; i2++) {
                if (b[i2] < 0.0f) {
                    b[i2] = 0.0f;
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(a aVar) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            int c = aVar.c(0);
            int c2 = aVar.c(1);
            float[] b = aVar.b();
            for (int i2 = 0; i2 < c; i2++) {
                int i3 = i2 * c2;
                int i4 = i3 + c2;
                float f2 = Float.MIN_VALUE;
                float f3 = 0.0f;
                for (int i5 = i3; i5 < i4; i5++) {
                    if (b[i5] > f2) {
                        f2 = b[i5];
                    }
                }
                for (int i6 = i3; i6 < i4; i6++) {
                    b[i6] = (float) Math.exp(b[i6] - f2);
                }
                for (int i7 = i3; i7 < i4; i7++) {
                    f3 += b[i7];
                }
                while (i3 < i4) {
                    b[i3] = b[i3] / f3;
                    i3++;
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a k(a aVar) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            int c = aVar.c(0);
            int c2 = aVar.c(1);
            a aVar2 = new a(new int[]{c2, c});
            float[] b = aVar.b();
            float[] b2 = aVar2.b();
            for (int i2 = 0; i2 < c; i2++) {
                for (int i3 = 0; i3 < c2; i3++) {
                    b2[(i3 * c) + i2] = b[(i2 * c2) + i3];
                }
            }
            return aVar2;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a l(a aVar) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            int c = aVar.c(0);
            int c2 = aVar.c(1);
            int c3 = aVar.c(2);
            a aVar2 = new a(new int[]{c3, c2, c});
            float[] b = aVar.b();
            float[] b2 = aVar2.b();
            for (int i2 = 0; i2 < c; i2++) {
                for (int i3 = 0; i3 < c2; i3++) {
                    for (int i4 = 0; i4 < c3; i4++) {
                        b2[(i4 * c * c2) + (i3 * c) + i2] = b[(i2 * c2 * c3) + (i3 * c3) + i4];
                    }
                }
            }
            return aVar2;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }
}
