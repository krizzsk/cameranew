package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Blur.kt */
/* loaded from: classes6.dex */
public final class BackgroundBlur extends BackgroundBlurMaterial implements NoProguard {
    private transient Adjustment adjusment;
    private transient String currentBlurLensParamType;
    private boolean isCustomizeItem;
    private final Integer order;
    private transient Shape shape;

    public BackgroundBlur() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public /* synthetic */ BackgroundBlur(String str, String str2, String str3, String str4, Integer num, Long l2, Long l3, Integer num2, Integer num3, String str5, String str6, Float f2, Integer num4, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : num, (i2 & 32) != 0 ? null : l2, (i2 & 64) != 0 ? null : l3, (i2 & 128) != 0 ? null : num2, (i2 & 256) != 0 ? 0 : num3, (i2 & 512) != 0 ? null : str5, (i2 & 1024) != 0 ? null : str6, (i2 & 2048) != 0 ? null : f2, (i2 & 4096) == 0 ? num4 : null);
    }

    public final BackgroundBlur clone() {
        Adjustment adjustment = this.adjusment;
        Float size = adjustment == null ? null : adjustment.getSize();
        Adjustment adjustment2 = this.adjusment;
        Float corrosion = adjustment2 == null ? null : adjustment2.getCorrosion();
        Adjustment adjustment3 = this.adjusment;
        Float swirly = adjustment3 == null ? null : adjustment3.getSwirly();
        Adjustment adjustment4 = this.adjusment;
        Float radial = adjustment4 == null ? null : adjustment4.getRadial();
        Adjustment adjustment5 = this.adjusment;
        Float highlight = adjustment5 == null ? null : adjustment5.getHighlight();
        Adjustment adjustment6 = this.adjusment;
        Float vivid = adjustment6 == null ? null : adjustment6.getVivid();
        Adjustment adjustment7 = this.adjusment;
        Adjustment adjustment8 = new Adjustment(size, corrosion, swirly, radial, highlight, vivid, adjustment7 == null ? null : adjustment7.getHalo());
        Shape shape = this.shape;
        Float creamy = shape == null ? null : shape.getCreamy();
        Shape shape2 = this.shape;
        Float soft = shape2 == null ? null : shape2.getSoft();
        Shape shape3 = this.shape;
        Float reflex = shape3 == null ? null : shape3.getReflex();
        Shape shape4 = this.shape;
        Float bilinear = shape4 == null ? null : shape4.getBilinear();
        Shape shape5 = this.shape;
        Shape shape6 = new Shape(creamy, soft, reflex, bilinear, shape5 != null ? shape5.getShapeTexture() : null);
        BackgroundBlur backgroundBlur = new BackgroundBlur(getPid(), getSid(), getName(), getIcon(), null, getOnsale_time(), getOff_time(), null, getVip(), getDown_url(), null, null, null, 7312, null);
        backgroundBlur.setAdjusment(adjustment8);
        backgroundBlur.setShape(shape6);
        return backgroundBlur;
    }

    public final Adjustment getAdjusment() {
        return this.adjusment;
    }

    public final String getCurrentBlurLensParamType() {
        return this.currentBlurLensParamType;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final boolean isCustomizeItem() {
        return this.isCustomizeItem;
    }

    public final void setAdjusment(Adjustment adjustment) {
        this.adjusment = adjustment;
    }

    public final void setCurrentBlurLensParamType(String str) {
        s.h(str, "<set-?>");
        this.currentBlurLensParamType = str;
    }

    public final void setCustomizeItem(boolean z) {
        this.isCustomizeItem = z;
    }

    public final void setShape(Shape shape) {
        this.shape = shape;
    }

    public BackgroundBlur(String str, String str2, String str3, String str4, Integer num, Long l2, Long l3, Integer num2, Integer num3, String str5, String str6, Float f2, Integer num4) {
        super(str, str2, str3, str4, l2, l3, num3, str5);
        this.order = num4;
        this.currentBlurLensParamType = "";
    }
}
