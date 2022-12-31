package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
/* compiled from: CollectionToArray.kt */
/* loaded from: classes3.dex */
public final class n {
    private static final Object[] a = new Object[0];

    public static final Object[] a(Collection<?> collection) {
        s.h(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr = new Object[size];
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    objArr[i2] = it.next();
                    if (i3 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            if (i3 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                            i4 = us.pinguo.user.recycler.c.TYPE_ERROR;
                        }
                        objArr = Arrays.copyOf(objArr, i4);
                        s.g(objArr, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i3);
                        s.g(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i2 = i3;
                }
            }
        }
        return a;
    }

    public static final Object[] b(Collection<?> collection, Object[] objArr) {
        Object[] objArr2;
        s.h(collection, "collection");
        Objects.requireNonNull(objArr);
        int size = collection.size();
        int i2 = 0;
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            s.f(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i3 = i2 + 1;
            objArr2[i2] = it.next();
            if (i3 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i4 = ((i3 * 3) + 1) >>> 1;
                if (i4 <= i3) {
                    if (i3 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i4 = us.pinguo.user.recycler.c.TYPE_ERROR;
                }
                objArr2 = Arrays.copyOf(objArr2, i4);
                s.g(objArr2, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i3] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i3);
                s.g(copyOf, "copyOf(result, size)");
                return copyOf;
            }
            i2 = i3;
        }
    }
}
