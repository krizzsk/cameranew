package com.google.android.datatransport.runtime.x;
/* compiled from: TimeModule_EventClockFactory.java */
/* loaded from: classes2.dex */
public final class c implements com.google.android.datatransport.runtime.dagger.internal.b<com.google.android.datatransport.runtime.x.a> {

    /* compiled from: TimeModule_EventClockFactory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final c a = new c();
    }

    public static c a() {
        return a.a;
    }

    public static com.google.android.datatransport.runtime.x.a b() {
        com.google.android.datatransport.runtime.x.a a2 = b.a();
        com.google.android.datatransport.runtime.dagger.internal.d.c(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public com.google.android.datatransport.runtime.x.a get() {
        return b();
    }
}
