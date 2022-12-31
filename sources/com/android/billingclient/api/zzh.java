package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class zzh extends ResultReceiver {
    private final /* synthetic */ BillingClientImpl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzh(BillingClientImpl billingClientImpl, Handler handler) {
        super(handler);
        this.zza = billingClientImpl;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i2, Bundle bundle) {
        zzd zzdVar;
        zzdVar = this.zza.zzd;
        PurchasesUpdatedListener zzb = zzdVar.zzb();
        if (zzb == null) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "PurchasesUpdatedListener is null - no way to return the response.");
            return;
        }
        zzb.onPurchasesUpdated(BillingResult.newBuilder().setResponseCode(i2).setDebugMessage(com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient")).build(), com.google.android.gms.internal.play_billing.zzb.zza(bundle));
    }
}
