package com.google.android.gms.common.util;

import java.lang.reflect.Array;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class b {
    public static <T> T[] a(T[]... tArr) {
        if (tArr.length == 0) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass(), 0));
        }
        int i2 = 0;
        for (T[] tArr2 : tArr) {
            i2 += tArr2.length;
        }
        T[] tArr3 = (T[]) Arrays.copyOf(tArr[0], i2);
        int length = tArr[0].length;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T[] tArr4 = tArr[i3];
            System.arraycopy(tArr4, 0, tArr3, length, tArr4.length);
            length += tArr4.length;
        }
        return tArr3;
    }

    public static <T> boolean b(T[] tArr, T t) {
        int length = tArr != null ? tArr.length : 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (com.google.android.gms.common.internal.p.a(tArr[i2], t)) {
                break;
            } else {
                i2++;
            }
        }
        return i2 >= 0;
    }

    public static void c(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(dArr[i2]));
        }
    }

    public static void d(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(fArr[i2]));
        }
    }

    public static void e(StringBuilder sb, int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(iArr[i2]));
        }
    }

    public static void f(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(jArr[i2]));
        }
    }

    public static <T> void g(StringBuilder sb, T[] tArr) {
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(tArr[i2].toString());
        }
    }

    public static void h(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(zArr[i2]));
        }
    }

    public static void i(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i2]);
            sb.append("\"");
        }
    }
}
