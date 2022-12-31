package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.t.c.a;
import java.util.List;
/* compiled from: EllipseContent.java */
/* loaded from: classes.dex */
public class f implements m, a.b, k {
    private final String b;
    private final com.airbnb.lottie.g c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<?, PointF> f486d;

    /* renamed from: e  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<?, PointF> f487e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.model.content.a f488f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f490h;
    private final Path a = new Path();

    /* renamed from: g  reason: collision with root package name */
    private b f489g = new b();

    public f(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.b = aVar2.b();
        this.c = gVar;
        com.airbnb.lottie.t.c.a<PointF, PointF> a = aVar2.d().a();
        this.f486d = a;
        com.airbnb.lottie.t.c.a<PointF, PointF> a2 = aVar2.c().a();
        this.f487e = a2;
        this.f488f = aVar2;
        aVar.i(a);
        aVar.i(a2);
        a.a(this);
        a2.a(this);
    }

    private void f() {
        this.f490h = false;
        this.c.invalidateSelf();
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
                    this.f489g.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        if (t == com.airbnb.lottie.l.f366g) {
            this.f486d.m(cVar);
        } else if (t == com.airbnb.lottie.l.f369j) {
            this.f487e.m(cVar);
        }
    }

    @Override // com.airbnb.lottie.model.e
    public void d(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        com.airbnb.lottie.w.g.l(dVar, i2, list, dVar2, this);
    }

    @Override // com.airbnb.lottie.t.b.c
    public String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.t.b.m
    public Path getPath() {
        if (this.f490h) {
            return this.a;
        }
        this.a.reset();
        if (this.f488f.e()) {
            this.f490h = true;
            return this.a;
        }
        PointF h2 = this.f486d.h();
        float f2 = h2.x / 2.0f;
        float f3 = h2.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.a.reset();
        if (this.f488f.f()) {
            float f6 = -f3;
            this.a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            this.a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            this.a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            this.a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            this.a.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            this.a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            this.a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            this.a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            this.a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF h3 = this.f487e.h();
        this.a.offset(h3.x, h3.y);
        this.a.close();
        this.f489g.b(this.a);
        this.f490h = true;
        return this.a;
    }
}
