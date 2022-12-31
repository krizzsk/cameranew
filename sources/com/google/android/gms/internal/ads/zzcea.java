package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcea implements zzbse {
    private final zzccd zzgch;
    private final zzcch zzgdj;

    public zzcea(zzccd zzccdVar, zzcch zzcchVar) {
        this.zzgch = zzccdVar;
        this.zzgdj = zzcchVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final void onAdImpression() {
        if (this.zzgch.zzaob() == null) {
            return;
        }
        zzbeb zzaoa = this.zzgch.zzaoa();
        zzbeb zzanz = this.zzgch.zzanz();
        if (zzaoa == null) {
            zzaoa = zzanz != null ? zzanz : null;
        }
        if (!this.zzgdj.zzanq() || zzaoa == null) {
            return;
        }
        zzaoa.zza("onSdkImpression", new ArrayMap());
    }
}
