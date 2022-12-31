package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: HttpUrlSource.java */
/* loaded from: classes.dex */
public class g implements m {

    /* renamed from: f  reason: collision with root package name */
    private static final org.slf4j.b f2224f = org.slf4j.c.i("HttpUrlSource");
    private final com.danikula.videocache.r.c a;
    private final com.danikula.videocache.q.b b;
    private n c;

    /* renamed from: d  reason: collision with root package name */
    private HttpURLConnection f2225d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f2226e;

    public g(String str) {
        this(str, com.danikula.videocache.r.d.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b() throws com.danikula.videocache.ProxyCacheException {
        /*
            r8 = this;
            org.slf4j.b r0 = com.danikula.videocache.g.f2224f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Read content info from "
            r1.append(r2)
            com.danikula.videocache.n r2 = r8.c
            java.lang.String r2 = r2.a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.debug(r1)
            r1 = 0
            r3 = 10000(0x2710, float:1.4013E-41)
            r4 = 0
            java.net.HttpURLConnection r1 = r8.g(r1, r3)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L64
            long r2 = r8.c(r1)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            java.lang.String r5 = r1.getContentType()     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            com.danikula.videocache.n r6 = new com.danikula.videocache.n     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            com.danikula.videocache.n r7 = r8.c     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            java.lang.String r7 = r7.a     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            r6.<init>(r7, r2, r5)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            r8.c = r6     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            com.danikula.videocache.r.c r2 = r8.a     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            java.lang.String r3 = r6.a     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            r2.a(r3, r6)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            r2.<init>()     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            java.lang.String r3 = "Source info fetched: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            com.danikula.videocache.n r3 = r8.c     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            r2.append(r3)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            r0.debug(r2)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L5f
            com.danikula.videocache.l.c(r4)
            if (r1 == 0) goto L88
            goto L85
        L5d:
            r0 = move-exception
            goto L89
        L5f:
            r0 = move-exception
            goto L66
        L61:
            r0 = move-exception
            r1 = r4
            goto L89
        L64:
            r0 = move-exception
            r1 = r4
        L66:
            org.slf4j.b r2 = com.danikula.videocache.g.f2224f     // Catch: java.lang.Throwable -> L5d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d
            r3.<init>()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r5 = "Error fetching info from "
            r3.append(r5)     // Catch: java.lang.Throwable -> L5d
            com.danikula.videocache.n r5 = r8.c     // Catch: java.lang.Throwable -> L5d
            java.lang.String r5 = r5.a     // Catch: java.lang.Throwable -> L5d
            r3.append(r5)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5d
            r2.error(r3, r0)     // Catch: java.lang.Throwable -> L5d
            com.danikula.videocache.l.c(r4)
            if (r1 == 0) goto L88
        L85:
            r1.disconnect()
        L88:
            return
        L89:
            com.danikula.videocache.l.c(r4)
            if (r1 == 0) goto L91
            r1.disconnect()
        L91:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.g.b():void");
    }

    private long c(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(HttpRequest.HEADER_CONTENT_LENGTH);
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private void f(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private HttpURLConnection g(long j2, int i2) throws IOException, ProxyCacheException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.c.a;
        int i3 = 0;
        do {
            org.slf4j.b bVar = f2224f;
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            int i4 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i4 > 0) {
                str = " with offset " + j2;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            bVar.debug(sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            f(httpURLConnection, str2);
            if (i4 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + PGTransHeader.CONNECTOR);
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField(HttpRequest.HEADER_LOCATION);
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i3);
            }
        } while (z);
        return httpURLConnection;
    }

    private long h(HttpURLConnection httpURLConnection, long j2, int i2) throws IOException {
        long c = c(httpURLConnection);
        return i2 == 200 ? c : i2 == 206 ? c + j2 : this.c.b;
    }

    @Override // com.danikula.videocache.m
    public void a(long j2) throws ProxyCacheException {
        try {
            HttpURLConnection g2 = g(j2, -1);
            this.f2225d = g2;
            String contentType = g2.getContentType();
            this.f2226e = new BufferedInputStream(this.f2225d.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f2225d;
            n nVar = new n(this.c.a, h(httpURLConnection, j2, httpURLConnection.getResponseCode()), contentType);
            this.c = nVar;
            this.a.a(nVar.a, nVar);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + this.c.a + " with offset " + j2, e2);
        }
    }

    @Override // com.danikula.videocache.m
    public void close() throws ProxyCacheException {
        HttpURLConnection httpURLConnection = this.f2225d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e2) {
                f2224f.error("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", e2);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e4) {
                e = e4;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public synchronized String d() throws ProxyCacheException {
        if (TextUtils.isEmpty(this.c.c)) {
            b();
        }
        return this.c.c;
    }

    public String e() {
        return this.c.a;
    }

    @Override // com.danikula.videocache.m
    public synchronized long length() throws ProxyCacheException {
        if (this.c.b == -2147483648L) {
            b();
        }
        return this.c.b;
    }

    @Override // com.danikula.videocache.m
    public int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.f2226e;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e2) {
                throw new InterruptedProxyCacheException("Reading source " + this.c.a + " is interrupted", e2);
            } catch (IOException e3) {
                throw new ProxyCacheException("Error reading data from " + this.c.a, e3);
            }
        }
        throw new ProxyCacheException("Error reading data from " + this.c.a + ": connection is absent!");
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.c + "}";
    }

    public g(String str, com.danikula.videocache.r.c cVar) {
        this(str, cVar, new com.danikula.videocache.q.a());
    }

    public g(String str, com.danikula.videocache.r.c cVar, com.danikula.videocache.q.b bVar) {
        j.d(cVar);
        this.a = cVar;
        j.d(bVar);
        this.b = bVar;
        n nVar = cVar.get(str);
        this.c = nVar == null ? new n(str, -2147483648L, l.g(str)) : nVar;
    }

    public g(g gVar) {
        this.c = gVar.c;
        this.a = gVar.a;
        this.b = gVar.b;
    }
}
