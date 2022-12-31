package us.pinguo.inspire.module.comment.cell;

import android.view.View;
import android.view.ViewGroup;
import us.pinguo.inspire.model.InspireWork;
/* compiled from: IdInfoCell.kt */
/* loaded from: classes9.dex */
public final class IdInfoCell extends BaseInfoCell {
    private final String mWorkId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdInfoCell(InspireWork data, String workId) {
        super(data);
        kotlin.jvm.internal.s.h(data, "data");
        kotlin.jvm.internal.s.h(workId, "workId");
        this.mWorkId = workId;
    }

    @Override // us.pinguo.inspire.y.a.b
    public us.pinguo.inspire.y.a.c createViewHolder(ViewGroup parent) {
        kotlin.jvm.internal.s.h(parent, "parent");
        return new us.pinguo.inspire.y.a.c(new View(parent.getContext()));
    }

    public final String getMWorkId() {
        return this.mWorkId;
    }

    @Override // us.pinguo.inspire.y.a.b
    public int getType() {
        return BaseInfoCell.Companion.getTYPE_WORKID();
    }

    @Override // us.pinguo.inspire.module.comment.cell.BaseInfoCell
    public boolean isContentPreparedForShare() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.module.comment.cell.BaseInfoCell, us.pinguo.inspire.y.a.b
    public void onBindViewHolder(us.pinguo.inspire.y.a.c viewHolder) {
        kotlin.jvm.internal.s.h(viewHolder, "viewHolder");
    }
}
