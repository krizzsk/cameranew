package com.pinguo.album;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: AlbumThreadPool.java */
/* loaded from: classes3.dex */
public class a {
    d a;
    d b;
    private final Executor c;

    /* compiled from: AlbumThreadPool.java */
    /* renamed from: com.pinguo.album.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0229a {
        void onCancel();
    }

    /* compiled from: AlbumThreadPool.java */
    /* loaded from: classes3.dex */
    public interface b<T> {
        T a(c cVar);
    }

    /* compiled from: AlbumThreadPool.java */
    /* loaded from: classes3.dex */
    public interface c {
        void a(InterfaceC0229a interfaceC0229a);

        boolean b(int i2);

        boolean isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumThreadPool.java */
    /* loaded from: classes3.dex */
    public static class d {
        public int a;

        public d(int i2) {
            this.a = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumThreadPool.java */
    /* loaded from: classes3.dex */
    public class e<T> implements Runnable, com.pinguo.album.c<T>, c {
        private b<T> a;
        private com.pinguo.album.d<T> b;
        private InterfaceC0229a c;

        /* renamed from: d  reason: collision with root package name */
        private d f5977d;

        /* renamed from: e  reason: collision with root package name */
        private volatile boolean f5978e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f5979f;

        /* renamed from: g  reason: collision with root package name */
        private T f5980g;

        /* renamed from: h  reason: collision with root package name */
        private int f5981h;

        public e(b<T> bVar, com.pinguo.album.d<T> dVar) {
            this.a = bVar;
            this.b = dVar;
        }

        private boolean c(d dVar) {
            while (true) {
                synchronized (this) {
                    if (this.f5978e) {
                        this.f5977d = null;
                        return false;
                    }
                    this.f5977d = dVar;
                    synchronized (dVar) {
                        int i2 = dVar.a;
                        if (i2 > 0) {
                            dVar.a = i2 - 1;
                            synchronized (this) {
                                this.f5977d = null;
                            }
                            return true;
                        }
                        try {
                            dVar.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }

        private d d(int i2) {
            if (i2 == 1) {
                return a.this.a;
            }
            if (i2 == 2) {
                return a.this.b;
            }
            return null;
        }

        private void e(d dVar) {
            synchronized (dVar) {
                dVar.a++;
                dVar.notifyAll();
            }
        }

        @Override // com.pinguo.album.a.c
        public synchronized void a(InterfaceC0229a interfaceC0229a) {
            InterfaceC0229a interfaceC0229a2;
            this.c = interfaceC0229a;
            if (this.f5978e && (interfaceC0229a2 = this.c) != null) {
                interfaceC0229a2.onCancel();
            }
        }

        @Override // com.pinguo.album.a.c
        public boolean b(int i2) {
            d d2 = d(this.f5981h);
            if (d2 != null) {
                e(d2);
            }
            this.f5981h = 0;
            d d3 = d(i2);
            if (d3 != null) {
                if (c(d3)) {
                    this.f5981h = i2;
                    return true;
                }
                return false;
            }
            return true;
        }

        @Override // com.pinguo.album.c
        public synchronized void cancel() {
            if (this.f5978e) {
                return;
            }
            this.f5978e = true;
            d dVar = this.f5977d;
            if (dVar != null) {
                synchronized (dVar) {
                    this.f5977d.notifyAll();
                }
            }
            InterfaceC0229a interfaceC0229a = this.c;
            if (interfaceC0229a != null) {
                interfaceC0229a.onCancel();
            }
        }

        @Override // com.pinguo.album.c
        public synchronized T get() {
            while (!this.f5979f) {
                try {
                    wait();
                } catch (Exception e2) {
                    us.pinguo.common.log.a.s("ingore exception", e2);
                }
            }
            return this.f5980g;
        }

        @Override // com.pinguo.album.c, com.pinguo.album.a.c
        public boolean isCancelled() {
            return this.f5978e;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                r0 = 1
                boolean r1 = r5.b(r0)
                r2 = 0
                if (r1 == 0) goto L19
                com.pinguo.album.a$b<T> r1 = r5.a     // Catch: java.lang.Throwable -> Lf
                java.lang.Object r1 = r1.a(r5)     // Catch: java.lang.Throwable -> Lf
                goto L1a
            Lf:
                r1 = move-exception
                java.lang.String r3 = "Exception in running a job"
                java.lang.Object[] r4 = new java.lang.Object[r0]
                r4[r2] = r1
                us.pinguo.common.log.a.s(r3, r4)
            L19:
                r1 = 0
            L1a:
                monitor-enter(r5)
                r5.b(r2)     // Catch: java.lang.Throwable -> L2e
                r5.f5980g = r1     // Catch: java.lang.Throwable -> L2e
                r5.f5979f = r0     // Catch: java.lang.Throwable -> L2e
                r5.notifyAll()     // Catch: java.lang.Throwable -> L2e
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L2e
                com.pinguo.album.d<T> r0 = r5.b
                if (r0 == 0) goto L2d
                r0.b(r5)
            L2d:
                return
            L2e:
                r0 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L2e
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pinguo.album.a.e.run():void");
        }
    }

    public a() {
        this(4, 8);
    }

    public <T> com.pinguo.album.c<T> a(b<T> bVar) {
        return b(bVar, null);
    }

    public <T> com.pinguo.album.c<T> b(b<T> bVar, com.pinguo.album.d<T> dVar) {
        e eVar = new e(bVar, dVar);
        this.c.execute(eVar);
        return eVar;
    }

    public a(int i2, int i3) {
        this.a = new d(2);
        this.b = new d(2);
        this.c = new ThreadPoolExecutor(i2, i3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new f("thread-pool", 10));
    }
}
