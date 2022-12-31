package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzehn extends zzehq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzehn(byte[] bArr, int i2) throws InvalidKeyException {
        super(bArr, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    final int[] zzb(int[] iArr, int i2) {
        if (iArr.length == 3) {
            int[] iArr2 = new int[16];
            zzehq.zza(iArr2, this.zzije);
            iArr2[12] = i2;
            System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzehq
    public final int zzbfp() {
        return 12;
    }
}
