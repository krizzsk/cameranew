package com.google.android.play.core.tasks;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
final class t implements c, b {
    private final CountDownLatch a = new CountDownLatch(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(byte[] bArr) {
    }

    public final void a() throws InterruptedException {
        this.a.await();
    }

    @Override // com.google.android.play.core.tasks.b
    public final void onFailure(Exception exc) {
        this.a.countDown();
    }

    @Override // com.google.android.play.core.tasks.c
    public final void onSuccess(Object obj) {
        this.a.countDown();
    }
}
