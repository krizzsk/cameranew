package us.pinguo.repository2020.database.sticker;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerDbTableDef.kt */
@Entity(tableName = "stickerItem")
/* loaded from: classes6.dex */
public final class StickerItemTable implements NoProguard {
    @PrimaryKey(autoGenerate = true)
    private int _aid;
    @ColumnInfo
    private Long collectTime;
    @ColumnInfo(defaultValue = "0")
    private Integer hasMusic;
    @ColumnInfo
    private String icon;
    @ColumnInfo
    private String id;
    @ColumnInfo(defaultValue = "0")
    private Integer isCollect;
    @ColumnInfo
    private String namejson;
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
    @ColumnInfo(defaultValue = "ut")
    private String type;

    public StickerItemTable() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public StickerItemTable(int i2, String str, String str2, String str3, Integer num, String str4, String str5, Integer num2, Long l2, Integer num3, String str6, String str7, String str8, String str9, String str10) {
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
        this.type = str6;
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

    public final String component11() {
        return this.type;
    }

    public final String component12() {
        return this.temp1;
    }

    public final String component13() {
        return this.temp2;
    }

    public final String component14() {
        return this.temp3;
    }

    public final String component15() {
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

    public final StickerItemTable copy(int i2, String str, String str2, String str3, Integer num, String str4, String str5, Integer num2, Long l2, Integer num3, String str6, String str7, String str8, String str9, String str10) {
        return new StickerItemTable(i2, str, str2, str3, num, str4, str5, num2, l2, num3, str6, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerItemTable) {
            StickerItemTable stickerItemTable = (StickerItemTable) obj;
            return this._aid == stickerItemTable._aid && s.c(this.id, stickerItemTable.id) && s.c(this.namejson, stickerItemTable.namejson) && s.c(this.icon, stickerItemTable.icon) && s.c(this.sortInPackage, stickerItemTable.sortInPackage) && s.c(this.packageId, stickerItemTable.packageId) && s.c(this.packageMd5, stickerItemTable.packageMd5) && s.c(this.isCollect, stickerItemTable.isCollect) && s.c(this.collectTime, stickerItemTable.collectTime) && s.c(this.hasMusic, stickerItemTable.hasMusic) && s.c(this.type, stickerItemTable.type) && s.c(this.temp1, stickerItemTable.temp1) && s.c(this.temp2, stickerItemTable.temp2) && s.c(this.temp3, stickerItemTable.temp3) && s.c(this.temp4, stickerItemTable.temp4);
        }
        return false;
    }

    public final Long getCollectTime() {
        return this.collectTime;
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
        int hashCode9 = (hashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str6 = this.type;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.temp1;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.temp2;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.temp3;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.temp4;
        return hashCode13 + (str10 != null ? str10.hashCode() : 0);
    }

    public final Integer isCollect() {
        return this.isCollect;
    }

    public final void setCollect(Integer num) {
        this.isCollect = num;
    }

    public final void setCollectTime(Long l2) {
        this.collectTime = l2;
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

    public final void set_aid(int i2) {
        this._aid = i2;
    }

    public String toString() {
        return "StickerItemTable(_aid=" + this._aid + ", id=" + ((Object) this.id) + ", namejson=" + ((Object) this.namejson) + ", icon=" + ((Object) this.icon) + ", sortInPackage=" + this.sortInPackage + ", packageId=" + ((Object) this.packageId) + ", packageMd5=" + ((Object) this.packageMd5) + ", isCollect=" + this.isCollect + ", collectTime=" + this.collectTime + ", hasMusic=" + this.hasMusic + ", type=" + ((Object) this.type) + ", temp1=" + ((Object) this.temp1) + ", temp2=" + ((Object) this.temp2) + ", temp3=" + ((Object) this.temp3) + ", temp4=" + ((Object) this.temp4) + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ StickerItemTable(int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Integer r21, java.lang.String r22, java.lang.String r23, java.lang.Integer r24, java.lang.Long r25, java.lang.Integer r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, int r32, kotlin.jvm.internal.o r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            if (r1 == 0) goto Lc
            goto Le
        Lc:
            r2 = r17
        Le:
            r1 = r0 & 2
            r4 = 0
            if (r1 == 0) goto L15
            r1 = r4
            goto L17
        L15:
            r1 = r18
        L17:
            r5 = r0 & 4
            if (r5 == 0) goto L1d
            r5 = r4
            goto L1f
        L1d:
            r5 = r19
        L1f:
            r6 = r0 & 8
            if (r6 == 0) goto L25
            r6 = r4
            goto L27
        L25:
            r6 = r20
        L27:
            r7 = r0 & 16
            if (r7 == 0) goto L2d
            r7 = r3
            goto L2f
        L2d:
            r7 = r21
        L2f:
            r8 = r0 & 32
            if (r8 == 0) goto L35
            r8 = r4
            goto L37
        L35:
            r8 = r22
        L37:
            r9 = r0 & 64
            if (r9 == 0) goto L3d
            r9 = r4
            goto L3f
        L3d:
            r9 = r23
        L3f:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L45
            r10 = r3
            goto L47
        L45:
            r10 = r24
        L47:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L52
            r11 = 0
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            goto L54
        L52:
            r11 = r25
        L54:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L59
            goto L5b
        L59:
            r3 = r26
        L5b:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L62
            java.lang.String r12 = "ut"
            goto L64
        L62:
            r12 = r27
        L64:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L6a
            r13 = r4
            goto L6c
        L6a:
            r13 = r28
        L6c:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L72
            r14 = r4
            goto L74
        L72:
            r14 = r29
        L74:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L7a
            r15 = r4
            goto L7c
        L7a:
            r15 = r30
        L7c:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L81
            goto L83
        L81:
            r4 = r31
        L83:
            r17 = r16
            r18 = r2
            r19 = r1
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r3
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r15
            r32 = r4
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerItemTable.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Long, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.o):void");
    }
}
