package com.tencent.matrix.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class ReflectMethod {
    private static final String TAG = "ReflectFiled";
    private Class<?> mClazz;
    private boolean mInit;
    private Method mMethod;
    private String mMethodName;
    private Class[] mParameterTypes;

    public ReflectMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null && str != null && str.length() != 0) {
            this.mClazz = cls;
            this.mMethodName = str;
            this.mParameterTypes = clsArr;
            return;
        }
        throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
    }

    private synchronized void prepare() {
        if (this.mInit) {
            return;
        }
        for (Class<?> cls = this.mClazz; cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(this.mMethodName, this.mParameterTypes);
                declaredMethod.setAccessible(true);
                this.mMethod = declaredMethod;
                break;
            } catch (Exception unused) {
            }
        }
        this.mInit = true;
    }

    public synchronized <T> T invoke(Object obj, Object... objArr) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return (T) invoke(obj, false, objArr);
    }

    public synchronized <T> T invokeWithoutThrow(Object obj, Object... objArr) {
        try {
            try {
                return (T) invoke(obj, true, objArr);
            } catch (IllegalAccessException e2) {
                MatrixLog.e(TAG, "invokeWithoutThrow, exception occur :%s", e2);
                return null;
            } catch (NoSuchFieldException e3) {
                MatrixLog.e(TAG, "invokeWithoutThrow, exception occur :%s", e3);
                return null;
            }
        } catch (IllegalArgumentException e4) {
            MatrixLog.e(TAG, "invokeWithoutThrow, exception occur :%s", e4);
            return null;
        } catch (InvocationTargetException e5) {
            MatrixLog.e(TAG, "invokeWithoutThrow, exception occur :%s", e5);
            return null;
        }
    }

    public synchronized <T> T invoke(Object obj, boolean z, Object... objArr) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        prepare();
        Method method = this.mMethod;
        if (method != null) {
            return (T) method.invoke(obj, objArr);
        } else if (z) {
            MatrixLog.w(TAG, "Field %s is no exists", this.mMethodName);
            return null;
        } else {
            throw new NoSuchFieldException("Method " + this.mMethodName + " is not exists.");
        }
    }
}
