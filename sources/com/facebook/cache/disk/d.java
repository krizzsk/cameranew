package com.facebook.cache.disk;

import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.disk.c;
import com.facebook.common.statfs.StatFsHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: DiskStorageCache.java */
@ThreadSafe
/* loaded from: classes.dex */
public class d implements h, com.facebook.common.disk.a {
    private static final Class<?> q = d.class;
    private static final long r = TimeUnit.HOURS.toMillis(2);
    private static final long s = TimeUnit.MINUTES.toMillis(30);
    private final long a;
    private final long b;
    private final CountDownLatch c;

    /* renamed from: d  reason: collision with root package name */
    private long f2379d;

    /* renamed from: e  reason: collision with root package name */
    private final CacheEventListener f2380e;
    @GuardedBy("mLock")
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    final Set<String> f2381f;

    /* renamed from: g  reason: collision with root package name */
    private long f2382g;

    /* renamed from: h  reason: collision with root package name */
    private final StatFsHelper f2383h;

    /* renamed from: i  reason: collision with root package name */
    private final com.facebook.cache.disk.c f2384i;

    /* renamed from: j  reason: collision with root package name */
    private final g f2385j;

    /* renamed from: k  reason: collision with root package name */
    private final CacheErrorLogger f2386k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f2387l;
    private final b m;
    private final com.facebook.common.time.a n;
    private final Object o = new Object();
    private boolean p;

    /* compiled from: DiskStorageCache.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this.o) {
                d.this.o();
            }
            d.this.p = true;
            d.this.c.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskStorageCache.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b {
        private boolean a = false;
        private long b = -1;
        private long c = -1;

        b() {
        }

        public synchronized long a() {
            return this.c;
        }

        public synchronized long b() {
            return this.b;
        }

        public synchronized void c(long j2, long j3) {
            if (this.a) {
                this.b += j2;
                this.c += j3;
            }
        }

        public synchronized boolean d() {
            return this.a;
        }

        public synchronized void e() {
            this.a = false;
            this.c = -1L;
            this.b = -1L;
        }

        public synchronized void f(long j2, long j3) {
            this.c = j3;
            this.b = j2;
            this.a = true;
        }
    }

    /* compiled from: DiskStorageCache.java */
    /* loaded from: classes.dex */
    public static class c {
        public final long a;
        public final long b;
        public final long c;

        public c(long j2, long j3, long j4) {
            this.a = j2;
            this.b = j3;
            this.c = j4;
        }
    }

    public d(com.facebook.cache.disk.c cVar, g gVar, c cVar2, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.disk.b bVar, Executor executor, boolean z) {
        this.a = cVar2.b;
        long j2 = cVar2.c;
        this.b = j2;
        this.f2379d = j2;
        this.f2383h = StatFsHelper.getInstance();
        this.f2384i = cVar;
        this.f2385j = gVar;
        this.f2382g = -1L;
        this.f2380e = cacheEventListener;
        long j3 = cVar2.a;
        this.f2386k = cacheErrorLogger;
        this.m = new b();
        this.n = com.facebook.common.time.c.a();
        this.f2387l = z;
        this.f2381f = new HashSet();
        if (bVar != null) {
            bVar.a(this);
        }
        if (z) {
            this.c = new CountDownLatch(1);
            executor.execute(new a());
            return;
        }
        this.c = new CountDownLatch(0);
    }

    private com.facebook.binaryresource.a k(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.binaryresource.a D;
        synchronized (this.o) {
            D = bVar.D(bVar2);
            this.f2381f.add(str);
            this.m.c(D.size(), 1L);
        }
        return D;
    }

