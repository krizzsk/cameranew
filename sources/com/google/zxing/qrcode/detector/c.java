package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.f;
import com.google.zxing.h;
import com.google.zxing.i;
import com.google.zxing.qrcode.decoder.g;
import java.util.Map;
/* compiled from: Detector.java */
/* loaded from: classes2.dex */
public class c {
    private final com.google.zxing.common.b a;
    private i b;

    public c(com.google.zxing.common.b bVar) {
        this.a = bVar;
    }

    private float b(h hVar, h hVar2) {
        float j2 = j((int) hVar.c(), (int) hVar.d(), (int) hVar2.c(), (int) hVar2.d());
        float j3 = j((int) hVar2.c(), (int) hVar2.d(), (int) hVar.c(), (int) hVar.d());
        return Float.isNaN(j2) ? j3 / 7.0f : Float.isNaN(j3) ? j2 / 7.0f : (j2 + j3) / 14.0f;
    }

    private static int c(h hVar, h hVar2, h hVar3, float f2) throws NotFoundException {
        int c = ((com.google.zxing.common.k.a.c(h.b(hVar, hVar2) / f2) + com.google.zxing.common.k.a.c(h.b(hVar, hVar3) / f2)) / 2) + 7;
        int i2 = c & 3;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return c;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            return c - 1;
        }
        return c + 1;
    }

    private static com.google.zxing.common.i d(h hVar, h hVar2, h hVar3, h hVar4, int i2) {
        float c;
        float d2;
        float f2;
        float f3 = i2 - 3.5f;
        if (hVar4 != null) {
            c = hVar4.c();
            d2 = hVar4.d();
            f2 = f3 - 3.0f;
        } else {
            c = (hVar2.c() - hVar.c()) + hVar3.c();
            d2 = (hVar2.d() - hVar.d()) + hVar3.d();
            f2 = f3;
        }
        return com.google.zxing.common.i.b(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, hVar.c(), hVar.d(), hVar2.c(), hVar2.d(), c, d2, hVar3.c(), hVar3.d());
    }

    private static com.google.zxing.common.b h(com.google.zxing.common.b bVar, com.google.zxing.common.i iVar, int i2) throws NotFoundException {
        return GridSampler.getInstance().b(bVar, i2, i2, iVar);
    }

    private float i(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        c cVar;
        boolean z;
        boolean z2;
        int i11 = 1;
        boolean z3 = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z3) {
            i7 = i2;
            i6 = i3;
            i9 = i4;
            i8 = i5;
        } else {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = i5;
        }
        int abs = Math.abs(i8 - i6);
        int abs2 = Math.abs(i9 - i7);
        int i12 = (-abs) / 2;
        int i13 = i6 < i8 ? 1 : -1;
        int i14 = i7 < i9 ? 1 : -1;
        int i15 = i8 + i13;
        int i16 = i6;
        int i17 = i7;
        int i18 = 0;
        while (true) {
            if (i16 == i15) {
                i10 = i15;
                break;
            }
            int i19 = z3 ? i17 : i16;
            int i20 = z3 ? i16 : i17;
            if (i18 == i11) {
                cVar = this;
                z = z3;
                i10 = i15;
                z2 = true;
            } else {
                cVar = this;
                z = z3;
                i10 = i15;
                z2 = false;
            }
            if (z2 == cVar.a.e(i19, i20)) {
                if (i18 == 2) {
                    return com.google.zxing.common.k.a.b(i16, i17, i6, i7);
                }
                i18++;
            }
            i12 += abs2;
            if (i12 > 0) {
                if (i17 == i9) {
                    break;
                }
                i17 += i14;
                i12 -= abs;
            }
            i16 += i13;
            i15 = i10;
            z3 = z;
            i11 = 1;
        }
        if (i18 == 2) {
            return com.google.zxing.common.k.a.b(i10, i9, i6, i7);
        }
        return Float.NaN;
    }

    private float j(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float i6 = i(i2, i3, i4, i5);
        int i7 = i2 - (i4 - i2);
        int i8 = 0;
        if (i7 < 0) {
            f2 = i2 / (i2 - i7);
            i7 = 0;
        } else if (i7 >= this.a.i()) {
            f2 = ((this.a.i() - 1) - i2) / (i7 - i2);
            i7 = this.a.i() - 1;
        } else {
            f2 = 1.0f;
        }
        float f4 = i3;
        int i9 = (int) (f4 - ((i5 - i3) * f2));
        if (i9 < 0) {
            f3 = f4 / (i3 - i9);
        } else if (i9 >= this.a.g()) {
            f3 = ((this.a.g() - 1) - i3) / (i9 - i3);
            i8 = this.a.g() - 1;
        } else {
            i8 = i9;
            f3 = 1.0f;
        }
        return (i6 + i(i2, i3, (int) (i2 + ((i7 - i2) * f3)), i8)) - 1.0f;
    }

    protected final float a(h hVar, h hVar2, h hVar3) {
        return (b(hVar, hVar2) + b(hVar, hVar3)) / 2.0f;
    }

    public final f e(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        i iVar = map == null ? null : (i) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.b = iVar;
        return g(new FinderPatternFinder(this.a, iVar).f(map));
    }

    protected final a f(float f2, int i2, int i3, float f3) throws NotFoundException {
        int i4 = (int) (f3 * f2);
        int max = Math.max(0, i2 - i4);
        int min = Math.min(this.a.i() - 1, i2 + i4) - max;
        float f4 = 3.0f * f2;
        if (min >= f4) {
            int max2 = Math.max(0, i3 - i4);
            int min2 = Math.min(this.a.g() - 1, i3 + i4) - max2;
            if (min2 >= f4) {
                return new b(this.a, max, max2, min, min2, f2, this.b).c();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected final f g(e eVar) throws NotFoundException, FormatException {
        d b = eVar.b();
        d c = eVar.c();
        d a = eVar.a();
        float a2 = a(b, c, a);
        if (a2 >= 1.0f) {
            int c2 = c(b, c, a, a2);
            g g2 = g.g(c2);
            int e2 = g2.e() - 7;
            a aVar = null;
            if (g2.d().length > 0) {
                float c3 = (c.c() - b.c()) + a.c();
                float d2 = (c.d() - b.d()) + a.d();
                float f2 = 1.0f - (3.0f / e2);
                int c4 = (int) (b.c() + ((c3 - b.c()) * f2));
                int d3 = (int) (b.d() + (f2 * (d2 - b.d())));
                for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                    try {
                        aVar = f(a2, c4, d3, i2);
                        break;
                    } catch (NotFoundException unused) {
                    }
                }
            }
            return new f(h(this.a, d(b, c, a, aVar, c2), c2), aVar == null ? new h[]{a, b, c} : new h[]{a, b, c, aVar});
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
