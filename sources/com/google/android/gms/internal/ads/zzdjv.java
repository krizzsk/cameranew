package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbnt;
import com.google.android.gms.internal.ads.zzbqv;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdjv<R extends zzbqv<AdT>, AdT extends zzbnt> implements zzdpx<AdT> {
    private final zzdkn<R, zzdpm<AdT>> zzhhh;

    public zzdjv(zzdkn<R, zzdpm<AdT>> zzdknVar) {
        this.zzhhh = zzdknVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdpx
    public final zzdzw<zzdpm<AdT>> zza(zzdqa zzdqaVar) {
        zzdju zzdjuVar = (zzdju) zzdqaVar;
        return this.zzhhh.zza(zzdjuVar.zzhhf, zzdjuVar.zzhhe);
    }

    @Override // com.google.android.gms.internal.ads.zzdpx
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzdpx
    public final void zza(zzdpm<AdT> zzdpmVar) {
        zzdpmVar.zzhoh = this.zzhhh.zzaun().zzagj();
    }
}