    @GuardedBy("mLock")
    private void l(long j2, CacheEventListener.EvictionReason evictionReason) throws IOException {
        try {
            Collection<c.a> m = m(this.f2384i.g());
            long b2 = this.m.b();
            long j3 = b2 - j2;
            int i2 = 0;
            long j4 = 0;
            for (c.a aVar : m) {
                if (j4 > j3) {
                    break;
                }
                long c2 = this.f2384i.c(aVar);
                this.f2381f.remove(aVar.getId());
                if (c2 > 0) {
                    i2++;
                    j4 += c2;
                    i a2 = i.a();
                    a2.j(aVar.getId());
                    a2.g(evictionReason);
                    a2.i(c2);
                    a2.f(b2 - j4);
                    a2.e(j2);
                    this.f2380e.e(a2);
                    a2.b();
                }
            }
            this.m.c(-j4, -i2);
            this.f2384i.a();
        } catch (IOException e2) {
            CacheErrorLogger cacheErrorLogger = this.f2386k;
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
            Class<?> cls = q;
            cacheErrorLogger.a(cacheErrorCategory, cls, "evictAboveSize: " + e2.getMessage(), e2);
            throw e2;
        }
    }

    private Collection<c.a> m(Collection<c.a> collection) {
        long now = this.n.now() + r;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.a() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.f2385j.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private void n() throws IOException {
        synchronized (this.o) {
            boolean o = o();
            r();
            long b2 = this.m.b();
            if (b2 > this.f2379d && !o) {
                this.m.e();
                o();
            }
            long j2 = this.f2379d;
            if (b2 > j2) {
                l((j2 * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public boolean o() {
        long now = this.n.now();
        if (this.m.d()) {
            long j2 = this.f2382g;
            if (j2 != -1 && now - j2 <= s) {
                return false;
            }
        }
        return p();
    }

    @GuardedBy("mLock")
    private boolean p() {
        Set<String> hashSet;
        long j2;
        long now = this.n.now();
        long j3 = r + now;
        if (this.f2387l && this.f2381f.isEmpty()) {
            hashSet = this.f2381f;
        } else {
            hashSet = this.f2387l ? new HashSet<>() : null;
        }
        try {
            long j4 = 0;
            long j5 = -1;
            int i2 = 0;
            boolean z = false;
            int i3 = 0;
            int i4 = 0;
            for (c.a aVar : this.f2384i.g()) {
                i3++;
                j4 += aVar.getSize();
                if (aVar.a() > j3) {
                    i4++;
                    i2 = (int) (i2 + aVar.getSize());
                    j2 = j3;
                    j5 = Math.max(aVar.a() - now, j5);
                    z = true;
                } else {
                    j2 = j3;
                    if (this.f2387l) {
                        com.facebook.common.internal.h.g(hashSet);
                        hashSet.add(aVar.getId());
                    }
                }
                j3 = j2;
            }
            if (z) {
                this.f2386k.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, q, "Future timestamp found in " + i4 + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j5 + "ms", null);
            }
            long j6 = i3;
            if (this.m.a() != j6 || this.m.b() != j4) {
                if (this.f2387l && this.f2381f != hashSet) {
                    com.facebook.common.internal.h.g(hashSet);
                    this.f2381f.clear();
                    this.f2381f.addAll(hashSet);
                }
                this.m.f(j4, j6);
            }
            this.f2382g = now;
            return true;
        } catch (IOException e2) {
            this.f2386k.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, q, "calcFileCacheSize: " + e2.getMessage(), e2);
            return false;
        }
    }

    private c.b q(String str, com.facebook.cache.common.b bVar) throws IOException {
        n();
        return this.f2384i.d(str, bVar);
    }

    @GuardedBy("mLock")
    private void r() {
        if (this.f2383h.e(this.f2384i.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.b - this.m.b())) {
            this.f2379d = this.a;
        } else {
            this.f2379d = this.b;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean a(com.facebook.cache.common.b bVar) {
        String str;
        IOException e2;
        String str2 = null;
        try {
            try {
                synchronized (this.o) {
                    try {
                        List<String> b2 = com.facebook.cache.common.c.b(bVar);
                        int i2 = 0;
                        while (i2 < b2.size()) {
                            String str3 = b2.get(i2);
                            if (this.f2384i.b(str3, bVar)) {
                                this.f2381f.add(str3);
                                return true;
                            }
                            i2++;
                            str2 = str3;
                        }
                        return false;
                    } catch (Throwable th) {
                        str = str2;
                        th = th;
                        try {
                            throw th;
                        } catch (IOException e3) {
                            e2 = e3;
                            i a2 = i.a();
                            a2.d(bVar);
                            a2.j(str);
                            a2.h(e2);
                            this.f2380e.c(a2);
                            a2.b();
                            return false;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            str = null;
            e2 = e4;
        }
    }

    @Override // com.facebook.cache.disk.h
    @Nullable
    public com.facebook.binaryresource.a b(com.facebook.cache.common.b bVar) {
        com.facebook.binaryresource.a aVar;
        i a2 = i.a();
        a2.d(bVar);
        try {
            synchronized (this.o) {
                List<String> b2 = com.facebook.cache.common.c.b(bVar);
                String str = null;
                aVar = null;
                for (int i2 = 0; i2 < b2.size(); i2++) {
                    str = b2.get(i2);
                    a2.j(str);
                    aVar = this.f2384i.f(str, bVar);
                    if (aVar != null) {
                        break;
                    }
                }
                if (aVar == null) {
                    this.f2380e.a(a2);
                    this.f2381f.remove(str);
                } else {
                    com.facebook.common.internal.h.g(str);
                    this.f2380e.g(a2);
                    this.f2381f.add(str);
                }
            }
            return aVar;
        } catch (IOException e2) {
            this.f2386k.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, q, "getResource", e2);
            a2.h(e2);
            this.f2380e.c(a2);
            return null;
        } finally {
            a2.b();
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean c(com.facebook.cache.common.b bVar) {
        synchronized (this.o) {
            List<String> b2 = com.facebook.cache.common.c.b(bVar);
            for (int i2 = 0; i2 < b2.size(); i2++) {
                if (this.f2381f.contains(b2.get(i2))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.facebook.cache.disk.h
    public void d(com.facebook.cache.common.b bVar) {
        synchronized (this.o) {
            try {
                List<String> b2 = com.facebook.cache.common.c.b(bVar);
                for (int i2 = 0; i2 < b2.size(); i2++) {
                    String str = b2.get(i2);
                    this.f2384i.remove(str);
                    this.f2381f.remove(str);
                }
            } catch (IOException e2) {
                CacheErrorLogger cacheErrorLogger = this.f2386k;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.DELETE_FILE;
                Class<?> cls = q;
                cacheErrorLogger.a(cacheErrorCategory, cls, "delete: " + e2.getMessage(), e2);
            }
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.o) {
            if (c(bVar)) {
                return true;
            }
            try {
                List<String> b2 = com.facebook.cache.common.c.b(bVar);
                for (int i2 = 0; i2 < b2.size(); i2++) {
                    String str = b2.get(i2);
                    if (this.f2384i.e(str, bVar)) {
                        this.f2381f.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.binaryresource.a f(com.facebook.cache.common.b bVar, com.facebook.cache.common.f fVar) throws IOException {
        String a2;
        i a3 = i.a();
        a3.d(bVar);
        this.f2380e.d(a3);
        synchronized (this.o) {
            a2 = com.facebook.cache.common.c.a(bVar);
        }
        a3.j(a2);
        try {
            try {
                c.b q2 = q(a2, bVar);
                try {
                    q2.C(fVar, bVar);
                    com.facebook.binaryresource.a k2 = k(q2, bVar, a2);
                    a3.i(k2.size());
                    a3.f(this.m.b());
                    this.f2380e.b(a3);
                    return k2;
                } finally {
                    if (!q2.B()) {
                        com.facebook.common.logging.a.d(q, "Failed to delete temp file");
                    }
                }
            } catch (IOException e2) {
                a3.h(e2);
                this.f2380e.f(a3);
                com.facebook.common.logging.a.e(q, "Failed inserting a file into the cache", e2);
                throw e2;
            }
        } finally {
            a3.b();
        }
    }
}
