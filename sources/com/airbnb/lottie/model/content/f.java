package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.h.m;
import com.airbnb.lottie.t.b.o;
/* compiled from: RectangleShape.java */
/* loaded from: classes.dex */
public class f implements b {
    private final String a;
    private final m<PointF, PointF> b;
    private final com.airbnb.lottie.model.h.f c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.b f416d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f417e;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.h.f fVar, com.airbnb.lottie.model.h.b bVar, boolean z) {
        this.a = str;
        this.b = mVar;
        this.c = fVar;
        this.f416d = bVar;
        this.f417e = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }

    public com.airbnb.lottie.model.h.b b() {
        return this.f416d;
    }

    public String c() {
        return this.a;
    }

    public m<PointF, PointF> d() {
        return this.b;
    }

    public com.airbnb.lottie.model.h.f e() {
        return this.c;
    }

    public boolean f() {
        return this.f417e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.b + ", size=" + this.c + '}';
    }
}
