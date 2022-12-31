package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzlu {
    public int zzaxc;
    public zzlg zzbao;
    public long zzbap;
    public long zzbaq;
    public long zzbar;
    public int zzbas;
    public long[] zzbat;
    public int[] zzbau;
    public int[] zzbav;
    public int[] zzbaw;
    public long[] zzbax;
    public boolean[] zzbay;
    public boolean zzbaz;
    public boolean[] zzbba;
    public zzlr zzbbb;
    public int zzbbc;
    public zzpn zzbbd;
    public boolean zzbbe;
    public long zzbbf;

    public final void zzau(int i2) {
        zzpn zzpnVar = this.zzbbd;
        if (zzpnVar == null || zzpnVar.limit() < i2) {
            this.zzbbd = new zzpn(i2);
        }
        this.zzbbc = i2;
        this.zzbaz = true;
        this.zzbbe = true;
    }

    public final long zzav(int i2) {
        return this.zzbax[i2] + this.zzbaw[i2];
    }
}
