package com.google.android.gms.internal.ads;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdtf extends zzdtb {
    private String zzhso;
    private Boolean zzhsp;
    private Boolean zzhsq;

    @Override // com.google.android.gms.internal.ads.zzdtb
    public final zzdtc zzaxo() {
        String concat = this.zzhso == null ? "".concat(" clientVersion") : "";
        if (this.zzhsp == null) {
            concat = String.valueOf(concat).concat(" shouldGetAdvertisingId");
        }
        if (this.zzhsq == null) {
            concat = String.valueOf(concat).concat(" isGooglePlayServicesAvailable");
        }
        if (!concat.isEmpty()) {
            String valueOf = String.valueOf(concat);
            throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
        }
        return new zzdtd(this.zzhso, this.zzhsp.booleanValue(), this.zzhsq.booleanValue());
    }

    @Override // com.google.android.gms.internal.ads.zzdtb
    public final zzdtb zzbo(boolean z) {
        this.zzhsp = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdtb
    public final zzdtb zzbp(boolean z) {
        this.zzhsq = Boolean.TRUE;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdtb
    public final zzdtb zzhe(String str) {
        Objects.requireNonNull(str, "Null clientVersion");
        this.zzhso = str;
        return this;
    }
}
