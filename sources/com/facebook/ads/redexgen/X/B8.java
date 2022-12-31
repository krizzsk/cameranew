package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: assets/audience_network.dex */
public interface B8 {
    public static final ByteBuffer A00 = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    boolean A45(int i2, int i3, int i4) throws B7;

    ByteBuffer A6x();

    int A6y();

    int A6z();

    int A70();

    boolean A8F();

    boolean A8J();

    void ADA();

    void ADB(ByteBuffer byteBuffer);

    void flush();

    void reset();
}
