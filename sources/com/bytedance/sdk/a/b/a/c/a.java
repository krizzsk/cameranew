package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.m;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.u;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import java.io.IOException;
import java.util.List;
import us.pinguo.common.network.HttpRequest;
/* compiled from: BridgeInterceptor.java */
/* loaded from: classes.dex */
public final class a implements t {
    private final m a;

    public a(m mVar) {
        this.a = mVar;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        y a = aVar.a();
        y.a e2 = a.e();
        z d2 = a.d();
        if (d2 != null) {
            u a2 = d2.a();
            if (a2 != null) {
                e2.a(HttpRequest.HEADER_CONTENT_TYPE, a2.toString());
            }
            long b = d2.b();
            if (b != -1) {
                e2.a(HttpRequest.HEADER_CONTENT_LENGTH, Long.toString(b));
                e2.b("Transfer-Encoding");
            } else {
                e2.a("Transfer-Encoding", "chunked");
                e2.b(HttpRequest.HEADER_CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (a.a("Host") == null) {
            e2.a("Host", com.bytedance.sdk.a.b.a.c.a(a.a(), false));
        }
        if (a.a("Connection") == null) {
            e2.a("Connection", "Keep-Alive");
        }
        if (a.a(HttpRequest.HEADER_ACCEPT_ENCODING) == null && a.a("Range") == null) {
            z = true;
            e2.a(HttpRequest.HEADER_ACCEPT_ENCODING, HttpRequest.ENCODING_GZIP);
        }
        List<com.bytedance.sdk.a.b.l> a3 = this.a.a(a.a());
        if (!a3.isEmpty()) {
            e2.a("Cookie", a(a3));
        }
        if (a.a(HttpRequest.HEADER_USER_AGENT) == null) {
            e2.a(HttpRequest.HEADER_USER_AGENT, com.bytedance.sdk.a.b.a.d.a());
        }
        aa a4 = aVar.a(e2.d());
        e.a(this.a, a.a(), a4.f());
        aa.a a5 = a4.h().a(a);
        if (z && HttpRequest.ENCODING_GZIP.equalsIgnoreCase(a4.a(HttpRequest.HEADER_CONTENT_ENCODING)) && e.b(a4)) {
            com.bytedance.sdk.a.a.j jVar = new com.bytedance.sdk.a.a.j(a4.g().c());
            a5.a(a4.f().b().b(HttpRequest.HEADER_CONTENT_ENCODING).b(HttpRequest.HEADER_CONTENT_LENGTH).a());
            a5.a(new h(a4.a(HttpRequest.HEADER_CONTENT_TYPE), -1L, com.bytedance.sdk.a.a.l.a(jVar)));
        }
        return a5.a();
    }

    private String a(List<com.bytedance.sdk.a.b.l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            com.bytedance.sdk.a.b.l lVar = list.get(i2);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }
}
