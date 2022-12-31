package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcui implements zzcrr<zzcbu, zzapk, zzctd> {
    private final Context context;
    private final zzcau zzgun;
    private zzanx zzguw;

    public zzcui(Context context, zzcau zzcauVar) {
        this.context = context;
        this.zzgun = zzcauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final void zza(zzdnl zzdnlVar, zzdmw zzdmwVar, zzcrl<zzapk, zzctd> zzcrlVar) throws zzdnt {
        try {
            zzcrlVar.zzdnl.zzdm(zzdmwVar.zzdoq);
            zzcrlVar.zzdnl.zza(zzdmwVar.zzeuo, zzdmwVar.zzhjj.toString(), zzdnlVar.zzhkr.zzfwy.zzhkw, d.z0(this.context), new zzcuk(this, zzcrlVar), zzcrlVar.zzgsu);
        } catch (RemoteException e2) {
            throw new zzdnt(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final /* synthetic */ zzcbu zzb(zzdnl zzdnlVar, zzdmw zzdmwVar, zzcrl<zzapk, zzctd> zzcrlVar) throws zzdnt, zzcva {
        if (zzdnlVar.zzhkr.zzfwy.zzhky.contains(Integer.toString(6))) {
            zzccd zzb = zzccd.zzb(this.zzguw);
            if (zzdnlVar.zzhkr.zzfwy.zzhky.contains(Integer.toString(zzb.zzanu()))) {
                zzcci zza = this.zzgun.zza(new zzboj(zzdnlVar, zzdmwVar, zzcrlVar.zzcio), new zzccp(zzb), new zzcee(null, null, this.zzguw));
                zzcrlVar.zzgsu.zzb(zza.zzagt());
                return zza.zzagu();
            }
            throw new zzcva(zzdom.INTERNAL_ERROR, "No corresponding native ad listener");
        }
        throw new zzcva(zzdom.INVALID_REQUEST, "Unified must be used for RTB.");
    }
}
