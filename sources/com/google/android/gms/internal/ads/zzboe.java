package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzboe {
    private final Executor executor;
    private volatile boolean zzafd = true;
    private final ScheduledExecutorService zzfri;
    private final zzdzw<zzbnz> zzfwn;

    public zzboe(Executor executor, ScheduledExecutorService scheduledExecutorService, zzdzw<zzbnz> zzdzwVar) {
        this.executor = executor;
        this.zzfri = scheduledExecutorService;
        this.zzfwn = zzdzwVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaku() {
        zzazp.zzeig.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzboi
            private final zzboe zzfwo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfwo = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfwo.zzakv();
            }
        });
    }

    public final boolean isLoading() {
        return this.zzafd;
    }

    public final void zza(zzdzl<zzbnt> zzdzlVar) {
        zzdzk.zza(this.zzfwn, new zzboh(this, zzdzlVar), this.executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzakv() {
        this.zzafd = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(List<? extends zzdzw<? extends zzbnt>> list, final zzdzl<zzbnt> zzdzlVar) {
        if (list != null && !list.isEmpty()) {
            zzdzw zzag = zzdzk.zzag(null);
            for (final zzdzw<? extends zzbnt> zzdzwVar : list) {
                zzag = zzdzk.zzb(zzdzk.zzb(zzag, Throwable.class, new zzdyu(zzdzlVar) { // from class: com.google.android.gms.internal.ads.zzbog
                    private final zzdzl zzfwm;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfwm = zzdzlVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdyu
                    public final zzdzw zzf(Object obj) {
                        this.zzfwm.zzb((Throwable) obj);
                        return zzdzk.zzag(null);
                    }
                }, this.executor), new zzdyu(this, zzdzlVar, zzdzwVar) { // from class: com.google.android.gms.internal.ads.zzbof
                    private final zzboe zzfwo;
                    private final zzdzl zzfwp;
                    private final zzdzw zzfwq;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfwo = this;
                        this.zzfwp = zzdzlVar;
                        this.zzfwq = zzdzwVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdyu
                    public final zzdzw zzf(Object obj) {
                        return this.zzfwo.zza(this.zzfwp, this.zzfwq, (zzbnt) obj);
                    }
                }, this.executor);
            }
            zzdzk.zza(zzag, new zzbok(this, zzdzlVar), this.executor);
            return;
        }
        this.executor.execute(new Runnable(zzdzlVar) { // from class: com.google.android.gms.internal.ads.zzbod
            private final zzdzl zzfwm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfwm = zzdzlVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfwm.zzb(new zzcmb(zzdom.NO_FILL));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(zzdzl zzdzlVar, zzdzw zzdzwVar, zzbnt zzbntVar) throws Exception {
        if (zzbntVar != null) {
            zzdzlVar.onSuccess(zzbntVar);
        }
        return zzdzk.zza(zzdzwVar, zzadv.zzdfb.get().longValue(), TimeUnit.MILLISECONDS, this.zzfri);
    }
}
