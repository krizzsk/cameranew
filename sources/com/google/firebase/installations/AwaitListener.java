package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.g;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
final class AwaitListener implements c<Void> {
    private final CountDownLatch latch = new CountDownLatch(1);

    AwaitListener() {
    }

    public boolean await(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.latch.await(j2, timeUnit);
    }

    @Override // com.google.android.gms.tasks.c
    public void onComplete(@NonNull g<Void> gVar) {
        this.latch.countDown();
    }

    public void onSuccess() {
        this.latch.countDown();
    }
}
