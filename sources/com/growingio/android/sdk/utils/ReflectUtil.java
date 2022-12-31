package com.growingio.android.sdk.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class ReflectUtil {
    private static final String TAG = "GIO.ReflectUtil";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SourceString {
        private ClassLoader classLoader;
        private int currentIndex = 1;
        private final String originalString;

        public SourceString(String str) {
            if (str.contains("/")) {
                this.originalString = str.replace('/', '.');
            } else {
                this.originalString = str;
            }
        }

        public boolean hasNextParam() {
            return this.originalString.charAt(this.currentIndex) != ')';
        }

        public Class<?> nextParamType() throws ClassNotFoundException {
            char charAt = this.originalString.charAt(this.currentIndex);
            int i2 = this.currentIndex + 1;
            this.currentIndex = i2;
            if (charAt != 'F') {
                if (charAt != 'L') {
                    if (charAt != 'S') {
                        if (charAt != 'I') {
                            if (charAt != 'J') {
                                if (charAt != 'Z') {
                                    if (charAt != '[') {
                                        switch (charAt) {
                                            case 'B':
                                                return Byte.TYPE;
                                            case 'C':
                                                return Character.TYPE;
                                            case 'D':
                                                return Double.TYPE;
                                            default:
                                                throw new RuntimeException("not support this signature: " + this.originalString);
                                        }
                                    }
                                    char charAt2 = this.originalString.charAt(i2);
                                    this.currentIndex++;
                                    if ('L' == charAt2) {
                                        return objParamType(true);
                                    }
                                    if (charAt2 != 'F') {
                                        if (charAt2 != 'S') {
                                            if (charAt2 != 'Z') {
                                                if (charAt2 != 'I') {
                                                    if (charAt2 != 'J') {
                                                        switch (charAt2) {
                                                            case 'B':
                                                                return byte[].class;
                                                            case 'C':
                                                                return char[].class;
                                                            case 'D':
                                                                return double[].class;
                                                            default:
                                                                throw new RuntimeException("ignore: " + this.originalString);
                                                        }
                                                    }
                                                    return long[].class;
                                                }
                                                return int[].class;
                                            }
                                            return boolean[].class;
                                        }
                                        return short[].class;
                                    }
                                    return float[].class;
                                }
                                return Boolean.TYPE;
                            }
                            return Long.TYPE;
                        }
                        return Integer.TYPE;
                    }
                    return Short.TYPE;
                }
                return objParamType(false);
            }
            return Float.TYPE;
        }

        Class<?> objParamType(boolean z) throws ClassNotFoundException {
            int indexOf = this.originalString.indexOf(59, this.currentIndex);
            String substring = this.originalString.substring(this.currentIndex, indexOf);
            if (z) {
                substring = "[L" + substring + ';';
            }
            this.currentIndex = indexOf + 1;
            ClassLoader classLoader = this.classLoader;
            if (classLoader != null) {
                return classLoader.loadClass(substring);
            }
            return Class.forName(substring);
        }
    }

    public static Object callMethod(Object obj, String str, Object... objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (objArr[i2] != null) {
                clsArr[i2] = objArr[i2].getClass();
            }
        }
        Method method = getMethod(obj.getClass(), str, clsArr);
        if (method != null) {
            try {
                return method.invoke(obj, objArr);
            } catch (Exception e2) {
                LogUtil.e(TAG, e2.getMessage(), e2);
                return null;
            }
        }
        return null;
    }

    public static <T> T findField(Class<?> cls, Object obj, String str) {
        Field findFieldObj = findFieldObj(cls, str);
        if (findFieldObj == null) {
            return null;
        }
        try {
            return (T) findFieldObj.get(obj);
        } catch (IllegalAccessException e2) {
            LogUtil.d(TAG, e2);
            return null;
        }
    }

    public static Field findFieldObj(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e2) {
            LogUtil.d(TAG, e2);
            return null;
        }
    }

    public static Field findFieldObjRecur(Class<?> cls, String str) {
        while (cls != Object.class) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static <T> T findFieldRecur(Object obj, String str) {
        Field findFieldObjRecur = findFieldObjRecur(obj.getClass(), str);
        if (findFieldObjRecur != null) {
            try {
                return (T) findFieldObjRecur.get(obj);
            } catch (IllegalAccessException e2) {
                LogUtil.d(TAG, e2);
                return null;
            }
        }
        return null;
    }

    public static Method getDeclaredRecur(Class<?> cls, String str, String str2) {
        try {
            return getDeclaredRecur(cls, str, parseArgumentTypeByDesc(str2, cls.getClassLoader()));
        } catch (Exception e2) {
            LogUtil.d(TAG, e2);
            return null;
        }
    }

    public static <T> T getFiledValue(Field field, Object obj) {
        if (field == null) {
            return null;
        }
        try {
            return (T) field.get(obj);
        } catch (IllegalAccessException e2) {
            LogUtil.e(TAG, e2.getMessage(), e2);
            return null;
        }
    }

    public static Method getMethod(String str, String str2, String str3) {
        return getMethod(null, str, str2, str3);
    }

    public static Class<?> getMethodFromSignature(String str) {
        throw new RuntimeException("NOT implementation");
    }

    public static Class<?>[] parseArgumentTypeByDesc(String str, ClassLoader classLoader) throws ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        SourceString sourceString = new SourceString(str);
        sourceString.classLoader = classLoader;
        while (sourceString.hasNextParam()) {
            arrayList.add(sourceString.nextParamType());
        }
        Class<?>[] clsArr = new Class[arrayList.size()];
        arrayList.toArray(clsArr);
        return clsArr;
    }

    public static Method getMethod(ClassLoader classLoader, String str, String str2, String str3) {
        Class<?> cls;
        try {
            if (str.contains("/")) {
                str = str.replace('/', '.');
            }
            if (classLoader != null) {
                cls = classLoader.loadClass(str);
            } else {
                cls = Class.forName(str);
            }
            return cls.getMethod(str2, parseArgumentTypeByDesc(str3, classLoader));
        } catch (Exception e2) {
            LogUtil.d(TAG, e2);
            return null;
        }
    }

    public static Method getDeclaredRecur(Class<?> cls, String str, Class<?>... clsArr) {
        Method declaredMethod;
        while (cls != Object.class) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
            if (declaredMethod != null) {
                return declaredMethod;
            }
        }
        return null;
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            LogUtil.d(TAG, e2);
            return null;
        }
    }
}
