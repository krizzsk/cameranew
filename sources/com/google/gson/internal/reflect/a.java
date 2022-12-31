package com.google.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;
/* compiled from: PreJava9ReflectionAccessor.java */
/* loaded from: classes2.dex */
final class a extends ReflectionAccessor {
    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void a(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}
