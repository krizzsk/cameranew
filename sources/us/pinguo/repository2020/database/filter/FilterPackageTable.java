package us.pinguo.repository2020.database.filter;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: FilterDbTable.kt */
@Entity(tableName = "category")
/* loaded from: classes6.dex */
public final class FilterPackageTable implements NoProguard {
    @ColumnInfo
    private Integer camera_support;
    @ColumnInfo(defaultValue = "")
    private String categoryId;
    @ColumnInfo
    private String displayMd5;
    @ColumnInfo
    private String filterType;
    @ColumnInfo
    private String icon;
    @PrimaryKey(autoGenerate = false)
    private String id;
    @ColumnInfo
    private String namejson;
    @ColumnInfo
    private String packageMd5;
    @ColumnInfo
    private long sort;
    @ColumnInfo
    private String subType;
    @ColumnInfo
    private Integer tagContent;
    @ColumnInfo
    private Long tagOffTime;
    @ColumnInfo
    private Long tagOnTime;
    @ColumnInfo
    private String temp1;
    @ColumnInfo
    private String temp2;
    @ColumnInfo
    private String temp3;
    @ColumnInfo
    private String temp4;
    @ColumnInfo
    private Integer unity_engine_filter;
    @ColumnInfo
    private Integer vip;

    public FilterPackageTable(String categoryId, String id, String str, String str2, String str3, String str4, long j2, String str5, String str6, Integer num, Integer num2, Integer num3, Integer num4, Long l2, Long l3, String str7, String str8, String str9, String str10) {
        s.h(categoryId, "categoryId");
        s.h(id, "id");
        this.categoryId = categoryId;
        this.id = id;
        this.namejson = str;
        this.filterType = str2;
        this.subType = str3;
        this.icon = str4;
        this.sort = j2;
        this.displayMd5 = str5;
        this.packageMd5 = str6;
        this.vip = num;
        this.unity_engine_filter = num2;
        this.camera_support = num3;
        this.tagContent = num4;
        this.tagOnTime = l2;
        this.tagOffTime = l3;
        this.temp1 = str7;
        this.temp2 = str8;
        this.temp3 = str9;
        this.temp4 = str10;
    }

    public final String component1() {
        return this.categoryId;
    }

    public final Integer component10() {
        return this.vip;
    }

    public final Integer component11() {
        return this.unity_engine_filter;
    }

    public final Integer component12() {
        return this.camera_support;
    }

    public final Integer component13() {
        return this.tagContent;
    }

    public final Long component14() {
        return this.tagOnTime;
    }

    public final Long component15() {
        return this.tagOffTime;
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
        return this.filterType;
    }

    public final String component5() {
        return this.subType;
    }

    public final String component6() {
        return this.icon;
    }

    public final long component7() {
        return this.sort;
    }

    public final String component8() {
        return this.displayMd5;
    }

    public final String component9() {
        return this.packageMd5;
    }

    public final FilterPackageTable copy(String categoryId, String id, String str, String str2, String str3, String str4, long j2, String str5, String str6, Integer num, Integer num2, Integer num3, Integer num4, Long l2, Long l3, String str7, String str8, String str9, String str10) {
        s.h(categoryId, "categoryId");
        s.h(id, "id");
        return new FilterPackageTable(categoryId, id, str, str2, str3, str4, j2, str5, str6, num, num2, num3, num4, l2, l3, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FilterPackageTable) {
            FilterPackageTable filterPackageTable = (FilterPackageTable) obj;
            return s.c(this.categoryId, filterPackageTable.categoryId) && s.c(this.id, filterPackageTable.id) && s.c(this.namejson, filterPackageTable.namejson) && s.c(this.filterType, filterPackageTable.filterType) && s.c(this.subType, filterPackageTable.subType) && s.c(this.icon, filterPackageTable.icon) && this.sort == filterPackageTable.sort && s.c(this.displayMd5, filterPackageTable.displayMd5) && s.c(this.packageMd5, filterPackageTable.packageMd5) && s.c(this.vip, filterPackageTable.vip) && s.c(this.unity_engine_filter, filterPackageTable.unity_engine_filter) && s.c(this.camera_support, filterPackageTable.camera_support) && s.c(this.tagContent, filterPackageTable.tagContent) && s.c(this.tagOnTime, filterPackageTable.tagOnTime) && s.c(this.tagOffTime, filterPackageTable.tagOffTime) && s.c(this.temp1, filterPackageTable.temp1) && s.c(this.temp2, filterPackageTable.temp2) && s.c(this.temp3, filterPackageTable.temp3) && s.c(this.temp4, filterPackageTable.temp4);
        }
        return false;
    }

