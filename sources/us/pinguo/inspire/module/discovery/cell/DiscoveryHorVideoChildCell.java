package us.pinguo.inspire.module.discovery.cell;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.cell.recycler.f;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.MissionDetail.TaskDetailActivity;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryHorVideoChildCell extends us.pinguo.widget.common.cell.recycler.b<InspireWork, c> implements View.OnClickListener {
    private int mScreenWidth;
    private InspireTask mTask;

    public DiscoveryHorVideoChildCell(InspireTask inspireTask, InspireWork inspireWork) {
        super(inspireWork);
        this.mScreenWidth = us.pinguo.foundation.t.b.a.j(Inspire.a());
        this.mTask = inspireTask;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discovery_square_hor_video_child_cell, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        int i2 = this.mScreenWidth;
        f.b(cVar, R.id.piv_hor_video_child_cell, (int) (i2 * 0.28d), (int) (i2 * 0.47d));
        T t = this.mData;
        if (((InspireWork) t).workType == 1) {
            f.c(cVar, R.id.piv_hor_video_child_cell, ((InspireWork) t).getWorkUrl());
        } else if (((InspireWork) t).workType == 2) {
            f.g(cVar, R.id.piv_hor_video_child_cell, ((InspireWork) t).getWorkUrl());
        }
        cVar.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), TaskDetailActivity.class);
        intent.putExtra("task_id", this.mTask.taskId);
        view.getContext().startActivity(intent);
    }
}
