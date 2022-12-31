package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.t.c.a;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ContentGroup.java */
/* loaded from: classes.dex */
public class d implements e, m, a.b, com.airbnb.lottie.model.e {
    private Paint a;
    private RectF b;
    private final Matrix c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f478d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f479e;

    /* renamed from: f  reason: collision with root package name */
    private final String f480f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f481g;

    /* renamed from: h  reason: collision with root package name */
    private final List<c> f482h;

    /* renamed from: i  reason: collision with root package name */
    private final com.airbnb.lottie.g f483i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private List<m> f484j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private com.airbnb.lottie.t.c.o f485k;

    public d(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.j jVar) {
        this(gVar, aVar, jVar.c(), jVar.d(), f(gVar, aVar, jVar.b()), h(jVar.b()));
    }

    private static List<c> f(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, List<com.airbnb.lottie.model.content.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            c a = list.get(i2).a(gVar, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    @Nullable
    static com.airbnb.lottie.model.h.l h(List<com.airbnb.lottie.model.content.b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.airbnb.lottie.model.content.b bVar = list.get(i2);
            if (bVar instanceof com.airbnb.lottie.model.h.l) {
                return (com.airbnb.lottie.model.h.l) bVar;
            }
        }
        return null;
    }

    private boolean k() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f482h.size(); i3++) {
            if ((this.f482h.get(i3) instanceof e) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.t.c.a.b
    public void a() {
        this.f483i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t.b.c
    public void b(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f482h.size());
        arrayList.addAll(list);
        for (int size = this.f482h.size() - 1; size >= 0; size--) {
            c cVar = this.f482h.get(size);
            cVar.b(arrayList, this.f482h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        com.airbnb.lottie.t.c.o oVar = this.f485k;
        if (oVar != null) {
            oVar.c(t, cVar);
        }
    }

    @Override // com.airbnb.lottie.model.e
    public void d(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        if (dVar.g(getName(), i2)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i2)) {
                    list.add(dVar2.i(this));
                }
            }
            if (dVar.h(getName(), i2)) {
                int e2 = i2 + dVar.e(getName(), i2);
                for (int i3 = 0; i3 < this.f482h.size(); i3++) {
                    c cVar = this.f482h.get(i3);
                    if (cVar instanceof com.airbnb.lottie.model.e) {
                        ((com.airbnb.lottie.model.e) cVar).d(dVar, e2, list, dVar2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.c.set(matrix);
        com.airbnb.lottie.t.c.o oVar = this.f485k;
        if (oVar != null) {
            this.c.preConcat(oVar.f());
        }
        this.f479e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f482h.size() - 1; size >= 0; size--) {
            c cVar = this.f482h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).e(this.f479e, this.c, z);
                rectF.union(this.f479e);
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        if (this.f481g) {
            return;
        }
        this.c.set(matrix);
        com.airbnb.lottie.t.c.o oVar = this.f485k;
        if (oVar != null) {
            this.c.preConcat(oVar.f());
            i2 = (int) (((((this.f485k.h() == null ? 100 : this.f485k.h().h().intValue()) / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        boolean z = this.f483i.E() && k() && i2 != 255;
        if (z) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            e(this.b, this.c, true);
            this.a.setAlpha(i2);
            com.airbnb.lottie.w.h.m(canvas, this.b, this.a);
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.f482h.size() - 1; size >= 0; size--) {
            c cVar = this.f482h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).g(canvas, this.c, i2);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.t.b.c
    public String getName() {
        return this.f480f;
    }

    @Override // com.airbnb.lottie.t.b.m
    public Path getPath() {
        this.c.reset();
        com.airbnb.lottie.t.c.o oVar = this.f485k;
        if (oVar != null) {
            this.c.set(oVar.f());
        }
        this.f478d.reset();
        if (this.f481g) {
            return this.f478d;
        }
        for (int size = this.f482h.size() - 1; size >= 0; size--) {
            c cVar = this.f482h.get(size);
            if (cVar instanceof m) {
                this.f478d.addPath(((m) cVar).getPath(), this.c);
            }
        }
        return this.f478d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<m> i() {
        if (this.f484j == null) {
            this.f484j = new ArrayList();
            for (int i2 = 0; i2 < this.f482h.size(); i2++) {
                c cVar = this.f482h.get(i2);
                if (cVar instanceof m) {
                    this.f484j.add((m) cVar);
                }
            }
        }
        return this.f484j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix j() {
        com.airbnb.lottie.t.c.o oVar = this.f485k;
        if (oVar != null) {
            return oVar.f();
        }
        this.c.reset();
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, String str, boolean z, List<c> list, @Nullable com.airbnb.lottie.model.h.l lVar) {
        this.a = new com.airbnb.lottie.t.a();
        this.b = new RectF();
        this.c = new Matrix();
        this.f478d = new Path();
        this.f479e = new RectF();
        this.f480f = str;
        this.f483i = gVar;
        this.f481g = z;
        this.f482h = list;
        if (lVar != null) {
            com.airbnb.lottie.t.c.o b = lVar.b();
            this.f485k = b;
            b.a(aVar);
            this.f485k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).f(list.listIterator(list.size()));
        }
    }
}
