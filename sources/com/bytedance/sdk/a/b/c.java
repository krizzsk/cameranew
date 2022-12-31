package com.bytedance.sdk.a.b;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
/* compiled from: Cache.java */
/* loaded from: classes.dex */
public final class c implements Closeable, Flushable {
    final com.bytedance.sdk.a.b.a.a.e a;
    final com.bytedance.sdk.a.b.a.a.d b;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }
}
