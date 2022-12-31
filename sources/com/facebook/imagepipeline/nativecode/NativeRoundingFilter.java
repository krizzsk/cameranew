package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.h;
@com.facebook.common.internal.d
/* loaded from: classes.dex */
public class NativeRoundingFilter {
    static {
        b.a();
    }

    @com.facebook.common.internal.d
    private static native void nativeAddRoundedCornersFilter(Bitmap bitmap, int i2, int i3, int i4, int i5);

    @com.facebook.common.internal.d
    private static native void nativeToCircleFastFilter(Bitmap bitmap, boolean z);

    @com.facebook.common.internal.d
    private static native void nativeToCircleFilter(Bitmap bitmap, boolean z);

    @com.facebook.common.internal.d
    private static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i2, int i3, boolean z);

    @com.facebook.common.internal.d
    public static void toCircle(Bitmap bitmap, boolean z) {
        h.g(bitmap);
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFilter(bitmap, z);
    }

    @com.facebook.common.internal.d
    public static void toCircleFast(Bitmap bitmap, boolean z) {
        h.g(bitmap);
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFastFilter(bitmap, z);
    }
}
