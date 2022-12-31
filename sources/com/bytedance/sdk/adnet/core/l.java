package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: RequestQueue.java */
/* loaded from: classes.dex */
public class l {
    private final AtomicInteger a;
    private final Set<Request<?>> b;
    private final PriorityBlockingQueue<Request<?>> c;

    /* renamed from: d  reason: collision with root package name */
    private final PriorityBlockingQueue<Request<?>> f1246d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.a f1247e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.b f1248f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.c f1249g;

    /* renamed from: h  reason: collision with root package name */
    private final h[] f1250h;

    /* renamed from: i  reason: collision with root package name */
    private d f1251i;

    /* renamed from: j  reason: collision with root package name */
    private final List<b> f1252j;

    /* renamed from: k  reason: collision with root package name */
    private final List<a> f1253k;

    /* compiled from: RequestQueue.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Request<?> request, int i2);
    }

    /* compiled from: RequestQueue.java */
    @Deprecated
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(Request<T> request);
    }

    public l(com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.b bVar, int i2, com.bytedance.sdk.adnet.face.c cVar) {
        this.a = new AtomicInteger();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue<>();
        this.f1246d = new PriorityBlockingQueue<>();
        this.f1252j = new ArrayList();
        this.f1253k = new ArrayList();
        this.f1247e = aVar;
        this.f1248f = bVar;
        this.f1250h = new h[i2];
        this.f1249g = cVar;
    }

    public void a() {
        b();
        d dVar = new d(this.c, this.f1246d, this.f1247e, this.f1249g);
        this.f1251i = dVar;
        dVar.start();
        for (int i2 = 0; i2 < this.f1250h.length; i2++) {
            h hVar = new h(this.f1246d, this.f1248f, this.f1247e, this.f1249g);
            this.f1250h[i2] = hVar;
            hVar.start();
        }
    }

    public void b() {
        h[] hVarArr;
        d dVar = this.f1251i;
        if (dVar != null) {
            dVar.a();
        }
        for (h hVar : this.f1250h) {
            if (hVar != null) {
                hVar.a();
            }
        }
    }

    public int c() {
        return this.a.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void c(Request<T> request) {
        synchronized (this.b) {
            this.b.remove(request);
        }
        synchronized (this.f1252j) {
            for (b bVar : this.f1252j) {
                bVar.a(request);
            }
        }
        a(request, 5);
    }

    public <T> void b(Request<T> request) {
        if (request == null || TextUtils.isEmpty(request.getUrl())) {
            return;
        }
        String url = request.getUrl();
        if (com.bytedance.sdk.adnet.a.d() != null) {
            String a2 = com.bytedance.sdk.adnet.a.d().a(url);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            request.setUrl(a2);
        }
    }

    public <T> Request<T> a(Request<T> request) {
        b(request);
        request.setStartTime();
        request.setRequestQueue(this);
        synchronized (this.b) {
            this.b.add(request);
        }
        request.setSequence(c());
        request.addMarker("add-to-queue");
        a(request, 0);
        if (!request.shouldCache()) {
            this.f1246d.add(request);
            return request;
        }
        this.c.add(request);
        return request;
    }

    public l(com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.b bVar, int i2) {
        this(aVar, bVar, i2, new g(new Handler(Looper.getMainLooper())));
    }

    public l(com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.b bVar) {
        this(aVar, bVar, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Request<?> request, int i2) {
        synchronized (this.f1253k) {
            for (a aVar : this.f1253k) {
                aVar.a(request, i2);
            }
        }
    }
}
