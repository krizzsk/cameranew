package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.Callable;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzab implements Callable<Bundle> {
    private final /* synthetic */ int zza;
    private final /* synthetic */ SkuDetails zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ BillingFlowParams zzd;
    private final /* synthetic */ Bundle zze;
    private final /* synthetic */ BillingClientImpl zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(BillingClientImpl billingClientImpl, int i2, SkuDetails skuDetails, String str, BillingFlowParams billingFlowParams, Bundle bundle) {
        this.zzf = billingClientImpl;
        this.zza = i2;
        this.zzb = skuDetails;
        this.zzc = str;
        this.zzd = billingFlowParams;
        this.zze = bundle;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Bundle call() throws Exception {
        com.google.android.gms.internal.play_billing.zza zzaVar;
        Context context;
        zzaVar = this.zzf.zzg;
        int i2 = this.zza;
        context = this.zzf.zzf;
        return zzaVar.zza(i2, context.getPackageName(), this.zzb.getSku(), this.zzc, this.zzd.zze(), this.zze);
    }
}
