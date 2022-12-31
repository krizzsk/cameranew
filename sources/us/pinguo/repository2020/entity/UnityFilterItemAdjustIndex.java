package us.pinguo.repository2020.entity;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: UnityFilterItemAdjustIndex.kt */
/* loaded from: classes6.dex */
public final class UnityFilterItemAdjustIndex implements NoProguard {
    private final Adjust[] adjusts;

    public UnityFilterItemAdjustIndex(Adjust[] adjustArr) {
        this.adjusts = adjustArr;
    }

    public static /* synthetic */ UnityFilterItemAdjustIndex copy$default(UnityFilterItemAdjustIndex unityFilterItemAdjustIndex, Adjust[] adjustArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            adjustArr = unityFilterItemAdjustIndex.adjusts;
        }
        return unityFilterItemAdjustIndex.copy(adjustArr);
    }

    public final Adjust[] component1() {
        return this.adjusts;
    }

    public final UnityFilterItemAdjustIndex copy(Adjust[] adjustArr) {
        return new UnityFilterItemAdjustIndex(adjustArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(UnityFilterItemAdjustIndex.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.entity.UnityFilterItemAdjustIndex");
            UnityFilterItemAdjustIndex unityFilterItemAdjustIndex = (UnityFilterItemAdjustIndex) obj;
            Adjust[] adjustArr = this.adjusts;
            if (adjustArr != null) {
                Adjust[] adjustArr2 = unityFilterItemAdjustIndex.adjusts;
                if (adjustArr2 == null || !Arrays.equals(adjustArr, adjustArr2)) {
                    return false;
                }
            } else if (unityFilterItemAdjustIndex.adjusts != null) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Adjust[] getAdjusts() {
        return this.adjusts;
    }

    public int hashCode() {
        Adjust[] adjustArr = this.adjusts;
        if (adjustArr == null) {
            return 0;
        }
        return Arrays.hashCode(adjustArr);
    }

    public String toString() {
        return "UnityFilterItemAdjustIndex(adjusts=" + Arrays.toString(this.adjusts) + ')';
    }
}
