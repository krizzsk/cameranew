package com.bytedance.sdk.a.b.a.e;

import java.util.concurrent.CountDownLatch;
/* compiled from: Ping.java */
/* loaded from: classes.dex */
final class l {
    private final CountDownLatch a = new CountDownLatch(1);
    private long b = -1;
    private long c = -1;

    l() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.b == -1) {
            this.b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.c == -1 && this.b != -1) {
            this.c = System.nanoTime();
            this.a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.c == -1) {
            long j2 = this.b;
            if (j2 != -1) {
                this.c = j2 - 1;
                this.a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
