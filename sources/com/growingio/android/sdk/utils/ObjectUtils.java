package com.growingio.android.sdk.utils;
/* loaded from: classes2.dex */
public class ObjectUtils {
    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static String toString(Object obj) {
        return String.valueOf(obj);
    }
}
