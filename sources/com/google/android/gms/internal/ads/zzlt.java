package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzlt {
    public final int[] zzaou;
    public final long[] zzaov;
    public final int zzaxc;
    public final int zzayj;
    public final int[] zzayl;
    public final long[] zzban;

    public zzlt(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2) {
        zzpg.checkArgument(iArr.length == jArr2.length);
        zzpg.checkArgument(jArr.length == jArr2.length);
        zzpg.checkArgument(iArr2.length == jArr2.length);
        this.zzaov = jArr;
        this.zzaou = iArr;
        this.zzayj = i2;
        this.zzban = jArr2;
        this.zzayl = iArr2;
        this.zzaxc = jArr.length;
    }

    public final int zzec(long j2) {
        for (int zza = zzpt.zza(this.zzban, j2, true, false); zza >= 0; zza--) {
            if ((this.zzayl[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    public final int zzed(long j2) {
        for (int zzb = zzpt.zzb(this.zzban, j2, true, false); zzb < this.zzban.length; zzb++) {
            if ((this.zzayl[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
