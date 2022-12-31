package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zznk {
    private int length;
    private int zzbfs;
    private int zzbft;
    private int zzbfu;
    private zzht zzbfz;
    private int zzbfo = 1000;
    private int[] zzbfp = new int[1000];
    private long[] zzaov = new long[1000];
    private long[] zzaox = new long[1000];
    private int[] zzayl = new int[1000];
    private int[] zzaou = new int[1000];
    private zzkk[] zzbfq = new zzkk[1000];
    private zzht[] zzbfr = new zzht[1000];
    private long zzbfv = Long.MIN_VALUE;
    private long zzbfw = Long.MIN_VALUE;
    private boolean zzbfy = true;
    private boolean zzbfx = true;

    public final synchronized int zza(zzhv zzhvVar, zzjp zzjpVar, boolean z, boolean z2, zzht zzhtVar, zznj zznjVar) {
        long j2;
        if (!zzie()) {
            if (z2) {
                zzjpVar.setFlags(4);
                return -4;
            }
            zzht zzhtVar2 = this.zzbfz;
            if (zzhtVar2 == null || (!z && zzhtVar2 == zzhtVar)) {
                return -3;
            }
            zzhvVar.zzahz = zzhtVar2;
            return -5;
        }
        if (!z) {
            zzht[] zzhtVarArr = this.zzbfr;
            int i2 = this.zzbft;
            if (zzhtVarArr[i2] == zzhtVar) {
                if (zzjpVar.zzdr == null) {
                    return -3;
                }
                zzjpVar.zzaol = this.zzaox[i2];
                zzjpVar.setFlags(this.zzayl[i2]);
                int[] iArr = this.zzaou;
                int i3 = this.zzbft;
                zznjVar.size = iArr[i3];
                zznjVar.zzawv = this.zzaov[i3];
                zznjVar.zzarp = this.zzbfq[i3];
                this.zzbfv = Math.max(this.zzbfv, zzjpVar.zzaol);
                int i4 = this.length - 1;
                this.length = i4;
                int i5 = this.zzbft + 1;
                this.zzbft = i5;
                this.zzbfs++;
                if (i5 == this.zzbfo) {
                    this.zzbft = 0;
                }
                if (i4 > 0) {
                    j2 = this.zzaov[this.zzbft];
                } else {
                    j2 = zznjVar.zzawv + zznjVar.size;
                }
                zznjVar.zzbfn = j2;
                return -4;
            }
        }
        zzhvVar.zzahz = this.zzbfr[this.zzbft];
        return -5;
    }

    public final synchronized long zzd(long j2, boolean z) {
        if (zzie()) {
            long[] jArr = this.zzaox;
            int i2 = this.zzbft;
            if (j2 >= jArr[i2]) {
                if (j2 <= this.zzbfw || z) {
                    int i3 = 0;
                    int i4 = -1;
                    while (i2 != this.zzbfu && this.zzaox[i2] <= j2) {
                        if ((this.zzayl[i2] & 1) != 0) {
                            i4 = i3;
                        }
                        i2 = (i2 + 1) % this.zzbfo;
                        i3++;
                    }
                    if (i4 == -1) {
                        return -1L;
                    }
                    int i5 = (this.zzbft + i4) % this.zzbfo;
                    this.zzbft = i5;
                    this.zzbfs += i4;
                    this.length -= i4;
                    return this.zzaov[i5];
                }
                return -1L;
            }
        }
        return -1L;
    }

    public final synchronized void zzei(long j2) {
        this.zzbfw = Math.max(this.zzbfw, j2);
    }

    public final synchronized boolean zzg(zzht zzhtVar) {
        if (zzhtVar == null) {
            this.zzbfy = true;
            return false;
        }
        this.zzbfy = false;
        if (zzpt.zza(zzhtVar, this.zzbfz)) {
            return false;
        }
        this.zzbfz = zzhtVar;
        return true;
    }

    public final synchronized long zzhv() {
        return Math.max(this.zzbfv, this.zzbfw);
    }

    public final void zzib() {
        this.zzbfs = 0;
        this.zzbft = 0;
        this.zzbfu = 0;
        this.length = 0;
        this.zzbfx = true;
    }

    public final void zzic() {
        this.zzbfv = Long.MIN_VALUE;
        this.zzbfw = Long.MIN_VALUE;
    }

    public final int zzid() {
        return this.zzbfs + this.length;
    }

    public final synchronized boolean zzie() {
        return this.length != 0;
    }

    public final synchronized zzht zzif() {
        if (this.zzbfy) {
            return null;
        }
        return this.zzbfz;
    }

    public final synchronized long zzig() {
        if (zzie()) {
            int i2 = this.zzbft;
            int i3 = this.length;
            int i4 = this.zzbfo;
            int i5 = ((i2 + i3) - 1) % i4;
            this.zzbft = (i2 + i3) % i4;
            this.zzbfs += i3;
            this.length = 0;
            return this.zzaov[i5] + this.zzaou[i5];
        }
        return -1L;
    }

    public final synchronized void zza(long j2, int i2, long j3, int i3, zzkk zzkkVar) {
        if (this.zzbfx) {
            if ((i2 & 1) == 0) {
                return;
            }
            this.zzbfx = false;
        }
        zzpg.checkState(!this.zzbfy);
        zzei(j2);
        long[] jArr = this.zzaox;
        int i4 = this.zzbfu;
        jArr[i4] = j2;
        long[] jArr2 = this.zzaov;
        jArr2[i4] = j3;
        this.zzaou[i4] = i3;
        this.zzayl[i4] = i2;
        this.zzbfq[i4] = zzkkVar;
        this.zzbfr[i4] = this.zzbfz;
        this.zzbfp[i4] = 0;
        int i5 = this.length + 1;
        this.length = i5;
        int i6 = this.zzbfo;
        if (i5 == i6) {
            int i7 = i6 + 1000;
            int[] iArr = new int[i7];
            long[] jArr3 = new long[i7];
            long[] jArr4 = new long[i7];
            int[] iArr2 = new int[i7];
            int[] iArr3 = new int[i7];
            zzkk[] zzkkVarArr = new zzkk[i7];
            zzht[] zzhtVarArr = new zzht[i7];
            int i8 = this.zzbft;
            int i9 = i6 - i8;
            System.arraycopy(jArr2, i8, jArr3, 0, i9);
            System.arraycopy(this.zzaox, this.zzbft, jArr4, 0, i9);
            System.arraycopy(this.zzayl, this.zzbft, iArr2, 0, i9);
            System.arraycopy(this.zzaou, this.zzbft, iArr3, 0, i9);
            System.arraycopy(this.zzbfq, this.zzbft, zzkkVarArr, 0, i9);
            System.arraycopy(this.zzbfr, this.zzbft, zzhtVarArr, 0, i9);
            System.arraycopy(this.zzbfp, this.zzbft, iArr, 0, i9);
            int i10 = this.zzbft;
            System.arraycopy(this.zzaov, 0, jArr3, i9, i10);
            System.arraycopy(this.zzaox, 0, jArr4, i9, i10);
            System.arraycopy(this.zzayl, 0, iArr2, i9, i10);
            System.arraycopy(this.zzaou, 0, iArr3, i9, i10);
            System.arraycopy(this.zzbfq, 0, zzkkVarArr, i9, i10);
            System.arraycopy(this.zzbfr, 0, zzhtVarArr, i9, i10);
            System.arraycopy(this.zzbfp, 0, iArr, i9, i10);
            this.zzaov = jArr3;
            this.zzaox = jArr4;
            this.zzayl = iArr2;
            this.zzaou = iArr3;
            this.zzbfq = zzkkVarArr;
            this.zzbfr = zzhtVarArr;
            this.zzbfp = iArr;
            this.zzbft = 0;
            int i11 = this.zzbfo;
            this.zzbfu = i11;
            this.length = i11;
            this.zzbfo = i7;
            return;
        }
        int i12 = i4 + 1;
        this.zzbfu = i12;
        if (i12 == i6) {
            this.zzbfu = 0;
        }
    }
}
