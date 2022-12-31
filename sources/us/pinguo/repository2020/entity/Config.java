package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
/* compiled from: Blur.kt */
/* loaded from: classes6.dex */
public final class Config {
    private Adjustment adjusment;
    private Boolean isCustomizeItem;
    private Shape shape;

    public Config() {
        this(null, null, null, 7, null);
    }

    public Config(Adjustment adjustment, Shape shape, Boolean bool) {
        this.adjusment = adjustment;
        this.shape = shape;
        this.isCustomizeItem = bool;
    }

    public final Adjustment getAdjusment() {
        return this.adjusment;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final Boolean isCustomizeItem() {
        return this.isCustomizeItem;
    }

    public final void setAdjusment(Adjustment adjustment) {
        this.adjusment = adjustment;
    }

    public final void setCustomizeItem(Boolean bool) {
        this.isCustomizeItem = bool;
    }

    public final void setShape(Shape shape) {
        this.shape = shape;
    }

    public /* synthetic */ Config(Adjustment adjustment, Shape shape, Boolean bool, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : adjustment, (i2 & 2) != 0 ? null : shape, (i2 & 4) != 0 ? null : bool);
    }
}
