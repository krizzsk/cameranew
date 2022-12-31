package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdmm implements zzcze<zzchb> {
    private final /* synthetic */ zzdmk zzhis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmm(zzdmk zzdmkVar) {
        this.zzhis = zzdmkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcze
    public final /* synthetic */ void onSuccess(zzchb zzchbVar) {
        zzchb zzchbVar2;
        zzchb zzchbVar3 = zzchbVar;
        synchronized (this.zzhis) {
            this.zzhis.zzhir = zzchbVar3;
            zzchbVar2 = this.zzhis.zzhir;
            zzchbVar2.zzakb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcze
    public final void zzasi() {
        synchronized (this.zzhis) {
            this.zzhis.zzhir = null;
        }
    }
}
