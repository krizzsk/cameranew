package com.google.android.datatransport.runtime;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransportRuntimeComponent.java */
@Singleton
/* loaded from: classes2.dex */
public abstract class s implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TransportRuntimeComponent.java */
    /* loaded from: classes2.dex */
    public interface a {
        a a(Context context);

        s build();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        d().close();
    }

    abstract com.google.android.datatransport.runtime.w.j.c d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract TransportRuntime t();
}
