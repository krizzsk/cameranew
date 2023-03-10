package com.tapjoy.internal;

import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class eo {
    public static List a() {
        return new ep(Collections.emptyList());
    }

    public static List a(String str, List list) {
        if (list != null) {
            if (list instanceof ep) {
                list = ((ep) list).a;
            }
            if (list == Collections.emptyList() || (list instanceof en)) {
                return list;
            }
            en enVar = new en(list);
            if (enVar.contains(null)) {
                throw new IllegalArgumentException(str + ".contains(null)");
            }
            return enVar;
        }
        throw new NullPointerException(str + " == null");
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static IllegalStateException a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        String str = "";
        for (int i2 = 0; i2 < length; i2 += 2) {
            if (objArr[i2] == null) {
                if (sb.length() > 0) {
                    str = "s";
                }
                sb.append("\n  ");
                sb.append(objArr[i2 + 1]);
            }
        }
        throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
    }
}
