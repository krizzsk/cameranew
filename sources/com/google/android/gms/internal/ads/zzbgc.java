package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbig;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzbgc implements zzbjd {
    @GuardedBy("AppComponent.class")
    private static zzbgc zzewb;

    public static zzbgc zza(Context context, zzane zzaneVar, int i2) {
        zzbgc zzh = zzh(context, i2);
        zzh.zzaff().zzb(zzaneVar);
        return zzh;
    }

    @Deprecated
    public static zzbgc zzh(Context context, int i2) {
        synchronized (zzbgc.class) {
            zzbgc zzbgcVar = zzewb;
            return zzbgcVar != null ? zzbgcVar : zza(new zzazn(204204000, i2, true, false), context, new zzbgw());
        }
    }

    protected abstract zzdga zza(zzdhj zzdhjVar);

    public abstract zzdrz zzaez();

    public abstract Executor zzafa();

    public abstract ScheduledExecutorService zzafb();

    public abstract Executor zzafc();

    public abstract zzdzv zzafd();

    public abstract zzbts zzafe();

    public abstract zzcin zzaff();

    public abstract zzbim zzafg();

    public abstract zzbmu zzafh();

    public abstract zzdjn zzafi();

    public abstract zzbla zzafj();

    public abstract zzblj zzafk();

    public abstract zzdic zzafl();

    public abstract zzbzx zzafm();

    public abstract zzdle zzafn();

    public abstract zzcat zzafo();

    public abstract zzchh zzafp();

    public abstract zzdmr zzafq();

    public abstract zzczl zzafr();

    public abstract zzczo zzafs();

    public abstract zzcrb zzaft();

    public abstract zzdof<zzcgk> zzafu();

    @Deprecated
    private static zzbgc zza(zzazn zzaznVar, Context context, zzbig.zza zzaVar) {
        zzbgc zzbgcVar;
        synchronized (zzbgc.class) {
            if (zzewb == null) {
                zzewb = new zzbhs().zzc(new zzbgb(new zzbgb.zza().zza(zzaznVar).zzbw(context))).zza(new zzbig(zzaVar)).zzahv();
                zzabp.initialize(context);
                com.google.android.gms.ads.internal.zzr.zzkv().zzd(context, zzaznVar);
                com.google.android.gms.ads.internal.zzr.zzkx().initialize(context);
                com.google.android.gms.ads.internal.zzr.zzkr().zzak(context);
                com.google.android.gms.ads.internal.zzr.zzkr().zzal(context);
                com.google.android.gms.ads.internal.zzr.zzkr();
                com.google.android.gms.ads.internal.util.zzj.zzbb(context);
                com.google.android.gms.ads.internal.util.zzb.zzaj(context);
                com.google.android.gms.ads.internal.zzr.zzku().initialize(context);
                com.google.android.gms.ads.internal.zzr.zzlm().initialize(context);
                com.google.android.gms.ads.internal.util.zzf zzxs = com.google.android.gms.ads.internal.zzr.zzkv().zzxs();
                zzxs.initialize(context);
                zzaxa.zza(context, zzxs);
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxy)).booleanValue()) {
                    if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcot)).booleanValue()) {
                        zztu zztuVar = new zztu(new zztz(context));
                        zzcpv zzcpvVar = new zzcpv(new zzcpt(context), zzewb.zzafd());
                        com.google.android.gms.ads.internal.zzr.zzkr();
                        new zzcql(context, zzaznVar, zztuVar, zzcpvVar, com.google.android.gms.ads.internal.util.zzj.zzyy(), zzewb.zzaez()).zzarx();
                    }
                }
            }
            zzbgcVar = zzewb;
        }
        return zzbgcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjd
    public final zzdga zza(zzatq zzatqVar, int i2) {
        return zza(new zzdhj(zzatqVar, i2));
    }
}
