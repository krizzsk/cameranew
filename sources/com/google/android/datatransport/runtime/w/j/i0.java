package com.google.android.datatransport.runtime.w.j;

import android.content.Context;
import javax.inject.Provider;
/* compiled from: SchemaManager_Factory.java */
/* loaded from: classes2.dex */
public final class i0 implements com.google.android.datatransport.runtime.dagger.internal.b<h0> {
    private final Provider<Context> a;
    private final Provider<String> b;
    private final Provider<Integer> c;

    public i0(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static i0 a(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new i0(provider, provider2, provider3);
    }

    public static h0 c(Context context, String str, int i2) {
        return new h0(context, str, i2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public h0 get() {
        return c(this.a.get(), this.b.get(), this.c.get().intValue());
    }
}
