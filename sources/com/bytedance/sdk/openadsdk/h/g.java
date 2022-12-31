package com.bytedance.sdk.openadsdk.h;

import android.util.Log;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.h.b;
import com.bytedance.sdk.openadsdk.h.h;
import com.bytedance.sdk.openadsdk.h.i;
import com.bytedance.sdk.openadsdk.h.l;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProxyTask.java */
/* loaded from: classes.dex */
public class g extends com.bytedance.sdk.openadsdk.h.a {
    private final Socket m;
    private final c n;
    private final ExecutorService o;
    private final d p;
    private volatile com.bytedance.sdk.openadsdk.h.b q;
    private volatile boolean r;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProxyTask.java */
    /* loaded from: classes.dex */
    public static class b {
        private final OutputStream a;
        private int b;
        private boolean c;

        b(OutputStream outputStream, int i2) {
            this.a = outputStream;
            this.b = i2;
        }

        boolean a() {
            return this.c;
        }

        void b(byte[] bArr, int i2, int i3) throws com.bytedance.sdk.openadsdk.h.c.d {
            try {
                this.a.write(bArr, i2, i3);
                this.b += i3;
            } catch (IOException e2) {
                throw new com.bytedance.sdk.openadsdk.h.c.d(e2);
            }
        }

        void a(byte[] bArr, int i2, int i3) throws com.bytedance.sdk.openadsdk.h.c.d {
            if (this.c) {
                return;
            }
            try {
                this.a.write(bArr, i2, i3);
                this.c = true;
            } catch (IOException e2) {
                throw new com.bytedance.sdk.openadsdk.h.c.d(e2);
            }
        }

        int b() {
            return this.b;
        }
    }

