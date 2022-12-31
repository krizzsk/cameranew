package com.bytedance.sdk.openadsdk.h;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.h.b;
import com.bytedance.sdk.openadsdk.h.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: Preloader.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    private static volatile d f2021e;
    private volatile int a = 163840;
    private final SparseArray<Map<String, com.bytedance.sdk.openadsdk.h.b>> b;
    private final b<Runnable> c;

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f2022d;

    /* renamed from: f  reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.h.b.c f2023f;

    /* renamed from: g  reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.h.a.c f2024g;

    /* renamed from: h  reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.h.a.b f2025h;

    /* renamed from: i  reason: collision with root package name */
    private final HashSet<a> f2026i;

    /* renamed from: j  reason: collision with root package name */
    private final b.InterfaceC0061b f2027j;

    /* renamed from: k  reason: collision with root package name */
    private volatile c f2028k;

    /* renamed from: l  reason: collision with root package name */
    private volatile c f2029l;
    private volatile String m;
    private volatile boolean n;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Preloader.java */
    /* loaded from: classes.dex */
    public static final class a {
        final boolean a;
        final boolean b;
        final int c;

        /* renamed from: d  reason: collision with root package name */
        final String f2031d;

        /* renamed from: e  reason: collision with root package name */
        final Map<String, String> f2032e;

        /* renamed from: f  reason: collision with root package name */
        final String[] f2033f;

        a(boolean z, boolean z2, int i2, String str, Map<String, String> map, String[] strArr) {
            this.a = z;
            this.b = z2;
            this.c = i2;
            this.f2031d = str;
            this.f2032e = map;
            this.f2033f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a == aVar.a && this.b == aVar.b && this.c == aVar.c) {
                return this.f2031d.equals(aVar.f2031d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + this.c) * 31) + this.f2031d.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Preloader.java */
    /* loaded from: classes.dex */
    public static final class b<T> extends LinkedBlockingDeque<T> {
        private ThreadPoolExecutor a;

        private b() {
        }

        public void a(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.a != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor != null) {
                    this.a = threadPoolExecutor;
                } else {
                    throw new NullPointerException("executor argument can't be null!");
                }
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.a.getPoolSize();
                int activeCount = this.a.getActiveCount();
                int maximumPoolSize = this.a.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    if (e.c) {
                        Log.i("TAG_PROXY_TT", "create new preloader thread");
                    }
                    return false;
                }
                return offerFirst(t);
            }
        }
    }

    private d() {
        SparseArray<Map<String, com.bytedance.sdk.openadsdk.h.b>> sparseArray = new SparseArray<>(2);
        this.b = sparseArray;
        this.f2026i = new HashSet<>();
        this.f2027j = new b.InterfaceC0061b() { // from class: com.bytedance.sdk.openadsdk.h.d.1
            @Override // com.bytedance.sdk.openadsdk.h.b.InterfaceC0061b
            public void a(com.bytedance.sdk.openadsdk.h.b bVar) {
                int f2 = bVar.f();
                synchronized (d.this.b) {
                    Map map = (Map) d.this.b.get(f2);
                    if (map != null) {
                        map.remove(bVar.f1996h);
                    }
                }
                if (e.c) {
                    Log.d("TAG_PROXY_Preloader", "afterExecute, key: " + bVar.f1996h);
                }
            }
        };
        b<Runnable> bVar = new b<>();
        this.c = bVar;
        ExecutorService a2 = a(bVar);
        this.f2022d = a2;
        bVar.a((ThreadPoolExecutor) a2);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    public static d c() {
        if (f2021e == null) {
            synchronized (d.class) {
                if (f2021e == null) {
                    f2021e = new d();
                }
            }
        }
        return f2021e;
    }

    public void d() {
        com.bytedance.sdk.openadsdk.h.g.d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.d.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bytedance.sdk.openadsdk.h.b> arrayList = new ArrayList();
                synchronized (d.this.b) {
                    int size = d.this.b.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        Map map = (Map) d.this.b.get(d.this.b.keyAt(i2));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    d.this.c.clear();
                }
                for (com.bytedance.sdk.openadsdk.h.b bVar : arrayList) {
                    bVar.a();
                    if (e.c) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + bVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.h.a.c cVar) {
        this.f2024g = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b() {
        return this.f2029l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.h.b.c cVar) {
        this.f2023f = cVar;
    }

    public void a(int i2) {
        if (i2 > 0) {
            this.a = i2;
        }
        if (e.c) {
            Log.i("TAG_PROXY_Preloader", "MaxPreloadSize: " + i2);
        }
    }

    public synchronized void a(long j2, long j3, long j4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a() {
        return this.f2028k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, String str) {
        com.bytedance.sdk.openadsdk.h.b remove;
        this.m = str;
        this.n = z;
        if (e.c) {
            Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, " + str);
        }
        HashSet hashSet = null;
        HashSet hashSet2 = null;
        if (str == null) {
            synchronized (this.f2026i) {
                if (!this.f2026i.isEmpty()) {
                    hashSet2 = new HashSet(this.f2026i);
                    this.f2026i.clear();
                }
            }
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    a(aVar.a, aVar.b, aVar.c, aVar.f2031d, aVar.f2032e, aVar.f2033f);
                    if (e.c) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + aVar.f2031d);
                    }
                }
                return;
            }
            return;
        }
        int i2 = e.f2038h;
        if (i2 != 3 && i2 != 2) {
            if (i2 == 1) {
                synchronized (this.b) {
                    Map<String, com.bytedance.sdk.openadsdk.h.b> map = this.b.get(com.bytedance.sdk.openadsdk.h.b.b.a(z));
                    remove = map != null ? map.remove(str) : null;
                }
                if (remove != null) {
                    remove.a();
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.b) {
            int size = this.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                SparseArray<Map<String, com.bytedance.sdk.openadsdk.h.b>> sparseArray = this.b;
                Map<String, com.bytedance.sdk.openadsdk.h.b> map2 = sparseArray.get(sparseArray.keyAt(i3));
                if (map2 != null) {
                    Collection<com.bytedance.sdk.openadsdk.h.b> values = map2.values();
                    if (values != null && !values.isEmpty()) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.addAll(values);
                    }
                    map2.clear();
                }
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            com.bytedance.sdk.openadsdk.h.b bVar = (com.bytedance.sdk.openadsdk.h.b) it2.next();
            bVar.a();
            if (e.c) {
                Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + bVar.f1995g);
            }
        }
        if (i2 == 3) {
            synchronized (this.f2026i) {
                Iterator it3 = hashSet.iterator();
                while (it3.hasNext()) {
                    a aVar2 = (a) ((com.bytedance.sdk.openadsdk.h.b) it3.next()).n;
                    if (aVar2 != null) {
                        this.f2026i.add(aVar2);
                    }
                }
            }
        }
    }

    public void a(boolean z, boolean z2, int i2, String str, String... strArr) {
        a(z, z2, i2, str, null, strArr);
    }

    public void a(boolean z, boolean z2, int i2, String str, Map<String, String> map, String... strArr) {
        boolean z3 = e.c;
        if (z3) {
            Log.d("TAG_PROXY_Preloader", "preload start ！！！！");
        }
        com.bytedance.sdk.openadsdk.h.a.a aVar = z ? this.f2025h : this.f2024g;
        com.bytedance.sdk.openadsdk.h.b.c cVar = this.f2023f;
        if (aVar == null || cVar == null) {
            if (z3) {
                Log.e("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
            }
        } else if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            int i3 = i2 <= 0 ? this.a : i2;
            String a2 = z2 ? str : com.bytedance.sdk.openadsdk.h.g.b.a(str);
            File d2 = aVar.d(a2);
            if (d2 != null && d2.length() >= i3) {
                if (z3) {
                    Log.i("TAG_PROXY_Preloader", "no need preload, file size: " + d2.length() + ", need preload size: " + i3);
                }
            } else if (f.a().a(com.bytedance.sdk.openadsdk.h.b.b.a(z), a2)) {
                if (z3) {
                    Log.w("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: " + str);
                }
            } else {
                synchronized (this.b) {
                    try {
                        try {
                            Map<String, com.bytedance.sdk.openadsdk.h.b> map2 = this.b.get(z ? 1 : 0);
                            if (map2.containsKey(a2)) {
                                return;
                            }
                            int i4 = i3;
                            a aVar2 = new a(z, z2, i3, str, map, strArr);
                            String str2 = this.m;
                            if (str2 != null) {
                                int i5 = e.f2038h;
                                if (i5 == 3) {
                                    synchronized (this.f2026i) {
                                        this.f2026i.add(aVar2);
                                    }
                                    if (z3) {
                                        Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                                    }
                                    return;
                                } else if (i5 == 2) {
                                    if (z3) {
                                        Log.w("TAG_PROXY_Preloader", "cancel preload: " + str);
                                    }
                                    return;
                                } else if (i5 == 1 && this.n == z && str2.equals(a2)) {
                                    if (z3) {
                                        Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                                    }
                                    return;
                                }
                            }
                            ArrayList arrayList = null;
                            List<i.b> a3 = com.bytedance.sdk.openadsdk.h.g.d.a(com.bytedance.sdk.openadsdk.h.g.d.a(map));
                            if (a3 != null) {
                                arrayList = new ArrayList(a3.size());
                                int size = a3.size();
                                for (int i6 = 0; i6 < size; i6++) {
                                    i.b bVar = a3.get(i6);
                                    if (bVar != null) {
                                        arrayList.add(new i.b(bVar.a, bVar.b));
                                    }
                                }
                            }
                            com.bytedance.sdk.openadsdk.h.b a4 = new b.a().a(aVar).a(cVar).a(str).b(a2).a(new l(com.bytedance.sdk.openadsdk.h.g.d.a(strArr))).a((List<i.b>) arrayList).a(i4).a(this.f2027j).a(aVar2).a();
                            map2.put(a2, a4);
                            this.f2022d.execute(a4);
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
    }

    public void a(String str) {
        a(false, false, str);
    }

    public void a(final boolean z, final boolean z2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.h.g.d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.h.b bVar;
                synchronized (d.this.b) {
                    Map map = (Map) d.this.b.get(com.bytedance.sdk.openadsdk.h.b.b.a(z));
                    if (map != null) {
                        bVar = (com.bytedance.sdk.openadsdk.h.b) map.remove(z2 ? str : com.bytedance.sdk.openadsdk.h.g.b.a(str));
                    } else {
                        bVar = null;
                    }
                }
                if (bVar != null) {
                    bVar.a();
                }
            }
        });
    }

    private static ExecutorService a(final b<Runnable> bVar) {
        int a2 = com.bytedance.sdk.openadsdk.h.g.d.a();
        return new ThreadPoolExecutor(0, a2 < 1 ? 1 : a2 > 4 ? 4 : a2, 60L, TimeUnit.SECONDS, bVar, new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.h.d.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable) { // from class: com.bytedance.sdk.openadsdk.h.d.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        super.run();
                    }
                };
                thread.setName("video-preload-" + thread.getId());
                thread.setDaemon(true);
                if (e.c) {
                    Log.i("TAG_PROXY_Preloader", "new preload thead: " + thread.getName());
                }
                return thread;
            }
        }, new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.h.d.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    b.this.offerFirst(runnable);
                    if (e.c) {
                        Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
