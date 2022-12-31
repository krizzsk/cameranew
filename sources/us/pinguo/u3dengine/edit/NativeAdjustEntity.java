package us.pinguo.u3dengine.edit;

import kotlin.jvm.internal.s;
/* compiled from: UnityEditData.kt */
/* loaded from: classes6.dex */
public final class NativeAdjustEntity {
    private final int componentID;
    private final String groupName;
    private final String name;
    private String value;
    private final int valueType;

    public NativeAdjustEntity(int i2, String groupName, String name, String value, int i3) {
        s.h(groupName, "groupName");
        s.h(name, "name");
        s.h(value, "value");
        this.componentID = i2;
        this.groupName = groupName;
        this.name = name;
        this.value = value;
        this.valueType = i3;
    }

    public static /* synthetic */ NativeAdjustEntity copy$default(NativeAdjustEntity nativeAdjustEntity, int i2, String str, String str2, String str3, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = nativeAdjustEntity.componentID;
        }
        if ((i4 & 2) != 0) {
            str = nativeAdjustEntity.groupName;
        }
        String str4 = str;
        if ((i4 & 4) != 0) {
            str2 = nativeAdjustEntity.name;
        }
        String str5 = str2;
        if ((i4 & 8) != 0) {
            str3 = nativeAdjustEntity.value;
        }
        String str6 = str3;
        if ((i4 & 16) != 0) {
            i3 = nativeAdjustEntity.valueType;
        }
        return nativeAdjustEntity.copy(i2, str4, str5, str6, i3);
    }

    public final int component1() {
        return this.componentID;
    }

    public final String component2() {
        return this.groupName;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.value;
    }

    public final int component5() {
        return this.valueType;
    }

    public final NativeAdjustEntity copy(int i2, String groupName, String name, String value, int i3) {
        s.h(groupName, "groupName");
        s.h(name, "name");
        s.h(value, "value");
        return new NativeAdjustEntity(i2, groupName, name, value, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NativeAdjustEntity) {
            NativeAdjustEntity nativeAdjustEntity = (NativeAdjustEntity) obj;
            return this.componentID == nativeAdjustEntity.componentID && s.c(this.groupName, nativeAdjustEntity.groupName) && s.c(this.name, nativeAdjustEntity.name) && s.c(this.value, nativeAdjustEntity.value) && this.valueType == nativeAdjustEntity.valueType;
        }
        return false;
    }

    public final int getComponentID() {
        return this.componentID;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final int getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        return (((((((this.componentID * 31) + this.groupName.hashCode()) * 31) + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + this.valueType;
    }

    public final void setValue(String str) {
        s.h(str, "<set-?>");
        this.value = str;
    }

    public String toString() {
        return "NativeAdjustEntity(componentID=" + this.componentID + ", groupName=" + this.groupName + ", name=" + this.name + ", value=" + this.value + ", valueType=" + this.valueType + ')';
    }
}
