package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* compiled from: StrokeContent.java */
/* loaded from: classes.dex */
public class r extends a {
    private final com.airbnb.lottie.model.layer.a o;
    private final String p;
    private final boolean q;
    private final com.airbnb.lottie.t.c.a<Integer, Integer> r;
    @Nullable
    private com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> s;

    public r(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.b().toPaintCap(), shapeStroke.e().toPaintJoin(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.o = aVar;
        this.p = shapeStroke.h();
        this.q = shapeStroke.k();
        com.airbnb.lottie.t.c.a<Integer, Integer> a = shapeStroke.c().a();
        this.r = a;
        a.a(this);
        aVar.i(a);
    }

    @Override // com.airbnb.lottie.t.b.a, com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        super.c(t, cVar);
        if (t == com.airbnb.lottie.l.b) {
            this.r.m(cVar);
        } else if (t == com.airbnb.lottie.l.C) {
            com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> aVar = this.s;
            if (aVar != null) {
                this.o.C(aVar);
            }
            if (cVar == null) {
                this.s = null;
                return;
            }
            com.airbnb.lottie.t.c.p pVar = new com.airbnb.lottie.t.c.p(cVar);
            this.s = pVar;
            pVar.a(this);
            this.o.i(this.r);
        }
    }

    @Override // com.airbnb.lottie.t.b.a, com.airbnb.lottie.t.b.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        if (this.q) {
            return;
        }
        this.f474i.setColor(((com.airbnb.lottie.t.c.b) this.r).o());
        com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> aVar = this.s;
        if (aVar != null) {
            this.f474i.setColorFilter(aVar.h());
        }
        super.g(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.t.b.c
    public String getName() {
        return this.p;
    }
}
