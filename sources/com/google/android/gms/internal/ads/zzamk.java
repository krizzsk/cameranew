package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.tapjoy.TapjoyAuctionFlags;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzamk<I, O> implements zzamb<I, O> {
    private final zzakz zzdkx;
    private final zzamd<O> zzdky;
    private final zzamc<I> zzdkz;
    private final String zzdla;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamk(zzakz zzakzVar, String str, zzamc<I> zzamcVar, zzamd<O> zzamdVar) {
        this.zzdkx = zzakzVar;
        this.zzdla = str;
        this.zzdkz = zzamcVar;
        this.zzdky = zzamdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzalm zzalmVar, zzalx zzalxVar, I i2, zzbaa<O> zzbaaVar) {
        try {
            com.google.android.gms.ads.internal.zzr.zzkr();
            String zzyy = com.google.android.gms.ads.internal.util.zzj.zzyy();
            zzahm.zzdhq.zza(zzyy, new zzamp(this, zzalmVar, zzbaaVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TapjoyAuctionFlags.AUCTION_ID, zzyy);
            jSONObject.put("args", this.zzdkz.zzi(i2));
            zzalxVar.zzb(this.zzdla, jSONObject);
        } catch (Exception e2) {
            try {
                zzbaaVar.setException(e2);
                zzazk.zzc("Unable to invokeJavascript", e2);
            } finally {
                zzalmVar.release();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyu
    public final zzdzw<O> zzf(@Nullable I i2) throws Exception {
        return zzh(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzamb
    public final zzdzw<O> zzh(I i2) {
        zzbaa zzbaaVar = new zzbaa();
        zzalm zzb = this.zzdkx.zzb((zzei) null);
        zzb.zza(new zzamn(this, zzb, i2, zzbaaVar), new zzamm(this, zzbaaVar, zzb));
        return zzbaaVar;
    }
}
