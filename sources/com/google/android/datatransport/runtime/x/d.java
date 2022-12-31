package com.google.android.datatransport.runtime.x;
/* compiled from: TimeModule_UptimeClockFactory.java */
/* loaded from: classes2.dex */
public final class d implements com.google.android.datatransport.runtime.dagger.internal.b<com.google.android.datatransport.runtime.x.a> {

    /* compiled from: TimeModule_UptimeClockFactory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final d a = new d();
    }

    public static d a() {
        return a.a;
    }

    public static com.google.android.datatransport.runtime.x.a c() {
        com.google.android.datatransport.runtime.x.a b = b.b();
        com.google.android.datatransport.runtime.dagger.internal.d.c(b, "Cannot return null from a non-@Nullable @Provides method");
        return b;
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public com.google.android.datatransport.runtime.x.a get() {
        return c();
    }
}
