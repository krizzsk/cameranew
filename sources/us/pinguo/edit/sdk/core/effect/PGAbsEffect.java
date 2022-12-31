package us.pinguo.edit.sdk.core.effect;

import java.io.Serializable;
import us.pinguo.edit.sdk.core.model.a;
/* loaded from: classes4.dex */
public abstract class PGAbsEffect implements Serializable, Comparable<PGAbsEffect> {
    public static final int PRECISION_HIGH = 2;
    public static final int PRECISION_LOW = 0;
    public static final int PRECISION_MIDDLE = 1;
    protected String mEffectKey;
    private int mPrecision = 2;
    private int mPriority;

    public abstract a buildMakeEft();

    public abstract String buildParamJson();

    public abstract a buildRenderEft();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.mEffectKey;
        String str2 = ((PGAbsEffect) obj).mEffectKey;
        return str == null ? str2 == null : str.equals(str2);
    }

    public String getEffectKey() {
        return this.mEffectKey;
    }

    public int getPrecision() {
        return this.mPrecision;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        String str = this.mEffectKey;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public abstract void parseParamJson(String str);

    public void setEffectKey(String str) {
        this.mEffectKey = str;
    }

    public void setParamValue(String str, float f2) {
    }

    public void setPrecision(int i2) {
        this.mPrecision = i2;
    }

    public void setPriority(int i2) {
        this.mPriority = i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(PGAbsEffect pGAbsEffect) {
        if (getPriority() < pGAbsEffect.getPriority()) {
            return -1;
        }
        return getPriority() > pGAbsEffect.getPriority() ? 1 : 0;
    }
}
