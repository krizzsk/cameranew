package com.google.android.gms.internal.ads;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zznu {
    public static final zznu zzbgv = new zznu(new zznr[0]);
    public final int length;
    private int zzahx;
    private final zznr[] zzbgw;

    public zznu(zznr... zznrVarArr) {
        this.zzbgw = zznrVarArr;
        this.length = zznrVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznu.class == obj.getClass()) {
            zznu zznuVar = (zznu) obj;
            if (this.length == zznuVar.length && Arrays.equals(this.zzbgw, zznuVar.zzbgw)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzahx == 0) {
            this.zzahx = Arrays.hashCode(this.zzbgw);
        }
        return this.zzahx;
    }

    public final int zza(zznr zznrVar) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.zzbgw[i2] == zznrVar) {
                return i2;
            }
        }
        return -1;
    }

    public final zznr zzbc(int i2) {
        return this.zzbgw[i2];
    }
}
