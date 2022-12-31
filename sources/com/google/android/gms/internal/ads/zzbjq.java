package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjq implements zzbrm, zzbsa, zzbse, zzbtb, zzvc {
    private final Context context;
    private final Executor executor;
    private final zzacq zzesn;
    private final zzdnl zzfrd;
    private final zzdsq zzfre;
    private final ScheduledExecutorService zzfri;
    private final zzdmw zzfrj;
    private final zzdnx zzfrk;
    private final zzei zzfrl;
    private final zzacv zzfrm;
    private final WeakReference<View> zzfrn;
    @GuardedBy("this")
    private boolean zzfro;
    @GuardedBy("this")
    private boolean zzfrp;

    public zzbjq(Context context, Executor executor, ScheduledExecutorService scheduledExecutorService, zzdnl zzdnlVar, zzdmw zzdmwVar, zzdsq zzdsqVar, zzdnx zzdnxVar, @Nullable View view, zzei zzeiVar, zzacq zzacqVar, zzacv zzacvVar) {
        this.context = context;
        this.executor = executor;
        this.zzfri = scheduledExecutorService;
        this.zzfrd = zzdnlVar;
        this.zzfrj = zzdmwVar;
        this.zzfre = zzdsqVar;
        this.zzfrk = zzdnxVar;
        this.zzfrl = zzeiVar;
        this.zzfrn = new WeakReference<>(view);
        this.zzesn = zzacqVar;
        this.zzfrm = zzacvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvc
    public final void onAdClicked() {
        if (!(((Boolean) zzwr.zzqr().zzd(zzabp.zzcoq)).booleanValue() && this.zzfrd.zzhks.zzess.zzeeb) && zzadj.zzddy.get().booleanValue()) {
            zzdzk.zza(zzdzf.zzg(this.zzfrm.zza(this.context, this.zzesn.zzsx(), this.zzesn.zzsy())).zza(((Long) zzwr.zzqr().zzd(zzabp.zzcpo)).longValue(), TimeUnit.MILLISECONDS, this.zzfri), new zzbjp(this), this.executor);
            return;
        }
        zzdnx zzdnxVar = this.zzfrk;
        zzdsq zzdsqVar = this.zzfre;
        zzdnl zzdnlVar = this.zzfrd;
        zzdmw zzdmwVar = this.zzfrj;
        List<String> zza = zzdsqVar.zza(zzdnlVar, zzdmwVar, zzdmwVar.zzdmp);
        com.google.android.gms.ads.internal.zzr.zzkr();
        zzdnxVar.zza(zza, com.google.android.gms.ads.internal.util.zzj.zzba(this.context) ? zzcqs.zzgru : zzcqs.zzgrt);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final synchronized void onAdImpression() {
        if (!this.zzfrp) {
            String zza = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcsq)).booleanValue() ? this.zzfrl.zzca().zza(this.context, this.zzfrn.get(), (Activity) null) : null;
            if (!(((Boolean) zzwr.zzqr().zzd(zzabp.zzcoq)).booleanValue() && this.zzfrd.zzhks.zzess.zzeeb) && zzadj.zzddz.get().booleanValue()) {
                zzdzk.zza(zzdzf.zzg(this.zzfrm.zzk(this.context)).zza(((Long) zzwr.zzqr().zzd(zzabp.zzcpo)).longValue(), TimeUnit.MILLISECONDS, this.zzfri), new zzbjs(this, zza), this.executor);
                this.zzfrp = true;
            }
            zzdnx zzdnxVar = this.zzfrk;
            zzdsq zzdsqVar = this.zzfre;
            zzdnl zzdnlVar = this.zzfrd;
            zzdmw zzdmwVar = this.zzfrj;
            zzdnxVar.zzj(zzdsqVar.zza(zzdnlVar, zzdmwVar, false, zza, null, zzdmwVar.zzdmq));
            this.zzfrp = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final synchronized void onAdLoaded() {
        if (this.zzfro) {
            ArrayList arrayList = new ArrayList(this.zzfrj.zzdmq);
            arrayList.addAll(this.zzfrj.zzhja);
            this.zzfrk.zzj(this.zzfre.zza(this.zzfrd, this.zzfrj, true, null, null, arrayList));
        } else {
            zzdnx zzdnxVar = this.zzfrk;
            zzdsq zzdsqVar = this.zzfre;
            zzdnl zzdnlVar = this.zzfrd;
            zzdmw zzdmwVar = this.zzfrj;
            zzdnxVar.zzj(zzdsqVar.zza(zzdnlVar, zzdmwVar, zzdmwVar.zzhjc));
            zzdnx zzdnxVar2 = this.zzfrk;
            zzdsq zzdsqVar2 = this.zzfre;
            zzdnl zzdnlVar2 = this.zzfrd;
            zzdmw zzdmwVar2 = this.zzfrj;
            zzdnxVar2.zzj(zzdsqVar2.zza(zzdnlVar2, zzdmwVar2, zzdmwVar2.zzhja));
        }
        this.zzfro = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onRewardedVideoCompleted() {
        zzdnx zzdnxVar = this.zzfrk;
        zzdsq zzdsqVar = this.zzfre;
        zzdnl zzdnlVar = this.zzfrd;
        zzdmw zzdmwVar = this.zzfrj;
        zzdnxVar.zzj(zzdsqVar.zza(zzdnlVar, zzdmwVar, zzdmwVar.zzhjb));
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onRewardedVideoStarted() {
        zzdnx zzdnxVar = this.zzfrk;
        zzdsq zzdsqVar = this.zzfre;
        zzdnl zzdnlVar = this.zzfrd;
        zzdmw zzdmwVar = this.zzfrj;
        zzdnxVar.zzj(zzdsqVar.zza(zzdnlVar, zzdmwVar, zzdmwVar.zzdwn));
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zzb(zzauk zzaukVar, String str, String str2) {
        zzdnx zzdnxVar = this.zzfrk;
        zzdsq zzdsqVar = this.zzfre;
        zzdmw zzdmwVar = this.zzfrj;
        zzdnxVar.zzj(zzdsqVar.zza(zzdmwVar, zzdmwVar.zzdwo, zzaukVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbsa
    public final void zzk(zzvg zzvgVar) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrd)).booleanValue()) {
            this.zzfrk.zzj(this.zzfre.zza(this.zzfrd, this.zzfrj, zzdsq.zza(2, zzvgVar.errorCode, this.zzfrj.zzhjd)));
        }
    }
}
