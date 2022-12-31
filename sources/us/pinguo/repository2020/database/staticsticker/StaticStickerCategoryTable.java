package us.pinguo.repository2020.database.staticsticker;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StaticStickerCategoryTable.kt */
@Entity(tableName = "downloaded_static_sticker_category")
/* loaded from: classes6.dex */
public final class StaticStickerCategoryTable implements NoProguard {
    private Integer completed;
    private final String icon;
    private final String name;
    @PrimaryKey(autoGenerate = false)
    private final String pid;
    private final String store_icon;
    private final Integer vip;

    public StaticStickerCategoryTable(String pid, String str, String str2, String str3, Integer num, Integer num2) {
        s.h(pid, "pid");
        this.pid = pid;
        this.name = str;
        this.icon = str2;
        this.store_icon = str3;
        this.vip = num;
        this.completed = num2;
    }

    public static /* synthetic */ StaticStickerCategoryTable copy$default(StaticStickerCategoryTable staticStickerCategoryTable, String str, String str2, String str3, String str4, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = staticStickerCategoryTable.pid;
        }
        if ((i2 & 2) != 0) {
            str2 = staticStickerCategoryTable.name;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = staticStickerCategoryTable.icon;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = staticStickerCategoryTable.store_icon;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            num = staticStickerCategoryTable.vip;
        }
        Integer num3 = num;
        if ((i2 & 32) != 0) {
            num2 = staticStickerCategoryTable.completed;
        }
        return staticStickerCategoryTable.copy(str, str5, str6, str7, num3, num2);
    }

    public final String component1() {
        return this.pid;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.store_icon;
    }

    public final Integer component5() {
        return this.vip;
    }

    public final Integer component6() {
        return this.completed;
    }

    public final StaticStickerCategoryTable copy(String pid, String str, String str2, String str3, Integer num, Integer num2) {
        s.h(pid, "pid");
        return new StaticStickerCategoryTable(pid, str, str2, str3, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StaticStickerCategoryTable) {
            StaticStickerCategoryTable staticStickerCategoryTable = (StaticStickerCategoryTable) obj;
            return s.c(this.pid, staticStickerCategoryTable.pid) && s.c(this.name, staticStickerCategoryTable.name) && s.c(this.icon, staticStickerCategoryTable.icon) && s.c(this.store_icon, staticStickerCategoryTable.store_icon) && s.c(this.vip, staticStickerCategoryTable.vip) && s.c(this.completed, staticStickerCategoryTable.completed);
        }
        return false;
    }

    public final Integer getCompleted() {
        return this.completed;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPid() {
        return this.pid;
    }

    public final String getStore_icon() {
        return this.store_icon;
    }

    public final Integer getVip() {
        return this.vip;
    }

    public int hashCode() {
        int hashCode = this.pid.hashCode() * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.icon;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.store_icon;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.vip;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.completed;
        return hashCode5 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setCompleted(Integer num) {
        this.completed = num;
    }

    public String toString() {
        return "StaticStickerCategoryTable(pid=" + this.pid + ", name=" + ((Object) this.name) + ", icon=" + ((Object) this.icon) + ", store_icon=" + ((Object) this.store_icon) + ", vip=" + this.vip + ", completed=" + this.completed + ')';
    }

    public /* synthetic */ StaticStickerCategoryTable(String str, String str2, String str3, String str4, Integer num, Integer num2, int i2, o oVar) {
        this((i2 & 1) != 0 ? "" : str, str2, str3, str4, num, num2);
    }
}
