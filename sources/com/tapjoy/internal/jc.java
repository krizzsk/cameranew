package com.tapjoy.internal;

import java.io.Closeable;
/* loaded from: classes3.dex */
public interface jc extends Closeable {
    long b(ir irVar, long j2);

    @Override // java.lang.AutoCloseable, com.tapjoy.internal.jc
    void close();
}
