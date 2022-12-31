package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.h.m;
/* compiled from: CircleShape.java */
/* loaded from: classes.dex */
public class a implements b {
    private final String a;
    private final m<PointF, PointF> b;
    private final com.airbnb.lottie.model.h.f c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f400d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f401e;

    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.h.f fVar, boolean z, boolean z2) {
        this.a = str;
        this.b = mVar;
        this.c = fVar;
        this.f400d = z;
        this.f401e = z2;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.t.b.f(gVar, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public m<PointF, PointF> c() {
        return this.b;
    }

    public com.airbnb.lottie.model.h.f d() {
        return this.c;
    }

    public boolean e() {
        return this.f401e;
    }

    public boolean f() {
        return this.f400d;
    }
}
