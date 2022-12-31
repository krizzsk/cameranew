package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zznm implements zzkh {
    private final zzpn zzapt;
    private final zzol zzbdp;
    private final int zzbge;
    private final zznk zzbgf;
    private final zznj zzbgg;
    private final AtomicInteger zzbgh;
    private zznl zzbgi;
    private zznl zzbgj;
    private zzht zzbgk;
    private boolean zzbgl;
    private zzht zzbgm;
    private long zzbgn;
    private int zzbgo;
    private zzno zzbgp;

    public zznm(zzol zzolVar) {
        this.zzbdp = zzolVar;
        int zzio = zzolVar.zzio();
        this.zzbge = zzio;
        this.zzbgf = new zznk();
        this.zzbgg = new zznj();
        this.zzapt = new zzpn(32);
        this.zzbgh = new AtomicInteger();
        this.zzbgo = zzio;
        zznl zznlVar = new zznl(0L, zzio);
        this.zzbgi = zznlVar;
        this.zzbgj = zznlVar;
    }

    private final int zzba(int i2) {
        if (this.zzbgo == this.zzbge) {
            this.zzbgo = 0;
            zznl zznlVar = this.zzbgj;
            if (zznlVar.zzbgb) {
                this.zzbgj = zznlVar.zzbgd;
            }
            zznl zznlVar2 = this.zzbgj;
            zzom zzin = this.zzbdp.zzin();
            zznl zznlVar3 = new zznl(this.zzbgj.zzasu, this.zzbge);
            zznlVar2.zzbgc = zzin;
            zznlVar2.zzbgd = zznlVar3;
            zznlVar2.zzbgb = true;
        }
        return Math.min(i2, this.zzbge - this.zzbgo);
    }

    private final void zzej(long j2) {
        while (true) {
            zznl zznlVar = this.zzbgi;
            if (j2 < zznlVar.zzasu) {
                return;
            }
            this.zzbdp.zza(zznlVar.zzbgc);
            this.zzbgi = this.zzbgi.zzih();
        }
    }

    private final void zzib() {
        this.zzbgf.zzib();
        zznl zznlVar = this.zzbgi;
        if (zznlVar.zzbgb) {
            zznl zznlVar2 = this.zzbgj;
            int i2 = (zznlVar2.zzbgb ? 1 : 0) + (((int) (zznlVar2.zzbga - zznlVar.zzbga)) / this.zzbge);
            zzom[] zzomVarArr = new zzom[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                zzomVarArr[i3] = zznlVar.zzbgc;
                zznlVar = zznlVar.zzih();
            }
            this.zzbdp.zza(zzomVarArr);
        }
        zznl zznlVar3 = new zznl(0L, this.zzbge);
        this.zzbgi = zznlVar3;
        this.zzbgj = zznlVar3;
        this.zzbgn = 0L;
        this.zzbgo = this.zzbge;
        this.zzbdp.zzn();
    }

    private final boolean zzij() {
        return this.zzbgh.compareAndSet(0, 1);
    }

    private final void zzik() {
        if (this.zzbgh.compareAndSet(1, 0)) {
            return;
        }
        zzib();
    }

    public final void disable() {
        if (this.zzbgh.getAndSet(2) == 0) {
            zzib();
        }
    }

    public final int zza(zzhv zzhvVar, zzjp zzjpVar, boolean z, boolean z2, long j2) {
        int i2;
        int zza = this.zzbgf.zza(zzhvVar, zzjpVar, z, z2, this.zzbgk, this.zzbgg);
        if (zza == -5) {
            this.zzbgk = zzhvVar.zzahz;
            return -5;
        } else if (zza != -4) {
            if (zza == -3) {
                return -3;
            }
            throw new IllegalStateException();
        } else {
            if (!zzjpVar.zzgi()) {
                if (zzjpVar.zzaol < j2) {
                    zzjpVar.zzaa(Integer.MIN_VALUE);
                }
                if (zzjpVar.isEncrypted()) {
                    zznj zznjVar = this.zzbgg;
                    long j3 = zznjVar.zzawv;
                    this.zzapt.reset(1);
                    zza(j3, this.zzapt.data, 1);
                    long j4 = j3 + 1;
                    byte b = this.zzapt.data[0];
                    boolean z3 = (b & 128) != 0;
                    int i3 = b & Byte.MAX_VALUE;
                    zzjl zzjlVar = zzjpVar.zzaok;
                    if (zzjlVar.iv == null) {
                        zzjlVar.iv = new byte[16];
                    }
                    zza(j4, zzjlVar.iv, i3);
                    long j5 = j4 + i3;
                    if (z3) {
                        this.zzapt.reset(2);
                        zza(j5, this.zzapt.data, 2);
                        j5 += 2;
                        i2 = this.zzapt.readUnsignedShort();
                    } else {
                        i2 = 1;
                    }
                    zzjl zzjlVar2 = zzjpVar.zzaok;
                    int[] iArr = zzjlVar2.numBytesOfClearData;
                    if (iArr == null || iArr.length < i2) {
                        iArr = new int[i2];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zzjlVar2.numBytesOfEncryptedData;
                    if (iArr3 == null || iArr3.length < i2) {
                        iArr3 = new int[i2];
                    }
                    int[] iArr4 = iArr3;
                    if (z3) {
                        int i4 = i2 * 6;
                        this.zzapt.reset(i4);
                        zza(j5, this.zzapt.data, i4);
                        j5 += i4;
                        this.zzapt.zzbi(0);
                        for (int i5 = 0; i5 < i2; i5++) {
                            iArr2[i5] = this.zzapt.readUnsignedShort();
                            iArr4[i5] = this.zzapt.zzja();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zznjVar.size - ((int) (j5 - zznjVar.zzawv));
                    }
                    zzkk zzkkVar = zznjVar.zzarp;
                    zzjl zzjlVar3 = zzjpVar.zzaok;
                    zzjlVar3.set(i2, iArr2, iArr4, zzkkVar.zzapi, zzjlVar3.iv, zzkkVar.zzaph);
                    long j6 = zznjVar.zzawv;
                    int i6 = (int) (j5 - j6);
                    zznjVar.zzawv = j6 + i6;
                    zznjVar.size -= i6;
                }
                zzjpVar.zzad(this.zzbgg.size);
                zznj zznjVar2 = this.zzbgg;
                long j7 = zznjVar2.zzawv;
                ByteBuffer byteBuffer = zzjpVar.zzdr;
                int i7 = zznjVar2.size;
                zzej(j7);
                while (i7 > 0) {
                    int i8 = (int) (j7 - this.zzbgi.zzbga);
                    int min = Math.min(i7, this.zzbge - i8);
                    zzom zzomVar = this.zzbgi.zzbgc;
                    byteBuffer.put(zzomVar.data, i8 + 0, min);
                    j7 += min;
                    i7 -= min;
                    if (j7 == this.zzbgi.zzasu) {
                        this.zzbdp.zza(zzomVar);
                        this.zzbgi = this.zzbgi.zzih();
                    }
                }
                zzej(this.zzbgg.zzbfn);
            }
            return -4;
        }
    }

    public final boolean zze(long j2, boolean z) {
        long zzd = this.zzbgf.zzd(j2, z);
        if (zzd == -1) {
            return false;
        }
        zzej(zzd);
        return true;
    }

    public final long zzhv() {
        return this.zzbgf.zzhv();
    }

    public final int zzid() {
        return this.zzbgf.zzid();
    }

    public final boolean zzie() {
        return this.zzbgf.zzie();
    }

    public final zzht zzif() {
        return this.zzbgf.zzif();
    }

    public final void zzii() {
        long zzig = this.zzbgf.zzig();
        if (zzig != -1) {
            zzej(zzig);
        }
    }

    public final void zzk(boolean z) {
        int andSet = this.zzbgh.getAndSet(z ? 0 : 2);
        zzib();
        this.zzbgf.zzic();
        if (andSet == 2) {
            this.zzbgk = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final void zze(zzht zzhtVar) {
        zzht zzhtVar2 = zzhtVar == null ? null : zzhtVar;
        boolean zzg = this.zzbgf.zzg(zzhtVar2);
        this.zzbgm = zzhtVar;
        this.zzbgl = false;
        zzno zznoVar = this.zzbgp;
        if (zznoVar == null || !zzg) {
            return;
        }
        zznoVar.zzf(zzhtVar2);
    }

    private final void zza(long j2, byte[] bArr, int i2) {
        zzej(j2);
        int i3 = 0;
        while (i3 < i2) {
            int i4 = (int) (j2 - this.zzbgi.zzbga);
            int min = Math.min(i2 - i3, this.zzbge - i4);
            zzom zzomVar = this.zzbgi.zzbgc;
            System.arraycopy(zzomVar.data, i4 + 0, bArr, i3, min);
            j2 += min;
            i3 += min;
            if (j2 == this.zzbgi.zzasu) {
                this.zzbdp.zza(zzomVar);
                this.zzbgi = this.zzbgi.zzih();
            }
        }
    }

    public final void zza(zzno zznoVar) {
        this.zzbgp = zznoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final int zza(zzjz zzjzVar, int i2, boolean z) throws IOException, InterruptedException {
        if (!zzij()) {
            int zzaf = zzjzVar.zzaf(i2);
            if (zzaf != -1) {
                return zzaf;
            }
            throw new EOFException();
        }
        try {
            int read = zzjzVar.read(this.zzbgj.zzbgc.data, this.zzbgo + 0, zzba(i2));
            if (read != -1) {
                this.zzbgo += read;
                this.zzbgn += read;
                return read;
            }
            throw new EOFException();
        } finally {
            zzik();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final void zza(zzpn zzpnVar, int i2) {
        if (!zzij()) {
            zzpnVar.zzbj(i2);
            return;
        }
        while (i2 > 0) {
            int zzba = zzba(i2);
            zzpnVar.zze(this.zzbgj.zzbgc.data, this.zzbgo + 0, zzba);
            this.zzbgo += zzba;
            this.zzbgn += zzba;
            i2 -= zzba;
        }
        zzik();
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final void zza(long j2, int i2, int i3, int i4, zzkk zzkkVar) {
        if (!zzij()) {
            this.zzbgf.zzei(j2);
            return;
        }
        try {
            this.zzbgf.zza(j2, i2, (this.zzbgn - i3) - i4, i3, zzkkVar);
        } finally {
            zzik();
        }
    }
}
