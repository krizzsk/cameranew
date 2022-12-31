package us.pinguo.repository2020.database.filter;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
/* compiled from: FilterDbTable.kt */
@Entity(tableName = "item")
/* loaded from: classes6.dex */
public final class FilterItemTable implements NoProguard {
    @PrimaryKey(autoGenerate = true)
    private int _aid;
    @ColumnInfo
    private Integer camera_support;
    @ColumnInfo
    private Long collectTime;
    @ColumnInfo
    private Integer enableGesture;
    @ColumnInfo
    private Integer hasMusic;
    @ColumnInfo
    private String icon;
    @ColumnInfo
    private String id;
    @ColumnInfo
    private Integer isCollect;
    @ColumnInfo
    private String namejson;
    @ColumnInfo(defaultValue = TaskDetailBasePresenter.SCENE_LIST)
    private int opacity;
    @ColumnInfo
    private String packageId;
    @ColumnInfo
    private String packageMd5;
    @ColumnInfo
    private Integer sortInPackage;
    @ColumnInfo
    private String temp1;
    @ColumnInfo
    private String temp2;
    @ColumnInfo
    private String temp3;
    @ColumnInfo
    private String temp4;
    @ColumnInfo
    private String type;
    @ColumnInfo
    private Integer unity_engine_filter;

    public FilterItemTable() {
        this(0, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, 524287, null);
    }

    public FilterItemTable(int i2, String str, String str2, String str3, Integer num, String str4, String str5, Integer num2, Long l2, Integer num3, int i3, String str6, Integer num4, Integer num5, Integer num6, String str7, String str8, String str9, String str10) {
        this._aid = i2;
        this.id = str;
        this.namejson = str2;
        this.icon = str3;
        this.sortInPackage = num;
        this.packageId = str4;
        this.packageMd5 = str5;
        this.isCollect = num2;
        this.collectTime = l2;
        this.hasMusic = num3;
        this.opacity = i3;
        this.type = str6;
        this.unity_engine_filter = num4;
        this.camera_support = num5;
        this.enableGesture = num6;
        this.temp1 = str7;
        this.temp2 = str8;
        this.temp3 = str9;
        this.temp4 = str10;
    }

    public final int component1() {
        return this._aid;
    }

    public final Integer component10() {
        return this.hasMusic;
    }

    public final int component11() {
        return this.opacity;
    }

    public final String component12() {
        return this.type;
    }

    public final Integer component13() {
        return this.unity_engine_filter;
    }

    public final Integer component14() {
        return this.camera_support;
    }

    public final Integer component15() {
        return this.enableGesture;
    }

    public final String component16() {
        return this.temp1;
    }

    public final String component17() {
        return this.temp2;
    }

    public final String component18() {
        return this.temp3;
    }

    public final String component19() {
        return this.temp4;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.namejson;
    }

    public final String component4() {
        return this.icon;
    }

    public final Integer component5() {
        return this.sortInPackage;
    }

    public final String component6() {
        return this.packageId;
    }

    public final String component7() {
        return this.packageMd5;
    }

    public final Integer component8() {
        return this.isCollect;
    }

    public final Long component9() {
        return this.collectTime;
    }

    public final FilterItemTable copy(int i2, String str, String str2, String str3, Integer num, String str4, String str5, Integer num2, Long l2, Integer num3, int i3, String str6, Integer num4, Integer num5, Integer num6, String str7, String str8, String str9, String str10) {
        return new FilterItemTable(i2, str, str2, str3, num, str4, str5, num2, l2, num3, i3, str6, num4, num5, num6, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FilterItemTable) {
            FilterItemTable filterItemTable = (FilterItemTable) obj;
            return this._aid == filterItemTable._aid && s.c(this.id, filterItemTable.id) && s.c(this.namejson, filterItemTable.namejson) && s.c(this.icon, filterItemTable.icon) && s.c(this.sortInPackage, filterItemTable.sortInPackage) && s.c(this.packageId, filterItemTable.packageId) && s.c(this.packageMd5, filterItemTable.packageMd5) && s.c(this.isCollect, filterItemTable.isCollect) && s.c(this.collectTime, filterItemTable.collectTime) && s.c(this.hasMusic, filterItemTable.hasMusic) && this.opacity == filterItemTable.opacity && s.c(this.type, filterItemTable.type) && s.c(this.unity_engine_filter, filterItemTable.unity_engine_filter) && s.c(this.camera_support, filterItemTable.camera_support) && s.c(this.enableGesture, filterItemTable.enableGesture) && s.c(this.temp1, filterItemTable.temp1) && s.c(this.temp2, filterItemTable.temp2) && s.c(this.temp3, filterItemTable.temp3) && s.c(this.temp4, filterItemTable.temp4);
        }
        return false;
    }

    public final Integer getCamera_support() {
        return this.camera_support;
    }

    public final Long getCollectTime() {
        return this.collectTime;
    }

