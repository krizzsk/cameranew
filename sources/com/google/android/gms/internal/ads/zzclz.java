package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzclz extends zzaji {
    private final /* synthetic */ zzclq zzgng;
    private final /* synthetic */ Object zzgnh;
    private final /* synthetic */ String zzgni;
    private final /* synthetic */ long zzgnj;
    private final /* synthetic */ zzbaa zzgnk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzclz(zzclq zzclqVar, Object obj, String str, long j2, zzbaa zzbaaVar) {
        this.zzgng = zzclqVar;
        this.zzgnh = obj;
        this.zzgni = str;
        this.zzgnj = j2;
        this.zzgnk = zzbaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzajj
    public final void onInitializationFailed(String str) {
        zzcla zzclaVar;
        zzbxg zzbxgVar;
        synchronized (this.zzgnh) {
            this.zzgng.zza(this.zzgni, false, str, (int) (com.google.android.gms.ads.internal.zzr.zzky().a() - this.zzgnj));
            zzclaVar = this.zzgng.zzgmx;
            zzclaVar.zzs(this.zzgni, "error");
            zzbxgVar = this.zzgng.zzgmz;
            zzbxgVar.zzm(this.zzgni, "error");
            this.zzgnk.set(Boolean.FALSE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajj
    public final void onInitializationSucceeded() {
        zzcla zzclaVar;
        zzbxg zzbxgVar;
        synchronized (this.zzgnh) {
            this.zzgng.zza(this.zzgni, true, "", (int) (com.google.android.gms.ads.internal.zzr.zzky().a() - this.zzgnj));
            zzclaVar = this.zzgng.zzgmx;
            zzclaVar.zzgg(this.zzgni);
            zzbxgVar = this.zzgng.zzgmz;
            zzbxgVar.zzfu(this.zzgni);
            this.zzgnk.set(Boolean.TRUE);
        }
    }
}
