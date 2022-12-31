package us.pinguo.repository2020.database.paint;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: PaintMaterialTables.kt */
@Entity(tableName = "paint_material")
/* loaded from: classes6.dex */
public final class PaintMaterialTable implements NoProguard {
    @ColumnInfo
    private Integer autoAdjustPaintInterval;
    @ColumnInfo
    private Integer brushBlendMode;
    @ColumnInfo
    private String brushColor;
    @ColumnInfo
    private Float brushDefaultEffectIntensity;
    @ColumnInfo
    private Float brushDisplaySizeRatio;
    @ColumnInfo
    private Float brushEffectIntensity;
    @ColumnInfo
    private Integer brushSizeCalculateMode;
    @ColumnInfo
    private Float brushSizeRatio;
    @ColumnInfo
    private Integer brushSourceType;
    @ColumnInfo
    private Integer enableFlow;
    @ColumnInfo
    private Integer enableRandomSpriteIndex;
    @ColumnInfo
    private Integer enableRotate;
    @ColumnInfo
    private String icon;
    @PrimaryKey(autoGenerate = false)
    private String id;
    @ColumnInfo
    private Float paintIntervalRatio;
    @ColumnInfo
    private String resourceChildBlendMode;
    @ColumnInfo
    private String resourceChildPath;
    @ColumnInfo
    private String resourceFolderPath;
    @ColumnInfo
    private Integer supportChangeColor;

    public PaintMaterialTable(String id, String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f2, Float f3, Float f4, Float f5, Float f6, String str5, Integer num6, Integer num7, Integer num8) {
        s.h(id, "id");
        this.id = id;
        this.icon = str;
        this.resourceFolderPath = str2;
        this.resourceChildPath = str3;
        this.resourceChildBlendMode = str4;
        this.autoAdjustPaintInterval = num;
        this.brushSizeCalculateMode = num2;
        this.brushSourceType = num3;
        this.enableRandomSpriteIndex = num4;
        this.enableRotate = num5;
        this.paintIntervalRatio = f2;
        this.brushDefaultEffectIntensity = f3;
        this.brushEffectIntensity = f4;
        this.brushSizeRatio = f5;
        this.brushDisplaySizeRatio = f6;
        this.brushColor = str5;
        this.enableFlow = num6;
        this.brushBlendMode = num7;
        this.supportChangeColor = num8;
    }

    public final String component1() {
        return this.id;
    }

    public final Integer component10() {
        return this.enableRotate;
    }

    public final Float component11() {
        return this.paintIntervalRatio;
    }

    public final Float component12() {
        return this.brushDefaultEffectIntensity;
    }

    public final Float component13() {
        return this.brushEffectIntensity;
    }

    public final Float component14() {
        return this.brushSizeRatio;
    }

    public final Float component15() {
        return this.brushDisplaySizeRatio;
    }

    public final String component16() {
        return this.brushColor;
    }

    public final Integer component17() {
        return this.enableFlow;
    }

    public final Integer component18() {
        return this.brushBlendMode;
    }

    public final Integer component19() {
        return this.supportChangeColor;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.resourceFolderPath;
    }

    public final String component4() {
        return this.resourceChildPath;
    }

    public final String component5() {
        return this.resourceChildBlendMode;
    }

    public final Integer component6() {
        return this.autoAdjustPaintInterval;
    }

    public final Integer component7() {
        return this.brushSizeCalculateMode;
    }

    public final Integer component8() {
        return this.brushSourceType;
    }

    public final Integer component9() {
        return this.enableRandomSpriteIndex;
    }

