package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.b;
import java.lang.reflect.Field;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class d<T> extends b.a {
    private final T a;

    private d(T t) {
        this.a = t;
    }

    public static <T> T y0(b bVar) {
        if (bVar instanceof d) {
            return ((d) bVar).a;
        }
        IBinder asBinder = bVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i2 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i2++;
                field = field2;
            }
        }
        if (i2 == 1) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return (T) field.get(asBinder);
                } catch (IllegalAccessException e2) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
                } catch (NullPointerException e3) {
                    throw new IllegalArgumentException("Binder object is null.", e3);
                }
            }
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        int length = declaredFields.length;
        StringBuilder sb = new StringBuilder(64);
        sb.append("Unexpected number of IObjectWrapper declared fields: ");
        sb.append(length);
        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> b z0(T t) {
        return new d(t);
    }
}
