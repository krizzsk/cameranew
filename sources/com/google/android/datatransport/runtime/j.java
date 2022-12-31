package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;
/* compiled from: ExecutionModule_ExecutorFactory.java */
/* loaded from: classes2.dex */
public final class j implements com.google.android.datatransport.runtime.dagger.internal.b<Executor> {

    /* compiled from: ExecutionModule_ExecutorFactory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final j a = new j();
    }

    public static j a() {
        return a.a;
    }

    public static Executor b() {
        Executor a2 = i.a();
        com.google.android.datatransport.runtime.dagger.internal.d.c(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public Executor get() {
        return b();
    }
}
