package us.pinguo.inspire.cell.recycler;

import android.view.View;
import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.widget.common.cell.recycler.c;
/* compiled from: BaseStatCell.java */
/* loaded from: classes9.dex */
public abstract class a<T, VH extends us.pinguo.widget.common.cell.recycler.c> extends e<T, VH> {
    public static final String PAGE_TYPE_DETAIL = "feed_detail";
    public static final String PAGE_TYPE_FOLLOW = "index_follow";
    public static final String PAGE_TYPE_HOT = "index_hot";
    public static final String PAGE_TYPE_OTHER = "other";
    private String mPageType;
    private long mShowTime;
    private FeedStat mStat;

    public a(T t) {
        super(t);
        this.mShowTime = -1L;
    }

    protected abstract String getShowKey();

    public FeedStat getStat() {
        return this.mStat;
    }

    protected abstract String getTimeKey();

    public String getTimeValue(int i2) {
        String str;
        T t = this.mData;
        if (t instanceof InspireFeed) {
            str = ((InspireFeed) t).fid;
            if (str == null && ((InspireFeed) t).getFcnt() != null) {
                str = ((InspireFeed) this.mData).getFcnt().workId;
            }
        } else {
            str = t instanceof InspireTask ? ((InspireTask) t).taskId : null;
        }
        Object[] objArr = new Object[3];
        if (str == null) {
            str = "null";
        }
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i2);
        String str2 = this.mPageType;
        if (str2 == null) {
            str2 = PAGE_TYPE_OTHER;
        }
        objArr[2] = str2;
        return String.format("id=%s,time=%d,page_type=%s", objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onHide() {
        if (this.mShowTime < 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mShowTime;
        if (currentTimeMillis > 0) {
            us.pinguo.common.log.a.k(getClass().getSimpleName() + ",showDuration:" + currentTimeMillis, new Object[0]);
            l.onEvent(Inspire.a(), getTimeKey(), getTimeValue((int) currentTimeMillis));
        }
        this.mShowTime = -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onShow() {
        View view;
        VH vh = this.mViewHolder;
        if (vh != null && (view = vh.itemView) != null && view.getContext() != null && getShowKey() != null) {
            l.c(getShowKey(), this.mStat);
        }
        this.mShowTime = System.currentTimeMillis();
    }

    public void setPageType(String str) {
        this.mPageType = str;
    }

    public void setStat(FeedStat feedStat) {
        this.mStat = feedStat;
    }
}
