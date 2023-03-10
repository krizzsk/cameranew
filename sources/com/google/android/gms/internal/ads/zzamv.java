package com.google.android.gms.internal.ads;

import com.tapjoy.TapjoyAuctionFlags;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzamv<I, O> implements zzdyu<I, O> {
    private final zzamd<O> zzdky;
    private final zzamc<I> zzdkz;
    private final String zzdla;
    private final zzdzw<zzalx> zzdle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamv(zzdzw<zzalx> zzdzwVar, String str, zzamc<I> zzamcVar, zzamd<O> zzamdVar) {
        this.zzdle = zzdzwVar;
        this.zzdla = str;
        this.zzdkz = zzamcVar;
        this.zzdky = zzamdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(Object obj, zzalx zzalxVar) throws Exception {
        zzbaa zzbaaVar = new zzbaa();
        com.google.android.gms.ads.internal.zzr.zzkr();
        String zzyy = com.google.android.gms.ads.internal.util.zzj.zzyy();
        zzahm.zzdhq.zza(zzyy, new zzamx(this, zzbaaVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TapjoyAuctionFlags.AUCTION_ID, zzyy);
        jSONObject.put("args", this.zzdkz.zzi(obj));
        zzalxVar.zzb(this.zzdla, jSONObject);
        return zzbaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyu
    public final zzdzw<O> zzf(final I i2) throws Exception {
        return zzdzk.zzb(this.zzdle, new zzdyu(this, i2) { // from class: com.google.android.gms.internal.ads.zzamu
            private final zzamv zzdlj;
            private final Object zzdlk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlj = this;
                this.zzdlk = i2;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzdlj.zza(this.zzdlk, (zzalx) obj);
            }
        }, zzazp.zzeih);
    }
}
