package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: FilterShowData.kt */
/* loaded from: classes6.dex */
public final class FilterItem {
    private final int camera_support;
    private final int enableGesture;
    private final String filterId;
    private final String icon;
    private boolean isCollect;
    private final boolean isVip;
    private final String name;
    private final String packageId;
    private final int tagContent;
    private final long tagOffTime;
    private final long tagOnTime;
    private final int unity_engine_filter;

    public FilterItem(String packageId, String filterId, String icon, String name, boolean z, boolean z2, int i2, int i3, int i4, int i5, long j2, long j3) {
        s.h(packageId, "packageId");
        s.h(filterId, "filterId");
        s.h(icon, "icon");
        s.h(name, "name");
        this.packageId = packageId;
        this.filterId = filterId;
        this.icon = icon;
        this.name = name;
        this.isCollect = z;
        this.isVip = z2;
        this.unity_engine_filter = i2;
        this.camera_support = i3;
        this.enableGesture = i4;
        this.tagContent = i5;
        this.tagOnTime = j2;
        this.tagOffTime = j3;
    }

    public final String component1() {
        return this.packageId;
    }

    public final int component10() {
        return this.tagContent;
    }

    public final long component11() {
        return this.tagOnTime;
    }

    public final long component12() {
        return this.tagOffTime;
    }

    public final String component2() {
        return this.filterId;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.name;
    }

    public final boolean component5() {
        return this.isCollect;
    }

    public final boolean component6() {
        return this.isVip;
    }

    public final int component7() {
        return this.unity_engine_filter;
    }

    public final int component8() {
        return this.camera_support;
    }

    public final int component9() {
        return this.enableGesture;
    }

    public final FilterItem copy(String packageId, String filterId, String icon, String name, boolean z, boolean z2, int i2, int i3, int i4, int i5, long j2, long j3) {
        s.h(packageId, "packageId");
        s.h(filterId, "filterId");
        s.h(icon, "icon");
        s.h(name, "name");
        return new FilterItem(packageId, filterId, icon, name, z, z2, i2, i3, i4, i5, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FilterItem) {
            FilterItem filterItem = (FilterItem) obj;
            return s.c(this.packageId, filterItem.packageId) && s.c(this.filterId, filterItem.filterId) && s.c(this.icon, filterItem.icon) && s.c(this.name, filterItem.name) && this.isCollect == filterItem.isCollect && this.isVip == filterItem.isVip && this.unity_engine_filter == filterItem.unity_engine_filter && this.camera_support == filterItem.camera_support && this.enableGesture == filterItem.enableGesture && this.tagContent == filterItem.tagContent && this.tagOnTime == filterItem.tagOnTime && this.tagOffTime == filterItem.tagOffTime;
        }
        return false;
    }

    public final int getCamera_support() {
        return this.camera_support;
    }

    public final int getEnableGesture() {
        return this.enableGesture;
    }

    public final String getFilterId() {
        return this.filterId;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final int getTagContent() {
        return this.tagContent;
    }

    public final long getTagOffTime() {
        return this.tagOffTime;
    }

    public final long getTagOnTime() {
        return this.tagOnTime;
    }

    public final int getUnity_engine_filter() {
        return this.unity_engine_filter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.packageId.hashCode() * 31) + this.filterId.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.name.hashCode()) * 31;
        boolean z = this.isCollect;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.isVip;
        return ((((((((((((i3 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.unity_engine_filter) * 31) + this.camera_support) * 31) + this.enableGesture) * 31) + this.tagContent) * 31) + c.a(this.tagOnTime)) * 31) + c.a(this.tagOffTime);
    }

    public final boolean isCollect() {
        return this.isCollect;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setCollect(boolean z) {
        this.isCollect = z;
    }

    public String toString() {
        return "FilterItem(packageId=" + this.packageId + ", filterId=" + this.filterId + ", icon=" + this.icon + ", name=" + this.name + ", isCollect=" + this.isCollect + ", isVip=" + this.isVip + ", unity_engine_filter=" + this.unity_engine_filter + ", camera_support=" + this.camera_support + ", enableGesture=" + this.enableGesture + ", tagContent=" + this.tagContent + ", tagOnTime=" + this.tagOnTime + ", tagOffTime=" + this.tagOffTime + ')';
    }
}
