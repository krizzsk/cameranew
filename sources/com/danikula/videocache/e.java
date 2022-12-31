package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpProxyCache.java */
/* loaded from: classes.dex */
public class e extends k {

    /* renamed from: j  reason: collision with root package name */
    private final g f2218j;

    /* renamed from: k  reason: collision with root package name */
    private final com.danikula.videocache.p.b f2219k;

    /* renamed from: l  reason: collision with root package name */
    private b f2220l;

    public e(g gVar, com.danikula.videocache.p.b bVar) {
        super(gVar, bVar);
        this.f2219k = bVar;
        this.f2218j = gVar;
    }

    private String p(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private boolean q(d dVar) throws ProxyCacheException {
        long length = this.f2218j.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.c && ((float) dVar.b) > ((float) this.f2219k.available()) + (((float) length) * 0.2f)) ? false : true;
    }

    private String r(d dVar) throws IOException, ProxyCacheException {
        String d2 = this.f2218j.d();
        boolean z = !TextUtils.isEmpty(d2);
        long available = this.f2219k.d() ? this.f2219k.available() : this.f2218j.length();
        boolean z2 = available >= 0;
        boolean z3 = dVar.c;
        long j2 = z3 ? available - dVar.b : available;
        boolean z4 = z2 && z3;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? p("Content-Length: %d\n", Long.valueOf(j2)) : "");
        sb.append(z4 ? p("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.b), Long.valueOf(available - 1), Long.valueOf(available)) : "");
        sb.append(z ? p("Content-Type: %s\n", d2) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void u(OutputStream outputStream, long j2) throws ProxyCacheException, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int j3 = j(bArr, j2, 8192);
            if (j3 != -1) {
                outputStream.write(bArr, 0, j3);
                j2 += j3;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private void v(OutputStream outputStream, long j2) throws ProxyCacheException, IOException {
        g gVar = new g(this.f2218j);
        try {
            gVar.a((int) j2);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = gVar.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            gVar.close();
        }
    }

    @Override // com.danikula.videocache.k
    protected void g(int i2) {
        b bVar = this.f2220l;
        if (bVar != null) {
            bVar.a(this.f2219k.b, this.f2218j.e(), i2);
        }
    }

    public void s(d dVar, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(r(dVar).getBytes("UTF-8"));
        long j2 = dVar.b;
        if (q(dVar)) {
            u(bufferedOutputStream, j2);
        } else {
            v(bufferedOutputStream, j2);
        }
    }

    public void t(b bVar) {
        this.f2220l = bVar;
    }
}
