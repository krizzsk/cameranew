package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.e.d;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http2Reader.java */
/* loaded from: classes.dex */
public final class h implements Closeable {
    static final Logger a = Logger.getLogger(e.class.getName());
    final d.a b;
    private final com.bytedance.sdk.a.a.e c;

    /* renamed from: d  reason: collision with root package name */
    private final a f1001d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1002e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(int i2, int i3, int i4, boolean z);

        void a(int i2, int i3, List<c> list) throws IOException;

        void a(int i2, long j2);

        void a(int i2, com.bytedance.sdk.a.b.a.e.b bVar);

        void a(int i2, com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.a.f fVar);

        void a(boolean z, int i2, int i3);

        void a(boolean z, int i2, int i3, List<c> list);

        void a(boolean z, int i2, com.bytedance.sdk.a.a.e eVar, int i3) throws IOException;

        void a(boolean z, n nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(com.bytedance.sdk.a.a.e eVar, boolean z) {
        this.c = eVar;
        this.f1002e = z;
        a aVar = new a(eVar);
        this.f1001d = aVar;
        this.b = new d.a(4096, aVar);
    }

    private void b(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        if (!((b2 & 32) != 0)) {
            short h2 = (b2 & 8) != 0 ? (short) (this.c.h() & Draft_75.END_OF_FRAME) : (short) 0;
            bVar.a(z, i3, this.c, a(i2, b2, h2));
            this.c.h(h2);
            return;
        }
        throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }

    private void c(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 5) {
            throw e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
        }
        if (i3 != 0) {
            a(bVar, i3);
            return;
        }
        throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
    }

