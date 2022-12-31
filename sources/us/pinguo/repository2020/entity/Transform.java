package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: UnityFilterItemTempleIndex.kt */
/* loaded from: classes6.dex */
public final class Transform {
    private final Integer anchorMode;
    private final Float cx;
    private final Float cy;
    private final Integer groupID;
    private final Float height;
    private final Float rotationAngle;
    private final Float width;

    public Transform(Integer num, Float f2, Float f3, Integer num2, Float f4, Float f5, Float f6) {
        this.anchorMode = num;
        this.cx = f2;
        this.cy = f3;
        this.groupID = num2;
        this.height = f4;
        this.rotationAngle = f5;
        this.width = f6;
    }

    public static /* synthetic */ Transform copy$default(Transform transform, Integer num, Float f2, Float f3, Integer num2, Float f4, Float f5, Float f6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = transform.anchorMode;
        }
        if ((i2 & 2) != 0) {
            f2 = transform.cx;
        }
        Float f7 = f2;
        if ((i2 & 4) != 0) {
            f3 = transform.cy;
        }
        Float f8 = f3;
        if ((i2 & 8) != 0) {
            num2 = transform.groupID;
        }
        Integer num3 = num2;
        if ((i2 & 16) != 0) {
            f4 = transform.height;
        }
        Float f9 = f4;
        if ((i2 & 32) != 0) {
            f5 = transform.rotationAngle;
        }
        Float f10 = f5;
        if ((i2 & 64) != 0) {
            f6 = transform.width;
        }
        return transform.copy(num, f7, f8, num3, f9, f10, f6);
    }

    public final Integer component1() {
        return this.anchorMode;
    }

    public final Float component2() {
        return this.cx;
    }

    public final Float component3() {
        return this.cy;
    }

    public final Integer component4() {
        return this.groupID;
    }

    public final Float component5() {
        return this.height;
    }

    public final Float component6() {
        return this.rotationAngle;
    }

    public final Float component7() {
        return this.width;
    }

    public final Transform copy(Integer num, Float f2, Float f3, Integer num2, Float f4, Float f5, Float f6) {
        return new Transform(num, f2, f3, num2, f4, f5, f6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Transform) {
            Transform transform = (Transform) obj;
            return s.c(this.anchorMode, transform.anchorMode) && s.c(this.cx, transform.cx) && s.c(this.cy, transform.cy) && s.c(this.groupID, transform.groupID) && s.c(this.height, transform.height) && s.c(this.rotationAngle, transform.rotationAngle) && s.c(this.width, transform.width);
        }
        return false;
    }

    public final Integer getAnchorMode() {
        return this.anchorMode;
    }

    public final Float getCx() {
        return this.cx;
    }

    public final Float getCy() {
        return this.cy;
    }

    public final Integer getGroupID() {
        return this.groupID;
    }

    public final Float getHeight() {
        return this.height;
    }

    public final Float getRotationAngle() {
        return this.rotationAngle;
    }

    public final Float getWidth() {
        return this.width;
    }

    public int hashCode() {
        Integer num = this.anchorMode;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Float f2 = this.cx;
        int hashCode2 = (hashCode + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.cy;
        int hashCode3 = (hashCode2 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Integer num2 = this.groupID;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f4 = this.height;
        int hashCode5 = (hashCode4 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.rotationAngle;
        int hashCode6 = (hashCode5 + (f5 == null ? 0 : f5.hashCode())) * 31;
        Float f6 = this.width;
        return hashCode6 + (f6 != null ? f6.hashCode() : 0);
    }

    public String toString() {
        return "Transform(anchorMode=" + this.anchorMode + ", cx=" + this.cx + ", cy=" + this.cy + ", groupID=" + this.groupID + ", height=" + this.height + ", rotationAngle=" + this.rotationAngle + ", width=" + this.width + ')';
    }
}
