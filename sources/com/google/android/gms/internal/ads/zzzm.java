package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzzm {
    private final zzvq zzact;
    private boolean zzbni;
    private VideoOptions zzbnw;
    private AppEventListener zzbsf;
    private String zzbut;
    private zzxl zzbuz;
    private final zzanf zzbvb;
    private zzvc zzchd;
    private AdListener zzchm;
    private AdSize[] zzcis;
    private final AtomicBoolean zzckk;
    private final VideoController zzckl;
    private final zzwu zzckm;
    private com.google.android.gms.ads.doubleclick.AppEventListener zzckn;
    private OnCustomRenderedAdLoadedListener zzcko;
    private ViewGroup zzckp;
    private int zzckq;
    @Nullable
    private OnPaidEventListener zzckr;

    public zzzm(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzvq.zzcif, 0);
    }

    private static boolean zzcz(int i2) {
        return i2 == 1;
    }

    public final void destroy() {
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.destroy();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final AdListener getAdListener() {
        return this.zzchm;
    }

    public final AdSize getAdSize() {
        zzvs zzkg;
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null && (zzkg = zzxlVar.zzkg()) != null) {
                return zzkg.zzqi();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
        AdSize[] adSizeArr = this.zzcis;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzcis;
    }

    public final String getAdUnitId() {
        zzxl zzxlVar;
        if (this.zzbut == null && (zzxlVar = this.zzbuz) != null) {
            try {
                this.zzbut = zzxlVar.getAdUnitId();
            } catch (RemoteException e2) {
                zzazk.zze("#007 Could not call remote method.", e2);
            }
        }
        return this.zzbut;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbsf;
    }

    public final String getMediationAdapterClassName() {
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                return zzxlVar.zzkh();
            }
            return null;
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcko;
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        zzyx zzyxVar = null;
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzyxVar = zzxlVar.zzki();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
        return ResponseInfo.zza(zzyxVar);
    }

    public final VideoController getVideoController() {
        return this.zzckl;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbnw;
    }

    public final boolean isLoading() {
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                return zzxlVar.isLoading();
            }
            return false;
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final void pause() {
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.pause();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void recordManualImpression() {
        if (this.zzckk.getAndSet(true)) {
            return;
        }
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zzkf();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void resume() {
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.resume();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzchm = adListener;
        this.zzckm.zza(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzcis == null) {
            zza(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void setAdUnitId(String str) {
        if (this.zzbut == null) {
            this.zzbut = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbsf = appEventListener;
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zza(appEventListener != null ? new zzrg(appEventListener) : null);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbni = z;
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.setManualImpressionsEnabled(z);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcko = onCustomRenderedAdLoadedListener;
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zza(onCustomRenderedAdLoadedListener != null ? new zzacm(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzckr = onPaidEventListener;
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zza(new zzaap(onPaidEventListener));
            }
        } catch (RemoteException e2) {
            zzazk.zze("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzbnw = videoOptions;
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zza(videoOptions == null ? null : new zzaau(videoOptions));
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(zzzk zzzkVar) {
        zzxl zzd;
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar == null) {
                if ((this.zzcis != null && this.zzbut != null) || zzxlVar != null) {
                    Context context = this.zzckp.getContext();
                    zzvs zza = zza(context, this.zzcis, this.zzckq);
                    if ("search_v2".equals(zza.zzacy)) {
                        zzd = new zzwj(zzwr.zzqo(), context, zza, this.zzbut).zzd(context, false);
                    } else {
                        zzd = new zzwb(zzwr.zzqo(), context, zza, this.zzbut, this.zzbvb).zzd(context, false);
                    }
                    this.zzbuz = zzd;
                    zzd.zza(new zzvi(this.zzckm));
                    if (this.zzchd != null) {
                        this.zzbuz.zza(new zzvb(this.zzchd));
                    }
                    if (this.zzbsf != null) {
                        this.zzbuz.zza(new zzrg(this.zzbsf));
                    }
                    if (this.zzckn != null) {
                        this.zzbuz.zza(new zzvy(this.zzckn));
                    }
                    if (this.zzcko != null) {
                        this.zzbuz.zza(new zzacm(this.zzcko));
                    }
                    if (this.zzbnw != null) {
                        this.zzbuz.zza(new zzaau(this.zzbnw));
                    }
                    this.zzbuz.zza(new zzaap(this.zzckr));
                    this.zzbuz.setManualImpressionsEnabled(this.zzbni);
                    try {
                        b zzke = this.zzbuz.zzke();
                        if (zzke != null) {
                            this.zzckp.addView((View) d.y0(zzke));
                        }
                    } catch (RemoteException e2) {
                        zzazk.zze("#007 Could not call remote method.", e2);
                    }
                } else {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
            }
            if (this.zzbuz.zza(zzvq.zza(this.zzckp.getContext(), zzzkVar))) {
                this.zzbvb.zzf(zzzkVar.zzrk());
            }
        } catch (RemoteException e3) {
            zzazk.zze("#007 Could not call remote method.", e3);
        }
    }

    public final zzzc zzdw() {
        zzxl zzxlVar = this.zzbuz;
        if (zzxlVar == null) {
            return null;
        }
        try {
            return zzxlVar.getVideoController();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final com.google.android.gms.ads.doubleclick.AppEventListener zzrr() {
        return this.zzckn;
    }

    public zzzm(ViewGroup viewGroup, int i2) {
        this(viewGroup, null, false, zzvq.zzcif, i2);
    }

    public zzzm(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzvq.zzcif, 0);
    }

    public zzzm(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i2) {
        this(viewGroup, attributeSet, false, zzvq.zzcif, i2);
    }

    private zzzm(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvq zzvqVar, zzxl zzxlVar, int i2) {
        zzvs zzvsVar;
        this.zzbvb = new zzanf();
        this.zzckl = new VideoController();
        this.zzckm = new zzzl(this);
        this.zzckp = viewGroup;
        this.zzact = zzvqVar;
        this.zzbuz = null;
        this.zzckk = new AtomicBoolean(false);
        this.zzckq = i2;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzvz zzvzVar = new zzvz(context, attributeSet);
                this.zzcis = zzvzVar.zzy(z);
                this.zzbut = zzvzVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzaza zzqn = zzwr.zzqn();
                    AdSize adSize = this.zzcis[0];
                    int i3 = this.zzckq;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzvsVar = zzvs.zzqh();
                    } else {
                        zzvs zzvsVar2 = new zzvs(context, adSize);
                        zzvsVar2.zzcij = zzcz(i3);
                        zzvsVar = zzvsVar2;
                    }
                    zzqn.zza(viewGroup, zzvsVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e2) {
                zzwr.zzqn().zza(viewGroup, new zzvs(context, AdSize.BANNER), e2.getMessage(), e2.getMessage());
            }
        }
    }

    private zzzm(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvq zzvqVar, int i2) {
        this(viewGroup, attributeSet, z, zzvqVar, null, i2);
    }

    public final void zza(zzvc zzvcVar) {
        try {
            this.zzchd = zzvcVar;
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zza(zzvcVar != null ? new zzvb(zzvcVar) : null);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzcis = adSizeArr;
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zza(zza(this.zzckp.getContext(), this.zzcis, this.zzckq));
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
        this.zzckp.requestLayout();
    }

    public final void zza(com.google.android.gms.ads.doubleclick.AppEventListener appEventListener) {
        try {
            this.zzckn = appEventListener;
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zza(appEventListener != null ? new zzvy(this.zzckn) : null);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final boolean zza(zzxl zzxlVar) {
        if (zzxlVar == null) {
            return false;
        }
        try {
            b zzke = zzxlVar.zzke();
            if (zzke != null && ((View) d.y0(zzke)).getParent() == null) {
                this.zzckp.addView((View) d.y0(zzke));
                this.zzbuz = zzxlVar;
                return true;
            }
            return false;
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return false;
        }
    }

    private static zzvs zza(Context context, AdSize[] adSizeArr, int i2) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.INVALID)) {
                return zzvs.zzqh();
            }
        }
        zzvs zzvsVar = new zzvs(context, adSizeArr);
        zzvsVar.zzcij = zzcz(i2);
        return zzvsVar;
    }
}
