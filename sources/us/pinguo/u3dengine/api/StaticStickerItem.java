package us.pinguo.u3dengine.api;

import android.graphics.PointF;
import android.graphics.RectF;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: UnityMethodData.kt */
/* loaded from: classes6.dex */
public final class StaticStickerItem {
    private PGEditBlendMode blendMode;
    private PointF center;
    private final Integer enableGestureSelect;
    private final RectF gestureAreaPaddingSize;
    private final Integer gesturePenetrate;
    private final String key;
    private Integer needRecordHistory;
    private Float opacity;
    private Float rotateAngle;
    private PointF size;
    private final String sourceTexture;

    public StaticStickerItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public StaticStickerItem(String str, PGEditBlendMode pGEditBlendMode, PointF pointF, PointF pointF2, Float f2, Integer num, Integer num2, String str2, Float f3, Integer num3, RectF rectF) {
        this.sourceTexture = str;
        this.blendMode = pGEditBlendMode;
        this.size = pointF;
        this.center = pointF2;
        this.rotateAngle = f2;
        this.enableGestureSelect = num;
        this.needRecordHistory = num2;
        this.key = str2;
        this.opacity = f3;
        this.gesturePenetrate = num3;
        this.gestureAreaPaddingSize = rectF;
    }

    public final String component1() {
        return this.sourceTexture;
    }

    public final Integer component10() {
        return this.gesturePenetrate;
    }

    public final RectF component11() {
        return this.gestureAreaPaddingSize;
    }

    public final PGEditBlendMode component2() {
        return this.blendMode;
    }

    public final PointF component3() {
        return this.size;
    }

    public final PointF component4() {
        return this.center;
    }

    public final Float component5() {
        return this.rotateAngle;
    }

    public final Integer component6() {
        return this.enableGestureSelect;
    }

    public final Integer component7() {
        return this.needRecordHistory;
    }

    public final String component8() {
        return this.key;
    }

    public final Float component9() {
        return this.opacity;
    }

    public final StaticStickerItem copy(String str, PGEditBlendMode pGEditBlendMode, PointF pointF, PointF pointF2, Float f2, Integer num, Integer num2, String str2, Float f3, Integer num3, RectF rectF) {
        return new StaticStickerItem(str, pGEditBlendMode, pointF, pointF2, f2, num, num2, str2, f3, num3, rectF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StaticStickerItem) {
            StaticStickerItem staticStickerItem = (StaticStickerItem) obj;
            return s.c(this.sourceTexture, staticStickerItem.sourceTexture) && this.blendMode == staticStickerItem.blendMode && s.c(this.size, staticStickerItem.size) && s.c(this.center, staticStickerItem.center) && s.c(this.rotateAngle, staticStickerItem.rotateAngle) && s.c(this.enableGestureSelect, staticStickerItem.enableGestureSelect) && s.c(this.needRecordHistory, staticStickerItem.needRecordHistory) && s.c(this.key, staticStickerItem.key) && s.c(this.opacity, staticStickerItem.opacity) && s.c(this.gesturePenetrate, staticStickerItem.gesturePenetrate) && s.c(this.gestureAreaPaddingSize, staticStickerItem.gestureAreaPaddingSize);
        }
        return false;
    }

    public final PGEditBlendMode getBlendMode() {
        return this.blendMode;
    }

    public final PointF getCenter() {
        return this.center;
    }

    public final Integer getEnableGestureSelect() {
        return this.enableGestureSelect;
    }

    public final RectF getGestureAreaPaddingSize() {
        return this.gestureAreaPaddingSize;
    }

    public final Integer getGesturePenetrate() {
        return this.gesturePenetrate;
    }

    public final String getKey() {
        return this.key;
    }

    public final Integer getNeedRecordHistory() {
        return this.needRecordHistory;
    }

    public final Float getOpacity() {
        return this.opacity;
    }

    public final Float getRotateAngle() {
        return this.rotateAngle;
    }

    public final PointF getSize() {
        return this.size;
    }

    public final String getSourceTexture() {
        return this.sourceTexture;
    }

