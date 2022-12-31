package us.pinguo.u3dengine.api;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import com.pinguo.camera360.effect.model.entity.Effect;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: UnityMethodData.kt */
/* loaded from: classes6.dex */
public final class MagicBgItem {
    private final PGEditBlendMode blendMode;
    private final PointF center;
    private final Boolean enableGestureSelect;
    private final RectF gestureAreaPaddingSize;
    private final Boolean gesturePenetrate;
    private final MagicBgType itemType;
    private final String key;
    private final Boolean needRecordHistory;
    private final Float opacity;
    private Integer rotateAngle;
    private final PointF size;
    private final String sourceTexture;
    private final Pair<Triple<String, Integer, Integer>, Triple<String, Integer, Integer>> sourceTextureAndMask;
    private final Pair<String, String> specialEffectId;
    private final Pair<String, String> strokeColor;
    private final Float strokeMargin;
    private final Pair<Float, Float> strokeOffset;
    private final Float strokeSmooth;
    private final Float strokeThickness;
    private final MagicBackgroundStrokeType strokeType;
    private final int supportHue;
    private final Triple<Color, Color, Integer> tintColor;

    public MagicBgItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 4194303, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MagicBgItem(String str, String str2, PGEditBlendMode pGEditBlendMode, PointF pointF, PointF pointF2, Integer num, Boolean bool, Boolean bool2, Float f2, Boolean bool3, RectF rectF, MagicBgType magicBgType, Triple<? extends Color, ? extends Color, Integer> triple, MagicBackgroundStrokeType strokeType, Pair<String, String> pair, Float f3, Float f4, Pair<Float, Float> pair2, Float f5, Pair<Triple<String, Integer, Integer>, Triple<String, Integer, Integer>> pair3, Pair<String, String> pair4, int i2) {
        s.h(strokeType, "strokeType");
        this.sourceTexture = str;
        this.key = str2;
        this.blendMode = pGEditBlendMode;
        this.size = pointF;
        this.center = pointF2;
        this.rotateAngle = num;
        this.enableGestureSelect = bool;
        this.needRecordHistory = bool2;
        this.opacity = f2;
        this.gesturePenetrate = bool3;
        this.gestureAreaPaddingSize = rectF;
        this.itemType = magicBgType;
        this.tintColor = triple;
        this.strokeType = strokeType;
        this.strokeColor = pair;
        this.strokeThickness = f3;
        this.strokeMargin = f4;
        this.strokeOffset = pair2;
        this.strokeSmooth = f5;
        this.sourceTextureAndMask = pair3;
        this.specialEffectId = pair4;
        this.supportHue = i2;
    }

    public final String component1() {
        return this.sourceTexture;
    }

    public final Boolean component10() {
        return this.gesturePenetrate;
    }

    public final RectF component11() {
        return this.gestureAreaPaddingSize;
    }

    public final MagicBgType component12() {
        return this.itemType;
    }

    public final Triple<Color, Color, Integer> component13() {
        return this.tintColor;
    }

    public final MagicBackgroundStrokeType component14() {
        return this.strokeType;
    }

    public final Pair<String, String> component15() {
        return this.strokeColor;
    }

    public final Float component16() {
        return this.strokeThickness;
    }

    public final Float component17() {
        return this.strokeMargin;
    }

    public final Pair<Float, Float> component18() {
        return this.strokeOffset;
    }

    public final Float component19() {
        return this.strokeSmooth;
    }

    public final String component2() {
        return this.key;
    }

    public final Pair<Triple<String, Integer, Integer>, Triple<String, Integer, Integer>> component20() {
        return this.sourceTextureAndMask;
    }

    public final Pair<String, String> component21() {
        return this.specialEffectId;
    }

    public final int component22() {
        return this.supportHue;
    }

    public final PGEditBlendMode component3() {
        return this.blendMode;
    }

    public final PointF component4() {
        return this.size;
    }

    public final PointF component5() {
        return this.center;
    }

    public final Integer component6() {
        return this.rotateAngle;
    }

    public final Boolean component7() {
        return this.enableGestureSelect;
    }

    public final Boolean component8() {
        return this.needRecordHistory;
    }

