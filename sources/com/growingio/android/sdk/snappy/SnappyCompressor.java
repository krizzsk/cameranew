package com.growingio.android.sdk.snappy;

import android.annotation.SuppressLint;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes2.dex */
final class SnappyCompressor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BLOCK_LOG = 15;
    private static final int BLOCK_SIZE = 32768;
    private static final int INPUT_MARGIN_BYTES = 15;
    private static final int MAX_HASH_TABLE_BITS = 14;
    private static final int MAX_HASH_TABLE_SIZE = 16384;
    private static final boolean NATIVE_LITTLE_ENDIAN;

    static {
        NATIVE_LITTLE_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
    }

    SnappyCompressor() {
    }

    private static int bytesBetweenHashLookups(int i2) {
        return i2 >>> 5;
    }

    public static int compress(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int writeUncompressedLength = writeUncompressedLength(bArr2, i4, i3);
        int hashTableSize = getHashTableSize(i3);
        BufferRecycler instance = BufferRecycler.instance();
        short[] allocEncodingHash = instance.allocEncodingHash(hashTableSize);
        int i5 = writeUncompressedLength;
        for (int i6 = 0; i6 < i3; i6 += 32768) {
            Arrays.fill(allocEncodingHash, (short) 0);
            i5 = compressFragment(bArr, i2 + i6, Math.min(i3 - i6, 32768), bArr2, i5, allocEncodingHash);
        }
        instance.releaseEncodingHash(allocEncodingHash);
        return i5 - i4;
    }

    @SuppressLint({"Assert"})
    private static int compressFragment(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, short[] sArr) {
        int i5;
        int i6;
        int i7 = i2 + i3;
        int log2Floor = 32 - log2Floor(getHashTableSize(i3));
        if (i3 >= 15) {
            int i8 = i7 - 15;
            int i9 = i2;
            int i10 = i4;
            while (i9 <= i8) {
                int[] findCandidate = findCandidate(bArr, i9, i8, i2, log2Floor, sArr, 32);
                int i11 = findCandidate[0];
                int i12 = findCandidate[1];
                if (bytesBetweenHashLookups(findCandidate[2]) + i11 > i8) {
                    break;
                }
                int[] emitCopies = emitCopies(bArr, i2, i3, i11, bArr2, emitLiteral(bArr2, i10, bArr, i9, i11 - i9, true), sArr, log2Floor, i12);
                i9 = emitCopies[0];
                i10 = emitCopies[1];
            }
            i6 = i10;
            i5 = i9;
        } else {
            i5 = i2;
            i6 = i4;
        }
        return i5 < i7 ? emitLiteral(bArr2, i6, bArr, i5, i7 - i5, false) : i6;
    }

    @SuppressLint({"Assert"})
    private static int[] emitCopies(byte[] bArr, int i2, int i3, int i4, byte[] bArr2, int i5, short[] sArr, int i6, int i7) {
        int loadInt;
        int loadInt2;
        while (true) {
            int i8 = i2 + i3;
            int findMatchLength = findMatchLength(bArr, i7 + 4, bArr, i4 + 4, i8) + 4;
            int i9 = i4 - i7;
            i4 += findMatchLength;
            i5 = emitCopy(bArr2, i5, i9, findMatchLength);
            if (i4 >= i8 - 15) {
                return new int[]{i4, i5};
            }
            if (SnappyInternalUtils.HAS_UNSAFE) {
                long loadLong = SnappyInternalUtils.loadLong(bArr, i4 - 1);
                loadInt = (int) loadLong;
                loadInt2 = (int) (loadLong >>> 8);
            } else {
                loadInt = SnappyInternalUtils.loadInt(bArr, i4 - 1);
                loadInt2 = SnappyInternalUtils.loadInt(bArr, i4);
            }
            int hashBytes = hashBytes(loadInt, i6);
            int i10 = i4 - i2;
            sArr[hashBytes] = (short) (i10 - 1);
            int hashBytes2 = hashBytes(loadInt2, i6);
            int i11 = sArr[hashBytes2] + i2;
            sArr[hashBytes2] = (short) i10;
            if (loadInt2 != SnappyInternalUtils.loadInt(bArr, i11)) {
                return new int[]{i4, i5};
            }
            i7 = i11;
        }
    }

    private static int emitCopy(byte[] bArr, int i2, int i3, int i4) {
        while (i4 >= 68) {
            i2 = emitCopyLessThan64(bArr, i2, i3, 64);
            i4 -= 64;
        }
        if (i4 > 64) {
            i2 = emitCopyLessThan64(bArr, i2, i3, 60);
            i4 -= 60;
        }
        return emitCopyLessThan64(bArr, i2, i3, i4);
    }

    @SuppressLint({"Assert"})
    private static int emitCopyLessThan64(byte[] bArr, int i2, int i3, int i4) {
        if (i4 < 12 && i3 < 2048) {
            int i5 = i2 + 1;
            bArr[i2] = (byte) (((i4 - 4) << 2) | 1 | ((i3 >>> 8) << 5));
            int i6 = i5 + 1;
            bArr[i5] = (byte) i3;
            return i6;
        }
        int i7 = i2 + 1;
        bArr[i2] = (byte) (((i4 - 1) << 2) | 2);
        int i8 = i7 + 1;
        bArr[i7] = (byte) i3;
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i3 >>> 8);
        return i9;
    }

    private static int emitLiteral(byte[] bArr, int i2, byte[] bArr2, int i3, int i4, boolean z) {
        int i5;
        int i6 = i3 + i4;
        SnappyInternalUtils.checkPositionIndexes(i3, i6, bArr2.length);
        int i7 = i4 - 1;
        if (i7 < 60) {
            i5 = i2 + 1;
            bArr[i2] = (byte) ((i7 << 2) | 0);
            if (z && i4 <= 16) {
                SnappyInternalUtils.copyLong(bArr2, i3, bArr, i5);
                SnappyInternalUtils.copyLong(bArr2, i3 + 8, bArr, i5 + 8);
                return i5 + i4;
            }
        } else if (i7 < 256) {
            int i8 = i2 + 1;
            bArr[i2] = -16;
            i5 = i8 + 1;
            bArr[i8] = (byte) i7;
        } else if (i7 < 65536) {
            int i9 = i2 + 1;
            bArr[i2] = -12;
            int i10 = i9 + 1;
            bArr[i9] = (byte) i7;
            i5 = i10 + 1;
            bArr[i10] = (byte) (i7 >>> 8);
        } else if (i7 < 16777216) {
            int i11 = i2 + 1;
            bArr[i2] = -8;
            int i12 = i11 + 1;
            bArr[i11] = (byte) i7;
            int i13 = i12 + 1;
            bArr[i12] = (byte) (i7 >>> 8);
            i5 = i13 + 1;
            bArr[i13] = (byte) (i7 >>> 16);
        } else {
            int i14 = i2 + 1;
            bArr[i2] = -4;
            int i15 = i14 + 1;
            bArr[i14] = (byte) i7;
            int i16 = i15 + 1;
            bArr[i15] = (byte) (i7 >>> 8);
            int i17 = i16 + 1;
            bArr[i16] = (byte) (i7 >>> 16);
            i5 = i17 + 1;
            bArr[i17] = (byte) (i7 >>> 24);
        }
        SnappyInternalUtils.checkPositionIndexes(i3, i6, bArr2.length);
        System.arraycopy(bArr2, i3, bArr, i5, i4);
        return i5 + i4;
    }

    @SuppressLint({"Assert"})
    private static int[] findCandidate(byte[] bArr, int i2, int i3, int i4, int i5, short[] sArr, int i6) {
        int i7 = i2 + 1;
        int i8 = 0;
        while (true) {
            if (bytesBetweenHashLookups(i6) + i7 > i3) {
                break;
            }
            int loadInt = SnappyInternalUtils.loadInt(bArr, i7);
            int hashBytes = hashBytes(loadInt, i5);
            int i9 = sArr[hashBytes] + i4;
            sArr[hashBytes] = (short) (i7 - i4);
            if (loadInt == SnappyInternalUtils.loadInt(bArr, i9)) {
                i8 = i9;
                break;
            }
            i7 += bytesBetweenHashLookups(i6);
            i6++;
            i8 = i9;
        }
        return new int[]{i7, i8, i6};
    }

    @SuppressLint({"Assert"})
    private static int findMatchLength(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = 0;
        if (!SnappyInternalUtils.HAS_UNSAFE) {
            int i8 = i4 - i3;
            while (i7 < i8) {
                if (bArr[i2 + i7] != bArr2[i3 + i7]) {
                    return i7;
                }
                i7++;
            }
            return i8;
        }
        while (true) {
            i5 = i3 + i7;
            i6 = i4 - 4;
            if (i5 > i6 || SnappyInternalUtils.loadInt(bArr2, i5) != SnappyInternalUtils.loadInt(bArr, i2 + i7)) {
                break;
            }
            i7 += 4;
        }
        if (NATIVE_LITTLE_ENDIAN && i5 <= i6) {
            return i7 + (Integer.numberOfTrailingZeros(SnappyInternalUtils.loadInt(bArr, i2 + i7) ^ SnappyInternalUtils.loadInt(bArr2, i5)) >> 3);
        }
        while (true) {
            int i9 = i3 + i7;
            if (i9 >= i4 || bArr[i2 + i7] != bArr2[i9]) {
                return i7;
            }
            i7++;
        }
    }

    @SuppressLint({"Assert"})
    private static int getHashTableSize(int i2) {
        int i3 = 256;
        while (i3 < 16384 && i3 < i2) {
            i3 <<= 1;
        }
        return i3;
    }

    private static int hashBytes(int i2, int i3) {
        return (i2 * 506832829) >>> i3;
    }

    private static int log2Floor(int i2) {
        if (i2 == 0) {
            return -1;
        }
        return Integer.numberOfLeadingZeros(i2) ^ 31;
    }

    public static int maxCompressedLength(int i2) {
        return i2 + 32 + (i2 / 6);
    }

    private static int writeUncompressedLength(byte[] bArr, int i2, int i3) {
        if (i3 < 128 && i3 >= 0) {
            int i4 = i2 + 1;
            bArr[i2] = (byte) i3;
            return i4;
        } else if (i3 < 16384 && i3 > 0) {
            int i5 = i2 + 1;
            bArr[i2] = (byte) (i3 | 128);
            int i6 = i5 + 1;
            bArr[i5] = (byte) (i3 >>> 7);
            return i6;
        } else if (i3 < 2097152 && i3 > 0) {
            int i7 = i2 + 1;
            bArr[i2] = (byte) (i3 | 128);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (128 | (i3 >>> 7));
            int i9 = i8 + 1;
            bArr[i8] = (byte) (i3 >>> 14);
            return i9;
        } else if (i3 < 268435456 && i3 > 0) {
            int i10 = i2 + 1;
            bArr[i2] = (byte) (i3 | 128);
            int i11 = i10 + 1;
            bArr[i10] = (byte) ((i3 >>> 7) | 128);
            int i12 = i11 + 1;
            bArr[i11] = (byte) (128 | (i3 >>> 14));
            int i13 = i12 + 1;
            bArr[i12] = (byte) (i3 >>> 21);
            return i13;
        } else {
            int i14 = i2 + 1;
            bArr[i2] = (byte) (i3 | 128);
            int i15 = i14 + 1;
            bArr[i14] = (byte) ((i3 >>> 7) | 128);
            int i16 = i15 + 1;
            bArr[i15] = (byte) ((i3 >>> 14) | 128);
            int i17 = i16 + 1;
            bArr[i16] = (byte) (128 | (i3 >>> 21));
            int i18 = i17 + 1;
            bArr[i17] = (byte) (i3 >>> 28);
            return i18;
        }
    }
}
