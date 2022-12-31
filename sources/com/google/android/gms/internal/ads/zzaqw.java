package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaqw {
    private final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zzdqn;
    @Nullable
    private final NativeCustomFormatAd.OnCustomClickListener zzdqo;
    @Nullable
    @GuardedBy("this")
    private NativeCustomFormatAd zzdqp;

    public zzaqw(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, @Nullable NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zzdqn = onCustomFormatAdLoadedListener;
        this.zzdqo = onCustomClickListener;
    }

    public final synchronized NativeCustomFormatAd zzc(zzafn zzafnVar) {
        NativeCustomFormatAd nativeCustomFormatAd = this.zzdqp;
        if (nativeCustomFormatAd != null) {
            return nativeCustomFormatAd;
        }
        zzara zzaraVar = new zzara(zzafnVar);
        this.zzdqp = zzaraVar;
        return zzaraVar;
    }

    @Nullable
    public final zzafx zzua() {
        if (this.zzdqo == null) {
            return null;
        }
        return new zzaqy(this);
    }

    public final zzafy zzvs() {
        return new zzarb(this);
    }
}
