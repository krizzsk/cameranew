package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzql implements Runnable {
    private final /* synthetic */ String zzaje;
    private final /* synthetic */ long zzajf;
    private final /* synthetic */ long zzajg;
    private final /* synthetic */ zzqj zzbna;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzql(zzqj zzqjVar, String str, long j2, long j3) {
        this.zzbna = zzqjVar;
        this.zzaje = str;
        this.zzajf = j2;
        this.zzajg = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        zzqkVar = this.zzbna.zzbmz;
        zzqkVar.zzd(this.zzaje, this.zzajf, this.zzajg);
    }
}
