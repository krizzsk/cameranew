package com.facebook.common.memory;

import com.facebook.common.internal.m;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: PooledByteBufferOutputStream.java */
/* loaded from: classes.dex */
public abstract class h extends OutputStream {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e2) {
            m.a(e2);
            throw null;
        }
    }

    public abstract PooledByteBuffer d();

    public abstract int size();
}
