package com.google.zxing.common;

import com.google.zxing.NotFoundException;
/* compiled from: DefaultGridSampler.java */
/* loaded from: classes2.dex */
public final class e extends GridSampler {
    @Override // com.google.zxing.common.GridSampler
    public b b(b bVar, int i2, int i3, i iVar) throws NotFoundException {
        if (i2 > 0 && i3 > 0) {
            b bVar2 = new b(i2, i3);
            int i4 = i2 * 2;
            float[] fArr = new float[i4];
            for (int i5 = 0; i5 < i3; i5++) {
                float f2 = i5 + 0.5f;
                for (int i6 = 0; i6 < i4; i6 += 2) {
                    fArr[i6] = (i6 / 2) + 0.5f;
                    fArr[i6 + 1] = f2;
                }
                iVar.f(fArr);
                GridSampler.a(bVar, fArr);
                for (int i7 = 0; i7 < i4; i7 += 2) {
                    try {
                        if (bVar.e((int) fArr[i7], (int) fArr[i7 + 1])) {
                            bVar2.j(i7 / 2, i5);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
            }
            return bVar2;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
