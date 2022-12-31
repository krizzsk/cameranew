package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdjg implements zzdzl<zzblv> {
    private final /* synthetic */ zzcze zzgzg;
    private final /* synthetic */ zzbmr zzhgk;
    final /* synthetic */ zzdje zzhgl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdjg(zzdje zzdjeVar, zzcze zzczeVar, zzbmr zzbmrVar) {
        this.zzhgl = zzdjeVar;
        this.zzgzg = zzczeVar;
        this.zzhgk = zzbmrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(zzblv zzblvVar) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        zzbts zzbtsVar;
        Executor executor;
        zzcxy zzcxyVar;
        zzcxy zzcxyVar2;
        zzcys zzcysVar;
        zzblv zzblvVar2 = zzblvVar;
        synchronized (this.zzhgl) {
            this.zzhgl.zzhgj = null;
            viewGroup = this.zzhgl.zzfum;
            viewGroup.removeAllViews();
            if (zzblvVar2.zzajr() != null) {
                ViewParent parent = zzblvVar2.zzajr().getParent();
                if (parent instanceof ViewGroup) {
                    String mediationAdapterClassName = zzblvVar2.zzakr() != null ? zzblvVar2.zzakr().getMediationAdapterClassName() : "";
                    StringBuilder sb = new StringBuilder(String.valueOf(mediationAdapterClassName).length() + 78);
                    sb.append("Banner view provided from ");
                    sb.append(mediationAdapterClassName);
                    sb.append(" already has a parent view. Removing its old parent.");
                    zzazk.zzex(sb.toString());
                    ((ViewGroup) parent).removeView(zzblvVar2.zzajr());
                }
            }
            zzaba<Boolean> zzabaVar = zzabp.zzczs;
            if (((Boolean) zzwr.zzqr().zzd(zzabaVar)).booleanValue()) {
                zzbve zzakt = zzblvVar2.zzakt();
                zzcxyVar2 = this.zzhgl.zzgxy;
                zzbve zza = zzakt.zza(zzcxyVar2);
                zzcysVar = this.zzhgl.zzhgg;
                zza.zza(zzcysVar);
            }
            viewGroup2 = this.zzhgl.zzfum;
            viewGroup2.addView(zzblvVar2.zzajr());
            this.zzgzg.onSuccess(zzblvVar2);
            if (((Boolean) zzwr.zzqr().zzd(zzabaVar)).booleanValue()) {
                executor = this.zzhgl.zzfsj;
                zzcxyVar = this.zzhgl.zzgxy;
                zzcxyVar.getClass();
                executor.execute(zzdjj.zzb(zzcxyVar));
            }
            zzbtsVar = this.zzhgl.zzhgi;
            zzbtsVar.zzdx(zzblvVar2.zzaka());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        zzbts zzbtsVar;
        Executor executor;
        final zzvg zze = this.zzhgk.zzagj().zze(th);
        synchronized (this.zzhgl) {
            this.zzhgl.zzhgj = null;
            this.zzhgk.zzagk().zzc(zze);
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczs)).booleanValue()) {
                executor = this.zzhgl.zzfsj;
                executor.execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzdji
                    private final zzvg zzgzk;
                    private final zzdjg zzhgn;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhgn = this;
                        this.zzgzk = zze;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcxy zzcxyVar;
                        zzdjg zzdjgVar = this.zzhgn;
                        zzvg zzvgVar = this.zzgzk;
                        zzcxyVar = zzdjgVar.zzhgl.zzgxy;
                        zzcxyVar.zzc(zzvgVar);
                    }
                });
            }
            zzbtsVar = this.zzhgl.zzhgi;
            zzbtsVar.zzdx(60);
            zzdod.zza(zze.errorCode, th, "BannerAdLoader.onFailure");
            this.zzgzg.zzasi();
        }
    }
}
