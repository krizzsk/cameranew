package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class zzo implements Callable<Void> {
    final /* synthetic */ AcknowledgePurchaseResponseListener zza;
    private final /* synthetic */ AcknowledgePurchaseParams zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(BillingClientImpl billingClientImpl, AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zzc = billingClientImpl;
        this.zzb = acknowledgePurchaseParams;
        this.zza = acknowledgePurchaseResponseListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: zza */
    public final Void call() {
        com.google.android.gms.internal.play_billing.zza zzaVar;
        Context context;
        String str;
        try {
            zzaVar = this.zzc.zzg;
            context = this.zzc.zzf;
            String packageName = context.getPackageName();
            String purchaseToken = this.zzb.getPurchaseToken();
            AcknowledgePurchaseParams acknowledgePurchaseParams = this.zzb;
            str = this.zzc.zzb;
            Bundle zzd = zzaVar.zzd(9, packageName, purchaseToken, com.google.android.gms.internal.play_billing.zzb.zza(acknowledgePurchaseParams, str));
            this.zzc.zza(new zzq(this, com.google.android.gms.internal.play_billing.zzb.zza(zzd, "BillingClient"), com.google.android.gms.internal.play_billing.zzb.zzb(zzd, "BillingClient")));
            return null;
        } catch (Exception e2) {
            this.zzc.zza(new zzr(this, e2));
            return null;
        }
    }
}
