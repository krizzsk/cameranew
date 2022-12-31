package com.google.android.datatransport.runtime.w.j;
/* compiled from: EventStoreModule_SchemaVersionFactory.java */
/* loaded from: classes2.dex */
public final class g implements com.google.android.datatransport.runtime.dagger.internal.b<Integer> {

    /* compiled from: EventStoreModule_SchemaVersionFactory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final g a = new g();
    }

    public static g a() {
        return a.a;
    }

    public static int c() {
        return e.b();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Integer get() {
        return Integer.valueOf(c());
    }
}
