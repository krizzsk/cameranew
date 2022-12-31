package com.pinguo.camera360.gallery;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/* compiled from: AlbumSetDataLoader.java */
/* loaded from: classes3.dex */
public class q {

    /* renamed from: e  reason: collision with root package name */
    private final com.pinguo.camera360.gallery.data.y f6440e;

    /* renamed from: f  reason: collision with root package name */
    private final com.pinguo.camera360.gallery.data.y[] f6441f;

    /* renamed from: g  reason: collision with root package name */
    private final com.pinguo.camera360.gallery.data.w[] f6442g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f6443h;

    /* renamed from: i  reason: collision with root package name */
    private final long[] f6444i;

    /* renamed from: j  reason: collision with root package name */
    private final long[] f6445j;

    /* renamed from: k  reason: collision with root package name */
    private final int[] f6446k;
    private int m;
    private e n;
    private final Handler o;
    private b p;
    private x q;
    private int a = 0;
    private int b = 0;
    private int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f6439d = 0;

    /* renamed from: l  reason: collision with root package name */
    private long f6447l = -1;
    private final d r = new d(this, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumSetDataLoader.java */
    /* loaded from: classes3.dex */
    public class a extends com.pinguo.album.g {
        a(com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                if (q.this.q != null) {
                    q.this.q.d();
                }
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                ((Runnable) message.obj).run();
            } else if (q.this.q != null) {
                q.this.q.c();
            }
        }
    }

    /* compiled from: AlbumSetDataLoader.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2);

        void b(int i2);
    }

    /* compiled from: AlbumSetDataLoader.java */
    /* loaded from: classes3.dex */
    private class c implements Callable<g> {
        private final long a;

        public c(long j2) {
            this.a = j2;
        }

