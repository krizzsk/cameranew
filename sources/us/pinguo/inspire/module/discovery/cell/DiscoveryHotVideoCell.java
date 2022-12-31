package us.pinguo.inspire.module.discovery.cell;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryFixedItem;
import us.pinguo.inspire.module.discovery.fragment.DiscoveryHotVideoFragment;
import us.pinguo.inspire.module.discovery.type.DiscoverySquareCellType;
import us.pinguo.inspire.widget.videocell.InspireVideoView;
import us.pinguo.inspire.widget.videocell.d;
import us.pinguo.widget.common.cell.recycler.DiffMode;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryHotVideoCell extends d<DiscoveryFixedItem, c> {
    private static final float RATE = 0.75f;
    private int mHeight;
    private int mScreenWidth;
    private View.OnClickListener onClickListener;

    public DiscoveryHotVideoCell(DiscoveryFixedItem discoveryFixedItem) {
        super(discoveryFixedItem);
        int j2 = us.pinguo.foundation.t.b.a.j(Inspire.a());
        this.mScreenWidth = j2;
        this.mHeight = (int) (j2 * 0.75f);
        this.onClickListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryHotVideoCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), InspireContentActivity.class);
                intent.putExtra(InspireContentActivity.FRAGMENT_NAME, DiscoveryHotVideoFragment.class.getName());
                intent.putExtra("KEY_TITLE", ((DiscoveryFixedItem) ((us.pinguo.widget.common.cell.recycler.b) DiscoveryHotVideoCell.this).mData).title);
                intent.putExtra(DiscoveryHotVideoFragment.WORK_ID, ((DiscoveryFixedItem) ((us.pinguo.widget.common.cell.recycler.b) DiscoveryHotVideoCell.this).mData).vid);
                view.getContext().startActivity(intent);
                l.onEvent(view.getContext(), "Community_Portal_SelectedVideo_Click");
            }
        };
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discovery_square_hot_video_cell, viewGroup, false);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(this.mScreenWidth, this.mHeight));
        return new c(inflate);
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    protected d.b getContainerSize() {
        d.b bVar = new d.b();
        bVar.a = this.mScreenWidth;
        bVar.b = this.mHeight;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public DiffMode getDiffMode() {
        return DiffMode.UNIQUE;
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    public InspireVideoView getInspireVideoView() {
        VH vh = this.mViewHolder;
        if (vh != 0) {
            return (InspireVideoView) vh.getView(R.id.ivv_cell_hot_video);
        }
        return null;
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    protected d.b getMayBeVideoSize() {
        d.b bVar = new d.b();
        T t = this.mData;
        int i2 = ((DiscoveryFixedItem) t).width == 0 ? this.mScreenWidth : ((DiscoveryFixedItem) t).width;
        bVar.a = i2;
        int i3 = ((DiscoveryFixedItem) t).height == 0 ? this.mHeight : ((DiscoveryFixedItem) t).height;
        bVar.b = i3;
        float f2 = (i3 * 1.0f) / i2;
        d.b bVar2 = new d.b();
        if (f2 >= 0.75f) {
            int i4 = this.mScreenWidth;
            bVar2.a = i4;
            bVar2.b = (int) (i4 * f2);
        } else {
            int i5 = this.mHeight;
            bVar2.b = i5;
            bVar2.a = (int) (i5 / f2);
        }
        return bVar2;
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.inspire.cell.recycler.a
    protected String getShowKey() {
        return "Community_Portal_Feed_Show";
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return DiscoverySquareCellType.HOT_VIDEO.ordinal();
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    public String getVideoUrl() {
        return ((DiscoveryFixedItem) this.mData).cover;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.videocell.d
    public InspireVideoView getVideoView(c cVar) {
        if (cVar != null) {
            return (InspireVideoView) cVar.getView(R.id.ivv_cell_hot_video);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.videocell.d
    public d.b getViewSize() {
        d.b bVar = new d.b();
        T t = this.mData;
        bVar.a = ((DiscoveryFixedItem) t).width;
        bVar.b = ((DiscoveryFixedItem) t).height;
        return bVar;
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    protected void onBindOtherView(c cVar) {
        cVar.setText(R.id.tv_title_cell_hot_video, ((DiscoveryFixedItem) this.mData).title);
        cVar.setText(R.id.tv_content_cell_hot_video, ((DiscoveryFixedItem) this.mData).desc);
        cVar.itemView.setOnClickListener(this.onClickListener);
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    public void onVideoPrepared() {
        FrameLayout frameLayout;
        super.onVideoPrepared();
        VH vh = this.mViewHolder;
        if (vh == 0 || (frameLayout = (FrameLayout) vh.getView(R.id.fl_loading_square_hot_video_cell)) == null) {
            return;
        }
        frameLayout.clearAnimation();
        frameLayout.setBackgroundResource(R.drawable.video_loaded);
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    public void onVideoStart() {
        InspireVideoView videoView = getVideoView(this.mViewHolder);
        if (videoView == null || this.mViewHolder == 0) {
            return;
        }
        videoView.b().a(true);
        videoView.k();
        FrameLayout frameLayout = (FrameLayout) this.mViewHolder.getView(R.id.fl_loading_square_hot_video_cell);
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(R.drawable.video_loading);
            frameLayout.startAnimation(AnimationUtils.loadAnimation(frameLayout.getContext(), R.anim.loading_video));
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        super.releaseResource();
    }
}
