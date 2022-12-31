package com.google.zxing.common;

import com.google.zxing.NotFoundException;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* compiled from: GlobalHistogramBinarizer.java */
/* loaded from: classes2.dex */
public class g extends com.google.zxing.a {

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f4990d = new byte[0];
    private byte[] b;
    private final int[] c;

    public g(com.google.zxing.d dVar) {
        super(dVar);
        this.b = f4990d;
        this.c = new int[32];
    }

    private static int c(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] > i2) {
                i2 = iArr[i5];
                i4 = i5;
            }
            if (iArr[i5] > i3) {
                i3 = iArr[i5];
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i4;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i4 <= i6) {
            int i11 = i4;
            i4 = i6;
            i6 = i11;
        }
        if (i4 - i6 > length / 16) {
            int i12 = i4 - 1;
            int i13 = i12;
            int i14 = -1;
            while (i12 > i6) {
                int i15 = i12 - i6;
                int i16 = i15 * i15 * (i4 - i12) * (i3 - iArr[i12]);
                if (i16 > i14) {
                    i13 = i12;
                    i14 = i16;
                }
                i12--;
            }
            return i13 << 3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void d(int i2) {
        if (this.b.length < i2) {
            this.b = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.c[i3] = 0;
        }
    }

    @Override // com.google.zxing.a
    public b a() throws NotFoundException {
        com.google.zxing.d b = b();
        int d2 = b.d();
        int a = b.a();
        b bVar = new b(d2, a);
        d(d2);
        int[] iArr = this.c;
        for (int i2 = 1; i2 < 5; i2++) {
            byte[] c = b.c((a * i2) / 5, this.b);
            int i3 = (d2 << 2) / 5;
            for (int i4 = d2 / 5; i4 < i3; i4++) {
                int i5 = (c[i4] & Draft_75.END_OF_FRAME) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
        }
        int c2 = c(iArr);
        byte[] b2 = b.b();
        for (int i6 = 0; i6 < a; i6++) {
            int i7 = i6 * d2;
            for (int i8 = 0; i8 < d2; i8++) {
                if ((b2[i7 + i8] & Draft_75.END_OF_FRAME) < c2) {
                    bVar.j(i8, i6);
                }
            }
        }
        return bVar;
    }
}
