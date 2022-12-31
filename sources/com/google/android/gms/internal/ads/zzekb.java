package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public class zzekb extends zzejy {
    protected final byte[] zzimk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzekb(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzimk = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzejr) && size() == ((zzejr) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (obj instanceof zzekb) {
                zzekb zzekbVar = (zzekb) obj;
                int zzbgo = zzbgo();
                int zzbgo2 = zzekbVar.zzbgo();
                if (zzbgo == 0 || zzbgo2 == 0 || zzbgo == zzbgo2) {
                    return zza(zzekbVar, 0, size());
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public int size() {
        return this.zzimk.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzejr
    public final void zza(zzejo zzejoVar) throws IOException {
        zzejoVar.zzh(this.zzimk, zzbgp(), size());
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public final zzejr zzaa(int i2, int i3) {
        int zzi = zzejr.zzi(i2, i3, size());
        if (zzi == 0) {
            return zzejr.zzilz;
        }
        return new zzeju(this.zzimk, zzbgp() + i2, zzi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzejr
    public void zzb(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.zzimk, i2, bArr, i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public final boolean zzbgj() {
        int zzbgp = zzbgp();
        return zzeok.zzm(this.zzimk, zzbgp, size() + zzbgp);
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public final zzekc zzbgk() {
        return zzekc.zzb(this.zzimk, zzbgp(), size(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zzbgp() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public byte zzfz(int i2) {
        return this.zzimk[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzejr
    public final int zzg(int i2, int i3, int i4) {
        int zzbgp = zzbgp() + i3;
        return zzeok.zzb(i2, this.zzimk, zzbgp, i4 + zzbgp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzejr
    public byte zzga(int i2) {
        return this.zzimk[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzejr
    public final int zzh(int i2, int i3, int i4) {
        return zzeld.zza(i2, this.zzimk, zzbgp() + i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    protected final String zza(Charset charset) {
        return new String(this.zzimk, zzbgp(), size(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzejy
    final boolean zza(zzejr zzejrVar, int i2, int i3) {
        if (i3 <= zzejrVar.size()) {
            int i4 = i2 + i3;
            if (i4 <= zzejrVar.size()) {
                if (zzejrVar instanceof zzekb) {
                    zzekb zzekbVar = (zzekb) zzejrVar;
                    byte[] bArr = this.zzimk;
                    byte[] bArr2 = zzekbVar.zzimk;
                    int zzbgp = zzbgp() + i3;
                    int zzbgp2 = zzbgp();
                    int zzbgp3 = zzekbVar.zzbgp() + i2;
                    while (zzbgp2 < zzbgp) {
                        if (bArr[zzbgp2] != bArr2[zzbgp3]) {
                            return false;
                        }
                        zzbgp2++;
                        zzbgp3++;
                    }
                    return true;
                }
                return zzejrVar.zzaa(i2, i4).equals(zzaa(0, i3));
            }
            int size = zzejrVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: ");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i3);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }
}
