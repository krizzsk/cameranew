package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdnw {
    public static <T extends zzbdu & zzaki & zzbfa & zzbfd & zzbfm & zzbfl & zzbfo> zzaif<T> zza(final zzcqr zzcqrVar, final zzdss zzdssVar) {
        return new zzaif(zzdssVar, zzcqrVar) { // from class: com.google.android.gms.internal.ads.zzdnv
            private final zzdss zzhlk;
            private final zzcqr zzhll;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhlk = zzdssVar;
                this.zzhll = zzcqrVar;
            }

            /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.internal.ads.zzbfd, com.google.android.gms.internal.ads.zzbdu] */
            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                int i2;
                zzdss zzdssVar2 = this.zzhlk;
                zzcqr zzcqrVar2 = this.zzhll;
                ?? r9 = (zzbdu) obj;
                String str = (String) map.get("u");
                if (str == null) {
                    zzazk.zzex("URL missing from click GMSG.");
                    return;
                }
                String zza = zzahm.zza(r9, str);
                if (!r9.zzacp().zzhjz) {
                    zzdssVar2.zzel(zza);
                    return;
                }
                long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis();
                String str2 = ((zzbfa) r9).zzadn().zzbvs;
                com.google.android.gms.ads.internal.zzr.zzkr();
                if (com.google.android.gms.ads.internal.util.zzj.zzba(((zzbfd) r9).getContext())) {
                    i2 = zzcqs.zzgru;
                } else {
                    i2 = zzcqs.zzgrt;
                }
                zzcqrVar2.zza(new zzcrc(currentTimeMillis, str2, zza, i2));
            }
        };
    }

    public static <T extends zzbdu & zzbfa & zzbfd & zzbfl> zzaif<T> zzb(final zzcqr zzcqrVar, final zzdss zzdssVar) {
        return new zzaif(zzdssVar, zzcqrVar) { // from class: com.google.android.gms.internal.ads.zzdny
            private final zzdss zzhlk;
            private final zzcqr zzhll;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhlk = zzdssVar;
                this.zzhll = zzcqrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                zzdss zzdssVar2 = this.zzhlk;
                zzcqr zzcqrVar2 = this.zzhll;
                zzbdu zzbduVar = (zzbdu) obj;
                String str = (String) map.get("u");
                if (str == null) {
                    zzazk.zzex("URL missing from httpTrack GMSG.");
                } else if (!zzbduVar.zzacp().zzhjz) {
                    zzdssVar2.zzel(str);
                } else {
                    zzcqrVar2.zza(new zzcrc(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis(), ((zzbfa) zzbduVar).zzadn().zzbvs, str, zzcqs.zzgru));
                }
            }
        };
    }
}
