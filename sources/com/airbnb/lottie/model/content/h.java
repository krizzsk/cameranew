package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ShapeData.java */
/* loaded from: classes.dex */
public class h {
    private final List<com.airbnb.lottie.model.a> a;
    private PointF b;
    private boolean c;

    public h(PointF pointF, boolean z, List<com.airbnb.lottie.model.a> list) {
        this.b = pointF;
        this.c = z;
        this.a = new ArrayList(list);
    }

    private void e(float f2, float f3) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f2, f3);
    }

    public List<com.airbnb.lottie.model.a> a() {
        return this.a;
    }

    public PointF b() {
        return this.b;
    }

    public void c(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.c = hVar.d() || hVar2.d();
        if (hVar.a().size() != hVar2.a().size()) {
            com.airbnb.lottie.w.d.c("Curves must have the same number of control points. Shape 1: " + hVar.a().size() + "\tShape 2: " + hVar2.a().size());
        }
        int min = Math.min(hVar.a().size(), hVar2.a().size());
        if (this.a.size() < min) {
            for (int size = this.a.size(); size < min; size++) {
                this.a.add(new com.airbnb.lottie.model.a());
            }
        } else if (this.a.size() > min) {
            for (int size2 = this.a.size() - 1; size2 >= min; size2--) {
                List<com.airbnb.lottie.model.a> list = this.a;
                list.remove(list.size() - 1);
            }
        }
        PointF b = hVar.b();
        PointF b2 = hVar2.b();
        e(com.airbnb.lottie.w.g.j(b.x, b2.x, f2), com.airbnb.lottie.w.g.j(b.y, b2.y, f2));
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            com.airbnb.lottie.model.a aVar = hVar.a().get(size3);
            com.airbnb.lottie.model.a aVar2 = hVar2.a().get(size3);
            PointF a = aVar.a();
            PointF b3 = aVar.b();
            PointF c = aVar.c();
            PointF a2 = aVar2.a();
            PointF b4 = aVar2.b();
            PointF c2 = aVar2.c();
            this.a.get(size3).d(com.airbnb.lottie.w.g.j(a.x, a2.x, f2), com.airbnb.lottie.w.g.j(a.y, a2.y, f2));
            this.a.get(size3).e(com.airbnb.lottie.w.g.j(b3.x, b4.x, f2), com.airbnb.lottie.w.g.j(b3.y, b4.y, f2));
            this.a.get(size3).f(com.airbnb.lottie.w.g.j(c.x, c2.x, f2), com.airbnb.lottie.w.g.j(c.y, c2.y, f2));
        }
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
    }

    public h() {
        this.a = new ArrayList();
    }
}
