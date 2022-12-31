package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzle implements zzkz {
    private final zzpn zzawt;
    private final int zzaxc;
    private final int zzaxf;
    private int zzaxg;
    private int zzaxh;

    public zzle(zzky zzkyVar) {
        zzpn zzpnVar = zzkyVar.zzawt;
        this.zzawt = zzpnVar;
        zzpnVar.zzbi(12);
        this.zzaxf = zzpnVar.zzja() & 255;
        this.zzaxc = zzpnVar.zzja();
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final int zzgx() {
        return this.zzaxc;
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final int zzgy() {
        int i2 = this.zzaxf;
        if (i2 == 8) {
            return this.zzawt.readUnsignedByte();
        }
        if (i2 == 16) {
            return this.zzawt.readUnsignedShort();
        }
        int i3 = this.zzaxg;
        this.zzaxg = i3 + 1;
        if (i3 % 2 == 0) {
            int readUnsignedByte = this.zzawt.readUnsignedByte();
            this.zzaxh = readUnsignedByte;
            return (readUnsignedByte & 240) >> 4;
        }
        return this.zzaxh & 15;
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final boolean zzgz() {
        return false;
    }
}
