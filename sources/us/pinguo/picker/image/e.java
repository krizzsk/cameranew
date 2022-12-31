package us.pinguo.picker.image;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import us.pinguo.picker.image.gallery.m;
import us.pinguo.picker.image.gallery.o;
/* compiled from: PhotoPickSetLoader.java */
/* loaded from: classes5.dex */
public class e {
    private final o b;
    private final o[] c;

    /* renamed from: d  reason: collision with root package name */
    private final m[] f11666d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f11667e;

    /* renamed from: f  reason: collision with root package name */
    private final long[] f11668f;

    /* renamed from: g  reason: collision with root package name */
    private final long[] f11669g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f11670h;

    /* renamed from: j  reason: collision with root package name */
    private int f11672j;

    /* renamed from: k  reason: collision with root package name */
    private C0428e f11673k;

    /* renamed from: l  reason: collision with root package name */
    private final Handler f11674l;
    private b m;
    private us.pinguo.picker.image.gallery.h n;
    private boolean a = true;

    /* renamed from: i  reason: collision with root package name */
    private long f11671i = -1;
    private final d o = new d(this, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PhotoPickSetLoader.java */
    /* loaded from: classes5.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                if (e.this.n != null) {
                    e.this.n.d();
                }
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                ((Runnable) message.obj).run();
            } else if (e.this.n != null) {
                e.this.n.c();
            }
        }
    }

    /* compiled from: PhotoPickSetLoader.java */
    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2);

