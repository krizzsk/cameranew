package us.pinguo.repository2020.database.staticsticker;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundBlurMaterialTable.kt */
@Entity(tableName = "background_blur_material")
/* loaded from: classes6.dex */
public final class BackgroundBlurMaterialTable implements NoProguard {
    @ColumnInfo
    private final String icon;
    @ColumnInfo
    private final String name;
    @PrimaryKey(autoGenerate = false)
    private final String pid;
    @ColumnInfo
    private final String shape;
    private final String sid;

    public BackgroundBlurMaterialTable(String pid, String str, String str2, String str3, String str4) {
        s.h(pid, "pid");
        this.pid = pid;
        this.sid = str;
        this.name = str2;
        this.icon = str3;
        this.shape = str4;
    }

    public static /* synthetic */ BackgroundBlurMaterialTable copy$default(BackgroundBlurMaterialTable backgroundBlurMaterialTable, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = backgroundBlurMaterialTable.pid;
        }
        if ((i2 & 2) != 0) {
            str2 = backgroundBlurMaterialTable.sid;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = backgroundBlurMaterialTable.name;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = backgroundBlurMaterialTable.icon;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = backgroundBlurMaterialTable.shape;
        }
        return backgroundBlurMaterialTable.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.pid;
    }

    public final String component2() {
        return this.sid;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.shape;
    }

    public final BackgroundBlurMaterialTable copy(String pid, String str, String str2, String str3, String str4) {
        s.h(pid, "pid");
        return new BackgroundBlurMaterialTable(pid, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackgroundBlurMaterialTable) {
            BackgroundBlurMaterialTable backgroundBlurMaterialTable = (BackgroundBlurMaterialTable) obj;
            return s.c(this.pid, backgroundBlurMaterialTable.pid) && s.c(this.sid, backgroundBlurMaterialTable.sid) && s.c(this.name, backgroundBlurMaterialTable.name) && s.c(this.icon, backgroundBlurMaterialTable.icon) && s.c(this.shape, backgroundBlurMaterialTable.shape);
        }
        return false;
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

    public final String getShape() {
        return this.shape;
    }

    public final String getSid() {
        return this.sid;
    }

    public int hashCode() {
        int hashCode = this.pid.hashCode() * 31;
        String str = this.sid;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.shape;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "BackgroundBlurMaterialTable(pid=" + this.pid + ", sid=" + ((Object) this.sid) + ", name=" + ((Object) this.name) + ", icon=" + ((Object) this.icon) + ", shape=" + ((Object) this.shape) + ')';
    }

    public /* synthetic */ BackgroundBlurMaterialTable(String str, String str2, String str3, String str4, String str5, int i2, o oVar) {
        this((i2 & 1) != 0 ? "" : str, str2, str3, str4, str5);
    }
}
