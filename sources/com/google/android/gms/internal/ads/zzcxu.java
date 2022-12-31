package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcxu extends zzxh {
    private zzwx zzbps;
    private final zzbgc zzguy;
    private final Context zzgxt;
    private final zzdnr zzgxu;
    private final zzccq zzgxv;

    public zzcxu(zzbgc zzbgcVar, Context context, String str) {
        zzdnr zzdnrVar = new zzdnr();
        this.zzgxu = zzdnrVar;
        this.zzgxv = new zzccq();
        this.zzguy = zzbgcVar;
        zzdnrVar.zzgs(str);
        this.zzgxt = context;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(zzafr zzafrVar) {
        this.zzgxv.zzb(zzafrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzwx zzwxVar) {
        this.zzbps = zzwxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final zzxd zzqz() {
        zzcco zzaor = this.zzgxv.zzaor();
        this.zzgxu.zzc(zzaor.zzaoo());
        this.zzgxu.zzd(zzaor.zzaop());
        zzdnr zzdnrVar = this.zzgxu;
        if (zzdnrVar.zzkg() == null) {
            zzdnrVar.zzg(zzvs.zzqe());
        }
        return new zzcxt(this.zzgxt, this.zzguy, this.zzgxu, zzaor, this.zzbps);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(zzagg zzaggVar) {
        this.zzgxv.zzb(zzaggVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzxz zzxzVar) {
        this.zzgxu.zzc(zzxzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(zzafs zzafsVar) {
        this.zzgxv.zzb(zzafsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(String str, zzafy zzafyVar, zzafx zzafxVar) {
        this.zzgxv.zzb(str, zzafyVar, zzafxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(zzaeh zzaehVar) {
        this.zzgxu.zzd(zzaehVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(zzajt zzajtVar) {
        this.zzgxu.zzb(zzajtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(zzakb zzakbVar) {
        this.zzgxv.zzb(zzakbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(zzagf zzagfVar, zzvs zzvsVar) {
        this.zzgxv.zza(zzagfVar);
        this.zzgxu.zzg(zzvsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzgxu.zzb(publisherAdViewOptions);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzgxu.zzb(adManagerAdViewOptions);
    }
}
