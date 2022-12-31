package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
final class a implements d0 {
    private final ByteBuffer a;

    public a(ByteBuffer byteBuffer) {
        this.a = byteBuffer.slice();
    }

    @Override // com.google.android.play.core.internal.d0
    public final long a() {
        return this.a.capacity();
    }

    @Override // com.google.android.play.core.internal.d0
    public final void a(MessageDigest[] messageDigestArr, long j2, int i2) throws IOException {
        ByteBuffer slice;
        synchronized (this.a) {
            int i3 = (int) j2;
            this.a.position(i3);
            this.a.limit(i3 + i2);
            slice = this.a.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            slice.position(0);
            messageDigest.update(slice);
        }
    }
}