    public final Integer getCamera_support() {
        return this.camera_support;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getDisplayMd5() {
        return this.displayMd5;
    }

    public final String getFilterType() {
        return this.filterType;
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

    public final String getPackageMd5() {
        return this.packageMd5;
    }

    public final long getSort() {
        return this.sort;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final Integer getTagContent() {
        return this.tagContent;
    }

    public final Long getTagOffTime() {
        return this.tagOffTime;
    }

    public final Long getTagOnTime() {
        return this.tagOnTime;
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

    public final Integer getUnity_engine_filter() {
        return this.unity_engine_filter;
    }

    public final Integer getVip() {
        return this.vip;
    }

    public int hashCode() {
        int hashCode = ((this.categoryId.hashCode() * 31) + this.id.hashCode()) * 31;
        String str = this.namejson;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.filterType;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.icon;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + defpackage.c.a(this.sort)) * 31;
        String str5 = this.displayMd5;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.packageMd5;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.vip;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.unity_engine_filter;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.camera_support;
        int hashCode10 = (hashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.tagContent;
        int hashCode11 = (hashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Long l2 = this.tagOnTime;
        int hashCode12 = (hashCode11 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.tagOffTime;
        int hashCode13 = (hashCode12 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str7 = this.temp1;
        int hashCode14 = (hashCode13 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.temp2;
        int hashCode15 = (hashCode14 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.temp3;
        int hashCode16 = (hashCode15 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.temp4;
        return hashCode16 + (str10 != null ? str10.hashCode() : 0);
    }

    public final void setCamera_support(Integer num) {
        this.camera_support = num;
    }

    public final void setCategoryId(String str) {
        s.h(str, "<set-?>");
        this.categoryId = str;
    }

    public final void setDisplayMd5(String str) {
        this.displayMd5 = str;
    }

    public final void setFilterType(String str) {
        this.filterType = str;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setId(String str) {
        s.h(str, "<set-?>");
        this.id = str;
    }

    public final void setNamejson(String str) {
        this.namejson = str;
    }

    public final void setPackageMd5(String str) {
        this.packageMd5 = str;
    }

    public final void setSort(long j2) {
        this.sort = j2;
    }

    public final void setSubType(String str) {
        this.subType = str;
    }

    public final void setTagContent(Integer num) {
        this.tagContent = num;
    }

    public final void setTagOffTime(Long l2) {
        this.tagOffTime = l2;
    }

    public final void setTagOnTime(Long l2) {
        this.tagOnTime = l2;
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

    public final void setUnity_engine_filter(Integer num) {
        this.unity_engine_filter = num;
    }

    public final void setVip(Integer num) {
        this.vip = num;
    }

    public String toString() {
        return "FilterPackageTable(categoryId=" + this.categoryId + ", id=" + this.id + ", namejson=" + ((Object) this.namejson) + ", filterType=" + ((Object) this.filterType) + ", subType=" + ((Object) this.subType) + ", icon=" + ((Object) this.icon) + ", sort=" + this.sort + ", displayMd5=" + ((Object) this.displayMd5) + ", packageMd5=" + ((Object) this.packageMd5) + ", vip=" + this.vip + ", unity_engine_filter=" + this.unity_engine_filter + ", camera_support=" + this.camera_support + ", tagContent=" + this.tagContent + ", tagOnTime=" + this.tagOnTime + ", tagOffTime=" + this.tagOffTime + ", temp1=" + ((Object) this.temp1) + ", temp2=" + ((Object) this.temp2) + ", temp3=" + ((Object) this.temp3) + ", temp4=" + ((Object) this.temp4) + ')';
    }

    public /* synthetic */ FilterPackageTable(String str, String str2, String str3, String str4, String str5, String str6, long j2, String str7, String str8, Integer num, Integer num2, Integer num3, Integer num4, Long l2, Long l3, String str9, String str10, String str11, String str12, int i2, o oVar) {
        this((i2 & 1) != 0 ? "" : str, str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? "effect" : str4, (i2 & 16) != 0 ? "Filter" : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? 0L : j2, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? null : str8, (i2 & 512) != 0 ? 0 : num, (i2 & 1024) != 0 ? 0 : num2, (i2 & 2048) != 0 ? 1 : num3, (i2 & 4096) != 0 ? 0 : num4, (i2 & 8192) != 0 ? 0L : l2, (i2 & 16384) != 0 ? 0L : l3, (32768 & i2) != 0 ? null : str9, (65536 & i2) != 0 ? null : str10, (131072 & i2) != 0 ? null : str11, (i2 & 262144) != 0 ? null : str12);
    }
}
