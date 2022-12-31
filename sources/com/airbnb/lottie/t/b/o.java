package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.t.c.a;
import java.util.List;
/* compiled from: RectangleContent.java */
/* loaded from: classes.dex */
public class o implements a.b, k, m {
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f518d;

    /* renamed from: e  reason: collision with root package name */
    private final com.airbnb.lottie.g f519e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<?, PointF> f520f;

    /* renamed from: g  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<?, PointF> f521g;

    /* renamed from: h  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<?, Float> f522h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f524j;
    private final Path a = new Path();
    private final RectF b = new RectF();

    /* renamed from: i  reason: collision with root package name */
    private b f523i = new b();

    public o(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.f fVar) {
        this.c = fVar.c();
        this.f518d = fVar.f();
        this.f519e = gVar;
        com.airbnb.lottie.t.c.a<PointF, PointF> a = fVar.d().a();
        this.f520f = a;
        com.airbnb.lottie.t.c.a<PointF, PointF> a2 = fVar.e().a();
        this.f521g = a2;
        com.airbnb.lottie.t.c.a<Float, Float> a3 = fVar.b().a();
        this.f522h = a3;
        aVar.i(a);
        aVar.i(a2);
        aVar.i(a3);
        a.a(this);
        a2.a(this);
        a3.a(this);
    }

    private void f() {
        this.f524j = false;
        this.f519e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t.c.a.b
    public void a() {
        f();
    }

    @Override // com.airbnb.lottie.t.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f523i.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        if (t == com.airbnb.lottie.l.f367h) {
            this.f521g.m(cVar);
        } else if (t == com.airbnb.lottie.l.f369j) {
            this.f520f.m(cVar);
        } else if (t == com.airbnb.lottie.l.f368i) {
            this.f522h.m(cVar);
        }
    }

    @Override // com.airbnb.lottie.model.e
    public void d(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        com.airbnb.lottie.w.g.l(dVar, i2, list, dVar2, this);
    }

    @Override // com.airbnb.lottie.t.b.c
    public String getName() {
        return this.c;
    }

    @Override // com.airbnb.lottie.t.b.m
    public Path getPath() {
        if (this.f524j) {
            return this.a;
        }
        this.a.reset();
        if (this.f518d) {
            this.f524j = true;
            return this.a;
        }
        PointF h2 = this.f521g.h();
        float f2 = h2.x / 2.0f;
        float f3 = h2.y / 2.0f;
        com.airbnb.lottie.t.c.a<?, Float> aVar = this.f522h;
        float o = aVar == null ? 0.0f : ((com.airbnb.lottie.t.c.c) aVar).o();
        float min = Math.min(f2, f3);
        if (o > min) {
            o = min;
        }
        PointF h3 = this.f520f.h();
        this.a.moveTo(h3.x + f2, (h3.y - f3) + o);
        this.a.lineTo(h3.x + f2, (h3.y + f3) - o);
        int i2 = (o > 0.0f ? 1 : (o == 0.0f ? 0 : -1));
        if (i2 > 0) {
            RectF rectF = this.b;
            float f4 = h3.x;
            float f5 = o * 2.0f;
            float f6 = h3.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((h3.x - f2) + o, h3.y + f3);
        if (i2 > 0) {
            RectF rectF2 = this.b;
            float f7 = h3.x;
            float f8 = h3.y;
            float f9 = o * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(h3.x - f2, (h3.y - f3) + o);
        if (i2 > 0) {
            RectF rectF3 = this.b;
            float f10 = h3.x;
            float f11 = h3.y;
            float f12 = o * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((h3.x + f2) - o, h3.y - f3);
        if (i2 > 0) {
            RectF rectF4 = this.b;
            float f13 = h3.x;
            float f14 = o * 2.0f;
            float f15 = h3.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.f523i.b(this.a);
        this.f524j = true;
        return this.a;
    }
}
