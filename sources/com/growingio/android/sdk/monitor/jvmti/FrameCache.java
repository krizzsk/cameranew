package com.growingio.android.sdk.monitor.jvmti;

import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public final class FrameCache {
    private static Set<String> appPackages = new HashSet();
    private static ThreadLocal<WeakHashMap<Throwable, Frame[]>> cache = new ThreadLocal<WeakHashMap<Throwable, Frame[]>>() { // from class: com.growingio.android.sdk.monitor.jvmti.FrameCache.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public WeakHashMap<Throwable, Frame[]> initialValue() {
            return new WeakHashMap<>();
        }
    };

    private FrameCache() {
    }

    public static void add(Throwable th, Frame[] frameArr) {
        cache.get().put(th, frameArr);
    }

    public static void addAppPackage(String str) {
        appPackages.add(str);
    }

    public static Frame[] get(Throwable th) {
        return cache.get().get(th);
    }

    public static boolean shouldCacheThrowable(Throwable th, int i2) {
        StackTraceElement[] stackTrace;
        if (appPackages.isEmpty()) {
            return false;
        }
        Frame[] frameArr = cache.get().get(th);
        if (frameArr == null || i2 > frameArr.length) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                for (String str : appPackages) {
                    if (stackTraceElement.getClassName().startsWith(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
