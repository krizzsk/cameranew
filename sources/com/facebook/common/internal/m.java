package com.facebook.common.internal;

import javax.annotation.Nullable;
/* compiled from: Throwables.java */
/* loaded from: classes.dex */
public final class m {
    public static RuntimeException a(Throwable th) {
        h.g(th);
        c(th);
        throw new RuntimeException(th);
    }

    public static <X extends Throwable> void b(@Nullable Throwable th, Class<X> cls) throws Throwable {
        if (th != null && cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void c(@Nullable Throwable th) {
        b(th, Error.class);
        b(th, RuntimeException.class);
    }
}
