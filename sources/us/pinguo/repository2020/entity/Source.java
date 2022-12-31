package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: UnityFilterItemTempleIndex.kt */
/* loaded from: classes6.dex */
public final class Source {
    private final Integer blendMode;
    private final ContentAlignment contentAlignment;
    private final Gesture gesture;
    private final Boolean isEnableAdjustOpacity;
    private final Double opacity;
    private final Integer renderOrder;
    private final Integer scaleMode;
    private final String templateTyple;
    private final Texturefile texturefile;
    private final Transform transform;

    public Source(Integer num, ContentAlignment contentAlignment, Gesture gesture, Boolean bool, Double d2, Integer num2, Integer num3, String str, Texturefile texturefile, Transform transform) {
        this.blendMode = num;
        this.contentAlignment = contentAlignment;
        this.gesture = gesture;
        this.isEnableAdjustOpacity = bool;
        this.opacity = d2;
        this.renderOrder = num2;
        this.scaleMode = num3;
        this.templateTyple = str;
        this.texturefile = texturefile;
        this.transform = transform;
    }

    public final Integer component1() {
        return this.blendMode;
    }

    public final Transform component10() {
        return this.transform;
    }

    public final ContentAlignment component2() {
        return this.contentAlignment;
    }

    public final Gesture component3() {
        return this.gesture;
    }

    public final Boolean component4() {
        return this.isEnableAdjustOpacity;
    }

    public final Double component5() {
        return this.opacity;
    }

    public final Integer component6() {
        return this.renderOrder;
    }

    public final Integer component7() {
        return this.scaleMode;
    }

    public final String component8() {
        return this.templateTyple;
    }

    public final Texturefile component9() {
        return this.texturefile;
    }

    public final Source copy(Integer num, ContentAlignment contentAlignment, Gesture gesture, Boolean bool, Double d2, Integer num2, Integer num3, String str, Texturefile texturefile, Transform transform) {
        return new Source(num, contentAlignment, gesture, bool, d2, num2, num3, str, texturefile, transform);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Source) {
            Source source = (Source) obj;
            return s.c(this.blendMode, source.blendMode) && s.c(this.contentAlignment, source.contentAlignment) && s.c(this.gesture, source.gesture) && s.c(this.isEnableAdjustOpacity, source.isEnableAdjustOpacity) && s.c(this.opacity, source.opacity) && s.c(this.renderOrder, source.renderOrder) && s.c(this.scaleMode, source.scaleMode) && s.c(this.templateTyple, source.templateTyple) && s.c(this.texturefile, source.texturefile) && s.c(this.transform, source.transform);
        }
        return false;
    }

    public final Integer getBlendMode() {
        return this.blendMode;
    }

    public final ContentAlignment getContentAlignment() {
        return this.contentAlignment;
    }

    public final Gesture getGesture() {
        return this.gesture;
    }

    public final Double getOpacity() {
        return this.opacity;
    }

    public final Integer getRenderOrder() {
        return this.renderOrder;
    }

    public final Integer getScaleMode() {
        return this.scaleMode;
    }

    public final String getTemplateTyple() {
        return this.templateTyple;
    }

    public final Texturefile getTexturefile() {
        return this.texturefile;
    }

    public final Transform getTransform() {
        return this.transform;
    }

    public int hashCode() {
        Integer num = this.blendMode;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        ContentAlignment contentAlignment = this.contentAlignment;
        int hashCode2 = (hashCode + (contentAlignment == null ? 0 : contentAlignment.hashCode())) * 31;
        Gesture gesture = this.gesture;
        int hashCode3 = (hashCode2 + (gesture == null ? 0 : gesture.hashCode())) * 31;
        Boolean bool = this.isEnableAdjustOpacity;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Double d2 = this.opacity;
        int hashCode5 = (hashCode4 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Integer num2 = this.renderOrder;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.scaleMode;
        int hashCode7 = (hashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.templateTyple;
        int hashCode8 = (hashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        Texturefile texturefile = this.texturefile;
        int hashCode9 = (hashCode8 + (texturefile == null ? 0 : texturefile.hashCode())) * 31;
        Transform transform = this.transform;
        return hashCode9 + (transform != null ? transform.hashCode() : 0);
    }

    public final Boolean isEnableAdjustOpacity() {
        return this.isEnableAdjustOpacity;
    }

    public String toString() {
        return "Source(blendMode=" + this.blendMode + ", contentAlignment=" + this.contentAlignment + ", gesture=" + this.gesture + ", isEnableAdjustOpacity=" + this.isEnableAdjustOpacity + ", opacity=" + this.opacity + ", renderOrder=" + this.renderOrder + ", scaleMode=" + this.scaleMode + ", templateTyple=" + ((Object) this.templateTyple) + ", texturefile=" + this.texturefile + ", transform=" + this.transform + ')';
    }
}
