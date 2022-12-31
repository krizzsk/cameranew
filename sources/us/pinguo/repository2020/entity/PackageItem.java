package us.pinguo.repository2020.entity;

import androidx.databinding.ObservableBoolean;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: FilterShowData.kt */
/* loaded from: classes6.dex */
public final class PackageItem {
    private final int camera_support;
    private final String categoryId;
    private int downloadProgress;
    private final String icon;
    private ObservableBoolean isAfterCapture;
    private boolean isCollect;
    private boolean isDownloaded;
    private boolean isFromEdit;
    private final boolean isVip;
    private final String name;
    private String noneAndAutoType;
    private final String packageId;
    private final int tagContent;
    private final long tagOffTime;
    private final long tagOnTime;
    private final int unity_engine_filter;

    public PackageItem(String categoryId, String packageId, String icon, String name, boolean z, int i2, int i3, boolean z2, boolean z3, int i4, int i5, long j2, long j3) {
        s.h(categoryId, "categoryId");
        s.h(packageId, "packageId");
        s.h(icon, "icon");
        s.h(name, "name");
        this.categoryId = categoryId;
        this.packageId = packageId;
        this.icon = icon;
        this.name = name;
        this.isVip = z;
        this.unity_engine_filter = i2;
        this.camera_support = i3;
        this.isCollect = z2;
        this.isDownloaded = z3;
        this.downloadProgress = i4;
        this.tagContent = i5;
        this.tagOnTime = j2;
        this.tagOffTime = j3;
        this.noneAndAutoType = "";
        this.isAfterCapture = new ObservableBoolean(false);
    }

    public final String component1() {
        return this.categoryId;
    }

    public final int component10() {
        return this.downloadProgress;
    }

    public final int component11() {
        return this.tagContent;
    }

    public final long component12() {
        return this.tagOnTime;
    }

    public final long component13() {
        return this.tagOffTime;
    }

    public final String component2() {
        return this.packageId;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.name;
    }

    public final boolean component5() {
        return this.isVip;
    }

    public final int component6() {
        return this.unity_engine_filter;
    }

    public final int component7() {
        return this.camera_support;
    }

    public final boolean component8() {
        return this.isCollect;
    }

    public final boolean component9() {
        return this.isDownloaded;
    }

    public final PackageItem copy(String categoryId, String packageId, String icon, String name, boolean z, int i2, int i3, boolean z2, boolean z3, int i4, int i5, long j2, long j3) {
        s.h(categoryId, "categoryId");
        s.h(packageId, "packageId");
        s.h(icon, "icon");
        s.h(name, "name");
        return new PackageItem(categoryId, packageId, icon, name, z, i2, i3, z2, z3, i4, i5, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PackageItem) {
            PackageItem packageItem = (PackageItem) obj;
            return s.c(this.categoryId, packageItem.categoryId) && s.c(this.packageId, packageItem.packageId) && s.c(this.icon, packageItem.icon) && s.c(this.name, packageItem.name) && this.isVip == packageItem.isVip && this.unity_engine_filter == packageItem.unity_engine_filter && this.camera_support == packageItem.camera_support && this.isCollect == packageItem.isCollect && this.isDownloaded == packageItem.isDownloaded && this.downloadProgress == packageItem.downloadProgress && this.tagContent == packageItem.tagContent && this.tagOnTime == packageItem.tagOnTime && this.tagOffTime == packageItem.tagOffTime;
        }
        return false;
    }

    public final int getCamera_support() {
        return this.camera_support;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public String getDiffId() {
        return s.q(this.categoryId, this.packageId);
    }

    public final int getDownloadProgress() {
        return this.downloadProgress;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNoneAndAutoType() {
        return this.noneAndAutoType;
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
        int hashCode = ((((((this.categoryId.hashCode() * 31) + this.packageId.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.name.hashCode()) * 31;
        boolean z = this.isVip;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (((((hashCode + i2) * 31) + this.unity_engine_filter) * 31) + this.camera_support) * 31;
        boolean z2 = this.isCollect;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z3 = this.isDownloaded;
        return ((((((((i5 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.downloadProgress) * 31) + this.tagContent) * 31) + c.a(this.tagOnTime)) * 31) + c.a(this.tagOffTime);
    }

    public final ObservableBoolean isAfterCapture() {
        return this.isAfterCapture;
    }

    public final boolean isCollect() {
        return this.isCollect;
    }

    public final boolean isDownloaded() {
        return this.isDownloaded;
    }

    public final boolean isFromEdit() {
        return this.isFromEdit;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setAfterCapture(ObservableBoolean observableBoolean) {
        s.h(observableBoolean, "<set-?>");
        this.isAfterCapture = observableBoolean;
    }

    public final void setCollect(boolean z) {
        this.isCollect = z;
    }

    public final void setDownloadProgress(int i2) {
        this.downloadProgress = i2;
    }

    public final void setDownloaded(boolean z) {
        this.isDownloaded = z;
    }

    public final void setFromEdit(boolean z) {
        this.isFromEdit = z;
    }

    public final void setNoneAndAutoType(String str) {
        s.h(str, "<set-?>");
        this.noneAndAutoType = str;
    }

    public String toString() {
        return "PackageItem(categoryId=" + this.categoryId + ", packageId=" + this.packageId + ", icon=" + this.icon + ", name=" + this.name + ", isVip=" + this.isVip + ", unity_engine_filter=" + this.unity_engine_filter + ", camera_support=" + this.camera_support + ", isCollect=" + this.isCollect + ", isDownloaded=" + this.isDownloaded + ", downloadProgress=" + this.downloadProgress + ", tagContent=" + this.tagContent + ", tagOnTime=" + this.tagOnTime + ", tagOffTime=" + this.tagOffTime + ')';
    }

    public /* synthetic */ PackageItem(String str, String str2, String str3, String str4, boolean z, int i2, int i3, boolean z2, boolean z3, int i4, int i5, long j2, long j3, int i6, o oVar) {
        this(str, str2, str3, str4, z, (i6 & 32) != 0 ? 0 : i2, (i6 & 64) != 0 ? 1 : i3, (i6 & 128) != 0 ? false : z2, (i6 & 256) != 0 ? false : z3, (i6 & 512) != 0 ? 0 : i4, i5, j2, j3);
    }
}
