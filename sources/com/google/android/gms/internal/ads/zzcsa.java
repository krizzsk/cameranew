package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcsa implements zzcag {
    private final zzazn zzboz;
    private final zzdnp zzfwy;
    private final zzdmw zzgeu;
    private final zzdzw<zzbli> zzgtj;
    private final zzbeb zzgtk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsa(zzazn zzaznVar, zzdzw<zzbli> zzdzwVar, zzdmw zzdmwVar, zzbeb zzbebVar, zzdnp zzdnpVar) {
        this.zzboz = zzaznVar;
        this.zzgtj = zzdzwVar;
        this.zzgeu = zzdmwVar;
        this.zzgtk = zzbebVar;
        this.zzfwy = zzdnpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcag
    public final void zza(boolean z, Context context) {
        int i2;
        this.zzgtk.zzay(true);
        com.google.android.gms.ads.internal.zzk zzkVar = new com.google.android.gms.ads.internal.zzk(true, true, false, 0.0f, -1, z, this.zzgeu.zzftq, false);
        com.google.android.gms.ads.internal.zzr.zzkq();
        zzbzw zzahf = ((zzbli) zzdzk.zzb(this.zzgtj)).zzahf();
        zzbeb zzbebVar = this.zzgtk;
        int i3 = this.zzgeu.zzhjp;
        if (i3 == -1) {
            zzvx zzvxVar = this.zzfwy.zzhla;
            if (zzvxVar != null) {
                int i4 = zzvxVar.orientation;
                if (i4 == 1) {
                    i2 = 7;
                } else if (i4 == 2) {
                    i2 = 6;
                }
                zzazn zzaznVar = this.zzboz;
                zzdmw zzdmwVar = this.zzgeu;
                String str = zzdmwVar.zzdwd;
                zzdnd zzdndVar = zzdmwVar.zzhjg;
                com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel((zzvc) null, zzahf, (com.google.android.gms.ads.internal.overlay.zzv) null, zzbebVar, i2, zzaznVar, str, zzkVar, zzdndVar.zzdsw, zzdndVar.zzdsy), true);
            }
            zzazk.zzdy("Error setting app open orientation; no targeting orientation available.");
            i3 = this.zzgeu.zzhjp;
        }
        i2 = i3;
        zzazn zzaznVar2 = this.zzboz;
        zzdmw zzdmwVar2 = this.zzgeu;
        String str2 = zzdmwVar2.zzdwd;
        zzdnd zzdndVar2 = zzdmwVar2.zzhjg;
        com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel((zzvc) null, zzahf, (com.google.android.gms.ads.internal.overlay.zzv) null, zzbebVar, i2, zzaznVar2, str2, zzkVar, zzdndVar2.zzdsw, zzdndVar2.zzdsy), true);
    }
}
