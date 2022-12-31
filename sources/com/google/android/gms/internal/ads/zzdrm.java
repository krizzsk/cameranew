package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdrm extends zzbwf<zzdrp> implements zzdrh<zzdrk> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdrm(Set<zzbya<zzdrp>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdrh
    public final void zza(final zzdqw<zzdrk, ?> zzdqwVar) {
        zza(new zzbwh(zzdqwVar) { // from class: com.google.android.gms.internal.ads.zzdrl
            private final zzdqw zzhrf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhrf = zzdqwVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                zzdqw zzdqwVar2 = this.zzhrf;
                ((zzdrp) obj).zza((zzdrk) zzdqwVar2.zzaxh(), zzdqwVar2.zzaxi());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdrh
    public final void zzb(final zzdqw<zzdrk, ?> zzdqwVar) {
        zza(new zzbwh(zzdqwVar) { // from class: com.google.android.gms.internal.ads.zzdro
            private final zzdqw zzhrf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhrf = zzdqwVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                zzdqw zzdqwVar2 = this.zzhrf;
                ((zzdrp) obj).zzb((zzdrk) zzdqwVar2.zzaxh(), zzdqwVar2.zzaxi());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdrh
    public final void zzc(final zzdqw<zzdrk, ?> zzdqwVar) {
        zza(new zzbwh(zzdqwVar) { // from class: com.google.android.gms.internal.ads.zzdrq
            private final zzdqw zzhrf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhrf = zzdqwVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                zzdqw zzdqwVar2 = this.zzhrf;
                ((zzdrp) obj).zzc((zzdrk) zzdqwVar2.zzaxh(), zzdqwVar2.zzaxi());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdrh
    public final void zza(final zzdqw<zzdrk, ?> zzdqwVar, final Throwable th) {
        zza(new zzbwh(zzdqwVar, th) { // from class: com.google.android.gms.internal.ads.zzdrn
            private final zzdqw zzhrf;
            private final Throwable zzhrg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhrf = zzdqwVar;
                this.zzhrg = th;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                zzdqw zzdqwVar2 = this.zzhrf;
                ((zzdrp) obj).zza((zzdrk) zzdqwVar2.zzaxh(), zzdqwVar2.zzaxi(), this.zzhrg);
            }
        });
    }
}
