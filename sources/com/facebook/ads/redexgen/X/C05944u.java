package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.lang.reflect.Proxy;
/* renamed from: com.facebook.ads.redexgen.X.4u  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05944u {
    @SuppressLint({"CatchGeneralException"})
    public static <T> T A00(T t, Class<T> cls) {
        ClassLoader classLoader = t.getClass().getClassLoader();
        return cls.cast(Proxy.newProxyInstance(classLoader, new Class[]{cls}, new C05934t(t, classLoader)));
    }
}
