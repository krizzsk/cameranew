package com.growingio.android.sdk.snappy;
/* loaded from: classes2.dex */
final class SnappyInternalUtils {
    static final boolean HAS_UNSAFE;
    private static SlowMemory memory;

    static {
        SlowMemory slowMemory = new SlowMemory();
        memory = slowMemory;
        HAS_UNSAFE = slowMemory.fastAccessSupported();
    }

    private SnappyInternalUtils() {
    }

    static String badPositionIndex(int i2, int i3, String str) {
        if (i2 < 0) {
            return String.format("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return String.format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException("negative size: " + i3);
    }

    static String badPositionIndexes(int i2, int i3, int i4) {
        if (i2 < 0 || i2 > i4) {
            return badPositionIndex(i2, i4, "start index");
        }
        return (i3 < 0 || i3 > i4) ? badPositionIndex(i3, i4, "end index") : String.format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkPositionIndexes(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i2, i3, i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyLong(byte[] bArr, int i2, byte[] bArr2, int i3) {
        memory.copyLong(bArr, i2, bArr2, i3);
    }

    static boolean equals(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        checkPositionIndexes(i2, i2 + i4, bArr.length);
        checkPositionIndexes(i3, i3 + i4, bArr2.length);
        for (int i5 = 0; i5 < i4; i5++) {
            if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                return false;
            }
        }
        return true;
    }

    public static int loadByte(byte[] bArr, int i2) {
        return memory.loadByte(bArr, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int loadInt(byte[] bArr, int i2) {
        return memory.loadInt(bArr, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long loadLong(byte[] bArr, int i2) {
        return memory.loadLong(bArr, i2);
    }

    public static int lookupShort(short[] sArr, int i2) {
        return memory.lookupShort(sArr, i2);
    }
}
