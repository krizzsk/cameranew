package com.hw.photomovie.util;

import android.graphics.Rect;
import android.graphics.RectF;
/* compiled from: PhotoUtil.java */
/* loaded from: classes2.dex */
public class c {
    public static Rect a(Rect rect, int i2, int i3, float f2, float f3) {
        if (rect == null) {
            rect = new Rect();
        }
        float f4 = f2 / f3;
        float f5 = i2;
        float f6 = i3;
        float f7 = f5 / f6;
        if (Math.abs(f4 - f7) < 0.01d) {
            rect.left = 0;
            rect.top = 0;
            rect.right = i2;
            rect.bottom = i3;
        } else if (f7 > f4) {
            float f8 = f3 / f6;
            int i4 = (int) ((((f5 * f8) - f2) / f8) / 2.0f);
            rect.left = i4;
            rect.top = 0;
            rect.right = i2 - i4;
            rect.bottom = i3;
        } else {
            float f9 = f2 / f5;
            rect.left = 0;
            int i5 = (int) ((((f6 * f9) - f3) / f9) / 2.0f);
            rect.top = i5;
            rect.right = i2;
            rect.bottom = i3 - i5;
        }
        return rect;
    }

    public static RectF b(RectF rectF, int i2, int i3, int i4, int i5) {
        if (rectF == null) {
            rectF = new RectF();
        }
        float f2 = i4 / i5;
        float f3 = i2 / i3;
        if (Math.abs(f2 - f3) < 0.01d) {
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = i4;
            rectF.bottom = i5;
        } else if (f3 > f2) {
            float f4 = i4;
            rectF.left = 0.0f;
            rectF.right = f4;
            int i6 = i5 / 2;
            int i7 = ((int) (f4 / f3)) / 2;
            rectF.top = i6 - i7;
            rectF.bottom = i6 + i7;
        } else {
            float f5 = i5;
            int i8 = i4 / 2;
            int i9 = ((int) (f3 * f5)) / 2;
            rectF.left = i8 - i9;
            rectF.right = i8 + i9;
            rectF.top = 0.0f;
            rectF.bottom = f5;
        }
        return rectF;
    }
}
