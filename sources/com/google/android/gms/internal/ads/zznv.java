package com.google.android.gms.internal.ads;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zznv implements zzog {
    private final int length;
    private int zzahx;
    private final zzht[] zzbfr;
    private final zznr zzbgx;
    private final int[] zzbgy;
    private final long[] zzbgz;

    public zznv(zznr zznrVar, int... iArr) {
        int i2 = 0;
        zzpg.checkState(iArr.length > 0);
        this.zzbgx = (zznr) zzpg.checkNotNull(zznrVar);
        int length = iArr.length;
        this.length = length;
        this.zzbfr = new zzht[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.zzbfr[i3] = zznrVar.zzbb(iArr[i3]);
        }
        Arrays.sort(this.zzbfr, new zznx());
        this.zzbgy = new int[this.length];
        while (true) {
            int i4 = this.length;
            if (i2 < i4) {
                this.zzbgy[i2] = zznrVar.zzh(this.zzbfr[i2]);
                i2++;
            } else {
                this.zzbgz = new long[i4];
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznv zznvVar = (zznv) obj;
            if (this.zzbgx == zznvVar.zzbgx && Arrays.equals(this.zzbgy, zznvVar.zzbgy)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.zzahx == 0) {
            this.zzahx = (System.identityHashCode(this.zzbgx) * 31) + Arrays.hashCode(this.zzbgy);
        }
        return this.zzahx;
    }

    @Override // com.google.android.gms.internal.ads.zzog
    public final int length() {
        return this.zzbgy.length;
    }

    @Override // com.google.android.gms.internal.ads.zzog
    public final zzht zzbb(int i2) {
        return this.zzbfr[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzog
    public final int zzbd(int i2) {
        return this.zzbgy[0];
    }

    @Override // com.google.android.gms.internal.ads.zzog
    public final zznr zzil() {
        return this.zzbgx;
    }
}
