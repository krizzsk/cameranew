package com.airbnb.lottie.model.content;

import android.graphics.Path;
/* compiled from: GradientFill.java */
/* loaded from: classes.dex */
public class d implements b {
    private final GradientType a;
    private final Path.FillType b;
    private final com.airbnb.lottie.model.h.c c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.d f402d;

    /* renamed from: e  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.f f403e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.f f404f;

    /* renamed from: g  reason: collision with root package name */
    private final String f405g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f406h;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.h.c cVar, com.airbnb.lottie.model.h.d dVar, com.airbnb.lottie.model.h.f fVar, com.airbnb.lottie.model.h.f fVar2, com.airbnb.lottie.model.h.b bVar, com.airbnb.lottie.model.h.b bVar2, boolean z) {
        this.a = gradientType;
        this.b = fillType;
        this.c = cVar;
        this.f402d = dVar;
        this.f403e = fVar;
        this.f404f = fVar2;
        this.f405g = str;
        this.f406h = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.t.b.h(gVar, aVar, this);
    }

    public com.airbnb.lottie.model.h.f b() {
        return this.f404f;
    }

    public Path.FillType c() {
        return this.b;
    }

    public com.airbnb.lottie.model.h.c d() {
        return this.c;
    }

    public GradientType e() {
        return this.a;
    }

    public String f() {
        return this.f405g;
    }

    public com.airbnb.lottie.model.h.d g() {
        return this.f402d;
    }

    public com.airbnb.lottie.model.h.f h() {
        return this.f403e;
    }

    public boolean i() {
        return this.f406h;
    }
}
