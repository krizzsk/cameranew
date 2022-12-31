package us.pinguo.repository2020.database.filter;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.repository2020.entity.SkinParam;
/* compiled from: FilterDbTable.kt */
@Entity(tableName = "effect")
/* loaded from: classes6.dex */
public final class FilterParamsTable implements NoProguard {
    @PrimaryKey(autoGenerate = true)
    private int _aid;
    @ColumnInfo
    private String gpuCmd;
    @ColumnInfo
    private String id;
    @ColumnInfo
    private String key;
    @ColumnInfo
    private String onlineParam;
    @ColumnInfo
    private String packageId;
    @ColumnInfo
    private String paramStr;
    @ColumnInfo
    private String preCmd;
    @ColumnInfo
    private String skinParam;
    @Ignore
    private SkinParam skinParamObject;
    @ColumnInfo
    private String subType;
    @ColumnInfo
    private Integer supportPreview;
    @ColumnInfo
    private String temp1;
    @ColumnInfo
    private String temp2;
    @ColumnInfo
    private String temp3;
    @ColumnInfo
    private String temp4;
    @ColumnInfo
    private String textureStr;
    @ColumnInfo
    private Integer version;
    @ColumnInfo
    private String versionDir;

    public FilterParamsTable() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public FilterParamsTable(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, String str9, String str10, String str11, String str12, String str13, String str14, String str15, SkinParam skinParam) {
        this._aid = i2;
        this.id = str;
        this.packageId = str2;
        this.key = str3;
        this.preCmd = str4;
        this.gpuCmd = str5;
        this.textureStr = str6;
        this.paramStr = str7;
        this.subType = str8;
        this.supportPreview = num;
        this.version = num2;
        this.skinParam = str9;
        this.versionDir = str10;
        this.onlineParam = str11;
        this.temp1 = str12;
        this.temp2 = str13;
        this.temp3 = str14;
        this.temp4 = str15;
        this.skinParamObject = skinParam;
    }

    public final int component1() {
        return this._aid;
    }

    public final Integer component10() {
        return this.supportPreview;
    }

    public final Integer component11() {
        return this.version;
    }

    public final String component12() {
        return this.skinParam;
    }

    public final String component13() {
        return this.versionDir;
    }

    public final String component14() {
        return this.onlineParam;
    }

    public final String component15() {
        return this.temp1;
    }

    public final String component16() {
        return this.temp2;
    }

    public final String component17() {
        return this.temp3;
    }

    public final String component18() {
        return this.temp4;
    }

    public final SkinParam component19() {
        return this.skinParamObject;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.packageId;
    }

    public final String component4() {
        return this.key;
    }

    public final String component5() {
        return this.preCmd;
    }

    public final String component6() {
        return this.gpuCmd;
    }

    public final String component7() {
        return this.textureStr;
    }

    public final String component8() {
        return this.paramStr;
    }

    public final String component9() {
        return this.subType;
    }

