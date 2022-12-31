package com.android.billingclient.api;

import java.util.List;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class zzg implements Callable<Void> {
    final /* synthetic */ SkuDetailsResponseListener zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ List zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ BillingClientImpl zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(BillingClientImpl billingClientImpl, String str, List list, String str2, SkuDetailsResponseListener skuDetailsResponseListener) {
        this.zze = billingClientImpl;
        this.zzb = str;
        this.zzc = list;
        this.zzd = str2;
        this.zza = skuDetailsResponseListener;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        this.zze.zza(new zzj(this, this.zze.zza(this.zzb, this.zzc, this.zzd)));
        return null;
    }
}
