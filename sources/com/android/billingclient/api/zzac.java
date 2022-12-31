package com.android.billingclient.api;

import com.android.billingclient.api.Purchase;
import java.util.concurrent.Callable;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzac implements Callable<Purchase.PurchasesResult> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ BillingClientImpl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(BillingClientImpl billingClientImpl, String str) {
        this.zzb = billingClientImpl;
        this.zza = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Purchase.PurchasesResult call() throws Exception {
        Purchase.PurchasesResult zzc;
        zzc = this.zzb.zzc(this.zza);
        return zzc;
    }
}
