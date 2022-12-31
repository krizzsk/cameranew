package com.android.billingclient.api;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzq implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzo zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(zzo zzoVar, int i2, String str) {
        this.zzc = zzoVar;
        this.zza = i2;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.onAcknowledgePurchaseResponse(BillingResult.newBuilder().setResponseCode(this.zza).setDebugMessage(this.zzb).build());
    }
}
