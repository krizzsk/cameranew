package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcsp implements zzcrr<zzblv, zzapk, zzctd> {
    private final Context context;
    private View view;
    private final zzbmr zzgto;

    public zzcsp(Context context, zzbmr zzbmrVar) {
        this.context = context;
        this.zzgto = zzbmrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final void zza(zzdnl zzdnlVar, zzdmw zzdmwVar, zzcrl<zzapk, zzctd> zzcrlVar) throws zzdnt {
        try {
            zzcrlVar.zzdnl.zzdm(zzdmwVar.zzdoq);
            zzcrlVar.zzdnl.zza(zzdmwVar.zzeuo, zzdmwVar.zzhjj.toString(), zzdnlVar.zzhkr.zzfwy.zzhkw, d.z0(this.context), new zzcsu(this, zzcrlVar), zzcrlVar.zzgsu, zzdnlVar.zzhkr.zzfwy.zzbpo);
        } catch (RemoteException e2) {
            throw new zzdnt(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final /* synthetic */ zzblv zzb(zzdnl zzdnlVar, zzdmw zzdmwVar, final zzcrl<zzapk, zzctd> zzcrlVar) throws zzdnt, zzcva {
        zzbly zza = this.zzgto.zza(new zzboj(zzdnlVar, zzdmwVar, zzcrlVar.zzcio), new zzbmc(this.view, null, new zzbnu(zzcrlVar) { // from class: com.google.android.gms.internal.ads.zzcss
            private final zzcrl zzgtt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgtt = zzcrlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbnu
            public final zzzc getVideoController() {
                return zzcsp.zza(this.zzgtt);
            }
        }, zzdmwVar.zzhji.get(0)));
        zza.zzahp().zzv(this.view);
        zzcrlVar.zzgsu.zzb(zza.zzagt());
        return zza.zzaho();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ zzzc zza(zzcrl zzcrlVar) throws zzdnt {
        try {
            return ((zzapk) zzcrlVar.zzdnl).getVideoController();
        } catch (RemoteException e2) {
            throw new zzdnt(e2);
        }
    }
}
