package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class LottieCompositionCache {
    private static final LottieCompositionCache b = new LottieCompositionCache();
    private final LruCache<String, com.airbnb.lottie.e> a = new LruCache<>(20);

    @VisibleForTesting
    LottieCompositionCache() {
    }

    public static LottieCompositionCache getInstance() {
        return b;
    }

    @Nullable
    public com.airbnb.lottie.e a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.a.get(str);
    }

    public void b(@Nullable String str, com.airbnb.lottie.e eVar) {
        if (str == null) {
            return;
        }
        this.a.put(str, eVar);
    }
}
