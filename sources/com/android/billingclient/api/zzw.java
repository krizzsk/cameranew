package com.android.billingclient.api;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class zzw implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ ConsumeResponseListener zzb;
    private final /* synthetic */ BillingResult zzc;
    private final /* synthetic */ String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(BillingClientImpl billingClientImpl, int i2, ConsumeResponseListener consumeResponseListener, BillingResult billingResult, String str) {
        this.zza = i2;
        this.zzb = consumeResponseListener;
        this.zzc = billingResult;
        this.zzd = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(63);
        sb.append("Error consuming purchase with token. Response code: ");
        sb.append(i2);
        com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb.toString());
        this.zzb.onConsumeResponse(this.zzc, this.zzd);
    }
}
