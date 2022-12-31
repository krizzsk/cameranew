package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzla {
    public int index;
    public final int length;
    public int zzawu;
    public long zzawv;
    private final boolean zzaww;
    private final zzpn zzawx;
    private final zzpn zzawy;
    private int zzawz;
    private int zzaxa;

    public zzla(zzpn zzpnVar, zzpn zzpnVar2, boolean z) {
        this.zzawy = zzpnVar;
        this.zzawx = zzpnVar2;
        this.zzaww = z;
        zzpnVar2.zzbi(12);
        this.length = zzpnVar2.zzja();
        zzpnVar.zzbi(12);
        this.zzaxa = zzpnVar.zzja();
        zzpg.checkState(zzpnVar.readInt() == 1, "first_chunk must be 1");
        this.index = -1;
    }

    public final boolean zzha() {
        int i2 = this.index + 1;
        this.index = i2;
        if (i2 == this.length) {
            return false;
        }
        this.zzawv = this.zzaww ? this.zzawx.zzjb() : this.zzawx.zzix();
        if (this.index == this.zzawz) {
            this.zzawu = this.zzawy.zzja();
            this.zzawy.zzbj(4);
            int i3 = this.zzaxa - 1;
            this.zzaxa = i3;
            this.zzawz = i3 > 0 ? this.zzawy.zzja() - 1 : -1;
        }
        return true;
    }
}
