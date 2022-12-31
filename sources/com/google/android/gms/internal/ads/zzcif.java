package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcif implements zzbsh {
    @Nullable
    private final zzbeb zzdjd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcif(@Nullable zzbeb zzbebVar) {
        this.zzdjd = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcpe)).booleanValue() ? zzbebVar : null;
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final void zzcb(@Nullable Context context) {
        zzbeb zzbebVar = this.zzdjd;
        if (zzbebVar != null) {
            zzbebVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final void zzcc(@Nullable Context context) {
        zzbeb zzbebVar = this.zzdjd;
        if (zzbebVar != null) {
            zzbebVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final void zzcd(@Nullable Context context) {
        zzbeb zzbebVar = this.zzdjd;
        if (zzbebVar != null) {
            zzbebVar.destroy();
        }
    }
}
