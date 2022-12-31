package okio;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
/* compiled from: Okio.java */
/* loaded from: classes3.dex */
public final class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Okio.java */
    /* loaded from: classes3.dex */
    public final class a implements j {
        final /* synthetic */ k a;
        final /* synthetic */ InputStream b;

        a(k kVar, InputStream inputStream) {
            this.a = kVar;
            this.b = inputStream;
        }

        @Override // okio.j, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            this.b.close();
        }

        @Override // okio.j
        public long r(b bVar, long j2) throws IOException {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (i2 == 0) {
                return 0L;
            } else {
                try {
                    this.a.a();
                    h a0 = bVar.a0(1);
                    int read = this.b.read(a0.a, a0.c, (int) Math.min(j2, 8192 - a0.c));
                    if (read == -1) {
                        return -1L;
                    }
                    a0.c += read;
                    long j3 = read;
                    bVar.b += j3;
                    return j3;
                } catch (AssertionError e2) {
                    if (e.b(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        public String toString() {
            return "source(" + this.b + ")";
        }
    }

    static {
        Logger.getLogger(e.class.getName());
    }

    private e() {
    }

    public static d a(j jVar) {
        return new g(jVar);
    }

    static boolean b(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static j c(InputStream inputStream) {
        return d(inputStream, new k());
    }

    private static j d(InputStream inputStream, k kVar) {
        if (inputStream != null) {
            if (kVar != null) {
                return new a(kVar, inputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }
}
