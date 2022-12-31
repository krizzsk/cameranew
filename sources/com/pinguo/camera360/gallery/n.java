package com.pinguo.camera360.gallery;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.pinguo.camera360.gallery.data.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/* compiled from: AlbumDataLoader.java */
/* loaded from: classes3.dex */
public class n {
    private final long[] b;
    private final long[] c;

    /* renamed from: h  reason: collision with root package name */
    private final com.pinguo.camera360.gallery.data.y f6416h;

    /* renamed from: j  reason: collision with root package name */
    private final Handler f6418j;

    /* renamed from: l  reason: collision with root package name */
    private WeakReference<b> f6420l;
    private x n;
    private f o;
    private int p;

    /* renamed from: d  reason: collision with root package name */
    private int f6412d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f6413e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f6414f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f6415g = 0;

    /* renamed from: i  reason: collision with root package name */
    private long f6417i = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f6419k = 0;
    private d m = new d();
    private final com.pinguo.camera360.gallery.data.w[] a = new com.pinguo.camera360.gallery.data.w[1000];

    /* compiled from: AlbumDataLoader.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, ArrayList<y.b> arrayList3);

        void b(int i2);
    }

    /* compiled from: AlbumDataLoader.java */
    /* loaded from: classes3.dex */
    private static class c extends e implements Callable<i> {
        private final long b;

