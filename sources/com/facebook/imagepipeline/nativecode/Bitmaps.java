package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.h;
@com.facebook.common.internal.d
/* loaded from: classes.dex */
public class Bitmaps {
    static {
        a.a();
    }

    @com.facebook.common.internal.d
    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        h.b(Boolean.valueOf(bitmap2.getConfig() == bitmap.getConfig()));
        h.b(Boolean.valueOf(bitmap.isMutable()));
        h.b(Boolean.valueOf(bitmap.getWidth() == bitmap2.getWidth()));
        h.b(Boolean.valueOf(bitmap.getHeight() == bitmap2.getHeight()));
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @com.facebook.common.internal.d
    private static native void nativeCopyBitmap(Bitmap bitmap, int i2, Bitmap bitmap2, int i3, int i4);
}
