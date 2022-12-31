package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Provider;
/* compiled from: MetadataBackendRegistry_Factory.java */
/* loaded from: classes2.dex */
public final class k implements com.google.android.datatransport.runtime.dagger.internal.b<j> {
    private final Provider<Context> a;
    private final Provider<h> b;

    public k(Provider<Context> provider, Provider<h> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static k a(Provider<Context> provider, Provider<h> provider2) {
        return new k(provider, provider2);
    }

    public static j c(Context context, Object obj) {
        return new j(context, (h) obj);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public j get() {
        return c(this.a.get(), this.b.get());
    }
}
