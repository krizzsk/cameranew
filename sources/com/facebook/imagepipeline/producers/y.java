package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;
/* compiled from: InternalProducerListener.java */
/* loaded from: classes.dex */
public class y implements q0 {
    @Nullable
    private final r0 a;
    @Nullable
    private final q0 b;

    public y(@Nullable r0 r0Var, @Nullable q0 q0Var) {
        this.a = r0Var;
        this.b = q0Var;
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void b(o0 o0Var, String str, boolean z) {
        r0 r0Var = this.a;
        if (r0Var != null) {
            r0Var.h(o0Var.getId(), str, z);
        }
        q0 q0Var = this.b;
        if (q0Var != null) {
            q0Var.b(o0Var, str, z);
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void c(o0 o0Var, String str, @Nullable Map<String, String> map) {
        r0 r0Var = this.a;
        if (r0Var != null) {
            r0Var.g(o0Var.getId(), str, map);
        }
        q0 q0Var = this.b;
        if (q0Var != null) {
            q0Var.c(o0Var, str, map);
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void d(o0 o0Var, String str) {
        r0 r0Var = this.a;
        if (r0Var != null) {
            r0Var.b(o0Var.getId(), str);
        }
        q0 q0Var = this.b;
        if (q0Var != null) {
            q0Var.d(o0Var, str);
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public boolean f(o0 o0Var, String str) {
        q0 q0Var;
        r0 r0Var = this.a;
        boolean d2 = r0Var != null ? r0Var.d(o0Var.getId()) : false;
        return (d2 || (q0Var = this.b) == null) ? d2 : q0Var.f(o0Var, str);
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void h(o0 o0Var, String str, String str2) {
        r0 r0Var = this.a;
        if (r0Var != null) {
            r0Var.j(o0Var.getId(), str, str2);
        }
        q0 q0Var = this.b;
        if (q0Var != null) {
            q0Var.h(o0Var, str, str2);
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void j(o0 o0Var, String str, @Nullable Map<String, String> map) {
        r0 r0Var = this.a;
        if (r0Var != null) {
            r0Var.e(o0Var.getId(), str, map);
        }
        q0 q0Var = this.b;
        if (q0Var != null) {
            q0Var.j(o0Var, str, map);
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void k(o0 o0Var, String str, Throwable th, @Nullable Map<String, String> map) {
        r0 r0Var = this.a;
        if (r0Var != null) {
            r0Var.f(o0Var.getId(), str, th, map);
        }
        q0 q0Var = this.b;
        if (q0Var != null) {
            q0Var.k(o0Var, str, th, map);
        }
    }
}
