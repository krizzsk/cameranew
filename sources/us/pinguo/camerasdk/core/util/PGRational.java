package us.pinguo.camerasdk.core.util;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
/* loaded from: classes4.dex */
public class PGRational extends Number implements Comparable<PGRational> {
    private static final long serialVersionUID = 1;
    private final int mDenominator;
    private final int mNumerator;
    public static final PGRational NaN = new PGRational(0, 0);
    public static final PGRational POSITIVE_INFINITY = new PGRational(1, 0);
    public static final PGRational NEGATIVE_INFINITY = new PGRational(-1, 0);
    public static final PGRational ZERO = new PGRational(0, 1);

    public PGRational(int i2, int i3) {
        if (i3 < 0) {
            i2 = -i2;
            i3 = -i3;
        }
        if (i3 == 0 && i2 > 0) {
            this.mNumerator = 1;
            this.mDenominator = 0;
        } else if (i3 == 0 && i2 < 0) {
            this.mNumerator = -1;
            this.mDenominator = 0;
        } else if (i3 == 0 && i2 == 0) {
            this.mNumerator = 0;
            this.mDenominator = 0;
        } else if (i2 == 0) {
            this.mNumerator = 0;
            this.mDenominator = 1;
        } else {
            int gcd = gcd(i2, i3);
            this.mNumerator = i2 / gcd;
            this.mDenominator = i3 / gcd;
        }
    }

    public static int gcd(int i2, int i3) {
        while (true) {
            int i4 = i3;
            int i5 = i2;
            i2 = i4;
            if (i2 != 0) {
                i3 = i5 % i2;
            } else {
                return Math.abs(i5);
            }
        }
    }

    private static NumberFormatException invalidRational(String str) {
        throw new NumberFormatException("Invalid Rational: \"" + str + "\"");
    }

    private boolean isNegInf() {
        return this.mDenominator == 0 && this.mNumerator < 0;
    }

    private boolean isPosInf() {
        return this.mDenominator == 0 && this.mNumerator > 0;
    }

    public static PGRational parseRational(String str) throws NumberFormatException {
        a.a(str, "string must not be null");
        if (str.equals("NaN")) {
            return NaN;
        }
        if (str.equals("Infinity")) {
            return POSITIVE_INFINITY;
        }
        if (str.equals("-Infinity")) {
            return NEGATIVE_INFINITY;
        }
        int indexOf = str.indexOf(58);
        if (indexOf < 0) {
            indexOf = str.indexOf(47);
        }
        if (indexOf >= 0) {
            try {
                return new PGRational(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            } catch (NumberFormatException unused) {
                throw invalidRational(str);
            }
        }
        throw invalidRational(str);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int i2 = this.mNumerator;
        if (i2 == 0) {
            int i3 = this.mDenominator;
            if (i3 != 1 && i3 != 0) {
                throw new InvalidObjectException("Rational must be deserialized from a reduced form for zero values");
            }
            return;
        }
        int i4 = this.mDenominator;
        if (i4 != 0) {
            if (gcd(i2, i4) > 1) {
                throw new InvalidObjectException("Rational must be deserialized from a reduced form for finite values");
            }
        } else if (i2 != 1 && i2 != -1) {
            throw new InvalidObjectException("Rational must be deserialized from a reduced form for infinity values");
        }
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.mNumerator / this.mDenominator;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PGRational) && equals((PGRational) obj);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.mNumerator / this.mDenominator;
    }

    public int getDenominator() {
        return this.mDenominator;
    }

    public int getNumerator() {
        return this.mNumerator;
    }

    public int hashCode() {
        int i2 = this.mNumerator;
        return ((i2 >>> 16) | (i2 << 16)) ^ this.mDenominator;
    }

    @Override // java.lang.Number
    public int intValue() {
        if (isPosInf()) {
            return Integer.MAX_VALUE;
        }
        if (isNegInf()) {
            return Integer.MIN_VALUE;
        }
        if (isNaN()) {
            return 0;
        }
        return this.mNumerator / this.mDenominator;
    }

    public boolean isFinite() {
        return this.mDenominator != 0;
    }

    public boolean isInfinite() {
        return this.mNumerator != 0 && this.mDenominator == 0;
    }

    public boolean isNaN() {
        return this.mDenominator == 0 && this.mNumerator == 0;
    }

    public boolean isZero() {
        return isFinite() && this.mNumerator == 0;
    }

    @Override // java.lang.Number
    public long longValue() {
        if (isPosInf()) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        if (isNegInf()) {
            return Long.MIN_VALUE;
        }
        if (isNaN()) {
            return 0L;
        }
        return this.mNumerator / this.mDenominator;
    }

    @Override // java.lang.Number
    public short shortValue() {
        return (short) intValue();
    }

    public float toFloat() {
        return floatValue();
    }

    public String toString() {
        if (isNaN()) {
            return "NaN";
        }
        if (isPosInf()) {
            return "Infinity";
        }
        if (isNegInf()) {
            return "-Infinity";
        }
        return this.mNumerator + "/" + this.mDenominator;
    }

    private boolean equals(PGRational pGRational) {
        return this.mNumerator == pGRational.mNumerator && this.mDenominator == pGRational.mDenominator;
    }

    @Override // java.lang.Comparable
    public int compareTo(PGRational pGRational) {
        int i2;
        a.a(pGRational, "another must not be null");
        if (equals(pGRational)) {
            return 0;
        }
        if (isNaN()) {
            return 1;
        }
        if (pGRational.isNaN()) {
            return -1;
        }
        if (isPosInf() || pGRational.isNegInf()) {
            return 1;
        }
        if (isNegInf() || pGRational.isPosInf() || this.mNumerator * pGRational.mDenominator < pGRational.mNumerator * this.mDenominator) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }
}
