package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.u;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.IHttpStack;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import us.pinguo.common.network.HttpRequest;
/* compiled from: OkStack.java */
/* loaded from: classes.dex */
public class j implements IHttpStack {
    private final v a;

    /* compiled from: OkStack.java */
    /* loaded from: classes.dex */
    static class a extends FilterInputStream {
        private final ab a;

        a(ab abVar) {
            super(j.b(abVar));
            this.a = abVar;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            try {
                this.a.close();
            } catch (Throwable unused) {
            }
        }
    }

    public j() {
        v.a aVar = new v.a();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.a = aVar.a(10000L, timeUnit).b(10000L, timeUnit).c(10000L, timeUnit).a();
    }

    private static boolean a(int i2, int i3) {
        return (i2 == 4 || (100 <= i3 && i3 < 200) || i3 == 204 || i3 == 304) ? false : true;
    }

    private String b(Request<?> request) {
        if (request != null) {
            if (request.getUrl() != null) {
                try {
                } catch (Exception unused) {
                    return "";
                }
            }
            return InetAddress.getByName(new URL(request.getUrl()).getHost()).getHostAddress();
        }
        return "";
    }

    private y.a c(Request request) throws IOException {
        if (request == null || request.getUrl() == null) {
            return null;
        }
        y.a aVar = new y.a();
        URL url = new URL(request.getUrl());
        String host = url.getHost();
        n nVar = com.bytedance.sdk.adnet.a.a;
        String a2 = nVar != null ? nVar.a(host) : null;
        boolean z = false;
        if (!TextUtils.isEmpty(a2)) {
            try {
                aVar.a(new URL(url.toString().replaceFirst(host, a2))).b("Host", host);
                z = true;
            } catch (Exception unused) {
            }
        }
        if (!z) {
            aVar.a(url);
        }
        return aVar;
    }

    private static z d(Request request) throws com.bytedance.sdk.adnet.err.a {
        byte[] body = request.getBody();
        if (body == null) {
            if (request.getMethod() != 1) {
                return null;
            }
            body = "".getBytes();
        }
        return z.a(u.a(request.getBodyContentType()), body);
    }

    @Override // com.bytedance.sdk.adnet.face.IHttpStack
    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, VAdError {
        int timeoutMs = request.getTimeoutMs();
        v.a y = this.a.y();
        long j2 = timeoutMs;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        v.a c = y.a(j2, timeUnit).b(j2, timeUnit).c(j2, timeUnit);
        boolean z = true;
        v a2 = c.b(true).a(true).a();
        y.a c2 = c(request);
        if (c2 != null) {
            a(request);
            if (!TextUtils.isEmpty(request.getUserAgent())) {
                c2.b(HttpRequest.HEADER_USER_AGENT).b(HttpRequest.HEADER_USER_AGENT, request.getUserAgent() + " " + com.bytedance.sdk.a.b.a.d.a());
            }
            Map<String, String> headers = request.getHeaders();
            if (headers != null) {
                for (String str : headers.keySet()) {
                    c2.b(str, headers.get(str));
                }
            }
            if (map != null) {
                for (String str2 : map.keySet()) {
                    c2.a(str2, map.get(str2));
                }
            }
            a(c2, request);
            aa a3 = a2.a(c2.d()).a();
            com.bytedance.sdk.a.b.a.c.k a4 = com.bytedance.sdk.a.b.a.c.k.a(a3);
            ab g2 = a3.g();
            try {
                int i2 = a4.b;
                if (i2 != -1) {
                    if (!a(request.getMethod(), i2)) {
                        HttpResponse httpResponse = new HttpResponse(i2, a(a3.f()));
                        g2.close();
                        return httpResponse;
                    }
                    try {
                        return new HttpResponse(i2, a(a3.f()), (int) g2.a(), new a(g2));
                    } catch (Throwable th) {
                        th = th;
                        if (!z) {
                            g2.close();
                        }
                        throw th;
                    }
                }
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
        } else {
            throw new IllegalArgumentException("request params maybe null");
        }
    }

    private void a(Request<?> request) {
        if (request != null) {
            request.setIpAddrStr(b(request));
        }
    }

    private static List<Header> a(r rVar) {
        if (rVar == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(rVar.a());
        int a2 = rVar.a();
        for (int i2 = 0; i2 < a2; i2++) {
            String a3 = rVar.a(i2);
            String b = rVar.b(i2);
            if (a3 != null) {
                arrayList.add(new Header(a3, b));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream b(ab abVar) {
        if (abVar == null) {
            return null;
        }
        return abVar.b();
    }

    private static void a(y.a aVar, Request<?> request) throws IOException, com.bytedance.sdk.adnet.err.a {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    aVar.a(z.a(u.a(request.getBodyContentType()), postBody));
                    return;
                }
                return;
            case 0:
                aVar.a();
                return;
            case 1:
                aVar.a(d(request));
                return;
            case 2:
                aVar.c(d(request));
                return;
            case 3:
                aVar.c();
                return;
            case 4:
                aVar.b();
                return;
            case 5:
                aVar.a("OPTIONS", (z) null);
                return;
            case 6:
                aVar.a("TRACE", (z) null);
                return;
            case 7:
                aVar.d(d(request));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }
}
