package com.google.gson.internal.reflect;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes2.dex */
public abstract class ReflectionAccessor {
    private static final ReflectionAccessor a;

    static {
        a = d.c() < 9 ? new a() : new b();
    }

    public static ReflectionAccessor getInstance() {
        return a;
    }

    public abstract void a(AccessibleObject accessibleObject);
}
