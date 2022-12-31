package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.f;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.h;
import com.facebook.drawee.drawable.o;
import com.facebook.drawee.drawable.p;
import javax.annotation.Nullable;
/* compiled from: GenericDraweeHierarchy.java */
/* loaded from: classes.dex */
public class a implements com.facebook.drawee.b.c {
    private final Drawable a;
    private final Resources b;
    @Nullable
    private RoundingParams c;

    /* renamed from: d  reason: collision with root package name */
    private final d f2586d;

    /* renamed from: e  reason: collision with root package name */
    private final f f2587e;

    /* renamed from: f  reason: collision with root package name */
    private final g f2588f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.a = colorDrawable;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("GenericDraweeHierarchy()");
        }
        this.b = bVar.p();
        this.c = bVar.s();
        g gVar = new g(colorDrawable);
        this.f2588f = gVar;
        int i2 = 1;
        int size = bVar.j() != null ? bVar.j().size() : 1;
        int i3 = (size == 0 ? 1 : size) + (bVar.m() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[i3 + 6];
        drawableArr[0] = h(bVar.e(), null);
        drawableArr[1] = h(bVar.k(), bVar.l());
        drawableArr[2] = g(gVar, bVar.d(), bVar.c(), bVar.b());
        drawableArr[3] = h(bVar.n(), bVar.o());
        drawableArr[4] = h(bVar.q(), bVar.r());
        drawableArr[5] = h(bVar.h(), bVar.i());
        if (i3 > 0) {
            if (bVar.j() != null) {
                i2 = 0;
                for (Drawable drawable : bVar.j()) {
                    drawableArr[i2 + 6] = h(drawable, null);
                    i2++;
                }
            }
            if (bVar.m() != null) {
                drawableArr[i2 + 6] = h(bVar.m(), null);
            }
        }
        f fVar = new f(drawableArr, false, 2);
        this.f2587e = fVar;
        fVar.v(bVar.g());
        d dVar = new d(e.e(fVar, this.c));
        this.f2586d = dVar;
        dVar.mutate();
        r();
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    private void D(float f2) {
        Drawable b = this.f2587e.b(3);
        if (b == null) {
            return;
        }
        if (f2 >= 0.999f) {
            if (b instanceof Animatable) {
                ((Animatable) b).stop();
            }
            k(3);
        } else {
            if (b instanceof Animatable) {
                ((Animatable) b).start();
            }
            i(3);
        }
        b.setLevel(Math.round(f2 * 10000.0f));
    }

    @Nullable
    private Drawable g(Drawable drawable, @Nullable p.c cVar, @Nullable PointF pointF, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.g(drawable, cVar, pointF);
    }

    @Nullable
    private Drawable h(@Nullable Drawable drawable, @Nullable p.c cVar) {
        return e.f(e.d(drawable, this.c, this.b), cVar);
    }

    private void i(int i2) {
        if (i2 >= 0) {
            this.f2587e.m(i2);
        }
    }

    private void j() {
        k(1);
        k(2);
        k(3);
        k(4);
        k(5);
    }

    private void k(int i2) {
        if (i2 >= 0) {
            this.f2587e.n(i2);
        }
    }

    private com.facebook.drawee.drawable.c n(int i2) {
        com.facebook.drawee.drawable.c c = this.f2587e.c(i2);
        if (c.b() instanceof h) {
            c = (h) c.b();
        }
        return c.b() instanceof o ? (o) c.b() : c;
    }

    private o o(int i2) {
        com.facebook.drawee.drawable.c n = n(i2);
        if (n instanceof o) {
            return (o) n;
        }
        return e.k(n, p.c.a);
    }

    private boolean p(int i2) {
        return n(i2) instanceof o;
    }

    private void q() {
        this.f2588f.a(this.a);
    }

    private void r() {
        f fVar = this.f2587e;
        if (fVar != null) {
            fVar.g();
            this.f2587e.l();
            j();
            i(1);
            this.f2587e.o();
            this.f2587e.j();
        }
    }

    private void w(int i2, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.f2587e.f(i2, null);
            return;
        }
        n(i2).a(e.d(drawable, this.c, this.b));
    }

    public void A(f.a aVar) {
        this.f2587e.u(aVar);
    }

    public void B(int i2) {
        C(this.b.getDrawable(i2));
    }

    public void C(@Nullable Drawable drawable) {
        w(1, drawable);
    }

    public void E(@Nullable RoundingParams roundingParams) {
        this.c = roundingParams;
        e.j(this.f2586d, roundingParams);
        for (int i2 = 0; i2 < this.f2587e.d(); i2++) {
            e.i(n(i2), this.c, this.b);
        }
    }

    @Override // com.facebook.drawee.b.c
    public void a(Throwable th) {
        this.f2587e.g();
        j();
        if (this.f2587e.b(4) != null) {
            i(4);
        } else {
            i(1);
        }
        this.f2587e.j();
    }

    @Override // com.facebook.drawee.b.c
    public void b(Throwable th) {
        this.f2587e.g();
        j();
        if (this.f2587e.b(5) != null) {
            i(5);
        } else {
            i(1);
        }
        this.f2587e.j();
    }

    @Override // com.facebook.drawee.b.c
    public void c(float f2, boolean z) {
        if (this.f2587e.b(3) == null) {
            return;
        }
        this.f2587e.g();
        D(f2);
        if (z) {
            this.f2587e.o();
        }
        this.f2587e.j();
    }

    @Override // com.facebook.drawee.b.b
    public Drawable d() {
        return this.f2586d;
    }

    @Override // com.facebook.drawee.b.c
    public void e(Drawable drawable, float f2, boolean z) {
        Drawable d2 = e.d(drawable, this.c, this.b);
        d2.mutate();
        this.f2588f.a(d2);
        this.f2587e.g();
        j();
        i(2);
        D(f2);
        if (z) {
            this.f2587e.o();
        }
        this.f2587e.j();
    }

    @Override // com.facebook.drawee.b.c
    public void f(@Nullable Drawable drawable) {
        this.f2586d.q(drawable);
    }

    @Override // com.facebook.drawee.b.b
    public Rect getBounds() {
        return this.f2586d.getBounds();
    }

    @Nullable
    public PointF l() {
        if (p(2)) {
            return o(2).s();
        }
        return null;
    }

    @Nullable
    public p.c m() {
        if (p(2)) {
            return o(2).t();
        }
        return null;
    }

    @Override // com.facebook.drawee.b.c
    public void reset() {
        q();
        r();
    }

    public void s(ColorFilter colorFilter) {
        this.f2588f.setColorFilter(colorFilter);
    }

    public void t(PointF pointF) {
        com.facebook.common.internal.h.g(pointF);
        o(2).u(pointF);
    }

    public void u(p.c cVar) {
        com.facebook.common.internal.h.g(cVar);
        o(2).v(cVar);
    }

    public void v(@Nullable Drawable drawable) {
        w(0, drawable);
    }

    public void x(int i2) {
        this.f2587e.v(i2);
    }

    public void y(int i2) {
        z(this.b.getDrawable(i2));
    }

    public void z(@Nullable Drawable drawable) {
        w(5, drawable);
    }
}
