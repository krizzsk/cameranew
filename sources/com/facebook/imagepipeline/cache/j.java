package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import android.os.Build;
import java.util.concurrent.TimeUnit;
/* compiled from: DefaultBitmapMemoryCacheParamsSupplier.java */
/* loaded from: classes.dex */
public class j implements com.facebook.common.internal.k<s> {
    private static final long b = TimeUnit.MINUTES.toMillis(5);
    private final ActivityManager a;

    public j(ActivityManager activityManager) {
        this.a = activityManager;
    }

    private int b() {
        int min = Math.min(this.a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (min < 33554432) {
            return 4194304;
        }
        if (min < 67108864) {
            return 6291456;
        }
        if (Build.VERSION.SDK_INT < 11) {
            return 8388608;
        }
        return min / 4;
    }

    @Override // com.facebook.common.internal.k
    /* renamed from: a */
    public s get() {
        return new s(b(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, b);
    }
}
