package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.t.c.a;
import java.util.ArrayList;
import java.util.List;
/* compiled from: FillContent.java */
/* loaded from: classes.dex */
public class g implements e, a.b, k {
    private final Path a;
    private final Paint b;
    private final com.airbnb.lottie.model.layer.a c;

    /* renamed from: d  reason: collision with root package name */
    private final String f491d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f492e;

    /* renamed from: f  reason: collision with root package name */
    private final List<m> f493f;

    /* renamed from: g  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<Integer, Integer> f494g;

    /* renamed from: h  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<Integer, Integer> f495h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> f496i;

    /* renamed from: j  reason: collision with root package name */
    private final com.airbnb.lottie.g f497j;

    public g(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        Path path = new Path();
        this.a = path;
        this.b = new com.airbnb.lottie.t.a(1);
        this.f493f = new ArrayList();
        this.c = aVar;
        this.f491d = iVar.d();
        this.f492e = iVar.f();
        this.f497j = gVar;
        if (iVar.b() != null && iVar.e() != null) {
            path.setFillType(iVar.c());
            com.airbnb.lottie.t.c.a<Integer, Integer> a = iVar.b().a();
            this.f494g = a;
            a.a(this);
            aVar.i(a);
            com.airbnb.lottie.t.c.a<Integer, Integer> a2 = iVar.e().a();
            this.f495h = a2;
            a2.a(this);
            aVar.i(a2);
            return;
        }
        this.f494g = null;
        this.f495h = null;
    }

    @Override // com.airbnb.lottie.t.c.a.b
    public void a() {
        this.f497j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof m) {
                this.f493f.add((m) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        if (t == com.airbnb.lottie.l.a) {
            this.f494g.m(cVar);
        } else if (t == com.airbnb.lottie.l.f363d) {
            this.f495h.m(cVar);
        } else if (t == com.airbnb.lottie.l.C) {
            com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> aVar = this.f496i;
            if (aVar != null) {
                this.c.C(aVar);
            }
            if (cVar == null) {
                this.f496i = null;
                return;
            }
            com.airbnb.lottie.t.c.p pVar = new com.airbnb.lottie.t.c.p(cVar);
            this.f496i = pVar;
            pVar.a(this);
            this.c.i(this.f496i);
        }
    }

    @Override // com.airbnb.lottie.model.e
    public void d(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        com.airbnb.lottie.w.g.l(dVar, i2, list, dVar2, this);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.a.reset();
        for (int i2 = 0; i2 < this.f493f.size(); i2++) {
            this.a.addPath(this.f493f.get(i2).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        if (this.f492e) {
            return;
        }
        com.airbnb.lottie.d.a("FillContent#draw");
        this.b.setColor(((com.airbnb.lottie.t.c.b) this.f494g).o());
        this.b.setAlpha(com.airbnb.lottie.w.g.c((int) ((((i2 / 255.0f) * this.f495h.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> aVar = this.f496i;
        if (aVar != null) {
            this.b.setColorFilter(aVar.h());
        }
        this.a.reset();
        for (int i3 = 0; i3 < this.f493f.size(); i3++) {
            this.a.addPath(this.f493f.get(i3).getPath(), matrix);
        }
        canvas.drawPath(this.a, this.b);
        com.airbnb.lottie.d.b("FillContent#draw");
    }

    @Override // com.airbnb.lottie.t.b.c
    public String getName() {
        return this.f491d;
    }
}
