package com.android.billingclient.api;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzk implements Runnable {
    private final /* synthetic */ ConsumeResponseListener zza;
    private final /* synthetic */ ConsumeParams zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        this.zza = consumeResponseListener;
        this.zzb = consumeParams;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onConsumeResponse(zzak.zzp, this.zzb.getPurchaseToken());
    }
}
