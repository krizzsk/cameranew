package com.google.android.datatransport.runtime.w.j;
/* compiled from: EventStoreModule_DbNameFactory.java */
/* loaded from: classes2.dex */
public final class f implements com.google.android.datatransport.runtime.dagger.internal.b<String> {

    /* compiled from: EventStoreModule_DbNameFactory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final f a = new f();
    }

    public static f a() {
        return a.a;
    }

    public static String b() {
        String a2 = e.a();
        com.google.android.datatransport.runtime.dagger.internal.d.c(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public String get() {
        return b();
    }
}
