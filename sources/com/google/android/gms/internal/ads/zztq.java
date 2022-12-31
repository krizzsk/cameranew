package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zztq extends PushbackInputStream {
    private final /* synthetic */ zztp zzbwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zztq(zztp zztpVar, InputStream inputStream, int i2) {
        super(inputStream, 1);
        this.zzbwc = zztpVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.zzbwc.zzbvu.disconnect();
        super.close();
    }
}
