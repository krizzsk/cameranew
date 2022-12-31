package com.facebook.imagepipeline.memory;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes.dex */
public class MemoryPooledByteBufferOutputStream extends com.facebook.common.memory.h {
    private final u a;
    @Nullable
    private com.facebook.common.references.a<t> b;
    private int c;

    /* loaded from: classes.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(u uVar) {
        this(uVar, uVar.C());
    }

    private void t() {
        if (!com.facebook.common.references.a.Q(this.b)) {
            throw new InvalidStreamException();
        }
    }

    @Override // com.facebook.common.memory.h, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.y(this.b);
        this.b = null;
        this.c = -1;
        super.close();
    }

    @Override // com.facebook.common.memory.h
    public int size() {
        return this.c;
    }

    @VisibleForTesting
    void u(int i2) {
        t();
        com.facebook.common.internal.h.g(this.b);
        if (i2 <= this.b.A().getSize()) {
            return;
        }
        t tVar = this.a.get(i2);
        com.facebook.common.internal.h.g(this.b);
        this.b.A().h(0, tVar, 0, this.c);
        this.b.close();
        this.b = com.facebook.common.references.a.T(tVar, this.a);
    }

    @Override // com.facebook.common.memory.h
    /* renamed from: v */
    public w d() {
        t();
        com.facebook.common.references.a<t> aVar = this.b;
        com.facebook.common.internal.h.g(aVar);
        return new w(aVar, this.c);
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    public MemoryPooledByteBufferOutputStream(u uVar, int i2) {
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 > 0));
        com.facebook.common.internal.h.g(uVar);
        u uVar2 = uVar;
        this.a = uVar2;
        this.c = 0;
        this.b = com.facebook.common.references.a.T(uVar2.get(i2), uVar2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 >= 0 && i3 >= 0 && i2 + i3 <= bArr.length) {
            t();
            u(this.c + i3);
            com.facebook.common.references.a<t> aVar = this.b;
            com.facebook.common.internal.h.g(aVar);
            aVar.A().e(this.c, bArr, i2, i3);
            this.c += i3;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i2 + "; regionLength=" + i3);
    }
}
