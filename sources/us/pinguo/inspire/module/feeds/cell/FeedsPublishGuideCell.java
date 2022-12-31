package us.pinguo.inspire.module.feeds.cell;

import android.app.Activity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import us.pinguo.foundation.domain.PublishMediaItem;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.feeds.PublishManager;
import us.pinguo.inspire.module.feeds.view.FeedsPublishGridView;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.util.p;
import us.pinguo.inspire.widget.PhotoGridView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsPublishGuideCell extends us.pinguo.widget.common.cell.recycler.b<ArrayList<PublishMediaItem>, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener, PhotoGridView.a {
    private static final int MAX_COUNT = 9;
    private OnCloseListener mOnCloseListener;
    private TreeSet<Integer> mSelectedSet;

    /* loaded from: classes9.dex */
    public interface OnCloseListener {
        void onClose(FeedsPublishGuideCell feedsPublishGuideCell);
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [T, java.util.ArrayList] */
    public FeedsPublishGuideCell(ArrayList<PublishMediaItem> arrayList) {
        super(new ArrayList(arrayList));
        this.mSelectedSet = new TreeSet<>();
        if (((ArrayList) this.mData).size() > 9) {
            this.mData = new ArrayList(((ArrayList) this.mData).subList(0, 9));
        }
        for (int i2 = 0; i2 < ((ArrayList) this.mData).size(); i2++) {
            this.mSelectedSet.add(Integer.valueOf(i2));
        }
    }

    private PhotoGridView.b[] getPhotos() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 9 && i2 < ((ArrayList) this.mData).size(); i2++) {
            PublishMediaItem publishMediaItem = (PublishMediaItem) ((ArrayList) this.mData).get(i2);
            int i3 = publishMediaItem.rotation;
            int i4 = (i3 == 90 || i3 == 270) ? publishMediaItem.height : publishMediaItem.width;
            int i5 = (i3 == 90 || i3 == 270) ? publishMediaItem.width : publishMediaItem.height;
            arrayList.add(new PhotoGridView.b(i4, i5, InspirePublishFragment.FILE_HEADER + publishMediaItem.filePath));
        }
        PhotoGridView.b[] bVarArr = new PhotoGridView.b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return bVarArr;
    }

    private void publishPics(View view) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.mSelectedSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((PublishMediaItem) ((ArrayList) this.mData).get(it.next().intValue())).filePath);
        }
        PublishManager.launchPublishPageFromPortal((Activity) view.getContext(), arrayList, null, new PublishManager.PublishCompleteLister() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsPublishGuideCell.2
            @Override // us.pinguo.inspire.module.feeds.PublishManager.PublishCompleteLister
            public void onPublishCancel() {
            }

            @Override // us.pinguo.inspire.module.feeds.PublishManager.PublishCompleteLister
            public void onPublishComplete(String str) {
                if (FeedsPublishGuideCell.this.mOnCloseListener != null) {
                    FeedsPublishGuideCell.this.mOnCloseListener.onClose(FeedsPublishGuideCell.this);
                }
            }
        });
    }

    private void setSelectCount(us.pinguo.widget.common.cell.recycler.c cVar) {
        if (cVar == null) {
            return;
        }
        T t = this.mData;
        int size = t == 0 ? 0 : ((ArrayList) t).size();
        if (size > 9) {
            size = 9;
        }
        String valueOf = String.valueOf(this.mSelectedSet.size());
        String string = cVar.itemView.getResources().getString(R.string.publish_guide_seleted);
        String format = String.format(string, Integer.valueOf(this.mSelectedSet.size()), Integer.valueOf(size));
        int indexOf = string.indexOf("%1$d");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(cVar.itemView.getResources().getColor(us.pinguo.ui.R.color.color_highlight));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(foregroundColorSpan, indexOf, valueOf.length() + indexOf, 33);
        cVar.setText(R.id.feeds_publish_guide_selected, spannableString);
        View view = cVar.getView(R.id.feeds_publish_guide_publish);
        if (this.mSelectedSet.size() > 0) {
            view.setEnabled(true);
        } else {
            view.setEnabled(false);
        }
        FeedsPublishGridView feedsPublishGridView = (FeedsPublishGridView) cVar.getView(R.id.feeds_publish_guide_photos);
        for (int i2 = 0; i2 < ((ArrayList) this.mData).size(); i2++) {
            feedsPublishGridView.setSelect(i2, this.mSelectedSet.contains(Integer.valueOf(i2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public boolean areItemsTheSame(us.pinguo.widget.common.cell.recycler.b bVar) {
        return bVar instanceof FeedsPublishGuideCell;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feeds_publish_guide_cell, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 15;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        cVar.setText(R.id.feeds_publish_guide_loc, p.e(cVar.itemView.getContext(), ((PublishMediaItem) ((ArrayList) this.mData).get(0)).createTime, System.currentTimeMillis()));
        cVar.setOnClickListener(R.id.feeds_publish_guide_publish, this);
        cVar.setOnClickListener(R.id.feeds_publish_guide_close, this);
        cVar.setOnClickListener(R.id.feeds_publish_guide_avatar, this);
        FeedsPublishGridView feedsPublishGridView = (FeedsPublishGridView) cVar.getView(R.id.feeds_publish_guide_photos);
        feedsPublishGridView.setPhotos(getPhotos());
        feedsPublishGridView.setOnItemClick(this);
        setSelectCount(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.feeds_publish_guide_publish) {
            if (this.mSelectedSet.size() > 0) {
                publishPics(view);
                us.pinguo.librouter.c.d.b().getInterface().a().recordClosedTime();
                view.post(new Runnable() { // from class: us.pinguo.inspire.module.feeds.cell.FeedsPublishGuideCell.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FeedsPublishGuideCell.this.mOnCloseListener != null) {
                            FeedsPublishGuideCell.this.mOnCloseListener.onClose(FeedsPublishGuideCell.this);
                        }
                    }
                });
            }
            l.onEvent(view.getContext(), "community_latestphoto_click");
        } else if (view.getId() == R.id.feeds_publish_guide_close) {
            us.pinguo.librouter.c.d.b().getInterface().a().recordClosedTime();
            OnCloseListener onCloseListener = this.mOnCloseListener;
            if (onCloseListener != null) {
                onCloseListener.onClose(this);
            }
        }
    }

    @Override // us.pinguo.inspire.widget.PhotoGridView.a
    public void onItemClick(PhotoGridView photoGridView, int i2) {
        FeedsPublishGridView feedsPublishGridView = (FeedsPublishGridView) photoGridView;
        if (feedsPublishGridView.getSelect(i2)) {
            this.mSelectedSet.remove(Integer.valueOf(i2));
            feedsPublishGridView.setSelect(i2, false);
        } else if (this.mSelectedSet.size() < 9) {
            this.mSelectedSet.add(Integer.valueOf(i2));
            feedsPublishGridView.setSelect(i2, true);
        }
        setSelectCount(this.mViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onShow() {
        super.onShow();
        l.onEvent(Inspire.a(), "community_latestphoto_page");
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void updateData(ArrayList<PublishMediaItem> arrayList) {
        this.mSelectedSet.clear();
        super.updateData((FeedsPublishGuideCell) new ArrayList(arrayList));
        us.pinguo.widget.common.cell.recycler.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }
}
