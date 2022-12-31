package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzahb;
import com.google.android.gms.internal.ads.zzahc;
import com.google.android.gms.internal.ads.zzahd;
import com.google.android.gms.internal.ads.zzahf;
import com.google.android.gms.internal.ads.zzahh;
import com.google.android.gms.internal.ads.zzanf;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzvi;
import com.google.android.gms.internal.ads.zzvq;
import com.google.android.gms.internal.ads.zzvs;
import com.google.android.gms.internal.ads.zzwr;
import com.google.android.gms.internal.ads.zzxd;
import com.google.android.gms.internal.ads.zzxi;
import com.google.android.gms.internal.ads.zzzk;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class AdLoader {
    private final Context a;
    private final zzxd b;

    AdLoader(Context context, zzxd zzxdVar) {
        this(context, zzxdVar, zzvq.zzcif);
    }

    private final void a(zzzk zzzkVar) {
        try {
            this.b.zzb(zzvq.zza(this.a, zzzkVar));
        } catch (RemoteException e2) {
            zzazk.zzc("Failed to load ad.", e2);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.b.zzkh();
        } catch (RemoteException e2) {
            zzazk.zzd("Failed to get the mediation adapter class name.", e2);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.b.isLoading();
        } catch (RemoteException e2) {
            zzazk.zzd("Failed to check if ad is loading.", e2);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        a(adRequest.zzds());
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAds(AdRequest adRequest, int i2) {
        try {
            this.b.zza(zzvq.zza(this.a, adRequest.zzds()), i2);
        } catch (RemoteException e2) {
            zzazk.zzc("Failed to load ads.", e2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private final Context a;
        private final zzxi b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Context context, String str) {
            this(context, zzwr.zzqo().zzb(context, str, new zzanf()));
            q.k(context, "context cannot be null");
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.a, this.b.zzqz());
            } catch (RemoteException e2) {
                zzazk.zzc("Failed to build AdLoader.", e2);
                return null;
            }
        }

        public Builder forAdManagerAdView(@NonNull OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr != null && adSizeArr.length > 0) {
                try {
                    this.b.zza(new zzahb(onAdManagerAdViewLoadedListener), new zzvs(this.a, adSizeArr));
                } catch (RemoteException e2) {
                    zzazk.zzd("Failed to add Google Ad Manager banner ad listener", e2);
                }
                return this;
            }
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }

        @Deprecated
        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.b.zza(new zzahd(onAppInstallAdLoadedListener));
            } catch (RemoteException e2) {
                zzazk.zzd("Failed to add app install ad listener", e2);
            }
            return this;
        }

        @Deprecated
        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.b.zza(new zzahc(onContentAdLoadedListener));
            } catch (RemoteException e2) {
                zzazk.zzd("Failed to add content ad listener", e2);
            }
            return this;
        }

        public Builder forCustomFormatAd(String str, NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
            zzaqw zzaqwVar = new zzaqw(onCustomFormatAdLoadedListener, onCustomClickListener);
            try {
                this.b.zza(str, zzaqwVar.zzvs(), zzaqwVar.zzua());
            } catch (RemoteException e2) {
                zzazk.zzd("Failed to add custom format ad listener", e2);
            }
            return this;
        }

        @Deprecated
        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzagx zzagxVar = new zzagx(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.b.zza(str, zzagxVar.zztz(), zzagxVar.zzua());
            } catch (RemoteException e2) {
                zzazk.zzd("Failed to add custom template ad listener", e2);
            }
            return this;
        }

        public Builder forNativeAd(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
            try {
                this.b.zza(new zzard(onNativeAdLoadedListener));
            } catch (RemoteException e2) {
                zzazk.zzd("Failed to add google native ad listener", e2);
            }
            return this;
        }

        @Deprecated
        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr != null && adSizeArr.length > 0) {
                try {
                    this.b.zza(new zzahf(onPublisherAdViewLoadedListener), new zzvs(this.a, adSizeArr));
                } catch (RemoteException e2) {
                    zzazk.zzd("Failed to add publisher banner ad listener", e2);
                }
                return this;
            }
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }

        @Deprecated
        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.b.zza(new zzahh(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e2) {
                zzazk.zzd("Failed to add google native ad listener", e2);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.b.zzb(new zzvi(adListener));
            } catch (RemoteException e2) {
                zzazk.zzd("Failed to set AdListener.", e2);
            }
            return this;
        }

        public Builder withAdManagerAdViewOptions(AdManagerAdViewOptions adManagerAdViewOptions) {
            try {
                this.b.zza(adManagerAdViewOptions);
            } catch (RemoteException e2) {
                zzazk.zzd("Failed to specify Ad Manager banner ad options", e2);
            }
            return this;
        }

        @Deprecated
        public Builder withCorrelator(@NonNull Correlator correlator) {
            return this;
        }

        @Deprecated
        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.b.zza(new zzaeh(nativeAdOptions));
            } catch (RemoteException e2) {
                zzazk.zzd("Failed to specify native ad options", e2);
            }
            return this;
        }

        @Deprecated
        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.b.zza(publisherAdViewOptions);
            } catch (RemoteException e2) {
                zzazk.zzd("Failed to specify Ad Manager banner ad options", e2);
            }
            return this;
        }

        public Builder withNativeAdOptions(com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
            try {
                this.b.zza(new zzaeh(nativeAdOptions));
            } catch (RemoteException e2) {
                zzazk.zzd("Failed to specify native ad options", e2);
            }
            return this;
        }

        private Builder(Context context, zzxi zzxiVar) {
            this.a = context;
            this.b = zzxiVar;
        }
    }

    @Deprecated
    public void loadAd(PublisherAdRequest publisherAdRequest) {
        a(publisherAdRequest.zzds());
    }

    private AdLoader(Context context, zzxd zzxdVar, zzvq zzvqVar) {
        this.a = context;
        this.b = zzxdVar;
    }

    public void loadAd(AdManagerAdRequest adManagerAdRequest) {
        a(adManagerAdRequest.zzds());
    }
}
