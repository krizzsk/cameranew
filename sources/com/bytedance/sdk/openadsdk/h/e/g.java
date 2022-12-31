package com.bytedance.sdk.openadsdk.h.e;

import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.openadsdk.h.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* compiled from: VolleyResponseWrapper.java */
/* loaded from: classes.dex */
public class g extends a {
    private HttpResponse c;

    public g(HttpResponse httpResponse, f fVar) {
        this.c = httpResponse;
        this.a = new ArrayList();
        for (int i2 = 0; i2 < this.c.getHeaders().size(); i2++) {
            Header header = this.c.getHeaders().get(i2);
            if (header != null) {
                this.a.add(new i.b(header.getName(), header.getValue()));
            }
        }
        this.b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public int a() {
        return this.c.getStatusCode();
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public boolean b() {
        return this.c.getStatusCode() >= 200 && this.c.getStatusCode() < 300;
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public List<i.b> c() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public InputStream d() {
        return this.c.getContent();
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public String e() {
        return "http/1.1";
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public String f() {
        return a(this.c.getStatusCode());
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public String a(String str, String str2) {
        return a(str) != null ? a(str).b : str2;
    }
}
