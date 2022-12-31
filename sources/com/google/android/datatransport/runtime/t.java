package com.google.android.datatransport.runtime;

import javax.inject.Provider;
/* compiled from: TransportRuntime_Factory.java */
/* loaded from: classes2.dex */
public final class t implements com.google.android.datatransport.runtime.dagger.internal.b<TransportRuntime> {
    private final Provider<com.google.android.datatransport.runtime.x.a> a;
    private final Provider<com.google.android.datatransport.runtime.x.a> b;
    private final Provider<com.google.android.datatransport.runtime.w.e> c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.l> f3414d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.p> f3415e;

    public t(Provider<com.google.android.datatransport.runtime.x.a> provider, Provider<com.google.android.datatransport.runtime.x.a> provider2, Provider<com.google.android.datatransport.runtime.w.e> provider3, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.l> provider4, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.p> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.f3414d = provider4;
        this.f3415e = provider5;
    }

    public static t a(Provider<com.google.android.datatransport.runtime.x.a> provider, Provider<com.google.android.datatransport.runtime.x.a> provider2, Provider<com.google.android.datatransport.runtime.w.e> provider3, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.l> provider4, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.p> provider5) {
        return new t(provider, provider2, provider3, provider4, provider5);
    }

    public static TransportRuntime c(com.google.android.datatransport.runtime.x.a aVar, com.google.android.datatransport.runtime.x.a aVar2, com.google.android.datatransport.runtime.w.e eVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.l lVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.p pVar) {
        return new TransportRuntime(aVar, aVar2, eVar, lVar, pVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TransportRuntime get() {
        return c(this.a.get(), this.b.get(), this.c.get(), this.f3414d.get(), this.f3415e.get());
    }
}
