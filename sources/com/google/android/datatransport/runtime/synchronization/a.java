package com.google.android.datatransport.runtime.synchronization;

import androidx.annotation.WorkerThread;
/* compiled from: SynchronizationGuard.java */
@WorkerThread
/* loaded from: classes2.dex */
public interface a {

    /* compiled from: SynchronizationGuard.java */
    /* renamed from: com.google.android.datatransport.runtime.synchronization.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0131a<T> {
        T execute();
    }

    <T> T a(InterfaceC0131a<T> interfaceC0131a);
}
