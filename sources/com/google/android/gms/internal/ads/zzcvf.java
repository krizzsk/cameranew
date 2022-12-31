package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcvf implements zzcrr<zzchb, zzapk, zzctd> {
    private final Context context;
    private final zzchi zzgvn;

    public zzcvf(Context context, zzchi zzchiVar) {
        this.context = context;
        this.zzgvn = zzchiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final void zza(zzdnl zzdnlVar, zzdmw zzdmwVar, zzcrl<zzapk, zzctd> zzcrlVar) throws zzdnt {
        try {
            zzcrlVar.zzdnl.zzdm(zzdmwVar.zzdoq);
            if (zzdnlVar.zzhkr.zzfwy.zzhle.zzhki == zzdnh.zzhkm) {
                zzcrlVar.zzdnl.zzb(zzdmwVar.zzeuo, zzdmwVar.zzhjj.toString(), zzdnlVar.zzhkr.zzfwy.zzhkw, d.z0(this.context), new zzcvh(this, zzcrlVar), zzcrlVar.zzgsu);
            } else {
                zzcrlVar.zzdnl.zza(zzdmwVar.zzeuo, zzdmwVar.zzhjj.toString(), zzdnlVar.zzhkr.zzfwy.zzhkw, d.z0(this.context), new zzcvh(this, zzcrlVar), zzcrlVar.zzgsu);
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Remote exception loading a rewarded RTB ad", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final /* synthetic */ zzchb zzb(zzdnl zzdnlVar, zzdmw zzdmwVar, zzcrl<zzapk, zzctd> zzcrlVar) throws zzdnt, zzcva {
        zzctn zzctnVar = new zzctn(zzdmwVar, zzcrlVar.zzdnl, true);
        zzchd zza = this.zzgvn.zza(new zzboj(zzdnlVar, zzdmwVar, zzcrlVar.zzcio), new zzchg(zzctnVar));
        zzctnVar.zza(zza.zzagq());
        zzcrlVar.zzgsu.zzb(zza.zzaij());
        return zza.zzaig();
    }
}
