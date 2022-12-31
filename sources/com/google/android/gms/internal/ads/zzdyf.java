package com.google.android.gms.internal.ads;

import java.io.OutputStream;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdyf extends OutputStream {
    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        zzdwl.checkNotNull(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        zzdwl.checkNotNull(bArr);
    }
}
