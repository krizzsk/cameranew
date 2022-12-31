package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* compiled from: ShapeFill.java */
/* loaded from: classes.dex */
public class i implements b {
    private final boolean a;
    private final Path.FillType b;
    private final String c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.a f420d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.d f421e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f422f;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.h.a aVar, @Nullable com.airbnb.lottie.model.h.d dVar, boolean z2) {
        this.c = str;
        this.a = z;
        this.b = fillType;
        this.f420d = aVar;
        this.f421e = dVar;
        this.f422f = z2;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.t.b.g(gVar, aVar, this);
    }

    @Nullable
    public com.airbnb.lottie.model.h.a b() {
        return this.f420d;
    }

    public Path.FillType c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    @Nullable
    public com.airbnb.lottie.model.h.d e() {
        return this.f421e;
    }

    public boolean f() {
        return this.f422f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }
}
