package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ShapePath.java */
/* loaded from: classes2.dex */
public class n {
    @Deprecated
    public float a;
    @Deprecated
    public float b;
    @Deprecated
    public float c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f4521d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f4522e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public float f4523f;

    /* renamed from: g  reason: collision with root package name */
    private final List<f> f4524g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List<g> f4525h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f4526i;

    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    class a extends g {
        final /* synthetic */ List b;
        final /* synthetic */ Matrix c;

        a(n nVar, List list, Matrix matrix) {
            this.b = list;
            this.c = matrix;
        }

        @Override // com.google.android.material.shape.n.g
        public void a(Matrix matrix, com.google.android.material.h.a aVar, int i2, Canvas canvas) {
            for (g gVar : this.b) {
                gVar.a(this.c, aVar, i2, canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    public static class b extends g {
        private final d b;

        public b(d dVar) {
            this.b = dVar;
        }

        @Override // com.google.android.material.shape.n.g
        public void a(Matrix matrix, @NonNull com.google.android.material.h.a aVar, int i2, @NonNull Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.b.k(), this.b.o(), this.b.l(), this.b.j()), i2, this.b.m(), this.b.n());
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    static class c extends g {
        private final e b;
        private final float c;

        /* renamed from: d  reason: collision with root package name */
        private final float f4527d;

        public c(e eVar, float f2, float f3) {
            this.b = eVar;
            this.c = f2;
            this.f4527d = f3;
        }

        @Override // com.google.android.material.shape.n.g
        public void a(Matrix matrix, @NonNull com.google.android.material.h.a aVar, int i2, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.b.c - this.f4527d, this.b.b - this.c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.c, this.f4527d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i2);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.b.c - this.f4527d) / (this.b.b - this.c)));
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    public static class d extends f {

        /* renamed from: h  reason: collision with root package name */
        private static final RectF f4528h = new RectF();
        @Deprecated
        public float b;
        @Deprecated
        public float c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f4529d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f4530e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public float f4531f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public float f4532g;

        public d(float f2, float f3, float f4, float f5) {
            q(f2);
            u(f3);
            r(f4);
            p(f5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f4530e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f4529d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f4531f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f4532g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.c;
        }

        private void p(float f2) {
            this.f4530e = f2;
        }

        private void q(float f2) {
            this.b = f2;
        }

        private void r(float f2) {
            this.f4529d = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f2) {
            this.f4531f = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f2) {
            this.f4532g = f2;
        }

        private void u(float f2) {
            this.c = f2;
        }

        @Override // com.google.android.material.shape.n.f
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f4528h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    public static class e extends f {
        private float b;
        private float c;

        @Override // com.google.android.material.shape.n.f
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.b, this.c);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    public static abstract class f {
        protected final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    public static abstract class g {
        static final Matrix a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, com.google.android.material.h.a aVar, int i2, Canvas canvas);

        public final void b(com.google.android.material.h.a aVar, int i2, Canvas canvas) {
            a(a, aVar, i2, canvas);
        }
    }

    public n() {
        n(0.0f, 0.0f);
    }

    private void b(float f2) {
        if (g() == f2) {
            return;
        }
        float g2 = ((f2 - g()) + 360.0f) % 360.0f;
        if (g2 > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(g2);
        this.f4525h.add(new b(dVar));
        p(f2);
    }

    private void c(g gVar, float f2, float f3) {
        b(f2);
        this.f4525h.add(gVar);
        p(f3);
    }

    private float g() {
        return this.f4522e;
    }

    private float h() {
        return this.f4523f;
    }

    private void p(float f2) {
        this.f4522e = f2;
    }

    private void q(float f2) {
        this.f4523f = f2;
    }

    private void r(float f2) {
        this.c = f2;
    }

    private void s(float f2) {
        this.f4521d = f2;
    }

    private void t(float f2) {
        this.a = f2;
    }

    private void u(float f2) {
        this.b = f2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.s(f6);
        dVar.t(f7);
        this.f4524g.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        c(bVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = f8;
        r(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        s(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f4524g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4524g.get(i2).a(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f4526i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public g f(Matrix matrix) {
        b(h());
        return new a(this, new ArrayList(this.f4525h), new Matrix(matrix));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f4521d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.b;
    }

    public void m(float f2, float f3) {
        e eVar = new e();
        eVar.b = f2;
        eVar.c = f3;
        this.f4524g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f2);
        s(f3);
    }

    public void n(float f2, float f3) {
        o(f2, f3, 270.0f, 0.0f);
    }

    public void o(float f2, float f3, float f4, float f5) {
        t(f2);
        u(f3);
        r(f2);
        s(f3);
        p(f4);
        q((f4 + f5) % 360.0f);
        this.f4524g.clear();
        this.f4525h.clear();
        this.f4526i = false;
    }
}
