package us.pinguo.repository2020.database.staticsticker;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StaticStickerTable.kt */
@Entity(tableName = "downloaded_static_sticker")
/* loaded from: classes6.dex */
public final class StaticStickerTable implements NoProguard {
    @ColumnInfo
    private final String display_md5;
    @ColumnInfo
    private final String down_url;
    @ColumnInfo
    private final int fromTemplate;
    @ColumnInfo
    private final String icon;
    @ColumnInfo
    private final String name;
    @PrimaryKey(autoGenerate = false)
    private final String sid;
    @ColumnInfo
    private final String tags;

    public StaticStickerTable(String sid, String str, String str2, String str3, String str4, String str5, int i2) {
        s.h(sid, "sid");
        this.sid = sid;
        this.name = str;
        this.icon = str2;
        this.tags = str3;
        this.display_md5 = str4;
        this.down_url = str5;
        this.fromTemplate = i2;
    }

    public static /* synthetic */ StaticStickerTable copy$default(StaticStickerTable staticStickerTable, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = staticStickerTable.sid;
        }
        if ((i3 & 2) != 0) {
            str2 = staticStickerTable.name;
        }
        String str7 = str2;
        if ((i3 & 4) != 0) {
            str3 = staticStickerTable.icon;
        }
        String str8 = str3;
        if ((i3 & 8) != 0) {
            str4 = staticStickerTable.tags;
        }
        String str9 = str4;
        if ((i3 & 16) != 0) {
            str5 = staticStickerTable.display_md5;
        }
        String str10 = str5;
        if ((i3 & 32) != 0) {
            str6 = staticStickerTable.down_url;
        }
        String str11 = str6;
        if ((i3 & 64) != 0) {
            i2 = staticStickerTable.fromTemplate;
        }
        return staticStickerTable.copy(str, str7, str8, str9, str10, str11, i2);
    }

    public final String component1() {
        return this.sid;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.tags;
    }

    public final String component5() {
        return this.display_md5;
    }

    public final String component6() {
        return this.down_url;
    }

    public final int component7() {
        return this.fromTemplate;
    }

    public final StaticStickerTable copy(String sid, String str, String str2, String str3, String str4, String str5, int i2) {
        s.h(sid, "sid");
        return new StaticStickerTable(sid, str, str2, str3, str4, str5, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StaticStickerTable) {
            StaticStickerTable staticStickerTable = (StaticStickerTable) obj;
            return s.c(this.sid, staticStickerTable.sid) && s.c(this.name, staticStickerTable.name) && s.c(this.icon, staticStickerTable.icon) && s.c(this.tags, staticStickerTable.tags) && s.c(this.display_md5, staticStickerTable.display_md5) && s.c(this.down_url, staticStickerTable.down_url) && this.fromTemplate == staticStickerTable.fromTemplate;
        }
        return false;
    }

    public final String getDisplay_md5() {
        return this.display_md5;
    }

    public final String getDown_url() {
        return this.down_url;
    }

    public final int getFromTemplate() {
        return this.fromTemplate;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getTags() {
        return this.tags;
    }

    public int hashCode() {
        int hashCode = this.sid.hashCode() * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.icon;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.tags;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.display_md5;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.down_url;
        return ((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.fromTemplate;
    }

    public String toString() {
        return "StaticStickerTable(sid=" + this.sid + ", name=" + ((Object) this.name) + ", icon=" + ((Object) this.icon) + ", tags=" + ((Object) this.tags) + ", display_md5=" + ((Object) this.display_md5) + ", down_url=" + ((Object) this.down_url) + ", fromTemplate=" + this.fromTemplate + ')';
    }

    public /* synthetic */ StaticStickerTable(String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, o oVar) {
        this((i3 & 1) != 0 ? "" : str, str2, str3, str4, str5, str6, i2);
    }
}
