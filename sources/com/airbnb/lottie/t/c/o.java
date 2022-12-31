package com.airbnb.lottie.t.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.t.c.a;
import java.util.Collections;
/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: classes.dex */
public class o {
    private final Matrix a = new Matrix();
    private final Matrix b;
    private final Matrix c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f556d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f557e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private a<PointF, PointF> f558f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private a<?, PointF> f559g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private a<com.airbnb.lottie.x.d, com.airbnb.lottie.x.d> f560h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private a<Float, Float> f561i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private a<Integer, Integer> f562j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private c f563k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private c f564l;
    @Nullable
    private a<?, Float> m;
    @Nullable
    private a<?, Float> n;

    public o(com.airbnb.lottie.model.h.l lVar) {
        this.f558f = lVar.c() == null ? null : lVar.c().a();
        this.f559g = lVar.f() == null ? null : lVar.f().a();
        this.f560h = lVar.h() == null ? null : lVar.h().a();
        this.f561i = lVar.g() == null ? null : lVar.g().a();
        c cVar = lVar.i() == null ? null : (c) lVar.i().a();
        this.f563k = cVar;
        if (cVar != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.f556d = new Matrix();
            this.f557e = new float[9];
        } else {
            this.b = null;
            this.c = null;
            this.f556d = null;
            this.f557e = null;
        }
        this.f564l = lVar.j() == null ? null : (c) lVar.j().a();
        if (lVar.e() != null) {
            this.f562j = lVar.e().a();
        }
        if (lVar.k() != null) {
            this.m = lVar.k().a();
        } else {
            this.m = null;
        }
        if (lVar.d() != null) {
            this.n = lVar.d().a();
        } else {
            this.n = null;
        }
    }

