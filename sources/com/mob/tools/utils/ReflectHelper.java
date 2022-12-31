package com.mob.tools.utils;

import android.content.BroadcastReceiver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Constants;
import com.mob.tools.gui.CachePool;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Marker;
/* loaded from: classes3.dex */
public class ReflectHelper {
    private static CachePool<String, Constructor<?>> cachedConstr;
    private static CachePool<String, Method> cachedMethod;
    private static HashMap<String, Class<?>> classMap;
    private static HashMap<Class<?>, String> nameMap;
    private static HashSet<String> packageSet;

    /* loaded from: classes3.dex */
    public interface ReflectRunnable<ArgType, RetType> {
        RetType run(ArgType argtype);
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        packageSet = hashSet;
        hashSet.add("java.lang");
        packageSet.add("java.io");
        packageSet.add("java.nio");
        packageSet.add("java.net");
        packageSet.add("java.util");
        packageSet.add("com.mob.tools");
        packageSet.add("com.mob.tools.gui");
        packageSet.add("com.mob.tools.log");
        packageSet.add("com.mob.tools.network");
        packageSet.add("com.mob.tools.utils");
        HashMap<String, Class<?>> hashMap = new HashMap<>();
        classMap = hashMap;
        hashMap.put("double", Double.TYPE);
        classMap.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
        classMap.put(Constants.LONG, Long.TYPE);
        classMap.put("int", Integer.TYPE);
        classMap.put("short", Short.TYPE);
        classMap.put("byte", Byte.TYPE);
        classMap.put("char", Character.TYPE);
        classMap.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
        classMap.put("Object", Object.class);
        classMap.put("String", String.class);
        classMap.put("Thread", Thread.class);
        classMap.put("Runnable", Runnable.class);
        classMap.put("System", System.class);
        classMap.put("double", Double.class);
        classMap.put("Float", Float.class);
        classMap.put("Long", Long.class);
        classMap.put("Integer", Integer.class);
        classMap.put("Short", Short.class);
        classMap.put("Byte", Byte.class);
        classMap.put("Character", Character.class);
        classMap.put("Boolean", Boolean.class);
        nameMap = new HashMap<>();
        for (Map.Entry<String, Class<?>> entry : classMap.entrySet()) {
            nameMap.put(entry.getValue(), entry.getKey());
        }
        cachedMethod = new CachePool<>(25);
        cachedConstr = new CachePool<>(5);
    }

    public static Object createProxy(HashMap<String, ReflectRunnable<Object, Object[]>> hashMap, Class<?>... clsArr) throws Throwable {
        HashMap hashMap2 = new HashMap();
        for (final Map.Entry<String, ReflectRunnable<Object, Object[]>> entry : hashMap.entrySet()) {
            hashMap2.put(entry.getKey(), new ReflectRunnable<Object[], Object>() { // from class: com.mob.tools.utils.ReflectHelper.1
                @Override // com.mob.tools.utils.ReflectHelper.ReflectRunnable
                public Object run(Object[] objArr) {
                    return ((Object[]) ((ReflectRunnable) entry.getValue()).run(objArr))[0];
                }
            });
        }
        return createProxy((Map<String, ReflectRunnable<Object[], Object>>) hashMap2, clsArr);
    }

    public static Class<?> getClass(String str) throws Throwable {
        Class<?> importedClass = getImportedClass(str);
        if (importedClass == null) {
            try {
                importedClass = Class.forName(str);
                if (importedClass != null) {
                    classMap.put(str, importedClass);
                }
            } catch (Throwable unused) {
            }
        }
        return importedClass;
    }