        public c(long j2, n nVar) {
            super(nVar);
            this.b = j2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: b */
        public i call() throws Exception {
            i iVar = new i();
            long j2 = this.b;
            n a = a();
            if (a == null) {
                return iVar;
            }
            iVar.a = a.f6417i;
            iVar.f6424d = a.f6419k;
            long[] jArr = a.c;
            int i2 = a.f6415g;
            for (int i3 = a.f6414f; i3 < i2; i3++) {
                if (jArr[i3 % 1000] != j2) {
                    iVar.b = i3;
                    iVar.c = Math.min(64, i2 - i3);
                    return iVar;
                }
            }
            if (a.f6417i == this.b) {
                return null;
            }
            return iVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumDataLoader.java */
    /* loaded from: classes3.dex */
    public class d implements com.pinguo.camera360.gallery.data.n {
        private d() {
        }

        @Override // com.pinguo.camera360.gallery.data.n
        public void a() {
            if (n.this.o != null) {
                n.this.o.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumDataLoader.java */
    /* loaded from: classes3.dex */
    public static abstract class e {
        private final WeakReference<n> a;

        protected e(n nVar) {
            this.a = new WeakReference<>(nVar);
        }

        @Nullable
        protected final n a() {
            return this.a.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumDataLoader.java */
    /* loaded from: classes3.dex */
    public static class f extends Thread {
        private final WeakReference<n> a;
        private volatile boolean b;
        private volatile boolean c;

        /* renamed from: d  reason: collision with root package name */
        private volatile boolean f6421d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6422e;

        /* renamed from: f  reason: collision with root package name */
        long f6423f;

        @Nullable
        private n a() {
            return this.a.get();
        }

        private void f(boolean z) {
            if (this.f6422e == z) {
                return;
            }
            this.f6422e = z;
            n a = a();
            if (a == null) {
                return;
            }
            a.f6418j.sendEmptyMessage(z ? 1 : 2);
            if (z) {
                this.f6423f = System.currentTimeMillis();
                return;
            }
            us.pinguo.common.log.a.k("----加载照片，数据部分花费时间:" + (System.currentTimeMillis() - this.f6423f) + " mActiveStart:" + a.f6412d + " :mActiveEnd " + a.f6413e, new Object[0]);
        }

        public synchronized void b() {
            this.f6421d = true;
            notifyAll();
        }

        public synchronized void c() {
            if (this.f6421d) {
                this.f6421d = false;
                notifyAll();
            }
        }

        public synchronized void d() {
            this.c = true;
            notifyAll();
        }

        public synchronized void e() {
            this.b = false;
            this.f6421d = false;
            notifyAll();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n a;
            long x;
            if (ContextCompat.checkSelfPermission(us.pinguo.foundation.e.b(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                Process.setThreadPriority(10);
                boolean z = false;
                while (this.b && (a = a()) != null) {
                    if (this.f6421d) {
                        synchronized (this) {
                            if (this.f6421d) {
                                try {
                                    wait();
                                } catch (InterruptedException unused) {
                                    this.b = false;
                                }
                            }
                        }
                    }
                    synchronized (this) {
                        if (this.b && !this.c && z) {
                            f(false);
                            com.pinguo.album.j.a.r(this);
                        } else {
                            this.c = false;
                            f(true);
                            Object obj = com.pinguo.camera360.gallery.data.o.f6371d;
                            synchronized (obj) {
                                x = a.f6416h.x();
                            }
                            i iVar = (i) a.v(new c(x, a));
                            boolean z2 = iVar == null;
                            if (!z2) {
                                synchronized (obj) {
                                    if (iVar.a != x) {
                                        iVar.f6426f = new ArrayList<>();
                                        iVar.f6427g = new ArrayList<>();
                                        iVar.f6425e = new ArrayList<>();
                                        if (a.p == 2) {
                                            iVar.f6424d = a.f6416h.n(iVar.f6426f, iVar.f6427g);
                                        } else if (a.p == 4) {
                                            iVar.f6424d = a.f6416h.m(iVar.f6426f, iVar.f6425e);
                                        } else if (a.p == 3) {
                                            iVar.f6424d = a.f6416h.r();
                                        } else {
                                            iVar.f6424d = a.f6416h.l(iVar.f6426f);
                                        }
                                        iVar.a = x;
                                    }
                                    if (iVar.c > 0) {
                                        us.pinguo.common.log.a.k("----------11---------info.reloadStart:info.reloadCount " + iVar.b + ":" + iVar.c, new Object[0]);
                                        iVar.f6428h = a.f6416h.q(iVar.b, iVar.c);
                                    }
                                }
                                a.v(new h(iVar, a));
                            }
                            z = z2;
                        }
                    }
                }
                f(false);
                this.a.clear();
            }
        }

        private f(n nVar) {
            super("AlbumDataLoader$ReloadTask");
            this.b = true;
            this.c = true;
            this.f6421d = false;
            this.f6422e = false;
            this.f6423f = 0L;
            this.a = new WeakReference<>(nVar);
        }
    }

    /* compiled from: AlbumDataLoader.java */
    /* loaded from: classes3.dex */
    private static class g extends com.pinguo.album.g {
        private final WeakReference<n> b;

        public g(com.pinguo.album.views.b bVar, n nVar) {
            super(bVar);
            this.b = new WeakReference<>(nVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            n nVar = this.b.get();
            if (nVar == null) {
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                if (nVar.n != null) {
                    nVar.n.d();
                }
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                ((Runnable) message.obj).run();
            } else if (nVar.n != null) {
                nVar.n.c();
            }
        }
    }

    /* compiled from: AlbumDataLoader.java */
    /* loaded from: classes3.dex */
    private static class h extends e implements Callable<Void> {
        private i b;

        public h(i iVar, n nVar) {
            super(nVar);
            this.b = iVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: b */
        public Void call() throws Exception {
            i iVar = this.b;
            n a = a();
            if (a == null) {
                return null;
            }
            b bVar = (b) a.f6420l.get();
            a.f6417i = iVar.a;
            int i2 = a.f6419k;
            int i3 = iVar.f6424d;
            if (i2 != i3) {
                ArrayList<y.c> arrayList = iVar.f6426f;
                a.f6419k = i3;
                if (bVar != null) {
                    bVar.a(a.f6419k, arrayList, iVar.f6427g, iVar.f6425e);
                }
                if (a.f6415g > a.f6419k) {
                    a.f6415g = a.f6419k;
                }
                if (a.f6413e > a.f6419k) {
                    a.f6413e = a.f6419k;
                }
            }
            ArrayList<com.pinguo.camera360.gallery.data.w> arrayList2 = iVar.f6428h;
            if (arrayList2 == null) {
                return null;
            }
            int min = Math.min(iVar.b + arrayList2.size(), a.f6415g);
            for (int max = Math.max(iVar.b, a.f6414f); max < min; max++) {
                int i4 = max % 1000;
                a.c[i4] = iVar.a;
                com.pinguo.camera360.gallery.data.w wVar = arrayList2.get(max - iVar.b);
                long d2 = wVar.d();
                if (a.b[i4] != d2) {
                    a.b[i4] = d2;
                    a.a[i4] = wVar;
                    if (bVar != null && max >= a.f6412d && max < a.f6413e) {
                        bVar.b(max);
                    }
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumDataLoader.java */
    /* loaded from: classes3.dex */
    public static class i {
        public long a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f6424d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<y.b> f6425e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<y.c> f6426f;

        /* renamed from: g  reason: collision with root package name */
        public ArrayList<y.c> f6427g;

        /* renamed from: h  reason: collision with root package name */
        public ArrayList<com.pinguo.camera360.gallery.data.w> f6428h;

        private i() {
        }
    }

    public n(l lVar, com.pinguo.camera360.gallery.data.y yVar, int i2) {
        this.f6416h = yVar;
        long[] jArr = new long[1000];
        this.b = jArr;
        long[] jArr2 = new long[1000];
        this.c = jArr2;
        this.p = i2;
        Arrays.fill(jArr, -1L);
        Arrays.fill(jArr2, -1L);
        this.f6418j = new g(lVar.E(), this);
    }

    private void E(int i2, int i3) {
        int i4 = this.f6414f;
        if (i2 == i4 && i3 == this.f6415g) {
            return;
        }
        int i5 = this.f6415g;
        synchronized (this) {
            this.f6414f = i2;
            this.f6415g = i3;
        }
        if (i2 >= i5 || i4 >= i3) {
            while (i4 < i5) {
                u(i4 % 1000);
                i4++;
            }
        } else {
            while (i4 < i2) {
                u(i4 % 1000);
                i4++;
            }
            while (i3 < i5) {
                u(i3 % 1000);
                i3++;
            }
        }
        f fVar = this.o;
        if (fVar != null) {
            fVar.d();
        }
    }

    private void u(int i2) {
        this.a[i2] = null;
        this.b[i2] = -1;
        this.c[i2] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T v(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        Handler handler = this.f6418j;
        handler.sendMessage(handler.obtainMessage(3, futureTask));
        try {
            return (T) futureTask.get();
        } catch (InterruptedException unused) {
            return null;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void A() {
        f fVar = this.o;
        if (fVar != null) {
            fVar.e();
            this.o = null;
        }
        this.f6416h.y(this.m);
    }

    public void B() {
        this.f6418j.removeCallbacksAndMessages(null);
    }

    public void C() {
        this.f6416h.k(this.m);
        f fVar = new f();
        this.o = fVar;
        fVar.start();
    }

    public void D(int i2, int i3) {
        if (i2 == this.f6412d && i3 == this.f6413e) {
            return;
        }
        com.pinguo.album.j.a.a(i2 <= i3 && i3 - i2 <= this.a.length && i3 <= this.f6419k);
        int length = this.a.length;
        this.f6412d = i2;
        this.f6413e = i3;
        if (i2 == i3) {
            return;
        }
        int e2 = com.pinguo.album.j.a.e(((i2 + i3) / 2) - (length / 2), 0, Math.max(0, this.f6419k - length));
        int min = Math.min(length + e2, this.f6419k);
        int i4 = this.f6414f;
        if (i4 > i2 || this.f6415g < i3 || Math.abs(e2 - i4) > 32) {
            E(e2, min);
        }
    }

    public void F(b bVar) {
        this.f6420l = new WeakReference<>(bVar);
    }

    public void G(x xVar) {
        this.n = xVar;
    }

    public int H() {
        return this.f6419k;
    }

    public com.pinguo.camera360.gallery.data.w w(int i2) {
        if (x(i2)) {
            com.pinguo.camera360.gallery.data.w[] wVarArr = this.a;
            return wVarArr[i2 % wVarArr.length];
        }
        throw new IllegalArgumentException(String.format("%s not in (%s, %s)", Integer.valueOf(i2), Integer.valueOf(this.f6412d), Integer.valueOf(this.f6413e)));
    }

    public boolean x(int i2) {
        return i2 >= this.f6412d && i2 < this.f6413e;
    }

    public void y() {
        f fVar = this.o;
        if (fVar != null) {
            fVar.b();
        }
    }

    public void z() {
        f fVar = this.o;
        if (fVar != null) {
            fVar.c();
        }
    }
}
