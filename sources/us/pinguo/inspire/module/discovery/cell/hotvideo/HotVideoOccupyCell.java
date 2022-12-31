package us.pinguo.inspire.module.discovery.cell.hotvideo;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.cell.recycler.e;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.widget.like.LikeImageView;
import us.pinguo.widet.PortraitImageView;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class HotVideoOccupyCell extends e<InspireWork, c> {
    private int mHeight;
    private int mScreenWidth;

    public HotVideoOccupyCell(InspireWork inspireWork) {
        super(inspireWork);
        int j2 = a.j(Inspire.a());
        this.mScreenWidth = j2;
        this.mHeight = (int) (j2 * 0.75f);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.hot_video_occupy_cell, viewGroup);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        cVar.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, this.mHeight));
        cVar.getView(R.id.fl_alpha_hot_video_occupy_cell).setBackgroundColor(cVar.itemView.getResources().getColor(R.color.video_bg));
        if (this.mData != 0) {
            cVar.show(R.id.ll_header_hot_video_occupy_cell);
            cVar.setText(R.id.tv_name_hot_video_occupy_cell, ((InspireWork) this.mData).getNickName());
            PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.piv_portrait_hot_video_occupy_cell);
            portraitImageView.setImageResource(us.pinguo.ui.R.drawable.default_avatar);
            portraitImageView.setUserId(((InspireWork) this.mData).authorId);
            T t = this.mData;
            if (((InspireWork) t).authorInfo != null) {
                portraitImageView.setUserType(((InspireWork) t).authorInfo.type);
                portraitImageView.setMark(((InspireWork) this.mData).authorInfo.mark);
            } else {
                portraitImageView.setUserType(0);
                portraitImageView.setMark(0);
            }
            portraitImageView.setImageUri(((InspireWork) this.mData).getAvatar());
            T t2 = this.mData;
            ((LikeImageView) cVar.getView(R.id.liv_like_hot_video_occupy_cell)).l((us.pinguo.inspire.widget.like.a) t2, ((InspireWork) t2).workId, this);
            return;
        }
        cVar.hide(R.id.ll_header_hot_video_occupy_cell);
    }
}
