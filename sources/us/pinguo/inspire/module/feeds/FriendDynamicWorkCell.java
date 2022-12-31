package us.pinguo.inspire.module.feeds;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.module.feeds.model.InspireCompositeCnt;
import us.pinguo.inspire.module.feeds.model.InspireFollowAndLikeDetail;
import us.pinguo.inspire.util.p;
import us.pinguo.inspire.widget.PhotoGridView;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FriendDynamicWorkCell extends us.pinguo.widget.common.cell.recycler.b<InspireFollowAndLikeDetail, us.pinguo.widget.common.cell.recycler.c> implements PhotoGridView.a {
    private CharSequence mTitle;

    public FriendDynamicWorkCell(InspireFollowAndLikeDetail inspireFollowAndLikeDetail) {
        super(inspireFollowAndLikeDetail);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.friend_dynamic_work_layout, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        T t = this.mData;
        if (t == 0) {
            return;
        }
        String str = ((InspireFollowAndLikeDetail) t).user == null ? "" : ((InspireFollowAndLikeDetail) t).user.avatar;
        PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.friend_dynamic_work_avatar);
        portraitImageView.setImageUri(str);
        T t2 = this.mData;
        portraitImageView.setUserId(((InspireFollowAndLikeDetail) t2).user != null ? ((InspireFollowAndLikeDetail) t2).user.userId : "");
        T t3 = this.mData;
        portraitImageView.setUserType(((InspireFollowAndLikeDetail) t3).user == null ? 0 : ((InspireFollowAndLikeDetail) t3).user.type);
        T t4 = this.mData;
        portraitImageView.setMark(((InspireFollowAndLikeDetail) t4).user != null ? ((InspireFollowAndLikeDetail) t4).user.mark : 0);
        setTitle(cVar);
        setPhotos(cVar);
    }

    @Override // us.pinguo.inspire.widget.PhotoGridView.a
    public void onItemClick(PhotoGridView photoGridView, int i2) {
        T t = this.mData;
        if (t == 0 || ((InspireFollowAndLikeDetail) t).likeList == null || ((InspireFollowAndLikeDetail) t).likeList.size() <= i2) {
            return;
        }
        FeedsList.enterDetailPage(photoGridView.getContext(), ((InspireFollowAndLikeDetail) this.mData).likeList.get(i2).mid, "", null, "from_unknown", this.mAdapter, this);
    }

    public void setPhotos(us.pinguo.widget.common.cell.recycler.c cVar) {
        PhotoGridView photoGridView = (PhotoGridView) cVar.getView(R.id.friend_dynamic_work_photo);
        T t = this.mData;
        if (((InspireFollowAndLikeDetail) t).likeList != null && ((InspireFollowAndLikeDetail) t).likeList.size() != 0) {
            if (photoGridView.getVisibility() != 0) {
                photoGridView.setVisibility(0);
            }
            T t2 = this.mData;
            int size = ((InspireFollowAndLikeDetail) t2).likeList == null ? 0 : ((InspireFollowAndLikeDetail) t2).likeList.size();
            PhotoGridView.b[] bVarArr = new PhotoGridView.b[size];
            for (int i2 = 0; i2 < size; i2++) {
                InspireCompositeCnt.Work work = ((InspireFollowAndLikeDetail) this.mData).likeList.get(i2);
                if (work != null) {
                    bVarArr[i2] = new PhotoGridView.b(work.width, work.height, work.murl);
                    bVarArr[i2].f11336d = "video".equals(work.mtype);
                }
            }
            if (size > 0) {
                if (photoGridView.getVisibility() != 0) {
                    photoGridView.setVisibility(0);
                }
                photoGridView.setPhotos(bVarArr);
                photoGridView.forceLayout();
            } else {
                photoGridView.setVisibility(4);
            }
            photoGridView.setOnItemClick(this);
            return;
        }
        photoGridView.setVisibility(4);
    }

    public void setTitle(us.pinguo.widget.common.cell.recycler.c cVar) {
        TextView textView = (TextView) cVar.getView(R.id.friend_dynamic_work_title);
        TextView textView2 = (TextView) cVar.getView(R.id.friend_dynamic_work_desc);
        T t = this.mData;
        String str = ((InspireFollowAndLikeDetail) t).user == null ? "" : ((InspireFollowAndLikeDetail) t).user.nickname;
        textView.setText(str != null ? str : "");
        String f2 = p.f(textView2.getContext(), ((InspireFollowAndLikeDetail) this.mData).timeline * 1000, System.currentTimeMillis());
        T t2 = this.mData;
        String format = String.format(textView2.getResources().getString(R.string.feeds_detail_like_num), Integer.valueOf(((InspireFollowAndLikeDetail) t2).likeList == null ? 0 : ((InspireFollowAndLikeDetail) t2).likeList.size()));
        textView2.setText(f2 + " / " + format);
    }
}
