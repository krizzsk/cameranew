package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.h.l;
import com.airbnb.lottie.t.b.p;
/* compiled from: Repeater.java */
/* loaded from: classes.dex */
public class g implements b {
    private final String a;
    private final com.airbnb.lottie.model.h.b b;
    private final com.airbnb.lottie.model.h.b c;

    /* renamed from: d  reason: collision with root package name */
    private final l f418d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f419e;

    public g(String str, com.airbnb.lottie.model.h.b bVar, com.airbnb.lottie.model.h.b bVar2, l lVar, boolean z) {
        this.a = str;
        this.b = bVar;
        this.c = bVar2;
        this.f418d = lVar;
        this.f419e = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new p(gVar, aVar, this);
    }

    public com.airbnb.lottie.model.h.b b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public com.airbnb.lottie.model.h.b d() {
        return this.c;
    }

    public l e() {
        return this.f418d;
    }

    public boolean f() {
        return this.f419e;
    }
}
