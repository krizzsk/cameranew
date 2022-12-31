package com.google.android.gms.internal.ads;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zznr {
    public final int length;
    private int zzahx;
    private final zzht[] zzbfr;

    public zznr(zzht... zzhtVarArr) {
        zzpg.checkState(zzhtVarArr.length > 0);
        this.zzbfr = zzhtVarArr;
        this.length = zzhtVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznr.class == obj.getClass()) {
            zznr zznrVar = (zznr) obj;
            if (this.length == zznrVar.length && Arrays.equals(this.zzbfr, zznrVar.zzbfr)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzahx == 0) {
            this.zzahx = Arrays.hashCode(this.zzbfr) + 527;
        }
        return this.zzahx;
    }

    public final zzht zzbb(int i2) {
        return this.zzbfr[i2];
    }

    public final int zzh(zzht zzhtVar) {
        int i2 = 0;
        while (true) {
            zzht[] zzhtVarArr = this.zzbfr;
            if (i2 >= zzhtVarArr.length) {
                return -1;
            }
            if (zzhtVar == zzhtVarArr[i2]) {
                return i2;
            }
            i2++;
        }
    }
}
