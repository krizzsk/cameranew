package us.pinguo.repository2020.database.background;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDetail.kt */
/* loaded from: classes6.dex */
public final class DecorationLocation implements NoProguard {
    private final float anchorX;
    private final float anchorY;
    private final String facePosition;
    private final float facePositionOffsetX;
    private final float facePositionOffsetY;

    /* renamed from: h  reason: collision with root package name */
    private final float f11838h;
    private final float rotation;
    private final int type;
    private final float w;
    private final float x;
    private final float y;

    public DecorationLocation(int i2, String facePosition, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        s.h(facePosition, "facePosition");
        this.type = i2;
        this.facePosition = facePosition;
        this.facePositionOffsetX = f2;
        this.facePositionOffsetY = f3;
        this.x = f4;
        this.y = f5;
        this.w = f6;
        this.f11838h = f7;
        this.anchorX = f8;
        this.anchorY = f9;
        this.rotation = f10;
    }

    public final int component1() {
        return this.type;
    }

    public final float component10() {
        return this.anchorY;
    }

    public final float component11() {
        return this.rotation;
    }

    public final String component2() {
        return this.facePosition;
    }

    public final float component3() {
        return this.facePositionOffsetX;
    }

    public final float component4() {
        return this.facePositionOffsetY;
    }

    public final float component5() {
        return this.x;
    }

    public final float component6() {
        return this.y;
    }

    public final float component7() {
        return this.w;
    }

    public final float component8() {
        return this.f11838h;
    }

    public final float component9() {
        return this.anchorX;
    }

    public final DecorationLocation copy(int i2, String facePosition, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        s.h(facePosition, "facePosition");
        return new DecorationLocation(i2, facePosition, f2, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DecorationLocation) {
            DecorationLocation decorationLocation = (DecorationLocation) obj;
            return this.type == decorationLocation.type && s.c(this.facePosition, decorationLocation.facePosition) && s.c(Float.valueOf(this.facePositionOffsetX), Float.valueOf(decorationLocation.facePositionOffsetX)) && s.c(Float.valueOf(this.facePositionOffsetY), Float.valueOf(decorationLocation.facePositionOffsetY)) && s.c(Float.valueOf(this.x), Float.valueOf(decorationLocation.x)) && s.c(Float.valueOf(this.y), Float.valueOf(decorationLocation.y)) && s.c(Float.valueOf(this.w), Float.valueOf(decorationLocation.w)) && s.c(Float.valueOf(this.f11838h), Float.valueOf(decorationLocation.f11838h)) && s.c(Float.valueOf(this.anchorX), Float.valueOf(decorationLocation.anchorX)) && s.c(Float.valueOf(this.anchorY), Float.valueOf(decorationLocation.anchorY)) && s.c(Float.valueOf(this.rotation), Float.valueOf(decorationLocation.rotation));
        }
        return false;
    }

    public final float getAnchorX() {
        return this.anchorX;
    }

    public final float getAnchorY() {
        return this.anchorY;
    }

    public final String getFacePosition() {
        return this.facePosition;
    }

    public final float getFacePositionOffsetX() {
        return this.facePositionOffsetX;
    }

    public final float getFacePositionOffsetY() {
        return this.facePositionOffsetY;
    }

    public final float getH() {
        return this.f11838h;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final int getType() {
        return this.type;
    }

    public final float getW() {
        return this.w;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return (((((((((((((((((((this.type * 31) + this.facePosition.hashCode()) * 31) + Float.floatToIntBits(this.facePositionOffsetX)) * 31) + Float.floatToIntBits(this.facePositionOffsetY)) * 31) + Float.floatToIntBits(this.x)) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.w)) * 31) + Float.floatToIntBits(this.f11838h)) * 31) + Float.floatToIntBits(this.anchorX)) * 31) + Float.floatToIntBits(this.anchorY)) * 31) + Float.floatToIntBits(this.rotation);
    }

    public String toString() {
        return "DecorationLocation(type=" + this.type + ", facePosition=" + this.facePosition + ", facePositionOffsetX=" + this.facePositionOffsetX + ", facePositionOffsetY=" + this.facePositionOffsetY + ", x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.f11838h + ", anchorX=" + this.anchorX + ", anchorY=" + this.anchorY + ", rotation=" + this.rotation + ')';
    }
}
