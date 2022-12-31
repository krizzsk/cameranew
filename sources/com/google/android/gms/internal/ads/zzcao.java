package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcao implements zzbny<zzbnz> {
    private final zzcco zzfup;
    private final Map<String, zzcrj<zzbnz>> zzfwj;
    private final zzeqo<zzbny<zzblv>> zzgbu;
    private final Map<String, zzcrj<zzcbu>> zzgbv;
    private final Map<String, zzcty<zzcbu>> zzgbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcao(Map<String, zzcrj<zzbnz>> map, Map<String, zzcrj<zzcbu>> map2, Map<String, zzcty<zzcbu>> map3, zzeqo<zzbny<zzblv>> zzeqoVar, zzcco zzccoVar) {
        this.zzfwj = map;
        this.zzgbv = map2;
        this.zzgbw = map3;
        this.zzgbu = zzeqoVar;
        this.zzfup = zzccoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbny
    @Nullable
    public final zzcrj<zzbnz> zze(int i2, String str) {
        zzcrj<zzblv> zze;
        zzcrj<zzbnz> zzcrjVar = this.zzfwj.get(str);
        if (zzcrjVar != null) {
            return zzcrjVar;
        }
        if (i2 == 1) {
            if (this.zzfup.zzaom() == null || (zze = this.zzgbu.get().zze(i2, str)) == null) {
                return null;
            }
            return zzbnz.zza(zze);
        } else if (i2 != 4) {
            return null;
        } else {
            zzcty<zzcbu> zzctyVar = this.zzgbw.get(str);
            if (zzctyVar != null) {
                return zzbnz.zza((zzcty<? extends zzbnt>) zzctyVar);
            }
            zzcrj<zzcbu> zzcrjVar2 = this.zzgbv.get(str);
            if (zzcrjVar2 != null) {
                return zzbnz.zza(zzcrjVar2);
            }
            return null;
        }
    }
}
