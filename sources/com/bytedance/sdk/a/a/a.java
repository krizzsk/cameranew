package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* compiled from: AsyncTimeout.java */
/* loaded from: classes.dex */
public class a extends t {
    static a a;
    private static final long b;

    /* renamed from: d  reason: collision with root package name */
    private static final long f837d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f838e;

    /* renamed from: f  reason: collision with root package name */
    private a f839f;

    /* renamed from: g  reason: collision with root package name */
    private long f840g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTimeout.java */
    /* renamed from: com.bytedance.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0036a extends Thread {
        C0036a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.a_();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.bytedance.sdk.a.a.a> r0 = com.bytedance.sdk.a.a.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                com.bytedance.sdk.a.a.a r1 = com.bytedance.sdk.a.a.a.d()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                com.bytedance.sdk.a.a.a r2 = com.bytedance.sdk.a.a.a.a     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                com.bytedance.sdk.a.a.a.a = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.a_()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.a.a.C0036a.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        b = millis;
        f837d = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    static a d() throws InterruptedException {
        a aVar = a.f839f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(b);
            if (a.f839f != null || System.nanoTime() - nanoTime < f837d) {
                return null;
            }
            return a;
        }
        long b2 = aVar.b(System.nanoTime());
        if (b2 > 0) {
            long j2 = b2 / 1000000;
            a.class.wait(j2, (int) (b2 - (1000000 * j2)));
            return null;
        }
        a.f839f = aVar.f839f;
        aVar.f839f = null;
        return aVar;
    }

    public final void a() {
        if (!this.f838e) {
            long b_ = b_();
            boolean c = c();
            if (b_ != 0 || c) {
                this.f838e = true;
                a(this, b_, c);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    protected void a_() {
    }

    public final boolean b() {
        if (this.f838e) {
            this.f838e = false;
            return a(this);
        }
        return false;
    }

    private long b(long j2) {
        return this.f840g - j2;
    }

    protected IOException b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static synchronized void a(a aVar, long j2, boolean z) {
        synchronized (a.class) {
            if (a == null) {
                a = new a();
                new C0036a().start();
            }
            long nanoTime = System.nanoTime();
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 != 0 && z) {
                aVar.f840g = Math.min(j2, aVar.c_() - nanoTime) + nanoTime;
            } else if (i2 != 0) {
                aVar.f840g = j2 + nanoTime;
            } else if (z) {
                aVar.f840g = aVar.c_();
            } else {
                throw new AssertionError();
            }
            long b2 = aVar.b(nanoTime);
            a aVar2 = a;
            while (true) {
                a aVar3 = aVar2.f839f;
                if (aVar3 == null || b2 < aVar3.b(nanoTime)) {
                    break;
                }
                aVar2 = aVar2.f839f;
            }
            aVar.f839f = aVar2.f839f;
            aVar2.f839f = aVar;
            if (aVar2 == a) {
                a.class.notify();
            }
        }
    }

    private static synchronized boolean a(a aVar) {
        synchronized (a.class) {
            a aVar2 = a;
            while (aVar2 != null) {
                a aVar3 = aVar2.f839f;
                if (aVar3 == aVar) {
                    aVar2.f839f = aVar.f839f;
                    aVar.f839f = null;
                    return false;
                }
                aVar2 = aVar3;
            }
            return true;
        }
    }

    public final r a(final r rVar) {
        return new r() { // from class: com.bytedance.sdk.a.a.a.1
            @Override // com.bytedance.sdk.a.a.r
            public t a() {
                return a.this;
            }

            @Override // com.bytedance.sdk.a.a.r
            public void a_(c cVar, long j2) throws IOException {
                u.a(cVar.b, 0L, j2);
                while (true) {
                    long j3 = 0;
                    if (j2 <= 0) {
                        return;
                    }
                    o oVar = cVar.a;
                    while (true) {
                        if (j3 >= 65536) {
                            break;
                        }
                        j3 += oVar.c - oVar.b;
                        if (j3 >= j2) {
                            j3 = j2;
                            break;
                        }
                        oVar = oVar.f848f;
                    }
                    a.this.a();
                    try {
                        try {
                            rVar.a_(cVar, j3);
                            j2 -= j3;
                            a.this.a(true);
                        } catch (IOException e2) {
                            throw a.this.a(e2);
                        }
                    } catch (Throwable th) {
                        a.this.a(false);
                        throw th;
                    }
                }
            }

            @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.a();
                try {
                    try {
                        rVar.close();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.a(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
            public void flush() throws IOException {
                a.this.a();
                try {
                    try {
                        rVar.flush();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.a(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + rVar + ")";
            }
        };
    }

    public final s a(final s sVar) {
        return new s() { // from class: com.bytedance.sdk.a.a.a.2
            @Override // com.bytedance.sdk.a.a.s
            public long a(c cVar, long j2) throws IOException {
                a.this.a();
                try {
                    try {
                        long a2 = sVar.a(cVar, j2);
                        a.this.a(true);
                        return a2;
                    } catch (IOException e2) {
                        throw a.this.a(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.a();
                try {
                    try {
                        sVar.close();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.a(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + sVar + ")";
            }

            @Override // com.bytedance.sdk.a.a.s
            public t a() {
                return a.this;
            }
        };
    }

    final void a(boolean z) throws IOException {
        if (b() && z) {
            throw b((IOException) null);
        }
    }

    final IOException a(IOException iOException) throws IOException {
        return !b() ? iOException : b(iOException);
    }
}
