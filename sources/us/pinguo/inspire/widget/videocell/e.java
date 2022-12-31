package us.pinguo.inspire.widget.videocell;

import androidx.recyclerview.widget.RecyclerView;
/* compiled from: InspireVideoAdapter.java */
/* loaded from: classes9.dex */
public class e extends us.pinguo.user.recycler.c {
    private us.pinguo.inspire.b0.a mClickVideoListener;
    private boolean mDefaultSilent;
    private f mInspireVideoPresenter;
    private us.pinguo.inspire.b0.b videoLoadCompleteListener;

    @Override // us.pinguo.widget.common.cell.recycler.a
    public us.pinguo.widget.common.cell.recycler.b getItem(int i2) {
        us.pinguo.widget.common.cell.recycler.b item = super.getItem(i2);
        if (item instanceof d) {
            d dVar = (d) item;
            if (dVar.getVideoLoadCompleteListener() == null) {
                dVar.setVideoLoadCompleteListener(this.videoLoadCompleteListener);
            }
            if (dVar.getClickVideoListener() == null) {
                dVar.setClickVideoListener(this.mClickVideoListener);
            }
            dVar.setDefaultSilent(this.mDefaultSilent);
        }
        return item;
    }

    @Override // us.pinguo.widget.common.cell.recycler.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        super.onBindViewHolder(viewHolder, i2);
        us.pinguo.widget.common.cell.recycler.b item = getItem(i2);
        if (item instanceof d) {
            ((d) item).setPresenter(this.mInspireVideoPresenter);
        }
    }

    public void setClickVideoListener(us.pinguo.inspire.b0.a aVar) {
        this.mClickVideoListener = aVar;
    }

    public void setDefaultSilent(boolean z) {
        this.mDefaultSilent = z;
    }

    public void setInspireVideoPresenter(f fVar) {
        this.mInspireVideoPresenter = fVar;
    }

    public void setVideoLoadCompleteListener(us.pinguo.inspire.b0.b bVar) {
        this.videoLoadCompleteListener = bVar;
    }
}
