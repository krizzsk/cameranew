package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
abstract class zzehq implements zzeio {
    private static final int[] zzijd = zzq(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    int[] zzije;
    private final int zzijf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzehq(byte[] bArr, int i2) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.zzije = zzq(bArr);
            this.zzijf = i2;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    private static int rotateLeft(int i2, int i3) {
        return (i2 >>> (-i3)) | (i2 << i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc(int[] iArr) {
        for (int i2 = 0; i2 < 10; i2++) {
            zza(iArr, 0, 4, 8, 12);
            zza(iArr, 1, 5, 9, 13);
            zza(iArr, 2, 6, 10, 14);
            zza(iArr, 3, 7, 11, 15);
            zza(iArr, 0, 5, 10, 15);
            zza(iArr, 1, 6, 11, 12);
            zza(iArr, 2, 7, 8, 13);
            zza(iArr, 3, 4, 9, 14);
        }
    }

    private static int[] zzq(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - zzbfp() >= bArr.length) {
            byte[] zzft = zzeiu.zzft(zzbfp());
            byteBuffer.put(zzft);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int remaining = wrap.remaining();
            int i2 = (remaining / 64) + 1;
            for (int i3 = 0; i3 < i2; i3++) {
                ByteBuffer zzf = zzf(zzft, this.zzijf + i3);
                if (i3 == i2 - 1) {
                    zzeho.zza(byteBuffer, wrap, zzf, remaining % 64);
                } else {
                    zzeho.zza(byteBuffer, wrap, zzf, 64);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    abstract int[] zzb(int[] iArr, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzbfp();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteBuffer zzf(byte[] bArr, int i2) {
        int[] zzb = zzb(zzq(bArr), i2);
        int[] iArr = (int[]) zzb.clone();
        zzc(iArr);
        for (int i3 = 0; i3 < zzb.length; i3++) {
            zzb[i3] = zzb[i3] + iArr[i3];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zzb, 0, 16);
        return order;
    }

    @Override // com.google.android.gms.internal.ads.zzeio
    public final byte[] zzn(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length <= Integer.MAX_VALUE - zzbfp()) {
            ByteBuffer allocate = ByteBuffer.allocate(zzbfp() + bArr.length);
            zza(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(int[] iArr, int[] iArr2) {
        int[] iArr3 = zzijd;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    private static void zza(int[] iArr, int i2, int i3, int i4, int i5) {
        iArr[i2] = iArr[i2] + iArr[i3];
        iArr[i5] = rotateLeft(iArr[i5] ^ iArr[i2], 16);
        iArr[i4] = iArr[i4] + iArr[i5];
        iArr[i3] = rotateLeft(iArr[i3] ^ iArr[i4], 12);
        iArr[i2] = iArr[i2] + iArr[i3];
        iArr[i5] = rotateLeft(iArr[i2] ^ iArr[i5], 8);
        iArr[i4] = iArr[i4] + iArr[i5];
        iArr[i3] = rotateLeft(iArr[i3] ^ iArr[i4], 7);
    }
}
