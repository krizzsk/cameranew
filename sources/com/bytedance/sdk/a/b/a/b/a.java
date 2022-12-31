package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
/* compiled from: ConnectInterceptor.java */
/* loaded from: classes.dex */
public final class a implements t {
    public final v a;

    public a(v vVar) {
        this.a = vVar;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        com.bytedance.sdk.a.b.a.c.g gVar = (com.bytedance.sdk.a.b.a.c.g) aVar;
        y a = gVar.a();
        g f2 = gVar.f();
        return gVar.a(a, f2, f2.a(this.a, aVar, !a.b().equals("GET")), f2.b());
    }
}
