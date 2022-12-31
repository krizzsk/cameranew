package com.android.billingclient.api;

import com.android.billingclient.api.BillingClientImpl;
import java.util.concurrent.Callable;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzn implements Callable<Void> {
    final /* synthetic */ PurchaseHistoryResponseListener zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(BillingClientImpl billingClientImpl, String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zzc = billingClientImpl;
        this.zzb = str;
        this.zza = purchaseHistoryResponseListener;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        BillingClientImpl.zzb zza;
        zza = this.zzc.zza(this.zzb);
        this.zzc.zza(new zzm(this, zza));
        return null;
    }
}
