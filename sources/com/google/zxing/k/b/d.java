package com.google.zxing.k.b;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
/* compiled from: HighLevelEncoder.java */
/* loaded from: classes2.dex */
public final class d {
    static final String[] b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f5026d;

    /* renamed from: e  reason: collision with root package name */
    static final int[][] f5027e;
    private final byte[] a;

    /* compiled from: HighLevelEncoder.java */
    /* loaded from: classes2.dex */
    class a implements Comparator<f> {
        a(d dVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.d() - fVar2.d();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance(int.class, 5, 256);
        f5026d = iArr;
        iArr[0][32] = 1;
        for (int i2 = 65; i2 <= 90; i2++) {
            f5026d[0][i2] = (i2 - 65) + 2;
        }
        f5026d[1][32] = 1;
        for (int i3 = 97; i3 <= 122; i3++) {
            f5026d[1][i3] = (i3 - 97) + 2;
        }
        f5026d[2][32] = 1;
        for (int i4 = 48; i4 <= 57; i4++) {
            f5026d[2][i4] = (i4 - 48) + 2;
        }
        int[][] iArr2 = f5026d;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i5 = 0; i5 < 28; i5++) {
            f5026d[3][iArr3[i5]] = i5;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < 31; i6++) {
            if (iArr4[i6] > 0) {
                f5026d[4][iArr4[i6]] = i6;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance(int.class, 6, 6);
        f5027e = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f5027e;
        iArr7[0][4] = 0;
        iArr7[1][4] = 0;
        iArr7[1][0] = 28;
        iArr7[3][4] = 0;
        iArr7[2][4] = 0;
        iArr7[2][0] = 15;
    }

    public d(byte[] bArr) {
        this.a = bArr;
    }

    private static Collection<f> b(Iterable<f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.f(fVar)) {
                    z = false;
                    break;
                } else if (fVar.f(fVar2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(fVar);
            }
        }
        return linkedList;
    }

    private void c(f fVar, int i2, Collection<f> collection) {
        char c2 = (char) (this.a[i2] & Draft_75.END_OF_FRAME);
        boolean z = f5026d[fVar.e()][c2] > 0;
        f fVar2 = null;
        for (int i3 = 0; i3 <= 4; i3++) {
            int i4 = f5026d[i3][c2];
            if (i4 > 0) {
                if (fVar2 == null) {
                    fVar2 = fVar.b(i2);
                }
                if (!z || i3 == fVar.e() || i3 == 2) {
                    collection.add(fVar2.g(i3, i4));
                }
                if (!z && f5027e[fVar.e()][i3] >= 0) {
                    collection.add(fVar2.h(i3, i4));
                }
            }
        }
        if (fVar.c() > 0 || f5026d[fVar.e()][c2] == 0) {
            collection.add(fVar.a(i2));
        }
    }

    private static void d(f fVar, int i2, int i3, Collection<f> collection) {
        f b2 = fVar.b(i2);
        collection.add(b2.g(4, i3));
        if (fVar.e() != 4) {
            collection.add(b2.h(4, i3));
        }
        if (i3 == 3 || i3 == 4) {
            collection.add(b2.g(2, 16 - i3).g(2, 1));
        }
        if (fVar.c() > 0) {
            collection.add(fVar.a(i2).a(i2 + 1));
        }
    }

    private Collection<f> e(Iterable<f> iterable, int i2) {
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            c(fVar, i2, linkedList);
        }
        return b(linkedList);
    }

    private static Collection<f> f(Iterable<f> iterable, int i2, int i3) {
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            d(fVar, i2, i3, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.zxing.common.a a() {
        /*
            r8 = this;
            com.google.zxing.k.b.f r0 = com.google.zxing.k.b.f.f5029e
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = 0
        L8:
            byte[] r3 = r8.a
            int r4 = r3.length
            if (r2 >= r4) goto L4c
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L15
            r5 = r3[r4]
            goto L16
        L15:
            r5 = 0
        L16:
            r3 = r3[r2]
            r6 = 13
            if (r3 == r6) goto L38
            r6 = 44
            r7 = 32
            if (r3 == r6) goto L34
            r6 = 46
            if (r3 == r6) goto L30
            r6 = 58
            if (r3 == r6) goto L2c
        L2a:
            r3 = 0
            goto L3d
        L2c:
            if (r5 != r7) goto L2a
            r3 = 5
            goto L3d
        L30:
            if (r5 != r7) goto L2a
            r3 = 3
            goto L3d
        L34:
            if (r5 != r7) goto L2a
            r3 = 4
            goto L3d
        L38:
            r3 = 10
            if (r5 != r3) goto L2a
            r3 = 2
        L3d:
            if (r3 <= 0) goto L45
            java.util.Collection r0 = f(r0, r2, r3)
            r2 = r4
            goto L49
        L45:
            java.util.Collection r0 = r8.e(r0, r2)
        L49:
            int r2 = r2 + 1
            goto L8
        L4c:
            com.google.zxing.k.b.d$a r1 = new com.google.zxing.k.b.d$a
            r1.<init>(r8)
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            com.google.zxing.k.b.f r0 = (com.google.zxing.k.b.f) r0
            byte[] r1 = r8.a
            com.google.zxing.common.a r0 = r0.i(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.k.b.d.a():com.google.zxing.common.a");
    }
}
