package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzbqx;
import com.google.android.gms.internal.ads.zzbwg;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdkx implements zzczc<zzbyy> {
    private final Executor zzfsj;
    @GuardedBy("this")
    private final zzdnr zzgxu;
    private final zzcxy zzgxy;
    private final zzbgc zzgzs;
    private final Context zzhfk;
    @Nullable
    private zzacl zzhgh;
    @GuardedBy("this")
    private zzdzw<zzbyy> zzhgj;
    private final zzdlh zzhhv;

    public zzdkx(Context context, Executor executor, zzbgc zzbgcVar, zzcxy zzcxyVar, zzdlh zzdlhVar, zzdnr zzdnrVar) {
        this.zzhfk = context;
        this.zzfsj = executor;
        this.zzgzs = zzbgcVar;
        this.zzgxy = zzcxyVar;
        this.zzgxu = zzdnrVar;
        this.zzhhv = zzdlhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final boolean isLoading() {
        zzdzw<zzbyy> zzdzwVar = this.zzhgj;
        return (zzdzwVar == null || zzdzwVar.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final boolean zza(zzvl zzvlVar, String str, zzczb zzczbVar, zzcze<? super zzbyy> zzczeVar) {
        zzvs zzvsVar;
        zzbzy zzahx;
        if (str == null) {
            zzazk.zzev("Ad unit ID should not be null for interstitial ad.");
            this.zzfsj.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdkw
                private final zzdkx zzhhu;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhhu = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhhu.zzauu();
                }
            });
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            if (zzczbVar instanceof zzdku) {
                zzvsVar = ((zzdku) zzczbVar).zzebq;
            } else {
                zzvsVar = new zzvs();
            }
            zzdnp zzavh = this.zzgxu.zzgs(str).zzg(zzvsVar).zzh(zzvlVar).zzavh();
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczu)).booleanValue()) {
                zzahx = this.zzgzs.zzafm().zze(new zzbqx.zza().zzcf(this.zzhfk).zza(zzavh).zzalo()).zze(new zzbwg.zza().zza((zzbua) this.zzgxy, this.zzfsj).zza((AppEventListener) this.zzgxy, this.zzfsj).zzaml()).zzb(new zzcxa(this.zzhgh)).zzahx();
            } else {
                zzbwg.zza zzaVar = new zzbwg.zza();
                zzdlh zzdlhVar = this.zzhhv;
                if (zzdlhVar != null) {
                    zzaVar.zza((zzbrm) zzdlhVar, this.zzfsj).zza((zzbtb) this.zzhhv, this.zzfsj).zza((zzbrr) this.zzhhv, this.zzfsj);
                }
                zzahx = this.zzgzs.zzafm().zze(new zzbqx.zza().zzcf(this.zzhfk).zza(zzavh).zzalo()).zze(zzaVar.zza((zzbua) this.zzgxy, this.zzfsj).zza((zzbrm) this.zzgxy, this.zzfsj).zza((zzbtb) this.zzgxy, this.zzfsj).zza((zzbrr) this.zzgxy, this.zzfsj).zza((zzvc) this.zzgxy, this.zzfsj).zza((AppEventListener) this.zzgxy, this.zzfsj).zza((zzbtt) this.zzgxy, this.zzfsj).zza((zzbsa) this.zzgxy, this.zzfsj).zzaml()).zzb(new zzcxa(this.zzhgh)).zzahx();
            }
            zzdzw<zzbyy> zzalb = zzahx.zzagj().zzalb();
            this.zzhgj = zzalb;
            zzdzk.zza(zzalb, new zzdkz(this, zzczeVar, zzahx), this.zzfsj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzauu() {
        this.zzgxy.zzc(zzdok.zza(zzdom.INVALID_AD_UNIT_ID, null, null));
    }

    public final void zza(zzacl zzaclVar) {
        this.zzhgh = zzaclVar;
    }
}
