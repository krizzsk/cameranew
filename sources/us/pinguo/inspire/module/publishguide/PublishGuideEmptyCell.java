package us.pinguo.inspire.module.publishguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.share.R;
import us.pinguo.user.recycler.c;
import us.pinguo.widget.common.cell.recycler.c;
/* loaded from: classes9.dex */
public class PublishGuideEmptyCell extends us.pinguo.widget.common.cell.recycler.b<PublishGuide2Fragment, c> implements c.b, View.OnClickListener {
    public PublishGuideEmptyCell(PublishGuide2Fragment publishGuide2Fragment) {
        super(publishGuide2Fragment);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.publish_guide_empty, viewGroup, false);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(viewGroup.getWidth(), viewGroup.getHeight()));
        return new us.pinguo.widget.common.cell.recycler.c(inflate);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 2;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        cVar.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((PublishGuide2Fragment) this.mData).onEmptyClick();
    }
}
