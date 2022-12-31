package com.airbnb.lottie.t.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.t.c.a;
import java.util.List;
/* compiled from: ShapeContent.java */
/* loaded from: classes.dex */
public class q implements m, a.b {
    private final boolean b;
    private final com.airbnb.lottie.g c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<?, Path> f532d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f533e;
    private final Path a = new Path();

    /* renamed from: f  reason: collision with root package name */
    private b f534f = new b();

    public q(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        kVar.b();
        this.b = kVar.d();
        this.c = gVar;
        com.airbnb.lottie.t.c.a<com.airbnb.lottie.model.content.h, Path> a = kVar.c().a();
        this.f532d = a;
        aVar.i(a);
        a.a(this);
    }

    private void c() {
        this.f533e = false;
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t.c.a.b
    public void a() {
        c();
    }

    @Override // com.airbnb.lottie.t.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f534f.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.m
    public Path getPath() {
        if (this.f533e) {
            return this.a;
        }
        this.a.reset();
        if (this.b) {
            this.f533e = true;
            return this.a;
        }
        this.a.set(this.f532d.h());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.f534f.b(this.a);
        this.f533e = true;
        return this.a;
    }
}
