package com.google.android.gms.internal.ads;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzekc {
    int zziml;
    int zzimm;
    int zzimn;
    zzekj zzimo;
    private boolean zzimp;

    private zzekc() {
        this.zzimm = 100;
        this.zzimn = Integer.MAX_VALUE;
        this.zzimp = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzekc zzb(byte[] bArr, int i2, int i3, boolean z) {
        zzeke zzekeVar = new zzeke(bArr, i2, i3, z);
        try {
            zzekeVar.zzgf(i3);
            return zzekeVar;
        } catch (zzelo e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static long zzfg(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static int zzgh(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzbgs() throws IOException;

    public abstract long zzbgt() throws IOException;

    public abstract long zzbgu() throws IOException;

    public abstract int zzbgv() throws IOException;

    public abstract long zzbgw() throws IOException;

    public abstract int zzbgx() throws IOException;

    public abstract boolean zzbgy() throws IOException;

    public abstract String zzbgz() throws IOException;

    public abstract zzejr zzbha() throws IOException;

    public abstract int zzbhb() throws IOException;

    public abstract int zzbhc() throws IOException;

    public abstract int zzbhd() throws IOException;

    public abstract long zzbhe() throws IOException;

    public abstract int zzbhf() throws IOException;

    public abstract long zzbhg() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long zzbhh() throws IOException;

    public abstract boolean zzbhi() throws IOException;

    public abstract int zzbhj();

    public abstract void zzgd(int i2) throws zzelo;

    public abstract boolean zzge(int i2) throws IOException;

    public abstract int zzgf(int i2) throws zzelo;

    public abstract void zzgg(int i2);
}
