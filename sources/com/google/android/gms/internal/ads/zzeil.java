package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeil {
    private final byte[] data;

    private zzeil(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        this.data = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i3);
    }

    public static zzeil zzr(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new zzeil(bArr, 0, bArr.length);
    }

    public final byte[] getBytes() {
        byte[] bArr = this.data;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
