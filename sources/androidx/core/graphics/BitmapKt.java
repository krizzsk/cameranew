package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Bitmap.kt */
/* loaded from: classes.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, l<? super Canvas, u> block) {
        s.h(bitmap, "<this>");
        s.h(block, "block");
        block.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(Bitmap bitmap, Point p) {
        int i2;
        s.h(bitmap, "<this>");
        s.h(p, "p");
        int i3 = p.x;
        return i3 >= 0 && i3 < bitmap.getWidth() && (i2 = p.y) >= 0 && i2 < bitmap.getHeight();
    }

    public static final Bitmap createBitmap(int i2, int i3, Bitmap.Config config) {
        s.h(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
        s.g(createBitmap, "createBitmap(width, height, config)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        s.h(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
        s.g(createBitmap, "createBitmap(width, height, config)");
        return createBitmap;
    }

    public static final int get(Bitmap bitmap, int i2, int i3) {
        s.h(bitmap, "<this>");
        return bitmap.getPixel(i2, i3);
    }

    public static final Bitmap scale(Bitmap bitmap, int i2, int i3, boolean z) {
        s.h(bitmap, "<this>");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
        s.g(createScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return createScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = true;
        }
        s.h(bitmap, "<this>");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
        s.g(createScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return createScaledBitmap;
    }

    public static final void set(Bitmap bitmap, int i2, int i3, @ColorInt int i4) {
        s.h(bitmap, "<this>");
        bitmap.setPixel(i2, i3, i4);
    }

    public static final boolean contains(Bitmap bitmap, PointF p) {
        s.h(bitmap, "<this>");
        s.h(p, "p");
        float f2 = p.x;
        if (f2 >= 0.0f && f2 < bitmap.getWidth()) {
            float f3 = p.y;
            if (f3 >= 0.0f && f3 < bitmap.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(26)
    public static final Bitmap createBitmap(int i2, int i3, Bitmap.Config config, boolean z, ColorSpace colorSpace) {
        s.h(config, "config");
        s.h(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
        s.g(createBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        if ((i4 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            s.g(colorSpace, "get(ColorSpace.Named.SRGB)");
        }
        s.h(config, "config");
        s.h(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
        s.g(createBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }
}
