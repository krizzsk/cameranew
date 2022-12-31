package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import java.util.concurrent.Executor;
import javax.inject.Provider;
/* compiled from: Uploader_Factory.java */
/* loaded from: classes2.dex */
public final class m implements com.google.android.datatransport.runtime.dagger.internal.b<l> {
    private final Provider<Context> a;
    private final Provider<com.google.android.datatransport.runtime.backends.e> b;
    private final Provider<com.google.android.datatransport.runtime.w.j.c> c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<r> f3408d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Executor> f3409e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.synchronization.a> f3410f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.x.a> f3411g;

    public m(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<com.google.android.datatransport.runtime.w.j.c> provider3, Provider<r> provider4, Provider<Executor> provider5, Provider<com.google.android.datatransport.runtime.synchronization.a> provider6, Provider<com.google.android.datatransport.runtime.x.a> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.f3408d = provider4;
        this.f3409e = provider5;
        this.f3410f = provider6;
        this.f3411g = provider7;
    }

    public static m a(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<com.google.android.datatransport.runtime.w.j.c> provider3, Provider<r> provider4, Provider<Executor> provider5, Provider<com.google.android.datatransport.runtime.synchronization.a> provider6, Provider<com.google.android.datatransport.runtime.x.a> provider7) {
        return new m(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static l c(Context context, com.google.android.datatransport.runtime.backends.e eVar, com.google.android.datatransport.runtime.w.j.c cVar, r rVar, Executor executor, com.google.android.datatransport.runtime.synchronization.a aVar, com.google.android.datatransport.runtime.x.a aVar2) {
        return new l(context, eVar, cVar, rVar, executor, aVar, aVar2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public l get() {
        return c(this.a.get(), this.b.get(), this.c.get(), this.f3408d.get(), this.f3409e.get(), this.f3410f.get(), this.f3411g.get());
    }
}
