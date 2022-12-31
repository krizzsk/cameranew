package com.android.billingclient.api;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzt implements Runnable {
    private final /* synthetic */ AcknowledgePurchaseResponseListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zza = acknowledgePurchaseResponseListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onAcknowledgePurchaseResponse(zzak.zzp);
    }
}
