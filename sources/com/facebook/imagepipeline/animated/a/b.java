package com.facebook.imagepipeline.animated.a;

import com.facebook.imagepipeline.bitmaps.f;
import com.facebook.imagepipeline.cache.i;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
/* compiled from: AnimatedFactoryProvider.java */
/* loaded from: classes.dex */
public class b {
    private static boolean a;
    @Nullable
    private static a b;

    @Nullable
    public static a a(f fVar, com.facebook.imagepipeline.core.f fVar2, i<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> iVar, boolean z, @Nullable ExecutorService executorService) {
        if (!a) {
            try {
                b = (a) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(f.class, com.facebook.imagepipeline.core.f.class, i.class, Boolean.TYPE, com.facebook.common.executors.e.class).newInstance(fVar, fVar2, iVar, Boolean.valueOf(z), executorService);
            } catch (Throwable unused) {
            }
            if (b != null) {
                a = true;
            }
        }
        return b;
    }
}
