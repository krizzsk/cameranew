package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeiy extends zzehq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeiy(byte[] bArr, int i2) throws InvalidKeyException {
        super(bArr, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    final int[] zzb(int[] iArr, int i2) {
        if (iArr.length == 6) {
            int[] iArr2 = new int[16];
            zzehq.zza(r0, this.zzije);
            int[] iArr3 = {0, 0, 0, 0, iArr3[12], iArr3[13], iArr3[14], iArr3[15], 0, 0, 0, 0, iArr[0], iArr[1], iArr[2], iArr[3]};
            zzehq.zzc(iArr3);
            zzehq.zza(iArr2, Arrays.copyOf(iArr3, 8));
            iArr2[12] = i2;
            iArr2[13] = 0;
            iArr2[14] = iArr[4];
            iArr2[15] = iArr[5];
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzehq
    public final int zzbfp() {
        return 24;
    }
}
