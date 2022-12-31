package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbo extends ThreadLocal<ByteBuffer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbo(zzbl zzblVar) {
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ ByteBuffer initialValue() {
        return ByteBuffer.allocate(32);
    }
}
