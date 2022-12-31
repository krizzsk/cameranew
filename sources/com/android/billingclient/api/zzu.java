package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class zzu implements Callable<Integer> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ BillingClientImpl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(BillingClientImpl billingClientImpl, String str) {
        this.zzb = billingClientImpl;
        this.zza = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() throws Exception {
        com.google.android.gms.internal.play_billing.zza zzaVar;
        Context context;
        Bundle zzb;
        zzaVar = this.zzb.zzg;
        context = this.zzb.zzf;
        String packageName = context.getPackageName();
        String str = this.zza;
        BillingClientImpl billingClientImpl = this.zzb;
        zzb = BillingClientImpl.zzb();
        return Integer.valueOf(zzaVar.zzb(7, packageName, str, zzb));
    }
}
