package us.pinguo.foundation.utils;

import android.graphics.Color;
/* compiled from: ColorUtil.java */
/* loaded from: classes4.dex */
public class l {
    public static int a(float f2, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) ((((i3 >> 24) & 255) - i4) * f2))) << 24) | ((i5 + ((int) ((((i3 >> 16) & 255) - i5) * f2))) << 16) | ((i6 + ((int) ((((i3 >> 8) & 255) - i6) * f2))) << 8) | (i7 + ((int) (f2 * ((i3 & 255) - i7))));
    }

    public static int b(int i2, int i3, float f2) {
        int alpha = Color.alpha(i2);
        int red = Color.red(i2);
        int green = Color.green(i2);
        int blue = Color.blue(i2);
        return Color.argb((int) (alpha + ((Color.alpha(i3) - alpha) * f2)), (int) (red + ((Color.red(i3) - red) * f2)), (int) (green + ((Color.green(i3) - green) * f2)), (int) (blue + ((Color.blue(i3) - blue) * f2)));
    }

    public static boolean c(int i2) {
        return 1000 - ((((Color.red(i2) * 299) + (Color.green(i2) * 587)) + (Color.blue(i2) * 114)) / 255) < 500;
    }
}
