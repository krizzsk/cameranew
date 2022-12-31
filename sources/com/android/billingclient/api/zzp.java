package com.android.billingclient.api;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzp implements Runnable {
    private final /* synthetic */ PurchaseHistoryResponseListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(BillingClientImpl billingClientImpl, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zza = purchaseHistoryResponseListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onPurchaseHistoryResponse(zzak.zzp, null);
    }
}
