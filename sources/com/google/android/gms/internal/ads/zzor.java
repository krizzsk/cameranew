package com.google.android.gms.internal.ads;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzor implements zzol {
    private final boolean zzbid;
    private final int zzbie;
    private final byte[] zzbif;
    private final zzom[] zzbig;
    private int zzbih;
    private int zzbii;
    private int zzbij;
    private zzom[] zzbik;

    public zzor(boolean z, int i2) {
        this(true, 65536, 0);
    }

    public final synchronized void reset() {
        if (this.zzbid) {
            zzbf(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized void zza(zzom zzomVar) {
        zzom[] zzomVarArr = this.zzbig;
        zzomVarArr[0] = zzomVar;
        zza(zzomVarArr);
    }

    public final synchronized void zzbf(int i2) {
        boolean z = i2 < this.zzbih;
        this.zzbih = i2;
        if (z) {
            zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized zzom zzin() {
        zzom zzomVar;
        this.zzbii++;
        int i2 = this.zzbij;
        if (i2 > 0) {
            zzom[] zzomVarArr = this.zzbik;
            int i3 = i2 - 1;
            this.zzbij = i3;
            zzomVar = zzomVarArr[i3];
            zzomVarArr[i3] = null;
        } else {
            zzomVar = new zzom(new byte[this.zzbie], 0);
        }
        return zzomVar;
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final int zzio() {
        return this.zzbie;
    }

    public final synchronized int zziq() {
        return this.zzbii * this.zzbie;
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized void zzn() {
        int max = Math.max(0, zzpt.zzf(this.zzbih, this.zzbie) - this.zzbii);
        int i2 = this.zzbij;
        if (max >= i2) {
            return;
        }
        Arrays.fill(this.zzbik, max, i2, (Object) null);
        this.zzbij = max;
    }

    private zzor(boolean z, int i2, int i3) {
        zzpg.checkArgument(true);
        zzpg.checkArgument(true);
        this.zzbid = true;
        this.zzbie = 65536;
        this.zzbij = 0;
        this.zzbik = new zzom[100];
        this.zzbif = null;
        this.zzbig = new zzom[1];
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized void zza(zzom[] zzomVarArr) {
        boolean z;
        int i2 = this.zzbij;
        int length = zzomVarArr.length + i2;
        zzom[] zzomVarArr2 = this.zzbik;
        if (length >= zzomVarArr2.length) {
            this.zzbik = (zzom[]) Arrays.copyOf(zzomVarArr2, Math.max(zzomVarArr2.length << 1, i2 + zzomVarArr.length));
        }
        for (zzom zzomVar : zzomVarArr) {
            byte[] bArr = zzomVar.data;
            if (bArr != null && bArr.length != this.zzbie) {
                z = false;
                zzpg.checkArgument(z);
                zzom[] zzomVarArr3 = this.zzbik;
                int i3 = this.zzbij;
                this.zzbij = i3 + 1;
                zzomVarArr3[i3] = zzomVar;
            }
            z = true;
            zzpg.checkArgument(z);
            zzom[] zzomVarArr32 = this.zzbik;
            int i32 = this.zzbij;
            this.zzbij = i32 + 1;
            zzomVarArr32[i32] = zzomVar;
        }
        this.zzbii -= zzomVarArr.length;
        notifyAll();
    }
}