    private void d(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            throw e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
        }
        if (i3 != 0) {
            int j2 = this.c.j();
            com.bytedance.sdk.a.b.a.e.b a2 = com.bytedance.sdk.a.b.a.e.b.a(j2);
            if (a2 == null) {
                throw e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(j2));
            }
            bVar.a(i3, a2);
            return;
        }
        throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
    }

    private void e(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i2 == 0) {
                bVar.a();
                return;
            }
            throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i2 % 6 != 0) {
            throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
        } else {
            n nVar = new n();
            for (int i4 = 0; i4 < i2; i4 += 6) {
                short i5 = this.c.i();
                int j2 = this.c.j();
                if (i5 != 2) {
                    if (i5 == 3) {
                        i5 = 4;
                    } else if (i5 == 4) {
                        i5 = 7;
                        if (j2 < 0) {
                            throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    } else if (i5 == 5 && (j2 < 16384 || j2 > 16777215)) {
                        throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(j2));
                    }
                } else if (j2 != 0 && j2 != 1) {
                    throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                nVar.a(i5, j2);
            }
            bVar.a(false, nVar);
        }
    }

    private void f(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            short h2 = (b2 & 8) != 0 ? (short) (this.c.h() & Draft_75.END_OF_FRAME) : (short) 0;
            bVar.a(i3, this.c.j() & Integer.MAX_VALUE, a(a(i2 - 4, b2, h2), h2, b2, i3));
            return;
        }
        throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void g(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 8) {
            throw e.b("TYPE_PING length != 8: %s", Integer.valueOf(i2));
        }
        if (i3 == 0) {
            bVar.a((b2 & 1) != 0, this.c.j(), this.c.j());
            return;
        }
        throw e.b("TYPE_PING streamId != 0", new Object[0]);
    }

    private void h(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 < 8) {
            throw e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
        }
        if (i3 == 0) {
            int j2 = this.c.j();
            int j3 = this.c.j();
            int i4 = i2 - 8;
            com.bytedance.sdk.a.b.a.e.b a2 = com.bytedance.sdk.a.b.a.e.b.a(j3);
            if (a2 == null) {
                throw e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(j3));
            }
            com.bytedance.sdk.a.a.f fVar = com.bytedance.sdk.a.a.f.b;
            if (i4 > 0) {
                fVar = this.c.c(i4);
            }
            bVar.a(j2, a2, fVar);
            return;
        }
        throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
    }

    private void i(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
        }
        long j2 = this.c.j() & 2147483647L;
        if (j2 == 0) {
            throw e.b("windowSizeIncrement was 0", Long.valueOf(j2));
        }
        bVar.a(i3, j2);
    }

    public void a(b bVar) throws IOException {
        if (this.f1002e) {
            if (!a(true, bVar)) {
                throw e.b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.bytedance.sdk.a.a.e eVar = this.c;
        com.bytedance.sdk.a.a.f fVar = e.a;
        com.bytedance.sdk.a.a.f c = eVar.c(fVar.g());
        Logger logger = a;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.bytedance.sdk.a.b.a.c.a("<< CONNECTION %s", c.e()));
        }
        if (!fVar.equals(c)) {
            throw e.b("Expected a connection header but was %s", c.a());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* loaded from: classes.dex */
    public static final class a implements s {
        int a;
        byte b;
        int c;

        /* renamed from: d  reason: collision with root package name */
        int f1003d;

        /* renamed from: e  reason: collision with root package name */
        short f1004e;

        /* renamed from: f  reason: collision with root package name */
        private final com.bytedance.sdk.a.a.e f1005f;

        a(com.bytedance.sdk.a.a.e eVar) {
            this.f1005f = eVar;
        }

        private void b() throws IOException {
            int i2 = this.c;
            int a = h.a(this.f1005f);
            this.f1003d = a;
            this.a = a;
            byte h2 = (byte) (this.f1005f.h() & Draft_75.END_OF_FRAME);
            this.b = (byte) (this.f1005f.h() & Draft_75.END_OF_FRAME);
            Logger logger = h.a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, this.c, this.a, h2, this.b));
            }
            int j2 = this.f1005f.j() & Integer.MAX_VALUE;
            this.c = j2;
            if (h2 != 9) {
                throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(h2));
            }
            if (j2 != i2) {
                throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
            while (true) {
                int i2 = this.f1003d;
                if (i2 == 0) {
                    this.f1005f.h(this.f1004e);
                    this.f1004e = (short) 0;
                    if ((this.b & 4) != 0) {
                        return -1L;
                    }
                    b();
                } else {
                    long a = this.f1005f.a(cVar, Math.min(j2, i2));
                    if (a == -1) {
                        return -1L;
                    }
                    this.f1003d = (int) (this.f1003d - a);
                    return a;
                }
            }
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // com.bytedance.sdk.a.a.s
        public t a() {
            return this.f1005f.a();
        }
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.c.a(9L);
            int a2 = a(this.c);
            if (a2 < 0 || a2 > 16384) {
                throw e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
            }
            byte h2 = (byte) (this.c.h() & Draft_75.END_OF_FRAME);
            if (!z || h2 == 4) {
                byte h3 = (byte) (this.c.h() & Draft_75.END_OF_FRAME);
                int j2 = this.c.j() & Integer.MAX_VALUE;
                Logger logger = a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(e.a(true, j2, a2, h2, h3));
                }
                switch (h2) {
                    case 0:
                        b(bVar, a2, h3, j2);
                        break;
                    case 1:
                        a(bVar, a2, h3, j2);
                        break;
                    case 2:
                        c(bVar, a2, h3, j2);
                        break;
                    case 3:
                        d(bVar, a2, h3, j2);
                        break;
                    case 4:
                        e(bVar, a2, h3, j2);
                        break;
                    case 5:
                        f(bVar, a2, h3, j2);
                        break;
                    case 6:
                        g(bVar, a2, h3, j2);
                        break;
                    case 7:
                        h(bVar, a2, h3, j2);
                        break;
                    case 8:
                        i(bVar, a2, h3, j2);
                        break;
                    default:
                        this.c.h(a2);
                        break;
                }
                return true;
            }
            throw e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(h2));
        } catch (IOException unused) {
            return false;
        }
    }

    private void a(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            boolean z = (b2 & 1) != 0;
            short h2 = (b2 & 8) != 0 ? (short) (this.c.h() & Draft_75.END_OF_FRAME) : (short) 0;
            if ((b2 & 32) != 0) {
                a(bVar, i3);
                i2 -= 5;
            }
            bVar.a(z, i3, -1, a(a(i2, b2, h2), h2, b2, i3));
            return;
        }
        throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private List<c> a(int i2, short s, byte b2, int i3) throws IOException {
        a aVar = this.f1001d;
        aVar.f1003d = i2;
        aVar.a = i2;
        aVar.f1004e = s;
        aVar.b = b2;
        aVar.c = i3;
        this.b.a();
        return this.b.b();
    }

    private void a(b bVar, int i2) throws IOException {
        int j2 = this.c.j();
        bVar.a(i2, j2 & Integer.MAX_VALUE, (this.c.h() & Draft_75.END_OF_FRAME) + 1, (Integer.MIN_VALUE & j2) != 0);
    }

    static int a(com.bytedance.sdk.a.a.e eVar) throws IOException {
        return (eVar.h() & Draft_75.END_OF_FRAME) | ((eVar.h() & Draft_75.END_OF_FRAME) << 16) | ((eVar.h() & Draft_75.END_OF_FRAME) << 8);
    }

    static int a(int i2, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
    }
}
