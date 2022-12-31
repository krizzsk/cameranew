package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbcw implements zzepn {
    private final ByteBuffer zzamk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcw(ByteBuffer byteBuffer) {
        this.zzamk = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.zzepn, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzepn
    public final long position() throws IOException {
        return this.zzamk.position();
    }

    @Override // com.google.android.gms.internal.ads.zzepn
    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.zzamk.remaining() != 0 || byteBuffer.remaining() <= 0) {
            int min = Math.min(byteBuffer.remaining(), this.zzamk.remaining());
            byte[] bArr = new byte[min];
            this.zzamk.get(bArr);
            byteBuffer.put(bArr);
            return min;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzepn
    public final long size() throws IOException {
        return this.zzamk.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzepn
    public final void zzfc(long j2) throws IOException {
        this.zzamk.position((int) j2);
    }

    @Override // com.google.android.gms.internal.ads.zzepn
    public final ByteBuffer zzh(long j2, long j3) throws IOException {
        int position = this.zzamk.position();
        this.zzamk.position((int) j2);
        ByteBuffer slice = this.zzamk.slice();
        slice.limit((int) j3);
        this.zzamk.position(position);
        return slice;
    }
}
