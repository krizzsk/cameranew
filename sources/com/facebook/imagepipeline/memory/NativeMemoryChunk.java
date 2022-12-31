package com.facebook.imagepipeline.memory;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
@com.facebook.common.internal.d
/* loaded from: classes.dex */
public class NativeMemoryChunk implements t, Closeable {
    private final long a;
    private final int b;
    private boolean c;

    static {
        com.facebook.soloader.n.a.d("imagepipeline");
    }

    public NativeMemoryChunk(int i2) {
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 > 0));
        this.b = i2;
        this.a = nativeAllocate(i2);
        this.c = false;
    }

    private void a(int i2, t tVar, int i3, int i4) {
        if (tVar instanceof NativeMemoryChunk) {
            com.facebook.common.internal.h.i(!isClosed());
            com.facebook.common.internal.h.i(!tVar.isClosed());
            v.b(i2, tVar.getSize(), i3, i4, this.b);
            nativeMemcpy(tVar.E() + i3, this.a + i2, i4);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @com.facebook.common.internal.d
    private static native long nativeAllocate(int i2);

    @com.facebook.common.internal.d
    private static native void nativeCopyFromByteArray(long j2, byte[] bArr, int i2, int i3);

    @com.facebook.common.internal.d
    private static native void nativeCopyToByteArray(long j2, byte[] bArr, int i2, int i3);

    @com.facebook.common.internal.d
    private static native void nativeFree(long j2);

    @com.facebook.common.internal.d
    private static native void nativeMemcpy(long j2, long j3, int i2);

    @com.facebook.common.internal.d
    private static native byte nativeReadByte(long j2);

    @Override // com.facebook.imagepipeline.memory.t
    @Nullable
    public ByteBuffer C() {
        return null;
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
        return nativeReadByte(this.a + i2);
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long E() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized int b(int i2, byte[] bArr, int i3, int i4) {
        int a;
        com.facebook.common.internal.h.g(bArr);
        com.facebook.common.internal.h.i(!isClosed());
        a = v.a(i2, i4, this.b);
        v.b(i2, bArr.length, i3, a, this.b);
        nativeCopyToByteArray(this.a + i2, bArr, i3, a);
        return a;
    }

    @Override // com.facebook.imagepipeline.memory.t, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.c) {
            this.c = true;
            nativeFree(this.a);
        }
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long d() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized int e(int i2, byte[] bArr, int i3, int i4) {
        int a;
        com.facebook.common.internal.h.g(bArr);
        com.facebook.common.internal.h.i(!isClosed());
        a = v.a(i2, i4, this.b);
        v.b(i2, bArr.length, i3, a, this.b);
        nativeCopyFromByteArray(this.a + i2, bArr, i3, a);
        return a;
    }

    protected void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. ");
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // com.facebook.imagepipeline.memory.t
    public int getSize() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public void h(int i2, t tVar, int i3, int i4) {
        com.facebook.common.internal.h.g(tVar);
        if (tVar.d() == d()) {
            Log.w("NativeMemoryChunk", "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(tVar)) + " which share the same address " + Long.toHexString(this.a));
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
        return this.c;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.b = 0;
        this.a = 0L;
        this.c = true;
    }
}
