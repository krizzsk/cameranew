package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdtd extends zzdtc {
    private final String zzhso;
    private final boolean zzxf;
    private final boolean zzzj;

    private zzdtd(String str, boolean z, boolean z2) {
        this.zzhso = str;
        this.zzxf = z;
        this.zzzj = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdtc) {
            zzdtc zzdtcVar = (zzdtc) obj;
            if (this.zzhso.equals(zzdtcVar.zzaxp()) && this.zzxf == zzdtcVar.zzaxq() && this.zzzj == zzdtcVar.zzcm()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zzhso.hashCode() ^ 1000003) * 1000003) ^ (this.zzxf ? 1231 : 1237)) * 1000003) ^ (this.zzzj ? 1231 : 1237);
    }

    public final String toString() {
        String str = this.zzhso;
        boolean z = this.zzxf;
        boolean z2 = this.zzzj;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdtc
    public final String zzaxp() {
        return this.zzhso;
    }

    @Override // com.google.android.gms.internal.ads.zzdtc
    public final boolean zzaxq() {
        return this.zzxf;
    }

    @Override // com.google.android.gms.internal.ads.zzdtc
    public final boolean zzcm() {
        return this.zzzj;
    }
}
