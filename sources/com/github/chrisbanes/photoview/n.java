package com.github.chrisbanes.photoview;

import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
/* compiled from: Util.java */
/* loaded from: classes9.dex */
class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i2) {
        return (i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImageView.ScaleType c(int i2) {
        ImageView.ScaleType[] values = ImageView.ScaleType.values();
        if (i2 < 0 || i2 >= values.length) {
            return null;
        }
        return values[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(int i2) {
        if (i2 != ImageView.ScaleType.MATRIX.ordinal()) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
