package us.pinguo.widget.discreteseekbar.internal.a;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
/* compiled from: SeekBarCompat.java */
/* loaded from: classes6.dex */
public class c {
    public static Drawable a(ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            return d.a(colorStateList);
        }
        return new us.pinguo.widget.discreteseekbar.internal.b.a(colorStateList);
    }

    public static boolean b(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            return d.b(view);
        }
        return false;
    }

    public static boolean c(ViewParent viewParent) {
        if (Build.VERSION.SDK_INT >= 14) {
            return d.c(viewParent);
        }
        return false;
    }

    public static void d(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            d.d(view, drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void e(Drawable drawable, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 21) {
            int i6 = (i4 - i2) / 8;
            DrawableCompat.setHotspotBounds(drawable, i2 + i6, i3 + i6, i4 - i6, i5 - i6);
            return;
        }
        drawable.setBounds(i2, i3, i4, i5);
    }

    public static void f(View view, us.pinguo.widget.discreteseekbar.internal.b.b bVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.e(view, bVar);
        }
    }

    public static void g(@NonNull Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            ((RippleDrawable) drawable).setColor(colorStateList);
        } else {
            ((us.pinguo.widget.discreteseekbar.internal.b.a) drawable).p(colorStateList);
        }
    }

    public static void h(TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            d.f(textView, i2);
        }
    }
}
