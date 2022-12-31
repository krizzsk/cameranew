package kotlin.coroutines.jvm.internal;
/* compiled from: boxing.kt */
/* loaded from: classes3.dex */
public final class Boxing {
    public static final Boolean boxBoolean(boolean z) {
        return Boolean.valueOf(z);
    }

    public static final Byte boxByte(byte b) {
        return Byte.valueOf(b);
    }

    public static final Character boxChar(char c) {
        return new Character(c);
    }

    public static final Double boxDouble(double d2) {
        return new Double(d2);
    }

    public static final Float boxFloat(float f2) {
        return new Float(f2);
    }

    public static final Integer boxInt(int i2) {
        return new Integer(i2);
    }

    public static final Long boxLong(long j2) {
        return new Long(j2);
    }

    public static final Short boxShort(short s) {
        return new Short(s);
    }
}
