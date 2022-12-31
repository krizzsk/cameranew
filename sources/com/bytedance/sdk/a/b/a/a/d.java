package com.bytedance.sdk.a.b.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class d implements Closeable, Flushable {
    final com.bytedance.sdk.a.b.a.f.a b;
    final int c;

    /* renamed from: d  reason: collision with root package name */
    com.bytedance.sdk.a.a.d f873d;

    /* renamed from: e  reason: collision with root package name */
    final LinkedHashMap<String, b> f874e;

    /* renamed from: f  reason: collision with root package name */
    int f875f;

    /* renamed from: g  reason: collision with root package name */
    boolean f876g;

    /* renamed from: h  reason: collision with root package name */
    boolean f877h;

    /* renamed from: i  reason: collision with root package name */
    boolean f878i;

    /* renamed from: k  reason: collision with root package name */
    private long f879k;

    /* renamed from: l  reason: collision with root package name */
    private long f880l;
    private long m;
    private final Executor n;
    private final Runnable o;

    /* renamed from: j  reason: collision with root package name */
    static final /* synthetic */ boolean f872j = true;
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class a {
        final b a;
        final boolean[] b;
        final /* synthetic */ d c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f881d;

        void a() {
            if (this.a.f884f != this) {
                return;
            }
            int i2 = 0;
            while (true) {
                d dVar = this.c;
                if (i2 < dVar.c) {
                    try {
                        dVar.b.a(this.a.f882d[i2]);
                    } catch (IOException unused) {
                    }
                    i2++;
                } else {
                    this.a.f884f = null;
                    return;
                }
            }
        }

        public void b() throws IOException {
            synchronized (this.c) {
                if (!this.f881d) {
                    if (this.a.f884f == this) {
                        this.c.a(this, false);
                    }
                    this.f881d = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class b {
        final String a;
        final long[] b;
        final File[] c;

        /* renamed from: d  reason: collision with root package name */
        final File[] f882d;

        /* renamed from: e  reason: collision with root package name */
        boolean f883e;

        /* renamed from: f  reason: collision with root package name */
        a f884f;

        /* renamed from: g  reason: collision with root package name */
        long f885g;

        void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
            for (long j2 : this.b) {
                dVar.i(32).l(j2);
            }
        }
    }

    private synchronized void d() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    synchronized void a(a aVar, boolean z) throws IOException {
        b bVar = aVar.a;
        if (bVar.f884f == aVar) {
            if (z && !bVar.f883e) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (aVar.b[i2]) {
                        if (!this.b.b(bVar.f882d[i2])) {
                            aVar.b();
                            return;
                        }
                    } else {
                        aVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.c; i3++) {
                File file = bVar.f882d[i3];
                if (z) {
                    if (this.b.b(file)) {
                        File file2 = bVar.c[i3];
                        this.b.a(file, file2);
                        long j2 = bVar.b[i3];
                        long c = this.b.c(file2);
                        bVar.b[i3] = c;
                        this.f880l = (this.f880l - j2) + c;
                    }
                } else {
                    this.b.a(file);
                }
            }
            this.f875f++;
            bVar.f884f = null;
            if (bVar.f883e | z) {
                bVar.f883e = true;
                this.f873d.b("CLEAN").i(32);
                this.f873d.b(bVar.a);
                bVar.a(this.f873d);
                this.f873d.i(10);
                if (z) {
                    long j3 = this.m;
                    this.m = 1 + j3;
                    bVar.f885g = j3;
                }
            } else {
                this.f874e.remove(bVar.a);
                this.f873d.b("REMOVE").i(32);
                this.f873d.b(bVar.a);
                this.f873d.i(10);
            }
            this.f873d.flush();
            if (this.f880l > this.f879k || a()) {
                this.n.execute(this.o);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public synchronized boolean b() {
        return this.f877h;
    }

    void c() throws IOException {
        while (this.f880l > this.f879k) {
            a(this.f874e.values().iterator().next());
        }
        this.f878i = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f876g && !this.f877h) {
            for (b bVar : (b[]) this.f874e.values().toArray(new b[this.f874e.size()])) {
                a aVar = bVar.f884f;
                if (aVar != null) {
                    aVar.b();
                }
            }
            c();
            this.f873d.close();
            this.f873d = null;
            this.f877h = true;
            return;
        }
        this.f877h = true;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f876g) {
            d();
            c();
            this.f873d.flush();
        }
    }

    boolean a() {
        int i2 = this.f875f;
        return i2 >= 2000 && i2 >= this.f874e.size();
    }

    boolean a(b bVar) throws IOException {
        a aVar = bVar.f884f;
        if (aVar != null) {
            aVar.a();
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            this.b.a(bVar.c[i2]);
            long j2 = this.f880l;
            long[] jArr = bVar.b;
            this.f880l = j2 - jArr[i2];
            jArr[i2] = 0;
        }
        this.f875f++;
        this.f873d.b("REMOVE").i(32).b(bVar.a).i(10);
        this.f874e.remove(bVar.a);
        if (a()) {
            this.n.execute(this.o);
        }
        return true;
    }
}
