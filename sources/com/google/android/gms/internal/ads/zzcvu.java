package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcvu implements zzcag {
    private final Context context;
    private final zzazn zzboz;
    private final zzdmw zzesr;
    private final zzdnp zzfwy;
    private final zzchq zzggk;
    private final zzdzw<zzchd> zzgtj;
    private final zzbeb zzgvt;

    private zzcvu(Context context, zzchq zzchqVar, zzdnp zzdnpVar, zzazn zzaznVar, zzdmw zzdmwVar, zzdzw<zzchd> zzdzwVar, zzbeb zzbebVar) {
        this.context = context;
        this.zzggk = zzchqVar;
        this.zzfwy = zzdnpVar;
        this.zzboz = zzaznVar;
        this.zzesr = zzdmwVar;
        this.zzgtj = zzdzwVar;
        this.zzgvt = zzbebVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcag
    public final void zza(boolean z, Context context) {
        zzbeb zzbebVar;
        zzbeb zzbebVar2;
        zzchd zzchdVar = (zzchd) zzdzk.zzb(this.zzgtj);
        try {
            zzdmw zzdmwVar = this.zzesr;
            if (!this.zzgvt.zzadm()) {
                zzbebVar2 = this.zzgvt;
            } else {
                if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcpd)).booleanValue()) {
                    zzbebVar2 = this.zzgvt;
                } else {
                    final zzbeb zze = this.zzggk.zze(this.zzfwy.zzbpo);
                    zzaio.zza(zze, zzchdVar.zzaih());
                    final zzcig zzcigVar = new zzcig();
                    zzcigVar.zzc(this.context, zze.getView());
                    zzchdVar.zzahe().zza(zze, true);
                    zze.zzacx().zza(new zzbfq(zzcigVar, zze) { // from class: com.google.android.gms.internal.ads.zzcvt
                        private final zzbeb zzggw;
                        private final zzcig zzgtf;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzgtf = zzcigVar;
                            this.zzggw = zze;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbfq
                        public final void zzal(boolean z2) {
                            zzcig zzcigVar2 = this.zzgtf;
                            zzbeb zzbebVar3 = this.zzggw;
                            zzcigVar2.zzapr();
                            zzbebVar3.zzacr();
                            zzbebVar3.zzacx().zzadv();
                        }
                    });
                    zzbfn zzacx = zze.zzacx();
                    zze.getClass();
                    zzacx.zza(zzcvw.zzn(zze));
                    zzdnd zzdndVar = zzdmwVar.zzhjg;
                    zze.zzb(zzdndVar.zzdsw, zzdndVar.zzdsy, null);
                    zzbebVar = zze;
                    zzbebVar.zzay(true);
                    com.google.android.gms.ads.internal.zzr.zzkr();
                    boolean zzax = com.google.android.gms.ads.internal.util.zzj.zzax(this.context);
                    zzdmw zzdmwVar2 = this.zzesr;
                    com.google.android.gms.ads.internal.zzk zzkVar = new com.google.android.gms.ads.internal.zzk(false, zzax, false, 0.0f, -1, z, zzdmwVar2.zzftq, zzdmwVar2.zzbpm);
                    com.google.android.gms.ads.internal.zzr.zzkq();
                    zzbzw zzahf = zzchdVar.zzahf();
                    zzdmw zzdmwVar3 = this.zzesr;
                    int i2 = zzdmwVar3.zzhjp;
                    zzazn zzaznVar = this.zzboz;
                    String str = zzdmwVar3.zzdwd;
                    zzdnd zzdndVar2 = zzdmwVar3.zzhjg;
                    com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel((zzvc) null, zzahf, (com.google.android.gms.ads.internal.overlay.zzv) null, zzbebVar, i2, zzaznVar, str, zzkVar, zzdndVar2.zzdsw, zzdndVar2.zzdsy), true);
                }
            }
            zzbebVar = zzbebVar2;
            zzbebVar.zzay(true);
            com.google.android.gms.ads.internal.zzr.zzkr();
            boolean zzax2 = com.google.android.gms.ads.internal.util.zzj.zzax(this.context);
            zzdmw zzdmwVar22 = this.zzesr;
            com.google.android.gms.ads.internal.zzk zzkVar2 = new com.google.android.gms.ads.internal.zzk(false, zzax2, false, 0.0f, -1, z, zzdmwVar22.zzftq, zzdmwVar22.zzbpm);
            com.google.android.gms.ads.internal.zzr.zzkq();
            zzbzw zzahf2 = zzchdVar.zzahf();
            zzdmw zzdmwVar32 = this.zzesr;
            int i22 = zzdmwVar32.zzhjp;
            zzazn zzaznVar2 = this.zzboz;
            String str2 = zzdmwVar32.zzdwd;
            zzdnd zzdndVar22 = zzdmwVar32.zzhjg;
            com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel((zzvc) null, zzahf2, (com.google.android.gms.ads.internal.overlay.zzv) null, zzbebVar, i22, zzaznVar2, str2, zzkVar2, zzdndVar22.zzdsw, zzdndVar22.zzdsy), true);
        } catch (zzben e2) {
            zzazk.zzc("", e2);
        }
    }
}
