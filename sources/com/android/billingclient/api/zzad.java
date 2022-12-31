package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.Callable;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzad implements Callable<Bundle> {
    private final /* synthetic */ SkuDetails zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(BillingClientImpl billingClientImpl, SkuDetails skuDetails, String str) {
        this.zzc = billingClientImpl;
        this.zza = skuDetails;
        this.zzb = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Bundle call() throws Exception {
        com.google.android.gms.internal.play_billing.zza zzaVar;
        Context context;
        zzaVar = this.zzc.zzg;
        context = this.zzc.zzf;
        return zzaVar.zza(3, context.getPackageName(), this.zza.getSku(), this.zzb, (String) null);
    }
}
