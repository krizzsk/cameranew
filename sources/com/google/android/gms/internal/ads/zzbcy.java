package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbcy implements zzbdl {
    @Override // com.google.android.gms.internal.ads.zzbdl
    public final zzbdd zza(zzbbo zzbboVar, int i2, String str, zzbbl zzbblVar) {
        if (i2 > 0) {
            int zzack = zzbck.zzack();
            if (zzack < zzbblVar.zzelm) {
                return new zzbds(zzbboVar, zzbblVar);
            }
            if (zzack < zzbblVar.zzelg) {
                return new zzbdp(zzbboVar, zzbblVar);
            }
            return new zzbdn(zzbboVar);
        }
        return new zzbdo(zzbboVar);
    }
}
