package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzctq implements zzcrr<zzbyy, zzdog, zzctd> {
    private final Context context;
    private final zzazn zzboz;
    private final Executor zzfsj;
    private final zzbzy zzgtz;

    public zzctq(Context context, zzazn zzaznVar, zzbzy zzbzyVar, Executor executor) {
        this.context = context;
        this.zzboz = zzaznVar;
        this.zzgtz = zzbzyVar;
        this.zzfsj = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final void zza(zzdnl zzdnlVar, zzdmw zzdmwVar, zzcrl<zzdog, zzctd> zzcrlVar) throws zzdnt {
        if (this.zzboz.zzehz < 4100000) {
            zzcrlVar.zzdnl.zza(this.context, zzdnlVar.zzhkr.zzfwy.zzhkw, zzdmwVar.zzhjj.toString(), zzcrlVar.zzgsu);
        } else {
            zzcrlVar.zzdnl.zza(this.context, zzdnlVar.zzhkr.zzfwy.zzhkw, zzdmwVar.zzhjj.toString(), com.google.android.gms.ads.internal.util.zzbh.zza(zzdmwVar.zzhjg), zzcrlVar.zzgsu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final /* synthetic */ zzbyy zzb(zzdnl zzdnlVar, zzdmw zzdmwVar, final zzcrl<zzdog, zzctd> zzcrlVar) throws zzdnt, zzcva {
        zzbza zza = this.zzgtz.zza(new zzboj(zzdnlVar, zzdmwVar, zzcrlVar.zzcio), new zzbyz(new zzcag(zzcrlVar) { // from class: com.google.android.gms.internal.ads.zzctp
            private final zzcrl zzgtt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgtt = zzcrlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzcag
            public final void zza(boolean z, Context context) {
                zzcrl zzcrlVar2 = this.zzgtt;
                try {
                    ((zzdog) zzcrlVar2.zzdnl).setImmersiveMode(z);
                    ((zzdog) zzcrlVar2.zzdnl).showInterstitial();
                } catch (zzdnt e2) {
                    zzazk.zzew("Cannot show interstitial.");
                    throw new zzcaf(e2.getCause());
                }
            }
        }));
        zza.zzagn().zza((zzbsg) new zzbjo(zzcrlVar.zzdnl), this.zzfsj);
        zzcrlVar.zzgsu.zzb(zza.zzags());
        return zza.zzahz();
    }
}
