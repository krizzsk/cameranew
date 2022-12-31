package us.pinguo.androidsdk.beans;

import kotlin.jvm.internal.s;
/* compiled from: SkinBeans.kt */
/* loaded from: classes3.dex */
public final class SkinParamExtra {
    private boolean autoLevel;
    private float smooth;
    private float whiteLevel;

    public SkinParamExtra(float f2, float f3, boolean z) {
        this.whiteLevel = f2;
        this.smooth = f3;
        this.autoLevel = z;
    }

    public static /* synthetic */ SkinParamExtra copy$default(SkinParamExtra skinParamExtra, float f2, float f3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = skinParamExtra.whiteLevel;
        }
        if ((i2 & 2) != 0) {
            f3 = skinParamExtra.smooth;
        }
        if ((i2 & 4) != 0) {
            z = skinParamExtra.autoLevel;
        }
        return skinParamExtra.copy(f2, f3, z);
    }

    public final float component1() {
        return this.whiteLevel;
    }

    public final float component2() {
        return this.smooth;
    }

    public final boolean component3() {
        return this.autoLevel;
    }

    public final SkinParamExtra copy(float f2, float f3, boolean z) {
        return new SkinParamExtra(f2, f3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkinParamExtra) {
            SkinParamExtra skinParamExtra = (SkinParamExtra) obj;
            return s.c(Float.valueOf(this.whiteLevel), Float.valueOf(skinParamExtra.whiteLevel)) && s.c(Float.valueOf(this.smooth), Float.valueOf(skinParamExtra.smooth)) && this.autoLevel == skinParamExtra.autoLevel;
        }
        return false;
    }

    public final boolean getAutoLevel() {
        return this.autoLevel;
    }

    public final float getSmooth() {
        return this.smooth;
    }

    public final float getWhiteLevel() {
        return this.whiteLevel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((Float.floatToIntBits(this.whiteLevel) * 31) + Float.floatToIntBits(this.smooth)) * 31;
        boolean z = this.autoLevel;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return floatToIntBits + i2;
    }

    public final void setAutoLevel(boolean z) {
        this.autoLevel = z;
    }

    public final void setSmooth(float f2) {
        this.smooth = f2;
    }

    public final void setWhiteLevel(float f2) {
        this.whiteLevel = f2;
    }

    public String toString() {
        return "SkinParamExtra(whiteLevel=" + this.whiteLevel + ", smooth=" + this.smooth + ", autoLevel=" + this.autoLevel + ')';
    }
}
