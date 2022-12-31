package com.android.billingclient.api;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class zzz implements Runnable {
    private final /* synthetic */ Exception zza;
    private final /* synthetic */ ConsumeResponseListener zzb;
    private final /* synthetic */ String zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(BillingClientImpl billingClientImpl, Exception exc, ConsumeResponseListener consumeResponseListener, String str) {
        this.zza = exc;
        this.zzb = consumeResponseListener;
        this.zzc = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
        sb.append("Error consuming purchase; ex: ");
        sb.append(valueOf);
        com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb.toString());
        this.zzb.onConsumeResponse(zzak.zzo, this.zzc);
    }
}
