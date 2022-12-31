package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzns extends zzid {
    private static final Object zzbgq = new Object();
    private final boolean zzaik;
    private final boolean zzail;
    private final long zzbgr;
    private final long zzbgs;
    private final long zzbgt;
    private final long zzbgu;

    public zzns(long j2, boolean z) {
        this(j2, j2, 0L, 0L, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final zzie zza(int i2, zzie zzieVar, boolean z, long j2) {
        zzpg.zzc(i2, 0, 1);
        boolean z2 = this.zzaik;
        long j3 = this.zzbgs;
        zzieVar.zzaih = null;
        zzieVar.zzaii = -9223372036854775807L;
        zzieVar.zzaij = -9223372036854775807L;
        zzieVar.zzaik = z2;
        zzieVar.zzail = false;
        zzieVar.zzaio = 0L;
        zzieVar.zzaip = j3;
        zzieVar.zzaim = 0;
        zzieVar.zzain = 0;
        zzieVar.zzaiq = 0L;
        return zzieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final int zzc(Object obj) {
        return zzbgq.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final int zzff() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final int zzfg() {
        return 1;
    }

    private zzns(long j2, long j3, long j4, long j5, boolean z, boolean z2) {
        this.zzbgr = j2;
        this.zzbgs = j3;
        this.zzbgt = 0L;
        this.zzbgu = 0L;
        this.zzaik = z;
        this.zzail = false;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final zzif zza(int i2, zzif zzifVar, boolean z) {
        zzpg.zzc(i2, 0, 1);
        Object obj = z ? zzbgq : null;
        return zzifVar.zza(obj, obj, 0, this.zzbgr, 0L, false);
    }
}
