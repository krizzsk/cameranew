package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzki implements zzkf {
    private final long zzaip;

    public zzki(long j2) {
        this.zzaip = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long getDurationUs() {
        return this.zzaip;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final boolean isSeekable() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long zzdz(long j2) {
        return 0L;
    }
}
