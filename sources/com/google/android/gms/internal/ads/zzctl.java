package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzctl implements zzcag {
    private final Context context;
    private final zzazn zzboz;
    private final zzdmw zzgeu;
    private final zzdzw<zzbza> zzgtj;
    private final zzbeb zzgtk;

    private zzctl(Context context, zzazn zzaznVar, zzdzw<zzbza> zzdzwVar, zzdmw zzdmwVar, zzbeb zzbebVar) {
        this.context = context;
        this.zzboz = zzaznVar;
        this.zzgtj = zzdzwVar;
        this.zzgeu = zzdmwVar;
        this.zzgtk = zzbebVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcag
    public final void zza(boolean z, Context context) {
        this.zzgtk.zzay(true);
        com.google.android.gms.ads.internal.zzr.zzkr();
        com.google.android.gms.ads.internal.zzk zzkVar = new com.google.android.gms.ads.internal.zzk(false, com.google.android.gms.ads.internal.util.zzj.zzax(this.context), false, 0.0f, -1, z, this.zzgeu.zzftq, false);
        com.google.android.gms.ads.internal.zzr.zzkq();
        zzbzw zzahf = ((zzbza) zzdzk.zzb(this.zzgtj)).zzahf();
        zzbeb zzbebVar = this.zzgtk;
        zzdmw zzdmwVar = this.zzgeu;
        int i2 = zzdmwVar.zzhjp;
        zzazn zzaznVar = this.zzboz;
        String str = zzdmwVar.zzdwd;
        zzdnd zzdndVar = zzdmwVar.zzhjg;
        com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel((zzvc) null, zzahf, (com.google.android.gms.ads.internal.overlay.zzv) null, zzbebVar, i2, zzaznVar, str, zzkVar, zzdndVar.zzdsw, zzdndVar.zzdsy), true);
    }
}
