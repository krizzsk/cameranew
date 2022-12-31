package com.tapjoy.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
/* loaded from: classes3.dex */
public final class iv {
    static final Logger a = Logger.getLogger(iv.class.getName());

    private iv() {
    }

    public static it a(jc jcVar) {
        if (jcVar != null) {
            return new ix(jcVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static is a(jb jbVar) {
        if (jbVar != null) {
            return new iw(jbVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static jb a(final OutputStream outputStream) {
        final jd jdVar = new jd();
        if (outputStream != null) {
            return new jb() { // from class: com.tapjoy.internal.iv.1
                @Override // com.tapjoy.internal.jb
                public final void a(ir irVar, long j2) {
                    je.a(irVar.b, 0L, j2);
                    while (j2 > 0) {
                        jd.this.a();
                        iy iyVar = irVar.a;
                        int min = (int) Math.min(j2, iyVar.c - iyVar.b);
                        outputStream.write(iyVar.a, iyVar.b, min);
                        int i2 = iyVar.b + min;
                        iyVar.b = i2;
                        long j3 = min;
                        j2 -= j3;
                        irVar.b -= j3;
                        if (i2 == iyVar.c) {
                            irVar.a = iyVar.a();
                            iz.a(iyVar);
                        }
                    }
                }

                @Override // com.tapjoy.internal.jb, java.io.Closeable, java.lang.AutoCloseable, com.tapjoy.internal.jc
                public final void close() {
                    outputStream.close();
                }

                @Override // com.tapjoy.internal.jb, java.io.Flushable
                public final void flush() {
                    outputStream.flush();
                }

                public final String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("out == null");
    }

    public static jc a(final InputStream inputStream) {
        final jd jdVar = new jd();
        if (inputStream != null) {
            return new jc() { // from class: com.tapjoy.internal.iv.2
                @Override // com.tapjoy.internal.jc
                public final long b(ir irVar, long j2) {
                    int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                    if (i2 < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j2);
                    } else if (i2 == 0) {
                        return 0L;
                    } else {
                        try {
                            jd.this.a();
                            iy c = irVar.c(1);
                            int read = inputStream.read(c.a, c.c, (int) Math.min(j2, 8192 - c.c));
                            if (read == -1) {
                                return -1L;
                            }
                            c.c += read;
                            long j3 = read;
                            irVar.b += j3;
                            return j3;
                        } catch (AssertionError e2) {
                            if (iv.a(e2)) {
                                throw new IOException(e2);
                            }
                            throw e2;
                        }
                    }
                }

                @Override // com.tapjoy.internal.jc, java.lang.AutoCloseable
                public final void close() {
                    inputStream.close();
                }

                public final String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("in == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
