package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.b.a.e.d;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: Http2Writer.java */
/* loaded from: classes.dex */
final class j implements Closeable {
    private static final Logger b = Logger.getLogger(e.class.getName());
    final d.b a;
    private final com.bytedance.sdk.a.a.d c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1021d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.sdk.a.a.c f1022e;

    /* renamed from: f  reason: collision with root package name */
    private int f1023f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1024g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.bytedance.sdk.a.a.d dVar, boolean z) {
        this.c = dVar;
        this.f1021d = z;
        com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        this.f1022e = cVar;
        this.a = new d.b(cVar);
        this.f1023f = 16384;
    }

    public synchronized void a() throws IOException {
        if (!this.f1024g) {
            if (this.f1021d) {
                Logger logger = b;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(com.bytedance.sdk.a.b.a.c.a(">> CONNECTION %s", e.a.e()));
                }
                this.c.c(e.a.h());
                this.c.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public synchronized void b() throws IOException {
        if (!this.f1024g) {
            this.c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public int c() {
        return this.f1023f;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f1024g = true;
        this.c.close();
    }

    public synchronized void b(n nVar) throws IOException {
        if (!this.f1024g) {
            int i2 = 0;
            a(0, nVar.b() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (nVar.a(i2)) {
                    this.c.h(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                    this.c.g(nVar.b(i2));
                }
                i2++;
            }
            this.c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(n nVar) throws IOException {
        if (!this.f1024g) {
            this.f1023f = nVar.d(this.f1023f);
            if (nVar.c() != -1) {
                this.a.a(nVar.c());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    private void b(int i2, long j2) throws IOException {
        while (j2 > 0) {
            int min = (int) Math.min(this.f1023f, j2);
            long j3 = min;
            j2 -= j3;
            a(i2, min, (byte) 9, j2 == 0 ? (byte) 4 : (byte) 0);
            this.c.a_(this.f1022e, j3);
        }
    }

    public synchronized void a(int i2, int i3, List<c> list) throws IOException {
        if (!this.f1024g) {
            this.a.a(list);
            long b2 = this.f1022e.b();
            int min = (int) Math.min(this.f1023f - 4, b2);
            long j2 = min;
            int i4 = (b2 > j2 ? 1 : (b2 == j2 ? 0 : -1));
            a(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : (byte) 0);
            this.c.g(i3 & Integer.MAX_VALUE);
            this.c.a_(this.f1022e, j2);
            if (i4 > 0) {
                b(i2, b2 - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i2, int i3, List<c> list) throws IOException {
        if (!this.f1024g) {
            a(z, i2, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, b bVar) throws IOException {
        if (!this.f1024g) {
            if (bVar.f946g != -1) {
                a(i2, 4, (byte) 3, (byte) 0);
                this.c.g(bVar.f946g);
                this.c.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i2, com.bytedance.sdk.a.a.c cVar, int i3) throws IOException {
        if (!this.f1024g) {
            a(i2, z ? (byte) 1 : (byte) 0, cVar, i3);
        } else {
            throw new IOException("closed");
        }
    }

    void a(int i2, byte b2, com.bytedance.sdk.a.a.c cVar, int i3) throws IOException {
        a(i2, i3, (byte) 0, b2);
        if (i3 > 0) {
            this.c.a_(cVar, i3);
        }
    }

    public synchronized void a(boolean z, int i2, int i3) throws IOException {
        if (!this.f1024g) {
            a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.c.g(i2);
            this.c.g(i3);
            this.c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, b bVar, byte[] bArr) throws IOException {
        if (!this.f1024g) {
            if (bVar.f946g != -1) {
                a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.c.g(i2);
                this.c.g(bVar.f946g);
                if (bArr.length > 0) {
                    this.c.c(bArr);
                }
                this.c.flush();
            } else {
                throw e.a("errorCode.httpCode == -1", new Object[0]);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, long j2) throws IOException {
        if (this.f1024g) {
            throw new IOException("closed");
        }
        if (j2 != 0 && j2 <= 2147483647L) {
            a(i2, 4, (byte) 8, (byte) 0);
            this.c.g((int) j2);
            this.c.flush();
        } else {
            throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
        }
    }

    public void a(int i2, int i3, byte b2, byte b3) throws IOException {
        Logger logger = b;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.a(false, i2, i3, b2, b3));
        }
        int i4 = this.f1023f;
        if (i3 > i4) {
            throw e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
        }
        if ((Integer.MIN_VALUE & i2) != 0) {
            throw e.a("reserved bit set: %s", Integer.valueOf(i2));
        }
        a(this.c, i3);
        this.c.i(b2 & Draft_75.END_OF_FRAME);
        this.c.i(b3 & Draft_75.END_OF_FRAME);
        this.c.g(i2 & Integer.MAX_VALUE);
    }

    private static void a(com.bytedance.sdk.a.a.d dVar, int i2) throws IOException {
        dVar.i((i2 >>> 16) & 255);
        dVar.i((i2 >>> 8) & 255);
        dVar.i(i2 & 255);
    }

    void a(boolean z, int i2, List<c> list) throws IOException {
        if (!this.f1024g) {
            this.a.a(list);
            long b2 = this.f1022e.b();
            int min = (int) Math.min(this.f1023f, b2);
            long j2 = min;
            int i3 = (b2 > j2 ? 1 : (b2 == j2 ? 0 : -1));
            byte b3 = i3 == 0 ? (byte) 4 : (byte) 0;
            if (z) {
                b3 = (byte) (b3 | 1);
            }
            a(i2, min, (byte) 1, b3);
            this.c.a_(this.f1022e, j2);
            if (i3 > 0) {
                b(i2, b2 - j2);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
