package com.bytedance.sdk.openadsdk.c;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: StatsDispatcher4MultiProcess.java */
/* loaded from: classes.dex */
public class m extends b<c.a> {
    private AtomicBoolean a = new AtomicBoolean(false);
    private boolean b;

    public m(boolean z) {
        this.b = true;
        this.b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a() {
        if (this.a.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.c.a.a(this.b);
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a(@NonNull c.a aVar) {
        if (this.a.get()) {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(aVar.a(), this.b);
        }
    }
}