    private static synchronized Class<?> getImportedClass(String str) {
        Class<?> cls;
        synchronized (ReflectHelper.class) {
            cls = classMap.get(str);
            if (cls == null) {
                Iterator<String> it = packageSet.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    try {
                        importClass(next + "." + str);
                    } catch (Throwable unused) {
                    }
                    cls = classMap.get(str);
                    if (cls != null) {
                        break;
                    }
                }
            }
        }
        return cls;
    }

    public static <T> T getInstanceField(Object obj, String str) throws Throwable {
        try {
            return (T) onGetInstanceField(obj, str);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str, th);
        }
    }

    public static String getName(Class<?> cls) throws Throwable {
        String str = nameMap.get(cls);
        if (str == null) {
            str = cls.getSimpleName();
            if (classMap.containsKey(str)) {
                nameMap.remove(classMap.get(str));
            }
            classMap.put(str, cls);
            nameMap.put(cls, str);
        }
        return str;
    }

    public static <T> T getStaticField(String str, String str2) throws Throwable {
        try {
            return (T) onGetStaticField(str, str2);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", fieldName: " + str2, th);
        }
    }

    private static Class<?>[] getTypes(Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (objArr[i2] instanceof BroadcastReceiver) {
                clsArr[i2] = BroadcastReceiver.class;
            } else {
                clsArr[i2] = objArr[i2] == null ? null : objArr[i2].getClass();
            }
        }
        return clsArr;
    }

    public static String importClass(String str) throws Throwable {
        return importClass(null, str);
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        return (T) invokeMethod(null, obj, str, objArr, clsArr);
    }

    private static <T> T invokeMethod(String str, Object obj, String str2, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        Class<?> cls;
        if (objArr == null) {
            objArr = new Object[0];
        }
        if (clsArr == null) {
            clsArr = new Class[0];
        }
        if (obj == null) {
            cls = getImportedClass(str);
        } else {
            cls = obj.getClass();
        }
        String str3 = cls.getName() + "#" + str2 + "#" + objArr.length;
        Method method = cachedMethod.get(str3);
        if (method != null) {
            method.setAccessible(true);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return null;
            }
            return (T) method.invoke(obj, objArr);
        }
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str2, clsArr);
                cachedMethod.put(str3, declaredMethod);
                declaredMethod.setAccessible(true);
                if (declaredMethod.getReturnType() == Void.TYPE) {
                    declaredMethod.invoke(obj, objArr);
                    return null;
                }
                return (T) declaredMethod.invoke(obj, objArr);
            } catch (Throwable unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("className: ");
        Class<?> cls2 = str;
        if (obj != null) {
            cls2 = obj.getClass();
        }
        sb.append((Object) cls2);
        sb.append(", methodName: ");
        sb.append(str2);
        throw new NoSuchMethodException(sb.toString());
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        return (T) invokeMethod(str, null, str2, objArr, clsArr);
    }

    private static boolean matchParams(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i2 = 0; i2 < clsArr2.length; i2++) {
                if (clsArr2[i2] != null && !primitiveEquals(clsArr[i2], clsArr2[i2]) && !clsArr[i2].isAssignableFrom(clsArr2[i2])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static Object newArray(String str, Object... objArr) throws Throwable {
        Class<?> importedClass;
        int i2 = 0;
        String str2 = str;
        while (str2.startsWith("[")) {
            i2++;
            str2 = str2.substring(1);
        }
        int[] iArr = null;
        if (i2 == objArr.length) {
            int[] iArr2 = new int[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    iArr2[i3] = Integer.parseInt(String.valueOf(objArr[i3]));
                } catch (Throwable unused) {
                }
            }
            iArr = iArr2;
        }
        if (iArr != null) {
            if ("B".equals(str2)) {
                importedClass = Byte.TYPE;
            } else if (ExifInterface.LATITUDE_SOUTH.equals(str2)) {
                importedClass = Short.TYPE;
            } else if ("I".equals(str2)) {
                importedClass = Integer.TYPE;
            } else if ("J".equals(str2)) {
                importedClass = Long.TYPE;
            } else if ("F".equals(str2)) {
                importedClass = Float.TYPE;
            } else if ("D".equals(str2)) {
                importedClass = Double.TYPE;
            } else if ("Z".equals(str2)) {
                importedClass = Boolean.TYPE;
            } else if ("C".equals(str2)) {
                importedClass = Character.TYPE;
            } else {
                importedClass = getImportedClass(str2);
            }
            if (importedClass != null) {
                return Array.newInstance(importedClass, iArr);
            }
        }
        throw new NoSuchMethodException("className: [" + str + ", methodName: <init>");
    }

    public static Object newInstance(String str, Object... objArr) throws Throwable {
        try {
            return onNewInstance(str, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", methodName: <init>", th);
        }
    }

    private static Object onGetElement(Object obj, String str) throws Throwable {
        int i2;
        int i3;
        if (obj instanceof List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i3 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused) {
                    i3 = -1;
                }
                if (i3 != -1) {
                    return ((List) obj).get(i3);
                }
            }
        } else if ("length".equals(str)) {
            return Integer.valueOf(Array.getLength(obj));
        } else {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i2 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused2) {
                    i2 = -1;
                }
                if (i2 != -1) {
                    return Array.get(obj, i2);
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    private static <T> T onGetInstanceField(Object obj, String str) throws Throwable {
        if (!(obj instanceof List) && !obj.getClass().isArray()) {
            if (obj instanceof Map) {
                return (T) ((Map) obj).get(str);
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                arrayList.add(cls);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Field field = null;
                try {
                    field = ((Class) it.next()).getDeclaredField(str);
                } catch (Throwable unused) {
                }
                if (field != null && !Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    return (T) field.get(obj);
                }
            }
            throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
        }
        return (T) onGetElement(obj, str);
    }

    private static <T> T onGetStaticField(String str, String str2) throws Throwable {
        Field field;
        ArrayList arrayList = new ArrayList();
        for (Class<?> importedClass = getImportedClass(str); importedClass != null; importedClass = importedClass.getSuperclass()) {
            arrayList.add(importedClass);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                field = ((Class) it.next()).getDeclaredField(str2);
            } catch (Throwable unused) {
                field = null;
            }
            if (field != null && Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                return (T) field.get(null);
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2);
    }

    private static Object onNewInstance(String str, Object... objArr) throws Throwable {
        boolean z;
        if (str.startsWith("[")) {
            return newArray(str, objArr);
        }
        Class<?> importedClass = getImportedClass(str);
        String str2 = importedClass.getName() + "#" + objArr.length;
        Constructor<?> constructor = cachedConstr.get(str2);
        Class<?>[] types = getTypes(objArr);
        if (constructor != null && matchParams(constructor.getParameterTypes(), types)) {
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        }
        Constructor<?>[] declaredConstructors = importedClass.getDeclaredConstructors();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Constructor<?> constructor2 : declaredConstructors) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (matchParams(parameterTypes, types)) {
                cachedConstr.put(str2, constructor2);
                constructor2.setAccessible(true);
                return constructor2.newInstance(objArr);
            }
            if (parameterTypes.length > 0 && parameterTypes[parameterTypes.length - 1].isArray() && types.length >= parameterTypes.length - 1) {
                arrayList.add(constructor2);
                arrayList2.add(parameterTypes);
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            Class[] clsArr = (Class[]) arrayList2.get(i2);
            Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
            if (tryMatchParams(clsArr, types)) {
                Object[] objArr2 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                objArr2[objArr.length] = Array.newInstance(componentType, 0);
                Constructor constructor3 = (Constructor) arrayList.get(i2);
                constructor3.setAccessible(true);
                return constructor3.newInstance(objArr);
            }
            int length = clsArr.length - 1;
            while (true) {
                if (length >= types.length) {
                    z = true;
                    break;
                } else if (!types[length].equals(componentType)) {
                    z = false;
                    break;
                } else {
                    length++;
                }
            }
            if (z) {
                int length2 = (types.length - clsArr.length) + 1;
                Object newInstance = Array.newInstance(componentType, length2);
                for (int i3 = 0; i3 < length2; i3++) {
                    Array.set(newInstance, i3, objArr[(clsArr.length - 1) + i3]);
                }
                Object[] objArr3 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
                objArr3[objArr.length] = newInstance;
                Constructor constructor4 = (Constructor) arrayList.get(i2);
                constructor4.setAccessible(true);
                return constructor4.newInstance(objArr);
            }
        }
        throw new NoSuchMethodException("className: " + str + ", methodName: <init>");
    }

    private static void onSetElement(Object obj, String str, Object obj2) throws Throwable {
        int i2;
        int i3;
        if (obj instanceof List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i3 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused) {
                    i3 = -1;
                }
                if (i3 != -1) {
                    ((List) obj).set(i3, obj2);
                    return;
                }
            }
        } else if (str.startsWith("[") && str.endsWith("]")) {
            try {
                i2 = Integer.parseInt(str.substring(1, str.length() - 1));
            } catch (Throwable unused2) {
                i2 = -1;
            }
            if (i2 != -1) {
                String name = obj.getClass().getName();
                while (name.startsWith("[")) {
                    name = name.substring(1);
                }
                Class<?> cls = obj2.getClass();
                if (!"B".equals(name)) {
                    Object obj3 = null;
                    if (ExifInterface.LATITUDE_SOUTH.equals(name)) {
                        if (cls == Short.class) {
                            obj3 = obj2;
                        } else if (cls == Byte.class) {
                            obj3 = Short.valueOf(((Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            Array.set(obj, i2, obj3);
                            return;
                        }
                    } else if ("I".equals(name)) {
                        if (cls == Integer.class) {
                            obj3 = obj2;
                        } else if (cls == Short.class) {
                            obj3 = Integer.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            obj3 = Integer.valueOf(((Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            Array.set(obj, i2, obj3);
                            return;
                        }
                    } else if ("J".equals(name)) {
                        if (cls == Long.class) {
                            obj3 = obj2;
                        } else if (cls == Integer.class) {
                            obj3 = Long.valueOf(((Integer) obj2).intValue());
                        } else if (cls == Short.class) {
                            obj3 = Long.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            obj3 = Long.valueOf(((Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            Array.set(obj, i2, obj3);
                            return;
                        }
                    } else if ("F".equals(name)) {
                        if (cls == Float.class) {
                            obj3 = obj2;
                        } else if (cls == Long.class) {
                            obj3 = Float.valueOf((float) ((Long) obj2).longValue());
                        } else if (cls == Integer.class) {
                            obj3 = Float.valueOf(((Integer) obj2).intValue());
                        } else if (cls == Short.class) {
                            obj3 = Float.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            obj3 = Float.valueOf(((Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            Array.set(obj, i2, obj3);
                            return;
                        }
                    } else if ("D".equals(name)) {
                        if (cls == Double.class) {
                            obj3 = obj2;
                        } else if (cls == Float.class) {
                            obj3 = Double.valueOf(((Float) obj2).floatValue());
                        } else if (cls == Long.class) {
                            obj3 = Double.valueOf(((Long) obj2).longValue());
                        } else if (cls == Integer.class) {
                            obj3 = Double.valueOf(((Integer) obj2).intValue());
                        } else if (cls == Short.class) {
                            obj3 = Double.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            obj3 = Double.valueOf(((Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            Array.set(obj, i2, obj3);
                            return;
                        }
                    } else if ("Z".equals(name)) {
                        if (cls == Boolean.class) {
                            Array.set(obj, i2, obj2);
                            return;
                        }
                    } else if ("C".equals(name)) {
                        if (cls == Character.class) {
                            Array.set(obj, i2, obj2);
                            return;
                        }
                    } else if (name.equals(cls.getName())) {
                        Array.set(obj, i2, obj2);
                        return;
                    }
                } else if (cls == Byte.class) {
                    Array.set(obj, i2, obj2);
                    return;
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
    }

    private static void onSetInstanceField(Object obj, String str, Object obj2) throws Throwable {
        if (!(obj instanceof List) && !obj.getClass().isArray()) {
            if (obj instanceof Map) {
                ((Map) obj).put(str, obj2);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                arrayList.add(cls);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Field field = null;
                try {
                    field = ((Class) it.next()).getDeclaredField(str);
                } catch (Throwable unused) {
                }
                if (field != null && !Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    field.set(obj, obj2);
                    return;
                }
            }
            throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
        }
        onSetElement(obj, str, obj2);
    }

    private static void onSetStaticField(String str, String str2, Object obj) throws Throwable {
        Field field;
        ArrayList arrayList = new ArrayList();
        for (Class<?> importedClass = getImportedClass(str); importedClass != null; importedClass = importedClass.getSuperclass()) {
            arrayList.add(importedClass);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                field = ((Class) it.next()).getDeclaredField(str2);
            } catch (Throwable unused) {
                field = null;
            }
            if (field != null && Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                field.set(null, obj);
                return;
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj));
    }

    private static boolean primitiveEquals(Class<?> cls, Class<?> cls2) {
        return (cls == Byte.TYPE && cls2 == Byte.class) || (cls == Short.TYPE && (cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Character.TYPE && (cls2 == Character.class || cls2 == Short.class || cls2 == Byte.class)) || ((cls == Integer.TYPE && (cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Long.TYPE && (cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Float.TYPE && (cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Double.TYPE && (cls2 == Double.class || cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || (cls == Boolean.TYPE && cls2 == Boolean.class))))));
    }

    public static void setInstanceField(Object obj, String str, Object obj2) throws Throwable {
        try {
            onSetInstanceField(obj, str, obj2);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2), th);
        }
    }

    public static void setStaticField(String str, String str2, Object obj) throws Throwable {
        try {
            onSetStaticField(str, str2, obj);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj), th);
        }
    }

    private static boolean tryMatchParams(Class<?>[] clsArr, Class<?>[] clsArr2) {
        boolean z;
        if (clsArr.length - clsArr2.length == 1) {
            int i2 = 0;
            while (true) {
                if (i2 >= clsArr2.length) {
                    z = true;
                    break;
                } else if (clsArr2[i2] != null && !primitiveEquals(clsArr[i2], clsArr2[i2]) && !clsArr[i2].isAssignableFrom(clsArr2[i2])) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            return z && clsArr[clsArr.length - 1].isArray();
        }
        return false;
    }

    public static synchronized String importClass(String str, String str2) throws Throwable {
        synchronized (ReflectHelper.class) {
            if (str2.endsWith(".*")) {
                packageSet.add(str2.substring(0, str2.length() - 2));
                return Marker.ANY_MARKER;
            }
            Class<?> cls = Class.forName(str2);
            if (str == null) {
                str = cls.getSimpleName();
            }
            if (classMap.containsKey(str)) {
                nameMap.remove(classMap.get(str));
            }
            classMap.put(str, cls);
            nameMap.put(cls, str);
            return str;
        }
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) throws Throwable {
        try {
            return (T) invokeMethod(null, obj, str, objArr);
        } catch (Throwable th) {
            if (!(th instanceof NoSuchMethodException)) {
                StringBuilder sb = new StringBuilder();
                sb.append("className: ");
                sb.append(obj != null ? obj.getClass() : null);
                sb.append(", methodName: ");
                sb.append(str);
                throw new Throwable(sb.toString(), th);
            }
            throw th;
        }
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object... objArr) throws Throwable {
        try {
            return (T) invokeMethod(str, null, str2, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", methodName: " + str2, th);
        }
    }

    public static Object createProxy(final Map<String, ReflectRunnable<Object[], Object>> map, Class<?>... clsArr) throws Throwable {
        if (clsArr.length == 0) {
            return null;
        }
        return Proxy.newProxyInstance(clsArr[0].getClassLoader(), clsArr, new InvocationHandler() { // from class: com.mob.tools.utils.ReflectHelper.2
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                ReflectRunnable reflectRunnable = (ReflectRunnable) map.get(method.getName());
                if (reflectRunnable != null) {
                    return reflectRunnable.run(objArr);
                }
                throw new NoSuchMethodException();
            }
        });
    }

    private static <T> T invokeMethod(String str, Object obj, String str2, Object... objArr) throws Throwable {
        Class<?> cls;
        Class<?>[] types;
        if (obj == null) {
            cls = getImportedClass(str);
        } else {
            cls = obj.getClass();
        }
        boolean z = false;
        if (str2.equals("getMethod") && objArr != null && objArr.length == 2) {
            types = new Class[]{String.class, Class[].class};
            if (objArr[1] == String.class) {
                Class[] clsArr = new Class[1];
                clsArr[0] = String.class;
                objArr[1] = clsArr;
            }
        } else if (str2.equals("getDeviceId") && objArr != null && objArr.length == 1) {
            types = new Class[]{Integer.TYPE};
        } else if (str2.equals("invoke") && objArr != null && objArr.length == 2) {
            types = new Class[]{Object.class, Object[].class};
        } else {
            types = (str2.equals("setAccessible") && objArr != null && objArr.length == 1) ? new Class[]{Boolean.TYPE} : getTypes(objArr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = types.length;
        for (int i2 = 0; i2 < length; i2++) {
            Class<?> cls2 = types[i2];
            stringBuffer.append(cls2 == null ? "" : cls2.getName());
        }
        String str3 = cls.getName() + "#" + str2 + "#" + objArr.length + stringBuffer.toString();
        Method method = cachedMethod.get(str3);
        if (method != null) {
            boolean isStatic = Modifier.isStatic(method.getModifiers());
            if (obj == null) {
                z = isStatic;
            } else if (!isStatic) {
                z = true;
            }
            if (z && matchParams(method.getParameterTypes(), types)) {
                method.setAccessible(true);
                if (method.getReturnType() == Void.TYPE) {
                    method.invoke(obj, objArr);
                    return null;
                }
                return (T) method.invoke(obj, objArr);
            }
        }
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str2, types);
                cachedMethod.put(str3, declaredMethod);
                declaredMethod.setAccessible(true);
                if (declaredMethod.getReturnType() == Void.TYPE) {
                    declaredMethod.invoke(obj, objArr);
                    return null;
                }
                return (T) declaredMethod.invoke(obj, objArr);
            } catch (Throwable unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("className: ");
        Class<?> cls3 = str;
        if (obj != null) {
            cls3 = obj.getClass();
        }
        sb.append((Object) cls3);
        sb.append(", methodName: ");
        sb.append(str2);
        throw new NoSuchMethodException(sb.toString());
    }
}
