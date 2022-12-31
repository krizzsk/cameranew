package com.facebook.imagepipeline.producers;

import android.net.Uri;
import javax.annotation.Nullable;
/* compiled from: FetchState.java */
/* loaded from: classes.dex */
public class w {
    private final l<com.facebook.imagepipeline.image.e> a;
    private final o0 b;
    private long c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f2992d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private com.facebook.imagepipeline.common.a f2993e;

    public w(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        this.a = lVar;
        this.b = o0Var;
    }

    public l<com.facebook.imagepipeline.image.e> a() {
        return this.a;
    }

    public o0 b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public q0 d() {
        return this.b.h();
    }

    public int e() {
        return this.f2992d;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a f() {
        return this.f2993e;
    }

    public Uri g() {
        return this.b.j().s();
    }

    public void h(long j2) {
        this.c = j2;
    }
}
