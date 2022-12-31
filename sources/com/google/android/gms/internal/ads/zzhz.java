package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzhz {
    public static final zzhz zzaia = new zzhz(1.0f, 1.0f);
    public final float zzaib;
    public final float zzaic;
    private final int zzaid;

    public zzhz(float f2, float f3) {
        this.zzaib = f2;
        this.zzaic = f3;
        this.zzaid = Math.round(f2 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzhz.class == obj.getClass()) {
            zzhz zzhzVar = (zzhz) obj;
            if (this.zzaib == zzhzVar.zzaib && this.zzaic == zzhzVar.zzaic) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzaib) + 527) * 31) + Float.floatToRawIntBits(this.zzaic);
    }

    public final long zzdu(long j2) {
        return j2 * this.zzaid;
    }
}
