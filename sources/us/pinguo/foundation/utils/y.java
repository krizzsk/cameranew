package us.pinguo.foundation.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/* compiled from: ObjectUtils.java */
/* loaded from: classes4.dex */
public final class y {

    /* compiled from: ObjectUtils.java */
    @FunctionalInterface
    /* loaded from: classes4.dex */
    public interface a<E> {
        boolean test(E e2);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static int c(Object[] objArr, Object obj) {
        if (obj != null && objArr != null) {
            for (int i2 = 0; i2 < objArr.length; i2++) {
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public static String d(String[] strArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            sb.append(strArr[i2]);
            if (i2 < strArr.length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static <E> boolean e(Collection<E> collection, a<E> aVar) {
        boolean z = false;
        if (collection != null && !collection.isEmpty()) {
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                if (aVar.test(it.next())) {
                    it.remove();
                    z = true;
                }
            }
        }
        return z;
    }

    public static String[] f(String str, String str2) {
        return (str == null || str.length() == 0) ? new String[0] : str.split(str2);
    }
}