        private int b(long j2) {
            long[] jArr = q.this.f6445j;
            int length = jArr.length;
            int i2 = q.this.f6439d;
            for (int i3 = q.this.c; i3 < i2; i3++) {
                if (jArr[i3 % length] != j2) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public g call() throws Exception {
            int b = b(this.a);
            if (b == -1 && q.this.f6447l == this.a) {
                return null;
            }
            g gVar = new g(null);
            gVar.a = q.this.f6447l;
            gVar.b = b;
            gVar.c = q.this.m;
            return gVar;
        }
    }

    /* compiled from: AlbumSetDataLoader.java */
    /* loaded from: classes3.dex */
    private class d implements com.pinguo.camera360.gallery.data.n {
        private d() {
        }

        @Override // com.pinguo.camera360.gallery.data.n
        public void a() {
            q.this.n.a();
        }

        /* synthetic */ d(q qVar, a aVar) {
            this();
        }
    }

    /* compiled from: AlbumSetDataLoader.java */
    /* loaded from: classes3.dex */
    private class f implements Callable<Void> {
        private final g a;

        public f(g gVar) {
            this.a = gVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            if (q.this.n == null) {
                return null;
            }
            g gVar = this.a;
            q.this.f6447l = gVar.a;
            int i2 = q.this.m;
            int i3 = gVar.c;
            if (i2 != i3) {
                q.this.m = i3;
                if (q.this.p != null) {
                    q.this.p.b(q.this.m);
                }
                if (q.this.f6439d > q.this.m) {
                    q qVar = q.this;
                    qVar.f6439d = qVar.m;
                }
                if (q.this.b > q.this.m) {
                    q qVar2 = q.this;
                    qVar2.b = qVar2.m;
                }
            }
            if (gVar.b >= q.this.c && gVar.b < q.this.f6439d) {
                int length = gVar.b % q.this.f6442g.length;
                q.this.f6445j[length] = gVar.a;
                long d2 = gVar.f6449d.d();
                if (q.this.f6444i[length] == d2) {
                    return null;
                }
                q.this.f6444i[length] = d2;
                q.this.f6441f[length] = gVar.f6449d;
                q.this.f6442g[length] = gVar.f6450e;
                q.this.f6443h[length] = gVar.f6451f;
                q.this.f6446k[length] = gVar.f6452g;
                if (q.this.p != null && gVar.b >= q.this.a && gVar.b < q.this.b) {
                    q.this.p.a(gVar.b);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumSetDataLoader.java */
    /* loaded from: classes3.dex */
    public static class g {
        public long a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public com.pinguo.camera360.gallery.data.y f6449d;

        /* renamed from: e  reason: collision with root package name */
        public com.pinguo.camera360.gallery.data.w f6450e;

        /* renamed from: f  reason: collision with root package name */
        public int f6451f;

        /* renamed from: g  reason: collision with root package name */
        public int f6452g;

        private g() {
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    public q(l lVar, com.pinguo.camera360.gallery.data.y yVar) {
        com.pinguo.album.j.a.c(yVar);
        this.f6440e = yVar;
        this.f6442g = new com.pinguo.camera360.gallery.data.w[256];
        this.f6441f = new com.pinguo.camera360.gallery.data.y[256];
        this.f6443h = new int[256];
        long[] jArr = new long[256];
        this.f6444i = jArr;
        long[] jArr2 = new long[256];
        this.f6445j = jArr2;
        this.f6446k = new int[256];
        Arrays.fill(jArr, -1L);
        Arrays.fill(jArr2, -1L);
        this.o = new a(lVar.E());
    }

    private void G(int i2, int i3) {
        int i4 = this.c;
        if (i2 == i4 && i3 == this.f6439d) {
            return;
        }
        int length = this.f6442g.length;
        int i5 = this.f6439d;
        this.c = i2;
        this.f6439d = i3;
        if (i2 >= i5 || i4 >= i3) {
            while (i4 < i5) {
                x(i4 % length);
                i4++;
            }
        } else {
            while (i4 < i2) {
                x(i4 % length);
                i4++;
            }
            while (i3 < i5) {
                x(i3 % length);
                i3++;
            }
        }
        this.n.a();
    }

    private void w(int i2) {
        if (i2 < this.a && i2 >= this.b) {
            throw new IllegalArgumentException(String.format("%s not in (%s, %s)", Integer.valueOf(i2), Integer.valueOf(this.a), Integer.valueOf(this.b)));
        }
    }

    private void x(int i2) {
        this.f6441f[i2] = null;
        this.f6442g[i2] = null;
        this.f6443h[i2] = 0;
        this.f6444i[i2] = -1;
        this.f6445j[i2] = -1;
        this.f6446k[i2] = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T y(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        Handler handler = this.o;
        handler.sendMessage(handler.obtainMessage(3, futureTask));
        try {
            return (T) futureTask.get();
        } catch (InterruptedException unused) {
            return null;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    public com.pinguo.camera360.gallery.data.w A(int i2) {
        w(i2);
        com.pinguo.camera360.gallery.data.w[] wVarArr = this.f6442g;
        return wVarArr[i2 % wVarArr.length];
    }

    public com.pinguo.camera360.gallery.data.y B(int i2) {
        w(i2);
        com.pinguo.camera360.gallery.data.y[] yVarArr = this.f6441f;
        return yVarArr[i2 % yVarArr.length];
    }

    public int C(int i2) {
        w(i2);
        int[] iArr = this.f6443h;
        return iArr[i2 % iArr.length];
    }

    public void D() {
        e eVar = this.n;
        if (eVar != null) {
            eVar.b();
            this.n = null;
            this.f6440e.y(this.r);
        }
    }

    public void E() {
        this.f6440e.k(this.r);
        e eVar = new e(this, null);
        this.n = eVar;
        eVar.start();
    }

    public void F(int i2, int i3) {
        if (i2 == this.a && i3 == this.b) {
            return;
        }
        com.pinguo.album.j.a.a(i2 <= i3 && i3 - i2 <= this.f6442g.length && i3 <= this.m);
        this.a = i2;
        this.b = i3;
        int length = this.f6442g.length;
        if (i2 == i3) {
            return;
        }
        int e2 = com.pinguo.album.j.a.e(((i2 + i3) / 2) - (length / 2), 0, Math.max(0, this.m - length));
        int min = Math.min(length + e2, this.m);
        int i4 = this.c;
        if (i4 > i2 || this.f6439d < i3 || Math.abs(e2 - i4) > 4) {
            G(e2, min);
        }
    }

    public void H(x xVar) {
        this.q = xVar;
    }

    public void I(b bVar) {
        this.p = bVar;
    }

    public int J() {
        return this.m;
    }

    public int z(int i2) {
        w(i2);
        int[] iArr = this.f6446k;
        return iArr[i2 % iArr.length];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumSetDataLoader.java */
    /* loaded from: classes3.dex */
    public class e extends Thread {
        private volatile boolean a;
        private volatile boolean b;
        private volatile boolean c;

        private e() {
            this.a = true;
            this.b = true;
            this.c = false;
        }

        private void c(boolean z) {
            if (this.c == z) {
                return;
            }
            this.c = z;
            q.this.o.sendEmptyMessage(z ? 1 : 2);
        }

        public synchronized void a() {
            this.b = true;
            notifyAll();
        }

        public synchronized void b() {
            this.a = false;
            notifyAll();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long x;
            Process.setThreadPriority(10);
            boolean z = false;
            while (this.a) {
                synchronized (this) {
                    if (this.a && !this.b && z) {
                        if (!q.this.f6440e.v()) {
                            c(false);
                        }
                        com.pinguo.album.j.a.r(this);
                    } else {
                        this.b = false;
                        c(true);
                        Object obj = com.pinguo.camera360.gallery.data.o.f6371d;
                        synchronized (obj) {
                            long uptimeMillis = SystemClock.uptimeMillis();
                            x = q.this.f6440e.x();
                            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                            if (uptimeMillis2 > 20) {
                                us.pinguo.common.log.a.q("finish reload - " + uptimeMillis2, new Object[0]);
                            }
                        }
                        q qVar = q.this;
                        g gVar = (g) qVar.y(new c(x));
                        z = gVar == null;
                        if (z) {
                            continue;
                        } else {
                            synchronized (obj) {
                                if (gVar.a != x) {
                                    gVar.a = x;
                                    int u = q.this.f6440e.u();
                                    gVar.c = u;
                                    if (gVar.b >= u) {
                                        gVar.b = -1;
                                    }
                                }
                                if (gVar.b != -1) {
                                    com.pinguo.camera360.gallery.data.y t = q.this.f6440e.t(gVar.b);
                                    gVar.f6449d = t;
                                    if (t != null) {
                                        gVar.f6450e = t.o();
                                        gVar.f6451f = gVar.f6449d.r();
                                        try {
                                            gVar.f6452g = Integer.valueOf(gVar.f6449d.g().f()).intValue();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                }
                                q qVar2 = q.this;
                                qVar2.y(new f(gVar));
                            }
                        }
                    }
                }
            }
            c(false);
        }

        /* synthetic */ e(q qVar, a aVar) {
            this();
        }
    }
}
