package com.android.billingclient.api;

import com.android.billingclient.api.SkuDetails;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzj implements Runnable {
    private final /* synthetic */ SkuDetails.zza zza;
    private final /* synthetic */ zzg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(zzg zzgVar, SkuDetails.zza zzaVar) {
        this.zzb = zzgVar;
        this.zza = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.onSkuDetailsResponse(BillingResult.newBuilder().setResponseCode(this.zza.zzb()).setDebugMessage(this.zza.zzc()).build(), this.zza.zza());
    }
}
