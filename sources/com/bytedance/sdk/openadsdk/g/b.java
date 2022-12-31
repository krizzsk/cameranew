package com.bytedance.sdk.openadsdk.g;

import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.g;
/* compiled from: StatsImageListener.java */
/* loaded from: classes.dex */
public class b implements d.InterfaceC0041d {
    private boolean a;
    private com.bytedance.sdk.openadsdk.f.a.c b;

    public b(boolean z) {
        this.a = z;
        if (z) {
            this.b = com.bytedance.sdk.openadsdk.f.a.c.b();
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
    public void a() {
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public void a(m<Bitmap> mVar) {
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.a || (cVar = this.b) == null) {
            return;
        }
        cVar.c(str);
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
    public void b() {
    }

    public void b(String str) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.a || (cVar = this.b) == null) {
            return;
        }
        cVar.e(str);
    }

    public void c(String str) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.a || (cVar = this.b) == null) {
            return;
        }
        cVar.d(str);
    }

    public void d(String str) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.a || (cVar = this.b) == null) {
            return;
        }
        cVar.g(str);
    }

    public void a(int i2) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.a || (cVar = this.b) == null) {
            return;
        }
        cVar.a(i2);
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public void b(m<Bitmap> mVar) {
        com.bytedance.sdk.openadsdk.f.a.c cVar;
        if (!this.a || (cVar = this.b) == null) {
            return;
        }
        cVar.b(201).f(g.a(201));
        com.bytedance.sdk.openadsdk.f.a.a().f(this.b);
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
    public void a(d.c cVar, boolean z) {
        if (!this.a || this.b == null) {
            return;
        }
        if (cVar == null || cVar.a() == null) {
            this.b.b(202).f(g.a(202));
            com.bytedance.sdk.openadsdk.f.a.a().f(this.b);
        }
    }
}
