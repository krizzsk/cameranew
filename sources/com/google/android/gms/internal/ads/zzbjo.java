package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjo implements zzbsh {
    private final zzdog zzfrg;

    public zzbjo(zzdog zzdogVar) {
        this.zzfrg = zzdogVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final void zzcb(@Nullable Context context) {
        try {
            this.zzfrg.pause();
        } catch (zzdnt e2) {
            zzazk.zzd("Cannot invoke onPause for the mediation adapter.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final void zzcc(@Nullable Context context) {
        try {
            this.zzfrg.resume();
            if (context != null) {
                this.zzfrg.onContextChanged(context);
            }
        } catch (zzdnt e2) {
            zzazk.zzd("Cannot invoke onResume for the mediation adapter.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final void zzcd(@Nullable Context context) {
        try {
            this.zzfrg.destroy();
        } catch (zzdnt e2) {
            zzazk.zzd("Cannot invoke onDestroy for the mediation adapter.", e2);
        }
    }
}
