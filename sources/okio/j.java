package okio;

import java.io.Closeable;
import java.io.IOException;
/* compiled from: Source.java */
/* loaded from: classes3.dex */
public interface j extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    void close() throws IOException;

    long r(b bVar, long j2) throws IOException;
}
