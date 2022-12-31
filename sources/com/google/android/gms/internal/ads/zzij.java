package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzij {
    public static final ByteBuffer zzajc = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    void flush();

    boolean isActive();

    void reset();

    boolean zzb(int i2, int i3, int i4) throws zzii;

    boolean zzfe();

    int zzfj();

    int zzfk();

    void zzfl();

    ByteBuffer zzfm();

    void zzn(ByteBuffer byteBuffer);
}