    private void d() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.f557e[i2] = 0.0f;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.i(this.f562j);
        aVar.i(this.m);
        aVar.i(this.n);
        aVar.i(this.f558f);
        aVar.i(this.f559g);
        aVar.i(this.f560h);
        aVar.i(this.f561i);
        aVar.i(this.f563k);
        aVar.i(this.f564l);
    }

    public void b(a.b bVar) {
        a<Integer, Integer> aVar = this.f562j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a<PointF, PointF> aVar4 = this.f558f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a<?, PointF> aVar5 = this.f559g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a<com.airbnb.lottie.x.d, com.airbnb.lottie.x.d> aVar6 = this.f560h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a<Float, Float> aVar7 = this.f561i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        c cVar = this.f563k;
        if (cVar != null) {
            cVar.a(bVar);
        }
        c cVar2 = this.f564l;
        if (cVar2 != null) {
            cVar2.a(bVar);
        }
    }

    public <T> boolean c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        c cVar2;
        c cVar3;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == com.airbnb.lottie.l.f364e) {
            a<PointF, PointF> aVar3 = this.f558f;
            if (aVar3 == null) {
                this.f558f = new p(cVar, new PointF());
                return true;
            }
            aVar3.m(cVar);
            return true;
        } else if (t == com.airbnb.lottie.l.f365f) {
            a<?, PointF> aVar4 = this.f559g;
            if (aVar4 == null) {
                this.f559g = new p(cVar, new PointF());
                return true;
            }
            aVar4.m(cVar);
            return true;
        } else if (t == com.airbnb.lottie.l.f370k) {
            a<com.airbnb.lottie.x.d, com.airbnb.lottie.x.d> aVar5 = this.f560h;
            if (aVar5 == null) {
                this.f560h = new p(cVar, new com.airbnb.lottie.x.d());
                return true;
            }
            aVar5.m(cVar);
            return true;
        } else if (t == com.airbnb.lottie.l.f371l) {
            a<Float, Float> aVar6 = this.f561i;
            if (aVar6 == null) {
                this.f561i = new p(cVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.m(cVar);
            return true;
        } else if (t == com.airbnb.lottie.l.c) {
            a<Integer, Integer> aVar7 = this.f562j;
            if (aVar7 == null) {
                this.f562j = new p(cVar, 100);
                return true;
            }
            aVar7.m(cVar);
            return true;
        } else if (t == com.airbnb.lottie.l.y && (aVar2 = this.m) != null) {
            if (aVar2 == null) {
                this.m = new p(cVar, 100);
                return true;
            }
            aVar2.m(cVar);
            return true;
        } else if (t == com.airbnb.lottie.l.z && (aVar = this.n) != null) {
            if (aVar == null) {
                this.n = new p(cVar, 100);
                return true;
            }
            aVar.m(cVar);
            return true;
        } else if (t == com.airbnb.lottie.l.m && (cVar3 = this.f563k) != null) {
            if (cVar3 == null) {
                this.f563k = new c(Collections.singletonList(new com.airbnb.lottie.x.a(Float.valueOf(0.0f))));
            }
            this.f563k.m(cVar);
            return true;
        } else if (t != com.airbnb.lottie.l.n || (cVar2 = this.f564l) == null) {
            return false;
        } else {
            if (cVar2 == null) {
                this.f564l = new c(Collections.singletonList(new com.airbnb.lottie.x.a(Float.valueOf(0.0f))));
            }
            this.f564l.m(cVar);
            return true;
        }
    }

    @Nullable
    public a<?, Float> e() {
        return this.n;
    }

    public Matrix f() {
        float o;
        this.a.reset();
        a<?, PointF> aVar = this.f559g;
        if (aVar != null) {
            PointF h2 = aVar.h();
            float f2 = h2.x;
            if (f2 != 0.0f || h2.y != 0.0f) {
                this.a.preTranslate(f2, h2.y);
            }
        }
        a<Float, Float> aVar2 = this.f561i;
        if (aVar2 != null) {
            if (aVar2 instanceof p) {
                o = aVar2.h().floatValue();
            } else {
                o = ((c) aVar2).o();
            }
            if (o != 0.0f) {
                this.a.preRotate(o);
            }
        }
        if (this.f563k != null) {
            c cVar = this.f564l;
            float cos = cVar == null ? 0.0f : (float) Math.cos(Math.toRadians((-cVar.o()) + 90.0f));
            c cVar2 = this.f564l;
            float sin = cVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-cVar2.o()) + 90.0f));
            d();
            float[] fArr = this.f557e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f3 = -sin;
            fArr[3] = f3;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.b.setValues(fArr);
            d();
            float[] fArr2 = this.f557e;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians(this.f563k.o()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            d();
            float[] fArr3 = this.f557e;
            fArr3[0] = cos;
            fArr3[1] = f3;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f556d.setValues(fArr3);
            this.c.preConcat(this.b);
            this.f556d.preConcat(this.c);
            this.a.preConcat(this.f556d);
        }
        a<com.airbnb.lottie.x.d, com.airbnb.lottie.x.d> aVar3 = this.f560h;
        if (aVar3 != null) {
            com.airbnb.lottie.x.d h3 = aVar3.h();
            if (h3.b() != 1.0f || h3.c() != 1.0f) {
                this.a.preScale(h3.b(), h3.c());
            }
        }
        a<PointF, PointF> aVar4 = this.f558f;
        if (aVar4 != null) {
            PointF h4 = aVar4.h();
            float f4 = h4.x;
            if (f4 != 0.0f || h4.y != 0.0f) {
                this.a.preTranslate(-f4, -h4.y);
            }
        }
        return this.a;
    }

    public Matrix g(float f2) {
        a<?, PointF> aVar = this.f559g;
        PointF h2 = aVar == null ? null : aVar.h();
        a<com.airbnb.lottie.x.d, com.airbnb.lottie.x.d> aVar2 = this.f560h;
        com.airbnb.lottie.x.d h3 = aVar2 == null ? null : aVar2.h();
        this.a.reset();
        if (h2 != null) {
            this.a.preTranslate(h2.x * f2, h2.y * f2);
        }
        if (h3 != null) {
            double d2 = f2;
            this.a.preScale((float) Math.pow(h3.b(), d2), (float) Math.pow(h3.c(), d2));
        }
        a<Float, Float> aVar3 = this.f561i;
        if (aVar3 != null) {
            float floatValue = aVar3.h().floatValue();
            a<PointF, PointF> aVar4 = this.f558f;
            PointF h4 = aVar4 != null ? aVar4.h() : null;
            this.a.preRotate(floatValue * f2, h4 == null ? 0.0f : h4.x, h4 != null ? h4.y : 0.0f);
        }
        return this.a;
    }

    @Nullable
    public a<?, Integer> h() {
        return this.f562j;
    }

    @Nullable
    public a<?, Float> i() {
        return this.m;
    }

    public void j(float f2) {
        a<Integer, Integer> aVar = this.f562j;
        if (aVar != null) {
            aVar.l(f2);
        }
        a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.l(f2);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.l(f2);
        }
        a<PointF, PointF> aVar4 = this.f558f;
        if (aVar4 != null) {
            aVar4.l(f2);
        }
        a<?, PointF> aVar5 = this.f559g;
        if (aVar5 != null) {
            aVar5.l(f2);
        }
        a<com.airbnb.lottie.x.d, com.airbnb.lottie.x.d> aVar6 = this.f560h;
        if (aVar6 != null) {
            aVar6.l(f2);
        }
        a<Float, Float> aVar7 = this.f561i;
        if (aVar7 != null) {
            aVar7.l(f2);
        }
        c cVar = this.f563k;
        if (cVar != null) {
            cVar.l(f2);
        }
        c cVar2 = this.f564l;
        if (cVar2 != null) {
            cVar2.l(f2);
        }
    }
}
