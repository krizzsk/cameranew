package com.tapjoy.internal;

import java.io.Closeable;
import java.io.Flushable;
/* loaded from: classes3.dex */
public interface jb extends Closeable, Flushable {
    void a(ir irVar, long j2);

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.tapjoy.internal.jc
    void close();

    void flush();
}
