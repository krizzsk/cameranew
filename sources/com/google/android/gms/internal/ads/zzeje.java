package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeje {
    private final byte[] zzilj = new byte[256];
    private int zzilk;
    private int zzill;

    public zzeje(byte[] bArr) {
        for (int i2 = 0; i2 < 256; i2++) {
            this.zzilj[i2] = (byte) i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            byte[] bArr2 = this.zzilj;
            i3 = (i3 + bArr2[i4] + bArr[i4 % bArr.length]) & 255;
            byte b = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b;
        }
        this.zzilk = 0;
        this.zzill = 0;
    }

    public final void zzs(byte[] bArr) {
        int i2 = this.zzilk;
        int i3 = this.zzill;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i2 = (i2 + 1) & 255;
            byte[] bArr2 = this.zzilj;
            i3 = (i3 + bArr2[i2]) & 255;
            byte b = bArr2[i2];
            bArr2[i2] = bArr2[i3];
            bArr2[i3] = b;
            bArr[i4] = (byte) (bArr2[(bArr2[i2] + bArr2[i3]) & 255] ^ bArr[i4]);
        }
        this.zzilk = i2;
        this.zzill = i3;
    }
}
