package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbv extends zzepk {
    private ByteBuffer zzdr;

    public zzbv(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzepk
    public final void zzl(ByteBuffer byteBuffer) {
        this.zzdr = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
