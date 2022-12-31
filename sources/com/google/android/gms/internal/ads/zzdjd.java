package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdjd implements zzcze<zzblq> {
    private final /* synthetic */ zzdiz zzhgf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdjd(zzdiz zzdizVar) {
        this.zzhgf = zzdizVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcze
    public final /* synthetic */ void onSuccess(zzblq zzblqVar) {
        zzdil zzdilVar;
        zzdil zzdilVar2;
        zzblq zzblqVar2 = zzblqVar;
        synchronized (this.zzhgf) {
            zzblq zzblqVar3 = this.zzhgf.zzhgd;
            if (zzblqVar3 != null) {
                zzblqVar3.destroy();
            }
            zzdiz zzdizVar = this.zzhgf;
            zzdizVar.zzhgd = zzblqVar2;
            zzdizVar.zza(zzblqVar2);
            zzdilVar = this.zzhgf.zzhfd;
            zzdiz zzdizVar2 = this.zzhgf;
            zzdilVar2 = zzdizVar2.zzhfd;
            zzdilVar.zzb(new zzblp(zzblqVar2, zzdizVar2, zzdilVar2));
            zzblqVar2.zzakb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcze
    public final void zzasi() {
        synchronized (this.zzhgf) {
            this.zzhgf.zzhgd = null;
        }
    }
}
