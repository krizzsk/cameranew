package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class zze extends BroadcastReceiver {
    private final PurchasesUpdatedListener zza;
    private boolean zzb;
    private final /* synthetic */ zzd zzc;

    /* JADX INFO: Access modifiers changed from: private */
    public zze(@NonNull zzd zzdVar, PurchasesUpdatedListener purchasesUpdatedListener) {
        this.zzc = zzdVar;
        this.zza = purchasesUpdatedListener;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        this.zza.onPurchasesUpdated(com.google.android.gms.internal.play_billing.zzb.zzb(intent, "BillingBroadcastManager"), com.google.android.gms.internal.play_billing.zzb.zza(intent.getExtras()));
    }

    public final void zza(Context context, IntentFilter intentFilter) {
        zze zzeVar;
        if (this.zzb) {
            return;
        }
        zzeVar = this.zzc.zzb;
        context.registerReceiver(zzeVar, intentFilter);
        this.zzb = true;
    }

    public final void zza(Context context) {
        zze zzeVar;
        if (this.zzb) {
            zzeVar = this.zzc.zzb;
            context.unregisterReceiver(zzeVar);
            this.zzb = false;
            return;
        }
        com.google.android.gms.internal.play_billing.zzb.zzb("BillingBroadcastManager", "Receiver is not registered.");
    }
}
