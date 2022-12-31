package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
/* compiled from: MessageFormatter.java */
/* loaded from: classes3.dex */
public final class b {
    public static final a a(String str, Object[] objArr) {
        Throwable i2 = i(objArr);
        if (i2 != null) {
            objArr = q(objArr);
        }
        return b(str, objArr, i2);
    }

    public static final a b(String str, Object[] objArr, Throwable th) {
        int i2;
        if (str == null) {
            return new a(null, objArr, th);
        }
        if (objArr == null) {
            return new a(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i3 = 0;
        int i4 = 0;
        while (i3 < objArr.length) {
            int indexOf = str.indexOf("{}", i4);
            if (indexOf == -1) {
                if (i4 == 0) {
                    return new a(str, objArr, th);
                }
                sb.append((CharSequence) str, i4, str.length());
                return new a(sb.toString(), objArr, th);
            }
            if (l(str, indexOf)) {
                if (!k(str, indexOf)) {
                    i3--;
                    sb.append((CharSequence) str, i4, indexOf - 1);
                    sb.append('{');
                    i2 = indexOf + 1;
                    i4 = i2;
                    i3++;
                } else {
                    sb.append((CharSequence) str, i4, indexOf - 1);
                    f(sb, objArr[i3], new HashMap());
                }
            } else {
                sb.append((CharSequence) str, i4, indexOf);
                f(sb, objArr[i3], new HashMap());
            }
            i2 = indexOf + 2;
            i4 = i2;
            i3++;
        }
        sb.append((CharSequence) str, i4, str.length());
        return new a(sb.toString(), objArr, th);
    }

    private static void c(StringBuilder sb, boolean[] zArr) {
        sb.append('[');
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(zArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void d(StringBuilder sb, byte[] bArr) {
        sb.append('[');
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append((int) bArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void e(StringBuilder sb, char[] cArr) {
        sb.append('[');
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(cArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void f(StringBuilder sb, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb.append("null");
        } else if (!obj.getClass().isArray()) {
            o(sb, obj);
        } else if (obj instanceof boolean[]) {
            c(sb, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            d(sb, (byte[]) obj);
        } else if (obj instanceof char[]) {
            e(sb, (char[]) obj);
        } else if (obj instanceof short[]) {
            p(sb, (short[]) obj);
        } else if (obj instanceof int[]) {
            j(sb, (int[]) obj);
        } else if (obj instanceof long[]) {
            m(sb, (long[]) obj);
        } else if (obj instanceof float[]) {
            h(sb, (float[]) obj);
        } else if (obj instanceof double[]) {
            g(sb, (double[]) obj);
        } else {
            n(sb, (Object[]) obj, map);
        }
    }

    private static void g(StringBuilder sb, double[] dArr) {
        sb.append('[');
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(dArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void h(StringBuilder sb, float[] fArr) {
        sb.append('[');
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(fArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    static final Throwable i(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    private static void j(StringBuilder sb, int[] iArr) {
        sb.append('[');
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(iArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    static final boolean k(String str, int i2) {
        return i2 >= 2 && str.charAt(i2 - 2) == '\\';
    }

    static final boolean l(String str, int i2) {
        return i2 != 0 && str.charAt(i2 - 1) == '\\';
    }

    private static void m(StringBuilder sb, long[] jArr) {
        sb.append('[');
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(jArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void n(StringBuilder sb, Object[] objArr, Map<Object[], Object> map) {
        sb.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                f(sb, objArr[i2], map);
                if (i2 != length - 1) {
                    sb.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            sb.append("...");
        }
        sb.append(']');
    }

    private static void o(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            f.b("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb.append("[FAILED toString()]");
        }
    }

    private static void p(StringBuilder sb, short[] sArr) {
        sb.append('[');
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append((int) sArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static Object[] q(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            return objArr2;
        }
        throw new IllegalStateException("non-sensical empty or null argument array");
    }
}
