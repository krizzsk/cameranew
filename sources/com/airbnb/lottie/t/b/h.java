package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.t.c.a;
import java.util.ArrayList;
import java.util.List;
/* compiled from: GradientFillContent.java */
/* loaded from: classes.dex */
public class h implements e, a.b, k {
    @NonNull
    private final String a;
    private final boolean b;
    private final com.airbnb.lottie.model.layer.a c;

    /* renamed from: d  reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f498d = new LongSparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f499e = new LongSparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private final Path f500f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f501g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f502h;

    /* renamed from: i  reason: collision with root package name */
    private final List<m> f503i;

    /* renamed from: j  reason: collision with root package name */
    private final GradientType f504j;

    /* renamed from: k  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> f505k;

    /* renamed from: l  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<Integer, Integer> f506l;
    private final com.airbnb.lottie.t.c.a<PointF, PointF> m;
    private final com.airbnb.lottie.t.c.a<PointF, PointF> n;
    @Nullable
    private com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> o;
    @Nullable
    private com.airbnb.lottie.t.c.p p;
    private final com.airbnb.lottie.g q;
    private final int r;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        Path path = new Path();
        this.f500f = path;
        this.f501g = new com.airbnb.lottie.t.a(1);
        this.f502h = new RectF();
        this.f503i = new ArrayList();
        this.c = aVar;
        this.a = dVar.f();
        this.b = dVar.i();
        this.q = gVar;
        this.f504j = dVar.e();
        path.setFillType(dVar.c());
        this.r = (int) (gVar.n().d() / 32.0f);
        com.airbnb.lottie.t.c.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> a = dVar.d().a();
        this.f505k = a;
        a.a(this);
        aVar.i(a);
        com.airbnb.lottie.t.c.a<Integer, Integer> a2 = dVar.g().a();
        this.f506l = a2;
        a2.a(this);
        aVar.i(a2);
        com.airbnb.lottie.t.c.a<PointF, PointF> a3 = dVar.h().a();
        this.m = a3;
        a3.a(this);
        aVar.i(a3);
        com.airbnb.lottie.t.c.a<PointF, PointF> a4 = dVar.b().a();
        this.n = a4;
        a4.a(this);
        aVar.i(a4);
    }

    private int[] f(int[] iArr) {
        com.airbnb.lottie.t.c.p pVar = this.p;
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

    private int h() {
        int round = Math.round(this.m.f() * this.r);
        int round2 = Math.round(this.n.f() * this.r);
        int round3 = Math.round(this.f505k.f() * this.r);
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private LinearGradient i() {
        long h2 = h();
        LinearGradient linearGradient = this.f498d.get(h2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h3 = this.m.h();
        PointF h4 = this.n.h();
        com.airbnb.lottie.model.content.c h5 = this.f505k.h();
        LinearGradient linearGradient2 = new LinearGradient(h3.x, h3.y, h4.x, h4.y, f(h5.a()), h5.b(), Shader.TileMode.CLAMP);
        this.f498d.put(h2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient j() {
        long h2 = h();
        RadialGradient radialGradient = this.f499e.get(h2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h3 = this.m.h();
        PointF h4 = this.n.h();
        com.airbnb.lottie.model.content.c h5 = this.f505k.h();
        int[] f2 = f(h5.a());
        float[] b = h5.b();
        float f3 = h3.x;
        float f4 = h3.y;
        float hypot = (float) Math.hypot(h4.x - f3, h4.y - f4);
        RadialGradient radialGradient2 = new RadialGradient(f3, f4, hypot <= 0.0f ? 0.001f : hypot, f2, b, Shader.TileMode.CLAMP);
        this.f499e.put(h2, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.t.c.a.b
    public void a() {
        this.q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof m) {
                this.f503i.add((m) cVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        if (t == com.airbnb.lottie.l.f363d) {
            this.f506l.m(cVar);
        } else if (t == com.airbnb.lottie.l.C) {
            com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> aVar = this.o;
            if (aVar != null) {
                this.c.C(aVar);
            }
            if (cVar == null) {
                this.o = null;
                return;
            }
            com.airbnb.lottie.t.c.p pVar = new com.airbnb.lottie.t.c.p(cVar);
            this.o = pVar;
            pVar.a(this);
            this.c.i(this.o);
        } else if (t == com.airbnb.lottie.l.D) {
            com.airbnb.lottie.t.c.p pVar2 = this.p;
            if (pVar2 != null) {
                this.c.C(pVar2);
            }
            if (cVar == null) {
                this.p = null;
                return;
            }
            com.airbnb.lottie.t.c.p pVar3 = new com.airbnb.lottie.t.c.p(cVar);
            this.p = pVar3;
            pVar3.a(this);
            this.c.i(this.p);
        }
    }

    @Override // com.airbnb.lottie.model.e
    public void d(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        com.airbnb.lottie.w.g.l(dVar, i2, list, dVar2, this);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.f500f.reset();
        for (int i2 = 0; i2 < this.f503i.size(); i2++) {
            this.f500f.addPath(this.f503i.get(i2).getPath(), matrix);
        }
        this.f500f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        Shader j2;
        if (this.b) {
            return;
        }
        com.airbnb.lottie.d.a("GradientFillContent#draw");
        this.f500f.reset();
        for (int i3 = 0; i3 < this.f503i.size(); i3++) {
            this.f500f.addPath(this.f503i.get(i3).getPath(), matrix);
        }
        this.f500f.computeBounds(this.f502h, false);
        if (this.f504j == GradientType.LINEAR) {
            j2 = i();
        } else {
            j2 = j();
        }
        j2.setLocalMatrix(matrix);
        this.f501g.setShader(j2);
        com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> aVar = this.o;
        if (aVar != null) {
            this.f501g.setColorFilter(aVar.h());
        }
        this.f501g.setAlpha(com.airbnb.lottie.w.g.c((int) ((((i2 / 255.0f) * this.f506l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f500f, this.f501g);
        com.airbnb.lottie.d.b("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.t.b.c
    public String getName() {
        return this.a;
    }
}