        void b(int i2);
    }

    /* compiled from: PhotoPickSetLoader.java */
    /* loaded from: classes5.dex */
    private class c implements Callable<g> {
        private final long a;

        public c(long j2) {
            this.a = j2;
        }

        private int b(long j2) {
            long[] jArr = e.this.f11669g;
            int length = jArr.length;
            int i2 = e.this.f11672j;
            for (int i3 = 0; i3 < i2; i3++) {
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
            if (b == -1 && e.this.f11671i == this.a) {
                return null;
            }
            g gVar = new g(null);
            gVar.a = e.this.f11671i;
            gVar.b = b;
            gVar.c = e.this.f11672j;
            return gVar;
        }
    }

    /* compiled from: PhotoPickSetLoader.java */
    /* loaded from: classes5.dex */
    private class d implements us.pinguo.picker.image.gallery.e {
        private d() {
        }

        @Override // us.pinguo.picker.image.gallery.e
        public void a() {
            e.this.f11673k.a();
        }

        /* synthetic */ d(e eVar, a aVar) {
            this();
        }
    }

    /* compiled from: PhotoPickSetLoader.java */
    /* loaded from: classes5.dex */
    private class f implements Callable<Void> {
        private final g a;

        public f(g gVar) {
            this.a = gVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            if (e.this.f11673k == null) {
                return null;
            }
            g gVar = this.a;
            e.this.f11671i = gVar.a;
            int i2 = e.this.f11672j;
            int i3 = gVar.c;
            if (i2 != i3) {
                e.this.f11672j = i3;
                if (e.this.m != null) {
                    e.this.m.b(e.this.f11672j);
                }
            }
            int i4 = gVar.b;
            if (i4 >= 0 && i4 < e.this.f11672j) {
                int length = gVar.b % e.this.f11666d.length;
                e.this.f11669g[length] = gVar.a;
                long a = gVar.f11676d.a();
                if (e.this.f11668f[length] == a) {
                    return null;
                }
                e.this.f11668f[length] = a;
                e.this.c[length] = gVar.f11676d;
                e.this.f11666d[length] = gVar.f11677e;
                e.this.f11667e[length] = gVar.f11678f;
                e.this.f11670h[length] = gVar.f11679g;
                if (e.this.m != null) {
                    e.this.m.a(gVar.b);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoPickSetLoader.java */
    /* loaded from: classes5.dex */
    public static class g {
        public long a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public o f11676d;

        /* renamed from: e  reason: collision with root package name */
        public m f11677e;

        /* renamed from: f  reason: collision with root package name */
        public int f11678f;

        /* renamed from: g  reason: collision with root package name */
        public int f11679g;

        private g() {
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    public e(o oVar) {
        com.pinguo.album.j.a.c(oVar);
        this.b = oVar;
        this.f11666d = new m[256];
        this.c = new o[256];
        this.f11667e = new int[256];
        long[] jArr = new long[256];
        this.f11668f = jArr;
        long[] jArr2 = new long[256];
        this.f11669g = jArr2;
        this.f11670h = new int[256];
        Arrays.fill(jArr, -1L);
        Arrays.fill(jArr2, -1L);
        this.f11674l = new a(Looper.getMainLooper());
    }

    private void q(int i2) {
        if (this.a) {
            throw new IllegalArgumentException("Activity has destroy!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T t(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        Handler handler = this.f11674l;
        handler.sendMessage(handler.obtainMessage(3, futureTask));
        try {
            return (T) futureTask.get();
        } catch (InterruptedException unused) {
            return null;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void A(b bVar) {
        this.m = bVar;
    }

    public int B() {
        return this.f11672j;
    }

    public void r() {
        this.a = false;
    }

    public void s() {
        this.a = true;
    }

    public int u(int i2) {
        q(i2);
        int[] iArr = this.f11670h;
        return iArr[i2 % iArr.length];
    }

    public m v(int i2) {
        q(i2);
        m[] mVarArr = this.f11666d;
        return mVarArr[i2 % mVarArr.length];
    }

    public o w(int i2) {
        q(i2);
        o[] oVarArr = this.c;
        return oVarArr[i2 % oVarArr.length];
    }

    public void x() {
        C0428e c0428e = this.f11673k;
        if (c0428e != null) {
            c0428e.b();
            this.f11673k = null;
            this.b.o(this.o);
        }
    }

    public void y() {
        if (this.f11673k == null) {
            this.b.e(this.o);
            C0428e c0428e = new C0428e(this, null);
            this.f11673k = c0428e;
            c0428e.start();
        }
    }

    public void z(us.pinguo.picker.image.gallery.h hVar) {
        this.n = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoPickSetLoader.java */
    /* renamed from: us.pinguo.picker.image.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0428e extends Thread {
        private volatile boolean a;
        private volatile boolean b;
        private volatile boolean c;

        private C0428e() {
            this.a = true;
            this.b = true;
            this.c = false;
        }

        private void c(boolean z) {
            if (this.c == z) {
                return;
            }
            this.c = z;
            e.this.f11674l.sendEmptyMessage(z ? 1 : 2);
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
            long n;
            Process.setThreadPriority(10);
            boolean z = false;
            while (this.a) {
                synchronized (this) {
                    if (this.a && !this.b && z) {
                        if (!e.this.b.l()) {
                            c(false);
                        }
                        com.pinguo.album.j.a.r(this);
                    } else {
                        this.b = false;
                        c(true);
                        Object obj = us.pinguo.picker.image.gallery.f.f11696d;
                        synchronized (obj) {
                            long uptimeMillis = SystemClock.uptimeMillis();
                            n = e.this.b.n();
                            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                            if (uptimeMillis2 > 20) {
                                us.pinguo.common.log.a.q("finish reload - " + uptimeMillis2, new Object[0]);
                            }
                        }
                        e eVar = e.this;
                        g gVar = (g) eVar.t(new c(n));
                        z = gVar == null;
                        if (z) {
                            continue;
                        } else {
                            synchronized (obj) {
                                if (gVar.a != n) {
                                    gVar.a = n;
                                    int k2 = e.this.b.k();
                                    gVar.c = k2;
                                    if (gVar.b >= k2) {
                                        gVar.b = -1;
                                    }
                                }
                                if (gVar.b != -1) {
                                    o j2 = e.this.b.j(gVar.b);
                                    gVar.f11676d = j2;
                                    if (j2 != null) {
                                        gVar.f11677e = j2.f();
                                        gVar.f11678f = gVar.f11676d.h();
                                        try {
                                            gVar.f11679g = Integer.valueOf(gVar.f11676d.c().b()).intValue();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                }
                                e eVar2 = e.this;
                                eVar2.t(new f(gVar));
                            }
                        }
                    }
                }
            }
            c(false);
        }

        /* synthetic */ C0428e(e eVar, a aVar) {
            this();
        }
    }
}
