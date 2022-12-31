package com.bytedance.sdk.a.b.a.g;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: OptionalMethod.java */
/* loaded from: classes.dex */
class d<T> {
    private final Class<?> a;
    private final String b;
    private final Class[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Class<?> cls, String str, Class... clsArr) {
        this.a = cls;
        this.b = str;
        this.c = clsArr;
    }

    public boolean a(T t) {
        return a(t.getClass()) != null;
    }

    public Object b(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object c(T t, Object... objArr) throws InvocationTargetException {
        Method a = a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException e2) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
                assertionError.initCause(e2);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.b + " not supported for object " + t);
    }

    public Object d(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object a(T t, Object... objArr) throws InvocationTargetException {
        Method a = a(t.getClass());
        if (a == null) {
            return null;
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    private Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.b;
        if (str != null) {
            Method a = a(cls, str, this.c);
            if (a == null || (cls2 = this.a) == null || cls2.isAssignableFrom(a.getReturnType())) {
                return a;
            }
            return null;
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
