package com.android.billingclient.api;

import java.util.concurrent.Callable;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzl implements Callable<Void> {
    private final /* synthetic */ ConsumeParams zza;
    private final /* synthetic */ ConsumeResponseListener zzb;
    private final /* synthetic */ BillingClientImpl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(BillingClientImpl billingClientImpl, ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        this.zzc = billingClientImpl;
        this.zza = consumeParams;
        this.zzb = consumeResponseListener;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        this.zzc.zza(this.zza, this.zzb);
        return null;
    }
}
