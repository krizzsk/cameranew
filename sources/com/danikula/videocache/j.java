package com.danikula.videocache;

import java.util.Objects;
/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class j {
    public static void a(Object... objArr) {
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T d(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T e(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }
}
