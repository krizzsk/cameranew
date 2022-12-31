package com.google.android.datatransport.runtime.w.j;

import javax.inject.Provider;
/* compiled from: SQLiteEventStore_Factory.java */
/* loaded from: classes2.dex */
public final class c0 implements com.google.android.datatransport.runtime.dagger.internal.b<b0> {
    private final Provider<com.google.android.datatransport.runtime.x.a> a;
    private final Provider<com.google.android.datatransport.runtime.x.a> b;
    private final Provider<d> c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<h0> f3430d;

    public c0(Provider<com.google.android.datatransport.runtime.x.a> provider, Provider<com.google.android.datatransport.runtime.x.a> provider2, Provider<d> provider3, Provider<h0> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.f3430d = provider4;
    }

    public static c0 a(Provider<com.google.android.datatransport.runtime.x.a> provider, Provider<com.google.android.datatransport.runtime.x.a> provider2, Provider<d> provider3, Provider<h0> provider4) {
        return new c0(provider, provider2, provider3, provider4);
    }

    public static b0 c(com.google.android.datatransport.runtime.x.a aVar, com.google.android.datatransport.runtime.x.a aVar2, Object obj, Object obj2) {
        return new b0(aVar, aVar2, (d) obj, (h0) obj2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public b0 get() {
        return c(this.a.get(), this.b.get(), this.c.get(), this.f3430d.get());
    }
}
