package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: SkinBeans.kt */
/* loaded from: classes6.dex */
public final class SkinParam implements NoProguard {
    private SkinParamExtra extra;
    private final float max;
    private float middle;
    private float min;
    private final int type;

    public SkinParam(int i2, float f2, float f3, float f4, SkinParamExtra skinParamExtra) {
        this.type = i2;
        this.max = f2;
        this.middle = f3;
        this.min = f4;
        this.extra = skinParamExtra;
    }

    public static /* synthetic */ SkinParam copy$default(SkinParam skinParam, int i2, float f2, float f3, float f4, SkinParamExtra skinParamExtra, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = skinParam.type;
        }
        if ((i3 & 2) != 0) {
            f2 = skinParam.max;
        }
        float f5 = f2;
        if ((i3 & 4) != 0) {
            f3 = skinParam.middle;
        }
        float f6 = f3;
        if ((i3 & 8) != 0) {
            f4 = skinParam.min;
        }
        float f7 = f4;
        if ((i3 & 16) != 0) {
            skinParamExtra = skinParam.extra;
        }
        return skinParam.copy(i2, f5, f6, f7, skinParamExtra);
    }

    public final int component1() {
        return this.type;
    }

    public final float component2() {
        return this.max;
    }

    public final float component3() {
        return this.middle;
    }

    public final float component4() {
        return this.min;
    }

    public final SkinParamExtra component5() {
        return this.extra;
    }

    public final SkinParam copy(int i2, float f2, float f3, float f4, SkinParamExtra skinParamExtra) {
        return new SkinParam(i2, f2, f3, f4, skinParamExtra);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkinParam) {
            SkinParam skinParam = (SkinParam) obj;
            return this.type == skinParam.type && s.c(Float.valueOf(this.max), Float.valueOf(skinParam.max)) && s.c(Float.valueOf(this.middle), Float.valueOf(skinParam.middle)) && s.c(Float.valueOf(this.min), Float.valueOf(skinParam.min)) && s.c(this.extra, skinParam.extra);
        }
        return false;
    }

    public final SkinParamExtra getExtra() {
        return this.extra;
    }

    public final float getMax() {
        return this.max;
    }

    public final float getMiddle() {
        return this.middle;
    }

    public final float getMin() {
        return this.min;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int floatToIntBits = ((((((this.type * 31) + Float.floatToIntBits(this.max)) * 31) + Float.floatToIntBits(this.middle)) * 31) + Float.floatToIntBits(this.min)) * 31;
        SkinParamExtra skinParamExtra = this.extra;
        return floatToIntBits + (skinParamExtra == null ? 0 : skinParamExtra.hashCode());
    }

    public final void setExtra(SkinParamExtra skinParamExtra) {
        this.extra = skinParamExtra;
    }

    public final void setMiddle(float f2) {
        this.middle = f2;
    }

    public final void setMin(float f2) {
        this.min = f2;
    }

    public String toString() {
        return "SkinParam(type=" + this.type + ", max=" + this.max + ", middle=" + this.middle + ", min=" + this.min + ", extra=" + this.extra + ')';
    }
}
