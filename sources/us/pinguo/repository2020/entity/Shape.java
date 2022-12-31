package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: Blur.kt */
/* loaded from: classes6.dex */
public final class Shape {
    private Float bilinear;
    private Float creamy;
    private Float reflex;
    private String shapeTexture;
    private Float soft;

    public Shape(Float f2, Float f3, Float f4, Float f5, String str) {
        this.creamy = f2;
        this.soft = f3;
        this.reflex = f4;
        this.bilinear = f5;
        this.shapeTexture = str;
    }

    public static /* synthetic */ Shape copy$default(Shape shape, Float f2, Float f3, Float f4, Float f5, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = shape.creamy;
        }
        if ((i2 & 2) != 0) {
            f3 = shape.soft;
        }
        Float f6 = f3;
        if ((i2 & 4) != 0) {
            f4 = shape.reflex;
        }
        Float f7 = f4;
        if ((i2 & 8) != 0) {
            f5 = shape.bilinear;
        }
        Float f8 = f5;
        if ((i2 & 16) != 0) {
            str = shape.shapeTexture;
        }
        return shape.copy(f2, f6, f7, f8, str);
    }

    public final Float component1() {
        return this.creamy;
    }

    public final Float component2() {
        return this.soft;
    }

    public final Float component3() {
        return this.reflex;
    }

    public final Float component4() {
        return this.bilinear;
    }

    public final String component5() {
        return this.shapeTexture;
    }

    public final Shape copy(Float f2, Float f3, Float f4, Float f5, String str) {
        return new Shape(f2, f3, f4, f5, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Shape) {
            Shape shape = (Shape) obj;
            return s.c(this.creamy, shape.creamy) && s.c(this.soft, shape.soft) && s.c(this.reflex, shape.reflex) && s.c(this.bilinear, shape.bilinear) && s.c(this.shapeTexture, shape.shapeTexture);
        }
        return false;
    }

    public final Float getBilinear() {
        return this.bilinear;
    }

    public final Float getCreamy() {
        return this.creamy;
    }

    public final Float getReflex() {
        return this.reflex;
    }

    public final String getShapeTexture() {
        return this.shapeTexture;
    }

    public final Float getSoft() {
        return this.soft;
    }

    public int hashCode() {
        Float f2 = this.creamy;
        int hashCode = (f2 == null ? 0 : f2.hashCode()) * 31;
        Float f3 = this.soft;
        int hashCode2 = (hashCode + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.reflex;
        int hashCode3 = (hashCode2 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.bilinear;
        int hashCode4 = (hashCode3 + (f5 == null ? 0 : f5.hashCode())) * 31;
        String str = this.shapeTexture;
        return hashCode4 + (str != null ? str.hashCode() : 0);
    }

    public final void setBilinear(Float f2) {
        this.bilinear = f2;
    }

    public final void setCreamy(Float f2) {
        this.creamy = f2;
    }

    public final void setReflex(Float f2) {
        this.reflex = f2;
    }

    public final void setShapeTexture(String str) {
        this.shapeTexture = str;
    }

    public final void setSoft(Float f2) {
        this.soft = f2;
    }

    public String toString() {
        return "Shape(creamy=" + this.creamy + ", soft=" + this.soft + ", reflex=" + this.reflex + ", bilinear=" + this.bilinear + ", shapeTexture=" + ((Object) this.shapeTexture) + ')';
    }
}
