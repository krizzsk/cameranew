package us.pinguo.inspire.module.discovery.cell.topic;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.cell.recycler.f;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryRec;
import us.pinguo.inspire.module.discovery.type.DiscoverySquareCellType;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.widget.common.cell.recycler.DiffMode;
import us.pinguo.widget.common.cell.recycler.b;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryRecommendTopicCell extends b<DiscoveryRec, c> implements View.OnClickListener {
    private int mImageHeight;
    private int mImageWidth;

    public DiscoveryRecommendTopicCell(DiscoveryRec discoveryRec) {
        super(discoveryRec);
        int j2 = a.j(Inspire.a());
        this.mImageWidth = j2;
        this.mImageHeight = (int) ((j2 * 310.0d) / 710.0d);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rec_topic_cell, (ViewGroup) null);
        inflate.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-1, -2));
        return new c(inflate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public DiffMode getDiffMode() {
        return DiffMode.UNIQUE;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return DiscoverySquareCellType.REC_FULL_SPAN.ordinal();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) cVar.itemView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
        cVar.setText(R.id.tv_desc_rec_topic_cell, ((DiscoveryRec) this.mData).desc);
        f.e(cVar, R.id.piv_cover_rec_topic_cell, ((DiscoveryRec) this.mData).cover, this.mImageWidth, this.mImageHeight);
        cVar.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TextUtils.isEmpty(((DiscoveryRec) this.mData).gotoUrl)) {
            return;
        }
        AppGoto.getInstance().c(((DiscoveryRec) this.mData).gotoUrl).b(view.getContext());
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        VH vh = this.mViewHolder;
        if (vh != 0) {
            ((PhotoImageView) vh.getView(R.id.piv_cover_rec_topic_cell)).setImageBitmap(null);
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void reloadResource() {
        VH vh = this.mViewHolder;
        if (vh != 0) {
            f.c(vh, R.id.piv_cover_rec_topic_cell, ((DiscoveryRec) this.mData).cover);
        }
    }
}
