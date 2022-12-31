package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: UnityFilterItemAdjustIndex.kt */
/* loaded from: classes6.dex */
public final class ChildAdjust implements NoProguard {
    private final String name;
    private final String value;
    private final Integer valueType;

    public ChildAdjust(String str, String str2, Integer num) {
        this.name = str;
        this.value = str2;
        this.valueType = num;
    }

    public static /* synthetic */ ChildAdjust copy$default(ChildAdjust childAdjust, String str, String str2, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = childAdjust.name;
        }
        if ((i2 & 2) != 0) {
            str2 = childAdjust.value;
        }
        if ((i2 & 4) != 0) {
            num = childAdjust.valueType;
        }
        return childAdjust.copy(str, str2, num);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.value;
    }

    public final Integer component3() {
        return this.valueType;
    }

    public final ChildAdjust copy(String str, String str2, Integer num) {
        return new ChildAdjust(str, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChildAdjust) {
            ChildAdjust childAdjust = (ChildAdjust) obj;
            return s.c(this.name, childAdjust.name) && s.c(this.value, childAdjust.value) && s.c(this.valueType, childAdjust.valueType);
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final Integer getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.valueType;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ChildAdjust(name=" + ((Object) this.name) + ", value=" + ((Object) this.value) + ", valueType=" + this.valueType + ')';
    }
}
