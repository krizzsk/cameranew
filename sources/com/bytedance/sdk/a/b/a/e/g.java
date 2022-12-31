package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.b.a.e.h;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: Http2Connection.java */
/* loaded from: classes.dex */
public final class g implements Closeable {
    final boolean b;
    final b c;

    /* renamed from: e  reason: collision with root package name */
    final String f976e;

    /* renamed from: f  reason: collision with root package name */
    int f977f;

    /* renamed from: g  reason: collision with root package name */
    int f978g;

    /* renamed from: h  reason: collision with root package name */
    boolean f979h;

    /* renamed from: i  reason: collision with root package name */
    final m f980i;

    /* renamed from: k  reason: collision with root package name */
    long f982k;
    final n m;
    boolean n;
    final Socket o;
    final j p;
    final c q;
    final Set<Integer> r;
    private final ExecutorService t;
    private Map<Integer, l> u;
    private int v;
    static final /* synthetic */ boolean s = true;
    static final ExecutorService a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.a("OkHttp Http2Connection", true));

    /* renamed from: d  reason: collision with root package name */
    final Map<Integer, i> f975d = new LinkedHashMap();

    /* renamed from: j  reason: collision with root package name */
    long f981j = 0;

    /* renamed from: l  reason: collision with root package name */
    n f983l = new n();

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public static abstract class b {

        /* renamed from: f  reason: collision with root package name */
        public static final b f1000f = new b() { // from class: com.bytedance.sdk.a.b.a.e.g.b.1
            @Override // com.bytedance.sdk.a.b.a.e.g.b
            public void a(i iVar) throws IOException {
                iVar.a(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
            }
        };

        public void a(g gVar) {
        }

        public abstract void a(i iVar) throws IOException;
    }

    g(a aVar) {
        n nVar = new n();
        this.m = nVar;
        this.n = false;
        this.r = new LinkedHashSet();
        this.f980i = aVar.f998f;
        boolean z = aVar.f999g;
        this.b = z;
        this.c = aVar.f997e;
        int i2 = z ? 1 : 2;
        this.f978g = i2;
        if (z) {
            this.f978g = i2 + 2;
        }
        this.v = z ? 1 : 2;
        if (z) {
            this.f983l.a(7, 16777216);
        }
        String str = aVar.b;
        this.f976e = str;
        this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.a.b.a.c.a(com.bytedance.sdk.a.b.a.c.a("OkHttp %s Push Observer", str), true));
        nVar.a(7, 65535);
        nVar.a(5, 16384);
        this.f982k = nVar.d();
        this.o = aVar.a;
        this.p = new j(aVar.f996d, z);
        this.q = new c(new h(aVar.c, z));
    }

    synchronized i a(int i2) {
        return this.f975d.get(Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized i b(int i2) {
        i remove;
        remove = this.f975d.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    synchronized l c(int i2) {
        Map<Integer, l> map;
        map = this.u;
        return map != null ? map.remove(Integer.valueOf(i2)) : null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(com.bytedance.sdk.a.b.a.e.b.NO_ERROR, com.bytedance.sdk.a.b.a.e.b.CANCEL);
    }

    public synchronized boolean d() {
        return this.f979h;
    }

    boolean d(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public synchronized int a() {
        return this.m.c(Integer.MAX_VALUE);
    }

    public void c() throws IOException {
        a(true);
    }

    public i a(List<com.bytedance.sdk.a.b.a.e.c> list, boolean z) throws IOException {
        return b(0, list, z);
    }

    void c(final int i2, final com.bytedance.sdk.a.b.a.e.b bVar) {
        this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Reset[%s]", new Object[]{this.f976e, Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.a.b.a.e.g.7
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                g.this.f980i.a(i2, bVar);
                synchronized (g.this) {
                    g.this.r.remove(Integer.valueOf(i2));
                }
            }
        });
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public static class a {
        Socket a;
        String b;
        com.bytedance.sdk.a.a.e c;

        /* renamed from: d  reason: collision with root package name */
        com.bytedance.sdk.a.a.d f996d;

        /* renamed from: e  reason: collision with root package name */
        b f997e = b.f1000f;

        /* renamed from: f  reason: collision with root package name */
        m f998f = m.a;

        /* renamed from: g  reason: collision with root package name */
        boolean f999g;

        public a(boolean z) {
            this.f999g = z;
        }

        public a a(Socket socket, String str, com.bytedance.sdk.a.a.e eVar, com.bytedance.sdk.a.a.d dVar) {
            this.a = socket;
            this.b = str;
            this.c = eVar;
            this.f996d = dVar;
            return this;
        }

        public a a(b bVar) {
            this.f997e = bVar;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[Catch: all -> 0x0067, TryCatch #1 {, blocks: (B:4:0x0006, B:21:0x0041, B:25:0x0050, B:22:0x0047, B:24:0x004b, B:29:0x0059, B:30:0x0060, B:5:0x0007, B:7:0x000b, B:9:0x001d, B:11:0x0025, B:16:0x002f, B:18:0x0035, B:19:0x003e, B:31:0x0061, B:32:0x0066), top: B:39:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bytedance.sdk.a.b.a.e.i b(int r11, java.util.List<com.bytedance.sdk.a.b.a.e.c> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            com.bytedance.sdk.a.b.a.e.j r7 = r10.p
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L6a
            boolean r0 = r10.f979h     // Catch: java.lang.Throwable -> L67
            if (r0 != 0) goto L61
            int r8 = r10.f978g     // Catch: java.lang.Throwable -> L67
            int r0 = r8 + 2
            r10.f978g = r0     // Catch: java.lang.Throwable -> L67
            com.bytedance.sdk.a.b.a.e.i r9 = new com.bytedance.sdk.a.b.a.e.i     // Catch: java.lang.Throwable -> L67
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L67
            if (r13 == 0) goto L2e
            long r0 = r10.f982k     // Catch: java.lang.Throwable -> L67
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L2e
            long r0 = r9.b     // Catch: java.lang.Throwable -> L67
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L2c
            goto L2e
        L2c:
            r13 = 0
            goto L2f
        L2e:
            r13 = 1
        L2f:
            boolean r0 = r9.b()     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto L3e
            java.util.Map<java.lang.Integer, com.bytedance.sdk.a.b.a.e.i> r0 = r10.f975d     // Catch: java.lang.Throwable -> L67
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L67
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L67
        L3e:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L67
            if (r11 != 0) goto L47
            com.bytedance.sdk.a.b.a.e.j r0 = r10.p     // Catch: java.lang.Throwable -> L6a
            r0.a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L6a
            goto L50
        L47:
            boolean r0 = r10.b     // Catch: java.lang.Throwable -> L6a
            if (r0 != 0) goto L59
            com.bytedance.sdk.a.b.a.e.j r0 = r10.p     // Catch: java.lang.Throwable -> L6a
            r0.a(r11, r8, r12)     // Catch: java.lang.Throwable -> L6a
        L50:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L6a
            if (r13 == 0) goto L58
            com.bytedance.sdk.a.b.a.e.j r11 = r10.p
            r11.b()
        L58:
            return r9
        L59:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L6a
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L6a
            throw r11     // Catch: java.lang.Throwable -> L6a
        L61:
            com.bytedance.sdk.a.b.a.e.a r11 = new com.bytedance.sdk.a.b.a.e.a     // Catch: java.lang.Throwable -> L67
            r11.<init>()     // Catch: java.lang.Throwable -> L67
            throw r11     // Catch: java.lang.Throwable -> L67
        L67:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L67
            throw r11     // Catch: java.lang.Throwable -> L6a
        L6a:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L6a
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.a.e.g.b(int, java.util.List, boolean):com.bytedance.sdk.a.b.a.e.i");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.p.c());
        r6 = r3;
        r8.f982k -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r9, boolean r10, com.bytedance.sdk.a.a.c r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            com.bytedance.sdk.a.b.a.e.j r12 = r8.p
            r12.a(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r3 = r8.f982k     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L30
            java.util.Map<java.lang.Integer, com.bytedance.sdk.a.b.a.e.i> r3 = r8.f975d     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L28
            r8.wait()     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            goto L12
        L28:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
        L30:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L56
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.a.b.a.e.j r3 = r8.p     // Catch: java.lang.Throwable -> L56
            int r3 = r3.c()     // Catch: java.lang.Throwable -> L56
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.f982k     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.f982k = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            com.bytedance.sdk.a.b.a.e.j r4 = r8.p
            if (r10 == 0) goto L51
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            r4.a(r5, r9, r11, r3)
            goto Ld
        L56:
            r9 = move-exception
            goto L5e
        L58:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            throw r9     // Catch: java.lang.Throwable -> L56
        L5e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            throw r9
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.a.e.g.a(int, boolean, com.bytedance.sdk.a.a.c, long):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: classes.dex */
    public class c extends com.bytedance.sdk.a.b.a.b implements h.b {
        final h a;

        c(h hVar) {
            super("OkHttp %s", g.this.f976e);
            this.a = hVar;
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a() {
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i2, int i3, int i4, boolean z) {
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i2, com.bytedance.sdk.a.a.e eVar, int i3) throws IOException {
            if (g.this.d(i2)) {
                g.this.a(i2, eVar, i3, z);
                return;
            }
            i a = g.this.a(i2);
            if (a == null) {
                g.this.a(i2, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                eVar.h(i3);
                return;
            }
            a.a(eVar, i3);
            if (z) {
                a.i();
            }
        }

        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            com.bytedance.sdk.a.b.a.e.b bVar;
            com.bytedance.sdk.a.b.a.e.b bVar2 = com.bytedance.sdk.a.b.a.e.b.INTERNAL_ERROR;
            try {
                try {
                    this.a.a(this);
                    while (this.a.a(false, (h.b) this)) {
                    }
                    bVar = com.bytedance.sdk.a.b.a.e.b.NO_ERROR;
                    try {
                        try {
                            g.this.a(bVar, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                        } catch (IOException unused) {
                            com.bytedance.sdk.a.b.a.e.b bVar3 = com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR;
                            g.this.a(bVar3, bVar3);
                            com.bytedance.sdk.a.b.a.c.a(this.a);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            g.this.a(bVar, bVar2);
                        } catch (IOException unused2) {
                        }
                        com.bytedance.sdk.a.b.a.c.a(this.a);
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
                bVar = bVar2;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                g.this.a(bVar, bVar2);
                com.bytedance.sdk.a.b.a.c.a(this.a);
                throw th;
            }
            com.bytedance.sdk.a.b.a.c.a(this.a);
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i2, int i3, List<com.bytedance.sdk.a.b.a.e.c> list) {
            if (g.this.d(i2)) {
                g.this.a(i2, list, z);
                return;
            }
            synchronized (g.this) {
                i a = g.this.a(i2);
                if (a == null) {
                    g gVar = g.this;
                    if (gVar.f979h) {
                        return;
                    }
                    if (i2 <= gVar.f977f) {
                        return;
                    }
                    if (i2 % 2 == gVar.f978g % 2) {
                        return;
                    }
                    final i iVar = new i(i2, g.this, false, z, list);
                    g gVar2 = g.this;
                    gVar2.f977f = i2;
                    gVar2.f975d.put(Integer.valueOf(i2), iVar);
                    g.a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{g.this.f976e, Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.a.b.a.e.g.c.1
                        @Override // com.bytedance.sdk.a.b.a.b
                        public void b() {
                            try {
                                g.this.c.a(iVar);
                            } catch (IOException e2) {
                                com.bytedance.sdk.a.b.a.g.e b = com.bytedance.sdk.a.b.a.g.e.b();
                                b.a(4, "Http2Connection.Listener failure for " + g.this.f976e, e2);
                                try {
                                    iVar.a(com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                    return;
                }
                a.a(list);
                if (z) {
                    a.i();
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
            if (g.this.d(i2)) {
                g.this.c(i2, bVar);
                return;
            }
            i b = g.this.b(i2);
            if (b != null) {
                b.c(bVar);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, n nVar) {
            i[] iVarArr;
            long j2;
            int i2;
            synchronized (g.this) {
                int d2 = g.this.m.d();
                if (z) {
                    g.this.m.a();
                }
                g.this.m.a(nVar);
                a(nVar);
                int d3 = g.this.m.d();
                iVarArr = null;
                if (d3 == -1 || d3 == d2) {
                    j2 = 0;
                } else {
                    j2 = d3 - d2;
                    g gVar = g.this;
                    if (!gVar.n) {
                        gVar.a(j2);
                        g.this.n = true;
                    }
                    if (!g.this.f975d.isEmpty()) {
                        iVarArr = (i[]) g.this.f975d.values().toArray(new i[g.this.f975d.size()]);
                    }
                }
                g.a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s settings", g.this.f976e) { // from class: com.bytedance.sdk.a.b.a.e.g.c.2
                    @Override // com.bytedance.sdk.a.b.a.b
                    public void b() {
                        g gVar2 = g.this;
                        gVar2.c.a(gVar2);
                    }
                });
            }
            if (iVarArr == null || j2 == 0) {
                return;
            }
            for (i iVar : iVarArr) {
                synchronized (iVar) {
                    iVar.a(j2);
                }
            }
        }

        private void a(final n nVar) {
            g.a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ACK Settings", new Object[]{g.this.f976e}) { // from class: com.bytedance.sdk.a.b.a.e.g.c.3
                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    try {
                        g.this.p.a(nVar);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i2, int i3) {
            if (z) {
                l c = g.this.c(i2);
                if (c != null) {
                    c.b();
                    return;
                }
                return;
            }
            g.this.a(true, i2, i3, (l) null);
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i2, com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.a.f fVar) {
            i[] iVarArr;
            fVar.g();
            synchronized (g.this) {
                iVarArr = (i[]) g.this.f975d.values().toArray(new i[g.this.f975d.size()]);
                g.this.f979h = true;
            }
            for (i iVar : iVarArr) {
                if (iVar.a() > i2 && iVar.c()) {
                    iVar.c(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
                    g.this.b(iVar.a());
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i2, long j2) {
            if (i2 == 0) {
                synchronized (g.this) {
                    g gVar = g.this;
                    gVar.f982k += j2;
                    gVar.notifyAll();
                }
                return;
            }
            i a = g.this.a(i2);
            if (a != null) {
                synchronized (a) {
                    a.a(j2);
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i2, int i3, List<com.bytedance.sdk.a.b.a.e.c> list) {
            g.this.a(i3, list);
        }
    }

    void a(long j2) {
        this.f982k += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i2, final com.bytedance.sdk.a.b.a.e.b bVar) {
        a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{this.f976e, Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.a.b.a.e.g.1
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.b(i2, bVar);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i2, final long j2) {
        a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp Window Update %s stream %d", new Object[]{this.f976e, Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.a.b.a.e.g.2
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.p.a(i2, j2);
                } catch (IOException unused) {
                }
            }
        });
    }

    void a(final boolean z, final int i2, final int i3, final l lVar) {
        a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ping %08x%08x", new Object[]{this.f976e, Integer.valueOf(i2), Integer.valueOf(i3)}) { // from class: com.bytedance.sdk.a.b.a.e.g.3
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.b(z, i2, i3, lVar);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i2, com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        this.p.a(i2, bVar);
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        synchronized (this.p) {
            synchronized (this) {
                if (this.f979h) {
                    return;
                }
                this.f979h = true;
                this.p.a(this.f977f, bVar, com.bytedance.sdk.a.b.a.c.a);
            }
        }
    }

    void b(boolean z, int i2, int i3, l lVar) throws IOException {
        synchronized (this.p) {
            if (lVar != null) {
                lVar.a();
            }
            this.p.a(z, i2, i3);
        }
    }

    public void b() throws IOException {
        this.p.b();
    }

    void a(com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.b.a.e.b bVar2) throws IOException {
        i[] iVarArr;
        if (!s && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        l[] lVarArr = null;
        try {
            a(bVar);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (this.f975d.isEmpty()) {
                iVarArr = null;
            } else {
                iVarArr = (i[]) this.f975d.values().toArray(new i[this.f975d.size()]);
                this.f975d.clear();
            }
            Map<Integer, l> map = this.u;
            if (map != null) {
                this.u = null;
                lVarArr = (l[]) map.values().toArray(new l[this.u.size()]);
            }
        }
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                try {
                    iVar.a(bVar2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        if (lVarArr != null) {
            for (l lVar : lVarArr) {
                lVar.c();
            }
        }
        try {
            this.p.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.o.close();
        } catch (IOException e5) {
            e = e5;
        }
        if (e != null) {
            throw e;
        }
    }

    void a(boolean z) throws IOException {
        if (z) {
            this.p.a();
            this.p.b(this.f983l);
            int d2 = this.f983l.d();
            if (d2 != 65535) {
                this.p.a(0, d2 - 65535);
            }
        }
        new Thread(this.q).start();
    }

    void a(final int i2, final List<com.bytedance.sdk.a.b.a.e.c> list) {
        synchronized (this) {
            if (this.r.contains(Integer.valueOf(i2))) {
                a(i2, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                return;
            }
            this.r.add(Integer.valueOf(i2));
            this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Request[%s]", new Object[]{this.f976e, Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.a.b.a.e.g.4
                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    if (g.this.f980i.a(i2, list)) {
                        try {
                            g.this.p.a(i2, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                            synchronized (g.this) {
                                g.this.r.remove(Integer.valueOf(i2));
                            }
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    void a(final int i2, final List<com.bytedance.sdk.a.b.a.e.c> list, final boolean z) {
        this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Headers[%s]", new Object[]{this.f976e, Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.a.b.a.e.g.5
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                boolean a2 = g.this.f980i.a(i2, list, z);
                if (a2) {
                    try {
                        g.this.p.a(i2, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (a2 || z) {
                    synchronized (g.this) {
                        g.this.r.remove(Integer.valueOf(i2));
                    }
                }
            }
        });
    }

    void a(final int i2, com.bytedance.sdk.a.a.e eVar, final int i3, final boolean z) throws IOException {
        final com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        long j2 = i3;
        eVar.a(j2);
        eVar.a(cVar, j2);
        if (cVar.b() == j2) {
            this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Data[%s]", new Object[]{this.f976e, Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.a.b.a.e.g.6
                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    try {
                        boolean a2 = g.this.f980i.a(i2, cVar, i3, z);
                        if (a2) {
                            g.this.p.a(i2, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                        }
                        if (a2 || z) {
                            synchronized (g.this) {
                                g.this.r.remove(Integer.valueOf(i2));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(cVar.b() + " != " + i3);
    }
}
