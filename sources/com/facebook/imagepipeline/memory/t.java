package com.facebook.imagepipeline.memory;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
/* compiled from: MemoryChunk.java */
/* loaded from: classes.dex */
public interface t {
    @Nullable
    ByteBuffer C();

    byte D(int i2);

    long E() throws UnsupportedOperationException;

    int b(int i2, byte[] bArr, int i3, int i4);

    void close();

    long d();

    int e(int i2, byte[] bArr, int i3, int i4);

    int getSize();

    void h(int i2, t tVar, int i3, int i4);

    boolean isClosed();
}
