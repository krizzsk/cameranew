package com.facebook.imagepipeline.bitmaps;

import android.os.Build;
import com.facebook.imagepipeline.memory.b0;
/* compiled from: PlatformBitmapFactoryProvider.java */
/* loaded from: classes.dex */
public class g {
    public static f a(b0 b0Var, com.facebook.imagepipeline.platform.d dVar, com.facebook.imagepipeline.core.a aVar) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            return new a(b0Var.b(), aVar);
        }
        if (i2 >= 11) {
            return new e(new b(b0Var.h()), dVar, aVar);
        }
        return new c();
    }
}
