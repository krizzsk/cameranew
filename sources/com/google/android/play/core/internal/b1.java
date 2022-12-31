package com.google.android.play.core.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public abstract class b1 implements Closeable {
    public abstract long d();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract InputStream e(long j2, long j3) throws IOException;

    public synchronized InputStream t() throws IOException {
        return e(0L, d());
    }
}
