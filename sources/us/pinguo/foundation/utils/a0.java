package us.pinguo.foundation.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ReflectionUtil.java */
/* loaded from: classes4.dex */
public class a0 {
    public static Object a(Object obj, String str, Class[] clsArr, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(obj, objArr);
    }

    public static Object b(Class cls, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = cls.getMethod(str, new Class[0]);
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        return method.invoke(null, null);
    }

    public static Object c(Class cls, String str, Class[] clsArr, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = cls.getMethod(str, clsArr);
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        return method.invoke(null, objArr);
    }

    public static <T> void d(Object obj, Class cls, String str, T t) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, t);
    }

    public static <T> void e(Object obj, String str, T t) throws NoSuchFieldException, IllegalAccessException {
        d(obj, obj.getClass(), str, t);
    }
}
