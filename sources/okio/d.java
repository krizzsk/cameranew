package okio;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* compiled from: BufferedSource.java */
/* loaded from: classes3.dex */
public interface d extends j, ReadableByteChannel {
    b F();

    long H(ByteString byteString) throws IOException;

    int P(f fVar) throws IOException;

    long g(ByteString byteString) throws IOException;

    boolean request(long j2) throws IOException;
}
