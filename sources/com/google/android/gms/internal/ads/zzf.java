package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzf implements zzc {
    private final FileChannel zzg;
    private final long zzh;
    private final long zzi;

    public zzf(FileChannel fileChannel, long j2, long j3) {
        this.zzg = fileChannel;
        this.zzh = j2;
        this.zzi = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzc
    public final long size() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzc
    public final void zza(MessageDigest[] messageDigestArr, long j2, int i2) throws IOException {
        MappedByteBuffer map = this.zzg.map(FileChannel.MapMode.READ_ONLY, this.zzh + j2, i2);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }
}
