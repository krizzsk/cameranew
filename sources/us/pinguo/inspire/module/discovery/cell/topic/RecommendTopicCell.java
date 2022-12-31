package us.pinguo.inspire.module.discovery.cell.topic;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.statistics.PageStack;
import us.pinguo.foundation.statistics.l;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.cell.recycler.f;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryRec;
import us.pinguo.widget.common.cell.recycler.b;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class RecommendTopicCell extends b<DiscoveryRec, c> implements View.OnClickListener {
    private int mImageHeight;
    private int mImageWidth;

    public RecommendTopicCell(DiscoveryRec discoveryRec) {
        super(discoveryRec);
        int j2 = a.j(Inspire.a()) - a.a(Inspire.a(), 10.0f);
        this.mImageWidth = j2;
        this.mImageHeight = (int) (j2 * 0.45d);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.rec_topic_cell, viewGroup);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        cVar.setText(R.id.tv_desc_rec_topic_cell, ((DiscoveryRec) this.mData).desc);
        f.e(cVar, R.id.piv_cover_rec_topic_cell, ((DiscoveryRec) this.mData).cover, this.mImageWidth, this.mImageHeight);
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
