package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.t.c.a;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class a implements a.b, k, e {

    /* renamed from: e  reason: collision with root package name */
    private final com.airbnb.lottie.g f470e;

    /* renamed from: f  reason: collision with root package name */
    protected final com.airbnb.lottie.model.layer.a f471f;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f473h;

    /* renamed from: i  reason: collision with root package name */
    final Paint f474i;

    /* renamed from: j  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<?, Float> f475j;

    /* renamed from: k  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<?, Integer> f476k;

    /* renamed from: l  reason: collision with root package name */
    private final List<com.airbnb.lottie.t.c.a<?, Float>> f477l;
    @Nullable
    private final com.airbnb.lottie.t.c.a<?, Float> m;
    @Nullable
    private com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> n;
    private final PathMeasure a = new PathMeasure();
    private final Path b = new Path();
    private final Path c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f469d = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final List<b> f472g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseStrokeContent.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final List<m> a;
        @Nullable
        private final s b;

        private b(@Nullable s sVar) {
            this.a = new ArrayList();
            this.b = sVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f2, com.airbnb.lottie.model.h.d dVar, com.airbnb.lottie.model.h.b bVar, List<com.airbnb.lottie.model.h.b> list, com.airbnb.lottie.model.h.b bVar2) {
        com.airbnb.lottie.t.a aVar2 = new com.airbnb.lottie.t.a(1);
        this.f474i = aVar2;
        this.f470e = gVar;
        this.f471f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f2);
        this.f476k = dVar.a();
        this.f475j = bVar.a();
        if (bVar2 == null) {
            this.m = null;
        } else {
            this.m = bVar2.a();
        }
        this.f477l = new ArrayList(list.size());
        this.f473h = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f477l.add(list.get(i2).a());
        }
        aVar.i(this.f476k);
        aVar.i(this.f475j);
        for (int i3 = 0; i3 < this.f477l.size(); i3++) {
            aVar.i(this.f477l.get(i3));
        }
        com.airbnb.lottie.t.c.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar.i(aVar3);
        }
        this.f476k.a(this);
        this.f475j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f477l.get(i4).a(this);
        }
        com.airbnb.lottie.t.c.a<?, Float> aVar4 = this.m;
        if (aVar4 != null) {
            aVar4.a(this);
        }
    }

    private void f(Matrix matrix) {
        com.airbnb.lottie.d.a("StrokeContent#applyDashPattern");
        if (this.f477l.isEmpty()) {
            com.airbnb.lottie.d.b("StrokeContent#applyDashPattern");
            return;
        }
        float g2 = com.airbnb.lottie.w.h.g(matrix);
        for (int i2 = 0; i2 < this.f477l.size(); i2++) {
            this.f473h[i2] = this.f477l.get(i2).h().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f473h;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f473h;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f473h;
            fArr3[i2] = fArr3[i2] * g2;
        }
        com.airbnb.lottie.t.c.a<?, Float> aVar = this.m;
        this.f474i.setPathEffect(new DashPathEffect(this.f473h, aVar == null ? 0.0f : g2 * aVar.h().floatValue()));
        com.airbnb.lottie.d.b("StrokeContent#applyDashPattern");
    }

    private void h(Canvas canvas, b bVar, Matrix matrix) {
        com.airbnb.lottie.d.a("StrokeContent#applyTrimPath");
        if (bVar.b == null) {
            com.airbnb.lottie.d.b("StrokeContent#applyTrimPath");
            return;
        }
        this.b.reset();
        for (int size = bVar.a.size() - 1; size >= 0; size--) {
            this.b.addPath(((m) bVar.a.get(size)).getPath(), matrix);
        }
        this.a.setPath(this.b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        float floatValue = (bVar.b.f().h().floatValue() * length) / 360.0f;
        float floatValue2 = ((bVar.b.h().h().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((bVar.b.d().h().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = bVar.a.size() - 1; size2 >= 0; size2--) {
            this.c.set(((m) bVar.a.get(size2)).getPath());
            this.c.transform(matrix);
            this.a.setPath(this.c, false);
            float length2 = this.a.getLength();
            if (floatValue3 > length) {
                float f3 = floatValue3 - length;
                if (f3 < f2 + length2 && f2 < f3) {
                    com.airbnb.lottie.w.h.a(this.c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.c, this.f474i);
                    f2 += length2;
                }
            }
            float f4 = f2 + length2;
            if (f4 >= floatValue2 && f2 <= floatValue3) {
                if (f4 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.c, this.f474i);
                } else {
                    com.airbnb.lottie.w.h.a(this.c, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 <= f4 ? (floatValue3 - f2) / length2 : 1.0f, 0.0f);
                    canvas.drawPath(this.c, this.f474i);
                }
            }
            f2 += length2;
        }
        com.airbnb.lottie.d.b("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.t.c.a.b
    public void a() {
        this.f470e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t.b.c
    public void b(List<c> list, List<c> list2) {
        s sVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof s) {
                s sVar2 = (s) cVar;
                if (sVar2.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    sVar = sVar2;
                }
            }
        }
        if (sVar != null) {
            sVar.c(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof s) {
                s sVar3 = (s) cVar2;
                if (sVar3.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f472g.add(bVar);
                    }
                    bVar = new b(sVar3);
                    sVar3.c(this);
                }
            }
            if (cVar2 instanceof m) {
                if (bVar == null) {
                    bVar = new b(sVar);
                }
                bVar.a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.f472g.add(bVar);
        }
    }

    @Override // com.airbnb.lottie.model.e
    @CallSuper
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        if (t == com.airbnb.lottie.l.f363d) {
            this.f476k.m(cVar);
        } else if (t == com.airbnb.lottie.l.o) {
            this.f475j.m(cVar);
        } else if (t == com.airbnb.lottie.l.C) {
            com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> aVar = this.n;
            if (aVar != null) {
                this.f471f.C(aVar);
            }
            if (cVar == null) {
                this.n = null;
                return;
            }
            com.airbnb.lottie.t.c.p pVar = new com.airbnb.lottie.t.c.p(cVar);
            this.n = pVar;
            pVar.a(this);
            this.f471f.i(this.n);
        }
    }

    @Override // com.airbnb.lottie.model.e
    public void d(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        com.airbnb.lottie.w.g.l(dVar, i2, list, dVar2, this);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        com.airbnb.lottie.d.a("StrokeContent#getBounds");
        this.b.reset();
        for (int i2 = 0; i2 < this.f472g.size(); i2++) {
            b bVar = this.f472g.get(i2);
            for (int i3 = 0; i3 < bVar.a.size(); i3++) {
                this.b.addPath(((m) bVar.a.get(i3)).getPath(), matrix);
            }
        }
        this.b.computeBounds(this.f469d, false);
        float o = ((com.airbnb.lottie.t.c.c) this.f475j).o();
        RectF rectF2 = this.f469d;
        float f2 = o / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f469d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.b("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.t.b.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.d.a("StrokeContent#draw");
        if (com.airbnb.lottie.w.h.h(matrix)) {
            com.airbnb.lottie.d.b("StrokeContent#draw");
            return;
        }
        this.f474i.setAlpha(com.airbnb.lottie.w.g.c((int) ((((i2 / 255.0f) * ((com.airbnb.lottie.t.c.e) this.f476k).o()) / 100.0f) * 255.0f), 0, 255));
        this.f474i.setStrokeWidth(((com.airbnb.lottie.t.c.c) this.f475j).o() * com.airbnb.lottie.w.h.g(matrix));
        if (this.f474i.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.b("StrokeContent#draw");
            return;
        }
        f(matrix);
        com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.f474i.setColorFilter(aVar.h());
        }
        for (int i3 = 0; i3 < this.f472g.size(); i3++) {
            b bVar = this.f472g.get(i3);
            if (bVar.b != null) {
                h(canvas, bVar, matrix);
            } else {
                com.airbnb.lottie.d.a("StrokeContent#buildPath");
                this.b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.b.addPath(((m) bVar.a.get(size)).getPath(), matrix);
                }
                com.airbnb.lottie.d.b("StrokeContent#buildPath");
                com.airbnb.lottie.d.a("StrokeContent#drawPath");
                canvas.drawPath(this.b, this.f474i);
                com.airbnb.lottie.d.b("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.d.b("StrokeContent#draw");
    }
}
