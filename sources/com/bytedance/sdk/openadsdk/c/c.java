package com.bytedance.sdk.openadsdk.c;

import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: AdEventDispatcher4MultiProcess.java */
/* loaded from: classes.dex */
public class c extends b<a> {
    private AtomicBoolean a = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a() {
        if (this.a.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.c.a.c();
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a(@NonNull a aVar) {
        if (this.a.get()) {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(aVar.a());
        }
    }
}
