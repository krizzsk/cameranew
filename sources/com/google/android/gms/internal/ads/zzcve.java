package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcve implements zzcrr<zzchb, zzdog, zzctd> {
    private final Context context;
    private final Executor zzfsj;
    private final zzchi zzgvn;

    public zzcve(Context context, Executor executor, zzchi zzchiVar) {
        this.context = context;
        this.zzfsj = executor;
        this.zzgvn = zzchiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final void zza(zzdnl zzdnlVar, zzdmw zzdmwVar, zzcrl<zzdog, zzctd> zzcrlVar) throws zzdnt {
        try {
            zzdnp zzdnpVar = zzdnlVar.zzhkr.zzfwy;
            if (zzdnpVar.zzhle.zzhki == zzdnh.zzhkm) {
                zzcrlVar.zzdnl.zzc(this.context, zzdnpVar.zzhkw, zzdmwVar.zzhjj.toString(), zzcrlVar.zzgsu);
            } else {
                zzcrlVar.zzdnl.zzb(this.context, zzdnpVar.zzhkw, zzdmwVar.zzhjj.toString(), zzcrlVar.zzgsu);
            }
        } catch (Exception e2) {
            String valueOf = String.valueOf(zzcrlVar.zzcio);
            zzazk.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrr
    public final /* synthetic */ zzchb zzb(zzdnl zzdnlVar, zzdmw zzdmwVar, final zzcrl<zzdog, zzctd> zzcrlVar) throws zzdnt, zzcva {
        zzchd zza = this.zzgvn.zza(new zzboj(zzdnlVar, zzdmwVar, zzcrlVar.zzcio), new zzchg(new zzcag(zzcrlVar) { // from class: com.google.android.gms.internal.ads.zzcvd
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
                    ((zzdog) zzcrlVar2.zzdnl).zzci(context);
                } catch (zzdnt e2) {
                    throw new zzcaf(e2.getCause());
                }
            }
        }));
        zza.zzagn().zza((zzbsg) new zzbjo(zzcrlVar.zzdnl), this.zzfsj);
        zzcrlVar.zzgsu.zzb(zza.zzaii());
        return zza.zzaig();
    }
}