    public final Float component9() {
        return this.opacity;
    }

    public final MagicBgItem copy(String str, String str2, PGEditBlendMode pGEditBlendMode, PointF pointF, PointF pointF2, Integer num, Boolean bool, Boolean bool2, Float f2, Boolean bool3, RectF rectF, MagicBgType magicBgType, Triple<? extends Color, ? extends Color, Integer> triple, MagicBackgroundStrokeType strokeType, Pair<String, String> pair, Float f3, Float f4, Pair<Float, Float> pair2, Float f5, Pair<Triple<String, Integer, Integer>, Triple<String, Integer, Integer>> pair3, Pair<String, String> pair4, int i2) {
        s.h(strokeType, "strokeType");
        return new MagicBgItem(str, str2, pGEditBlendMode, pointF, pointF2, num, bool, bool2, f2, bool3, rectF, magicBgType, triple, strokeType, pair, f3, f4, pair2, f5, pair3, pair4, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MagicBgItem) {
            MagicBgItem magicBgItem = (MagicBgItem) obj;
            return s.c(this.sourceTexture, magicBgItem.sourceTexture) && s.c(this.key, magicBgItem.key) && this.blendMode == magicBgItem.blendMode && s.c(this.size, magicBgItem.size) && s.c(this.center, magicBgItem.center) && s.c(this.rotateAngle, magicBgItem.rotateAngle) && s.c(this.enableGestureSelect, magicBgItem.enableGestureSelect) && s.c(this.needRecordHistory, magicBgItem.needRecordHistory) && s.c(this.opacity, magicBgItem.opacity) && s.c(this.gesturePenetrate, magicBgItem.gesturePenetrate) && s.c(this.gestureAreaPaddingSize, magicBgItem.gestureAreaPaddingSize) && this.itemType == magicBgItem.itemType && s.c(this.tintColor, magicBgItem.tintColor) && this.strokeType == magicBgItem.strokeType && s.c(this.strokeColor, magicBgItem.strokeColor) && s.c(this.strokeThickness, magicBgItem.strokeThickness) && s.c(this.strokeMargin, magicBgItem.strokeMargin) && s.c(this.strokeOffset, magicBgItem.strokeOffset) && s.c(this.strokeSmooth, magicBgItem.strokeSmooth) && s.c(this.sourceTextureAndMask, magicBgItem.sourceTextureAndMask) && s.c(this.specialEffectId, magicBgItem.specialEffectId) && this.supportHue == magicBgItem.supportHue;
        }
        return false;
    }

    public final PGEditBlendMode getBlendMode() {
        return this.blendMode;
    }

    public final PointF getCenter() {
        return this.center;
    }

    public final Boolean getEnableGestureSelect() {
        return this.enableGestureSelect;
    }

    public final RectF getGestureAreaPaddingSize() {
        return this.gestureAreaPaddingSize;
    }

    public final Boolean getGesturePenetrate() {
        return this.gesturePenetrate;
    }

    public final MagicBgType getItemType() {
        return this.itemType;
    }

    public final String getKey() {
        return this.key;
    }

    public final Boolean getNeedRecordHistory() {
        return this.needRecordHistory;
    }

    public final Float getOpacity() {
        return this.opacity;
    }

    public final Integer getRotateAngle() {
        return this.rotateAngle;
    }

    public final PointF getSize() {
        return this.size;
    }

    public final String getSourceTexture() {
        return this.sourceTexture;
    }

    public final Pair<Triple<String, Integer, Integer>, Triple<String, Integer, Integer>> getSourceTextureAndMask() {
        return this.sourceTextureAndMask;
    }

    public final Pair<String, String> getSpecialEffectId() {
        return this.specialEffectId;
    }

    public final Pair<String, String> getStrokeColor() {
        return this.strokeColor;
    }

    public final Float getStrokeMargin() {
        return this.strokeMargin;
    }

    public final Pair<Float, Float> getStrokeOffset() {
        return this.strokeOffset;
    }

    public final Float getStrokeSmooth() {
        return this.strokeSmooth;
    }

    public final Float getStrokeThickness() {
        return this.strokeThickness;
    }

    public final MagicBackgroundStrokeType getStrokeType() {
        return this.strokeType;
    }

