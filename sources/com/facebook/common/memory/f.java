package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* compiled from: PooledByteBufferFactory.java */
/* loaded from: classes.dex */
public interface f {
    PooledByteBuffer a(InputStream inputStream) throws IOException;

    PooledByteBuffer b(InputStream inputStream, int i2) throws IOException;

    h c();

    PooledByteBuffer d(byte[] bArr);

    h e(int i2);
}
