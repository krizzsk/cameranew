package com.facebook.common.memory;

import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public interface PooledByteBuffer extends Closeable {

    /* loaded from: classes.dex */
    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }

    @Nullable
    ByteBuffer C();

    byte D(int i2);

    long E();

    int b(int i2, byte[] bArr, int i3, int i4);

    boolean isClosed();

    int size();
}
