package com.bytedance.sdk.openadsdk.j;

import java.util.List;
/* compiled from: TrackAdUrlImplEmpty.java */
/* loaded from: classes.dex */
class d implements a {
    private static volatile d a;

    private d() {
    }

    public static d c() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void a(List<String> list) {
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void b() {
    }
}
