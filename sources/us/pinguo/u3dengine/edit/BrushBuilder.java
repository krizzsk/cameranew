package us.pinguo.u3dengine.edit;

import kotlin.collections.n;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: BrushBuilder.kt */
/* loaded from: classes6.dex */
public final class BrushBuilder {
    private Integer autoAdjustPaintInterval;
    private Integer brushBlendMode;
    private String brushColorString;
    private Float brushDefaultEffectIntensity;
    private Float brushDisplaySizeRatio;
    private Integer brushSizeCalculateMode;
    private Float brushSizeRatio;
    private final int brushSourceType;
    private Integer enableRandomSpriteIndex;
    private Integer enableRotate;
    private Integer isVIP;
    private Float paintIntervalRatio;
    private Integer[] resourceChildBlendMode;
    private String[] resourceChildPath;
    private String resourceFolderPath;
    private String sourceID;

    public BrushBuilder() {
        this(0, 1, null);
    }

    public BrushBuilder(int i2) {
        this.brushSourceType = i2;
    }

    public final String build() {
        String y;
        String y2;
        StringBuilder sb = new StringBuilder();
        sb.append("brushSourceType");
        sb.append('=');
        sb.append(this.brushSourceType);
        Integer num = this.brushBlendMode;
        if (num != null) {
            sb.append('|');
            sb.append("brushBlendMode");
            sb.append('=');
            sb.append(num.intValue());
        }
        Integer num2 = this.brushSizeCalculateMode;
        if (num2 != null) {
            sb.append('|');
            sb.append("brushSizeCalculateMode");
            sb.append('=');
            sb.append(num2.intValue());
        }
        String str = this.brushColorString;
        if (str != null) {
            sb.append('|');
            sb.append("brushColorString");
            sb.append('=');
            sb.append(str);
        }
        Float f2 = this.brushDefaultEffectIntensity;
        if (f2 != null) {
            sb.append('|');
            sb.append("brushDefaultEffectIntensity");
            sb.append('=');
            sb.append(f2.floatValue());
        }
        Float f3 = this.brushDisplaySizeRatio;
        if (f3 != null) {
            sb.append('|');
            sb.append("brushDisplaySizeRatio");
            sb.append('=');
            sb.append(f3.floatValue());
        }
        Float f4 = this.brushSizeRatio;
        if (f4 != null) {
            sb.append('|');
            sb.append("brushSizeRatio");
            sb.append('=');
            sb.append(f4.floatValue());
        }
        Float f5 = this.paintIntervalRatio;
        if (f5 != null) {
            sb.append('|');
            sb.append("paintIntervalRatio");
            sb.append('=');
            sb.append(f5.floatValue());
        }
        Integer num3 = this.autoAdjustPaintInterval;
        if (num3 != null) {
            sb.append('|');
            sb.append("autoAdjustPaintInterval");
            sb.append('=');
            sb.append(num3.intValue());
        }
        Integer num4 = this.enableRandomSpriteIndex;
        if (num4 != null) {
            sb.append('|');
            sb.append("enableRandomSpriteIndex");
            sb.append('=');
            sb.append(num4.intValue());
        }
        Integer num5 = this.enableRotate;
        if (num5 != null) {
            sb.append('|');
            sb.append("enableRotate");
            sb.append('=');
            sb.append(num5.intValue());
        }
        String str2 = this.resourceFolderPath;
        if (str2 != null) {
            sb.append('|');
            sb.append("resourceFolderPath");
            sb.append('=');
            sb.append(str2);
        }
        String[] strArr = this.resourceChildPath;
        if (strArr != null) {
            sb.append('|');
            sb.append("resourceChildPath");
            sb.append('=');
            y2 = n.y(strArr, ",", null, null, 0, null, null, 62, null);
            sb.append(y2);
        }
        Integer[] numArr = this.resourceChildBlendMode;
        if (numArr != null) {
            sb.append('|');
            sb.append("resourceChildBlendMode");
            sb.append('=');
            y = n.y(numArr, ",", null, null, 0, null, null, 62, null);
            sb.append(y);
        }
        Integer num6 = this.isVIP;
        if (num6 != null) {
            sb.append('|');
            sb.append("isVIP");
            sb.append('=');
            sb.append(num6.intValue());
        }
        String str3 = this.sourceID;
        if (str3 != null) {
            sb.append('|');
            sb.append("sourceID");
            sb.append('=');
            sb.append(str3);
        }
        String sb2 = sb.toString();
        s.g(sb2, "sb.toString()");
        return sb2;
    }

    public final Integer getAutoAdjustPaintInterval() {
        return this.autoAdjustPaintInterval;
    }

    public final Integer getBrushBlendMode() {
        return this.brushBlendMode;
    }

    public final String getBrushColorString() {
        return this.brushColorString;
    }

    public final Float getBrushDefaultEffectIntensity() {
        return this.brushDefaultEffectIntensity;
    }

    public final Float getBrushDisplaySizeRatio() {
        return this.brushDisplaySizeRatio;
    }

    public final Integer getBrushSizeCalculateMode() {
        return this.brushSizeCalculateMode;
    }

    public final Float getBrushSizeRatio() {
        return this.brushSizeRatio;
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

    public final String getSourceID() {
        return this.sourceID;
    }

    public final Integer isVIP() {
        return this.isVIP;
    }

    public final void setAutoAdjustPaintInterval(Integer num) {
        this.autoAdjustPaintInterval = num;
    }

    public final void setBrushBlendMode(Integer num) {
        this.brushBlendMode = num;
    }

    public final void setBrushColorString(String str) {
        this.brushColorString = str;
    }

    public final void setBrushDefaultEffectIntensity(Float f2) {
        this.brushDefaultEffectIntensity = f2;
    }

    public final void setBrushDisplaySizeRatio(Float f2) {
        this.brushDisplaySizeRatio = f2;
    }

    public final void setBrushSizeCalculateMode(Integer num) {
        this.brushSizeCalculateMode = num;
    }

    public final void setBrushSizeRatio(Float f2) {
        this.brushSizeRatio = f2;
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

    public final void setSourceID(String str) {
        this.sourceID = str;
    }

    public final void setVIP(Integer num) {
        this.isVIP = num;
    }

    public /* synthetic */ BrushBuilder(int i2, int i3, o oVar) {
        this((i3 & 1) != 0 ? 104 : i2);
    }
}
