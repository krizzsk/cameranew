package com.airbnb.lottie.model.content;

import com.airbnb.lottie.t.b.q;
/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class k implements b {
    private final String a;
    private final int b;
    private final com.airbnb.lottie.model.h.h c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f423d;

    public k(String str, int i2, com.airbnb.lottie.model.h.h hVar, boolean z) {
        this.a = str;
        this.b = i2;
        this.c = hVar;
        this.f423d = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public com.airbnb.lottie.model.h.h c() {
        return this.c;
    }

    public boolean d() {
        return this.f423d;
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.b + '}';
    }
}
