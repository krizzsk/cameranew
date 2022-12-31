package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
/* compiled from: GradientStrokeContent.java */
/* loaded from: classes.dex */
public class i extends a {
    private final String o;
    private final boolean p;
    private final LongSparseArray<LinearGradient> q;
    private final LongSparseArray<RadialGradient> r;
    private final RectF s;
    private final GradientType t;
    private final int u;
    private final com.airbnb.lottie.t.c.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> v;
    private final com.airbnb.lottie.t.c.a<PointF, PointF> w;
    private final com.airbnb.lottie.t.c.a<PointF, PointF> x;
    @Nullable
    private com.airbnb.lottie.t.c.p y;

    public i(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.b().toPaintCap(), eVar.g().toPaintJoin(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        this.q = new LongSparseArray<>();
        this.r = new LongSparseArray<>();
        this.s = new RectF();
        this.o = eVar.j();
        this.t = eVar.f();
        this.p = eVar.n();
        this.u = (int) (gVar.n().d() / 32.0f);
        com.airbnb.lottie.t.c.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> a = eVar.e().a();
        this.v = a;
        a.a(this);
        aVar.i(a);
        com.airbnb.lottie.t.c.a<PointF, PointF> a2 = eVar.l().a();
        this.w = a2;
        a2.a(this);
        aVar.i(a2);
        com.airbnb.lottie.t.c.a<PointF, PointF> a3 = eVar.d().a();
        this.x = a3;
        a3.a(this);
        aVar.i(a3);
    }

    private int[] i(int[] iArr) {
        com.airbnb.lottie.t.c.p pVar = this.y;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.h();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    private int j() {
        int round = Math.round(this.w.f() * this.u);
        int round2 = Math.round(this.x.f() * this.u);
        int round3 = Math.round(this.v.f() * this.u);
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private LinearGradient k() {
        long j2 = j();
        LinearGradient linearGradient = this.q.get(j2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h2 = this.w.h();
        PointF h3 = this.x.h();
        com.airbnb.lottie.model.content.c h4 = this.v.h();
        LinearGradient linearGradient2 = new LinearGradient(h2.x, h2.y, h3.x, h3.y, i(h4.a()), h4.b(), Shader.TileMode.CLAMP);
        this.q.put(j2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient l() {
        float f2;
        float f3;
        long j2 = j();
        RadialGradient radialGradient = this.r.get(j2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h2 = this.w.h();
        PointF h3 = this.x.h();
        com.airbnb.lottie.model.content.c h4 = this.v.h();
        int[] i2 = i(h4.a());
        float[] b = h4.b();
        RadialGradient radialGradient2 = new RadialGradient(h2.x, h2.y, (float) Math.hypot(h3.x - f2, h3.y - f3), i2, b, Shader.TileMode.CLAMP);
        this.r.put(j2, radialGradient2);
        return radialGradient2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.t.b.a, com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        super.c(t, cVar);
        if (t == com.airbnb.lottie.l.D) {
            com.airbnb.lottie.t.c.p pVar = this.y;
            if (pVar != null) {
                this.f471f.C(pVar);
            }
            if (cVar == null) {
                this.y = null;
                return;
            }
            com.airbnb.lottie.t.c.p pVar2 = new com.airbnb.lottie.t.c.p(cVar);
            this.y = pVar2;
            pVar2.a(this);
            this.f471f.i(this.y);
        }
    }

    @Override // com.airbnb.lottie.t.b.a, com.airbnb.lottie.t.b.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        Shader l2;
        if (this.p) {
            return;
        }
        e(this.s, matrix, false);
        if (this.t == GradientType.LINEAR) {
            l2 = k();
        } else {
            l2 = l();
        }
        l2.setLocalMatrix(matrix);
        this.f474i.setShader(l2);
        super.g(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.t.b.c
    public String getName() {
        return this.o;
    }
}
