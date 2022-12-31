package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: Okio.java */
/* loaded from: classes.dex */
public final class l {
    static final Logger a = Logger.getLogger(l.class.getName());

    private l() {
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    public static s b(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                a c = c(socket);
                return c.a(a(socket.getInputStream(), c));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static a c(final Socket socket) {
        return new a() { // from class: com.bytedance.sdk.a.a.l.3
            @Override // com.bytedance.sdk.a.a.a
            protected void a_() {
                try {
                    socket.close();
                } catch (AssertionError e2) {
                    if (l.a(e2)) {
                        Logger logger = l.a;
                        Level level = Level.WARNING;
                        logger.log(level, "Failed to close timed out socket " + socket, (Throwable) e2);
                        return;
                    }
                    throw e2;
                } catch (Exception e3) {
                    Logger logger2 = l.a;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Failed to close timed out socket " + socket, (Throwable) e3);
                }
            }

            @Override // com.bytedance.sdk.a.a.a
            protected IOException b(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }
        };
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    private static r a(final OutputStream outputStream, final t tVar) {
        if (outputStream != null) {
            if (tVar != null) {
                return new r() { // from class: com.bytedance.sdk.a.a.l.1
                    @Override // com.bytedance.sdk.a.a.r
                    public t a() {
                        return t.this;
                    }

                    @Override // com.bytedance.sdk.a.a.r
                    public void a_(c cVar, long j2) throws IOException {
                        u.a(cVar.b, 0L, j2);
                        while (j2 > 0) {
                            t.this.g();
                            o oVar = cVar.a;
                            int min = (int) Math.min(j2, oVar.c - oVar.b);
                            outputStream.write(oVar.a, oVar.b, min);
                            int i2 = oVar.b + min;
                            oVar.b = i2;
                            long j3 = min;
                            j2 -= j3;
                            cVar.b -= j3;
                            if (i2 == oVar.c) {
                                cVar.a = oVar.b();
                                p.a(oVar);
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        outputStream.close();
                    }

                    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
                    public void flush() throws IOException {
                        outputStream.flush();
                    }

                    public String toString() {
                        return "sink(" + outputStream + ")";
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static r a(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                a c = c(socket);
                return c.a(a(socket.getOutputStream(), c));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(final InputStream inputStream, final t tVar) {
        if (inputStream != null) {
            if (tVar != null) {
                return new s() { // from class: com.bytedance.sdk.a.a.l.2
                    @Override // com.bytedance.sdk.a.a.s
                    public long a(c cVar, long j2) throws IOException {
                        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                        if (i2 < 0) {
                            throw new IllegalArgumentException("byteCount < 0: " + j2);
                        } else if (i2 == 0) {
                            return 0L;
                        } else {
                            try {
                                t.this.g();
                                o e2 = cVar.e(1);
                                int read = inputStream.read(e2.a, e2.c, (int) Math.min(j2, 8192 - e2.c));
                                if (read == -1) {
                                    return -1L;
                                }
                                e2.c += read;
                                long j3 = read;
                                cVar.b += j3;
                                return j3;
                            } catch (AssertionError e3) {
                                if (l.a(e3)) {
                                    throw new IOException(e3);
                                }
                                throw e3;
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        inputStream.close();
                    }

                    public String toString() {
                        return "source(" + inputStream + ")";
                    }

                    @Override // com.bytedance.sdk.a.a.s
                    public t a() {
                        return t.this;
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
