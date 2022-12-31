package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcug implements zzcrr<zzcbu, zzdog, zzctd> {
    private final Context context;
    private final Executor zzfsj;
    private final zzcau zzgun;

    public zzcug(Context context, zzcau zzcauVar, Executor executor) {
        this.context = context;
        this.zzgun = zzcauVar;
        this.zzfsj = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final void zza(zzdnl zzdnlVar, zzdmw zzdmwVar, zzcrl<zzdog, zzctd> zzcrlVar) throws zzdnt {
        zzdnp zzdnpVar = zzdnlVar.zzhkr.zzfwy;
        zzcrlVar.zzdnl.zza(this.context, zzdnlVar.zzhkr.zzfwy.zzhkw, zzdmwVar.zzhjj.toString(), com.google.android.gms.ads.internal.util.zzbh.zza(zzdmwVar.zzhjg), zzcrlVar.zzgsu, zzdnpVar.zzdoe, zzdnpVar.zzhky);
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final /* synthetic */ zzcbu zzb(zzdnl zzdnlVar, zzdmw zzdmwVar, zzcrl<zzdog, zzctd> zzcrlVar) throws zzdnt, zzcva {
        zzccd zza;
        zzanr zzuv = zzcrlVar.zzdnl.zzuv();
        zzans zzuw = zzcrlVar.zzdnl.zzuw();
        zzanx zzvb = zzcrlVar.zzdnl.zzvb();
        if (zzvb != null && zza(zzdnlVar, 6)) {
            zza = zzccd.zzb(zzvb);
        } else if (zzuv != null && zza(zzdnlVar, 6)) {
            zza = zzccd.zzb(zzuv);
        } else if (zzuv != null && zza(zzdnlVar, 2)) {
            zza = zzccd.zza(zzuv);
        } else if (zzuw != null && zza(zzdnlVar, 6)) {
            zza = zzccd.zzb(zzuw);
        } else if (zzuw != null && zza(zzdnlVar, 1)) {
            zza = zzccd.zza(zzuw);
        } else {
            throw new zzcva(zzdom.INTERNAL_ERROR, "No native ad mappers");
        }
        if (zzdnlVar.zzhkr.zzfwy.zzhky.contains(Integer.toString(zza.zzanu()))) {
            zzcci zza2 = this.zzgun.zza(new zzboj(zzdnlVar, zzdmwVar, zzcrlVar.zzcio), new zzccp(zza), new zzcee(zzuw, zzuv, zzvb));
            zzcrlVar.zzgsu.zzb(zza2.zzags());
            zza2.zzagn().zza((zzbsg) new zzbjo(zzcrlVar.zzdnl), this.zzfsj);
            return zza2.zzagu();
        }
        throw new zzcva(zzdom.INTERNAL_ERROR, "No corresponding native ad listener");
    }

    private static boolean zza(zzdnl zzdnlVar, int i2) {
        return zzdnlVar.zzhkr.zzfwy.zzhky.contains(Integer.toString(i2));
    }
}
