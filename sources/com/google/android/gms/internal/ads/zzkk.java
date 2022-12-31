package com.google.android.gms.internal.ads;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzkk {
    public final int zzaph = 1;
    public final byte[] zzapi;

    public zzkk(int i2, byte[] bArr) {
        this.zzapi = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzkk.class == obj.getClass()) {
            zzkk zzkkVar = (zzkk) obj;
            if (this.zzaph == zzkkVar.zzaph && Arrays.equals(this.zzapi, zzkkVar.zzapi)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zzaph * 31) + Arrays.hashCode(this.zzapi);
    }
}
