package us.pinguo.inspire.module.discovery.cell.hotvideo;

import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.collection.GrowingIO;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.entity.dicovery.AuthorInfo;
import us.pinguo.inspire.widget.like.LikeImageView;
import us.pinguo.inspire.widget.videocell.InspireVideoView;
import us.pinguo.inspire.widget.videocell.d;
import us.pinguo.widet.PortraitImageView;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class HotVideoCell extends d<InspireWork, c> implements IFilterColorCell, IHeaderCell, View.OnClickListener {
    private final InspireWork mNextWork;

    public HotVideoCell(InspireWork inspireWork, InspireWork inspireWork2) {
        super(inspireWork);
        this.mNextWork = inspireWork2;
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.hot_video_cell, viewGroup);
    }

    @Override // us.pinguo.inspire.module.discovery.cell.hotvideo.IFilterColorCell
    public void filterColor(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.mViewHolder.getView(R.id.fl_alpha_hot_video_cell).setBackgroundColor((((int) ((f2 * 255.0f) * 0.9d)) << 24) | 1119512);
    }

    @Override // us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    public String getVideoUrl() {
        return ((InspireWork) this.mData).getWorkUrl();
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    public InspireVideoView getVideoView(c cVar) {
        if (cVar != null) {
            return (InspireVideoView) cVar.getView(R.id.ivv_hot_video_cell);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.videocell.d
    public d.b getViewSize() {
        d.b bVar = new d.b();
        T t = this.mData;
        bVar.a = ((InspireWork) t).width;
        bVar.b = ((InspireWork) t).height;
        return bVar;
    }

    @Override // us.pinguo.inspire.module.discovery.cell.hotvideo.IHeaderCell
    public void hideHeader() {
        this.mViewHolder.hide(R.id.ll_header_hot_video_cell);
    }

    @Override // us.pinguo.inspire.widget.videocell.d
    protected void onBindOtherView(c cVar) {
        GrowingIO.setViewContent(cVar.itemView, ((InspireWork) this.mData).workId);
        cVar.hide(R.id.ll_header_hot_video_cell);
        cVar.itemView.setOnClickListener(this);
        PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.piv_portrait_hot_video_cell);
        portraitImageView.setImageResource(us.pinguo.ui.R.drawable.default_avatar);
        portraitImageView.setUserType(0);
        portraitImageView.setMark(0);
        InspireWork inspireWork = this.mNextWork;
        if (inspireWork != null) {
            cVar.setText(R.id.tv_name_hot_video_cell, inspireWork.getNickName());
            portraitImageView.setUserId(this.mNextWork.authorId);
            AuthorInfo authorInfo = this.mNextWork.authorInfo;
            if (authorInfo != null) {
                portraitImageView.setUserType(authorInfo.type);
                portraitImageView.setMark(this.mNextWork.authorInfo.mark);
            }
            portraitImageView.setImageUri(this.mNextWork.getAvatar());
            InspireWork inspireWork2 = this.mNextWork;
            ((LikeImageView) cVar.getView(R.id.liv_like_hot_video_cell)).l(inspireWork2, inspireWork2.workId, this);
        }
        cVar.setOnClickListener(R.id.ll_header_hot_video_cell, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // us.pinguo.inspire.module.discovery.cell.hotvideo.IHeaderCell
    public void showHeader() {
        this.mViewHolder.show(R.id.ll_header_hot_video_cell);
    }
}
