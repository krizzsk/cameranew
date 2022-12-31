package us.pinguo.inspire.module.feeds.cell;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.growingio.android.sdk.collection.GrowingIO;
import com.tencent.matrix.report.Issue;
import us.pinguo.inspire.module.feeds.FriendDynamicActivity;
import us.pinguo.inspire.module.feeds.model.InspireCompositeCnt;
import us.pinguo.inspire.module.feeds.view.MultiAvatarView;
import us.pinguo.inspire.widget.PhotoGridView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsCompositeCell extends us.pinguo.widget.common.cell.recycler.b<InspireCompositeCnt, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener, PhotoGridView.a {
    private String mContent;
    private String mFid;

    public FeedsCompositeCell(String str, InspireCompositeCnt inspireCompositeCnt) {
        super(inspireCompositeCnt);
        this.mFid = str;
    }

    private void setAvatars(us.pinguo.widget.common.cell.recycler.c cVar) {
        MultiAvatarView multiAvatarView = (MultiAvatarView) cVar.getView(R.id.feeds_dynamic_avatars);
        T t = this.mData;
        if (((InspireCompositeCnt) t).users != null && ((InspireCompositeCnt) t).users.size() != 0) {
            if (multiAvatarView.getVisibility() == 8) {
                multiAvatarView.setVisibility(0);
            }
        } else {
            multiAvatarView.setVisibility(8);
        }
        int size = ((InspireCompositeCnt) this.mData).users.size();
        PhotoGridView.b[] bVarArr = new PhotoGridView.b[size];
        for (int i2 = 0; i2 < size; i2++) {
            bVarArr[i2] = new PhotoGridView.b(0, 0, ((InspireCompositeCnt) this.mData).users.get(i2).avatar);
        }
        multiAvatarView.setPhotos(bVarArr);
    }

    private void setContent(us.pinguo.widget.common.cell.recycler.c cVar) {
        Context context = cVar.itemView.getContext();
        TextView textView = (TextView) cVar.getView(R.id.feeds_dynamic_content);
        if (this.mContent == null) {
            T t = this.mData;
            if (t != 0 && ((InspireCompositeCnt) t).users != null && ((InspireCompositeCnt) t).users.size() >= 1) {
                T t2 = this.mData;
                int i2 = ((InspireCompositeCnt) t2).upUserCount;
                this.mContent = String.format(context.getString(R.string.feeds_dynamic_content), ((InspireCompositeCnt) t2).users.get(0).nickname);
            } else {
                this.mContent = "";
            }
        }
        textView.setText(this.mContent);
    }

    private void setPhotos(us.pinguo.widget.common.cell.recycler.c cVar) {
        PhotoGridView photoGridView = (PhotoGridView) cVar.getView(R.id.feeds_dynamic_photo);
        T t = this.mData;
        if (((InspireCompositeCnt) t).works != null && ((InspireCompositeCnt) t).works.size() != 0) {
            if (photoGridView.getVisibility() != 0) {
                photoGridView.setVisibility(0);
            }
        } else {
            photoGridView.setVisibility(4);
        }
        int size = ((InspireCompositeCnt) this.mData).works.size();
        PhotoGridView.b[] bVarArr = new PhotoGridView.b[size];
        for (int i2 = 0; i2 < size; i2++) {
            InspireCompositeCnt.Work work = ((InspireCompositeCnt) this.mData).works.get(i2);
            if (work != null) {
                bVarArr[i2] = new PhotoGridView.b(work.width, work.height, work.murl, "video".equals(work.mtype));
            }
        }
        photoGridView.setPhotos(bVarArr, 100);
        photoGridView.forceLayout();
        photoGridView.setOnClickListener(this);
        photoGridView.setOnItemClick(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public boolean areItemsTheSame(us.pinguo.widget.common.cell.recycler.b bVar) {
        return bVar instanceof FeedsCompositeCell;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feeds_dynamic_layout, viewGroup, false);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        GrowingIO.setViewContent(inflate, this.mFid);
        return new us.pinguo.widget.common.cell.recycler.c(inflate);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 5;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        setAvatars(cVar);
        setContent(cVar);
        setPhotos(cVar);
        cVar.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mData != 0) {
            Intent intent = new Intent(view.getContext(), FriendDynamicActivity.class);
            intent.putExtra(Issue.ISSUE_REPORT_TIME, ((InspireCompositeCnt) this.mData).lastMfeedTime);
            view.getContext().startActivity(intent);
        }
    }

    @Override // us.pinguo.inspire.widget.PhotoGridView.a
    public void onItemClick(PhotoGridView photoGridView, int i2) {
        onClick(photoGridView);
    }
}
