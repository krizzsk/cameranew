package us.pinguo.repository2020.database.background;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StrokeDetail.kt */
/* loaded from: classes6.dex */
public final class StrokeDetail implements NoProguard {
    private final String sketchColor;
    private final float sketchCutoutMarginGap;
    private final int sketchSizeAdjustType;
    private final float sketchThickness;
    private final float smooth;
    private final float strokeOffsetX;
    private final float strokeOffsetY;
    private final int strokeType;
    private final int supportedAutoGradientColor;
    private final int supportedColorChange;

    public StrokeDetail(int i2, String sketchColor, int i3, float f2, float f3, float f4, float f5, float f6, int i4, int i5) {
        s.h(sketchColor, "sketchColor");
        this.strokeType = i2;
        this.sketchColor = sketchColor;
        this.sketchSizeAdjustType = i3;
        this.sketchThickness = f2;
        this.sketchCutoutMarginGap = f3;
        this.smooth = f4;
        this.strokeOffsetX = f5;
        this.strokeOffsetY = f6;
        this.supportedColorChange = i4;
        this.supportedAutoGradientColor = i5;
    }

    public final int component1() {
        return this.strokeType;
    }

    public final int component10() {
        return this.supportedAutoGradientColor;
    }

    public final String component2() {
        return this.sketchColor;
    }

    public final int component3() {
        return this.sketchSizeAdjustType;
    }

    public final float component4() {
        return this.sketchThickness;
    }

    public final float component5() {
        return this.sketchCutoutMarginGap;
    }

    public final float component6() {
        return this.smooth;
    }

    public final float component7() {
        return this.strokeOffsetX;
    }

    public final float component8() {
        return this.strokeOffsetY;
    }

    public final int component9() {
        return this.supportedColorChange;
    }

    public final StrokeDetail copy(int i2, String sketchColor, int i3, float f2, float f3, float f4, float f5, float f6, int i4, int i5) {
        s.h(sketchColor, "sketchColor");
        return new StrokeDetail(i2, sketchColor, i3, f2, f3, f4, f5, f6, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StrokeDetail) {
            StrokeDetail strokeDetail = (StrokeDetail) obj;
            return this.strokeType == strokeDetail.strokeType && s.c(this.sketchColor, strokeDetail.sketchColor) && this.sketchSizeAdjustType == strokeDetail.sketchSizeAdjustType && s.c(Float.valueOf(this.sketchThickness), Float.valueOf(strokeDetail.sketchThickness)) && s.c(Float.valueOf(this.sketchCutoutMarginGap), Float.valueOf(strokeDetail.sketchCutoutMarginGap)) && s.c(Float.valueOf(this.smooth), Float.valueOf(strokeDetail.smooth)) && s.c(Float.valueOf(this.strokeOffsetX), Float.valueOf(strokeDetail.strokeOffsetX)) && s.c(Float.valueOf(this.strokeOffsetY), Float.valueOf(strokeDetail.strokeOffsetY)) && this.supportedColorChange == strokeDetail.supportedColorChange && this.supportedAutoGradientColor == strokeDetail.supportedAutoGradientColor;
        }
        return false;
    }

    public final String getSketchColor() {
        return this.sketchColor;
    }

    public final float getSketchCutoutMarginGap() {
        return this.sketchCutoutMarginGap;
    }

    public final int getSketchSizeAdjustType() {
        return this.sketchSizeAdjustType;
    }

    public final float getSketchThickness() {
        return this.sketchThickness;
    }

    public final float getSmooth() {
        return this.smooth;
    }

    public final float getStrokeOffsetX() {
        return this.strokeOffsetX;
    }

    public final float getStrokeOffsetY() {
        return this.strokeOffsetY;
    }

    public final int getStrokeType() {
        return this.strokeType;
    }

    public final int getSupportedAutoGradientColor() {
        return this.supportedAutoGradientColor;
    }

    public final int getSupportedColorChange() {
        return this.supportedColorChange;
    }

    public int hashCode() {
        return (((((((((((((((((this.strokeType * 31) + this.sketchColor.hashCode()) * 31) + this.sketchSizeAdjustType) * 31) + Float.floatToIntBits(this.sketchThickness)) * 31) + Float.floatToIntBits(this.sketchCutoutMarginGap)) * 31) + Float.floatToIntBits(this.smooth)) * 31) + Float.floatToIntBits(this.strokeOffsetX)) * 31) + Float.floatToIntBits(this.strokeOffsetY)) * 31) + this.supportedColorChange) * 31) + this.supportedAutoGradientColor;
    }

    public String toString() {
        return "StrokeDetail(strokeType=" + this.strokeType + ", sketchColor=" + this.sketchColor + ", sketchSizeAdjustType=" + this.sketchSizeAdjustType + ", sketchThickness=" + this.sketchThickness + ", sketchCutoutMarginGap=" + this.sketchCutoutMarginGap + ", smooth=" + this.smooth + ", strokeOffsetX=" + this.strokeOffsetX + ", strokeOffsetY=" + this.strokeOffsetY + ", supportedColorChange=" + this.supportedColorChange + ", supportedAutoGradientColor=" + this.supportedAutoGradientColor + ')';
    }
}
