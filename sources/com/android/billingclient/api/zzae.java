package com.android.billingclient.api;

import com.android.billingclient.api.BillingClientImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class zzae implements Runnable {
    private final /* synthetic */ BillingResult zza;
    private final /* synthetic */ BillingClientImpl.zza zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(BillingClientImpl.zza zzaVar, BillingResult billingResult) {
        this.zzb = zzaVar;
        this.zza = billingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        BillingClientStateListener billingClientStateListener;
        BillingClientStateListener billingClientStateListener2;
        obj = this.zzb.zzb;
        synchronized (obj) {
            billingClientStateListener = this.zzb.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener2 = this.zzb.zzd;
                billingClientStateListener2.onBillingSetupFinished(this.zza);
            }
        }
    }
}
