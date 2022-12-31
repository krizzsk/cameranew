package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzqr implements Runnable {
    private final /* synthetic */ zzjm zzajo;
    private final /* synthetic */ zzqj zzbna;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqr(zzqj zzqjVar, zzjm zzjmVar) {
        this.zzbna = zzqjVar;
        this.zzajo = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        this.zzajo.zzgn();
        zzqkVar = this.zzbna.zzbmz;
        zzqkVar.zzf(this.zzajo);
    }
}
