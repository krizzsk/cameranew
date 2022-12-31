package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.lang.reflect.Method;
/* renamed from: com.facebook.ads.redexgen.X.5o  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06135o {
    @Nullable
    public static Object A00(@Nullable Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static Method A01(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Nullable
    public static Method A02(String str, String str2, Class<?>... clsArr) {
        try {
            Class<?> clazz = Class.forName(str);
            return A01(clazz, str2, clsArr);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
