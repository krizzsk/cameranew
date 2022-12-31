package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
@com.facebook.common.internal.d
/* loaded from: classes.dex */
public class NativeBlurFilter {
    static {
        b.a();
    }

    @com.facebook.common.internal.d
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i2, int i3);
}
