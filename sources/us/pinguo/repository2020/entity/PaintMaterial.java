package us.pinguo.repository2020.entity;

import java.util.Objects;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Material.kt */
/* loaded from: classes6.dex */
public class PaintMaterial extends Material implements NoProguard {
    private boolean applied;
    private Integer autoAdjustPaintInterval;
    private Integer brushBlendMode;
    private String brushColor;
    private Float brushDefaultEffectIntensity;
    private Float brushDisplaySizeRatio;
    private Float brushEffectIntensity;
    private Integer brushSizeCalculateMode;
    private Float brushSizeRatio;
    private Integer brushSourceType;
    private Integer enableFlow;
    private Integer enableRandomSpriteIndex;
    private Integer enableRotate;
    private Float paintIntervalRatio;
    private Integer[] resourceChildBlendMode;
    private String[] resourceChildPath;
    private String resourceFolderPath;
    private Integer supportChangeColor;

    public /* synthetic */ PaintMaterial(String str, String str2, String str3, Long l2, Long l3, Integer num, String str4, int i2, o oVar) {
        this(str, str2, str3, l2, l3, (i2 & 32) != 0 ? 0 : num, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(getClass(), obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.entity.PaintMaterial");
            return s.c(((PaintMaterial) obj).getPid(), getPid());
        }
        return false;
    }

    public final boolean getApplied() {
        return this.applied;
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

    public final String getResourceFolderPath() {
        return this.resourceFolderPath;
    }

    public final Integer getSupportChangeColor() {
        return this.supportChangeColor;
    }

    public final void setApplied(boolean z) {
        this.applied = z;
    }

    public final void setAutoAdjustPaintInterval(Integer num) {
        this.autoAdjustPaintInterval = num;
    }

    public final void setBrushBlendMode(Integer num) {
        this.brushBlendMode = num;
    }

    public final void setBrushColor(String str) {
        this.brushColor = str;
    }

    public final void setBrushDefaultEffectIntensity(Float f2) {
        this.brushDefaultEffectIntensity = f2;
    }

    public final void setBrushDisplaySizeRatio(Float f2) {
        this.brushDisplaySizeRatio = f2;
    }

    public final void setBrushEffectIntensity(Float f2) {
        this.brushEffectIntensity = f2;
    }

    public final void setBrushSizeCalculateMode(Integer num) {
        this.brushSizeCalculateMode = num;
    }

    public final void setBrushSizeRatio(Float f2) {
        this.brushSizeRatio = f2;
    }

    public final void setBrushSourceType(Integer num) {
        this.brushSourceType = num;
    }

    public final void setEnableFlow(Integer num) {
        this.enableFlow = num;
    }

    public final void setEnableRandomSpriteIndex(Integer num) {
        this.enableRandomSpriteIndex = num;
    }

    public final void setEnableRotate(Integer num) {
        this.enableRotate = num;
    }

    public final void setPaintIntervalRatio(Float f2) {
        this.paintIntervalRatio = f2;
    }

    public final void setResourceChildBlendMode(Integer[] numArr) {
        this.resourceChildBlendMode = numArr;
    }

    public final void setResourceChildPath(String[] strArr) {
        this.resourceChildPath = strArr;
    }

    public final void setResourceFolderPath(String str) {
        this.resourceFolderPath = str;
    }

    public final void setSupportChangeColor(Integer num) {
        this.supportChangeColor = num;
    }

    public PaintMaterial(String str, String str2, String str3, Long l2, Long l3, Integer num, String str4) {
        super(str, str2, str3, str4, l2, l3, num);
    }
}
