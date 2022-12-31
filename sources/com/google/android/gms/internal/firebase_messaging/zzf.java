package com.google.android.gms.internal.firebase_messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
/* loaded from: classes2.dex */
final class zzf extends FilterInputStream {
    private long zza;
    private long zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(InputStream inputStream, long j2) {
        super(inputStream);
        this.zzb = -1L;
        Objects.requireNonNull(inputStream);
        this.zza = 1048577L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.zza);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i2) {
        ((FilterInputStream) this).in.mark(i2);
        this.zzb = this.zza;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.zza == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.zza--;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        if (((FilterInputStream) this).in.markSupported()) {
            if (this.zzb != -1) {
                ((FilterInputStream) this).in.reset();
                this.zza = this.zzb;
            } else {
                throw new IOException("Mark not set");
            }
        } else {
            throw new IOException("Mark not supported");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        long skip = ((FilterInputStream) this).in.skip(Math.min(j2, this.zza));
        this.zza -= skip;
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        long j2 = this.zza;
        if (j2 == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read(bArr, i2, (int) Math.min(i3, j2));
        if (read != -1) {
            this.zza -= read;
        }
        return read;
    }
}