    /* compiled from: ProxyTask.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(g gVar);

        void b(g gVar);
    }

    g(a aVar) {
        super(aVar.a, aVar.b);
        this.r = true;
        this.o = aVar.c;
        this.m = aVar.f2059d;
        this.n = aVar.f2060e;
        this.p = d.c();
    }

    private void a(boolean z, int i2, int i3, int i4, int i5) {
    }

    private void b(b bVar, l.a aVar) throws IOException, com.bytedance.sdk.openadsdk.h.c.d, VAdError {
        byte[] a2 = a(this.b.a(this.f1996h, this.f1997i.c.a), bVar, aVar);
        if (a2 == null) {
            return;
        }
        bVar.a(a2, 0, a2.length);
    }

    private void c(b bVar, l.a aVar) throws h.a, com.bytedance.sdk.openadsdk.h.c.d, IOException, com.bytedance.sdk.openadsdk.h.c.a, com.bytedance.sdk.openadsdk.h.c.b, VAdError {
        if (this.r) {
            File c2 = this.a.c(this.f1996h);
            long length = c2.length();
            com.bytedance.sdk.openadsdk.h.b.a a2 = this.b.a(this.f1996h, this.f1997i.c.a);
            int b2 = bVar.b();
            long j2 = length - b2;
            int i2 = (int) j2;
            int i3 = a2 == null ? -1 : a2.c;
            if (length > bVar.b()) {
                if (e.c) {
                    Log.i("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + j2);
                }
                a(true, i2, i3, (int) length, b2);
                a(a2, c2, bVar, aVar);
                return;
            }
            a(false, i2, i3, (int) length, b2);
        } else {
            a(false, 0, 0, 0, bVar.b());
        }
        d(bVar, aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ad A[EDGE_INSN: B:100:0x01ad->B:70:0x01ad ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104 A[Catch: all -> 0x01d9, TRY_LEAVE, TryCatch #4 {all -> 0x01d9, blocks: (B:30:0x00ef, B:37:0x0100, B:39:0x0104, B:45:0x014e, B:49:0x0160, B:48:0x015e, B:36:0x00fc), top: B:94:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015e A[Catch: all -> 0x01d9, TryCatch #4 {all -> 0x01d9, blocks: (B:30:0x00ef, B:37:0x0100, B:39:0x0104, B:45:0x014e, B:49:0x0160, B:48:0x015e, B:36:0x00fc), top: B:94:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016f A[Catch: all -> 0x01d5, TryCatch #3 {all -> 0x01d5, blocks: (B:51:0x0169, B:53:0x016f, B:55:0x0174, B:68:0x01a2, B:69:0x01a9, B:70:0x01ad, B:72:0x01b1, B:73:0x01b6, B:58:0x017a), top: B:96:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b1 A[Catch: all -> 0x01d5, TryCatch #3 {all -> 0x01d5, blocks: (B:51:0x0169, B:53:0x016f, B:55:0x0174, B:68:0x01a2, B:69:0x01a9, B:70:0x01ad, B:72:0x01b1, B:73:0x01b6, B:58:0x017a), top: B:96:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0208  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(com.bytedance.sdk.openadsdk.h.g.b r13, com.bytedance.sdk.openadsdk.h.l.a r14) throws com.bytedance.sdk.openadsdk.h.c.d, java.io.IOException, com.bytedance.sdk.openadsdk.h.c.a, com.bytedance.sdk.openadsdk.h.c.b, com.bytedance.sdk.adnet.err.VAdError {
        /*
            Method dump skipped, instructions count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.g.d(com.bytedance.sdk.openadsdk.h.g$b, com.bytedance.sdk.openadsdk.h.l$a):void");
    }

    private b h() {
        try {
            this.f1997i = i.a(this.m.getInputStream());
            OutputStream outputStream = this.m.getOutputStream();
            com.bytedance.sdk.openadsdk.h.a.a aVar = this.f1997i.c.a == 1 ? e.a : e.b;
            if (aVar == null) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.a = aVar;
            this.f1995g = this.f1997i.c.b;
            this.f1996h = this.f1997i.c.c;
            this.f1998j = new l(this.f1997i.c.f2066g);
            this.f1994f = this.f1997i.b;
            if (e.c) {
                Log.i("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.f1997i.toString());
            }
            return new b(outputStream, this.f1997i.c.f2063d);
        } catch (i.d e2) {
            com.bytedance.sdk.openadsdk.h.g.d.a(this.m);
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            a(this.a == null ? null : Boolean.valueOf(g()), this.f1995g, e2);
            return null;
        } catch (IOException e3) {
            com.bytedance.sdk.openadsdk.h.g.d.a(this.m);
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
            }
            a(this.a == null ? null : Boolean.valueOf(g()), this.f1995g, e3);
            return null;
        }
    }

    private void i() {
        com.bytedance.sdk.openadsdk.h.b bVar = this.q;
        this.q = null;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bytedance.sdk.openadsdk.h.b.a a2;
        b h2 = h();
        if (h2 == null) {
            return;
        }
        c cVar = this.n;
        if (cVar != null) {
            cVar.a(this);
        }
        this.a.a(this.f1996h);
        if (e.f2038h != 0 && ((a2 = this.b.a(this.f1996h, this.f1997i.c.a)) == null || this.a.c(this.f1996h).length() < a2.c)) {
            this.p.a(g(), this.f1996h);
        }
        try {
            a(h2);
        } catch (VAdError e2) {
            e2.printStackTrace();
        } catch (com.bytedance.sdk.openadsdk.h.c.a e3) {
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
            }
        } catch (Throwable th) {
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.a.b(this.f1996h);
        this.p.a(g(), null);
        a();
        com.bytedance.sdk.openadsdk.h.g.d.a(this.m);
        c cVar2 = this.n;
        if (cVar2 != null) {
            cVar2.b(this);
        }
    }

    /* compiled from: ProxyTask.java */
    /* loaded from: classes.dex */
    static final class a {
        com.bytedance.sdk.openadsdk.h.a.a a;
        com.bytedance.sdk.openadsdk.h.b.c b;
        ExecutorService c;