    public final PaintMaterialTable copy(String id, String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f2, Float f3, Float f4, Float f5, Float f6, String str5, Integer num6, Integer num7, Integer num8) {
        s.h(id, "id");
        return new PaintMaterialTable(id, str, str2, str3, str4, num, num2, num3, num4, num5, f2, f3, f4, f5, f6, str5, num6, num7, num8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaintMaterialTable) {
            PaintMaterialTable paintMaterialTable = (PaintMaterialTable) obj;
            return s.c(this.id, paintMaterialTable.id) && s.c(this.icon, paintMaterialTable.icon) && s.c(this.resourceFolderPath, paintMaterialTable.resourceFolderPath) && s.c(this.resourceChildPath, paintMaterialTable.resourceChildPath) && s.c(this.resourceChildBlendMode, paintMaterialTable.resourceChildBlendMode) && s.c(this.autoAdjustPaintInterval, paintMaterialTable.autoAdjustPaintInterval) && s.c(this.brushSizeCalculateMode, paintMaterialTable.brushSizeCalculateMode) && s.c(this.brushSourceType, paintMaterialTable.brushSourceType) && s.c(this.enableRandomSpriteIndex, paintMaterialTable.enableRandomSpriteIndex) && s.c(this.enableRotate, paintMaterialTable.enableRotate) && s.c(this.paintIntervalRatio, paintMaterialTable.paintIntervalRatio) && s.c(this.brushDefaultEffectIntensity, paintMaterialTable.brushDefaultEffectIntensity) && s.c(this.brushEffectIntensity, paintMaterialTable.brushEffectIntensity) && s.c(this.brushSizeRatio, paintMaterialTable.brushSizeRatio) && s.c(this.brushDisplaySizeRatio, paintMaterialTable.brushDisplaySizeRatio) && s.c(this.brushColor, paintMaterialTable.brushColor) && s.c(this.enableFlow, paintMaterialTable.enableFlow) && s.c(this.brushBlendMode, paintMaterialTable.brushBlendMode) && s.c(this.supportChangeColor, paintMaterialTable.supportChangeColor);
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

    public final String getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final Float getPaintIntervalRatio() {
        return this.paintIntervalRatio;
    }

    public final String getResourceChildBlendMode() {
        return this.resourceChildBlendMode;
    }

    public final String getResourceChildPath() {
        return this.resourceChildPath;
    }

    public final String getResourceFolderPath() {
        return this.resourceFolderPath;
    }

    public final Integer getSupportChangeColor() {
        return this.supportChangeColor;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        String str = this.icon;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.resourceFolderPath;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.resourceChildPath;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.resourceChildBlendMode;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.autoAdjustPaintInterval;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.brushSizeCalculateMode;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.brushSourceType;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.enableRandomSpriteIndex;
        int hashCode9 = (hashCode8 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.enableRotate;
        int hashCode10 = (hashCode9 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Float f2 = this.paintIntervalRatio;
        int hashCode11 = (hashCode10 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.brushDefaultEffectIntensity;
        int hashCode12 = (hashCode11 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.brushEffectIntensity;
        int hashCode13 = (hashCode12 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.brushSizeRatio;
        int hashCode14 = (hashCode13 + (f5 == null ? 0 : f5.hashCode())) * 31;
        Float f6 = this.brushDisplaySizeRatio;
        int hashCode15 = (hashCode14 + (f6 == null ? 0 : f6.hashCode())) * 31;
        String str5 = this.brushColor;
        int hashCode16 = (hashCode15 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num6 = this.enableFlow;
        int hashCode17 = (hashCode16 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.brushBlendMode;
        int hashCode18 = (hashCode17 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.supportChangeColor;
        return hashCode18 + (num8 != null ? num8.hashCode() : 0);
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

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setId(String str) {
        s.h(str, "<set-?>");
        this.id = str;
    }

    public final void setPaintIntervalRatio(Float f2) {
        this.paintIntervalRatio = f2;
    }

    public final void setResourceChildBlendMode(String str) {
        this.resourceChildBlendMode = str;
    }

    public final void setResourceChildPath(String str) {
        this.resourceChildPath = str;
    }

    public final void setResourceFolderPath(String str) {
        this.resourceFolderPath = str;
    }

    public final void setSupportChangeColor(Integer num) {
        this.supportChangeColor = num;
    }

    public String toString() {
        return "PaintMaterialTable(id=" + this.id + ", icon=" + ((Object) this.icon) + ", resourceFolderPath=" + ((Object) this.resourceFolderPath) + ", resourceChildPath=" + ((Object) this.resourceChildPath) + ", resourceChildBlendMode=" + ((Object) this.resourceChildBlendMode) + ", autoAdjustPaintInterval=" + this.autoAdjustPaintInterval + ", brushSizeCalculateMode=" + this.brushSizeCalculateMode + ", brushSourceType=" + this.brushSourceType + ", enableRandomSpriteIndex=" + this.enableRandomSpriteIndex + ", enableRotate=" + this.enableRotate + ", paintIntervalRatio=" + this.paintIntervalRatio + ", brushDefaultEffectIntensity=" + this.brushDefaultEffectIntensity + ", brushEffectIntensity=" + this.brushEffectIntensity + ", brushSizeRatio=" + this.brushSizeRatio + ", brushDisplaySizeRatio=" + this.brushDisplaySizeRatio + ", brushColor=" + ((Object) this.brushColor) + ", enableFlow=" + this.enableFlow + ", brushBlendMode=" + this.brushBlendMode + ", supportChangeColor=" + this.supportChangeColor + ')';
    }
}
