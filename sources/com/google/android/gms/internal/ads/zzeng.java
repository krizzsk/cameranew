package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeng extends zzejr {
    static final int[] zzitu = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzitv;
    private final zzejr zzitw;
    private final zzejr zzitx;
    private final int zzity;
    private final int zzitz;

    private zzeng(zzejr zzejrVar, zzejr zzejrVar2) {
        this.zzitw = zzejrVar;
        this.zzitx = zzejrVar2;
        int size = zzejrVar.size();
        this.zzity = size;
        this.zzitv = size + zzejrVar2.size();
        this.zzitz = Math.max(zzejrVar.zzbgm(), zzejrVar2.zzbgm()) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzejr zza(zzejr zzejrVar, zzejr zzejrVar2) {
        if (zzejrVar2.size() == 0) {
            return zzejrVar;
        }
        if (zzejrVar.size() == 0) {
            return zzejrVar2;
        }
        int size = zzejrVar.size() + zzejrVar2.size();
        if (size < 128) {
            return zzb(zzejrVar, zzejrVar2);
        }
        if (zzejrVar instanceof zzeng) {
            zzeng zzengVar = (zzeng) zzejrVar;
            if (zzengVar.zzitx.size() + zzejrVar2.size() < 128) {
                return new zzeng(zzengVar.zzitw, zzb(zzengVar.zzitx, zzejrVar2));
            } else if (zzengVar.zzitw.zzbgm() > zzengVar.zzitx.zzbgm() && zzengVar.zzbgm() > zzejrVar2.zzbgm()) {
                return new zzeng(zzengVar.zzitw, new zzeng(zzengVar.zzitx, zzejrVar2));
            }
        }
        if (size >= zzhr(Math.max(zzejrVar.zzbgm(), zzejrVar2.zzbgm()) + 1)) {
            return new zzeng(zzejrVar, zzejrVar2);
        }
        return zzeni.zza(new zzeni(null), zzejrVar, zzejrVar2);
    }

    private static zzejr zzb(zzejr zzejrVar, zzejr zzejrVar2) {
        int size = zzejrVar.size();
        int size2 = zzejrVar2.size();
        byte[] bArr = new byte[size + size2];
        zzejrVar.zza(bArr, 0, 0, size);
        zzejrVar2.zza(bArr, 0, size, size2);
        return zzejr.zzu(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzhr(int i2) {
        int[] iArr = zzitu;
        if (i2 >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public final boolean equals(Object obj) {
        boolean zza;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzejr)) {
            return false;
        }
        zzejr zzejrVar = (zzejr) obj;
        if (this.zzitv != zzejrVar.size()) {
            return false;
        }
        if (this.zzitv == 0) {
            return true;
        }
        int zzbgo = zzbgo();
        int zzbgo2 = zzejrVar.zzbgo();
        if (zzbgo != 0 && zzbgo2 != 0 && zzbgo != zzbgo2) {
            return false;
        }
        zzenh zzenhVar = new zzenh(this, null);
        zzejy next = zzenhVar.next();
        zzenh zzenhVar2 = new zzenh(zzejrVar, null);
        zzejy next2 = zzenhVar2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int size = next.size() - i2;
            int size2 = next2.size() - i3;
            int min = Math.min(size, size2);
            if (i2 == 0) {
                zza = next.zza(next2, i3, min);
            } else {
                zza = next2.zza(next, i2, min);
            }
            if (!zza) {
                return false;
            }
            i4 += min;
            int i5 = this.zzitv;
            if (i4 >= i5) {
                if (i4 == i5) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = zzenhVar.next();
                i2 = 0;
            } else {
                i2 += min;
            }
            if (min == size2) {
                next2 = zzenhVar2.next();
                i3 = 0;
            } else {
                i3 += min;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejr, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public final int size() {
        return this.zzitv;
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public final zzejr zzaa(int i2, int i3) {
        int zzi = zzejr.zzi(i2, i3, this.zzitv);
        if (zzi == 0) {
            return zzejr.zzilz;
        }
        if (zzi == this.zzitv) {
            return this;
        }
        int i4 = this.zzity;
        if (i3 <= i4) {
            return this.zzitw.zzaa(i2, i3);
        }
        if (i2 >= i4) {
            return this.zzitx.zzaa(i2 - i4, i3 - i4);
        }
        zzejr zzejrVar = this.zzitw;
        return new zzeng(zzejrVar.zzaa(i2, zzejrVar.size()), this.zzitx.zzaa(0, i3 - this.zzity));
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public final zzejw zzbgh() {
        return new zzenf(this);
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public final boolean zzbgj() {
        int zzg = this.zzitw.zzg(0, 0, this.zzity);
        zzejr zzejrVar = this.zzitx;
        return zzejrVar.zzg(zzg, 0, zzejrVar.size()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public final zzekc zzbgk() {
        return new zzekh(new zzenk(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzejr
    public final int zzbgm() {
        return this.zzitz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzejr
    public final boolean zzbgn() {
        return this.zzitv >= zzhr(this.zzitz);
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    public final byte zzfz(int i2) {
        zzejr.zzab(i2, this.zzitv);
        return zzga(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzejr
    public final int zzg(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.zzity;
        if (i5 <= i6) {
            return this.zzitw.zzg(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.zzitx.zzg(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.zzitx.zzg(this.zzitw.zzg(i2, i3, i7), 0, i4 - i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzejr
    public final byte zzga(int i2) {
        int i3 = this.zzity;
        if (i2 < i3) {
            return this.zzitw.zzga(i2);
        }
        return this.zzitx.zzga(i2 - i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzejr
    public final int zzh(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.zzity;
        if (i5 <= i6) {
            return this.zzitw.zzh(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.zzitx.zzh(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.zzitx.zzh(this.zzitw.zzh(i2, i3, i7), 0, i4 - i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzeng(zzejr zzejrVar, zzejr zzejrVar2, zzenf zzenfVar) {
        this(zzejrVar, zzejrVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzejr
    public final void zzb(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        int i6 = this.zzity;
        if (i5 <= i6) {
            this.zzitw.zzb(bArr, i2, i3, i4);
        } else if (i2 >= i6) {
            this.zzitx.zzb(bArr, i2 - i6, i3, i4);
        } else {
            int i7 = i6 - i2;
            this.zzitw.zzb(bArr, i2, i3, i7);
            this.zzitx.zzb(bArr, 0, i3 + i7, i4 - i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzejr
    public final void zza(zzejo zzejoVar) throws IOException {
        this.zzitw.zza(zzejoVar);
        this.zzitx.zza(zzejoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzejr
    protected final String zza(Charset charset) {
        return new String(toByteArray(), charset);
    }
}
