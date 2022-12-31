package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: HttpProxyCacheServerClients.java */
/* loaded from: classes.dex */
final class f {
    private final AtomicInteger a = new AtomicInteger(0);
    private final String b;
    private volatile e c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b> f2221d;

    /* renamed from: e  reason: collision with root package name */
    private final b f2222e;

    /* renamed from: f  reason: collision with root package name */
    private final c f2223f;

    /* compiled from: HttpProxyCacheServerClients.java */
    /* loaded from: classes.dex */
    private static final class a extends Handler implements b {
        private final String a;
        private final List<b> b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.a = str;
            this.b = list;
        }

        @Override // com.danikula.videocache.b
        public void a(File file, String str, int i2) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i2;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (b bVar : this.b) {
                bVar.a((File) message.obj, this.a, message.arg1);
            }
        }
    }

    public f(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f2221d = copyOnWriteArrayList;
        j.d(str);
        this.b = str;
        j.d(cVar);
        this.f2223f = cVar;
        this.f2222e = new a(str, copyOnWriteArrayList);
    }

    private synchronized void a() {
        if (this.a.decrementAndGet() <= 0) {
            this.c.m();
            this.c = null;
        }
    }

    private e c() throws ProxyCacheException {
        String str = this.b;
        c cVar = this.f2223f;
        e eVar = new e(new g(str, cVar.f2214d, cVar.f2215e), new com.danikula.videocache.p.b(this.f2223f.a(this.b), this.f2223f.c));
        eVar.t(this.f2222e);
        return eVar;
    }

    private synchronized void e() throws ProxyCacheException {
        this.c = this.c == null ? c() : this.c;
    }

    public int b() {
        return this.a.get();
    }

    public void d(d dVar, Socket socket) throws ProxyCacheException, IOException {
        e();
        try {
            this.a.incrementAndGet();
            this.c.s(dVar, socket);
        } finally {
            a();
        }
    }
}
