package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzfd implements Runnable {
    private final /* synthetic */ int zzzm;
    private final /* synthetic */ boolean zzzn;
    private final /* synthetic */ zzfc zzzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfd(zzfc zzfcVar, int i2, boolean z) {
        this.zzzo = zzfcVar;
        this.zzzm = i2;
        this.zzzn = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zza;
        zzcf.zza zzb = this.zzzo.zzb(this.zzzm, this.zzzn);
        this.zzzo.zzzf = zzb;
        zza = zzfc.zza(this.zzzm, zzb);
        if (zza) {
            this.zzzo.zza(this.zzzm + 1, this.zzzn);
        }
    }
}
