package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdpn implements zzdpl {
    private final String zzcm;

    public zzdpn(String str) {
        this.zzcm = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final boolean equals(Object obj) {
        if (obj instanceof zzdpn) {
            return this.zzcm.equals(((zzdpn) obj).zzcm);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final int hashCode() {
        return this.zzcm.hashCode();
    }

    public final String toString() {
        return this.zzcm;
    }
}
