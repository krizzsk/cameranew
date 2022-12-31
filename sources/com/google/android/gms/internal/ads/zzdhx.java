package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdhx extends zzxo implements com.google.android.gms.ads.internal.overlay.zzz, zzbtg, zzsh {
    private final zzazn zzboz;
    private final String zzbut;
    private final ViewGroup zzfum;
    private final zzbgc zzguy;
    private final Context zzgxt;
    private final zzdhv zzhfc;
    private final zzdil zzhfd;
    @Nullable
    private zzbkq zzhff;
    @Nullable
    @GuardedBy("this")
    protected zzblg zzhfg;
    private AtomicBoolean zzhfb = new AtomicBoolean();
    private long zzhfe = -1;

    public zzdhx(zzbgc zzbgcVar, Context context, String str, zzdhv zzdhvVar, zzdil zzdilVar, zzazn zzaznVar) {
        this.zzfum = new FrameLayout(context);
        this.zzguy = zzbgcVar;
        this.zzgxt = context;
        this.zzbut = str;
        this.zzhfc = zzdhvVar;
        this.zzhfd = zzdilVar;
        zzdilVar.zza(this);
        this.zzboz = zzaznVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzvs zzauc() {
        return zzdnu.zzb(this.zzgxt, Collections.singletonList(this.zzhfg.zzajq()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RelativeLayout.LayoutParams zzb(zzblg zzblgVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzblgVar.zzadp() ? 11 : 9);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzblg zzblgVar) {
        zzblgVar.zza(this);
    }

    private final synchronized void zzeb(int i2) {
        if (this.zzhfb.compareAndSet(false, true)) {
            zzblg zzblgVar = this.zzhfg;
            if (zzblgVar != null && zzblgVar.zzajt() != null) {
                this.zzhfd.zzb(this.zzhfg.zzajt());
            }
            this.zzhfd.onAdClosed();
            this.zzfum.removeAllViews();
            zzbkq zzbkqVar = this.zzhff;
            if (zzbkqVar != null) {
                com.google.android.gms.ads.internal.zzr.zzku().zzb(zzbkqVar);
            }
            if (this.zzhfg != null) {
                long j2 = -1;
                if (this.zzhfe != -1) {
                    j2 = com.google.android.gms.ads.internal.zzr.zzky().a() - this.zzhfe;
                }
                this.zzhfg.zzb(j2, i2);
            }
            destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void destroy() {
        q.e("destroy must be called on the main UI thread.");
        zzblg zzblgVar = this.zzhfg;
        if (zzblgVar != null) {
            zzblgVar.destroy();
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
        return this.zzhfc.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isReady() {
        return false;
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
    public final void showInterstitial() {
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
        this.zzhfc.zza(zzvxVar);
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

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzalq() {
        if (this.zzhfg == null) {
            return;
        }
        this.zzhfe = com.google.android.gms.ads.internal.zzr.zzky().a();
        int zzajh = this.zzhfg.zzajh();
        if (zzajh <= 0) {
            return;
        }
        zzbkq zzbkqVar = new zzbkq(this.zzguy.zzafb(), com.google.android.gms.ads.internal.zzr.zzky());
        this.zzhff = zzbkqVar;
        zzbkqVar.zza(zzajh, new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdhz
            private final zzdhx zzhfa;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhfa = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhfa.zzaud();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaud() {
        zzwr.zzqn();
        if (zzaza.zzzx()) {
            zzeb(zzbkw.zzftw);
        } else {
            this.zzguy.zzafa().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdhw
                private final zzdhx zzhfa;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhfa = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhfa.zzaue();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaue() {
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
        q.e("getAdFrame must be called on the main UI thread.");
        return d.z0(this.zzfum);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zzkf() {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized zzvs zzkg() {
        q.e("getAdSize must be called on the main UI thread.");
        zzblg zzblgVar = this.zzhfg;
        if (zzblgVar != null) {
            return zzdnu.zzb(this.zzgxt, Collections.singletonList(zzblgVar.zzajq()));
        }
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

    @Override // com.google.android.gms.ads.internal.overlay.zzz
    public final void zzvv() {
        zzeb(zzbkw.zzftv);
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
            return this.zzhfc.zza(zzvlVar, this.zzbut, new zzdhy(this), new zzdib(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.google.android.gms.ads.internal.overlay.zzp zza(zzblg zzblgVar) {
        boolean zzadp = zzblgVar.zzadp();
        int intValue = ((Integer) zzwr.zzqr().zzd(zzabp.zzcvf)).intValue();
        com.google.android.gms.ads.internal.overlay.zzs zzsVar = new com.google.android.gms.ads.internal.overlay.zzs();
        zzsVar.size = 50;
        zzsVar.paddingLeft = zzadp ? intValue : 0;
        zzsVar.paddingRight = zzadp ? 0 : intValue;
        zzsVar.paddingTop = 0;
        zzsVar.paddingBottom = intValue;
        return new com.google.android.gms.ads.internal.overlay.zzp(this.zzgxt, zzsVar, this);
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
