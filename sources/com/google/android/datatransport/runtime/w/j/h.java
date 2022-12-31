package com.google.android.datatransport.runtime.w.j;
/* compiled from: EventStoreModule_StoreConfigFactory.java */
/* loaded from: classes2.dex */
public final class h implements com.google.android.datatransport.runtime.dagger.internal.b<d> {

    /* compiled from: EventStoreModule_StoreConfigFactory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final h a = new h();
    }

    public static h a() {
        return a.a;
    }

    public static d c() {
        d c = e.c();
        com.google.android.datatransport.runtime.dagger.internal.d.c(c, "Cannot return null from a non-@Nullable @Provides method");
        return c;
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public d get() {
        return c();
    }
}
