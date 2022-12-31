package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* compiled from: UnsafeReflectionAccessor.java */
/* loaded from: classes2.dex */
final class b extends ReflectionAccessor {

    /* renamed from: d  reason: collision with root package name */
    private static Class f4967d;
    private final Object b = c();
    private final Field c = b();

    private static Field b() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Object c() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f4967d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void a(AccessibleObject accessibleObject) {
        if (d(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e2) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
        }
    }

    boolean d(AccessibleObject accessibleObject) {
        if (this.b != null && this.c != null) {
            try {
                f4967d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.b, accessibleObject, Long.valueOf(((Long) f4967d.getMethod("objectFieldOffset", Field.class).invoke(this.b, this.c)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
