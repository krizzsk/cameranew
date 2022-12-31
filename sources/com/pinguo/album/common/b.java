package com.pinguo.album.common;

import com.pinguo.album.a;
import java.util.LinkedList;
/* compiled from: JobLimiter.java */
/* loaded from: classes3.dex */
public class b implements com.pinguo.album.d {
    private final LinkedList<a<?>> a = new LinkedList<>();
    private final com.pinguo.album.a b;
    private int c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobLimiter.java */
    /* loaded from: classes3.dex */
    public static class a<T> implements com.pinguo.album.c<T>, a.b<T> {
        private int a = 0;
        private a.b<T> b;
        private com.pinguo.album.c<T> c;

        /* renamed from: d  reason: collision with root package name */
        private com.pinguo.album.d<T> f6019d;

        /* renamed from: e  reason: collision with root package name */
        private T f6020e;

        public a(a.b<T> bVar, com.pinguo.album.d<T> dVar) {
            this.b = bVar;
            this.f6019d = dVar;
        }

        @Override // com.pinguo.album.a.b
        public T a(a.c cVar) {
            T t;
            synchronized (this) {
                if (this.a == 2) {
                    return null;
                }
                a.b<T> bVar = this.b;
                try {
                    t = bVar.a(cVar);
                } catch (Throwable th) {
                    us.pinguo.common.log.a.s("error executing job: " + bVar, th);
                    t = null;
                }
                synchronized (this) {
                    if (this.a == 2) {
                        return null;
                    }
                    this.a = 1;
                    com.pinguo.album.d<T> dVar = this.f6019d;
                    this.f6019d = null;
                    this.b = null;
                    this.f6020e = t;
                    notifyAll();
                    if (dVar != null) {
                        dVar.b(this);
                    }
                    return t;
                }
            }
        }

        public synchronized void b(com.pinguo.album.c<T> cVar) {
            if (this.a != 0) {
                return;
            }
            this.c = cVar;
        }

        @Override // com.pinguo.album.c
        public void cancel() {
            com.pinguo.album.d<T> dVar;
            synchronized (this) {
                if (this.a != 1) {
                    dVar = this.f6019d;
                    this.b = null;
                    this.f6019d = null;
                    com.pinguo.album.c<T> cVar = this.c;
                    if (cVar != null) {
                        cVar.cancel();
                        this.c = null;
                    }
                } else {
                    dVar = null;
                }
                this.a = 2;
                this.f6020e = null;
                notifyAll();
            }
            if (dVar != null) {
                dVar.b(this);
            }
        }

        @Override // com.pinguo.album.c
        public synchronized T get() {
            while (this.a == 0) {
                com.pinguo.album.j.a.r(this);
            }
            return this.f6020e;
        }

        @Override // com.pinguo.album.c, com.pinguo.album.a.c
        public synchronized boolean isCancelled() {
            return this.a == 2;
        }
    }

    public b(com.pinguo.album.a aVar, int i2) {
        com.pinguo.album.j.a.c(aVar);
        this.b = aVar;
        this.c = i2;
    }

    private void c() {
        while (this.c > 0 && !this.a.isEmpty()) {
            a<?> removeFirst = this.a.removeFirst();
            if (!removeFirst.isCancelled()) {
                this.c--;
                removeFirst.b(this.b.b(removeFirst, this));
            }
        }
    }

    public synchronized <T> com.pinguo.album.c<T> a(a.b<T> bVar, com.pinguo.album.d<T> dVar) {
        a<?> aVar;
        com.pinguo.album.j.a.c(bVar);
        aVar = new a<>(bVar, dVar);
        this.a.addLast(aVar);
        c();
        return aVar;
    }

    @Override // com.pinguo.album.d
    public synchronized void b(com.pinguo.album.c cVar) {
        this.c++;
        c();
    }
}
