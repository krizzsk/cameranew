package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: UnityFilterItemIndex.kt */
/* loaded from: classes6.dex */
public final class ChildComponent {
    private final String resourcePath;
    private final Integer type;
    private final String typeDescribe;

    public ChildComponent(Integer num, String str, String str2) {
        this.type = num;
        this.typeDescribe = str;
        this.resourcePath = str2;
    }

    public static /* synthetic */ ChildComponent copy$default(ChildComponent childComponent, Integer num, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = childComponent.type;
        }
        if ((i2 & 2) != 0) {
            str = childComponent.typeDescribe;
        }
        if ((i2 & 4) != 0) {
            str2 = childComponent.resourcePath;
        }
        return childComponent.copy(num, str, str2);
    }

    public final Integer component1() {
        return this.type;
    }

    public final String component2() {
        return this.typeDescribe;
    }

    public final String component3() {
        return this.resourcePath;
    }

    public final ChildComponent copy(Integer num, String str, String str2) {
        return new ChildComponent(num, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChildComponent) {
            ChildComponent childComponent = (ChildComponent) obj;
            return s.c(this.type, childComponent.type) && s.c(this.typeDescribe, childComponent.typeDescribe) && s.c(this.resourcePath, childComponent.resourcePath);
        }
        return false;
    }

    public final String getResourcePath() {
        return this.resourcePath;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getTypeDescribe() {
        return this.typeDescribe;
    }

    public int hashCode() {
        Integer num = this.type;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.typeDescribe;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.resourcePath;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ChildComponent(type=" + this.type + ", typeDescribe=" + ((Object) this.typeDescribe) + ", resourcePath=" + ((Object) this.resourcePath) + ')';
    }
}
