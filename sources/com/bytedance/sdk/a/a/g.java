package com.bytedance.sdk.a.a;

import java.io.IOException;
/* compiled from: ForwardingSink.java */
/* loaded from: classes.dex */
public abstract class g implements r {
    private final r a;

    public g(r rVar) {
        if (rVar != null) {
            this.a = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // com.bytedance.sdk.a.a.r
    public t a() {
        return this.a.a();
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a_(c cVar, long j2) throws IOException {
        this.a.a_(cVar, j2);
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        this.a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
