package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzd implements zzc {
    private final ByteBuffer zza;

    public zzd(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.slice();
    }

    @Override // com.google.android.gms.internal.ads.zzc
    public final long size() {
        return this.zza.capacity();
    }

    @Override // com.google.android.gms.internal.ads.zzc
    public final void zza(MessageDigest[] messageDigestArr, long j2, int i2) throws IOException {
        ByteBuffer slice;
        synchronized (this.zza) {
            int i3 = (int) j2;
            this.zza.position(i3);
            this.zza.limit(i3 + i2);
            slice = this.zza.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            slice.position(0);
            messageDigest.update(slice);
        }
    }
}
