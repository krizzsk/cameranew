package us.pinguo.repository2020.database.background;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDetail.kt */
/* loaded from: classes6.dex */
public final class DecorationDetail implements NoProguard {
    private final float alpha;
    private final Integer enableGestureSelect;
    private final int gesturePenetrate;
    private final String img;
    private final String layer_effect_type;
    private final int layer_type;
    private final DecorationLocation location;
    private final String name;
    private final String overlayMode;
    private final Integer supportHue;

    public DecorationDetail(String name, Integer num, int i2, String layer_effect_type, String img, int i3, String overlayMode, float f2, Integer num2, DecorationLocation decorationLocation) {
        s.h(name, "name");
        s.h(layer_effect_type, "layer_effect_type");
        s.h(img, "img");
        s.h(overlayMode, "overlayMode");
        this.name = name;
        this.supportHue = num;
        this.layer_type = i2;
        this.layer_effect_type = layer_effect_type;
        this.img = img;
        this.gesturePenetrate = i3;
        this.overlayMode = overlayMode;
        this.alpha = f2;
        this.enableGestureSelect = num2;
        this.location = decorationLocation;
    }

    public final String component1() {
        return this.name;
    }

    public final DecorationLocation component10() {
        return this.location;
    }

    public final Integer component2() {
        return this.supportHue;
    }

    public final int component3() {
        return this.layer_type;
    }

    public final String component4() {
        return this.layer_effect_type;
    }

    public final String component5() {
        return this.img;
    }

    public final int component6() {
        return this.gesturePenetrate;
    }

    public final String component7() {
        return this.overlayMode;
    }

    public final float component8() {
        return this.alpha;
    }

    public final Integer component9() {
        return this.enableGestureSelect;
    }

    public final DecorationDetail copy(String name, Integer num, int i2, String layer_effect_type, String img, int i3, String overlayMode, float f2, Integer num2, DecorationLocation decorationLocation) {
        s.h(name, "name");
        s.h(layer_effect_type, "layer_effect_type");
        s.h(img, "img");
        s.h(overlayMode, "overlayMode");
        return new DecorationDetail(name, num, i2, layer_effect_type, img, i3, overlayMode, f2, num2, decorationLocation);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DecorationDetail) {
            DecorationDetail decorationDetail = (DecorationDetail) obj;
            return s.c(this.name, decorationDetail.name) && s.c(this.supportHue, decorationDetail.supportHue) && this.layer_type == decorationDetail.layer_type && s.c(this.layer_effect_type, decorationDetail.layer_effect_type) && s.c(this.img, decorationDetail.img) && this.gesturePenetrate == decorationDetail.gesturePenetrate && s.c(this.overlayMode, decorationDetail.overlayMode) && s.c(Float.valueOf(this.alpha), Float.valueOf(decorationDetail.alpha)) && s.c(this.enableGestureSelect, decorationDetail.enableGestureSelect) && s.c(this.location, decorationDetail.location);
        }
        return false;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final Integer getEnableGestureSelect() {
        return this.enableGestureSelect;
    }

    public final int getGesturePenetrate() {
        return this.gesturePenetrate;
    }

    public final String getImg() {
        return this.img;
    }

    public final String getLayer_effect_type() {
        return this.layer_effect_type;
    }

    public final int getLayer_type() {
        return this.layer_type;
    }

    public final DecorationLocation getLocation() {
        return this.location;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOverlayMode() {
        return this.overlayMode;
    }

    public final Integer getSupportHue() {
        return this.supportHue;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        Integer num = this.supportHue;
        int hashCode2 = (((((((((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.layer_type) * 31) + this.layer_effect_type.hashCode()) * 31) + this.img.hashCode()) * 31) + this.gesturePenetrate) * 31) + this.overlayMode.hashCode()) * 31) + Float.floatToIntBits(this.alpha)) * 31;
        Integer num2 = this.enableGestureSelect;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        DecorationLocation decorationLocation = this.location;
        return hashCode3 + (decorationLocation != null ? decorationLocation.hashCode() : 0);
    }

    public String toString() {
        return "DecorationDetail(name=" + this.name + ", supportHue=" + this.supportHue + ", layer_type=" + this.layer_type + ", layer_effect_type=" + this.layer_effect_type + ", img=" + this.img + ", gesturePenetrate=" + this.gesturePenetrate + ", overlayMode=" + this.overlayMode + ", alpha=" + this.alpha + ", enableGestureSelect=" + this.enableGestureSelect + ", location=" + this.location + ')';
    }
}
