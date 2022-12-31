package com.growingio.android.sdk.snappy;

import android.annotation.TargetApi;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class Snappy {
    static final int COPY_1_BYTE_OFFSET = 1;
    static final int COPY_2_BYTE_OFFSET = 2;
    static final int COPY_4_BYTE_OFFSET = 3;
    static final int LITERAL = 0;

    private Snappy() {
    }

    public static int compress(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        return SnappyCompressor.compress(bArr, i2, i3, bArr2, i4);
    }

    public static int maxCompressedLength(int i2) {
        return SnappyCompressor.maxCompressedLength(i2);
    }

    @TargetApi(9)
    public static byte[] compress(byte[] bArr) {
        byte[] bArr2 = new byte[maxCompressedLength(bArr.length)];
        return Arrays.copyOf(bArr2, compress(bArr, 0, bArr.length, bArr2, 0));
    }
}
