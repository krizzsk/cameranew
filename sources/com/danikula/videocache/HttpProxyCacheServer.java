package com.danikula.videocache;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class HttpProxyCacheServer {

    /* renamed from: i  reason: collision with root package name */
    private static final org.slf4j.b f2206i = org.slf4j.c.i("HttpProxyCacheServer");
    private final Object a;
    private final ExecutorService b;
    private final Map<String, f> c;

    /* renamed from: d  reason: collision with root package name */
    private final ServerSocket f2207d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2208e;

    /* renamed from: f  reason: collision with root package name */
    private final Thread f2209f;

    /* renamed from: g  reason: collision with root package name */
    private final c f2210g;

    /* renamed from: h  reason: collision with root package name */
    private final i f2211h;

    /* loaded from: classes.dex */
    public static final class Builder {
        private File a;

        /* renamed from: d  reason: collision with root package name */
        private com.danikula.videocache.r.c f2212d;
        private com.danikula.videocache.p.a c = new com.danikula.videocache.p.g(IjkMediaMeta.AV_CH_STEREO_LEFT);
        private com.danikula.videocache.p.c b = new com.danikula.videocache.p.f();

        /* renamed from: e  reason: collision with root package name */
        private com.danikula.videocache.q.b f2213e = new com.danikula.videocache.q.a();

        public Builder(Context context) {
            this.f2212d = com.danikula.videocache.r.d.b(context);
            this.a = o.c(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c b() {
            return new c(this.a, this.b, this.c, this.f2212d, this.f2213e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements Runnable {
        private final Socket a;

        public a(Socket socket) {
            this.a = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpProxyCacheServer.this.o(this.a);
        }
    }

    /* loaded from: classes.dex */
    private final class b implements Runnable {
        private final CountDownLatch a;

        public b(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.countDown();
            HttpProxyCacheServer.this.r();
        }
    }

    public HttpProxyCacheServer(Context context) {
        this(new Builder(context).b());
    }

    private String c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.f2208e), l.f(str));
    }

    private void d(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e2) {
            n(new ProxyCacheException("Error closing socket", e2));
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            f2206i.debug("Releasing input stream… Socket is closed by client.");
        } catch (IOException e2) {
            n(new ProxyCacheException("Error closing socket input stream", e2));
        }
    }

    private void f(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e2) {
            f2206i.warn("Failed to close socket on proxy side: {}. It seems client have already closed connection.", e2.getMessage());
        }
    }

    private File g(String str) {
        c cVar = this.f2210g;
        return new File(cVar.a, cVar.b.a(str));
    }

    private f h(String str) throws ProxyCacheException {
        f fVar;
        synchronized (this.a) {
            fVar = this.c.get(str);
            if (fVar == null) {
                fVar = new f(str, this.f2210g);
                this.c.put(str, fVar);
            }
        }
        return fVar;
    }

    private int i() {
        int i2;
        synchronized (this.a) {
            i2 = 0;
            for (f fVar : this.c.values()) {
                i2 += fVar.b();
            }
        }
        return i2;
    }

    private boolean l() {
        return this.f2211h.e(3, 70);
    }

    private void n(Throwable th) {
        f2206i.error("HttpProxyCacheServer error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Socket socket) {
        try {
            try {
                d c = d.c(socket.getInputStream());
                org.slf4j.b bVar = f2206i;
                bVar.debug("Request to cache proxy:" + c);
                String e2 = l.e(c.a);
                if (this.f2211h.d(e2)) {
                    this.f2211h.g(socket);
                } else {
                    h(e2).d(c, socket);
                }
                p(socket);
                bVar.debug("Opened connections: " + i());
            } catch (ProxyCacheException e3) {
                e = e3;
                n(new ProxyCacheException("Error processing request", e));
            } catch (SocketException unused) {
                org.slf4j.b bVar2 = f2206i;
                bVar2.debug("Closing socket… Socket is closed by client.");
                p(socket);
                bVar2.debug("Opened connections: " + i());
            } catch (IOException e4) {
                e = e4;
                n(new ProxyCacheException("Error processing request", e));
            }
        } finally {
            p(socket);
            org.slf4j.b bVar3 = f2206i;
            bVar3.debug("Opened connections: " + i());
        }
    }

    private void p(Socket socket) {
        e(socket);
        f(socket);
        d(socket);
    }

    private void q(File file) {
        try {
            this.f2210g.c.a(file);
        } catch (IOException e2) {
            org.slf4j.b bVar = f2206i;
            bVar.error("Error touching file " + file, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f2207d.accept();
                org.slf4j.b bVar = f2206i;
                bVar.debug("Accept new socket " + accept);
                this.b.submit(new a(accept));
            } catch (IOException e2) {
                n(new ProxyCacheException("Error during waiting connection", e2));
                return;
            }
        }
    }

    public String j(String str) {
        return k(str, true);
    }

    public String k(String str, boolean z) {
        if (!z || !m(str)) {
            return l() ? c(str) : str;
        }
        File g2 = g(str);
        q(g2);
        return Uri.fromFile(g2).toString();
    }

    public boolean m(String str) {
        j.e(str, "Url can't be null!");
        return g(str).exists();
    }

    private HttpProxyCacheServer(c cVar) {
        this.a = new Object();
        this.b = Executors.newFixedThreadPool(8);
        this.c = new ConcurrentHashMap();
        j.d(cVar);
        this.f2210g = cVar;
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f2207d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f2208e = localPort;
            h.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new b(countDownLatch));
            this.f2209f = thread;
            thread.start();
            countDownLatch.await();
            this.f2211h = new i("127.0.0.1", localPort);
            org.slf4j.b bVar = f2206i;
            bVar.info("Proxy cache server started. Is it alive? " + l());
        } catch (IOException | InterruptedException e2) {
            this.b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }
}
