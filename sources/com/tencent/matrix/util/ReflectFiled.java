package com.tencent.matrix.util;

import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class ReflectFiled<Type> {
    private static final String TAG = "ReflectFiled";
    private Class<?> mClazz;
    private Field mField;
    private String mFieldName;
    private boolean mInit;

    public ReflectFiled(Class<?> cls, String str) {
        if (cls != null && str != null && str.length() != 0) {
            this.mClazz = cls;
            this.mFieldName = str;
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
                Field declaredField = cls.getDeclaredField(this.mFieldName);
                declaredField.setAccessible(true);
                this.mField = declaredField;
                break;
            } catch (Exception unused) {
            }
        }
        this.mInit = true;
    }

    public synchronized Type get() throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        return get(false);
    }

    public synchronized Type getWithoutThrow(Object obj) {
        Type type;
        try {
            try {
                type = get(true, obj);
            } catch (NoSuchFieldException e2) {
                MatrixLog.i(TAG, "getWithoutThrow, exception occur :%s", e2);
                type = null;
                return type;
            }
        } catch (IllegalAccessException e3) {
            MatrixLog.i(TAG, "getWithoutThrow, exception occur :%s", e3);
            type = null;
            return type;
        } catch (IllegalArgumentException e4) {
            MatrixLog.i(TAG, "getWithoutThrow, exception occur :%s", e4);
            type = null;
            return type;
        }
        return type;
    }

    public synchronized boolean set(Object obj, Type type) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        return set(obj, type, false);
    }

    public synchronized boolean setWithoutThrow(Object obj, Type type) {
        boolean z;
        z = false;
        try {
            try {
                z = set(obj, type, true);
            } catch (NoSuchFieldException e2) {
                MatrixLog.i(TAG, "setWithoutThrow, exception occur :%s", e2);
            }
        } catch (IllegalAccessException e3) {
            MatrixLog.i(TAG, "setWithoutThrow, exception occur :%s", e3);
        } catch (IllegalArgumentException e4) {
            MatrixLog.i(TAG, "setWithoutThrow, exception occur :%s", e4);
        }
        return z;
    }

    public synchronized Type get(boolean z) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        prepare();
        Field field = this.mField;
        if (field != null) {
            try {
                return (Type) field.get(null);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("unable to cast object");
            }
        } else if (z) {
            MatrixLog.w(TAG, String.format("Field %s is no exists.", this.mFieldName), new Object[0]);
            return null;
        } else {
            throw new NoSuchFieldException();
        }
    }

    public synchronized boolean set(Object obj, Type type, boolean z) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        prepare();
        Field field = this.mField;
        if (field != null) {
            field.set(obj, type);
            return true;
        } else if (z) {
            MatrixLog.w(TAG, String.format("Field %s is no exists.", this.mFieldName), new Object[0]);
            return false;
        } else {
            throw new NoSuchFieldException("Method " + this.mFieldName + " is not exists.");
        }
    }

    public synchronized Type getWithoutThrow() {
        Type type;
        try {
            try {
                type = get(true);
            } catch (NoSuchFieldException e2) {
                MatrixLog.i(TAG, "getWithoutThrow, exception occur :%s", e2);
                type = null;
                return type;
            }
        } catch (IllegalAccessException e3) {
            MatrixLog.i(TAG, "getWithoutThrow, exception occur :%s", e3);
            type = null;
            return type;
        } catch (IllegalArgumentException e4) {
            MatrixLog.i(TAG, "getWithoutThrow, exception occur :%s", e4);
            type = null;
            return type;
        }
        return type;
    }

    public synchronized boolean setWithoutThrow(Type type) {
        boolean z;
        z = false;
        try {
            try {
                z = set(null, type, true);
            } catch (NoSuchFieldException e2) {
                MatrixLog.i(TAG, "setWithoutThrow, exception occur :%s", e2);
            }
        } catch (IllegalAccessException e3) {
            MatrixLog.i(TAG, "setWithoutThrow, exception occur :%s", e3);
        } catch (IllegalArgumentException e4) {
            MatrixLog.i(TAG, "setWithoutThrow, exception occur :%s", e4);
        }
        return z;
    }

    public synchronized boolean set(Type type) throws NoSuchFieldException, IllegalAccessException {
        return set(null, type, false);
    }

    public synchronized Type get(boolean z, Object obj) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        prepare();
        Field field = this.mField;
        if (field != null) {
            try {
                return (Type) field.get(obj);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("unable to cast object");
            }
        } else if (z) {
            MatrixLog.w(TAG, String.format("Field %s is no exists.", this.mFieldName), new Object[0]);
            return null;
        } else {
            throw new NoSuchFieldException();
        }
    }

    public synchronized Type get(Object obj) throws NoSuchFieldException, IllegalAccessException {
        return get(false, obj);
    }
}
