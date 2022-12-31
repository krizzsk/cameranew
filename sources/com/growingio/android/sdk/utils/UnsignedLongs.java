package com.growingio.android.sdk.utils;

import androidx.annotation.NonNull;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;
    private static final long[] maxValueDivs = new long[37];
    private static final int[] maxValueMods = new int[37];
    private static final int[] maxSafeDigits = new int[37];

    /* loaded from: classes2.dex */
    enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                if (jArr[i2] != jArr2[i2]) {
                    return UnsignedLongs.compare(jArr[i2], jArr2[i2]);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    static {
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i2 = 2; i2 <= 36; i2++) {
            long j2 = i2;
            maxValueDivs[i2] = divide(-1L, j2);
            maxValueMods[i2] = (int) remainder(-1L, j2);
            maxSafeDigits[i2] = bigInteger.toString(i2).length() - 1;
        }
    }

    private UnsignedLongs() {
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @NonNull
    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static int compare(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    public static long divide(long j2, long j3) {
        if (j3 < 0) {
            return compare(j2, j3) < 0 ? 0L : 1L;
        } else if (j2 >= 0) {
            return j2 / j3;
        } else {
            long j4 = ((j2 >>> 1) / j3) << 1;
            return j4 + (compare(j2 - (j4 * j3), j3) < 0 ? 0 : 1);
        }
    }

    private static long flip(long j2) {
        return j2 ^ Long.MIN_VALUE;
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    private static boolean overflowInParse(long j2, int i2, int i3) {
        if (j2 >= 0) {
            long[] jArr = maxValueDivs;
            if (j2 < jArr[i3]) {
                return false;
            }
            return j2 > jArr[i3] || i2 > maxValueMods[i3];
        }
        return true;
    }

    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static long remainder(long j2, long j3) {
        if (j3 < 0) {
            return compare(j2, j3) < 0 ? j2 : j2 - j3;
        } else if (j2 >= 0) {
            return j2 % j3;
        } else {
            long j4 = j2 - ((((j2 >>> 1) / j3) << 1) * j3);
            if (compare(j4, j3) < 0) {
                j3 = 0;
            }
            return j4 - j3;
        }
    }

    public static String toString(long j2) {
        return toString(j2, 10);
    }

    public static long parseUnsignedLong(String str, int i2) {
        checkNotNull(str);
        if (str.length() != 0) {
            if (i2 >= 2 && i2 <= 36) {
                int i3 = maxSafeDigits[i2] - 1;
                long j2 = 0;
                for (int i4 = 0; i4 < str.length(); i4++) {
                    int digit = Character.digit(str.charAt(i4), i2);
                    if (digit != -1) {
                        if (i4 > i3 && overflowInParse(j2, digit, i2)) {
                            throw new NumberFormatException("Too large for unsigned long: " + str);
                        }
                        j2 = (j2 * i2) + digit;
                    } else {
                        throw new NumberFormatException(str);
                    }
                }
                return j2;
            }
            throw new NumberFormatException("illegal radix: " + i2);
        }
        throw new NumberFormatException("empty string");
    }

    public static String toString(long j2, int i2) {
        checkArgument(i2 >= 2 && i2 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", Integer.valueOf(i2));
        int i3 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i3 == 0) {
            return "0";
        }
        int i4 = 64;
        char[] cArr = new char[64];
        if (i3 < 0) {
            long j3 = i2;
            long divide = divide(j2, j3);
            i4 = 63;
            cArr[63] = Character.forDigit((int) (j2 - (j3 * divide)), i2);
            j2 = divide;
        }
        while (j2 > 0) {
            i4--;
            long j4 = i2;
            cArr[i4] = Character.forDigit((int) (j2 % j4), i2);
            j2 /= j4;
        }
        return new String(cArr, i4, 64 - i4);
    }
}
