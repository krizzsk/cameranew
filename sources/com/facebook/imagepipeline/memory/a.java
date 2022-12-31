package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
/* compiled from: AshmemMemoryChunk.java */
@TargetApi(27)
/* loaded from: classes.dex */
public class a implements t, Closeable {
    @Nullable
    private SharedMemory a;
    @Nullable
    private ByteBuffer b;
    private final long c;

    public a(int i2) {
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 > 0));
        try {
            SharedMemory create = SharedMemory.create("AshmemMemoryChunk", i2);
            this.a = create;
            this.b = create.mapReadWrite();
            this.c = System.identityHashCode(this);
        } catch (ErrnoException e2) {
            throw new RuntimeException("Fail to create AshmemMemory", e2);
        }
    }

    private void a(int i2, t tVar, int i3, int i4) {
        if (tVar instanceof a) {
            com.facebook.common.internal.h.i(!isClosed());
            com.facebook.common.internal.h.i(!tVar.isClosed());
            v.b(i2, tVar.getSize(), i3, i4, getSize());
            this.b.position(i2);
            tVar.C().position(i3);
            byte[] bArr = new byte[i4];
            this.b.get(bArr, 0, i4);
            tVar.C().put(bArr, 0, i4);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.t
    @Nullable
    public ByteBuffer C() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized byte D(int i2) {
        boolean z = true;
        com.facebook.common.internal.h.i(!isClosed());
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 >= 0));
        if (i2 >= getSize()) {
            z = false;
        }
        com.facebook.common.internal.h.b(Boolean.valueOf(z));
        return this.b.get(i2);
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long E() {
        throw new UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized int b(int i2, byte[] bArr, int i3, int i4) {
        int a;
        com.facebook.common.internal.h.g(bArr);
        com.facebook.common.internal.h.i(!isClosed());
        a = v.a(i2, i4, getSize());
        v.b(i2, bArr.length, i3, a, getSize());
        this.b.position(i2);
        this.b.get(bArr, i3, a);
        return a;
    }

    @Override // com.facebook.imagepipeline.memory.t, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!isClosed()) {
            SharedMemory.unmap(this.b);
            this.a.close();
            this.b = null;
            this.a = null;
        }
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
        a = v.a(i2, i4, getSize());
        v.b(i2, bArr.length, i3, a, getSize());
        this.b.position(i2);
        this.b.put(bArr, i3, a);
        return a;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public int getSize() {
        com.facebook.common.internal.h.i(!isClosed());
        return this.a.getSize();
    }

    @Override // com.facebook.imagepipeline.memory.t
    public void h(int i2, t tVar, int i3, int i4) {
        com.facebook.common.internal.h.g(tVar);
        if (tVar.d() == d()) {
            Log.w("AshmemMemoryChunk", "Copying from AshmemMemoryChunk " + Long.toHexString(d()) + " to AshmemMemoryChunk " + Long.toHexString(tVar.d()) + " which are the same ");
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
        boolean z;
        if (this.b != null) {
            z = this.a == null;
        }
        return z;
    }
}
