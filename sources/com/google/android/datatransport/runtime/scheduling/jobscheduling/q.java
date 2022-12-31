package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.concurrent.Executor;
import javax.inject.Provider;
/* compiled from: WorkInitializer_Factory.java */
/* loaded from: classes2.dex */
public final class q implements com.google.android.datatransport.runtime.dagger.internal.b<p> {
    private final Provider<Executor> a;
    private final Provider<com.google.android.datatransport.runtime.w.j.c> b;
    private final Provider<r> c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.synchronization.a> f3413d;

    public q(Provider<Executor> provider, Provider<com.google.android.datatransport.runtime.w.j.c> provider2, Provider<r> provider3, Provider<com.google.android.datatransport.runtime.synchronization.a> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.f3413d = provider4;
    }

    public static q a(Provider<Executor> provider, Provider<com.google.android.datatransport.runtime.w.j.c> provider2, Provider<r> provider3, Provider<com.google.android.datatransport.runtime.synchronization.a> provider4) {
        return new q(provider, provider2, provider3, provider4);
    }

    public static p c(Executor executor, com.google.android.datatransport.runtime.w.j.c cVar, r rVar, com.google.android.datatransport.runtime.synchronization.a aVar) {
        return new p(executor, cVar, rVar, aVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public p get() {
        return c(this.a.get(), this.b.get(), this.c.get(), this.f3413d.get());
    }
}
