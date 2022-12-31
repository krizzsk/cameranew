package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.tapjoy.TapjoyAuctionFlags;
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {TapjoyAuctionFlags.AUCTION_ID})})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class SystemIdInfo {
    @ColumnInfo(name = "system_id")
    public final int systemId;
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "work_spec_id")
    public final String workSpecId;

    public SystemIdInfo(@NonNull String str, int i2) {
        this.workSpecId = str;
        this.systemId = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        if (this.systemId != systemIdInfo.systemId) {
            return false;
        }
        return this.workSpecId.equals(systemIdInfo.workSpecId);
    }

    public int hashCode() {
        return (this.workSpecId.hashCode() * 31) + this.systemId;
    }
}
