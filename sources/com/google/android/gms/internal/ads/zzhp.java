package com.google.android.gms.internal.ads;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzhp {
    public final int index;
    private final zzhy[] zzaeq;
    private final zzoh zzaer;
    private final zzib[] zzafn;
    private final zzhx zzafo;
    private final zzne zzafu;
    public int zzagi;
    public long zzagj;
    public final zznc zzagm;
    public final Object zzagn;
    public final zznn[] zzago;
    private final boolean[] zzagp;
    public final long zzagq;
    public boolean zzagr;
    public boolean zzags;
    public boolean zzagt;
    public zzhp zzagu;
    public zzoj zzagv;
    private zzoj zzagw;

    public zzhp(zzhy[] zzhyVarArr, zzib[] zzibVarArr, long j2, zzoh zzohVar, zzhx zzhxVar, zzne zzneVar, Object obj, int i2, int i3, boolean z, long j3) {
        this.zzaeq = zzhyVarArr;
        this.zzafn = zzibVarArr;
        this.zzagq = j2;
        this.zzaer = zzohVar;
        this.zzafo = zzhxVar;
        this.zzafu = zzneVar;
        this.zzagn = zzpg.checkNotNull(obj);
        this.index = i2;
        this.zzagi = i3;
        this.zzagr = z;
        this.zzagj = j3;
        this.zzago = new zznn[zzhyVarArr.length];
        this.zzagp = new boolean[zzhyVarArr.length];
        this.zzagm = zzneVar.zza(i3, zzhxVar.zzfd());
    }

    public final void release() {
        try {
            this.zzafu.zzb(this.zzagm);
        } catch (RuntimeException e2) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e2);
        }
    }

    public final long zza(long j2, boolean z, boolean[] zArr) {
        zzoi zzoiVar = this.zzagv.zzbhy;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= zzoiVar.length) {
                break;
            }
            boolean[] zArr2 = this.zzagp;
            if (z || !this.zzagv.zza(this.zzagw, i2)) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i2++;
        }
        long zza = this.zzagm.zza(zzoiVar.zzim(), this.zzagp, this.zzago, zArr, j2);
        this.zzagw = this.zzagv;
        this.zzagt = false;
        int i3 = 0;
        while (true) {
            zznn[] zznnVarArr = this.zzago;
            if (i3 < zznnVarArr.length) {
                if (zznnVarArr[i3] != null) {
                    zzpg.checkState(zzoiVar.zzbe(i3) != null);
                    this.zzagt = true;
                } else {
                    zzpg.checkState(zzoiVar.zzbe(i3) == null);
                }
                i3++;
            } else {
                this.zzafo.zza(this.zzaeq, this.zzagv.zzbhx, zzoiVar);
                return zza;
            }
        }
    }

    public final long zzb(long j2, boolean z) {
        return zza(j2, false, new boolean[this.zzaeq.length]);
    }

    public final void zzc(int i2, boolean z) {
        this.zzagi = i2;
        this.zzagr = z;
    }

    public final long zzew() {
        return this.zzagq - this.zzagj;
    }

    public final boolean zzex() {
        if (this.zzags) {
            return !this.zzagt || this.zzagm.zzhr() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzey() throws com.google.android.gms.internal.ads.zzhe {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzoh r0 = r6.zzaer
            com.google.android.gms.internal.ads.zzib[] r1 = r6.zzafn
            com.google.android.gms.internal.ads.zznc r2 = r6.zzagm
            com.google.android.gms.internal.ads.zznu r2 = r2.zzhp()
            com.google.android.gms.internal.ads.zzoj r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zzoj r1 = r6.zzagw
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L16
        L14:
            r1 = 0
            goto L28
        L16:
            r4 = 0
        L17:
            com.google.android.gms.internal.ads.zzoi r5 = r0.zzbhy
            int r5 = r5.length
            if (r4 >= r5) goto L27
            boolean r5 = r0.zza(r1, r4)
            if (r5 != 0) goto L24
            goto L14
        L24:
            int r4 = r4 + 1
            goto L17
        L27:
            r1 = 1
        L28:
            if (r1 == 0) goto L2b
            return r3
        L2b:
            r6.zzagv = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhp.zzey():boolean");
    }
}
