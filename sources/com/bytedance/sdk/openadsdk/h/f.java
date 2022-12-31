package com.bytedance.sdk.openadsdk.h;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.h.g;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ProxyServer.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    private static volatile f f2044e;
    private volatile ServerSocket a;
    private volatile int b;
    private final AtomicInteger c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f2045d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.h.f.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("video-proxyserver-" + thread.getId());
            return thread;
        }
    });

    /* renamed from: f  reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.h.b.c f2046f;

    /* renamed from: g  reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.h.a.c f2047g;

    /* renamed from: h  reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.h.a.b f2048h;

    /* renamed from: i  reason: collision with root package name */
    private final SparseArray<Set<g>> f2049i;

    /* renamed from: j  reason: collision with root package name */
    private final g.c f2050j;

    /* renamed from: k  reason: collision with root package name */
    private volatile c f2051k;

    /* renamed from: l  reason: collision with root package name */
    private volatile c f2052l;
    private final Runnable m;
    private final AtomicBoolean n;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProxyServer.java */
    /* loaded from: classes.dex */
    public static final class a implements Callable<Boolean> {
        private final String a;
        private final int b;

        a(String str, int i2) {
            this.a = str;
            this.b = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            Socket socket;
            Throwable th;
            try {
                socket = new Socket(this.a, this.b);
                try {
                    socket.setSoTimeout(2000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Ping\n".getBytes(com.bytedance.sdk.openadsdk.h.g.d.a));
                    outputStream.flush();
                    if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        return Boolean.TRUE;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        f.b("ping error", Log.getStackTraceString(th));
                        com.bytedance.sdk.openadsdk.h.g.d.a(socket);
                        return Boolean.FALSE;
                    } finally {
                        com.bytedance.sdk.openadsdk.h.g.d.a(socket);
                    }
                }
            } catch (Throwable th3) {
                socket = null;
                th = th3;
            }
            com.bytedance.sdk.openadsdk.h.g.d.a(socket);
            return Boolean.FALSE;
        }
    }

    private f() {
        SparseArray<Set<g>> sparseArray = new SparseArray<>(2);
        this.f2049i = sparseArray;
        this.f2050j = new g.c() { // from class: com.bytedance.sdk.openadsdk.h.f.2
            @Override // com.bytedance.sdk.openadsdk.h.g.c
            public void a(g gVar) {
                synchronized (f.this.f2049i) {
                    Set set = (Set) f.this.f2049i.get(gVar.f());
                    if (set != null) {
                        set.add(gVar);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.h.g.c
            public void b(g gVar) {
                if (e.c) {
                    Log.d("TAG_PROXY_ProxyServer", "afterExecute, ProxyTask: " + gVar);
                }
                int f2 = gVar.f();
                synchronized (f.this.f2049i) {
                    Set set = (Set) f.this.f2049i.get(f2);
                    if (set != null) {
                        set.remove(gVar);
                    }
                }
            }
        };
        this.m = new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.f.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i2 = 0;
                    f.this.a = new ServerSocket(0, 50, InetAddress.getByName("127.0.0.1"));
                    f fVar = f.this;
                    fVar.b = fVar.a.getLocalPort();
                    if (f.this.b != -1) {
                        j.a("127.0.0.1", f.this.b);
                        if (f.this.g() && f.this.c.compareAndSet(0, 1)) {
                            if (e.c) {
                                Log.i("TAG_PROXY_ProxyServer", "proxy server start!");
                            }
                            while (f.this.c.get() == 1) {
                                try {
                                    try {
                                        Socket accept = f.this.a.accept();
                                        com.bytedance.sdk.openadsdk.h.b.c cVar = f.this.f2046f;
                                        if (cVar != null) {
                                            f.this.f2045d.execute(new g.a().a(cVar).a(f.this.f2045d).a(accept).a(f.this.f2050j).a());
                                        } else {
                                            com.bytedance.sdk.openadsdk.h.g.d.a(accept);
                                        }
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        f.b("accept error", Log.getStackTraceString(e2));
                                        i2++;
                                        if (i2 > 3) {
                                            break;
                                        }
                                    }
                                } catch (Throwable th) {
                                    String stackTraceString = Log.getStackTraceString(th);
                                    Log.e("TAG_PROXY_ProxyServer", "proxy server crashed!  " + stackTraceString);
                                    f.b("error", stackTraceString);
                                }
                            }
                            if (e.c) {
                                Log.i("TAG_PROXY_ProxyServer", "proxy server closed!");
                            }
                            f.this.e();
                            return;
                        }
                        return;
                    }
                    f.b("socket not bound", "");
                    f.this.e();
                } catch (IOException e3) {
                    if (e.c) {
                        Log.e("TAG_PROXY_ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e3));
                    }
                    f.b("create ServerSocket error", Log.getStackTraceString(e3));
                    f.this.e();
                }
            }
        };
        this.n = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.c.compareAndSet(1, 2) || this.c.compareAndSet(0, 2)) {
            com.bytedance.sdk.openadsdk.h.g.d.a(this.a);
            this.f2045d.shutdownNow();
            f();
        }
    }

    private void f() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f2049i) {
            int size = this.f2049i.size();
            for (int i2 = 0; i2 < size; i2++) {
                SparseArray<Set<g>> sparseArray = this.f2049i;
                Set<g> set = sparseArray.get(sparseArray.keyAt(i2));
                if (set != null) {
                    arrayList.addAll(set);
                    set.clear();
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        Future submit = this.f2045d.submit(new a("127.0.0.1", this.b));
        h();
        try {
            if (!((Boolean) submit.get()).booleanValue()) {
                Log.e("TAG_PROXY_ProxyServer", "Ping error");
                b("ping error", "");
                e();
                return false;
            } else if (e.c) {
                Log.i("TAG_PROXY_ProxyServer", "Ping OK!");
                return true;
            } else {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            b("ping error", Log.getStackTraceString(th));
            e();
            return false;
        }
    }

    private void h() {
        Socket socket = null;
        try {
            try {
                socket = this.a.accept();
                socket.setSoTimeout(2000);
                if ("Ping".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("OK\n".getBytes(com.bytedance.sdk.openadsdk.h.g.d.a));
                    outputStream.flush();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                b("ping error", Log.getStackTraceString(e2));
            }
        } finally {
            com.bytedance.sdk.openadsdk.h.g.d.a(socket);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b() {
        return this.f2051k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c c() {
        return this.f2052l;
    }

    public void d() {
        if (this.n.compareAndSet(false, true)) {
            new Thread(this.m).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i2, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.f2049i) {
            Set<g> set = this.f2049i.get(i2);
            if (set != null) {
                for (g gVar : set) {
                    if (gVar != null && str.equals(gVar.f1996h)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static f a() {
        if (f2044e == null) {
            synchronized (f.class) {
                if (f2044e == null) {
                    f2044e = new f();
                }
            }
        }
        return f2044e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.h.b.c cVar) {
        this.f2046f = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.h.a.c cVar) {
        this.f2047g = cVar;
    }

    public String a(boolean z, boolean z2, String str, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            if (TextUtils.isEmpty(str)) {
                b("key", "key is empty");
                return strArr[0];
            } else if (this.f2046f == null) {
                b("db", "VideoProxyDB is null");
                return strArr[0];
            } else {
                if ((z ? this.f2048h : this.f2047g) == null) {
                    b("cache", "Cache is null");
                    return strArr[0];
                }
                int i2 = this.c.get();
                if (i2 != 1) {
                    b("state", "ProxyServer is not running, " + i2);
                    return strArr[0];
                }
                List<String> a2 = com.bytedance.sdk.openadsdk.h.g.d.a(strArr);
                if (a2 == null) {
                    b("url", "url not start with http/https");
                    return strArr[0];
                }
                String a3 = i.a(str, z2 ? str : com.bytedance.sdk.openadsdk.h.g.b.a(str), a2);
                if (a3 == null) {
                    b("url", "combine proxy url error");
                    return strArr[0];
                } else if (z) {
                    return "http://127.0.0.1:" + this.b + "?f=1&" + a3;
                } else {
                    return "http://127.0.0.1:" + this.b + "?" + a3;
                }
            }
        }
        b("url", "url is empty");
        return null;
    }
}
