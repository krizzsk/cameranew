package com.bytedance.sdk.adnet.core;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.face.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CacheDispatcher.java */
/* loaded from: classes.dex */
public class d extends Thread {
    private static final boolean a = o.a;
    private final BlockingQueue<Request<?>> b;
    private final BlockingQueue<Request<?>> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.a f1230d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.c f1231e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f1232f = false;

    /* renamed from: g  reason: collision with root package name */
    private final a f1233g = new a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CacheDispatcher.java */
    /* loaded from: classes.dex */
    public static class a implements Request.a {
        private final Map<String, List<Request<?>>> a = new HashMap();
        private final d b;

        a(d dVar) {
            this.b = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(Request<?> request) {
            String cacheKey = request.getCacheKey();
            if (this.a.containsKey(cacheKey)) {
                List<Request<?>> list = this.a.get(cacheKey);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.addMarker("waiting-for-response");
                list.add(request);
                this.a.put(cacheKey, list);
                if (o.a) {
                    o.b("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                }
                return true;
            }
            this.a.put(cacheKey, null);
            request.a(this);
            if (o.a) {
                o.b("new request, sending to network %s", cacheKey);
            }
            return false;
        }

        @Override // com.bytedance.sdk.adnet.core.Request.a
        public void a(Request<?> request, m<?> mVar) {
            List<Request<?>> remove;
            a.C0044a c0044a = mVar.b;
            if (c0044a != null && !c0044a.a()) {
                String cacheKey = request.getCacheKey();
                synchronized (this) {
                    remove = this.a.remove(cacheKey);
                }
                if (remove != null) {
                    if (o.a) {
                        o.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                    }
                    for (Request<?> request2 : remove) {
                        this.b.f1231e.a(request2, mVar);
                    }
                    return;
                }
                return;
            }
            a(request);
        }

        @Override // com.bytedance.sdk.adnet.core.Request.a
        public synchronized void a(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> remove = this.a.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (o.a) {
                    o.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request<?> remove2 = remove.remove(0);
                this.a.put(cacheKey, remove);
                remove2.a(this);
                try {
                    this.b.c.put(remove2);
                } catch (InterruptedException e2) {
                    o.c("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.b.a();
                }
            }
        }
    }

    public d(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.c cVar) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.f1230d = aVar;
        this.f1231e = cVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (a) {
            o.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f1230d.a();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f1232f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                o.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        a(this.b.take());
    }

    public void a() {
        this.f1232f = true;
        interrupt();
    }

    @VisibleForTesting
    void a(final Request<?> request) throws InterruptedException {
        request.addMarker("cache-queue-take");
        request.a(1);
        try {
        } finally {
            try {
            } finally {
            }
        }
        if (request.isCanceled()) {
            request.a("cache-discard-canceled");
            return;
        }
        a.C0044a a2 = this.f1230d.a(request.getCacheKey());
        if (a2 == null) {
            request.addMarker("cache-miss");
            if (!this.f1233g.b(request)) {
                this.c.put(request);
            }
        } else if (a2.a()) {
            request.addMarker("cache-hit-expired");
            request.setCacheEntry(a2);
            if (!this.f1233g.b(request)) {
                this.c.put(request);
            }
        } else {
            request.addMarker("cache-hit");
            m<?> a3 = request.a(new i(a2.b, a2.f1265h));
            request.addMarker("cache-hit-parsed");
            if (!a2.b()) {
                this.f1231e.a(request, a3);
            } else {
                request.addMarker("cache-hit-refresh-needed");
                request.setCacheEntry(a2);
                a3.f1254d = true;
                if (!this.f1233g.b(request)) {
                    this.f1231e.a(request, a3, new Runnable() { // from class: com.bytedance.sdk.adnet.core.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                d.this.c.put(request);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    });
                } else {
                    this.f1231e.a(request, a3);
                }
            }
        }
    }
}
