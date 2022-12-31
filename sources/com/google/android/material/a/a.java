package com.google.android.material.a;

import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
/* compiled from: CanvasCompat.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {
    public static int a(@NonNull Canvas canvas, float f2, float f3, float f4, float f5, int i2) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(f2, f3, f4, f5, i2);
        }
        return canvas.saveLayerAlpha(f2, f3, f4, f5, i2, 31);
    }
}
