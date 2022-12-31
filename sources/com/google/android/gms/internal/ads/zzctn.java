package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzctn implements zzcag {
    @Nullable
    private zzbsd zzfxz = null;
    private final zzdmw zzfya;
    private final zzapk zzgul;
    private final boolean zzgum;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzctn(zzdmw zzdmwVar, zzapk zzapkVar, boolean z) {
        this.zzfya = zzdmwVar;
        this.zzgul = zzapkVar;
        this.zzgum = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcag
    public final void zza(boolean z, Context context) throws zzcaf {
        boolean zzz;
        try {
            if (this.zzgum) {
                zzz = this.zzgul.zzaa(d.z0(context));
            } else {
                zzz = this.zzgul.zzz(d.z0(context));
            }
            if (zzz) {
                if (this.zzfxz == null) {
                    return;
                }
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcre)).booleanValue() || this.zzfya.zzhjs != 2) {
                    return;
                }
                this.zzfxz.onAdImpression();
                return;
            }
            throw new zzcaf("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzcaf(th);
        }
    }

    public final void zza(zzbsd zzbsdVar) {
        this.zzfxz = zzbsdVar;
    }
}
