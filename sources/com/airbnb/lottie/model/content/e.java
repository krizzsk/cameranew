package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* compiled from: GradientStroke.java */
/* loaded from: classes.dex */
public class e implements b {
    private final String a;
    private final GradientType b;
    private final com.airbnb.lottie.model.h.c c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.d f407d;

    /* renamed from: e  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.f f408e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.f f409f;

    /* renamed from: g  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.b f410g;

    /* renamed from: h  reason: collision with root package name */
    private final ShapeStroke.LineCapType f411h;

    /* renamed from: i  reason: collision with root package name */
    private final ShapeStroke.LineJoinType f412i;

    /* renamed from: j  reason: collision with root package name */
    private final float f413j;

    /* renamed from: k  reason: collision with root package name */
    private final List<com.airbnb.lottie.model.h.b> f414k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.b f415l;
    private final boolean m;

    public e(String str, GradientType gradientType, com.airbnb.lottie.model.h.c cVar, com.airbnb.lottie.model.h.d dVar, com.airbnb.lottie.model.h.f fVar, com.airbnb.lottie.model.h.f fVar2, com.airbnb.lottie.model.h.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, List<com.airbnb.lottie.model.h.b> list, @Nullable com.airbnb.lottie.model.h.b bVar2, boolean z) {
        this.a = str;
        this.b = gradientType;
        this.c = cVar;
        this.f407d = dVar;
        this.f408e = fVar;
        this.f409f = fVar2;
        this.f410g = bVar;
        this.f411h = lineCapType;
        this.f412i = lineJoinType;
        this.f413j = f2;
        this.f414k = list;
        this.f415l = bVar2;
        this.m = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.t.b.i(gVar, aVar, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f411h;
    }

    @Nullable
    public com.airbnb.lottie.model.h.b c() {
        return this.f415l;
    }

    public com.airbnb.lottie.model.h.f d() {
        return this.f409f;
    }

    public com.airbnb.lottie.model.h.c e() {
        return this.c;
    }

    public GradientType f() {
        return this.b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.f412i;
    }

    public List<com.airbnb.lottie.model.h.b> h() {
        return this.f414k;
    }

    public float i() {
        return this.f413j;
    }

    public String j() {
        return this.a;
    }

    public com.airbnb.lottie.model.h.d k() {
        return this.f407d;
    }

    public com.airbnb.lottie.model.h.f l() {
        return this.f408e;
    }

    public com.airbnb.lottie.model.h.b m() {
        return this.f410g;
    }

    public boolean n() {
        return this.m;
    }
}
