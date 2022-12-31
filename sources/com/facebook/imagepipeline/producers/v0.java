package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;
/* compiled from: StatefulProducerRunnable.java */
/* loaded from: classes.dex */
public abstract class v0<T> extends com.facebook.common.executors.f<T> {
    private final l<T> b;
    private final q0 c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2990d;

    /* renamed from: e  reason: collision with root package name */
    private final o0 f2991e;

    public v0(l<T> lVar, q0 q0Var, o0 o0Var, String str) {
        this.b = lVar;
        this.c = q0Var;
        this.f2990d = str;
        this.f2991e = o0Var;
        q0Var.d(o0Var, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.executors.f
    public void d() {
        q0 q0Var = this.c;
        o0 o0Var = this.f2991e;
        String str = this.f2990d;
        q0Var.c(o0Var, str, q0Var.f(o0Var, str) ? g() : null);
        this.b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.executors.f
    public void e(Exception exc) {
        q0 q0Var = this.c;
        o0 o0Var = this.f2991e;
        String str = this.f2990d;
        q0Var.k(o0Var, str, exc, q0Var.f(o0Var, str) ? h(exc) : null);
        this.b.onFailure(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.executors.f
    public void f(@Nullable T t) {
        q0 q0Var = this.c;
        o0 o0Var = this.f2991e;
        String str = this.f2990d;
        q0Var.j(o0Var, str, q0Var.f(o0Var, str) ? i(t) : null);
        this.b.c(t, 1);
    }

    @Nullable
    protected Map<String, String> g() {
        return null;
    }

    @Nullable
    protected Map<String, String> h(Exception exc) {
        return null;
    }

    @Nullable
    protected Map<String, String> i(@Nullable T t) {
        return null;
    }
}
