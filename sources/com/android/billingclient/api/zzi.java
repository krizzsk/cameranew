package com.android.billingclient.api;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzi implements Runnable {
    private final /* synthetic */ SkuDetailsResponseListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(BillingClientImpl billingClientImpl, SkuDetailsResponseListener skuDetailsResponseListener) {
        this.zza = skuDetailsResponseListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onSkuDetailsResponse(zzak.zzp, null);
    }
}
