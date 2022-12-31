package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: UnityFilterItemTempleIndex.kt */
/* loaded from: classes6.dex */
public final class Gesture {
    private final Boolean enableMove;
    private final Boolean enableScale;
    private final Integer moveGestureOrder;
    private final Integer scaleGestureOrder;

    public Gesture(Boolean bool, Boolean bool2, Integer num, Integer num2) {
        this.enableMove = bool;
        this.enableScale = bool2;
        this.moveGestureOrder = num;
        this.scaleGestureOrder = num2;
    }

    public static /* synthetic */ Gesture copy$default(Gesture gesture, Boolean bool, Boolean bool2, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = gesture.enableMove;
        }
        if ((i2 & 2) != 0) {
            bool2 = gesture.enableScale;
        }
        if ((i2 & 4) != 0) {
            num = gesture.moveGestureOrder;
        }
        if ((i2 & 8) != 0) {
            num2 = gesture.scaleGestureOrder;
        }
        return gesture.copy(bool, bool2, num, num2);
    }

    public final Boolean component1() {
        return this.enableMove;
    }

    public final Boolean component2() {
        return this.enableScale;
    }

    public final Integer component3() {
        return this.moveGestureOrder;
    }

    public final Integer component4() {
        return this.scaleGestureOrder;
    }

    public final Gesture copy(Boolean bool, Boolean bool2, Integer num, Integer num2) {
        return new Gesture(bool, bool2, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Gesture) {
            Gesture gesture = (Gesture) obj;
            return s.c(this.enableMove, gesture.enableMove) && s.c(this.enableScale, gesture.enableScale) && s.c(this.moveGestureOrder, gesture.moveGestureOrder) && s.c(this.scaleGestureOrder, gesture.scaleGestureOrder);
        }
        return false;
    }

    public final Boolean getEnableMove() {
        return this.enableMove;
    }

    public final Boolean getEnableScale() {
        return this.enableScale;
    }

    public final Integer getMoveGestureOrder() {
        return this.moveGestureOrder;
    }

    public final Integer getScaleGestureOrder() {
        return this.scaleGestureOrder;
    }

    public int hashCode() {
        Boolean bool = this.enableMove;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.enableScale;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.moveGestureOrder;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.scaleGestureOrder;
        return hashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "Gesture(enableMove=" + this.enableMove + ", enableScale=" + this.enableScale + ", moveGestureOrder=" + this.moveGestureOrder + ", scaleGestureOrder=" + this.scaleGestureOrder + ')';
    }
}
