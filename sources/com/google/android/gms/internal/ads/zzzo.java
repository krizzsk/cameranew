package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzzo {
    private final Context context;
    private final zzvq zzact;
    private AppEventListener zzboe;
    private String zzbut;
    private zzxl zzbuz;
    private final zzanf zzbvb;
    private zzvc zzchd;
    private AdListener zzchm;
    private AdMetadataListener zzcid;
    private OnCustomRenderedAdLoadedListener zzcko;
    @Nullable
    private OnPaidEventListener zzckr;
    private RewardedVideoAdListener zzckz;
    private boolean zzcla;
    private Boolean zzclb;

    public zzzo(Context context) {
        this(context, zzvq.zzcif, null);
    }

    private final void zzcn(String str) {
        if (this.zzbuz != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
        sb.append("The ad unit ID must be set on InterstitialAd before ");
        sb.append(str);
        sb.append(" is called.");
        throw new IllegalStateException(sb.toString());
    }

    public final AdListener getAdListener() {
        return this.zzchm;
    }

    public final Bundle getAdMetadata() {
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                return zzxlVar.getAdMetadata();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zzbut;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzboe;
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

    public final boolean isLoaded() {
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar == null) {
                return false;
            }
            return zzxlVar.isReady();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar == null) {
                return false;
            }
            return zzxlVar.isLoading();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzchm = adListener;
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zza(adListener != null ? new zzvi(adListener) : null);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.zzcid = adMetadataListener;
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zza(adMetadataListener != null ? new zzvm(adMetadataListener) : null);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzbut == null) {
            this.zzbut = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzboe = appEventListener;
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zza(appEventListener != null ? new zzvy(appEventListener) : null);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzclb = Boolean.valueOf(z);
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.setImmersiveMode(z);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzcko = onCustomRenderedAdLoadedListener;
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
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzckz = rewardedVideoAdListener;
            zzxl zzxlVar = this.zzbuz;
            if (zzxlVar != null) {
                zzxlVar.zza(rewardedVideoAdListener != null ? new zzavb(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void show() {
        try {
            zzcn("show");
            this.zzbuz.showInterstitial();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(zzzk zzzkVar) {
        try {
            if (this.zzbuz == null) {
                if (this.zzbut == null) {
                    zzcn("loadAd");
                }
                zzxl zzb = zzwr.zzqo().zzb(this.context, this.zzcla ? zzvs.zzqf() : new zzvs(), this.zzbut, this.zzbvb);
                this.zzbuz = zzb;
                if (this.zzchm != null) {
                    zzb.zza(new zzvi(this.zzchm));
                }
                if (this.zzchd != null) {
                    this.zzbuz.zza(new zzvb(this.zzchd));
                }
                if (this.zzcid != null) {
                    this.zzbuz.zza(new zzvm(this.zzcid));
                }
                if (this.zzboe != null) {
                    this.zzbuz.zza(new zzvy(this.zzboe));
                }
                if (this.zzcko != null) {
                    this.zzbuz.zza(new zzacm(this.zzcko));
                }
                if (this.zzckz != null) {
                    this.zzbuz.zza(new zzavb(this.zzckz));
                }
                this.zzbuz.zza(new zzaap(this.zzckr));
                Boolean bool = this.zzclb;
                if (bool != null) {
                    this.zzbuz.setImmersiveMode(bool.booleanValue());
                }
            }
            if (this.zzbuz.zza(zzvq.zza(this.context, zzzkVar))) {
                this.zzbvb.zzf(zzzkVar.zzrk());
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zzd(boolean z) {
        this.zzcla = true;
    }

    public zzzo(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzvq.zzcif, publisherInterstitialAd);
    }

    private zzzo(Context context, zzvq zzvqVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbvb = new zzanf();
        this.context = context;
        this.zzact = zzvqVar;
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
}
