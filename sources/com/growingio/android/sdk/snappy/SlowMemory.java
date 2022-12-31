package com.growingio.android.sdk.snappy;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* loaded from: classes2.dex */
class SlowMemory implements Memory {
    @Override // com.growingio.android.sdk.snappy.Memory
    public void copyLong(byte[] bArr, int i2, byte[] bArr2, int i3) {
        for (int i4 = 0; i4 < 8; i4++) {
            bArr2[i3 + i4] = bArr[i2 + i4];
        }
    }

    @Override // com.growingio.android.sdk.snappy.Memory
    public void copyMemory(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        System.arraycopy(bArr, i2, bArr2, i3, i4);
    }

    @Override // com.growingio.android.sdk.snappy.Memory
    public boolean fastAccessSupported() {
        return false;
    }

    @Override // com.growingio.android.sdk.snappy.Memory
    public int loadByte(byte[] bArr, int i2) {
        return bArr[i2] & Draft_75.END_OF_FRAME;
    }

    @Override // com.growingio.android.sdk.snappy.Memory
    public int loadInt(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & Draft_75.END_OF_FRAME) << 24) | (bArr[i2] & Draft_75.END_OF_FRAME) | ((bArr[i2 + 1] & Draft_75.END_OF_FRAME) << 8) | ((bArr[i2 + 2] & Draft_75.END_OF_FRAME) << 16);
    }

    @Override // com.growingio.android.sdk.snappy.Memory
    public long loadLong(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    @Override // com.growingio.android.sdk.snappy.Memory
    public int lookupShort(short[] sArr, int i2) {
        return sArr[i2] & 65535;
    }
}
