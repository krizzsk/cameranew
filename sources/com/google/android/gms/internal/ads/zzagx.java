package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzagx {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzdgk;
    @Nullable
    private final NativeCustomTemplateAd.OnCustomClickListener zzdgl;
    @Nullable
    @GuardedBy("this")
    private NativeCustomTemplateAd zzdgm;

    public zzagx(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, @Nullable NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzdgk = onCustomTemplateAdLoadedListener;
        this.zzdgl = onCustomClickListener;
    }

    public final synchronized NativeCustomTemplateAd zzb(zzafn zzafnVar) {
        NativeCustomTemplateAd nativeCustomTemplateAd = this.zzdgm;
        if (nativeCustomTemplateAd != null) {
            return nativeCustomTemplateAd;
        }
        zzafo zzafoVar = new zzafo(zzafnVar);
        this.zzdgm = zzafoVar;
        return zzafoVar;
    }

    public final zzafy zztz() {
        return new zzagy(this);
    }

    @Nullable
    public final zzafx zzua() {
        if (this.zzdgl == null) {
            return null;
        }
        return new zzagz(this);
    }
}
