package com.airbnb.lottie.t.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.t.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* compiled from: RepeaterContent.java */
/* loaded from: classes.dex */
public class p implements e, m, j, a.b, k {
    private final Matrix a = new Matrix();
    private final Path b = new Path();
    private final com.airbnb.lottie.g c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f525d;

    /* renamed from: e  reason: collision with root package name */
    private final String f526e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f527f;

    /* renamed from: g  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<Float, Float> f528g;

    /* renamed from: h  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<Float, Float> f529h;

    /* renamed from: i  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.o f530i;

    /* renamed from: j  reason: collision with root package name */
    private d f531j;

    public p(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar2) {
        this.c = gVar;
        this.f525d = aVar;
        this.f526e = gVar2.c();
        this.f527f = gVar2.f();
        com.airbnb.lottie.t.c.a<Float, Float> a = gVar2.b().a();
        this.f528g = a;
        aVar.i(a);
        a.a(this);
        com.airbnb.lottie.t.c.a<Float, Float> a2 = gVar2.d().a();
        this.f529h = a2;
        aVar.i(a2);
        a2.a(this);
        com.airbnb.lottie.t.c.o b = gVar2.e().b();
        this.f530i = b;
        b.a(aVar);
        b.b(this);
    }

    @Override // com.airbnb.lottie.t.c.a.b
    public void a() {
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t.b.c
    public void b(List<c> list, List<c> list2) {
        this.f531j.b(list, list2);
    }

    @Override // com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        if (this.f530i.c(t, cVar)) {
            return;
        }
        if (t == com.airbnb.lottie.l.q) {
            this.f528g.m(cVar);
        } else if (t == com.airbnb.lottie.l.r) {
            this.f529h.m(cVar);
        }
    }

    @Override // com.airbnb.lottie.model.e
    public void d(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        com.airbnb.lottie.w.g.l(dVar, i2, list, dVar2, this);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.f531j.e(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.t.b.j
    public void f(ListIterator<c> listIterator) {
        if (this.f531j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f531j = new d(this.c, this.f525d, "Repeater", this.f527f, arrayList, null);
    }

    @Override // com.airbnb.lottie.t.b.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.f528g.h().floatValue();
        float floatValue2 = this.f529h.h().floatValue();
        float floatValue3 = this.f530i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.f530i.e().h().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.a.set(matrix);
            float f2 = i3;
            this.a.preConcat(this.f530i.g(f2 + floatValue2));
            this.f531j.g(canvas, this.a, (int) (i2 * com.airbnb.lottie.w.g.j(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.t.b.c
    public String getName() {
        return this.f526e;
    }

    @Override // com.airbnb.lottie.t.b.m
    public Path getPath() {
        Path path = this.f531j.getPath();
        this.b.reset();
        float floatValue = this.f528g.h().floatValue();
        float floatValue2 = this.f529h.h().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.a.set(this.f530i.g(i2 + floatValue2));
            this.b.addPath(path, this.a);
        }
        return this.b;
    }
}
