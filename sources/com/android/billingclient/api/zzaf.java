package com.android.billingclient.api;

import com.android.billingclient.api.BillingClientImpl;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzaf implements Runnable {
    private final /* synthetic */ BillingClientImpl.zza zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(BillingClientImpl.zza zzaVar) {
        this.zza = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BillingClientImpl.this.zza = 0;
        BillingClientImpl.this.zzg = null;
        this.zza.zza(zzak.zzp);
    }
}
