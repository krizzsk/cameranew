package com.tapjoy.internal;

import java.math.BigInteger;
/* loaded from: classes3.dex */
public final class ci extends Number {
    private final String a;

    public ci(String str) {
        this.a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (number instanceof Integer) {
                return intValue() == number.intValue();
            } else if (number instanceof Long) {
                return longValue() == number.longValue();
            } else if (number instanceof Float) {
                return floatValue() == number.floatValue();
            } else if (number instanceof Double) {
                return doubleValue() == number.doubleValue();
            } else {
                return this.a.equals(number.toString());
            }
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.a);
    }

    @Override // java.lang.Number
    public final int intValue() {
        try {
            try {
                return Integer.parseInt(this.a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.a);
            }
        } catch (NumberFormatException unused2) {
            return new BigInteger(this.a).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        try {
            return Long.parseLong(this.a);
        } catch (NumberFormatException unused) {
            return new BigInteger(this.a).longValue();
        }
    }

    public final String toString() {
        return this.a;
    }
}
