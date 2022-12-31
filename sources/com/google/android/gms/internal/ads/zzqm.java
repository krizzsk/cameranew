package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzqm implements Runnable {
    private final /* synthetic */ zzjm zzaji;
    private final /* synthetic */ zzqj zzbna;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqm(zzqj zzqjVar, zzjm zzjmVar) {
        this.zzbna = zzqjVar;
        this.zzaji = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        zzqkVar = this.zzbna.zzbmz;
        zzqkVar.zze(this.zzaji);
    }
}