    public final FilterParamsTable copy(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, String str9, String str10, String str11, String str12, String str13, String str14, String str15, SkinParam skinParam) {
        return new FilterParamsTable(i2, str, str2, str3, str4, str5, str6, str7, str8, num, num2, str9, str10, str11, str12, str13, str14, str15, skinParam);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FilterParamsTable) {
            FilterParamsTable filterParamsTable = (FilterParamsTable) obj;
            return this._aid == filterParamsTable._aid && s.c(this.id, filterParamsTable.id) && s.c(this.packageId, filterParamsTable.packageId) && s.c(this.key, filterParamsTable.key) && s.c(this.preCmd, filterParamsTable.preCmd) && s.c(this.gpuCmd, filterParamsTable.gpuCmd) && s.c(this.textureStr, filterParamsTable.textureStr) && s.c(this.paramStr, filterParamsTable.paramStr) && s.c(this.subType, filterParamsTable.subType) && s.c(this.supportPreview, filterParamsTable.supportPreview) && s.c(this.version, filterParamsTable.version) && s.c(this.skinParam, filterParamsTable.skinParam) && s.c(this.versionDir, filterParamsTable.versionDir) && s.c(this.onlineParam, filterParamsTable.onlineParam) && s.c(this.temp1, filterParamsTable.temp1) && s.c(this.temp2, filterParamsTable.temp2) && s.c(this.temp3, filterParamsTable.temp3) && s.c(this.temp4, filterParamsTable.temp4) && s.c(this.skinParamObject, filterParamsTable.skinParamObject);
        }
        return false;
    }

    public final String getGpuCmd() {
        return this.gpuCmd;
    }

    public final String getId() {
        return this.id;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getOnlineParam() {
        return this.onlineParam;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getParamStr() {
        return this.paramStr;
    }

    public final String getPreCmd() {
        return this.preCmd;
    }

    public final String getSkinParam() {
        return this.skinParam;
    }

    public final SkinParam getSkinParamObject() {
        return this.skinParamObject;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final Integer getSupportPreview() {
        return this.supportPreview;
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

    public final String getTextureStr() {
        return this.textureStr;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final String getVersionDir() {
        return this.versionDir;
    }

    public final int get_aid() {
        return this._aid;
    }

    public int hashCode() {
        int i2 = this._aid * 31;
        String str = this.id;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.packageId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.key;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.preCmd;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.gpuCmd;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.textureStr;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.paramStr;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.subType;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num = this.supportPreview;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.version;
        int hashCode10 = (hashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str9 = this.skinParam;
        int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.versionDir;
        int hashCode12 = (hashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.onlineParam;
        int hashCode13 = (hashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.temp1;
        int hashCode14 = (hashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.temp2;
        int hashCode15 = (hashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.temp3;
        int hashCode16 = (hashCode15 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.temp4;
        int hashCode17 = (hashCode16 + (str15 == null ? 0 : str15.hashCode())) * 31;
        SkinParam skinParam = this.skinParamObject;
        return hashCode17 + (skinParam != null ? skinParam.hashCode() : 0);
    }

    public final void setGpuCmd(String str) {
        this.gpuCmd = str;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setOnlineParam(String str) {
        this.onlineParam = str;
    }

    public final void setPackageId(String str) {
        this.packageId = str;
    }

    public final void setParamStr(String str) {
        this.paramStr = str;
    }

    public final void setPreCmd(String str) {
        this.preCmd = str;
    }

    public final void setSkinParam(String str) {
        this.skinParam = str;
    }

    public final void setSkinParamObject(SkinParam skinParam) {
        this.skinParamObject = skinParam;
    }

    public final void setSubType(String str) {
        this.subType = str;
    }

    public final void setSupportPreview(Integer num) {
        this.supportPreview = num;
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

    public final void setTextureStr(String str) {
        this.textureStr = str;
    }

    public final void setVersion(Integer num) {
        this.version = num;
    }

    public final void setVersionDir(String str) {
        this.versionDir = str;
    }

    public final void set_aid(int i2) {
        this._aid = i2;
    }

    public String toString() {
        return "FilterParamsTable(_aid=" + this._aid + ", id=" + ((Object) this.id) + ", packageId=" + ((Object) this.packageId) + ", key=" + ((Object) this.key) + ", preCmd=" + ((Object) this.preCmd) + ", gpuCmd=" + ((Object) this.gpuCmd) + ", textureStr=" + ((Object) this.textureStr) + ", paramStr=" + ((Object) this.paramStr) + ", subType=" + ((Object) this.subType) + ", supportPreview=" + this.supportPreview + ", version=" + this.version + ", skinParam=" + ((Object) this.skinParam) + ", versionDir=" + ((Object) this.versionDir) + ", onlineParam=" + ((Object) this.onlineParam) + ", temp1=" + ((Object) this.temp1) + ", temp2=" + ((Object) this.temp2) + ", temp3=" + ((Object) this.temp3) + ", temp4=" + ((Object) this.temp4) + ", skinParamObject=" + this.skinParamObject + ')';
    }

    public /* synthetic */ FilterParamsTable(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, String str9, String str10, String str11, String str12, String str13, String str14, String str15, SkinParam skinParam, int i3, o oVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? null : str5, (i3 & 64) != 0 ? null : str6, (i3 & 128) != 0 ? null : str7, (i3 & 256) != 0 ? "Filter" : str8, (i3 & 512) != 0 ? 1 : num, (i3 & 1024) != 0 ? 0 : num2, (i3 & 2048) != 0 ? null : str9, (i3 & 4096) != 0 ? null : str10, (i3 & 8192) != 0 ? null : str11, (i3 & 16384) != 0 ? null : str12, (i3 & 32768) != 0 ? null : str13, (i3 & 65536) != 0 ? null : str14, (i3 & 131072) != 0 ? null : str15, (i3 & 262144) != 0 ? null : skinParam);
    }
}
