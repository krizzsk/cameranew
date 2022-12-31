package us.pinguo.repository2020.entity;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: UnityFilterItemAdjustIndex.kt */
/* loaded from: classes6.dex */
public final class Adjust implements NoProguard {
    private final String childAdjustGroupName;
    private final ChildAdjust[] childAdjusts;

    public Adjust(String str, ChildAdjust[] childAdjustArr) {
        this.childAdjustGroupName = str;
        this.childAdjusts = childAdjustArr;
    }

    public static /* synthetic */ Adjust copy$default(Adjust adjust, String str, ChildAdjust[] childAdjustArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = adjust.childAdjustGroupName;
        }
        if ((i2 & 2) != 0) {
            childAdjustArr = adjust.childAdjusts;
        }
        return adjust.copy(str, childAdjustArr);
    }

    public final String component1() {
        return this.childAdjustGroupName;
    }

    public final ChildAdjust[] component2() {
        return this.childAdjusts;
    }

    public final Adjust copy(String str, ChildAdjust[] childAdjustArr) {
        return new Adjust(str, childAdjustArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(Adjust.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.entity.Adjust");
            Adjust adjust = (Adjust) obj;
            if (s.c(this.childAdjustGroupName, adjust.childAdjustGroupName)) {
                ChildAdjust[] childAdjustArr = this.childAdjusts;
                if (childAdjustArr != null) {
                    ChildAdjust[] childAdjustArr2 = adjust.childAdjusts;
                    if (childAdjustArr2 == null || !Arrays.equals(childAdjustArr, childAdjustArr2)) {
                        return false;
                    }
                } else if (adjust.childAdjusts != null) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final String getChildAdjustGroupName() {
        return this.childAdjustGroupName;
    }

    public final ChildAdjust[] getChildAdjusts() {
        return this.childAdjusts;
    }

    public int hashCode() {
        String str = this.childAdjustGroupName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ChildAdjust[] childAdjustArr = this.childAdjusts;
        return hashCode + (childAdjustArr != null ? Arrays.hashCode(childAdjustArr) : 0);
    }

    public String toString() {
        return "Adjust(childAdjustGroupName=" + ((Object) this.childAdjustGroupName) + ", childAdjusts=" + Arrays.toString(this.childAdjusts) + ')';
    }
}
