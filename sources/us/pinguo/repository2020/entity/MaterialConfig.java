package us.pinguo.repository2020.entity;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: MaterialConfig.kt */
/* loaded from: classes6.dex */
public final class MaterialConfig {
    private final Integer autoAdjustPaintInterval;
    private final Integer brushBlendMode;
    private final String brushColor;
    private final Float brushDefaultEffectIntensity;
    private final Float brushDisplaySizeRatio;
    private final Float brushEffectIntensity;
    private final Integer brushSizeCalculateMode;
    private final Float brushSizeRatio;
    private final Integer brushSourceType;
    private final Integer enableFlow;
    private final Integer enableRandomSpriteIndex;
    private final Integer enableRotate;
    private final Float paintIntervalRatio;
    private final Integer[] resourceChildBlendMode;
    private final String[] resourceChildPath;
    private final Integer supportChangeColor;

    public MaterialConfig(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f2, Float f3, Float f4, Float f5, Float f6, String str, Integer num6, Integer num7, Integer num8, Integer[] numArr, String[] strArr) {
        this.autoAdjustPaintInterval = num;
        this.brushSizeCalculateMode = num2;
        this.brushSourceType = num3;
        this.enableRandomSpriteIndex = num4;
        this.enableRotate = num5;
        this.paintIntervalRatio = f2;
        this.brushSizeRatio = f3;
        this.brushEffectIntensity = f4;
        this.brushDefaultEffectIntensity = f5;
        this.brushDisplaySizeRatio = f6;
        this.brushColor = str;
        this.enableFlow = num6;
        this.supportChangeColor = num7;
        this.brushBlendMode = num8;
        this.resourceChildBlendMode = numArr;
        this.resourceChildPath = strArr;
    }

    public final Integer component1() {
        return this.autoAdjustPaintInterval;
    }

    public final Float component10() {
        return this.brushDisplaySizeRatio;
    }

    public final String component11() {
        return this.brushColor;
    }

    public final Integer component12() {
        return this.enableFlow;
    }

    public final Integer component13() {
        return this.supportChangeColor;
    }

    public final Integer component14() {
        return this.brushBlendMode;
    }

    public final Integer[] component15() {
        return this.resourceChildBlendMode;
    }

    public final String[] component16() {
        return this.resourceChildPath;
    }

    public final Integer component2() {
        return this.brushSizeCalculateMode;
    }

    public final Integer component3() {
        return this.brushSourceType;
    }

    public final Integer component4() {
        return this.enableRandomSpriteIndex;
    }

    public final Integer component5() {
        return this.enableRotate;
    }

    public final Float component6() {
        return this.paintIntervalRatio;
    }

    public final Float component7() {
        return this.brushSizeRatio;
    }

    public final Float component8() {
        return this.brushEffectIntensity;
    }

    public final Float component9() {
        return this.brushDefaultEffectIntensity;
    }

    public final MaterialConfig copy(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f2, Float f3, Float f4, Float f5, Float f6, String str, Integer num6, Integer num7, Integer num8, Integer[] numArr, String[] strArr) {
        return new MaterialConfig(num, num2, num3, num4, num5, f2, f3, f4, f5, f6, str, num6, num7, num8, numArr, strArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MaterialConfig) {
            MaterialConfig materialConfig = (MaterialConfig) obj;
            return s.c(this.autoAdjustPaintInterval, materialConfig.autoAdjustPaintInterval) && s.c(this.brushSizeCalculateMode, materialConfig.brushSizeCalculateMode) && s.c(this.brushSourceType, materialConfig.brushSourceType) && s.c(this.enableRandomSpriteIndex, materialConfig.enableRandomSpriteIndex) && s.c(this.enableRotate, materialConfig.enableRotate) && s.c(this.paintIntervalRatio, materialConfig.paintIntervalRatio) && s.c(this.brushSizeRatio, materialConfig.brushSizeRatio) && s.c(this.brushEffectIntensity, materialConfig.brushEffectIntensity) && s.c(this.brushDefaultEffectIntensity, materialConfig.brushDefaultEffectIntensity) && s.c(this.brushDisplaySizeRatio, materialConfig.brushDisplaySizeRatio) && s.c(this.brushColor, materialConfig.brushColor) && s.c(this.enableFlow, materialConfig.enableFlow) && s.c(this.supportChangeColor, materialConfig.supportChangeColor) && s.c(this.brushBlendMode, materialConfig.brushBlendMode) && s.c(this.resourceChildBlendMode, materialConfig.resourceChildBlendMode) && s.c(this.resourceChildPath, materialConfig.resourceChildPath);
        }
        return false;
    }

    public final Integer getAutoAdjustPaintInterval() {
        return this.autoAdjustPaintInterval;
    }

    public final Integer getBrushBlendMode() {
        return this.brushBlendMode;
    }

