package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcnc implements zzcnz {
    private static final Pattern zzgoi = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzfri;
    private final zzdnp zzfwy;
    private final zzdzv zzghl;
    private final zzcme zzgog;
    private final zzcqb zzgoh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnc(zzdnp zzdnpVar, zzcme zzcmeVar, zzdzv zzdzvVar, ScheduledExecutorService scheduledExecutorService, zzcqb zzcqbVar) {
        this.zzfwy = zzdnpVar;
        this.zzgog = zzcmeVar;
        this.zzghl = zzdzvVar;
        this.zzfri = scheduledExecutorService;
        this.zzgoh = zzcqbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zzd(InputStream inputStream) throws Exception {
        return zzdzk.zzag(new zzdnl(new zzdng(this.zzfwy), zzdnj.zza(new InputStreamReader(inputStream))));
    }

    @Override // com.google.android.gms.internal.ads.zzcnz
    public final zzdzw<zzdnl> zzh(zzatq zzatqVar) {
        zzdzw<zzdnl> zzb = zzdzk.zzb(this.zzgog.zze(zzatqVar), new zzdyu(this) { // from class: com.google.android.gms.internal.ads.zzcnb
            private final zzcnc zzgof;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgof = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzgof.zzd((InputStream) obj);
            }
        }, this.zzghl);
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcwm)).booleanValue()) {
            zzb = zzdzk.zzb(zzdzk.zza(zzb, ((Integer) zzwr.zzqr().zzd(zzabp.zzcwn)).intValue(), TimeUnit.SECONDS, this.zzfri), TimeoutException.class, zzcne.zzboq, zzazp.zzeih);
        }
        zzdzk.zza(zzb, new zzcnd(this), zzazp.zzeih);
        return zzb;
    }
}
