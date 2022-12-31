package com.android.billingclient.api;

import com.android.billingclient.api.BillingClientImpl;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzm implements Runnable {
    private final /* synthetic */ BillingClientImpl.zzb zza;
    private final /* synthetic */ zzn zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzn zznVar, BillingClientImpl.zzb zzbVar) {
        this.zzb = zznVar;
        this.zza = zzbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.onPurchaseHistoryResponse(this.zza.zza(), this.zza.zzb());
    }
}
