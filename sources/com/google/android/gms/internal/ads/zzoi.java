package com.google.android.gms.internal.ads;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzoi {
    public final int length;
    private int zzahx;
    private final zzog[] zzbhw;

    public zzoi(zzog... zzogVarArr) {
        this.zzbhw = zzogVarArr;
        this.length = zzogVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzoi.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbhw, ((zzoi) obj).zzbhw);
    }

    public final int hashCode() {
        if (this.zzahx == 0) {
            this.zzahx = Arrays.hashCode(this.zzbhw) + 527;
        }
        return this.zzahx;
    }

    public final zzog zzbe(int i2) {
        return this.zzbhw[i2];
    }

    public final zzog[] zzim() {
        return (zzog[]) this.zzbhw.clone();
    }
}