    public final int getSupportHue() {
        return this.supportHue;
    }

    public final Triple<Color, Color, Integer> getTintColor() {
        return this.tintColor;
    }

    public int hashCode() {
        String str = this.sourceTexture;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.key;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        PGEditBlendMode pGEditBlendMode = this.blendMode;
        int hashCode3 = (hashCode2 + (pGEditBlendMode == null ? 0 : pGEditBlendMode.hashCode())) * 31;
        PointF pointF = this.size;
        int hashCode4 = (hashCode3 + (pointF == null ? 0 : pointF.hashCode())) * 31;
        PointF pointF2 = this.center;
        int hashCode5 = (hashCode4 + (pointF2 == null ? 0 : pointF2.hashCode())) * 31;
        Integer num = this.rotateAngle;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.enableGestureSelect;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.needRecordHistory;
        int hashCode8 = (hashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Float f2 = this.opacity;
        int hashCode9 = (hashCode8 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Boolean bool3 = this.gesturePenetrate;
        int hashCode10 = (hashCode9 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        RectF rectF = this.gestureAreaPaddingSize;
        int hashCode11 = (hashCode10 + (rectF == null ? 0 : rectF.hashCode())) * 31;
        MagicBgType magicBgType = this.itemType;
        int hashCode12 = (hashCode11 + (magicBgType == null ? 0 : magicBgType.hashCode())) * 31;
        Triple<Color, Color, Integer> triple = this.tintColor;
        int hashCode13 = (((hashCode12 + (triple == null ? 0 : triple.hashCode())) * 31) + this.strokeType.hashCode()) * 31;
        Pair<String, String> pair = this.strokeColor;
        int hashCode14 = (hashCode13 + (pair == null ? 0 : pair.hashCode())) * 31;
        Float f3 = this.strokeThickness;
        int hashCode15 = (hashCode14 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.strokeMargin;
        int hashCode16 = (hashCode15 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Pair<Float, Float> pair2 = this.strokeOffset;
        int hashCode17 = (hashCode16 + (pair2 == null ? 0 : pair2.hashCode())) * 31;
        Float f5 = this.strokeSmooth;
        int hashCode18 = (hashCode17 + (f5 == null ? 0 : f5.hashCode())) * 31;
        Pair<Triple<String, Integer, Integer>, Triple<String, Integer, Integer>> pair3 = this.sourceTextureAndMask;
        int hashCode19 = (hashCode18 + (pair3 == null ? 0 : pair3.hashCode())) * 31;
        Pair<String, String> pair4 = this.specialEffectId;
        return ((hashCode19 + (pair4 != null ? pair4.hashCode() : 0)) * 31) + this.supportHue;
    }

    public final void setRotateAngle(Integer num) {
        this.rotateAngle = num;
    }

    public final String toParam() {
        StringBuilder sb = new StringBuilder();
        if (this.key != null) {
            sb.append(s.q("7=", getKey()));
            sb.append(Effect.DIVIDER);
        }
        if (this.sourceTexture != null) {
            sb.append(s.q("0=", getSourceTexture()));
            sb.append(Effect.DIVIDER);
        }
        if (this.blendMode != null) {
            sb.append(s.q("1=", Integer.valueOf(getBlendMode().getValue())));
            sb.append(Effect.DIVIDER);
        }
        PointF pointF = this.size;
        if (pointF != null) {
            sb.append("2=" + pointF.x + ',' + pointF.y);
            sb.append(Effect.DIVIDER);
        }
        PointF pointF2 = this.center;
        if (pointF2 != null) {
            sb.append("3=" + pointF2.x + ',' + pointF2.y);
            sb.append(Effect.DIVIDER);
        }
        Integer num = this.rotateAngle;
        if (num != null) {
            sb.append(s.q("4=", Integer.valueOf(num.intValue())));
            sb.append(Effect.DIVIDER);
        }
        Boolean bool = this.enableGestureSelect;
        if (bool != null) {
            sb.append(s.q("5=", Integer.valueOf(bool.booleanValue() ? 1 : 0)));
            sb.append(Effect.DIVIDER);
        }
        Boolean bool2 = this.needRecordHistory;
        if (bool2 != null) {
            sb.append(s.q("6=", Integer.valueOf(bool2.booleanValue() ? 1 : 0)));
            sb.append(Effect.DIVIDER);
        }
        Float f2 = this.opacity;
        if (f2 != null) {
            f2.floatValue();
            sb.append(s.q("8=", getOpacity()));
            sb.append(Effect.DIVIDER);
        }
        Boolean bool3 = this.gesturePenetrate;
        if (bool3 != null) {
            sb.append(s.q("9=", Integer.valueOf(bool3.booleanValue() ? 1 : 0)));
            sb.append(Effect.DIVIDER);
        }
        RectF rectF = this.gestureAreaPaddingSize;
        if (rectF != null) {
            sb.append("10=" + rectF.left + ',' + rectF.top + ',' + rectF.right + ',' + rectF.bottom);
            sb.append(Effect.DIVIDER);
        }
        if (this.itemType != null) {
            sb.append(s.q("11=", Integer.valueOf(getItemType().ordinal())));
            sb.append(Effect.DIVIDER);
        }
        Triple<Color, Color, Integer> triple = this.tintColor;
        if (triple != null) {
            sb.append("12=" + triple.getFirst() + ',' + triple.getSecond() + ',' + triple.getThird().intValue());
            sb.append(Effect.DIVIDER);
        }
        MagicBackgroundStrokeType magicBackgroundStrokeType = this.strokeType;
        if (magicBackgroundStrokeType != null) {
            sb.append(s.q("13=", Integer.valueOf(magicBackgroundStrokeType.ordinal())));
            sb.append(Effect.DIVIDER);
        }
        Pair<String, String> pair = this.strokeColor;
        if (pair != null) {
            if (pair.getSecond() == null) {
                sb.append(s.q("14=", pair.getFirst()));
                sb.append(Effect.DIVIDER);
            } else {
                sb.append("14=" + pair.getFirst() + ',' + ((Object) pair.getSecond()));
                sb.append(Effect.DIVIDER);
            }
        }
        Float f3 = this.strokeThickness;
        if (f3 != null) {
            sb.append(s.q("15=", Float.valueOf(f3.floatValue())));
            sb.append(Effect.DIVIDER);
        }
        Float f4 = this.strokeMargin;
        if (f4 != null) {
            sb.append(s.q("16=", Float.valueOf(f4.floatValue())));
            sb.append(Effect.DIVIDER);
        }
        Pair<Float, Float> pair2 = this.strokeOffset;
        if (pair2 != null) {
            sb.append("17=" + pair2.getFirst().floatValue() + ',' + pair2.getSecond().floatValue());
            sb.append(Effect.DIVIDER);
        }
        Float f5 = this.strokeSmooth;
        if (f5 != null) {
            sb.append(s.q("18=", Float.valueOf(f5.floatValue())));
            sb.append(Effect.DIVIDER);
        }
        Pair<Triple<String, Integer, Integer>, Triple<String, Integer, Integer>> pair3 = this.sourceTextureAndMask;
        if (pair3 != null) {
            sb.append("19=" + pair3.getFirst().getFirst() + ',' + pair3.getFirst().getSecond().intValue() + ',' + pair3.getFirst().getThird().intValue() + ',' + pair3.getSecond().getFirst() + ',' + pair3.getSecond().getSecond().intValue() + ',' + pair3.getSecond().getThird().intValue());
            sb.append(Effect.DIVIDER);
        }
        Pair<String, String> pair4 = this.specialEffectId;
        if (pair4 != null) {
            if (pair4.getSecond() == null) {
                sb.append(s.q("20=", pair4.getFirst()));
                sb.append(Effect.DIVIDER);
            } else {
                sb.append("20=" + pair4.getFirst() + ',' + ((Object) pair4.getSecond()));
                sb.append(Effect.DIVIDER);
            }
        }
        sb.append(s.q("22=", Integer.valueOf(this.supportHue)));
        String sb2 = sb.toString();
        s.g(sb2, "paramBuilder.toString()");
        return sb2;
    }

    public final String toParamWithoutPosition() {
        CharSequence h0;
        StringBuilder sb = new StringBuilder();
        if (this.key != null) {
            sb.append(s.q("7=", getKey()));
            sb.append(Effect.DIVIDER);
        }
        if (this.sourceTexture != null) {
            sb.append(s.q("0=", getSourceTexture()));
            sb.append(Effect.DIVIDER);
        }
        if (this.blendMode != null) {
            sb.append(s.q("1=", Integer.valueOf(getBlendMode().getValue())));
            sb.append(Effect.DIVIDER);
        }
        Boolean bool = this.enableGestureSelect;
        if (bool != null) {
            sb.append(s.q("5=", Integer.valueOf(bool.booleanValue() ? 1 : 0)));
            sb.append(Effect.DIVIDER);
        }
        Boolean bool2 = this.needRecordHistory;
        if (bool2 != null) {
            sb.append(s.q("6=", Integer.valueOf(bool2.booleanValue() ? 1 : 0)));
            sb.append(Effect.DIVIDER);
        }
        Float f2 = this.opacity;
        if (f2 != null) {
            f2.floatValue();
            sb.append(s.q("8=", getOpacity()));
            sb.append(Effect.DIVIDER);
        }
        Boolean bool3 = this.gesturePenetrate;
        if (bool3 != null) {
            sb.append(s.q("9=", Integer.valueOf(bool3.booleanValue() ? 1 : 0)));
            sb.append(Effect.DIVIDER);
        }
        RectF rectF = this.gestureAreaPaddingSize;
        if (rectF != null) {
            sb.append("10=" + rectF.left + ',' + rectF.top + ',' + rectF.right + ',' + rectF.bottom);
            sb.append(Effect.DIVIDER);
        }
        if (this.itemType != null) {
            sb.append(s.q("11=", Integer.valueOf(getItemType().ordinal())));
            sb.append(Effect.DIVIDER);
        }
        Triple<Color, Color, Integer> triple = this.tintColor;
        if (triple != null) {
            sb.append("12=" + triple.getFirst() + ',' + triple.getSecond() + ',' + triple.getThird().intValue());
            sb.append(Effect.DIVIDER);
        }
        MagicBackgroundStrokeType magicBackgroundStrokeType = this.strokeType;
        if (magicBackgroundStrokeType != null) {
            sb.append(s.q("13=", Integer.valueOf(magicBackgroundStrokeType.ordinal())));
            sb.append(Effect.DIVIDER);
        }
        Pair<String, String> pair = this.strokeColor;
        if (pair != null) {
            if (pair.getSecond() == null) {
                sb.append(s.q("14=", pair.getFirst()));
                sb.append(Effect.DIVIDER);
            } else {
                sb.append("14=" + pair.getFirst() + ',' + ((Object) pair.getSecond()));
                sb.append(Effect.DIVIDER);
            }
        }
        Float f3 = this.strokeThickness;
        if (f3 != null) {
            sb.append(s.q("15=", Float.valueOf(f3.floatValue())));
            sb.append(Effect.DIVIDER);
        }
        Float f4 = this.strokeMargin;
        if (f4 != null) {
            sb.append(s.q("16=", Float.valueOf(f4.floatValue())));
            sb.append(Effect.DIVIDER);
        }
        Pair<Float, Float> pair2 = this.strokeOffset;
        if (pair2 != null) {
            sb.append("17=" + pair2.getFirst().floatValue() + ',' + pair2.getSecond().floatValue());
            sb.append(Effect.DIVIDER);
        }
        Float f5 = this.strokeSmooth;
        if (f5 != null) {
            sb.append(s.q("18=", Float.valueOf(f5.floatValue())));
            sb.append(Effect.DIVIDER);
        }
        Pair<Triple<String, Integer, Integer>, Triple<String, Integer, Integer>> pair3 = this.sourceTextureAndMask;
        if (pair3 != null) {
            sb.append("19=" + pair3.getFirst().getFirst() + ',' + pair3.getFirst().getSecond().intValue() + ',' + pair3.getFirst().getThird().intValue() + ',' + pair3.getSecond().getFirst() + ',' + pair3.getSecond().getSecond().intValue() + ',' + pair3.getSecond().getThird().intValue());
            sb.append(Effect.DIVIDER);
        }
        Pair<String, String> pair4 = this.specialEffectId;
        if (pair4 != null) {
            if (pair4.getSecond() == null) {
                sb.append(s.q("20=", pair4.getFirst()));
                sb.append(Effect.DIVIDER);
            } else {
                sb.append("20=" + pair4.getFirst() + ',' + ((Object) pair4.getSecond()));
                sb.append(Effect.DIVIDER);
            }
        }
        h0 = StringsKt__StringsKt.h0(sb, Effect.DIVIDER);
        return h0.toString();
    }

    public final String toPositionParam() {
        CharSequence h0;
        StringBuilder sb = new StringBuilder();
        if (this.key != null) {
            sb.append(s.q("7=", getKey()));
            sb.append(Effect.DIVIDER);
        }
        PointF pointF = this.size;
        if (pointF != null) {
            sb.append("2=" + pointF.x + ',' + pointF.y);
            sb.append(Effect.DIVIDER);
        }
        PointF pointF2 = this.center;
        if (pointF2 != null) {
            sb.append("3=" + pointF2.x + ',' + pointF2.y);
            sb.append(Effect.DIVIDER);
        }
        Integer num = this.rotateAngle;
        if (num != null) {
            sb.append(s.q("4=", Integer.valueOf(num.intValue())));
            sb.append(Effect.DIVIDER);
        }
        h0 = StringsKt__StringsKt.h0(sb, Effect.DIVIDER);
        return h0.toString();
    }

    public String toString() {
        return "MagicBgItem(sourceTexture=" + ((Object) this.sourceTexture) + ", key=" + ((Object) this.key) + ", blendMode=" + this.blendMode + ", size=" + this.size + ", center=" + this.center + ", rotateAngle=" + this.rotateAngle + ", enableGestureSelect=" + this.enableGestureSelect + ", needRecordHistory=" + this.needRecordHistory + ", opacity=" + this.opacity + ", gesturePenetrate=" + this.gesturePenetrate + ", gestureAreaPaddingSize=" + this.gestureAreaPaddingSize + ", itemType=" + this.itemType + ", tintColor=" + this.tintColor + ", strokeType=" + this.strokeType + ", strokeColor=" + this.strokeColor + ", strokeThickness=" + this.strokeThickness + ", strokeMargin=" + this.strokeMargin + ", strokeOffset=" + this.strokeOffset + ", strokeSmooth=" + this.strokeSmooth + ", sourceTextureAndMask=" + this.sourceTextureAndMask + ", specialEffectId=" + this.specialEffectId + ", supportHue=" + this.supportHue + ')';
    }

    public /* synthetic */ MagicBgItem(String str, String str2, PGEditBlendMode pGEditBlendMode, PointF pointF, PointF pointF2, Integer num, Boolean bool, Boolean bool2, Float f2, Boolean bool3, RectF rectF, MagicBgType magicBgType, Triple triple, MagicBackgroundStrokeType magicBackgroundStrokeType, Pair pair, Float f3, Float f4, Pair pair2, Float f5, Pair pair3, Pair pair4, int i2, int i3, o oVar) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : pGEditBlendMode, (i3 & 8) != 0 ? null : pointF, (i3 & 16) != 0 ? null : pointF2, (i3 & 32) != 0 ? null : num, (i3 & 64) != 0 ? null : bool, (i3 & 128) != 0 ? null : bool2, (i3 & 256) != 0 ? null : f2, (i3 & 512) != 0 ? null : bool3, (i3 & 1024) != 0 ? null : rectF, (i3 & 2048) != 0 ? null : magicBgType, (i3 & 4096) != 0 ? null : triple, (i3 & 8192) != 0 ? MagicBackgroundStrokeType.None : magicBackgroundStrokeType, (i3 & 16384) != 0 ? null : pair, (i3 & 32768) != 0 ? null : f3, (i3 & 65536) != 0 ? null : f4, (i3 & 131072) != 0 ? null : pair2, (i3 & 262144) != 0 ? null : f5, (i3 & 524288) != 0 ? null : pair3, (i3 & 1048576) != 0 ? null : pair4, (i3 & 2097152) != 0 ? 1 : i2);
    }
}
