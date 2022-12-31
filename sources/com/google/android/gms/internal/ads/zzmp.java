package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzmp implements zznq {
    private final zznq[] zzbdk;

    public zzmp(zznq[] zznqVarArr) {
        this.zzbdk = zznqVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zznq
    public final boolean zzee(long j2) {
        zznq[] zznqVarArr;
        boolean z;
        boolean z2 = false;
        do {
            long zzhn = zzhn();
            if (zzhn == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zznq zznqVar : this.zzbdk) {
                if (zznqVar.zzhn() == zzhn) {
                    z |= zznqVar.zzee(j2);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zznq
    public final long zzhn() {
        long j2 = Long.MAX_VALUE;
        for (zznq zznqVar : this.zzbdk) {
            long zzhn = zznqVar.zzhn();
            if (zzhn != Long.MIN_VALUE) {
                j2 = Math.min(j2, zzhn);
            }
        }
        if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
            return Long.MIN_VALUE;
        }
        return j2;
    }
}
