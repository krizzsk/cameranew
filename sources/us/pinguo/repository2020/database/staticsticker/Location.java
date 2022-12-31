package us.pinguo.repository2020.database.staticsticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StaticStickerDetail.kt */
/* loaded from: classes6.dex */
public final class Location implements NoProguard {
    private final Float H;
    private final Float W;
    private final Float X;
    private final Float Y;
    private final Float anchorX;
    private final Float anchorY;
    private final String facePosition;
    private final Integer mirrorH;
    private final Float rotation;
    private final Integer type;

    public Location(Integer num, String str, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Integer num2) {
        this.type = num;
        this.facePosition = str;
        this.X = f2;
        this.Y = f3;
        this.W = f4;
        this.H = f5;
        this.anchorX = f6;
        this.anchorY = f7;
        this.rotation = f8;
        this.mirrorH = num2;
    }

    public final Integer component1() {
        return this.type;
    }

    public final Integer component10() {
        return this.mirrorH;
    }

    public final String component2() {
        return this.facePosition;
    }

    public final Float component3() {
        return this.X;
    }

    public final Float component4() {
        return this.Y;
    }

    public final Float component5() {
        return this.W;
    }

    public final Float component6() {
        return this.H;
    }

    public final Float component7() {
        return this.anchorX;
    }

    public final Float component8() {
        return this.anchorY;
    }

    public final Float component9() {
        return this.rotation;
    }

    public final Location copy(Integer num, String str, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Integer num2) {
        return new Location(num, str, f2, f3, f4, f5, f6, f7, f8, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Location) {
            Location location = (Location) obj;
            return s.c(this.type, location.type) && s.c(this.facePosition, location.facePosition) && s.c(this.X, location.X) && s.c(this.Y, location.Y) && s.c(this.W, location.W) && s.c(this.H, location.H) && s.c(this.anchorX, location.anchorX) && s.c(this.anchorY, location.anchorY) && s.c(this.rotation, location.rotation) && s.c(this.mirrorH, location.mirrorH);
        }
        return false;
    }

    public final Float getAnchorX() {
        return this.anchorX;
    }

    public final Float getAnchorY() {
        return this.anchorY;
    }

    public final String getFacePosition() {
        return this.facePosition;
    }

    public final Float getH() {
        return this.H;
    }

    public final Integer getMirrorH() {
        return this.mirrorH;
    }

    public final Float getRotation() {
        return this.rotation;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Float getW() {
        return this.W;
    }

    public final Float getX() {
        return this.X;
    }

    public final Float getY() {
        return this.Y;
    }

    public int hashCode() {
        Integer num = this.type;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.facePosition;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Float f2 = this.X;
        int hashCode3 = (hashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.Y;
        int hashCode4 = (hashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.W;
        int hashCode5 = (hashCode4 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.H;
        int hashCode6 = (hashCode5 + (f5 == null ? 0 : f5.hashCode())) * 31;
        Float f6 = this.anchorX;
        int hashCode7 = (hashCode6 + (f6 == null ? 0 : f6.hashCode())) * 31;
        Float f7 = this.anchorY;
        int hashCode8 = (hashCode7 + (f7 == null ? 0 : f7.hashCode())) * 31;
        Float f8 = this.rotation;
        int hashCode9 = (hashCode8 + (f8 == null ? 0 : f8.hashCode())) * 31;
        Integer num2 = this.mirrorH;
        return hashCode9 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "Location(type=" + this.type + ", facePosition=" + ((Object) this.facePosition) + ", X=" + this.X + ", Y=" + this.Y + ", W=" + this.W + ", H=" + this.H + ", anchorX=" + this.anchorX + ", anchorY=" + this.anchorY + ", rotation=" + this.rotation + ", mirrorH=" + this.mirrorH + ')';
    }
}