    public final Integer getEnableGesture() {
        return this.enableGesture;
    }

    public final Integer getHasMusic() {
        return this.hasMusic;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNamejson() {
        return this.namejson;
    }

    public final int getOpacity() {
        return this.opacity;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getPackageMd5() {
        return this.packageMd5;
    }

    public final Integer getSortInPackage() {
        return this.sortInPackage;
    }

    public final String getTemp1() {
        return this.temp1;
    }

    public final String getTemp2() {
        return this.temp2;
    }

    public final String getTemp3() {
        return this.temp3;
    }

    public final String getTemp4() {
        return this.temp4;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer getUnity_engine_filter() {
        return this.unity_engine_filter;
    }

    public final int get_aid() {
        return this._aid;
    }

    public int hashCode() {
        int i2 = this._aid * 31;
        String str = this.id;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.namejson;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.sortInPackage;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.packageId;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.packageMd5;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.isCollect;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l2 = this.collectTime;
        int hashCode8 = (hashCode7 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num3 = this.hasMusic;
        int hashCode9 = (((hashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31) + this.opacity) * 31;
        String str6 = this.type;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num4 = this.unity_engine_filter;
        int hashCode11 = (hashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.camera_support;
        int hashCode12 = (hashCode11 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.enableGesture;
        int hashCode13 = (hashCode12 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str7 = this.temp1;
        int hashCode14 = (hashCode13 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.temp2;
        int hashCode15 = (hashCode14 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.temp3;
        int hashCode16 = (hashCode15 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.temp4;
        return hashCode16 + (str10 != null ? str10.hashCode() : 0);
    }

    public final Integer isCollect() {
        return this.isCollect;
    }

    public final void setCamera_support(Integer num) {
        this.camera_support = num;
    }

    public final void setCollect(Integer num) {
        this.isCollect = num;
    }

    public final void setCollectTime(Long l2) {
        this.collectTime = l2;
    }

    public final void setEnableGesture(Integer num) {
        this.enableGesture = num;
    }

    public final void setHasMusic(Integer num) {
        this.hasMusic = num;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setNamejson(String str) {
        this.namejson = str;
    }

    public final void setOpacity(int i2) {
        this.opacity = i2;
    }

    public final void setPackageId(String str) {
        this.packageId = str;
    }

    public final void setPackageMd5(String str) {
        this.packageMd5 = str;
    }

    public final void setSortInPackage(Integer num) {
        this.sortInPackage = num;
    }

    public final void setTemp1(String str) {
        this.temp1 = str;
    }

    public final void setTemp2(String str) {
        this.temp2 = str;
    }

    public final void setTemp3(String str) {
        this.temp3 = str;
    }

    public final void setTemp4(String str) {
        this.temp4 = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUnity_engine_filter(Integer num) {
        this.unity_engine_filter = num;
    }

    public final void set_aid(int i2) {
        this._aid = i2;
    }

    public String toString() {
        return "FilterItemTable(_aid=" + this._aid + ", id=" + ((Object) this.id) + ", namejson=" + ((Object) this.namejson) + ", icon=" + ((Object) this.icon) + ", sortInPackage=" + this.sortInPackage + ", packageId=" + ((Object) this.packageId) + ", packageMd5=" + ((Object) this.packageMd5) + ", isCollect=" + this.isCollect + ", collectTime=" + this.collectTime + ", hasMusic=" + this.hasMusic + ", opacity=" + this.opacity + ", type=" + ((Object) this.type) + ", unity_engine_filter=" + this.unity_engine_filter + ", camera_support=" + this.camera_support + ", enableGesture=" + this.enableGesture + ", temp1=" + ((Object) this.temp1) + ", temp2=" + ((Object) this.temp2) + ", temp3=" + ((Object) this.temp3) + ", temp4=" + ((Object) this.temp4) + ')';
    }

    public /* synthetic */ FilterItemTable(int i2, String str, String str2, String str3, Integer num, String str4, String str5, Integer num2, Long l2, Integer num3, int i3, String str6, Integer num4, Integer num5, Integer num6, String str7, String str8, String str9, String str10, int i4, o oVar) {
        this((i4 & 1) == 0 ? i2 : 0, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? 0 : num, (i4 & 32) != 0 ? null : str4, (i4 & 64) != 0 ? null : str5, (i4 & 128) != 0 ? 0 : num2, (i4 & 256) != 0 ? 0L : l2, (i4 & 512) != 0 ? 0 : num3, (i4 & 1024) != 0 ? -1 : i3, (i4 & 2048) != 0 ? null : str6, (i4 & 4096) != 0 ? 0 : num4, (i4 & 8192) != 0 ? 1 : num5, (i4 & 16384) != 0 ? 0 : num6, (i4 & 32768) != 0 ? null : str7, (i4 & 65536) != 0 ? null : str8, (i4 & 131072) != 0 ? null : str9, (i4 & 262144) != 0 ? null : str10);
    }
}
