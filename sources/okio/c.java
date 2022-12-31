package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;
/* compiled from: BufferedSink.java */
/* loaded from: classes3.dex */
public interface c extends Closeable, Flushable, WritableByteChannel {
    c k(String str) throws IOException;

    c l(String str, int i2, int i3) throws IOException;

    c q(int i2) throws IOException;
}
