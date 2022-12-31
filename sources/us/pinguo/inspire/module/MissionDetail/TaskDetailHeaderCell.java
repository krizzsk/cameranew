package us.pinguo.inspire.module.MissionDetail;

import android.view.View;
import android.view.ViewGroup;
import us.pinguo.user.recycler.c;
import us.pinguo.widget.common.cell.recycler.DiffMode;
/* loaded from: classes9.dex */
public class TaskDetailHeaderCell extends us.pinguo.widget.common.cell.recycler.b<View, us.pinguo.widget.common.cell.recycler.c> implements c.b {
    public TaskDetailHeaderCell(View view) {
        super(view);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c((View) this.mData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public DiffMode getDiffMode() {
        return DiffMode.UNIQUE;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
    }
}