        /* renamed from: d  reason: collision with root package name */
        Socket f2059d;

        /* renamed from: e  reason: collision with root package name */
        c f2060e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(com.bytedance.sdk.openadsdk.h.b.c cVar) {
            if (cVar != null) {
                this.b = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(ExecutorService executorService) {
            if (executorService != null) {
                this.c = executorService;
                return this;
            }
            throw new IllegalArgumentException("executor == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(Socket socket) {
            if (socket != null) {
                this.f2059d = socket;
                return this;
            }
            throw new IllegalArgumentException("socket == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(c cVar) {
            this.f2060e = cVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g a() {
            if (this.b != null && this.c != null && this.f2059d != null) {
                return new g(this);
            }
            throw new IllegalArgumentException();
        }
    }

    private boolean a(b bVar) throws com.bytedance.sdk.openadsdk.h.c.a, VAdError {
        while (this.f1998j.a()) {
            e();
            l.a b2 = this.f1998j.b();
            try {
                a(bVar, b2);
                return true;
            } catch (com.bytedance.sdk.adnet.err.a e2) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
            } catch (com.bytedance.sdk.openadsdk.h.c.b e3) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                return false;
            } catch (com.bytedance.sdk.openadsdk.h.c.c e4) {
                b2.a();
                a(Boolean.valueOf(g()), this.f1995g, e4);
            } catch (com.bytedance.sdk.openadsdk.h.c.d e5) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
                return true;
            } catch (h.a e6) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
                }
                this.r = false;
                a(Boolean.valueOf(g()), this.f1995g, e6);
            } catch (IOException e7) {
                if (e7 instanceof SocketTimeoutException) {
                    b2.b();
                }
                if (b()) {
                    if (e.c) {
                        if ("Canceled".equalsIgnoreCase(e7.getMessage())) {
                            Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                        } else {
                            Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e7));
                        }
                    }
                } else {
                    a(Boolean.valueOf(g()), this.f1995g, e7);
                }
            } catch (Exception e8) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e8));
                }
            }
        }
        return false;
    }

    private void a(b bVar, l.a aVar) throws com.bytedance.sdk.openadsdk.h.c.d, IOException, h.a, com.bytedance.sdk.openadsdk.h.c.a, com.bytedance.sdk.openadsdk.h.c.b, VAdError {
        if ("HEAD".equalsIgnoreCase(this.f1997i.a.a)) {
            b(bVar, aVar);
        } else {
            c(bVar, aVar);
        }
    }

    private byte[] a(com.bytedance.sdk.openadsdk.h.b.a aVar, b bVar, l.a aVar2) throws IOException, VAdError {
        if (aVar != null) {
            if (e.c) {
                Log.i("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bytedance.sdk.openadsdk.h.g.d.a(aVar, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.h.g.d.a);
        }
        com.bytedance.sdk.openadsdk.h.e.a a2 = a(aVar2, 0, -1, "HEAD");
        if (a2 == null) {
            return null;
        }
        try {
            String a3 = com.bytedance.sdk.openadsdk.h.g.d.a(a2, false, false);
            if (a3 == null) {
                com.bytedance.sdk.openadsdk.h.b.a a4 = com.bytedance.sdk.openadsdk.h.g.d.a(a2, this.b, this.f1996h, this.f1997i.c.a);
                if (e.c) {
                    Log.w("TAG_PROXY_ProxyTask", "get header from network");
                }
                return com.bytedance.sdk.openadsdk.h.g.d.a(a4, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.h.g.d.a);
            }
            throw new com.bytedance.sdk.openadsdk.h.c.c(a3 + ", rawKey: " + this.f1995g + ", url: " + aVar2);
        } finally {
            com.bytedance.sdk.openadsdk.h.g.d.a(a2.d());
        }
    }

    private void a(com.bytedance.sdk.openadsdk.h.b.a aVar, File file, b bVar, l.a aVar2) throws IOException, com.bytedance.sdk.openadsdk.h.c.d, h.a, com.bytedance.sdk.openadsdk.h.c.a, com.bytedance.sdk.openadsdk.h.c.b, VAdError {
        Future<?> future;
        com.bytedance.sdk.openadsdk.h.b bVar2;
        if (!bVar.a()) {
            byte[] a2 = a(aVar, bVar, aVar2);
            e();
            if (a2 == null) {
                return;
            }
            bVar.a(a2, 0, a2.length);
        }
        h hVar = null;
        if (aVar == null && (aVar = this.b.a(this.f1996h, this.f1997i.c.a)) == null) {
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            a((com.bytedance.sdk.openadsdk.h.b.a) null, bVar, aVar2);
            aVar = this.b.a(this.f1996h, this.f1997i.c.a);
            if (aVar == null) {
                throw new com.bytedance.sdk.openadsdk.h.c.c("failed to get header, rawKey: " + this.f1995g + ", url: " + aVar2);
            }
        }
        if (file.length() >= aVar.c || !((bVar2 = this.q) == null || bVar2.b() || bVar2.d())) {
            future = null;
        } else {
            com.bytedance.sdk.openadsdk.h.b a3 = new b.a().a(this.a).a(this.b).a(this.f1995g).b(this.f1996h).a(new l(aVar2.a)).a(this.f1994f).a(this.f1997i).a(new b.InterfaceC0061b() { // from class: com.bytedance.sdk.openadsdk.h.g.1
                @Override // com.bytedance.sdk.openadsdk.h.b.InterfaceC0061b
                public void a(com.bytedance.sdk.openadsdk.h.b bVar3) {
                    g.this.c.addAndGet(bVar3.c.get());
                    g.this.f1992d.addAndGet(bVar3.f1992d.get());
                    synchronized (bVar3.m) {
                        bVar3.m.notifyAll();
                    }
                    if (bVar3.d()) {
                        g.this.p.a(g.this.g(), null);
                    }
                }
            }).a();
            this.q = a3;
            future = this.o.submit(a3);
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            h hVar2 = new h(file, "r");
            try {
                hVar2.a(bVar.b());
                int min = this.f1997i.c.f2064e > 0 ? Math.min(aVar.c, this.f1997i.c.f2064e) : aVar.c;
                while (bVar.b() < min) {
                    e();
                    int a4 = hVar2.a(bArr);
                    if (a4 <= 0) {
                        com.bytedance.sdk.openadsdk.h.b bVar3 = this.q;
                        if (bVar3 != null) {
                            com.bytedance.sdk.openadsdk.h.c.b i2 = bVar3.i();
                            if (i2 == null) {
                                h.a h2 = bVar3.h();
                                if (h2 != null) {
                                    throw h2;
                                }
                            } else {
                                throw i2;
                            }
                        }
                        if (bVar3 != null && !bVar3.b() && !bVar3.d()) {
                            e();
                            synchronized (bVar3.m) {
                                try {
                                    bVar3.m.wait(1000L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (e.c) {
                            Log.e("TAG_PROXY_ProxyTask", "download task has finished!!!");
                        }
                        throw new com.bytedance.sdk.openadsdk.h.c.c("illegal state download task has finished, rawKey: " + this.f1995g + ", url: " + aVar2);
                    }
                    bVar.b(bArr, 0, a4);
                    e();
                }
                if (e.c) {
                    Log.i("TAG_PROXY_ProxyTask", "read cache file complete: " + bVar.b() + ", " + min);
                }
                c();
                hVar2.a();
                if (future != null) {
                    try {
                        future.get();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                hVar = hVar2;
                if (hVar != null) {
                    hVar.a();
                }
                if (future != null) {
                    try {
                        future.get();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.a
    public void a() {
        super.a();
        i();
    }
}
