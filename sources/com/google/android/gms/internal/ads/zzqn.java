package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzqn implements Runnable {
    private final /* synthetic */ zzqj zzbna;
    private final /* synthetic */ int zzbnb;
    private final /* synthetic */ long zzbnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqn(zzqj zzqjVar, int i2, long j2) {
        this.zzbna = zzqjVar;
        this.zzbnb = i2;
        this.zzbnc = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        zzqkVar = this.zzbna.zzbmz;
        zzqkVar.zzg(this.zzbnb, this.zzbnc);
    }
}
