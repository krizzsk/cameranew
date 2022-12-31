package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
/* compiled from: InternalRequestListener.java */
/* loaded from: classes.dex */
public class z extends y implements com.facebook.imagepipeline.e.d {
    @Nullable
    private final com.facebook.imagepipeline.e.e c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.imagepipeline.e.d f3003d;

    public z(@Nullable com.facebook.imagepipeline.e.e eVar, @Nullable com.facebook.imagepipeline.e.d dVar) {
        super(eVar, dVar);
        this.c = eVar;
        this.f3003d = dVar;
    }

    @Override // com.facebook.imagepipeline.e.d
    public void a(o0 o0Var) {
        com.facebook.imagepipeline.e.e eVar = this.c;
        if (eVar != null) {
            eVar.a(o0Var.j(), o0Var.a(), o0Var.getId(), o0Var.m());
        }
        com.facebook.imagepipeline.e.d dVar = this.f3003d;
        if (dVar != null) {
            dVar.a(o0Var);
        }
    }

    @Override // com.facebook.imagepipeline.e.d
    public void e(o0 o0Var) {
        com.facebook.imagepipeline.e.e eVar = this.c;
        if (eVar != null) {
            eVar.c(o0Var.j(), o0Var.getId(), o0Var.m());
        }
        com.facebook.imagepipeline.e.d dVar = this.f3003d;
        if (dVar != null) {
            dVar.e(o0Var);
        }
    }

    @Override // com.facebook.imagepipeline.e.d
    public void g(o0 o0Var) {
        com.facebook.imagepipeline.e.e eVar = this.c;
        if (eVar != null) {
            eVar.k(o0Var.getId());
        }
        com.facebook.imagepipeline.e.d dVar = this.f3003d;
        if (dVar != null) {
            dVar.g(o0Var);
        }
    }

    @Override // com.facebook.imagepipeline.e.d
    public void i(o0 o0Var, Throwable th) {
        com.facebook.imagepipeline.e.e eVar = this.c;
        if (eVar != null) {
            eVar.i(o0Var.j(), o0Var.getId(), th, o0Var.m());
        }
        com.facebook.imagepipeline.e.d dVar = this.f3003d;
        if (dVar != null) {
            dVar.i(o0Var, th);
        }
    }
}
