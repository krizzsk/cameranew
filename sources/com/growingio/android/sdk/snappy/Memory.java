package com.growingio.android.sdk.snappy;
/* loaded from: classes2.dex */
interface Memory {
    void copyLong(byte[] bArr, int i2, byte[] bArr2, int i3);

    void copyMemory(byte[] bArr, int i2, byte[] bArr2, int i3, int i4);

    boolean fastAccessSupported();

    int loadByte(byte[] bArr, int i2);

    int loadInt(byte[] bArr, int i2);

    long loadLong(byte[] bArr, int i2);

    int lookupShort(short[] sArr, int i2);
}
