package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import java.util.Arrays;
import java.util.concurrent.Callable;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzaa implements Callable<Bundle> {
    private final /* synthetic */ BillingFlowParams zza;
    private final /* synthetic */ SkuDetails zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(BillingClientImpl billingClientImpl, BillingFlowParams billingFlowParams, SkuDetails skuDetails) {
        this.zzc = billingClientImpl;
        this.zza = billingFlowParams;
        this.zzb = skuDetails;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Bundle call() throws Exception {
        com.google.android.gms.internal.play_billing.zza zzaVar;
        Context context;
        zzaVar = this.zzc.zzg;
        context = this.zzc.zzf;
        return zzaVar.zza(5, context.getPackageName(), Arrays.asList(this.zza.getOldSku()), this.zzb.getSku(), "subs", (String) null);
    }
}
