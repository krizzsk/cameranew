package com.google.zxing.datamatrix.encoder;

import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: SymbolInfo.java */
/* loaded from: classes2.dex */
public class k {

    /* renamed from: i  reason: collision with root package name */
    private static k[] f5015i = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, InspirePublishFragment.MAX_DESC_COUNT, 56), new k(false, 368, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 56), new k(false, 696, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, DeeplinkCallback.ERROR_TIMEOUT, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
    private final boolean a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5016d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5017e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5018f;

    /* renamed from: g  reason: collision with root package name */
    private final int f5019g;

    /* renamed from: h  reason: collision with root package name */
    private final int f5020h;

    public k(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    private int e() {
        int i2 = this.f5018f;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2 && i2 != 4) {
                if (i2 != 16) {
                    if (i2 == 36) {
                        return 6;
                    }
                    throw new IllegalStateException("Cannot handle this number of data regions");
                }
                return 4;
            }
        }
        return i3;
    }

    private int k() {
        int i2 = this.f5018f;
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 != 4) {
            if (i2 != 16) {
                if (i2 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
            return 4;
        }
        return 2;
    }

    public static k l(int i2, SymbolShapeHint symbolShapeHint, com.google.zxing.c cVar, com.google.zxing.c cVar2, boolean z) {
        k[] kVarArr;
        for (k kVar : f5015i) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && kVar.a) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || kVar.a) && ((cVar == null || (kVar.j() >= cVar.b() && kVar.i() >= cVar.a())) && ((cVar2 == null || (kVar.j() <= cVar2.b() && kVar.i() <= cVar2.a())) && i2 <= kVar.b)))) {
                return kVar;
            }
        }
        if (z) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i2)));
        }
        return null;
    }

    public final int a() {
        return this.b;
    }

    public int b(int i2) {
        return this.f5019g;
    }

    public final int c() {
        return this.c;
    }

    public final int d(int i2) {
        return this.f5020h;
    }

    public int f() {
        return this.b / this.f5019g;
    }

    public final int g() {
        return k() * this.f5017e;
    }

    public final int h() {
        return e() * this.f5016d;
    }

    public final int i() {
        return g() + (k() << 1);
    }

    public final int j() {
        return h() + (e() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f5016d);
        sb.append('x');
        sb.append(this.f5017e);
        sb.append(", symbol size ");
        sb.append(j());
        sb.append('x');
        sb.append(i());
        sb.append(", symbol data size ");
        sb.append(h());
        sb.append('x');
        sb.append(g());
        sb.append(", codewords ");
        sb.append(this.b);
        sb.append('+');
        sb.append(this.c);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a = z;
        this.b = i2;
        this.c = i3;
        this.f5016d = i4;
        this.f5017e = i5;
        this.f5018f = i6;
        this.f5019g = i7;
        this.f5020h = i8;
    }
}
