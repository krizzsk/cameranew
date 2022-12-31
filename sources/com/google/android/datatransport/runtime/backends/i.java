package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Provider;
/* compiled from: CreationContextFactory_Factory.java */
/* loaded from: classes2.dex */
public final class i implements com.google.android.datatransport.runtime.dagger.internal.b<h> {
    private final Provider<Context> a;
    private final Provider<com.google.android.datatransport.runtime.x.a> b;
    private final Provider<com.google.android.datatransport.runtime.x.a> c;

    public i(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.x.a> provider2, Provider<com.google.android.datatransport.runtime.x.a> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static i a(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.x.a> provider2, Provider<com.google.android.datatransport.runtime.x.a> provider3) {
        return new i(provider, provider2, provider3);
    }

    public static h c(Context context, com.google.android.datatransport.runtime.x.a aVar, com.google.android.datatransport.runtime.x.a aVar2) {
        return new h(context, aVar, aVar2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public h get() {
        return c(this.a.get(), this.b.get(), this.c.get());
    }
}
