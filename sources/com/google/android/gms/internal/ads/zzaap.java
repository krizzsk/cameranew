package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaap extends zzyv {
    @Nullable
    private final OnPaidEventListener zzcls;

    public zzaap(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzcls = onPaidEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzyw
    public final void zza(zzvu zzvuVar) {
        if (this.zzcls != null) {
            this.zzcls.onPaidEvent(AdValue.zza(zzvuVar.zzadc, zzvuVar.zzadd, zzvuVar.zzade));
        }
    }
}
