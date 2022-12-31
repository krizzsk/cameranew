package com.android.billingclient.api;

import java.util.concurrent.Future;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class zzs implements Runnable {
    private final /* synthetic */ Future zza;
    private final /* synthetic */ Runnable zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(BillingClientImpl billingClientImpl, Future future, Runnable runnable) {
        this.zza = future;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza.isDone() || this.zza.isCancelled()) {
            return;
        }
        this.zza.cancel(true);
        com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Async task is taking too long, cancel it!");
        Runnable runnable = this.zzb;
        if (runnable != null) {
            runnable.run();
        }
    }
}