    public int hashCode() {
        String str = this.sourceTexture;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        PGEditBlendMode pGEditBlendMode = this.blendMode;
        int hashCode2 = (hashCode + (pGEditBlendMode == null ? 0 : pGEditBlendMode.hashCode())) * 31;
        PointF pointF = this.size;
        int hashCode3 = (hashCode2 + (pointF == null ? 0 : pointF.hashCode())) * 31;
        PointF pointF2 = this.center;
        int hashCode4 = (hashCode3 + (pointF2 == null ? 0 : pointF2.hashCode())) * 31;
        Float f2 = this.rotateAngle;
        int hashCode5 = (hashCode4 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Integer num = this.enableGestureSelect;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.needRecordHistory;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.key;
        int hashCode8 = (hashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f3 = this.opacity;
        int hashCode9 = (hashCode8 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Integer num3 = this.gesturePenetrate;
        int hashCode10 = (hashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        RectF rectF = this.gestureAreaPaddingSize;
        return hashCode10 + (rectF != null ? rectF.hashCode() : 0);
    }

    public final void setBlendMode(PGEditBlendMode pGEditBlendMode) {
        this.blendMode = pGEditBlendMode;
    }

    public final void setCenter(PointF pointF) {
        this.center = pointF;
    }

    public final void setNeedRecordHistory(Integer num) {
        this.needRecordHistory = num;
    }

    public final void setOpacity(Float f2) {
        this.opacity = f2;
    }

    public final void setRotateAngle(Float f2) {
        this.rotateAngle = f2;
    }

    public final void setSize(PointF pointF) {
        this.size = pointF;
    }

    public String toString() {
        PGEditBlendMode pGEditBlendMode;
        PointF pointF;
        PointF pointF2;
        RectF rectF;
        String str = this.key;
        String str2 = "";
        if (str != null) {
            str2 = "7=" + str + '|';
        }
        String str3 = this.sourceTexture;
        if (str3 != null) {
            str2 = str2 + "0=" + str3 + '|';
        }
        if (this.blendMode != null) {
            str2 = str2 + "1=" + pGEditBlendMode.getValue() + '|';
        }
        if (this.size != null) {
            str2 = str2 + "2=" + pointF.x + ',' + pointF.y + '|';
        }
        if (this.center != null) {
            str2 = str2 + "3=" + pointF2.x + ',' + pointF2.y + '|';
        }
        Float f2 = this.rotateAngle;
        if (f2 != null) {
            str2 = str2 + "4=" + f2.floatValue() + '|';
        }
        Integer num = this.enableGestureSelect;
        if (num != null) {
            str2 = str2 + "5=" + num.intValue() + '|';
        }
        Integer num2 = this.needRecordHistory;
        if (num2 != null) {
            str2 = str2 + "6=" + num2.intValue() + '|';
        }
        Float f3 = this.opacity;
        if (f3 != null) {
            str2 = str2 + "8=" + f3.floatValue() + '|';
        }
        Integer num3 = this.gesturePenetrate;
        if (num3 != null) {
            str2 = str2 + "9=" + num3.intValue() + '|';
        }
        if (this.gestureAreaPaddingSize == null) {
            return str2;
        }
        return str2 + "10=" + rectF.left + ',' + rectF.top + ',' + rectF.right + ',' + rectF.bottom;
    }

    public /* synthetic */ StaticStickerItem(String str, PGEditBlendMode pGEditBlendMode, PointF pointF, PointF pointF2, Float f2, Integer num, Integer num2, String str2, Float f3, Integer num3, RectF rectF, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : pGEditBlendMode, (i2 & 4) != 0 ? null : pointF, (i2 & 8) != 0 ? null : pointF2, (i2 & 16) != 0 ? null : f2, (i2 & 32) != 0 ? null : num, (i2 & 64) != 0 ? null : num2, (i2 & 128) != 0 ? null : str2, (i2 & 256) != 0 ? null : f3, (i2 & 512) != 0 ? null : num3, (i2 & 1024) == 0 ? rectF : null);
    }
}
