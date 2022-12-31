package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* compiled from: UnsafeAllocator.java */
/* loaded from: classes2.dex */
public abstract class j {

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes2.dex */
    class a extends j {
        final /* synthetic */ Method a;
        final /* synthetic */ Object b;

        a(Method method, Object obj) {
            this.a = method;
            this.b = obj;
        }

        @Override // com.google.gson.internal.j
        public <T> T c(Class<T> cls) throws Exception {
            j.a(cls);
            return (T) this.a.invoke(this.b, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes2.dex */
    class b extends j {
        final /* synthetic */ Method a;
        final /* synthetic */ int b;

        b(Method method, int i2) {
            this.a = method;
            this.b = i2;
        }

        @Override // com.google.gson.internal.j
        public <T> T c(Class<T> cls) throws Exception {
            j.a(cls);
            return (T) this.a.invoke(null, cls, Integer.valueOf(this.b));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes2.dex */
    class c extends j {
        final /* synthetic */ Method a;

        c(Method method) {
            this.a = method;
        }

        @Override // com.google.gson.internal.j
        public <T> T c(Class<T> cls) throws Exception {
            j.a(cls);
            return (T) this.a.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes2.dex */
    class d extends j {
        d() {
        }

        @Override // com.google.gson.internal.j
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers)) {
            if (Modifier.isAbstract(modifiers)) {
                throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
            }
            return;
        }
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
    }

    public static j b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    return new d();
                }
            } catch (Exception unused3) {
                Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new c(declaredMethod3);
            }
        }
    }

    public abstract <T> T c(Class<T> cls) throws Exception;
}
