package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbnt;
import com.google.android.gms.internal.ads.zzbqv;
import com.google.android.gms.internal.ads.zzug;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdjr<R extends zzbqv<AdT>, AdT extends zzbnt> implements zzdkn<R, AdT> {
    private final Executor executor;
    private final zzdkn<R, AdT> zzhfm;
    private final zzdkn<R, zzdka<AdT>> zzhgz;
    private final zzdpu<AdT> zzhha;
    @GuardedBy("this")
    private R zzhhb;

    public zzdjr(zzdkn<R, AdT> zzdknVar, zzdkn<R, zzdka<AdT>> zzdknVar2, zzdpu<AdT> zzdpuVar, Executor executor) {
        this.zzhfm = zzdknVar;
        this.zzhgz = zzdknVar2;
        this.zzhha = zzdpuVar;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzdkn
    /* renamed from: zzauo */
    public final synchronized R zzaun() {
        return this.zzhhb;
    }

    @Override // com.google.android.gms.internal.ads.zzdkn
    public final synchronized zzdzw<AdT> zza(final zzdko zzdkoVar, final zzdkp<R> zzdkpVar) {
        final zzdju zzdjuVar;
        zzdnp zzahg = zzdkpVar.zzc(zzdkoVar.zzhht).zzagm().zzahg();
        zzdjuVar = new zzdju(zzdkpVar, zzdkoVar, zzahg.zzhkw, zzahg.zzhkx, this.executor, zzahg.zzhla, null);
        return zzdzf.zzg(this.zzhgz.zza(zzdkoVar, zzdkpVar)).zzb(new zzdyu(this, zzdkoVar, zzdjuVar, zzdkpVar) { // from class: com.google.android.gms.internal.ads.zzdjq
            private final zzdjr zzhgv;
            private final zzdko zzhgw;
            private final zzdju zzhgx;
            private final zzdkp zzhgy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhgv = this;
                this.zzhgw = zzdkoVar;
                this.zzhgx = zzdjuVar;
                this.zzhgy = zzdkpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzhgv.zza(this.zzhgw, this.zzhgx, this.zzhgy, (zzdka) obj);
            }
        }, this.executor);
    }

    private final zzdzw<AdT> zza(zzdpm<AdT> zzdpmVar, zzdko zzdkoVar, zzdkp<R> zzdkpVar) {
        final zzbqy<R> zzc = zzdkpVar.zzc(zzdkoVar.zzhht);
        if (zzdpmVar.zzhoi != null) {
            R zzagm = zzc.zzagm();
            if (zzagm.zzahh() != null) {
                zzdpmVar.zzhoi.zzaks().zzb(zzagm.zzahh());
            }
            return zzdzk.zzag(zzdpmVar.zzhoi);
        }
        zzc.zza(zzdpmVar.zzeyz);
        zzdzw<AdT> zza = this.zzhfm.zza(zzdkoVar, new zzdkp(zzc) { // from class: com.google.android.gms.internal.ads.zzdjt
            private final zzbqy zzhhd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhhd = zzc;
            }

            @Override // com.google.android.gms.internal.ads.zzdkp
            public final zzbqy zzc(zzdkm zzdkmVar) {
                return this.zzhhd;
            }
        });
        this.zzhhb = this.zzhfm.zzaun();
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(zzdkp zzdkpVar, zzdpy zzdpyVar) throws Exception {
        zzdqa zzdqaVar;
        if (zzdpyVar != null && zzdpyVar.zzhhn != null && (zzdqaVar = zzdpyVar.zzhoy) != null) {
            zzdpyVar.zzhhn.zzhoh.zzalc().zze((zzug.zzb) ((zzelb) zzug.zzb.zznl().zza(zzug.zzb.zza.zznn().zza(zzug.zzb.EnumC0162zzb.IN_MEMORY).zza(zzug.zzb.zzd.zznp())).zzbiw()));
            return zza(zzdpyVar.zzhhn, ((zzdju) zzdqaVar).zzhhf, zzdkpVar);
        }
        throw new zzcmb(zzdom.INTERNAL_ERROR, "Empty prefetch");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(zzdko zzdkoVar, zzdju zzdjuVar, final zzdkp zzdkpVar, zzdka zzdkaVar) throws Exception {
        if (zzdkaVar != null) {
            zzdju zzdjuVar2 = new zzdju(zzdjuVar.zzhhe, zzdjuVar.zzhhf, zzdjuVar.zzdud, zzdjuVar.zzbut, zzdjuVar.executor, zzdjuVar.zzhba, zzdkaVar.zzhhg);
            if (zzdkaVar.zzhhn != null) {
                this.zzhhb = null;
                this.zzhha.zzb(zzdjuVar2);
                return zza(zzdkaVar.zzhhn, zzdkoVar, zzdkpVar);
            }
            zzdzw<zzdpy<AdT>> zzc = this.zzhha.zzc(zzdjuVar2);
            if (zzc != null) {
                this.zzhhb = (R) zzdkpVar.zzc(zzdkoVar.zzhht).zzagm();
                return zzdzk.zzb(zzc, new zzdyu(this, zzdkpVar) { // from class: com.google.android.gms.internal.ads.zzdjs
                    private final zzdjr zzhgv;
                    private final zzdkp zzhhc;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhgv = this;
                        this.zzhhc = zzdkpVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdyu
                    public final zzdzw zzf(Object obj) {
                        return this.zzhgv.zza(this.zzhhc, (zzdpy) obj);
                    }
                }, this.executor);
            }
            this.zzhha.zzb(zzdjuVar2);
            zzdkoVar = new zzdko(zzdkoVar.zzhht, zzdkaVar.zzgoq);
        }
        zzdzw<AdT> zza = this.zzhfm.zza(zzdkoVar, zzdkpVar);
        this.zzhhb = this.zzhfm.zzaun();
        return zza;
    }
}
