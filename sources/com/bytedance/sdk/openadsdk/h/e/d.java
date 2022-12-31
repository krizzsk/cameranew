package com.bytedance.sdk.openadsdk.h.e;

import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.IHttpStack;
import java.io.IOException;
/* compiled from: NetworkSoureVolleyImpl.java */
/* loaded from: classes.dex */
public class d implements b {
    private IHttpStack a;

    public d() {
        IHttpStack a = com.bytedance.sdk.openadsdk.g.d.a();
        this.a = a;
        if (a == null) {
            this.a = new j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.b
    public a a(f fVar) throws IOException, VAdError {
        e eVar = new e(fVar.a, fVar.b);
        if (fVar.c != -1) {
            eVar.setRetryPolicy(new com.bytedance.sdk.adnet.core.e().a((int) fVar.c));
        }
        return new g(this.a.performRequest(eVar, fVar.f2043e), fVar);
    }
}
