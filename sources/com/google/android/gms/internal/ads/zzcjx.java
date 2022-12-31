package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcjx implements zzdrp {
    private zztu zzgkx;
    private Map<zzdrk, zzcjz> zzgld;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcjx(zztu zztuVar, Map<zzdrk, zzcjz> map) {
        this.zzgld = map;
        this.zzgkx = zztuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdrp
    public final void zza(zzdrk zzdrkVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdrp
    public final void zza(zzdrk zzdrkVar, String str, Throwable th) {
        if (this.zzgld.containsKey(zzdrkVar)) {
            this.zzgkx.zza(this.zzgld.get(zzdrkVar).zzgli);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdrp
    public final void zzb(zzdrk zzdrkVar, String str) {
        if (this.zzgld.containsKey(zzdrkVar)) {
            this.zzgkx.zza(this.zzgld.get(zzdrkVar).zzglg);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdrp
    public final void zzc(zzdrk zzdrkVar, String str) {
        if (this.zzgld.containsKey(zzdrkVar)) {
            this.zzgkx.zza(this.zzgld.get(zzdrkVar).zzglh);
        }
    }
}
