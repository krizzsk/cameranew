package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@VisibleForTesting
/* loaded from: classes2.dex */
final class zzba extends FilterInputStream {
    private final long zzco;
    private long zzcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(InputStream inputStream, long j2) {
        super(inputStream);
        this.zzco = j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.zzcp++;
        }
        return read;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzp() {
        return this.zzco - this.zzcp;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = super.read(bArr, i2, i3);
        if (read != -1) {
            this.zzcp += read;
        }
        return read;
    }
}
