package com.tapjoy.internal;

import java.io.PrintStream;
import java.util.Map;
/* loaded from: classes3.dex */
public final class jg {
    public static void a(StringBuffer stringBuffer, Object obj, Map map) {
        if (obj == null) {
            stringBuffer.append("null");
        } else if (!obj.getClass().isArray()) {
            try {
                stringBuffer.append(obj.toString());
            } catch (Throwable th) {
                PrintStream printStream = System.err;
                printStream.println("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]");
                th.printStackTrace();
                stringBuffer.append("[FAILED toString()]");
            }
        } else if (obj instanceof boolean[]) {
            a(stringBuffer, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            a(stringBuffer, (byte[]) obj);
        } else if (obj instanceof char[]) {
            a(stringBuffer, (char[]) obj);
        } else if (obj instanceof short[]) {
            a(stringBuffer, (short[]) obj);
        } else if (obj instanceof int[]) {
            a(stringBuffer, (int[]) obj);
        } else if (obj instanceof long[]) {
            a(stringBuffer, (long[]) obj);
        } else if (obj instanceof float[]) {
            a(stringBuffer, (float[]) obj);
        } else if (obj instanceof double[]) {
            a(stringBuffer, (double[]) obj);
        } else {
            a(stringBuffer, (Object[]) obj, map);
        }
    }

    private static void a(StringBuffer stringBuffer, Object[] objArr, Map map) {
        stringBuffer.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                a(stringBuffer, objArr[i2], map);
                if (i2 != length - 1) {
                    stringBuffer.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            stringBuffer.append("...");
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, boolean[] zArr) {
        stringBuffer.append('[');
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(zArr[i2]);
            if (i2 != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, byte[] bArr) {
        stringBuffer.append('[');
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append((int) bArr[i2]);
            if (i2 != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, char[] cArr) {
        stringBuffer.append('[');
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(cArr[i2]);
            if (i2 != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, short[] sArr) {
        stringBuffer.append('[');
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append((int) sArr[i2]);
            if (i2 != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, int[] iArr) {
        stringBuffer.append('[');
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(iArr[i2]);
            if (i2 != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, long[] jArr) {
        stringBuffer.append('[');
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(jArr[i2]);
            if (i2 != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, float[] fArr) {
        stringBuffer.append('[');
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(fArr[i2]);
            if (i2 != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void a(StringBuffer stringBuffer, double[] dArr) {
        stringBuffer.append('[');
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(dArr[i2]);
            if (i2 != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }
}
