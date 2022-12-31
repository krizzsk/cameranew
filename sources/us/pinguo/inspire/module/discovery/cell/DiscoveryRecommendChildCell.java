package us.pinguo.inspire.module.discovery.cell;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.statistics.PageStack;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.cell.recycler.f;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryRec;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryRecommendChildCell extends us.pinguo.widget.common.cell.recycler.b<DiscoveryRec, c> implements View.OnClickListener {
    private int mScreenWidth;

    public DiscoveryRecommendChildCell(DiscoveryRec discoveryRec) {
        super(discoveryRec);
        this.mScreenWidth = us.pinguo.foundation.t.b.a.j(Inspire.a());
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discovery_square_recommend_child_cell, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        int i2 = this.mScreenWidth;
        f.b(cVar, R.id.piv_recommend_cell, (int) (i2 * 0.637d), (int) (i2 * 0.373d));
        f.c(cVar, R.id.piv_recommend_cell, ((DiscoveryRec) this.mData).cover);
        cVar.setText(R.id.tv_desc_recommend_cell, ((DiscoveryRec) this.mData).desc);
        cVar.itemView.setOnClickListener(this);
        Context context = cVar.itemView.getContext();
        l.onEvent(context, "Community_Discovery_SelectedTopic_Show", "topic_id=" + ((DiscoveryRec) this.mData).recId + ",src=" + PageStack.getInstance().e());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context = view.getContext();
        l.onEvent(context, "Community_Discovery_SelectedTopic_Click", "topic_id=" + ((DiscoveryRec) this.mData).recId + ",src=" + PageStack.getInstance().e());
        if (TextUtils.isEmpty(((DiscoveryRec) this.mData).gotoUrl)) {
            return;
        }
        AppGoto.getInstance().c(((DiscoveryRec) this.mData).gotoUrl).b(view.getContext());
    }
}
