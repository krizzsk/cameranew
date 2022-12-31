package com.google.android.gms.internal.ads;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzph {
    private int size;
    private long[] zzbjw;

    public zzph() {
        this(32);
    }

    public final void add(long j2) {
        int i2 = this.size;
        long[] jArr = this.zzbjw;
        if (i2 == jArr.length) {
            this.zzbjw = Arrays.copyOf(jArr, i2 << 1);
        }
        long[] jArr2 = this.zzbjw;
        int i3 = this.size;
        this.size = i3 + 1;
        jArr2[i3] = j2;
    }

    public final long get(int i2) {
        if (i2 >= 0 && i2 < this.size) {
            return this.zzbjw[i2];
        }
        int i3 = this.size;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Invalid index ");
        sb.append(i2);
        sb.append(", size is ");
        sb.append(i3);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int size() {
        return this.size;
    }

    private zzph(int i2) {
        this.zzbjw = new long[32];
    }
}
