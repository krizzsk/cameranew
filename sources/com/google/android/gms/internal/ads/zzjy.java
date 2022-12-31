package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzjy implements zzkf {
    private final int length;
    private final long zzaip;
    private final int[] zzaou;
    private final long[] zzaov;
    private final long[] zzaow;
    private final long[] zzaox;

    public zzjy(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzaou = iArr;
        this.zzaov = jArr;
        this.zzaow = jArr2;
        this.zzaox = jArr3;
        int length = iArr.length;
        this.length = length;
        if (length > 0) {
            this.zzaip = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.zzaip = 0L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long getDurationUs() {
        return this.zzaip;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long zzdz(long j2) {
        return this.zzaov[zzpt.zza(this.zzaox, j2, true, true)];
    }
}
