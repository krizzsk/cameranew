package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbh extends ByteArrayOutputStream {
    private final zzat zzcg;

    public zzbh(zzat zzatVar, int i2) {
        this.zzcg = zzatVar;
        ((ByteArrayOutputStream) this).buf = zzatVar.zzf(Math.max(i2, 256));
    }

    private final void zzg(int i2) {
        int i3 = ((ByteArrayOutputStream) this).count;
        if (i3 + i2 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] zzf = this.zzcg.zzf((i3 + i2) << 1);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, zzf, 0, ((ByteArrayOutputStream) this).count);
        this.zzcg.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = zzf;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzcg.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public final void finalize() {
        this.zzcg.zza(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i2, int i3) {
        zzg(i3);
        super.write(bArr, i2, i3);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i2) {
        zzg(1);
        super.write(i2);
    }
}
