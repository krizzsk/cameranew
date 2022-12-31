package com.google.android.gms.internal.ads;

import java.util.concurrent.BlockingQueue;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzp implements Runnable {
    private final /* synthetic */ zzab zzy;
    private final /* synthetic */ zzm zzz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(zzm zzmVar, zzab zzabVar) {
        this.zzz = zzmVar;
        this.zzy = zzabVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.zzz.zzm;
            blockingQueue.put(this.zzy);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
