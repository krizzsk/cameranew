package com.danikula.videocache;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pinger.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: d  reason: collision with root package name */
    private static final org.slf4j.b f2228d = org.slf4j.c.i("Pinger");
    private final ExecutorService a = Executors.newSingleThreadExecutor();
    private final String b;
    private final int c;

    /* compiled from: Pinger.java */
    /* loaded from: classes.dex */
    private class b implements Callable<Boolean> {
        private b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(i.this.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, int i2) {
        j.d(str);
        this.b = str;
        this.c = i2;
    }

    private List<Proxy> b() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.b, Integer.valueOf(this.c), "ping");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() throws ProxyCacheException {
        g gVar = new g(c());
        try {
            byte[] bytes = "ping ok".getBytes();
            gVar.a(0L);
            byte[] bArr = new byte[bytes.length];
            gVar.read(bArr);
            boolean equals = Arrays.equals(bytes, bArr);
            org.slf4j.b bVar = f2228d;
            bVar.info("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (ProxyCacheException e2) {
            f2228d.error("Error reading ping response", e2);
            return false;
        } finally {
            gVar.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(String str) {
        return "ping".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(int i2, int i3) {
        j.b(i2 >= 1);
        j.b(i3 > 0);
        int i4 = 0;
        while (i4 < i2) {
            try {
            } catch (InterruptedException e2) {
                e = e2;
                f2228d.error("Error pinging server due to unexpected error", e);
            } catch (ExecutionException e3) {
                e = e3;
                f2228d.error("Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                org.slf4j.b bVar = f2228d;
                bVar.warn("Error pinging server (attempt: " + i4 + ", timeout: " + i3 + "). ");
            }
            if (((Boolean) this.a.submit(new b()).get(i3, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i4++;
            i3 *= 2;
        }
        String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i4), Integer.valueOf(i3 / 2), b());
        f2228d.error(format, new ProxyCacheException(format));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }
}
