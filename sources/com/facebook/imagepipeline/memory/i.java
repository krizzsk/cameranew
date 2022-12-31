package com.facebook.imagepipeline.memory;

import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
/* compiled from: BufferMemoryChunk.java */
/* loaded from: classes.dex */
public class i implements t, Closeable {
    private ByteBuffer a;
    private final int b;
    private final long c = System.identityHashCode(this);

    public i(int i2) {
        this.a = ByteBuffer.allocateDirect(i2);
        this.b = i2;
    }

    private void a(int i2, t tVar, int i3, int i4) {
        if (tVar instanceof i) {
            com.facebook.common.internal.h.i(!isClosed());
            com.facebook.common.internal.h.i(!tVar.isClosed());
            v.b(i2, tVar.getSize(), i3, i4, this.b);
            this.a.position(i2);
            tVar.C().position(i3);
            byte[] bArr = new byte[i4];
            this.a.get(bArr, 0, i4);
            tVar.C().put(bArr, 0, i4);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.t
    @Nullable
    public synchronized ByteBuffer C() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized byte D(int i2) {
        boolean z = true;
        com.facebook.common.internal.h.i(!isClosed());
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 >= 0));
        if (i2 >= this.b) {
            z = false;
        }
        com.facebook.common.internal.h.b(Boolean.valueOf(z));
        return this.a.get(i2);
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long E() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized int b(int i2, byte[] bArr, int i3, int i4) {
        int a;
        com.facebook.common.internal.h.g(bArr);
        com.facebook.common.internal.h.i(!isClosed());
        a = v.a(i2, i4, this.b);
        v.b(i2, bArr.length, i3, a, this.b);
        this.a.position(i2);
        this.a.get(bArr, i3, a);
        return a;
    }

    @Override // com.facebook.imagepipeline.memory.t, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.a = null;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long d() {
        return this.c;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized int e(int i2, byte[] bArr, int i3, int i4) {
        int a;
        com.facebook.common.internal.h.g(bArr);
        com.facebook.common.internal.h.i(!isClosed());
        a = v.a(i2, i4, this.b);
        v.b(i2, bArr.length, i3, a, this.b);
        this.a.position(i2);
        this.a.put(bArr, i3, a);
        return a;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public int getSize() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public void h(int i2, t tVar, int i3, int i4) {
        com.facebook.common.internal.h.g(tVar);
        if (tVar.d() == d()) {
            Log.w("BufferMemoryChunk", "Copying from BufferMemoryChunk " + Long.toHexString(d()) + " to BufferMemoryChunk " + Long.toHexString(tVar.d()) + " which are the same ");
            com.facebook.common.internal.h.b(Boolean.FALSE);
        }
        if (tVar.d() < d()) {
            synchronized (tVar) {
                synchronized (this) {
                    a(i2, tVar, i3, i4);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (tVar) {
                a(i2, tVar, i3, i4);
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized boolean isClosed() {
        return this.a == null;
    }
}
