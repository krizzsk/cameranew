package com.bytedance.sdk.a.b.a.d;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.a.a.i;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.a.c.k;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import us.pinguo.common.network.HttpRequest;
/* compiled from: Http1Codec.java */
/* loaded from: classes.dex */
public final class a implements com.bytedance.sdk.a.b.a.c.c {
    final v a;
    final g b;
    final com.bytedance.sdk.a.a.e c;

    /* renamed from: d  reason: collision with root package name */
    final com.bytedance.sdk.a.a.d f929d;

    /* renamed from: e  reason: collision with root package name */
    int f930e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f931f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* renamed from: com.bytedance.sdk.a.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public abstract class AbstractC0037a implements s {
        protected final i a;
        protected boolean b;
        protected long c;

        private AbstractC0037a() {
            this.a = new i(a.this.c.a());
            this.c = 0L;
        }

        @Override // com.bytedance.sdk.a.a.s
        public t a() {
            return this.a;
        }

        @Override // com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
            try {
                long a = a.this.c.a(cVar, j2);
                if (a > 0) {
                    this.c += a;
                }
                return a;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        protected final void a(boolean z, IOException iOException) throws IOException {
            a aVar = a.this;
            int i2 = aVar.f930e;
            if (i2 == 6) {
                return;
            }
            if (i2 == 5) {
                aVar.a(this.a);
                a aVar2 = a.this;
                aVar2.f930e = 6;
                g gVar = aVar2.b;
                if (gVar != null) {
                    gVar.a(!z, aVar2, this.c, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + a.this.f930e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes.dex */
    public final class b implements r {
        private final i b;
        private boolean c;

        b() {
            this.b = new i(a.this.f929d.a());
        }

        @Override // com.bytedance.sdk.a.a.r
        public t a() {
            return this.b;
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            if (j2 == 0) {
                return;
            }
            a.this.f929d.k(j2);
            a.this.f929d.b("\r\n");
            a.this.f929d.a_(cVar, j2);
            a.this.f929d.b("\r\n");
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.c) {
                return;
            }
            this.c = true;
            a.this.f929d.b("0\r\n\r\n");
            a.this.a(this.b);
            a.this.f930e = 3;
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.c) {
                return;
            }
            a.this.f929d.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes.dex */
    public class c extends AbstractC0037a {

        /* renamed from: f  reason: collision with root package name */
        private final com.bytedance.sdk.a.b.s f934f;

        /* renamed from: g  reason: collision with root package name */
        private long f935g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f936h;

        c(com.bytedance.sdk.a.b.s sVar) {
            super();
            this.f935g = -1L;
            this.f936h = true;
            this.f934f = sVar;
        }

        private void b() throws IOException {
            if (this.f935g != -1) {
                a.this.c.p();
            }
            try {
                this.f935g = a.this.c.m();
                String trim = a.this.c.p().trim();
                if (this.f935g >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.f935g == 0) {
                        this.f936h = false;
                        com.bytedance.sdk.a.b.a.c.e.a(a.this.a.f(), this.f934f, a.this.c());
                        a(true, (IOException) null);
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f935g + trim + "\"");
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0037a, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
            if (j2 >= 0) {
                if (!this.b) {
                    if (this.f936h) {
                        long j3 = this.f935g;
                        if (j3 == 0 || j3 == -1) {
                            b();
                            if (!this.f936h) {
                                return -1L;
                            }
                        }
                        long a = super.a(cVar, Math.min(j2, this.f935g));
                        if (a != -1) {
                            this.f935g -= a;
                            return a;
                        }
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        a(false, (IOException) protocolException);
                        throw protocolException;
                    }
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.f936h && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes.dex */
    public final class d implements r {
        private final i b;
        private boolean c;

        /* renamed from: d  reason: collision with root package name */
        private long f937d;

        d(long j2) {
            this.b = new i(a.this.f929d.a());
            this.f937d = j2;
        }

        @Override // com.bytedance.sdk.a.a.r
        public t a() {
            return this.b;
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
            if (!this.c) {
                com.bytedance.sdk.a.b.a.c.a(cVar.b(), 0L, j2);
                if (j2 <= this.f937d) {
                    a.this.f929d.a_(cVar, j2);
                    this.f937d -= j2;
                    return;
                }
                throw new ProtocolException("expected " + this.f937d + " bytes but received " + j2);
            }
            throw new IllegalStateException("closed");
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.c) {
                return;
            }
            this.c = true;
            if (this.f937d <= 0) {
                a.this.a(this.b);
                a.this.f930e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public void flush() throws IOException {
            if (this.c) {
                return;
            }
            a.this.f929d.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes.dex */
    public class e extends AbstractC0037a {

        /* renamed from: f  reason: collision with root package name */
        private long f939f;

        e(long j2) throws IOException {
            super();
            this.f939f = j2;
            if (j2 == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0037a, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
            if (j2 >= 0) {
                if (!this.b) {
                    long j3 = this.f939f;
                    if (j3 == 0) {
                        return -1L;
                    }
                    long a = super.a(cVar, Math.min(j3, j2));
                    if (a != -1) {
                        long j4 = this.f939f - a;
                        this.f939f = j4;
                        if (j4 == 0) {
                            a(true, (IOException) null);
                        }
                        return a;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, (IOException) protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.f939f != 0 && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: classes.dex */
    public class f extends AbstractC0037a {

        /* renamed from: f  reason: collision with root package name */
        private boolean f941f;

        f() {
            super();
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0037a, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
            if (j2 >= 0) {
                if (!this.b) {
                    if (this.f941f) {
                        return -1L;
                    }
                    long a = super.a(cVar, j2);
                    if (a == -1) {
                        this.f941f = true;
                        a(true, (IOException) null);
                        return -1L;
                    }
                    return a;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (!this.f941f) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }

    public a(v vVar, g gVar, com.bytedance.sdk.a.a.e eVar, com.bytedance.sdk.a.a.d dVar) {
        this.a = vVar;
        this.b = gVar;
        this.c = eVar;
        this.f929d = dVar;
    }

    private String f() throws IOException {
        String e2 = this.c.e(this.f931f);
        this.f931f -= e2.length();
        return e2;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(y yVar, long j2) {
        if ("chunked".equalsIgnoreCase(yVar.a("Transfer-Encoding"))) {
            return d();
        }
        if (j2 != -1) {
            return a(j2);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.f929d.flush();
    }

    public com.bytedance.sdk.a.b.r c() throws IOException {
        r.a aVar = new r.a();
        while (true) {
            String f2 = f();
            if (f2.length() != 0) {
                com.bytedance.sdk.a.b.a.a.a.a(aVar, f2);
            } else {
                return aVar.a();
            }
        }
    }

    public com.bytedance.sdk.a.a.r d() {
        if (this.f930e == 1) {
            this.f930e = 2;
            return new b();
        }
        throw new IllegalStateException("state: " + this.f930e);
    }

    public s e() throws IOException {
        if (this.f930e == 4) {
            g gVar = this.b;
            if (gVar != null) {
                this.f930e = 5;
                gVar.d();
                return new f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f930e);
    }

    public s b(long j2) throws IOException {
        if (this.f930e == 4) {
            this.f930e = 5;
            return new e(j2);
        }
        throw new IllegalStateException("state: " + this.f930e);
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a(y yVar) throws IOException {
        a(yVar.c(), com.bytedance.sdk.a.b.a.c.i.a(yVar, this.b.b().a().b().type()));
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public ab a(aa aaVar) throws IOException {
        g gVar = this.b;
        gVar.c.f(gVar.b);
        String a = aaVar.a(HttpRequest.HEADER_CONTENT_TYPE);
        if (!com.bytedance.sdk.a.b.a.c.e.b(aaVar)) {
            return new h(a, 0L, l.a(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(aaVar.a("Transfer-Encoding"))) {
            return new h(a, -1L, l.a(a(aaVar.a().a())));
        }
        long a2 = com.bytedance.sdk.a.b.a.c.e.a(aaVar);
        if (a2 != -1) {
            return new h(a, a2, l.a(b(a2)));
        }
        return new h(a, -1L, l.a(e()));
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.f929d.flush();
    }

    public void a(com.bytedance.sdk.a.b.r rVar, String str) throws IOException {
        if (this.f930e == 0) {
            this.f929d.b(str).b("\r\n");
            int a = rVar.a();
            for (int i2 = 0; i2 < a; i2++) {
                this.f929d.b(rVar.a(i2)).b(": ").b(rVar.b(i2)).b("\r\n");
            }
            this.f929d.b("\r\n");
            this.f930e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f930e);
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public aa.a a(boolean z) throws IOException {
        int i2 = this.f930e;
        if (i2 != 1 && i2 != 3) {
            throw new IllegalStateException("state: " + this.f930e);
        }
        try {
            k a = k.a(f());
            aa.a a2 = new aa.a().a(a.a).a(a.b).a(a.c).a(c());
            if (z && a.b == 100) {
                return null;
            }
            this.f930e = 4;
            return a2;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public com.bytedance.sdk.a.a.r a(long j2) {
        if (this.f930e == 1) {
            this.f930e = 2;
            return new d(j2);
        }
        throw new IllegalStateException("state: " + this.f930e);
    }

    public s a(com.bytedance.sdk.a.b.s sVar) throws IOException {
        if (this.f930e == 4) {
            this.f930e = 5;
            return new c(sVar);
        }
        throw new IllegalStateException("state: " + this.f930e);
    }

    void a(i iVar) {
        t a = iVar.a();
        iVar.a(t.c);
        a.f();
        a.e();
    }
}
