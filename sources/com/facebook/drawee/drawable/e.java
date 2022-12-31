package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;
import javax.annotation.Nullable;
/* compiled from: DrawableUtils.java */
/* loaded from: classes.dex */
public class e {
    public static void a(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        if (drawable2 == null || drawable == null || drawable == drawable2) {
            return;
        }
        drawable.setBounds(drawable2.getBounds());
        drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
        drawable.setLevel(drawable2.getLevel());
        drawable.setVisible(drawable2.isVisible(), false);
        drawable.setState(drawable2.getState());
    }

    public static int b(int i2) {
        int i3 = i2 >>> 24;
        if (i3 == 255) {
            return -1;
        }
        return i3 == 0 ? -2 : -3;
    }

    public static int c(int i2, int i3) {
        if (i3 == 255) {
            return i2;
        }
        if (i3 == 0) {
            return i2 & ViewCompat.MEASURED_SIZE_MASK;
        }
        int i4 = i3 + (i3 >> 7);
        return (i2 & ViewCompat.MEASURED_SIZE_MASK) | ((((i2 >>> 24) * i4) >> 8) << 24);
    }

    public static void d(@Nullable Drawable drawable, @Nullable Drawable.Callback callback, @Nullable r rVar) {
        if (drawable != null) {
            drawable.setCallback(callback);
            if (drawable instanceof q) {
                ((q) drawable).h(rVar);
            }
        }
    }

    public static void e(@Nullable Drawable drawable, @Nullable d dVar) {
        if (drawable == null || dVar == null) {
            return;
        }
        dVar.a(drawable);
    }
}
