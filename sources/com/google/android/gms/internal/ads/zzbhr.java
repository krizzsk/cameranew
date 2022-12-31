package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbhr implements zzbng {
    private zzeqo<zzdmw> zzffs;
    private zzeqo<Set<zzbya<zzbsh>>> zzffv;
    private zzeqo<zzbsg> zzffw;
    private zzeqo<zzbud> zzffx;
    private zzeqo<zzdnl> zzffz;
    private zzeqo<Set<zzbya<zzbtb>>> zzfhe;
    private zzeqo<zzbsw> zzfhf;
    private zzeqo<String> zzfhz;
    private zzeqo<zzbrh> zzfia;
    private zzeqo<zzbnw> zzfib;
    private final /* synthetic */ zzbhp zzfne;
    private final zzbnf zzfnw;
    private zzeqo<zzagl> zzfnx;
    private zzeqo<Runnable> zzfny;
    private zzeqo<zzbnb> zzfnz;

    private zzbhr(zzbhp zzbhpVar, zzboj zzbojVar, zzbnf zzbnfVar) {
        zzeqo zzeqoVar;
        this.zzfne = zzbhpVar;
        this.zzfnw = zzbnfVar;
        this.zzffz = zzbon.zze(zzbojVar);
        this.zzffs = zzbom.zzc(zzbojVar);
        zzeqk zzbmo = zzeqk.zzas(0, 2).zzax(zzbhp.zzm(zzbhpVar)).zzax(zzbhp.zzl(zzbhpVar)).zzbmo();
        this.zzffv = zzbmo;
        this.zzffw = zzeqc.zzau(zzbsn.zzj(zzbmo));
        zzeqk zzbmo2 = zzeqk.zzas(4, 3).zzaw(zzbhp.zzh(zzbhpVar)).zzaw(zzbhp.zzg(zzbhpVar)).zzaw(zzbhp.zzf(zzbhpVar)).zzax(zzbhp.zzak(zzbhpVar)).zzax(zzbhp.zzaj(zzbhpVar)).zzax(zzbhp.zzai(zzbhpVar)).zzaw(zzbhp.zzc(zzbhpVar)).zzbmo();
        this.zzfhe = zzbmo2;
        this.zzfhf = zzeqc.zzau(zzbsy.zzl(zzbmo2));
        zzbol zza = zzbol.zza(zzbojVar);
        this.zzfhz = zza;
        this.zzfia = zzbrg.zzm(this.zzffs, zza, zzbhp.zzi(zzbhpVar));
        this.zzffx = zzeqc.zzau(zzbvg.zzalv());
        this.zzfib = zzbpn.zza(this.zzffz, this.zzffs, this.zzffw, this.zzfhf, zzbhp.zzal(zzbhpVar), this.zzfia, this.zzffx);
        this.zzfnx = new zzbnh(zzbnfVar);
        zzbni zzbniVar = new zzbni(zzbnfVar);
        this.zzfny = zzbniVar;
        zzeqo<zzbnw> zzeqoVar2 = this.zzfib;
        zzeqo<zzagl> zzeqoVar3 = this.zzfnx;
        zzeqoVar = zzbhpVar.zzffq.zzewz;
        this.zzfnz = zzeqc.zzau(new zzbnk(zzeqoVar2, zzeqoVar3, zzbniVar, zzeqoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final zzblv zzahu() {
        return (zzblv) zzeqh.zza(this.zzfnz.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
