package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(21)
/* loaded from: classes2.dex */
public final class zzig {
    private static final zzig zzait = new zzig(new int[]{2}, 2);
    private final int[] zzaiu;
    private final int zzaiv;

    private zzig(int[] iArr, int i2) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.zzaiu = copyOf;
        Arrays.sort(copyOf);
        this.zzaiv = 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzig) {
            zzig zzigVar = (zzig) obj;
            return Arrays.equals(this.zzaiu, zzigVar.zzaiu) && this.zzaiv == zzigVar.zzaiv;
        }
        return false;
    }

    public final int hashCode() {
        return this.zzaiv + (Arrays.hashCode(this.zzaiu) * 31);
    }

    public final String toString() {
        int i2 = this.zzaiv;
        String arrays = Arrays.toString(this.zzaiu);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i2);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
