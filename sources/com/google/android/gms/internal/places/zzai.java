package com.google.android.gms.internal.places;
/* loaded from: classes2.dex */
public abstract class zzai {
    private int zzeo;
    private int zzep;
    private boolean zzeq;

    private zzai() {
        this.zzeo = 100;
        this.zzep = Integer.MAX_VALUE;
        this.zzeq = false;
    }

    public static long zzb(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzai zzb(byte[] bArr, int i2, int i3, boolean z) {
        zzak zzakVar = new zzak(bArr, 0, i3, false);
        try {
            zzakVar.zzl(i3);
            return zzakVar;
        } catch (zzbk e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int zzm(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public abstract int zzaj();

    public abstract int zzl(int i2) throws zzbk;
}
