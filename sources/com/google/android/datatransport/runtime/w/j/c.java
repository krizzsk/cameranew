package com.google.android.datatransport.runtime.w.j;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.Closeable;
/* compiled from: EventStore.java */
@WorkerThread
/* loaded from: classes2.dex */
public interface c extends Closeable {
    int B();

    Iterable<com.google.android.datatransport.runtime.m> G();

    long I(com.google.android.datatransport.runtime.m mVar);

    boolean J(com.google.android.datatransport.runtime.m mVar);

    void K(Iterable<i> iterable);

    Iterable<i> L(com.google.android.datatransport.runtime.m mVar);

    @Nullable
    i M(com.google.android.datatransport.runtime.m mVar, com.google.android.datatransport.runtime.h hVar);

    void c(Iterable<i> iterable);

    void f(com.google.android.datatransport.runtime.m mVar, long j2);
}
