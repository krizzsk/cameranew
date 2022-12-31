package com.facebook.imagepipeline.cache;

import java.util.concurrent.TimeUnit;
/* compiled from: DefaultEncodedMemoryCacheParamsSupplier.java */
/* loaded from: classes.dex */
public class k implements com.facebook.common.internal.k<s> {
    private static final long a = TimeUnit.MINUTES.toMillis(5);

    private int b() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return 1048576;
        }
        return min < 33554432 ? 2097152 : 4194304;
    }

    @Override // com.facebook.common.internal.k
    /* renamed from: a */
    public s get() {
        int b = b();
        return new s(b, Integer.MAX_VALUE, b, Integer.MAX_VALUE, b / 8, a);
    }
}
