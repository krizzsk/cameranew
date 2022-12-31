package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzchb extends zzbnt {
    private final Context context;
    private final zzavl zzdzk;
    private final WeakReference<zzbeb> zzgbe;
    private final zzbxo zzgbf;
    private final zzboq zzgbg;
    private final zzdtm zzgbh;
    private final zzbrt zzgbi;
    private final zzcag zzgbj;
    private boolean zzgiq;
    private final zzbta zzgjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzchb(zzbnw zzbnwVar, Context context, @Nullable zzbeb zzbebVar, zzcag zzcagVar, zzbxo zzbxoVar, zzbrt zzbrtVar, zzbta zzbtaVar, zzboq zzboqVar, zzdmw zzdmwVar, zzdtm zzdtmVar) {
        super(zzbnwVar);
        this.zzgiq = false;
        this.context = context;
        this.zzgbj = zzcagVar;
        this.zzgbe = new WeakReference<>(zzbebVar);
        this.zzgbf = zzbxoVar;
        this.zzgbi = zzbrtVar;
        this.zzgjf = zzbtaVar;
        this.zzgbg = zzboqVar;
        this.zzgbh = zzdtmVar;
        this.zzdzk = new zzawi(zzdmwVar.zzdwm);
    }

    public final void finalize() throws Throwable {
        try {
            zzbeb zzbebVar = this.zzgbe.get();
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyw)).booleanValue()) {
                if (!this.zzgiq && zzbebVar != null) {
                    zzdzv zzdzvVar = zzazp.zzeig;
                    zzbebVar.getClass();
                    zzdzvVar.execute(zzche.zze(zzbebVar));
                }
            } else if (zzbebVar != null) {
                zzbebVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle getAdMetadata() {
        return this.zzgjf.getAdMetadata();
    }

    public final boolean isClosed() {
        return this.zzgbg.isClosed();
    }

    public final boolean isUsed() {
        return this.zzgiq;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context] */
    public final boolean zzb(boolean z, @Nullable Activity activity) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcov)).booleanValue()) {
            com.google.android.gms.ads.internal.zzr.zzkr();
            if (com.google.android.gms.ads.internal.util.zzj.zzaq(this.context)) {
                zzazk.zzex("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzgbi.zzalp();
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcow)).booleanValue()) {
                    this.zzgbh.zzhf(this.zzfrd.zzhks.zzess.zzbvs);
                }
                return false;
            }
        }
        if (this.zzgiq) {
            zzazk.zzex("The rewarded ad have been showed.");
            this.zzgbi.zzl(zzdok.zza(zzdom.AD_REUSED, null, null));
            return false;
        }
        this.zzgiq = true;
        this.zzgbf.zzalf();
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.context;
        }
        try {
            this.zzgbj.zza(z, activity2);
            this.zzgbf.zzald();
            return true;
        } catch (zzcaf e2) {
            this.zzgbi.zza(e2);
            return false;
        }
    }

    public final zzavl zzrv() {
        return this.zzdzk;
    }

    public final boolean zzrw() {
        zzbeb zzbebVar = this.zzgbe.get();
        return (zzbebVar == null || zzbebVar.zzadm()) ? false : true;
    }
}
