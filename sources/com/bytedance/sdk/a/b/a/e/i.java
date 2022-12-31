package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* compiled from: Http2Stream.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: i  reason: collision with root package name */
    static final /* synthetic */ boolean f1006i = true;
    long b;
    final int c;

    /* renamed from: d  reason: collision with root package name */
    final g f1007d;

    /* renamed from: e  reason: collision with root package name */
    final a f1008e;

    /* renamed from: j  reason: collision with root package name */
    private final List<com.bytedance.sdk.a.b.a.e.c> f1012j;

    /* renamed from: k  reason: collision with root package name */
    private List<com.bytedance.sdk.a.b.a.e.c> f1013k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1014l;
    private final b m;
    long a = 0;

    /* renamed from: f  reason: collision with root package name */
    final c f1009f = new c();

    /* renamed from: g  reason: collision with root package name */
    final c f1010g = new c();

    /* renamed from: h  reason: collision with root package name */
    com.bytedance.sdk.a.b.a.e.b f1011h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* loaded from: classes.dex */
    public class c extends com.bytedance.sdk.a.a.a {
        c() {
        }

        @Override // com.bytedance.sdk.a.a.a
        protected void a_() {
            i.this.b(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        }

        @Override // com.bytedance.sdk.a.a.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void h() throws IOException {
            if (b()) {
                throw b((IOException) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i2, g gVar, boolean z, boolean z2, List<com.bytedance.sdk.a.b.a.e.c> list) {
        Objects.requireNonNull(gVar, "connection == null");
        Objects.requireNonNull(list, "requestHeaders == null");
        this.c = i2;
        this.f1007d = gVar;
        this.b = gVar.m.d();
        b bVar = new b(gVar.f983l.d());
        this.m = bVar;
        a aVar = new a();
        this.f1008e = aVar;
        bVar.b = z2;
        aVar.b = z;
        this.f1012j = list;
    }

    public int a() {
        return this.c;
    }

    public synchronized boolean b() {
        if (this.f1011h != null) {
            return false;
        }
        b bVar = this.m;
        if (bVar.b || bVar.a) {
            a aVar = this.f1008e;
            if (aVar.b || aVar.a) {
                if (this.f1014l) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean c() {
        return this.f1007d.b == ((this.c & 1) == 1);
    }

    public synchronized List<com.bytedance.sdk.a.b.a.e.c> d() throws IOException {
        List<com.bytedance.sdk.a.b.a.e.c> list;
        if (c()) {
            this.f1009f.a();
            while (this.f1013k == null && this.f1011h == null) {
                l();
            }
            this.f1009f.h();
            list = this.f1013k;
            if (list != null) {
                this.f1013k = null;
            } else {
                throw new o(this.f1011h);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    public t e() {
        return this.f1009f;
    }

    public t f() {
        return this.f1010g;
    }

    public s g() {
        return this.m;
    }

    public r h() {
        synchronized (this) {
            if (!this.f1014l && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f1008e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean b2;
        if (!f1006i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.m.b = true;
            b2 = b();
            notifyAll();
        }
        if (b2) {
            return;
        }
        this.f1007d.b(this.c);
    }

    void j() throws IOException {
        boolean z;
        boolean b2;
        if (!f1006i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            b bVar = this.m;
            if (!bVar.b && bVar.a) {
                a aVar = this.f1008e;
                if (aVar.b || aVar.a) {
                    z = true;
                    b2 = b();
                }
            }
            z = false;
            b2 = b();
        }
        if (z) {
            a(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (b2) {
        } else {
            this.f1007d.b(this.c);
        }
    }

    void k() throws IOException {
        a aVar = this.f1008e;
        if (!aVar.a) {
            if (!aVar.b) {
                if (this.f1011h != null) {
                    throw new o(this.f1011h);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (d(bVar)) {
            this.f1007d.b(this.c, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (this.f1011h == null) {
            this.f1011h = bVar;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<com.bytedance.sdk.a.b.a.e.c> list) {
        boolean z;
        if (!f1006i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            this.f1014l = true;
            if (this.f1013k == null) {
                this.f1013k = list;
                z = b();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f1013k);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f1013k = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f1007d.b(this.c);
    }

    public void b(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (d(bVar)) {
            this.f1007d.a(this.c, bVar);
        }
    }

    private boolean d(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (f1006i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f1011h != null) {
                    return false;
                }
                if (this.m.b && this.f1008e.b) {
                    return false;
                }
                this.f1011h = bVar;
                notifyAll();
                this.f1007d.b(this.c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* loaded from: classes.dex */
    public final class a implements r {
        static final /* synthetic */ boolean c = true;
        boolean a;
        boolean b;

        /* renamed from: e  reason: collision with root package name */
        private final com.bytedance.sdk.a.a.c f1016e = new com.bytedance.sdk.a.a.c();

        a() {
        }

        private void a(boolean z) throws IOException {
            i iVar;
            long min;
            i iVar2;
            synchronized (i.this) {
                i.this.f1010g.a();
                while (true) {
                    iVar = i.this;
                    if (iVar.b > 0 || this.b || this.a || iVar.f1011h != null) {
                        break;
                    }
                    iVar.l();
                }
                iVar.f1010g.h();
                i.this.k();
                min = Math.min(i.this.b, this.f1016e.b());
                iVar2 = i.this;
                iVar2.b -= min;
            }
            iVar2.f1010g.a();
            try {
                i iVar3 = i.this;
                iVar3.f1007d.a(iVar3.c, z && min == this.f1016e.b(), this.f1016e, min);
            } finally {
                i.this.f1010g.h();
            }
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.f1016e.a_(cVar, j2);
            while (this.f1016e.b() >= 16384) {
                a(false);
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (this.a) {
                    return;
                }
                if (!i.this.f1008e.b) {
                    if (this.f1016e.b() > 0) {
                        while (this.f1016e.b() > 0) {
                            a(true);
                        }
                    } else {
                        i iVar = i.this;
                        iVar.f1007d.a(iVar.c, true, (com.bytedance.sdk.a.a.c) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.a = true;
                }
                i.this.f1007d.b();
                i.this.j();
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public void flush() throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.k();
            }
            while (this.f1016e.b() > 0) {
                a(false);
                i.this.f1007d.b();
            }
        }

        @Override // com.bytedance.sdk.a.a.r
        public t a() {
            return i.this.f1010g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.a.a.e eVar, int i2) throws IOException {
        if (!f1006i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.m.a(eVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http2Stream.java */
    /* loaded from: classes.dex */
    public final class b implements s {
        static final /* synthetic */ boolean c = true;
        boolean a;
        boolean b;

        /* renamed from: e  reason: collision with root package name */
        private final com.bytedance.sdk.a.a.c f1018e = new com.bytedance.sdk.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        private final com.bytedance.sdk.a.a.c f1019f = new com.bytedance.sdk.a.a.c();

        /* renamed from: g  reason: collision with root package name */
        private final long f1020g;

        b(long j2) {
            this.f1020g = j2;
        }

        private void b() throws IOException {
            i.this.f1009f.a();
            while (this.f1019f.b() == 0 && !this.b && !this.a) {
                try {
                    i iVar = i.this;
                    if (iVar.f1011h != null) {
                        break;
                    }
                    iVar.l();
                } finally {
                    i.this.f1009f.h();
                }
            }
        }

        private void c() throws IOException {
            if (!this.a) {
                if (i.this.f1011h != null) {
                    throw new o(i.this.f1011h);
                }
                return;
            }
            throw new IOException("stream closed");
        }

        @Override // com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
            if (j2 >= 0) {
                synchronized (i.this) {
                    b();
                    c();
                    if (this.f1019f.b() == 0) {
                        return -1L;
                    }
                    com.bytedance.sdk.a.a.c cVar2 = this.f1019f;
                    long a = cVar2.a(cVar, Math.min(j2, cVar2.b()));
                    i iVar = i.this;
                    long j3 = iVar.a + a;
                    iVar.a = j3;
                    if (j3 >= iVar.f1007d.f983l.d() / 2) {
                        i iVar2 = i.this;
                        iVar2.f1007d.a(iVar2.c, iVar2.a);
                        i.this.a = 0L;
                    }
                    synchronized (i.this.f1007d) {
                        g gVar = i.this.f1007d;
                        long j4 = gVar.f981j + a;
                        gVar.f981j = j4;
                        if (j4 >= gVar.f983l.d() / 2) {
                            g gVar2 = i.this.f1007d;
                            gVar2.a(0, gVar2.f981j);
                            i.this.f1007d.f981j = 0L;
                        }
                    }
                    return a;
                }
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.a = true;
                this.f1019f.r();
                i.this.notifyAll();
            }
            i.this.j();
        }

        void a(com.bytedance.sdk.a.a.e eVar, long j2) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j2 > 0) {
                synchronized (i.this) {
                    z = this.b;
                    z2 = true;
                    z3 = this.f1019f.b() + j2 > this.f1020g;
                }
                if (z3) {
                    eVar.h(j2);
                    i.this.b(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.h(j2);
                    return;
                } else {
                    long a = eVar.a(this.f1018e, j2);
                    if (a != -1) {
                        j2 -= a;
                        synchronized (i.this) {
                            if (this.f1019f.b() != 0) {
                                z2 = false;
                            }
                            this.f1019f.a(this.f1018e);
                            if (z2) {
                                i.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.a.a.s
        public t a() {
            return i.this.f1009f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j2) {
        this.b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }
}
