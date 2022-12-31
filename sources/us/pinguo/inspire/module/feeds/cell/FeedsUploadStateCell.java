package us.pinguo.inspire.module.feeds.cell;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import us.pinguo.inspire.base.easyload.k;
import us.pinguo.inspire.module.publish.InspirePublishTask;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.inspire.module.publish.vo.PublishDataCache;
import us.pinguo.inspire.util.s;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsUploadStateCell extends us.pinguo.inspire.cell.recycler.e<PublishData, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener, us.pinguo.user.recycler.a {
    AtomicInteger count;
    private boolean mDividerVisiable;
    private long mTransferred;

    public FeedsUploadStateCell(PublishData publishData) {
        super(publishData);
        this.count = new AtomicInteger(0);
    }

    private void onClickCancel() {
        InspirePublishTask.removePublishData((PublishData) this.mData);
        this.mAdapter.remove((us.pinguo.widget.common.cell.recycler.a) this);
        this.mAdapter.notifyItemChanged(this.mAdapter.indexOf(this) - 1);
    }

    private void onClickRetry() {
        InspirePublishTask inspirePublishTask = new InspirePublishTask();
        k<PublishDataCache> publishDataDiskCache = InspirePublishTask.getPublishDataDiskCache();
        try {
            PublishDataCache object = publishDataDiskCache.getObject();
            if (object == null || us.pinguo.foundation.utils.k.a(object.publishDataList)) {
                return;
            }
            Iterator<PublishData> it = object.publishDataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PublishData next = it.next();
                if (next.clientId.equals(((PublishData) this.mData).clientId)) {
                    next.state = 1;
                    ((PublishData) this.mData).state = 1;
                    next.order = Calendar.getInstance().getTimeInMillis();
                    break;
                }
            }
            publishDataDiskCache.putObject(object);
            updateData((PublishData) this.mData);
            inspirePublishTask.pickAndPublish();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void refreshProgress() {
        VH vh = this.mViewHolder;
        if (vh != 0) {
            T t = this.mData;
            int i2 = (((PublishData) t).totalFileSize != 0 ? (int) ((this.mTransferred * 95) / ((PublishData) t).totalFileSize) : 0) + 5;
            int i3 = i2 >= 5 ? i2 : 5;
            if (i3 > 99) {
                i3 = 99;
            }
            ((ProgressBar) vh.getView(R.id.pb_upload_state_cell)).setProgress(i3);
            us.pinguo.common.log.a.k("progress : " + i3, new Object[0]);
        }
    }

    public void addTransferred(long j2) {
        this.mTransferred += j2;
        us.pinguo.common.log.a.k("mTransferred total : " + this.mTransferred, new Object[0]);
        us.pinguo.common.log.a.k("mTransferred current : " + j2, new Object[0]);
        us.pinguo.common.log.a.k("totalsize : " + ((PublishData) this.mData).totalFileSize, new Object[0]);
        us.pinguo.common.log.a.k("got count : " + this.count.incrementAndGet(), new Object[0]);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.feeds_upload_state_cell, viewGroup);
    }

    @Override // us.pinguo.user.recycler.a
    public boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        return false;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 14;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        if (!us.pinguo.foundation.utils.k.a(((PublishData) this.mData).filePathes)) {
            int a = us.pinguo.foundation.t.b.a.a(cVar.itemView.getContext(), 48.0f);
            String str = ((PublishData) this.mData).filePathes.get(0);
            if (((PublishData) this.mData).isPhoto) {
                us.pinguo.inspire.cell.recycler.f.e(cVar, R.id.piv_upload_state_cell, Uri.fromFile(new File(str)).toString(), a, a);
                if (((PublishData) this.mData).filePathes.size() == 1) {
                    cVar.hide(R.id.iv_media_type_upload_state_cell);
                } else {
                    cVar.show(R.id.iv_media_type_upload_state_cell);
                    cVar.setImageResource(R.id.iv_media_type_upload_state_cell, s.a(((PublishData) this.mData).filePathes.size()));
                }
            } else {
                us.pinguo.inspire.cell.recycler.f.f(cVar, R.id.piv_upload_state_cell, str);
                cVar.show(R.id.iv_media_type_upload_state_cell);
                cVar.setImageResource(R.id.iv_media_type_upload_state_cell, R.drawable.video_icon);
            }
            TextView textView = (TextView) this.mViewHolder.getView(R.id.tv_state_upload_state_cell);
            cVar.hide(R.id.iv_retry_upload_state_cell);
            cVar.hide(R.id.iv_cancel_upload_state_cell);
            if (((PublishData) this.mData).state == 0) {
                textView.setVisibility(8);
                cVar.show(R.id.pb_upload_state_cell);
            } else {
                textView.setVisibility(0);
                cVar.hide(R.id.pb_upload_state_cell);
                T t = this.mData;
                if (((PublishData) t).state == 3) {
                    textView.setText(textView.getContext().getString(R.string.preparing));
                } else if (((PublishData) t).state == 1) {
                    textView.setText(textView.getContext().getString(R.string.upload_waiting));
                } else if (((PublishData) t).state == 2) {
                    textView.setText(textView.getContext().getString(R.string.upload_failed));
                    cVar.show(R.id.iv_retry_upload_state_cell);
                    cVar.show(R.id.iv_cancel_upload_state_cell);
                }
            }
            refreshProgress();
        }
        if (this.mDividerVisiable) {
            cVar.show(R.id.v_divider_upload_state_cell);
        } else {
            cVar.hide(R.id.v_divider_upload_state_cell);
        }
        cVar.setOnClickListener(R.id.iv_retry_upload_state_cell, this);
        cVar.setOnClickListener(R.id.iv_cancel_upload_state_cell, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_retry_upload_state_cell) {
            onClickRetry();
        } else if (id == R.id.iv_cancel_upload_state_cell) {
            onClickCancel();
        }
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        boolean z = bVar instanceof FeedsUploadStateCell;
        if (z && (bVar2 instanceof FeedsUploadStateCell)) {
            rect.set(rect2.left, 0, rect2.right, 0);
            return true;
        } else if (z) {
            rect.set(rect2.left, 0, rect2.right, rect2.bottom);
            return true;
        } else if (bVar2 instanceof FeedsUploadStateCell) {
            rect.set(rect2.left, rect2.top, rect2.right, 0);
            return true;
        } else {
            return false;
        }
    }

    public void setDividerVisibility(boolean z) {
        this.mDividerVisiable = z;
    }
}
