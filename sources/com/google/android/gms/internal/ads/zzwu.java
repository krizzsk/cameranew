package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class zzwu extends AdListener {
    private final Object lock = new Object();
    private AdListener zzcjv;

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        synchronized (this.lock) {
            AdListener adListener = this.zzcjv;
            if (adListener != null) {
                adListener.onAdClosed();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(int i2) {
        synchronized (this.lock) {
            AdListener adListener = this.zzcjv;
            if (adListener != null) {
                adListener.onAdFailedToLoad(i2);
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdImpression() {
        synchronized (this.lock) {
            AdListener adListener = this.zzcjv;
            if (adListener != null) {
                adListener.onAdImpression();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLeftApplication() {
        synchronized (this.lock) {
            AdListener adListener = this.zzcjv;
            if (adListener != null) {
                adListener.onAdLeftApplication();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        synchronized (this.lock) {
            AdListener adListener = this.zzcjv;
            if (adListener != null) {
                adListener.onAdLoaded();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdOpened() {
        synchronized (this.lock) {
            AdListener adListener = this.zzcjv;
            if (adListener != null) {
                adListener.onAdOpened();
            }
        }
    }

    public final void zza(AdListener adListener) {
        synchronized (this.lock) {
            this.zzcjv = adListener;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(LoadAdError loadAdError) {
        synchronized (this.lock) {
            AdListener adListener = this.zzcjv;
            if (adListener != null) {
                adListener.onAdFailedToLoad(loadAdError);
            }
        }
    }
}
