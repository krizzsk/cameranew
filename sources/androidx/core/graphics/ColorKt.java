package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
/* compiled from: Color.kt */
/* loaded from: classes.dex */
public final class ColorKt {
    @RequiresApi(26)
    public static final float component1(Color color) {
        s.h(color, "<this>");
        return color.getComponent(0);
    }

    public static final int component1(@ColorInt int i2) {
        return (i2 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(Color color) {
        s.h(color, "<this>");
        return color.getComponent(1);
    }

    public static final int component2(@ColorInt int i2) {
        return (i2 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(Color color) {
        s.h(color, "<this>");
        return color.getComponent(2);
    }

    public static final int component3(@ColorInt int i2) {
        return (i2 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(Color color) {
        s.h(color, "<this>");
        return color.getComponent(3);
    }

    public static final int component4(@ColorInt int i2) {
        return i2 & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i2, ColorSpace.Named colorSpace) {
        s.h(colorSpace, "colorSpace");
        return Color.convert(i2, ColorSpace.get(colorSpace));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j2) {
        return Color.alpha(j2);
    }

    public static final int getAlpha(@ColorInt int i2) {
        return (i2 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j2) {
        return Color.blue(j2);
    }

    public static final int getBlue(@ColorInt int i2) {
        return i2 & 255;
    }

    @RequiresApi(26)
    public static final ColorSpace getColorSpace(long j2) {
        ColorSpace colorSpace = Color.colorSpace(j2);
        s.g(colorSpace, "colorSpace(this)");
        return colorSpace;
    }

    @RequiresApi(26)
    public static final float getGreen(long j2) {
        return Color.green(j2);
    }

    public static final int getGreen(@ColorInt int i2) {
        return (i2 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i2) {
        return Color.luminance(i2);
    }

    @RequiresApi(26)
    public static final float getRed(long j2) {
        return Color.red(j2);
    }

    public static final int getRed(@ColorInt int i2) {
        return (i2 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j2) {
        return Color.isSrgb(j2);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j2) {
        return Color.isWideGamut(j2);
    }

    @RequiresApi(26)
    public static final Color plus(Color color, Color c) {
        s.h(color, "<this>");
        s.h(c, "c");
        Color compositeColors = ColorUtils.compositeColors(c, color);
        s.g(compositeColors, "compositeColors(c, this)");
        return compositeColors;
    }

    @RequiresApi(26)
    public static final Color toColor(@ColorInt int i2) {
        Color valueOf = Color.valueOf(i2);
        s.g(valueOf, "valueOf(this)");
        return valueOf;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j2) {
        return Color.toArgb(j2);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i2) {
        return Color.pack(i2);
    }

    @RequiresApi(26)
    public static final float component1(long j2) {
        return Color.red(j2);
    }

    @RequiresApi(26)
    public static final float component2(long j2) {
        return Color.green(j2);
    }

    @RequiresApi(26)
    public static final float component3(long j2) {
        return Color.blue(j2);
    }

    @RequiresApi(26)
    public static final float component4(long j2) {
        return Color.alpha(j2);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i2, ColorSpace colorSpace) {
        s.h(colorSpace, "colorSpace");
        return Color.convert(i2, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j2) {
        return Color.luminance(j2);
    }

    @RequiresApi(26)
    public static final Color toColor(long j2) {
        Color valueOf = Color.valueOf(j2);
        s.g(valueOf, "valueOf(this)");
        return valueOf;
    }

    @ColorInt
    public static final int toColorInt(String str) {
        s.h(str, "<this>");
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final long convertTo(long j2, ColorSpace.Named colorSpace) {
        s.h(colorSpace, "colorSpace");
        return Color.convert(j2, ColorSpace.get(colorSpace));
    }

    @RequiresApi(26)
    public static final long convertTo(long j2, ColorSpace colorSpace) {
        s.h(colorSpace, "colorSpace");
        return Color.convert(j2, colorSpace);
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace.Named colorSpace) {
        s.h(color, "<this>");
        s.h(colorSpace, "colorSpace");
        Color convert = color.convert(ColorSpace.get(colorSpace));
        s.g(convert, "convert(ColorSpace.get(colorSpace))");
        return convert;
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace colorSpace) {
        s.h(color, "<this>");
        s.h(colorSpace, "colorSpace");
        Color convert = color.convert(colorSpace);
        s.g(convert, "convert(colorSpace)");
        return convert;
    }
}
