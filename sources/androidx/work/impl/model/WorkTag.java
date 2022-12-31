package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.matrix.report.Issue;
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {TapjoyAuctionFlags.AUCTION_ID})}, indices = {@Index({"work_spec_id"})}, primaryKeys = {Issue.ISSUE_REPORT_TAG, "work_spec_id"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class WorkTag {
    @NonNull
    @ColumnInfo(name = Issue.ISSUE_REPORT_TAG)
    public final String tag;
    @NonNull
    @ColumnInfo(name = "work_spec_id")
    public final String workSpecId;

    public WorkTag(@NonNull String str, @NonNull String str2) {
        this.tag = str;
        this.workSpecId = str2;
    }
}
