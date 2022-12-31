package com.facebook.imagepipeline.memory;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: MemoryPooledByteBufferFactory.java */
@ThreadSafe
/* loaded from: classes.dex */
public class x implements com.facebook.common.memory.f {
    private final com.facebook.common.memory.i a;
    private final u b;

    public x(u uVar, com.facebook.common.memory.i iVar) {
        this.b = uVar;
        this.a = iVar;
    }

    @VisibleForTesting
    w f(InputStream inputStream, MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream) throws IOException {
        this.a.a(inputStream, memoryPooledByteBufferOutputStream);
        return memoryPooledByteBufferOutputStream.d();
    }

    @Override // com.facebook.common.memory.f
    /* renamed from: g */
    public w a(InputStream inputStream) throws IOException {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.b);
        try {
            return f(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.f
    /* renamed from: h */
    public w b(InputStream inputStream, int i2) throws IOException {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.b, i2);
        try {
            return f(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.f
    /* renamed from: i */
    public w d(byte[] bArr) {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.b, bArr.length);
        try {
            try {
                memoryPooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                return memoryPooledByteBufferOutputStream.d();
            } catch (IOException e2) {
                com.facebook.common.internal.m.a(e2);
                throw null;
            }
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.f
    /* renamed from: j */
    public MemoryPooledByteBufferOutputStream c() {
        return new MemoryPooledByteBufferOutputStream(this.b);
    }

    @Override // com.facebook.common.memory.f
    /* renamed from: k */
    public MemoryPooledByteBufferOutputStream e(int i2) {
        return new MemoryPooledByteBufferOutputStream(this.b, i2);
    }
}
