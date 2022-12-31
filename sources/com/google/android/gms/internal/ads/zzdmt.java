package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdmt implements zzcze<zzchb> {
    private final /* synthetic */ zzdmq zzhiv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmt(zzdmq zzdmqVar) {
        this.zzhiv = zzdmqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcze
    public final /* synthetic */ void onSuccess(zzchb zzchbVar) {
        zzchb zzchbVar2;
        zzchb zzchbVar3 = zzchbVar;
        synchronized (this.zzhiv) {
            this.zzhiv.zzhir = zzchbVar3;
            zzchbVar2 = this.zzhiv.zzhir;
            zzchbVar2.zzakb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcze
    public final void zzasi() {
        synchronized (this.zzhiv) {
            this.zzhiv.zzhir = null;
        }
    }
}
