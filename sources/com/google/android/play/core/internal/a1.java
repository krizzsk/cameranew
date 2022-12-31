package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
final class a1 implements d0 {
    private final FileChannel a;
    private final long b;
    private final long c;

    public a1(FileChannel fileChannel, long j2, long j3) {
        this.a = fileChannel;
        this.b = j2;
        this.c = j3;
    }

    @Override // com.google.android.play.core.internal.d0
    public final long a() {
        return this.c;
    }

    @Override // com.google.android.play.core.internal.d0
    public final void a(MessageDigest[] messageDigestArr, long j2, int i2) throws IOException {
        MappedByteBuffer map = this.a.map(FileChannel.MapMode.READ_ONLY, this.b + j2, i2);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }
}
