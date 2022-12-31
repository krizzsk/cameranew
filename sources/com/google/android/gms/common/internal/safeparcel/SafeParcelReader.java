package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class SafeParcelReader {

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public static class ParseException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ParseException(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                int r1 = r1 + 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    public static Double A(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        if (L == 0) {
            return null;
        }
        P(parcel, i2, L, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float B(Parcel parcel, int i2) {
        O(parcel, i2, 4);
        return parcel.readFloat();
    }

    public static Float C(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        if (L == 0) {
            return null;
        }
        P(parcel, i2, L, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int D(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder E(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + L);
        return readStrongBinder;
    }

    public static int F(Parcel parcel, int i2) {
        O(parcel, i2, 4);
        return parcel.readInt();
    }

    public static Integer G(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        if (L == 0) {
            return null;
        }
        P(parcel, i2, L, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static void H(Parcel parcel, int i2, List list, ClassLoader classLoader) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(dataPosition + L);
    }

    public static long I(Parcel parcel, int i2) {
        O(parcel, i2, 8);
        return parcel.readLong();
    }

    public static Long J(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        if (L == 0) {
            return null;
        }
        P(parcel, i2, L, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short K(Parcel parcel, int i2) {
        O(parcel, i2, 4);
        return (short) parcel.readInt();
    }

    public static int L(Parcel parcel, int i2) {
        return (i2 & SupportMenu.CATEGORY_MASK) != -65536 ? (i2 >> 16) & 65535 : parcel.readInt();
    }

    public static void M(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + L(parcel, i2));
    }

    public static int N(Parcel parcel) {
        int D = D(parcel);
        int L = L(parcel, D);
        int dataPosition = parcel.dataPosition();
        if (v(D) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(D));
            throw new ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = L + dataPosition;
        if (i2 < dataPosition || i2 > parcel.dataSize()) {
            StringBuilder sb = new StringBuilder(54);
            sb.append("Size read is invalid start=");
            sb.append(dataPosition);
            sb.append(" end=");
            sb.append(i2);
            throw new ParseException(sb.toString(), parcel);
        }
        return i2;
    }

    private static void O(Parcel parcel, int i2, int i3) {
        int L = L(parcel, i2);
        if (L == i3) {
            return;
        }
        String hexString = Integer.toHexString(L);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(L);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    private static void P(Parcel parcel, int i2, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        String hexString = Integer.toHexString(i3);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i4);
        sb.append(" got ");
        sb.append(i3);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    public static BigDecimal a(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + L);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static BigDecimal[] b(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i3] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + L);
        return bigDecimalArr;
    }

    public static BigInteger c(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + L);
        return new BigInteger(createByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            bigIntegerArr[i3] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + L);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + L);
        return createBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + L);
        return readBundle;
    }

    public static byte[] g(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + L);
        return createByteArray;
    }

    public static double[] h(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + L);
        return createDoubleArray;
    }

    public static float[] i(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + L);
        return createFloatArray;
    }

    public static int[] j(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + L);
        return createIntArray;
    }

    public static ArrayList<Integer> k(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + L);
        return arrayList;
    }

    public static long[] l(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + L);
        return createLongArray;
    }

    public static Parcel m(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, L);
        parcel.setDataPosition(dataPosition + L);
        return obtain;
    }

    public static Parcel[] n(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i3] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i3] = null;
            }
        }
        parcel.setDataPosition(dataPosition + L);
        return parcelArr;
    }

    public static <T extends Parcelable> T o(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + L);
        return createFromParcel;
    }

    public static String p(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + L);
        return readString;
    }

    public static String[] q(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + L);
        return createStringArray;
    }

    public static ArrayList<String> r(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + L);
        return createStringArrayList;
    }

    public static <T> T[] s(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + L);
        return tArr;
    }

    public static <T> ArrayList<T> t(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int L = L(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (L == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + L);
        return createTypedArrayList;
    }

    public static void u(Parcel parcel, int i2) {
        if (parcel.dataPosition() == i2) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i2);
        throw new ParseException(sb.toString(), parcel);
    }

    public static int v(int i2) {
        return i2 & 65535;
    }

    public static boolean w(Parcel parcel, int i2) {
        O(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean x(Parcel parcel, int i2) {
        int L = L(parcel, i2);
        if (L == 0) {
            return null;
        }
        P(parcel, i2, L, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte y(Parcel parcel, int i2) {
        O(parcel, i2, 4);
        return (byte) parcel.readInt();
    }

    public static double z(Parcel parcel, int i2) {
        O(parcel, i2, 8);
        return parcel.readDouble();
    }
}
