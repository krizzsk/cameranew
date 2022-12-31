package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.b;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdiz extends zzxo implements com.google.android.gms.ads.internal.overlay.zzq, zzsh {
    private final String zzbut;
    private final zzbgc zzguy;
    private final Context zzgxt;
    private final zzdil zzhfd;
    @Nullable
    @GuardedBy("this")
    private zzbkq zzhff;
    private final zzdix zzhgb;
    @Nullable
    @GuardedBy("this")
    protected zzblq zzhgd;
    private AtomicBoolean zzhfb = new AtomicBoolean();
    @GuardedBy("this")
    private long zzhgc = -1;

    public zzdiz(zzbgc zzbgcVar, Context context, String str, zzdix zzdixVar, zzdil zzdilVar) {
        this.zzguy = zzbgcVar;
        this.zzgxt = context;
        this.zzbut = str;
        this.zzhgb = zzdixVar;
        this.zzhfd = zzdilVar;
        zzdilVar.zza(this);
    }

    private final synchronized void zzeb(int i2) {
        if (this.zzhfb.compareAndSet(false, true)) {
            this.zzhfd.onAdClosed();
            zzbkq zzbkqVar = this.zzhff;
            if (zzbkqVar != null) {
                com.google.android.gms.ads.internal.zzr.zzku().zzb(zzbkqVar);
            }
            if (this.zzhgd != null) {
                long j2 = -1;
                if (this.zzhgc != -1) {
                    j2 = com.google.android.gms.ads.internal.zzr.zzky().a() - this.zzhgc;
                }
                this.zzhgd.zzb(j2, i2);
            }
            destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void destroy() {
        q.e("destroy must be called on the main UI thread.");
        zzblq zzblqVar = this.zzhgd;
        if (zzblqVar != null) {
            zzblqVar.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized String getAdUnitId() {
        return this.zzbut;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized zzzc getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized boolean isLoading() {
        return this.zzhgb.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void onUserLeaveHint() {
        zzblq zzblqVar = this.zzhgd;
        if (zzblqVar != null) {
            zzblqVar.zzb(com.google.android.gms.ads.internal.zzr.zzky().a() - this.zzhgc, zzbkw.zzfts);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void pause() {
        q.e("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void resume() {
        q.e("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void setManualImpressionsEnabled(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void showInterstitial() {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzary zzaryVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzase zzaseVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzauu zzauuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzvl zzvlVar, zzxc zzxcVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzvx zzvxVar) {
        this.zzhgb.zza(zzvxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzww zzwwVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwx zzwxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxs zzxsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxt zzxtVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyb zzybVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyw zzywVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzzi zzziVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaug() {
        this.zzguy.zzafa().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdiy
            private final zzdiz zzhga;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhga = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhga.zzauh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzauh() {
        zzeb(zzbkw.zzftw);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzbl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zze(b bVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final b zzke() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zzkf() {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized zzvs zzkg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized String zzkh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized zzyx zzki() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxt zzkj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzwx zzkk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final void zzmt() {
        zzeb(zzbkw.zzftu);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void zzvo() {
        if (this.zzhgd == null) {
            return;
        }
        this.zzhgc = com.google.android.gms.ads.internal.zzr.zzky().a();
        int zzajh = this.zzhgd.zzajh();
        if (zzajh <= 0) {
            return;
        }
        zzbkq zzbkqVar = new zzbkq(this.zzguy.zzafb(), com.google.android.gms.ads.internal.zzr.zzky());
        this.zzhff = zzbkqVar;
        zzbkqVar.zza(zzajh, new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdjb
            private final zzdiz zzhga;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhga = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhga.zzaug();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized boolean zza(zzvl zzvlVar) throws RemoteException {
        q.e("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzr.zzkr();
        if (com.google.android.gms.ads.internal.util.zzj.zzaz(this.zzgxt) && zzvlVar.zzcia == null) {
            zzazk.zzev("Failed to load the ad because app ID is missing.");
            this.zzhfd.zzc(zzdok.zza(zzdom.APP_ID_MISSING, null, null));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            this.zzhfb = new AtomicBoolean();
            return this.zzhgb.zza(zzvlVar, this.zzbut, new zzdja(this), new zzdjd(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzblq zzblqVar) {
        zzblqVar.zza(this);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zza(com.google.android.gms.ads.internal.overlay.zzn zznVar) {
        int i2 = zzdjc.zzhge[zznVar.ordinal()];
        if (i2 == 1) {
            zzeb(zzbkw.zzftu);
        } else if (i2 == 2) {
            zzeb(zzbkw.zzftt);
        } else if (i2 == 3) {
            zzeb(zzbkw.zzftv);
        } else if (i2 != 4) {
        } else {
            zzeb(zzbkw.zzftx);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzsp zzspVar) {
        this.zzhfd.zzb(zzspVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zza(zzvs zzvsVar) {
        q.e("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zza(zzxz zzxzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zza(zzaau zzaauVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zza(zzacl zzaclVar) {
    }
}
