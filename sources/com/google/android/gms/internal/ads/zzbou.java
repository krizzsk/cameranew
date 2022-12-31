package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbou<T> {
    private final Executor executor;
    private final zzcnf zzfwx;
    private final zzdnp zzfwy;
    private final zzdrj zzfwz;
    private final zzbjg zzfxa;
    private final zzcuz<T> zzfxb;
    private final zzbvu zzfxc;
    @Nullable
    private final zzdnl zzfxd;
    private final zzcob zzfxe;
    private final zzbqu zzfxf;
    private final zzcny zzfxg;
    private final zzcrq zzfxh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbou(zzcnf zzcnfVar, zzdnp zzdnpVar, zzdrj zzdrjVar, zzbjg zzbjgVar, zzcuz<T> zzcuzVar, zzbvu zzbvuVar, @Nullable zzdnl zzdnlVar, zzcob zzcobVar, zzbqu zzbquVar, Executor executor, zzcny zzcnyVar, zzcrq zzcrqVar) {
        this.zzfwx = zzcnfVar;
        this.zzfwy = zzdnpVar;
        this.zzfwz = zzdrjVar;
        this.zzfxa = zzbjgVar;
        this.zzfxb = zzcuzVar;
        this.zzfxc = zzbvuVar;
        this.zzfxd = zzdnlVar;
        this.zzfxe = zzcobVar;
        this.zzfxf = zzbquVar;
        this.executor = executor;
        this.zzfxg = zzcnyVar;
        this.zzfxh = zzcrqVar;
    }

    private final zzdzw<zzdnl> zza(zzdzw<zzatq> zzdzwVar) {
        if (this.zzfxd != null) {
            return this.zzfwz.zzt(zzdrk.SERVER_TRANSACTION).zze(zzdzk.zzag(this.zzfxd)).zzaxj();
        }
        com.google.android.gms.ads.internal.zzr.zzkx().zzmv();
        if (this.zzfwy.zzhkw.zzcia != null) {
            return this.zzfwz.zzt(zzdrk.SERVER_TRANSACTION).zze(this.zzfwx.zzaro()).zzaxj();
        }
        zzdrb<I> zza = this.zzfwz.zza((zzdrj) zzdrk.SERVER_TRANSACTION, (zzdzw) zzdzwVar);
        zzcny zzcnyVar = this.zzfxg;
        zzcnyVar.getClass();
        return zza.zza(zzbot.zza(zzcnyVar)).zzaxj();
    }

    public final zzdzw<zzdnl> zzala() {
        return zza(this.zzfxf.zzalj());
    }

    public final zzdzw<T> zzalb() {
        return zzb(zzala());
    }

    public final zzbvu zzalc() {
        return this.zzfxc;
    }

    public final zzdzw<T> zzb(zzdzw<zzdnl> zzdzwVar) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcwm)).booleanValue()) {
            return this.zzfwz.zza((zzdrj) zzdrk.RENDERER, (zzdzw) zzdzwVar).zza(this.zzfxa).zza(this.zzfxb).zzaxj();
        }
        return this.zzfwz.zza((zzdrj) zzdrk.RENDERER, (zzdzw) zzdzwVar).zza(this.zzfxa).zza(this.zzfxb).zza(((Integer) zzwr.zzqr().zzd(zzabp.zzcwn)).intValue(), TimeUnit.SECONDS).zzaxj();
    }

    public final zzdzw<Void> zzc(zzatq zzatqVar) {
        zzdqw zzaxj = this.zzfwz.zza((zzdrj) zzdrk.NOTIFY_CACHE_HIT, (zzdzw) this.zzfxe.zzm(zzatqVar)).zzaxj();
        zzdzk.zza(zzaxj, new zzboy(this), this.executor);
        return zzaxj;
    }

    public final zzvg zze(Throwable th) {
        return zzdok.zza(th, this.zzfxh);
    }

    public final zzdzw<zzdnl> zza(@NonNull zzatq zzatqVar) {
        return zza(zzdzk.zzag(zzatqVar));
    }

    public final zzdzw<T> zzb(@NonNull zzatq zzatqVar) {
        return zzb(zza(zzatqVar));
    }

    public final zzdzw<zzatq> zza(final zzdpf zzdpfVar) {
        zzdqw zzaxj = this.zzfwz.zza((zzdrj) zzdrk.GET_CACHE_KEY, (zzdzw) this.zzfxf.zzalj()).zza(new zzdyu(this, zzdpfVar) { // from class: com.google.android.gms.internal.ads.zzbow
            private final zzbou zzfxj;
            private final zzdpf zzfxk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfxj = this;
                this.zzfxk = zzdpfVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzfxj.zza(this.zzfxk, (zzatq) obj);
            }
        }).zzaxj();
        zzdzk.zza(zzaxj, new zzbov(this), this.executor);
        return zzaxj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(zzdpf zzdpfVar, zzatq zzatqVar) throws Exception {
        zzatqVar.zzdxk = zzdpfVar;
        return this.zzfxe.zzl(zzatqVar);
    }
}
