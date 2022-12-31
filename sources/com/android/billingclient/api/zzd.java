package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class zzd {
    private final Context zza;
    private final zze zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(Context context, @NonNull PurchasesUpdatedListener purchasesUpdatedListener) {
        this.zza = context;
        this.zzb = new zze(this, purchasesUpdatedListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zzb.zza(this.zza, new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PurchasesUpdatedListener zzb() {
        return zze.zza(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        this.zzb.zza(this.zza);
    }
}
