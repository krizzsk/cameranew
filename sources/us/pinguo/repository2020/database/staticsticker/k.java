package us.pinguo.repository2020.database.staticsticker;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: StickerTemplateCollectionTable.kt */
@Entity(tableName = "sticker_template_collection")
/* loaded from: classes6.dex */
public final class k {
    @PrimaryKey(autoGenerate = false)
    private String a;

    public k() {
        this(null, 1, null);
    }

    public k(String tid) {
        s.h(tid, "tid");
        this.a = tid;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && s.c(this.a, ((k) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "StickerTemplateCollectionTable(tid=" + this.a + ')';
    }

    public /* synthetic */ k(String str, int i2, o oVar) {
        this((i2 & 1) != 0 ? "" : str);
    }
}
