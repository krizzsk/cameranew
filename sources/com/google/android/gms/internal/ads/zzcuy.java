package com.google.android.gms.internal.ads;

import com.tencent.tauth.AuthActivity;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcuy {
    private final zzckn zzdib;
    private final zzdrz zzdic;
    private final zzcim zzgkk;
    private final zzdoc zzglj;

    public zzcuy(zzdoc zzdocVar, zzcim zzcimVar, zzckn zzcknVar, zzdrz zzdrzVar) {
        this.zzglj = zzdocVar;
        this.zzgkk = zzcimVar;
        this.zzdib = zzcknVar;
        this.zzdic = zzdrzVar;
    }

    public final void zza(zzdnb zzdnbVar, zzdmw zzdmwVar, int i2, @Nullable zzcrn zzcrnVar, long j2) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
            zzdsa zzu = zzdsa.zzgx("adapter_status").zzb(zzdnbVar).zzf(zzdmwVar).zzu("adapter_l", String.valueOf(j2)).zzu("sc", Integer.toString(i2));
            if (zzcrnVar != null) {
                zzu.zzu("arec", Integer.toString(zzcrnVar.zzary().errorCode));
                String zzgt = this.zzglj.zzgt(zzcrnVar.getMessage());
                if (zzgt != null) {
                    zzu.zzu("areec", zzgt);
                }
            }
            zzcij zzi = this.zzgkk.zzi(zzdmwVar.zzhjh);
            if (zzi != null) {
                zzu.zzu("ancn", zzi.zzdit);
                zzapy zzapyVar = zzi.zzgkg;
                if (zzapyVar != null) {
                    zzu.zzu("adapter_v", zzapyVar.toString());
                }
                zzapy zzapyVar2 = zzi.zzgkh;
                if (zzapyVar2 != null) {
                    zzu.zzu("adapter_sv", zzapyVar2.toString());
                }
            }
            this.zzdic.zzb(zzu);
            return;
        }
        zzckq zzr = this.zzdib.zzaqr().zza(zzdnbVar).zzc(zzdmwVar).zzr(AuthActivity.ACTION_KEY, "adapter_status").zzr("adapter_l", String.valueOf(j2));
        zzr.zzr("sc", Integer.toString(i2));
        if (zzcrnVar != null) {
            zzr.zzr("arec", Integer.toString(zzcrnVar.zzary().errorCode));
            String zzgt2 = this.zzglj.zzgt(zzcrnVar.getMessage());
            if (zzgt2 != null) {
                zzr.zzr("areec", zzgt2);
            }
        }
        zzcij zzi2 = this.zzgkk.zzi(zzdmwVar.zzhjh);
        if (zzi2 != null) {
            zzr.zzr("ancn", zzi2.zzdit);
            zzapy zzapyVar3 = zzi2.zzgkg;
            if (zzapyVar3 != null) {
                zzr.zzr("adapter_v", zzapyVar3.toString());
            }
            zzapy zzapyVar4 = zzi2.zzgkh;
            if (zzapyVar4 != null) {
                zzr.zzr("adapter_sv", zzapyVar4.toString());
            }
        }
        zzr.zzaqt();
    }
}
