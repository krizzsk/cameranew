package com.airbnb.lottie.model.h;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.t.c.o;
/* compiled from: AnimatableTransform.java */
/* loaded from: classes.dex */
public class l implements com.airbnb.lottie.model.content.b {
    @Nullable
    private final e a;
    @Nullable
    private final m<PointF, PointF> b;
    @Nullable
    private final g c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final b f426d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final d f427e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final b f428f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final b f429g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final b f430h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final b f431i;

    public l() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    public o b() {
        return new o(this);
    }

    @Nullable
    public e c() {
        return this.a;
    }

    @Nullable
    public b d() {
        return this.f431i;
    }

    @Nullable
    public d e() {
        return this.f427e;
    }

    @Nullable
    public m<PointF, PointF> f() {
        return this.b;
    }

    @Nullable
    public b g() {
        return this.f426d;
    }

    @Nullable
    public g h() {
        return this.c;
    }

    @Nullable
    public b i() {
        return this.f428f;
    }

    @Nullable
    public b j() {
        return this.f429g;
    }

    @Nullable
    public b k() {
        return this.f430h;
    }

    public l(@Nullable e eVar, @Nullable m<PointF, PointF> mVar, @Nullable g gVar, @Nullable b bVar, @Nullable d dVar, @Nullable b bVar2, @Nullable b bVar3, @Nullable b bVar4, @Nullable b bVar5) {
        this.a = eVar;
        this.b = mVar;
        this.c = gVar;
        this.f426d = bVar;
        this.f427e = dVar;
        this.f430h = bVar2;
        this.f431i = bVar3;
        this.f428f = bVar4;
        this.f429g = bVar5;
    }
}
