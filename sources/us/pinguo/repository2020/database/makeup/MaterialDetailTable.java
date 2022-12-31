package us.pinguo.repository2020.database.makeup;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: MaterialTables.kt */
@Entity(tableName = "material_detail")
/* loaded from: classes6.dex */
public final class MaterialDetailTable implements NoProguard {
    @ColumnInfo
    private String displayMd5;
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
    private String temp1;
    @ColumnInfo
    private String temp2;
    @ColumnInfo
    private String temp3;
    @ColumnInfo
    private String temp4;

    public MaterialDetailTable(String id, String str, String str2, String str3, String str4, long j2, String str5, String str6, String str7, String str8, String str9, String str10) {
        s.h(id, "id");
        this.id = id;
        this.namejson = str;
        this.packageMd5 = str2;
        this.subType = str3;
        this.icon = str4;
        this.sort = j2;
        this.displayMd5 = str5;
        this.filterType = str6;
        this.temp1 = str7;
        this.temp2 = str8;
        this.temp3 = str9;
        this.temp4 = str10;
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.temp2;
    }

    public final String component11() {
        return this.temp3;
    }

    public final String component12() {
        return this.temp4;
    }

    public final String component2() {
        return this.namejson;
    }

    public final String component3() {
        return this.packageMd5;
    }

    public final String component4() {
        return this.subType;
    }

    public final String component5() {
        return this.icon;
    }

    public final long component6() {
        return this.sort;
    }

    public final String component7() {
        return this.displayMd5;
    }

    public final String component8() {
        return this.filterType;
    }

    public final String component9() {
        return this.temp1;
    }

    public final MaterialDetailTable copy(String id, String str, String str2, String str3, String str4, long j2, String str5, String str6, String str7, String str8, String str9, String str10) {
        s.h(id, "id");
        return new MaterialDetailTable(id, str, str2, str3, str4, j2, str5, str6, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MaterialDetailTable) {
            MaterialDetailTable materialDetailTable = (MaterialDetailTable) obj;
            return s.c(this.id, materialDetailTable.id) && s.c(this.namejson, materialDetailTable.namejson) && s.c(this.packageMd5, materialDetailTable.packageMd5) && s.c(this.subType, materialDetailTable.subType) && s.c(this.icon, materialDetailTable.icon) && this.sort == materialDetailTable.sort && s.c(this.displayMd5, materialDetailTable.displayMd5) && s.c(this.filterType, materialDetailTable.filterType) && s.c(this.temp1, materialDetailTable.temp1) && s.c(this.temp2, materialDetailTable.temp2) && s.c(this.temp3, materialDetailTable.temp3) && s.c(this.temp4, materialDetailTable.temp4);
        }
        return false;
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

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        String str = this.namejson;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.packageMd5;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.icon;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + defpackage.c.a(this.sort)) * 31;
        String str5 = this.displayMd5;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.filterType;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.temp1;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.temp2;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.temp3;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.temp4;
        return hashCode10 + (str10 != null ? str10.hashCode() : 0);
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

    public String toString() {
        return "MaterialDetailTable(id=" + this.id + ", namejson=" + ((Object) this.namejson) + ", packageMd5=" + ((Object) this.packageMd5) + ", subType=" + ((Object) this.subType) + ", icon=" + ((Object) this.icon) + ", sort=" + this.sort + ", displayMd5=" + ((Object) this.displayMd5) + ", filterType=" + ((Object) this.filterType) + ", temp1=" + ((Object) this.temp1) + ", temp2=" + ((Object) this.temp2) + ", temp3=" + ((Object) this.temp3) + ", temp4=" + ((Object) this.temp4) + ')';
    }

    public /* synthetic */ MaterialDetailTable(String str, String str2, String str3, String str4, String str5, long j2, String str6, String str7, String str8, String str9, String str10, String str11, int i2, o oVar) {
        this(str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? 0L : j2, (i2 & 64) != 0 ? "" : str6, (i2 & 128) != 0 ? "" : str7, (i2 & 256) != 0 ? "" : str8, (i2 & 512) != 0 ? "" : str9, (i2 & 1024) != 0 ? "" : str10, (i2 & 2048) == 0 ? str11 : "");
    }
}
