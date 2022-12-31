package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzug;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzciy implements zzeqb<zztu> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzug.zza.EnumC0160zza> zzftc;
    private final zzeqo<String> zzfyr;
    private final zzeqo<zzazn> zzfze;
    private final zzeqo<String> zzgku;

    private zzciy(zzeqo<Context> zzeqoVar, zzeqo<String> zzeqoVar2, zzeqo<zzazn> zzeqoVar3, zzeqo<zzug.zza.EnumC0160zza> zzeqoVar4, zzeqo<String> zzeqoVar5) {
        this.zzewk = zzeqoVar;
        this.zzfyr = zzeqoVar2;
        this.zzfze = zzeqoVar3;
        this.zzftc = zzeqoVar4;
        this.zzgku = zzeqoVar5;
    }

    public static zzciy zze(zzeqo<Context> zzeqoVar, zzeqo<String> zzeqoVar2, zzeqo<zzazn> zzeqoVar3, zzeqo<zzug.zza.EnumC0160zza> zzeqoVar4, zzeqo<String> zzeqoVar5) {
        return new zzciy(zzeqoVar, zzeqoVar2, zzeqoVar3, zzeqoVar4, zzeqoVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        final String str = this.zzfyr.get();
        zzazn zzaznVar = this.zzfze.get();
        final zzug.zza.EnumC0160zza enumC0160zza = this.zzftc.get();
        final String str2 = this.zzgku.get();
        zztu zztuVar = new zztu(new zztz(this.zzewk.get()));
        final zzug.zzu zzuVar = (zzug.zzu) ((zzelb) zzug.zzu.zzpn().zzcq(zzaznVar.zzehy).zzcr(zzaznVar.zzehz).zzcs(zzaznVar.zzeia ? 0 : 2).zzbiw());
        zztuVar.zza(new zztx(enumC0160zza, str, zzuVar, str2) { // from class: com.google.android.gms.internal.ads.zzciv
            private final String zzdjf;
            private final zzug.zza.EnumC0160zza zzgkr;
            private final zzug.zzu zzgks;
            private final String zzgkt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkr = enumC0160zza;
                this.zzdjf = str;
                this.zzgks = zzuVar;
                this.zzgkt = str2;
            }

            @Override // com.google.android.gms.internal.ads.zztx
            public final void zza(zzug.zzi.zza zzaVar) {
                zzug.zza.EnumC0160zza enumC0160zza2 = this.zzgkr;
                String str3 = this.zzdjf;
                zzug.zzu zzuVar2 = this.zzgks;
                zzaVar.zza(zzaVar.zzoe().zzbij().zzb(enumC0160zza2)).zza(zzaVar.zzod().zzbij().zzbw(str3).zzb(zzuVar2)).zzby(this.zzgkt);
            }
        });
        return (zztu) zzeqh.zza(zztuVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
