package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaqy extends zzafw {
    private final /* synthetic */ zzaqw zzdqs;

    private zzaqy(zzaqw zzaqwVar) {
        this.zzdqs = zzaqwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void zza(zzafn zzafnVar, String str) {
        if (zzaqw.zzb(this.zzdqs) == null) {
            return;
        }
        zzaqw.zzb(this.zzdqs).onCustomClick(zzaqw.zza(this.zzdqs, zzafnVar), str);
    }
}
