package com.google.android.datatransport.runtime.w;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
import java.util.concurrent.Executor;
import javax.inject.Provider;
/* compiled from: DefaultScheduler_Factory.java */
/* loaded from: classes2.dex */
public final class d implements com.google.android.datatransport.runtime.dagger.internal.b<c> {
    private final Provider<Executor> a;
    private final Provider<com.google.android.datatransport.runtime.backends.e> b;
    private final Provider<r> c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.w.j.c> f3420d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.synchronization.a> f3421e;

    public d(Provider<Executor> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<r> provider3, Provider<com.google.android.datatransport.runtime.w.j.c> provider4, Provider<com.google.android.datatransport.runtime.synchronization.a> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.f3420d = provider4;
        this.f3421e = provider5;
    }

    public static d a(Provider<Executor> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<r> provider3, Provider<com.google.android.datatransport.runtime.w.j.c> provider4, Provider<com.google.android.datatransport.runtime.synchronization.a> provider5) {
        return new d(provider, provider2, provider3, provider4, provider5);
    }

    public static c c(Executor executor, com.google.android.datatransport.runtime.backends.e eVar, r rVar, com.google.android.datatransport.runtime.w.j.c cVar, com.google.android.datatransport.runtime.synchronization.a aVar) {
        return new c(executor, eVar, rVar, cVar, aVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public c get() {
        return c(this.a.get(), this.b.get(), this.c.get(), this.f3420d.get(), this.f3421e.get());
    }
}
