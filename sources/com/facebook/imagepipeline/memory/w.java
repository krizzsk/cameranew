package com.facebook.imagepipeline.memory;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: MemoryPooledByteBuffer.java */
@ThreadSafe
/* loaded from: classes.dex */
public class w implements PooledByteBuffer {
    private final int a;
    @GuardedBy("this")
    @VisibleForTesting
    com.facebook.common.references.a<t> b;

    public w(com.facebook.common.references.a<t> aVar, int i2) {
        com.facebook.common.internal.h.g(aVar);
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 >= 0 && i2 <= aVar.A().getSize()));
        this.b = aVar.clone();
        this.a = i2;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    @Nullable
    public synchronized ByteBuffer C() {
        return this.b.A().C();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte D(int i2) {
        d();
        boolean z = true;
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 >= 0));
        if (i2 >= this.a) {
            z = false;
        }
        com.facebook.common.internal.h.b(Boolean.valueOf(z));
        return this.b.A().D(i2);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long E() throws UnsupportedOperationException {
        d();
        return this.b.A().E();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int b(int i2, byte[] bArr, int i3, int i4) {
        d();
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 + i4 <= this.a));
        return this.b.A().b(i2, bArr, i3, i4);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.a.y(this.b);
        this.b = null;
    }

    synchronized void d() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.a.Q(this.b);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        d();
        return this.a;
    }
}
