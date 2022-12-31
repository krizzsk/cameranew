package com.google.android.gms.internal.ads;

import com.tencent.bugly.BuglyStrategy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbch implements zzhx {
    private int zzbih;
    private final zzor zzeof;
    private long zzeog;
    private long zzeoh;
    private long zzeoi;
    private long zzeoj;
    private boolean zzeok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbch() {
        this(15000, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, 2500L, 5000L);
    }

    private final void zzk(boolean z) {
        this.zzbih = 0;
        this.zzeok = false;
        if (z) {
            this.zzeof.reset();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void onStopped() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zza(zzhy[] zzhyVarArr, zznu zznuVar, zzoi zzoiVar) {
        this.zzbih = 0;
        for (int i2 = 0; i2 < zzhyVarArr.length; i2++) {
            if (zzoiVar.zzbe(i2) != null) {
                this.zzbih += zzpt.zzbp(zzhyVarArr[i2].getTrackType());
            }
        }
        this.zzeof.zzbf(this.zzbih);
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final synchronized boolean zzc(long j2, boolean z) {
        long j3;
        j3 = z ? this.zzeoj : this.zzeoi;
        return j3 <= 0 || j2 >= j3;
    }

    public final synchronized void zzdm(int i2) {
        this.zzeoi = i2 * 1000;
    }

    public final synchronized void zzdn(int i2) {
        this.zzeoj = i2 * 1000;
    }

    public final synchronized void zzds(int i2) {
        this.zzeog = i2 * 1000;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final synchronized boolean zzdt(long j2) {
        boolean z;
        char c;
        z = false;
        if (j2 > this.zzeoh) {
            c = 0;
        } else {
            c = j2 < this.zzeog ? (char) 2 : (char) 1;
        }
        boolean z2 = this.zzeof.zziq() >= this.zzbih;
        if (c == 2 || (c == 1 && this.zzeok && !z2)) {
            z = true;
        }
        this.zzeok = z;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzfb() {
        zzk(false);
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzfc() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final zzol zzfd() {
        return this.zzeof;
    }

    private zzbch(int i2, int i3, long j2, long j3) {
        this.zzeof = new zzor(true, 65536);
        this.zzeog = 15000000L;
        this.zzeoh = 30000000L;
        this.zzeoi = 2500000L;
        this.zzeoj = 5000000L;
    }

    public final synchronized void zzdt(int i2) {
        this.zzeoh = i2 * 1000;
    }
}