    public final String getBrushColor() {
        return this.brushColor;
    }

    public final Float getBrushDefaultEffectIntensity() {
        return this.brushDefaultEffectIntensity;
    }

    public final Float getBrushDisplaySizeRatio() {
        return this.brushDisplaySizeRatio;
    }

    public final Float getBrushEffectIntensity() {
        return this.brushEffectIntensity;
    }

    public final Integer getBrushSizeCalculateMode() {
        return this.brushSizeCalculateMode;
    }

    public final Float getBrushSizeRatio() {
        return this.brushSizeRatio;
    }

    public final Integer getBrushSourceType() {
        return this.brushSourceType;
    }

    public final Integer getEnableFlow() {
        return this.enableFlow;
    }

    public final Integer getEnableRandomSpriteIndex() {
        return this.enableRandomSpriteIndex;
    }

    public final Integer getEnableRotate() {
        return this.enableRotate;
    }

    public final Float getPaintIntervalRatio() {
        return this.paintIntervalRatio;
    }

    public final Integer[] getResourceChildBlendMode() {
        return this.resourceChildBlendMode;
    }

    public final String[] getResourceChildPath() {
        return this.resourceChildPath;
    }

    public final Integer getSupportChangeColor() {
        return this.supportChangeColor;
    }

    public int hashCode() {
        Integer num = this.autoAdjustPaintInterval;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.brushSizeCalculateMode;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.brushSourceType;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.enableRandomSpriteIndex;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.enableRotate;
        int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Float f2 = this.paintIntervalRatio;
        int hashCode6 = (hashCode5 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.brushSizeRatio;
        int hashCode7 = (hashCode6 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.brushEffectIntensity;
        int hashCode8 = (hashCode7 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.brushDefaultEffectIntensity;
        int hashCode9 = (hashCode8 + (f5 == null ? 0 : f5.hashCode())) * 31;
        Float f6 = this.brushDisplaySizeRatio;
        int hashCode10 = (hashCode9 + (f6 == null ? 0 : f6.hashCode())) * 31;
        String str = this.brushColor;
        int hashCode11 = (hashCode10 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num6 = this.enableFlow;
        int hashCode12 = (hashCode11 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.supportChangeColor;
        int hashCode13 = (hashCode12 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.brushBlendMode;
        int hashCode14 = (hashCode13 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer[] numArr = this.resourceChildBlendMode;
        int hashCode15 = (hashCode14 + (numArr == null ? 0 : Arrays.hashCode(numArr))) * 31;
        String[] strArr = this.resourceChildPath;
        return hashCode15 + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    public String toString() {
        return "MaterialConfig(autoAdjustPaintInterval=" + this.autoAdjustPaintInterval + ", brushSizeCalculateMode=" + this.brushSizeCalculateMode + ", brushSourceType=" + this.brushSourceType + ", enableRandomSpriteIndex=" + this.enableRandomSpriteIndex + ", enableRotate=" + this.enableRotate + ", paintIntervalRatio=" + this.paintIntervalRatio + ", brushSizeRatio=" + this.brushSizeRatio + ", brushEffectIntensity=" + this.brushEffectIntensity + ", brushDefaultEffectIntensity=" + this.brushDefaultEffectIntensity + ", brushDisplaySizeRatio=" + this.brushDisplaySizeRatio + ", brushColor=" + ((Object) this.brushColor) + ", enableFlow=" + this.enableFlow + ", supportChangeColor=" + this.supportChangeColor + ", brushBlendMode=" + this.brushBlendMode + ", resourceChildBlendMode=" + Arrays.toString(this.resourceChildBlendMode) + ", resourceChildPath=" + Arrays.toString(this.resourceChildPath) + ')';
    }

    public /* synthetic */ MaterialConfig(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f2, Float f3, Float f4, Float f5, Float f6, String str, Integer num6, Integer num7, Integer num8, Integer[] numArr, String[] strArr, int i2, o oVar) {
        this((i2 & 1) != 0 ? 0 : num, (i2 & 2) != 0 ? 0 : num2, (i2 & 4) != 0 ? 0 : num3, (i2 & 8) != 0 ? 0 : num4, (i2 & 16) != 0 ? 0 : num5, (i2 & 32) != 0 ? Float.valueOf(0.0f) : f2, (i2 & 64) != 0 ? Float.valueOf(0.0f) : f3, (i2 & 128) != 0 ? Float.valueOf(0.0f) : f4, (i2 & 256) != 0 ? Float.valueOf(0.0f) : f5, (i2 & 512) != 0 ? Float.valueOf(0.0f) : f6, (i2 & 1024) != 0 ? "" : str, (i2 & 2048) != 0 ? 0 : num6, (i2 & 4096) != 0 ? 0 : num7, (i2 & 8192) != 0 ? 0 : num8, (i2 & 16384) != 0 ? null : numArr, strArr);
    }
}
