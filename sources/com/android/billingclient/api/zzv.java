package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.Callable;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzv implements Callable<Bundle> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(BillingClientImpl billingClientImpl, String str, Bundle bundle) {
        this.zzc = billingClientImpl;
        this.zza = str;
        this.zzb = bundle;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Bundle call() throws Exception {
        com.google.android.gms.internal.play_billing.zza zzaVar;
        Context context;
        zzaVar = this.zzc.zzg;
        context = this.zzc.zzf;
        return zzaVar.zzb(8, context.getPackageName(), this.zza, "subs", this.zzb);
    }
}
