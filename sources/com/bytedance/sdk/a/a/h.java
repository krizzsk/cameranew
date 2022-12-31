package com.bytedance.sdk.a.a;

import java.io.IOException;
/* compiled from: ForwardingSource.java */
/* loaded from: classes.dex */
public abstract class h implements s {
    private final s a;

    public h(s sVar) {
        if (sVar != null) {
            this.a = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j2) throws IOException {
        return this.a.a(cVar, j2);
    }

    public final s b() {
        return this.a;
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.a.a();
    }
}
