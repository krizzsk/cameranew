package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzlb implements zzkz {
    private final zzpn zzawt;
    private final int zzaxb;
    private final int zzaxc;

    public zzlb(zzky zzkyVar) {
        zzpn zzpnVar = zzkyVar.zzawt;
        this.zzawt = zzpnVar;
        zzpnVar.zzbi(12);
        this.zzaxb = zzpnVar.zzja();
        this.zzaxc = zzpnVar.zzja();
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final int zzgx() {
        return this.zzaxc;
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final int zzgy() {
        int i2 = this.zzaxb;
        return i2 == 0 ? this.zzawt.zzja() : i2;
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final boolean zzgz() {
        return this.zzaxb != 0;
    }
}
